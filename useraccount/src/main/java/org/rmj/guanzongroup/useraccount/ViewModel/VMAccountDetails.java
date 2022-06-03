package org.rmj.guanzongroup.useraccount.ViewModel;

import android.app.Application;
import android.os.AsyncTask;
import android.os.PowerManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.dev.Database.Entities.EBarangayInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.ECountryInfo;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.guanzongroup.useraccount.Model.AccountDetailsInfo;

import java.util.ArrayList;
import java.util.List;

public class VMAccountDetails extends AndroidViewModel {
    private static final String TAG = VMAccountDetails.class.getSimpleName();
    private final ConnectionUtil poConnect;
    private final RClientInfo poClientx;
    private final RAddressMobile poAddress;
    private final MutableLiveData<List<AccountDetailsInfo>> poAcctInf = new MutableLiveData<>();

    private final String[] psLstHead = new String[] {
            "Personal Information",
            "Present Address",
            "Account Information"
    };

    public VMAccountDetails(@NonNull Application application) {
        super(application);
        this.poConnect = new ConnectionUtil(application);
        this.poClientx = new RClientInfo(application);
        this.poAddress = new RAddressMobile(application);
    }

    public LiveData<EClientInfo> getClientInfo(){
        return poClientx.getClientInfo();
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

    public void setAccountDetailsList(EClientInfo foClientx) {
        List<AccountDetailsInfo> loAcctInf = new ArrayList<>();
        String lsFullNme = foClientx.getFrstName() + " " + foClientx.getMiddName() + " " + foClientx.getLastName() + " " + foClientx.getSuffixNm();
        String lsGenderx = getGenderList().get(Integer.parseInt(foClientx.getGenderCd()));
        String lsCivilSt = getCivilStatusList().get(Integer.parseInt(foClientx.getCvilStat()));
        String lsAddress = foClientx.getHouseNox() + " " + foClientx.getAddressx();
        loAcctInf.add(new AccountDetailsInfo(true, psLstHead[0], "",""));
        loAcctInf.add(new AccountDetailsInfo(false,"","Full Name", lsFullNme));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Gender", lsGenderx));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Birth Date", foClientx.getBirthDte()));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Birth Place", ""));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Citizen", ""));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Civil Status", lsCivilSt));
        loAcctInf.add(new AccountDetailsInfo(false, "", "Tax ID", foClientx.getTaxIDNox()));

        loAcctInf.add(new AccountDetailsInfo(true, psLstHead[1], "",""));
        loAcctInf.add(new AccountDetailsInfo(false,"","Address", lsAddress));

        loAcctInf.add(new AccountDetailsInfo(true, psLstHead[2], "",""));
        loAcctInf.add(new AccountDetailsInfo(false,"","Email Address", foClientx.getEmailAdd()));
        loAcctInf.add(new AccountDetailsInfo(false,"","Mobile Number", foClientx.getMobileNo()));
        loAcctInf.add(new AccountDetailsInfo(false,"","Password", "CHANGE"));

        poAcctInf.setValue(loAcctInf);
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

    public interface OnTransactionCallBack {
        void onLoading();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
    }


}
