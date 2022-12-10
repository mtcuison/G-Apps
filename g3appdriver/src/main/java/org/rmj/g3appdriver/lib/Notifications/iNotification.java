package org.rmj.g3appdriver.lib.Notifications;

import androidx.lifecycle.LiveData;

import com.google.firebase.messaging.RemoteMessage;

import org.rmj.g3appdriver.dev.Database.Entities.ENotificationMaster;

import java.util.List;

public interface iNotification {

    boolean ImportNotifications();

    String Save(RemoteMessage foVal);

    ENotificationMaster SendResponse(String mesgID, NOTIFICATION_STATUS status);

    LiveData<ENotificationMaster> GetNotificationMasterDetail(String fsVal);

    LiveData<List<ENotificationMaster>> GetNotificationList();

    String getMessage();
}
