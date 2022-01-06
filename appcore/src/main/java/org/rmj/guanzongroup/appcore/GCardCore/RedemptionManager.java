package org.rmj.guanzongroup.appcore.GCardCore;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.lifecycle.LiveData;

import org.json.JSONObject;
import org.rmj.guanzongroup.appcore.Database.Entities.EGCardTransactionLedger;
import org.rmj.guanzongroup.appcore.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.appcore.Database.Entities.ERedeemItemInfo;
import org.rmj.guanzongroup.appcore.Database.Entities.ERedeemablesInfo;
import org.rmj.guanzongroup.appcore.Database.Repositories.RGcardApp;
import org.rmj.guanzongroup.appcore.Database.Repositories.RRedeemItemInfo;
import org.rmj.guanzongroup.appcore.Etc.AppConstants;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.CartItem;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.GcardCartItems;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.GcardCredentials;

import java.util.List;

public class RedemptionManager implements iGCardSystem{
    private static final String TAG = RedemptionManager.class.getSimpleName();

    private final Context mContext;
    private final RGcardApp poGcard;
    private final RRedeemItemInfo poRedeem;

    public RedemptionManager(Context context) {
        this.mContext = context;
        this.poGcard = new RGcardApp(mContext);
        this.poRedeem = new RRedeemItemInfo(mContext);
    }

    @Override
    public void AddGCard(GcardCredentials gcardInfo, GCardSystem.GCardSystemCallback callback) throws Exception {

    }

    @Override
    public LiveData<List<EGcardApp>> GetGCardList() {
        return null;
    }

    @Override
    public void AddGCardQrCode(String GcardNo, GCardSystem.GCardSystemCallback callback) throws Exception {

    }

    @Override
    public void DownloadGcardNumbers(GCardSystem.GCardSystemCallback callback) throws Exception {

    }

    @Override
    public void SaveGCardInfo(JSONObject detail) throws Exception {

    }

    @Override
    public void ActivateGcard(String GcardNo) throws Exception {

    }

    @Override
    public Bitmap GenerateGCardQrCode() throws Exception {
        return null;
    }

    @Override
    public void DownloadRedeemables(GCardSystem.GCardSystemCallback callback) throws Exception {

    }

    @Override
    public LiveData<List<ERedeemablesInfo>> GetRedeemablesList() {
        return null;
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

    }

    @Override
    public void PlaceOrder(GcardCartItems items, GCardSystem.GCardSystemCallback callback) throws Exception {

    }

    @Override
    public Bitmap GenerateGCardOrderQrCode() throws Exception {
        return null;
    }

    @Override
    public void DownloadTransactions(GCardSystem.GCardSystemCallback callback) throws Exception {

    }

    @Override
    public void SaveTransactions(JSONObject detail) throws Exception {

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

    }

    @Override
    public void DownloadRegistrationInfo(GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }


    @Override
    public void SaveMcServiceInfo(JSONObject detail) throws Exception {

    }

    @Override
    public void SaveRegistrationInfo(JSONObject detail) throws Exception {

    }

    @Override
    public void ScheduleNextServiceDate(String date, GCardSystem.GCardSystemCallback callback) throws Exception {

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
