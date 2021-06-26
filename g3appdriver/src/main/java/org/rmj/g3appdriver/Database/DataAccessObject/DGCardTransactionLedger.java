package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;

import java.util.List;

@Dao
public interface DGCardTransactionLedger {
    
    @Insert
    void insert(EGCardTransactionLedger egCardTransactionLedger);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EGCardTransactionLedger> egCardTransactionLedgerList);

    @Update
    void update(EGCardTransactionLedger egCardTransactionLedger);
}
