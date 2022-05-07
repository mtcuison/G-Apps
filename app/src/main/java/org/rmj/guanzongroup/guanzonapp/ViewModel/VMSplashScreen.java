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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RGcardApp;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.etc.oLoadStat;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.Objects;

public class VMSplashScreen extends AndroidViewModel {
    private static final String TAG = VMSplashScreen.class.getSimpleName();

    private final Context mContext;

    private final String[] laPermissions =  new String[]{
        Manifest.permission.MANAGE_EXTERNAL_STORAGE,
        Manifest.permission.INTERNET,
        Manifest.permission.ACCESS_NETWORK_STATE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.GET_ACCOUNTS,
        Manifest.permission.CAMERA,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.REQUEST_INSTALL_PACKAGES};

    private final MutableLiveData<Boolean> poIsGranted = new MutableLiveData<>();
    private final MutableLiveData<oLoadStat> poLoadStat = new MutableLiveData<>();

    public VMSplashScreen(@NonNull Application application) {
        super(application);
        this.mContext = application;
    }

    public interface OnInitializeData{
        void OnLoad(String args);
        void OnFinished(String args);
    }

    public void setupApp(){
        GuanzonAppConfig loConfig = new GuanzonAppConfig(mContext);
        loConfig.setTestCase(true);
        loConfig.setIfPermissionsGranted(hasPermissions(mContext, laPermissions));
        poLoadStat.setValue(new oLoadStat(
                loConfig.IsPermissionsGranted(),
                new AccountInfo(mContext).getLoginStatus(),
                !new AccountInfo(mContext).getClientID().isEmpty()));
    }

    public void setPermissionsGranted(boolean val){
        oLoadStat loStat = poLoadStat.getValue();
        Objects.requireNonNull(loStat).setPermissionGranted(val);
        poLoadStat.setValue(loStat);
        new GuanzonAppConfig(mContext).setIfPermissionsGranted(val);
    }

    public String[] GetPermissions(){
        return laPermissions;
    }

    public LiveData<Boolean> CheckIfPermissionsGranted(){
        return poIsGranted;
    }

    public LiveData<oLoadStat> GetLoadStatus(){
        return poLoadStat;
    }

    private static boolean hasPermissions(Context context, String... permissions){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && permissions!=null ){
            for (String permission: permissions){
                if(ActivityCompat.checkSelfPermission(context, permission)!= PackageManager.PERMISSION_GRANTED){
                    return false;
                }
            }
        }
        return true;
    }

    public void InitializeData(OnInitializeData listener){
        new InitDataTask(mContext, listener).execute();
    }

    private static class InitDataTask extends AsyncTask<String, Void, String>{

        private final Context mContext;
        private final OnInitializeData listener;

        GCardSystem.GCardSystemCallback poCallback = new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                Log.d(TAG, "Import Success...");
            }

            @Override
            public void OnFailed(String message) {
                Log.e(TAG, "Import failed... " + message);
            }
        };

        public InitDataTask(Context mContext, OnInitializeData listener) {
            this.mContext = mContext;
            this.listener = listener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listener.OnLoad("Started!");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
//                importAddresses();
                //TODO : Revise importing data to improve speed on splash screen...
                //Import Dashboard products only if possible,
                // import other important must be imported before the operation of usage...
                if (new RProduct(mContext).ImportProductList()) {
                    Log.d(TAG, "Product Sales imported successfully...");
                }

                pause();
                iGCardSystem loGcard = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.EXTRAS);
                loGcard.DownloadBranchesList(poCallback);
                pause();

                if (new AccountInfo(mContext).getLoginStatus()) {
                    loGcard = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
                    loGcard.DownloadGcardNumbers(poCallback);
                    loGcard.DownloadRedeemables(poCallback);
                    if(new RGcardApp(mContext).hasActiveGcard().size() > 0){
                        pause();
                        loGcard.DownloadMCServiceInfo(poCallback);
                        pause();
                        loGcard.DownloadTransactions(poCallback);
                        pause();
                    } else {
                        Log.e(TAG, "No gcard registered on this account.");
                    }

                    if(!new AccountInfo(mContext).getClientID().isEmpty()){
                        if(new ROrder(mContext).ImportMarketPlaceItemCart()){
                            Log.d(TAG, "Marketplace cart items imported successfully...");
                        }
                    } else {
                        Log.e(TAG, "User doesn't have complete details for marketplace.");
                    }
                } else {
                    Log.e(TAG, "No account session found.");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            listener.OnFinished("Finished!");
        }

//        private void importAddresses() {
//            RAddressMobile poAddress = new RAddressMobile(mContext);
//            if(poAddress.ImportCountryList()) {
//                Log.d(TAG, "Country data imported successfully...");
//                pause();
//            }
//            if(poAddress.ImportProvinceList()) {
//                Log.d(TAG, "Province data imported successfully...");
//                pause();
//            }
//            if(poAddress.ImportTownList()) {
//                Log.d(TAG, "Town and City data imported successfully...");
//                pause();
//            }
//            if(poAddress.ImportBarangayList()) {
//                Log.d(TAG, "Barangay data Sales imported successfully...");
//                pause();
//            }
//        }

        private void pause() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
