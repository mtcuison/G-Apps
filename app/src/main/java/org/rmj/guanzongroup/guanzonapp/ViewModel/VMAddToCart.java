package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemItemInfo;

import java.util.List;

public class VMAddToCart extends AndroidViewModel {
    private static final String TAG = VMAddToCart.class.getSimpleName();
    private final RGcardApp poGcardxx;
    private final RRedeemItemInfo poItmCart;

    public VMAddToCart(@NonNull Application application) {
        super(application);
        Log.e(TAG, "Initialized.");
        this.poGcardxx = new RGcardApp(application);
        this.poItmCart = new RRedeemItemInfo(application);
    }

    public void insert(ERedeemItemInfo foItem) {
        poItmCart.insert(foItem);
    }

    public void updateItemDetails(String fsGcardNo, String fsPromoId, int fnNewCnt, double fnNewPts) {
        poItmCart.updateItemDetails(fsGcardNo, fsPromoId, fnNewCnt, fnNewPts);
    }

    public LiveData<List<DRedeemItemInfo.ItemDetail>> getExistingItemDetail(String fsPromoId) {
        return poItmCart. getExistingItemDetail(fsPromoId);
    }

    public void deductAvailablePoints(String fsGcardNo, String fsNewPts) {
        poGcardxx.deductAvailablePoints(fsGcardNo, fsNewPts);
    }

}
