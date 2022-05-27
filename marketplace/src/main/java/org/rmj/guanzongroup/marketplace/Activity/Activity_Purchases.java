package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.kofigyan.stateprogressbar.StateProgressBar;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderDetail;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_OrderedItems;
import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMOrders;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Activity_Purchases extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private VMOrders mViewModel;

    String[] descriptionData = {"Processing", "Verified", "Shipping", "Delivered"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_Purchases.this).get(VMOrders.class);
        setContentView(R.layout.activity_purchases);

        toolbar = findViewById(R.id.toolbar_purchases);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        StateProgressBar progressBar = (StateProgressBar) findViewById(R.id.your_state_progress_bar_id);
        progressBar.setStateDescriptionData(descriptionData);
        String lsOrderIDx = getIntent().getStringExtra("sOrderIDx");
        recyclerView = findViewById(R.id.recyclerview_Orders);
        LinearLayoutManager loManager = new LinearLayoutManager(Activity_Purchases.this);
        loManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(loManager);
        mViewModel.GetOrderMaster(lsOrderIDx).observe(Activity_Purchases.this, eOrderMaster -> {
            try{
                progressBar.setCurrentStateNumber(GetStateNumber(eOrderMaster.getTranStat()));
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetOrderedItemsList(lsOrderIDx).observe(Activity_Purchases.this, orderedItemsInfos -> {
            try {
                Adapter_OrderedItems loAdapter = new Adapter_OrderedItems(orderedItemsInfos);
                recyclerView.setAdapter(loAdapter);
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

    private StateProgressBar.StateNumber GetStateNumber(String fsVal){
        switch (fsVal){
            case "0":
                return StateProgressBar.StateNumber.ONE;
            case "1":
                return StateProgressBar.StateNumber.TWO;
            case "2":
                return StateProgressBar.StateNumber.THREE;
            case "3":
                return StateProgressBar.StateNumber.FOUR;
            default:
                return StateProgressBar.StateNumber.FIVE;
        }
    }
}