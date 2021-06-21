package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.AppData;

public class G_AppLocal {
    private static final String TAG = G_AppLocal.class.getSimpleName();

    private AppData db;

    public G_AppLocal(Context context){
        this.db = AppData.getInstance(context);
    }

    public void setupGuanzonAppData() {

        /*Table for Client Information**/
        db.getWritableDb().execSQL("CREATE TABLE IF NOT EXISTS Client_Info_Master(" +
                " sUserIDxx varchar PRIMARY KEY" +
                ", sEmailAdd varchar" +
                ", sUserName varchar" +
                ", dLoginxxx varchar" +
                ", sMobileNo varchar" +
                ", dDateMmbr varchar)");

        /*Table for local data synchronation
         *
         * NOTE: This function is inside the Sync Data button...
         * **/
        db.getWritableDb().execSQL("create table if not exists tbl_user(name varchar PRIMARY KEY, gcard_number varchar, avl_points double, d_modified varchar)");

        /*Table for Gcard Information**/
        db.getWritableDb().execSQL("CREATE TABLE IF NOT EXISTS Gcard_App_Master(" +
                " sCardNmbr varchar PRIMARY KEY" +
                ", sGCardNox varchar " +
                ", sUserIDxx varchar" +
                ", sNmOnCard varchar" +
                ", dMemberxx varchar" +
                ", cCardType varchar" +
                ", sTotPoint double" +
                ", sAvlPoint double" +
                ", cTranStat varchar" +
                ", cActvStat varchar" +
                ", dModified varchar" +
                ", cNotified varchar)");


        /*Table for Promolink*/
        db.getWritableDb().execSQL("CREATE TABLE IF NOT EXISTS tbl_promo_link(" +
                "sTransNox varchar PRIMARY KEY," +
                "dTransact varchar," +
                "sImageUrl varchar," +
                "sImgeByte varchar," +
                "sPromoUrl varchar," +
                "sCaptionx varchar," +
                "dDateFrom varchar," +
                "dDateThru varchar," +
                "cNotified varchar," +
                "cDivision int)");

        /*Table for Branches*/
        db.getWritableDb().execSQL("CREATE TABLE IF NOT EXISTS tbl_branch (" +
                "sBranchCd varchar PRIMARY KEY, " +
                "sBranchNm varchar," +
                "sDescript varchar," +
                "sAddressx varchar," +
                "sContactx varchar," +
                "sTelNumbr varchar," +
                "sEmailAdd varchar)");

        db.getWritableDb().execSQL("CREATE TABLE IF NOT EXISTS MC_Serial_Registration (" +
                "sSerialID varchar PRIMARY KEY," +
                "sGCardNox varchar," +
                "sEngineNo varchar," +
                "sFrameNox Varchar," +
                "sModelNme varchar," +
                "sFSEPStat varchar," +
                "cRegStatx varchar)");

        /*Table for Service*/
        db.getWritableDb().execSQL("CREATE TABLE IF NOT EXISTS tbl_service(" +
                "sGCardNox varchar, " +
                "sSerialID varchar, " +
                "sEngineNo varchar, " +
                "sFrameNox varchar, " +
                "sBrandNme varchar, " +
                "sModelNme varchar, " +
                "cFSEPStat varchar, " +
                "dPurchase varchar, " +
                "nYellowxx int," +
                "nWhitexxx int," +
                "nYlwCtrxx int," +
                "nWhtCtrxx int," +
                "dLastSrvc varchar," +
                "nMIlAgexx int," +
                "dNxtRmnds  varchar)");

        /*Table for Transaction*/
        db.getWritableDb().execSQL("CREATE TABLE IF NOT EXISTS G_Card_Transaction_Ledger (" +
                "sReferNox varchar PRIMARY KEY " +
                ",sGCardNox varchar " +
                ",nEntryNox int " +
                ",dTransact varchar " +
                ",sSourceDs varchar " +
                ",sTranType varchar " +
                ",sTranDesc varchar " +
                ",sSourceNo varchar" +
                ",nPointsxx double" +
                ",cQRCodexx varchar" +
                ",cReceived varchar)");

        /*Table for Redeemable  Items*/
        db.getWritableDb().execSQL("CREATE TABLE IF NOT EXISTS tbl_redeemables (" +
                "sTransNox varchar PRIMARY KEY, " +
                "sPromoCde varchar,  " +
                "sPromoDsc varvhar, " +
                "nPointsxx double," +
                "sImageUrl varchar," +
                "cPreOrder varchar," +
                "dDateFrom  varchar, " +
                "dDateThru  varchar," +
                "cNotified varchar)");

        /*Table for Redeem Items*/
        db.getWritableDb().execSQL("CREATE TABLE IF NOT EXISTS redeem_item(" +
                "sPromoIDx varchar PRIMARY KEY," +
                "sBatchNox varchar, " +
                "sTransNox varchar, " +
                "sGCardNox varchar, " +
                "nItemQtyx int, " +
                "nPointsxx double, " +
                "sBranchCd varchar, " +
                "sReferNox varchar, " +
                "dOrderedx  varchar, " +
                "dPlacOrdr  varchar, " +
                "dPickupxx  varchar, " +
                "cTranStat varchar," +
                "cPlcOrder varchar," +
                "cNotified varchar)");

        db.getWritableDb().execSQL("CREATE TABLE IF NOT EXISTS App_Event_Info(" +
                "sTransNox varchar PRIMARY KEY," +
                "sBranchNm varhcar," +
                "dEvntFrom  varchar," +
                "dEvntThru  varchar," +
                "sEventTle varchar," +
                "sAddressx varchar," +
                "sEventURL varchar," +
                "sImageURL varchar," +
                "cNotified varchar," +
                "dModified varchar)");
    }

    /**
     * GET client id
     */
    public String getClientID(){
        return getEmployeeInfo("sClientID");
    }
    /**
     * GET branch code
     */
    public String getBranchCode(){
        return getEmployeeInfo("sBranchCD");
    }
    /**
     * GET branch name
     */
    public String getBranchName(){
        return getEmployeeInfo("sBranchNm");
    }
    /**
     * GET the log number of the user
     */
    public String getLogNumber(){
        return getEmployeeInfo("sLogNoxxx");
    }
    /**
     * GET the user id of the user
     */
    public String getUserID(){
        return getEmployeeInfo("sUserIDxx");
    }
    /**
     * GET the email address of the user
     */
    public String getEmailAddress(){
        return getEmployeeInfo("sEmailAdd");
    }
    /**
     * GET the username of the client
     */
    public String getUserName(){
        return getEmployeeInfo("sUserName");
    }
    /**
     * GET the client id
     */
    public String getUserLevel(){
        return getEmployeeInfo("nUserLevl");
    }
    /**
     * GET the department id of the client
     */
    public String getDepartmentID(){
        return getEmployeeInfo("sDeptIDxx");
    }
    /**
     * GET the position id of the client
     */
    public String getPositionID(){
        return getEmployeeInfo("sPositnID");
    }
    /**
     * GET the employee level id of the client
     */
    public String getEmpLevelID(){
        return getEmployeeInfo("sEmpLevID");
    }
    /**
     * GET if the client is allowed to update records
     */
    public String getAllowUpdate(){
        return getEmployeeInfo("cAllowUpd");
    }
    /**
     * GET the date login of the client
     */
    public String getDateLogin(){
        return getEmployeeInfo("dLoginxxx");
    }
    /**
     * QUERY to get the client information
     */
    private String getEmployeeInfo(String fsFieldNme){
        Cursor loCursor = db.getReadableDb().rawQuery("SELECT * FROM User_Info_Master", null);
        int lnRow = loCursor.getCount();

        if (lnRow <= 0){
            return "";
        } else {
            loCursor.moveToFirst();
            return loCursor.getString(loCursor.getColumnIndex(fsFieldNme));
        }
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

    public boolean savePromos(JSONObject jsonResponse){
        try {
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
            if(jsonArray.length()>0){
                String lsUserID = getUserID();
                String lsSql = "INSERT OR REPLACE INTO GCard_App_Master (" +
                        "sUserIDxx, " +
                        "sGCardNox, " +
                        "sCardNmbr, " +
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
                    loSql.bindString(1, lsUserID);
                    loSql.bindString(2, jsonDetail.getString("sGCardNox"));
                    loSql.bindString(3, jsonDetail.getString("sCardNmbr"));
                    loSql.bindString(4, jsonDetail.getString("sNmOnCard"));
                    loSql.bindString(5, jsonDetail.getString("cCardType"));
                    loSql.bindString(6, jsonDetail.getString("dMemberxx"));
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
}
