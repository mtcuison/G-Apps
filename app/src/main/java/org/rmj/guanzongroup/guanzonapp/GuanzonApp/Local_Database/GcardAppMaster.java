package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import org.rmj.g3appdriver.dev.AppData;

import java.util.ArrayList;

public class GcardAppMaster {
    private static final String TAG = GcardAppMaster.class.getSimpleName();

    private AppData db;

    public GcardAppMaster(Context context) {
        this.db = AppData.getInstance(context);
    }

    private String getGCardInfo(String ColumnName){
        String GCardInfo = "";
        try {
            Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM GCard_App_Master WHERE cActvStat = '1'", null);
            int rowCount = cursor.getCount();
            if (rowCount > 0) {
                cursor.moveToFirst();
                GCardInfo = cursor.getString(cursor.getColumnIndex(ColumnName));
                cursor.close();
                return GCardInfo;
            }
            cursor.close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return GCardInfo;
    }
    /**
     *
     * @return returns GCARD points
     */
    public String getGCardPoints(){ return getGCardInfo("sAvlPoint"); }
    /**
     *
     * @return returns GCARD Number
     */
    public String getCardNumber(){ return getGCardInfo("sCardNmbr"); }

    /**
     *
     * @return Get the local GCard Nox
     */
    public String getGCardNox(){ return getGCardInfo("sGCardNox"); }

    /**
     *
     * @return Get the local GCard Number
     */
    public String getGCardNm(){ return getGCardInfo("sNmOnCard"); }

    /**
     *
     * @return Get the date of the last request of points on a GCard
     */
    public String getLastUpdate(){ return getGCardInfo("dModified"); }

    /**
     *
     * @return Get the Total points on a selected active GCard
     */
    public String getCardTotPts(){ return getGCardInfo("sTotPoint"); }

    public int getGCardCount(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM GCard_App_Master", null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public ArrayList<ArrayList<String>> getAllGCardNumber(){
        ArrayList<String> CardNmbr = new ArrayList<>();
        ArrayList<String> CardName = new ArrayList<>();
        ArrayList<String> CardPnts = new ArrayList<>();
        ArrayList<String> isNewCrd = new ArrayList<>();
        ArrayList<ArrayList<String>> GcardList= new ArrayList<>();

        Cursor cursor = db.getReadableDb().rawQuery("SELECT sCardNmbr, sNmOnCard, sTotPoint, cNotified FROM GCard_App_Master WHERE cActvStat != '1'", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++){
                CardNmbr.add(cursor.getString(cursor.getColumnIndex("sCardNmbr")));
                CardName.add(cursor.getString(cursor.getColumnIndex("sNmOnCard")));
                CardPnts.add(cursor.getString(cursor.getColumnIndex("sTotPoint")));
                isNewCrd.add(cursor.getString(cursor.getColumnIndex("cNotified")));
                cursor.moveToNext();
            }
            GcardList.add(CardNmbr);
            GcardList.add(CardName);
            GcardList.add(CardPnts);
            GcardList.add(isNewCrd);
        }
        cursor.close();
        return GcardList;
    }

    public void replaceActiveGcardSetNew(String GcardNumber){
        db.getWritableDb().beginTransaction();
        db.getWritableDb().execSQL("UPDATE GCard_App_Master SET cActvStat = 0 WHERE sCardNmbr IN (SELECT sCardNmbr FROM GCard_App_Master WHERE cActvStat = '1') ");
        db.getWritableDb().execSQL("UPDATE GCard_App_Master SET cActvStat = 1 WHERE sCardNmbr = '"+GcardNumber+"'");
        db.getWritableDb().setTransactionSuccessful();
        db.getWritableDb().endTransaction();
    }

    public void setAsOneActiveGCard(){
        db.getWritableDb().beginTransaction();
        db.getWritableDb().execSQL("UPDATE GCard_App_Master SET cActvStat = '1'");
        db.getWritableDb().setTransactionSuccessful();
        db.getWritableDb().endTransaction();
        Log.e(TAG, "Gcard has been activate automatically.");
    }

    public boolean hasMultipleGCard(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM GCard_App_Master", null);
        if(cursor.getCount()>1){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    public boolean hasNoGcard(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM GCard_App_Master WHERE cActvStat = 1", null);
        if((cursor.getCount()==0)){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }

    public boolean hasUnCheckGCard(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM GCard_App_Master WHERE cNotified = '0'", null);
        if(cursor.getCount()>0){
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }
}
