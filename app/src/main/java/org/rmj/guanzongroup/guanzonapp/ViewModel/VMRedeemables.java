package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemablesInfo;

import java.util.List;

public class VMRedeemables extends AndroidViewModel {
    private final static String TAG = VMRedeemables.class.getSimpleName();
    private final RGcardApp poGcardxx;
    private final RRedeemablesInfo poRedeemx;

    public VMRedeemables(@NonNull Application application) {
        super(application);
        Log.e(TAG, "Initialized.");
        this.poGcardxx = new RGcardApp(application);
        this.poRedeemx = new RRedeemablesInfo(application);
    }

    public LiveData<EGcardApp> getGcardInfo() {
        return poGcardxx.getGCardInfo();
    }

    public LiveData<List<ERedeemablesInfo>> getRedeemablesList() {
        return poRedeemx.getRedeemablesList();
    }
}
