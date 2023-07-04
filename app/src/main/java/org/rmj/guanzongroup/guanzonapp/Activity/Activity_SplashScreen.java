package org.rmj.guanzongroup.guanzonapp.Activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.splashscreen.SplashScreen;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;

import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.MessageBox;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.Service.GMessagingService;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMSplashScreen;

import java.util.ArrayList;
import java.util.List;

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
        splashScreen.setKeepOnScreenCondition(() -> false );
        if (!isMyServiceRunning(GMessagingService.class)) {
            startService(new Intent(Activity_SplashScreen.this, GMessagingService.class));
        }

        poRequest = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), result -> {
            InitializeAppData();
        });

        InitializeAppContentDisclosure();
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                        return;
                    }

                    // Get new FCM registration token
                    String token = task.getResult();

//                    mViewModel.SaveFirebaseToken(token);
                    AppConfigPreference.getInstance(Activity_SplashScreen.this).setAppToken(token);
                });
    }

    private void InitializeAppData(){
        mViewModel.InitializeData(new VMSplashScreen.OnInitializeCallback() {
            @Override
            public void OnLoad(String args) {

            }

            @Override
            public void OnProgress(int progress) {

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

    private void InitializeAppContentDisclosure(){
        boolean isFirstLaunch = AppConfigPreference.getInstance(Activity_SplashScreen.this).isAppFirstLaunch();
        if(isFirstLaunch) {
            MessageBox loMessage = new MessageBox(Activity_SplashScreen.this);
            loMessage.initDialog();
            loMessage.setTitle("Guanzon Connect");
            loMessage.setMessage("Guanzon Connect collects location data for Selfie Log, DCP and other major features of the app" +
                    " even when the app is closed or not in use.");
            loMessage.setPositiveButton("Continue", (view, dialog) -> {
                dialog.dismiss();
                CheckPermissions();
            });
            loMessage.show();
        } else {
            CheckPermissions();
        }
    }

    private void CheckPermissions(){
        List<String> lsPermissions = new ArrayList<>();
        if(ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
            lsPermissions.add(Manifest.permission.INTERNET);
        }
        if(ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED){
            lsPermissions.add(Manifest.permission.ACCESS_NETWORK_STATE);
        }
        if(ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            lsPermissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if(ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
            lsPermissions.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            lsPermissions.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if(ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED){
            lsPermissions.add(Manifest.permission.GET_ACCOUNTS);
        }
        if(ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            lsPermissions.add(Manifest.permission.CAMERA);
        }
        if(ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            lsPermissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if(ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            lsPermissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if(ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED){
                lsPermissions.add(Manifest.permission.POST_NOTIFICATIONS);
            }
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if (ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED) {
                lsPermissions.add(Manifest.permission.READ_PHONE_NUMBERS);
            }
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            if (ActivityCompat.checkSelfPermission(Activity_SplashScreen.this, Manifest.permission.MANAGE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                lsPermissions.add(Manifest.permission.MANAGE_EXTERNAL_STORAGE);
            }
        }
        poRequest.launch(lsPermissions.toArray(new String[0]));
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