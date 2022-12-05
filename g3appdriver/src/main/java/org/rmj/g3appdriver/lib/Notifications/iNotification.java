package org.rmj.g3appdriver.lib.Notifications;

import androidx.lifecycle.LiveData;

import com.google.firebase.messaging.RemoteMessage;

import org.rmj.g3appdriver.dev.Database.Entities.ENotificationMaster;

import java.util.List;

public interface iNotification {

    String Save(RemoteMessage foVal);

    boolean SendResponse(String val);

    boolean CreateNotification(String title, String message);

    LiveData<ENotificationMaster> GetNotificationMasterDetail(String fsVal);

    LiveData<List<ENotificationMaster>> GetNotificationList();

    String getMessage();
}
