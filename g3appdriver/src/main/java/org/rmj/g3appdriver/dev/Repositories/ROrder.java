package org.rmj.g3appdriver.dev.Repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DItemCart;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EItemCart;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
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

    private JSONObject data;
    private String message;

    public ROrder(Context context){
        this.mContext = context;
        this.poProdDao = GGC_GuanzonAppDB.getInstance(mContext).prodctDao();
        this.poCartDao = GGC_GuanzonAppDB.getInstance(mContext).itemCartDao();
    }

    public JSONObject getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public boolean AddUpdateCart(String fsLstngID, int fnQuantity){
        try {
            AccountInfo loAccount = new AccountInfo(mContext);
            if(fnQuantity <= 0){
                message = "Unable to proceed with '0' quantity.";
                return false;
            } else if(loAccount.getEmailAdd().isEmpty()){
                message = "Please login your account to continue.";
                return false;
            } else if(loAccount.getClientID().isEmpty()){
                message = "Please complete your account setup to continue.";
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

    public boolean PlaceOrder(List<EItemCart> foItemLst, PaymentMethod foTypexx, String fsReferNo){
        try {
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            JSONArray jaDetail = new JSONArray();
            for(int x = 0; x < foItemLst.size(); x++){
                JSONObject joDetail = new JSONObject();
                joDetail.put("sListngID", foItemLst.get(x).getListIDxx());
                joDetail.put("nQuantity", foItemLst.get(x).getQuantity());
                jaDetail.put(joDetail);
            }

            String lsPaymnt = null;
            switch (foTypexx){
                case GCash:
                    lsPaymnt = "GC";
                    break;
                case PayMaya:
                    lsPaymnt = "PAYM";
                    break;
                default:
                    lsPaymnt = "NP";
                    break;
            }

            JSONObject params = new JSONObject();
            params.put("cCartItem", 1); //0 - direct place order; 1 - place order of cart item
            params.put("nFreightx", 100.00); //Freight charge
            params.put("sTermCode", lsPaymnt); //payment term : PayMaya
            params.put("sReferNox", fsReferNo); //payment reference no.

            params.put("detail", jaDetail);

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

    public boolean PlaceOrder(EProducts loCartList, PaymentMethod foTypexx, String fsReferNo){
        try {
            ServerAPIs loApis = new ServerAPIs(new GuanzonAppConfig(mContext).getTestCase());
            JSONArray jaDetail = new JSONArray();

            JSONObject joDetail = new JSONObject();
            joDetail.put("sListngID", loCartList.getListngID());
            joDetail.put("nQuantity", loCartList.getQtyOnHnd());
            jaDetail.put(joDetail);

            String lsPaymnt = null;
            switch (foTypexx){
                case GCash:
                    lsPaymnt = "GCASH";
                    break;
                case PayMaya:
                    lsPaymnt = "PAYM";
                    break;
                default:
                    lsPaymnt = "COD";
                    break;
            }

            JSONObject params = new JSONObject();
            params.put("cCartItem", 1); //0 - direct place order; 1 - place order of cart item
            params.put("nFreightx", 100.00); //Freight charge
            params.put("sTermCode", lsPaymnt); //payment term : PayMaya
            params.put("sReferNox", fsReferNo); //payment reference no.

            params.put("detail", jaDetail);

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
            loItem.setCreatedx(new AppConstants().GCARD_DATE_TIME);
            loItem.setTimeStmp(new AppConstants().GCARD_DATE_TIME);
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
            String lsResponse = WebClient.httpsPostJSon(
                    loApis.getImportCartItems(),
                    new JSONObject().toString(),
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
                    DItemCart loCart = GGC_GuanzonAppDB.getInstance(mContext).itemCartDao();
                    JSONArray jaDetail = loResponse.getJSONArray("detail");
                    for(int x = 0; x < jaDetail.length(); x++){
                        EItemCart loDetail = new EItemCart();
                        JSONObject loJson = jaDetail.getJSONObject(x);
                        loDetail.setUserIDxx(loJson.getString("sUserIDxx"));
                        loDetail.setUserIDxx(loJson.getString("sListIDxx"));
                        loDetail.setUserIDxx(loJson.getString("nQuantity"));
                        loDetail.setUserIDxx(loJson.getString("nAvlQtyxx"));
                        loDetail.setUserIDxx(loJson.getString("dCreatedx"));
                        loDetail.setUserIDxx(loJson.getString("cTranStat"));
                        loDetail.setUserIDxx(loJson.getString("dTimeStmp"));
                        loCart.SaveItemInfo(loDetail);
                    }
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public LiveData<Integer> GetCartItemCount(){
        DItemCart loCart = GGC_GuanzonAppDB.getInstance(mContext).itemCartDao();
        return loCart.GetCartItemCount();
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
                JSONObject loResponse = new JSONObject(lsResponse);
                String lsResult = loResponse.getString("result");
                if(!lsResult.equalsIgnoreCase("result")){
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
}
