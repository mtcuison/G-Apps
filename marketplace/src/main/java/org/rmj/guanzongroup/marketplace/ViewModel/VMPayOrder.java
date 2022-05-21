package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;

public class VMPayOrder extends AndroidViewModel {

    private final Application application;
    private final ROrder poItmCart;

    public VMPayOrder(@NonNull Application application) {
        super(application);
        this.application = application;
        this.poItmCart = new ROrder(application);
    }

    public void payOrder(String fsTransNo, PaymentMethod foPayMeth, String fsReferNo,
                         OnTransactionsCallback foCallBck) {
        new PayOrderTask(application, foPayMeth, fsReferNo, foCallBck).execute(fsTransNo);
    }

    private static class PayOrderTask extends AsyncTask<String, Void, Boolean> {

        private final ConnectionUtil loConnect;
        private final ROrder loItmCart;
        private final OnTransactionsCallback loCallBck;
        private final PaymentMethod loPayMeth;
        private final String lsReferNo;
        private String lsMessage = "";

        private PayOrderTask(Application application, PaymentMethod foPayMeth, String fsReferNo,
                             OnTransactionsCallback foCallBck) {
            this.loConnect = new ConnectionUtil(application);
            this.loItmCart = new ROrder(application);
            this.loPayMeth = foPayMeth;
            this.lsReferNo = fsReferNo;
            this.loCallBck = foCallBck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallBck.onLoading();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try {
                String lsTransNo = strings[0];
                if(loConnect.isDeviceConnected()) {
                    boolean isSuccess = loItmCart.PayOrder(lsTransNo, loPayMeth, lsReferNo);
                    lsMessage = (isSuccess) ? "Order payment selection success." : loItmCart.getMessage();
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
