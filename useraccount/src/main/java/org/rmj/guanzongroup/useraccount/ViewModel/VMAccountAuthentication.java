package org.rmj.guanzongroup.useraccount.ViewModel;

import static org.rmj.g3appdriver.utils.CallbackJson.CallbackStatus.FAILED;
import static org.rmj.g3appdriver.utils.CallbackJson.CallbackStatus.SUCCESS;
import static org.rmj.g3appdriver.utils.CallbackJson.parse;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.Account.AccountAuthentication;
import org.rmj.g3appdriver.utils.CallbackJson;
import org.rmj.guanzongroup.useraccount.Model.SignUpInfoModel;

public class VMAccountAuthentication extends AndroidViewModel {
    private static final String TAG = VMAccountAuthentication.class.getSimpleName();
    private final ConnectionUtil poConnect;
    private final AccountAuthentication poActAuth;
    private final SignUpInfoModel poSignUpM;

    public VMAccountAuthentication(@NonNull Application application) {
        super(application);
        Log.e(TAG, "Initialized");
        this.poConnect = new ConnectionUtil(application);
        this.poActAuth = new AccountAuthentication(application);
        this.poSignUpM = new SignUpInfoModel();
    }

    public void LoginAccount(AccountAuthentication.LoginCredentials foCrednts, AuthTransactionCallback foCallbck) {
        new LoginAccountTask(poConnect, poActAuth, foCallbck).execute(foCrednts);
    }

    public void RegisterAccount(AccountAuthentication.AccountCredentials foCrednts, AuthTransactionCallback foCallbck) {
        new RegisterAccountTask(poConnect, poActAuth, foCallbck).execute(foCrednts);
    }

    public void RetrievePassword(String fsEmailxx, AuthTransactionCallback foCallbck) {
        new RetrievePasswordTask(poConnect, poActAuth, foCallbck).execute(fsEmailxx);
    }

    public SignUpInfoModel getSignUpModel() {
        return poSignUpM;
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

    private static class LoginAccountTask extends AsyncTask<AccountAuthentication.LoginCredentials, Void, String> {
        private final ConnectionUtil loConnect;
        private final AccountAuthentication loActAuth;
        private final AuthTransactionCallback loCallbck;

        private LoginAccountTask(ConnectionUtil foConnect, AccountAuthentication foActAuth, AuthTransactionCallback foCallbck) {
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
        protected String doInBackground(AccountAuthentication.LoginCredentials... foCrednts) {
            AccountAuthentication.LoginCredentials loCrednts = foCrednts[0];
            final String[] lsResultx = {""};
            try {
                if(loConnect.isDeviceConnected()) {
                    loActAuth.LoginAccount(loCrednts, new AccountAuthentication.OnLoginCallback() {
                        @Override
                        public void OnSuccessLogin(String message) {
                            lsResultx[0] = parse(SUCCESS, message);
                        }

                        @Override
                        public void OnFailedLogin(String message) {
                            lsResultx[0] = parse(FAILED, message);
                        }
                    });
                } else {
                    lsResultx[0] = parse(FAILED, AppConstants.SERVER_NO_RESPONSE());
                }
            } catch (Exception e) {
                e.printStackTrace();
                lsResultx[0] = parse(FAILED,TAG + ": " + e.getMessage());
            }
            return lsResultx[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setCallBack(s, loCallbck);
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

    public interface AuthTransactionCallback {
        void onLoad();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
    }

}
