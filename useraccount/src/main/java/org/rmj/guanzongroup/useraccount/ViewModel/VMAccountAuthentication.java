package org.rmj.guanzongroup.useraccount.ViewModel;

import static org.rmj.g3appdriver.utils.CallbackJson.CallbackStatus.FAILED;
import static org.rmj.g3appdriver.utils.CallbackJson.CallbackStatus.SUCCESS;
import static org.rmj.g3appdriver.utils.CallbackJson.parse;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RNotificationInfo;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.etc.Telephony;
import org.rmj.g3appdriver.lib.Account.AccountAuthentication;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;
import org.rmj.g3appdriver.utils.Task.OnTaskExecuteListener;
import org.rmj.g3appdriver.utils.Task.TaskExecutor;

public class VMAccountAuthentication extends AndroidViewModel {
    private static final String TAG = VMAccountAuthentication.class.getSimpleName();
    private final ConnectionUtil poConnect;
    private final AccountAuthentication poActAuth;
    private final AccountInfo poAccount;
    private final Telephony poDevice;
    private String sMessage;
    private String cResult = "0";
    private String psOtpxxx = "";
    private String psVerify = "";

    public VMAccountAuthentication(@NonNull Application application) {
        super(application);
        Log.e(TAG, "Initialized");

        this.poConnect = new ConnectionUtil(application);
        this.poActAuth = new AccountAuthentication(application);
        this.poAccount = new AccountInfo(application);
        this.poDevice = new Telephony(application);
    }
    public String GetMobileNo(){
        if(!poAccount.getMobileNo().isEmpty()){
            return poAccount.getMobileNo();
        }

        if(!poDevice.getMobilNumbers().isEmpty()){
            return poDevice.getMobilNumbers();
        }

        return "";
    }
    public void LoginAccount(AccountAuthentication.LoginCredentials foCrednts, AuthenticationCallback foCallbck) {
        //new LoginAccountTask(poConnect, poActAuth, poClientx, foCallbck).execute(foCrednts);
        TaskExecutor.Execute(foCrednts, new OnTaskExecuteListener() {
            @Override
            public void OnPreExecute() {
                foCallbck.onLoad();
            }

            @Override
            public Object DoInBackground(Object args) {
                try {
                    AccountAuthentication.LoginCredentials foCrednts = (AccountAuthentication.LoginCredentials) args;
                    if (!poConnect.isDeviceConnected()){
                        sMessage = "Server no response";
                        return "0";
                    }

                    poActAuth.LoginAccount(foCrednts, new AccountAuthentication.OnLoginCallback() {
                        @Override
                        public void OnSuccessLogin(String message) {
                            cResult = "1";
                            sMessage = message;

                            poAccount.setLoginStatus(true);
                        }
                        @Override
                        public void OnFailedLogin(String message) {
                            cResult = "0";
                            sMessage = message;
                        }
                        @Override
                        public void OnAccountVerification(String args, String args1) {
                            psOtpxxx = args;
                            psVerify = args1;
                            cResult = "2";
                        }
                    });

                    return cResult;
                }catch (Exception e){
                    sMessage = e.getMessage();
                    return "0";
                }
            }
            @Override
            public void OnPostExecute(Object object) {
                String result = (String) object;
                switch (result){
                    case "0":
                        foCallbck.onFailed(sMessage);
                        break;
                    case "1":
                        foCallbck.onSuccess(sMessage);
                        break;
                    case "2":
                        foCallbck.onVerifiy(psOtpxxx, psVerify);
                        break;
                }
            }
        });
    }
    public void RegisterAccount(AccountAuthentication.AccountCredentials foCrednts, AuthTransactionCallback foCallbck) {
        //new RegisterAccountTask(poConnect, poActAuth, foCallbck).execute(foCrednts);
        TaskExecutor.Execute(foCrednts, new OnTaskExecuteListener() {
            @Override
            public void OnPreExecute() {
                foCallbck.onLoad();
            }

            @Override
            public Object DoInBackground(Object args) {
                final String[] lsResultx = {""};

                try {
                    AccountAuthentication.AccountCredentials loCrednts = (AccountAuthentication.AccountCredentials) args;

                    if (!poConnect.isDeviceConnected()){
                        lsResultx[0] = parse(FAILED, AppConstants.SERVER_NO_RESPONSE());
                    }else {
                        poActAuth.RegisterAccount(loCrednts, new AccountAuthentication.OnCreateAccountCallback() {
                            @Override
                            public void OnSuccessRegister(String message) {
                                lsResultx[0] = parse(SUCCESS, message);
                            }

                            @Override
                            public void OnFailedRegister(String message) {
                                lsResultx[0] = parse(FAILED, message);
                            }
                        });
                    }
                }catch (Exception e){
                    lsResultx[0] = parse(FAILED, TAG + ": " + e.getMessage());
                }

                return lsResultx[0];
            }
            @Override
            public void OnPostExecute(Object object) {
                String result = (String) object;
                setCallBack(result, foCallbck);
            }
        });
    }
    public void RetrievePassword(String fsEmailxx, AuthTransactionCallback foCallbck) {
        //new RetrievePasswordTask(poConnect, poActAuth, foCallbck).execute(fsEmailxx);
        TaskExecutor.Execute(fsEmailxx, new OnTaskExecuteListener() {
            @Override
            public void OnPreExecute() {
                foCallbck.onLoad();
            }

            @Override
            public Object DoInBackground(Object args) {
                final String[] lsResultx = {""};
                String lsEmailAd = (String) args;

                try {
                    if (!poConnect.isDeviceConnected()){
                        lsResultx[0] = parse(FAILED, AppConstants.SERVER_NO_RESPONSE());
                    }else {
                        poActAuth.RetrievePassword(lsEmailAd, new AccountAuthentication.OnRetrievePasswordCallback() {
                            @Override
                            public void OnSuccessRetrieve(String message) {
                                lsResultx[0] = parse(SUCCESS, message);
                            }

                            @Override
                            public void OnFailedRetrieve(String message) {
                                lsResultx[0] = parse(FAILED, message);
                            }
                        });
                    }
                }catch (Exception e){
                    lsResultx[0] = parse(FAILED, TAG + ": " + e.getMessage());
                }

                return lsResultx[0];
            }

            @Override
            public void OnPostExecute(Object object) {
                String result = (String) object;
                setCallBack(result, foCallbck);
            }
        });
    }
    public void ActivateAccount(String Entry, String Otp, String Address, AuthTransactionCallback callback){
        if(Entry.equalsIgnoreCase(Otp)) {
            //new ActivateAccTask(callback).execute(Address);
            TaskExecutor.Execute(Address, new OnTaskExecuteListener() {
                @Override
                public void OnPreExecute() {
                    callback.onLoad();
                }

                @Override
                public Object DoInBackground(Object args) {
                    String params = (String) args;

                    Boolean result = Activate(params);
                    return result;
                }

                @Override
                public void OnPostExecute(Object object) {
                    Boolean result = (Boolean) object;
                    if(result){
                        callback.onSuccess(sMessage);
                    } else {
                        callback.onFailed(sMessage);
                    }
                }
            });
        } else {
            callback.onFailed("Invalid OTP detected!");
        }
    }
    private Boolean Activate(String Address){
        try{
            String lsResponse = WebClient.httpsPostJSon(Address, new JSONObject().toString(), null);
            if(lsResponse == null){
                sMessage = "Unable to confirm your account. No server response has received.";
                return false;
            } else if(lsResponse.isEmpty()){
                sMessage = "Unable to confirm your account. No server response has received.";
                return false;
            } else if(lsResponse.equalsIgnoreCase("Your account was activated successfully. You can now login on Guanzon App.")){
                sMessage = "Your Account has been activated successfully.";
                return true;
            } else if(lsResponse.equalsIgnoreCase("Unable to verify account. Your account cannot be updated.")){
                sMessage = "Unable to confirm your account. No server response has received.";
                return false;
            } else {
                sMessage = "Unable to confirm your account. Unknown problem occurred. Please try again.";
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            sMessage = e.getMessage();
            return false;
        }
    }
    private static void setCallBack(String fsResultx, AuthTransactionCallback foCallBck) {
        try {
            JSONObject loJson = new JSONObject(fsResultx);
            String lsStatus =String.valueOf(loJson.get("status"));
            String lsMessage = loJson.getString("message");
            if(lsStatus.equals(SUCCESS.toString())) {
                foCallBck.onSuccess(lsMessage);
            } else if(lsStatus.equals(FAILED.toString())) {
                foCallBck.onFailed(lsMessage);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //TODO: REVISED CODE, DUE TO ASYNCTASK LIBRARY DEPRECATION. WHICH COULD BE REMOVED ON FUTURE VERSIONS
    /*private static class LoginAccountTask extends AsyncTask<AccountAuthentication.LoginCredentials, Void, String> {
        private final ConnectionUtil loConnect;
        private final AccountAuthentication loActAuth;
        private final RClientInfo loClientx;
        private final AuthenticationCallback loCallbck;

        private char cResult = '0';
        private String psMssage = "";
        private String psOtpxxx = "";
        private String psVerify = "";

        private LoginAccountTask(ConnectionUtil foConnect, AccountAuthentication foActAuth, RClientInfo foClientx, AuthenticationCallback foCallbck) {
            this.loConnect = foConnect;
            this.loActAuth = foActAuth;
            this.loClientx = foClientx;
            this.loCallbck = foCallbck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected String doInBackground(AccountAuthentication.LoginCredentials... foCrednts) {
            AccountAuthentication.LoginCredentials loCrednts = foCrednts[0];
            final String[] lsResultx = {""};
            try {
                if(loConnect.isDeviceConnected()) {
                    loActAuth.LoginAccount(loCrednts, new AccountAuthentication.OnLoginCallback() {
                        @Override
                        public void OnSuccessLogin(String message) {
                            psMssage = message;
                            cResult = '1';
                            try {
                                lsResultx[0] = parse(SUCCESS, message);

                            } catch (Exception e){
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void OnFailedLogin(String message) {
                            psMssage = message;
                            cResult = '0';
                            lsResultx[0] = parse(FAILED, message);
                        }

                        @Override
                        public void OnAccountVerification(String args, String args1) {
                            psOtpxxx = args;
                            psVerify = args1;
                            cResult = '2';
                        }
                    });
                } else {
                    psMssage = "Server no response.";
                    cResult = '0';
                }
            } catch (Exception e) {
                e.printStackTrace();
                psMssage = e.getMessage();
                cResult = '0';
            }
            return psMssage;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            switch (cResult){
                case '0':
                    loCallbck.onFailed(psMssage);
                    break;
                case '1':
                    loCallbck.onSuccess(psMssage);
                    break;
                case '2':
                    loCallbck.onVerifiy(psOtpxxx, psVerify);
                    break;
            }
        }
    }
    private static class RegisterAccountTask extends AsyncTask<AccountAuthentication.AccountCredentials, Void, String> {
        private final ConnectionUtil loConnect;
        private final AccountAuthentication loActAuth;
        private final AuthTransactionCallback loCallbck;

        private RegisterAccountTask(ConnectionUtil foConnect, AccountAuthentication foActAuth, AuthTransactionCallback foCallbck) {
            this.loConnect = foConnect;
            this.loActAuth = foActAuth;
            this.loCallbck = foCallbck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected String doInBackground(AccountAuthentication.AccountCredentials... foCrednts) {
            AccountAuthentication.AccountCredentials loCrednts = foCrednts[0];
            final String[] lsResultx = {""};
            try {
                if(loConnect.isDeviceConnected()) {
                    loActAuth.RegisterAccount(loCrednts, new AccountAuthentication.OnCreateAccountCallback() {
                        @Override
                        public void OnSuccessRegister(String message) {
                            lsResultx[0] = parse(SUCCESS, message);
                        }

                        @Override
                        public void OnFailedRegister(String message) {
                            lsResultx[0] = parse(FAILED, message);
                        }
                    });
                } else {
                    lsResultx[0] = parse(FAILED, AppConstants.SERVER_NO_RESPONSE());
                }
            } catch (Exception e) {
                e.printStackTrace();
                lsResultx[0] = parse(FAILED, TAG + ": " + e.getMessage());
            }
            return lsResultx[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setCallBack(s, loCallbck);
        }
    }
    private static class RetrievePasswordTask extends AsyncTask<String, Void, String> {
        private final ConnectionUtil loConnect;
        private final AccountAuthentication loActAuth;
        private final AuthTransactionCallback loCallbck;

        private RetrievePasswordTask(ConnectionUtil foConnect, AccountAuthentication foActAuth, AuthTransactionCallback foCallbck) {
            this.loConnect = foConnect;
            this.loActAuth = foActAuth;
            this.loCallbck = foCallbck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected String doInBackground(String... strings) {
            String lsEmailAd = "";
            final String[] lsResultx = {""};
            try {
                lsEmailAd = strings[0];
                if(loConnect.isDeviceConnected()) {
                    loActAuth.RetrievePassword(lsEmailAd, new AccountAuthentication.OnRetrievePasswordCallback() {
                        @Override
                        public void OnSuccessRetrieve(String message) {
                            lsResultx[0] = parse(SUCCESS, message);
                        }

                        @Override
                        public void OnFailedRetrieve(String message) {
                            lsResultx[0] = parse(FAILED, message);
                        }
                    });
                } else {
                    lsResultx[0] = parse(FAILED, AppConstants.SERVER_NO_RESPONSE());
                }
            } catch (Exception e) {
                e.printStackTrace();
                lsResultx[0] = parse(FAILED, TAG + ": " + e.getMessage());
            }
            return lsResultx[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setCallBack(s, loCallbck);
        }
    }

    private static class ActivateAccTask extends AsyncTask<String, Void, String>{

        private final AuthTransactionCallback callback;
        private boolean isSuccess;
        private String message;

        public ActivateAccTask(AuthTransactionCallback callback) {
            this.callback = callback;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.onLoad();
        }

        @Override
        protected String doInBackground(String... strings) {
            isSuccess = Activate(strings[0]);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(isSuccess){
                callback.onSuccess(message);
            } else {
                callback.onFailed(message);
            }
        }

        boolean Activate(String Address){
            try{
                String lsResponse = WebClient.httpsPostJSon(Address, new JSONObject().toString(), null);
                if(lsResponse == null){
                    message = "Unable to confirm your account. No server response has received.";
                    return false;
                } else if(lsResponse.isEmpty()){
                    message = "Unable to confirm your account. No server response has received.";
                    return false;
                } else if(lsResponse.equalsIgnoreCase("Your account was activated successfully. You can now login on Guanzon App.")){
                    message = "Your Account has been activated successfully.";
                    return true;
                } else if(lsResponse.equalsIgnoreCase("Unable to verify account. Your account cannot be updated.")){
                    message = "Unable to confirm your account. No server response has received.";
                    return false;
                } else {
                    message = "Unable to confirm your account. Unknown problem occurred. Please try again.";
                    return false;
                }
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }
    }

    public void ResendOtp(AuthTransactionCallback callback){
        new ResendOTPTask(callback).execute();
    }
    private static class ResendOTPTask extends AsyncTask<String, Void, String>{

        private final AuthTransactionCallback callback;

        public ResendOTPTask(AuthTransactionCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
    public void StartTimer(TimerListener listener){
        new OtpTimerTask(listener).execute();
    }
    private static class OtpTimerTask extends AsyncTask<String, Integer, String>{

        private final TimerListener listener;

        public OtpTimerTask(TimerListener listener) {
            this.listener = listener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int x = 60; x >= 0; x--) {
                    publishProgress(x);
                    Thread.sleep(1000);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            listener.OnTimerCountdown(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listener.OnFinish();
        }
    }*/

    public interface AuthTransactionCallback {
        void onLoad();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
    }

    public interface AuthenticationCallback {
        void onLoad();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
        void onVerifiy(String args1, String args2);
    }

    public interface TimerListener{
        void OnStart();
        void OnTimerCountdown(int progress);
        void OnFinish();
    }
}
