package org.rmj.guanzongroup.notifications.Obj;

import static org.rmj.g3appdriver.lib.Notifications.Constants.NotificationID;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import org.rmj.guanzongroup.notifications.R;

import java.util.Date;

public class PanaloNotification implements iNotificationUI{
    private static final String TAG = PanaloNotification.class.getSimpleName();

    private final Context mContext;

    private final NotificationManager loManager;

    private static final String CHANNEL_NAME = "Guanzon Panalo";
    private static final String CHANNEL_DESC = "Guanzon connect rewards notification for panalo participants.";

    public PanaloNotification(Context context) {
        this.mContext = context;
        this.loManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public void CreateNotification(Intent landingActivity, String title, String message) {
        try{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                int importance = NotificationManager.IMPORTANCE_DEFAULT;
                NotificationChannel channel = new NotificationChannel(NotificationID, CHANNEL_NAME, importance);
                channel.setDescription(CHANNEL_DESC);
                // Register the channel with the system; you can't change the importance
                // or other notification behaviors after this
                NotificationManager notificationManager = mContext.getSystemService(NotificationManager.class);
                notificationManager.createNotificationChannel(channel);
            }

            PendingIntent notifyPendingIntent = null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                notifyPendingIntent = PendingIntent.getActivity(
                        mContext, 0, landingActivity, PendingIntent.FLAG_MUTABLE);
            } else {
                notifyPendingIntent = PendingIntent.getActivity(
                        mContext, 0, landingActivity, PendingIntent.FLAG_UPDATE_CURRENT);
            }

            Notification.Builder loBuilder = new Notification.Builder(mContext)
                    .setContentIntent(notifyPendingIntent)
                    .setPriority(Notification.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setSmallIcon(R.drawable.ic_guanzon_logo)
                    .setContentTitle(title)
                    .setContentText(message);

            int lnChannelID = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);

            loManager.notify(lnChannelID, loBuilder.build());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
