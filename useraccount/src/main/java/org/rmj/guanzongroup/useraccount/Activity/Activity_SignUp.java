package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.lib.Account.AccountAuthentication;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountAuthentication;

import java.util.Objects;

public class Activity_SignUp extends AppCompatActivity {

    private VMAccountAuthentication mViewModel;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;
    private Toolbar toolbar;
    private TextInputEditText txtUserNm, txtEmailx, txtMobile, txtPasswd, txtRetype;
    private MaterialButton btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mViewModel = new ViewModelProvider(Activity_SignUp.this).get(VMAccountAuthentication.class);
        initViews();
        setUpToolbar();
        btnSignUp.setOnClickListener(view -> signUp());
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
        poDialogx = new Dialog_SingleButton(Activity_SignUp.this);
        toolbar = findViewById(R.id.toolbar);
        txtUserNm = findViewById(R.id.tie_username);
        txtEmailx = findViewById(R.id.tie_email);
        txtMobile = findViewById(R.id.tie_mobile);
        txtPasswd = findViewById(R.id.tie_password);
        txtRetype = findViewById(R.id.tie_retype);
        btnSignUp = findViewById(R.id.btnSignUp);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Sign Up");
    }

    private void signUp() {
        AccountAuthentication.AccountCredentials loCrednts = new AccountAuthentication.AccountCredentials();
        loCrednts.setUserName(Objects.requireNonNull(txtUserNm.getText().toString().trim()));
        loCrednts.setEmailAdd(Objects.requireNonNull(txtEmailx.getText().toString().trim()));
        loCrednts.setMobileNo(Objects.requireNonNull(txtMobile.getText().toString().trim()));
        loCrednts.setPassword(Objects.requireNonNull(txtPasswd.getText().toString().trim()));
        loCrednts.setPasswrd2(Objects.requireNonNull(txtRetype.getText().toString().trim()));
        try {
            mViewModel.RegisterAccount(loCrednts, new VMAccountAuthentication.AuthTransactionCallback() {
                @Override
                public void onLoad() {
                    poLoading = new Dialog_Loading(Activity_SignUp.this);
                    poLoading.initDialog("Signing Up", "Please wait for a while.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Sign Up", fsMessage, dialog -> {
                        dialog.dismiss();
                        finish();
                    });
                    poDialogx.show();
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Sign Up Failed", fsMessage, dialog -> dialog.dismiss());
                    poDialogx.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}