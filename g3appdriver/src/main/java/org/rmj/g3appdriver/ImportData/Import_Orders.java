package org.rmj.g3appdriver.ImportData;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemItemInfo;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Import_Orders extends CodeGenerator implements ImportInstance {
    private static final String TAG = Import_Branch.class.getSimpleName();
    private final Application instance;
    private final AppConfigPreference poConfig;
    private final RGcardApp poGcardx;
/*
    Repository
    private final RBranch repository;
*/

    public Import_Orders(Application application){
        this.instance = application;
        this.poConfig = AppConfigPreference.getInstance(instance);
        this.poGcardx = new RGcardApp(instance);
//        this.repository = new RBranch(instance);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void ImportData(ImportDataCallback callback) {
        try {
            JSONObject loJson = new JSONObject();
            loJson.put("secureno", generateSecureNo(poGcardx.getCardNo()));
            new ImportOrdersTask(callback, instance).execute(loJson);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static class ImportOrdersTask extends AsyncTask<JSONObject, Void, String> {
        private final ImportDataCallback callback;
        private final HttpHeaders headers;
        private final ConnectionUtil conn;
        private WebApi poWebApi;
        private final RRedeemItemInfo repository;


        public ImportOrdersTask(ImportDataCallback callback, Application instance) {
            this.callback = callback;
            this.headers = HttpHeaders.getInstance(instance);
            this.conn = new ConnectionUtil(instance);
            this.poWebApi = new WebApi(instance);
            this.repository = new RRedeemItemInfo(instance);

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            String response = "";
            try {
                if(conn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_IMPORT_PLACE_ORDER, jsonObjects[0].toString(),  headers.getHeaders());
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
            List<ERedeemItemInfo> brnList = new ArrayList<>();

            for(int x = 0; x < laJson.length(); x++){
                JSONObject loJson = laJson.getJSONObject(x);
                ERedeemItemInfo info = new ERedeemItemInfo();
                info.setPromoIDx(loJson.getString("sPromoIDx"));
                info.setTransNox(loJson.getString("sTransNox"));
                info.setGCardNox(loJson.getString("sGCardNox"));
                info.setOrderedx(loJson.getString("dOrderedx"));
                info.setPickupxx(loJson.getString("dPickupxx"));
                info.setBranchCd(loJson.getString("sBranchCD"));
                info.setReferNox(loJson.getString("sReferNox"));
                info.setTranStat(loJson.getString("cTranStat"));
                info.setPlcOrder(loJson.getString("cPlcOrder"));
                info.setPlcOrder(loJson.getString("cPlcOrder"));
                info.setItemQtyx(Integer.parseInt(loJson.getString("nItemQtyx")));

                info.setPointsxx(itemTotalPoints(loJson));
                brnList.add(info);
            }
            repository.insertBulkData(brnList);
        }
        private double itemTotalPoints(JSONObject jsonObject){
            double points = 0;
            try{
                int qty = Integer.parseInt(jsonObject.getString("nItemQtyx"));
                double pts = Double.parseDouble(jsonObject.getString("nPointsxx"));
                points = qty * pts;
            } catch (JSONException e){
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
            return points;
        }
    }

}
