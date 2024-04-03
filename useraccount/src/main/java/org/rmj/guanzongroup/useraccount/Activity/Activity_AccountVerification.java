package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountAuthentication;

import java.util.Objects;

public class Activity_AccountVerification extends AppCompatActivity {
    private static final String TAG = Activity_AccountVerification.class.getSimpleName();

    private VMAccountAuthentication mViewModel;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;

    private String lsOtpxxx = "", lsVerify = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_AccountVerification.this).get(VMAccountAuthentication.class);
        setContentView(R.layout.activity_account_verification);
        if(getIntent().hasExtra("otp")){
            lsOtpxxx = getIntent().getStringExtra("otp");
            lsVerify = getIntent().getStringExtra("verify");
        }
        poLoading = new Dialog_Loading(Activity_AccountVerification.this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Activate Account");
        MaterialButton btnResend = findViewById(R.id.btn_resend);
        TextInputEditText txtOtp = findViewById(R.id.tie_otp);
        MaterialButton btnSubmit = findViewById(R.id.btn_Submit);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        /*btnResend.setOnClickListener(v -> mViewModel.StartTimer(new VMAccountAuthentication.TimerListener() {
            @Override
            public void OnStart() {
                btnResend.setEnabled(false);
            }

            @Override
            public void OnTimerCountdown(int progress) {
                if(progress > 0) {
                    btnResend.setText("Please wait...(" + progress + ")");
                } else {
                    btnResend.setText("Resend OTP?");
                }
            }

            @Override
            public void OnFinish() {
                btnResend.setEnabled(true);
            }
        }));*/

        btnSubmit.setOnClickListener(v -> {
            String lsEntry = Objects.requireNonNull(txtOtp.getText()).toString();
            mViewModel.ActivateAccount(lsEntry,lsOtpxxx, lsVerify, new VMAccountAuthentication.AuthTransactionCallback() {
                @Override
                public void onLoad() {
                    poLoading.initDialog("Activating Account", "Please wait...");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();

                    poDialogx = new Dialog_SingleButton(Activity_AccountVerification.this);
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Activate Account", fsMessage, () -> {
                        poDialogx.dismiss();
                        Intent loIntent = new Intent();
                        loIntent.putExtra("result", "success");
                        setResult(111, loIntent);
                        finish();
                    });
                    poDialogx.show();
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx = new Dialog_SingleButton(Activity_AccountVerification.this);
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Activate Account", fsMessage, () -> poDialogx.dismiss());
                    poDialogx.show();
                }
            });
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}