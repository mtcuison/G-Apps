package org.rmj.guanzongroup.guanzonapp.Services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.ImportRedeemables;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.onImportResultListener;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.LoadService;
import org.rmj.guanzongroup.guanzonapp.etc.GuanzonAppNotice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class AppService extends JobService {
    private static final String TAG = AppService.class.getSimpleName();

    private boolean jobCancelled = false;

    private OutputStream outputStream;
    private String[] psImagUrl;

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.e(TAG, "Guanzon App job service has started.");
        dobackgroundWork(params);
        return true;
    }

    private void dobackgroundWork(final JobParameters params){
        new ImportRedeemables().sendRequest(AppService.this, new onImportResultListener() {
            @Override
            public void onSuccessImport() {

            }

            @Override
            public void onErrorResult() {

            }
        });
        downloadPromoImages(params);
        new LoadService(AppService.this).checkDateService(new LoadService.OnCheckServiceListener() {
            @Override
            public void ServiceToday() {
                new GuanzonAppNotice(AppService.this, "Your motorcycle free service is scheduled today.", GuanzonAppNotice.CHANNEL_ID.IndividualMessage).showNotification();
            }
        });
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.e(TAG, "Background AppService Cancelled.");
        jobCancelled = true;
        return true;
    }

    private void downloadPromoImages(final JobParameters params){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String[] lsFileName = getFileName();
                for(int x = 0; x < lsFileName.length; x++) {
                    Bitmap loBitmap;
                    try {
                        InputStream loStream = new java.net.URL(psImagUrl[x]).openStream();
                        loBitmap = BitmapFactory.decodeStream(loStream);

                        File loFilePath = Environment.getExternalStorageDirectory();
                        File dir = new File(loFilePath.getAbsolutePath() + "/Demo/");
                        dir.mkdir();
                        File loFile = new File(dir,  lsFileName[x]+".png");
                        try {
                            outputStream = new FileOutputStream(loFile);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                        loBitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (jobCancelled) {
                        return;
                    }
                }
                jobFinished(params, false);
            }
        }).start();
    }

    private String[] getFileName(){
        String[] fileName = new String[0];
        try {
            AppData db = AppData.getInstance(AppService.this);
            final Cursor loCursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_promo_link", null);
            if (loCursor.getCount() > 0) {
                fileName = new String[loCursor.getCount()];
                psImagUrl = new String[loCursor.getCount()];
                loCursor.moveToFirst();
                for (int x = 0; x < loCursor.getCount(); x++) {
                    String lsTransno = loCursor.getString(loCursor.getColumnIndex("sTransNox"));
                    String lsImagUrl = loCursor.getString(loCursor.getColumnIndex("sImageUrl"));
                    String ldTransct = loCursor.getString(loCursor.getColumnIndex("dTransact"));
                    fileName[x] = lsTransno + "-" + ldTransct;
                    psImagUrl[x] = lsImagUrl;
                    loCursor.moveToNext();
                }
                loCursor.close();
                return fileName;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return fileName;
    }

    private void downloadEventImages(final JobParameters params){

    }
}
