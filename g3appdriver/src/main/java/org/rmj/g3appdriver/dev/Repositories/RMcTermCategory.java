/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:18 PM
 */

package org.rmj.g3appdriver.dev.Repositories;

import static org.rmj.g3appdriver.etc.AppConstants.getErrorMessage;
import static org.rmj.g3appdriver.etc.AppConstants.getLocalMessage;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.apprdiver.util.SQLUtil;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMcTermCategory;
import org.rmj.g3appdriver.dev.Database.Entities.EMcTermCategory;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;

import java.util.Date;
import java.util.List;

public class RMcTermCategory {
    private static final String TAG = RMcTermCategory.class.getSimpleName();

    private final DMcTermCategory poDao;
    private final ServerAPIs poApi;
    private final HttpHeaders poHeaders;
    private final GuanzonAppConfig poConfig;

    private String message;

    public RMcTermCategory(Context instance){
        this.poDao = GGC_GuanzonAppDB.getInstance(instance).McTermCategoryDao();
        this.poConfig = new GuanzonAppConfig(instance);
        this.poApi = new ServerAPIs(poConfig.getTestCase());
        this.poHeaders = new HttpHeaders(instance);
    }

    public String getMessage() {
        return message;
    }

    public void insertBulkData(List<EMcTermCategory> categories){
        poDao.insertBulkData(categories);
    }

    public String getLatestDataTime(){
        return poDao.getLatestDataTime();
    }

    public boolean ImportMcTermCategory(){
        try{
            JSONObject params = new JSONObject();
            params.put("bsearch", true);
            params.put("descript", "All");

            EMcTermCategory loObj = poDao.GetLatestMcTermCategory();
            if(loObj != null){
                params.put("timestamp", loObj.getTimeStmp());
            }

            String lsResponse = WebClient.httpPostJSon(
                    poApi.getUrlImportTermCategory(),
                    params.toString(),
                    poHeaders.getHeaders());

            if(lsResponse == null){
                message = "Server no response";
                return false;
            }

            JSONObject loResponse = new JSONObject(lsResponse);

            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("error")){
                JSONObject loError = loResponse.getJSONObject("error");
                message = getErrorMessage(loError);
                return false;
            }

            JSONArray laJson = loResponse.getJSONArray("detail");
            for(int x = 0; x < laJson.length(); x++){
                JSONObject loJson = laJson.getJSONObject(x);
                EMcTermCategory loDetail = poDao.GetMcTermCategory(
                        loJson.getString("sMCCatIDx"),
                        loJson.getString("nAcctTerm"));

                if(loDetail == null){
                    EMcTermCategory loTerm = new EMcTermCategory();
                    loTerm.setMCCatIDx(loJson.getString("sMCCatIDx"));
                    loTerm.setAcctTerm(loJson.getString("nAcctTerm"));
                    loTerm.setAcctThru(loJson.getString("nAcctThru"));
                    loTerm.setFactorRt(loJson.getString("nFactorRt"));
                    loTerm.setPricexxx(loJson.getString("dPricexxx"));
                    loTerm.setTimeStmp(loJson.getString("dTimeStmp"));
                    poDao.insert(loTerm);
                    Log.d(TAG, "Mc term category info has been saved.");
                } else {
                    Date ldDate1 = SQLUtil.toDate(loDetail.getTimeStmp(), SQLUtil.FORMAT_TIMESTAMP);
                    Date ldDate2 = SQLUtil.toDate((String) loJson.get("dTimeStmp"), SQLUtil.FORMAT_TIMESTAMP);
                    if (!ldDate1.equals(ldDate2)) {
                        loDetail.setMCCatIDx(loJson.getString("sMCCatIDx"));
                        loDetail.setAcctTerm(loJson.getString("nAcctTerm"));
                        loDetail.setAcctThru(loJson.getString("nAcctThru"));
                        loDetail.setFactorRt(loJson.getString("nFactorRt"));
                        loDetail.setPricexxx(loJson.getString("dPricexxx"));
                        loDetail.setTimeStmp(loJson.getString("dTimeStmp"));
                        poDao.update(loDetail);
                        Log.d(TAG, "Mc term category info has been updated.");
                    }
                }
            }

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = getLocalMessage(e);
            return false;
        }
    }
}
