package org.rmj.androidprojects.guanzongroup.g3logindriver.Login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.rmj.androidprojects.guanzongroup.g3logindriver.Activity_CreateAccount;
import org.rmj.androidprojects.guanzongroup.g3logindriver.Activity_RequestPassword;
import org.rmj.androidprojects.guanzongroup.g3logindriver.R;
import org.rmj.androidprojects.guanzongroup.g3logindriver.Services.LoginImportService;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GAppMessageBox;
import org.rmj.g3appdriver.etc.LoadDialog;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.etc.SharedPref;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.ServiceScheduler;

import static org.rmj.g3appdriver.utils.ServiceScheduler.TWO_HOUR_PERIODIC;

public class Activity_Login extends AppCompatActivity implements LoginCallback{
    private static final String TAG = Activity_Login.class.getSimpleName();
    @SuppressLint("StaticFieldLeak")
    private static Activity_Login instance;

    private VMLogin mViewModel;
    private static int RESOLVE_HINT = 9820;
    private LoadDialog dialog;
    private Toast toast;
    private Context mContext = Activity_Login.this;
    private ConnectionUtil connectionUtil;
    private SessionManager sessionManager;
    private SharedPref sharedPref;

    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private TextInputLayout tilMobileNo;

    private TextInputEditText tieEmail;
    private TextInputEditText tiePassword;
    private TextInputEditText tieMobileNo;
    private LinearLayout mobileNoInput;
    private Button btnLogin, btnFrgtPassword ,btnCrateAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dialog = new LoadDialog(Activity_Login.this);
        setupWidgets();
        mViewModel = ViewModelProviders.of(this).get(VMLogin.class);
        mViewModel.hasMobileNo().observe(Activity_Login.this, val ->{
           mobileNoInput.setVisibility(val);
        });
        mViewModel.getMobileNo().observe(Activity_Login.this, val->{
            if (val != null || !val.isEmpty()){
                tieMobileNo.setText(val);
            }
        });
        btnLogin.setOnClickListener(v->{
            String email = tieEmail.getText().toString();
            String password = tiePassword.getText().toString();
            String mobileNo = tieMobileNo.getText().toString();
            mViewModel.Login(new UserAuthInfo(email,password, mobileNo), Activity_Login.this);
        });
    }
    private void setupWidgets() {
        tilEmail = findViewById(R.id.til_loginEmail);
        tilPassword = findViewById(R.id.til_loginPassword);
        tilMobileNo = findViewById(R.id.til_loginMobileNo);

        tieEmail = findViewById(R.id.tie_loginEmail);
        tiePassword = findViewById(R.id.tie_loginPassword);
        tieMobileNo = findViewById(R.id.tie_loginMobileNo);

         btnLogin = findViewById(R.id.btn_login);
         btnFrgtPassword = findViewById(R.id.btn_forgotPassword);
         btnCrateAccount = findViewById(R.id.btn_createAccnt);
         mobileNoInput = findViewById(R.id.linear_loginMobileNo);
        ImageView loginBackground = findViewById(R.id.linear_loginBackground);

//        loginBackground.setImageResource(new LoginAssets().getLoginBackground(sharedPref.ProducID()));

        btnFrgtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Login.this, Activity_RequestPassword.class));
            }
        });

        btnCrateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Login.this, Activity_CreateAccount.class));
            }
        });
    }

    @Override
    public void OnAuthenticationLoad(String Title, String Message) {
        dialog.initDialog(Title, Message, false);
        dialog.show();
    }

    @Override
    public void OnSuccessLoginResult() {
        Log.e("User ID", new SessionManager(Activity_Login.this).getUserID());
        dialog.dismiss();
        ServiceScheduler.scheduleJob(Activity_Login.this, LoginImportService.class, TWO_HOUR_PERIODIC, AppConstants.DataServiceID);
        setResult(Activity.RESULT_OK);
        finish();
    }

    @Override
    public void OnFailedLoginResult(String message) {
        dialog.dismiss();
        GAppMessageBox loMessage = new GAppMessageBox(Activity_Login.this);
        loMessage.initDialog();
        loMessage.setTitle("Guanzon App");
        loMessage.setMessage(message);
        loMessage.setPositiveButton("Okay", (view, dialog) -> dialog.dismiss());
        loMessage.show();
    }
}
