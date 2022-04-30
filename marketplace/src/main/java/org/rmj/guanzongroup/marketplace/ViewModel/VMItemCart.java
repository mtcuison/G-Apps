package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Repositories.RClientInfo;
import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;

import java.util.ArrayList;
import java.util.List;

public class VMItemCart extends AndroidViewModel {
    private static final String TAG = VMItemCart.class.getSimpleName();

    private final MutableLiveData<List<ItemCartModel>> poItemCart = new MutableLiveData<>();
    private final RClientInfo poClientx;

    public VMItemCart(@NonNull Application application) {
        super(application);
        this.poClientx = new RClientInfo(application);
        generateData();
    }
    private void generateData(){
        ArrayList<ItemCartModel> list = new ArrayList<>();
        ItemCartModel model = new ItemCartModel();
        model.setItemName("Realme 8 (8GB+128GB)");
        model.setItemPrice("₱13,133.00");
        model.setItemQty("1");
        list.add(model);
        ItemCartModel model2 = new ItemCartModel();
        model2.setItemName("Reno 6 5G (8GB+128GB)");
        model2.setItemPrice("₱24,526.00");
        model2.setItemQty("1");
        list.add(model2);
        ItemCartModel model1 = new ItemCartModel();
        model1.setItemName("Realme C25Y (4+128GB)");
        model1.setItemPrice("₱8,677.00");
        model1.setItemQty("1");
        list.add(model1);
        ItemCartModel model3 = new ItemCartModel();
        model3.setItemName("Galaxy S22+ (8+256GB)");
        model3.setItemPrice("₱60,990.00");
        model3.setItemQty("1");
        list.add(model3);
        poItemCart.setValue(list);

    }
    public LiveData<EClientInfo> getClientInfo() {
        return poClientx.getClientInfo();
    }
    public LiveData<List<ItemCartModel>> getData() {
        return poItemCart;
    }
}