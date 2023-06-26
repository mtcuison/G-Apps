package org.guanzongroup.com.creditapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class VMLoanTerm extends AndroidViewModel {
    private static final String TAG = VMLoanTerm.class.getSimpleName();

//    private final CreditApplication poApp;
//    private final RProduct poProdct;
//    private final ConnectionUtil poConn;

    private String message;

//    public interface OnDownloadInstallmentPlan{
//        void OnDownload(String title, String message);
//        void OnDownload(List<LoanTerm> args);
//        void OnFailed(String message);
//    }

    public VMLoanTerm(@NonNull Application application) {
        super(application);
//        this.poApp = new CreditApplication(application);
//        this.poProdct = new RProduct(application);
//        this.poConn = new ConnectionUtil(application);
    }

//    public LiveData<EProducts> GetProductInfo(String args){
//        return poProdct.GetProductInfo(args);
//    }

//    public void ImportInstallmentPlans(String args, OnDownloadInstallmentPlan listener){
//        new ImportInstallmentPlanTask(listener).execute(args);
//    }

//    private class ImportInstallmentPlanTask extends AsyncTask<String, Void, List<LoanTerm>>{
//
//        private final OnDownloadInstallmentPlan listener;
//
//        public ImportInstallmentPlanTask(OnDownloadInstallmentPlan listener) {
//            this.listener = listener;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            listener.OnDownload("Apply For A Loan", "Checking installment plans. Please wait...");
//        }
//
//        @Override
//        protected List<LoanTerm> doInBackground(String... strings) {
//            try{
//                if(!poConn.isDeviceConnected()){
//                    message = "Unable to connect.";
//                    return null;
//                }
//
//                List<LoanTerm> loDetail = poApp.GetLoanTerms(strings[0]);
//
//                if(loDetail == null){
//                    message = poApp.getMessage();
//                    return null;
//                }
//
//                return loDetail;
//            } catch (Exception e){
//                e.printStackTrace();
//                message = e.getMessage();
//                return null;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(List<LoanTerm> result) {
//            super.onPostExecute(result);
//            if(result == null){
//                listener.OnFailed(message);
//            } else {
//                listener.OnDownload(result);
//            }
//        }
//    }
}
