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

import java.util.Objects;

public class Activity_OtherInfo extends AppCompatActivity {

    private TextInputEditText txt_OtherIncome, txt_EstimatedIncome;
    private AutoCompleteTextView txt_BankName , txt_TypeOfAccount;
    private MaterialButton btnNext;
    private Toolbar toolbar;

    String [] Bank = new String[] {"BDO", "Union Bank", "Security", "DBP", "UCPB"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_info);

        initViews();
        bankName();
        goToNextPage();
        setUpToolbar();
    }

    private void bankName() {
        txt_BankName.setAdapter(new ArrayAdapter<>(Activity_OtherInfo.this, android.R.layout.simple_list_item_1, Bank));
    }

    private void goToNextPage() {

        btnNext.setOnClickListener(v -> {

            if (validateData()){
                Toast.makeText(Activity_OtherInfo.this, "Proceeding to Next Page", Toast.LENGTH_SHORT).show();

                try {
                    Intent receiveIntent = getIntent();
                    String param = receiveIntent.getStringExtra("params");

                    JSONObject params = new JSONObject(param);
                    params.put("sBankName", (txt_BankName.getText().toString()));
                    params.put("sEstimatedIncome2", (Objects.requireNonNull(txt_EstimatedIncome.getText()).toString()));
                    params.put("sOtherIncome", (Objects.requireNonNull(txt_OtherIncome.getText()).toString()));
                    params.put("sTypeOfAccount", (txt_TypeOfAccount.getText().toString()));

                    Intent loIntent = new Intent(Activity_OtherInfo.this, Activity_LoanPreview.class);

                    loIntent.putExtra("params", params.toString());
                    startActivity(loIntent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initViews() {
        txt_OtherIncome = findViewById(R.id.tie_OtherIncome);
        txt_EstimatedIncome = findViewById(R.id.tie_EstimatedIncome);
        txt_BankName = findViewById(R.id.tie_BankName);
        txt_TypeOfAccount = findViewById(R.id.tie_TypeOfAccount);
        toolbar = findViewById(R.id.toolbar);
        btnNext = findViewById(R.id.btnNext);
    }

    private boolean validateData(){
        if (Objects.requireNonNull(txt_OtherIncome.getText()).toString().equals("")){
            Toast.makeText(this, "Please Enter Other Source of Income", Toast.LENGTH_SHORT).show();
            return false;
        }else if (Objects.requireNonNull(txt_EstimatedIncome.getText()).toString().equals("")){
            Toast.makeText(this, "Please Enter Estimated Income", Toast.LENGTH_SHORT).show();
            return false;
        }else if(txt_BankName.getText().toString().equals("")){
            Toast.makeText(this, "Please Enter Bank Name", Toast.LENGTH_SHORT).show();
            return false;
        }else if (txt_TypeOfAccount.getText().toString().equals("")){
            Toast.makeText(this, "Please Enter Type of Account", Toast.LENGTH_SHORT).show();
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
