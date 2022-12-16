package org.rmj.guanzongroup.panalo.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import org.rmj.g3appdriver.dev.Database.Entities.EPanaloReward;
import org.rmj.g3appdriver.dev.Database.Entities.EPromo;
import org.rmj.g3appdriver.lib.Panalo.GPanalo;
import org.rmj.g3appdriver.lib.Promotions.GPromos;

import java.util.List;

public class VMPanalo extends AndroidViewModel {

    private final GPromos poPromos;
    private final GPanalo poSys;

    public VMPanalo(@NonNull Application application) {
        super(application);
        this.poPromos = new GPromos(application);
        this.poSys = new GPanalo(application);
    }
    // TODO: Implement the ViewModel

    public LiveData<List<EPromo>> getPromotions(){
        return poPromos.GetPromotions();
    }

    public LiveData<EPanaloReward> GetPanaloNotice(){
        return poSys.GetPanaloNotice();
    }
}