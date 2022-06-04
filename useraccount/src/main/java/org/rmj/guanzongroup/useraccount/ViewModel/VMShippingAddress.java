package org.rmj.guanzongroup.useraccount.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.dev.Database.Entities.EBarangayInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.guanzongroup.useraccount.Model.ShippingInfoModel;

import java.util.ArrayList;
import java.util.List;

public class VMShippingAddress extends AndroidViewModel {

    private final RClientInfo poClientx;
    private final RAddressMobile poAddress;
    private final ConnectionUtil poConnect;

    public VMShippingAddress(@NonNull Application application) {
        super(application);
        this.poClientx = new RClientInfo(application);
        this.poAddress = new RAddressMobile(application);
        this.poConnect = new ConnectionUtil(application);
    }

    public LiveData<EClientInfo> getClientInfo() {
        return poClientx.getClientInfo();
    }

    public LiveData<List<DAddress.oTownObj>> getTownCityList(){
        return poAddress.GetTownList();
    }

    public ArrayList<String> getTownCityForInput(List<DAddress.oTownObj> foList) {
        return poAddress.getTownCityForInput(foList);
    }
    public LiveData<List<EBarangayInfo>> getBarangayList(String fsTownID){
        return poAddress.GetBarangayList(fsTownID);
    }

    public ArrayList<String> getBarangayForInput(List<EBarangayInfo> foList) {
        return poAddress.getBarangayForInput(foList);
    }

    public void addShippingAddress(ShippingInfoModel foInfoMdl, OnTransactionCallBack foCallBck) {
        new AddShippingAddressTask(poAddress, poConnect, foCallBck).execute(foInfoMdl);
    }

    private static class AddShippingAddressTask extends AsyncTask<ShippingInfoModel, Void, Boolean> {

        private final RAddressMobile loAddress;
        private final ConnectionUtil loConnect;
        private final OnTransactionCallBack loCallBck;
        private String lsMessage = "";

        private AddShippingAddressTask(RAddressMobile foAddress, ConnectionUtil foConnnect,
                                       OnTransactionCallBack foCallBck) {
            this.loAddress = foAddress;
            this.loConnect = foConnnect;
            this.loCallBck = foCallBck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallBck.onLoading();
        }

        @Override
        protected Boolean doInBackground(ShippingInfoModel... infoModels) {
            try {
                ShippingInfoModel infoModel = infoModels[0];
                if(loConnect.isDeviceConnected()) {
                    // TODO: Add shipping address
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

    public interface OnTransactionCallBack {
        void onLoading();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
    }

}
