package org.rmj.guanzongroup.guanzonapp.etc;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_EventReminder;

import java.io.File;

public class Event_Reminder {
    private static final String TAG = Event_Reminder.class.getSimpleName();

    private AppData db;
    private String PromoWebLink;
    private String EventWebLink;
    private Context mContext;

    public Event_Reminder(Context context){
        this.mContext = context;
        this.db = AppData.getInstance(context);
    }

    public void showPromoEventReminder(){
        if(!getEventID().isEmpty()){
            new Dialog_EventReminder(mContext, getImageThumbnail(getEventID(), false), EventWebLink).showDialog();
        }
        if(!getPromoID().isEmpty()){
            new Dialog_EventReminder(mContext, getImageThumbnail(getPromoID(), true), PromoWebLink).showDialog();
        }
    }

    private String getEventID(){
        String ID = "";
        try {
            Cursor cursor = db.getReadableDb().rawQuery("SELECT sTransNox, sEventURL, MIN(abs(strftime('%s', dEvntFrom) - strftime('%s', 'now'))) AS ClosestDate FROM App_Event_Info", null);
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                ID = cursor.getString(0);
                EventWebLink = cursor.getString(1);
                cursor.close();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ID;
    }

    private String getPromoID(){
        String ID = "";
        try{
            Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_promo_link", null);
            if(cursor.getCount() > 0 ){
                cursor.moveToFirst();
                ID = cursor.getString(0);
                PromoWebLink = cursor.getString(cursor.getColumnIndex("sPromoUrl"));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return ID;
    }

    private Bitmap getImageThumbnail(String TransNox, boolean isPromo){
        String Folder;
        if(isPromo){
            Folder = "Promos";
        } else {
            Folder = "Events";
        }
        File loFilePath = Environment.getExternalStorageDirectory() ;
        File imgFile = new File(loFilePath.getAbsolutePath() + "/Android/data/GuanzonApps/"+Folder+"/" + TransNox + ".png");
        if(imgFile.exists()){
            Bitmap loBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            return loBitmap;
        }
        return null;
    }
}
