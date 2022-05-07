package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductDescription;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMProductOverview;

import java.util.Objects;

public class Activity_ProductOverview extends AppCompatActivity {
    private VMProductOverview mViewModel;
    private Toolbar toolbar;
    private LinearLayout poItmSpec;
    private RecyclerView rvItmSpec;
    private TextView txtProdNm, txtUntPrc, txtSoldQt, txtBrandx, txtCatgry, txtColorx, txtStocks,
            txtBriefx;

    private String psItemIdx = "";

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
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
    }

    private void displayData() {
        mViewModel.getProductInfo(psItemIdx).observe(Activity_ProductOverview.this, product -> {
            try {
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

}