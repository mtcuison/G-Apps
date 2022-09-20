package org.guanzongroup.com.creditapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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


    private TextInputEditText txt_nDownPaym, txt_nUnitPrce, txt_nDiscount, txt_nMiscChrg, txt_nMonAmort;
    private AutoCompleteTextView txt_dAppliedx, txt_sModelIDx, txt_nAccrTerm;

    private MaterialButton btnNext;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory_question);

        initViews();
        receiveIntent();
        setUpToolbar();
        arrayList();
        goToNextPage();
    }

    private void arrayList() {

        ArrayList<String> AppUnit = new ArrayList<>();
        AppUnit.add("Motorcycle");
        AppUnit.add("Mobile Phone");

        ArrayAdapter<String> AppUnitAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, AppUnit
        );
        txt_dAppliedx.setAdapter(AppUnitAdapter);

        ArrayList<String> LTS = new ArrayList<>();
        LTS.add("36 Months/3 Years");
        LTS.add("24 Months/2 Years");
        LTS.add("18 Months");
        LTS.add("12 Months/1 Year");
        LTS.add("6 Months");

        ArrayAdapter<String> LTSAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, LTS
        );

        txt_nAccrTerm.setAdapter(LTSAdapter);
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

    }

    private void goToNextPage() {

        btnNext.setOnClickListener(v -> {


//                try {
//
//
//                    JSONObject params = new JSONObject();
//                    params.put("sDownPayment", (Objects.requireNonNull(txt_dAppliedx.getText()).toString()));

            Intent loIntent = new Intent(Activity_IntroductoryQuestion.this, Activity_PersonalInfo.class);

//                    loIntent.putExtra("params", params.toString());
//
            startActivity(loIntent);
            this.finish();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
        });
    }

    private void initViews() {

        txt_dAppliedx = findViewById(R.id.tie_UntApply);
        txt_nDownPaym = findViewById(R.id.tie_DownPayment);
        txt_sModelIDx = findViewById(R.id.tie_ModelId);
        txt_nUnitPrce = findViewById(R.id.tie_PriceOfUnit);
        txt_nDiscount = findViewById(R.id.tie_Discount);
        txt_nMiscChrg = findViewById(R.id.tie_Miscellaneous);
        txt_nAccrTerm = findViewById(R.id.tie_LoanTermSelection);
        txt_nMonAmort = findViewById(R.id.tie_MonthlyPayment);

        toolbar = findViewById(R.id.toolbar);
        btnNext = findViewById(R.id.btnNext);
    }


    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Introductory Question");
    }
}