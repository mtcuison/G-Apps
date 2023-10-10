package org.rmj.guanzongroup.ganado.Activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import org.json.JSONObject;
import org.rmj.g3appdriver.etc.FormatUIText;
import org.rmj.g3appdriver.lib.Ganado.Obj.ProductInquiry;
import org.rmj.g3appdriver.lib.Ganado.model.GConstants;
import org.rmj.g3appdriver.lib.Ganado.pojo.InstallmentInfo;
import org.rmj.guanzongroup.ganado.R;
import org.rmj.guanzongroup.ganado.ViewModel.VMInstallmentSummary;
import org.rmj.guanzongroup.ganado.ViewModel.VMProductInquiry;

import java.util.ArrayList;


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
//        mViewModel = new ViewModelProvider(Activity_Installment_Summary.this).get(VMInstallmentSummary.class);

        mViewModel.GetInquiryDetail().observe(Activity_Installment_Summary.this, eGanadoOnline->{
            try {
                JSONObject jsonProdInfo = new JSONObject(eGanadoOnline.getProdInfo());
                JSONObject jsonPaymInfo = new JSONObject(eGanadoOnline.getPaymInfo());
                if(jsonPaymInfo.getInt("sTermIDxx")==36){
                    txtTerm.setText(GConstants.INSTALLMENT_TERM[0]);
                }else if(jsonPaymInfo.getInt("sTermIDxx")==24){
                    txtTerm.setText(GConstants.INSTALLMENT_TERM[1]);
                }else if(jsonPaymInfo.getInt("sTermIDxx")==18){
                    txtTerm.setText(GConstants.INSTALLMENT_TERM[2]);
                }else if(jsonPaymInfo.getInt("sTermIDxx")==12){
                    txtTerm.setText(GConstants.INSTALLMENT_TERM[3]);
                }else if(jsonPaymInfo.getInt("sTermIDxx")==6){
                    txtTerm.setText(GConstants.INSTALLMENT_TERM[4]);
                }
                txtTerm.setAdapter(GConstants.getAdapter(Activity_Installment_Summary.this, GConstants.INSTALLMENT_TERM));

                mViewModel.setModelID(jsonProdInfo.getString("sModelIDx"));
                mViewModel.GetModelID().observe(Activity_Installment_Summary.this, modelID -> {
                    try{
                        if(mViewModel.GetCashInfo(modelID) !=  null){
                            Log.e("cashPrice",FormatUIText.getCurrencyUIFormat(String.valueOf(mViewModel.GetCashInfo(modelID).CashPrce)) + "");
                            txtCashPrice.setText(FormatUIText.getCurrencyUIFormat(String.valueOf(mViewModel.GetCashInfo(modelID).CashPrce)));
                        }else{
                            txtCashPrice.setText(FormatUIText.getCurrencyUIFormat("0.0"));
                            Log.e("cashPrice",FormatUIText.getCurrencyUIFormat("0.0"));
                        }
                        mViewModel.GetMinimumDownpayment(modelID,jsonPaymInfo.getInt("sTermIDxx"), new VMInstallmentSummary.OnRetrieveInstallmentInfo() {
                            @Override
                            public void OnRetrieve(InstallmentInfo loResult) {
                                Log.e("getMonthlyAmortization",FormatUIText.getCurrencyUIFormat(String.valueOf(loResult.getMonthlyAmortization())) + "");
                                Log.e("getMonthlyAmortization",FormatUIText.getCurrencyUIFormat(String.valueOf(loResult.getMinimumDownpayment())) + "");

                                mViewModel.getModel().setDownPaym(String.valueOf(loResult.getMinimumDownpayment()));
                                txtMinDP.setText(String.valueOf(loResult.getMinimumDownpayment()));
                                mViewModel.getModel().setMonthAmr(String.valueOf(loResult.getMonthlyAmortization()));
                                txtMontlyAmort.setText(FormatUIText.getCurrencyUIFormat(String.valueOf(loResult.getMonthlyAmortization())));
                            }

                            @Override
                            public void OnFailed(String message) {

                            }
                        });
                    } catch (NullPointerException e){
                        e.printStackTrace();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });
            } catch (NullPointerException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        });
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