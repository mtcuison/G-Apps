package org.rmj.guanzongroup.marketplace.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMProductList;

public class Activity_ProductList extends AppCompatActivity {

    private VMProductList mViewModel;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_ProductList.this).get(VMProductList.class);
        setContentView(R.layout.activity_product_list);
    }
}