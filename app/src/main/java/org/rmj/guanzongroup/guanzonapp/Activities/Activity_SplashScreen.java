package org.rmj.guanzongroup.guanzonapp.Activities;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import org.rmj.androidprojects.guanzongroup.g3logindriver.Activity_Login;
import org.rmj.g3appdriver.dev.Telephony;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.utils.ServiceScheduler;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_AskDataServer;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_MobileNo;
import org.rmj.guanzongroup.guanzonapp.Dialogs.MessageBox;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.Services.DataImportService;
import org.rmj.guanzongroup.guanzonapp.Services.MyFirebaseMessagingService;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMSplashScreen;

import java.util.ArrayList;

import static org.rmj.g3appdriver.utils.ServiceScheduler.TWO_HOUR_PERIODIC;


@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class Activity_SplashScreen extends AppCompatActivity {
    private static final String TAG = Activity_SplashScreen.class.getSimpleName();
    private static Activity_SplashScreen instance;
    private VMSplashScreen mViewModel;
    public static TextView lblProgress;
    private ImageView imgSplashView;
    private AppConfigPreference app;
    private AnimatedVectorDrawableCompat avdc;
    private AnimatedVectorDrawable avd;
    public static Activity_SplashScreen getInstance(){
        return instance;
    }
    @SuppressLint({"SetTextI18n", "NewApi"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        initWidgets();
        app = new AppConfigPreference(this);
        mViewModel = ViewModelProviders.of(this).get(VMSplashScreen.class);
        try {
            mViewModel = new ViewModelProvider(this).get(VMSplashScreen.class);

            if (app.isTesting_Phase() && app.getIsLocalHostChange()){
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
                        app.setIsLocalHostChange(false);
                        Activity_SplashScreen.this.recreate();
                    }
                });
                messageBox.showDialog();
            }else{

                mViewModel.isPermissionsGranted().observe(this, isGranted -> {
                    if(!isGranted){
                        mViewModel.getPermisions().observe(this, strings -> ActivityCompat.requestPermissions(Activity_SplashScreen.this, strings, AppConstants.PERMISION_REQUEST_CODE));
                    } else {

                        starLogoAnimation();
                        if (mViewModel.getMobileNo().getValue() == null || mViewModel.getMobileNo().getValue().isEmpty()){
                            checkMobileNumbers();
                            if(!isMyServiceRunning(MyFirebaseMessagingService.class)) {
                                startService(new Intent(Activity_SplashScreen.this, MyFirebaseMessagingService.class));
                            }

                        }else{
                            startService(new Intent(Activity_SplashScreen.this, MyFirebaseMessagingService.class));
//                            scheduleJob();
                            ServiceScheduler.scheduleJob(Activity_SplashScreen.this, DataImportService.class, TWO_HOUR_PERIODIC, AppConstants.DataServiceID);

                            TextView lblBuildVersion = findViewById(R.id.lbl_splash_build_version);

                        }


                    }
                });
            }

        }catch (NullPointerException e){
            e.printStackTrace();
            Log.e("TAG",e.getMessage() + " NullPointerException");
        }catch (RuntimeException e){
            e.printStackTrace();
            Log.e("TAG",e.getMessage()  + " RuntimeException");
        }
    }
    public void initWidgets(){
        imgSplashView = findViewById(R.id.img_splash_screen_logo);
        TextView lblBuildVersion = findViewById(R.id.lbl_splash_build_version);
        lblProgress = findViewById(R.id.lbl_splash_progress_status);

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
    @SuppressLint("NewApi")
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
    @SuppressLint("NewApi")
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
                            mViewModel.setMobileNo(mobileNo.get(0));
                            dialog.dismiss();
                            Activity_SplashScreen.this.recreate();
                        }
                    });
                    loMessage.setNegativeButton(mobileNo.get(1), new MessageBox.onMessageBoxButtonClick() {
                        @Override
                        public void onClick(View view, AlertDialog dialog) {
                            mViewModel.setMobileNo(mobileNo.get(1));
                            dialog.dismiss();
                            Activity_SplashScreen.this.recreate();
                        }
                    });
                    loMessage.showDialog();
                } else if(simCount == 1){
                    mViewModel.setMobileNo(mobileNo.get(0));
                    Activity_SplashScreen.this.recreate();
                } else {
                    Dialog_MobileNo loMobile = new Dialog_MobileNo(Activity_SplashScreen.this);
                    loMobile.initDialog(new Dialog_MobileNo.OnMobileNoConfirmListener() {
                        @Override
                        public void OnConfirm(String MobileNo) {
                            mViewModel.setMobileNo(MobileNo);
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
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void scheduleJob(){
        ComponentName loComponent = new ComponentName(this, DataImportService.class);
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
}
