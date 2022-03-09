package org.rmj.guanzongroup.guanzonapp.Service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class DataImportService extends JobService {
    public static final String TAG = DataImportService.class.getSimpleName();

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        try{
//            doBackgroundTask(jobParameters);
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


//    private void doBackgroundTask(JobParameters params) {
//        ImportInstance[]  importInstances = {
//                new Import_BankList(getApplication()),
//                new ImportFileCode(getApplication()),
//                new Import_Relation(getApplication()),
//                new ImportBrand(getApplication()),
//                new ImportBrandModel(getApplication()),
//                new ImportCategory(getApplication()),
//                new ImportProvinces(getApplication()),
//                new ImportMcModelPrice(getApplication()),
//                new ImportTown(getApplication()),
//                new ImportBarangay(getApplication()),
//                new ImportMcTermCategory(getApplication()),
//                new ImportCountry(getApplication()),
//                new Import_Occupations(getApplication()),
//                new Import_SysConfig(getApplication()),
//                new Import_SCARequest(getApplication()),
//                new ImportBranch(getApplication()),
//                new Import_AreaPerformance(getApplication()),
//                new Import_BranchPerformance(getApplication()),};
//        new Thread(() -> {
//            for (ImportInstance importInstance : importInstances) {
//                importInstance.ImportData(new ImportDataCallback() {
//                    @Override
//                    public void OnSuccessImportData() {
//                        Log.e(TAG, importInstance.getClass().getSimpleName() + " import success.");
//                    }
//
//                    @Override
//                    public void OnFailedImportData(String message) {
//                        Log.e(TAG, importInstance.getClass().getSimpleName() + " import failed. " + message);
//                    }
//                });
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            AppConfigPreference.getInstance(DataImportService.this).setLastSyncDate(new AppConstants().CURRENT_DATE);
//            jobFinished(params, false);
//        }).start();
//    }
}
