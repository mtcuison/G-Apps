package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.rmj.g3appdriver.lib.Account.AccountAuthentication;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.Etc.LogType;
import org.rmj.guanzongroup.useraccount.Model.ForgotPasswordInfoModel;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountAuthentication;

import java.util.Objects;

public class Activity_ForgotPassword extends AppCompatActivity {

    private VMAccountAuthentication mViewModel;
    private Toolbar toolbar;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;
    private TabLayout tabLayout;
    private TextView lblUser;
    private TextInputLayout tilEmail, tilMobile;
    private TextInputEditText tieEmail, tieMobile;
    private MaterialButton btnResend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mViewModel = new ViewModelProvider(Activity_ForgotPassword.this)
                .get(VMAccountAuthentication.class);

        initViews();
        setUpToolbar();
        setTabLayout();

        btnResend.setOnClickListener(v -> retrievePassword());
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
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Email"));
        tabLayout.addTab(tabLayout.newTab().setText("Mobile"));

        lblUser = findViewById(R.id.lblUser);
        tilEmail = findViewById(R.id.til_email);
        tilMobile = findViewById(R.id.til_mobile);

        tieEmail = findViewById(R.id.tie_email);
        tieMobile = findViewById(R.id.tie_mobile);
        btnResend = findViewById(R.id.btnResend);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Forgot Password");
    }

    private void retrievePassword() {
        String lsEmailxx = Objects.requireNonNull(tieEmail.getText().toString().trim());
        String lsMobilex = Objects.requireNonNull(tieMobile.getText().toString().trim());
        ForgotPasswordInfoModel infoModel = new ForgotPasswordInfoModel(LogType.EMAIL, lsEmailxx);
        if(infoModel.isDataNotEmpty()) {
            try {
                mViewModel.RetrievePassword(infoModel.getLogUser(), new VMAccountAuthentication.AuthTransactionCallback() {
                    @Override
                    public void onLoad() {
                        poLoading = new Dialog_Loading(Activity_ForgotPassword.this);
                        poLoading.initDialog("Resending Password", "Please wait while re-sending your password to your email.");
                        poLoading.show();
                    }

                    @Override
                    public void onSuccess(String fsMessage) {
                        poLoading.dismiss();
                        poDialogx = new Dialog_SingleButton(Activity_ForgotPassword.this);
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Forgot Password", fsMessage, dialog -> {
                            dialog.dismiss();
                            finish();
                        });
                        poDialogx.show();
                    }

                    @Override
                    public void onFailed(String fsMessage) {
                        poLoading.dismiss();
                        poDialogx = new Dialog_SingleButton(Activity_ForgotPassword.this);
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Retrieving Password Failed", fsMessage, dialog -> {
                            dialog.dismiss();
                        });
                        poDialogx.show();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            poDialogx = new Dialog_SingleButton(Activity_ForgotPassword.this);
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Retrieving Password Failed", infoModel.getMessage(), dialog -> {
                dialog.dismiss();
            });
            poDialogx.show();
        }
    }

    private void setTabLayout(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()) {
                    case 1:
                        tilEmail.setVisibility(View.INVISIBLE);
                        tilMobile.setVisibility(View.VISIBLE);
                        lblUser.setText(R.string.lblMobileNumber);
                        break;
                    default:
                        tilEmail.setVisibility(View.VISIBLE);
                        tilMobile.setVisibility(View.INVISIBLE);
                        lblUser.setText(R.string.lblEmailAddress);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}