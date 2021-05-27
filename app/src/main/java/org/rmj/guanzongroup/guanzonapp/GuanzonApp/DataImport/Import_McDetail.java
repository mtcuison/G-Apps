package org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport;

import android.content.Context;
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

public class Import_McDetail extends CodeGenerator implements GapImportInstance{
    private static final String TAG = Import_McDetail.class.getSimpleName();

    private Context mContext;
    private RequestHeaders headers;
    private GcardAppMaster gcardAppMaster;
    private onImportResultListener onImportResultListener;

    @Override
    public void sendRequest(Context context, onImportResultListener listener) {
        this.mContext = context;
        this.headers = new RequestHeaders(mContext);
        ConnectionUtil connectionUtil = new ConnectionUtil(mContext);
        this.gcardAppMaster = new GcardAppMaster(mContext);
        this.onImportResultListener = listener;

        if(connectionUtil.isDeviceConnected()){
            new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_IMPORT_MC_REGISTRATION(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap)headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    try{
                        JSONObject params = new JSONObject();
                        params.put("secureno", generateSecureNo(gcardAppMaster.getCardNumber()));
                        return params;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    try{
                        JSONArray jsonArray = jsonResponse.getJSONArray("detail");
                        if(jsonArray.length() > 0){
                            saveServiceDataToLocal(jsonArray);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    onImportResultListener.onSuccessImport();
                }

                @Override
                public void onErrorResponse(String message) {
                    if(isJsonValid(message)){
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

    private void saveServiceDataToLocal(JSONArray jsonArray){
        String lsGcardNox = gcardAppMaster.getGCardNox();
        AppData db = AppData.getInstance(mContext);
        String lsSql = "INSERT OR REPLACE INTO MC_Serial_Registration(" +
                "sGCardNox, " +
                "sSerialID, " +
                "sEngineNo, " +
                "sFrameNox, " +
                "sModelNme, " +
                "sFSEPStat, " +
                "cRegStatx) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        SQLiteStatement loSql = db.getWritableDb().compileStatement(lsSql);
        db.getWritableDb().beginTransaction();
        try {
            for(int x = 0; x < jsonArray.length(); x++){
                JSONObject jsonDetail = new JSONObject(jsonArray.getString(x));
                loSql.clearBindings();
                loSql.bindString(1, lsGcardNox);
                loSql.bindString(2, jsonDetail.getString("sSerialID"));
                loSql.bindString(3, jsonDetail.getString("sEngineNo"));
                loSql.bindString(4, jsonDetail.getString("sFrameNox"));
                loSql.bindString(5, jsonDetail.getString("sModelNme"));
                loSql.bindString(6, jsonDetail.getString("cFSEPStat"));
                loSql.bindString(7, jsonDetail.getString("cRegStatx"));
            }
            db.getWritableDb().setTransactionSuccessful();
            db.getWritableDb().endTransaction();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
