package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;

import org.rmj.g3appdriver.dev.AppData;

public class TransactionPoints {
    private static final String TAG = TransactionPoints.class.getSimpleName();

    private AppData db;
    private GcardAppMaster gcardAppMaster;

    public TransactionPoints(Context context) {
        this.db = AppData.getInstance(context);
        this.gcardAppMaster = new GcardAppMaster(context);
    }

    private double getGCardTotPoints(){
        double points = 0;
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM Gcard_App_Master WHERE sCardNmbr = '"+gcardAppMaster.getCardNumber()+"'", null);
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
        Cursor cursor = db.getReadableDb().rawQuery("SELECT SUM(nPointsxx) FROM redeem_item WHERE sGCardNox = '"+ gcardAppMaster.getGCardNox() +"' AND cTranStat IN ('0', '1')",null);
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
        Cursor cursor = db.getReadableDb().rawQuery("SELECT SUM(nPointsxx) FROM redeem_item WHERE cTranStat = '0' AND sGCArdNox = '"+ gcardAppMaster.getGCardNox() +"'",null);
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
        Cursor cursor = db.getReadableDb().rawQuery("SELECT SUM(nPointsxx) FROM redeem_item WHERE sGCardNox = '"+ gcardAppMaster.getGCardNox() +"' AND cTranStat = '1'",null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            points = cursor.getDouble(0);
        }
        cursor.close();
        return points;
    }
}
