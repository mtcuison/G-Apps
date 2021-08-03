package org.rmj.guanzongroup.g3msg_notifylib.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.Database.Repositories.RNotificationInfo;

import java.util.List;

public class VMNotificationList extends AndroidViewModel {

    private final RNotificationInfo poNotification;
    private final LiveData<List<DNotifications.UserNotificationInfo>> userNotificationList;

    public VMNotificationList(@NonNull Application application) {
        super(application);
        this.poNotification = new RNotificationInfo(application);
        this.userNotificationList = poNotification.getUserNotificationList();
    }

    public LiveData<List<DNotifications.UserNotificationInfo>> getUserNotificationList() {
        return userNotificationList;
    }
}
