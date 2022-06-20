package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.ViewModel.VMWriteProductReview;
import org.rmj.guanzongroup.marketplace.databinding.ActivityWriteProductReviewBinding;

import java.util.Objects;

public class Activity_WriteProductReview extends AppCompatActivity {

    private VMWriteProductReview mViewModel;
    private ActivityWriteProductReviewBinding mBinding;
    private Dialog_SingleButton poDialogx;
    private Dialog_Loading poLoading;

    private String psItemIdx = "", psOrderID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_WriteProductReview.this)
                .get(VMWriteProductReview.class);

        mBinding = ActivityWriteProductReviewBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        poDialogx = new Dialog_SingleButton(this);
        poLoading = new Dialog_Loading(this);

        getExtra();
        setProductDetails();
        mBinding.ratingBar.setMax(5);
        mBinding.btnSaveRv.setOnClickListener(v -> saveReview());
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
            psOrderID = getIntent().getStringExtra("sTransNox");
        } else {
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Marketplace", "Product does not exist.", d -> {
                d.dismiss();
                finish();
            });
            poDialogx.show();
        }
    }

    private void setProductDetails() {
        mViewModel.getProductInfo(psItemIdx).observe(Activity_WriteProductReview.this, eProduct -> {
            try {
                // mBinding.imgProdct.setImageBitmap(Objects.requireNonNull());
                mBinding.txtProdNm.setText(Objects.requireNonNull(eProduct.getModelNme()));
                mBinding.txtPricex.setText(Objects.requireNonNull(eProduct.getUnitPrce()));
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });
    }

    private void saveReview() {
        if(mBinding.txtReview.getText().toString().trim().isEmpty()) {
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Product Review", "Please enter a product review.", dialog -> {
                dialog.dismiss();
            });
            poDialogx.show();
        } else {
            String lsReviewx = mBinding.txtReview.getText().toString().trim();
            mViewModel.saveReview(psOrderID, psItemIdx, mBinding.ratingBar.getNumStars(), lsReviewx,
                    new OnTransactionsCallback() {
                @Override
                public void onLoading() {
                    poLoading.initDialog("Product Review", "Processing. Please wait.");
                    poLoading.show();
                }

                @Override
                public void onSuccess(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Product Review", fsMessage, dialog -> {
                        dialog.dismiss();
                        finish();
                    });
                    poDialogx.show();
                }

                @Override
                public void onFailed(String fsMessage) {
                    poLoading.dismiss();
                    poDialogx.setButtonText("Okay");
                    poDialogx.initDialog("Product Review", fsMessage, dialog -> {
                        dialog.dismiss();
                    });
                    poDialogx.show();
                }
            });
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