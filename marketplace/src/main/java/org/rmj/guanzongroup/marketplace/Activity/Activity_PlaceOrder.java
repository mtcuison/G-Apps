package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.Entities.EItemCart;
import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPlaceOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Activity_PlaceOrder extends AppCompatActivity {

    private VMPlaceOrder mViewModel;
    private Dialog_SingleButton poDialogx;
    private Dialog_Loading poLoading;
    private Toolbar toolbar;
    private TextView txtClient, txtMobile, txtAddrss, btnTxtPlc;

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

        btnTxtPlc.setOnClickListener(v -> placeOrder());
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
        poDialogx = new Dialog_SingleButton(Activity_PlaceOrder.this);
        toolbar = findViewById(R.id.toolbar);
        txtClient = findViewById(R.id.txt_client_name);
        txtMobile = findViewById(R.id.txt_mobile_no);
        txtAddrss = findViewById(R.id.txt_address);
        btnTxtPlc = findViewById(R.id.btnText_place_order);
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

    private void placeOrder() {
        try {
            JSONObject loJson = new JSONObject(psOrdersx);
            if(loJson != null) {
                mViewModel.placeOrder(
                        getOrderList(loJson.getJSONArray("orders")),
                        PaymentMethod.CashOnDelivery,
                        "",
                        !loJson.getBoolean("fromCart"),
                        new OnTransactionsCallback() {
                            @Override
                            public void onLoading() {
                                poLoading = new Dialog_Loading(Activity_PlaceOrder.this);
                                poLoading.initDialog("Place Order",
                                        "Placing Order. Please wait.");
                                poLoading.show();
                            }

                            @Override
                            public void onSuccess(String fsMessage) {
                                poLoading.dismiss();
                                poDialogx.setButtonText("Okay");
                                poDialogx.initDialog("Place Order",
                                        "Order placed successfully.", dialog -> {
                                    dialog.dismiss();
                                    finish();
                                });
                                poDialogx.show();
                            }

                            @Override
                            public void onFailed(String fsMessage) {
                                poLoading.dismiss();
                                poDialogx.setButtonText("Okay");
                                poDialogx.initDialog("Place Order", fsMessage, dialog -> {
                                    dialog.dismiss();
                                });
                                poDialogx.show();
                            }
                        }
                );
            }
        } catch(JSONException e) {
            e.printStackTrace();
        }
    }

    private List<EItemCart> getOrderList(JSONArray foArray) {
        List<EItemCart> loItems = new ArrayList<>();
        if(foArray != null && foArray.length() > 0) {
            for(int x = 0; x < foArray.length(); x++) {
                try {
                    EItemCart loItem = new EItemCart();
                    JSONObject loJson = foArray.getJSONObject(x);

                    loItem.setListIDxx(loJson.getString("sListingId"));
                    loItem.setQuantity(String.valueOf(loJson.getInt("nQuantityx")));

                    loItems.add(loItem);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return loItems;
    }

}