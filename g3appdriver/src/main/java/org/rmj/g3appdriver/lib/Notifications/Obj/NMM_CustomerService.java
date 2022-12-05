package org.rmj.g3appdriver.lib.Notifications.Obj;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.google.firebase.messaging.RemoteMessage;

import org.rmj.g3appdriver.dev.Database.Entities.ENotificationMaster;
import org.rmj.g3appdriver.lib.Notifications.iNotification;

import java.util.List;

public class NMM_CustomerService implements iNotification {
    private static final String TAG = NMM_CustomerService.class.getSimpleName();

    private final Context instance;

    private String message;

    public NMM_CustomerService(Context instance) {
        this.instance = instance;
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
    public boolean SendResponse(String val) {
        try{

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    @Override
    public boolean CreateNotification(String title, String message) {
        try{

            return true;
        } catch (Exception e){
            e.printStackTrace();
            this.message = e.getMessage();
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