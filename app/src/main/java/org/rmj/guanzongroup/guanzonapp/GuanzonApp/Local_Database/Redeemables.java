package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.rmj.g3appdriver.dev.AppData;

import java.util.ArrayList;

public class Redeemables {
    private static final String TAG = Redeemables.class.getSimpleName();

    private ArrayList<ArrayList> redeemables = new ArrayList<>();
    private ArrayList<String> promoID = new ArrayList<>();
    private ArrayList<String> promoDs = new ArrayList<>();
    private ArrayList<String> promoPt = new ArrayList<>();
    private ArrayList<String> promoFr = new ArrayList<>();
    private ArrayList<String> promoTh = new ArrayList<>();
    private ArrayList<String> PreOrdr = new ArrayList<>();
    private ArrayList<String> Notifyx = new ArrayList<>();
    private ArrayList promoIm = new ArrayList();

    private AppData db;
    private Cursor cursor;

    public Redeemables(Context context) {
        this.db = AppData.getInstance(context);
    }

    private void clearData(){
        redeemables.clear();
        promoID.clear();
        promoDs.clear();
        promoPt.clear();
        promoFr.clear();
        promoTh.clear();
        PreOrdr.clear();
    }

    private void populateRedeemItemsList(){
        clearData();
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_redeemables", null);
        int rowCount = cursor.getCount();
        if(rowCount>0){
            cursor.moveToFirst();
            for(int x = 0; x < rowCount; x++){
                promoID.add(cursor.getString(cursor.getColumnIndex("sTransNox")));
                promoDs.add(cursor.getString(cursor.getColumnIndex("sPromoDsc")));
                promoPt.add(cursor.getString(cursor.getColumnIndex("nPointsxx")));
                promoIm.add(cursor.getBlob(cursor.getColumnIndex("sImageUrl")));
                promoFr.add(cursor.getString(cursor.getColumnIndex("dDateFrom")));
                promoTh.add(cursor.getString(cursor.getColumnIndex("dDateThru")));
                PreOrdr.add(cursor.getString(cursor.getColumnIndex("cPreOrder")));
                Notifyx.add(cursor.getString(cursor.getColumnIndex("cNotified")));
                cursor.moveToNext();
            }
        }
        cursor.close();

        redeemables.add(promoID); //0
        redeemables.add(promoDs); //1
        redeemables.add(promoPt); //2
        redeemables.add(promoFr); //3
        redeemables.add(promoTh); //4
        redeemables.add(PreOrdr); //5
        redeemables.add(promoIm); //6
        redeemables.add(Notifyx); //7
    }

    public ArrayList<ArrayList> getRedeemables(){
        populateRedeemItemsList();
        return redeemables;
    }
}
