package org.rmj.guanzongroup.notifications.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import org.rmj.guanzongroup.notifications.Adapter.Adapter_Notifications;
import org.rmj.guanzongroup.notifications.Adapter.Adapter_RegularMessage;
import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMNotifications;

public class Activity_GuanzonPanalo extends AppCompatActivity {
    private VMNotifications mViewModel;
    private RecyclerView recyclerView;
    private ConstraintLayout ln_empty;

    private Toolbar toolbar;
    private Adapter_Notifications adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_GuanzonPanalo.this).get(VMNotifications.class);
        setContentView(R.layout.activity_guanzon_panalo);
        setupWidgets();
        toolbar.setTitle("Guanzon Panalo");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        LinearLayoutManager layoutManager = new LinearLayoutManager(Activity_GuanzonPanalo.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(Activity_GuanzonPanalo.this, DividerItemDecoration.VERTICAL));

        mViewModel.GetPanaloRegularMessagesSystemNotif().observe(Activity_GuanzonPanalo.this, notif -> {
            if (notif.size() > 0) {
                ln_empty.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                adapter = new Adapter_Notifications(notif, (fsMesgIDxx, lsCreated, fsMesgType, lsDataSent) -> {
                    if (!fsMesgType.equalsIgnoreCase("00000")) {
                        Intent loIntent = new Intent(Activity_GuanzonPanalo.this, Activity_ViewNotification.class);
                        loIntent.putExtra("sMsgIDxxx", fsMesgIDxx);
                        loIntent.putExtra("sMsgTypex", fsMesgType);
                        loIntent.putExtra("sDataSent", lsDataSent);
                        startActivity(loIntent);
                    } else {
                        Intent loIntent = new Intent(Activity_GuanzonPanalo.this, Activity_PreviewMessage.class);
                        loIntent.putExtra("sCreatedx", lsCreated);
                        startActivity(loIntent);
                    }
                });

//                adapter = new Adapter_RegularMessage(notif);

                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            } else {
                ln_empty.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            }
        });

    }
    private void setupWidgets() {
        toolbar = findViewById(R.id.toolbar_panalo);
        recyclerView = findViewById(R.id.recyclerview);
        ln_empty = findViewById(R.id.ln_empty);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}