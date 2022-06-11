package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductList;
import org.rmj.guanzongroup.marketplace.ViewModel.VMSearchItem;
import org.rmj.guanzongroup.marketplace.databinding.ActivitySearchItemBinding;

import java.util.List;
import java.util.Objects;

public class Activity_SearchItem extends AppCompatActivity {
    private static final String TAG = Activity_SearchItem.class.getSimpleName();
    private VMSearchItem mViewModel;
    private ActivitySearchItemBinding mBinding;

    private Adapter_ProductList loAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_SearchItem.this).get(VMSearchItem.class);
        mBinding = ActivitySearchItemBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
// Get the intent, verify the action and get the query
        setUpToolbar();
        mBinding.searchview.requestFocus();
        mBinding.searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                displayResult(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        mBinding.recyclrVw.setLayoutManager(new GridLayoutManager(Activity_SearchItem.this,
                2, RecyclerView.VERTICAL, false));
        mBinding.recyclrVw.setHasFixedSize(true);
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

    private void setUpToolbar() {
        setSupportActionBar(mBinding.toolBarxx);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Search Item");
    }

    private void displayResult(String fsQueryxx) {
        mViewModel.RequestProductSearch(fsQueryxx, () -> {
            mViewModel.GetSearchProductList(fsQueryxx).observe(Activity_SearchItem.this, oProducts -> {
                try{
                    if(oProducts.size() > 0) {
                        loAdapter = new Adapter_ProductList(oProducts, fsListIdx -> {
                            Intent loIntent = new Intent(Activity_SearchItem.this, Activity_ProductOverview.class);
                            loIntent.putExtra("sListingId", fsListIdx);
                            startActivity(loIntent);
                        });
                        mBinding.recyclrVw.setAdapter(loAdapter);
                        loAdapter.notifyDataSetChanged();
                    } else {

                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            });
        });
    }
}