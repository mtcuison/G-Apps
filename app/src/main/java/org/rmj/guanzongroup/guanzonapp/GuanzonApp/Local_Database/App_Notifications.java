package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.etc.SessionManager;

public class App_Notifications {

    private Context mContext;
    private AppData db;

    public App_Notifications(Context context){
        this.mContext = context;
        this.db = AppData.getInstance(context);
    }

    public int getUnreadNotificationCount(){
        if(new SessionManager(mContext).isLoggedIn()) {
            return getEventCount() + getPromoCount() + getMessageCount();
        }
        return getPromoCount();
    }

    public int getOrdersCount(){
        String GcardNox = new GcardAppMaster(mContext).getGCardNox();
        String[] args = {GcardNox};
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM redeem_item WHERE sGcardNox = ? AND cTranStat != 0 GROUP BY sReferNox", args);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getEventCount(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM App_Event_Info WHERE cNotified = '0'", null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getPromoCount(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_promo_link WHERE cNotified = '0'", null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public int getMessageCount(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM Notification_Info_Recepient WHERE cMesgStat != '3'", null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
}
