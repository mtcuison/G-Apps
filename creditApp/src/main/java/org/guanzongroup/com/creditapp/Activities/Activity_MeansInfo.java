package org.guanzongroup.com.creditapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONObject;

import java.util.Objects;

public class Activity_MeansInfo extends AppCompatActivity{


    private RadioGroup rg_EmployeeStatus;
    private RadioButton rb_Employed, rb_SelfEmployed, rb_OFW;
    private TextInputEditText txt_Industry, txt_JobTitle, txt_EstimatedIncome;
    private MaterialButton btnNext;
    private TextView lblInd;
    private Toolbar toolbar;
    private String TypeOfEmployee, aa, bb, cc, dd, ee, w, x, y, z;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_means_info);

        initViews();
        receiveIntent();
        setUpToolbar();
        rg_EmployeeStats();
        goToNextPage();
    }

    private void receiveIntent() {
        try {
            Intent receiveIntent = getIntent();
            Bundle bundle = receiveIntent.getBundleExtra("bundles");
            Bundle bundlex = new Bundle(bundle);

            String DownPayment = bundlex.getString("xDownPayment");
            String LoanTermSelection = bundlex.getString("xLTSelection");
            String MonthlyPayment = bundlex.getString("xPriceOfUnit");
            String PriceOfUnit = bundlex.getString("xMonthlyPayment");
            String Discount = bundlex.getString("xDiscount");

            aa = DownPayment;
            bb = LoanTermSelection;
            cc = MonthlyPayment;
            dd = PriceOfUnit;
            ee = Discount;

            String OthInc = bundlex.getString("xOtherIncome");
            String EstInc = bundlex.getString("xEstimatedIncome1");
            String BnkName = bundlex.getString("xBankName");
            String TypeofAcc = bundlex.getString("xTypeOfAccount");

            w = OthInc;
            x = EstInc;
            y = BnkName;
            z = TypeofAcc;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {

            Intent returnIntent = new Intent(Activity_MeansInfo.this,
                    Activity_IntroductoryQuestion.class);
            Bundle bundle = new Bundle();
            bundle.putString("xDownPayment", aa);
            bundle.putString("xLTSelection", bb);
            bundle.putString("xPriceOfUnit", cc);
            bundle.putString("xMonthlyPayment", dd);
            bundle.putString("xDiscount", ee);

            bundle.putString("xEmployment", TypeOfEmployee);
            bundle.putString("xIndustry", Objects.requireNonNull(txt_Industry.getText()).toString().trim());
            bundle.putString("xEstimatedIncome", Objects.requireNonNull(txt_EstimatedIncome.getText()).toString().trim());
            bundle.putString("xJobTitle", Objects.requireNonNull(txt_JobTitle.getText()).toString().trim());

            bundle.putString("xOtherIncome", w);
            bundle.putString("xEstimatedIncome1", x);
            bundle.putString("xBankName", y);
            bundle.putString("xTypeOfAccount", z);

            returnIntent.putExtra("bundle", bundle);

            startActivity(returnIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        Intent returnIntent = new Intent(Activity_MeansInfo.this,
                Activity_IntroductoryQuestion.class);

        Bundle bundle = new Bundle();
        bundle.putString("xDownPayment", aa);
        bundle.putString("xLTSelection", bb);
        bundle.putString("xPriceOfUnit", cc);
        bundle.putString("xMonthlyPayment", dd);
        bundle.putString("xDiscount", ee);

        bundle.putString("xEmployment", TypeOfEmployee);
        bundle.putString("xIndustry", Objects.requireNonNull(txt_Industry.getText()).toString().trim());
        bundle.putString("xEstimatedIncome", Objects.requireNonNull(txt_EstimatedIncome.getText()).toString().trim());
        bundle.putString("xJobTitle", Objects.requireNonNull(txt_JobTitle.getText()).toString().trim());

        bundle.putString("xOtherIncome", w);
        bundle.putString("xEstimatedIncome1", x);
        bundle.putString("xBankName", y);
        bundle.putString("xTypeOfAccount", z);



        startActivity(returnIntent);

    }

    private void goToNextPage() {

        btnNext.setOnClickListener(v -> {
            if (validateData()) {
                Toast.makeText(Activity_MeansInfo.this, "Proceeding to the next page", Toast.LENGTH_SHORT).show();

                try {
                    intent = getIntent();
                    String param = intent.getStringExtra("params");
                    JSONObject params = new JSONObject(param);
                    params.put("sTypeOfEmployment", (TypeOfEmployee.trim()));
                    params.put("sIndustry", (Objects.requireNonNull(txt_Industry.getText()).toString().trim()));
                    params.put("sJobTitle", (Objects.requireNonNull(txt_JobTitle.getText()).toString().trim()));
                    params.put("sEstimatedIncome", (Objects.requireNonNull(txt_EstimatedIncome.getText()).toString().trim()));

                    Intent loIntent = new Intent(Activity_MeansInfo.this, Activity_DisbursementInfo.class);
                    loIntent.putExtra("params", params.toString());

                    Bundle bundle = new Bundle();
                    bundle.putString("xDownPayment", aa);
                    bundle.putString("xLTSelection", bb);
                    bundle.putString("xPriceOfUnit", cc);
                    bundle.putString("xMonthlyPayment", dd);
                    bundle.putString("xDiscount", ee);

                    bundle.putString("xEmployment", TypeOfEmployee);
                    bundle.putString("xIndustry", txt_Industry.getText().toString().trim());
                    bundle.putString("xEstimatedIncome", txt_EstimatedIncome.getText().toString().trim());
                    bundle.putString("xJobTitle", txt_JobTitle.getText().toString().trim());

                    bundle.putString("xOtherIncome", w);
                    bundle.putString("xEstimatedIncome1", x);
                    bundle.putString("xBankName", y);
                    bundle.putString("xTypeOfAccount", z);

                    loIntent.putExtra("bundle", bundle);
                    startActivity(loIntent);
                    this.finish();

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


        txt_EstimatedIncome = findViewById(R.id.tie_EstimatedIncome);

        toolbar = findViewById(R.id.toolbar);

        btnNext = findViewById(R.id.btnNext);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Loan Application info");
    }
}