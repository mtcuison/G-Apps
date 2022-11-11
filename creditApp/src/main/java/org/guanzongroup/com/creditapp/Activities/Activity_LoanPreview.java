package org.guanzongroup.com.creditapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

import org.guanzongroup.com.creditapp.R;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanPreview;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanProductList;
import org.json.JSONArray;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.g3appdriver.lib.CreditApp.model.MpCreditApp;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;

public class Activity_LoanPreview extends AppCompatActivity {
    private static final String TAG = Activity_LoanPreview.class.getSimpleName();

    private VMLoanPreview mViewModel;
    private Dialog_Loading poLoad;
    private Dialog_SingleButton poMessage;

    private MpCreditApp poApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_LoanPreview.this).get(VMLoanPreview.class);
        poLoad = new Dialog_Loading(Activity_LoanPreview.this);
        poMessage = new Dialog_SingleButton(Activity_LoanPreview.this);
        setContentView(R.layout.activity_loan_preview);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Apply For A Loan");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView imgUnit = findViewById(R.id.imgProdct);
        TextView lblProdct = findViewById(R.id.txtProdNm);
        TextView lblDownPy = findViewById(R.id.lbl_downpayment);
        TextView lblUntPrc = findViewById(R.id.lblUnitPrce);
        TextView lblTermxx = findViewById(R.id.lbl_installmentPlan);
        TextView lblAmortx = findViewById(R.id.lbl_monthlyPayment);

        MaterialButton btnSubmit = findViewById(R.id.btn_Submit);

        mViewModel.InitIntentData(getIntent());

        mViewModel.GetProductInfo().observe(Activity_LoanPreview.this, new Observer<EProducts>() {
            @Override
            public void onChanged(EProducts product) {
                try{
                    JSONArray laJson = new JSONArray(product.getImagesxx());
                    String sampleImg = laJson.getJSONObject(0).getString("sImageURL");
                    Picasso.get().load(sampleImg).into(imgUnit);
                    lblProdct.setText(product.getModelNme());
                    lblUntPrc.setText(CashFormatter.parse(product.getUnitPrce()));

                    lblDownPy.setText(CashFormatter.parse(mViewModel.getModel().getLsDownPaym()));
                    lblTermxx.setText(mViewModel.getModel().getLsInstallx());
                    lblAmortx.setText(CashFormatter.parse(mViewModel.getModel().getLsAmortztn()));

                    mViewModel.InitializeApplicantInfo(new VMLoanPreview.OnInitializeInfo() {
                        @Override
                        public void OnLoad(String title, String message) {
                            poLoad.initDialog(title, message);
                            poLoad.show();
                        }

                        @Override
                        public void OnSuccess(MpCreditApp args) {
                            poLoad.dismiss();
                            poApp = args;
                        }

                        @Override
                        public void OnFailed(String message) {
                            poLoad.dismiss();
                            poMessage.setButtonText("Okay");
                            poMessage.initDialog("Apply For A Loan", message, () -> poMessage.dismiss());
                            poMessage.show();
                        }
                    });
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        btnSubmit.setOnClickListener(view -> {
            try {
                mViewModel.SubmitApplication(poApp.getData(), new VMLoanPreview.OnSubmitApplication() {
                    @Override
                    public void OnSubmit(String title, String message) {
                        poLoad.initDialog(title, message);
                        poLoad.show();
                    }

                    @Override
                    public void OnSuccess() {
                        poLoad.dismiss();
                        poMessage.setButtonText("Okay");
                        poMessage.initDialog("Apply For A Loan", "Application submitted successfully", new Dialog_SingleButton.OnButtonClick() {
                            @Override
                            public void onClick() {
                                poMessage.dismiss();
                                Activity_LoanTerm.getInstance().finish();
                                finish();
                            }
                        });
                        poMessage.show();
                    }

                    @Override
                    public void OnFailed(String message) {
                        poLoad.dismiss();
                        poMessage.setButtonText("Okay");
                        poMessage.initDialog("Apply For A Loan", message, () -> poMessage.dismiss());
                        poMessage.show();
                    }
                });
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}