package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.SQLUtil;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.CartItem;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CartManager {
    private static final String TAG = CartManager.class.getSimpleName();

    private Context mContext;
    private AppData db;
    private GcardAppMaster gcardAppMaster;
    private T_ActionValidator validator;
    private Calendar calendar;

    private String GCardNox = "";

    public CartManager(Context context){
        this.mContext = context;
        this.db = AppData.getInstance(mContext);
        this.gcardAppMaster = new GcardAppMaster(mContext);
        this.calendar = Calendar.getInstance();
        this.validator = new T_ActionValidator(mContext);
        GCardNox = gcardAppMaster.getGCardNox();
    }

    public void add(String PromoID, int Quantity, double ItemPoints, onAddToCartListener listener){
        onAddToCartListener onAddToCartListener = listener;
        try {
            if (!isItemOnCartExisted(PromoID)) {
                if (isDataValid(ItemPoints)) {
                    db.getWritableDb().execSQL("INSERT INTO redeem_item" +
                            "(sTransNox, " +
                            "sGCardNox, " +
                            "sPromoIDx, " +
                            "nItemQtyx," +
                            "nPointsxx, " +
                            "dOrderedx, " +
                            "cTranStat," +
                            "cPlcOrder) " +
                            "VALUES " +
                            "('" + new CodeGenerator().generateTransNox() + "', " +
                            "'" + GCardNox + "', " +
                            "'" + PromoID + "', " +
                            "'" + Quantity + "', " +
                            "'" + ItemPoints + "', " +
                            "'" + SQLUtil.dateFormat(calendar.getTime(), "yyyyMMddHHmmss") + "', " +
                            "'0', " +
                            "'0')");
                    Log.e(TAG, "Redeemable item has been added to cart.");
                    onAddToCartListener.onAddToCartSuccess();
                } else {
                    onAddToCartListener.onAddToCartFailed("Not enough GCard points.");
                }
            } else {
                if (isDataValid(ItemPoints)) {
                    db.getWritableDb().execSQL("UPDATE redeem_item " +
                            "SET nItemQtyx = nItemQtyx + " + Quantity + " ," +
                            "nPointsxx = nPointsxx + " + ItemPoints + " " +
                            "WHERE sPromoIDx = '" + PromoID + "'");
                    Log.e(TAG, "Redeemable item has been added to cart.");
                    onAddToCartListener.onAddToCartSuccess();
                } else {
                    onAddToCartListener.onAddToCartFailed("Not enough GCard points.");
                }
            }
        } catch (Exception e){
            onAddToCartListener.onAddToCartFailed(e.getMessage());
            e.printStackTrace();
        }
    }
    private boolean isDataValid(double itemPoints){
        if(gcardAppMaster.getCardNumber().isEmpty()){
            return false;
        } else return validator.isPointsEnough(itemPoints);
    }

    private boolean isItemOnCartExisted(String sTransNox){
        String[] args = {sTransNox};
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM redeem_item WHERE sPromoIDx = ?", args);
        if(cursor.getCount() > 0){
            cursor.close();
            return true;
        }
        return false;
    }

    private void addQuantityToExistedItem(String TransNox, int Quantity){

    }

    public void removeFromCart(String TransNo){
        GCardNox = gcardAppMaster.getGCardNox();
        db.getWritableDb().execSQL("DELETE FROM redeem_item WHERE sPromoIDx = '" + TransNo + "' AND sGCardNox = '" + GCardNox + "'");
    }

    public int getCartItemCount(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM redeem_item WHERE sGCardNox = '"+GCardNox+ "' AND cTranStat = '0' AND cPlcOrder = '0'", null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

    public List<CartItem> getCartItems(){
        List<CartItem> cartItems = new ArrayList<>();
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM redeem_item a LEFT JOIN tbl_redeemables b ON a.sPromoIDx = b.sTransNox WHERE a.sGCardNox = '"+GCardNox+"' AND a.cTranStat = '0' AND a.cPlcOrder = '0'", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++) {
                CartItem cartItem = new CartItem(cursor.getString(cursor.getColumnIndex("sPromoIDx")),
                        cursor.getString(cursor.getColumnIndex("sPromoDsc")),
                        cursor.getString(cursor.getColumnIndex("nPointsxx")),
                        cursor.getString(cursor.getColumnIndex("nItemQtyx")),
                        cursor.getBlob(cursor.getColumnIndex("sImageUrl")));
                cursor.moveToNext();
                cartItems.add(cartItem);
            }
        }
        cursor.close();
        return cartItems;
    }

    public interface onAddToCartListener{
        void onAddToCartSuccess();
        void onAddToCartFailed(String errorMessage);
    }
}
