package org.rmj.guanzongroup.notifications.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.rmj.guanzongroup.notifications.Adapter.Adapter_Fragment;
import org.rmj.guanzongroup.notifications.Adapter.Adapter_Notifications;
import org.rmj.guanzongroup.notifications.Fragment.Fragment_Notification;
import org.rmj.guanzongroup.notifications.Fragment.Fragment_Panalo;
import org.rmj.guanzongroup.notifications.Fragment.Fragment_Promotion;
import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMNotifications;

import java.util.ArrayList;
import java.util.List;

public class Activity_NotificationList extends AppCompatActivity {
    private static final String TAG = Activity_NotificationList.class.getSimpleName();


    private Adapter_Fragment mAdapter;
    private ViewPager mPager;

    private VMNotifications mViewModel;
    private TabLayout tabLayout_NotifList;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TextView noNotif;
    private RecyclerView recyclerView;
    private Adapter_Notifications adapter;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_NotificationList.this).get(VMNotifications.class);
        setContentView(R.layout.activity_notification_list);
        initViews();
        toolbar.setTitle("Notifications");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAdapter = new Adapter_Fragment(getSupportFragmentManager());
        mAdapter.addFragment(new Fragment_Notification());
        mAdapter.addFragment(new Fragment_Promotion());
        mAdapter.addFragment(new Fragment_Panalo());
        mAdapter.addTitle("Notification");
        mAdapter.addTitle("Promotions");
        mAdapter.addTitle("Guanzon Panalo");

        viewPager.setAdapter(mAdapter);
        tabLayout_NotifList.setupWithViewPager(viewPager);


        LinearLayoutManager layoutManager = new LinearLayoutManager(Activity_NotificationList.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(Activity_NotificationList.this, DividerItemDecoration.VERTICAL));
        mViewModel.GetClientNotificationList().observe(Activity_NotificationList.this, notif -> {
            if (notif.size() > 0) {
                noNotif.setVisibility(View.GONE);
                adapter = new Adapter_Notifications(notif, (fsMesgIDxx, lsCreated, fsMesgType, lsDataSent) -> {
                    if (!fsMesgType.equalsIgnoreCase("00000")) {
                        Intent loIntent = new Intent(Activity_NotificationList.this, Activity_ViewNotification.class);
                        loIntent.putExtra("sMsgIDxxx", fsMesgIDxx);
                        loIntent.putExtra("sMsgTypex", fsMesgType);
                        loIntent.putExtra("sDataSent", lsDataSent);
                        startActivity(loIntent);
                    } else {
                        Intent loIntent = new Intent(Activity_NotificationList.this, Activity_PreviewMessage.class);
                        loIntent.putExtra("sCreatedx", lsCreated);
                        startActivity(loIntent);
                    }
                });
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            } else {
                noNotif.setVisibility(View.VISIBLE);
            }
        });
    }


    private void initViews() {
        toolbar = findViewById(R.id.toolbar_notification);
        noNotif = findViewById(R.id.lbl_no_notifications);
        recyclerView = findViewById(R.id.recycler_view_notifications);

        tabLayout_NotifList = findViewById(R.id.tablayout_notifList);
        viewPager = findViewById(R.id.Notif_viewPager);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}