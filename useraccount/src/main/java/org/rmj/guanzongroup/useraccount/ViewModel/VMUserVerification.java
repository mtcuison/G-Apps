package org.rmj.guanzongroup.useraccount.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.ConnectionUtil;

import java.util.List;

public class VMUserVerification extends AndroidViewModel {
    private static final String TAG = VMUserVerification.class.getSimpleName();

    private final Context mContext;

    public interface OnSelfieVerificationSubmitCallback {
        void OnLoad();
        void OnSuccess(String message);
        void OnFailed(String message);
    }

    public interface OnIDVerificationSubmitCallback{
        void OnProgress(int progress);
        void OnSuccess(String message);
        void OnFailed(String message);
    }

    public VMUserVerification(@NonNull Application application) {
        super(application);
        this.mContext = application;
    }

    public void UploadForVerification(RClientInfo.PhotoDetail foVal, OnSelfieVerificationSubmitCallback callback){
        new UploadForVerificationTask(mContext, callback).execute(foVal);
    }

    private static class UploadForVerificationTask extends AsyncTask<RClientInfo.PhotoDetail, Void, Boolean>{

        private final OnSelfieVerificationSubmitCallback callback;
        private final ConnectionUtil poConn;
        private final RClientInfo poClient;

        private String message;

        public UploadForVerificationTask(Context mContext, OnSelfieVerificationSubmitCallback callback) {
            this.callback = callback;
            this.poClient = new RClientInfo(mContext);
            this.poConn = new ConnectionUtil(mContext);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.OnLoad();
        }

        @Override
        protected Boolean doInBackground(RClientInfo.PhotoDetail... photoDetails) {
            RClientInfo.PhotoDetail loDetail = photoDetails[0];
            try{
                if(!poConn.isDeviceConnected()){
                    message = "Unable to connect.";
                    return false;
                } else {
                    if(!poClient.UploadVerificationImage(loDetail)){
                        message = poClient.getMessage();
                        return false;
                    } else {
                        String lsDtrn = loDetail.getCaptured();
                        String lsName = loDetail.getImageNme();
                        String lsHash = loDetail.getMD5Hashx();
                        String lsPath = loDetail.getFileLoct();
                        String lsDate = loDetail.getCaptured();
                        Log.d(TAG, "Selfie verification parameters: + \n" +
                                        "dTransact: " + lsDtrn + "\n" +
                                        "sImageNme: " + lsName + "\n" +
                                        "sMD5Hashx: " + lsHash + "\n" +
                                        "sImagePth: " + lsPath + "\n" +
                                        "dImgeDate: " + lsDate + "\n");
                        poClient.SubmitSelfieVerification(lsDtrn, lsName, lsHash, lsPath, lsDate);
                        return true;
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean){
                callback.OnSuccess("Request for verification has been submitted.");
            } else {
                callback.OnFailed(message);
            }
        }
    }

    public void UploadIDVerification(List<RClientInfo.PhotoDetail> foVal, OnIDVerificationSubmitCallback callback){
        new UploadIDVerificationTask(mContext, callback).execute(foVal);
    }

    private static class UploadIDVerificationTask extends AsyncTask<List<RClientInfo.PhotoDetail>, Integer, Boolean>{

        private final ConnectionUtil poConn;
        private final OnIDVerificationSubmitCallback callback;
        private final RClientInfo poClient;

        private String message;

        public UploadIDVerificationTask(Context context, OnIDVerificationSubmitCallback callback) {
            this.callback = callback;
            this.poConn = new ConnectionUtil(context);
            this.poClient = new RClientInfo(context);
        }

        @Override
        protected Boolean doInBackground(List<RClientInfo.PhotoDetail>... lists) {
            List<RClientInfo.PhotoDetail> loDetail = lists[0];
            try{
                if(!poConn.isDeviceConnected()){
                    message = "Unable to connect.";
                    return false;
                } else {
                    for(int x = 0; x < loDetail.size(); x++){
                        RClientInfo.PhotoDetail loPhoto = loDetail.get(x);
                        Log.d(TAG, "Uploading ID Capture. " + x);
                        boolean isSuccess = poClient.UploadVerificationImage(loPhoto);
                        if(isSuccess){
                            Log.d(TAG, "Upload success!");
                        } else {
                            Log.d(TAG, "Upload failed!, " + poClient.getMessage());
                            return false;
                        }
                        publishProgress(x);
                        Thread.sleep(1000);
                    }

                    JSONObject loJson = new JSONObject();
                    boolean isSuccess = poClient.SubmitIDVerification(loJson);
                    if(!isSuccess){
                        message = poClient.getMessage();
                        return false;
                    } else {
                        return true;
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            callback.OnProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                callback.OnSuccess("Your request for account verification has been submitted.");
            } else {
                callback.OnFailed(message);
            }
        }
    }
}
