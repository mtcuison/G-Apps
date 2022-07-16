package org.rmj.guanzongroup.useraccount.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.guanzongroup.useraccount.R;

public class Activity_AccountUpdate extends AppCompatActivity {

    private Toolbar toolbar;

    private TextView lblUpdate;
    private TextInputEditText tieUpdate;
    private MaterialButton btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_update);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lblUpdate = findViewById(R.id.lblAccountUpdate);
        tieUpdate = findViewById(R.id.tie_accountUpdate);
        btnSubmit = findViewById(R.id.btnUpdate);

        boolean cIsMobile;
        if(getIntent().hasExtra("sUpdatexx")){
            cIsMobile = getIntent().getStringExtra("sUpdatexx").equalsIgnoreCase("sMobileNo");
            if(cIsMobile){

            } else {

            }
        }
    }
}