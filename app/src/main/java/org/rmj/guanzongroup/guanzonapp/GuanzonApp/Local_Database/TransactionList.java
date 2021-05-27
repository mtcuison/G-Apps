package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.All_Transactions;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionList {

    private Context mContext;
    private List<Transactions> transactionsList;
    private List<All_Transactions> allTransactionsList;
    private AppData db;

    private String GCardNox;

    public TransactionList(Context context){
        this.mContext = context;
        this.GCardNox = new GcardAppMaster(mContext).getGCardNox();
    }

    public List<All_Transactions> getAllTransactionsList(){
        db = AppData.getInstance(mContext);
        allTransactionsList = new ArrayList<>();
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM G_Card_Transaction_Ledger " +
                "WHERE sGCardNox = '"+GCardNox+"'", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++){
                All_Transactions all_transactions = new All_Transactions(
                        cursor.getString(cursor.getColumnIndex("sReferNox")),
                        cursor.getString(cursor.getColumnIndex("sSourceDs")),
                        cursor.getString(cursor.getColumnIndex("nPointsxx")),
                        cursor.getString(cursor.getColumnIndex("dTransact")));
                allTransactionsList.add(all_transactions);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return allTransactionsList;
    }

    public List<Transactions> getPointsEntryTransactionsList(){
        db = AppData.getInstance(mContext);
        transactionsList = new ArrayList<>();
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM G_Card_Transaction_Ledger " +
                "WHERE sGCardNox = '"+GCardNox+"' " +
                "AND sSourceDs = 'ONLINE' " +
                "OR sSourceDs = 'OFFLINE'", null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++){
                Transactions onlinePoints = new Transactions(
                        cursor.getString(cursor.getColumnIndex("dTransact")),
                        cursor.getString(cursor.getColumnIndex("nPointsxx")),
                        cursor.getString(cursor.getColumnIndex("sReferNox")),
                        cursor.getString(cursor.getColumnIndex("sSourceDs")));
                transactionsList.add(onlinePoints);
            }
        }
        cursor.close();
        return transactionsList;
    }

    public List<Transactions> getRedemptionTransactionsList(){
        db = AppData.getInstance(mContext);
        transactionsList = new ArrayList<>();
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM G_Card_Transaction_Ledger " +
                "WHERE sGCardNox = '"+GCardNox+"' " +
                "AND sSourceDs = 'REDEMPTION'" +
                "OR sSourceDs = 'PREORDER'", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++){
                Transactions redemptions = new Transactions(
                        cursor.getString(cursor.getColumnIndex("dTransact")),
                        cursor.getString(cursor.getColumnIndex("nPointsxx")),
                        cursor.getString(cursor.getColumnIndex("sReferNox")),
                        cursor.getString(cursor.getColumnIndex("sSourceDs")));
                transactionsList.add(redemptions);
            }
        }
        cursor.close();
        return transactionsList;
    }
}
