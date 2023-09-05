/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 5/14/21 3:59 PM
 * project file last modified : 5/14/21 3:59 PM
 */

package org.rmj.g3appdriver.etc;


import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.apprdiver.util.SQLUtil;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRelation;
import org.rmj.g3appdriver.dev.Database.Entities.ERelation;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Relation {
    private static final String TAG = Relation.class.getSimpleName();

    private final DRelation poDao;
    private final Context mContext;

    private final ServerAPIs poApi;
    private final HttpHeaders poHeaders;
    private final GuanzonAppConfig poConfig;

    private String message;

    public Relation(Context mContext){
        this.mContext = mContext;
        this.poDao = GGC_GuanzonAppDB.getInstance(mContext).relDao();
        this.poConfig = new GuanzonAppConfig(mContext);
        this.poApi = new ServerAPIs(poConfig.getTestCase());
        this.poHeaders = new HttpHeaders(mContext);
    }

    public String getMessage() {
        return message;
    }

    public LiveData<List<ERelation>> GetRelations(){
        return poDao.getRelation();
    }

    public boolean ImportRelations(){
        try{
            JSONObject params = new JSONObject();
            params.put("descript", "All");
            params.put("bsearch", true);

            ERelation loDetail = poDao.GetLatestRelationInfo();
            if(loDetail != null){
                params.put("timestamp", loDetail.getTimeStmp());
            }

            String lsResponse = WebClient.httpsPostJSon(
                    poApi.getUrlDownloadRelation(),
                    params.toString(),
                    poHeaders.getHeaders());
            if(lsResponse == null){
                message = "Server no response while importing response.";
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
            for (int x = 0; x < laJson.length(); x++) {
                JSONObject loJson = laJson.getJSONObject(x);
                ERelation loRel = poDao.GetRelationInfo(loJson.getString("sRelatnID"));
                if(loRel == null){

                    if(loJson.getString("cRecdStat").equalsIgnoreCase("1")) {
                        ERelation loanInfo = new ERelation();
                        loanInfo.setRelatnID(loJson.getString("sRelatnID"));
                        loanInfo.setRelatnDs(loJson.getString("sRelatnDs"));
                        loanInfo.setRecdStats(loJson.getString("cRecdStat"));
                        loanInfo.setTimeStmp(loJson.getString("dTimeStmp"));
                        poDao.insert(loanInfo);
                        Log.d(TAG, "Relation info has been saved.");
                    }

                } else {
                    Date ldDate1 = SQLUtil.toDate(loDetail.getTimeStmp(), SQLUtil.FORMAT_TIMESTAMP);
                    Date ldDate2 = SQLUtil.toDate((String) loJson.get("dTimeStmp"), SQLUtil.FORMAT_TIMESTAMP);
                    if (!ldDate1.equals(ldDate2)) {
                        loRel.setRelatnID(loJson.getString("sRelatnID"));
                        loRel.setRelatnDs(loJson.getString("sRelatnDs"));
                        loRel.setRecdStats(loJson.getString("cRecdStat"));
                        loRel.setTimeStmp(loJson.getString("dTimeStmp"));
                        poDao.update(loRel);
                        Log.d(TAG, "Relation info has been updated.");
                    }
                }
            }

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = AppConstants.getLocalMessage(e);
            return false;
        }
    }

}
