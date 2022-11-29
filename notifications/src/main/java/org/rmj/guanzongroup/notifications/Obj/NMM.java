package org.rmj.guanzongroup.notifications.Obj;

import androidx.lifecycle.LiveData;

import com.google.firebase.messaging.RemoteMessage;

import org.rmj.g3appdriver.dev.Database.Entities.ENotificationMaster;

import java.util.List;

public interface NMM {
    void Save(RemoteMessage args);
    void CreateNotification();
    void SendResponse();
    LiveData<List<ENotificationMaster>> GetNotificationList();
}
