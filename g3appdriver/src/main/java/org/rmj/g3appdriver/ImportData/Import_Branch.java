package org.rmj.g3appdriver.ImportData;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Repositories.RBranchInfo;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;

import java.util.Arrays;
import java.util.Objects;


public class Import_Branch implements ImportInstance{
    private static final String TAG = Import_Branch.class.getSimpleName();
    private final Application instance;
    private final AppConfigPreference poConfig;
/*
    Repository
    private final RBranch repository;
*/

    public Import_Branch(Application application){
        this.instance = application;
        this.poConfig = AppConfigPreference.getInstance(instance);
//        this.repository = new RBranch(instance);
    }

    @Override
    public void ImportData(ImportDataCallback callback) {
        try {
            new ImportBranchTask(callback, instance).execute(new JSONObject());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class ImportBranchTask extends AsyncTask<JSONObject, Void, String> {
        private final ImportDataCallback callback;
        private final HttpHeaders headers;
        private final ConnectionUtil conn;
        private final RBranchInfo repository;
        private final WebApi poWebApi;

        public ImportBranchTask(ImportDataCallback callback, Application instance) {
            this.callback = callback;
            this.headers = HttpHeaders.getInstance(instance);
            this.conn = new ConnectionUtil(instance);
            this.repository = new RBranchInfo(instance);
            this.poWebApi = new WebApi(instance);

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            String response = "";
            try {
                if(conn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_IMPORT_BRANCH, jsonObjects[0].toString(), headers.getHeaders());
                    Log.e("TAG", response);
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        JSONArray laJson = loJson.getJSONArray("detail");
                        if (!repository.insertBranchInfos(laJson)){
                            response = AppConstants.ERROR_SAVING_TO_LOCAL();
                        }
                        Log.e(TAG, lsResult);
//
                    } else {
                        JSONObject loError = loJson.getJSONObject("error");
                        String message = loError.getString("message");
                        callback.OnFailedImportData(TAG + " " + message);
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

    }

}
