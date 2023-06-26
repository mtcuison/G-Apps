package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONObject;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;

import java.util.List;

public class VMPlaceOrder extends AndroidViewModel {

    private final Application application;
//    private final ConnectionUtil poConnect;
//    private final RClientInfo poClientx;
//    private final ROrder poItmCart;
//    private final RProduct poProdcts;
//    private final RAddressMobile poAddress;

    public VMPlaceOrder(@NonNull Application application) {
        super(application);
        this.application = application;
//        this.poConnect = new ConnectionUtil(application);
//        this.poClientx = new RClientInfo(application);
//        this.poItmCart = new ROrder(application);
//        this.poProdcts = new RProduct(application);
//        this.poAddress = new RAddressMobile(application);
    }

//    public LiveData<EClientInfo> getClientInfo(){
//        return poClientx.getClientInfo();
//    }
//
//    public LiveData<String> getFullAddress(String fsBrgyID) {
//        return poAddress.GetFullAddressName(fsBrgyID);
//    }
//
//    public LiveData<List<DItemCart.oMarketplaceCartItem>> getCheckoutItems(boolean cBuyNowxx) {
//        return poItmCart.GetCheckoutItems(cBuyNowxx);
//    }
//
//    public LiveData<DClientInfo.ClientBSAddress> getClientBSAddress(){
//        return poClientx.getClientBSAddress();
//    }
//
//    public LiveData<Double> GetSelectedItemCartTotalPrice(){
//        return poItmCart.GetSelectedItemCartTotalPrice();
//    }
//
//    public LiveData<Double> GetShippingFee(){
//        MutableLiveData<Double> lnShipFee = new MutableLiveData();
//        lnShipFee.setValue(100.0);
//        return lnShipFee;
//    }
//
//    public void cancelBuyNow(boolean fromBuyNow, OnTransactionsCallback foCallBck) {
//        if(fromBuyNow) {
//            new CancelBuyNowTask(application, foCallBck).execute();
//        } else {
//            foCallBck.onLoading();
//            foCallBck.onSuccess("");
//        }
//    }
//
//    public void placeOrder(List<DItemCart.oMarketplaceCartItem> foItemLst, boolean fcDirectxx,
//                           OnTransactionsCallback foCallBck) {
//        new PlaceOrderTask(application, fcDirectxx, foCallBck).execute(foItemLst);
//    }
//
//
//    private static class CancelBuyNowTask extends AsyncTask<Void, Void, Boolean> {
//
//        private final ROrder loItmCart;
//        private final ConnectionUtil loConnect;
//        private final OnTransactionsCallback loCallBck;
//        private String lsMessage = "";
//
//        private CancelBuyNowTask(Application application, OnTransactionsCallback foCallBck) {
//            this.loItmCart = new ROrder(application);
//            this.loConnect = new ConnectionUtil(application);
//            this.loCallBck = foCallBck;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            loCallBck.onLoading();
//        }
//
//        @Override
//        protected Boolean doInBackground(Void... voids) {
//            try {
//                if(loConnect.isDeviceConnected()) {
//                    return loItmCart.CancelBuyNow();
//                } else {
//                    lsMessage = AppConstants.SERVER_NO_RESPONSE();
//                    return false;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                lsMessage = e.getMessage();
//                return false;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(Boolean aBoolean) {
//            super.onPostExecute(aBoolean);
//            if(aBoolean) {
//                loCallBck.onSuccess(lsMessage);
//            } else {
//                loCallBck.onFailed(lsMessage);
//            }
//        }
//
//    }
//
//    private static class PlaceOrderTask extends AsyncTask<List<DItemCart.oMarketplaceCartItem>, Void, String> {
//
//        private final ConnectionUtil loConnect;
//        private final ROrder loItmCart;
//        private final OnTransactionsCallback loCallBck;
//        private final boolean fcDirectxx;
//        private String lsMessage = "";
//
//        private PlaceOrderTask(Application application, boolean fcDirectxx, OnTransactionsCallback foCallBck) {
//            this.loConnect = new ConnectionUtil(application);
//            this.loItmCart = new ROrder(application);
//            this.loCallBck = foCallBck;
//            this.fcDirectxx = fcDirectxx;
//        }
//
//        @Override
//        protected String doInBackground(List<DItemCart.oMarketplaceCartItem>... lists) {
//            try {
//                List<DItemCart.oMarketplaceCartItem> loProdcts = lists[0];
//                if(!loConnect.isDeviceConnected()) {
//                    lsMessage = "Unable to connect";
//                    return null;
//                }
//
//                double lnTotalPrce = loItmCart.GetPlacedOrderTotalPrice();
//
//                String result = loItmCart.PlaceOrder(loProdcts, fcDirectxx);
//                if(result == null) {
//                    lsMessage = loItmCart.getMessage();
//                    return null;
//                }
//
//                loItmCart.ImportPurchases();
//
//                JSONObject loResult = new JSONObject();
//                loResult.put("sTransNox", result);
//                loResult.put("nTrantotl", lnTotalPrce + 100);
//                return loResult.toString();
//            } catch (Exception e) {
//                e.printStackTrace();
//                lsMessage = e.getMessage();
//                return null;
//            }
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            loCallBck.onLoading();
//        }
//
//        @Override
//        protected void onPostExecute(String result) {
//            super.onPostExecute(result);
//            if(result == null) {
//                loCallBck.onFailed(lsMessage);
//            } else {
//                loCallBck.onSuccess(result);
//            }
//        }
//    }
//

}
