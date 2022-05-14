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
    void SaveDetailOrder(List<EOrderDetail> foVal);

    @Query("SELECT * FROM MarketPlace_Order_Detail WHERE sTransNox =:fsTransNo")
    LiveData<List<EOrderDetail>> GetOrderDetail(String fsTransNo);
}
