package org.rmj.guanzongroup.appcore.GCardCore;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.apprdiver.util.SQLUtil;
import org.rmj.guanzongroup.appcore.Database.Entities.EBranchInfo;
import org.rmj.guanzongroup.appcore.Database.Entities.EEvents;
import org.rmj.guanzongroup.appcore.Database.Entities.EGCardTransactionLedger;
import org.rmj.guanzongroup.appcore.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.appcore.Database.Entities.EPromo;
import org.rmj.guanzongroup.appcore.Database.Entities.ERedeemItemInfo;
import org.rmj.guanzongroup.appcore.Database.Entities.ERedeemablesInfo;
import org.rmj.guanzongroup.appcore.Database.Repositories.RBranchInfo;
import org.rmj.guanzongroup.appcore.Database.Repositories.REvents;
import org.rmj.guanzongroup.appcore.Database.Repositories.RPromo;
import org.rmj.guanzongroup.appcore.Etc.AppConstants;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.CartItem;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.GcardCredentials;
import org.rmj.guanzongroup.appcore.ServerRequest.GCardAPI;
import org.rmj.guanzongroup.appcore.ServerRequest.HttpHeaders;
import org.rmj.guanzongroup.appcore.ServerRequest.WebClient;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SystemExtras implements iGCardSystem{
    private static final String TAG = SystemExtras.class.getSimpleName();

    private final Context mContext;

    private final RBranchInfo poBranch;
    private final RPromo poPromo;
    private final REvents poEvents;
    private final HttpHeaders poHeaders;

    public SystemExtras(Context context) {
        this.mContext = context;
        this.poBranch = new RBranchInfo(mContext);
        this.poPromo = new RPromo(mContext);
        this.poEvents = new REvents(mContext);
        this.poHeaders = new HttpHeaders(mContext);
    }

    @Override
    public void AddGCard(GcardCredentials gcardInfo, GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public LiveData<List<EGcardApp>> GetGCardList() {
        return null;
    }

    @Override
    public void AddGCardQrCode(String GcardNo, GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void DownloadGcardNumbers(GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void SaveGCardInfo(JSONObject detail) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void ActivateGcard(String GcardNo) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public Bitmap GenerateGCardQrCode() throws Exception {
        return null;
    }

    @Override
    public void DownloadRedeemables(GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void SaveRedeemables(JSONObject detail) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public LiveData<List<ERedeemablesInfo>> GetRedeemablesList() {
        return null;
    }

    @Override
    public void AddToCart(CartItem item, GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void UpdateCartItem(CartItem item, GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void PlaceOrder(List<ERedeemItemInfo> redeemables, String BranchCD, GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public Bitmap GenerateGCardOrderQrCode() throws Exception {
        return null;
    }

    @Override
    public void DownloadTransactions(GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void SaveTransactions(JSONObject detail) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> GetGcardTransactions() {
        return null;
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> GetPointsEntryTransactions() {
        return null;
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> GetRedemptionTransactions() {
        return null;
    }

    @Override
    public void DownloadMCServiceInfo(GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void DownloadRegistrationInfo(GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void SaveMcServiceInfo(JSONObject detail) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void SaveRegistrationInfo(JSONObject detail) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void ScheduleNextServiceDate(String date, GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void DownloadBranchesList(GCardSystem.GCardSystemCallback callback) throws Exception {
        JSONObject params = new JSONObject();
        String lsResponse = WebClient.httpsPostJSon(GCardAPI.URL_IMPORT_BRANCH, params.toString(), poHeaders.getHeaders());
        if(lsResponse == null){
            callback.OnFailed("Server no response.");
            Log.d(TAG, "Unable to retrieve data from server. Server no response.");
        } else {
            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("success")){
                callback.OnSuccess(loResponse.toString());
                Log.d(TAG, "Branch records retrieve successfully.");
            } else {
                JSONObject loError = loResponse.getJSONObject("error");
                String lsMessage = loError.getString("message");
                callback.OnFailed(lsMessage);
                Log.d(TAG, "Unable to retrieve records from server. Message : " + lsMessage);
            }
        }
    }

    @Override
    public void SaveBranchesList(JSONObject detail) throws Exception {
        JSONArray laDetail = detail.getJSONArray("detail");
        for(int x = 0; x < laDetail.length(); x++){
            JSONObject loJson = laDetail.getJSONObject(x);
            EBranchInfo loBranch = poBranch.getBranchIfExist(loJson.getString("sBranchCD"));
            //Insert new record if not exist
            if(loBranch == null){
                //check the records from API, if record status is not equal to 1, record is inactive, do not insert
                if(!"1".equalsIgnoreCase(loJson.getString("cRecdStat"))){
                    // insert saving method inside...
                    EBranchInfo info = new EBranchInfo();
                    info.setBranchCd(loJson.getString("sBranchCD"));
                    info.setBranchNm(loJson.getString("sBranchNm"));
                    info.setDescript(loJson.getString("sDescript"));
                    info.setAddressx(loJson.getString("sAddressx"));
                    info.setContactx(loJson.getString("sContactx"));
                    info.setTelNumbr(loJson.getString("sTelNumbr"));
                    info.setEmailAdd(loJson.getString("sEMailAdd"));
                    info.setRecdStat(loJson.getString("cRecdStat"));
                    info.setTimeStmp(loJson.getString("dTimeStmp"));
                    poBranch.insert(info);
                    Log.d(TAG, "New record save!");
                }
            } else {
                // if exist check timestamp for latest record and replace current record on local
                Date ldDate1 = SQLUtil.toDate(loBranch.getTimeStmp(), SQLUtil.FORMAT_TIMESTAMP);
                Date ldDate2 = SQLUtil.toDate((String) loJson.get("dTimeStmp"), SQLUtil.FORMAT_TIMESTAMP);
                if(!ldDate1.equals(ldDate2)){
                    poBranch.UpdateBranchInfo(
                            loJson.getString("sBranchCD"),
                            loJson.getString("sBranchNm"),
                            loJson.getString("sDescript"),
                            loJson.getString("sAddressx"),
                            loJson.getString("sContactx"),
                            loJson.getString("sTelNumbr"),
                            loJson.getString("sEMailAdd"));
                    Log.d(TAG, "A record has been updated!");
                }
            }
        }
    }

    @Override
    public LiveData<List<EBranchInfo>> GetMobileBranchList() {
        return poBranch.getMobileBranches();
    }

    @Override
    public LiveData<List<EBranchInfo>> GetMotorcycleBranchList() {
        return poBranch.getMotorBranches();
    }

    @Override
    public void DownloadPromotions(GCardSystem.GCardSystemCallback callback) throws Exception {
        JSONObject params = new JSONObject();
        String lsResponse = WebClient.httpsPostJSon(GCardAPI.URL_IMPORT_PROMOLINK, params.toString(), poHeaders.getHeaders());
        if(lsResponse == null){
            callback.OnFailed("Server no response.");
            Log.d(TAG, "Unable to retrieve data from server. Server no response.");
        } else {
            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("success")){
                callback.OnSuccess(loResponse.toString());
                Log.d(TAG, "Promo records retrieve successfully.");
            } else {
                JSONObject loError = loResponse.getJSONObject("error");
                String lsMessage = loError.getString("message");
                callback.OnFailed(lsMessage);
                Log.d(TAG, "Unable to retrieve records from server. Message : " + lsMessage);
            }
        }
    }

    @Override
    public void SavePromotions(JSONObject detail) throws Exception {
        JSONArray laDetail = detail.getJSONArray("detail");
        for(int x = 0; x < laDetail.length(); x++){
            JSONObject loJson = laDetail.getJSONObject(x);
            EPromo loPromo = poPromo.getPromoInfoIfExist(loJson.getString("sTransNox"));
            if(loPromo == null) {
                //check the records from API, if record status is not equal to 1, record is inactive, do not insert
//                if(!"1".equalsIgnoreCase(loJson.getString("cRecdStat"))){
//                    // insert saving method inside...
//                }
                EPromo info = new EPromo();
                info.setTransNox(loJson.getString("sTransNox"));
                info.setTransact(loJson.getString("dTransact"));
                info.setImageUrl(loJson.getString("sImageURL"));
                info.setPromoUrl(loJson.getString("sPromoURL"));
                info.setCaptionx(loJson.getString("sCaptionx"));
                info.setDateFrom(loJson.getString("dDateFrom"));
                info.setDateThru(loJson.getString("dDateThru"));
                poPromo.insert(info);
            } else {

            }
        }
    }

    @Override
    public LiveData<List<EPromo>> GetPromotions() {
        return poPromo.getAllPromo();
    }

    @Override
    public void DownloadNewsEvents(GCardSystem.GCardSystemCallback callback) throws Exception {
        JSONObject params = new JSONObject();
        String lsResponse = WebClient.httpsPostJSon(GCardAPI.URL_IMPORT_EVENTS, params.toString(), poHeaders.getHeaders());
        if(lsResponse == null){
            callback.OnFailed("Server no response.");
        } else {
            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("success")){
                callback.OnSuccess(loResponse.toString());
            } else {
                JSONObject loError = loResponse.getJSONObject("error");
                String lsMessage = loError.getString("message");
                callback.OnFailed(lsMessage);
            }
        }
    }

    @Override
    public void SaveNewsEvents(JSONObject detail) throws Exception {
        JSONArray laDetail = detail.getJSONArray("detail");
        for(int x = 0; x < laDetail.length(); x++){
            JSONObject loJson = laDetail.getJSONObject(x);

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
            poEvents.insert(info);
        }
    }

    @Override
    public LiveData<List<EEvents>> GetNewsEvents() {
        return null;
    }
}
