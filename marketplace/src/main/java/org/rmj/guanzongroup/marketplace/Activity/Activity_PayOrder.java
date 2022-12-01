package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import org.rmj.g3appdriver.etc.FragmentAdapter;
import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.guanzongroup.marketplace.Fragment.Fragment_PaymentInfo;
import org.rmj.guanzongroup.marketplace.Fragment.Fragment_PaymentSelection;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPayOrder;
import org.rmj.guanzongroup.marketplace.databinding.ActivityPayOrderBinding;

import java.util.Objects;

public class Activity_PayOrder extends AppCompatActivity {

    private static Activity_PayOrder instance;
    private ActivityPayOrderBinding binding;
    private VMPayOrder mViewModel;

    private String TransNox;

    private double pnOrderAmnt;

    private Fragment[] poPages = new Fragment[] {
            new Fragment_PaymentSelection(),
            new Fragment_PaymentInfo()
    };

    public String getTransNox(){
        return TransNox;
    }

    public double getOrderAmount(){
        return pnOrderAmnt;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = Activity_PayOrder.this;
        TransNox = getIntent().getStringExtra("sTransNox");
        pnOrderAmnt = getIntent().getDoubleExtra("nSubTotal", 0.00);
        mViewModel = new ViewModelProvider(Activity_PayOrder.this).get(VMPayOrder.class);
        binding = ActivityPayOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Order Payment");

        binding.viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), poPages));

        setExtra();
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
            if(getIntent().hasExtra("oPayMethd")) {
                mViewModel.setPaymentMethod((PaymentMethod) Objects.requireNonNull(
                        getIntent().getSerializableExtra("oPayMethd")
                ));
                moveToPageNumber(1);
            }
        } else {
            Toast.makeText(Activity_PayOrder.this, "Cannot find specific transaction.",
                    Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private void popUpCloseConfirmationDialog() {
        if(binding.viewPager.getCurrentItem() > 0) {
            moveToPageNumber(binding.viewPager.getCurrentItem() - 1);
        } else {
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

    public static Activity_PayOrder getInstance() {
        return instance;
    }

    public void moveToPageNumber(int fnPageNum){
        binding.viewPager.setCurrentItem(fnPageNum);
    }

}