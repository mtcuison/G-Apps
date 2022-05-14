package org.rmj.guanzongroup.marketplace.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.marketplace.Adapter.ActivityFragmentAdapter;
import org.rmj.guanzongroup.marketplace.Fragment.Fragment_GCardItemCart;
import org.rmj.guanzongroup.marketplace.Fragment.Fragment_MPItemCart;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMHome;
import org.rmj.guanzongroup.marketplace.ViewModel.VMItemCart;

public class Activity_ItemCart extends AppCompatActivity {
    private VMItemCart mViewModel;
    private ViewPager viewPager;
    private View view;
    private TabLayout tabLayout;
    private ActivityFragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_cart);
        initWidgets();
        setupTabLayoutListener();
        mViewModel = new ViewModelProvider(Activity_ItemCart.this).get(VMItemCart.class);
        mViewModel.GetActiveGCard().observe(Activity_ItemCart.this, new Observer<EGcardApp>() {
            @Override
            public void onChanged(EGcardApp eGcardApp) {
                try {

                    adapter.addFragment(new Fragment_MPItemCart());
                    if (eGcardApp != null) {
                        adapter.addFragment(new Fragment_GCardItemCart());

                    }

                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        adapter.notifyDataSetChanged();
        tabLayout.getTabAt(0).setText("MarketPlace");
        if (tabLayout.getTabCount() > 1){

            tabLayout.getTabAt(1).setText("GCard");
        }
//        tabLayout.getTabAt(0).setIcon(tabIconsToggled[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }
    private void initWidgets(){
        tabLayout = findViewById(R.id.tabLayout_item_cart_fragment_indicator);
        viewPager = findViewById(R.id.viewpager_fragment_item_cart);
        adapter = new ActivityFragmentAdapter(getSupportFragmentManager());

    }

    private void setupTabLayoutListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsToggled[tab.getPosition()]);
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
}