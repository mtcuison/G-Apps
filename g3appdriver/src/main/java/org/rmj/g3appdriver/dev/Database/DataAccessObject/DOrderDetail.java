package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.rmj.g3appdriver.dev.Database.Entities.EOrderDetail;

import java.util.List;

@Dao
public interface DOrderDetail {

    @Insert
    void SaveDetailOrder(EOrderDetail foVal);

    @Query("SELECT * FROM MarketPlace_Order_Detail WHERE sTransNox =:fsTransNo")
    LiveData<List<EOrderDetail>> GetOrderDetail(String fsTransNo);

    @Query("SELECT COUNT(sTransNox) FROM MarketPlace_Order_Detail")
    int CheckIfDetailHasRecord();

    @Query("SELECT dTimeStmp FROM MarketPlace_Order_Detail ORDER BY dTimeStmp DESC LIMIT 1")
    String getDetailLatestTimeStmp();
}
