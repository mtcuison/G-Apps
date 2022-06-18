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
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.kofigyan.stateprogressbar.StateProgressBar;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderDetail;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderMaster;
import org.rmj.g3appdriver.etc.DateTimeFormatter;
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
    private TextView lblOrderID,
            lblTrackNox,
            lblAddressx,
            lblClientNm,
            lblMobileNo,
            lblPaymntxx,
            lblDatePlcd,
            lblDlvyDate;

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

        StateProgressBar progressBar = findViewById(R.id.your_state_progress_bar_id);
        progressBar.setStateDescriptionData(descriptionData);
        String lsOrderIDx = getIntent().getStringExtra("sOrderIDx");
        MaterialButton btnPay = findViewById(R.id.btn_Pay);
        recyclerView = findViewById(R.id.recyclerview_Orders);
        lblOrderID = findViewById(R.id.lbl_orderID);
        lblTrackNox = findViewById(R.id.lbl_trackNo);
        lblAddressx = findViewById(R.id.lbl_shipAddress);
        lblClientNm = findViewById(R.id.lbl_clientNm);
        lblMobileNo = findViewById(R.id.lbl_mobileNo);
        lblPaymntxx = findViewById(R.id.lbl_paymnt);
        lblDatePlcd = findViewById(R.id.lbl_datePlace);
        lblDlvyDate = findViewById(R.id.lbl_deliveryDate);
        LinearLayoutManager loManager = new LinearLayoutManager(Activity_Purchases.this);
        loManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(loManager);
        mViewModel.GetDetailOrderHistory(lsOrderIDx).observe(Activity_Purchases.this, foOrder -> {
            try{
                lblOrderID.setText(foOrder.sTransNox);
                lblTrackNox.setText("");
                lblAddressx.setText(foOrder.sAddressx);
                lblClientNm.setText(foOrder.sUserName);
                lblMobileNo.setText(foOrder.sMobileNo);
                lblPaymntxx.setText(foOrder.sTermCode);
                lblDatePlcd.setText("Place on : " + DateTimeFormatter.ParseDateFullyDetailed(foOrder.dTransact));
                lblDlvyDate.setText("Get By : " + DateTimeFormatter.ParseDateForList(foOrder.dExpected));
                btnPay.setOnClickListener(v -> {
                    Intent loIntent = new Intent(Activity_Purchases.this, Activity_PayOrder.class);
                    loIntent.putExtra("sTransNox", foOrder.sTransNox);
                    startActivity(loIntent);
                });
                if(foOrder.cTranStat.equalsIgnoreCase("0")){
                     btnPay.setVisibility(View.VISIBLE);
                } else {
                    btnPay.setVisibility(View.GONE);
                }
                progressBar.setCurrentStateNumber(GetStateNumber(foOrder.cTranStat));
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetOrderedItemsList(lsOrderIDx).observe(Activity_Purchases.this, orderedItemsInfos -> {
            try {
                Adapter_OrderedItems loAdapter = new Adapter_OrderedItems(orderedItemsInfos, args -> {
                    Intent loIntent = new Intent(Activity_Purchases.this, Activity_ProductOverview.class);
                    loIntent.putExtra("sListingId", args);
                    startActivity(loIntent);
                });
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