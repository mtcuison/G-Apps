package org.rmj.guanzongroup.notifications.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import org.rmj.guanzongroup.marketplace.Activity.Activity_Purchases;
import org.rmj.guanzongroup.notifications.Adapter.Adapter_RegularMessage;
import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMNotifications;

import java.util.Objects;

public class Activity_PreviewMessage extends AppCompatActivity {
    private static final String TAG = Activity_PreviewMessage.class.getSimpleName();

    private VMNotifications mViewModel;

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_PreviewMessage.this).get(VMNotifications.class);
        setContentView(R.layout.activity_preview_message);

        toolbar = findViewById(R.id.toolbar_notification);
        recyclerView = findViewById(R.id.recyclerView);

        if(getIntent().hasExtra("sCreatedx")){
            String lsTitle = getIntent().getStringExtra("sCreatedx");
            if(lsTitle == null || lsTitle.isEmpty()){
                toolbar.setTitle("System Notification");
                findViewById(R.id.linear).setVisibility(View.GONE);
            }
            setSupportActionBar(toolbar);
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        }

        mViewModel.GetRegularMessagesSystemNotif().observe(Activity_PreviewMessage.this, regularMessages -> {
            try{
                Adapter_RegularMessage loAdapter = new Adapter_RegularMessage(regularMessages);
                loAdapter.setOnActionClickListener((module, args) -> {
                    Log.d(TAG, module);
                    Log.d(TAG, args);

                    Intent loIntent;

                    switch (module){
                        case "00005":
//                            Intent loIntent = new Intent(Activity_PreviewMessage.this)
                            break;
                        case "00003":
                            loIntent = new Intent(Activity_PreviewMessage.this, Activity_Purchases.class);
                            loIntent.putExtra("sOrderIDx", args);
                            loIntent.putExtra("cReimport", true);
                            startActivity(loIntent);
                            break;
                    }
                });
                LinearLayoutManager loManager = new LinearLayoutManager(Activity_PreviewMessage.this);
                loManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(loManager);
                recyclerView.setAdapter(loAdapter);
            } catch (Exception e){
                e.printStackTrace();
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