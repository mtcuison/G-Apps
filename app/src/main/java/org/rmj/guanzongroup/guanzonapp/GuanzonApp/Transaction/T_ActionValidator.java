package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.SQLUtil;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;

import java.util.Calendar;

public class T_ActionValidator {

    private Context context;
    private GcardAppMaster gCardManager;
    private AppData db;
    private PointsManager pointsManager;

    private String GCardNmbr = "";
    private String sGCardNox = "";
    private String BranchCde = "";
    private double GCardPnts = 0.0;
    private double ItmPoints = 0.0;

    public T_ActionValidator(Context context){
        this.context = context;
        this.gCardManager = new GcardAppMaster(context);
        this.db = AppData.getInstance(context);
        this.pointsManager = new PointsManager(context);
    }

    /***********ADD TO CART VALIDATIONS********/

    /** Validate user gcard number first before proceeding...*
     * User must have an Active GCarc number.
     * User must have enough points to pre-order an item.
     * *******************************************************
     * NOTE: Calculation of available points doesn't come from server.
     *  Calculate all total points inside ITEM CART.
     *  Calculate all total place orders.
     *  Add Items on cart and place orders and deduct to the sTotPoints
     *  of Active GCard number...
     */

    /**
     * Set the redeemable item points.*/
    public void setItmPoints(double itmPoints) {
        ItmPoints = itmPoints;
    }

    /**
     * Check all Imported GCard Number first before proceeding.
     * Must disable or Hide Add To Cart Button is NO GCard number is Active.
     * */
    public boolean hasGCardNumber(){
        this.GCardNmbr = gCardManager.getCardNumber();
        if(!GCardNmbr.equalsIgnoreCase("")) {
            this.GCardPnts = Double.parseDouble(gCardManager.getGCardPoints());
            this.sGCardNox = gCardManager.getGCardNox();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Users cannot proceed if GCard points is not enough to order an item.
     * */
    public boolean isPointsEnough(double itemPoints){
        GCardPnts = pointsManager.getRemainingGCardPoints();
        return GCardPnts >= itemPoints;
    }


    /******************PLACE ORDER VALIDATIONS***************/

    /**
     * check if item cart has items
     * */
    public boolean isCartHasItem(){
        sGCardNox = gCardManager.getGCardNox();
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM redeem_item WHERE cTranStat = '0' AND sGCardNox = '"+sGCardNox+"'",null);
        int rowCount = cursor.getCount();
        return rowCount > 0;
    }

    /**
     * check if claiming address is selected.
     * */
    public void setBranchCde(String BrachCode){
        BranchCde = BrachCode;
    }
    public boolean hasSelectedBranch(){
        return !BranchCde.equalsIgnoreCase("");
    }

    /******************CANCEL ORDER VALIDATIONS***************/
    public boolean isOrderCancelable(String BatchNox){
        boolean cancelable = false;
        Calendar dateExp = Calendar.getInstance();
        String dPlacOrdr = "";
        Cursor cursor = db.getReadableDb().rawQuery("SELECT dPlacOrdr FROM redeem_item WHERE sGCardNox = '"+sGCardNox+"' AND sReferNox = '"+BatchNox+"'", null);
        if(cursor.getCount()>0){
            dPlacOrdr = cursor.getString(0);
            dateExp.setTime(SQLUtil.toDate(dPlacOrdr,"yyyyMMddHHmmss"));
            Calendar expDate = Calendar.getInstance();
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                int diff = (int) java.time.Duration.between(expDate.toInstant(), dateExp.toInstant()).toHours();
                cancelable = diff <= -24 || diff >= 24;
            }
        }
        return cancelable;
    }
}
