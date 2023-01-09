package org.rmj.guanzongroup.marketplace.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_TextInput;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPaymentConfirmation;

import java.util.Locale;

public class Activity_PaymentConfirmation extends AppCompatActivity {

    private VMPaymentConfirmation mViewModel;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;

    private MaterialButton btnConfrm;
    private TextView txtPayTyp, txtAccNme, txtMobile, lblCodAmount, lblPayAmount, lblSendThru, lblOrderAmount;
    private CardView cardviewPaymentInfo;
    private LinearLayout linearCod;

    private String TransNox;
    private String PayMthod;
    private double OrdrAmnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_PaymentConfirmation.this).get(VMPaymentConfirmation.class);
        poLoading = new Dialog_Loading(Activity_PaymentConfirmation.this);
        poDialogx = new Dialog_SingleButton(Activity_PaymentConfirmation.this);
        setContentView(R.layout.activity_payment_confirmation);
        setupWidgets();
        PayMthod = getIntent().getStringExtra("oPayMethd");
        TransNox = getIntent().getStringExtra("TransNox");
        OrdrAmnt = getIntent().getDoubleExtra("nSubTotal", 0.00);

        btnConfrm.setOnClickListener(v -> {
            if(PayMthod.equalsIgnoreCase(PaymentMethod.CashOnDelivery.toString())){
                InitCashOnDelivery();
                Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
                intent.putExtra("args", "purchase");
                sendBroadcast(intent);
                Activity_PayOrder.getInstance().finish();
                finish();
            } else {
                payOrder();
            }
        });

        txtPayTyp.setText(PayMthod);
        if(PayMthod.equalsIgnoreCase(PaymentMethod.CashOnDelivery.toString())){
            lblSendThru.setVisibility(View.GONE);

            mViewModel.payOrder(TransNox, PaymentMethod.CashOnDelivery,
                    "", new OnTransactionsCallback() {
                        @Override
                        public void onLoading() {
                            poLoading.initDialog("Pay Order", "Payment Processing. Please wait.");
                            poLoading.show();
                        }

                        @Override
                        public void onSuccess(String fsMessage) {
                            poLoading.dismiss();
                            cardviewPaymentInfo.setVisibility(View.GONE);
                            linearCod.setVisibility(View.VISIBLE);
                            btnConfrm.setText("Continue Shopping");
                            if(getIntent().hasExtra("nSubTotal")){
                                lblOrderAmount.setText(CashFormatter.parse(String.valueOf(OrdrAmnt)));
                                lblCodAmount.setText(CashFormatter.parse(String.valueOf(OrdrAmnt)));
                            }
                        }

                        @Override
                        public void onFailed(String fsMessage) {
                            poLoading.dismiss();
                            poDialogx.setButtonText("Okay");
                            poDialogx.initDialog("Pay Order", fsMessage, () -> poDialogx.dismiss());
                            poDialogx.show();
                        }
                    });
        } else {
            lblCodAmount.setText(CashFormatter.parse(String.valueOf(OrdrAmnt)));
            lblPayAmount.setText("To complete your purchase please deposit ₱" + OrdrAmnt + " to " + PayMthod + " account shown below.");
            cardviewPaymentInfo.setVisibility(View.VISIBLE);
            linearCod.setVisibility(View.GONE);
            mViewModel.CheckPaymentMethods(new OnTransactionsCallback() {
                @Override
                public void onLoading() {
                    poLoading.initDialog("Pay Order", "Retrieving payment options. Please wait.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                    try {
                        JSONObject loJson = new JSONObject(fsMessage);
                        JSONArray laJson = loJson.getJSONArray("detail");
                        for(int x = 0; x < laJson.length(); x++){
                            JSONObject loDetail = laJson.getJSONObject(x);
                            String lsBankCde = loDetail.getString("sBankCode");
                            if(lsBankCde.toLowerCase(Locale.ROOT).equalsIgnoreCase(PayMthod)) {
                                txtAccNme.setText(loDetail.getString("sActNamex"));
                                txtMobile.setText(loDetail.getString("sActNumbr"));
                                break;
                            }
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Pay Order", fsMessage, () -> poDialogx.dismiss());
                    poDialogx.show();
                }
            });
        }
    }

    private void InitCashOnDelivery(){
        mViewModel.payOrder(TransNox,
                PaymentMethod.CashOnDelivery,
                "", new OnTransactionsCallback() {
            @Override
            public void onLoading() {
                poLoading.initDialog("Pay Order", "Payment Processing. Please wait.");
                poLoading.show();
            }

            @Override
            public void onSuccess(String fsMessage) {
                poLoading.dismiss();
                cardviewPaymentInfo.setVisibility(View.GONE);
                linearCod.setVisibility(View.VISIBLE);
                btnConfrm.setText("Continue Shopping");
                if(getIntent().hasExtra("nSubTotal")){
                    lblOrderAmount.setText(CashFormatter.parse(String.valueOf(OrdrAmnt)));
                    lblCodAmount.setText(CashFormatter.parse(String.valueOf(OrdrAmnt)));
                }
            }

            @Override
            public void onFailed(String fsMessage) {
                poLoading.dismiss();
                poDialogx.setButtonText("Okay");
                poDialogx.initDialog("Pay Order", fsMessage, () -> poDialogx.dismiss());
                poDialogx.show();
            }
        });
    }

    private void payOrder(){
        final Dialog_TextInput loDialog = new Dialog_TextInput(Activity_PaymentConfirmation.this);
        loDialog.initDialog("Reference Number", new Dialog_TextInput.OnDialogConfirmation() {
            @Override
            public void onConfirm(String fsInputx, AlertDialog dialog) {
                if(!fsInputx.isEmpty()) {
                    String lsRefNoxx = fsInputx;
                    dialog.dismiss();
                    mViewModel.payOrder(TransNox,
                            getPaymentMethod(PayMthod),
                            lsRefNoxx, new OnTransactionsCallback() {
                                @Override
                                public void onLoading() {
                                    poLoading = new Dialog_Loading(Activity_PaymentConfirmation.this);
                                    poLoading.initDialog("Pay Order", "Payment Processing. Please wait.");
                                    poLoading.show();
                                }

                                @Override
                                public void onSuccess(String fsMessage) {
                                    poLoading.dismiss();
                                    poDialogx.setButtonText("Okay");
                                    poDialogx.initDialog("Pay Order", fsMessage, () -> {
                                        poDialogx.dismiss();
                                        Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
                                        intent.putExtra("args", "purchase");
                                        sendBroadcast(intent);
                                        Activity_PayOrder.getInstance().finish();
                                        finish();
                                    });
                                    poDialogx.show();
                                }

                                @Override
                                public void onFailed(String fsMessage) {
                                    poLoading.dismiss();
                                    poDialogx.setButtonText("Okay");
                                    poDialogx.initDialog("Pay Order", fsMessage, () -> poDialogx.dismiss());
                                    poDialogx.show();
                                }
                            });
                } else {
                    dialog.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Pay Order",
                            "Please enter payment reference number.", () -> poDialogx.dismiss());
                    poDialogx.show();
                }
            }

            @Override
            public void onCancel(AlertDialog dialog) {
                dialog.dismiss();
            }
        });
        loDialog.show();
    }

    private PaymentMethod getPaymentMethod(String args){
        switch (args){
            case "Maya":
                return PaymentMethod.Maya;
            case "GCash":
                return PaymentMethod.GCash;
            default:
                return null;
        }
    }

    private void setupWidgets(){
        btnConfrm = findViewById(R.id.btnConfrm);
        txtPayTyp = findViewById(R.id.txtPayTyp);
        txtAccNme = findViewById(R.id.txtAccNme);
        txtMobile = findViewById(R.id.txtMobile);
        lblCodAmount = findViewById(R.id.lbl_codAmount);
        lblPayAmount = findViewById(R.id.lbl_payAmount);
        lblSendThru = findViewById(R.id.lbl_SendThru);
        lblOrderAmount = findViewById(R.id.lbl_orderAmount);
        cardviewPaymentInfo = findViewById(R.id.cardview_payment_info);
        linearCod = findViewById(R.id.linear_cod);
    }

    @Override
    public void onBackPressed() {
        if(PayMthod.equalsIgnoreCase(PaymentMethod.CashOnDelivery.toString())){
            InitCashOnDelivery();
            Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
            intent.putExtra("args", "purchase");
            sendBroadcast(intent);
            Activity_PayOrder.getInstance().finish();
            finish();
        } else {
            finish();
        }
    }
}