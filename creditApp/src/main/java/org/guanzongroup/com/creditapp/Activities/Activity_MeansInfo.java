package org.guanzongroup.com.creditapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class Activity_MeansInfo extends AppCompatActivity {


    private TextInputEditText txt_sIndstWrk, txt_sPosition, txt_nSalaryxx,
            txt_sIndstBus, txt_nBusIcom, txt_nPensionx, txt_nEstIncme, txt_sOthrIncm, txt_nOthrIncm;
    private AutoCompleteTextView txt_cIncmeSrc, txt_cPenTypex, txt_sReltnCde;
    private MaterialButton btnNext;
    private Toolbar toolbar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_means_info);

        initViews();
        receiveIntent();
        setUpToolbar();
        goToNextPage();
        arrayList();
    }

    private void arrayList() {

        ArrayList<String> sIncome = new ArrayList<>();
        sIncome.add("Employed");
        sIncome.add("Self Employed");

        ArrayAdapter<String> sIncomeAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, sIncome
        );
        txt_cIncmeSrc.setAdapter(sIncomeAdapter);

        ArrayList<String> pentype = new ArrayList<>();
        pentype.add("Private");
        pentype.add("Public");

        ArrayAdapter<String> pentypeAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, pentype
        );
        txt_cPenTypex.setAdapter(pentypeAdapter);

        ArrayList<String> finance = new ArrayList<>();
        finance.add("Children");
        finance.add("Parents");
        finance.add("Siblings");
        finance.add("Relatives");
        finance.add("Others");

        ArrayAdapter<String> financedAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, finance
        );
        txt_sReltnCde.setAdapter(financedAdapter);
    }

    private void receiveIntent() {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @Override
    public void onBackPressed() {

    }

    private void goToNextPage() {

        btnNext.setOnClickListener(v -> {

//            try {
//                intent = getIntent();
//                String param = intent.getStringExtra("params");
//                JSONObject params = new JSONObject(param);
//                params.put("sEstimatedIncome", (Objects.requireNonNull(txt_cIncmeSrc.getText()).toString().trim()));

            Intent loIntent = new Intent(Activity_MeansInfo.this, Activity_DisbursementInfo.class);
//
//                loIntent.putExtra("params", params.toString());
            startActivity(loIntent);
            this.finish();

//            } catch (Exception e) {
//                e.printStackTrace();
//            }


        });
    }

    private void initViews() {

        txt_cIncmeSrc = findViewById(R.id.tie_PSincome);

        txt_sIndstWrk = findViewById(R.id.tie_NatureOfWork);
        txt_sPosition = findViewById(R.id.tie_Position);
        txt_nSalaryxx = findViewById(R.id.tie_Salary);

        txt_sIndstBus = findViewById(R.id.tie_NatureOfBus);
        txt_nBusIcom = findViewById(R.id.tie_BusInc);

        txt_cPenTypex = findViewById(R.id.tie_PenType);
        txt_nPensionx = findViewById(R.id.tie_PenRnge);

        txt_sReltnCde = findViewById(R.id.tie_Financed);
        txt_nEstIncme = findViewById(R.id.tie_fEstIncome);

        txt_sOthrIncm = findViewById(R.id.tie_OtherIncome);
        txt_nEstIncme = findViewById(R.id.tie_OthrEstIncome);

        toolbar = findViewById(R.id.toolbar);

        btnNext = findViewById(R.id.btnNext);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Means Info");
    }
}
