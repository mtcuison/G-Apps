package org.rmj.guanzongroup.guanzonapp.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.splashscreen.SplashScreen;
import androidx.lifecycle.ViewModelProvider;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.Service.GMessagingService;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMSplashScreen;

public class Activity_SplashScreen extends AppCompatActivity {
    private static final String TAG = Activity_SplashScreen.class.getSimpleName();

    private VMSplashScreen mViewModel;

    private static final int REQUEST_PERMISSION = 1;

    private ActivityResultLauncher<String[]> poRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMSplashScreen.class);
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        setContentView(R.layout.activity_splash_screen);
        splashScreen.setKeepOnScreenCondition(() -> true );
        if (!isMyServiceRunning(GMessagingService.class)) {
            startService(new Intent(Activity_SplashScreen.this, GMessagingService.class));
        }

        poRequest = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
            InitializeAppData();
        });

        mViewModel.GetLoadStatus().observe(Activity_SplashScreen.this, oLoadStat -> {
            if(!oLoadStat.getPermissionGranted()){
                ActivityCompat.requestPermissions(
                        Activity_SplashScreen.this,
                        mViewModel.GetPermissions(),
                        REQUEST_PERMISSION);
            } else {
                mViewModel.InitializeData(new VMSplashScreen.OnInitializCallback() {
                    @Override
                    public void OnLoad(String args) {
                        Log.d(TAG, "Loading Marketplace...");
                    }

                    @Override
                    public void OnFinished(String args) {
                        Intent loIntent = new Intent(Activity_SplashScreen.this, Activity_Dashboard.class);
                        if(getIntent().hasExtra("notification")){
                            String lsArgs = getIntent().getStringExtra("notification");
                            switch (lsArgs){
                                case "regular":
                                    break;
//                                case "cs":
//                                    loIntent = new Intent(Activity_SplashScreen.this, Activity_Purchases.class);
//                                    break;
//                                case "event":
//                                    loIntent = new Intent(Activity_SplashScreen.this, Activity_ProductReview.class);
//                                    break;
                                case "mp_order":
                                    String lsOrderIDx = getIntent().getStringExtra("sOrderIDx");
                                    loIntent.putExtra("notification", "mp_order");
                                    loIntent.putExtra("sOrderIDx", lsOrderIDx);
                                    break;
                                case "panalo":
                                    String lsPanaloxx = getIntent().getStringExtra("panalo");
                                    String lsReferNox = getIntent().getStringExtra("sReferNox");
                                    loIntent.putExtra("notification", "panalo");
                                    loIntent.putExtra("panalo", lsPanaloxx);
                                    loIntent.putExtra("sReferNox", lsReferNox);
                                    break;
                                case "promo":
                                    String lsArgument = getIntent().getStringExtra("args");
                                    String lsUrlLinkx = getIntent().getStringExtra("url_link");
                                    loIntent.putExtra("notification", "promo");
                                    loIntent.putExtra("args", lsArgument);
                                    loIntent.putExtra("url_link", lsUrlLinkx);
                                    break;
                                case "review":
                                    String lsListngID = getIntent().getStringExtra("sListngId");
                                    String lnEntryNox = getIntent().getStringExtra("nEntryNox");
                                    loIntent.putExtra("notification", "review");
                                    loIntent.putExtra("sListngId", lsListngID);
                                    loIntent.putExtra("nEntryNox", lnEntryNox);
                                    break;
                            }
                        }
                        startActivity(loIntent);
                        finish();
                    }
                });
            }
        });
    }

    private void InitializeAppData(){

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {
            boolean lbIsGrnt = true;
            for (int x = 0; x < grantResults.length; x++) {
                if (ContextCompat.checkSelfPermission(Activity_SplashScreen.this, permissions[x]) != grantResults[x]) {
                    lbIsGrnt = false;
                    break;
                }
                Log.e("Permission", permissions[x] + " Granted " + grantResults[x]);
            }
            if(lbIsGrnt) {
                mViewModel.setPermissionsGranted(lbIsGrnt);
            } else {
                mViewModel.setPermissionsGranted(false);
            }
        }
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }
}