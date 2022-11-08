package org.guanzongroup.com.creditapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;

import org.guanzongroup.com.creditapp.Adapter.Adapter_InstallmentPlans;
import org.guanzongroup.com.creditapp.R;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanTerm;
import org.rmj.g3appdriver.lib.CreditApp.model.LoanTerm;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;

import java.util.List;
import java.util.Objects;

public class Activity_LoanTerm extends AppCompatActivity {

    private VMLoanTerm mViewModel;
    private Dialog_Loading poLoad;
    private Dialog_SingleButton poMessage;

    private Toolbar toolbar;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_LoanTerm.this).get(VMLoanTerm.class);
        poLoad = new Dialog_Loading(Activity_LoanTerm.this);
        poMessage = new Dialog_SingleButton(Activity_LoanTerm.this);
        setContentView(R.layout.activity_loan_term);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Apply For A Loan");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        String lsListID = getIntent().getStringExtra("sListngID");
        mViewModel.ImportInstallmentPlans(lsListID, new VMLoanTerm.OnDownloadInstallmentPlan() {
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
                Adapter_InstallmentPlans loAdapter = new Adapter_InstallmentPlans(args, new Adapter_InstallmentPlans.OnItemClick() {
                    @Override
                    public void onClick(String fsListIdx) {

                    }
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