package org.rmj.guanzongroup.panalo.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import org.rmj.g3appdriver.dev.Database.Entities.EPanaloReward;
import org.rmj.g3appdriver.lib.Panalo.GPanalo;

public class VMPanaloDashboard extends AndroidViewModel {
    private static final String TAG = VMPanaloDashboard.class.getSimpleName();

    private final GPanalo poSys;

    public VMPanaloDashboard(@NonNull Application application) {
        super(application);
        this.poSys = new GPanalo(application);
    }

    public LiveData<EPanaloReward> GetPanaloNotice(){
        return poSys.GetPanaloNotice();
    }


}