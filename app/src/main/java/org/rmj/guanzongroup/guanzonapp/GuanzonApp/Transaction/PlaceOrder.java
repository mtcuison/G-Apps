package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_BranchSelection;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;

import java.util.HashMap;

public class PlaceOrder extends CodeGenerator {
    private static final String TAG = PlaceOrder.class.getSimpleName();

    private Context mContext;
    private AppData db;
    private RequestHeaders headers;
    private GcardAppMaster gcardAppMaster;
    private ConnectionUtil connectionUtil;
    private onPlaceOrderRequestListener onPlaceOrderRequestListener;

    private String message = "";

    private JSONArray items = new JSONArray();

    public interface onPlaceOrderRequestListener{
        void onPlaceOrderSuccessResult();
        void onPlaceOrderFailedResult(String errorMessage);
    }

    public void placeItemsOnCart(Context context, final String BranchCode, final String[] promoIDs, final int[] Quantity, onPlaceOrderRequestListener listener){
        this.mContext = context;
        this.headers = new RequestHeaders(mContext);
        this.gcardAppMaster = new GcardAppMaster(mContext);
        this.connectionUtil = new ConnectionUtil(mContext);
        this.onPlaceOrderRequestListener = listener;

        if(isDataValid(promoIDs)){
            new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_PLACE_ODER(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap)headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    return composeDataParameter(BranchCode, promoIDs, Quantity);
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    Log.e(TAG, "Response : " + jsonResponse.toString());
                    updateItemLocalDb(BranchCode, jsonResponse);
                }

                @Override
                public void onErrorResponse(String message) {
                    onPlaceOrderRequestListener.onPlaceOrderFailedResult(message);
                }
            });
        } else {
            onPlaceOrderRequestListener.onPlaceOrderFailedResult(message);
        }
    }

    private JSONObject composeDataParameter(String BranchCode, String[] promoIDs, int[] Quantity){
        JSONObject params = new JSONObject();
        JSONObject details;
        try{
            for(int x = 0; x < promoIDs.length; x++){
                details = new JSONObject();
                details.put("promoidx", promoIDs[x]);
                details.put("itemqtyx", Quantity[x]);
                items.put(details);
            }
            params.put("secureno", generateSecureNo(gcardAppMaster.getCardNumber()));
            params.put("branchcd", BranchCode);
            params.put("detail", items);

            return params;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean isDataValid(String[] promoIDs){
        if(promoIDs.length == 0){
            message = "No Items to place.";
            return false;
        } else

            //09-02-2020
                // -> if branch code is empty dialog branch selection will automatically open
        /*if(BranchCode.isEmpty()){
            message = "Please select branch.";
            return false;
        } else*/

        if(!connectionUtil.isDeviceConnected()){
            message = "Not internet connection.";
            return false;
        }
        return true;
    }

    private void updateItemLocalDb(String BranchCode, JSONObject jsonResponse){
        try{
            db = AppData.getInstance(mContext);
            String BatchNox = jsonResponse.getString("sTransNox");
            String dPlacOdr = jsonResponse.getString("dPlacOrdr");
            String ReferNox = jsonResponse.getString("sReferNox");
            ContentValues cv = new ContentValues();
            for(int promos = 0; promos < items.length(); promos++) {
                JSONObject object = new JSONObject(items.getString(promos));
                String PromoID = object.getString("promoidx");
                cv.clear();
                cv.put("sBatchNox", BatchNox);
                cv.put("dPlacOrdr", dPlacOdr);
                cv.put("sBranchCd", BranchCode);
                cv.put("sReferNox", ReferNox);
                cv.put("cTranStat", 1);
                cv.put("cPlcOrder", 1);
                db.getWritableDb().update("redeem_item", cv, "sPromoIDx = '" + PromoID + "'", null);
            }
            onPlaceOrderRequestListener.onPlaceOrderSuccessResult();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
