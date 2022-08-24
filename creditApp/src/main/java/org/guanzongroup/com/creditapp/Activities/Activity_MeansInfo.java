package org.guanzongroup.com.creditapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Activity_MeansInfo extends AppCompatActivity {

    private RadioGroup rg_EmployeeStatus;
    private RadioButton rb_Employed, rb_SelfEmployed, rb_OFW;
    private TextInputEditText txt_Industry, txt_JobTitle, txt_EstimatedIncome;
    private MaterialButton btnNext;
    private TextView lblInd;
    private Toolbar toolbar;
    String TypeOfEmployee = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_means_info);

        initViews();
        setUpToolbar();
        rg_EmployeeStats();
        goToNextPage();


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){

            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        finish();
    }

    private void goToNextPage() {

        btnNext.setOnClickListener(v -> {

            if (validateData()) {
                Toast.makeText(Activity_MeansInfo.this, "Proceeding to the next page", Toast.LENGTH_SHORT).show();

                try {
                    Intent receiveIntent = getIntent();
                    String param = receiveIntent.getStringExtra("params");
                    JSONObject params = new JSONObject(param);
                    params.put("sTypeOfEmployment", (TypeOfEmployee));
                    params.put("sIndustry", (Objects.requireNonNull(txt_Industry.getText()).toString()));
                    params.put("sJobTitle", (Objects.requireNonNull(txt_JobTitle.getText()).toString()));
                    params.put("sEstimatedIncome", (Objects.requireNonNull(txt_EstimatedIncome.getText()).toString()));

                    Intent loIntent = new Intent(Activity_MeansInfo.this, Activity_OtherInfo.class);

                    loIntent.putExtra("params", params.toString());
                    startActivity(loIntent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

    }

    private boolean validateData() {

        if (rg_EmployeeStatus.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Employee Status", Toast.LENGTH_SHORT).show();
            return false;
        } else if (rb_Employed.isChecked() || rb_SelfEmployed.isChecked()) {
            if (Objects.requireNonNull(txt_Industry.getText()).toString().equals("")) {
                Toast.makeText(this, "Please Enter Industry", Toast.LENGTH_SHORT).show();
                return false;
            } else if (Objects.requireNonNull(txt_JobTitle.getText()).toString().equals("")) {
                Toast.makeText(this, "Please Enter Job Title", Toast.LENGTH_SHORT).show();
                return false;
            } else if (Objects.requireNonNull(txt_EstimatedIncome.getText()).toString().equals("")) {
                Toast.makeText(this, "Please Enter Estimated Income", Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        } else if (Objects.requireNonNull(txt_JobTitle.getText()).toString().equals("")) {
            Toast.makeText(this, "Please Enter Job Title", Toast.LENGTH_SHORT).show();
            return false;
        } else if (Objects.requireNonNull(txt_EstimatedIncome.getText()).toString().equals("")) {
            Toast.makeText(this, "Please Enter Estimated Income", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void rg_EmployeeStats() {

        rg_EmployeeStatus.setOnCheckedChangeListener((group, checkedId) -> {
            if (rb_OFW.isChecked()) {
                txt_Industry.setVisibility(TextInputEditText.GONE);
                lblInd.setVisibility(TextView.GONE);
//                    txt_Industry.setFocusable(false);
//                    txt_Industry.setFocusableInTouchMode(false);
                TypeOfEmployee = "OFW";
            } else if (rb_Employed.isChecked()) {
                txt_Industry.setVisibility(TextInputEditText.VISIBLE);
                lblInd.setVisibility(TextView.VISIBLE);
//                    txt_Industry.setFocusable(true);
//                    txt_Industry.setFocusableInTouchMode(true);
                TypeOfEmployee = "Employed";
            } else if (rb_SelfEmployed.isChecked()) {
                txt_Industry.setVisibility(TextInputEditText.VISIBLE);
                lblInd.setVisibility(TextView.VISIBLE);
//                    txt_Industry.setFocusable(true);
//                    txt_Industry.setFocusableInTouchMode(true);
                TypeOfEmployee = "Self Employed";
            } else {
                Toast.makeText(Activity_MeansInfo.this, "Invalid Input",
                        Toast.LENGTH_SHORT).show();
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

        lblInd = findViewById(R.id.lblInd);
        toolbar = findViewById(R.id.toolbar);

        btnNext = findViewById(R.id.btnNext);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Loan Application info");
    }
}