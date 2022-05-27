package org.rmj.guanzongroup.notifications.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.etc.FragmentAdapter;
import org.rmj.g3appdriver.etc.NonSwipeableViewPager;
import org.rmj.guanzongroup.marketplace.Fragment.Fragment_OrderStatus;
import org.rmj.guanzongroup.notifications.Fragment.Fragment_ActionNotification;
import org.rmj.guanzongroup.notifications.Fragment.Fragment_ViewMessage;
import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMViewNotification;

import java.util.Objects;

public class Activity_ViewNotification extends AppCompatActivity {

    private Toolbar toolbar;
    private NonSwipeableViewPager viewPager;
    private VMViewNotification mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_notification);
        mViewModel = new ViewModelProvider(Activity_ViewNotification.this).get(VMViewNotification.class);
        toolbar = findViewById(R.id.toolbar_notification);
        viewPager = findViewById(R.id.viewpager_notification);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        if(getIntent().hasExtra("sMsgIDxxx")){
            mViewModel.GetNotificationInfo(getIntent().getStringExtra("sMsgIDxxx")).observe(Activity_ViewNotification.this, new Observer<DNotifications.ClientNotificationInfo>() {
                @Override
                public void onChanged(DNotifications.ClientNotificationInfo clientNotificationInfo) {
                    try{
                        if ("00000".equals(clientNotificationInfo.MsgTypex)) {
                            if (!clientNotificationInfo.DataInfo.isEmpty()) {
                                JSONObject loJson = new JSONObject(clientNotificationInfo.DataInfo);
                                Bundle loBundle = new Bundle();
                                if(loJson.has("data")) {
                                    loBundle.putString("sOrderInfo", loJson.getJSONObject("data").toString());
                                }
                                Fragment_OrderStatus loFragment = new Fragment_OrderStatus();
                                loFragment.setArguments(loBundle);
                                getSupportFragmentManager().beginTransaction().replace(R.id.viewpager_notification, loFragment, "SAMPLE");
                                viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), new Fragment[]{loFragment}));
                            } else {
                                viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), new Fragment[]{new Fragment_ViewMessage()}));
                            }
                        } else {
                            viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), new Fragment[]{new Fragment_ActionNotification()}));
                        }
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}