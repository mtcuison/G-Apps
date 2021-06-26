package org.rmj.g3appdriver.GuanzonApp;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.EMCSerialRegistration;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RMCSerialRegistration;
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

public class Import_McDetail extends CodeGenerator implements ImportInstance {
    private static final String TAG = Import_Branch.class.getSimpleName();
    private final Application instance;
    private final AppConfigPreference poConfig;
    private final RGcardApp poGcardx;
/*
    Repository
    private final RBranch repository;
*/

    public Import_McDetail(Application application){
        this.instance = application;
        this.poConfig = AppConfigPreference.getInstance(instance);
        this.poGcardx = new RGcardApp(instance);
//        this.repository = new RBranch(instance);
    }

    @Override
    public void ImportData(ImportDataCallback callback) {
        try {
            JSONObject loJson = new JSONObject();
            loJson.put("secureno", generateSecureNo(poGcardx.getGCardInfo().getValue().getCardNmbr()));
            new ImportMcDetailTask(callback, instance).execute(loJson);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class ImportMcDetailTask extends AsyncTask<JSONObject, Void, String> {
        private final ImportDataCallback callback;
        private final RequestHeaders headers;
        private final ConnectionUtil conn;
        private final WebApi poWebApi;
        private final RMCSerialRegistration repository;
        private final RGcardApp gcardApp;


        public ImportMcDetailTask(ImportDataCallback callback, Application instance) {
            this.callback = callback;
            this.headers = new RequestHeaders(instance);
            this.conn = new ConnectionUtil(instance);
            this.poWebApi = new WebApi(instance);
            this.repository = new RMCSerialRegistration(instance);
            this.gcardApp = new RGcardApp(instance);

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            String response = "";
            try {
                if(conn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_IMPORT_MC_REGISTRATION(), jsonObjects[0].toString(),  (HashMap<String, String>) headers.getHeaders());
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    Log.e(TAG, loJson.getString("result"));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        JSONArray laJson = loJson.getJSONArray("detail");
                        saveDataToLocal(laJson);
//                        if(!repository.insertBranchInfos(laJson)){
//                            response = AppConstants.ERROR_SAVING_TO_LOCAL();
//                        }
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
            List<EMCSerialRegistration> brnList = new ArrayList<>();

            EGcardApp eGcardApp = gcardApp.getGCardInfo().getValue();
            for(int x = 0; x < laJson.length(); x++){
                JSONObject loJson = laJson.getJSONObject(x);
                EMCSerialRegistration info = new EMCSerialRegistration();
                info.setGCardNox(eGcardApp.getGCardNox());
                info.setSerialID(loJson.getString("sSerialID"));
                info.setEngineNo(loJson.getString("sEngineNo"));
                info.setFrameNox(loJson.getString("sFrameNox"));
                info.setModelNme(loJson.getString("sModelNme"));
                info.setFSEPStat(loJson.getString("cFSEPStat"));
                info.setRegStatx(loJson.getString("cRegStatx"));
                brnList.add(info);
            }
            repository.insertBulkData(brnList);
        }
    }
}
