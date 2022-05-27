package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderDetail;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderMaster;
import org.rmj.g3appdriver.dev.Database.Entities.EOrderDetail;
import org.rmj.g3appdriver.dev.Database.Entities.EOrderMaster;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.ROrder;

import java.util.List;

public class VMOrders extends AndroidViewModel {
    private static final String TAG = VMOrders.class.getSimpleName();

    private final ROrder poORder;

    private final MutableLiveData<String> poStatus = new MutableLiveData<>();

    public VMOrders(@NonNull Application application) {
        super(application);
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

    public LiveData<List<DOrderMaster.OrderHistory>> GetOrderHistoryList(){
        return poORder.GetOrderHistoryList();
    }

    public LiveData<List<DOrderMaster.OrderHistory>> GetOrderHistoryList(String fsVal){
        return poORder.GetOrderHistoryList(fsVal);
    }

    public LiveData<List<DOrderDetail.OrderHistoryDetail>> GetOrderHistoryDetail(String fsVal){
        return poORder.GetOrderHistoryDetail(fsVal);
    }

    public void ImportOrdersTask(){
        new ImportOrdersTask().execute();
    }

    private class ImportOrdersTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            poORder.ImportPurchases();
            return null;
        }
    }

    public LiveData<EOrderMaster> GetOrderMaster(String fsVal){
        return poORder.GetOrderMasterInfo(fsVal);
    }

    public LiveData<List<DOrderDetail.OrderedItemsInfo>> GetOrderedItemsList(String fsVal){
        return poORder.GetOrderedItems(fsVal);
    }
}