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

import static org.rmj.g3appdriver.etc.AppConstants.getLocalMessage;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.apprdiver.util.SQLUtil;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMcCategory;
import org.rmj.g3appdriver.dev.Database.Entities.EMcCategory;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;

import java.util.Date;
import java.util.List;

public class RMcCategory {
    private static final String TAG = RMcCategory.class.getSimpleName();

    private final DMcCategory poDao;

    private final ServerAPIs poApi;
    private final HttpHeaders poHeaders;
    private final GuanzonAppConfig poConfig;

    private String message;

    public RMcCategory(Context instance){
        this.poDao = GGC_GuanzonAppDB.getInstance(instance).McCategoryDao();
        this.poConfig = new GuanzonAppConfig(instance);
        this.poApi = new ServerAPIs(poConfig.getTestCase());
        this.poHeaders = new HttpHeaders(instance);
    }

    public String getMessage() {
        return message;
    }

    public void insertBulkData(List<EMcCategory> categories){
        poDao.insetBulkData(categories);
    }

    public String getLatestDataTime(){
        return poDao.getLatestDataTime();
    }

    public boolean ImportMcCategory(){
        try{
            JSONObject params = new JSONObject();
            params.put("bsearch", true);
            params.put("descript", "All");

            EMcCategory loObj = poDao.GetLatestMcCategory();
            if(loObj != null) {
                params.put("timestamp", loObj.getTimeStmp());
            }

            String lsResponse = WebClient.httpsPostJSon(
                    poApi.getUrlImportMcCategory(),
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
                message = AppConstants.getErrorMessage(loError);
                return false;
            }

            JSONArray laJson = loResponse.getJSONArray("detail");
            for(int x = 0; x < laJson.length(); x++){
                JSONObject loJson = laJson.getJSONObject(x);
                EMcCategory loDetail = poDao.GetMcCategory(loJson.getString("sMCCatIDx"));

                if(loDetail == null){

                    if(loJson.getString("cRecdStat").equalsIgnoreCase("1")) {
                        EMcCategory loCat = new EMcCategory();
                        loCat.setMcCatIDx(loJson.getString("sMCCatIDx"));
                        loCat.setMcCatNme(loJson.getString("sMCCatNme"));
                        loCat.setMiscChrg(loJson.getString("nMiscChrg"));
                        loCat.setRebatesx(loJson.getString("nRebatesx"));
                        loCat.setEndMrtgg(loJson.getString("nEndMrtgg"));
                        loCat.setRecdStat(loJson.getString("cRecdStat"));
                        loCat.setTimeStmp(loJson.getString("dTimeStmp"));
                        poDao.insert(loCat);
                        Log.d(TAG, "Mc category info has been saved.");
                    }
                } else {
                    Date ldDate1 = SQLUtil.toDate(loDetail.getTimeStmp(), SQLUtil.FORMAT_TIMESTAMP);
                    Date ldDate2 = SQLUtil.toDate((String) loJson.get("dTimeStmp"), SQLUtil.FORMAT_TIMESTAMP);
                    if (!ldDate1.equals(ldDate2)) {
                        loDetail.setMcCatIDx(loJson.getString("sMCCatIDx"));
                        loDetail.setMcCatNme(loJson.getString("sMCCatNme"));
                        loDetail.setMiscChrg(loJson.getString("nMiscChrg"));
                        loDetail.setRebatesx(loJson.getString("nRebatesx"));
                        loDetail.setEndMrtgg(loJson.getString("nEndMrtgg"));
                        loDetail.setRecdStat(loJson.getString("cRecdStat"));
                        loDetail.setTimeStmp(loJson.getString("dTimeStmp"));
                        poDao.insert(loDetail);
                        Log.d(TAG, "Mc category info has been updated.");
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
