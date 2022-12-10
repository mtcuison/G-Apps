package org.rmj.guanzongroup.digitalgcard.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import org.rmj.guanzongroup.digitalgcard.Fragment.Fragment_GCardItemCart;
import org.rmj.guanzongroup.digitalgcard.Fragment.Fragment_GcardOrders;
import org.rmj.guanzongroup.digitalgcard.R;

import java.util.ArrayList;
import java.util.List;

public class Activity_Orders extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Orders");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout = findViewById(R.id.tabLayout_item_cart_fragment_indicator);
        viewPager = findViewById(R.id.viewpager_fragment_item_cart);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private static class FragmentAdapter extends FragmentStatePagerAdapter {

        private List<Fragment> loFragments = new ArrayList<>();
        private List<String> lsTitles = new ArrayList<>();

        public FragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
            loFragments.add(new Fragment_GCardItemCart());
            loFragments.add(new Fragment_GcardOrders());
            lsTitles.add("Item Cart");
            lsTitles.add("Orders");
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return loFragments.get(position);
        }

        @Override
        public int getCount() {
            return loFragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return lsTitles.get(position);
        }
    }
}