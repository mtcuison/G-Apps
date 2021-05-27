package org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.etc.SharedPref;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.SQLUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;

import java.util.HashMap;

public class Import_Transactions extends CodeGenerator implements GapImportInstance{
    private static final String TAG = Import_Transactions.class.getSimpleName();
    private Context mContext;
    private WebApi webApi;
    private RequestHeaders headers;
    private AppData db;
    private onImportResultListener onImportResultListener;

    private String GCardNumber = "";
    private String GCardNox = "";

    private String[] Import_Urls = {
            };

    private String[] Import_Type = {
            "ONLINE",
            "OFFLINE",
            "PREORDER",
            "REDEMPTION"};



    @Override
    public void sendRequest(Context context, onImportResultListener listener) {
        this.mContext = context;
        this.webApi = new WebApi(mContext);
        this.headers = new RequestHeaders(context);
        ConnectionUtil connectionUtil = new ConnectionUtil(context);
        GcardAppMaster gcardAppMaster = new GcardAppMaster(context);
        this.onImportResultListener = listener;
        HttpRequestUtil httpRequestUtil = new HttpRequestUtil();
        this.GCardNumber = gcardAppMaster.getCardNumber();
        this.GCardNox = gcardAppMaster.getGCardNox();
        this.db = AppData.getInstance(context);

        Import_Urls = new String[]{
                webApi.URL_IMPORT_TRANSACTIONS_ONLINE(),
                webApi.URL_IMPORT_TRANSACTIONS_OFFLINE(),
                webApi.URL_IMPORT_TRANSACTIONS_PREORDER(),
                webApi.URL_IMPORT_TRANSACTIONS_REDEMPTION()
        };

        if(connectionUtil.isDeviceConnected()){
            for(int index = 0; index < Import_Urls.length; index++){
                final int finalIndex = index;
                httpRequestUtil.sendRequest(Import_Urls[index], new HttpRequestUtil.onServerResponseListener() {
                    @Override
                    public HashMap setHeaders() {
                        return (HashMap)headers.getHeaders();
                    }

                    @Override
                    public JSONObject setData() {
                        JSONObject params = new JSONObject();
                        try{
                            params.put("secureno", generateSecureNo(GCardNumber));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        Log.d(TAG, "Importing "+ Import_Type[finalIndex] +" transactions.");
                        return params;
                    }

                    @Override
                    public void onResponse(JSONObject jsonResponse) {
                        try {
                            JSONArray jsonArray = jsonResponse.getJSONArray("detail");
                            if(jsonArray.length()>0){
                                db.getWritableDb().beginTransaction();
                                for(int x = 0; x < jsonArray.length(); x++){
                                    JSONObject jsonDetail = new JSONObject(jsonArray.getString(x));
                                    String ReferNo = jsonDetail.getString("sReferNox");
                                    if (!isTransactionExist(ReferNo)) {
                                        String sql_query = "INSERT INTO G_Card_Transaction_Ledger(" +
                                                "sReferNox," +
                                                "sGCardNox," +
                                                "dTransact," +
                                                "sSourceDs, " +
                                                "sTranType," +
                                                "sSourceNo," +
                                                "nPointsxx)" +
                                                "VALUES(" +
                                                "'" + jsonDetail.get("sReferNox") + "'," +
                                                "'" + jsonDetail.get("sGCardNox") + "'," +
                                                "'" + jsonDetail.get("dTransact") + "'," +
                                                " "+ SQLUtil.toSQL(Import_Type[finalIndex]) +"," +
                                                "'" + jsonDetail.get("sTranType") + "'," +
                                                "'" + jsonDetail.get("sSourceNo") + "'," +
                                                "'" + jsonDetail.get("nPointsxx") + "')";
                                        db.getWritableDb().execSQL(sql_query);
                                    }
                                }
                                db.getWritableDb().setTransactionSuccessful();
                                db.getWritableDb().endTransaction();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if(finalIndex == Import_Urls.length) {
                            onImportResultListener.onSuccessImport();
                        }
                    }

                    @Override
                    public void onErrorResponse(String message) {
                        if (isJsonValid(message)) {
                            if(finalIndex == Import_Urls.length) {
                                onImportResultListener.onSuccessImport();
                            } else {
                                onImportResultListener.onErrorResult();
                            }
                        }
                    }
                });

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
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

    private boolean isTransactionExist(String ReferNox){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT sReferNox FROM G_Card_Transaction_Ledger WHERE sReferNox = '"+ReferNox+"' AND sGCardNox = '"+GCardNox+"'",null);
        int rowCount = cursor.getCount();
        if(rowCount>0){
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }
}
