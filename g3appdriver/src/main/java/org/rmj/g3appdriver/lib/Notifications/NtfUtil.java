package org.rmj.g3appdriver.lib.Notifications;

import android.content.Context;

public class NtfUtil {
    private static final String TAG = NtfUtil.class.getSimpleName();

    private Context mContext;

    private String message;

    public NtfUtil(Context context) {
        this.mContext = context;
    }

    public boolean CheckNotifications(){
        try{

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }
}
