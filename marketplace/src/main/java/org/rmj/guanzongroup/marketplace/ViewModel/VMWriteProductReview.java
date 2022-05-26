package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;

public class VMWriteProductReview extends AndroidViewModel {

    private final Application poApplctn;
    private final RProduct poProdcts;

    public VMWriteProductReview(@NonNull Application application) {
        super(application);
        this.poApplctn = application;
        this.poProdcts = new RProduct(application);
    }

    public LiveData<EProducts> getProductInfo(String fsListID){
        return poProdcts.GetProductInfo(fsListID);
    }

    public void saveReview(String fsListID,
                           int fnRating,
                           String fsReview,
                           OnTransactionsCallback foCallBck) {
        new SaveReviewTask(poApplctn, fnRating, fsReview, foCallBck).execute(fsListID);
    }

    private static class SaveReviewTask extends AsyncTask<String, Void, Boolean> {

        private final ConnectionUtil loConnect;
        private final OnTransactionsCallback loCallBck;
        private final int lnRatings;
        private final String lsReviews;

        private String lsMessage = "";

        private SaveReviewTask(Application foAppsxx, int fnRatings, String fsReviews,
                               OnTransactionsCallback foCallBck) {
            this.loConnect = new ConnectionUtil(foAppsxx);
            this.lnRatings = fnRatings;
            this.lsReviews = fsReviews;
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
                String lsListIdx = strings[0];
                if(loConnect.isDeviceConnected()) {

                    // TODO: Initialize write review here.
                    return true;

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
