package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductReview;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMProductReview;
import org.rmj.guanzongroup.marketplace.databinding.ActivityProductReviewBinding;

import java.util.Objects;

public class Activity_ProductReview extends AppCompatActivity {
    private static final String TAG = Activity_ProductOverview.class.getSimpleName();
    private VMProductReview mViewModel;
    private ActivityProductReviewBinding mBinding;
    private Dialog_SingleButton poDialogx;
    private String psItemIdx = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_ProductReview.this).get(VMProductReview.class);
        mBinding = ActivityProductReviewBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        getExtras();

        setSupportActionBar(mBinding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Product Review");

        poDialogx = new Dialog_SingleButton(Activity_ProductReview.this);

        displayData();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void getExtras() {
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

    private void displayData() {
        showProductInfo();
        showReviews();
    }

    private void showProductInfo() {
        mViewModel.getProductInfo(psItemIdx).observe(Activity_ProductReview.this, product -> {
            try {
                String lsSoldQty = "Sold: " + product.getSoldQtyx();
                String sampleImg = "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/MHKD3?wid=2000&hei=2000&fmt=jpeg&qlt=95&.v=1623348270000";
                Picasso.get().load(sampleImg).into(mBinding.imgProdct);
                mBinding.txtProdNm.setText(product.getModelNme());
                mBinding.txtSoldQt.setText(lsSoldQty);
                mBinding.ratingBar.setRating(4.5f);
            } catch (NullPointerException e) {
                e.printStackTrace();
                finish();
            }
        });
    }

    private void showReviews() {
        mViewModel.ImportReviews(psItemIdx, new VMProductReview.OnInquiryReviewsImportCallback() {
            @Override
            public void OnImport(String args) {
                try {
                    mBinding.rvRatings.setVisibility(View.VISIBLE);
                    mBinding.lblNoRevs.setVisibility(View.GONE);
                    JSONObject loJson = new JSONObject(args);
                    Adapter_ProductReview loAdapter = new
                            Adapter_ProductReview(loJson.getJSONArray("detail"),
                            false);
                    loAdapter.notifyDataSetChanged();
                    mBinding.rvRatings.setLayoutManager(new LinearLayoutManager(Activity_ProductReview.this));
                    mBinding.rvRatings.setHasFixedSize(true);
                    mBinding.rvRatings.setAdapter(loAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                    mBinding.rvRatings.setVisibility(View.GONE);
                    mBinding.lblNoRevs.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void OnFailed(String message) {
                Log.e(TAG, message);
                mBinding.rvRatings.setVisibility(View.GONE);
                mBinding.lblNoRevs.setVisibility(View.VISIBLE);
            }
        });
    }

}