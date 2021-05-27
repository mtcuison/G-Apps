package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.HttpRequestUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;

import java.util.HashMap;

public class LoadService {
    private static final String TAG = LoadService.class.getSimpleName();

    private Context mContext;
    private String GCardNox = "";
    private AppData db;
    private OnRequestServiceListener listener;
    private OnRequestRegistrationListener mListener;

    public LoadService(Context context) {
        this.mContext = context;
        this.db = AppData.getInstance(context);
        this.GCardNox = new GcardAppMaster(context).getGCardNox();
    }

    public interface OnRequestServiceListener{
        void onSuccess();
        void onFailed(String message);
    }

    public interface OnRequestRegistrationListener{
        void onSuccess();
        void onFailed(String message);
    }

    /**
     *
     * @return checks if local table has information for motorcycle registration.
     */
    public boolean hasMcRegistration(){
        String[] args = {new GcardAppMaster(mContext).getGCardNox()};
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM MC_Serial_Registration WHERE sGCardNox = ?", args);
        if(cursor.getCount() > 0){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    /**
     * Request Current Mc Service detail of current active Gcard Number...
     */
    public void RequestServiceInfo(final OnRequestServiceListener listener){
        this.listener = listener;
        if(new ConnectionUtil(mContext).isDeviceConnected()){
            new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_IMPORT_SERVICE(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap) new RequestHeaders(mContext).getHeaders();
                }

                @Override
                public JSONObject setData() {
                    JSONObject loJson = new JSONObject();
                    try{
                        String lsGCardNumber = new GcardAppMaster(mContext).getCardNumber();
                        String lsSecureNo = new CodeGenerator().generateSecureNo(lsGCardNumber);
                        loJson.put("secureno", lsSecureNo);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    return loJson;
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    saveMcServiceDetail(jsonResponse);
                }

                @Override
                public void onErrorResponse(String message) {
                    listener.onFailed(message);
                }
            });
        } else {
            listener.onFailed("No internet connection.");
        }
    }

    private void saveMcServiceDetail(JSONObject jsonObject){
        try{
            String lsGcardNox = new GcardAppMaster(mContext).getGCardNox();
            JSONArray laJson = jsonObject.getJSONArray("detail");
            if(laJson.length() > 0) {
                db.getWritableDb().beginTransaction();
                JSONObject loJson = new JSONObject(laJson.getString(0));
                String[] args = {lsGcardNox,
                        loJson.getString("sSerialID"),
                        loJson.getString("sEngineNo"),
                        loJson.getString("sFrameNox"),
                        loJson.getString("sBrandNme"),
                        loJson.getString("sModelNme"),
                        loJson.getString("cFSEPStat"),
                        loJson.getString("dLastSrvc"),
                        loJson.getString("nYellowxx"),
                        loJson.getString("nWhitexxx"),
                        loJson.getString("nYlwCtrxx"),
                        loJson.getString("nWhtCtrxx"),
                        loJson.getString("nMilagexx"),
                        loJson.getString("dNxtRmndS")};
                db.getWritableDb().execSQL("INSERT OR REPLACE INTO tbl_service(" +
                        "sGCardNox, " +
                        "sSerialID," +
                        "sEngineNo," +
                        "sFrameNox," +
                        "sBrandNme," +
                        "sModelNme," +
                        "cFSEPStat," +
                        "dLastSrvc," +
                        "nYellowxx," +
                        "nWhitexxx," +
                        "nYlwCtrxx," +
                        "nWhtCtrxx," +
                        "nMilagexx," +
                        "dNxtRmnds)" +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", args);
                }
                db.getWritableDb().setTransactionSuccessful();
                db.getWritableDb().endTransaction();
                listener.onSuccess();
        } catch (Exception e){
            e.printStackTrace();
            listener.onFailed("Something went wrong. " + e.getMessage());
        }
    }

    public void CheckMcRegistration(OnRequestRegistrationListener listener){
        this.mListener = listener;
        if(new ConnectionUtil(mContext).isDeviceConnected()){
            new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_IMPORT_MC_REGISTRATION(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap) new RequestHeaders(mContext).getHeaders();
                }

                @Override
                public JSONObject setData() {
                    JSONObject loJson = new JSONObject();
                    try{
                        String lsGCardNumber = new GcardAppMaster(mContext).getCardNumber();
                        String lsSecureNo = new CodeGenerator().generateSecureNo(lsGCardNumber);
                        loJson.put("secureno", lsSecureNo);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    return loJson;
                }

                @Override
                public void onResponse(JSONObject jsonResponse) {
                    saveMcRegistration(jsonResponse);
                }

                @Override
                public void onErrorResponse(String message) {
                    mListener.onFailed(message);
                }
            });
        } else {
            mListener.onFailed("No internet connection.");
        }
    }

    private void saveMcRegistration(JSONObject jsonObject){
        try{
            String[] args = {};
            db.getWritableDb().beginTransaction();
            db.getWritableDb().execSQL("INSERT INTO MC_Serial_Registration(" +
                    "sGCardNox," +
                    " sSerialID," +
                    " sEngineNo," +
                    " sFrameNox," +
                    " sModelNme," +
                    " sFSEPStat," +
                    " dRegStatx," +
                    " dLastSrvc," +
                    " nMileAgex," +
                    " dNxtRmnds," +
                    " dModified)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", args);
            db.getWritableDb().setTransactionSuccessful();
            db.getWritableDb().endTransaction();
            mListener.onSuccess();
        } catch (Exception e){
            e.printStackTrace();
            mListener.onFailed("Something went wrong. " + e.getMessage());
        }
    }

    private String getServiceInfo(String ColoumnName){
        String serviceInfo = "";
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_service WHERE sGCardNox = '"+GCardNox+"'", null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            serviceInfo = cursor.getString(cursor.getColumnIndex(ColoumnName));
            cursor.close();
            return serviceInfo;
        }
        cursor.close();
        return serviceInfo;
    }

    public String getEngineNo(){
        return getServiceInfo("sEngineNo");
    }

    public String getModelName(){
        return getServiceInfo("sModelNme");
    }

    public String getBrandName(){
        return getServiceInfo("sBrandNme");
    }

    public String getDatePurchase(){
        return getServiceInfo("dPurchase");
    }

    public String getLastServiceDate(){
        return getServiceInfo("dLastSrvc");
    }

    public String getNextReminders(){
        return getServiceInfo("dNxtRmnds");
    }

    public String getMajorServiceInfo(){
        return getServiceInfo("nYellowxx");
    }

    public String getMinorServiceInfo(){
        return getServiceInfo("nWhitexxx");
    }



    public void checkDateService(OnCheckServiceListener listener){
        try {
            Cursor loCursor = db.getReadableDb().rawQuery("SELECT strftime('%Y-%m-%d','now'), dNxtRmnds FROM tbl_service", null);
            loCursor.moveToFirst();
            if (loCursor.getCount() > 0) {
                String lsDate = "Date time : " + loCursor.getString(0) + " " + loCursor.getString(1);
                Log.e(TAG, "Date time : " + loCursor.getString(0) + " " + loCursor.getString(1));
            }
            Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_service WHERE dNxtRmnds = strftime('%Y-%m-%d','now')", null);
            if (cursor.getCount() > 0) {
                listener.ServiceToday();
            }
            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public interface OnCheckServiceListener{
        void ServiceToday();
    }

    private void checkUnattendedService(){
        try{
            Cursor loCursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_service WHERE dNxtRmnds < strftime('%YYYY-%MM-%dd', 'now');", null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
