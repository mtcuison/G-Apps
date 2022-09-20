package org.guanzongroup.com.creditapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;
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

public class Activity_DisbursementInfo extends AppCompatActivity {

    String[] Bank = new String[]{"BDO", "Union Bank", "Security", "DBP", "UCPB"};

    private AutoCompleteTextView txt_sBankName, txt_sAcctType;
    private MaterialButton btnNext;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disbursement_info);

        initViews();
        bankName();
        goToNextPage();
        arrayList();
        setUpToolbar();
    }

    private void arrayList() {
        ArrayList<String> BankAccType = new ArrayList<>();

        BankAccType.add("Checking");
        BankAccType.add("Savings");
        BankAccType.add("Payroll");

        ArrayAdapter<String> BAcctTypeAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, BankAccType
        );

        txt_sAcctType.setAdapter(BAcctTypeAdapter);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

    }

    private void goToNextPage() {

        btnNext.setOnClickListener(v -> {


//                try {
//                    Intent receiveIntent = getIntent();
//                    String param = receiveIntent.getStringExtra("params");
//                    JSONObject params = new JSONObject(param);
//                    params.put("sBankName", (txt_sBankName.getText().toString()));
//                    params.put("sAcctType", (txt_sAcctType.getText().toString()));

            Intent loIntent = new Intent(Activity_DisbursementInfo.this, Activity_LoanPreview.class);

//                    loIntent.putExtra("params", params.toString());
            startActivity(loIntent);
            this.finish();
//
//                } catch (Exception ee) {
//                    ee.printStackTrace();
//                }
        });
    }

    private void bankName() {
        txt_sBankName.setAdapter(new ArrayAdapter<>(Activity_DisbursementInfo.this, android.R.layout.simple_list_item_1, Bank));
    }

    private void initViews() {

        txt_sBankName = findViewById(R.id.tie_BankName);
        txt_sAcctType = findViewById(R.id.tie_TypeOfAccount);

        toolbar = findViewById(R.id.toolbar);
        btnNext = findViewById(R.id.btnNext);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Disbursement Info");
    }

}
