package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.rmj.g3appdriver.dev.Database.Entities.EOrderMaster;

@Dao
public interface DOrderMaster {

    @Insert
    void SaveOrderMaster(EOrderMaster foVal);

    @Query("SELECT * FROM MarketPlace_Order_Master WHERE sTransNox=:fsTransNo")
    EOrderMaster CheckOrderMasterIfExist(String fsTransNo);

//    void UpdateMasterRecord();
}
