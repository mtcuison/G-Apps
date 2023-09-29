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

    import androidx.lifecycle.LiveData;

    import org.json.JSONArray;
    import org.json.JSONObject;
    import org.rmj.apprdiver.util.SQLUtil;
    import org.rmj.g3appdriver.dev.Database.DataAccessObject.DTownInfo;
    import org.rmj.g3appdriver.dev.Database.Entities.ETownInfo;
    import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
    import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
    import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
    import org.rmj.g3appdriver.etc.GuanzonAppConfig;
    import org.rmj.g3appdriver.utils.WebClient;

    import java.util.Date;
    import java.util.List;
    import java.util.Objects;

    public class RTown {
    private static final String TAG = RTown.class.getSimpleName();

    private final DTownInfo poDao;
    private final Context mContext;

    private final ServerAPIs poApi;
    private final HttpHeaders poHeaders;
    private final GuanzonAppConfig poConfig;


        private String message;

    public RTown(Context instance){
        this.mContext = instance;
        this.poDao = GGC_GuanzonAppDB.getInstance(instance).TownDao();
        this.poConfig = new GuanzonAppConfig(instance);
        this.poApi = new ServerAPIs(poConfig.getTestCase());
        this.poHeaders = new HttpHeaders(mContext);
    }

    public String getMessage() {
        return message;
    }

    public void insertBulkData(List<ETownInfo> townInfoList){
        poDao.insertBulkData(townInfoList);
    }

    public String getLatestDataTime(){
        return poDao.getLatestDataTime();
    }

    public LiveData<DTownInfo.BrgyTownProvinceInfo> getBrgyTownProvinceInfo(String fsID){
        return poDao.getBrgyTownProvinceInfo(fsID);
    }
    public LiveData<DTownInfo.BrgyTownProvinceInfo> getTownProvinceInfo(String fsID){
        return poDao.getTownProvinceInfo(fsID);
    }
    public LiveData<List<DTownInfo.TownProvinceInfo>> getTownProvinceInfo(){
        return poDao.getTownProvinceInfo();
    }

    public DTownInfo.TownProvinceName getTownProvinceName(String TownID){
        return poDao.getTownProvinceNames(TownID);
    }

    public boolean ImportTown(){
        try{
            JSONObject params = new JSONObject();

            params.put("bsearch", true);
            params.put("descript", "All");

            ETownInfo loObj = poDao.GetLatestTown();
            if(loObj != null){
                params.put("timestamp", loObj.getTimeStmp());
            }

            String lsResponse = WebClient.httpPostJSon(
                    poApi.getUrlImportTown(),
                    params.toString(),
                    poHeaders.getHeaders());

            if(lsResponse == null){
                message = "Server no response.";
                return false;
            }

            JSONObject loResponse = new JSONObject(Objects.requireNonNull(lsResponse));
            String lsResult = loResponse.getString("result");
            if (lsResult.equalsIgnoreCase("error")) {
                JSONObject loError = loResponse.getJSONObject("error");
                message = getErrorMessage(loError);
                return false;
            }

            JSONArray laJson = loResponse.getJSONArray("detail");
            for(int x = 0; x < laJson.length(); x++){
                JSONObject loJson = laJson.getJSONObject(x);
                ETownInfo loDetail = poDao.GetTown(loJson.getString("sTownIDxx"));

                if(loDetail == null){

                    if(loJson.getString("cRecdStat").equalsIgnoreCase("1")) {
                        ETownInfo loTown = new ETownInfo();
                        loTown.setTownIDxx(loJson.getString("sTownIDxx"));
                        loTown.setTownName(loJson.getString("sTownName"));
                        loTown.setZippCode(loJson.getString("sZippCode"));
                        loTown.setProvIDxx(loJson.getString("sProvIDxx"));
                        loTown.setMuncplCd(loJson.getString("sMuncplCd"));
                        loTown.setHasRoute(loJson.getString("cHasRoute"));
                        loTown.setBlackLst(loJson.getString("cBlackLst"));
                        loTown.setRecdStat(loJson.getString("cRecdStat"));
                        loTown.setTimeStmp(loJson.getString("dTimeStmp"));
                        poDao.insert(loTown);
                        Log.d(TAG, "Town info has been saved.");
                    }

                } else {
                    Date ldDate1 = SQLUtil.toDate(loDetail.getTimeStmp(), SQLUtil.FORMAT_TIMESTAMP);
                    Date ldDate2 = SQLUtil.toDate((String) loJson.get("dTimeStmp"), SQLUtil.FORMAT_TIMESTAMP);
                    if (!ldDate1.equals(ldDate2)) {
                        loDetail.setTownIDxx(loJson.getString("sTownIDxx"));
                        loDetail.setTownName(loJson.getString("sTownName"));
                        loDetail.setZippCode(loJson.getString("sZippCode"));
                        loDetail.setProvIDxx(loJson.getString("sProvIDxx"));
                        loDetail.setMuncplCd(loJson.getString("sMuncplCd"));
                        loDetail.setHasRoute(loJson.getString("cHasRoute"));
                        loDetail.setBlackLst(loJson.getString("cBlackLst"));
                        loDetail.setRecdStat(loJson.getString("cRecdStat"));
                        loDetail.setTimeStmp(loJson.getString("dTimeStmp"));
                        poDao.update(loDetail);
                        Log.d(TAG, "Town info has been updated.");
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
