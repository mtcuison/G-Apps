package org.rmj.g3appdriver.ImportData;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Entities.EPromo;
import org.rmj.g3appdriver.Database.Repositories.RPromo;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ImageDownloader;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Import_Promotions implements ImportInstance {
    private static final String TAG = Import_Promotions.class.getSimpleName();
    private final Application instance;
    private final AppConfigPreference poConfig;
/*
    Repository
    private final RBranch repository;
*/

    public Import_Promotions(Application application){
        this.instance = application;
        this.poConfig = AppConfigPreference.getInstance(instance);
//        this.repository = new RBranch(instance);
    }

    @Override
    public void ImportData(ImportDataCallback callback) {
        try {
            new ImportPromotionsTask(callback, instance).execute(new JSONObject());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class ImportPromotionsTask extends AsyncTask<JSONObject, Void, String> {
        private final ImportDataCallback callback;
        private final HttpHeaders headers;
        private final ConnectionUtil conn;
        private final WebApi poWebapi;
        private final RPromo repository;
        private Application instance;
        public ImportPromotionsTask(ImportDataCallback callback, Application instance) {
            this.callback = callback;
            this.instance = instance;
            this.headers = HttpHeaders.getInstance(instance);
            this.conn = new ConnectionUtil(instance);
            this.poWebapi = new WebApi(instance);
            this.repository = new RPromo(instance);

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            String response = "";
            try {
                if(conn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebapi.URL_IMPORT_PROMOLINK, jsonObjects[0].toString(),  headers.getHeaders());
                    Log.e("TAG", response);
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    Log.e(TAG, loJson.getString("result"));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        JSONArray laJson = loJson.getJSONArray("detail");
//                        saveDataToLocal(laJson);
                        if (!saveDataToLocal(laJson)){
                            response = AppConstants.ERROR_SAVING_TO_LOCAL();
                        }
//
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
        boolean saveDataToLocal(JSONArray laJson) throws Exception{
            try{
            List<EPromo> promos = new ArrayList<>();
            if (laJson.length()>0){
                for(int x = 0; x < laJson.length(); x++){
                    JSONObject loJson = laJson.getJSONObject(x);
                    if (!repository.getPromoExist(loJson.getString("sTransNox"))) {
                        EPromo info = new EPromo();
                        info.setTransNox(loJson.getString("sTransNox"));
                        info.setTransact(loJson.getString("dTransact"));
                        info.setImageUrl(loJson.getString("sImageURL"));
                        info.setPromoUrl(loJson.getString("sPromoURL"));
                        info.setCaptionx(loJson.getString("sCaptionx"));
                        info.setDateFrom(loJson.getString("dDateFrom"));
                        info.setDateThru(loJson.getString("dDateThru"));
                        promos.add(info);
                    }
                }

                repository.insertBulkData(promos);
                new ImageDownloader(instance, "Promo").downloadPromoImage(repository.getAllPromoForDownloadImg());
            }
                return true;
            }catch (NullPointerException e){
                e.printStackTrace();
                return false;
            }

        }
    }
}
