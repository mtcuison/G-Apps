package org.rmj.g3appdriver.ImportData;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.appdriver.base.GConnection;
import org.rmj.g3appdriver.Database.DbConnection;
import org.rmj.g3appdriver.Database.Entities.EEvents;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.Database.Repositories.REvents;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ImageDownloader;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.SQLUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Import_Events implements ImportInstance {
    private static final String TAG = Import_Events.class.getSimpleName();
    private final Application instance;
    private final AppConfigPreference poConfig;
/*
    Repository
    private final RBranch repository;
*/

    public Import_Events(Application application){
        this.instance = application;
        this.poConfig = AppConfigPreference.getInstance(instance);
//        this.repository = new RBranch(instance);
    }

    @Override
    public void ImportData(ImportDataCallback callback) {
        try {
            JSONObject loJson = new JSONObject();
//            loJson.put("user_id", db.getUserID());
            new ImportEventTask(callback, instance).execute(loJson);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class ImportEventTask extends AsyncTask<JSONObject, Void, String> {
        private final ImportDataCallback callback;
        private final HttpHeaders headers;
        private final ConnectionUtil conn;
        private final WebApi poWebApi;
        private final REvents repository;
        private final RClientInfo poClient;
        private final SessionManager poSession;
        private Application instance;
        public ImportEventTask(ImportDataCallback callback, Application instance) {
            this.callback = callback;
            this.headers = HttpHeaders.getInstance(instance);
            this.conn = new ConnectionUtil(instance);
            this.poWebApi = new WebApi(instance);
            this.repository = new REvents(instance);
            this.poSession = new SessionManager(instance);
            this.poClient = new RClientInfo(instance);
            this.instance = instance;

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            String response = "";
            try {
                if(conn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_IMPORT_EVENTS, jsonObjects[0].toString(), headers.getHeaders());
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    Log.e(TAG, loJson.getString("result"));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        JSONArray laJson = loJson.getJSONArray("detail");
//                        saveDataToLocal(laJson);
                        if(!insertEvents(laJson)){
                            response = AppConstants.ERROR_SAVING_TO_LOCAL();
                        }

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
        boolean insertEvents(JSONArray faJson) throws Exception{
        try{
            List<EEvents> eEventsList = new ArrayList<>();
            for(int x = 0; x < faJson.length(); x++){
                JSONObject loJson = faJson.getJSONObject(x);
                if (!repository.getEventExist(loJson.getString("sTransNox"))){
                    EEvents info = new EEvents();
                    info.setTransNox(loJson.getString("sTransNox"));
                    info.setBranchNm(loJson.getString("sBranchNm"));
                    info.setEvntFrom(loJson.getString("dEvntFrom"));
                    info.setEvntThru(loJson.getString("dEvntThru"));
                    info.setEventTle(loJson.getString("sEventTle"));
                    info.setAddressx(loJson.getString("sAddressx"));
                    info.setEventURL(loJson.getString("sEventURL"));
                    info.setImageURL(loJson.getString("sImageURL"));
                    info.setNotified("0");
                    info.setModified(AppConstants.DATE_MODIFIED);
                    info.setDirectoryFolder("Events");
                    eEventsList.add(info);
                }

            }
            repository.insertBulkData(eEventsList);
            new ImageDownloader(instance, "Events").downloadEventImage(repository.getAllEventsForDownloadImg());
            //.e(TAG, "Branch info has been save to local.");

            return true;
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }

    }

    }
}
