package org.rmj.guanzongroup.guanzonapp.Activities;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import org.rmj.g3appdriver.dev.Telephony;
import org.rmj.g3appdriver.etc.SharedPref;
import org.rmj.g3appdriver.utils.InAppUpdate;
import org.rmj.guanzongroup.g3msg_notifylib.DbHelper.NotificationData;
import org.rmj.guanzongroup.guanzonapp.BuildConfig;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_AskDataServer;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_MobileNo;
import org.rmj.guanzongroup.guanzonapp.Dialogs.MessageBox;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.G_AppLocal;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.Services.AppService;
import org.rmj.guanzongroup.guanzonapp.Services.MyFirebaseMessagingService;
import org.rmj.guanzongroup.guanzonapp.etc.CustomToast;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class Activity_SplashScreen extends AppCompatActivity {
    private static final String TAG = Activity_SplashScreen.class.getSimpleName();
    private static Activity_SplashScreen instance;
    private ImageView imgSplashView;
    private TextView lblProgress;
    private SharedPref sharedPref;
    private AnimatedVectorDrawableCompat avdc;
    private AnimatedVectorDrawable avd;

    private final int PERMISSION_ALL = 0;

    private final String[] permissions = {
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.GET_ACCOUNTS,
            Manifest.permission.CAMERA};

    public static Activity_SplashScreen getInstance(){
        return instance;
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        instance = this;
        sharedPref = new SharedPref(Activity_SplashScreen.this);
        sharedPref.setIsTesting(false);
        sharedPref.setTemp_ProductID("GuanzonApp");

        if (sharedPref.isTesting_Phase() && sharedPref.getIsLocalHostChange()) {
            MessageBox messageBox = new MessageBox(Activity_SplashScreen.this);
            messageBox.setDialogMessage("You installed a test version of GuanzonApp. Do you want to change to Localhost?");
            messageBox.setMessageType(MessageBox.MessageType.INFO);
            messageBox.setPositiveButton("Yes", new MessageBox.onMessageBoxButtonClick() {
                @Override
                public void onClick(View view, AlertDialog dialog) {
                    dialog.dismiss();
                    new Dialog_AskDataServer(Activity_SplashScreen.this).showDialog();
                }
            });
            messageBox.setNegativeButton("No", new MessageBox.onMessageBoxButtonClick() {
                @Override
                public void onClick(View view, AlertDialog dialog) {
                    dialog.dismiss();
                    sharedPref.setIsLocalHostChange(false);
                    Activity_SplashScreen.this.recreate();
                }
            });
            messageBox.showDialog();
        } else {
            new InAppUpdate(Activity_SplashScreen.this, Activity_SplashScreen.this).Check_Update();
            new G_AppLocal(Activity_SplashScreen.this).setupGuanzonAppData();
            new NotificationData(Activity_SplashScreen.this).setupNotificationData();
            if (!isMyServiceRunning(MyFirebaseMessagingService.class)) {
                startService(new Intent(Activity_SplashScreen.this, MyFirebaseMessagingService.class));
            }
            transparentToolbar();

            imgSplashView = findViewById(R.id.img_splash_screen_logo);
            TextView lblBuildVersion = findViewById(R.id.lbl_splash_build_version);
            lblProgress = findViewById(R.id.lbl_splash_progress_status);

            lblBuildVersion.setText("Build Version " + BuildConfig.VERSION_NAME + " - " + BuildConfig.VERSION_CODE + "Vc.");
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                starLogoAnimation();
            }
            if (!hasPermissions(Activity_SplashScreen.this, permissions)) {
                viewPermissionMessage();
            } else {
                setupApp();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(Activity_SplashScreen.this, "Please wait.", Toast.LENGTH_SHORT).show();
    }

    private void setupApp(){
        if(sharedPref.getMobileNo().isEmpty()){
            checkMobileNumbers();
        } else {
            LoadScreen loadScreen = new LoadScreen(Activity_SplashScreen.this, Activity_SplashScreen.this, lblProgress);
            loadScreen.startProgress();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                scheduleJob();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void starLogoAnimation(){
        Drawable drawable = getDrawable(R.drawable.anim_guanzon_progress_logo);
        if(drawable instanceof AnimatedVectorDrawableCompat){
            avdc = (AnimatedVectorDrawableCompat)drawable;
            imgSplashView.setImageDrawable(avdc);
            AnimatedVectorDrawableCompat.registerAnimationCallback(drawable, new Animatable2Compat.AnimationCallback() {
                @Override
                public void onAnimationEnd(Drawable drawable) {
                    avdc.start();
                }
            });
            avdc.start();
        } else if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            if(drawable instanceof AnimatedVectorDrawable){
                avd = (AnimatedVectorDrawable) drawable;
                imgSplashView.setImageDrawable(avd);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    avd.registerAnimationCallback(new Animatable2.AnimationCallback() {
                        @Override
                        public void onAnimationEnd(Drawable drawable) {
                            avd.start();
                        }
                    });
                }
                avd.start();
            }
        }
    }

    @Override
    protected void onDestroy() {
        if(avdc!=null){
            avdc.clearAnimationCallbacks();
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if(avd!=null) {
                    avd.clearAnimationCallbacks();
                }
            }
        }
        super.onDestroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void scheduleJob(){
        ComponentName loComponent = new ComponentName(this, AppService.class);
        JobInfo loJob = new JobInfo.Builder(20190625, loComponent)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_NONE)
                .setPersisted(true)
                .setPeriodic(900000)
                .build();
        JobScheduler loScheduler = (JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
        int liResult = loScheduler.schedule(loJob);
        if(liResult == JobScheduler.RESULT_SUCCESS){
            Log.e(TAG, "Job Scheduled");
        } else {
            Log.e(TAG, "Job Schedule Failed.");
        }
    }

    private void transparentToolbar() {
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            this.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
    private void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    private static boolean hasPermissions(Context context, String... permissions){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && permissions!=null ){
            for (String permission: permissions){
                if(ActivityCompat.checkSelfPermission(context, permission)!= PackageManager.PERMISSION_GRANTED){
                    return false;
                }
            }
        }
        return true;
    }

    private void viewPermissionMessage(){
        MessageBox messageBox = new MessageBox(Activity_SplashScreen.this);
        messageBox.setDialogMessage(getString(R.string.permission_message));
        messageBox.setMessageType(MessageBox.MessageType.WARNING);
        messageBox.setPositiveButton("Okay", new MessageBox.onMessageBoxButtonClick() {
            @Override
            public void onClick(View view, AlertDialog dialog) {
                dialog.dismiss();
                while (!hasPermissions(Activity_SplashScreen.this, permissions)) {
                    ActivityCompat.requestPermissions(Activity_SplashScreen.this, permissions, PERMISSION_ALL);
                }
                setupApp();
            }
        });
        messageBox.showDialog();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == InAppUpdate.InAppUpdateResult.RESULT_CODE){
            if(resultCode != RESULT_OK){
                System.exit(1);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
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

    private void checkMobileNumbers(){
        Telephony loMobileNo = new Telephony(Activity_SplashScreen.this);
        loMobileNo.getSubscriptions(new Telephony.OnSubscriptionCheckListener() {
            @Override
            public void OnCheck(int simCount, final ArrayList<String> mobileNo) {
                if(simCount > 1){
                    MessageBox loMessage = new MessageBox(Activity_SplashScreen.this);
                    loMessage.setMessageType(MessageBox.MessageType.INFO);
                    loMessage.setDialogMessage("Please select which mobile no is registered to your Gcard Number.");
                    loMessage.setPositiveButton(mobileNo.get(0), new MessageBox.onMessageBoxButtonClick() {
                        @Override
                        public void onClick(View view, AlertDialog dialog) {
                            sharedPref.setTemp_mobileno(mobileNo.get(0));
                            dialog.dismiss();
                            Activity_SplashScreen.this.recreate();
                        }
                    });
                    loMessage.setNegativeButton(mobileNo.get(1), new MessageBox.onMessageBoxButtonClick() {
                        @Override
                        public void onClick(View view, AlertDialog dialog) {
                            sharedPref.setTemp_mobileno(mobileNo.get(1));
                            dialog.dismiss();
                            Activity_SplashScreen.this.recreate();
                        }
                    });
                    loMessage.showDialog();
                } else if(simCount == 1){
                    sharedPref.setTemp_mobileno(mobileNo.get(0));
                    Activity_SplashScreen.this.recreate();
                } else {
                    Dialog_MobileNo loMobile = new Dialog_MobileNo(Activity_SplashScreen.this);
                    loMobile.initDialog(new Dialog_MobileNo.OnMobileNoConfirmListener() {
                        @Override
                        public void OnConfirm(String MobileNo) {
                            sharedPref.setTemp_mobileno(MobileNo);
                            Activity_SplashScreen.this.recreate();
                        }
                    });
                    loMobile.show();
                }
            }

            @Override
            public void NoSubscription() {
                Toast.makeText(Activity_SplashScreen.this, "Device mobile number is invalid.", Toast.LENGTH_LONG).show();
                Activity_SplashScreen.this.recreate();
            }
        });
    }
}
