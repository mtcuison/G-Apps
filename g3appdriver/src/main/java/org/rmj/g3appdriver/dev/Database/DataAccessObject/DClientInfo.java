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

    @Query("SELECT * FROM Client_Info_Master")
    EClientInfo GetUserInfo();

    @Query("SELECT * FROM Client_Info_Master")
    LiveData<EClientInfo> getClientInfo();

    @Query("SELECT sClientID FROM CLIENT_INFO_MASTER")
    String getClientId();

    @Query("DELETE FROM Client_Info_Master")
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
}
