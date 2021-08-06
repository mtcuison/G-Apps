package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemItemInfo;

import java.util.List;

public class VMItemCart extends AndroidViewModel {
    private static final String TAG = VMItemCart.class.getSimpleName();
    private final RGcardApp poGcardxx;
    private final RRedeemItemInfo poCartItm;
    private final MutableLiveData<String> psGcardNo = new MutableLiveData<>();
    public VMItemCart(@NonNull Application application) {
        super(application);
        Log.e(TAG, "Initialized.");
        this.poGcardxx = new RGcardApp(application);
        this.poCartItm = new RRedeemItemInfo(application);
        this.psGcardNo.setValue(poGcardxx.getCardNox());
    }

    public LiveData<EGcardApp> getGCardInfo() {
        return poGcardxx.getGCardInfo();
    }

    public LiveData<List<DRedeemItemInfo.CartItemsDetail>> getCartItemsDetail() {
        return poCartItm.getCartItemsDetail(psGcardNo.getValue());
    }

    public LiveData<Double> getTotalCartPoints() {
        return poCartItm.getTotalCartPoints(psGcardNo.getValue());
    }

    public void removeItemFromCart(String fsPromoId) {
        poCartItm.removeItemFromCart(fsPromoId);
    }

    public void updateAvailablePoints(String fsGcardNo, String fsNewPts) {
        poGcardxx.updateAvailablePoints(fsGcardNo, fsNewPts);
    }

}
