package org.guanzongroup.com.creditapp.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Activity_LoanPreview extends AppCompatActivity {

    private TextView lbl_DownPayment, lbl_LoanTermSelection, lbl_MonthlyPayment, lbl_PriceOfUnit,
            lbl_Discount, lbl_TypeOfEmployment, lbl_Industry, lbl_JobTitle, lbl_EstimatedIncome1,
            lbl_OtherIncome, lbl_EstimatedIncome2, lbl_BankName, lbl_TypeOfAccount;
    private MaterialButton btnApplyLoan;
    private TextView txt_industry;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_preview);

        initViews();
        setUpToolbar();
        receiveIntent();

        btnApplyLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void receiveIntent() {
        try {
            Intent receiveIntent = getIntent();
            String param = receiveIntent.getStringExtra("params");

            JSONObject obj = new JSONObject(param);

            String DownPayment = obj.getString("sDownPayment");
            String LoanTermSelection = obj.getString("sLTSelection");
            String MonthlyPayment = obj.getString("sPriceOfUnit");
            String PriceOfUnit = obj.getString("sMonthlyPayment");
            String Discount = obj.getString("sDiscount");

            String TypeOfEmployment = obj.getString("sTypeOfEmployment");
            String Industry = obj.getString("sIndustry");
            String JobTitle = obj.getString("sJobTitle");
            String EstimatedIncome = obj.getString("sEstimatedIncome");

            String OtherIncome = obj.getString("sOtherIncome");
            String EstimatedIncome2 = obj.getString("sEstimatedIncome2");
            String BankName = obj.getString("sBankName");
            String TypeOfAccount = obj.getString("sTypeOfAccount");

            lbl_DownPayment.setText(DownPayment);
            lbl_LoanTermSelection.setText(LoanTermSelection);
            lbl_MonthlyPayment.setText(MonthlyPayment);
            lbl_PriceOfUnit.setText(PriceOfUnit);
            lbl_Discount.setText(Discount);

            lbl_TypeOfEmployment.setText(TypeOfEmployment);

            if (lbl_TypeOfEmployment.getText().toString().equalsIgnoreCase("OFW")) {
                lbl_Industry.setVisibility(TextView.GONE);
                txt_industry.setVisibility(TextView.GONE);
            } else {
                lbl_Industry.setText(Industry);
            }
            lbl_JobTitle.setText(JobTitle);
            lbl_EstimatedIncome1.setText(EstimatedIncome);

            lbl_OtherIncome.setText(OtherIncome);
            lbl_EstimatedIncome2.setText(EstimatedIncome2);
            lbl_BankName.setText(BankName);
            lbl_TypeOfAccount.setText(TypeOfAccount);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            try {
                Intent receiveIntent = getIntent();
                String param = receiveIntent.getStringExtra("params");
                JSONObject params = new JSONObject(param);

                Intent returnIntent = new Intent(Activity_LoanPreview.this,
                        Activity_OtherInfo.class);
                Bundle bundle = new Bundle();

                bundle.putString("xDownPayment", lbl_DownPayment.getText().toString());
                bundle.putString("xLTSelection", lbl_LoanTermSelection.getText().toString());
                bundle.putString("xPriceOfUnit", lbl_MonthlyPayment.getText().toString());
                bundle.putString("xMonthlyPayment", lbl_PriceOfUnit.getText().toString());
                bundle.putString("xDiscount", lbl_Discount.getText().toString());

                bundle.putString("xEmployment", lbl_TypeOfEmployment.getText().toString());
                bundle.putString("xIndustry", lbl_Industry.getText().toString());
                bundle.putString("xEstimatedIncome", lbl_JobTitle.getText().toString());
                bundle.putString("xJobTitle", lbl_EstimatedIncome1.getText().toString());

                bundle.putString("xOtherIncome", lbl_OtherIncome.getText().toString());
                bundle.putString("xEstimatedIncome1", lbl_EstimatedIncome2.getText().toString());
                bundle.putString("xBankName", lbl_BankName.getText().toString());
                bundle.putString("xTypeOfAccount", lbl_TypeOfAccount.getText().toString());

                returnIntent.putExtra("bundle", bundle);
                returnIntent.putExtra("params", params.toString());

                startActivity(returnIntent);

                this.finish();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        try {
            Intent receiveIntent = getIntent();
            String param = receiveIntent.getStringExtra("params");
            JSONObject params = new JSONObject(param);

            Intent returnIntent = new Intent(Activity_LoanPreview.this,
                    Activity_OtherInfo.class);

            Bundle bundle = new Bundle();

            bundle.putString("xDownPayment", lbl_DownPayment.getText().toString());
            bundle.putString("xLTSelection", lbl_LoanTermSelection.getText().toString());
            bundle.putString("xPriceOfUnit", lbl_MonthlyPayment.getText().toString());
            bundle.putString("xMonthlyPayment", lbl_PriceOfUnit.getText().toString());
            bundle.putString("xDiscount", lbl_Discount.getText().toString());

            bundle.putString("xEmployment", lbl_TypeOfEmployment.getText().toString());
            bundle.putString("xIndustry", lbl_Industry.getText().toString());
            bundle.putString("xEstimatedIncome", lbl_JobTitle.getText().toString());
            bundle.putString("xJobTitle", lbl_EstimatedIncome1.getText().toString());

            bundle.putString("xOtherIncome", lbl_OtherIncome.getText().toString());
            bundle.putString("xEstimatedIncome1", lbl_EstimatedIncome2.getText().toString());
            bundle.putString("xBankName", lbl_BankName.getText().toString());
            bundle.putString("xTypeOfAccount", lbl_TypeOfAccount.getText().toString());

            returnIntent.putExtra("bundle", bundle);
            returnIntent.putExtra("params", params.toString());

            startActivity(returnIntent);
            this.finish();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    private void initViews() {
        lbl_DownPayment = findViewById(R.id.lbl_DownPayment);
        lbl_LoanTermSelection = findViewById(R.id.lbl_LoanTermSelection);
        lbl_MonthlyPayment = findViewById(R.id.lbl_MonthlyPayment);
        lbl_PriceOfUnit = findViewById(R.id.lbl_PriceOfUnit);
        lbl_Discount = findViewById(R.id.lbl_Discount);
        lbl_TypeOfEmployment = findViewById(R.id.lbl_EmployeeStatus);
        lbl_Industry = findViewById(R.id.lbl_Industry);
        lbl_JobTitle = findViewById(R.id.lbl_JobTitle);
        lbl_EstimatedIncome1 = findViewById(R.id.lbl_EstimatedIncome1);
        lbl_OtherIncome = findViewById(R.id.lbl_OtherIncome);
        lbl_EstimatedIncome2 = findViewById(R.id.lbl_EstimatedIncome2);
        lbl_BankName = findViewById(R.id.lbl_BankName);
        lbl_TypeOfAccount = findViewById(R.id.lbl_TypeOfAccount);

        txt_industry = findViewById(R.id.txt7);

        toolbar = findViewById(R.id.toolbar);

        btnApplyLoan = findViewById(R.id.btnApplyLoan);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Loan Preview");
    }
}