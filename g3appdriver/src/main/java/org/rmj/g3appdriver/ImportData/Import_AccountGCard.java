package org.rmj.g3appdriver.ImportData;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;

import java.util.Arrays;
import java.util.Objects;

public class Import_AccountGCard implements ImportInstance {
    private static final String TAG = Import_AccountGCard.class.getSimpleName();
    private final Application instance;
    private final AppConfigPreference poConfig;
    private final RClientInfo poClient;
    private final SessionManager poSession;
/*
    Repository
    private final RBranch repository;
*/

    public Import_AccountGCard(Application application){
        this.instance = application;
        this.poConfig = AppConfigPreference.getInstance(instance);
        this.poClient = new RClientInfo(instance);
        this.poSession = new SessionManager(instance);
    }

    @Override
    public void ImportData(ImportDataCallback callback) {
        try {
            JSONObject loJson = new JSONObject();
            loJson.put("user_id", new SessionManager(instance).getUserID());
            new ImportAccountGCardTask(callback, instance).execute(loJson);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class ImportAccountGCardTask extends AsyncTask<JSONObject, Void, String> {
        private final ImportDataCallback callback;
        private final HttpHeaders headers;
        private final ConnectionUtil conn;
        private final WebApi poWebApi;
        private final RGcardApp repository;
        private final RClientInfo poClient;
        private final SessionManager poSession;
        private final Application instance;


        public ImportAccountGCardTask(ImportDataCallback callback, Application instance) {
            this.callback = callback;
            this.headers = HttpHeaders.getInstance(instance);
            this.conn = new ConnectionUtil(instance);
            this.poWebApi = new WebApi(instance);
            this.repository = new RGcardApp(instance);
            this.poSession = new SessionManager(instance);
            this.poClient = new RClientInfo(instance);
            this.instance = instance;

        }

        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            String response = "";
            try {
                if(conn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_IMPORT_GCARD, jsonObjects[0].toString(),headers.getHeaders());
                    Log.e("Import_AccountGCard", response);
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        if (!repository.insertGCard(loJson)){
                            response = AppConstants.ERROR_SAVING_TO_LOCAL();
                        }
                        else {
                            Log.e("ELSE", lsResult);
                            repository.saveGCardUpdate();
                        }

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
                    callback.OnFailedImportData(message + "Import GCard");
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
