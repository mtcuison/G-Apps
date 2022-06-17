package org.rmj.guanzongroup.useraccount.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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
import org.rmj.guanzongroup.useraccount.Model.LoginInfoModel;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountAuthentication;

import java.util.Objects;

public class Activity_Login extends AppCompatActivity {

    private VMAccountAuthentication mViewModel;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TextView lblUser, lblForgot, lblCreate;
    private TextInputLayout tilEmail, tilMobile;
    private TextInputEditText tieEmail, tieMobile, tiePassword;
    private MaterialButton btnLogin;

    private static final int VERIFY = 111;

    private final ActivityResultLauncher<Intent> poArl = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == VERIFY) {
                    Intent loIntent = result.getData();
                    if (loIntent != null) {
//                        Toast.makeText(Activity_Login.this, loIntent.getStringExtra("result"), Toast.LENGTH_LONG).show();
                        if(loIntent.getStringExtra("result").equalsIgnoreCase("success")){
                            acccountLogin();
                        }
                    } else {
                        Toast.makeText(Activity_Login.this, "No data result receive.", Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mViewModel = new ViewModelProvider(Activity_Login.this).get(VMAccountAuthentication.class);
        initViews();
        setUpToolbar();
        setTabLayout();
        setClickLinkListeners();

        btnLogin.setOnClickListener(v -> acccountLogin());
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
        poDialogx = new Dialog_SingleButton(Activity_Login.this);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Email"));
        tabLayout.addTab(tabLayout.newTab().setText("Mobile"));

        tilEmail = findViewById(R.id.til_email);
        tilMobile = findViewById(R.id.til_mobile);
        lblUser = findViewById(R.id.lblUser);
        lblForgot = findViewById(R.id.lblForgotPassword);
        lblCreate = findViewById(R.id.lblSignUp);

        tieEmail = findViewById(R.id.tie_email);
        tieMobile = findViewById(R.id.tie_mobile);
        tiePassword = findViewById(R.id.tie_password);
        btnLogin = findViewById(R.id.btnLogin);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Log In");
    }

    private void setClickLinkListeners() {
        lblForgot.setOnClickListener(v -> {
            Intent loIntent = new Intent(Activity_Login.this, Activity_ForgotPassword.class);
            startActivity(loIntent);
        });

        lblCreate.setOnClickListener(v -> {
            Intent loIntent = new Intent(Activity_Login.this, Activity_SignUp.class);
            startActivity(loIntent);
        });
    }

    private void acccountLogin() {
        String lsEmailxx = Objects.requireNonNull(tieEmail.getText().toString().trim());
        String lsMobilex = "09171870011";
        String lsPasswrd = Objects.requireNonNull(tiePassword.getText().toString().trim());
        LoginInfoModel infoModel = new LoginInfoModel(LogType.EMAIL, lsEmailxx, lsPasswrd);
        if(infoModel.isDataNotEmpty()) {
            AccountAuthentication.LoginCredentials loCrednts = new AccountAuthentication.LoginCredentials(
                    infoModel.getLogUser(),
                    infoModel.getPassword(),
                    lsMobilex);
            try {
                mViewModel.LoginAccount(loCrednts, new VMAccountAuthentication.AuthenticationCallback() {
                    @Override
                    public void onLoad() {
                        poLoading = new Dialog_Loading(Activity_Login.this);
                        poLoading.initDialog("Logging In", "Please wait for a while.");
                        poLoading.show();
                    }

                    @Override
                    public void onSuccess(String fsMessage) {
                        Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
                        sendBroadcast(intent);
                        poLoading.dismiss();
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Log In", fsMessage, dialog -> {
                            dialog.dismiss();
                            finish();
                        });
                        poDialogx.show();
                    }

                    @Override
                    public void onFailed(String fsMessage) {
                        poLoading.dismiss();
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Log in Failed", fsMessage, dialog -> dialog.dismiss());
                        poDialogx.show();
                    }

                    @Override
                    public void onVerifiy(String args1, String args2) {
                        poLoading.dismiss();
                        Log.d("Activation OTP", args1);
                        Intent loIntent = new Intent(Activity_Login.this, Activity_AccountVerification.class);
                        loIntent.putExtra("otp", args1);
                        loIntent.putExtra("verify", args2);
                        loIntent.putExtra("email", lsEmailxx);
                        loIntent.putExtra("passw", lsPasswrd);
                        poArl.launch(loIntent);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Log in Failed", infoModel.getMessage(), dialog -> dialog.dismiss());
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