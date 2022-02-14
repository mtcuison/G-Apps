package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.rmj.guanzongroup.appcore.Account.AccountAuthentication;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountAuthentication;

import java.util.Objects;

public class Activity_Login extends AppCompatActivity {

    private VMAccountAuthentication mViewModel;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TextView lblUser, lblForgot, lblCreate;
    private TextInputLayout tilEmail, tilMobile;
    private TextInputEditText tieEmail, tieMobile, tiePassword;
    private MaterialButton btnLogin;

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
        String lsMobilex = Objects.requireNonNull(tieMobile.getText().toString().trim());
        String lsPasswrd = Objects.requireNonNull(tiePassword.getText().toString().trim());
        AccountAuthentication.LoginCredentials loCrednts =
                new AccountAuthentication.LoginCredentials(lsEmailxx, lsPasswrd, lsMobilex);
        try {
            mViewModel.LoginAccount(loCrednts, new AccountAuthentication.OnLoginCallback() {
                @Override
                public void OnSuccessLogin(String message) {
                    Toast.makeText(Activity_Login.this, message, Toast.LENGTH_LONG).show();
                }

                @Override
                public void OnFailedLogin(String message) {
                    Toast.makeText(Activity_Login.this, message, Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
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