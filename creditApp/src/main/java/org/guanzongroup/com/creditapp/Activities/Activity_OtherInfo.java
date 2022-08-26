package org.guanzongroup.com.creditapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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
    private String a,b,c,d,e,f,g,h,i;


    String [] Bank = new String[] {"BDO", "Union Bank", "Security", "DBP", "UCPB"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_info);

        initViews();
        receiveIntent();
        bankName();
        goToNextPage();
        setUpToolbar();
    }

    private void receiveIntent() {

        Intent receiveIntent = getIntent();
        Bundle bundle = receiveIntent.getBundleExtra("bundle");

        String OthInc = bundle.getString("OtherIncomex");
        String EstInc = bundle.getString("EstimatedIncomex");
        String BnkName= bundle.getString("BankNamex");
        String TypeofAcc = bundle.getString("TypeOfAccountx");

        txt_OtherIncome.setText(OthInc);
        txt_EstimatedIncome.setText(EstInc);
        txt_BankName.setText(BnkName);
        txt_TypeOfAccount.setText(TypeofAcc);

        try {
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

            a = DownPayment;
            b = LoanTermSelection;
            c = MonthlyPayment;
            d = PriceOfUnit;
            e = Discount;
            f = TypeOfEmployment;
            g = Industry;
            h = JobTitle;
            i = EstimatedIncome;

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home){

            Intent returnIntent = new Intent(Activity_OtherInfo.this ,
                    Activity_MeansInfo.class);
            Bundle bundle = new Bundle();

            bundle.putString("xOtherAccount", txt_OtherIncome.getText().toString().trim());
            bundle.putString("xEstimatedIncome1", txt_EstimatedIncome.getText().toString().trim());
            bundle.putString("xBankName", txt_BankName.getText().toString().trim());
            bundle.putString("xTypeOfAccount", txt_TypeOfAccount.getText().toString().trim());

            bundle.putString("xDownPayment", a);
            bundle.putString("xLTSelection", b);
            bundle.putString("xPriceOfUnit", c);
            bundle.putString("xMonthlyPayment", d);
            bundle.putString("xDiscount", e);

            bundle.putString("xEmployment", f);
            bundle.putString("xIndustry", g);
            bundle.putString("xEstimatedIncome", h);
            bundle.putString("xJobTitle", i);

            returnIntent.putExtra("bundle",bundle);
            startActivity(returnIntent);

            this.finish();
        }
        return super.onOptionsItemSelected(item);
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

    private void bankName() {
        txt_BankName.setAdapter(new ArrayAdapter<>(Activity_OtherInfo.this, android.R.layout.simple_list_item_1, Bank));
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
