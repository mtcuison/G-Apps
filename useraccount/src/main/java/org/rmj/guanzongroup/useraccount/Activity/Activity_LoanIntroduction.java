package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import org.rmj.guanzongroup.useraccount.R;

import java.util.Objects;

public class Activity_LoanIntroduction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_introduction);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Apply For A Loan");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        CheckBox cbTNC = findViewById(R.id.cb_termsAndConditions);

        findViewById(R.id.btn_continue).setOnClickListener(v -> {
            if(!cbTNC.isChecked()) {
                Toast.makeText(Activity_LoanIntroduction.this, "Terms and Conditions agreement required to proceed", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(Activity_LoanIntroduction.this, Activity_IDVerification.class));
                finish();
            }
        });

        findViewById(R.id.lbl_termsAndConditions).setOnClickListener(view -> startActivity(new Intent(Activity_LoanIntroduction.this, Activity_LoanTermsAndConditions.class)));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}