package org.rmj.guanzongroup.useraccount.ViewModel;

import static org.rmj.g3appdriver.utils.CallbackJson.CallbackStatus.FAILED;
import static org.rmj.g3appdriver.utils.CallbackJson.CallbackStatus.SUCCESS;
import static org.rmj.g3appdriver.utils.CallbackJson.parse;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EBarangayInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.ECountryInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EEmailInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EMobileInfo;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.Account.Obj.AccountDetail;
import org.rmj.g3appdriver.lib.Account.Obj.ClientCredentials;
import org.rmj.g3appdriver.lib.Account.Obj.ClientSystem;
import org.rmj.g3appdriver.lib.Account.iClientInfo;
import org.rmj.g3appdriver.lib.GCardCore.CodeGenerator;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.guanzongroup.useraccount.Model.AccountDetailsInfo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VMAccountDetails extends AndroidViewModel {
    private static final String TAG = VMAccountDetails.class.getSimpleName();
    private final Context mContext;
    private iClientInfo mClientSys;
    private final ConnectionUtil poConnect;
    private final RClientInfo poClientx;
    private final RAddressMobile poAddress;

    private  String clientID;
    private final MutableLiveData<List<AccountDetailsInfo>> poAcctInf = new MutableLiveData<>();

    private final String[] psLstHead = new String[] {
            "Personal Information",
            "Address",
            "Account Information"
    };

    public interface ClientInfoTransactionCallback {
        void onLoad();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
    }
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
    public LiveData<EClientInfo> getClientDetail(){
        return poClientx.getLoClient();
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
    public LiveData<String> GetTownProvinceName(String fsTownID){
        return poAddress.ParseTownID(fsTownID);
    }
    public LiveData<String> GetBarangay(String fsBrgyID){
        return poAddress.ParseBrgyID(fsBrgyID);
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
    public void addScannedClientInfo(String args, ClientInfoTransactionCallback foCallBck) {
        new AddScannedClientInfoTask(mClientSys, poConnect, foCallBck).execute(args);
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
//    public void importClientInfo(OnClientInfoCallBack foCallBck) {
//        new ImportClientInfoTask(poConnect, poClientx, foCallBck).execute();
//    }

    public void importClientInfo(String ClientID, String SourceCD, String SourceNo, OnClientInfoCallBack foCallBck) {
        new ImportClientInfoTask(poConnect, poClientx, ClientID,  SourceCD,  SourceNo, foCallBck).execute();
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
            String lsGCashNox = foClientx.getGCashNo();
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
            loAcctInf.add(new AccountDetailsInfo(false, "","GCash No",lsGCashNox));
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
    private static class ImportClientInfoTask extends AsyncTask<Void, Void, String> {

        private final ConnectionUtil loConnect;
        private final RClientInfo loClientx;
        private final OnClientInfoCallBack loCallBck;
        private boolean isSuccess = false;
        private String ClientID,  SourceCD,  SourceNo ;
//        private ImportClientInfoTask(ConnectionUtil foConnect, RClientInfo foClientx, String ClientID, String SourceCD, String SourceNo,OnClientInfoCallBack foCallBck) {
//            this.loConnect = foConnect;
//            this.loClientx = foClientx;
//            this.loCallBck = foCallBck;
//        }

        private ImportClientInfoTask(ConnectionUtil foConnect, RClientInfo foClientx, String clientID, String sourceCD, String sourceNo, OnClientInfoCallBack foCallBck) {
            this.loConnect = foConnect;
            this.loClientx = foClientx;
            this.loCallBck = foCallBck;
            this.ClientID = clientID;
            this.SourceCD = sourceCD;
            this.SourceNo = sourceNo;
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
//                    lsResultx = loClientx.ImportClientDetail(ClientID, SourceCD, SourceNo);
//                    if(!lsResultx.isEmpty()) {
//                        lsResultx = "";
//                        isSuccess = true;
//                    } else {
//                        lsResultx = loClientx.getMessage();
//                    }
                    if(loClientx.ImportClientInfo(ClientID, SourceCD, SourceNo)) {
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
                } else if(lsMobileNo.substring(0, 1).equalsIgnoreCase("09")){
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
    public interface OnClientInfoCallBack {
        void onLoading();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
    }

    public interface OnTransactionCallBack {
        void onLoading();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
    }
    public interface OnSearchCallBack {
        void onLoading();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
    }

    public interface OnRetrieveEmailInfo{
        void OnRetrieve(EEmailInfo args);
    }

    public interface OnRetrieveMobileInfo{
        void OnRetrieve(EMobileInfo args);
    }

    public void GetEmailInfo(String args, OnRetrieveEmailInfo listener){
        new GetEmailTask(listener).execute(args);
    }

    public void GetMobileInfo(String args, OnRetrieveMobileInfo listener){
        new GetMobileTask(listener).execute(args);
    }

    private class GetEmailTask extends AsyncTask<String, Void, EEmailInfo>{

        private final OnRetrieveEmailInfo mListener;

        public GetEmailTask(OnRetrieveEmailInfo mListener) {
            this.mListener = mListener;
        }

        @Override
        protected EEmailInfo doInBackground(String... strings) {
            EEmailInfo loResult = poClientx.GetEmailInfo(strings[0]);
            return loResult;
        }

        @Override
        protected void onPostExecute(EEmailInfo eEmailInfo) {
            super.onPostExecute(eEmailInfo);
            mListener.OnRetrieve(eEmailInfo);
        }
    }

    private class GetMobileTask extends AsyncTask<String, Void, EMobileInfo>{

        private final OnRetrieveMobileInfo mListener;

        public GetMobileTask(OnRetrieveMobileInfo mListener) {
            this.mListener = mListener;
        }

        @Override
        protected EMobileInfo doInBackground(String... strings) {
            EMobileInfo loResult = poClientx.GetMobileInfo(strings[0]);
            return null;
        }

        @Override
        protected void onPostExecute(EMobileInfo eMobileInfo) {
            super.onPostExecute(eMobileInfo);
            mListener.OnRetrieve(eMobileInfo);
        }
    }
//    @Override
//    protected String doInBackground(ClientCredentials... foClientxx) {
//        ClientCredentials loClientxx = foClientxx[0];
//        final String[] lsResult = {""};
//        try {
//            if(poConnect.isDeviceConnected()) {
//                mClientSys.AddGCard(loClientxx, new GCardSystem.GCardSystemCallback() {
//                    @Override
//                    public void OnSuccess(String args) {
//                        try {
//                            JSONObject loDetail = new JSONObject(args);
//                            mClientSys.SaveGCardInfo(loDetail);
//                            mClientSys.DownloadMCServiceInfo(new GCardSystem.GCardSystemCallback() {
//                                @Override
//                                public void OnSuccess(String args) {
//                                    try {
//                                        JSONObject loDetail = new JSONObject(args);
//                                        mClientSys.SaveMcServiceInfo(loDetail);
//                                        lsResult[0] = parse(SUCCESS, "GCard Added Successfully.");
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                        lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
//                                    }
//                                }
//
//                                @Override
//                                public void OnFailed(String message) {
//                                    lsResult[0] = parse(FAILED, message);
//                                }
//                            });
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                            Log.e(ADD_GCARD_TAG, e.getMessage());
//                            lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            Log.e(ADD_GCARD_TAG, e.getMessage());
//                            lsResult[0] = parse(FAILED,ADD_GCARD_TAG + e.getMessage());
//                        }
//                    }
//
//                    @Override
//                    public void OnFailed(String message) {
//                        lsResult[0] = parse(FAILED, message);
//                    }
//
//                });
//            } else {
//                lsResult[0] = parse(FAILED, AppConstants.SERVER_NO_RESPONSE());
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//            Log.e(ADD_GCARD_TAG, e.getMessage());
//            lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
//        }
//        return lsResult[0];
//    }

    private static class AddScannedClientInfoTask extends AsyncTask<String, Void, String> {
        private static final String ADD_GCARD_TAG = AddClientInfoTask.class.getSimpleName();
        private final iClientInfo mClientSys;
        private final ConnectionUtil loConnect;
        private final ClientInfoTransactionCallback loCallbck;

        private AddScannedClientInfoTask(iClientInfo foGcrdSys, ConnectionUtil foConnect, ClientInfoTransactionCallback callBack) {
            this.mClientSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected String doInBackground(String... strings) {
            final String[] lsResult = {""};
            try {
                if(loConnect.isDeviceConnected()) {
                    CodeGenerator loCode = new CodeGenerator();
                    loCode.setEncryptedQrCode(strings[0]);
                    String lsArgs = loCode.getGCardNumber();
                    mClientSys.AddGCardQrCode(lsArgs, new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            try {
                                Thread.sleep(1000);
                                mClientSys.DownloadGcardNumbers(new GCardSystem.GCardSystemCallback() {
                                    @Override
                                    public void OnSuccess(String args) {
                                        try {
                                            JSONObject loDetail = new JSONObject(args);
                                            mClientSys.SaveGCardInfo(loDetail);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
                                        }
                                    }

                                    @Override
                                    public void OnFailed(String message) {
                                        lsResult[0] = parse(FAILED, message);
                                    }
                                });

                                Thread.sleep(1000);
                                mClientSys.DownloadMCServiceInfo(new GCardSystem.GCardSystemCallback() {
                                    @Override
                                    public void OnSuccess(String args) {
                                        try {
                                            JSONObject loDetail = new JSONObject(args);
                                            mClientSys.SaveMcServiceInfo(loDetail);
                                            lsResult[0] = parse(SUCCESS, "GCard Added Successfully.");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
                                        }
                                    }

                                    @Override
                                    public void OnFailed(String message) {
                                        lsResult[0] = parse(FAILED, message);
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e(ADD_GCARD_TAG, e.getMessage());
                                lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(ADD_GCARD_TAG, e.getMessage());
                                lsResult[0] = parse(FAILED,ADD_GCARD_TAG + e.getMessage());
                            }
                        }

                        @Override
                        public void OnFailed(String message) {
                            lsResult[0] = parse(FAILED, message);
                        }

                    });
                } else {
                    lsResult[0] = parse(FAILED, AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(ADD_GCARD_TAG, e.getMessage());
                lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
            }
            return lsResult[0];
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setCallBack(s, loCallbck);
        }
    }

    private static class AddClientInfoTask extends AsyncTask<ClientCredentials, Void, String> {
        private static final String ADD_GCARD_TAG = AddClientInfoTask.class.getSimpleName();
        private final iClientInfo mClientSys;
        private final ConnectionUtil loConnect;
        private final ClientInfoTransactionCallback loCallbck;

        private AddClientInfoTask(iClientInfo foGcrdSys, ConnectionUtil foConnect, ClientInfoTransactionCallback callBack) {
            this.mClientSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected String doInBackground(ClientCredentials... foClientxx) {
            ClientCredentials loClientInfoxx = foClientxx[0];
            final String[] lsResult = {""};
            try {
                if(loConnect.isDeviceConnected()) {
                    mClientSys.AddClientInfo(loClientInfoxx, new ClientSystem.ClientInfoSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            try {
                                JSONObject loDetail = new JSONObject(args);
                                mClientSys.SaveGCardInfo(loDetail);
                                mClientSys.DownloadMCServiceInfo(new GCardSystem.GCardSystemCallback() {
                                    @Override
                                    public void OnSuccess(String args) {
                                        try {
                                            JSONObject loDetail = new JSONObject(args);
                                            mClientSys.SaveMcServiceInfo(loDetail);
                                            lsResult[0] = parse(SUCCESS, "GCard Added Successfully.");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
                                        }
                                    }

                                    @Override
                                    public void OnFailed(String message) {
                                        lsResult[0] = parse(FAILED, message);
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e(ADD_GCARD_TAG, e.getMessage());
                                lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(ADD_GCARD_TAG, e.getMessage());
                                lsResult[0] = parse(FAILED,ADD_GCARD_TAG + e.getMessage());
                            }
                        }

                        @Override
                        public void OnFailed(String message) {
                            lsResult[0] = parse(FAILED, message);
                        }

                    });
                } else {
                    lsResult[0] = parse(FAILED, AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(ADD_GCARD_TAG, e.getMessage());
                lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
            }
            return lsResult[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setCallBack(s, loCallbck);
        }

    }
    private static void setCallBack(String fsResultx, ClientInfoTransactionCallback foCallBck) {
        try {
            JSONObject loJson = new JSONObject(fsResultx);
            String lsStatus =String.valueOf(loJson.get("status"));
            String lsMessage = loJson.getString("message");
            if(lsStatus.equals(SUCCESS.toString())) {
                foCallBck.onSuccess(lsMessage);
            } else if(lsStatus.equals(FAILED.toString())) {
                foCallBck.onFailed(lsMessage);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
