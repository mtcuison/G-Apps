package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.etc.InputFieldController;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.Model.CompleteAccountDetailsInfo;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountDetails;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Activity_CompleteAccountDetails extends AppCompatActivity {

    private VMAccountDetails mViewModel;
    private CompleteAccountDetailsInfo poDataMdl;
    private Toolbar toolbar;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;
    private Dialog_DoubleButton poDblDiag;
    private TextInputEditText txtLastNm, txtFirstN, txtMidNme, txtSuffix, txtBdatex, txtTaxNox,
            txtHouseN, txtStreet;
    private AutoCompleteTextView txtBplace, txtGender, txtCivilS, txtCtizen, txtTownCt, txtBarngy;
    private MaterialButton btnSaveDt;

    private List<DAddress.oTownObj> poTownCty = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_account_details);
        initObjects();
        initViews();
        setUpToolbar();
        setInputOptions();
        btnSaveDt.setOnClickListener(v -> saveAccountDetails());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            popUpCloseConfirmationDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        popUpCloseConfirmationDialog();
    }

    private void initObjects() {
        mViewModel = new ViewModelProvider(Activity_CompleteAccountDetails.this)
                .get(VMAccountDetails.class);
        poDataMdl = new CompleteAccountDetailsInfo();
    }

    // Initialize this first before anything else.
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        poDialogx = new Dialog_SingleButton(Activity_CompleteAccountDetails.this);
        poDblDiag = new Dialog_DoubleButton(Activity_CompleteAccountDetails.this);
        txtLastNm = findViewById(R.id.tie_lastname);
        txtFirstN = findViewById(R.id.tie_firstname);
        txtMidNme = findViewById(R.id.tie_middname);
        txtSuffix = findViewById(R.id.tie_suffix);
        txtBdatex = findViewById(R.id.tie_bdate);
        txtBplace = findViewById(R.id.tie_bplace);
        txtGender = findViewById(R.id.tie_gender);
        txtCivilS = findViewById(R.id.tie_civil_stat);
        txtCtizen = findViewById(R.id.tie_citizen);
        txtTaxNox = findViewById(R.id.tie_taxId);
        txtHouseN = findViewById(R.id.tie_houseNo);
        txtStreet = findViewById(R.id.tie_street);
        txtTownCt = findViewById(R.id.tie_towncity);
        txtBarngy = findViewById(R.id.tie_barangay);
        btnSaveDt = findViewById(R.id.btnSave);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Complete Details");
    }

    private void saveAccountDetails() {
        setInfoModelValues();
        if(poDataMdl.isDataValid()) {
            mViewModel.completeClientInfo(poDataMdl.getClientEntityValues(), new VMAccountDetails.OnTransactionCallBack() {
                @Override
                public void onLoading() {
                    poLoading = new Dialog_Loading(Activity_CompleteAccountDetails.this);
                    poLoading.initDialog("Account Details", "Saving account information. Please wait.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Account Details", fsMessage, () -> {
                        poDialogx.dismiss();
                        Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
                        intent.putExtra("args", "auth");
                        sendBroadcast(intent);
                        poLoading.dismiss();
                        finish();
                    });
                    poDialogx.show();
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Account Details", fsMessage, () -> poDialogx.dismiss());
                    poDialogx.show();
                }
            });
        } else {
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Account Details", poDataMdl.getMessage(), () -> poDialogx.dismiss());
            poDialogx.show();
        }

    }

    private void setInfoModelValues() {
        poDataMdl.setLastName(Objects.requireNonNull(Objects.requireNonNull(txtLastNm.getText()).toString().trim()));
        poDataMdl.setFirstName(Objects.requireNonNull(Objects.requireNonNull(txtFirstN.getText()).toString().trim()));
        poDataMdl.setMiddName(Objects.requireNonNull(Objects.requireNonNull(txtMidNme.getText()).toString().trim()));
        poDataMdl.setSuffixName(Objects.requireNonNull(Objects.requireNonNull(txtSuffix.getText()).toString().trim()));
        poDataMdl.setBirthDate(Objects.requireNonNull(Objects.requireNonNull(txtBdatex.getText()).toString().trim()));
        poDataMdl.setTaxIdNumber(Objects.requireNonNull(Objects.requireNonNull(txtTaxNox.getText()).toString().trim()));
        poDataMdl.setHouseNumber(Objects.requireNonNull(Objects.requireNonNull(txtHouseN.getText()).toString().trim()));
        poDataMdl.setAddress(Objects.requireNonNull(Objects.requireNonNull(txtStreet.getText()).toString().trim()));
    }

    private void setInputOptions() {
        /** Date Auto Formatter */
        txtBdatex.setOnClickListener(v ->  {
            final Calendar newCalendar = Calendar.getInstance();
            @SuppressLint("SimpleDateFormat") final SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
            final DatePickerDialog StartTime = new DatePickerDialog(this, (view131, year, monthOfYear, dayOfMonth) -> {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                String lsDate = dateFormatter.format(newDate.getTime());
                txtBdatex.setText(lsDate);
            }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
            StartTime.getDatePicker().setMaxDate(new Date().getTime());
            StartTime.show();
        });

        /** AutoCompleteTextviews */

        // Setup auto complete town/city fields.
        mViewModel.getTownCityList().observe(Activity_CompleteAccountDetails.this, townObj ->{
            try {
                ArrayList<String> lsTownCts = mViewModel.getTownCityForInput(townObj);
                txtBplace.setAdapter(
                        InputFieldController.getAutoCompleteData(
                                Activity_CompleteAccountDetails.this, lsTownCts
                        )
                );
                txtTownCt.setAdapter(
                        InputFieldController.getAutoCompleteData(
                                Activity_CompleteAccountDetails.this, lsTownCts
                        )
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        mViewModel.getCountryList().observe(Activity_CompleteAccountDetails.this, countries -> {
            try {
                ArrayList<String> lsCountry = mViewModel.getCountryForInput(countries);
                txtCtizen.setAdapter(
                        InputFieldController.getAutoCompleteData(
                                Activity_CompleteAccountDetails.this,
                                lsCountry
                        )
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        /** Dropdowns */

        // Setup gender field.
        txtGender.setAdapter(
                InputFieldController.getAutoCompleteData(
                        Activity_CompleteAccountDetails.this,
                        mViewModel.getGenderList()
                )
        );

        // Setup Civil status field.
        txtCivilS.setAdapter(
                InputFieldController.getAutoCompleteData(
                    Activity_CompleteAccountDetails.this,
                    mViewModel.getCivilStatusList()
                )
        );


        /** Set OnItemClickListeners on Auto Complete Input Fields */
        txtBplace.setOnItemClickListener((adapterView, view, i, l) -> {
            mViewModel.getTownCityList().observe(this, townCties -> {
                try {
                    for(int x = 0; x < townCties.size(); x++) {
                        String lsTownCty = "";
                        lsTownCty = townCties.get(x).sTownNm + ", " + townCties.get(x).sProvNm;
                        if(lsTownCty.equalsIgnoreCase(txtBplace.getText().toString().trim())) {
                            poDataMdl.setBirthPlace(townCties.get(x).sTownID);
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        txtTownCt.setOnItemClickListener((adapterView, view, i, l) -> {
            mViewModel.getTownCityList().observe(this, townObjs -> {
                try {
                    for (int x = 0; x < townObjs.size(); x++) {
                        String lsTownCt = townObjs.get(x).sTownNm + ", " + townObjs.get(x).sProvNm;
                        if (txtTownCt.getText().toString().equalsIgnoreCase(lsTownCt)) {
                            poDataMdl.setTownCity(townObjs.get(x).sTownID);
                            mViewModel.getBarangayList(townObjs.get(x).sTownID).observe(this, brgys -> {
                                txtBarngy.setAdapter(
                                        InputFieldController.getAutoCompleteData(
                                                Activity_CompleteAccountDetails.this,
                                                mViewModel.getBarangayForInput(brgys)
                                        )
                                );

                                txtBarngy.setOnItemClickListener((adapterView1, view1, i1, l1) -> {
                                    for(int x1 = 0; x1 < brgys.size(); x1++){
                                        if(brgys.get(x1).getBrgyName().equalsIgnoreCase(txtBarngy.getText().toString().trim())){
                                            poDataMdl.setBarangay(brgys.get(x1).getBrgyIDxx());
                                            break;
                                        }
                                    }
                                });
                            });
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        txtCtizen.setOnItemClickListener((adapterView, view, i, l) -> {
            mViewModel.getCountryList().observe(this, countries -> {
                try {
                    for(int x = 0; x < countries.size(); x++) {
                        if(countries.get(x).getNational() != null && !countries.get(x).getNational().isEmpty()) {
                            if(countries.get(x).getNational().equalsIgnoreCase(txtCtizen.getText().toString().trim())) {
                                poDataMdl.setCitizenship(countries.get(x).getCntryCde());
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        txtGender.setOnItemClickListener((adapterView, view, i, l) -> poDataMdl.setGender(String.valueOf(i)));
        txtCivilS.setOnItemClickListener((adapterView, view, i, l) -> poDataMdl.setCivilStat(String.valueOf(i)));
    }

    private void popUpCloseConfirmationDialog() {
        poDblDiag.setButtonText("Yes", "No");
        poDblDiag.initDialog("Complete Account Details", "Are you sure you want to cancel filling in account details?", new Dialog_DoubleButton.OnDialogConfirmation() {
            @Override
            public void onConfirm(AlertDialog dialog) {
                dialog.dismiss();
                Intent loIntent = new Intent();
                loIntent.putExtra("result", "cancelled");
                finish();
            }

            @Override
            public void onCancel(AlertDialog dialog) {
                dialog.dismiss();
            }
        });
        poDblDiag.show();
    }


}

