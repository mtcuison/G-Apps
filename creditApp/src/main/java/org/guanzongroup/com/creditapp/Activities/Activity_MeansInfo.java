package org.guanzongroup.com.creditapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONObject;

public class Activity_MeansInfo extends AppCompatActivity {

    private RadioGroup rg_EmployeeStatus;
    private RadioButton rb_Employed, rb_SelfEmployed, rb_OFW;

    private TextInputEditText txt_Industry, txt_JobTitle, txt_EstimatedIncome;

    private MaterialButton btnNext;
    String TypeOfEmployee = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_means_info);

        initViews();
        rg_EmployeeStats();
        goToNextpage();

    }

    private void goToNextpage() {

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent receiveIntent = getIntent();
                    String param = receiveIntent.getStringExtra("params");
                    JSONObject params = new JSONObject(param);
                    params.put("sTypeOfEmployment", (TypeOfEmployee));
                    params.put("sIndustry", (txt_Industry.getText().toString()));
                    params.put("sJobTitle", (txt_JobTitle.getText().toString()));
                    params.put("sEstimatedIncome", (txt_EstimatedIncome.getText().toString()));

                    Intent loIntent = new Intent(Activity_MeansInfo.this, Activity_OtherInfo.class);

                    loIntent.putExtra("params", params.toString());
                    startActivity(loIntent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void rg_EmployeeStats() {

        rg_EmployeeStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (rb_OFW.isChecked()) {
                    txt_Industry.setFocusable(false);
                    txt_Industry.setText("");
                    txt_Industry.setFocusableInTouchMode(false);
                    TypeOfEmployee = "OFW";
                } else if (rb_Employed.isChecked()) {
                    txt_Industry.setFocusable(true);
                    txt_Industry.setFocusableInTouchMode(true);
                    TypeOfEmployee = "Employed";
                }else if (rb_SelfEmployed.isChecked()){
                    txt_Industry.setFocusable(true);
                    txt_Industry.setFocusableInTouchMode(true);
                    TypeOfEmployee = "Self Employed";
                }else {
                    Toast.makeText(Activity_MeansInfo.this, "HHahahah", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void initViews() {

        rg_EmployeeStatus = findViewById(R.id.rg_EmployeeStatus);
        rb_Employed = findViewById(R.id.rb_Employed);
        rb_SelfEmployed = findViewById(R.id.rb_SelfEmployed);
        rb_OFW = findViewById(R.id.rb_OFW);
        txt_Industry = findViewById(R.id.tie_Industry);
        txt_JobTitle = findViewById(R.id.tie_JobTitle);
        txt_EstimatedIncome = findViewById(R.id.tie_EstimatedIncome);

        btnNext = findViewById(R.id.btnNext);
    }
}