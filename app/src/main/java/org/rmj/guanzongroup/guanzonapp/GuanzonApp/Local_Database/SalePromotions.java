package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Events;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Promotions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalePromotions {

    private Cursor cursor;
    private AppData db;
    private List<Promotions> promotions;

    public SalePromotions(Context context) {
        this.db = AppData.getInstance(context);
        promotions = new ArrayList<>();
    }

    public List<Promotions> getPromoList(){
        cursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_promo_link", null);
        if(cursor.getCount() > 0){
            return setPromotions(cursor.getCount());
        } else {
            Promotions promos = new Promotions("https://www.guanzongroup.com.ph/category/promos/",
                    "See more promos at Official Guanzon Group",
                    "",
                    "",
                    "",
                    null);
            promotions.clear();
            promotions.add(promos);
        }
        return promotions;
    }

    private List<Promotions> setPromotions(int PromoCount){
        if(PromoCount <= 4){

            cursor.moveToFirst();
            for (int x = 0; x < cursor.getCount(); x++) {
                Promotions promos = new Promotions("",
                        cursor.getString(4),
                        cursor.getString(3),
                        cursor.getString(6),
                        cursor.getString(5),
                        "");
                promotions.add(promos);
                cursor.moveToNext();
            }
        } else {
            cursor.moveToFirst();
            for (int x = 0; x < cursor.getCount(); x++) {
                Promotions promos = new Promotions("",
                        cursor.getString(4),
                        cursor.getString(3),
                        cursor.getString(6),
                        cursor.getString(5),
                        "");
                promotions.add(promos);
                cursor.moveToNext();
            }
        }

        return promotions;
    }

    public List<Events> getEventList(){
        List<Events> events = new ArrayList<>();
        cursor = db.getReadableDb().rawQuery("SELECT * FROM App_Event_Info", null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++){
                Events event = new Events(cursor.getString(cursor.getColumnIndex("sTransNox")),
                        cursor.getString(cursor.getColumnIndex("sBranchNm")),
                        cursor.getString(cursor.getColumnIndex("sEventTle")),
                        cursor.getString(cursor.getColumnIndex("dEvntFrom")),
                        cursor.getString(cursor.getColumnIndex("dEvntThru")),
                        cursor.getString(cursor.getColumnIndex("sAddressx")),
                        cursor.getString(cursor.getColumnIndex("sEventURL")),
                        cursor.getString(cursor.getColumnIndex("sTransNox")));
                events.add(event);
                cursor.moveToNext();
            }
        }
        return events;
    }

    public void UpdateReadEvent(String TransNox){
        try{
            String[] args = {"1", getDateTime(), TransNox};
            db.getWritableDb().execSQL("UPDATE App_Event_Info SET cNotified = ?, dModified = ? WHERE sTransNox = ?", args);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void UpdateReadPromo(String TransNox){
        try{
            String[] args = {"1", getDateTime(), TransNox};
            db.getWritableDb().execSQL("UPDATE tbl_promo_link SET cNotified = ?, dModified = ? WHERE sTransNox = ?", args);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
}
