package org.rmj.g3appdriver.dev.Repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.dev.Database.Entities.EBarangayInfo;
import org.rmj.g3appdriver.dev.Database.Entities.ECountryInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EProvinceInfo;
import org.rmj.g3appdriver.dev.Database.Entities.ETownInfo;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;

import java.util.ArrayList;
import java.util.List;

public class RAddress {
    private static final String TAG = RAddress.class.getSimpleName();

    private final Context mContext;
    private final DAddress poDao;
    private JSONObject data;
    private String message;

    public RAddress(Context instance) {
        this.mContext = instance;
        this.poDao = GGC_GuanzonAppDB.getInstance(mContext).AddDao();
    }

    public LiveData<List<EBarangayInfo>> GetBarangayList(String fsTownID){
        return poDao.GetBarangayList(fsTownID);
    }

    public LiveData<List<DAddress.oTownObj>> GetTownList(){
        return poDao.GetTownList();
    }

    public LiveData<List<ECountryInfo>> GetCountryList(){
        return poDao.GetCountryList();
    }

    public boolean ImportBarangayList(){
        try{
            JSONObject param = new JSONObject();
            param.put("bsearch", true);
            param.put("descript", "All");
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsAddress = loApis.getImportBarangayAPI();
            String lsResponse = WebClient.httpsPostJSon(lsAddress, param.toString(), new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Server no response";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    Log.e(TAG, message);
                    return false;
                } else {
                    Log.d(TAG, "Importing barangay info success.");
                    JSONArray laJson = loResponse.getJSONArray("detail");
                    List<EBarangayInfo> laDetail = new ArrayList<>();
                    for(int x = 0; x < laJson.length(); x++){
                        JSONObject loJson = laJson.getJSONObject(x);
                        EBarangayInfo loDetail = new EBarangayInfo();
                        loDetail.setBrgyIDxx(loJson.getString("sBrgyIDxx"));
                        loDetail.setBrgyName(loJson.getString("sBrgyName"));
                        loDetail.setTownIDxx(loJson.getString("sTownIDxx"));
                        loDetail.setHasRoute(loJson.getString("cHasRoute"));
                        loDetail.setBlackLst(loJson.getString("cBlackLst"));
                        loDetail.setRecdStat(loJson.getString("cRecdStat"));
                        loDetail.setTimeStmp(loJson.getString("dTimeStmp"));
                        laDetail.add(loDetail);
                    }
                    poDao.SaveBarangay(laDetail);
                    Log.d(TAG, "Saving barangay info success.");
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean ImportTownList(){
        try{
            JSONObject param = new JSONObject();
            param.put("bsearch", true);
            param.put("descript", "All");

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsAddress = loApis.getImportTownAPI();
            String lsResponse = WebClient.httpsPostJSon(lsAddress, param.toString(), new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Server no response";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    Log.e(TAG, message);
                    return false;
                } else {
                    Log.d(TAG, "Importing town info success.");
                    JSONArray laJson = loResponse.getJSONArray("detail");
                    List<ETownInfo> laDetail = new ArrayList<>();
                    for(int x = 0; x < laJson.length(); x++) {
                        JSONObject loJson = laJson.getJSONObject(x);
                        ETownInfo loDetail = new ETownInfo();
                        loDetail.setTownIDxx(loJson.getString("sTownIDxx"));
                        loDetail.setTownName(loJson.getString("sTownName"));
                        loDetail.setZippCode(loJson.getString("sZippCode"));
                        loDetail.setProvIDxx(loJson.getString("sProvIDxx"));
                        loDetail.setMuncplCd(loJson.getString("sMuncplCd"));
                        loDetail.setHasRoute(loJson.getString("cHasRoute"));
                        loDetail.setBlackLst(loJson.getString("cBlackLst"));
                        loDetail.setRecdStat(loJson.getString("cRecdStat"));
                        loDetail.setTimeStmp(loJson.getString("dTimeStmp"));
                        laDetail.add(loDetail);
                    }
                    poDao.SaveTown(laDetail);
                    Log.d(TAG, "Saving town info success.");
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean ImportProvinceList(){
        try{
            JSONObject param = new JSONObject();
            param.put("bsearch", true);
            param.put("descript", "All");

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsAddress = loApis.getImportProvinceAPI();
            String lsResponse = WebClient.httpsPostJSon(lsAddress, param.toString(), new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Server no response";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    Log.e(TAG, message);
                    return false;
                } else {
                    Log.d(TAG, "Importing province info success.");
                    JSONArray laJson = loResponse.getJSONArray("detail");
                    List<EProvinceInfo> laDetail = new ArrayList<>();
                    for(int x = 0; x < laJson.length(); x++){
                        JSONObject loJson = new JSONObject(laJson.getString(x));
                        EProvinceInfo loDetail = new EProvinceInfo();
                        loDetail.setProvIDxx(loJson.getString("sProvIDxx"));
                        loDetail.setProvName(loJson.getString("sProvName"));
                        loDetail.setRecdStat(loJson.getString("cRecdStat").charAt(0));
                        loDetail.setTimeStmp(loJson.getString("dTimeStmp"));
                        laDetail.add(loDetail);
                    }
                    poDao.SaveProvince(laDetail);
                    Log.d(TAG, "Saving province info success.");
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean ImportCountryList(){
        try{
            JSONObject param = new JSONObject();
            param.put("bsearch", true);
            param.put("descript", "All");

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsAddress = loApis.getImportCountriesAPI();
            String lsResponse = WebClient.httpsPostJSon(lsAddress, param.toString(), new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Server no response";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    Log.e(TAG, message);
                    return false;
                } else {
                    Log.d(TAG, "Importing country info success.");
                    JSONArray laJson = loResponse.getJSONArray("detail");
                    List<ECountryInfo> laDetail = new ArrayList<>();
                    for(int x = 0; x < laJson.length(); x++){
                        JSONObject loJson = new JSONObject(laJson.getString(x));
                        ECountryInfo loDetail = new ECountryInfo();
                        loDetail.setCntryCde(loJson.getString("sCntryCde"));
                        loDetail.setCntryCde(loJson.getString("sCntryNme"));
                        loDetail.setCntryCde(loJson.getString("sNational"));
                        loDetail.setCntryCde(loJson.getString("cRecdStat"));
                        loDetail.setCntryCde(loJson.getString("dTimeStmp"));
                        laDetail.add(loDetail);
                    }
                    poDao.SaveCountry(laDetail);
                    Log.d(TAG, "Saving country info success.");
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean AddShipAddress(){
        try{
            JSONObject param = new JSONObject();
            param.put("sTransNox", "");
            param.put("sClientID", "info.getClientID()");
            param.put("cReqstCDe", "info.getReqstCDe()");
            param.put("cAddrssTp", "info.getAddrssTp()");
            param.put("sHouseNox", "info.getHouseNox()");
            param.put("sAddressx", "info.getAddressx()");
            param.put("sTownIDxx", "info.getTownIDxx()");
            param.put("sBrgyIDxx", "info.getBrgyIDxx()");
            param.put("cPrimaryx", "info.getPrimaryx()");
            param.put("nLatitude", "");
            param.put("nLongitud", "");
            param.put("sRemarksx", "info.getRemarksx()");
            param.put("sSourceCD", "DCPa");
            param.put("sSourceNo", "fsTransno");

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsAddress = loApis.getImportCountriesAPI();
            String lsResponse = WebClient.httpsPostJSon(lsAddress, param.toString(), new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Server no response";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    Log.e(TAG, message);
                    return false;
                } else {
                    Log.d(TAG, "Importing country info success.");
                    JSONArray laJson = loResponse.getJSONArray("detail");
                    List<ECountryInfo> laDetail = new ArrayList<>();
                    for(int x = 0; x < laJson.length(); x++){
                        JSONObject loJson = new JSONObject(laJson.getString(x));
                        ECountryInfo loDetail = new ECountryInfo();
                        loDetail.setCntryCde(loJson.getString("sCntryCde"));
                        loDetail.setCntryCde(loJson.getString("sCntryNme"));
                        loDetail.setCntryCde(loJson.getString("sNational"));
                        loDetail.setCntryCde(loJson.getString("cRecdStat"));
                        loDetail.setCntryCde(loJson.getString("dTimeStmp"));
                        laDetail.add(loDetail);
                    }
                    poDao.SaveCountry(laDetail);
                    Log.d(TAG, "Saving country info success.");
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean AddMobileNo(){
        try{
            JSONObject param = new JSONObject();
            param.put("sTransNox", "info.getTransNox()");
            param.put("sClientID", "info.getClientID()");
            param.put("cReqstCDe", "info.getReqstCDe()");
            param.put("sMobileNo", "info.getMobileNo()");
            param.put("cPrimaryx", "info.getPrimaryx()");
            param.put("sRemarksx", "info.getRemarksx()");
            param.put("sSourceCD", "DCPa");
            param.put("sSourceNo", "fsTransno");

            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsAddress = loApis.getImportCountriesAPI();
            String lsResponse = WebClient.httpsPostJSon(lsAddress, param.toString(), new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Server no response";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    Log.e(TAG, message);
                    return false;
                } else {
                    Log.d(TAG, "Importing country info success.");
                    JSONArray laJson = loResponse.getJSONArray("detail");
                    List<ECountryInfo> laDetail = new ArrayList<>();
                    for(int x = 0; x < laJson.length(); x++){
                        JSONObject loJson = new JSONObject(laJson.getString(x));
                        ECountryInfo loDetail = new ECountryInfo();
                        loDetail.setCntryCde(loJson.getString("sCntryCde"));
                        loDetail.setCntryCde(loJson.getString("sCntryNme"));
                        loDetail.setCntryCde(loJson.getString("sNational"));
                        loDetail.setCntryCde(loJson.getString("cRecdStat"));
                        loDetail.setCntryCde(loJson.getString("dTimeStmp"));
                        laDetail.add(loDetail);
                    }
                    poDao.SaveCountry(laDetail);
                    Log.d(TAG, "Saving country info success.");
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }
}