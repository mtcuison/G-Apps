package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import org.rmj.g3appdriver.dev.AppData;

public class UserLogout {

    private Context mContext;
    private AppData db;

    public UserLogout(Context context){
        this.mContext = context;
    }

    public void logoutUser(){
        try {
            db = AppData.getInstance(mContext);
            db.getWritableDb().execSQL("DELETE FROM G_Card_Transaction_Ledger");
            db.getWritableDb().execSQL("DELETE FROM GCard_App_Master");
            db.getWritableDb().execSQL("DELETE FROM Mc_Serial_Registration");
            //db.getWritableDb().execSQL("DELETE FROM tbl_notifications");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
