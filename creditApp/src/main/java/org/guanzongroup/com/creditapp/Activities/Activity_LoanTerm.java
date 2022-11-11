package org.guanzongroup.com.creditapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.guanzongroup.com.creditapp.Adapter.Adapter_InstallmentPlans;
import org.guanzongroup.com.creditapp.R;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanTerm;
import org.json.JSONArray;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.g3appdriver.lib.CreditApp.model.LoanTerm;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;

import java.util.List;
import java.util.Objects;

public class Activity_LoanTerm extends AppCompatActivity {

    private static Activity_LoanTerm instance;
    private VMLoanTerm mViewModel;
    private Dialog_Loading poLoad;
    private Dialog_SingleButton poMessage;

    private Toolbar toolbar;

    private ImageView imgView;
    private TextView lblProdctx, lblUnitPrc, lblDownPym;

    private RecyclerView recyclerView;

    public static Activity_LoanTerm getInstance(){
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        mViewModel = new ViewModelProvider(Activity_LoanTerm.this).get(VMLoanTerm.class);
        poLoad = new Dialog_Loading(Activity_LoanTerm.this);
        poMessage = new Dialog_SingleButton(Activity_LoanTerm.this);
        setContentView(R.layout.activity_loan_term);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Apply For A Loan");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        imgView = findViewById(R.id.imgProdct);
        lblProdctx = findViewById(R.id.txtProdNm);
        lblUnitPrc = findViewById(R.id.lblUnitPrce);
        lblDownPym = findViewById(R.id.lblDownpaym);

        recyclerView = findViewById(R.id.recyclerView);

        String lsListID = getIntent().getStringExtra("sListngID");
        String lsModlID = getIntent().getStringExtra("sModelIDx");
        mViewModel.GetProductInfo(lsListID).observe(Activity_LoanTerm.this, product -> {
            try{
                JSONArray laJson = new JSONArray(product.getImagesxx());
                String sampleImg = laJson.getJSONObject(0).getString("sImageURL");
                Picasso.get().load(sampleImg).into(imgView);
                lblProdctx.setText(product.getModelNme());
                lblUnitPrc.setText(CashFormatter.parse(product.getUnitPrce()));

                mViewModel.ImportInstallmentPlans(lsModlID, new VMLoanTerm.OnDownloadInstallmentPlan() {
                    @Override
                    public void OnDownload(String title, String message) {
                        poLoad.initDialog(title, message);
                        poLoad.show();
                    }

                    @Override
                    public void OnDownload(List<LoanTerm> args) {
                        poLoad.dismiss();
                        LinearLayoutManager loManager = new LinearLayoutManager(Activity_LoanTerm.this);
                        loManager.setOrientation(RecyclerView.VERTICAL);
                        recyclerView.setLayoutManager(loManager);
                        lblDownPym.setText("Downayment: " + CashFormatter.parse(args.get(0).getnDownPaym()));
                        Adapter_InstallmentPlans loAdapter = new Adapter_InstallmentPlans(args, args1 -> {
                            Intent loIntent = new Intent(Activity_LoanTerm.this, Activity_LoanPreview.class);
                            loIntent.putExtra("sListngID", lsListID);
                            loIntent.putExtra("sUnitAppl", product.getBrandNme());
                            loIntent.putExtra("sModelIDx", args1.getsModelIDx());
                            loIntent.putExtra("sLoanTerm", args1.getsLoanTerm());
                            loIntent.putExtra("sDownPaym", args1.getnDownPaym());
                            loIntent.putExtra("nMonAmort", args1.getnMonAmort());
                            loIntent.putExtra("nDiscount", args1.getnRebatesx());
                            loIntent.putExtra("nMiscExps", args1.getnMiscChrg());
                            startActivity(loIntent);
                        });
                        recyclerView.setAdapter(loAdapter);
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
            startActivity(new Intent(Activity_LoanTerm.this, Activity_LoanProductList.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}