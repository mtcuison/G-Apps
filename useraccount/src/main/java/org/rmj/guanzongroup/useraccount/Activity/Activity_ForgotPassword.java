package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;

import org.rmj.guanzongroup.useraccount.R;

import java.util.Objects;

public class Activity_ForgotPassword extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private TextView lblUser;
    private TextInputLayout tilEmail, tilMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        initViews();
        setUpToolbar();
        setTabLayout();
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
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Forgot Password");
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