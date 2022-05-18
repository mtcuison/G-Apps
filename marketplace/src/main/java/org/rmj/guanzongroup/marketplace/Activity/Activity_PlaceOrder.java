package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DItemCart;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_OrderList;
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
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private TextView txtClient, txtMobile, txtAddrss, txtSubTot, txtShipFe, txtOthFee, txtTotalx,
            btnTxtPlc;

    private List<DItemCart.oMarketplaceCartItem> poLstOrder = new ArrayList<>();
    private boolean cIsBuyNow;

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
            popUpCloseConfirmationDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        popUpCloseConfirmationDialog();
    }

    private void getExtras() {
        if(getIntent().hasExtra("cBuyNowxx")) {
            cIsBuyNow = getIntent().getBooleanExtra("cBuyNowxx", true);
        }
    }

    private void initViews() {
        poDialogx = new Dialog_SingleButton(Activity_PlaceOrder.this);
        toolbar = findViewById(R.id.toolbar);
        txtClient = findViewById(R.id.txt_client_name);
        txtMobile = findViewById(R.id.txt_mobile_no);
        txtAddrss = findViewById(R.id.txt_address);
        txtSubTot = findViewById(R.id.txt_sub_total);
        txtShipFe = findViewById(R.id.txt_shipping_fee);
        txtOthFee = findViewById(R.id.txt_other_fee);
        txtTotalx = findViewById(R.id.txt_total_price);
        btnTxtPlc = findViewById(R.id.btnText_place_order);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(Activity_PlaceOrder.this));
        recyclerView.setHasFixedSize(true);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Check Out");
    }

    private void setOrderPreview() {
        setDefaultShipping();
        setDefaultPayMethod();
        setOrderList();
    }

    private void setDefaultShipping() {
        mViewModel.getClientInfo().observe(Activity_PlaceOrder.this, client -> {
            try {
                txtClient.setText(client.getFrstName() + " " + client.getLastName());
                txtMobile.setText(client.getMobileNo());
                mViewModel.getFullAddress(client.getBrgyIDxx()).observe(this, address -> {
                    try {
                        txtAddrss.setText(client.getHouseNox() + " " + client.getAddressx() + ", "
                                + address);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                });
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });
    }

    private void setDefaultPayMethod() {

    }

    private void setOrderList() {
        mViewModel.getCheckoutItems(cIsBuyNow).observe(Activity_PlaceOrder.this, orders -> {
            if(orders != null) {
                poLstOrder = orders;
                final Adapter_OrderList poAdapter = new Adapter_OrderList(orders);
                poAdapter.notifyDataSetChanged();
                recyclerView.setAdapter(poAdapter);
                setBreakdown(orders);
            }
        });
    }

    private void setBreakdown (List<DItemCart.oMarketplaceCartItem> orders) {
        double lnSubTotl = 0.0;
        double lnShipFee = 0.0;
        double lnOthrFee = 0.0;

        if(orders.size() > 0) {
            for(int x = 0; x < orders.size(); x++) {
                lnSubTotl += Double.parseDouble(orders.get(x).nUnitPrce)
                        * Integer.parseInt(orders.get(x).nQuantity);
            }
        }

        double lnTotalPr = lnSubTotl + lnShipFee + lnOthrFee;

        txtSubTot.setText(CashFormatter.parse(String.valueOf(lnSubTotl)));
        txtShipFe.setText(CashFormatter.parse(String.valueOf(lnShipFee)));
        txtOthFee.setText(CashFormatter.parse(String.valueOf(lnOthrFee)));
        txtTotalx.setText(CashFormatter.parse(String.valueOf(lnTotalPr)));
    }

    private void placeOrder () {
        mViewModel.placeOrder(poLstOrder, PaymentMethod.CashOnDelivery, "", cIsBuyNow,
                new OnTransactionsCallback() {
                @Override
                public void onLoading() {
                    poLoading = new Dialog_Loading(Activity_PlaceOrder.this);
                    poLoading.initDialog("Place Order", "Placing Order. Please wait.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Place Order", "Order placed successfully.", dialog -> {
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
        });
    }

    private void popUpCloseConfirmationDialog() {
        Dialog_DoubleButton loDblDiag = new Dialog_DoubleButton(Activity_PlaceOrder.this);
        loDblDiag.setButtonText("Yes", "No");
        loDblDiag.initDialog("Marketplace", "Are you sure you want to cancel placing your order?",
                new Dialog_DoubleButton.OnDialogConfirmation() {
            @Override
            public void onConfirm(AlertDialog dialog) {
                dialog.dismiss();
                mViewModel.cancelBuyNow(cIsBuyNow, new OnTransactionsCallback() {
                    @Override
                    public void onLoading() {
                        poLoading = new Dialog_Loading(Activity_PlaceOrder.this);
                        poLoading.initDialog("Marketplace", "Processing. Please wait.");
                        poLoading.show();
                    }

                    @Override
                    public void onSuccess(String fsMessage) {
                        poLoading.dismiss();
                        finish();
                    }

                    @Override
                    public void onFailed(String fsMessage) {
                        poLoading.dismiss();
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Marketplace", fsMessage, dialog -> dialog.dismiss());
                        poDialogx.show();
                    }
                });
            }

            @Override
            public void onCancel(AlertDialog dialog) {
                dialog.dismiss();
            }
        });
        loDblDiag.show();
    }

}