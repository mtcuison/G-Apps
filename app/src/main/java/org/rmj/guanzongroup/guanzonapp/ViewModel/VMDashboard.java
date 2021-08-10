package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.Database.Repositories.RBranchInfo;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.Database.Repositories.REvents;
import org.rmj.g3appdriver.Database.Repositories.RGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RMCSerialRegistration;
import org.rmj.g3appdriver.Database.Repositories.RPromo;
import org.rmj.g3appdriver.Database.Repositories.RRedeemablesInfo;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.dev.Telephony;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GCard_Constants;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.crypto.spec.RC2ParameterSpec;

public class VMDashboard extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final RBranchInfo poBranch;
    private final RClientInfo poClient;
    private final RGcardApp poGCard;
    private final RGCardTransactionLedger poLedger;
    private final RMCSerialRegistration poMC;
    private final RRedeemablesInfo poRedeemables;
    private final REvents poEvents;
    private final RPromo poPromo;
    private final SessionManager poSession;
    private final MutableLiveData nUnReadCount = new MutableLiveData();
    public VMDashboard(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poBranch = new RBranchInfo(application);
        this.poClient = new RClientInfo(application);
        this.poGCard = new RGcardApp(application);
        this.poRedeemables = new RRedeemablesInfo(application);
        this.poEvents = new REvents(application);
        this.poPromo = new RPromo(application);
        this.nUnReadCount.setValue(0);
        this.poLedger = new RGCardTransactionLedger(application);
        this.poMC = new RMCSerialRegistration(application);
        this.poSession = new SessionManager(application);
    }

    public LiveData<EClientInfo> getClientInfo(){
        return poClient.getClientInfo();
    }
    public LiveData<EGcardApp> getGCardInfo(){
        return poGCard.getGCardInfo();
    }
    public LiveData<EGcardApp> hasNoCard(){
        return poGCard.hasNoGcard();
    }
    public LiveData<Integer> getOrdersCount(String GCardNo){
        return poRedeemables.getOrdersCount(GCardNo);
    }
    public LiveData<List<ERedeemItemInfo>> getOrdersList(String GCardNo){
        return poRedeemables.getOrdersList(GCardNo);
    }
    public LiveData<Integer> getEventsCount(){
        return poEvents.getEventCount();
    }
    public LiveData<Integer> getPromoCount(){
        return poPromo.getPromoCount();
    }

//    public LiveData<Integer> getUnreadNotificationCount(){
//        if(poSession.isLoggedIn()) {
//            nUnReadCount.setValue(poEvents.getEventCount().getValue() + poPromo.getPromoCount().getValue());
////            return poEvents.getEventCount() + poPromo.getPromoCount() + getMessageCount();
//            return nUnReadCount;
//        }else {
//            nUnReadCount.setValue(poPromo.getPromoCount());
//        }
//        return nUnReadCount;
//    }

    public interface onAddNewGCardListener{
        void onAddResult();
        void onSuccessResult();
        void onErrorResult(String ErrorMessage);
    }

    public void addNewGCard(String gcardNo, String bday,onAddNewGCardListener listener){
        try{
            JSONObject params = new JSONObject();
            params.put("secureno", new CodeGenerator().generateSecureNo(gcardNo));
            new AddNewGCardTaslk(poGCard,listener, instance).execute(params);
//            new VMQrCodeScanner.LoadTransactionResult(codeGenerator, result, instance, listener).execute(params);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private static class AddNewGCardTaslk extends AsyncTask<JSONObject, Integer, String> {
        private final onAddNewGCardListener callback;
        private final RGCardTransactionLedger poLedger;
        private final RGcardApp poGcard;

        private final HttpHeaders poHeaders;
        private final ConnectionUtil poConn;
        private final Telephony poDevID;
        private final SessionManager poUser;
        private final AppConfigPreference poConfig;
        private final WebApi poWebApi;
        private final Application instance;
        public AddNewGCardTaslk(RGcardApp poGcard, onAddNewGCardListener callback, Application application) {
            this.instance = application;
            this.callback = callback;
            this.poLedger = new RGCardTransactionLedger(instance);
            this.poGcard = new RGcardApp(instance);
            this.poHeaders = HttpHeaders.getInstance(instance);
            this.poConn = new ConnectionUtil(instance);
            this.poDevID = new Telephony(instance);
            this.poUser = new SessionManager(instance);
            this.poWebApi = new WebApi(instance);
            this.poConfig = AppConfigPreference.getInstance(instance);
        }
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObject) {
            String response = "";
            try {
                if(poConn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_ADD_NEW_GCARD, jsonObject[0].toString(),poHeaders.getHeaders());
                    Log.e("add new gcard", response);
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        if (!poGcard.insertGCard(loJson)){
                            response = AppConstants.ERROR_SAVING_TO_LOCAL();
                        }
                    }
                } else {
                    response = AppConstants.NO_INTERNET();
                }
            } catch (Exception e) {
                Log.e(TAG, Arrays.toString(e.getStackTrace()));
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.onAddResult();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject loJson = new JSONObject(s);
                Log.e(TAG, loJson.getString("result"));
                String lsResult = loJson.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.onSuccessResult();
                } else {
                    JSONObject loError = loJson.getJSONObject("error");
                    String message = loError.getString("message");
                    callback.onErrorResult(message);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onErrorResult(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                callback.onErrorResult(e.getMessage());
            }
        }
    }
    public void userLogout(){
        poGCard.deleteGCard();
        poClient.LogoutUserSession();
        poLedger.deleteGCardTrans();
        poMC.deleteMC();
        poSession.initUserLogout();
    }

}
