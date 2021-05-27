package org.rmj.guanzongroup.guanzonapp.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Orders;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.TransactionOrder;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_GCardCodex;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GCardOrders;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Activity_Orders extends AppCompatActivity {
    private static Activity_Orders instance;

    private RecyclerView recyclerView;
    private Adapter_Orders adapter;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_orders);
        setupWidgets();
        setupList();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void setupWidgets(){
        Toolbar toolbar = findViewById(R.id.toolbar_orderItems);
        toolbar.setTitle("Orders");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        layout = findViewById(R.id.linear_emptyList);

        recyclerView = findViewById(R.id.recycler_view_orders);
    }

    private void setupList(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(Activity_Orders.this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        List<TransactionOrder> transactionOrderList = new GCardOrders(Activity_Orders.this).getTransactionOrderList();
        if(transactionOrderList.size() > 0) {
            layout.setVisibility(View.GONE);
            adapter = new Adapter_Orders(Activity_Orders.this, transactionOrderList);
            adapter.setOnOrderQrCodeClickListener(new Adapter_Orders.OnOrderQrCodeClickListener() {
                @Override
                public void OnClick(String BatchNox) {
                    new Dialog_GCardCodex(Activity_Orders.this).showDialog(BatchNox);
                }
            });
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
        } else {
            layout.setVisibility(View.VISIBLE);
        }
    }

    public static Activity_Orders getInstance(){
        return instance;
    }

    public void refreshList(){
        setupList();
        adapter.notifyDataSetChanged();
        Fragment_DashBoard.getInstance().refreshUI();
    }
}
