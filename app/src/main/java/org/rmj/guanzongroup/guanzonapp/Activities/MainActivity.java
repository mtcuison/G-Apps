package org.rmj.guanzongroup.guanzonapp.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import org.rmj.guanzongroup.guanzonapp.Adapters.ActivityFragmentAdapter;
import org.rmj.guanzongroup.guanzonapp.Adapters.ExpandableListDrawerAdapter;
import org.rmj.guanzongroup.guanzonapp.Adapters.FragmentAdapter;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_ContactUs;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_ShareApp;
import org.rmj.guanzongroup.guanzonapp.Fragments.Branches.Fragment_Branches;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Fragments.Fragment_About;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Notifications;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Promotions;
import org.rmj.guanzongroup.guanzonapp.MeuModel.MenuModel;
import org.rmj.guanzongroup.guanzonapp.MeuModel.PopulateExpandableList;
import org.rmj.guanzongroup.guanzonapp.MeuModel.PrepareData;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMMainActivity;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_NewsFeed;
import org.rmj.guanzongroup.guanzonapp.etc.NonSwipeableViewPager;
import org.rmj.guanzongroup.guanzonapp.etc.appConstants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private VMMainActivity mViewModel;
    private DrawerLayout drawer;


    @SuppressLint("StaticFieldLeak")
    public static ExpandableListDrawerAdapter listAdapter;
    @SuppressLint("StaticFieldLeak")
    public static ExpandableListView expListView;

    public static List<MenuModel> listDataHeader = new ArrayList<>();
    public static HashMap<MenuModel, List<MenuModel>> listDataChild = new HashMap<>();
    private PrepareData prepareData;
    private PopulateExpandableList populateExpandableList;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ActivityFragmentAdapter adapter;
    private final int[] icons ={R.drawable.ic_tab_dashboard_toggled,
            R.drawable.ic_tab_promo_toggled,
            R.drawable.ic_tab_location_toggled,
            R.drawable.ic_tab_info_toggled};

    private String[] tabTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        adapter = new ActivityFragmentAdapter(getSupportFragmentManager());
        try {

            mViewModel = new ViewModelProvider(MainActivity.this).get(VMMainActivity.class);
            mViewModel.isLoggedIn().observe(MainActivity.this, val ->{
                tabTitles = appConstants.getHomeTitles(val);
                ActivityFragmentAdapter adapter = new ActivityFragmentAdapter(getSupportFragmentManager());
                adapter.addFragment(mViewModel.getMainFragment(val));
                adapter.addFragment(mViewModel.getPromoFragment(val));
                adapter.addFragment(new Fragment_Branches());
                adapter.addFragment(new Fragment_About());
                viewPager.setAdapter(adapter);
                tabLayout.setupWithViewPager(viewPager);
                tabLayout.getTabAt(0).setIcon(icons[0]);
                tabLayout.getTabAt(1).setIcon(icons[1]);
                tabLayout.getTabAt(2).setIcon(icons[2]);
                tabLayout.getTabAt(3).setIcon(icons[3]);
                getSupportActionBar().setTitle(tabTitles[0]);
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        tabLayout.getTabAt(tab.getPosition()).setIcon(icons[tab.getPosition()]);
                        getSupportActionBar().setTitle(tabTitles[tab.getPosition()]);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        tabLayout.getTabAt(tab.getPosition()).setIcon(icons[tab.getPosition()]);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
            });

        }catch (NullPointerException e){
            e.printStackTrace();
        }catch (RuntimeException e){
            e.printStackTrace();
        }
    }
    public void initWidgets(){

        toolbar = findViewById(R.id.toolbar_dashboardMain);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);

        viewPager = findViewById(R.id.viewpager_dashboard_fragment_view);
        tabLayout = findViewById(R.id.tablayout_dashboard_fragment_indicator);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;

        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
            expListView.setIndicatorBoundsRelative(width - GetPixelFromDips(50), width - GetPixelFromDips(10));
        }

        prepareData = new PrepareData();
        prepareData.prepareMenuData(this);
        //populateExpandableList();

        populateExpandableList = new PopulateExpandableList();
        populateExpandableList.populate(this, () -> {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Add your menu entries here
        mViewModel.getMenuAction().observe(MainActivity.this, val ->{
            getMenuInflater().inflate(val, menu);
            mViewModel.setMenuBadges(menu);
//            super.onCreateOptionsMenu(menu);
        });

        super.onCreateOptionsMenu(menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_action_item_cart:
                startActivity(new Intent(getApplication(), Activity_ItemCart.class));
                break;
            case R.id.menu_pp_action_contact_us:
            case R.id.menu_action_contact_us:
                new Dialog_ContactUs(getApplication()).showDialog();
                break;
            case R.id.menu_pp_action_share:
                new Dialog_ShareApp(getApplication()).showDialog();
                break;
            case R.id.menu_pp_action_account:
                startActivity(new Intent(getApplication(), Activity_Account.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public int GetPixelFromDips(float pixels) {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            mViewModel.setLogin(true);
        }
    }
}