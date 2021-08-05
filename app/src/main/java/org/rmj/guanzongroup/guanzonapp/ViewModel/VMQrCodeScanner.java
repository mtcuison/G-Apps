package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Repositories.RGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemablesInfo;
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
import java.util.Objects;

public class VMQrCodeScanner extends AndroidViewModel {
    private final static String TAG = VMQrCodeScanner.class.getSimpleName();
    private final RRedeemablesInfo poRedeemx;

    private final RGcardApp gcard;
    private String message;
    private AppConfigPreference appConfig;
    private SessionManager sessionManager;

    private final Application instance;
    private final MutableLiveData<String> resultMessage = new MutableLiveData<>();
    public VMQrCodeScanner(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poRedeemx = new RRedeemablesInfo(application);
        this.gcard = new RGcardApp(application);
        this.appConfig = new AppConfigPreference(application);
        this.sessionManager = new SessionManager(application);
    }

    public interface onScannerResultListener{
        void onSuccessResult(String Pin);
        void onFailedResult(String errorMessage);
    }

    public void setupAction(CodeGenerator codeGenerator,String result, onScannerResultListener listener){
        Log.e(TAG, codeGenerator.getGCardNumber() + " mygcardnumber = " + gcard.getCardNo());
        if(!isQrCodeValid(codeGenerator, listener)){
            listener.onFailedResult(resultMessage.getValue());
        } else {
            if(codeGenerator.isQrCodeTransaction()){
                if(!codeGenerator.isDeviceValid(
                        appConfig.getMobileNo(),
                        sessionManager.getUserID(),
                        gcard.getCardNo())){
                    listener.onFailedResult("Mobile Number or Account is not valid to confirm this transaction");
                } else {
//                    getTransactionResult();createJSONParameters()
                    JSONObject params = new JSONObject();
                    try{
                        params.put("gcardno", gcard.getCardNo());
                        params.put("entryno", "");
                        params.put("datetrn", codeGenerator.getDTransact());
                        params.put("srcedsc", codeGenerator.getTransSource());
                        params.put("referno", codeGenerator.getSourceNo());
                        params.put("trandsc", codeGenerator.getSourceCD());
                        params.put("srcenox", codeGenerator.getSourceNo());
                        params.put("pointsx", Double.parseDouble(codeGenerator.getPointsxx()));
                        params.put("qrcodex", "1");
                        params.put("receive", "0");
                        new LoadTransactionResult(codeGenerator, result, instance, listener).execute(params);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        listener.onFailedResult(e.getMessage());
                    }
                }
            } else if(codeGenerator.isQrCodeApplication()){
                JSONObject params = new JSONObject();
                try {
                    params.put("secureno", codeGenerator.generateSecureNo(gcard.getCardNo()));
                    new LoadApplicationResult(codeGenerator, result, instance, listener).execute(params);
                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.onFailedResult(e.getMessage());
                }
            }
        }
    }
    private boolean isQrCodeValid(CodeGenerator codeGenerator,onScannerResultListener listener){
        if(!codeGenerator.isCodeValid()){
            message = "Qr Code is not applicable to any GCard transaction.";
            resultMessage.setValue(message);
//            listener.onFailedResult(message);
            return false;
        } else if(codeGenerator.isTransactionVoid()){
            message = "This transaction is cancelled or void";
            resultMessage.setValue(message);
//            listener.onFailedResult(message);
            return false;
        } else {
            return true;
        }
    }
    public String getMessage(){
        return message;
    }
    private static class LoadApplicationResult extends AsyncTask<JSONObject, Integer, String>{
        private final onScannerResultListener callback;
        private final RGCardTransactionLedger poLedger;
        private final RGcardApp poGcard;

        private final HttpHeaders poHeaders;
        private final ConnectionUtil poConn;
        private final Telephony poDevID;
        private final SessionManager poUser;
        private final AppConfigPreference poConfig;
        private final WebApi poWebApi;
        private final Application instance;
        private final CodeGenerator codeGenerator;
        public LoadApplicationResult(CodeGenerator codeGenerator, String result, Application application, onScannerResultListener callback) {
            this.instance = application;
            this.callback = callback;
            this.codeGenerator = codeGenerator;
            this.poLedger = new RGCardTransactionLedger(instance);
            this.poGcard = new RGcardApp(instance);
            this.poHeaders = HttpHeaders.getInstance(instance);
            this.poConn = new ConnectionUtil(instance);
            this.poDevID = new Telephony(instance);
            this.poUser = new SessionManager(instance);
            this.poWebApi = new WebApi(instance);
            this.poConfig = AppConfigPreference.getInstance(instance);
            this.codeGenerator.setEncryptedQrCode(result);
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObject) {
            String response = "";
            try {
                if(poConn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_IMPORT_GCARD,jsonObject[0].toString(),poHeaders.getHeaders());
                    Log.e("Import_AccountGCard", response);
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        if (!poGcard.insertGCard(loJson)){
                            response = AppConstants.ERROR_SAVING_TO_LOCAL();
                        }
                        else {
                            Log.e("Import_AccountGCard", lsResult);
                            poGcard.saveGCardUpdate();
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
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject loJson = new JSONObject(s);
                Log.e(TAG, loJson.getString("result"));
                String lsResult = loJson.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.onSuccessResult(codeGenerator.getGCardNumber());
                } else {
                    JSONObject loError = loJson.getJSONObject("error");
                    String message = loError.getString("message");
                    callback.onFailedResult(message);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onFailedResult(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                callback.onFailedResult(e.getMessage());
            }
        }
    }
    private static class LoadTransactionResult extends AsyncTask<JSONObject, Integer, String>{
        private final onScannerResultListener callback;
        private final RGCardTransactionLedger poLedger;
        private final RGcardApp poGcard;

        private final HttpHeaders poHeaders;
        private final ConnectionUtil poConn;
        private final Telephony poDevID;
        private final SessionManager poUser;
        private final AppConfigPreference poConfig;
        private final WebApi poWebApi;
        private final Application instance;
        private final CodeGenerator codeGenerator;
        public LoadTransactionResult(CodeGenerator codeGenerator, String result, Application application, onScannerResultListener callback) {
            this.instance = application;
            this.callback = callback;
            this.codeGenerator = codeGenerator;
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
                if (poLedger.isTransactionValid(jsonObject[0].getString("gcardno"),
                        jsonObject[0].getString("srcedsc"),
                        jsonObject[0].getString("referno"),
                        jsonObject[0].getString("trandsc"),
                        jsonObject[0].getString("srcenox"),
                        jsonObject[0].getString("pointsx")).getValue() > 0){
                    EGCardTransactionLedger ledger = new EGCardTransactionLedger();
                    ledger.setReferNox(jsonObject[0].getString("referno"));
                    ledger.setSourceDs(jsonObject[0].getString("srcedsc"));
                    ledger.setGCardNox(jsonObject[0].getString("gcardno"));
                    ledger.setTranDesc(jsonObject[0].getString("trandsc"));
                    ledger.setSourceNo(jsonObject[0].getString("srcenox"));
                    ledger.setQRCodexx(jsonObject[0].getString("qrcodex"));
                    ledger.setReceived(jsonObject[0].getString("receive"));
                    ledger.setTransact(jsonObject[0].getString("datetrn"));
                    ledger.setEntryNox(Integer.parseInt(jsonObject[0].getString("entryno")));
                    ledger.setPointsxx(Double.parseDouble(jsonObject[0].getString("pointsx")));
                    poLedger.insert(ledger);
                    response ="success";

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return response;
        }



        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject loJson = new JSONObject(s);
                Log.e(TAG, loJson.getString("result"));
                String lsResult = loJson.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.onSuccessResult(codeGenerator.getTransactionPIN());
                } else {
                    JSONObject loError = loJson.getJSONObject("error");
                    String message = loError.getString("message");
                    callback.onFailedResult(message);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onFailedResult(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                callback.onFailedResult(e.getMessage());
            }
        }
    }
}
