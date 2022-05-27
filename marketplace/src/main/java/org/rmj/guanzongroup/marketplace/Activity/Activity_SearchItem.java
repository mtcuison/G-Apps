package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMSearchItem;
import org.rmj.guanzongroup.marketplace.databinding.ActivitySearchItemBinding;

import java.util.Objects;

public class Activity_SearchItem extends AppCompatActivity {

    private VMSearchItem mViewModel;
    private ActivitySearchItemBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_SearchItem.this).get(VMSearchItem.class);
        mBinding = ActivitySearchItemBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        setUpToolbar();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setQueryHint("Search Products");
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        return super.onCreateOptionsMenu(menu);
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
//        Adapter_ProductList loAdapter = new Adapter_ProductList()
//        mBinding.recyclrVw.setLayoutManager(new GridLayoutManager(Activity_SearchItem.this,
//                2, RecyclerView.VERTICAL, false));
//        mBinding.recyclrVw.setHasFixedSize(true);
//        mBinding.recyclrVw.setAdapter(poAdapter);
//        poAdapter.notifyDataSetChanged();
    }

}