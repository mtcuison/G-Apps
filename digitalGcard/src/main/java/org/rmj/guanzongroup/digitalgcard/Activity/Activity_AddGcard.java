package org.rmj.guanzongroup.digitalgcard.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.GcardCredentials;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class Activity_AddGcard extends AppCompatActivity {

    private VMGCardSystem mViewModel;
    private Toolbar toolbar;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialog;
    private TextInputEditText txtBdatex, txtGcardN;
    private MaterialButton btnAddCrd, btnScanGc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gcard);
        mViewModel = new ViewModelProvider(Activity_AddGcard.this).get(VMGCardSystem.class);
        mViewModel.setInstance(GCardSystem.CoreFunctions.GCARD);
        initViews();
        setUpToolbar();

        txtBdatex.setOnClickListener(v -> datePicker());
        btnAddCrd.setOnClickListener(v -> addGcard());
        btnScanGc.setOnClickListener(v -> scanGcard());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }


    // Initialize this first before anything else.
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        txtGcardN = findViewById(R.id.tie_gcard_number);
        txtBdatex = findViewById(R.id.tie_birth_date);
        btnAddCrd = findViewById(R.id.btnAddGcard);
        btnScanGc = findViewById(R.id.btnScanGcard);
        poDialog = new Dialog_SingleButton(Activity_AddGcard.this);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add GCard");
    }

    private void addGcard() {
        String lsGcardNo = Objects.requireNonNull(txtGcardN.getText().toString().trim());
        String lsBrtDate = Objects.requireNonNull(txtBdatex.getText().toString().trim());
        GcardCredentials loGcard = new GcardCredentials(lsGcardNo, lsBrtDate);
        if(loGcard.isDataValid()) {
            try {
                mViewModel.addGcard(loGcard, new VMGCardSystem.GcardTransactionCallback() {
                    @Override
                    public void onLoad() {
                        poLoading = new Dialog_Loading(Activity_AddGcard.this);
                        poLoading.initDialog("Adding GCard", "Please wait for a while.");
                        poLoading.show();
                    }

                    @Override
                    public void onSuccess(String fsMessage) {
                        poLoading.dismiss();
                        poDialog.setButtonText("Okay");
                        poDialog.initDialog("Add GCard", fsMessage, dialog -> {
                            dialog.dismiss();
                        });
                        poDialog.show();
                    }

                    @Override
                    public void onFailed(String fsMessage) {
                        poLoading.dismiss();
                        if(isJSONValid(fsMessage)) {
                            String lsErrCode = "";
                            try {
                                JSONObject loJson = new JSONObject(fsMessage);
                                lsErrCode = loJson.getString("code");
                                if("CNF".equalsIgnoreCase(lsErrCode)) {
                                    Dialog_DoubleButton loDialog = new Dialog_DoubleButton(Activity_AddGcard.this);
                                    loDialog.setButtonText("Confirm", "Cancel");
                                    loDialog.initDialog("GCard Confirmation", loJson.getString("message")
                                            , new Dialog_DoubleButton.OnDialogConfirmation() {
                                                @Override
                                                public void onConfirm(AlertDialog dialog) {
                                                    dialog.dismiss();
                                                }

                                                @Override
                                                public void onCancel(AlertDialog dialog) {
                                                    dialog.dismiss();
                                                }
                                            });
                                    loDialog.show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            poDialog.setButtonText("Okay");
                            poDialog.initDialog("Add GCard Failed",fsMessage, dialog -> {
                                dialog.dismiss();
                            });
                            poDialog.show();
                        }
                    }

                    @Override
                    public void onQrGenerate(Bitmap foBitmap) {

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Log.e("ADD GCARD ERROR", loGcard.getMessage());
        }
    }

    private void scanGcard() {
        Intent loIntent = new Intent(Activity_AddGcard.this, Activity_QrCodeScanner.class);
        startActivity(loIntent);
    }

    private void datePicker() {
        final Calendar newCalendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat")
        final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        final DatePickerDialog dateFrom = new DatePickerDialog(Activity_AddGcard.this, (view, year, month, dayOfMonth) -> {
            try {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, month, dayOfMonth);
                txtBdatex.setText(dateFormatter.format(newDate.getTime()));
            } catch (Exception e){
                e.printStackTrace();
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        dateFrom.show();
    }

    public boolean isJSONValid(String fsMessage) {
        try {
            new JSONObject(fsMessage);
        } catch (JSONException ex) {
            try {
                new JSONArray(fsMessage);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

}