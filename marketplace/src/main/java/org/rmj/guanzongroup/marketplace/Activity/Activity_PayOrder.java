package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_TextInput;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPayOrder;

import java.util.Objects;

public class Activity_PayOrder extends AppCompatActivity {

    private VMPayOrder mViewModel;
    private Toolbar toolBar;
    private Dialog_SingleButton poDialogx;
    private Dialog_Loading poLoading;
    private RecyclerView recyclerView;
    private MaterialButton btnPayOrd;

    private PaymentMethod poPayMeth;
    private String psTransNo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_order);
        mViewModel = new ViewModelProvider(Activity_PayOrder.this).get(VMPayOrder.class);
        getExtra();
        initViews();
        setUpToolbar();
        displayPaymentOptions();

        btnPayOrd.setOnClickListener(v -> {
            if(isMethodSelected()) { payOrder(); }
        });
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

    private void getExtra() {
        if(getIntent().hasExtra("sTransNox")) {
            psTransNo = Objects.requireNonNull(getIntent().getStringExtra("sTransNox"));
        } else {
            Toast.makeText(Activity_PayOrder.this, "Cannot find specific transaction.",
                    Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void initViews() {
        toolBar = findViewById(R.id.toolbar);
        poDialogx = new Dialog_SingleButton(Activity_PayOrder.this);
        recyclerView = findViewById(R.id.recyclerView);
        btnPayOrd = findViewById(R.id.btnPayOrder);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pay Order");
    }

    private void displayPaymentOptions() {

    }

    private void payOrder() {
        final Dialog_TextInput loDialog = new Dialog_TextInput(Activity_PayOrder.this);
        loDialog.initDialog("Reference Number", new Dialog_TextInput.OnDialogConfirmation() {
            @Override
            public void onConfirm(String fsInputx, AlertDialog dialog) {
                if(!fsInputx.isEmpty()) {
                    dialog.dismiss();
                    mViewModel.payOrder(psTransNo, poPayMeth, fsInputx, new OnTransactionsCallback() {
                        @Override
                        public void onLoading() {
                            poLoading = new Dialog_Loading(Activity_PayOrder.this);
                            poLoading.initDialog("Pay Order", "Payment Processing. Please wait.");
                            poLoading.show();
                        }

                        @Override
                        public void onSuccess(String fsMessage) {
                            poLoading.dismiss();
                            poDialogx.setButtonText("Okay");
                            poDialogx.initDialog("Pay Order", fsMessage, dialog1 -> {
                                dialog1.dismiss();
                                finish();
                            });
                            poDialogx.show();
                        }

                        @Override
                        public void onFailed(String fsMessage) {
                            poLoading.dismiss();
                            poDialogx.setButtonText("Okay");
                            poDialogx.initDialog("Pay Order", fsMessage, dialog1 -> dialog1.dismiss());
                            poDialogx.show();
                        }
                    });
                } else {
                    dialog.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Pay Order",
                            "Please enter payment reference number.", dialog1 -> {
                        dialog1.dismiss();
                    });
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

    private boolean isMethodSelected() {
        if(poPayMeth == null) {
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Pay Order",
                    "Please select payment method for your order.", dialog -> {
                        dialog.dismiss();
                    });
            poDialogx.show();
            return false;
        }
        return true;
    }

    private void popUpCloseConfirmationDialog() {
        Dialog_DoubleButton poDblDiag = new Dialog_DoubleButton(Activity_PayOrder.this);
        poDblDiag.setButtonText("Yes", "No");
        poDblDiag.initDialog("Order Payment", "Are you sure you want to cancel payment?", new Dialog_DoubleButton.OnDialogConfirmation() {
            @Override
            public void onConfirm(AlertDialog dialog) {
                dialog.dismiss();
                finish();
            }

            @Override
            public void onCancel(AlertDialog dialog) {
                dialog.dismiss();
            }
        });
        poDblDiag.show();
    }

}