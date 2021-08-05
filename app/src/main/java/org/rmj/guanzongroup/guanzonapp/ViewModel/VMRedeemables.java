package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemablesInfo;
import org.rmj.g3appdriver.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemablesInfo;

import java.util.List;

public class VMRedeemables extends AndroidViewModel {
    private final static String TAG = VMRedeemables.class.getSimpleName();
    private final RRedeemablesInfo poRedeemx;

    private final RGcardApp gcard;
    public VMRedeemables(@NonNull Application application) {
        super(application);
        this.poRedeemx = new RRedeemablesInfo(application);
        this.gcard = new RGcardApp(application);
    }

    public LiveData<Integer> countRedeemables() {
        return poRedeemx.countRedeemables();
    }

    public LiveData<List<ERedeemablesInfo>> getRedeemablesList() {
        return poRedeemx.getRedeemablesList();
    }
    public LiveData<List<DRedeemablesInfo.TransactionOrder>> getTransactionOrderList() {
        return poRedeemx.getTransactionOrderList(gcard.getCardNox());
    }
}
