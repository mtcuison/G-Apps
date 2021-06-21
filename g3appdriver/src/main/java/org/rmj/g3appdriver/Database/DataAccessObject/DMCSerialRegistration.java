package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Entities.EMCSerialRegistration;

import java.util.List;

@Dao
public interface DMCSerialRegistration {

    @Insert
    void insert(EMCSerialRegistration emcSerialRegistration);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EMCSerialRegistration> emcSerialRegistrationList);

    @Update
    void update(EMCSerialRegistration emcSerialRegistration);
}
