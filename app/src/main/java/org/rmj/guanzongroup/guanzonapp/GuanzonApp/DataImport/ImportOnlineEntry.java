package org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;

import java.util.HashMap;

public class ImportOnlineEntry extends CodeGenerator implements GapImportInstance {

    private Context mContext;
    private RequestHeaders headers;
    private AppData db;
    private onImportResultListener onImportResultListener;


    @Override
    public void sendRequest(Context context, onImportResultListener listener) {
        this.mContext = context;
        this.headers = new RequestHeaders(mContext);
        ConnectionUtil connectionUtil = new ConnectionUtil(mContext);
        GcardAppMaster gcardAppMaster = new GcardAppMaster(mContext);
        this.onImportResultListener = listener;
        HttpRequestUtil httpRequestUtil = new HttpRequestUtil();
        final String GCardNumber = gcardAppMaster.getCardNumber();

        if(connectionUtil.isDeviceConnected()){
            httpRequestUtil.sendRequest(new WebApi(mContext).URL_IMPORT_TRANSACTIONS_ONLINE(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap)headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    JSONObject params = new JSONObject();
                    try{
                        params.put("secureno", generateSecureNo(GCardNumber));
                        return params;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    try {
                        JSONArray jsonArray = jsonResponse.getJSONArray("detail");
                        if(jsonArray.length()>0){
                            saveToLocal(jsonArray);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                        onImportResultListener.onSuccessImport();
                }

                @Override
                public void onErrorResponse(String message) {
                    if (isJsonValid(message)) {
                        onImportResultListener.onSuccessImport();
                    } else {
                        onImportResultListener.onErrorResult();
                    }
                }
            });
        } else {
            onImportResultListener.onErrorResult();
        }
    }

    private boolean isJsonValid(String message){
        try{
            JSONObject jsonObject = new JSONObject(message);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void saveToLocal(JSONArray jsonArray){
        db = AppData.getInstance(mContext);
        String lsSql = "INSERT OR REPLACE INTO G_Card_Transaction_Ledger(sGCardNox, dTransact, sSourceDs, sReferNox, sTranType, sSourceNo, nPointsxx) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement loSql = db.getWritableDb().compileStatement(lsSql);
        db.getWritableDb().beginTransaction();
        try{
            for(int x = 0; x < jsonArray.length(); x++){
                JSONObject jsonDetail = new JSONObject(jsonArray.getString(x));
                loSql.clearBindings();
                loSql.bindString(1, jsonDetail.getString("sGCardNox"));
                loSql.bindString(2, jsonDetail.getString("dTransact"));
                loSql.bindString(3, "ONLINE");
                loSql.bindString(4, jsonDetail.getString("sReferNox"));
                loSql.bindString(5, jsonDetail.getString("sTranType"));
                loSql.bindString(6, jsonDetail.getString("sSourceNo"));
                loSql.bindString(7, jsonDetail.getString("nPointsxx"));
                loSql.execute();
            }
            db.getWritableDb().setTransactionSuccessful();
            db.getWritableDb().endTransaction();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
