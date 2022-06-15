package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.guanzongroup.marketplace.Etc.AddUpdateCartTask;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.R;

public class VMProductOverview extends AndroidViewModel {

    private final Application application;
    private final RProduct poProdcts;
    private final ROrder poOrder;

    public VMProductOverview(@NonNull Application application) {
        super(application);
        this.poOrder = new ROrder(application);
        this.application = application;
        this.poProdcts = new RProduct(application);
    }

    public LiveData<EProducts> getProductInfo(String fsListID){
        return poProdcts.GetProductInfo(fsListID);
    }

    public LiveData<Integer> GetCartItemCount(){
        return poOrder.GetCartItemCount();
    }

    public void addUpdateCart(String fsListId, int fnItemQty, OnTransactionsCallback foCallBck) {
        new AddUpdateCartTask(application, fnItemQty, foCallBck).execute(fsListId);
    }

    public void buyNow(String fsLstngID, int fnItemQty, OnTransactionsCallback foCallBck) {
        new BuyNowTask(application, fnItemQty, foCallBck).execute(fsLstngID);
    }

    private static class BuyNowTask extends AsyncTask<String, Void, Boolean> {
        private final ConnectionUtil loConnect;
        private final ROrder loItmCart;
        private final int lnItemQty;
        private final OnTransactionsCallback loCallBck;
        private String lsMessage = "";

        private BuyNowTask(Application foAppsxxx, int fnItemQty, OnTransactionsCallback foCallBck) {
            this.loConnect = new ConnectionUtil(foAppsxxx);
            this.loItmCart = new ROrder(foAppsxxx);
            this.lnItemQty = fnItemQty;
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
                String lsItemIdx = strings[0];
                if(loConnect.isDeviceConnected()) {
                    boolean isSuccess = loItmCart.BuyNow(lsItemIdx, lnItemQty);
                    lsMessage = "";
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

    public interface OnInquiryReviewsImportCallback{
        void OnImport(String args);
        void OnFailed(String message);
    }

    public void ImportInquiries(String fsVal, OnInquiryReviewsImportCallback callback){
        new ImportInquiriesTask(callback).execute(fsVal);
    }

    public void ImportReviews(String fsVal, OnInquiryReviewsImportCallback callback){
        new ImportReviewsTask(callback).execute(fsVal);
    }

    private class ImportInquiriesTask extends AsyncTask<String, Void, String>{

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
                if (poProdcts.GetQuestionsAndAnswers(strings[0])) {
                    poData = poProdcts.getData();
                    isSuccess = true;
                } else {
                    message = poProdcts.getMessage();
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

    private class ImportReviewsTask extends AsyncTask<String, Void, String>{

        private OnInquiryReviewsImportCallback callback;
        private final ConnectionUtil loConnect;
        private boolean isSuccess = false;
        private String message;
        private JSONObject poData;

        public ImportReviewsTask(OnInquiryReviewsImportCallback callback) {
            this.callback = callback;
            this.loConnect = new ConnectionUtil(application);
        }

        @Override
        protected String doInBackground(String... strings) {
            if(loConnect.isDeviceConnected()) {
                if (poProdcts.GetProductRatings(strings[0])) {
                    poData = poProdcts.getData();
                    isSuccess = true;
                } else {
                    message = poProdcts.getMessage();
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
}
