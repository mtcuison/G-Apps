package org.rmj.guanzongroup.guanzonapp.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
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

import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.GapImportInstance;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.ImportAccountGcard;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.ImportOrders;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.ImportRedeemables;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.Import_McDetail;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.Import_Transactions;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.onImportResultListener;
import org.rmj.guanzongroup.guanzonapp.R;

public class Activity_LoadScreen extends AppCompatActivity {

    private Context mContext = this;
    private ProgressBar loProgress;
    private ImageView imgProgress;
    private GapImportInstance[] importInstances = {
            new ImportAccountGcard(),
            new ImportRedeemables(),
            new ImportOrders(),
            new Import_McDetail(),
            new Import_Transactions()
    };

    private AnimatedVectorDrawableCompat avdc;
    private AnimatedVectorDrawable avd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
        imgProgress = findViewById(R.id.img_load_screen_loadingLogo);
        loProgress = findViewById(R.id.progress_bar_assetdownload);
        new Handler();
        try {
            new ImportAssets().execute(importInstances.length);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                setupAnimation();
            }
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(Activity_LoadScreen.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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

    @SuppressLint("StaticFieldLeak")
    class ImportAssets extends AsyncTask<Integer, Integer, String>{

        @Override
        protected String doInBackground(Integer... integers) {
            try {
                for (int x = 0; x < integers[0]; x++) {
                    importInstances[x].sendRequest(mContext, new onImportResultListener() {
                        @Override
                        public void onSuccessImport() {

                        }

                        @Override
                        public void onErrorResult() {

                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    publishProgress((int) ((x / (float) integers[0]) * 100));
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return "finish";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            loProgress.setProgress(values[0]);
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            startActivity(new Intent(Activity_LoadScreen.this, Activity_DashBoard.class));
            overridePendingTransition(R.anim.animation_intent_activity_fade_in, R.anim.animation_intent_activity_fade_out);
            finish();
            this.cancel(true);
            super.onPostExecute(s);
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
}
