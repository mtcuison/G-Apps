package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.ImageData;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Promotions;
import org.rmj.guanzongroup.guanzonapp.etc.ImageDownloader;

import java.util.ArrayList;
import java.util.List;

public class AssetDownload {
    private static final String TAG = AssetDownload.class.getSimpleName();

    private AppData db;
    private Context mContext;

    public AssetDownload(Context context){
        this.db = AppData.getInstance(context);
        this.mContext = context;
    }

    public boolean saveBranches(JSONObject jsonResponse){
        try {
            JSONArray jsonArray = jsonResponse.getJSONArray("detail");
            if (jsonArray.length() > 0) {
                String lsSql = "INSERT OR REPLACE INTO tbl_branch(" +
                        "sBranchCd, " +
                        "sBranchNm, " +
                        "sDescript, " +
                        "sAddressx, " +
                        "sContactx, " +
                        "sTelNumbr, " +
                        "sEmailAdd) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                SQLiteStatement loSql = db.getWritableDb().compileStatement(lsSql);
                db.getWritableDb().beginTransaction();
                for (int x = 0; x < jsonArray.length(); x++) {
                    JSONObject jsonDetail = new JSONObject(jsonArray.getString(x));
                    loSql.clearBindings();
                    loSql.bindString(1, jsonDetail.getString("sBranchCD"));
                    loSql.bindString(2, jsonDetail.getString("sBranchNm"));
                    loSql.bindString(3, jsonDetail.getString("sDescript"));
                    loSql.bindString(4, jsonDetail.getString("sAddressx"));
                    loSql.bindString(5, jsonDetail.getString("sTelNumbr"));
                    loSql.bindString(6, jsonDetail.getString("sContactx"));
                    loSql.bindString(7, jsonDetail.getString("sEMailAdd"));
                    loSql.execute();
                }
                db.getWritableDb().setTransactionSuccessful();
                db.getWritableDb().endTransaction();
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveGcard(JSONObject jsonResponse){
        try {
            JSONArray jsonArray = jsonResponse.getJSONArray("detail");
            String lsUserID = db.getUserID();
            if(jsonArray.length()>0){
                String lsSql = "INSERT INTO GCard_App_Master (" +
                        "sGCardNox, " +
                        "sCardNmbr, " +
                        "sUserIDxx, " +
                        "sNmOnCArd, " +
                        "dMemberxx, " +
                        "cCardType, " +
                        "sTotPoint, " +
                        "sAvlPoint, " +
                        "cTranStat, " +
                        "cActvStat, " +
                        "cNotified) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                SQLiteStatement loSql = db.getWritableDb().compileStatement(lsSql);
                db.getWritableDb().beginTransaction();
                for (int x = 0; x < jsonArray.length(); x++){
                    JSONObject jsonDetail = new JSONObject(jsonArray.getString(x));
                    loSql.clearBindings();
                    loSql.bindString(1, jsonDetail.getString("sGCardNox"));
                    loSql.bindString(2, jsonDetail.getString("sCardNmbr"));
                    loSql.bindString(3, lsUserID);
                    loSql.bindString(4, jsonDetail.getString("sNmOnCard"));
                    loSql.bindString(5, jsonDetail.getString("dMemberxx"));
                    loSql.bindString(6, jsonDetail.getString("cCardType"));
                    loSql.bindString(7, jsonDetail.getString("nAvlPoint"));
                    loSql.bindString(8, jsonDetail.getString("nTotPoint"));
                    loSql.bindString(9, jsonDetail.getString("cCardStat"));
                    loSql.bindString(10, "0");
                    loSql.bindString(11, "1");
                    loSql.execute();
                }
                db.getWritableDb().setTransactionSuccessful();
                db.getWritableDb().endTransaction();
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void deleteCurrentGCard(String UserID){
        db.getWritableDb().beginTransaction();
        db.getWritableDb().execSQL("DELETE FROM GCard_App_Master WHERE sUserIDxx = '" + UserID + "'");
        db.getWritableDb().setTransactionSuccessful();
        db.getWritableDb().endTransaction();
        Log.e(TAG, "Gcard number for account: " + UserID + " has been deleted.");
    }

    public boolean savePromos(JSONObject jsonResponse){
        try {
            List<Promotions> promotionsList = new ArrayList<>();
            JSONArray jsonArray = jsonResponse.getJSONArray("detail");
            if(jsonArray.length()>0){
                String lsSql = "INSERT OR REPLACE INTO tbl_promo_link(" +
                        "sTransNox, " +
                        "dTransact, " +
                        "sImageUrl, " +
                        "sPromoUrl, " +
                        "sCaptionx, " +
                        "dDateFrom, " +
                        "dDateThru) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                SQLiteStatement loSql = db.getWritableDb().compileStatement(lsSql);
                db.getWritableDb().beginTransaction();
                for(int x = 0; x < jsonArray.length(); x++){
                    JSONObject jsonDetail = new JSONObject(jsonArray.getString(x));
                    loSql.clearBindings();
                    loSql.bindString(1, jsonDetail.getString("sTransNox"));
                    loSql.bindString(2, jsonDetail.getString("dTransact"));
                    loSql.bindString(3, jsonDetail.getString("sImageURL"));
                    loSql.bindString(4, jsonDetail.getString("sPromoURL"));
                    loSql.bindString(5, jsonDetail.getString("sCaptionx"));
                    loSql.bindString(6, jsonDetail.getString("dDateFrom"));
                    loSql.bindString(7, jsonDetail.getString("dDateThru"));
                    loSql.execute();

                    Promotions promos = new Promotions(jsonDetail.getString("sImageURL"),
                            jsonDetail.getString("sCaptionx"),
                            jsonDetail.getString("sPromoURL"),
                            jsonDetail.getString("dDateFrom"),
                            jsonDetail.getString("dDateThru"),
                            jsonDetail.getString("sTransNox"));
                    promotionsList.add(promos);
                }
                db.getWritableDb().setTransactionSuccessful();
                db.getWritableDb().endTransaction();
                new ImageDownloader(mContext, "Promos").downloadPromoImage(promotionsList);
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveEvents(JSONObject jsonResponse){
        try {
            List<ImageData> imageData = new ArrayList<>();
            JSONArray jsonArray = jsonResponse.getJSONArray("detail");
            if(jsonArray.length()>0){
                String lsSql = "INSERT INTO App_Event_Info(" +
                        "sTransNox, " +
                        "sBranchNm, " +
                        "dEvntFrom, " +
                        "dEvntThru, " +
                        "sEventTle, " +
                        "sAddressx, " +
                        "sEventURL, " +
                        "sImageURL, " +
                        "cNotified) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                SQLiteStatement loSql = db.getWritableDb().compileStatement(lsSql);
                db.getWritableDb().beginTransaction();
                for(int x = 0; x < jsonArray.length(); x++){
                    JSONObject jsonDetail = new JSONObject(jsonArray.getString(x));
                    if(!isEventExists(jsonDetail.getString("sTransNox"))) {
                        loSql.clearBindings();
                        loSql.bindString(1, jsonDetail.getString("sTransNox"));
                        loSql.bindString(2, jsonDetail.getString("sBranchNm"));
                        loSql.bindString(3, jsonDetail.getString("dEvntFrom"));
                        loSql.bindString(4, jsonDetail.getString("dEvntThru"));
                        loSql.bindString(5, jsonDetail.getString("sEventTle"));
                        loSql.bindString(6, jsonDetail.getString("sAddressx"));
                        loSql.bindString(7, jsonDetail.getString("sEventURL"));
                        loSql.bindString(8, jsonDetail.getString("sImageURL"));
                        loSql.bindString(9, "0");
                        loSql.execute();
                        ImageData image = new ImageData(jsonDetail.getString("sTransNox"), jsonDetail.getString("sImageURL"));
                        imageData.add(image);
                    }
                }
                db.getWritableDb().setTransactionSuccessful();
                db.getWritableDb().endTransaction();
                new ImageDownloader(mContext, "Events").downloadEventImage(imageData);
            }
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean isEventExists(String TransNox){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM App_Event_Info WHERE sTransNox = '" + TransNox + "'", null);
        return cursor.getCount() > 0;
    }
}
