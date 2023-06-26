package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class VMOrderStatus extends AndroidViewModel {
    private static final String TAG = VMOrderStatus.class.getSimpleName();

    private final Application instance;
//    private final ROrder poOrder;

    public VMOrderStatus(@NonNull Application application) {
        super(application);
        this.instance = application;
//        this.poOrder = new ROrder(instance);
    }

//    public LiveData<EOrderMaster> GetMasterOrderInfo(String fsVal){
//        return poOrder.GetOrderMasterInfo(fsVal);
//    }
//
//    public LiveData<List<EOrderDetail>> GetOrderDetailInfo(String fsVal){
//        return poOrder.GetOrderDetailInfo(fsVal);
//    }
}