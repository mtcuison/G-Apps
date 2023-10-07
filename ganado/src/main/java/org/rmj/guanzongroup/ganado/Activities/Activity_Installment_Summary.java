package org.rmj.guanzongroup.ganado.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textview.MaterialTextView;

import org.rmj.g3appdriver.lib.Ganado.Obj.ProductInquiry;
import org.rmj.guanzongroup.ganado.R;
import org.rmj.guanzongroup.ganado.ViewModel.VMInstallmentSummary;


public class Activity_Installment_Summary extends AppCompatActivity {
    private ProductInquiry poApp;
    private VMInstallmentSummary mViewModel;

    private MaterialTextView txtPaymMod, txtCashPrice, txtMinDP, txtTerm, txtMontlyAmort, txtTargetDte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_installment_summary);
        mViewModel.InitializeApplication(getIntent());
        initWidgets();
        setWidgets();

    }
    private void initWidgets(){
        mViewModel = new ViewModelProvider(Activity_Installment_Summary.this).get(VMInstallmentSummary.class);
        //poMessage = new MessageBox(Activity_Installment_Summary.this);
//        MaterialToolbar toolbar = findViewById(R.id.toolbar_Inquiry);
//        setSupportActionBar(toolbar);
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
//
        txtPaymMod = findViewById(R.id.paymMethod);
        txtCashPrice = findViewById(R.id.txt_cashPrice);
        txtMinDP = findViewById(R.id.txt_mindownpayment);
        txtTerm = findViewById(R.id.spn_installmentTerm);
        txtMontlyAmort = findViewById(R.id.txt_monthlyAmort);
        txtTargetDte = findViewById(R.id.txt_mindownpayment);


    }

    private void setWidgets(){
        mViewModel = new ViewModelProvider(Activity_Installment_Summary.this).get(VMInstallmentSummary.class);
        txtPaymMod.setText("");
        txtCashPrice.setText("");
        txtMinDP.setText("");
        txtTerm.setText("");
        txtMontlyAmort.setText("");
        txtTargetDte.setText("");
    }
}