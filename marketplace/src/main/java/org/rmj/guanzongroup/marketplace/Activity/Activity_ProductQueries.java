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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductQueries;
import org.rmj.guanzongroup.marketplace.ViewModel.VMProductQueries;
import org.rmj.guanzongroup.marketplace.databinding.ActivityProductQueriesBinding;

import java.util.Objects;

public class Activity_ProductQueries extends AppCompatActivity {
    private final String TAG = Activity_ProductQueries.class.getSimpleName();
    private VMProductQueries mViewModel;
    private ActivityProductQueriesBinding mBinding;
    private Dialog_SingleButton poDialogx;
    private String psItemIdx = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityProductQueriesBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mViewModel = new ViewModelProvider(Activity_ProductQueries.this).get(VMProductQueries.class);
        getExtras();

        setSupportActionBar(mBinding.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Asked Questions");

        poDialogx = new Dialog_SingleButton(Activity_ProductQueries.this);

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
        showInquiries();
    }

    private void showProductInfo() {
        mViewModel.getProductInfo(psItemIdx).observe(Activity_ProductQueries.this, product -> {
            try {
                String lsSoldQty = "Sold: " + product.getSoldQtyx();
                String sampleImg = "https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/MHKD3?wid=2000&hei=2000&fmt=jpeg&qlt=95&.v=1623348270000";
                Picasso.get().load(sampleImg).into(mBinding.imgProdct);
                mBinding.txtProdNm.setText(product.getModelNme());
                mBinding.txtSoldQt.setText(lsSoldQty);
                mBinding.txtPricex.setText(CashFormatter.parse(product.getUnitPrce()));
            } catch (NullPointerException e) {
                e.printStackTrace();
                finish();
            }
        });
    }

    private void showInquiries() {
        mViewModel.ImportInquiries(psItemIdx, new VMProductQueries.OnInquiryReviewsImportCallback() {
            @Override
            public void OnImport(String args) {
                try {
                    JSONObject loJson = new JSONObject(args);
                    mBinding.rvQueries.setVisibility(View.VISIBLE);
                    mBinding.lblNoFaqs.setVisibility(View.GONE);
                    Adapter_ProductQueries loAdapter = new Adapter_ProductQueries(
                            getFilteredFaqs(loJson.getJSONArray("detail")),
                            false);
                    loAdapter.notifyDataSetChanged();
                    mBinding.rvQueries.setLayoutManager(new LinearLayoutManager(Activity_ProductQueries.this));
                    mBinding.rvQueries.setHasFixedSize(true);
                    mBinding.rvQueries.setAdapter(loAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                    mBinding.rvQueries.setVisibility(View.GONE);
                    mBinding.lblNoFaqs.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void OnFailed(String message) {
                Log.e(TAG, message);
                mBinding.rvQueries.setVisibility(View.GONE);
                mBinding.lblNoFaqs.setVisibility(View.VISIBLE);
            }
        });
    }

    private JSONArray getFilteredFaqs(JSONArray foArray) {
        JSONArray loArray = new JSONArray();
        for(int x = 0; x < foArray.length(); x++) {
            try {
                if (!foArray.getJSONObject(x).getString("sReplyxxx")
                        .equalsIgnoreCase("null")) {
                    loArray.put(foArray.getJSONObject(x));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return loArray;
    }

}