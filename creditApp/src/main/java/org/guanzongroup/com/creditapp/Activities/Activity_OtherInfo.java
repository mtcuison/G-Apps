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

import java.util.Objects;

public class Activity_OtherInfo extends AppCompatActivity {

    String[] Bank = new String[]{"BDO", "Union Bank", "Security", "DBP", "UCPB"};
    private TextInputEditText txt_OtherIncome, txt_EstimatedIncome;
    private AutoCompleteTextView txt_BankName, txt_TypeOfAccount;
    private MaterialButton btnNext;
    private Toolbar toolbar;
    private String a, b, c, d, e, f, g, h, i;

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
        try {
            Intent receiveIntent = getIntent();
            Bundle bundle = receiveIntent.getBundleExtra("bundle");
            Bundle bundlex = new Bundle(bundle);

            String DownPayment = bundlex.getString("xDownPayment");
            String LoanTermSelection = bundlex.getString("xLTSelection");
            String MonthlyPayment = bundlex.getString("xPriceOfUnit");
            String PriceOfUnit = bundlex.getString("xMonthlyPayment");
            String Discount = bundlex.getString("xDiscount");

            a = DownPayment;
            b = LoanTermSelection;
            c = MonthlyPayment;
            d = PriceOfUnit;
            e = Discount;

            String TypeOfEmployment = bundlex.getString("xEmployment");
            String Industry = bundlex.getString("xIndustry");
            String JobTitle = bundlex.getString("xEstimatedIncome");
            String EstimatedIncome = bundlex.getString("xJobTitle");

            f = TypeOfEmployment;
            g = Industry;
            h = JobTitle;
            i = EstimatedIncome;

            String OthInc = bundlex.getString("xOtherIncome");
            String EstInc = bundlex.getString("xEstimatedIncome1");
            String BnkName = bundlex.getString("xBankName");
            String TypeofAcc = bundlex.getString("xTypeOfAccount");

            txt_OtherIncome.setText(OthInc);
            txt_EstimatedIncome.setText(EstInc);
            txt_BankName.setText(BnkName);
            txt_TypeOfAccount.setText(TypeofAcc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            try {
                Intent receiveIntent = getIntent();
                String param = receiveIntent.getStringExtra("params");
                JSONObject params = new JSONObject(param);

                Intent returnIntent = new Intent(Activity_OtherInfo.this,
                        Activity_MeansInfo.class);

                Bundle bundle = new Bundle();
                bundle.putString("xDownPayment", a);
                bundle.putString("xLTSelection", b);
                bundle.putString("xPriceOfUnit", c);
                bundle.putString("xMonthlyPayment", d);
                bundle.putString("xDiscount", e);

                bundle.putString("xEmployment", f);
                bundle.putString("xIndustry", g);
                bundle.putString("xEstimatedIncome", h);
                bundle.putString("xJobTitle", i);

                bundle.putString("xOtherIncome", txt_OtherIncome.getText().toString().trim());
                bundle.putString("xEstimatedIncome1", txt_EstimatedIncome.getText().toString().trim());
                bundle.putString("xBankName", txt_BankName.getText().toString().trim());
                bundle.putString("xTypeOfAccount", txt_TypeOfAccount.getText().toString().trim());

                returnIntent.putExtra("bundles", bundle);
                returnIntent.putExtra("params", params.toString());

                startActivity(returnIntent);
                this.finish();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        try {
            Intent receiveIntent = getIntent();
            String param = receiveIntent.getStringExtra("params");
            JSONObject params = new JSONObject(param);

            Intent returnIntent = new Intent(Activity_OtherInfo.this,
                    Activity_MeansInfo.class);

            Bundle bundle = new Bundle();
            bundle.putString("xDownPayment", a);
            bundle.putString("xLTSelection", b);
            bundle.putString("xPriceOfUnit", c);
            bundle.putString("xMonthlyPayment", d);
            bundle.putString("xDiscount", e);

            bundle.putString("xEmployment", f);
            bundle.putString("xIndustry", g);
            bundle.putString("xEstimatedIncome", h);
            bundle.putString("xJobTitle", i);

            bundle.putString("xOtherIncome", txt_OtherIncome.getText().toString().trim());
            bundle.putString("xEstimatedIncome1", txt_EstimatedIncome.getText().toString().trim());
            bundle.putString("xBankName", txt_BankName.getText().toString().trim());
            bundle.putString("xTypeOfAccount", txt_TypeOfAccount.getText().toString().trim());

            returnIntent.putExtra("bundles", bundle);
            returnIntent.putExtra("params", params.toString());

            startActivity(returnIntent);
            this.finish();
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    private void goToNextPage() {

        btnNext.setOnClickListener(v -> {

            if (validateData()) {
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
                    this.finish();

                } catch (Exception ee) {
                    ee.printStackTrace();
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

    private boolean validateData() {
        if (Objects.requireNonNull(txt_OtherIncome.getText()).toString().equals("")) {
            Toast.makeText(this, "Please Enter Other Source of Income", Toast.LENGTH_SHORT).show();
            return false;
        } else if (Objects.requireNonNull(txt_EstimatedIncome.getText()).toString().equals("")) {
            Toast.makeText(this, "Please Enter Estimated Income", Toast.LENGTH_SHORT).show();
            return false;
        } else if (txt_BankName.getText().toString().equals("")) {
            Toast.makeText(this, "Please Enter Bank Name", Toast.LENGTH_SHORT).show();
            return false;
        } else if (txt_TypeOfAccount.getText().toString().equals("")) {
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
