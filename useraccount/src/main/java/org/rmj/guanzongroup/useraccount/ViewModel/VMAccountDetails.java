package org.rmj.guanzongroup.useraccount.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.PowerManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EBarangayInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.ECountryInfo;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.guanzongroup.useraccount.Model.AccountDetailsInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VMAccountDetails extends AndroidViewModel {
    private static final String TAG = VMAccountDetails.class.getSimpleName();
    private final Context mContext;
    private final ConnectionUtil poConnect;
    private final RClientInfo poClientx;
    private final RAddressMobile poAddress;
    private final MutableLiveData<List<AccountDetailsInfo>> poAcctInf = new MutableLiveData<>();

    private final String[] psLstHead = new String[] {
            "Personal Information",
            "Address",
            "Account Information"
    };

    public VMAccountDetails(@NonNull Application application) {
        super(application);
        this.mContext = application;
        this.poConnect = new ConnectionUtil(application);
        this.poClientx = new RClientInfo(application);
        this.poAddress = new RAddressMobile(application);
    }

    public LiveData<EClientInfo> getClientInfo(){
        return poClientx.getClientInfo();
    }

    public LiveData<DClientInfo.ClientDetail> GetClientDetailForPreview(){
        return poClientx.GetClientDetailForPreview();
    }

    public ArrayList<String> getGenderList() {
        return poClientx.getGenderList();
    }

    public ArrayList<String> getCivilStatusList() {
        return poClientx.getCivilStatusList();
    }

    public LiveData<List<EBarangayInfo>> getBarangayList(String fsTownID){
        return poAddress.GetBarangayList(fsTownID);
    }

    public LiveData<List<DAddress.oTownObj>> getTownCityList(){
        return poAddress.GetTownList();
    }

    public LiveData<List<ECountryInfo>> getCountryList(){
        return poAddress.GetCountryList();
    }

    public ArrayList<String> getBarangayForInput(List<EBarangayInfo> foList) {
        return poAddress.getBarangayForInput(foList);
    }

    public ArrayList<String> getTownCityForInput(List<DAddress.oTownObj> foList) {
        return poAddress.getTownCityForInput(foList);
    }

    public ArrayList<String> getCountryForInput(List<ECountryInfo> foList) {
        return poAddress.getCountryForInput(foList);
    }

    public LiveData<String> getFullAddress(String fsBrgyIdx) {
        return poAddress.GetFullAddressName(fsBrgyIdx);
    }

    public LiveData<String> getBirthplace(String fsTownIdx) {
        return poAddress.ParseTownID(fsTownIdx);
    }

    public LiveData<List<AccountDetailsInfo>> getAccountDetailsList() {
        return poAcctInf;
    }

    public void importAccountInfo(OnTransactionCallBack foCallBck) {
        new ImportAccountInfoTask(poConnect, poClientx, foCallBck).execute();
    }

    public void completeClientInfo(EClientInfo foClientx, OnTransactionCallBack foCallBck) {
        new CompleteClientInfoTask(poConnect, poClientx, foCallBck).execute(foClientx);
    }

    public void updateAccountInfo(EClientInfo foClientx, OnTransactionCallBack foCallBck) {
        new UpdateAccountInfoTask(poConnect, poClientx, foCallBck).execute(foClientx);
    }

    public void UpdateMobileNo(String fsArgs, OnTransactionCallBack foCallBck){
        new UpdateMobileNoTask(mContext, foCallBck).execute(fsArgs);
    }

    public void UpdateEmailAdd(String fsArgs, OnTransactionCallBack foCallBck){
        new UpdateEmailAddTask(mContext, foCallBck).execute(fsArgs);
    }

    public void setAccountDetailsList(EClientInfo foClientx, String fsAddress, String fsBplacex) {
        try {
            List<AccountDetailsInfo> loAcctInf = new ArrayList<>();
            String lsFullNme = foClientx.getFrstName() + " " + foClientx.getMiddName() + " " + foClientx.getLastName() + " " + foClientx.getSuffixNm();
            String lsGenderx = getGenderList().get(Integer.parseInt(foClientx.getGenderCd()));
            String lsCivilSt = getCivilStatusList().get(Integer.parseInt(foClientx.getCvilStat()));
            loAcctInf.add(new AccountDetailsInfo(true, psLstHead[0], "", ""));
            loAcctInf.add(new AccountDetailsInfo(false, "", "GuanzonApp ID", foClientx.getUserIDxx()));
            loAcctInf.add(new AccountDetailsInfo(false, "", "Full Name", lsFullNme));
            loAcctInf.add(new AccountDetailsInfo(false, "", "Gender", lsGenderx));
            loAcctInf.add(new AccountDetailsInfo(false, "", "Birth Date", getDate(foClientx.getBirthDte())));
            loAcctInf.add(new AccountDetailsInfo(false, "", "Birth Place", fsBplacex));
//            loAcctInf.add(new AccountDetailsInfo(false, "", "Citizen", ""));
            loAcctInf.add(new AccountDetailsInfo(false, "", "Civil Status", lsCivilSt));
//            loAcctInf.add(new AccountDetailsInfo(false, "", "Tax ID", foClientx.getTaxIDNox()));

//            loAcctInf.add(new AccountDetailsInfo(true, psLstHead[1], "", ""));
//            loAcctInf.add(new AccountDetailsInfo(false, "", "Shipping Address", fsAddress));
//            loAcctInf.add(new AccountDetailsInfo(false, "", "Billing Address", fsAddress));

            loAcctInf.add(new AccountDetailsInfo(true, psLstHead[2], "", ""));
            loAcctInf.add(new AccountDetailsInfo(true, "Email Address: " + foClientx.getEmailAdd(), "", ""));
            loAcctInf.add(new AccountDetailsInfo(true, "Mobile Number: " + foClientx.getMobileNo(), "", ""));
            loAcctInf.add(new AccountDetailsInfo(true, "Password", "", "CHANGE"));

            poAcctInf.setValue(loAcctInf);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getDate(String val){
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");
        String formattedDate = null;
        try {
            formattedDate = formatter.format(fromUser.parse(val));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    public String[] getListHeaders() {
        return psLstHead;
    }

    private static class ImportAccountInfoTask extends AsyncTask<Void, Void, String> {

        private final ConnectionUtil loConnect;
        private final RClientInfo loClientx;
        private final OnTransactionCallBack loCallBck;
        private boolean isSuccess = false;

        private ImportAccountInfoTask(ConnectionUtil foConnect, RClientInfo foClientx, OnTransactionCallBack foCallBck) {
            this.loConnect = foConnect;
            this.loClientx = foClientx;
            this.loCallBck = foCallBck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallBck.onLoading();
        }

        @Override
        protected String doInBackground(Void... voids) {
            String lsResultx = "";
            try {
                if(loConnect.isDeviceConnected()) {
                    if(loClientx.ImportAccountInfo()) {
                        lsResultx = "";
                        isSuccess = true;
                    } else {
                        lsResultx = loClientx.getMessage();
                    }
                } else {
                    lsResultx = AppConstants.SERVER_NO_RESPONSE();
                }
            } catch (Exception e) {
                e.printStackTrace();
                lsResultx = e.getMessage();
            }

            return lsResultx;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(isSuccess) {
                loCallBck.onSuccess(s);
            } else {
                loCallBck.onFailed(s);
            }
        }

    }

    private static class CompleteClientInfoTask extends AsyncTask<EClientInfo, Void, String> {

        private final ConnectionUtil loConnect;
        private final RClientInfo loClientx;
        private final OnTransactionCallBack loCallBck;
        private boolean isSuccess = false;

        private CompleteClientInfoTask(ConnectionUtil foConnect, RClientInfo foClientx, OnTransactionCallBack foCallBck) {
            this.loConnect = foConnect;
            this.loClientx = foClientx;
            this.loCallBck = foCallBck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallBck.onLoading();
        }

        @Override
        protected String doInBackground(EClientInfo... eClientInfos) {
            String lsResultx = "";
            EClientInfo loInfo = eClientInfos[0];

            try {
                if(loConnect.isDeviceConnected()) {
                    if(loClientx.CompleteClientInfo(loInfo)) {
                        loClientx.ImportAccountInfo();
                        lsResultx = "Client info completion success";
                        isSuccess = true;
                    } else {
                        lsResultx = loClientx.getMessage();
                    }
                } else {
                    lsResultx = AppConstants.SERVER_NO_RESPONSE();
                }
            } catch (Exception e) {
                e.printStackTrace();
                lsResultx = e.getMessage();
            }

            return lsResultx;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(isSuccess) {
                loCallBck.onSuccess(s);
            } else {
                loCallBck.onFailed(s);
            }
        }
    }

    public void UpdatePassword(String fsOld, String fsNew, String fsNew1, OnTransactionCallBack callBack){
        ArrayList<String> lsParams = new ArrayList<>();
        lsParams.add(fsOld);
        lsParams.add(fsNew);
        lsParams.add(fsNew1);
        new UpdatePasswordTask(mContext, callBack).execute(lsParams);
    }

    private static class UpdatePasswordTask extends AsyncTask<ArrayList<String>, Void, Boolean>{

        private final RClientInfo poClient;
        private final ConnectionUtil poConn;
        private final OnTransactionCallBack callBack;

        private String message;

        public UpdatePasswordTask(Context context, OnTransactionCallBack callBack) {
            this.poClient = new RClientInfo(context);
            this.poConn = new ConnectionUtil(context);
            this.callBack = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callBack.onLoading();
        }

        @Override
        protected Boolean doInBackground(ArrayList<String>... strings) {
            try{
                String lsOld = strings[0].get(0);
                String lsNew = strings[0].get(1);
                String lsNw1 = strings[0].get(2);
                if(!poConn.isDeviceConnected()){
                    message = "Not connected to internet.";
                    return false;
                } else if(poClient.ChangePassword(lsOld, lsNew, lsNw1)){
                    return true;
                } else {
                    message = poClient.getMessage();
                    return false;
                }
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                callBack.onSuccess("Password change successfully.");
            } else {
                callBack.onFailed(message);
            }
        }
    }

    private static class UpdateAccountInfoTask extends AsyncTask<EClientInfo, Void, Boolean> {

        private final ConnectionUtil loConnect;
        private final RClientInfo loClientx;
        private final OnTransactionCallBack loCallBck;

        private String lsMessage = "";

        private UpdateAccountInfoTask(ConnectionUtil foConnect, RClientInfo foClientx,
                                      OnTransactionCallBack foCallBck) {
            this.loCallBck = foCallBck;
            this.loConnect = foConnect;
            this.loClientx = foClientx;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallBck.onLoading();
        }

        @Override
        protected Boolean doInBackground(EClientInfo... eClientInfos) {
            try {
                EClientInfo oClientx = eClientInfos[0];
                if(loConnect.isDeviceConnected()) {
                    if(loClientx.UpdateAccountInfo(oClientx)) {
                        Thread.sleep(1000);
                        if(loClientx.ImportAccountInfo()) {
                            lsMessage = "Personal account details updated successfully.";
                            return true;
                        } else {
                            lsMessage = loClientx.getMessage();
                            return false;
                        }
                    } else {
                        lsMessage = loClientx.getMessage();
                        return false;
                    }
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

    private static class UpdateMobileNoTask extends AsyncTask<String, Void, Boolean>{

        private final RClientInfo poClient;
        private final ConnectionUtil poConn;
        private final OnTransactionCallBack callBack;

        private String message;

        public UpdateMobileNoTask(Context context, OnTransactionCallBack callBack) {
            this.poClient = new RClientInfo(context);
            this.poConn = new ConnectionUtil(context);
            this.callBack = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callBack.onLoading();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try{
                String lsMobileNo = strings[0];
                if(lsMobileNo.trim().isEmpty()){
                    message = "Please enter mobile no.";
                    return false;
                } else if(lsMobileNo.substring(0, 2).equalsIgnoreCase("09")){
                    message = "Mobile number must start with '09'";
                    return false;
                } else if(lsMobileNo.length() != 11) {
                    message = "Mobile number must be 11 characters";
                    return false;
                } else {
                    if (!poConn.isDeviceConnected()) {
                        message = "Not connected to internet.";
                        return false;
                    } else if(poClient.UpdateMobileNo(lsMobileNo)){
                        return true;
                    } else {
                        message = poClient.getMessage();
                        return false;
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                callBack.onSuccess("Your request to update mobile no has been submitted. Please wait for verification.");
            } else {
                callBack.onFailed(message);
            }
        }
    }

    private static class UpdateEmailAddTask extends AsyncTask<String, Void, Boolean>{


        private final RClientInfo poClient;
        private final ConnectionUtil poConn;
        private final OnTransactionCallBack callBack;

        private String message;

        public UpdateEmailAddTask(Context context, OnTransactionCallBack callBack) {
            this.poClient = new RClientInfo(context);
            this.poConn = new ConnectionUtil(context);
            this.callBack = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callBack.onLoading();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try{
                String lsEmailAdd = strings[0];
                if(lsEmailAdd.trim().isEmpty()){
                    message = "Please enter email address";
                    return false;
                } else {
                    if (!poConn.isDeviceConnected()) {
                        message = "Not connected to internet.";
                        return false;
                    } else if(poClient.UpdateEmailAddress(lsEmailAdd)){
                        return true;
                    } else {
                        message = poClient.getMessage();
                        return false;
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean){
                callBack.onSuccess("Your request to update email address has been submitted. Please wait for verification.");
            } else {
                callBack.onFailed(message);
            }
        }
    }

    public interface OnTransactionCallBack {
        void onLoading();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
    }
}
