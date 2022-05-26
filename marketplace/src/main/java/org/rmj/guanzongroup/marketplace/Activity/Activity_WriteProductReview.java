package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.ViewModel.VMWriteProductReview;
import org.rmj.guanzongroup.marketplace.databinding.ActivityWriteProductReviewBinding;

public class Activity_WriteProductReview extends AppCompatActivity {

    private VMWriteProductReview mViewModel;
    private ActivityWriteProductReviewBinding mBinding;
    private Dialog_SingleButton poDialogx;

    private String psItemIdx = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new ViewModelProvider(Activity_WriteProductReview.this)
                .get(VMWriteProductReview.class);

        mBinding = ActivityWriteProductReviewBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        poDialogx = new Dialog_SingleButton(this);

        getExtra();
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
        if(getIntent().hasExtra("sListingId")) {
            psItemIdx = getIntent().getStringExtra("sListingId");
        } else {
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Marketplace", "Product does not exist.", d -> {
                d.dismiss();
                finish();
            });
            poDialogx.show();
        }
    }

    private void popUpCloseConfirmationDialog() {
        Dialog_DoubleButton loDblDiag = new Dialog_DoubleButton(Activity_WriteProductReview.this);
        loDblDiag.setButtonText("Yes", "No");
        loDblDiag.initDialog("Product Review", "Are you sure you want to cancel reviewing this product?", new Dialog_DoubleButton.OnDialogConfirmation() {
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
        loDblDiag.show();
    }

}