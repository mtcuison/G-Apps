package org.rmj.guanzongroup.digitalgcard.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.guanzongroup.appcore.GCardCore.GCardSystem;
import org.rmj.guanzongroup.appcore.GCardCore.iGCardSystem;

public class VMGcardSystem extends AndroidViewModel {
    private static final String TAG = VMGcardSystem.class.getSimpleName();
    private final GCardSystem poGcrdSys;

    public VMGcardSystem(@NonNull Application application) {
        super(application);
        Log.e(TAG, "Initialized.");
        this.poGcrdSys = new GCardSystem(application);
    }

    public iGCardSystem getInstance(GCardSystem.CoreFunctions foCore) {
        return poGcrdSys.getInstance(foCore);
    }



}
