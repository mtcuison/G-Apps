package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.kofigyan.stateprogressbar.StateProgressBar;

import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.DateTimeFormatter;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_TextInput;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_OrderedItems;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMOrders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            lblDlvyDate,
            lblCancelUs,
            lblCancelRm,
            lblCancelDt;

    private CardView cvCanclDetl;
    private MaterialButton btnCancel;

    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;

    private VMOrders mViewModel;

    String[] descriptionData = {"Processing", "Verified", "Shipping", "Delivered"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_Purchases.this).get(VMOrders.class);
        setContentView(R.layout.activity_purchases);

        toolbar = findViewById(R.id.toolbar_purchases);
        toolbar.setTitle("Order Detail");
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
        lblCancelUs = findViewById(R.id.lbl_userCancel);
        lblCancelRm = findViewById(R.id.lbl_cancellationRemarks);
        lblCancelDt = findViewById(R.id.lbl_cancellationDate);
        cvCanclDetl = findViewById(R.id.cv_cancellation_detail);
        btnCancel = findViewById(R.id.btn_cancel);
        LinearLayoutManager loManager = new LinearLayoutManager(Activity_Purchases.this);
        loManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(loManager);

        if(getIntent().hasExtra("cReimport")){
            mViewModel.ImportOrdersTask();
        }

        mViewModel.GetDetailOrderHistory(lsOrderIDx).observe(Activity_Purchases.this, foOrder -> {
            try{
                if(foOrder == null) {
                    findViewById(R.id.lblNoOrderInfo).setVisibility(View.VISIBLE);
                } else {
                    findViewById(R.id.scrollView).setVisibility(View.VISIBLE);
                    if(foOrder.sTermCode.equalsIgnoreCase("C001002")){

                    } else if(foOrder.nAmtPaidx != null){
                        double lnTotal = Double.parseDouble(foOrder.nTranTotl);
                        double lnAmntx = Double.parseDouble(foOrder.nAmtPaidx);

                        if(lnTotal > lnAmntx){
                            btnPay.setVisibility(View.VISIBLE);
                        } else {
                            btnPay.setVisibility(View.GONE);
                        }
                    }

                    if (!foOrder.cTranStat.equalsIgnoreCase("3")) {
                        toolbar.setTitle("Order Detail");
                        progressBar.setVisibility(View.VISIBLE);
                        progressBar.setCurrentStateNumber(GetStateNumber(foOrder.cTranStat));
                    } else {
                        toolbar.setTitle("Cancellation Detail");
                        btnCancel.setVisibility(View.GONE);
                        mViewModel.CheckCancellationDetail(foOrder.sTransNox, new VMOrders.OnCheckCancellationCallback() {
                            @Override
                            public void OnCheck(String dTransact, String sClientNm, String sRemarksx) {
                                cvCanclDetl.setVisibility(View.VISIBLE);
                                lblCancelUs.setText(sClientNm);
                                lblCancelRm.setText(sRemarksx);
                                lblCancelDt.setText(getDate(dTransact));
                            }

                            @Override
                            public void OnFailed(String message) {
                                Toast.makeText(Activity_Purchases.this, message, Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    lblOrderID.setText(foOrder.sTransNox);
                    lblTrackNox.setText("");
                    lblAddressx.setText(foOrder.sAddressx);
                    lblClientNm.setText(foOrder.sUserName);
                    lblMobileNo.setText(foOrder.sMobileNo);
                    lblPaymntxx.setText(AppConstants.parseTermCode(foOrder.sTermCode));
                    lblDatePlcd.setText("Place on : " + DateTimeFormatter.ParseDateFullyDetailed(foOrder.dTransact));
                    lblDlvyDate.setText("Get By : " + DateTimeFormatter.ParseDateForList(foOrder.dExpected));
                    btnPay.setOnClickListener(v -> {
                        Intent loIntent = new Intent(Activity_Purchases.this, Activity_PayOrder.class);
                        loIntent.putExtra("sTransNox", foOrder.sTransNox);
                        startActivity(loIntent);
                    });

                    mViewModel.GetOrderedItemsList(lsOrderIDx).observe(Activity_Purchases.this, orderedItemsInfos -> {
                        try {
                            Adapter_OrderedItems loAdapter = new Adapter_OrderedItems(orderedItemsInfos, args -> {
                                Intent loIntent = new Intent(Activity_Purchases.this, Activity_ProductOverview.class);
                                loIntent.putExtra("sListngId", args);
                                startActivity(loIntent);
                            }, args -> {
                                Intent loIntent = new Intent(Activity_Purchases.this, Activity_WriteProductReview.class);
                                loIntent.putExtra("sTransNox", foOrder.sTransNox);
                                loIntent.putExtra("sListngId", args);
                                startActivity(loIntent);
                            });
                            loAdapter.setForReview(foOrder.cTranStat.equalsIgnoreCase("4"));
                            recyclerView.setAdapter(loAdapter);
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                    });
                }

            } catch (Exception e){
                e.printStackTrace();
            }
        });
        btnCancel.setOnClickListener(v -> {
            Dialog_TextInput loDialog = new Dialog_TextInput(Activity_Purchases.this);
            loDialog.initDialog("Remarks", new Dialog_TextInput.OnDialogConfirmation() {
                @Override
                public void onConfirm(String fsInputx, AlertDialog dialog) {
                    dialog.dismiss();
                    poLoading = new Dialog_Loading(Activity_Purchases.this);
                    poDialogx = new Dialog_SingleButton(Activity_Purchases.this);
                    mViewModel.CancelOrder(lsOrderIDx, fsInputx, new VMOrders.OnCancelCallback() {
                        @Override
                        public void OnLoad() {
                            poLoading.initDialog("Order Cancellation", "Processing order cancellation. Please wait...");
                            poLoading.show();
                        }

                        @Override
                        public void OnSuccess(String args) {
                            poLoading.dismiss();
                            poDialogx.setButtonText("Okay");
                            poDialogx.initDialog("Order Cancellation", args, () -> {
                                poDialogx.dismiss();
                                Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
                                intent.putExtra("args", "purchase");
                                sendBroadcast(intent);
                            });
                            poDialogx.show();
                        }

                        @Override
                        public void OnFailed(String message) {
                            poLoading.dismiss();
                            poDialogx.setButtonText("Okay");
                            poDialogx.initDialog("Order Cancellation", message, () -> poDialogx.dismiss());
                            poDialogx.show();
                        }
                    });
                }

                @Override
                public void onCancel(AlertDialog dialog) {
                    dialog.dismiss();
                }
            });
            loDialog.show();
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
            case "4":
                return StateProgressBar.StateNumber.FOUR;
            default:
                return StateProgressBar.StateNumber.FIVE;
        }
    }

    private String getDate(String val){
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
        String formattedDate = null;
        try {
            formattedDate = formatter.format(fromUser.parse(val));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }
}