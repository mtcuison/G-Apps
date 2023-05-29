package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.utils.Task.OnDoBackgroundTaskListener;
import org.rmj.g3appdriver.utils.Task.TaskExecutor;
import org.rmj.guanzongroup.guanzonapp.BuildConfig;

import java.util.Objects;

public class VMSplashScreen extends AndroidViewModel {
    private static final String TAG = VMSplashScreen.class.getSimpleName();

    private final Application instance;

    private final String[] laPermissions =  new String[]{
        Manifest.permission.POST_NOTIFICATIONS,
        Manifest.permission.MANAGE_EXTERNAL_STORAGE,
        Manifest.permission.READ_PHONE_NUMBERS,
        Manifest.permission.INTERNET,
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.GET_ACCOUNTS,
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,};

    public VMSplashScreen(@NonNull Application application) {
        super(application);
        this.instance = application;
        AppConfigPreference loConfig = AppConfigPreference.getInstance(instance);
        loConfig.setProductID("GuanzonApp");
        loConfig.setUpdateLocally(false);
        loConfig.setTestCase(true);
        loConfig.setPackageName(BuildConfig.APPLICATION_ID);
        loConfig.setupAppVersionInfo(BuildConfig.VERSION_CODE, BuildConfig.VERSION_NAME, "");
    }

    public interface OnInitializCallback {
        void OnLoad(String args);
        void OnFinished(String args);
    }

    public void InitializeData(OnInitializCallback callback){
        TaskExecutor.Execute(null, new OnDoBackgroundTaskListener() {
            @Override
            public Object DoInBackground(Object args) {
                return null;
            }

            @Override
            public void OnPostExecute(Object object) {
                callback.OnFinished("");
            }
        });
    }

//    private static class InitDataTask extends AsyncTask<String, Void, String>{
//
//        private final Context mContext;
//        private final OnInitializCallback listener;
//
//        GCardSystem.GCardSystemCallback poCallback = new GCardSystem.GCardSystemCallback() {
//            @Override
//            public void OnSuccess(String args) {
//                Log.d(TAG, "Import Success...");
//            }
//
//            @Override
//            public void OnFailed(String message) {
//                Log.e(TAG, "Import failed... " + message);
//            }
//        };
//
//        public InitDataTask(Context mContext, OnInitializCallback listener) {
//            this.mContext = mContext;
//            this.listener = listener;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            listener.OnLoad("Started!");
//        }
//
//        @Override
//        protected String doInBackground(String... strings) {
//            try {
//                GuanzonAppConfig loConfig = new GuanzonAppConfig(mContext);
//                if(loConfig.isAppFirstLaunch()){
//                    RAddressMobile loAddress = new RAddressMobile(mContext);
//                    loAddress.ImportBarangayList();
//                    pause();
//                    loAddress.ImportTownList();
//                    pause();
//                    loAddress.ImportProvinceList();
//                    pause();
//                    loAddress.ImportCountryList();
//                }
//                pause();
//                //TODO : Revise importing data to improve speed on splash screen...
//                //Import Dashboard products only if possible,
//                // import other important must be imported before the operation of usage...
//                if (new RProduct(mContext).ImportProductList()) {
//                    Log.d(TAG, "Product Sales imported successfully...");
//                }
//                pause();
//                iGCardSystem loGcard = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.EXTRAS);
//                loGcard.DownloadBranchesList(poCallback);
//                pause();
//                loGcard.DownloadPromotions(poCallback);
//                pause();
////                loGcard.DownloadNewsEvents(poCallback);
////                Log.d(TAG, "News events imported successfully...");
////                pause();
//
//                if (new AccountInfo(mContext).getLoginStatus()) {
//                    RNotificationInfo loNotif = new RNotificationInfo(mContext);
//                    loNotif.ImportClientNotifications(0);
//                    pause();
//                    loGcard = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
//                    loGcard.DownloadGcardNumbers(poCallback);
//                    if(loGcard.hasActiveGcard().size() > 0){
//                        pause();
//                        loGcard.DownloadMCServiceInfo(poCallback);
//                        pause();
//                        loGcard.DownloadTransactions(poCallback);
//                        pause();
//                    } else {
//                        Log.e(TAG, "No gcard registered on this account.");
//                    }
//                    loGcard = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.REDEMPTION);
//                    loGcard.DownloadRedeemables(poCallback);
//
//                    if(new AccountInfo(mContext).getVerificationStatus() > 0){
//                        if(new ROrder(mContext).ImportMarketPlaceItemCart()){
//                            Log.d(TAG, "Marketplace cart items imported successfully...");
//                        }
//                    } else {
//                        Log.e(TAG, "User doesn't have complete details for marketplace.");
//                    }
//                } else {
//                    Log.e(TAG, "No account session found.");
//                }
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            listener.OnFinished("Finished!");
//        }
//
//        private void pause() {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
