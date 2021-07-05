package org.rmj.guanzongroup.guanzonapp.Activities;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

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
import java.util.Random;

import static org.rmj.g3appdriver.utils.ServiceScheduler.FIFTEEN_MINUTE_PERIODIC;
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
    private Handler handler;
    private int loading = 0;
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
            startService(new Intent(Activity_SplashScreen.this, MyFirebaseMessagingService.class));
            if(!ServiceScheduler.isJobRunning(Activity_SplashScreen.this, AppConstants.DataServiceID)) {
                ServiceScheduler.scheduleJob(Activity_SplashScreen.this, DataImportService.class, TWO_HOUR_PERIODIC, AppConstants.DataServiceID);
            }

            mViewModel.isPermissionsGranted().observe(this, isGranted -> {
                if(!isGranted){
                    mViewModel.getPermisions().observe(this, strings -> ActivityCompat.requestPermissions(Activity_SplashScreen.this, strings, AppConstants.PERMISION_REQUEST_CODE));
                } else {
                    Log.e("else", String.valueOf(mViewModel.getMobileNo().getValue()));
                    starLogoAnimation();
                    mViewModel.getMobileNo().observe(Activity_SplashScreen.this,val->{
                        Log.e(TAG,val);
                        if (val == null || val.isEmpty()){
                            checkMobileNumbers();
                        }else{
                            startSerives();
                        }
                    });

                }
            });
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
//                            startSerives();
                            dialog.dismiss();
                            Activity_SplashScreen.this.recreate();
                        }
                    });
                    loMessage.setNegativeButton(mobileNo.get(1), new MessageBox.onMessageBoxButtonClick() {
                        @Override
                        public void onClick(View view, AlertDialog dialog) {
                            mViewModel.setMobileNo(mobileNo.get(1));
//                            startSerives();
                            dialog.dismiss();
                            Activity_SplashScreen.this.recreate();

                        }
                    });
                    loMessage.showDialog();
                } else if(simCount == 1){
                    mViewModel.setMobileNo(mobileNo.get(0));
//                    startSerives();
                } else {
                    Dialog_MobileNo loMobile = new Dialog_MobileNo(Activity_SplashScreen.this);
                    loMobile.initDialog(new Dialog_MobileNo.OnMobileNoConfirmListener() {
                        @Override
                        public void OnConfirm(String MobileNo) {
                            mViewModel.setMobileNo(MobileNo);
                            Activity_SplashScreen.this.recreate();
//                            startSerives();
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
    public void startSerives(){

        TextView lblBuildVersion = findViewById(R.id.lbl_splash_build_version);
        handler=new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (loading < 100) {
                    loading += 1;
                    Random random = new Random();
                    loading += random.nextInt(10 - 1 + 1) + 1;
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if (loading > 100){
                                 loading=100;
                            }
                            lblProgress.setText(loading + "%");
                            if (loading == 100) {
                                Intent intent=new Intent(Activity_SplashScreen.this,MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });


                }
            }
        }).start();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == AppConstants.PERMISION_REQUEST_CODE) {
            boolean lbIsGrnt = true;
            for (int x = 0; x < grantResults.length; x++) {
                if (ContextCompat.checkSelfPermission(Activity_SplashScreen.this, permissions[x]) != grantResults[x]) {
                    lbIsGrnt = false;
                    break;
                }
                Log.e("Permission", permissions[x] + " Granted " + grantResults[x]);

            }
            if (lbIsGrnt) {
                mViewModel.setPermissionsGranted(true);
            }
        }
    }

}
