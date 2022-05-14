package org.rmj.guanzongroup.guanzonapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.rmj.g3appdriver.etc.oLoadStat;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.Service.GMessagingService;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMSplashScreen;

public class Activity_SplashScreen extends AppCompatActivity {
    private static final String TAG = Activity_SplashScreen.class.getSimpleName();

    private VMSplashScreen mViewModel;

    private static final int REQUEST_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (!isMyServiceRunning(GMessagingService.class)) {
            startService(new Intent(Activity_SplashScreen.this, GMessagingService.class));
        }
        mViewModel = new ViewModelProvider(this).get(VMSplashScreen.class);
        mViewModel.setupApp();

        mViewModel.GetLoadStatus().observe(Activity_SplashScreen.this, new Observer<oLoadStat>() {
            @Override
            public void onChanged(oLoadStat oLoadStat) {
                if(!oLoadStat.getPermissionGranted()){
                    ActivityCompat.requestPermissions(
                            Activity_SplashScreen.this,
                            mViewModel.GetPermissions(),
                            REQUEST_PERMISSION);
                } else {
                    mViewModel.InitializeData(new VMSplashScreen.OnInitializeData() {
                        @Override
                        public void OnLoad(String args) {
                            Log.d(TAG, "Loading Marketplace...");
                        }

                        @Override
                        public void OnFinished(String args) {
                            startActivity(new Intent(Activity_SplashScreen.this, Activity_Dashboard.class));
                            finish();
                        }
                    });
                }
            }
        });
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