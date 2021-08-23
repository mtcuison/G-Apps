package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RBranchInfo;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.Database.Repositories.REmployee;
import org.rmj.g3appdriver.Database.Repositories.RGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RMCSerialRegistration;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.dev.Telephony;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class VMAccount extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final REmployee poUser;
    private final RClientInfo poClient;
    private final RGcardApp poGCard;
    private final RGCardTransactionLedger poLedger;
    private final RMCSerialRegistration poMC;
    private final SessionManager poSession;
    private final AppConfigPreference appConfig;
    public static final MutableLiveData<Boolean> pbIsLogIn = new MutableLiveData<>();
    private final MutableLiveData<List<Fragment>> psFragment = new MutableLiveData<>();
    private final MutableLiveData<Integer> psMenu = new MutableLiveData<>();
    private final MutableLiveData<String[]> psTitles = new MutableLiveData<>();
    private Application instance;
    public VMAccount(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poUser = new REmployee(application);
        this.poClient = new RClientInfo(application);
        this.poSession = new SessionManager(application);
        this.poGCard = new RGcardApp(application);
        this.poLedger = new RGCardTransactionLedger(application);
        this.poMC = new RMCSerialRegistration(application);
        this.appConfig = new AppConfigPreference(application);
        this.pbIsLogIn.setValue(poSession.isLoggedIn());
    }

    public LiveData<EClientInfo> getClientInfo(){
        return poClient.getClientInfo();
    }
    public LiveData<EGcardApp> getGCardInfo(){
        return poGCard.getGCardInfo();
    }
    public void userLogout(){
        poSession.setLogin(false);
        poGCard.deleteGCard();
        poClient.LogoutUserSession();
        poLedger.deleteGCardTrans();
        poMC.deleteMC();
        poSession.initUserLogout();
    }

    public interface onChangePasswordCallBackListener{
        void onStartChangePassword();
        void onSuccessChangePassword();
        void onErrorChangePassword(String ErrorMessage);
    }
    public void changePassword(String oldPass, String newPass, onChangePasswordCallBackListener listener){
        try{
            JSONObject params = new JSONObject();
            params.put("oldpassword",oldPass);
            params.put("newpassword", newPass);
            new ChangePasswordTask(listener, instance).execute(params);
//            new VMQrCodeScanner.LoadTransactionResult(codeGenerator, result, instance, listener).execute(params);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private static class ChangePasswordTask extends AsyncTask<JSONObject, Integer, String> {
        private final onChangePasswordCallBackListener callback;
        private final RGCardTransactionLedger poLedger;
        private final RGcardApp poGcard;

        private final HttpHeaders poHeaders;
        private final ConnectionUtil poConn;
        private final Telephony poDevID;
        private final SessionManager poUser;
        private final AppConfigPreference poConfig;
        private final WebApi poWebApi;
        private final Application instance;
        public ChangePasswordTask(onChangePasswordCallBackListener callback, Application application) {
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
                    response = WebClient.httpsPostJSon(poWebApi.URL_CHANGE_PASSWORD, jsonObject[0].toString(),poHeaders.getHeaders());
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    String lsResult = loJson.getString("result");
                    Log.e(TAG, response);
                    if(lsResult.equalsIgnoreCase("success")){
                        if (!poGcard.insertNewGCard(loJson)){
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
            callback.onStartChangePassword();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject loJson = new JSONObject(s);
                Log.e(TAG, loJson.getString("result"));
                String lsResult = loJson.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.onSuccessChangePassword();
                } else {
                    JSONObject loError = loJson.getJSONObject("error");
                    String message = loError.getString("message");
                    callback.onErrorChangePassword(message);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onErrorChangePassword(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                callback.onErrorChangePassword(e.getMessage());
            }
        }
    }
}
