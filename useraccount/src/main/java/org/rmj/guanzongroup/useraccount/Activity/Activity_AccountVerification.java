package org.rmj.guanzongroup.useraccount.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountAuthentication;

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
        TextView lblResend = findViewById(R.id.lbl_resend);
        TextInputEditText txtOtp = findViewById(R.id.tie_otp);
        MaterialButton btnSubmit = findViewById(R.id.btn_Submit);

        btnSubmit.setOnClickListener(v -> {
            String lsEntry = txtOtp.getText().toString();
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
                    poDialogx.initDialog("Activate Account", fsMessage, dialog -> {
                        dialog.dismiss();
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
                    poDialogx.initDialog("Retrieving Password Failed", fsMessage, dialog -> {
                        dialog.dismiss();
                    });
                    poDialogx.show();
                }
            });
        });
    }
}