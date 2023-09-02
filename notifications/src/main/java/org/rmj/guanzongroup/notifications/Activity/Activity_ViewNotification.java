package org.rmj.guanzongroup.notifications.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import org.json.JSONObject;
import org.rmj.g3appdriver.etc.FragmentAdapter;
import org.rmj.g3appdriver.etc.NonSwipeableViewPager;
import org.rmj.guanzongroup.digitalgcard.Fragment.Fragment_CustomerService;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ProductQueries;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ProductReview;
import org.rmj.guanzongroup.marketplace.Activity.Activity_Purchases;
import org.rmj.guanzongroup.notifications.Fragment.Fragment_EventsPromos;
import org.rmj.guanzongroup.notifications.Fragment.Fragment_ViewMessage;
import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMViewNotification;

import java.util.Objects;

public class Activity_ViewNotification extends AppCompatActivity {
    private static final String TAG = Activity_ViewNotification.class.getSimpleName();

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
            String lsMsgID = getIntent().getStringExtra("sMsgIDxxx");
            String lsMsgTp = getIntent().getStringExtra("sMsgTypex");
            String lsDatax = getIntent().getStringExtra("sDataSent");

            Log.d(TAG, "Notification message ID: " + lsMsgID);
            Log.d(TAG, "Notification message type: " + lsMsgTp);
            Log.d(TAG, "Notification message data: " + lsDatax);

            try{
                Bundle loBundle;
                Intent loIntent;
                JSONObject loJson;
                String psItemIdx, psEntryNo;

                mViewModel.SendReadResponse(lsMsgID, lsMsgTp);

                switch (lsMsgTp) {
                    case "00000":   //Regular Message
                        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), new Fragment[]{new Fragment_ViewMessage()}));
                        break;
                    case "00002":   //Marketplace Order Status
                        Log.d(TAG, "Initializing marketplace order status");
                        loJson = new JSONObject(lsDatax);
                        String lsOrderIDx = loJson.getJSONObject("data").getString("sTransNox");
                        Log.d(TAG, "Marketplace order data: " + lsOrderIDx);
                        loIntent = new Intent(Activity_ViewNotification.this, Activity_Purchases.class);
                        loIntent.putExtra("sOrderIDx", lsOrderIDx);
                        loIntent.putExtra("cReimport", true);
                        startActivity(loIntent);
                        finish();
                        break;
                    case "00003":   //Guanzon Promotions
                        Fragment_EventsPromos loPromos = new Fragment_EventsPromos();
                        loBundle = new Bundle();
                        loPromos.setArguments(loBundle);
                        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), new Fragment[]{loPromos}));
                        break;
                    case "00004":   //Guanzon Events
                        Fragment_EventsPromos loEvent = new Fragment_EventsPromos();
                        loBundle = new Bundle();
                        loEvent.setArguments(loBundle);
                        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), new Fragment[]{new Fragment_EventsPromos()}));
                        break;
                    case "00005":   //Marketplace Product Inquiry
                        Log.d(TAG, "Initializing marketplace order status");
                        loJson = new JSONObject(lsDatax);
                        psItemIdx = loJson.getJSONObject("data").getString("sListngID");
                        psEntryNo = loJson.getJSONObject("data").getString("nEntryNox");
                        Log.d(TAG, "Marketplace product inquiry. Product ID: " + psItemIdx);
                        Log.d(TAG, "Marketplace product inquiry. Inquiry entry No:" + psEntryNo);
                        loIntent = new Intent(Activity_ViewNotification.this, Activity_ProductQueries.class);
                        loIntent.putExtra("sListngId", psItemIdx);
                        loIntent.putExtra("nEntryNox", psEntryNo);
                        startActivity(loIntent);
                        finish();
                        break;
                    case "00006":   //Marketplace Product Review
                        loJson = new JSONObject(lsDatax);
                        psItemIdx = loJson.getJSONObject("data").getString("sListngID");
                        psEntryNo = loJson.getJSONObject("data").getString("nEntryNox");
                        Log.d(TAG, "Marketplace product review. Product ID: " + psItemIdx);
                        Log.d(TAG, "Marketplace product review. Inquiry entry No:" + psEntryNo);
                        loIntent = new Intent(Activity_ViewNotification.this, Activity_ProductReview.class);
                        loIntent.putExtra("sListngId", psItemIdx);
                        loIntent.putExtra("nEntryNox", psEntryNo);
                        startActivity(loIntent);
                        finish();
                        break;
                    default:
                        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), new Fragment[]{new Fragment_CustomerService()}));
                        break;
                }
            } catch (Exception e){
                e.printStackTrace();
            }
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