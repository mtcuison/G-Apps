package org.rmj.guanzongroup.guanzonapp.Services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.rmj.g3appdriver.GuanzonApp.ImportDataCallback;
import org.rmj.g3appdriver.GuanzonApp.ImportInstance;

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
        ImportInstance[]  importInstances = {
//                TODO: Import Class Instance
//                e.g. new Import_AreaPerformance(getApplication()),
        };
        new Thread(() -> {
            for (ImportInstance importInstance : importInstances) {
                importInstance.ImportData(new ImportDataCallback() {
                    @Override
                    public void OnSuccessImportData() {

                    }

                    @Override
                    public void OnFailedImportData(String message) {

                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            jobFinished(params, false);
        }).start();
    }
}
