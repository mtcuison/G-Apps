package org.rmj.guanzongroup.marketplace.Activity;

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

import com.google.android.material.tabs.TabLayout;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderDetail;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_OrderHistory;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMOrders;

import java.util.List;
import java.util.Objects;

public class Activity_Purchases extends AppCompatActivity {

    private Toolbar toolbar;

    private VMOrders mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_Purchases.this).get(VMOrders.class);
        setContentView(R.layout.activity_purchases);

        toolbar = findViewById(R.id.toolbar_purchases);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        String lsOrderIDx = getIntent().getStringExtra("sOrderIDx");
        mViewModel.GetOrderHistoryDetail(lsOrderIDx).observe(Activity_Purchases.this, orderHistoryDetails -> {
            try{

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