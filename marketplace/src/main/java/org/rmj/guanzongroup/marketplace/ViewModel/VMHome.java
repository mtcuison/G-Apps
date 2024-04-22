package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EEvents;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.dev.Database.Entities.EPromo;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RNotificationInfo;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;
import org.rmj.g3appdriver.utils.Task.OnDoBackgroundTaskListener;
import org.rmj.g3appdriver.utils.Task.OnTaskExecuteListener;
import org.rmj.g3appdriver.utils.Task.TaskExecutor;

import java.util.HashMap;
import java.util.List;

public class VMHome extends AndroidViewModel {
    private static final String TAG =VMHome.class.getSimpleName();
    private String lsPromo, lsPmUrl;
    private String lsEvent, lsEvUrl;
    private final RClientInfo poClient;
    private final RProduct poProduct;
    private final ROrder poOrder;
    private final ConnectionUtil poConn;
    private final RNotificationInfo poNotif;
    private iGCardSystem poSystem;
    private AccountInfo loAccount;
    private Context mContext;
    private char cResult;
    private String tranSrc;
    private Object result;
    private String message;
    private Boolean isSuccess;

    public VMHome(@NonNull Application application) {
        super(application);
        this.mContext = application;
        this.poClient = new RClientInfo(application);
        this.poProduct = new RProduct(application);
        this.poOrder = new ROrder(application);
        this.poConn = new ConnectionUtil(application);
        this.poNotif = new RNotificationInfo(application);
        this.loAccount = new AccountInfo(mContext);

        new GuanzonAppConfig(application).setFirstLaunch(false);
    }

    public interface OnValidateVerifiedUser{
        void OnValidate(String title, String message);
        void OnIncompleteAccountInfo();
        void OnAccountVerified();
        void OnAccountNotVerified();
        void OnFailed(String message);
    }

    public LiveData<EClientInfo> getClientInfo() {
        return poClient.getClientInfo();
    }
    public LiveData<EGcardApp> GetActiveGCard(){
        this.poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
        return poSystem.getGCardInfo();
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

    public LiveData<List<EPromo>> GetPromoLinkList(){
        poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.EXTRAS);
        return poSystem.GetPromotions();
    }
    public LiveData<List<String>> GetBrandNames(){
        return poProduct.GetBrandNames();
    }

    public void LogoutUserSession(OnLogoutListener listener){
        TaskExecutor.Execute(null, new OnDoBackgroundTaskListener() {
            @Override
            public Object DoInBackground(Object args) {
                poClient.LogoutUserSession();
                loAccount.LogoutUser();

                return null;
            }
            @Override
            public void OnPostExecute(Object object) {
                listener.OnLogout();
            }
        });
    }
    public interface OnLogoutListener{
        void OnLogout();
    }

    public void AddNewGCard(String fsVal, OnActionCallback callback){
        TaskExecutor.Execute(fsVal, new OnTaskExecuteListener() {
            @Override
            public void OnPreExecute() {
                callback.OnLoad();
            }
            @Override
            public Object DoInBackground(Object args) {
                try {
                    if(poConn.isDeviceConnected()) {
                        String params = (String) args;
                        poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
                        poSystem.AddGCardQrCode(params, new GCardSystem.GCardSystemCallback() {
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
                }catch (Exception e){
                    e.printStackTrace();

                    isSuccess = false;
                    message = e.getMessage();
                }

                return isSuccess;
            }
            @Override
            public void OnPostExecute(Object object) {
                Boolean res = (Boolean) object;

                if(res){
                    callback.OnSuccess(message);
                } else {
                    callback.OnFailed(message);
                }
            }
        });
    }
    public interface OnActionCallback{
        void OnLoad();
        void OnSuccess(String args);
        void OnFailed(String args);
    }

    public void DownloadGCardPoints(HashMap<String, String> loParams, onDownloadPoints callback){
        TaskExecutor.Execute(loParams, new OnTaskExecuteListener() {
            @Override
            public void OnPreExecute() {
                callback.onLoad("GCard Points", "Downloading Points . .");
            }
            @Override
            public Object DoInBackground(Object args) {
                try{
                    if (!poConn.isDeviceConnected()){
                        message = poConn.getMessage();
                        return false;
                    }else {
                        HashMap<String, String> params = (HashMap<String, String>) args;

                        poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
                        if (!poSystem.DownloadGcardPoints(params)){
                            message = poSystem.GetMessage();
                            return false;
                        }

                        return true;
                    }
                }catch (Exception e){
                    message = e.getMessage();
                    return false;
                }
            }
            @Override
            public void OnPostExecute(Object object) {
                Boolean res = (Boolean) object;
                if (res){
                    callback.onSuccess();
                }else {
                    callback.onFailed(message);
                }
            }
        });
    }
    public interface onDownloadPoints{
        void onLoad(String title, String message);
        void onSuccess();
        void onFailed(String res);
    }

    public void ParseQrCode(String fsArgs, GCardSystem.ParseQrCodeCallback callback){
        TaskExecutor.Execute(fsArgs, new OnDoBackgroundTaskListener() {
            @Override
            public Object DoInBackground(Object args) {
                String params = (String) args;
                try{
                    poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);
                    poSystem.ParseQrCode(params, new GCardSystem.ParseQrCodeCallback() {
                        @Override
                        public void ApplicationResult(String src, Object args) {
                            cResult = '0';
                            tranSrc = src;
                            result = args;
                        }
                        @Override
                        public void TransactionResult(String src, Object args) {
                            cResult = '1';
                            tranSrc = src;
                            result = args;
                        }
                        @Override
                        public void OnFailed(String args) {
                            cResult = '2';
                            result = args;
                        }
                    });
                    return true;
                } catch (Exception e){
                    result = e.getMessage();
                    return false;
                }
            }
            @Override
            public void OnPostExecute(Object object) {
                Boolean aBoolean = (Boolean) object;
                if(aBoolean) {
                    switch (cResult) {
                        case '0':
                            callback.ApplicationResult(tranSrc, result);
                            break;
                        case '1':
                            callback.TransactionResult(tranSrc, result);
                            break;
                        default:
                            callback.OnFailed(result.toString());
                            break;
                    }
                } else {
                    callback.OnFailed(result.toString());
                }
            }
        });
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
    public interface OnCheckPromotions {
        void OnCheckPromos(String args1, String args2);
        void OnCheckEvents(String args1, String args2);
        void NoPromos();
    }

    public Boolean ImportOrdersTask(){
        TaskExecutor.Execute(null, new OnDoBackgroundTaskListener() {
            @Override
            public Object DoInBackground(Object args) {
                if(poConn.isDeviceConnected()) {
                    Log.d(TAG, "Unable to connect on server");
                    return false;
                }
                if (!poOrder.ImportPurchases()){
                    Log.d(TAG, "Unable to import purchases");
                    return false;
                }

                return true;
            }
            @Override
            public void OnPostExecute(Object object) {
                isSuccess = (Boolean) object;
            }
        });

        return isSuccess;
    }

    public void ValidateUserVerification(OnValidateVerifiedUser listener){
        TaskExecutor.Execute(null, new OnTaskExecuteListener() {
            @Override
            public void OnPreExecute() {
                listener.OnValidate("Guanzon App", "Checking account. Please wait...");
            }
            @Override
            public Object DoInBackground(Object args) {
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
            public void OnPostExecute(Object object) {
                Integer result = (Integer) object;
                switch (result){
                    case 0:
                        listener.OnFailed(message);
                        break;
                    case 2:
                        listener.OnAccountNotVerified();
                        break;
                    case 3:
                        listener.OnIncompleteAccountInfo();
                        break;
                    default:
                        listener.OnAccountVerified();
                        break;
                }
            }
        });
    }
}