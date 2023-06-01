package org.rmj.guanzongroup.marketplace.ViewModel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.GConnect.Account.ClientMaster;
import org.rmj.g3appdriver.GConnect.GCard.DigitalGcard.GCard;
import org.rmj.g3appdriver.GConnect.Marketplace.Cart.MpCart;
import org.rmj.g3appdriver.GConnect.Marketplace.Order.MpOrder;
import org.rmj.g3appdriver.GConnect.Marketplace.Product.MpProducts;
import org.rmj.g3appdriver.GConnect.room.Entities.EClientInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.EGcardApp;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Task.OnDoBackgroundTaskListener;
import org.rmj.g3appdriver.utils.Task.OnTaskExecuteListener;
import org.rmj.g3appdriver.utils.Task.TaskExecutor;

import java.util.List;

public class VMHome extends AndroidViewModel {
    private static final String TAG =VMHome.class.getSimpleName();
    private final ClientMaster poClient;
//    private final RAddressMobile poAddress;
    private final MpProducts poProduct;
    private final MpOrder poOrder;
    private final MpCart poCart;
    private final ConnectionUtil poConn;
    private final GCard poGcard;
//    private final RNotificationInfo poNotif;
//    private iGCardSystem poSystem;

    private String message;

    public interface OnViewGCardQrCode{
        void OnCreateBitmap(Bitmap foVal);
        void OnFailed(String message);
    }

    public interface OnValidateVerifiedUser{
        void OnValidate(String title, String message);
        void OnIncompleteAccountInfo();
        void OnAccountVerified();
        void OnAccountNotVerified();
        void OnFailed(String message);
    }

    public interface OnActionCallback{
        void OnLoad();
        void OnSuccess(String args);
        void OnFailed(String args);
    }

    public interface OnParseQrCodeCallback{
        void OnParse();
        void OnNewGCard();
        void OnTransactionPoints(String args);
        void OnFailed(String message);
    }

    public interface OnCheckPromotions {
        void OnCheckPromos(String args1, String args2);
        void OnCheckEvents(String args1, String args2);
        void NoPromos();
    }

    public VMHome(@NonNull Application application) {
        super(application);
        this.poClient = new ClientMaster(application);
        this.poProduct = new MpProducts(application);
//        this.poAddress = new RAddressMobile(application);
        this.poOrder = new MpOrder(application);
        this.poConn = new ConnectionUtil(application);
        this.poGcard = new GCard(application);
        this.poCart = new MpCart(application);
//        this.poNotif = new RNotificationInfo(application);
//        this.poSystem = new GCardSystem(application).getInstance(GCardSystem.CoreFunctions.GCARD);
//        new GuanzonAppConfig(application).setFirstLaunch(false);
    }

    public LiveData<EClientInfo> getClientInfo() {
        return poClient.GetClientDetail();
    }

    public LiveData<EGcardApp> GetActiveGCard(){
        return poGcard.GetActiveGCardInfo();
    }

    public LiveData<List<DProduct.oProduct>> getProductList(int fnIndex) {
        return poProduct.GetProductsList(fnIndex, FilterType.DEFAULT, null, null);
    }

    public LiveData<Integer> GetUnreadMessagesCount(){
        return poNotif.GetUnreadMessagesCount();
    }

    public LiveData<Integer> GetCartItemCount(){
        return poCart.GetCartItemCount();
    }

    public LiveData<Integer> GetToPayOrders(){
        return poOrder.GetToPayOrders();
    }

    public void ViewGCardQrCode(OnViewGCardQrCode callback){
        TaskExecutor.Execute(null, new OnDoBackgroundTaskListener() {
            @Override
            public Object DoInBackground(Object args) {
                Bitmap loResult = poGcard.GenerateGCardQrCode();
                if(loResult == null){
                    message = poGcard.getMessage();
                    return null;
                }
                return loResult;
            }

            @Override
            public void OnPostExecute(Object object) {
                Bitmap loResult = (Bitmap) object;
                if(loResult == null){
                    callback.OnCreateBitmap(loResult);
                    return;
                }

                callback.OnFailed(message);
            }
        });
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

    public void AddNewGCard(String fsVal, OnActionCallback callback){
        TaskExecutor.Execute(fsVal, new OnTaskExecuteListener() {
            @Override
            public void OnPreExecute() {
                callback.OnLoad();
            }

            @Override
            public Object DoInBackground(Object args) {
                if(!poConn.isDeviceConnected()){
                    message = poConn.getMessage();
                    return false;
                }

                if(!poGcard.AddGCard((String)args)){
                    message = poGcard.getMessage();
                    return false;
                }

                return true;
            }

            @Override
            public void OnPostExecute(Object object) {
                boolean isSuccess = (boolean) object;
                if(!isSuccess){
                    callback.OnFailed(message);
                    return;
                }

                callback.OnSuccess("Congratulations! Your new GCard has been successfully added.");
            }
        });
    }

    public void ParseQrCode(String fsArgs, OnParseQrCodeCallback callback){
        final String[] lsPIN = {""};
        TaskExecutor.Execute(fsArgs, new OnTaskExecuteListener() {
            @Override
            public void OnPreExecute() {
                callback.OnParse();
            }

            @Override
            public Object DoInBackground(Object args) {
                GCard.QrCodeType loResult = poGcard.ParseQrCode((String) args);

                if(loResult == null){
                    message = poGcard.getMessage();
                    return 0;
                }

                if(loResult == GCard.QrCodeType.NEW_GCARD){
                    if(!poConn.isDeviceConnected()){
                        message = poConn.getMessage();
                        return 0;
                    }

                    if(!poGcard.AddGCard((String)args)){
                        message = poGcard.getMessage();
                        return 0;
                    }

                    return 1;
                }

                if(loResult == GCard.QrCodeType.TRANSACTION){
                    lsPIN[0] = poGcard.GetTransactionPIN((String) args);
                    if(lsPIN[0] == null){
                        message = poGcard.getMessage();
                        return 0;
                    }
                }

                return 2;
            }

            @Override
            public void OnPostExecute(Object object) {
                int lnResult = (int) object;
                switch (lnResult){
                    case 1:
                        callback.OnNewGCard();
                        break;
                    case 2:
                        callback.OnTransactionPoints(lsPIN[0]);
                        break;
                    default:
                        callback.OnFailed(message);
                        break;
                }
            }
        });
    }

    public LiveData<List<EPromo>> GetPromoLinkList(){
        poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.EXTRAS);
        return poSystem.GetPromotions();
    }

    public LiveData<List<String>> GetBrandNames(){
        return poProduct.GetB();
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