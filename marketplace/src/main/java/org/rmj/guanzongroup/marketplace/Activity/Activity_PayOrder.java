package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;

import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.guanzongroup.marketplace.Fragment.Fragment_PaymentInfo;
import org.rmj.guanzongroup.marketplace.Fragment.Fragment_PaymentSelection;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPaymentSelection;
import org.rmj.guanzongroup.marketplace.databinding.ActivityPayOrderBinding;

import java.util.Objects;

public class Activity_PayOrder extends AppCompatActivity {

    private static Activity_PayOrder instance;
    private ActivityPayOrderBinding binding;

    private String TransNox;
    private String PayMthod;
    private double OrdrAmnt;

    private Fragment[] poPages = new Fragment[] {
            new Fragment_PaymentSelection(),
            new Fragment_PaymentInfo()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = Activity_PayOrder.this;
        setExtra();
//        TransNox = getIntent().getStringExtra("sTransNox");
//        OrdrAmnt = getIntent().getDoubleExtra("nSubTotal", 0.00);
        binding = ActivityPayOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setupWidgets();
    }

    private void setupWidgets(){
        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Order Payment");

        binding.btnSelect.setOnClickListener(v -> {
            Intent loIntent = new Intent(Activity_PayOrder.this, Activity_PaymentConfirmation.class);
            loIntent.putExtra("TransNox", TransNox);
            loIntent.putExtra("oPayMethd", PayMthod);
            loIntent.putExtra("nSubTotal", OrdrAmnt);
            startActivity(loIntent);
        });

        if(PayMthod != null){
            switch (PayMthod){
                case "Maya":
                    binding.rdPayMaya.setChecked(true);
                    break;
                case "GCash":
                    binding.rdGcashxx.setChecked(true);
                    break;
                default:
                    binding.rdCashOnD.setChecked(true);
                    break;
            }
        }

        binding.crdGcashx.setOnClickListener(v -> {
            binding.rdGcashxx.setChecked(true);
        });
        binding.crdPayMya.setOnClickListener(v -> {
            binding.rdPayMaya.setChecked(true);
        });
        binding.crdCashOD.setOnClickListener(v -> {
            binding.rdCashOnD.setChecked(true);
        });
        binding.rdGcashxx.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                binding.rdGcashxx.setChecked(true);
                binding.rdPayMaya.setChecked(false);
                binding.rdCashOnD.setChecked(false);
                PayMthod = PaymentMethod.GCash.toString();
            }
        });
        binding.rdPayMaya.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                binding.rdGcashxx.setChecked(false);
                binding.rdPayMaya.setChecked(true);
                binding.rdCashOnD.setChecked(false);
                PayMthod = PaymentMethod.Maya.toString();
            }
        });
        binding.rdCashOnD.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked) {
                binding.rdGcashxx.setChecked(false);
                binding.rdPayMaya.setChecked(false);
                binding.rdCashOnD.setChecked(true);
                PayMthod = PaymentMethod.CashOnDelivery.toString();
            }
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

    private void setExtra() {
        if(getIntent().hasExtra("sTransNox")) {
            TransNox = getIntent().getStringExtra("sTransNox");
            OrdrAmnt = getIntent().getDoubleExtra("nSubTotal", 0.00);
        }
        if(getIntent().hasExtra("oPayMethd")) {
            PayMthod = getIntent().getStringExtra("oPayMethd");
        }
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

    public static Activity_PayOrder getInstance() {
        return instance;
    }
}