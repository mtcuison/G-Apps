package org.rmj.guanzongroup.guanzonapp.Services;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.rmj.g3appdriver.Database.Entities.ETokenInfo;
import org.rmj.g3appdriver.Database.Repositories.AppTokenManager;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.guanzongroup.g3msg_notifylib.Builder.NotificationBuilder;
import org.rmj.guanzongroup.g3msg_notifylib.Utils.DataParser;
import org.rmj.guanzongroup.g3msg_notifylib.Utils.Validator;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_DashBoard;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        AppTokenManager poToken = new AppTokenManager(getApplication());
        ETokenInfo loToken = new ETokenInfo();
        loToken.setTokenInf(s);
        poToken.setTokenInfo(loToken);
        AppData.getInstance(MyFirebaseMessagingService.this).setAppToken(s);
//        Log.e(TAG, "Firebase token has been acquired. Token value : " + s);
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

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
