package org.guanzongroup.com.creditapp.ViewModel;

import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.guanzongroup.com.creditapp.Model.PurchaseInfo;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.lib.CreditApp.CreditApplication;
import org.rmj.g3appdriver.lib.CreditApp.model.MpCreditApp;

public class VMLoanPreview extends AndroidViewModel {
    private static final String TAG = VMLoanPreview.class.getSimpleName();

    private final CreditApplication poApp;
    private final ConnectionUtil poConn;
    private final RClientInfo poClient;
    private final PurchaseInfo poModel;
    private final RProduct poProdct;
    private final MpCreditApp poCrdt;

    private String message;
    private String psDetlInf;

    public interface OnInitializeInfo{
        void OnLoad(String title, String message);
        void OnSuccess(MpCreditApp args);
        void OnFailed(String message);
    }

    public interface OnSubmitApplication{
        void OnSubmit(String title, String message);
        void OnSuccess();
        void OnFailed(String message);
    }

    public VMLoanPreview(@NonNull Application application) {
        super(application);
        this.poApp = new CreditApplication(application);
        this.poConn = new ConnectionUtil(application);
        this.poClient = new RClientInfo(application);
        this.poModel = new PurchaseInfo();
        this.poProdct = new RProduct(application);
        this.poCrdt = new MpCreditApp();
    }

    public void InitIntentData(Intent foVal){
        try {
            poModel.setLsListngID(foVal.getStringExtra("sListngID"));
            poModel.setLsUnitAppl(foVal.getStringExtra("sUnitAppl"));
            poModel.setLsModelIDx(foVal.getStringExtra("sModelIDx"));
            poModel.setLsDiscount(foVal.getStringExtra("nDiscount"));
            poModel.setLsAmortztn(foVal.getStringExtra("nMonAmort"));
            poModel.setLsDownPaym(foVal.getStringExtra("sDownPaym"));
            poModel.setLsMiscExps(foVal.getStringExtra("nMiscExps"));
            poModel.setLsInstallx(foVal.getStringExtra("sLoanTerm"));
            poCrdt.setData(foVal.getStringExtra("sDetlInfo"));
            psDetlInf = poCrdt.getData();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public PurchaseInfo getModel(){
        return poModel;
    }

    public LiveData<EProducts> GetProductInfo(){
        return poProdct.GetProductInfo(poModel.getLsListngID());
    }

//    public void InitializeApplicantInfo(OnInitializeInfo listener){
//        new InitializeApplicantInfo(listener).execute(poModel);
//    }

    public void SubmitApplication(OnSubmitApplication listener){
        new SubmitApplicationTask(listener).execute(psDetlInf);
    }

//    private class InitializeApplicantInfo extends AsyncTask<PurchaseInfo, Void, MpCreditApp>{
//
//        private final OnInitializeInfo listener;
//
//        public InitializeApplicantInfo(OnInitializeInfo listener) {
//            this.listener = listener;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            listener.OnLoad("Apply For A Loan", "Initializing applicant info...");
//        }
//
//        @Override
//        protected MpCreditApp doInBackground(PurchaseInfo... info) {
//            try {
//                if(!poConn.isDeviceConnected()){
//                    message = "Unable to connect.";
//                    return null;
//                }
//
//                String lsResult = poApp.GetOtherApplicationInfo();
//
//                if(lsResult == null){
//                    message = poApp.getMessage();
//                    return null;
//                }
//
//                JSONObject loJson = new JSONObject(lsResult);
//                String lsMeans = loJson.getString("sMeansInf");
//                String lsOther = loJson.getString("sOtherInf");
//
//                MpCreditApp loApp = new MpCreditApp();
//                loApp.setDateApplied(new AppConstants().DATE_MODIFIED);
//                loApp.setDateCreated(new AppConstants().DATE_MODIFIED);
//
//                String lsUnitAppl = info[0].getLsUnitAppl();
//                String lsModelIDx = info[0].getLsModelIDx();
//                String lsDiscount = info[0].getLsDiscount();
//                String lsAmortztn = info[0].getLsAmortztn();
//                String lsDownPaym = info[0].getLsDownPaym();
//                String lsMiscExps = info[0].getLsMiscExps();
//                String lsInstallx = info[0].getLsInstallx();
//
//                loApp.setUnitApplied(lsUnitAppl);
//                loApp.setModel(lsModelIDx);
//                loApp.setUnitType("1");
//                loApp.setDiscount(lsDiscount);
//                loApp.setDownpayment(lsDownPaym);
//                loApp.setAmortization(lsAmortztn);
//                loApp.setMiscellaneousExpense(lsMiscExps);
//                loApp.setInstallmentTerm(lsInstallx.split(" ")[0]);
//
//                EClientInfo loClient = poClient.GetClientInfo();
//
//                String lsLastNm = loClient.getLastName();
//                String lsMiddNm = loClient.getMiddName();
//                String lsFrstNm = loClient.getFrstName();
//                String lsGender = loClient.getGenderCd();
//                String lsCvlStt = loClient.getCvilStat();
//
//                loApp.clientInfo().setLastName(lsLastNm);
//                loApp.clientInfo().setFirstName(lsFrstNm);
//                loApp.clientInfo().setMiddleName(lsMiddNm);
//                loApp.clientInfo().setGender(lsGender);
//                loApp.clientInfo().setCivilStatus(lsCvlStt);
//
//                loApp.clientInfo().addressInfo().setHouseNo(loClient.getHouseNo1());
//                loApp.clientInfo().addressInfo().setAddress1(loClient.getAddress1());
////                loApp.clientInfo().addressInfo().setAddress2(loClient.get());
//                loApp.clientInfo().addressInfo().setBarangayID(loClient.getBrgyIDx1());
//                loApp.clientInfo().addressInfo().setTownID(loClient.getTownIDx1());
//
//                MpCreditApp loMeans = new MpCreditApp();
//                loMeans.setData(lsMeans);
//                loApp.meansInfo().setData(loMeans.getData());
//
//                MpCreditApp loOther = new MpCreditApp();
//                loMeans.setData(lsOther);
//                loApp.disbursementInfo().setData(loOther.getData());
//
//                return loApp;
//            } catch (Exception e){
//                e.printStackTrace();
//                message = e.getMessage();
//                return null;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(MpCreditApp result) {
//            super.onPostExecute(result);
//            if(result == null){
//                listener.OnFailed(message);
//            } else {
//                listener.OnSuccess(result);
//            }
//        }
//    }

    private class SubmitApplicationTask extends AsyncTask<String, Void, Boolean>{

        private final OnSubmitApplication listener;

        public SubmitApplicationTask(OnSubmitApplication listener) {
            this.listener = listener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listener.OnSubmit("Apply For A Loan", "Submitting application. Please wait...");
        }

        @Override
        protected Boolean doInBackground(String... info) {
            try{
                if(!poConn.isDeviceConnected()){
                    message = "Unable to connect";
                    return false;
                }

                if(!poApp.SubmitApplication(info[0])){
                    message = poApp.getMessage();
                    return false;
                }

                return true;
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean isSuccess) {
            super.onPostExecute(isSuccess);
            if(!isSuccess){
                listener.OnFailed(message);
            } else {
                listener.OnSuccess();
            }
        }
    }
}
