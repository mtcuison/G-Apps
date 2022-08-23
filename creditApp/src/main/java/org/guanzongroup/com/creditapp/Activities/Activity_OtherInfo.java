package org.guanzongroup.com.creditapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.R;
import org.json.JSONObject;

public class Activity_OtherInfo extends AppCompatActivity {

    private TextInputEditText txt_OtherIncome, txt_EstimatedIncome;
    private AutoCompleteTextView txt_BankName , txt_TypeOfAccount;

    private MaterialButton btnNext;

    String [] Bank = new String[] {"BDO", "Union Bank", "Security", "DBP", "UCPB"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_info);

        initViews();
        bankName();
        goToNextPage();



    }

    private void bankName() {
        txt_BankName.setAdapter(new ArrayAdapter<>(Activity_OtherInfo.this, android.R.layout.simple_list_item_1, Bank));
    }

    private void goToNextPage() {

        try {
            Intent receiveIntent = getIntent();
            String param = receiveIntent.getStringExtra("params");

            JSONObject params = new JSONObject(param);
            params.put("sBankName", (txt_BankName.getText().toString()));
            params.put("sEstimatedIncome2", (txt_EstimatedIncome.getText().toString()));
            params.put("sOtherIncome", (txt_OtherIncome.getText().toString()));
            params.put("sTypeOfAccount", (txt_TypeOfAccount.getText().toString()));

            Intent loIntent = new Intent(Activity_OtherInfo.this, Activity_LoanPreview.class);

            loIntent.putExtra("params", params.toString());
            startActivity(loIntent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initViews() {
        txt_OtherIncome = findViewById(R.id.tie_OtherIncome);
        txt_EstimatedIncome = findViewById(R.id.tie_EstimatedIncome);
        txt_BankName = findViewById(R.id.tie_BankName);
        txt_TypeOfAccount = findViewById(R.id.tie_TypeOfAccount);

        btnNext = findViewById(R.id.btnNext);
    }
}