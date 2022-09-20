package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderDetail;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderMaster;
import org.rmj.g3appdriver.dev.Database.Entities.EOrderDetail;
import org.rmj.g3appdriver.dev.Database.Entities.EOrderMaster;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.etc.ConnectionUtil;

import java.util.List;

public class VMOrders extends AndroidViewModel {
    private static final String TAG = VMOrders.class.getSimpleName();

    private final Context mContext;
    private final ROrder poORder;

    private final MutableLiveData<String> poStatus = new MutableLiveData<>();

    public VMOrders(@NonNull Application application) {
        super(application);
        this.mContext = application;
        this.poORder = new ROrder(application);
        this.poStatus.setValue("");
    }

    public void setOrderStatusFilter(String fsVal){
        this.poStatus.setValue(fsVal);
    }

    public LiveData<String> GetOrderStatusFilter(){
        return poStatus;
    }

    public LiveData<List<EOrderMaster>> GetMasterOrderHistory(String fsVal){
        return poORder.GetMasterOrderHistory(fsVal);
    }

    public LiveData<List<EOrderMaster>> GetMasterOrderHistory(){
        return poORder.GetMasterOrderHistory();
    }

    public LiveData<List<EOrderDetail>> GetOrderDetailInfo(String fsVal){
        return poORder.GetOrderDetailInfo(fsVal);
    }

    public LiveData<List<DOrderMaster.OrderHistory>> GetOrderHistoryList() {
        return poORder.GetOrderHistoryList();
    }

    public LiveData<List<DOrderMaster.OrderHistory>> GetOrderHistoryList(String fsVal) {
        return poORder.GetOrderHistoryList(fsVal);
    }

    public LiveData<List<DOrderMaster.OrderHistory>> GetToPayOrderList() {
        return poORder.GetToPayOrderList();
    }

    public LiveData<List<DOrderDetail.OrderHistoryDetail>> GetOrderHistoryDetail(String fsVal) {
        return poORder.GetOrderHistoryDetail(fsVal);
    }

    public void ImportOrdersTask() {
        new ImportOrdersTask().execute();
    }

    private class ImportOrdersTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            ConnectionUtil loConnect = new ConnectionUtil(mContext);
            if(loConnect.isDeviceConnected()) {
                Log.d(TAG, "Importing purchase info.");
                poORder.ImportPurchases();
            }
            return null;
        }
    }

    public LiveData<EOrderMaster> GetOrderMaster(String fsVal){
        return poORder.GetOrderMasterInfo(fsVal);
    }

    public LiveData<List<DOrderDetail.OrderedItemsInfo>> GetOrderedItemsList(String fsVal){
        return poORder.GetOrderedItems(fsVal);
    }

    public LiveData<Integer> GetToPayOrdersCount(){
        return poORder.GetToPayOrdersCount();
    }
    public LiveData<Integer> GetProcessingOrdersCount(){
        return poORder.GetProcessingOrdersCount();
    }
    public LiveData<Integer> GetToShipOrdersCount(){
        return poORder.GetToShipOrdersCount();
    }
    public LiveData<Integer> GetDeliveredOrdersCount(){
        return poORder.GetDeliveredOrdersCount();
    }
    public LiveData<Integer> GetCancelledOrdersCount(){
        return poORder.GetCancelledOrdersCount();
    }

    public LiveData<DOrderMaster.DetailedOrderHistory> GetDetailOrderHistory(String fsVal){
        return poORder.GetDetailOrderHistory(fsVal);
    }

    public interface OnCheckCancellationCallback {
        void OnCheck(String dTransact, String sClientNm, String sRemarksx);
        void OnFailed(String message);
    }

    public void CheckCancellationDetail(String fsArgs, OnCheckCancellationCallback callback){
        new CheckCancellationTask(callback).execute(fsArgs);
    }

    private class CheckCancellationTask extends AsyncTask<String, Void, Boolean>{

        private final OnCheckCancellationCallback callback;

        private JSONObject loData;
        private String message;

        public CheckCancellationTask(OnCheckCancellationCallback callback) {
            this.callback = callback;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            ConnectionUtil loConnect = new ConnectionUtil(mContext);
            if(loConnect.isDeviceConnected()) {
                if (poORder.ImportCancellationDetail(strings[0])) {
                    loData = poORder.getData();
                    return true;
                } else {
                    message = poORder.getMessage();
                    return false;
                }
            } else {
                message = "Unable to connect";
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean) {
                try {
                    String dTransact = loData.getString("dTransact");
                    String sClientNm = loData.getString("sModified");
                    String sRemarksx = loData.getString("sRemarksx");
                    callback.OnCheck(dTransact, sClientNm, sRemarksx);
                } catch (Exception e){
                    e.printStackTrace();
                    callback.OnFailed(e.getMessage());
                }
            } else {
                callback.OnFailed(message);
            }
        }
    }

    public interface OnCancelCallback{
        void OnLoad();
        void OnSuccess(String args);
        void OnFailed(String message);
    }

    public void CancelOrder(String fsOrderID, String fsRemarks, OnCancelCallback callback){
        new CancelOrderTask(fsOrderID, callback).execute(fsRemarks);
    }

    private class CancelOrderTask extends AsyncTask<String, Void, Boolean>{

        private final String fsOrderID;
        private final OnCancelCallback callback;

        private String message;

        public CancelOrderTask(String fsOrderID, OnCancelCallback callback) {
            this.fsOrderID = fsOrderID;
            this.callback = callback;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.OnLoad();
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try{
                if(poORder.CancelOrder(fsOrderID, strings[0])){
                    return true;
                } else {
                    message = poORder.getMessage();
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
                callback.OnSuccess("Order cancelled");
            } else {
                callback.OnFailed(message);
            }
        }
    }
}