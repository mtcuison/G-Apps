package org.rmj.guanzongroup.marketplace.ViewModel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EEvents;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.dev.Database.Entities.EPromo;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RNotificationInfo;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.etc.FilterType;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;
import org.rmj.g3appdriver.utils.Task.OnDoBackgroundTaskListener;
import org.rmj.g3appdriver.utils.Task.TaskExecutor;

import java.util.List;

public class VMHome extends AndroidViewModel {
    private static final String TAG =VMHome.class.getSimpleName();
    private String lsPromo, lsPmUrl;
    private String lsEvent, lsEvUrl;
    private final RClientInfo poClient;
    private final RAddressMobile poAddress;
    private final RProduct poProduct;
    private final ROrder poOrder;
    private final ConnectionUtil poConn;
    private final RNotificationInfo poNotif;
    private iGCardSystem poSystem;
    private Context mContext;

    public interface OnViewGCardQrCode{
        void OnView(Bitmap foVal);
    }

    public interface OnValidateVerifiedUser{
        void OnValidate(String title, String message);
        void OnIncompleteAccountInfo();
        void OnAccountVerified();
        void OnAccountNotVerified();
        void OnFailed(String message);
    }

    public VMHome(@NonNull Application application) {
        super(application);
        this.mContext = application;
        this.poClient = new RClientInfo(application);
        this.poProduct = new RProduct(application);
        this.poAddress = new RAddressMobile(application);
        this.poOrder = new ROrder(application);
        this.poConn = new ConnectionUtil(application);
        this.poNotif = new RNotificationInfo(application);
        this.poSystem = new GCardSystem(application).getInstance(GCardSystem.CoreFunctions.GCARD);
        new GuanzonAppConfig(application).setFirstLaunch(false);
    }

    public LiveData<EClientInfo> getClientInfo() {
        return poClient.getClientInfo();
    }

    public LiveData<EGcardApp> getActiveGcard() {
        this.poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
        return poSystem.hasNoGcard();
    }

    public LiveData<EGcardApp> GetActiveGCard(){
        this.poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
        return poSystem.getGCardInfo();
    }

    public LiveData<List<DProduct.oProduct>> getProductList(int fnIndex) {
        return poProduct.GetProductsList(fnIndex, FilterType.DEFAULT, null, null);
    }

    public LiveData<Integer> GetUnreadMessagesCount(){
        return poNotif.GetUnreadMessagesCount();
    }

    public LiveData<Integer> GetCartItemCount(){
        return poOrder.GetCartItemCount();
    }

    public LiveData<Integer> GetToPayOrders(){
        return poOrder.GetToPayOrders();
    }

    public void ViewGCardQrCode(OnViewGCardQrCode callback){
        new CreateGCardQrCodeTask(callback).execute();
    }

    @SuppressLint("StaticFieldLeak")
    private class CreateGCardQrCodeTask extends AsyncTask<String, Void, Bitmap>{
        private final OnViewGCardQrCode callback;

        public CreateGCardQrCodeTask(OnViewGCardQrCode callback) {
            this.callback = callback;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
                return poSystem.GenerateGCardQrCode();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap s) {
//            callback.OnView(s);
            super.onPostExecute(s);
            callback.OnView(s);
        }
    }

    public interface OnLogoutListener{
        void OnLogout();
    }

    public void LogoutUserSession(OnLogoutListener listener){
        new LogoutTask(listener).execute();
    }

    private class LogoutTask extends AsyncTask<String, Void, String>{

        private final OnLogoutListener mListener;

        public LogoutTask(OnLogoutListener mListener) {
            this.mListener = mListener;
        }

        @Override
        protected String doInBackground(String... strings) {
            poClient.LogoutUserSession();
            new AccountInfo(mContext).LogoutUser();
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mListener.OnLogout();
        }
    }

    public interface OnActionCallback{
        void OnLoad();
        void OnSuccess(String args);
        void OnFailed(String args);
    }

    public void AddNewGCard(String fsVal, OnActionCallback callback){
        new AddNewGCardTask(callback).execute(fsVal);
    }

    private class AddNewGCardTask extends AsyncTask<String, Void, Boolean>{
        private final OnActionCallback callback;

        private boolean isSuccess = false;
        private String message = "";

        public AddNewGCardTask(OnActionCallback callback) {
            this.callback = callback;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.OnLoad();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                ConnectionUtil loConn = new ConnectionUtil(mContext);
                if(loConn.isDeviceConnected()) {
                    poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
                    poSystem.AddGCardQrCode(strings[0], new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            isSuccess = true;
                            message = args;
                        }

                        @Override
                        public void OnFailed(String fsMsg) {
                            isSuccess = false;
                            message = fsMsg;
                        }
                    });
                } else {
                    isSuccess = false;
                    message = "Unable to connect";
                }
            } catch (Exception e) {
                e.printStackTrace();
                isSuccess = false;
                message = e.getMessage();
            }
            return isSuccess;
        }

        @Override
        protected void onPostExecute(Boolean s) {
            super.onPostExecute(s);
            if(s){
                callback.OnSuccess(message);
            } else {
                callback.OnFailed(message);
            }
        }
    }

    public void ParseQrCode(String fsArgs, GCardSystem.ParseQrCodeCallback callback){
        new ParseQrCodeTask(callback).execute(fsArgs);
    }

    private class ParseQrCodeTask extends AsyncTask<String, Void, Boolean>{

        private final GCardSystem.ParseQrCodeCallback callback;

        private char cResult;
        private String message;

        public ParseQrCodeTask(GCardSystem.ParseQrCodeCallback callback) {
            this.callback = callback;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try{
                poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
                poSystem.ParseQrCode(strings[0], new GCardSystem.ParseQrCodeCallback() {
                    @Override
                    public void ApplicationResult(String args) {
                        cResult = '0';
                        message = args;
                    }

                    @Override
                    public void TransactionResult(String args) {
                        cResult = '1';
                        message = args;
                    }

                    @Override
                    public void OnFailed(String args) {
                        cResult = '2';
                        message = args;
                    }
                });
                return true;
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean) {
                switch (cResult) {
                    case '0':
                        callback.ApplicationResult(message);
                        break;
                    case '1':
                        callback.TransactionResult(message);
                        break;
                    default:
                        callback.OnFailed(message);
                        break;
                }
            } else {
                callback.OnFailed(message);
            }
        }
    }

    public LiveData<List<EPromo>> GetPromoLinkList(){
        poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.EXTRAS);
        return poSystem.GetPromotions();
    }

    public LiveData<List<String>> GetBrandNames(){
        return poProduct.GetBrandNames();
    }

    public interface OnCheckPromotions {
        void OnCheckPromos(String args1, String args2);
        void OnCheckEvents(String args1, String args2);
        void NoPromos();
    }

    public void CheckPromotions(OnCheckPromotions listener){
        TaskExecutor.Execute(listener, new OnDoBackgroundTaskListener() {
            @Override
            public Object DoInBackground(Object args) {
                poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.EXTRAS);
            if(poSystem.CheckPromo() != null){
                EPromo loPromo = poSystem.CheckPromo();
                lsPromo = loPromo.getPromoUrl();
                lsPmUrl = loPromo.getImageUrl();
            }

            if(poSystem.CheckEvents() != null){
                EEvents loEvent = poSystem.CheckEvents();
                lsEvent = loEvent.getImageURL();
                lsEvUrl = loEvent.getEventURL();
            }
            return null;
            }

            @Override
            public void OnPostExecute(Object object) {
                if(lsPromo != null) {
                    listener.OnCheckPromos(lsPromo, lsPmUrl);
                }
                if(lsEvent != null){
                    listener.OnCheckEvents(lsEvent, lsEvUrl);
                }
                if(lsEvent == null && lsPromo == null){
                    listener.NoPromos();
                }

            }
        });
    }

//    private class OnPromoCheckTask extends AsyncTask<String, Void, Boolean>{
//
//        private final OnCheckPromotions mListener;
//
//        private String lsPromo, lsPmUrl;
//        private String lsEvent, lsEvUrl;
//
//        public OnPromoCheckTask(OnCheckPromotions mListener) {
//            this.mListener = mListener;
//        }
//
//        @Override
//        protected Boolean doInBackground(String... strings) {
//            poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.EXTRAS);
//            if(poSystem.CheckPromo() != null){
//                EPromo loPromo = poSystem.CheckPromo();
//                lsPromo = loPromo.getPromoUrl();
//                lsPmUrl = loPromo.getImageUrl();
//            }
//
//            if(poSystem.CheckEvents() != null){
//                EEvents loEvent = poSystem.CheckEvents();
//                lsEvent = loEvent.getImageURL();
//                lsEvUrl = loEvent.getEventURL();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Boolean aBoolean) {
//            if(lsPromo != null) {
//                mListener.OnCheckPromos(lsPromo, lsPmUrl);
//            }
//            if(lsEvent != null){
//                mListener.OnCheckEvents(lsEvent, lsEvUrl);
//            }
//            if(lsEvent == null && lsPromo == null){
//                mListener.NoPromos();
//            }
//            super.onPostExecute(aBoolean);
//        }
//    }


    public void ImportOrdersTask(){
        new ImportOrdersTask().execute();
    }

    private class ImportOrdersTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            ConnectionUtil loConnect = new ConnectionUtil(mContext);
            if(loConnect.isDeviceConnected()) {
                Log.d(TAG, "Importing purchase info.");
                poOrder.ImportPurchases();
            }
            return null;
        }
    }

    public void ValidateUserVerification(OnValidateVerifiedUser listener){
        new ValidateVerifiedTask(listener).execute();
    }

    private class ValidateVerifiedTask extends AsyncTask<Void, String, Integer>{

        private final OnValidateVerifiedUser mListener;

        private String message;

        public ValidateVerifiedTask(OnValidateVerifiedUser mListener) {
            this.mListener = mListener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mListener.OnValidate("Guanzon App", "Checking account. Please wait...");
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            try{
                if(!poConn.isDeviceConnected()){
                    message = "Unable to connect.";
                    return 0;
                }

                if(!poClient.ImportAccountInfo()){
                    message = poClient.getMessage();
                    return 0;
                }

                EClientInfo loClient = poClient.GetClientInfo();
                if(loClient == null){
                    message = "Unable to find client record. Please try restarting the app and try again.";
                    return 0;
                }

                if(!poClient.HasCompleteInfo()){
                    message = "Client incomplete info.";
                    return 3;
                }

                int lnVerified = loClient.getVerified();
                if(lnVerified == 0){
                    message = "Account not verified. Proceed to account verification.";
                    return 2;
                }

                message = "Account verified. Proceed to loan application.";
                return 1;
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return 0;
            }
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            switch (result){
                case 0:
                    mListener.OnFailed(message);
                    break;
                case 2:
                    mListener.OnAccountNotVerified();
                    break;
                case 3:
                    mListener.OnIncompleteAccountInfo();
                    break;
                default:
                    mListener.OnAccountVerified();
                    break;
            }
        }
    }
}