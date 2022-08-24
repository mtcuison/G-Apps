package org.guanzongroup.com.creditapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Activity_IntroductoryQuestion extends AppCompatActivity {

    private TextInputEditText txt_DownPayment,
            txt_MonthlyPayment, txt_PriceOfUnit, txt_Discount;
    private AutoCompleteTextView txt_LoanTermSelection;

    private MaterialButton btnNext;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory_question);

        initViews();
        setUpToolbar();
        LoanTermSelection();
        goToNextPage();
    }

    private void goToNextPage() {

            btnNext.setOnClickListener(v -> {

                if (validateData()) {
                    Toast.makeText(Activity_IntroductoryQuestion.this, "Proceeding to next Page ", Toast.LENGTH_SHORT).show();

                    try {
                        JSONObject params = new JSONObject();
                        params.put("sDownPayment", (Objects.requireNonNull(txt_DownPayment.getText()).toString()));
                        params.put("sLTSelection", (txt_LoanTermSelection.getText().toString()));
                        params.put("sPriceOfUnit", (Objects.requireNonNull(txt_PriceOfUnit.getText()).toString()));
                        params.put("sMonthlyPayment", (Objects.requireNonNull(txt_MonthlyPayment.getText()).toString()));
                        params.put("sDiscount", (Objects.requireNonNull(txt_Discount.getText()).toString()));

                        Intent loIntent = new Intent(Activity_IntroductoryQuestion.this, Activity_MeansInfo.class);
                        loIntent.putExtra("params", params.toString());

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
        }else if (txt_LoanTermSelection.getText().toString().equals("")){
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