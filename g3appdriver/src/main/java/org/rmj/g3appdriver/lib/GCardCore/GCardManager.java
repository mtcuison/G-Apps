package org.rmj.g3appdriver.lib.GCardCore;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EEvents;
import org.rmj.g3appdriver.dev.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.dev.Database.Entities.EMCSerialRegistration;
import org.rmj.g3appdriver.dev.Database.Entities.EPromo;
import org.rmj.g3appdriver.dev.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EServiceInfo;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.Repositories.RGCardTransactionLedger;
import org.rmj.g3appdriver.dev.Repositories.RMCSerialRegistration;
import org.rmj.g3appdriver.dev.Repositories.RServiceInfo;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.etc.Telephony;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.lib.GCardCore.Obj.CartItem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.GcardCredentials;

import java.util.List;

public class GCardManager implements iGCardSystem{
    private static final String TAG = GCardManager.class.getSimpleName();

    private final Context mContext;

    private final HttpHeaders poHeaders;
    private final CodeGenerator poCode;
    private final DGcardApp poGCard;
    private final AccountInfo poSession;
    private final Telephony poDevicex;
    private final RServiceInfo poService;
    private final RMCSerialRegistration poMcReg;
    private final RGCardTransactionLedger poLedger;
    private final GuanzonAppConfig poConfig;
    private final ServerAPIs poAPI;

    public GCardManager(Context context) {
        this.mContext = context;
        this.poHeaders = new HttpHeaders(mContext);
        this.poCode = new CodeGenerator();
        this.poGCard = GGC_GuanzonAppDB.getInstance(mContext).EGcardAppDao();
        this.poSession = new AccountInfo(mContext);
        this.poDevicex = new Telephony(mContext);
        this.poService = new RServiceInfo(mContext);
        this.poMcReg = new RMCSerialRegistration(mContext);
        this.poLedger = new RGCardTransactionLedger(mContext);
        this.poConfig = new GuanzonAppConfig(mContext);
        this.poAPI = new ServerAPIs(poConfig.getTestCase());
    }

    @Override
    public void AddGCard(GcardCredentials gcardInfo, GCardSystem.GCardSystemCallback callback) throws Exception{
        if(!gcardInfo.isDataValid()){
            callback.OnFailed(gcardInfo.getMessage());
        } else {
            String lsResponse = WebClient.httpsPostJSon(poAPI.getAddNewGCardAPI(), gcardInfo.getJSONParameters(), poHeaders.getHeaders());
            if(lsResponse == null){
                callback.OnFailed("No server response.");
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.OnSuccess(lsResponse);
                } else {
                    JSONObject loError = loResponse.getJSONObject("error");
                    String lsCode = loError.getString("code");
                    if(lsCode.equalsIgnoreCase("CNF")){
                        callback.OnFailed(loError.toString());
                    } else {
                        String lsMessage = loError.getString("message");
                        callback.OnFailed(lsMessage);
                    }
                }
            }
        }
    }

    @Override
    public LiveData<List<EGcardApp>> GetGCardList() {
        return poGCard.getAllGCardInfo();
    }

    @Override
    public void updateGCardActiveStatus(String GCardNmbr) {
        poGCard.updateGCardActiveStatus(GCardNmbr);
    }

    @Override
    public List<EGcardApp> hasGcard() {
        return poGCard.hasGcard();
    }

    @Override
    public LiveData<EGcardApp> hasNoGcard() {
        return poGCard.hasNoGcard();
    }

    @Override
    public LiveData<List<EGcardApp>> hasUnCheckGCard() {
        return poGCard.hasUnCheckGCard();
    }

    @Override
    public List<EGcardApp> hasActiveGcard() {
        return poGCard.hasActiveGcard();
    }

    @Override
    public List<EGcardApp> hasMultipleGCard() {
        return poGCard.hasMultipleGCard();
    }

    @Override
    public LiveData<EGcardApp> getGCardInfo() {
        return poGCard.getGCardInfo();
    }

    @Override
    public List<EGcardApp> getAllGCard() {
        return poGCard.getAllGCard();
    }

    @Override
    public void updateAvailablePoints(String fsGcardNo, String fsNewPts) {
        poGCard.updateAvailablePoints(fsGcardNo, fsNewPts);
    }



    @Override
    public LiveData<String> getActiveGcardNo() {
        return null;
    }

    @Override
    public LiveData<String> getActiveGcardAvlPoints() {
        return poGCard.getActiveGcardAvlPoints();
    }

    @Override
    public double getRemainingActiveCardPoints() {
        return 0;
    }

    @Override
    public double getAvailableGcardPoints() {
        return 0;
    }

    @Override
    public double getRedeemItemPoints() {
        return 0;
    }

    @Override
    public void updateGCardDeactiveStatus() {
        poGCard.updateGCardDeactiveStatus();
    }

    @Override
    public void AddGCardQrCode(String GCardNumber, GCardSystem.GCardSystemCallback callback) throws Exception {
        JSONObject params = new JSONObject();
        params.put("secureno", poCode.generateSecureNo(GCardNumber));
        String lsAddress = poAPI.getAddNewGCardAPI();
        String lsResponse = WebClient.httpsPostJSon(lsAddress, params.toString(), poHeaders.getHeaders());
        if(lsResponse == null){
            callback.OnFailed("No server response.");
        } else {
            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("success")){
                callback.OnSuccess("New gcard has been added successfully.");
            } else {
                JSONObject loError = loResponse.getJSONObject("error");
                String lsMessage = loError.getString("message");
                callback.OnFailed(lsMessage);
            }
        }
    }

    @Override
    public void ConfirmAddGCard(GcardCredentials gcardInfo, GCardSystem.GCardSystemCallback callback) throws Exception {
        gcardInfo.setsConfirmx("1");
        String lsResponse = WebClient.httpsPostJSon(poAPI.getAddNewGCardAPI(), gcardInfo.getJSONParameters(), poHeaders.getHeaders());
        if(lsResponse == null){
            callback.OnFailed("No server response.");
        } else {
            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if(lsResult.equalsIgnoreCase("success")){
                callback.OnSuccess(lsResponse);
            } else {
                JSONObject loError = loResponse.getJSONObject("error");
                String lsMessage = loError.getString("message");
                callback.OnFailed(lsMessage);
            }
        }
    }

    @Override
    public void DownloadGcardNumbers(GCardSystem.GCardSystemCallback callback) throws Exception {
        JSONObject param = new JSONObject();
        param.put("user_id", poCode.generateSecureNo(poSession.getUserID()));
        String lsResponse = WebClient.httpsPostJSon(poAPI.getImportGCardAPI(), param.toString(), poHeaders.getHeaders());
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
    public void SaveGCardInfo(JSONObject detail) throws Exception {
        poGCard.updateGCardDeactiveStatus();
        if(!detail.has("detail")){
            EGcardApp loGCard = new EGcardApp();
            loGCard.setGCardNox(detail.getString("sGCardNox"));
            loGCard.setCardNmbr(detail.getString("sCardNmbr"));
            loGCard.setUserIDxx(poSession.getUserID());
            loGCard.setNmOnCard(detail.getString("sNmOnCard"));
            loGCard.setMemberxx(detail.getString("dMemberxx"));
            loGCard.setCardType(detail.getString("cCardType"));
            loGCard.setAvlPoint(detail.getString("nAvlPoint"));
            loGCard.setTotPoint(detail.getString("nTotPoint"));
            loGCard.setTranStat(detail.getString("cCardStat"));
            loGCard.setActvStat("0");
            loGCard.setNotified("1");
            poGCard.insert(loGCard);
        } else {
            JSONArray laJson = detail.getJSONArray("detail");
            for(int x = 0; x < laJson.length(); x++) {
                JSONObject loJson = laJson.getJSONObject(x);
                EGcardApp loGCard = new EGcardApp();
                loGCard.setGCardNox(loJson.getString("sGCardNox"));
                loGCard.setCardNmbr(loJson.getString("sCardNmbr"));
                loGCard.setUserIDxx(poSession.getUserID());
                loGCard.setNmOnCard(loJson.getString("sNmOnCard"));
                loGCard.setMemberxx(loJson.getString("dMemberxx"));
                loGCard.setCardType(loJson.getString("cCardType"));
                loGCard.setAvlPoint(loJson.getString("nAvlPoint"));
                loGCard.setTotPoint(loJson.getString("nTotPoint"));
                loGCard.setTranStat(loJson.getString("cCardStat"));
                loGCard.setActvStat("0");
                loGCard.setNotified("1");
                poGCard.insert(loGCard);
            }
        }
        poGCard.updateGCardAppWithHighestPoints();
    }

    @Override
    public Bitmap GenerateGCardQrCode() {
        String lsSource = "CARD";
        String lsDevcID = poDevicex.getDeviceID();
        String lsCardNo = poGCard.getCardNo();
        String lsUserID = poSession.getUserID();
        String lsMobNox = poDevicex.getMobilNumbers();
        String lsDateTm = new AppConstants().GCARD_DATE_TIME;
        double lsCardPt;
        if(poGCard.getRedeemItemPoints() > 0){
            lsCardPt = Math.abs(poGCard.getAvailableGcardPoints() - poGCard.getRedeemItemPoints());
        } else {
            lsCardPt = poGCard.getAvailableGcardPoints();
        }
        String lsModelx = Build.MODEL;
        String lsTransN = "";
        return poCode.generateGCardCodex(lsSource,
                lsDevcID,
                lsCardNo,
                lsUserID,
                lsMobNox,
                lsDateTm,
                lsCardPt,
                lsModelx,
                lsTransN);
    }

    @Override
    public void ParseQrCode(String val, GCardSystem.ParseQrCodeCallback callback) throws Exception {
        poCode.setEncryptedQrCode(val);
        String lsMobileNo = new AccountInfo(mContext).getMobileNo();
        String lsUserIDxx = new AccountInfo(mContext).getUserID();
        String lsGcardNox = poGCard.getCardNo();
        if(poConfig.getTestCase() && lsMobileNo.isEmpty()){
            lsMobileNo = "09171870011";
        }
        if(poGCard.getCardNox() == null){
            callback.OnFailed("No Gcard number detected");
        } else if(!poCode.isCodeValid()){
            callback.OnFailed("Invalid Qr Code");
        } else if (poCode.isQrCodeTransaction()){
            if(poCode.isTransactionVoid()){
                callback.TransactionResult(poCode.getTransactionPIN());
            } else if(lsUserIDxx.isEmpty()){
                callback.OnFailed("No user account detected. Please make sure you login account before proceeding.");
            } else if(lsMobileNo.isEmpty()){
                callback.OnFailed("Unable to retrieve device mobile no. Please make sure your device has mobile no.");
            } else if(lsGcardNox.isEmpty()){
                callback.OnFailed("No GCard number is registered or active in this account. Please make sure a GCard is active.");
            } else if(poCode.isDeviceValid(lsMobileNo, lsUserIDxx, lsGcardNox)) {
                callback.TransactionResult(poCode.getTransactionPIN());
            } else {
                callback.OnFailed("Mobile Number or Account is not valid to confirm this transaction");
            }
        } else {
            if(lsUserIDxx.isEmpty()){
                callback.OnFailed("No user account detected. Please make sure you login account before proceeding.");
            } else if(lsMobileNo.isEmpty()){
                callback.OnFailed("Unable to retrieve device mobile no. Please make sure your device has mobile no.");
            } else {
                callback.ApplicationResult(poCode.getGCardNumber());
            }
        }
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
    public LiveData<List<Double>> GetRedeemablePointsFilter() {
        return null;
    }

    @Override
    public LiveData<List<ERedeemablesInfo>> GetRedeemablesList() {
        return null;
    }

    @Override
    public LiveData<List<ERedeemablesInfo>> GetRedeemablesList(String fsVal) {
        return null;
    }

    @Override
    public void AddToCart(CartItem item, GCardSystem.GCardSystemCallback callback) {
        throw new NullPointerException();
    }

    @Override
    public void UpdateCartItem(CartItem item, GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public LiveData<List<DRedeemItemInfo.GCardCartItem>> GetCartItems() {
        return null;
    }

    @Override
    public List<EBranchInfo> GetMCBranchesForRedemption() {
        return null;
    }

    @Override
    public LiveData<Integer> GetGcardCartItemCount() {
        return null;
    }

    @Override
    public LiveData<Double> GetGCardCartItemTotalPoints() {
        return null;
    }

    @Override
    public void DeleteItemCart(String fsVal) {
        throw new NullPointerException();
    }

    @Override
    public void PlaceOrder(List<DRedeemItemInfo.GCardCartItem> redeemables, String BranchCD, GCardSystem.GCardSystemCallback callback) throws Exception {
        throw new NullPointerException();
    }

    @Override
    public Bitmap GenerateGCardOrderQrCode(String BatchNox) throws Exception {
        return null;
    }

    @Override
    public void DownloadTransactions(GCardSystem.GCardSystemCallback callback) {
        try {
            JSONObject params = new JSONObject();
            params.put("secureno", poCode.generateSecureNo(poGCard.getCardNo()));
            String[] Ledger_Address = {poAPI.getImportOfflineTransAPI(),
                    poAPI.getImportOnlineTransAPI(),
                    poAPI.getImportPreOrderAPI(),
                    poAPI.getImportReedemptionsAPI()};
            for (String ledger_address : Ledger_Address) {
                String lsResponse = WebClient.httpsPostJSon(ledger_address, params.toString(), poHeaders.getHeaders());
                if (lsResponse == null) {
                    callback.OnFailed("Server no response");
                } else {
                    JSONObject loResponse = new JSONObject(lsResponse);
                    String lsResult = loResponse.getString("result");
                    if (lsResult.equalsIgnoreCase("success")) {
                        SaveTransactions(loResponse);
                    } else {
                        JSONObject loError = loResponse.getJSONObject("error");
                        String lsMessage = loError.getString("message");
                        callback.OnFailed(lsMessage);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            callback.OnFailed("Failed downloading transactions. " + e.getMessage());
        }
    }

    @Override
    public void SaveTransactions(JSONObject detail) throws Exception {
        RGCardTransactionLedger loLedger = new RGCardTransactionLedger(mContext);
        String[] Import_Type = {
                "ONLINE",
                "OFFLINE",
                "PREORDER",
                "REDEMPTION"};
        JSONArray laDetail = detail.getJSONArray("detail");
        for(int x = 0; x < laDetail.length(); x++){
            JSONObject loJson = laDetail.getJSONObject(x);
            EGCardTransactionLedger info = new EGCardTransactionLedger();
            info.setGCardNox(loJson.getString("sGCardNox"));
            info.setTransact(loJson.getString("dTransact"));
            info.setSourceDs(Import_Type[x]);
            info.setReferNox(loJson.getString("sReferNox"));
            info.setTranType(loJson.getString("sTranType"));
            info.setSourceNo(loJson.getString("sSourceNo"));
            info.setPointsxx(Double.parseDouble(loJson.getString("nPointsxx")));
            loLedger.Save(info);
        }
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> GetGcardTransactions() {
        return poLedger.getAllTransactionsList();
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> GetPointsEntryTransactions() {
        return poLedger.getPointsEntryTransactionsList();
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> GetRedemptionTransactions() {
        return poLedger.getRedemptionTransactionsList();
    }

    @Override
    public void DownloadMCServiceInfo(GCardSystem.GCardSystemCallback callback) throws Exception {
        JSONObject params = new JSONObject();
        String lsGcardNo = poGCard.getCardNo();
        String lsSecureNo = new CodeGenerator().generateSecureNo(lsGcardNo);
        params.put("secureno", lsSecureNo);
        String lsResponse = WebClient.httpsPostJSon(poAPI.getServiceInfoAPI(), params.toString(), poHeaders.getHeaders());
        if (lsResponse == null) {
            callback.OnFailed("Server no response");
        } else {
            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if (lsResult.equalsIgnoreCase("success")) {
                callback.OnSuccess(loResponse.toString());
            } else {
            }
                JSONObject loError = loResponse.getJSONObject("error");
                String lsMessage = loError.getString("message");
                callback.OnFailed(lsMessage);
            }
    }


    @Override
    public void DownloadRegistrationInfo(GCardSystem.GCardSystemCallback callback) throws Exception {
        JSONObject params = new JSONObject();
        String lsSecureNo = new CodeGenerator().generateSecureNo(poGCard.getCardNo());
        params.put("secureno", lsSecureNo);
        String lsResponse = WebClient.httpsPostJSon(poAPI.getMCRegistrationAPI(), params.toString(), poHeaders.getHeaders());
        if (lsResponse == null) {
            callback.OnFailed("Server no response");
        } else {
            JSONObject loResponse = new JSONObject(lsResponse);
            String lsResult = loResponse.getString("result");
            if (lsResult.equalsIgnoreCase("success")) {
                callback.OnSuccess(loResponse.toString());
            } else {
                JSONObject loError = loResponse.getJSONObject("error");
                String lsMessage = loError.getString("message");
                callback.OnFailed(lsMessage);
            }
        }
    }

    @Override
    public void SaveMcServiceInfo(JSONObject detail) throws Exception {
        JSONArray laJson = detail.getJSONArray("detail");
        if(laJson.length() > 0) {
            for (int x = 0; x < laJson.length(); x++) {
                JSONObject loJson = laJson.getJSONObject(x);
                EServiceInfo loService = new EServiceInfo();
                loService.setGCardNox(poGCard.getCardNox());
                loService.setSerialID(loJson.getString("sSerialID"));
                loService.setEngineNo(loJson.getString("sEngineNo"));
                loService.setFrameNox(loJson.getString("sFrameNox"));
                loService.setModelNme(loJson.getString("sModelNme"));
                loService.setFSEPStat(loJson.getString("cFSEPStat"));
                loService.setLastSrvc(loJson.getString("dLastSrvc"));
                loService.setPurchase(loJson.getString("dPurchase"));
                loService.setYellowxx(loJson.getInt("nYellowxx"));
                loService.setWhitexxx(loJson.getInt("nWhitexxx"));
                loService.setMIlAgexx(loJson.getInt("nMilagexx"));
                loService.setNxtRmnds(loJson.getString("dNxtRmndS"));
                poService.insert(loService);
            }
        }
    }

    @Override
    public void SaveRegistrationInfo(JSONObject detail) throws Exception {
        JSONArray laJson = detail.getJSONArray("detail");
        if(laJson.length() > 0) {
            for (int x = 0; x < laJson.length(); x++) {
                JSONObject loJson = laJson.getJSONObject(x);
                EMCSerialRegistration loMcSerial = new EMCSerialRegistration();
                loMcSerial.setGCardNox(poGCard.getCardNox());
                loMcSerial.setSerialID(loJson.getString("sSerialID"));
                loMcSerial.setEngineNo(loJson.getString("sEngineNo"));
                loMcSerial.setFrameNox(loJson.getString("sFrameNox"));
                loMcSerial.setModelNme(loJson.getString("sModelNme"));
                loMcSerial.setFSEPStat(loJson.getString("cFSEPStat"));
                loMcSerial.setRegStatx(loJson.getString("cRegStatx"));
                poMcReg.insert(loMcSerial);
            }
        }
    }

    @Override
    public void ScheduleNextServiceDate(String date, GCardSystem.GCardSystemCallback callback) {

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
    public EPromo CheckPromo() {
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

    @Override
    public EEvents CheckEvents() {
        return null;
    }

    @Override
    public void ActivateGcard(String GcardNo) throws Exception {

    }
}
