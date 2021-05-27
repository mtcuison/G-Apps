package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;

import org.rmj.g3appdriver.dev.AppData;

public class AppUserMaster {

    private AppData db;

    public AppUserMaster(Context context) {
        this.db = AppData.getInstance(context);
    }

    private String getUserInfo(String ColumnName){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM Client_Info_Master", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            String value = cursor.getString(cursor.getColumnIndex(ColumnName));
            cursor.close();
            return value;
        }
        cursor.close();
        return "";
    }

    public String getUserID(){
        return getUserInfo("sUserIDxx");
    }

    public String getUserName(){
        return getUserInfo("sUserName");
    }

    public String getUserEmail(){
        return getUserInfo("sEmailAdd");
    }

    public String getUserRegistrationDate(){
        return getUserInfo("dDateMmbr");
    }

    public String getUserMobileNo(){
        return getUserInfo("sMobileNo");
    }

    public String getDateLogin(){
        return getUserInfo("dLoginxxx");
    }
}
