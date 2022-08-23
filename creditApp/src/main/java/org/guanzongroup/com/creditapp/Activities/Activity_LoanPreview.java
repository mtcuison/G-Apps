package org.guanzongroup.com.creditapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONException;
import org.json.JSONObject;

public class Activity_LoanPreview extends AppCompatActivity {

    private TextView lbl_DownPayment, lbl_LoanTermSelection, lbl_MonthlyPayment, lbl_PriceOfUnit,
            lbl_Discount, lbl_TypeOfEmployment, lbl_Industry, lbl_JobTitle, lbl_EstimatedIncome1,
            lbl_OtherIncome, lbl_EstimatedIncome2, lbl_BankName, lbl_TypeOfAccount;
    private MaterialButton btnApplyLoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_preview);

        initViews();
        receiveIntent();

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
                lbl_Industry.setText(Industry);
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

        btnApplyLoan = findViewById(R.id.btnApplyLoan);
    }
}