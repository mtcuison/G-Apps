package org.rmj.guanzongroup.ganado.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import org.rmj.g3appdriver.etc.FormatUIText;
import org.rmj.g3appdriver.lib.Ganado.Obj.ProductInquiry;
import org.rmj.guanzongroup.ganado.R;
import org.rmj.guanzongroup.ganado.ViewModel.VMInstallmentSummary;


public class Activity_Installment_Summary extends AppCompatActivity {
    private ProductInquiry poApp;
    private VMInstallmentSummary mViewModel;
    private String Transaction;
    private MaterialTextView  txtTerms,  txtTargetDtes;
    private MaterialAutoCompleteTextView txtPaymMod;
    private MaterialAutoCompleteTextView txtTargetDtex;
    private MaterialAutoCompleteTextView txtTerm;
    private MaterialAutoCompleteTextView txtMinDP;
        private TextInputEditText txtCashPrice;
    private TextInputEditText txtMontlyAmort;
    private MaterialAutoCompleteTextView txtTargetDte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installment_summary);
        initWidgets();
        mViewModel.InitializeApplication(getIntent());
        setWidgets();

    }
    private void initWidgets(){
        mViewModel = new ViewModelProvider(Activity_Installment_Summary.this).get(VMInstallmentSummary.class);
        txtPaymMod = findViewById(R.id.paymMethod);
        txtCashPrice = findViewById(R.id.txt_cashPrice);
        txtMinDP = findViewById(R.id.txt_mindownpayment);
        txtTerm = findViewById(R.id.spn_installmentTerm);
        txtMontlyAmort = findViewById(R.id.txt_monthlyAmort);
        txtTargetDte = findViewById(R.id.txt_mindownpayment);
    }

    private void setWidgets(){
        mViewModel = new ViewModelProvider(Activity_Installment_Summary.this).get(VMInstallmentSummary.class);

        String lsInput = txtMinDP.getText().toString().trim();
        Double lnInput = FormatUIText.getParseDouble(lsInput);
        String lsModelID = getIntent().getStringExtra("sModelIDx");
        txtCashPrice.setText(getIntent().getStringExtra("nSelPrice"));
        Transaction = getIntent().getStringExtra("sTransNox");
        txtMinDP.setText(getIntent().getStringExtra("sTransNox"));
//        mViewModel.CalculateNewDownpayment(lsModelID, Integer.parseInt(mViewModel.getModel().getTermIDxx()), lnInput, new VMInstallmentSummary.OnCalculateNewDownpayment() {
//            @Override
//            public void OnCalculate(double lnResult) {
//                txtMontlyAmort.setText(FormatUIText.getCurrencyUIFormat(String.valueOf(lnResult)));
//            }
//
//            @Override
//            public void OnFailed(String message) {
//
//            }
//        } );


    }
}