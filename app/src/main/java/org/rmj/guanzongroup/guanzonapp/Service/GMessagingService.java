package org.rmj.guanzongroup.guanzonapp.Service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.rmj.g3appdriver.dev.Repositories.RNotificationInfo;
import org.rmj.g3appdriver.dev.Repositories.RRawData;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.lib.Notifications.NMM;
import org.rmj.g3appdriver.lib.Notifications.NOTIFICATION_STATUS;
import org.rmj.g3appdriver.lib.Notifications.iNotification;
import org.rmj.guanzongroup.notifications.Etc.GNotifBuilder;
import org.rmj.guanzongroup.notifications.Etc.NotificationUI;
import org.rmj.guanzongroup.notifications.Etc.iNotificationUI;

public class GMessagingService extends FirebaseMessagingService {
    private static final String TAG = GMessagingService.class.getSimpleName();

    private RNotificationInfo poNotif;


    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        new RRawData(GMessagingService.this).SaveNewToken(token);
        new GuanzonAppConfig(GMessagingService.this).setAppToken(token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
//        poNotif = new RNotificationInfo(GMessagingService.this);
//        poNotif.SaveNotification(message);
//        poNotif.SendReceiveResponse(poNotif.getMessageID());
//        GNotifBuilder.createFirebaseNotification(GMessagingService.this, message, 1).show();
        Log.e(TAG, "Message received!");
        iNotification loSys = new NMM(GMessagingService.this).getInstance(message);
        String lsResult = loSys.Save(message);
        if(lsResult == null){
            Log.e(TAG, loSys.getMessage());
            return;
        }

        if(!loSys.SendResponse(lsResult, NOTIFICATION_STATUS.RECEIVED)){
            Log.e(TAG, loSys.getMessage());
            return;
        }

        iNotificationUI loNotif = new NotificationUI(GMessagingService.this).getInstance(message);
        loNotif.CreateNotification();
    }
}
