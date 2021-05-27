package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;

public class PointsManager {

    private GcardAppMaster gCardManager;
    private AppData db;
    private String CardNmbr;
    private String GCardNox;

    public PointsManager(Context context) {
        this.db = AppData.getInstance(context);
        this.gCardManager = new GcardAppMaster(context);
        this.CardNmbr = gCardManager.getCardNumber();
        this.GCardNox = gCardManager.getGCardNox();
    }


    /**Remaining GCard Points indicates the net points of gcar
     * deducting all items on cart and place order items...
     * */
    private double getGCardTotPoints(){
        double points = 0;
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM Gcard_App_Master WHERE sCardNmbr = '"+CardNmbr+"'", null);
        if(cursor.getCount()==0){
            cursor.close();
            return points;
        } else {
            cursor.moveToFirst();
            points = cursor.getDouble(6);
            cursor.close();
        }
        return points;
    }

    private double getOrderPoints(){
        double points = 0;
        Cursor cursor = db.getReadableDb().rawQuery("SELECT SUM(nPointsxx) FROM redeem_item WHERE sGCardNox = '"+ GCardNox +"' AND cTranStat IN ('0', '1')",null);
        if(cursor.getCount()==0){
            return points;
        } else {
            cursor.moveToFirst();
            points = cursor.getDouble(0);
        }
        cursor.close();
        return points;
    }

    public double getRemainingGCardPoints(){
        double cardPoints = getGCardTotPoints();
        double ordrPoints = getOrderPoints();
        double RmngPoints = cardPoints - ordrPoints;
        return RmngPoints;
    }

    public double getCartItemPoints(){
        double points = 0;
        Cursor cursor = db.getReadableDb().rawQuery("SELECT SUM(nPointsxx) FROM redeem_item WHERE cTranStat = '0' AND sGCArdNox = '"+ GCardNox +"'",null);
        if(cursor.getCount()==0){
            return points;
        } else {
            cursor.moveToFirst();
            points = cursor.getDouble(0);
        }
        return points;
    }

    public double getPlaceOrderPoints(){
        double points = 0;
        Cursor cursor = db.getReadableDb().rawQuery("SELECT SUM(nPointsxx) FROM redeem_item WHERE sGCardNox = '"+GCardNox+"' AND cTranStat = '1'",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            points = cursor.getDouble(0);
        }
        cursor.close();
        return points;
    }
}
