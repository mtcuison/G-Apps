package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EItemCart;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;

import java.util.List;

public class VMPlaceOrder extends AndroidViewModel {

    private final Application application;
    private final ConnectionUtil poConnect;
    private final RClientInfo poClientx;
    private final ROrder poItmCart;
    private final RProduct poProdcts;
    private final RAddressMobile poAddress;

    public VMPlaceOrder(@NonNull Application application) {
        super(application);
        this.application = application;
        this.poConnect = new ConnectionUtil(application);
        this.poClientx = new RClientInfo(application);
        this.poItmCart = new ROrder(application);
        this.poProdcts = new RProduct(application);
        this.poAddress = new RAddressMobile(application);
    }

    public LiveData<EClientInfo> getClientInfo(){
        return poClientx.getClientInfo();
    }

    public LiveData<String> getFullAddress(String fsBrgyID) {
        return poAddress.GetFullAddressName(fsBrgyID);
    }

    public LiveData<EProducts> getProductInfo(String fsListID) {
        return poProdcts.GetProductInfo(fsListID);
    }

    public void placeOrder(List<EItemCart> foItemLst,
                           PaymentMethod foTypexx,
                           String fsReferNo,
                           boolean fcDirectxx,
                           OnTransactionsCallback foCallBck) {
        new PlaceOrderTask(application, foTypexx, fsReferNo, fcDirectxx, foCallBck).execute(foItemLst);
    }


    private static class PlaceOrderTask extends AsyncTask<List<EItemCart>, Void, Boolean> {

        private final ConnectionUtil loConnect;
        private final ROrder loItmCart;
        private final OnTransactionsCallback loCallBck;
        private final PaymentMethod loPayment;
        private final String lsReferNo;
        private final boolean fcDirectxx;
        private String lsMessage = "";

        private PlaceOrderTask(Application application,
                               PaymentMethod foPayment,
                               String fsReferNo,
                               boolean fcDirectxx,
                               OnTransactionsCallback foCallBck) {
            this.loConnect = new ConnectionUtil(application);
            this.loItmCart = new ROrder(application);
            this.loCallBck = foCallBck;
            this.loPayment = foPayment;
            this.lsReferNo = fsReferNo;
            this.fcDirectxx = fcDirectxx;
        }

        @Override
        protected Boolean doInBackground(List<EItemCart>... lists) {
            try {
                List<EItemCart> loProdcts = lists[0];
                if(loConnect.isDeviceConnected()) {
                    boolean isSuccess = false;
                    if(loItmCart.PlaceOrder(loProdcts, fcDirectxx)) {
                        isSuccess = loItmCart.PayOrder(loItmCart.getTransNox(), loPayment, lsReferNo);
                    }
                    lsMessage = loItmCart.getMessage();
                    return isSuccess;
                } else {
                    lsMessage = AppConstants.SERVER_NO_RESPONSE();
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                lsMessage = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallBck.onLoading();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean) {
                loCallBck.onSuccess(lsMessage);
            } else {
                loCallBck.onFailed(lsMessage);
            }
        }
    }


}
