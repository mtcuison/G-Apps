package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DItemCart;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_OrderList;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPlaceOrder;
import org.rmj.guanzongroup.useraccount.Activity.Activity_AddressUpdate;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Activity_PlaceOrder extends AppCompatActivity {

    private VMPlaceOrder mViewModel;
    private Dialog_SingleButton poDialogx;
    private Dialog_Loading poLoading;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private TextView txtClient, txtMobile,
            txtShipAddrss,
            txtBillAddrss,
            txtSubTot,
            txtShipFe,
            txtOthFee,
            txtTotalx,
            btnTxtPlc;

    private List<DItemCart.oMarketplaceCartItem> poLstOrder = new ArrayList<>();
    private boolean cIsBuyNow;

    private double nSubTotl = 0.0,
                   nShipFee = 0.0,
                   nOthrFee = 0.0;

    public boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        mViewModel = new ViewModelProvider(Activity_PlaceOrder.this).get(VMPlaceOrder.class);
        getExtras();
        initViews();
        setUpToolbar();
        setOrderPreview();

        findViewById(R.id.lbl_chg_ship_address).setOnClickListener(v -> {
            Intent loIntent = new Intent(Activity_PlaceOrder.this, Activity_AddressUpdate.class);
            loIntent.putExtra("sAddUpdte", "shipping");
            startActivity(loIntent);
        });

        findViewById(R.id.lbl_chg_bill_address).setOnClickListener(v -> {
            Intent loIntent = new Intent(Activity_PlaceOrder.this, Activity_AddressUpdate.class);
            loIntent.putExtra("sAddUpdte", "billing");
            startActivity(loIntent);
        });

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
        poLoading = new Dialog_Loading(Activity_PlaceOrder.this);
        poDialogx = new Dialog_SingleButton(Activity_PlaceOrder.this);
        toolbar = findViewById(R.id.toolbar);
        txtClient = findViewById(R.id.txt_client_name);
        txtMobile = findViewById(R.id.txt_mobile_no);
        txtBillAddrss = findViewById(R.id.txt_bill_address);
        txtShipAddrss = findViewById(R.id.txt_ship_address);
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
        setOrderList();
    }

    private void setDefaultShipping() {
        mViewModel.getClientBSAddress().observe(Activity_PlaceOrder.this, clientBSAddress -> {
            try{
                String lsBillAdd = "";
                if(!clientBSAddress.sHouseNo1.isEmpty()){
                    lsBillAdd = clientBSAddress.sHouseNo1 + ", ";
                }
                if(!clientBSAddress.sAddress1.isEmpty()){
                    lsBillAdd = lsBillAdd + clientBSAddress.sAddress1 + ", ";
                }
                lsBillAdd = lsBillAdd + clientBSAddress.sBrgyNme1 + ", " +
                        clientBSAddress.sTownNme1 + ", " +
                        clientBSAddress.sProvNme1;
                txtBillAddrss.setText(lsBillAdd);

                String lsShipAdd = "";
                if(!clientBSAddress.sHouseNo2.isEmpty()){
                    lsShipAdd = clientBSAddress.sHouseNo2 + ", ";
                }
                if(!clientBSAddress.sAddress2.isEmpty()){
                    lsShipAdd = lsShipAdd + clientBSAddress.sAddress2 + ", ";
                }
                lsShipAdd = lsShipAdd + clientBSAddress.sBrgyNme2 + ", " +
                        clientBSAddress.sTownNme2 + ", " +
                        clientBSAddress.sProvNme2;
                txtShipAddrss.setText(lsShipAdd);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
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

        mViewModel.GetSelectedItemCartTotalPrice().observe(Activity_PlaceOrder.this, subtotal -> {
            try{
                txtSubTot.setText(CashFormatter.parse(String.valueOf(subtotal)));
                nSubTotl = subtotal;
                txtTotalx.setText(CashFormatter.parse(String.valueOf(CalculateGrandTotal())));
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetShippingFee().observe(Activity_PlaceOrder.this, shipFee -> {
            try{
                txtShipFe.setText(CashFormatter.parse(String.valueOf(shipFee)));
                nShipFee = shipFee;
                txtTotalx.setText(CashFormatter.parse(String.valueOf(CalculateGrandTotal())));
            } catch (Exception e){
                e.printStackTrace();
            }
        });

//        txtSubTot.setText(CashFormatter.parse(String.valueOf(lnSubTotl)));
//        txtShipFe.setText(CashFormatter.parse(String.valueOf(lnShipFee)));
        txtOthFee.setText(CashFormatter.parse(String.valueOf(lnOthrFee)));
        txtTotalx.setText(CashFormatter.parse(String.valueOf(CalculateGrandTotal())));
    }

    private void placeOrder () {
        mViewModel.placeOrder(poLstOrder, cIsBuyNow, new OnTransactionsCallback() {
            @Override
            public void onLoading() {
                poLoading = new Dialog_Loading(Activity_PlaceOrder.this);
                poLoading.initDialog("Place Order", "Placing Order. Please wait.");
                poLoading.show();
                isClicked = false;
            }

            @Override
            public void onSuccess(String fsMessage) {
                poLoading.dismiss();
                Intent loIntent = new Intent(Activity_PlaceOrder.this, Activity_PayOrder.class);
                loIntent.putExtra("sTransNox", fsMessage);
                loIntent.putExtra("nSubTotal", nSubTotl);
                loIntent.putExtra("nShipFeex", nShipFee);
                startActivity(loIntent);
                finish();
            }

            @Override

            public void onFailed(String fsMessage) {
                poLoading.dismiss();
                poDialogx.setButtonText("Okay");
                poDialogx.initDialog("Place Order", fsMessage, () -> poDialogx.dismiss());
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
                        poDialogx.initDialog("Marketplace", fsMessage, () -> poDialogx.dismiss());
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

    private double CalculateGrandTotal(){
        return nSubTotl + nShipFee + nOthrFee;
    }
}