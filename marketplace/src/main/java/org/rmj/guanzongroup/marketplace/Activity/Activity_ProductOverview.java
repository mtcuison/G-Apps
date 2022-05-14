package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.utils.Dialogs.BottomDialog_AddToCart;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductDescription;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMProductOverview;
import org.rmj.guanzongroup.useraccount.Activity.Activity_CompleteAccountDetails;
import org.rmj.guanzongroup.useraccount.Activity.Activity_Login;

import java.util.Objects;

public class Activity_ProductOverview extends AppCompatActivity {
    private final AccountInfo poAccount = new AccountInfo(Activity_ProductOverview.this);
    private VMProductOverview mViewModel;
    private Toolbar toolbar;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;
    private LinearLayout poItmSpec;
    private RecyclerView rvItmSpec;
    private TextView txtProdNm, txtUntPrc, txtSoldQt, txtBrandx, txtCatgry, txtColorx, txtStocks,
            txtBriefx;
    private TextView btnAddCrt, btnBuyNow;

    private String psItemIdx = "";
    private String psProduct = "";
    private String psPricexx = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_overview);
        mViewModel = new ViewModelProvider(Activity_ProductOverview.this)
                .get(VMProductOverview.class);
        getExtras();
        initViews();
        setUpToolbar();
        displayData();

        btnAddCrt.setOnClickListener(v -> addToCart());
        btnBuyNow.setOnClickListener(v -> buyNow());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.order_menu, menu);
        return true;
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
        psItemIdx = getIntent().getStringExtra("sListingId");
    }

    private void initViews() {
        poDialogx = new Dialog_SingleButton(Activity_ProductOverview.this);
        toolbar = findViewById(R.id.toolbar);
        poItmSpec = findViewById(R.id.layout_specifications);
        rvItmSpec = findViewById(R.id.rv_specifications);
        rvItmSpec.setLayoutManager(new LinearLayoutManager(Activity_ProductOverview.this));
        rvItmSpec.setHasFixedSize(true);

        txtProdNm = findViewById(R.id.txt_product_name);
        txtUntPrc = findViewById(R.id.txt_product_price);
        txtSoldQt = findViewById(R.id.txt_product_sold_count);
        txtBrandx = findViewById(R.id.txt_brand_name);
        txtCatgry = findViewById(R.id.txt_category);
        txtColorx = findViewById(R.id.txt_variant);
        txtStocks = findViewById(R.id.txt_stocks);
        txtBriefx = findViewById(R.id.txt_brief_desc);

        btnAddCrt = findViewById(R.id.btnText_addToCart);
        btnBuyNow = findViewById(R.id.btnText_buyNow);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    private void displayData() {
        mViewModel.getProductInfo(psItemIdx).observe(Activity_ProductOverview.this, product -> {
            try {
                psProduct = Objects.requireNonNull(product.getModelNme());
                psPricexx = CashFormatter.parse(Objects.requireNonNull(product.getUnitPrce()));

                txtProdNm.setText(Objects.requireNonNull(product.getModelNme()));
                txtUntPrc.setText(CashFormatter.parse(Objects.requireNonNull(product.getUnitPrce())));
                txtSoldQt.setText(Objects.requireNonNull(product.getSoldQtyx()) + " Sold");
                txtBrandx.setText(Objects.requireNonNull(product.getBrandNme()));
                txtCatgry.setText(Objects.requireNonNull(product.getCategrNm()));
                txtColorx.setText(Objects.requireNonNull(product.getColorNme()));
                txtStocks.setText(Objects.requireNonNull(product.getQtyOnHnd()));
                txtBriefx.setText(Objects.requireNonNull(product.getBriefDsc()));
                setFullDescription(Objects.requireNonNull(product.getDescript()));
            } catch (NullPointerException e) {
                e.printStackTrace();
                finish();
            }
        });
    }

    private void setFullDescription(String fsDescrip) {
        try {
            JSONArray loArrayxx = new JSONArray(fsDescrip);
            if(loArrayxx.length() > 0) {
                poItmSpec.setVisibility(View.VISIBLE);
                Adapter_ProductDescription loAdapter = new Adapter_ProductDescription(loArrayxx);
                loAdapter.notifyDataSetChanged();
                rvItmSpec.setAdapter(loAdapter);
            } else {
                poItmSpec.setVisibility(View.GONE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void addToCart() {
        if(isLoggedIn()) {
            final BottomDialog_AddToCart dialog = new BottomDialog_AddToCart(psProduct, psPricexx,
                    fnItemQty -> {
                try {
                    mViewModel.addUpdateCart(psItemIdx, fnItemQty, new OnTransactionsCallback() {
                        @Override
                        public void onLoading() {
                            poLoading = new Dialog_Loading(Activity_ProductOverview.this);
                            poLoading.initDialog("Add to Cart",
                                    "Adding to cart. Please wait.");
                            poLoading.show();
                        }

                        @Override
                        public void onSuccess(String fsMessage) {
                            poLoading.dismiss();
                            poDialogx.setButtonText("Okay");
                            poDialogx.initDialog("Add to Cart",
                                    "Successfully added to cart.",
                                    dialog -> dialog.dismiss());
                            poDialogx.show();
                        }

                        @Override
                        public void onFailed(String fsMessage) {
                            poLoading.dismiss();
                            poDialogx.setButtonText("Okay");
                            poDialogx.initDialog("Add to Cart", fsMessage,
                                    dialog -> dialog.dismiss());
                            poDialogx.show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            dialog.show(getSupportFragmentManager(),"Add To Cart");
        }
    }

    private void buyNow() {
        if(isLoggedIn()) {
            if(poAccount.getClientID().isEmpty()) {
                Intent loIntent = new Intent(Activity_ProductOverview.this,
                        Activity_CompleteAccountDetails.class);
                startActivity(loIntent);
            } else {
                Intent loIntent = new Intent(Activity_ProductOverview.this,
                        Activity_PlaceOrder.class);
                startActivity(loIntent);
            }

        }
    }

    private boolean isLoggedIn() {
        if(!poAccount.getLoginStatus()) {
            Intent loIntent = new Intent(Activity_ProductOverview.this, Activity_Login.class);
            startActivity(loIntent);
            return false;
        } else {
            return true;
        }
    }

}