package org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;

import java.util.HashMap;

public class TransHistory {

    private Context mContext;
    private CodeGenerator codeGenerator;
    private RequestHeaders api_headers;

    public TransHistory(Context context){
        this.mContext = context;
        this.codeGenerator = new CodeGenerator();
        this.api_headers = new RequestHeaders(mContext);
    }

    public void importTransactions_OFFLINE(String GCardNumber){
        final String secureno = codeGenerator.generateSecureNo(GCardNumber);
        final JSONObject params = new JSONObject();
        String API_OFFLINE_TRANSACTIONS = new WebApi(mContext).URL_IMPORT_TRANSACTIONS_OFFLINE();
        if(new ConnectionUtil(mContext).isDeviceConnected()){
            new HttpRequestUtil().sendRequest(API_OFFLINE_TRANSACTIONS, new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap)api_headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    try{
                        params.put("secureno", secureno);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    return params;
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    try {
                        saveTransactionToLocal(jsonResponse, "offline");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onErrorResponse(String message) {

                }
            });
        }
    }

    public void importTransactions_ONLINE(String GCardNumber){
        final JSONObject params = new JSONObject();
        final String secureno = codeGenerator.generateSecureNo(GCardNumber);
        String API_ONLINE_TRANSACTIONS = new WebApi(mContext).URL_IMPORT_TRANSACTIONS_ONLINE();
        if(new ConnectionUtil(mContext).isDeviceConnected()){
            new HttpRequestUtil().sendRequest(API_ONLINE_TRANSACTIONS, new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap)api_headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    try{
                        params.put("secureno", secureno);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    return params;
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    try {
                        saveTransactionToLocal(jsonResponse, "online");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onErrorResponse(String message) {

                }
            });
        }
    }

    public void importTransactions_PreORDER(String GCardNumber){
        final JSONObject params = new JSONObject();
        final String secureno = codeGenerator.generateSecureNo(GCardNumber);
        String API_PRE_ORDER = new WebApi(mContext).URL_IMPORT_TRANSACTIONS_PREORDER();
        if(new ConnectionUtil(mContext).isDeviceConnected()){
            new HttpRequestUtil().sendRequest(API_PRE_ORDER, new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap)api_headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    try{
                        params.put("secureno", secureno);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    return params;
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    try {
                        saveTransactionToLocal(jsonResponse, "preorder");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onErrorResponse(String message) {

                }
            });
        }
    }

    public void importTransactions_REDEMPTION(String GCardNumber){
        final JSONObject params = new JSONObject();
        final String secureno = codeGenerator.generateSecureNo(GCardNumber);
        String API_REDEMPTIONS = new WebApi(mContext).URL_IMPORT_TRANSACTIONS_REDEMPTION();
        if(new ConnectionUtil(mContext).isDeviceConnected()){
            new HttpRequestUtil().sendRequest(API_REDEMPTIONS, new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap)api_headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    try{
                        params.put("secureno", secureno);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    return params;
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    try {
                        saveTransactionToLocal(jsonResponse, "redemption");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onErrorResponse(String message) {

                }
            });
        }
    }

    private void saveTransactionToLocal(JSONObject jsonResponse, String Transaction) throws Exception{
        JSONArray arr_response = jsonResponse.getJSONArray("detail");
        AppData db = AppData.getInstance(mContext);
        String lsSql = "INSERT OR REPLACE INTO G_Card_Transaction_Ledger (sGCardNox, dTransact, sSourceDs, sReferNox, sTranType, sSourceN, nPointsxx) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement loStatement = db.getWritableDb().compileStatement(lsSql);
        db.getWritableDb().beginTransaction();
        for(int x = 0; x < arr_response.length(); x++) {
            JSONObject jsonDetail = new JSONObject(arr_response.getString(x));
            loStatement.clearBindings();
            loStatement.bindString(1, jsonDetail.getString("sGCardNox"));
            loStatement.bindString(2, jsonDetail.getString("dTransact"));
            loStatement.bindString(3, Transaction.toUpperCase());
            loStatement.bindString(4, jsonDetail.getString("sReferNox"));
            loStatement.bindString(5, jsonDetail.getString("sTranType"));
            loStatement.bindString(6, jsonDetail.getString("sSourceNo"));
            loStatement.bindString(7, jsonDetail.getString("nPointsxx"));
            loStatement.execute();
        }
        db.getWritableDb().setTransactionSuccessful();
        db.getWritableDb().endTransaction();
    }
}
