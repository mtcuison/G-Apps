package org.rmj.guanzongroup.guanzonapp.Services;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.rmj.guanzongroup.g3msg_notifylib.Builder.NotificationBuilder;
import org.rmj.guanzongroup.g3msg_notifylib.Utils.DataParser;
import org.rmj.guanzongroup.g3msg_notifylib.Utils.Validator;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Notifications;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.TokenStorage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        TokenStorage tokenStorage = new TokenStorage(MyFirebaseMessagingService.this);
        tokenStorage.saveToken(s);
        Log.e(TAG, "Firebase token has been acquired. Token value : " + s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        try {
            NotificationBuilder builder = new NotificationBuilder(MyFirebaseMessagingService.this, remoteMessage);

            DataParser dataParser = new DataParser(remoteMessage);
            if (new Validator(MyFirebaseMessagingService.this, remoteMessage).VALID_NOTIFICATION()) {
                builder.setIntent(new Intent(MyFirebaseMessagingService.this, Activity_DashBoard.class));
                builder.CreateNotification();
            }
            try {
                new Activity_DashBoard().getInstance().refreshTabBadge();
                new Fragment_Notifications().getInstance().refreshBadges();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
