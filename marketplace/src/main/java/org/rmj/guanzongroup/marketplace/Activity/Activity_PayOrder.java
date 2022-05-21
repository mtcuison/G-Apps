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

    private Fragment[] poPages = new Fragment[] {
            new Fragment_PaymentSelection(),
            new Fragment_PaymentInfo()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPayOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        instance = Activity_PayOrder.this;
        mViewModel = new ViewModelProvider(Activity_PayOrder.this).get(VMPayOrder.class);

        setSupportActionBar(binding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Pay Order");

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
            mViewModel.setTransactionNumber(Objects.requireNonNull(getIntent().getStringExtra("sTransNox")));
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

    private void moveToPageNumber(int fnPageNum){
        binding.viewPager.setCurrentItem(fnPageNum);
    }

}