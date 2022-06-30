package org.rmj.guanzongroup.marketplace.ViewModel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;

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

import java.util.List;

public class VMHome extends AndroidViewModel {
    private final RClientInfo poClientx;
    private final RAddressMobile poAddress;
    private final RProduct poProduct;
    private final ROrder poOrder;
    private final RNotificationInfo poNotif;
    private iGCardSystem poSystem;
    private Context mContext;

    public interface OnViewGCardQrCode{
        void OnView(Bitmap foVal);
    }

    public VMHome(@NonNull Application application) {
        super(application);
        this.mContext = application;
        this.poClientx = new RClientInfo(application);
        this.poProduct = new RProduct(application);
        this.poAddress = new RAddressMobile(application);
        this.poOrder = new ROrder(application);
        this.poNotif = new RNotificationInfo(application);
        this.poSystem = new GCardSystem(application).getInstance(GCardSystem.CoreFunctions.GCARD);
        new GuanzonAppConfig(application).setFirstLaunch(false);
    }

    public LiveData<EClientInfo> getClientInfo() {
        return poClientx.getClientInfo();
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
            poClientx.LogoutUserSession();
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
        new OnPromoCheckTask(listener).execute();
    }

    private class OnPromoCheckTask extends AsyncTask<String, Void, Boolean>{

        private final OnCheckPromotions mListener;

        private String lsPromo, lsPmUrl;
        private String lsEvent, lsEvUrl;

        public OnPromoCheckTask(OnCheckPromotions mListener) {
            this.mListener = mListener;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
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
        protected void onPostExecute(Boolean aBoolean) {
            if(lsPromo != null) {
                mListener.OnCheckPromos(lsPromo, lsPmUrl);
            }
            if(lsEvent != null){
                mListener.OnCheckEvents(lsEvent, lsEvUrl);
            }
            if(lsEvent == null && lsPromo == null){
                mListener.NoPromos();
            }
            super.onPostExecute(aBoolean);
        }
    }
}