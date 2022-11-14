package org.guanzongroup.com.creditapp.ViewModel;

import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.guanzongroup.com.creditapp.Model.PurchaseInfo;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.dev.Database.Entities.EBarangayInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.CreditApp.CreditApplication;
import org.rmj.g3appdriver.lib.CreditApp.model.MpCreditApp;

import java.util.List;

public class VMApplicantInfo extends AndroidViewModel {
    private static final String TAG = VMApplicantInfo.class.getSimpleName();

    private final CreditApplication poApp;
    private final ConnectionUtil poConn;
    private final PurchaseInfo poModel;


    private String message;

    public interface OnInitializeInfo{
        void OnLoad(String title, String message);
        void OnSuccess(MpCreditApp args);
        void OnFailed(String message);
    }

    public VMApplicantInfo(@NonNull Application application) {
        super(application);
        this.poApp = new CreditApplication(application);
        this.poConn = new ConnectionUtil(application);
        this.poModel = new PurchaseInfo();
    }

    public void InitIntentData(Intent foVal){
        poModel.setLsListngID(foVal.getStringExtra("sListngID"));
        poModel.setLsUnitAppl(foVal.getStringExtra("sUnitAppl"));
        poModel.setLsModelIDx(foVal.getStringExtra("sModelIDx"));
        poModel.setLsDiscount(foVal.getStringExtra("nDiscount"));
        poModel.setLsAmortztn(foVal.getStringExtra("nMonAmort"));
        poModel.setLsDownPaym(foVal.getStringExtra("sDownPaym"));
        poModel.setLsMiscExps(foVal.getStringExtra("nMiscExps"));
        poModel.setLsInstallx(foVal.getStringExtra("sLoanTerm"));
    }

    LiveData<List<EBarangayInfo>> GetBarangayList(String TownID) {
        return poApp.GetBarangayList(TownID);
    }
    LiveData<List<DAddress.oTownObj>> GetTownList() {
        return poApp.GetTownList();
    }

    public void InitializeApplicantInfo(OnInitializeInfo listener){
        new InitializeApplicantInfo(listener).execute(poModel);
    }

    private class InitializeApplicantInfo extends AsyncTask<PurchaseInfo, Void, MpCreditApp> {

        private final OnInitializeInfo listener;

        public InitializeApplicantInfo(OnInitializeInfo listener) {
            this.listener = listener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            listener.OnLoad("Apply For A Loan", "Initializing applicant info...");
        }

        @Override
        protected MpCreditApp doInBackground(PurchaseInfo... info) {
            try {
                if(!poConn.isDeviceConnected()){
                    message = "Unable to connect.";
                    return null;
                }

                String lsResult = poApp.GetOtherApplicationInfo();

                if(lsResult == null){
                    message = poApp.getMessage();
                    return null;
                }

                JSONObject loJson = new JSONObject(lsResult);

                String lsUnitAppl = info[0].getLsUnitAppl();
                String lsModelIDx = info[0].getLsModelIDx();
                String lsDiscount = info[0].getLsDiscount();
                String lsAmortztn = info[0].getLsAmortztn();
                String lsDownPaym = info[0].getLsDownPaym();
                String lsMiscExps = info[0].getLsMiscExps();
                String lsInstallx = info[0].getLsInstallx();

                MpCreditApp loApp = poApp.ParseData(loJson);

                loApp.setUnitApplied(lsUnitAppl);
                loApp.setModel(lsModelIDx);
                loApp.setUnitType("1");
                loApp.setDiscount(lsDiscount);
                loApp.setDownpayment(lsDownPaym);
                loApp.setAmortization(lsAmortztn);
                loApp.setMiscellaneousExpense(lsMiscExps);
                loApp.setInstallmentTerm(lsInstallx.split(" ")[0]);

                return loApp;
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return null;
            }
        }

        @Override
        protected void onPostExecute(MpCreditApp result) {
            super.onPostExecute(result);
            if(result == null){
                listener.OnFailed(message);
            } else {
                listener.OnSuccess(result);
            }
        }
    }
}
