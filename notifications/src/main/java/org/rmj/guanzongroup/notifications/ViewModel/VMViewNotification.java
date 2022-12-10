package org.rmj.guanzongroup.notifications.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.dev.Repositories.RNotificationInfo;
import org.rmj.g3appdriver.lib.Notifications.NMM;
import org.rmj.g3appdriver.lib.Notifications.NOTIFICATION_STATUS;
import org.rmj.g3appdriver.lib.Notifications.iNotification;

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

    public void SendReadResponse(String args, String args1){
        new SendReadTask(instance).execute(args, args1);
    }

    private static class SendReadTask extends AsyncTask<String, Void, Boolean>{

        private final Context mContext;
        private iNotification loSys;

        private boolean isSuccess = false;
        private String message;

        public SendReadTask(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            String lsMesgID = strings[0];
            String lsMesgTP = strings[1];
            this.loSys = new NMM(mContext).getInstance(lsMesgTP);
            if(loSys.SendResponse(lsMesgID, NOTIFICATION_STATUS.READ) == null){
                message = loSys.getMessage();
                return false;
            }
            return true;
        }

        @Override
        protected void onPostExecute(Boolean isSuccess) {
            super.onPostExecute(isSuccess);
            if(!isSuccess){
                Log.e(TAG, message);
            } else {
                Log.d(TAG, "Response sent!");
            }
        }
    }
}