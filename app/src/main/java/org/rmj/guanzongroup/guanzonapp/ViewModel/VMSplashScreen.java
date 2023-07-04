package org.rmj.guanzongroup.guanzonapp.ViewModel;

import static org.rmj.g3appdriver.etc.AppConstants.getLocalMessage;

import android.Manifest;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.g3appdriver.GConnect.GCard.DigitalGcard.GCard;
import org.rmj.g3appdriver.GConnect.GCard.DigitalGcard.GCardLedger;
import org.rmj.g3appdriver.GConnect.GCard.Redemption.GCardItems;
import org.rmj.g3appdriver.GConnect.GCard.Service.MCService;
import org.rmj.g3appdriver.GConnect.Marketplace.Product.MpProducts;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.lib.Etc.Barangay;
import org.rmj.g3appdriver.lib.Etc.Branch;
import org.rmj.g3appdriver.lib.Etc.Country;
import org.rmj.g3appdriver.lib.Etc.Province;
import org.rmj.g3appdriver.lib.Etc.Town;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Task.OnLoadApplicationListener;
import org.rmj.g3appdriver.utils.Task.TaskExecutor;
import org.rmj.guanzongroup.guanzonapp.BuildConfig;

public class VMSplashScreen extends AndroidViewModel {
    private static final String TAG = VMSplashScreen.class.getSimpleName();

    private final Application instance;

    private final AppConfigPreference poConfig;
    private final ConnectionUtil poConn;

    private String message;

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
        this.poConfig = AppConfigPreference.getInstance(instance);
        this.poConn = new ConnectionUtil(instance);
        poConfig.setProductID("GuanzonApp");
        poConfig.setUpdateLocally(false);
        poConfig.setTestCase(true);
        poConfig.setPackageName(BuildConfig.APPLICATION_ID);
        poConfig.setupAppVersionInfo(BuildConfig.VERSION_CODE, BuildConfig.VERSION_NAME, "");
    }

    public interface OnInitializeCallback {
        void OnLoad(String args);

        void OnProgress(int progress);
        void OnFinished(String args);
    }

    public void InitializeData(OnInitializeCallback callback){
        TaskExecutor loLoadApp = new TaskExecutor();
        loLoadApp.setOnLoadApplicationListener(new OnLoadApplicationListener() {
            @Override
            public Object DoInBackground() {
                try{
//                    new Town(instance).ImportTown();
//                    loLoadApp.publishProgress(1);
//                    pause();

//                    new Province(instance).ImportProvince();
//                    loLoadApp.publishProgress(2);
//                    pause();

//                    new Country(instance).ImportCountry();
//                    loLoadApp.publishProgress(3);
//                    pause();

//                    new Barangay(instance).ImportBarangay();
//                    loLoadApp.publishProgress(4);
//                    pause();

//                    new Branch(instance).ImportBranches();
//                    loLoadApp.publishProgress(5);
//                    pause();

                    new MpProducts(instance).ImportMPProducts();
                    loLoadApp.publishProgress(6);
                    pause();

                    new GCard(instance).ImportGcard();
                    loLoadApp.publishProgress(8);
                    pause();

                    //Add importing promotions
                    loLoadApp.publishProgress(9);
                    pause();

                    new GCardLedger(instance).ImportOfflineTransactions();
                    loLoadApp.publishProgress(10);
                    pause();

                    new GCardLedger(instance).ImportOnlineTransactions();
                    loLoadApp.publishProgress(11);
                    pause();

                    new GCardLedger(instance).ImportPreOrderTransactions();
                    loLoadApp.publishProgress(12);
                    pause();

                    new GCardLedger(instance).ImportRedemptionTransaction();
                    loLoadApp.publishProgress(13);
                    pause();

                    new GCardItems(instance).ImportRedeemable();
                    loLoadApp.publishProgress(14);
                    pause();

                    new MCService(instance).ImportServiceInfo();
                    loLoadApp.publishProgress(14);
                    pause();
                } catch (Exception e){
                    e.printStackTrace();
                    message = getLocalMessage(e);
                    return 0;
                }
                return null;
            }

            @Override
            public void OnProgress(int progress) {
                callback.OnProgress(progress);
            }

            @Override
            public void OnPostExecute(Object object) {
                callback.OnFinished("Initialization Completed");
            }
        });
        loLoadApp.Execute();
    }

    private void pause() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
