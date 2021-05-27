package org.rmj.guanzongroup.guanzonapp.GuanzonApp.ScanResultHandler;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.dev.Telephony;
import org.rmj.g3appdriver.etc.SharedPref;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.ImportAccountGcard;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.onImportResultListener;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;

import java.util.HashMap;

public class ScanResult {

    private Context mContext;
    private CodeGenerator codeGenerator;
    private onScannerResultListener onScannerResultListener;

    private String message = "";

    public ScanResult(Context context, CodeGenerator codeGenerator){
        this.mContext = context;
        this.codeGenerator = codeGenerator;
    }

    public void setupAction(onScannerResultListener listener){
        this.onScannerResultListener = listener;
        if(!isQrCodeValid()){
            onScannerResultListener.onFailedResult(message);
        } else {
            if(codeGenerator.isQrCodeTransaction()){
                if(!codeGenerator.isDeviceValid(
                        new SharedPref(mContext).getMobileNo(),
                        AppData.getInstance(mContext).getUserID(),
                        new GcardAppMaster(mContext).getCardNumber())){
                    message = "Mobile Number or Account is not valid to confirm this transaction";
                    onScannerResultListener.onFailedResult(message);
                } else {
                    getTransactionResult();
                }
            } else if(codeGenerator.isQrCodeApplication()){
                getApplicationResult();
            }
        }
    }

    private void getTransactionResult(){
        new LoadTransactionResult().LoadTransactionResult(createJSONParameters(), new onQrCodeRequestResult() {
            @Override
            public void isSuccess() {
                onScannerResultListener.onSuccessResult(codeGenerator.getTransactionPIN());
            }

            @Override
            public void isFailed(String errorMessage) {
                onScannerResultListener.onFailedResult(errorMessage);
            }
        });
    }

    private void getApplicationResult(){
        new LoadApplicationResult(codeGenerator.getGCardNumber(), new onQrCodeRequestResult() {
            @Override
            public void isSuccess() {
                onScannerResultListener.onSuccessResult(codeGenerator.getGCardNumber());
            }

            @Override
            public void isFailed(String errorMessage) {
                onScannerResultListener.onFailedResult(errorMessage);
            }
        });
    }

    private boolean isQrCodeValid(){
        if(!codeGenerator.isCodeValid()){
            message = "Qr Code is not applicable to any GCard transaction.";
            return false;
        } else if(codeGenerator.isTransactionVoid()){
            message = "This transaction is cancelled or void";
            return false;
        } else {
            return true;
        }
    }

    private JSONObject createJSONParameters(){
        JSONObject params = new JSONObject();
        try{
            params.put("gcardno", new GcardAppMaster(mContext).getCardNumber());
            params.put("entryno", "");
            params.put("datetrn", codeGenerator.getDTransact());
            params.put("srcedsc", codeGenerator.getTransSource());
            params.put("referno", codeGenerator.getSourceNo());
            params.put("trandsc", codeGenerator.getSourceCD());
            params.put("srcenox", codeGenerator.getSourceNo());
            params.put("pointsx", Double.parseDouble(codeGenerator.getPointsxx()));
            params.put("qrcodex", "1");
            params.put("receive", "0");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return params;
    }

    public interface onQrCodeRequestResult{
        void isSuccess();
        void isFailed(String errorMessage);
    }

    public interface onScannerResultListener{
        void onSuccessResult(String Pin);
        void onFailedResult(String errorMessage);
    }

    class LoadTransactionResult{

        LoadTransactionResult() {
        }

        void LoadTransactionResult(JSONObject jsonObject, onQrCodeRequestResult listener){
            if(isTransactionValid(jsonObject)) {
                try {
                    AppData db = AppData.getInstance(mContext);
                    db.getWritableDb().execSQL("INSERT INTO G_Card_Transaction_Ledger( " +
                            "sReferNox," +
                            "sGCardNox, " +
                            "nEntryNox," +
                            "dTransact," +
                            "sSourceDs," +
                            "sTranDesc," +
                            "sSourceNo," +
                            "nPointsxx," +
                            "cQrCodexx," +
                            "cReceived)" +
                            "VALUES (" +
                            "'" + jsonObject.getString("referno") + "'," +
                            "'" + jsonObject.getString("gcardno") + "'," +
                            "'" + jsonObject.getString("entryno") + "'," +
                            "'" + jsonObject.getString("datetrn") + "'," +
                            "'" + jsonObject.getString("srcedsc") + "'," +
                            "'" + jsonObject.getString("trandsc") + "'," +
                            "'" + jsonObject.getString("srcenox") + "'," +
                            "'" + jsonObject.getString("pointsx") + "'," +
                            "'" + jsonObject.getString("qrcodex") + "'," +
                            "'" + jsonObject.getString("receive") + "')");
                    listener.isSuccess();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                listener.isSuccess();
            }
        }

        private boolean isTransactionValid(JSONObject jsonObject){
            AppData db = AppData.getInstance(mContext);
            try {
                Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM G_Card_Transaction_Ledger WHERE " +
                        "sGCardNox = '" + jsonObject.getString("gcardno") + "' AND " +
                        "sSourceDs = '" + jsonObject.getString("srcedsc") + "' AND " +
                        "sReferNox = '" + jsonObject.getString("referno") + "' AND " +
                        "sTranDesc = '" + jsonObject.getString("trandsc") + "' AND " +
                        "sSourceNo = '" + jsonObject.getString("srcenox") + "' AND " +
                        "nPointsxx = '" + jsonObject.getString("pointsx") + "'", null);
                int DataCount = cursor.getCount();
                if (DataCount >= 1) {
                    cursor.close();
                    return true;
                } else {
                    cursor.close();
                    return false;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    class LoadApplicationResult{
        private RequestHeaders headers;
        private onQrCodeRequestResult onQrCodeRequestResult;

        LoadApplicationResult(final String GCardNumber, onQrCodeRequestResult listener){
            this.headers = new RequestHeaders(mContext);
            ConnectionUtil connectionUtil = new ConnectionUtil(mContext);
            this.onQrCodeRequestResult = listener;

            if(connectionUtil.isDeviceConnected()){
                new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_ADD_NEW_GCARD(), new HttpRequestUtil.onServerResponseListener() {
                    @Override
                    public HashMap setHeaders() { return (HashMap)headers.getHeaders(); }

                    @Override
                    public JSONObject setData() {
                        JSONObject params = new JSONObject();
                        try{
                            params.put("secureno", codeGenerator.generateSecureNo(GCardNumber));
                            return params;
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    public void onResponse(JSONObject jsonResponse) {
                        new ImportAccountGcard().sendRequest(mContext, new onImportResultListener() {
                            @Override
                            public void onSuccessImport() {
                                onQrCodeRequestResult.isSuccess();
                            }

                            @Override
                            public void onErrorResult() {

                            }
                        });
                    }

                    @Override
                    public void onErrorResponse(String message) {
                        if (isJsonValid(message)) {
                            try {
                                JSONObject loJson = new JSONObject(message);
                                onQrCodeRequestResult.isFailed(loJson.getString("message"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            onQrCodeRequestResult.isFailed(message);
                        }
                    }
                });
            } else {
                onQrCodeRequestResult.isFailed("No internet connection detected.");
            }
        }

        boolean isJsonValid(String message){
            try{
                JSONObject loJson = new JSONObject(message);
                return true;
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
    }
}
