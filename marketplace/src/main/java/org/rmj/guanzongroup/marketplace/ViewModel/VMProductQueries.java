package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;

public class VMProductQueries extends AndroidViewModel {

    private final Application application;
    private final RProduct poProduct;

    public VMProductQueries(@NonNull Application application) {
        super(application);
        this.application = application;
        this.poProduct = new RProduct(application);
    }

    public LiveData<EProducts> getProductInfo(String fsListID){
        return poProduct.GetProductInfo(fsListID);
    }

    public void ImportInquiries(String fsVal, OnInquiryReviewsImportCallback callback){
        new ImportInquiriesTask(callback).execute(fsVal);
    }

    public void sendProductInquiry(String fsItemIdx, String fsInquiry, OnTransactionsCallback foCallBck) {
        new SendProductInquiryTask(fsInquiry, foCallBck).execute(fsItemIdx);
    }

    private class ImportInquiriesTask extends AsyncTask<String, Void, String> {

        private OnInquiryReviewsImportCallback callback;
        private final ConnectionUtil loConnect;
        private boolean isSuccess = false;
        private String message;
        private JSONObject poData;

        public ImportInquiriesTask(OnInquiryReviewsImportCallback callback) {
            this.callback = callback;
            this.loConnect = new ConnectionUtil(application);
        }

        @Override
        protected String doInBackground(String... strings) {
            if(loConnect.isDeviceConnected()) {
                if (poProduct.GetQuestionsAndAnswers(strings[0])) {
                    poData = poProduct.getData();
                    isSuccess = true;
                } else {
                    message = poProduct.getMessage();
                    isSuccess = false;
                }
            } else {
                message = "No internet";
                isSuccess = false;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(isSuccess){
                callback.OnImport(poData.toString());
            } else {
                callback.OnFailed(message);
            }
        }
    }

    private class SendProductInquiryTask extends AsyncTask<String, Void, Boolean> {

        private final OnTransactionsCallback loCallBck;
        private final ConnectionUtil loConnect;
        private final String lsInquiry;
        private String message = "";

        private SendProductInquiryTask(String fsInquiry, OnTransactionsCallback foCallBck) {
            this.loConnect = new ConnectionUtil(application);
            this.lsInquiry = fsInquiry;
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
                if(loConnect.isDeviceConnected()) {
                    String lsItemIdx = strings[0];
                    if(poProduct.SendProductInquiry(lsItemIdx, lsInquiry)) {
                        Thread.sleep(1000);
                        poProduct.GetQuestionsAndAnswers(lsItemIdx);
                        message = "Product Inquiry Sent.";
                        return true;
                    } else {
                        message = poProduct.getMessage();
                        return false;
                    }
                } else {
                    message = AppConstants.SERVER_NO_RESPONSE();
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean) {
                loCallBck.onSuccess(message);
            } else {
                loCallBck.onFailed(message);
            }
        }

    }

    public interface OnInquiryReviewsImportCallback{
        void OnImport(String args);
        void OnFailed(String message);
    }



}
