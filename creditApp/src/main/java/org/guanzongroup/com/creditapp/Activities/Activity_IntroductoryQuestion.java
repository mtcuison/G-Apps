package org.guanzongroup.com.creditapp.Activities;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Activity_IntroductoryQuestion extends AppCompatActivity {

    TextView DP, LTS, MP, POU;
    private TextInputEditText txt_DownPayment,
            txt_MonthlyPayment, txt_PriceOfUnit, txt_Discount;
    private AutoCompleteTextView txt_LoanTermSelection;
    private MaterialButton btnNext;
    private Toolbar toolbar;
    private String a, b, c, d, w, x, y, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory_question);



        initViews();
        receiveIntent();
        setUpToolbar();
        LoanTermSelection();
        goToNextPage();
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    private void receiveIntent() {

        try {
            Intent receiveIntent = getIntent();
            Bundle bundle = receiveIntent.getBundleExtra("bundle");
            Bundle bundlex = new Bundle(bundle);

            String down = bundlex.getString("xDownPayment");
            String loan = bundlex.getString("xLTSelection");
            String price = bundlex.getString("xPriceOfUnit");
            String MonPay = bundlex.getString("xMonthlyPayment");
            String Dis = bundlex.getString("xDiscount");

            txt_DownPayment.setText(down);
            txt_LoanTermSelection.setText(loan);
            txt_PriceOfUnit.setText(price);
            txt_MonthlyPayment.setText(MonPay);
            txt_Discount.setText(Dis);

            String emp = bundlex.getString("xEmployment");
            String ind = bundlex.getString("xIndustry");
            String est = bundlex.getString("xEstimatedIncome");
            String job = bundlex.getString("xJobTitle");

            w = emp;
            x = ind;
            y = est;
            z = job;

            String OthInc = bundlex.getString("xOtherIncome");
            String EstInc = bundlex.getString("xEstimatedIncome1");
            String BnkName = bundlex.getString("xBankName");
            String TypeofAcc = bundlex.getString("xTypeOfAccount");

            a = OthInc;
            b = EstInc;
            c = BnkName;
            d = TypeofAcc;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goToNextPage() {

        btnNext.setOnClickListener(v -> {

            if (validateData()) {
                Toast.makeText(Activity_IntroductoryQuestion.this, "Proceeding to next Page ", Toast.LENGTH_SHORT).show();
                try {
                    Intent loIntent = new Intent(Activity_IntroductoryQuestion.this, Activity_MeansInfo.class);

                    JSONObject params = new JSONObject();
                    params.put("sDownPayment", (Objects.requireNonNull(txt_DownPayment.getText()).toString()));
                    params.put("sLTSelection", (txt_LoanTermSelection.getText().toString()));
                    params.put("sPriceOfUnit", (Objects.requireNonNull(txt_PriceOfUnit.getText()).toString()));
                    params.put("sMonthlyPayment", (Objects.requireNonNull(txt_MonthlyPayment.getText()).toString()));
                    params.put("sDiscount", (Objects.requireNonNull(txt_Discount.getText()).toString()));

                    loIntent.putExtra("params", params.toString());

                    Bundle meansInfo = new Bundle();

                    meansInfo.putString("xDownPayment", (Objects.requireNonNull(txt_DownPayment.getText()).toString()));
                    meansInfo.putString("xLTSelection", (txt_LoanTermSelection.getText().toString()));
                    meansInfo.putString("xPriceOfUnit", (Objects.requireNonNull(txt_PriceOfUnit.getText()).toString()));
                    meansInfo.putString("xMonthlyPayment", (Objects.requireNonNull(txt_MonthlyPayment.getText().toString())));
                    meansInfo.putString("xDiscount", (Objects.requireNonNull(txt_Discount.getText()).toString()));

                    meansInfo.putString("xEmployment", w);
                    meansInfo.putString("xIndustry", x);
                    meansInfo.putString("xEstimatedIncome", y);
                    meansInfo.putString("xJobTitle", z);

                    meansInfo.putString("xOtherIncome", a);
                    meansInfo.putString("xEstimatedIncome1", b);
                    meansInfo.putString("xBankName", c);
                    meansInfo.putString("xTypeOfAccount", d);

                    loIntent.putExtra("bundles", meansInfo);

                    startActivity(loIntent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void LoanTermSelection() {

        ArrayList<String> LTS = new ArrayList<>();
        LTS.add("36 Months/3 Years");
        LTS.add("24 Months/2 Years");
        LTS.add("18 Months");
        LTS.add("12 Months/1 Year");
        LTS.add("6 Months");

        ArrayAdapter<String> LTSAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, LTS
        );

        txt_LoanTermSelection.setAdapter(LTSAdapter);
    }

    private void initViews() {

        txt_DownPayment = findViewById(R.id.tie_DownPayment);
        txt_LoanTermSelection = findViewById(R.id.tie_LoanTermSelection);
        txt_PriceOfUnit = findViewById(R.id.tie_PriceOfUnit);
        txt_MonthlyPayment = findViewById(R.id.tie_MonthlyPayment);
        txt_Discount = findViewById(R.id.tie_Discount);

        toolbar = findViewById(R.id.toolbar);

        btnNext = findViewById(R.id.btnNext);
    }

    private boolean validateData() {

        if (Objects.requireNonNull(txt_DownPayment.getText()).toString().equals("")) {
            Toast.makeText(this, "Please Enter Down Payment Amount", Toast.LENGTH_SHORT).show();
            return false;
        } else if (txt_LoanTermSelection.getText().toString().equals("")) {
            Toast.makeText(this, "Please Select Loan Terms", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Loan Application Info");
    }
}