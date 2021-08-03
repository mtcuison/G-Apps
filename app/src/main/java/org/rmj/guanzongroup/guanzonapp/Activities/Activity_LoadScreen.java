package org.rmj.guanzongroup.guanzonapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import org.rmj.androidprojects.guanzongroup.g3logindriver.Login.Activity_Login;
import org.rmj.androidprojects.guanzongroup.g3logindriver.Services.LoginImportService;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.utils.ServiceScheduler;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.Services.ImportDataService;

import java.util.Random;

import static org.rmj.g3appdriver.utils.ServiceScheduler.TWO_HOUR_PERIODIC;

public class Activity_LoadScreen extends AppCompatActivity {
    private Context mContext = this;
    private ProgressBar loProgress;
    private ImageView imgProgress;

    private AnimatedVectorDrawableCompat avdc;
    private AnimatedVectorDrawable avd;
    private Handler handler;
    private int loading = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
        imgProgress = findViewById(R.id.img_load_screen_loadingLogo);
        loProgress = findViewById(R.id.progress_bar_assetdownload);
       try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                setupAnimation();
            }
            handler=new Handler();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (loading < 100) {
                        loading += 1;
                        Random random = new Random();
                        loading += random.nextInt(10 - 1 + 1) + 1;
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (loading > 100){
                                    loading=100;
                                    loProgress.setProgress(loading);
                                }
                                if (loading == 100) {
                                    Intent intent=new Intent(Activity_LoadScreen.this,MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });


                    }
                }
            }).start();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(Activity_LoadScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setupAnimation(){
        Drawable drawable = getDrawable(R.drawable.anim_loading_progress_logo);
        if(drawable instanceof AnimatedVectorDrawableCompat){
            avdc = (AnimatedVectorDrawableCompat)drawable;
            imgProgress.setImageDrawable(avdc);
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
                imgProgress.setImageDrawable(avd);
                avd.registerAnimationCallback(new Animatable2.AnimationCallback() {
                    @Override
                    public void onAnimationEnd(Drawable drawable) {
                        avd.start();
                    }
                });
                avd.start();
            }
        }
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(Activity_LoadScreen.this, "Please wait.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        if(avdc!=null){
            avdc.clearAnimationCallbacks();
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(avd!=null) {
                avd.clearAnimationCallbacks();
            }
        }
        super.onDestroy();
    }
}
