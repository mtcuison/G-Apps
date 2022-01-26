package org.rmj.guanzongroup.appcore.GCardCore;

import android.graphics.Bitmap;

import androidx.lifecycle.LiveData;

import org.json.JSONObject;
import org.rmj.guanzongroup.appcore.Database.Entities.EBranchInfo;
import org.rmj.guanzongroup.appcore.Database.Entities.EEvents;
import org.rmj.guanzongroup.appcore.Database.Entities.EGCardTransactionLedger;
import org.rmj.guanzongroup.appcore.Database.Entities.EGcardApp;
import org.rmj.guanzongroup.appcore.Database.Entities.EPromo;
import org.rmj.guanzongroup.appcore.Database.Entities.ERedeemItemInfo;
import org.rmj.guanzongroup.appcore.Database.Entities.ERedeemablesInfo;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.CartItem;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.GcardCartItems;
import org.rmj.guanzongroup.appcore.GCardCore.Obj.GcardCredentials;

import java.util.List;

public interface iGCardSystem {

    void AddGCard(GcardCredentials gcardInfo, GCardSystem.GCardSystemCallback callback) throws Exception;
    LiveData<List<EGcardApp>> GetGCardList();
    void AddGCardQrCode(String GcardNo, GCardSystem.GCardSystemCallback callback) throws Exception;
    void DownloadGcardNumbers(GCardSystem.GCardSystemCallback callback) throws Exception;
    void SaveGCardInfo(JSONObject detail) throws Exception;
    void ActivateGcard(String GcardNo) throws Exception;
    Bitmap GenerateGCardQrCode() throws Exception;

    void DownloadRedeemables(GCardSystem.GCardSystemCallback callback) throws Exception;
    void SaveRedeemables(JSONObject detail) throws Exception;
    LiveData<List<ERedeemablesInfo>> GetRedeemablesList();
    void AddToCart(CartItem item, GCardSystem.GCardSystemCallback callback) throws Exception;
    void UpdateCartItem(CartItem item, GCardSystem.GCardSystemCallback callback) throws Exception;
    void PlaceOrder(List<ERedeemItemInfo> redeemables, String BranchCD, GCardSystem.GCardSystemCallback callback) throws Exception;
    Bitmap GenerateGCardOrderQrCode() throws Exception;

    void DownloadTransactions(GCardSystem.GCardSystemCallback callback) throws Exception;
    void SaveTransactions(JSONObject detail) throws Exception;
    LiveData<List<EGCardTransactionLedger>> GetGcardTransactions();
    LiveData<List<EGCardTransactionLedger>> GetPointsEntryTransactions();
    LiveData<List<EGCardTransactionLedger>> GetRedemptionTransactions();

    void DownloadMCServiceInfo(GCardSystem.GCardSystemCallback callback) throws Exception;
    void DownloadRegistrationInfo(GCardSystem.GCardSystemCallback callback) throws Exception;
    void SaveMcServiceInfo(JSONObject detail) throws Exception;
    void SaveRegistrationInfo(JSONObject detail) throws Exception;
    void ScheduleNextServiceDate(String date, GCardSystem.GCardSystemCallback callback) throws Exception;

    void DownloadBranchesList(GCardSystem.GCardSystemCallback callback) throws Exception;
    void SaveBranchesList(JSONObject detail) throws Exception;
    LiveData<List<EBranchInfo>> GetMobileBranchList();
    LiveData<List<EBranchInfo>> GetMotorcycleBranchList();

    void DownloadPromotions(GCardSystem.GCardSystemCallback callback) throws Exception;
    void SavePromotions(JSONObject detail) throws Exception;
    LiveData<List<EPromo>> GetPromotions();

    void DownloadNewsEvents(GCardSystem.GCardSystemCallback callback) throws Exception;
    void SaveNewsEvents(JSONObject detail) throws Exception;
    LiveData<List<EEvents>> GetNewsEvents();
}


