package org.rmj.guanzongroup.digitalgcard.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.dev.Database.Entities.EPointsRequest;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.MessageBox;
import org.rmj.g3appdriver.etc.Telephony;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.lib.GCardCore.CodeGenerator;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardOffline;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

public class Activity_GCardOffline extends AppCompatActivity {
    private VMGCardOffline mviewmodel;
    private MaterialToolbar toolbar;
    private MaterialAutoCompleteTextView tie_gcard_number;
    private MaterialAutoCompleteTextView tie_branch;
    private MaterialAutoCompleteTextView tie_src;
    private TextInputEditText tie_date;
    private TextInputEditText tie_refno;
    private MaterialButton btn_Submit;
    private HashMap<String, String> loCardNmbrs = new HashMap<>();
    private HashMap<String, String> loBranch = new HashMap<>();
    private HashMap<String, String> loSource = new HashMap<>();
    private Dialog_Loading poDialog;
    private MessageBox poMessage;
    private String loMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_gcard_offline);

        mviewmodel = new ViewModelProvider(this).get(VMGCardOffline.class);
        poDialog = new Dialog_Loading(this);
        poMessage = new MessageBox(this);

        toolbar = findViewById(R.id.toolbar);
        tie_gcard_number = findViewById(R.id.tie_gcard_number);
        tie_branch = findViewById(R.id.tie_branch);
        tie_date = findViewById(R.id.tie_date);
        tie_src = findViewById(R.id.tie_src);
        tie_refno = findViewById(R.id.tie_refno);
        btn_Submit = findViewById(R.id.btn_Submit);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        setListeners();
    }

    private void setListeners() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        tie_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetSelectedDate();
            }
        });
        tie_gcard_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setGcardNmbrs();
            }
        });
        tie_branch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setBranch();
            }
        });
        tie_src.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSource();
            }
        });
        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                poMessage.initDialog();
                poMessage.setTitle("Points Request");
                poMessage.setPositiveButton("Dismiss", new MessageBox.DialogButton() {
                    @Override
                    public void OnButtonClick(View view, AlertDialog dialog) {
                        dialog.dismiss();
                    }
                });

                try {
                    if (ValidateEntry()) {
                        SimpleDateFormat sFormat = new SimpleDateFormat("MMMM dd, yyyy");
                        Date dTransact = sFormat.parse(tie_date.getText().toString());

                        SimpleDateFormat sFormat1 = new SimpleDateFormat("yyyy-MM-dd");

                        EPointsRequest loParams = new EPointsRequest();
                        loParams.setsTransNox(new CodeGenerator().generateTransNox());
                        loParams.setsGCardNox(loCardNmbrs.get(tie_gcard_number.getText().toString()));
                        loParams.setdTransact(sFormat1.format(dTransact));
                        loParams.setsBranchCd(loBranch.get(tie_branch.getText().toString()));
                        loParams.setsReferNox(tie_refno.getText().toString());
                        loParams.setsSourceCd(loSource.get(tie_src.getText().toString()));
                        loParams.setsOTPasswd("");
                        loParams.setnTranAmtx(0.00);
                        loParams.setnPointsxx(0.00);
                        loParams.setcTranStat("0");
                        loParams.setsUserIDxx(new AccountInfo(Activity_GCardOffline.this).getUserID());
                        loParams.setsIMEINoxx(new Telephony(Activity_GCardOffline.this).getDeviceID());
                        loParams.setdRequestd(GetCurrentDate());
                        loParams.setdTimeStmp(GetCurrentDate());
                        mviewmodel.SaveRequest(loParams, new VMGCardOffline.onRequest() {
                            @Override
                            public void onLoad(String title, String message) {
                                poDialog.initDialog(title, message);
                                poDialog.show();
                            }
                            @Override
                            public void onFinished(String result) {
                                poDialog.dismiss();

                                poMessage.setMessage(result);
                                poMessage.show();
                            }
                        });
                    } else {
                        poMessage.setMessage(loMessage);
                        poMessage.show();
                    }
                }catch (Exception e){
                    poMessage.setMessage(e.getMessage());
                    poMessage.show();
                }
            }
        });
    }

    private Boolean ValidateEntry() {
        String cardnumber = tie_gcard_number.getText().toString();
        String branch = tie_branch.getText().toString();
        String transdate = tie_date.getText().toString();
        String srctype = tie_src.getText().toString();
        String refno = tie_refno.getText().toString();

        if (cardnumber.isEmpty() || cardnumber == null) {
            loMessage = "Please select card number";
            return false;
        }

        if (branch.isEmpty() || branch == null) {
            loMessage = "Please select branch";
            return false;
        }

        if (transdate.isEmpty() || transdate == null) {
            loMessage = "Please select transaction date";
            return false;
        }

        if (srctype.isEmpty() || srctype == null) {
            loMessage = "Please select source";
            return false;
        }

        if (refno.isEmpty() || refno == null) {
            loMessage = "Please enter reference number";
            return false;
        }

        return true;
    }

    private void setGcardNmbrs() {
        mviewmodel.GetCardNumbers().observe(this, new Observer<List<EGcardApp>>() {
            @Override
            public void onChanged(List<EGcardApp> eGcardApps) {
                if (eGcardApps.size() > 0) {

                    List<String> Gcards = new ArrayList<>();
                    for (int i = 0; i < eGcardApps.size(); i++) {
                        EGcardApp gcardApp = eGcardApps.get(i);

                        String sActive = gcardApp.getActvStat();
                        if (sActive.equalsIgnoreCase("1")) {
                            Gcards.add(gcardApp.getCardNmbr());

                            loCardNmbrs.put(gcardApp.getCardNmbr(), gcardApp.getGCardNox());
                        }
                    }

                    tie_gcard_number.setAdapter(new ArrayAdapter<String>(Activity_GCardOffline.this,
                            R.layout.support_simple_spinner_dropdown_item, Gcards));

                    if (Gcards.size() == 1){
                        tie_gcard_number.setText(Gcards.get(0));
                        tie_gcard_number.setEnabled(false);
                    }else if (Gcards.size() > 1){
                        tie_gcard_number.setEnabled(true);
                    }
                }
            }
        });
    }
    private void setBranch() {
        mviewmodel.getMotorBranches().observe(this, new Observer<List<EBranchInfo>>() {
            @Override
            public void onChanged(List<EBranchInfo> eBranchInfos) {
                List<String> branches = new ArrayList<>();
                if (eBranchInfos.size() > 0) {
                    for (int i = 0; i < eBranchInfos.size(); i++) {
                        EBranchInfo foData = eBranchInfos.get(i);
                        branches.add(foData.getBranchNm());

                        loBranch.put(foData.getBranchNm(), foData.getBranchCd());
                    }
                }

                tie_branch.setAdapter(new ArrayAdapter<String>(Activity_GCardOffline.this,
                        R.layout.support_simple_spinner_dropdown_item, branches));
            }
        });
    }
    private void setSource() {
        //TODO: TEMPORARY HARD CODED
        loSource.put("MC Sales", "M02910000001");
        loSource.put("SP Sales", "M02910000002");
        loSource.put("Job Order", "M02910000003");
        loSource.put("Monthly Payment", "M02910000004");

        List<String> sources = new ArrayList<>();
        for (Map.Entry<String, String> entry : loSource.entrySet()) {
            sources.add(entry.getKey());
        }

        tie_src.setAdapter(new ArrayAdapter<>(Activity_GCardOffline.this,
                R.layout.support_simple_spinner_dropdown_item, sources));
    }

    private String GetCurrentDate() {
        Calendar cal = Calendar.getInstance(Locale.getDefault());
        Date date = cal.getTime();

        SimpleDateFormat sFormat = new SimpleDateFormat();
        return sFormat.format(date);
    }
    private void GetSelectedDate() {
        final Calendar newCalendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") final SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy");

        // Set the maximum date to one month from the current date
        newCalendar.add(Calendar.MONTH, 1);
        long maxDateInMillis = newCalendar.getTimeInMillis();

        final DatePickerDialog StartTime = new DatePickerDialog(Activity_GCardOffline.this,
                android.R.style.Theme_Holo_Dialog, (view131, year, monthOfYear, dayOfMonth) -> {
            try {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                String lsDate = dateFormatter.format(newDate.getTime());
                tie_date.setText(lsDate);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        // Set the default selection to the current date
        StartTime.getDatePicker().init(
                newCalendar.get(Calendar.YEAR),
                newCalendar.get(Calendar.MONTH),
                newCalendar.get(Calendar.DAY_OF_MONTH),
                null
        );

        StartTime.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        StartTime.getDatePicker().setMaxDate(maxDateInMillis); // Set the maximum date

        StartTime.show();
    }
}