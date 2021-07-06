package org.rmj.g3appdriver.GuanzonApp;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.Database.DataAccessObject.DServiceInfo;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.Database.Entities.EServiceInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemItemInfo;
import org.rmj.g3appdriver.Database.Repositories.RServiceInfo;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Import_Service extends CodeGenerator implements ImportInstance {
    private static final String TAG = Import_Service.class.getSimpleName();
    private final Application instance;
    private final RGcardApp poGcardx;

    public Import_Service(Application application){
        Log.e(TAG, "Initialized.");
        this.instance = application;
        this.poGcardx = new RGcardApp(instance);
    }

    @Override
    public void ImportData(ImportDataCallback callback) {
        try {
            JSONObject loJson = new JSONObject();
            String lsSecureN = new CodeGenerator()
                    .generateSecureNo(poGcardx.getActiveGcardNo());
            loJson.put("secureno", lsSecureN);
            new ImportServicesTask(callback, instance).execute(loJson);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class ImportServicesTask extends AsyncTask<JSONObject, Void, String> {
        private final ImportDataCallback callback;
        private final HttpHeaders headers;
        private final ConnectionUtil conn;
        private WebApi poWebApi;
        private final RServiceInfo poService;


        public ImportServicesTask(ImportDataCallback callback, Application instance) {
            this.callback = callback;
            this.headers = HttpHeaders.getInstance(instance);
            this.conn = new ConnectionUtil(instance);
            this.poWebApi = new WebApi(instance);
            this.poService = new RServiceInfo(instance);

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            String response = "";
            try {
                if(conn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_IMPORT_SERVICE, jsonObjects[0].toString(),  headers.getHeaders());
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    Log.e(TAG, loJson.getString("result"));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        JSONArray laJson = loJson.getJSONArray("detail");
                        saveDataToLocal(laJson);
                    } else {
                        JSONObject loError = loJson.getJSONObject("error");
                        String message = loError.getString("message");
                        callback.OnFailedImportData(message);
                    }
                } else {
                    response = AppConstants.NO_INTERNET();
                }
            } catch (Exception e) {
                Log.e(TAG, Arrays.toString(e.getStackTrace()));
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject loJson = new JSONObject(s);
                Log.e(TAG, loJson.getString("result"));
                String lsResult = loJson.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.OnSuccessImportData();
                } else {
                    JSONObject loError = loJson.getJSONObject("error");
                    String message = loError.getString("message");
                    callback.OnFailedImportData(message);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                callback.OnFailedImportData(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                callback.OnFailedImportData(e.getMessage());
            }
        }
        void saveDataToLocal(JSONArray laJson) throws Exception{
            Log.e("ServiceSave", laJson.toString());

            List<EServiceInfo> loServces = new ArrayList<>();


            for(int x = 0; x < laJson.length(); x++){
                JSONObject loJson = laJson.getJSONObject(x);
                EServiceInfo info = new EServiceInfo();

                info.setGCardNox("M00121000043");
                info.setSerialID(loJson.getString("sSerialID"));
                info.setEngineNo(loJson.getString("sEngineNo"));
                info.setFrameNox(loJson.getString("sFrameNox"));
                info.setModelNme(loJson.getString("sModelNme"));
                info.setBrandNme(loJson.getString("sBrandNme"));
                info.setFSEPStat(loJson.getString("cFSEPStat"));
                info.setYellowxx(loJson.getInt("nYellowxx"));
                info.setYlwCtrxx(loJson.getInt("nYlwCtrxx"));
                info.setWhitexxx(loJson.getInt("nWhitexxx"));
                info.setWhtCtrxx(loJson.getInt("nWhtCtrxx"));
                info.setLastSrvc(loJson.getString("dLastSrvc"));
                info.setMIlAgexx(loJson.getInt("nMilagexx"));
                info.setNxtRmnds(loJson.getString("dNxtRmndS"));

                loServces.add(info);
            }
            poService.insertBulkData(loServces);
        }

    }

}
