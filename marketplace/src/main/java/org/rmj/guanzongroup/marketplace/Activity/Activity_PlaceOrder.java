package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPlaceOrder;

import java.util.Objects;

public class Activity_PlaceOrder extends AppCompatActivity {

    private VMPlaceOrder mViewModel;
    private Toolbar toolbar;
    private TextView txtClient, txtMobile, txtAddrss;

    private String psOrdersx = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        mViewModel = new ViewModelProvider(Activity_PlaceOrder.this).get(VMPlaceOrder.class);
        getExtras();
        initViews();
        setUpToolbar();
        setOrderPreview();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void getExtras() {
        psOrdersx = getIntent().getStringExtra("sOrderList");
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        txtClient = findViewById(R.id.txt_client_name);
        txtMobile = findViewById(R.id.txt_mobile_no);
        txtAddrss = findViewById(R.id.txt_address);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Check Out");
    }

    private void setOrderPreview() {
        setDefaultShipping();
    }

    private void setDefaultShipping() {
        mViewModel.getClientInfo().observe(Activity_PlaceOrder.this, client -> {
            try {
                txtClient.setText(client.getFrstName() + " " + client.getLastName());
                txtMobile.setText(client.getMobileNo());
                txtAddrss.setText(client.getHouseNox() + " " + client.getAddressx());

            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });
    }

}