package org.rmj.guanzongroup.notifications.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.rmj.guanzongroup.notifications.Adapter.Adapter_Notifications;
import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMNotifications;

public class Activity_NotificationList extends AppCompatActivity {
    private static final String TAG = Activity_NotificationList.class.getSimpleName();

    private VMNotifications mViewModel;
    private TextView noNotif;
    private RecyclerView recyclerView;
    private Adapter_Notifications adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_NotificationList.this).get(VMNotifications.class);
        setContentView(R.layout.activity_notification_list);
        noNotif = findViewById(R.id.lbl_no_notifications);
        recyclerView = findViewById(R.id.recycler_view_notifications);

        LinearLayoutManager layoutManager = new LinearLayoutManager(Activity_NotificationList.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(Activity_NotificationList.this, DividerItemDecoration.VERTICAL));
        mViewModel.GetClientNotificationList().observe(Activity_NotificationList.this, notif ->{
            if(notif.size() > 0){
                noNotif.setVisibility(View.GONE);
                adapter = new Adapter_Notifications(notif, (fsMesgIDxx, fsMesgType) -> {
                    Intent loIntent = new Intent(Activity_NotificationList.this, Activity_ViewNotification.class);
                    loIntent.putExtra("sMsgIDxxx", fsMesgIDxx);
                    startActivity(loIntent);
                });
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }else{
                noNotif.setVisibility(View.VISIBLE);
            }
        });
    }
}