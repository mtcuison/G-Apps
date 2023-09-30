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
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMcModelPrice;
import org.rmj.g3appdriver.dev.Database.Entities.EMcModelPrice;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.utils.WebClient;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class RMcModelPrice {
    private static final String TAG = RMcModelPrice.class.getSimpleName();

    private final DMcModelPrice poDao;
    private final ServerAPIs poApi;
    private final HttpHeaders poHeaders;
    private final GuanzonAppConfig poConfig;

    private String message;

    public RMcModelPrice(Context instance) {
        this.poDao = GGC_GuanzonAppDB.getInstance(instance).McModelPriceDao();
        this.poConfig = new GuanzonAppConfig(instance);
        this.poApi = new ServerAPIs(poConfig.getTestCase());
        this.poHeaders = new HttpHeaders(instance);
    }

    public String getMessage() {
        return message;
    }

    public void insertBulkData(List<EMcModelPrice> modelPrices) {
        poDao.insertBulkdData(modelPrices);
    }

    public String getLatestDataTime() {
        return poDao.getLatestDataTime();
    }

    public boolean ImportMcModelPrice(){
        try{
            JSONObject params = new JSONObject();
            params.put("bsearch", true);
            params.put("descript", "All");

            EMcModelPrice loObj = poDao.GetLatestModelPrice();
            if(loObj != null) {
                params.put("timestamp", loObj.getTimeStmp());
            }

            String lsResponse = WebClient.httpPostJSon(
                    poApi.getUrlImportMcModelPrice(),
                    params.toString(),
                    poHeaders.getHeaders());

            if(lsResponse == null){
                message = "Server no response";
                return false;
            }

            JSONObject loResponse = new JSONObject(Objects.requireNonNull(lsResponse));
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("error")){
                JSONObject loError = loResponse.getJSONObject("error");
                message = AppConstants.getErrorMessage(loError);
                return false;
            }

            JSONArray laJson = loResponse.getJSONArray("detail");
            for(int x = 0; x < laJson.length(); x++){
                JSONObject loJson = laJson.getJSONObject(x);
                EMcModelPrice loDetail = poDao.GetModelPrice(loJson.getString("sModelIDx"));

                if(loDetail == null){

                    if(loJson.getString("cRecdStat").equalsIgnoreCase("1")){
                        EMcModelPrice loPrice = new EMcModelPrice();
                        loPrice.setModelIDx(loJson.getString("sModelIDx"));
                        loPrice.setSelPrice(loJson.getString("nSelPrice"));
                        loPrice.setLastPrce(loJson.getString("nLastPrce"));
                        loPrice.setDealrPrc(loJson.getString("nDealrPrc"));
                        loPrice.setMinDownx(loJson.getString("nMinDownx"));
                        loPrice.setMCCatIDx(loJson.getString("sMCCatIDx"));
                        loPrice.setPricexxx(loJson.getString("dPricexxx"));
                        loPrice.setInsPrice(loJson.getString("dInsPrice"));
                        loPrice.setRecdStat(loJson.getString("cRecdStat"));
                        loPrice.setTimeStmp(loJson.getString("dTimeStmp"));
                        poDao.insert(loPrice);
                        Log.d(TAG, "Mc model price info has been saved.");
                    }

                } else {
                    Date ldDate1 = SQLUtil.toDate(loDetail.getTimeStmp(), SQLUtil.FORMAT_TIMESTAMP);
                    Date ldDate2 = SQLUtil.toDate((String) loJson.get("dTimeStmp"), SQLUtil.FORMAT_TIMESTAMP);
                    if (!ldDate1.equals(ldDate2)) {
                        loDetail.setModelIDx(loJson.getString("sModelIDx"));
                        loDetail.setSelPrice(loJson.getString("nSelPrice"));
                        loDetail.setLastPrce(loJson.getString("nLastPrce"));
                        loDetail.setDealrPrc(loJson.getString("nDealrPrc"));
                        loDetail.setMinDownx(loJson.getString("nMinDownx"));
                        loDetail.setMCCatIDx(loJson.getString("sMCCatIDx"));
                        loDetail.setPricexxx(loJson.getString("dPricexxx"));
                        loDetail.setInsPrice(loJson.getString("dInsPrice"));
                        loDetail.setRecdStat(loJson.getString("cRecdStat"));
                        loDetail.setTimeStmp(loJson.getString("dTimeStmp"));
                        poDao.update(loDetail);
                        Log.d(TAG, "Mc model price info has been updated.");
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
