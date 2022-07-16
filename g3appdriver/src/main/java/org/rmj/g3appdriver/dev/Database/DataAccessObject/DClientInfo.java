package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;

import java.util.List;

@Dao
public interface DClientInfo {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EClientInfo eClientInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EClientInfo> eClientInfoList);

    @Update
    void update(EClientInfo eClientInfo);

    @Query("SELECT * FROM Client_Profile_Info")
    EClientInfo GetUserInfo();

    @Query("SELECT * FROM Client_Profile_Info")
    LiveData<EClientInfo> getClientInfo();

    @Query("SELECT sClientID FROM Client_Profile_Info")
    String getClientId();

    @Query("DELETE FROM Client_Profile_Info")
    void LogoutAccount();

    @Query("DELETE FROM GCard_App_Master")
    void LogoutGcard();

    @Query("DELETE FROM MarketPlace_Cart")
    void LogoutItemCart();

    @Query("DELETE FROM G_Card_Transaction_Ledger")
    void LogoutGcardLedger();

    @Query("DELETE FROM Redeem_Item")
    void LogoutRedeemItem();

    @Query("DELETE FROM SERVICE")
    void LogoutServiceInfo();

    @Query("DELETE FROM MC_Serial_Registration")
    void LogoutMCSerial();

    @Query("DELETE FROM MarketPlace_Order_Master")
    void LogoutMasterPurchase();

    @Query("DELETE FROM MarketPlace_Order_Detail")
    void LogoutDetailPurchase();

    @Query("SELECT " +
            "a.sHouseNo1, " +
            "a.sAddress1, " +
            "(SELECT " +
            "sBrgyName " +
            "FROM Barangay_Info " +
            "WHERE sBrgyIDxx = a.sBrgyIDx1) AS sBrgyNme1, " +
            "(SELECT " +
            "sTownName " +
            "FROM Town_Info " +
            "WHERE sTownIDxx = a.sTownIDx1) AS sTownNme1, " +
            "(SELECT " +
            "sProvName " +
            "FROM Province_Info " +
            "WHERE sProvIDxx = (SELECT " +
            "sProvIDxx " +
            "FROM Town_Info " +
            "WHERE sTownIDxx = a.sTownIDx1)) AS sProvNme1, " +
            "a.sHouseNo2, " +
            "a.sAddress2, " +
            "(SELECT " +
            "sBrgyName " +
            "FROM Barangay_Info " +
            "WHERE sBrgyIDxx = a.sBrgyIDx2) AS sBrgyNme2, " +
            "(SELECT " +
            "sTownName " +
            "FROM Town_Info " +
            "WHERE sTownIDxx = a.sTownIDx2) AS sTownNme2, " +
            "(SELECT " +
            "sProvName " +
            "FROM Province_Info " +
            "WHERE sProvIDxx = (SELECT " +
            "sProvIDxx " +
            "FROM Town_Info " +
            "WHERE sTownIDxx = a.sTownIDx2)) AS sProvNme2 " +
            "FROM Client_Profile_Info a")
    LiveData<ClientBSAddress> getClientBSAddress();

    @Query("SELECT a.sHouseNo1 AS sHouseNox, " +
            "a.sAddress1 AS sAddressx, " +
            "a.sBrgyIDx1 AS sBrgyIDxx, " +
            "a.sTownIDx1 AS sTownIDxx, " +
            "(SELECT sBrgyName FROM Barangay_Info WHERE sBrgyIDxx = a.sBrgyIDx1) AS sBrgyName, " +
            "(SELECT sTownName FROM Town_Info WHERE sTownIDxx = a.sTownIDx1) AS sTownName " +
            "FROM Client_Profile_Info a")
    LiveData<oAddressUpdate> GetBillingAddressInfoForUpdate();

    @Query("SELECT a.sHouseNo2 AS sHouseNox, " +
            "a.sAddress2 AS sAddressx, " +
            "a.sBrgyIDx2 AS sBrgyIDxx, " +
            "a.sTownIDx2 AS sTownIDxx, " +
            "(SELECT sBrgyName FROM Barangay_Info WHERE sBrgyIDxx = a.sBrgyIDx2) AS sBrgyName, " +
            "(SELECT sTownName FROM Town_Info WHERE sTownIDxx = a.sTownIDx2) AS sTownName " +
            "FROM Client_Profile_Info a")
    LiveData<oAddressUpdate> GetShippingAddressInfoForUpdate();

    @Query("SELECT * FROM Client_Profile_Info")
    EClientInfo GetClientInfo();

    class ClientBSAddress{
        public String sHouseNo1;
        public String sAddress1;
        public String sBrgyNme1;
        public String sTownNme1;
        public String sProvNme1;
        public String sHouseNo2;
        public String sAddress2;
        public String sBrgyNme2;
        public String sTownNme2;
        public String sProvNme2;
    }

    class oAddressUpdate{
        public String sHouseNox;
        public String sAddressx;
        public String sBrgyIDxx;
        public String sTownIDxx;
        public String sBrgyName;
        public String sTownName;
    }
}
