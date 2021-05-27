package org.rmj.guanzongroup.guanzonapp.GuanzonApp.LoadGCard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_Loading;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.ImportPreOrder;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.Import_McDetail;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.Import_Transactions;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.onImportResultListener;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;

public class LoadGCardNumber extends CodeGenerator {

    private Context mContext;
    private GcardAppMaster gcardAppMaster;
    private ConnectionUtil connectionUtil;
    private Dialog_Loading dialogLoading;
    private String GCardNumber;
    private onLoadGcardNumberListener listener;
    private DoBackgroundTask loTask;

    private int[] dataLoadStatus = {0, 0, 0, 0};

    public interface onLoadGcardNumberListener{
        void isOnlineResult();
        void isOfflineLoad();
    }
    public LoadGCardNumber(Context context){
        this.mContext = context;
        this.gcardAppMaster = new GcardAppMaster(mContext);
        this.dialogLoading = new Dialog_Loading(mContext);
        this.connectionUtil = new ConnectionUtil(mContext);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void loadGcard(String GCardNumber, onLoadGcardNumberListener listener){
        this.GCardNumber = GCardNumber;
        this.listener = listener;
        loTask = new DoBackgroundTask(new OnTaskFinish() {
            @Override
            public void OnFinished() {
                loTask.cancel(true);
            }
        });
        loTask.execute();
    }

    private void importGcardAssets(){
        if(dataLoadStatus[0] == 0){
            new Import_McDetail().sendRequest(mContext, new onImportResultListener() {
                @Override
                public void onSuccessImport() {
                    dataLoadStatus[0] = 1;
                }

                @Override
                public void onErrorResult() {

                }
            });
        }
        if(dataLoadStatus[1] == 0) {
            new Import_Transactions().sendRequest(mContext, new onImportResultListener() {
                @Override
                public void onSuccessImport() {
                    dataLoadStatus[1] = 1;
                }

                @Override
                public void onErrorResult() {

                }
            });
        }

        if(dataLoadStatus[2] == 0) {
            new ImportPreOrder().sendRequest(mContext, new onImportResultListener() {
                @Override
                public void onSuccessImport() {
                    dataLoadStatus[2] = 1;
                }

                @Override
                public void onErrorResult() {

                }
            });
        }

        if(dataLoadStatus[3] == 0) {
            new Import_McDetail().sendRequest(mContext, new onImportResultListener() {
                @Override
                public void onSuccessImport() {
                    dataLoadStatus[3] = 1;
                }

                @Override
                public void onErrorResult() {

                }
            });
        }
    }

    @SuppressLint("StaticFieldLeak")
    @RequiresApi(api = Build.VERSION_CODES.M)
    private class DoBackgroundTask extends AsyncTask<Integer, Integer, String>{

        OnTaskFinish lolistener;

        DoBackgroundTask(OnTaskFinish listener){
            this.lolistener = listener;
        }

        @Override
        protected void onPreExecute() {
            gcardAppMaster.replaceActiveGcardSetNew(GCardNumber);
            dialogLoading.setMessage("Loading GCard. Please wait...");
            dialogLoading.showDialog();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            if(connectionUtil.isDeviceConnected()) {
                while (dataLoadStatus[0] != 1 && dataLoadStatus[1] != 1 && dataLoadStatus[2] != 1) {
                    importGcardAssets();
                }
                dialogLoading.dismissDialog();
                listener.isOnlineResult();
            } else {
                dialogLoading.dismissDialog();
                listener.isOfflineLoad();
            }
            lolistener.OnFinished();
            return "GCard info loaded successfully.";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            this.cancel(true);
        }
    }

    public interface OnTaskFinish{
        void OnFinished();
    }
}
