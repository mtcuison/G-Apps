package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPayOrder;

import java.util.Objects;

public class Activity_PayOrder extends AppCompatActivity {

    private VMPayOrder mViewModel;
    private Toolbar toolBar;
    private String psTransNo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_order);
        mViewModel = new ViewModelProvider(Activity_PayOrder.this).get(VMPayOrder.class);
        initViews();
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        if(requestCode == RESULT_OK) {
            if(intent.hasExtra("sTransNox")) {
                psTransNo = Objects.requireNonNull(intent.getStringExtra("sTransNox"));
            } else {
                finish();
            }
        }
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

    private void initViews() {
//        toolBar = findViewById(R.id.toolbar);
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