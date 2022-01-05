package org.rmj.guanzongroup.appcore.GCardCore;

import android.graphics.Bitmap;

import androidx.lifecycle.LiveData;

import org.json.JSONObject;
import org.rmj.guanzongroup.appcore.Database.Entities.EGCardTransactionLedger;
import org.rmj.guanzongroup.appcore.Database.Entities.EGcardApp;
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
    LiveData<List<ERedeemablesInfo>> GetRedeemablesList();
    void AddToCart(CartItem item, GCardSystem.GCardSystemCallback callback) throws Exception;
    void UpdateCartItem(CartItem item, GCardSystem.GCardSystemCallback callback) throws Exception;
    void PlaceOrder(GcardCartItems items, GCardSystem.GCardSystemCallback callback) throws Exception;
    Bitmap GenerateGCardOrderQrCode() throws Exception;

    void DownloadTransactions(GCardSystem.GCardSystemCallback callback) throws Exception;
    LiveData<List<EGCardTransactionLedger>> GetGcardTransactions();

    void DownloadMCServiceInfo(String GCard, GCardSystem.GCardSystemCallback callback) throws Exception;
    void DownloadRegistrationInfo(String GCard, GCardSystem.GCardSystemCallback callback) throws Exception;
    void SaveMcServiceInfo(JSONObject detail) throws Exception;
    void SaveRegistrationInfo(JSONObject detail) throws Exception;
    void ScheduleNextServiceDate(String date, GCardSystem.GCardSystemCallback callback) throws Exception;
}


