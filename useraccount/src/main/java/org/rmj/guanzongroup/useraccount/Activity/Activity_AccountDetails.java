package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.kofigyan.stateprogressbar.StateProgressBar;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.Adapter.Adapter_AccountDetails;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountDetails;

import java.util.Objects;
import org.rmj.guanzongroup.useraccount.R;


public class Activity_AccountDetails extends AppCompatActivity {
    private static final String TAG = Activity_AccountDetails.class.getSimpleName();
    private VMAccountDetails mViewModel;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;
    private Toolbar toolbar;

    String[] descriptionData = {"Registered", "Account Verified", "Fully Verified"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        mViewModel = new ViewModelProvider(Activity_AccountDetails.this)
                .get(VMAccountDetails.class);
        initViews();
        setUpToolbar();
        importAccountInfo();
        setAdapter();
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
        poDialogx = new Dialog_SingleButton(Activity_AccountDetails.this);

        StateProgressBar progressBar = findViewById(R.id.your_state_progress_bar_id);
        progressBar.setStateDescriptionData(descriptionData);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Account Details");
    }

    private void setAdapter() {
        try {
            mViewModel.getClientInfo().observe(this, eClientInfo -> {
                try {
                    mViewModel.getBirthplace(eClientInfo.getBirthPlc()).observe(this, bPlace -> {
                        try {
                            TextView lblUserID = findViewById(R.id.lbl_appID);
                            lblUserID.setText(eClientInfo.getUserIDxx());

                            TextView lblFullNm = findViewById(R.id.lbl_fullName);
                            String lsFullNme = eClientInfo.getLastName() + ", " + eClientInfo.getFrstName();
                            if(!eClientInfo.getMiddName().trim().isEmpty()){
                                lsFullNme = lsFullNme + ", " + eClientInfo.getMiddName();
                            }
                            if(!eClientInfo.getSuffixNm().trim().isEmpty()){
                                lsFullNme = lsFullNme + ", " + eClientInfo.getSuffixNm();
                            }
                            lblFullNm.setText(lsFullNme);

                            TextView lblGender = findViewById(R.id.lbl_gender);
                            String lsGenderx = mViewModel.getGenderList().get(Integer.parseInt(eClientInfo.getGenderCd()));
                            lblGender.setText(lsGenderx);

                            TextView lblCvilSt = findViewById(R.id.lbl_civilStatus);
                            String lsCivilSt = mViewModel.getCivilStatusList().get(Integer.parseInt(eClientInfo.getCvilStat()));
                            lblCvilSt.setText(lsCivilSt);

                            TextView lblBirthP = findViewById(R.id.lbl_birthPlace);
                            lblBirthP.setText(eClientInfo.getBirthPlc());

                            TextView lblBirthD = findViewById(R.id.lbl_birthDate);
                            String lsBirthDt = mViewModel.getDate(eClientInfo.getBirthDte());
                            lblBirthD.setText(lsBirthDt);

                            TextView lblEmailx = findViewById(R.id.lbl_email);
                            lblEmailx.setText(eClientInfo.getEmailAdd());
                            findViewById(R.id.lbl_editEmail).setOnClickListener(v -> {
                                Intent loIntent = new Intent(Activity_AccountDetails.this, Activity_AccountUpdate.class);
                                loIntent.putExtra("sUpdatexx", 0);
                                startActivity(loIntent);
                            });

                            TextView lblMobile = findViewById(R.id.lbl_mobile);
                            lblMobile.setText(eClientInfo.getMobileNo());
                            findViewById(R.id.lbl_editMobileNo).setOnClickListener(v -> {
                                Intent loIntent = new Intent(Activity_AccountDetails.this, Activity_AccountUpdate.class);
                                loIntent.putExtra("sUpdatexx", 1);
                                startActivity(loIntent);
                            });

                            findViewById(R.id.lbl_editPassword).setOnClickListener(v -> {
                                Intent loIntent = new Intent(Activity_AccountDetails.this, Activity_AccountUpdate.class);
                                loIntent.putExtra("sUpdatexx", 2);
                                startActivity(loIntent);
                            });

                            mViewModel.getFullAddress(eClientInfo.getBrgyIDx1()).observe(this, address -> {
                                try {
                                    String lsFulAdrs = eClientInfo.getHouseNo1() + ", "
                                            + eClientInfo.getAddress1() + ", " + address;
                                    mViewModel.setAccountDetailsList(eClientInfo, lsFulAdrs, bPlace);
                                } catch (NullPointerException e) {
                                    e.printStackTrace();
                                }
                            });
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    });
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void importAccountInfo() {
        try {
            mViewModel.importAccountInfo(new VMAccountDetails.OnTransactionCallBack() {
                @Override
                public void onLoading() {
                    poLoading = new Dialog_Loading(Activity_AccountDetails.this);
                    poLoading.initDialog("Account Details", "Importing Account Data. Please wait.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Account Details", fsMessage, () -> {
                        poDialogx.dismiss();
                        finish();
                    });
                    poDialogx.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}