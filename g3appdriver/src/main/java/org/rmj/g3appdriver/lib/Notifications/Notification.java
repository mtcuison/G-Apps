package org.rmj.g3appdriver.lib.Notifications;

import android.content.Context;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;

import java.util.List;

public class Notification {
    private static final String TAG = Notification.class.getSimpleName();

    private final Context mContext;

    private final DNotifications poDao;

    public Notification(Context context) {
        this.mContext = context;
        this.poDao = GGC_GuanzonAppDB.getInstance(context).NotificationDao();
    }

    public LiveData<List<DNotifications.UserNotificationInfo>> GetNotifications(){
        return poDao.getUserNotificationList();
    }

    public LiveData<List<DNotifications.UserNotificationInfo>> GetPromotions(){
        return poDao.getPromotionsNotifications();
    }

    public LiveData<List<DNotifications.UserNotificationInfo>> GetPanaloNotice(){
        return poDao.getPanaloNotifications();
    }
}
