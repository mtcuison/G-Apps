package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;


import org.rmj.g3appdriver.Database.Entities.ERedeemablesInfo;

import java.util.List;

@Dao
public interface DRedeemablesInfo {

    @Insert
    void insert(ERedeemablesInfo redeemablesInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<ERedeemablesInfo> redeemablesInfoList);

    @Update
    void update(ERedeemablesInfo redeemablesInfo);
}
