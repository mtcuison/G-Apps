package org.rmj.g3appdriver.GuanzonApp;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.Database.Repositories.RRedeemablesInfo;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.Http.RequestHeaders;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Import_Redeemables implements ImportInstance {
    private static final String TAG = Import_Branch.class.getSimpleName();
    private final Application instance;
    private final AppConfigPreference poConfig;
/*
    Repository
    private final RBranch repository;
*/

    public Import_Redeemables(Application application){
        this.instance = application;
        this.poConfig = AppConfigPreference.getInstance(instance);
//        this.repository = new RBranch(instance);
    }

    @Override
    public void ImportData(ImportDataCallback callback) {
        try {
            new ImportRedeemablesTask(callback, instance).execute(new JSONObject());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class ImportRedeemablesTask extends AsyncTask<JSONObject, Void, String> {
        private final ImportDataCallback callback;
        private final HttpHeaders headers;
        private final ConnectionUtil conn;
        private final WebApi poWebApi;
        private final RRedeemablesInfo repository;


        public ImportRedeemablesTask(ImportDataCallback callback, Application instance) {
            this.callback = callback;
            this.headers = HttpHeaders.getInstance(instance);
            this.conn = new ConnectionUtil(instance);
            this.poWebApi = new WebApi(instance);
            this.repository = new RRedeemablesInfo(instance);

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            String response = "";
            try {
                if(conn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_IMPORT_REDEEM_ITEMS, jsonObjects[0].toString(), headers.getHeaders());
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
                    Log.e(TAG, lsResult);
                    callback.OnSuccessImportData();
                } else {
                    JSONObject loError = loJson.getJSONObject("error");
                    String message = loError.getString("message");
                    callback.OnFailedImportData(TAG + " " + message);
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
            List<ERedeemablesInfo> brnList = new ArrayList<>();

            for(int x = 0; x < laJson.length(); x++){
                JSONObject loJson = laJson.getJSONObject(x);
                ERedeemablesInfo info = new ERedeemablesInfo();
                info.setTransNox(loJson.getString("sTransNox"));
                info.setPromoCde(loJson.getString("sPromCode"));
                info.setPromoDsc(loJson.getString("sPromDesc"));
                info.setPointsxx(Double.parseDouble(loJson.getString("nPointsxx")));
                info.setImageUrl(loJson.getString("sImageURL"));
                info.setDateFrom(loJson.getString("dDateFrom"));
                info.setDateThru(loJson.getString("dDateThru"));
                info.setPreOrder(loJson.getString("cPreOrder"));
                brnList.add(info);
            }
            repository.insertBulkData(brnList);
        }
    }
}
