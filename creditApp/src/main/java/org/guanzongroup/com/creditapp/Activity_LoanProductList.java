package org.guanzongroup.com.creditapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import org.guanzongroup.com.creditapp.Adapter.Adapter_LoanProductList;
import org.guanzongroup.com.creditapp.Obj.MpCreditApp;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanProductList;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;

import java.util.List;
import java.util.Objects;

public class Activity_LoanProductList extends AppCompatActivity {

    private VMLoanProductList mViewModel;

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private MpCreditApp poCredApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_LoanProductList.this).get(VMLoanProductList.class);
        setContentView(R.layout.activity_loan_product_list);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Apply For A Loan");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(Activity_LoanProductList.this, 2, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        mViewModel.getCreditAppData().observe(Activity_LoanProductList.this, mpCreditApp -> {
            try {
                poCredApp = mpCreditApp;
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        findViewById(R.id._lbl).setOnClickListener(v -> {
            try {
                mViewModel.setData(poCredApp);
                mViewModel.StartActivity(Activity_Sample.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        mViewModel.getProductList(0).observe(Activity_LoanProductList.this, products -> {
            try {
                if (products.size() > 0) {
                    Adapter_LoanProductList loAdapter = new Adapter_LoanProductList(products, fsListIdx -> {

                    });
                    recyclerView.setAdapter(loAdapter);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}