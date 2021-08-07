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

package org.rmj.guanzongroup.guanzonapp.Services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.rmj.g3appdriver.ImportData.ImportDataCallback;
import org.rmj.g3appdriver.ImportData.ImportInstance;
import org.rmj.g3appdriver.ImportData.Import_AccountGCard;
import org.rmj.g3appdriver.ImportData.Import_Branch;
import org.rmj.g3appdriver.ImportData.Import_Events;
import org.rmj.g3appdriver.ImportData.Import_McDetail;
import org.rmj.g3appdriver.ImportData.Import_Orders;
import org.rmj.g3appdriver.ImportData.Import_Promotions;
import org.rmj.g3appdriver.ImportData.Import_Redeemables;
import org.rmj.g3appdriver.ImportData.Import_Service;
import org.rmj.g3appdriver.ImportData.Import_Transactions;
import org.rmj.g3appdriver.etc.SessionManager;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class DataImportService extends JobService {
    public static final String TAG = DataImportService.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.e(TAG, "Data import service has started.");
        try{
            doBackgroundTask(jobParameters);
        } catch (Exception e){
            e.printStackTrace();
            jobFinished(jobParameters, false);
        }
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.e(TAG, "Data import service has stop.");
        return true;
    }


    private void doBackgroundTask(JobParameters params) {
        ImportInstance[]  importInstances;
        if (new SessionManager(getApplication()).isLoggedIn()){
         importInstances = new ImportInstance[] {
                    new Import_AccountGCard(getApplication()),
                    new Import_Events(getApplication()),
                    new Import_Promotions(getApplication()),
                    new Import_Orders(getApplication()),
                    new Import_Redeemables(getApplication()),
                    new Import_Service(getApplication()),
                    new Import_McDetail(getApplication()),
                    new Import_Transactions(getApplication())};
        }else{
                    importInstances = new ImportInstance[]{
                    new Import_Redeemables(getApplication()),
                    new Import_Events(getApplication()),
                    new Import_Promotions(getApplication()),
                    new Import_Branch(getApplication())};
        }


        new Thread(() -> {
            for (ImportInstance importInstance : importInstances) {
                importInstance.ImportData(new ImportDataCallback() {
                    @Override
                    public void OnSuccessImportData() {
                        Log.e(TAG,   importInstance.getClass().getSimpleName() + " success");
                    }

                    @Override
                    public void OnFailedImportData(String message) {
                        Log.e(TAG,  importInstance.getClass().getSimpleName() + " " + message);
                    }
                });
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
            jobFinished(params, false);
        }).start();
    }
}
