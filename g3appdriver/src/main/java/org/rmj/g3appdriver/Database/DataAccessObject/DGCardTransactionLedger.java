package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;

import java.util.List;

@Dao
public interface DGCardTransactionLedger {
    
    @Insert
    void insert(EGCardTransactionLedger egCardTransactionLedger);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EGCardTransactionLedger> egCardTransactionLedgerList);

    @Update
    void update(EGCardTransactionLedger egCardTransactionLedger);

    @Query("DELETE FROM G_Card_Transaction_Ledger")
    void deleteGCardTrans();

    @Query("SELECT * FROM G_Card_Transaction_Ledger " +
            "WHERE sGCardNox =:GCardNox " +
            "AND sSourceDs = 'REDEMPTION'" +
            "OR sSourceDs = 'PREORDER'")
    LiveData<List<EGCardTransactionLedger>> getRedemptionTransactionsList(String GCardNox);

    @Query("SELECT * FROM G_Card_Transaction_Ledger " +
            "WHERE sGCardNox =:GCardNox")
    LiveData<List<EGCardTransactionLedger>> getAllTransactionsList(String GCardNox);

    @Query("SELECT * FROM G_Card_Transaction_Ledger " +
            "WHERE sGCardNox =:GCardNox " +
            "AND sSourceDs = 'ONLINE' " +
            "OR sSourceDs = 'OFFLINE'")
    LiveData<List<EGCardTransactionLedger>> getPointsEntryTransactionsList(String GCardNox);

    @Query("SELECT COUNT(sReferNox) FROM G_Card_Transaction_Ledger WHERE "  +
                "sGCardNox =:gcardNo AND " +
                "sSourceDs =:srcedsc AND " +
                "sReferNox =:referno AND " +
                "sTranDesc =:trandsc AND " +
                "sSourceNo =:srcenox AND " +
                "nPointsxx =:pointsx ")
    LiveData<Integer> isTransactionValid(String gcardNo, String srcedsc, String referno, String trandsc, String srcenox, String pointsx);

}
