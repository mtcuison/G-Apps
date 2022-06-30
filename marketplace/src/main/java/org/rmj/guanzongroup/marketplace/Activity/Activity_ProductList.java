package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.FilterType;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductList;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMProductList;

import java.util.List;

public class Activity_ProductList extends AppCompatActivity {

    private VMProductList mViewModel;

    private Toolbar toolbar;
    private ViewPager viewPager;
    private RecyclerView recyclerView;

    private Adapter_ProductList poAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_ProductList.this).get(VMProductList.class);
        setContentView(R.layout.activity_product_list);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.rv_products);
        recyclerView.setLayoutManager(new GridLayoutManager(Activity_ProductList.this,
                2, RecyclerView.VERTICAL, false));
        String lsBrandNme = getIntent().getStringExtra("xBrandNme");
        toolbar.setTitle(lsBrandNme);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mViewModel.SetProductFilter(new RProduct.oFilterx(FilterType.BRAND_NAME, lsBrandNme, ""));
        mViewModel.GetFilterType().observe(Activity_ProductList.this, oFilterx -> {
            try{
                mViewModel.GetBrandProductList(0, oFilterx.getFilter(), oFilterx.getArgs1()).observe(Activity_ProductList.this, new Observer<List<DProduct.oProduct>>() {
                    @Override
                    public void onChanged(List<DProduct.oProduct> oProducts) {
                        if(oProducts.size() > 0) {
                            poAdapter = new Adapter_ProductList(oProducts, listingId -> {
                                Intent loIntent = new Intent(Activity_ProductList.this, Activity_ProductOverview.class);
                                loIntent.putExtra("sListingId", listingId);
                                startActivity(loIntent);
                            });
                            recyclerView.setAdapter(poAdapter);
                            poAdapter.notifyDataSetChanged();
                        }
                    }
                });
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}