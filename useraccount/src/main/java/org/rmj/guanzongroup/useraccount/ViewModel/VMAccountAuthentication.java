package org.rmj.guanzongroup.useraccount.ViewModel;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.Account.AccountAuthentication;
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

    public void LoginAccount(AccountAuthentication.LoginCredentials foCrednts,
                             AuthTransactionCallback foCallbck) {
        new LoginAccountTask(poConnect, foCrednts, poActAuth, foCallbck).execute();
    }

    public void RegisterAccount(AccountAuthentication.AccountCredentials foCrednts,
                                AuthTransactionCallback foCallbck) {
        new RegisterAccountTask(poConnect, foCrednts, poActAuth, foCallbck).execute();
    }

    public void RetrievePassword(String fsEmailxx,
                                 AuthTransactionCallback foCallbck) {
        new RetrievePasswordTask(poConnect, poActAuth, foCallbck).execute(fsEmailxx);
    }

    public SignUpInfoModel getSignUpModel() {
        return poSignUpM;
    }

    private static class LoginAccountTask extends AsyncTask<Void, Void, Void> {
        private final ConnectionUtil loConnect;
        private final AccountAuthentication.LoginCredentials loCrednts;
        private final AccountAuthentication loActAuth;
        private final AuthTransactionCallback loCallbck;

        private LoginAccountTask(ConnectionUtil foConnect, AccountAuthentication.LoginCredentials foCrednts, AccountAuthentication foActAuth, AuthTransactionCallback foCallbck) {
            this.loConnect = foConnect;
            this.loCrednts = foCrednts;
            this.loActAuth = foActAuth;
            this.loCallbck = foCallbck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                if(loConnect.isDeviceConnected()) {
                    loActAuth.LoginAccount(loCrednts, new AccountAuthentication.OnLoginCallback() {
                        @Override
                        public void OnSuccessLogin(String message) {
                            loCallbck.onSuccess(message);
                        }

                        @Override
                        public void OnFailedLogin(String message) {
                            loCallbck.onFailed(message);
                        }
                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch (Exception e) {
                e.printStackTrace();
                loCallbck.onFailed(TAG + ": " + e.getMessage());
            }
            return null;
        }

    }

    private static class RegisterAccountTask extends AsyncTask<Void, Void, Void> {
        private final ConnectionUtil loConnect;
        private final AccountAuthentication.AccountCredentials loCrednts;
        private final AccountAuthentication loActAuth;
        private final AuthTransactionCallback loCallbck;

        private RegisterAccountTask(ConnectionUtil foConnect, AccountAuthentication.AccountCredentials foCrednts, AccountAuthentication foActAuth, AuthTransactionCallback foCallbck) {
            this.loConnect = foConnect;
            this.loCrednts = foCrednts;
            this.loActAuth = foActAuth;
            this.loCallbck = foCallbck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                if(loConnect.isDeviceConnected()) {
                    loActAuth.RegisterAccount(loCrednts, new AccountAuthentication.OnCreateAccountCallback() {
                        @Override
                        public void OnSuccessRegister(String message) {
                            loCallbck.onSuccess(message);
                        }

                        @Override
                        public void OnFailedRegister(String message) {
                            loCallbck.onFailed(message);
                        }
                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch (Exception e) {
                e.printStackTrace();
                loCallbck.onFailed(TAG + ": " + e.getMessage());
            }
            return null;
        }

    }

    private static class RetrievePasswordTask extends AsyncTask<String, Void, Void> {
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
        protected Void doInBackground(String... strings) {
            String lsEmailAd = "";
            try {
                lsEmailAd = strings[0];
                if(loConnect.isDeviceConnected()) {
                    loActAuth.RetrievePassword(lsEmailAd, new AccountAuthentication.OnRetrievePasswordCallback() {
                        @Override
                        public void OnSuccessRetrieve(String message) {
                            loCallbck.onSuccess(message);
                        }

                        @Override
                        public void OnFailedRetrieve(String message) {
                            loCallbck.onFailed(message);
                        }
                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch (Exception e) {
                e.printStackTrace();
                loCallbck.onFailed(TAG + ": " + e.getMessage());
            }
            return null;
        }

    }

    public interface AuthTransactionCallback {
        void onLoad();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
    }

}
