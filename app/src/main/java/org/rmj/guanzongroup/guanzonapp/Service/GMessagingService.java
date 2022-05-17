package org.rmj.guanzongroup.guanzonapp.Service;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.rmj.g3appdriver.dev.Repositories.RNotificationInfo;
import org.rmj.g3appdriver.dev.Repositories.RRawData;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;

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
        poNotif = new RNotificationInfo(GMessagingService.this);
        poNotif.SaveNotification(message);
        poNotif.SendResponse(poNotif.getMessageID());
        Log.e(TAG, "Message received!");
    }
}
