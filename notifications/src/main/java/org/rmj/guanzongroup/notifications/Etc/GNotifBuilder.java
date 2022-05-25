/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.notifications
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:18 PM
 */

package org.rmj.guanzongroup.notifications.Etc;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.RemoteMessage;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.etc.RemoteMessageParser;
import org.rmj.guanzongroup.notifications.Activity.Activity_ViewNotification;
import org.rmj.guanzongroup.notifications.R;

public class GNotifBuilder {

    private final Context context;

    private NotificationManager loManager;

    private static int CHANNEL_ID = 0;

    private static final String CHANNEL_DESC = "DRider Background Sending Data";
    private static final String CHANNEL_NAME = "GRider NTF_Channel";
    private static final String NotificationID = "org.rmj.guanzongroup.ghostrider";

    private static String Title;
    private static String Message;
    private static String MessageID;

    @SuppressLint("StaticFieldLeak")
    private static GNotifBuilder instance;

    private GNotifBuilder(Context context){
        this.context = context;
    }

    public static GNotifBuilder createFirebaseNotification(Context context, RemoteMessage foVal, int fnChannelID) {
        if(instance == null) {
            instance = new GNotifBuilder(context);
        }
        RemoteMessageParser loParser = new RemoteMessageParser(foVal);
        Title = loParser.getDataValueOf("title");
        Message = loParser.getDataValueOf("message");
        MessageID = loParser.getValueOf("transno");
        CHANNEL_ID = fnChannelID;
        return instance;
    }

    public static GNotifBuilder createNotification(Context context, String fsTitle, String fsMessage, int fnChannelID) {
        if(instance == null) {
            instance = new GNotifBuilder(context);
        }
        Title = fsTitle;
        Message = fsMessage;
        CHANNEL_ID = fnChannelID;
        return instance;
    }

    private void initChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(NotificationID, CHANNEL_NAME, importance);
            channel.setDescription(CHANNEL_DESC);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private NotificationCompat.Builder initNotification(){
        Intent notifyIntent = new Intent(context, Activity_ViewNotification.class);
        // Set the Activity to start in a new, empty task
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        if(MessageID != null) {
            notifyIntent.putExtra("id", MessageID);
            notifyIntent.putExtra("title", Title);
            notifyIntent.putExtra("type", "notification");
        }
        // Create the PendingIntent
        PendingIntent notifyPendingIntent = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            notifyPendingIntent = PendingIntent.getActivity(
                    context, 0, notifyIntent, PendingIntent.FLAG_MUTABLE);
        } else {
            notifyPendingIntent = PendingIntent.getActivity(
                    context, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        }
        return new NotificationCompat.Builder(context)
                .setContentIntent(notifyPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setChannelId(NotificationID)
                .setSmallIcon(R.drawable.ic_guanzon_logo)
                .setContentTitle(Title)
                .setContentText(Message);
    }

    public void show(){
        initChannel();
        initNotification();
        loManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        loManager.notify(CHANNEL_ID, initNotification().build());
    }

    public void dismiss(){
        if (loManager != null) {
            loManager.cancel(CHANNEL_ID);
        }
    }
}
