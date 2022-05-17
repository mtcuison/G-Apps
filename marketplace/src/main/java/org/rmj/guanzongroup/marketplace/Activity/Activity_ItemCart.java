package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.digitalgcard.Fragment.Fragment_Redeemables;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMRedeemables;
import org.rmj.guanzongroup.marketplace.Adapter.ActivityFragmentAdapter;
import org.rmj.guanzongroup.marketplace.Fragment.Fragment_GCardItemCart;
import org.rmj.guanzongroup.marketplace.Fragment.Fragment_MPItemCart;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMHome;
import org.rmj.guanzongroup.marketplace.ViewModel.VMItemCart;

import java.util.List;

public class Activity_ItemCart extends AppCompatActivity {
    String TAG = Activity_ItemCart.class.getSimpleName();
    private VMGCardSystem mViewModel;
    private VMRedeemables vmRedeemables;
    private ViewPager viewPager;
    private View view;
    private TabLayout tabLayout;
    private ActivityFragmentAdapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_cart);
        initWidgets();

        try{
            mViewModel = new ViewModelProvider(this).get(VMGCardSystem.class);
//            mViewModel.GetActiveGCard().observe(this, new Observer<EGcardApp>() {
//                @Override
//                public void onChanged(EGcardApp eGcardApp) {
//                    try {
//                        adapter.clear();
//                        adapter.addFragment(new Fragment_MPItemCart());
//                        adapter.addTitle("MarketPlace");
//                        if (eGcardApp != null) {
//                            adapter.addFragment(new Fragment_GCardItemCart());
//                            adapter.addTitle("GCard");
//                        }
//                        viewPager.setAdapter(adapter);
//                        tabLayout.setupWithViewPager(viewPager);
//                        adapter.notifyDataSetChanged();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
            if(getIntent().getStringExtra("args").equalsIgnoreCase("1")){
                getSupportActionBar().setTitle("Item Cart");
                mViewModel.getActiveGcard().observe(this, new Observer<EGcardApp>() {
                    @Override
                    public void onChanged(EGcardApp eGcardApp) {
                        try {
                            adapter.clear();
                            adapter.addFragment(new Fragment_MPItemCart());
                            adapter.addTitle("MarketPlace");
                            if (eGcardApp != null) {
                                adapter.addFragment(new Fragment_GCardItemCart());
                                adapter.addTitle("GCard");
                            }
                            viewPager.setAdapter(adapter);
                            tabLayout.setupWithViewPager(viewPager);
                            adapter.notifyDataSetChanged();
                            tabLayout.setVisibility(View.VISIBLE);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }else {
                getSupportActionBar().setTitle("Redeemables");
                adapter.clear();
                adapter.addFragment(new Fragment_Redeemables());
                viewPager.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                tabLayout.setVisibility(View.GONE);
            }
        }catch (NullPointerException e){
            Log.e(TAG, e.getMessage());
        }
    }
    @SuppressLint("NewApi")
    private void initWidgets(){
        toolbar = findViewById(R.id.toolbar_item_cart);
        tabLayout = findViewById(R.id.tabLayout_item_cart_fragment_indicator);
        viewPager = findViewById(R.id.viewpager_fragment_item_cart);
        adapter = new ActivityFragmentAdapter(getSupportFragmentManager());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupTabLayoutListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                tabLayout.getTabAt(tab.getPosition()).setIcon(tabToggledIcons[tab.getPosition()]);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                tabLayout.getTabAt(tab.getPosition()).setIcon(tabIcons[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

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