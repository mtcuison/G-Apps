package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemablesInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemItemInfo;
import org.rmj.g3appdriver.Database.Repositories.RRedeemablesInfo;

import java.util.List;

public class VMRedeemables extends AndroidViewModel {
    private final static String TAG = VMRedeemables.class.getSimpleName();
    private final RRedeemablesInfo poRedeemx;
    private final RRedeemItemInfo poRedeemItem;
    private final RGcardApp poGcardxx;

    public VMRedeemables(@NonNull Application application) {
        super(application);
        Log.e(TAG, "Initialized.");
        this.poRedeemx = new RRedeemablesInfo(application);
        this.poRedeemItem = new RRedeemItemInfo(application);
        this.poGcardxx = new RGcardApp(application);
    }

    public LiveData<EGcardApp> getGcardInfo() {
        return poGcardxx.getGCardInfo();
    }

    public LiveData<List<ERedeemablesInfo>> getRedeemablesList() {
        return poRedeemx.getRedeemablesList();
    }

    public LiveData<List<DRedeemablesInfo.TransactionOrder>> getTransactionOrderList() {
        return poRedeemx.getTransactionOrderList(poGcardxx.getCardNox());
    }

    public LiveData<Integer> getCartItemCount() {
        return poRedeemItem.getCartItemCount(poGcardxx.getCardNox());
    }

}
