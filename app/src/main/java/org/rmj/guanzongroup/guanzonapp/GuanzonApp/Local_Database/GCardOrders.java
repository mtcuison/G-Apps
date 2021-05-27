package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.OrderItems;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.TransactionOrder;

import java.util.ArrayList;
import java.util.List;

public class GCardOrders {

    private Context mContext;
    private AppData db;
    private GcardAppMaster gcardAppMaster;
    private String GCardNox = "";

    private List<TransactionOrder> transactionOrderList;
    private List<OrderItems> orderItemsList;

    public GCardOrders(Context context){
        this.mContext = context;
        this.db = AppData.getInstance(mContext);
        this.gcardAppMaster = new GcardAppMaster(mContext);
        this.GCardNox = gcardAppMaster.getGCardNox();
        transactionOrderList = new ArrayList<>();
        orderItemsList = new ArrayList<>();
    }

    public List<TransactionOrder> getTransactionOrderList(){
        Cursor cursor = db.getReadableDb().rawQuery(
                "SELECT c.sReferNox, c.dOrderedx, b.sBranchNm, b.sAddressx, SUM(c.nPointsxx) " +
                    "FROM redeem_item c " +
                    "LEFT JOIN tbl_branch b ON c.sBranchCd = b.sBranchCd " +
                    "LEFT JOIN tbl_redeemables a ON a.sTransNox = c.sPromoIDx " +
                    "WHERE c.sGCardNox = '"+GCardNox+"' " +
                    "AND c.cPlcOrder = '1' " +
                    "AND c.cTranStat = '1' " +
                    "GROUP BY c.sReferNox;", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++){
                TransactionOrder order = new TransactionOrder(
                        cursor.getString(cursor.getColumnIndex("sReferNox")),
                        cursor.getString(4),
                        cursor.getString(cursor.getColumnIndex("sBranchNm")),
                        cursor.getString(cursor.getColumnIndex("sAddressx")),
                        cursor.getString(cursor.getColumnIndex("dOrderedx")));
                transactionOrderList.add(order);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return transactionOrderList;
    }

    public List<OrderItems> getOrderItems(String ReferNox){
        String lsSQL = "SELECT " +
                "a.sPromoIDx, " +
                "b.sPromoDsc, " +
                "a.nItemQtyx, " +
                "a.nPointsxx " +
                "FROM redeem_item a " +
                "LEFT JOIN tbl_redeemables b " +
                "ON a.sPromoIDx = b.sTransNox " +
                "WHERE a.cTranStat = '1' " +
                "AND a.cPlcOrder = '1' " +
                "AND a.sGCardNox = '"+GCardNox+"'" +
                "AND a.sReferNox = '"+ReferNox+"'";


        Cursor cursor = db.getReadableDb().rawQuery(lsSQL, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++){
                OrderItems orderItems = new OrderItems(
                        cursor.getString(cursor.getColumnIndex("sPromoDsc")),
                        cursor.getString(cursor.getColumnIndex("nItemQtyx")),
                        cursor.getString(cursor.getColumnIndex("nPointsxx")));
                orderItemsList.add(orderItems);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return orderItemsList;
    }
}
