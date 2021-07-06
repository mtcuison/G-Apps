/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.app
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:17 PM
 */

package org.rmj.androidprojects.guanzongroup.g3logindriver.Services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.rmj.g3appdriver.GuanzonApp.ImportDataCallback;
import org.rmj.g3appdriver.GuanzonApp.ImportInstance;
import org.rmj.g3appdriver.GuanzonApp.Import_AccountGCard;
import org.rmj.g3appdriver.GuanzonApp.Import_Branch;
import org.rmj.g3appdriver.GuanzonApp.Import_Events;
import org.rmj.g3appdriver.GuanzonApp.Import_Orders;
import org.rmj.g3appdriver.GuanzonApp.Import_Promotions;
import org.rmj.g3appdriver.GuanzonApp.Import_Redeemables;
import org.rmj.g3appdriver.GuanzonApp.Import_Service;
import org.rmj.g3appdriver.GuanzonApp.Import_Transactions;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class LoginImportService extends JobService {
    public static final String TAG = LoginImportService.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.e(TAG, "Login import service has started.");
        try{
            doBackgroundTask(jobParameters);
        } catch (Exception e){
            e.printStackTrace();
            jobFinished(jobParameters, false);
            Log.e("exception", e.getMessage());
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.e(TAG, "Login import service has stop.");
        return true;
    }


    private void doBackgroundTask(JobParameters params) {
        ImportInstance[]  importInstances = {
                new Import_AccountGCard(getApplication()),
                new Import_Redeemables(getApplication()),
                new Import_Orders(getApplication()),
                new Import_Service(getApplication()),
                new Import_Transactions(getApplication())};


        new Thread(() -> {
            for (ImportInstance importInstance : importInstances) {
                importInstance.ImportData(new ImportDataCallback() {
                    @Override
                    public void OnSuccessImportData() {
                        Log.e(TAG,   importInstance.toString() + " success");
                    }

                    @Override
                    public void OnFailedImportData(String message) {
                        Log.e(TAG,  message + " sample failed");
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Log.e(TAG,  e.getMessage() + " InterruptedException sample failed");
                }


            }
            jobFinished(params, false);
        }).start();
    }
}
