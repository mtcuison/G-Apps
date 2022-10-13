package org.rmj.guanzongroup.useraccount.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.Account.AccountVerification;
import org.rmj.g3appdriver.lib.Account.Obj.UserIdentification;
import org.rmj.guanzongroup.useraccount.Etc.IDDetail;

import java.util.List;

public class VMID1Verification extends AndroidViewModel {

    private final AccountVerification poSys;
    private final ConnectionUtil poConn;

    public VMID1Verification(@NonNull Application application) {
        super(application);
        this.poSys = new AccountVerification(application);
        this.poConn = new ConnectionUtil(application);
    }

    public void SubmitIDPicture(IDDetail foVal, OnSubmitIDPictureListener listener){
        new SubmitIDTask(listener).execute(foVal);
    }

    private class SubmitIDTask extends AsyncTask<IDDetail, Void, Boolean>{

        private final OnSubmitIDPictureListener listener;

        private String message;

        public SubmitIDTask(OnSubmitIDPictureListener listener) {
            this.listener = listener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listener.OnSubmit("Loan Application", "Uploading id picture. Please wait...");
        }

        @Override
        protected Boolean doInBackground(IDDetail... args) {
            try{
                if(!poConn.isDeviceConnected()){
                    message = "Unable to connect.";
                    return false;
                }

                IDDetail loDetail = args[0];
                String lsFilePath = loDetail.getsFrntPath();
                String lsFileName = loDetail.getsFrontImg();

                if(!poSys.SubmitIDVerification(lsFilePath, lsFileName)){
                    message = poSys.getMessage();
                    return false;
                }

                if(!loDetail.getcHasBackx().equalsIgnoreCase("1")){
                    return true;
                }

                Thread.sleep(1000);

                lsFilePath = loDetail.getsBackPath();
                lsFileName = loDetail.getsBackImgx();
                if(!poSys.SubmitIDVerification(lsFilePath, lsFileName)){
                    message = poSys.getMessage();
                    return false;
                }

                return true;
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean isSuccess) {
            super.onPostExecute(isSuccess);
            if(!isSuccess){
                listener.OnFailed(message);
            } else {
                listener.OnSuccess("Id picture uploaded successfully.");
            }
        }
    }
}