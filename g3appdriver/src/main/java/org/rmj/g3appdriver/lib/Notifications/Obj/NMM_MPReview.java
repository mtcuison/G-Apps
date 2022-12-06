package org.rmj.g3appdriver.lib.Notifications.Obj;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.google.firebase.messaging.RemoteMessage;

import org.rmj.g3appdriver.dev.Database.Entities.ENotificationMaster;
import org.rmj.g3appdriver.lib.Notifications.NOTIFICATION_STATUS;
import org.rmj.g3appdriver.lib.Notifications.iNotification;

import java.util.List;

public class NMM_MPReview implements iNotification {
    private static final String TAG = NMM_MPReview.class.getSimpleName();

    private final Context instance;

    private String message;

    public NMM_MPReview(Context instance) {
        this.instance = instance;
    }

    @Override
    public boolean ImportNotifications() {
        return false;
    }

    @Override
    public String Save(RemoteMessage foVal) {
        try{

            return "";
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    @Override
    public boolean SendResponse(String mesgID, NOTIFICATION_STATUS status) {
        try{

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    @Override
    public LiveData<ENotificationMaster> GetNotificationMasterDetail(String fsVal) {
        return null;
    }

    @Override
    public LiveData<List<ENotificationMaster>> GetNotificationList() {
        return null;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
