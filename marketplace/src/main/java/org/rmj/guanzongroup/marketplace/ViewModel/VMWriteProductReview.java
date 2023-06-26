package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;

public class VMWriteProductReview extends AndroidViewModel {

    private final Context poApplctn;
//    private final RProduct poProdcts;

    public VMWriteProductReview(@NonNull Application application) {
        super(application);
        this.poApplctn = application;
//        this.poProdcts = new RProduct(application);
    }
//
//    public LiveData<EProducts> getProductInfo(String fsListID){
//        return poProdcts.GetProductInfo(fsListID);
//    }
//
//    public void saveReview(String OrderID,
//                            String fsListID,
//                           int fnRating,
//                           String fsReview,
//                           OnTransactionsCallback foCallBck) {
//        new SaveReviewTask(poApplctn, OrderID, fnRating, fsReview, foCallBck).execute(fsListID);
//    }
//
//    private static class SaveReviewTask extends AsyncTask<String, Void, Boolean> {
//
//        private final Context mContext;
//        private final ConnectionUtil loConnect;
//        private final OnTransactionsCallback loCallBck;
//        private final String psOrderID;
//        private final int lnRatings;
//        private final String lsReviews;
//        private RProduct poProdct;
//
//        private String lsMessage = "";
//
//        private SaveReviewTask(Context foAppsxx,String OrderID, int fnRatings, String fsReviews,
//                               OnTransactionsCallback foCallBck) {
//            this.mContext = foAppsxx;
//            this.loConnect = new ConnectionUtil(foAppsxx);
//            this.poProdct = new RProduct(foAppsxx);
//            this.psOrderID = OrderID;
//            this.lnRatings = fnRatings;
//            this.lsReviews = fsReviews;
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
//        protected Boolean doInBackground(String... strings) {
//            try {
//                String lsListIdx = strings[0];
//                if(loConnect.isDeviceConnected()) {
//                    // TODO: Initialize write review here.
//                    if(poProdct.SendProductReview(psOrderID, lsListIdx, lnRatings, lsReviews)){
//                        lsMessage = "Thank you for your review.";
//                        new ROrder(mContext).UpdateReviewedItem(psOrderID, lsListIdx);
//                        return true;
//                    } else {
//                        lsMessage = poProdct.getMessage();
//                        return false;
//                    }
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

}
