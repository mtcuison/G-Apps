package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.etc.CashFormatter;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.utils.Dialogs.BottomDialog_AddToCart;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ImageSlider;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductDescription;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductQueries;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductReview;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.Model.HomeImageSliderModel;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMProductOverview;
import org.rmj.guanzongroup.useraccount.Activity.Activity_CompleteAccountDetails;
import org.rmj.guanzongroup.useraccount.Activity.Activity_Login;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Activity_ProductOverview extends AppCompatActivity {
    private AccountInfo poAccount;
    private VMProductOverview mViewModel;
    private Toolbar toolbar;
    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialogx;
    private LinearLayout poItmSpec;
    private SliderView poSliderx;
    private RecyclerView rvItmSpec, rvRatings, rvQueries;
    private ImageView imgPromox;
    private BadgeDrawable loBadge;
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
        poAccount = new AccountInfo(Activity_ProductOverview.this);
        mViewModel = new ViewModelProvider(Activity_ProductOverview.this)
                .get(VMProductOverview.class);
        initViews();
        getExtras();
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
        } else {
            Intent intent = new Intent(Activity_ProductOverview.this, Activity_ItemCart.class);
            intent.putExtra("args", "1");
            startActivity(intent);
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

    private void initViews() {
        poDialogx = new Dialog_SingleButton(Activity_ProductOverview.this);
        toolbar = findViewById(R.id.toolbar);
        poItmSpec = findViewById(R.id.layout_specifications);

        // Image Slider Setup
        poSliderx = findViewById(R.id.imgSlider);
        poSliderx.setIndicatorAnimation(IndicatorAnimationType.WORM);
        poSliderx.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        poSliderx.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        poSliderx.setIndicatorSelectedColor(Color.WHITE);
        poSliderx.setIndicatorUnselectedColor(Color.GRAY);
        poSliderx.setScrollTimeInSec(5);
        poSliderx.startAutoCycle();

        rvItmSpec = findViewById(R.id.rv_specifications);
        rvItmSpec.setLayoutManager(new LinearLayoutManager(Activity_ProductOverview.this));
        rvItmSpec.setHasFixedSize(true);

        rvRatings = findViewById(R.id.rv_ratings);
        rvRatings.setLayoutManager(new LinearLayoutManager(Activity_ProductOverview.this));
        rvRatings.setHasFixedSize(true);

        rvQueries = findViewById(R.id.rv_faqs);
        rvQueries.setLayoutManager(new LinearLayoutManager(Activity_ProductOverview.this));
        rvQueries.setHasFixedSize(true);

        imgPromox = findViewById(R.id.imgPromox);
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

        loBadge = BadgeDrawable.create(Activity_ProductOverview.this);
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    @SuppressLint("UnsafeOptInUsageError")
    private void displayData() {
        mViewModel.GetCartItemCount().observe(Activity_ProductOverview.this, count -> {
            try {
                loBadge.setNumber(count);
                BadgeUtils.attachBadgeDrawable(loBadge, toolbar, R.id.item_cart);
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.getProductInfo(psItemIdx).observe(Activity_ProductOverview.this, product -> {
            try {
                showPromoBanner();
                setImageSlider();
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

                mViewModel.ImportReviews(product.getListngID(), new VMProductOverview.OnInquiryReviewsImportCallback() {
                    @Override
                    public void OnImport(String args) {
                        // TODO:  Set adapter here
                        Adapter_ProductReview loAdapter = new Adapter_ProductReview(args);
                        loAdapter.notifyDataSetChanged();
                        rvRatings.setAdapter(loAdapter);
                    }

                    @Override
                    public void OnFailed(String message) {
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Marketplace", message, dialog -> dialog.dismiss());
                        poDialogx.show();
                    }
                });

                mViewModel.ImportInquiries(product.getListngID(), new VMProductOverview.OnInquiryReviewsImportCallback() {
                    @Override
                    public void OnImport(String args) {
                        try {
                            JSONObject loJson = new JSONObject(args);
                            Adapter_ProductQueries loAdapter = new
                                    Adapter_ProductQueries(loJson.getJSONArray("detail"),
                                    true);
                            loAdapter.notifyDataSetChanged();
                            rvQueries.setAdapter(loAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void OnFailed(String message) {
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Marketplace", message, dialog -> dialog.dismiss());
                        poDialogx.show();
                    }
                });

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

    private void setImageSlider() {
        Adapter_ImageSlider adapter = new Adapter_ImageSlider(Activity_ProductOverview.this,
                getSliderImages());
        poSliderx.setSliderAdapter(adapter);
    }

    private void showPromoBanner() {
        boolean isThereAPromoForItem = true;
        if(isThereAPromoForItem) {
            String sampleUrl = "https://www.toysrus.com.bn/dw/image/v2/BDGJ_PRD/on/demandware.static/-/Sites-storefront-catalog-toysrus-bn/default/dw660375c3/categories/brands/W-Z/zuru-2560x320-2.jpg?q=75";
            imgPromox.setVisibility(View.VISIBLE);
            Picasso.get().load(sampleUrl).into(imgPromox);
        }
    }

    private void addToCart() {
        if(isLoggedIn()) {
            if (poAccount.getClientID().isEmpty()) {
                Intent loIntent = new Intent(Activity_ProductOverview.this,
                        Activity_CompleteAccountDetails.class);
                startActivity(loIntent);
            } else {
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
                dialog.show(getSupportFragmentManager(), "Add To Cart");
            }
        }
    }

    private void buyNow() {
        if(isLoggedIn()) {
            if(poAccount.getClientID().isEmpty()) {
                Intent loIntent = new Intent(Activity_ProductOverview.this,
                        Activity_CompleteAccountDetails.class);
                startActivity(loIntent);
            } else {
                mViewModel.buyNow(psItemIdx, 1, new OnTransactionsCallback() {
                    @Override
                    public void onLoading() {
                        poLoading = new Dialog_Loading(Activity_ProductOverview.this);
                        poLoading.initDialog("Marketplace", "Order processing. Please wait.");
                        poLoading.show();
                    }

                    @Override
                    public void onSuccess(String fsMessage) {
                        poLoading.dismiss();
                        Intent loIntent = new Intent(Activity_ProductOverview.this,
                                Activity_PlaceOrder.class);
                        loIntent.putExtra("cBuyNowxx", true);
                        startActivity(loIntent);
                    }

                    @Override
                    public void onFailed(String fsMessage) {
                        poLoading.dismiss();
                        poDialogx.setButtonText("Okay");
                        poDialogx.initDialog("Marketplace", fsMessage, dialog -> dialog.dismiss());
                        poDialogx.show();
                    }
                });
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

    private List<HomeImageSliderModel> getSliderImages() {
        List<HomeImageSliderModel> loSliders = new ArrayList<>();
        loSliders.add(new HomeImageSliderModel("https://wallpaperaccess.com/full/5043968.jpg"));
        loSliders.add(new HomeImageSliderModel("https://wallpaperaccess.com/full/327367.jpg"));
        loSliders.add(new HomeImageSliderModel("https://wallpaperaccess.com/full/4260890.png"));
        return loSliders;
    }

}