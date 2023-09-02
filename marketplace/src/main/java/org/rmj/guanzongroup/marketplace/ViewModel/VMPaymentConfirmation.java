package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.etc.PaymentMethod;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;

public class VMPaymentConfirmation extends AndroidViewModel {

    private final ROrder poOrder;
    private final ConnectionUtil poConn;

    public VMPaymentConfirmation(@NonNull Application application) {
        super(application);
        this.poOrder = new ROrder(application);
        this.poConn = new ConnectionUtil(application);
    }

    public void CheckPaymentMethods(OnTransactionsCallback callback){
        new CheckPaymentMethodTask(callback).execute();
    }

    private class CheckPaymentMethodTask extends AsyncTask<String, Void, Boolean>{

        private final OnTransactionsCallback callback;
        private String message;

        public CheckPaymentMethodTask(OnTransactionsCallback callback) {
            this.callback = callback;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.onLoading();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try{
                if(poOrder.DownloadBankAccounts()){
                    message = poOrder.getData().toString();
                    return true;
                } else {
                    message = poOrder.getMessage();
                    return false;
                }
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                callback.onSuccess(message);
            } else {
                callback.onFailed(message);
            }
        }
    }

    public void payOrder(String fsTransNo, PaymentMethod foPayMeth, String fsReferNo,
                         OnTransactionsCallback foCallBck) {
        new PayOrderTask(foPayMeth, foCallBck).execute(fsTransNo, fsReferNo);
    }

    private class PayOrderTask extends AsyncTask<String, Void, Boolean>{

        private final PaymentMethod poMethod;
        private final OnTransactionsCallback callback;

        private String message;

        public PayOrderTask(PaymentMethod poMethod, OnTransactionsCallback foCallBck) {
            this.poMethod = poMethod;
            this.callback = foCallBck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.onLoading();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try{
                if(!poConn.isDeviceConnected()){
                    message = "Unable to connect.";
                    return false;
                }

                String lsTransNo = strings[0];
                String lsReferNo = strings[1];

                boolean isSuccess = poOrder.PayOrder(lsTransNo, poMethod, lsReferNo);
                message = (isSuccess) ? "Order Completed. \nThank you for your purchase." : poOrder.getMessage();
                return isSuccess;
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean isSuccess) {
            super.onPostExecute(isSuccess);
            if(isSuccess) {
                callback.onSuccess(message);
            } else {
                callback.onFailed(message);
            }
        }
    }
}
