package org.rmj.guanzongroup.guanzonapp.GuanzonApp.WebRequest;

import android.content.Context;
import android.database.Cursor;

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

public class McInfoService extends CodeGenerator {

    private Context mContext;
    private AppData db;
    private RequestHeaders headers;
    private ConnectionUtil connectionUtil;
    private GcardAppMaster gcardAppMaster;
    private onRequestServiceListener onRequestServiceListener;

    private String GCardNox = "";

    public McInfoService(Context context){
        this.mContext = context;
        this.db = AppData.getInstance(mContext);
        this.headers = new RequestHeaders(mContext);
        this.connectionUtil = new ConnectionUtil(mContext);
        this.gcardAppMaster = new GcardAppMaster(mContext);
    }

    public void requestServiceInfo(final String GCardNumber, onRequestServiceListener listener){
        this.onRequestServiceListener = listener;
        if(isDataValid()) {
            new HttpRequestUtil().sendRequest(new WebApi(mContext).URL_IMPORT_SERVICE(), new HttpRequestUtil.onServerResponseListener() {
                @Override
                public HashMap setHeaders() {
                    return (HashMap) headers.getHeaders();
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
                    saveDataToLocal(jsonResponse);
                }

                @Override
                public void onErrorResponse(String message) {
                    onRequestServiceListener.onRequestServiceFailed(message);
                }
            });
        } else {
            onRequestServiceListener.onRequestServiceFailed("No internet connection.");
        }
    }

    private boolean isDataValid(){
        if(gcardAppMaster.hasNoGcard()){
            return false;
        } else if(!connectionUtil.isDeviceConnected()){
            return false;
        }
        GCardNox = gcardAppMaster.getGCardNox();
        return true;
    }

    public interface onRequestServiceListener{
        void onRequestServiceSuccess();
        void onRequestServiceFailed(String errorMessage);
    }

    private void saveDataToLocal(JSONObject jsonResponse){
        try{
            String result1 = jsonResponse.getString("result");
            if (result1.equalsIgnoreCase("success")) {
                JSONArray arrResponse = jsonResponse.getJSONArray("detail");
                if (arrResponse.length() > 0) {
                    for (int x = 0; x < arrResponse.length(); x++) {
                        JSONObject jsonDetail = new JSONObject(arrResponse.getString(x));
                        String serialID = jsonDetail.getString("sSerialID");
                        if (!isServiceExist(serialID)) {
                            db.getWritableDb().execSQL("INSERT INTO tbl_service(" +
                                    "sGCardNox, " +
                                    "sSerialID," +
                                    "sEngineNo," +
                                    "sFrameNox," +
                                    "sModelNme," +
                                    "cFSEPStat," +
                                    "dPurchase," +
                                    "nYellowxx," +
                                    "nWhitexxx," +
                                    "dLastSrvc," +
                                    "nMilagexx," +
                                    "dNxtRmnds)" +
                                    "VALUES(" +
                                    "'" + GCardNox + "'," +
                                    "'" + jsonDetail.getString("sSerialID") + "'," +
                                    "'" + jsonDetail.getString("sEngineNo") + "'," +
                                    "'" + jsonDetail.getString("sFrameNox") + "'," +
                                    "'" + jsonDetail.getString("sModelNme") + "'," +
                                    "'" + jsonDetail.getString("cFSEPStat") + "'," +
                                    "'" + jsonDetail.getString("dPurchase") + "'," +
                                    "'" + jsonDetail.getString("nYellowxx") + "'," +
                                    "'" + jsonDetail.getString("nWhitexxx") + "'," +
                                    "'" + jsonDetail.getString("dLastSrvc") + "'," +
                                    "'" + jsonDetail.getString("nMilagexx") + "'," +
                                    "'" + jsonDetail.getString("dNxtRmndS") + "')");
                        }
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            onRequestServiceListener.onRequestServiceSuccess();
        }
    }

    private boolean isServiceExist(String serialid){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_service WHERE sSerialID = '"+serialid+"'", null);
        int rowCount = cursor.getCount();
        if(rowCount >0){
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }
}
