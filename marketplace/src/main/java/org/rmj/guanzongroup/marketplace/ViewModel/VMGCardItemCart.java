package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RGcardApp;
import org.rmj.g3appdriver.etc.ItemCartModel;

import java.util.ArrayList;
import java.util.List;

public class VMGCardItemCart extends AndroidViewModel {
    private static final String TAG = VMMPItemCart.class.getSimpleName();

    private final MutableLiveData<List<ItemCartModel>> poItemCart = new MutableLiveData<>();
    private final RClientInfo poClientx;
    private final RGcardApp poGCard;

    public VMGCardItemCart(@NonNull Application application) {
        super(application);
        this.poClientx = new RClientInfo(application);
//        generateData();
        this.poGCard = new RGcardApp(application);
    }
    public LiveData<List<ItemCartModel>> getGCardItemCart(){
        ArrayList<ItemCartModel> itemList = new ArrayList<>();
        poItemCart.setValue(itemList);
        return poItemCart;
    }
}