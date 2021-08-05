package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemItemInfo;

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

    public void updateGcardPoints(EGcardApp foGcard) {
        poGcardxx.update(foGcard);
    }

    public void insert(ERedeemItemInfo foItem) {
        poItmCart.insert(foItem);
    }
}
