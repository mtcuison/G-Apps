package org.rmj.guanzongroup.useraccount.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.Account.AccountVerification;

public class VMLoanIntro extends AndroidViewModel {
    private static final String TAG = VMLoanIntro.class.getSimpleName();

    private final AccountVerification poVerify;
    private final ConnectionUtil poConn;

    public interface OnGetMobileNo{
        void OnRetrieve(String args);
    }

    public interface OnSendOtpListener{
        void OnRequest(String title, String message);
        void OnSuccess(String args);
        void OnFailed(String message);
    }

    public VMLoanIntro(@NonNull Application application) {
        super(application);
        this.poVerify = new AccountVerification(application);
        this.poConn = new ConnectionUtil(application);
    }

    public void GetMobileNo(OnGetMobileNo listener){
        new GetMobileNoTask(listener).execute();
    }

    private class GetMobileNoTask extends AsyncTask<Void, Void, String>{

        private final OnGetMobileNo listener;

        public GetMobileNoTask(OnGetMobileNo listener) {
            this.listener = listener;
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{
                return poVerify.GetMobileNo();
            } catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            listener.OnRetrieve(result);
        }
    }

    public void SendOtp(String fsVal, OnSendOtpListener listener){
        new SendOtpTask(listener).execute(fsVal);
    }

    private class SendOtpTask extends AsyncTask<String, Void, String>{

        private final OnSendOtpListener listener;

        private String message;

        public SendOtpTask(OnSendOtpListener listener) {
            this.listener = listener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listener.OnRequest("Loan Application", "Sending OTP. Please wait...");
        }

        @Override
        protected String doInBackground(String... strings) {
            try{
                if(!poConn.isDeviceConnected()){
                    message = "Unable to connect.";
                    return null;
                }

                String result = poVerify.SendOTP(strings[0]);
                if(result == null){
                    message = poVerify.getMessage();
                    return null;
                }

                return result;
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if(result == null){
                listener.OnFailed(message);
            } else {
                listener.OnSuccess(result);
            }
        }
    }
}
