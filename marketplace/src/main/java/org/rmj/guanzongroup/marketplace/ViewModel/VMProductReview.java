package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.ConnectionUtil;

public class VMProductReview extends AndroidViewModel {

    private final Application application;
    private final RProduct poProduct;

    public VMProductReview(@NonNull Application application) {
        super(application);
        this.application = application;
        this.poProduct = new RProduct(application);
    }

    public LiveData<EProducts> getProductInfo(String fsListID){
        return poProduct.GetProductInfo(fsListID);
    }

    public void ImportReviews(String fsVal, OnInquiryReviewsImportCallback callback){
        new ImportReviewsTask(callback).execute(fsVal);
    }

    private class ImportReviewsTask extends AsyncTask<String, Void, String> {

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
                if (poProduct.GetProductRatings(strings[0])) {
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

    public interface OnInquiryReviewsImportCallback{
        void OnImport(String args);
        void OnFailed(String message);
    }

}
