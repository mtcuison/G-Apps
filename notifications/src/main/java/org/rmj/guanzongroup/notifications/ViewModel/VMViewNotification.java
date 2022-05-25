package org.rmj.guanzongroup.notifications.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.dev.Repositories.RNotificationInfo;

public class VMViewNotification extends AndroidViewModel {
    private static final String TAG = VMViewNotification.class.getSimpleName();
    private final Application instance;
    private final RNotificationInfo poNotif;

    public VMViewNotification(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poNotif = new RNotificationInfo(application);
    }

    public LiveData<DNotifications.ClientNotificationInfo> GetNotificationInfo(String fsMesgID){
        return poNotif.GetNotificationInfo(fsMesgID);
    }
}