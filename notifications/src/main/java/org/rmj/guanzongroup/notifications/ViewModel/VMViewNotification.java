package org.rmj.guanzongroup.notifications.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.dev.Repositories.RNotificationInfo;

public class VMViewNotification extends AndroidViewModel {
    private static final String TAG = VMViewNotification.class.getSimpleName();
    private final Application instance;
    private final RNotificationInfo poNotif;

    public VMViewNotification(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poNotif = new RNotificationInfo(application);
    }

    public LiveData<DNotifications.ClientNotificationInfo> GetNotificationInfo(String fsMesgID){
        return poNotif.GetNotificationInfo(fsMesgID);
    }

    public void SendReadResponse(String fsVal){
        new SendReadTask(instance).execute(fsVal);
    }

    private static class SendReadTask extends AsyncTask<String, Void, String>{

        private final Context mContext;

        private boolean isSuccess = false;
        private String message;

        public SendReadTask(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            String fsVal = strings[0];
            RNotificationInfo loNotif = new RNotificationInfo(mContext);
            isSuccess = loNotif.SendReadResponse(fsVal);
            if(!isSuccess){
                message = loNotif.getMessage();
            }
            return null;
        }
    }
}