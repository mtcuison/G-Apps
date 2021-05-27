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

public class ImportOrders extends CodeGenerator implements GapImportInstance {
    private static final String TAG = ImportOrders.class.getSimpleName();

    private Context mContext;
    private RequestHeaders headers;
    private AppData db;
    private GcardAppMaster gcardAppMaster;
    private onImportResultListener onImportResultListener;

    @Override
    public void sendRequest(Context context, onImportResultListener listener) {
        this.mContext = context;
        this.headers = new RequestHeaders(mContext);
        ConnectionUtil connectionUtil = new ConnectionUtil(mContext);
        this.gcardAppMaster = new GcardAppMaster(mContext);
        this.onImportResultListener = listener;

        if (connectionUtil.isDeviceConnected()) {
            new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_IMPORT_PLACE_ORDER(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap) headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    JSONObject params = new JSONObject();
                    try {
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
                            savePlaceOrdersToLocal(jsonArray);
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

    private void savePlaceOrdersToLocal(JSONArray jsonArray) {
        try {
            db = AppData.getInstance(mContext);
            String lsSql = "INSERT OR REPLACE INTO redeem_item(sPromoIDx, sBatchNox, sGCardNox, dOrderedx, dPickUpxx, sBranchCD, sReferNox, cTranStat, cPlcOrder, nItemQtyx, nPointsxx) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            SQLiteStatement loSql = db.getWritableDb().compileStatement(lsSql);
            db.getWritableDb().beginTransaction();
            for (int x = 0; x < jsonArray.length(); x++){
                JSONObject jsonDetail = new JSONObject(jsonArray.getString(x));
                loSql.clearBindings();
                loSql.bindString(1, jsonDetail.getString("sPromoIDx"));
                loSql.bindString(2, jsonDetail.getString("sTransNox"));
                loSql.bindString(3, jsonDetail.getString("sGCardNox"));
                loSql.bindString(4, jsonDetail.getString("dOrderedx"));
                loSql.bindString(5, jsonDetail.getString("dPickupxx"));
                loSql.bindString(6, jsonDetail.getString("sBranchCD"));
                loSql.bindString(7, jsonDetail.getString("sReferNox"));
                loSql.bindString(8, jsonDetail.getString("cTranStat"));
                loSql.bindString(9, jsonDetail.getString("cPlcOrder"));
                loSql.bindString(10, jsonDetail.getString("nItemQtyx"));
                loSql.bindString(11, String.valueOf(itemTotalPoints(jsonDetail)));
                loSql.execute();
            }
            db.getWritableDb().setTransactionSuccessful();
            db.getWritableDb().endTransaction();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private double itemTotalPoints(JSONObject jsonObject){
        double points = 0;
        try{
            int qty = Integer.parseInt(jsonObject.getString("nItemQtyx"));
            double pts = Double.parseDouble(jsonObject.getString("nPointsxx"));
            points = qty * pts;
        } catch (JSONException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return points;
    }
}
