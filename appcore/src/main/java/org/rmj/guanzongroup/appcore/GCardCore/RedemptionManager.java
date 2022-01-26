package org.rmj.guanzongroup.appcore.GCardCore;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.guanzongroup.appcore.Database.Entities.EBranchInfo;
import org.rmj.guanzongroup.appcore.Database.Entities.EEvents;
import org.rmj.guanzongroup.appcore.Database.Entities.EGCardTransactionLedger;
import org.rmj.guanzongroup.appcore.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.appcore.Database.Entities.EPromo;
import org.rmj.guanzongroup.appcore.Database.Entities.ERedeemItemInfo;
import org.rmj.guanzongroup.appcore.Database.Entities.ERedeemablesInfo;
import org.rmj.guanzongroup.appcore.Database.Repositories.RGcardApp;
import org.rmj.guanzongroup.appcore.Database.Repositories.RRedeemItemInfo;
import org.rmj.guanzongroup.appcore.Database.Repositories.RRedeemablesInfo;
import org.rmj.guanzongroup.appcore.Etc.AppConstants;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.CartItem;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.GcardCartItems;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.GcardCredentials;
import org.rmj.guanzongroup.appcore.ServerRequest.GCardAPI;
import org.rmj.guanzongroup.appcore.ServerRequest.HttpHeaders;
import org.rmj.guanzongroup.appcore.ServerRequest.WebClient;

import java.util.List;

public class RedemptionManager implements iGCardSystem{
    private static final String TAG = RedemptionManager.class.getSimpleName();

    private final Context mContext;
    private final RGcardApp poGcard;
    private final RRedeemItemInfo poRedeem;
    private final HttpHeaders poHeaders;
    private final RRedeemablesInfo poRedeemables;

    public RedemptionManager(Context context) {
        this.mContext = context;
        this.poGcard = new RGcardApp(mContext);
        this.poRedeem = new RRedeemItemInfo(mContext);
        this.poHeaders = new HttpHeaders(mContext);
        this.poRedeemables = new RRedeemablesInfo(mContext);
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
        JSONObject params = new JSONObject();
        String lsResponse = WebClient.httpsPostJSon(GCardAPI.URL_IMPORT_REDEEM_ITEMS, params.toString(), poHeaders.getHeaders());
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
    public void SaveRedeemables(JSONObject detail) throws Exception {
        JSONArray laDetail = detail.getJSONArray("detail");
        for(int x = 0; x < laDetail.length(); x++){
            JSONObject loJson = laDetail.getJSONObject(x);
            ERedeemablesInfo info = new ERedeemablesInfo();
            info.setTransNox(loJson.getString("sTransNox"));
            info.setPromoCde(loJson.getString("sPromCode"));
            info.setPromoDsc(loJson.getString("sPromDesc"));
            info.setPointsxx(Double.parseDouble(loJson.getString("nPointsxx")));
            info.setImageUrl(loJson.getString("sImageURL"));
            info.setDateFrom(loJson.getString("dDateFrom"));
            info.setDateThru(loJson.getString("dDateThru"));
            info.setPreOrder(loJson.getString("cPreOrder"));
            poRedeemables.insert(info);
        }
    }

    @Override
    public LiveData<List<ERedeemablesInfo>> GetRedeemablesList() {
        return poRedeemables.getRedeemablesList();
    }

    @Override
    public void AddToCart(CartItem item, GCardSystem.GCardSystemCallback callback) throws Exception {
        if (!isPointsValid(item.getTotalItemPoints())) {
            ERedeemItemInfo loItem = new ERedeemItemInfo();
            loItem.setTransNox(new CodeGenerator().generateTransNox());
            loItem.setGCardNox(poGcard.getCardNox());
            loItem.setPromoIDx(item.getPromoIDx());
            loItem.setItemQtyx(item.getItemQtyx());
            loItem.setPointsxx(item.getTotalItemPoints());
            loItem.setOrderedx(new AppConstants().GCARD_DATE_TIME);
            loItem.setTranStat("0");
            loItem.setPlacOrdr("0");

            String lsTransNox = item.getTransNox();
            String lsPromoIDx = item.getPromoIDx();
            if(poRedeem.getRedeemableIfExist(lsTransNox, lsPromoIDx).size() > 0) {
                poRedeem.UpdateExistingItemOnCart(lsTransNox, lsPromoIDx, item.getItemQtyx(), item.getTotalItemPoints());
            } else {
                poRedeem.insert(loItem);
            }
            callback.OnSuccess("Item added on cart");
        } else {
            callback.OnFailed("Not enough available points.");
        }
    }

    @Override
    public void UpdateCartItem(CartItem item, GCardSystem.GCardSystemCallback callback) throws Exception {
        String lsTransNox = item.getTransNox();
        String lsPromoIDx = item.getPromoIDx();
        poRedeem.UpdateExistingItemOnCart(lsTransNox, lsPromoIDx, item.getItemQtyx(), item.getTotalItemPoints());
    }

    @Override
    public void PlaceOrder(List<ERedeemItemInfo> redeemables, String BranchCD, GCardSystem.GCardSystemCallback callback) throws Exception {
        JSONArray items = new JSONArray();
        JSONObject params = new JSONObject();
        JSONObject details;
        if(redeemables.size() <= 0) {
        } else {
            for(int x = 0; x < redeemables.size(); x++){
                details = new JSONObject();
                details.put("promoidx", redeemables.get(x).getPromoIDx());
                details.put("itemqtyx", redeemables.get(x).getItemQtyx());
                items.put(details);
            }

            String lsGcardNo = poGcard.getCardNo();
            params.put("secureno", new CodeGenerator().generateSecureNo(lsGcardNo));
            params.put("branchcd", BranchCD);
            params.put("detail", items);

            String lsResponse = WebClient.httpsPostJSon(GCardAPI.URL_PLACE_ODER, params.toString(), poHeaders.getHeaders());
            if(lsResponse == null){
                callback.OnFailed("Server no response.");
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(lsResult.equalsIgnoreCase("success")){

                } else {

                }
            }
        }
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
        throw new NullPointerException();
    }

    @Override
    public void SaveBranchesList(JSONObject detail) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public LiveData<List<EBranchInfo>> GetMobileBranchList() {
        return null;
    }

    @Override
    public LiveData<List<EBranchInfo>> GetMotorcycleBranchList() {
        return null;
    }

    @Override
    public void DownloadPromotions(GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void SavePromotions(JSONObject detail) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public LiveData<List<EPromo>> GetPromotions() {
        return null;
    }

    @Override
    public void DownloadNewsEvents(GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public void SaveNewsEvents(JSONObject detail) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public LiveData<List<EEvents>> GetNewsEvents() {
        return null;
    }

    public boolean isPointsValid(double fnItemPts){
        String lsCrdNmbr = poGcard.getCardNo();
        double lnTotalPt = poGcard.getGCardTotPoints(lsCrdNmbr);
        double lnOrderPt = poGcard.getOrderPoints(lsCrdNmbr);
        double lnRmnPnts = Math.abs(lnTotalPt - lnOrderPt);

        if(fnItemPts > lnRmnPnts){
            return true;
        } else {
            return false;
        }
    }
}
