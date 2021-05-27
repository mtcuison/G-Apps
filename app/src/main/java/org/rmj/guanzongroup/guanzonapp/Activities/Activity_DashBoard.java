package org.rmj.guanzongroup.guanzonapp.Activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import org.rmj.guanzongroup.guanzonapp.Adapters.ActivityFragmentAdapter;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_ContactUs;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_ShareApp;
import org.rmj.guanzongroup.guanzonapp.Dialogs.MessageBox;
import org.rmj.guanzongroup.guanzonapp.Fragments.Branches.Fragment_Branches;
import org.rmj.guanzongroup.guanzonapp.Fragments.Fragment_About;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.App_Notifications;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.Services.ActionBroadCaster;
import org.rmj.guanzongroup.guanzonapp.etc.DashBoardIconBadge;
import org.rmj.guanzongroup.guanzonapp.etc.Dashboard_TabAsset;

public class Activity_DashBoard extends AppCompatActivity {
    private static final String TAG = Activity_DashBoard.class.getSimpleName();
    @SuppressLint("StaticFieldLeak")
    private static Activity_DashBoard instance;

    private ActionBroadCaster actionBroadCaster = new ActionBroadCaster();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private BadgeDrawable tabBadge;
    private Context mContext = this;
    private MessageBox messageDialog;
    private boolean isDialogShow = false;

    private DashBoardIconBadge dashBoardIconBadge;

    private int[] tabIcons;
    private int[] tabToggledIcons;

    private String[] tabTitles =
            {"Client Portal",
            "Promos",
            "Find Us",
            "About Us"};


    public static Activity_DashBoard getInstance(){ return instance; }

    public void setDialogShow(boolean IsDialogShow){
        isDialogShow = IsDialogShow;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        /*if(!isDialogShow) {
            new Event_Reminder(mContext).showPromoEventReminder();
        }*/
        setContentView(R.layout.activity_dash_board);
        messageDialog = new MessageBox(mContext);
        dashBoardIconBadge = new DashBoardIconBadge(mContext);
        setupWidgets();
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SUCCESS_LOGIN");
        registerReceiver(actionBroadCaster, intentFilter);
        Log.e(TAG, "Login action receiver has been registered.");
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(actionBroadCaster);
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        messageDialog.setDialogMessage("Are you sure you want to exit?");
        messageDialog.setMessageType(MessageBox.MessageType.WARNING);
        messageDialog.setPositiveButton("Yes", new MessageBox.onMessageBoxButtonClick() {
            @Override
            public void onClick(View view, AlertDialog dialog) {
                dialog.dismiss();
                System.exit(1);
            }
        });
        messageDialog.setNegativeButton("No", new MessageBox.onMessageBoxButtonClick() {
            @Override
            public void onClick(View view, AlertDialog dialog) {
                dialog.dismiss();
            }
        });
        messageDialog.showDialog();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(dashBoardIconBadge.getMenuAction(), menu);
        dashBoardIconBadge.setMenuBadges(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_action_item_cart:
                startActivity(new Intent(mContext, Activity_ItemCart.class));
                break;
            case R.id.menu_pp_action_contact_us:
            case R.id.menu_action_contact_us:
                new Dialog_ContactUs(mContext).showDialog();
                break;
            case R.id.menu_pp_action_share:
                new Dialog_ShareApp(mContext).showDialog();
                break;
            case R.id.menu_pp_action_account:
                startActivity(new Intent(mContext, Activity_Account.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void setupWidgets(){
        toolbar = findViewById(R.id.toolbar_dashboardMain);
        toolbar.setTitle("Dashboard");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        Dashboard_TabAsset tabAsset = new Dashboard_TabAsset(mContext);
        tabIcons = tabAsset.tabIcon();
        tabToggledIcons = tabAsset.tabIconToggled();

        ViewPager viewPager = findViewById(R.id.viewpager_dashboard_fragment_view);
        tabLayout = findViewById(R.id.tablayout_dashboard_fragment_indicator);

        ActivityFragmentAdapter adapter = new ActivityFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(dashBoardIconBadge.getMainFragment());
        adapter.addFragment(dashBoardIconBadge.getPromoFragment());
        adapter.addFragment(new Fragment_Branches());
        adapter.addFragment(new Fragment_About());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(tabToggledIcons[0]);
        tabBadge = tabLayout.getTabAt(1).getOrCreateBadge();
        tabBadge.setNumber(new App_Notifications(mContext).getUnreadNotificationCount());
        tabBadge.setVisible(getVisibility(new App_Notifications(mContext).getUnreadNotificationCount()));
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        setupTablayoutListener();
    }

    private void setupTablayoutListener(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).setIcon(tabToggledIcons[tab.getPosition()]);
                toolbar.setTitle(tabTitles[tab.getPosition()]);
                setSupportActionBar(toolbar);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).setIcon(tabIcons[tab.getPosition()]);
                toolbar.setTitle(tabTitles[tab.getPosition()]);
                setSupportActionBar(toolbar);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private boolean getVisibility(int count){
        return count > 0;
    }

    public void refreshTabBadge(){
        tabBadge.setNumber(new App_Notifications(mContext).getUnreadNotificationCount());
        tabBadge.setVisible(getVisibility(new App_Notifications(mContext).getUnreadNotificationCount()));
    }
}
