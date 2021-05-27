package org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.AssetDownload;

import java.util.HashMap;

public class ImportAccountGcard implements GapImportInstance {
    private static final String TAG = ImportAccountGcard.class.getSimpleName();

    private RequestHeaders headers;
    private AppData db;
    private onImportResultListener onImportResultListener;

    @Override
    public void sendRequest(final Context context, onImportResultListener listener) {
        this.headers = new RequestHeaders(context);
        ConnectionUtil connectionUtil = new ConnectionUtil(context);
        this.onImportResultListener = listener;
        this.db = AppData.getInstance(context);

        if(connectionUtil.isDeviceConnected()){
            new AssetDownload(context).deleteCurrentGCard(AppData.getInstance(context).getUserID());
            new HttpRequestUtil().sendRequest(new WebApi(context).URL_IMPORT_GCARD(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    Log.e(TAG, "Headers for importing gcard has been set. ");
                    return (HashMap) headers.getHeaders();
                }

                @Override
                public JSONObject setData() {
                    JSONObject params = new JSONObject();
                    try{
                        params.put("user_id", db.getUserID());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return params;
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    if(new AssetDownload(context).saveGcard(jsonResponse)) {
                        setGcardActive();
                        onImportResultListener.onSuccessImport();
                    } else {
                        onImportResultListener.onErrorResult();
                    }
                }

                @Override
                public void onErrorResponse(String message) {
                    if(isJsonValid(message)) {
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


    private void setGcardActive(){
        if(hasGcard()){
            if(!hasActiveGcard()){
                if(!hasMultipleGCard()){
                    db.getWritableDb().beginTransaction();
                    db.getWritableDb().execSQL("UPDATE Gcard_App_Master SET cActvStat = '1'");
                    db.getWritableDb().setTransactionSuccessful();
                    db.getWritableDb().endTransaction();
                } else {
                    db.getWritableDb().beginTransaction();
                    db.getWritableDb().execSQL("UPDATE Gcard_App_Master SET cActvStat = '1' WHERE sCardNmbr = '"+getHighestPointGcard()+"'");
                    db.getWritableDb().setTransactionSuccessful();
                    db.getWritableDb().endTransaction();
                }
            }
        }
    }

    private boolean hasActiveGcard(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM Gcard_App_Master WHERE cActvStat = '1'", null);
        if(cursor.getCount()>0){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    private boolean hasGcard(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM Gcard_App_Master", null);
        if(cursor.getCount()>0){
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }

    private boolean hasMultipleGCard(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM Gcard_App_Master", null);
        if(cursor.getCount() <= 1){
            cursor.close();
            return false;
        } else {
            cursor.close();
            return true;
        }
    }

    private String getHighestPointGcard(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM Gcard_App_Master WHERE sTotPoint IN (SELECT MAX(sTotPoint) FROM Gcard_App_Master)", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            String gcardNumber = cursor.getString(cursor.getColumnIndex("sCardNmbr"));
            cursor.close();
            return gcardNumber;
        }
        cursor.close();
        return "";
    }
}
