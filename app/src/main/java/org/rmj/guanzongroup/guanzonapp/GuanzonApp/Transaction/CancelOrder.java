package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction;

import android.content.Context;
import android.database.Cursor;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;

import java.util.HashMap;

public class CancelOrder extends CodeGenerator {
    private AppData db;
    private RequestHeaders headers;
    private ConnectionUtil connectionUtil;
    private onCancelOrderRequestListener onCancelOrderRequestListener;

    public interface onCancelOrderRequestListener{
        void onCancellationSuccessResult();
        void onCancellationFailedResult(String errorMessage);
    }

    private String message = "";

    public void sendCancelOrderRequest(Context context, final String ReferNox, onCancelOrderRequestListener listener){
        this.db = AppData.getInstance(context);
        this.headers = new RequestHeaders(context);
        this.connectionUtil = new ConnectionUtil(context);
        this.onCancelOrderRequestListener = listener;

        if(isValid(ReferNox)){
            new HttpRequestUtil().sendRequest(new WebApi(context).URL_CANCEL_ORDER(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap)headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    JSONObject params = new JSONObject();
                    try{
                        params.put("uuid", generateSecureNo(getReferNoxBatchNo(ReferNox)));
                        return params;
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    updateLocalOrderTable(ReferNox);
                }

                @Override
                public void onErrorResponse(String message) {
                    onCancelOrderRequestListener.onCancellationFailedResult(message);
                }
            });
        } else {
            onCancelOrderRequestListener.onCancellationFailedResult(message);
        }
    }

    private boolean isValid(String ReferNox){
        if(!connectionUtil.isDeviceConnected()){
            message = "No internet connection.";
            return false;
        } else if(isOrderCancelable(ReferNox)){
            message = "Were unable to cancel your order. Your items are already being process.";
            return false;
        } else {
            return true;
        }
    }

    private boolean isOrderCancelable(String ReferNox){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM redeem_item WHERE sReferNox = '"+ ReferNox +"' AND datetime(dOrderedx, '+24 Hour') < datetime('now')", null);
        if(cursor.getCount()>0){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    private void updateLocalOrderTable(String ReferNox){
        db.getWritableDb().execSQL("DELETE FROM redeem_item WHERE sReferNox = '"+ReferNox+"'");
        onCancelOrderRequestListener.onCancellationSuccessResult();
    }

    private String getReferNoxBatchNo(String ReferNox){
        Cursor cursor = db.getWritableDb().rawQuery("SELECT sBatchNox FROM redeem_item WHERE sReferNox = '"+ReferNox+"'", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            String batchno = cursor.getString(cursor.getColumnIndex("sBatchNox"));
            cursor.close();
            return batchno;
        }
        cursor.close();
        return null;
    }
}
