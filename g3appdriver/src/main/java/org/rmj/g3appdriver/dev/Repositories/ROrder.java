package org.rmj.g3appdriver.dev.Repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DItemCart;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderDetail;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderMaster;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EItemCart;
import org.rmj.g3appdriver.dev.Database.Entities.EOrderDetail;
import org.rmj.g3appdriver.dev.Database.Entities.EOrderMaster;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.ServerRequest.HttpHeaders;
import org.rmj.g3appdriver.dev.ServerRequest.ServerAPIs;
import org.rmj.g3appdriver.dev.ServerRequest.WebClient;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.g3appdriver.lib.Account.AccountInfo;

import java.util.List;

public class ROrder {
    private static final String TAG = ROrder.class.getSimpleName();

    private final Context mContext;
    private final DItemCart poCartDao;
    private final DProduct poProdDao;

    private final DOrderDetail poDetail;
    private final DOrderMaster poMaster;

    private JSONObject data;
    private String message;
    private String TransNox;

    public ROrder(Context context){
        this.mContext = context;
        this.poProdDao = GGC_GuanzonAppDB.getInstance(mContext).prodctDao();
        this.poCartDao = GGC_GuanzonAppDB.getInstance(mContext).itemCartDao();
        this.poDetail = GGC_GuanzonAppDB.getInstance(mContext).orderDetailDao();
        this.poMaster = GGC_GuanzonAppDB.getInstance(mContext).orderMasterDao();
    }

    public JSONObject getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getTransNox() {
        return TransNox;
    }

    public boolean AddUpdateCart(String fsLstngID, int fnQuantity){
        try {
            AccountInfo loAccount = new AccountInfo(mContext);
            if(fnQuantity <= 0){
                message = "Unable to proceed with '0' quantity.";
                Log.e(TAG, message);
                return false;
            } else if(loAccount.getUserID().isEmpty()){
                message = "Please login your account to continue.";
                Log.e(TAG, message);
                return false;
            } else if(loAccount.getVerificationStatus() == 0){
                message = "Please complete your account setup to continue.";
                Log.e(TAG, message);
                return true;
            } else if(ValidateItemQuantity(fsLstngID, fnQuantity)) {
                Thread.sleep(1000);

                ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
                JSONObject params = new JSONObject();
                params.put("sListngID", fsLstngID);
                params.put("nQuantity", fnQuantity);

                String lsResponse = WebClient.httpsPostJSon(
                        loApis.getAddToCartAPI(),
                        params.toString(),
                        new HttpHeaders(mContext).getHeaders());
                if (lsResponse == null) {
                    message = "Unable to retrieve server response.";
                    Log.e(TAG, message);
                    return false;
                } else {
                    JSONObject loResponse = new JSONObject(lsResponse);
                    String lsResult = loResponse.getString("result");
                    if (!lsResult.equalsIgnoreCase("success")) {
                        JSONObject loError = loResponse.getJSONObject("error");
                        message = loError.getString("message");
                        Log.e(TAG, message);
                        return false;
                    } else {
                        data = loResponse;
                        Log.e(TAG, data.toString());
                        return AddUpdateCartLocal(fsLstngID, fnQuantity);
                    }
                }
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean UpdateCartQuantity(String fsLstngID, int fnQuantity){
        try {
            AccountInfo loAccount = new AccountInfo(mContext);
            if(fnQuantity <= 0){
                message = "Unable to proceed with '0' quantity.";
                Log.e(TAG, "Unable to proceed with '0' quantity.");
                return false;
            } else if(loAccount.getUserID().isEmpty()){
                message = "Please login your account to continue.";
                Log.e(TAG, "Please login your account to continue.");
                return false;
            } else if(loAccount.getVerificationStatus() == 0){
                message = "Please complete your account setup to continue.";
                Log.e(TAG, "Please complete your account setup to continue.");
                return true;
            } else if(ValidateItemQuantity(fsLstngID, fnQuantity)) {
                Thread.sleep(1000);

                ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
                JSONObject params = new JSONObject();
                params.put("sListngID", fsLstngID);
                params.put("nQuantity", fnQuantity);

                String lsResponse = WebClient.httpsPostJSon(
                        loApis.getAddToCartAPI(),
                        params.toString(),
                        new HttpHeaders(mContext).getHeaders());
                if (lsResponse == null) {
                    message = "Unable to retrieve server response.";
                    return false;
                } else {
                    JSONObject loResponse = new JSONObject(lsResponse);
                    String lsResult = loResponse.getString("result");
                    if (!lsResult.equalsIgnoreCase("success")) {
                        JSONObject loError = loResponse.getJSONObject("error");
                        message = loError.getString("message");
                        return false;
                    } else {
                        data = loResponse;
                        return UpdateCartQuantityLocal(fsLstngID, fnQuantity);
                    }
                }
            } else {
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean RemoveCartItem(String fsLstngID){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            JSONObject params = new JSONObject();
            params.put("sListngID", fsLstngID);

            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getRemoveCartItemAPI(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if (lsResponse == null) {
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if (!lsResult.equalsIgnoreCase("success")) {
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    poCartDao.DeleteCartItem(fsLstngID);
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean ForCheckOut(String fsLstngID){
        try {
            poCartDao.UpdateForCheckOut(fsLstngID);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean RemoveForCheckOut(String fsLstngID){
        try {
            poCartDao.RemoveForCheckOut(fsLstngID);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean CheckCartItemsForCheckOut(){
        try{
            int lnCountxx = poCartDao.CheckCartItemsForOrder();
            if(lnCountxx > 0){
                return true;
            } else {
                message = "Select items for check out.";
                return false;
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean PlaceOrder(List<DItemCart.oMarketplaceCartItem> foItemLst, boolean fcDirect){
        try {
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            JSONArray jaDetail = new JSONArray();
            for(int x = 0; x < foItemLst.size(); x++){
                JSONObject joDetail = new JSONObject();
                joDetail.put("sListngID", foItemLst.get(x).sListIDxx);
                joDetail.put("nQuantity", foItemLst.get(x).nQuantity);
                jaDetail.put(joDetail);
            }

            JSONObject params = new JSONObject();
            int nDirectxx = 1;
            if(fcDirect){
                nDirectxx = 0;
            }
            params.put("cCartItem", nDirectxx); //0 - direct place order; 1 - place order of cart item
            params.put("nFreightx", 100.00); //Freight charge

            params.put("detail", jaDetail);

            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getMarketPlaceOrderAPI(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                Log.d(TAG, "Server Response : " + lsResponse);
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    for(int x = 0; x < foItemLst.size(); x++){
                        poCartDao.DeleteCartItem(foItemLst.get(x).sListIDxx);
                    }
                    TransNox = loResponse.getString("sTransNox");
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    private boolean ValidateItemQuantity(String fsLstngID, int fnQuantity) throws Exception{
        ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());

        JSONObject params = new JSONObject();
        params.put("bsearch", false);
        params.put("id", fsLstngID);
        String lsResponse = WebClient.httpsPostJSon(
                loApis.getImportProducts(),
                params.toString(),
                new HttpHeaders(mContext).getHeaders());
        if(lsResponse == null){
            message = "Unable to retrieve server response.";
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
                JSONArray laDetail = loResponse.getJSONArray("detail");
                JSONObject loDetail = laDetail.getJSONObject(0);
                int lnQuantity = loDetail.getInt("nQtyOnHnd");
                String nTotalQty = loDetail.getString("nTotalQty");
                String nQtyOnHnd = loDetail.getString("nQtyOnHnd");
                String nResvOrdr = loDetail.getString("nResvOrdr");
                String nSoldQtyx = loDetail.getString("nSoldQtyx");
                String nUnitPrce = loDetail.getString("nUnitPrce");
                String sListngID = loDetail.getString("sListngID");
                poProdDao.UpdateProductQtyInfo(sListngID, nTotalQty, nQtyOnHnd, nResvOrdr, nSoldQtyx, nUnitPrce);
                if(lnQuantity >= fnQuantity){
                    return true;
                } else {
                    message = "Order quantity is higher than quantity on hand.";
                    Log.e(TAG, message);
                    return false;
                }
            }
        }
    }

    private boolean AddUpdateCartLocal(String fsLstngID, int fnQuantity){
        try{
            EItemCart loItem = new EItemCart();
            loItem.setUserIDxx(new AccountInfo(mContext).getUserID());
            loItem.setListIDxx(fsLstngID);
            loItem.setQuantity(String.valueOf(fnQuantity));
            loItem.setTranStat("0");
            loItem.setAvlQtyxx("");
            loItem.setCreatedx(new AppConstants().DATE_MODIFIED);
            loItem.setTimeStmp(new AppConstants().DATE_MODIFIED);
            if(poCartDao.CheckIFItemExist(fsLstngID) == null){
                poCartDao.SaveItemInfo(loItem);
                Log.d(TAG, "");
            } else {
                int lnQty = Integer.parseInt(poCartDao.CheckIFItemExist(fsLstngID).getQuantity());
                lnQty = lnQty + fnQuantity;
                poCartDao.UpdateItem(fsLstngID, lnQty);
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    private boolean UpdateCartQuantityLocal(String fsLstngID, int fnQuantity){
        try{
            EItemCart loItem = new EItemCart();
            loItem.setUserIDxx(new AccountInfo(mContext).getUserID());
            loItem.setListIDxx(fsLstngID);
            loItem.setQuantity(String.valueOf(fnQuantity));
            loItem.setTranStat("0");
            loItem.setAvlQtyxx("");
            loItem.setCreatedx(new AppConstants().DATE_MODIFIED);
            loItem.setTimeStmp(new AppConstants().DATE_MODIFIED);
            if(poCartDao.CheckIFItemExist(fsLstngID) == null){
                poCartDao.SaveItemInfo(loItem);
            } else {
                poCartDao.UpdateItem(fsLstngID, fnQuantity);
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean ImportMarketPlaceItemCart(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            JSONObject params = new JSONObject();
            if(poCartDao.CheckIfCartHasRecord() > 0){
                params.put("dTimeStmp", poCartDao.GetLatestCartTimeStamp());
            }
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getImportCartItems(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    JSONArray jaDetail = loResponse.getJSONArray("detail");
                    for(int x = 0; x < jaDetail.length(); x++){
                        EItemCart loDetail = new EItemCart();
                        JSONObject loJson = jaDetail.getJSONObject(x);
                        loDetail.setUserIDxx(loJson.getString("sUserIDxx"));
                        loDetail.setListIDxx(loJson.getString("sListngID"));
                        loDetail.setQuantity(loJson.getString("nQuantity"));
                        loDetail.setAvlQtyxx(loJson.getString("nAvlQtyxx"));
                        loDetail.setCreatedx(loJson.getString("dCreatedx"));
                        loDetail.setTranStat(loJson.getString("cTranStat"));
                        loDetail.setTimeStmp(loJson.getString("dTimeStmp"));
                        poCartDao.SaveItemInfo(loDetail);
                    }
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public LiveData<Integer> GetCartItemCount(){
        return poCartDao.GetCartItemCount();
    }

    public LiveData<Integer> GetMartketplaceCartItemCount(){
        return poCartDao.GetMartketplaceCartItemCount();
    }

    public boolean BuyNow(String fsLstngID, int fnQuantity){
        try {
            EItemCart loItem = new EItemCart();
            loItem.setUserIDxx(new AccountInfo(mContext).getUserID());
            loItem.setListIDxx(fsLstngID);
            loItem.setQuantity(String.valueOf(fnQuantity));
            loItem.setBuyNowxx("1");
            loItem.setCheckOut("1");
            loItem.setAvlQtyxx("");
            loItem.setCreatedx(new AppConstants().DATE_MODIFIED);
            loItem.setTimeStmp(new AppConstants().DATE_MODIFIED);
            poCartDao.CancelBuyNowItem();
            poCartDao.SaveItemInfo(loItem);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean CancelBuyNow(){
        try{
            poCartDao.CancelBuyNowItem();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public LiveData<List<DItemCart.oMarketplaceCartItem>> GetItemCartList() {
        return poCartDao.GetCartItemsList();
    }

    public LiveData<Double> GetSelectedItemCartTotalPrice() {
        return poCartDao.GetSelectedItemCartTotalPrice();
    }

    public LiveData<Integer> GetSelectedItemCartTotalCount() {
        return poCartDao.GetSelectedItemCartTotalCount();
    }

    public LiveData<List<DItemCart.oMarketplaceCartItem>> GetCheckoutItems(boolean cBuyNowxx) {
        if (!cBuyNowxx) {
            return poCartDao.GetItemsForCheckOut();
        } else {
            return poCartDao.GetBuyNowItem();
        }
    }

    public boolean PayOrder(String fsTransno, PaymentMethod foTypexx, String fsReferNo){
        try{
            JSONObject param = new JSONObject();
            param.put("sTransNox", fsTransno);

            if(foTypexx != PaymentMethod.CashOnDelivery){
                if(fsReferNo == null){
                    message = "Please enter payment reference no.";
                    return false;
                } else if(fsReferNo.trim().isEmpty()){
                    message = "Please enter payment reference no.";
                    return false;
                }
            }

            switch (foTypexx){
                case CashOnDelivery:
                    param.put("sTermCode", "COD"); //payment term : PayMaya
                    param.put("sReferNox", fsReferNo);
                    break;
                case PayMaya:
                    param.put("sTermCode", "PAYMAYA");//payment term : PayMaya
                    param.put("sReferNox", fsReferNo);
                    break;
                default:
                    param.put("sTermCode", "GCASH");//payment term : PayMaya
                    param.put("sReferNox", fsReferNo);
                    break;
            }

            ServerAPIs loApi = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            String lsResponse = WebClient.httpsPostJSon(
                    loApi.getOrderPaymentAPI(),
                    param.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Server no response.";
                return false;
            } else {
                Log.e(TAG, lsResponse);
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("success")){
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    Thread.sleep(1000);
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean CancelOrder(String args, String args1){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            JSONObject params = new JSONObject();
            params.put("sTransNox", args);
            params.put("sRemarksx", args1);

            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getCancelMarketplaceOrderAPI(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if (lsResponse == null) {
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if (!lsResult.equalsIgnoreCase("success")) {
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean ImportPurchases(){
        try{
            DOrderMaster loMaster = GGC_GuanzonAppDB.getInstance(mContext).orderMasterDao();
            DOrderDetail loDetail = GGC_GuanzonAppDB.getInstance(mContext).orderDetailDao();
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());

            JSONObject params = new JSONObject();
            if(loMaster.CheckIfMasterHasRecord() > 0){
                params.put("dTimeStmp", loMaster.getMasterLatestTimeStmp());
            }
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getImportPurchasesAPI(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                Log.d(TAG, lsResponse);
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if (!lsResult.equalsIgnoreCase("success")) {
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    JSONArray jaMaster = loResponse.getJSONArray("master");
                    JSONArray jaDetail = loResponse.getJSONArray("detail");
                    for(int x = 0; x < jaMaster.length(); x++){
                        JSONObject joMaster = jaMaster.getJSONObject(x);
                        EOrderMaster oMaster = new EOrderMaster();
                        oMaster.setTransNox(joMaster.getString("sTransNox"));
                        oMaster.setTransact(joMaster.getString("dTransact"));
                        oMaster.setExpected(joMaster.getString("dExpected"));
                        oMaster.setClientID(joMaster.getString("sClientID"));
                        oMaster.setAppUsrID(joMaster.getString("sAppUsrID"));
                        oMaster.setTranTotl(joMaster.getString("nTranTotl"));
                        oMaster.setDiscount(joMaster.getString("nDiscount"));
                        oMaster.setFreightx(joMaster.getString("nFreightx"));
                        oMaster.setTermCode(joMaster.getString("sTermCode"));
                        oMaster.setTranStat(joMaster.getString("cTranStat"));
                        oMaster.setTimeStmp(joMaster.getString("dTimeStmp"));

                        loMaster.SaveOrderMaster(oMaster);
                    }

                    for(int i = 0; i <jaDetail.length(); i++) {
                        JSONObject joDetail = jaDetail.getJSONObject(i);
                        EOrderDetail oDetail = new EOrderDetail();
                        oDetail.setTransNox(joDetail.getString("sTransNox"));
                        oDetail.setEntryNox(joDetail.getString("nEntryNox"));
                        oDetail.setQuantity(joDetail.getString("nQuantity"));
                        oDetail.setUnitPrce(joDetail.getString("nUnitPrce"));
                        oDetail.setDiscount(joDetail.getString("nDiscount"));
                        oDetail.setAddDiscx(joDetail.getString("nAddDiscx"));
                        oDetail.setStockIDx(joDetail.getString("sStockIDx"));
//                        oDetail.setIssuedxx(joDetail.getString("nIssuedxx"));
//                        oDetail.setCancelld(joDetail.getString("nCancelld"));
//                        oDetail.setReferNox(joDetail.getString("sReferNox"));
                        oDetail.setNotesxxx(joDetail.getString("sNotesxxx"));
                        oDetail.setReviewed(joDetail.getString("cReviewed"));
                        oDetail.setTimeStmp(joDetail.getString("dTimeStmp"));

                        loDetail.SaveDetailOrder(oDetail);
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean ImportCancellationDetail(String fsArgs){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            JSONObject params = new JSONObject();
            params.put("sTransNox", fsArgs);
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getDownloadCancellationsAPI(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if(lsResponse == null){
                message = "Unable to retrieve server response.";
                return false;
            } else {
                Log.d(TAG, lsResponse);
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if (!lsResult.equalsIgnoreCase("success")) {
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    data = loResponse;
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public LiveData<Integer> GetToPayOrders(){
        DOrderMaster loMaster = GGC_GuanzonAppDB.getInstance(mContext).orderMasterDao();
        return loMaster.GetToPayOrders();
    }

    public LiveData<EOrderMaster> GetOrderMasterInfo(String fsVal){
        return poMaster.GetMasterInfo(fsVal);
    }

    public LiveData<List<EOrderDetail>> GetOrderDetailInfo(String fsVal){
        return poDetail.GetDetailInfo(fsVal);
    }

    public LiveData<List<EOrderMaster>> GetMasterOrderHistory(String fsVal){
        return poMaster.GetMasterOrderHistory(fsVal);
    }

    public LiveData<List<EOrderMaster>> GetMasterOrderHistory(){
        return poMaster.GetMasterOrderHistory();
    }

    public LiveData<List<DOrderMaster.OrderHistory>> GetOrderHistoryList() {
        return poMaster.GetOrderHistoryList();
    }

    public LiveData<List<DOrderMaster.OrderHistory>> GetOrderHistoryList(String fsVal) {
        return poMaster.GetOrderHistoryList(fsVal);
    }


    public LiveData<List<DOrderMaster.OrderHistory>> GetToPayOrderList() {
        return poMaster.GetToPayOrderList();
    }

    public LiveData<List<DOrderDetail.OrderHistoryDetail>> GetOrderHistoryDetail(String fsVal) {
        return poDetail.GetOrderHistoryDetail(fsVal);
    }

    public LiveData<List<DOrderDetail.OrderedItemsInfo>> GetOrderedItems(String fsVal) {
        return poDetail.GetOrderedItems(fsVal);
    }

    public LiveData<Integer> GetToPayOrdersCount() {
        return poMaster.GetToPayOrdersCount();
    }
    public LiveData<Integer> GetProcessingOrdersCount(){
        return poMaster.GetProcessingOrdersCount();
    }
    public LiveData<Integer> GetToShipOrdersCount(){
        return poMaster.GetToShipOrdersCount();
    }
    public LiveData<Integer> GetDeliveredOrdersCount(){
        return poMaster.GetDeliveredOrdersCount();
    }
    public LiveData<Integer> GetCancelledOrdersCount(){
        return poMaster.GetCancelledOrdersCount();
    }

    public LiveData<DOrderMaster.DetailedOrderHistory> GetDetailOrderHistory(String fsVal){
        return poMaster.GetDetailOrderHistory(fsVal);
    }

    public void UpdateReviewedItem(String OrderID, String ListID){
        poDetail.UpdateReviewedItem(OrderID, ListID);
    }

    public boolean DownloadBankAccounts(){
        try{
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            JSONObject params = new JSONObject();
            params.put("bsearch", true);
            params.put("descript", "");

            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getDownloadBankAccountAPI(),
                    params.toString(),
                    new HttpHeaders(mContext).getHeaders());
            if (lsResponse == null) {
                message = "Unable to retrieve server response.";
                return false;
            } else {
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if (!lsResult.equalsIgnoreCase("success")) {
                    JSONObject loError = loResponse.getJSONObject("error");
                    message = loError.getString("message");
                    return false;
                } else {
                    data = loResponse;
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean SelectAll(boolean isSelected) {
        try {
            if (isSelected) {
                poCartDao.UpdateSelectAllCheckOut();
            } else {
                poCartDao.UpdateUnselectAllCheckOut();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean DeleteAll() {
        try {
            poCartDao.DeleteAllSelected();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }
}
