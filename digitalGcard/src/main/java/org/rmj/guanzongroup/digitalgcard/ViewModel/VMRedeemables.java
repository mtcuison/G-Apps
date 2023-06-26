package org.rmj.guanzongroup.digitalgcard.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

//import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
//import org.rmj.g3appdriver.dev.Repositories.RRedeemablesInfo;
//import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
//import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

public class VMRedeemables extends AndroidViewModel {
//    private final RClientInfo poClientx;
//    private final RRedeemablesInfo poRedeem;
//    private final iGCardSystem poGCard;
    private final MutableLiveData<Double> poRemainPoints = new MutableLiveData<>();
    public VMRedeemables(@NonNull Application application) {
        super(application);
//        this.poClientx = new RClientInfo(application);
//        this.poRedeem = new RRedeemablesInfo(application);
//        this.poGCard = new GCardSystem(application).getInstance(GCardSystem.CoreFunctions.GCARD);
//        this.poRemainPoints.setValue(poGCard.getRemainingActiveCardPoints());
    }
    public LiveData<Double> getRemainingActiveCardPoints(){
        return poRemainPoints;
    }
//    public LiveData<List<ERedeemablesInfo>> getClientInfo() {
//        return poRedeem.getRedeemablesList();
//    }
}