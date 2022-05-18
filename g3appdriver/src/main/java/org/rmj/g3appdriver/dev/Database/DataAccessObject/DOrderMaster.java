package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
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

    @Query("SELECT COUNT(sTransNox) FROM MarketPlace_Order_Master")
    int CheckIfMasterHasRecord();

    @Query("SELECT dTimeStmp FROM MarketPlace_Order_Detail ORDER BY dTimeStmp DESC LIMIT 1")
    String getMasterLatestTimeStmp();

    @Query("SELECT COUNT(*) FROM MarketPlace_Order_Master")
    LiveData<Integer> GetToPayOrders();
}
