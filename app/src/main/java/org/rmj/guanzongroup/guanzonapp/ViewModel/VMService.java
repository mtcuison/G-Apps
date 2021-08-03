package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.Entities.EServiceInfo;
import org.rmj.g3appdriver.Database.Repositories.RServiceInfo;

public class VMService extends AndroidViewModel {
    private final static String TAG = VMService.class.getSimpleName();
    private final RServiceInfo poService;

    public VMService(@NonNull Application application) {
        super(application);
        this.poService = new RServiceInfo(application);
    }

    public LiveData<EServiceInfo> getActiveServiceInfo() {
        return poService.getActiveServiceInfo();
    }

}
