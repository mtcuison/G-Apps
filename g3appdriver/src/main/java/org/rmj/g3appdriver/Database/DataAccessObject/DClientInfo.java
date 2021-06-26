package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EClientInfo;

import java.util.List;

@Dao
public interface DClientInfo {
    @Insert
    void insert(EClientInfo eClientInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EClientInfo> eClientInfoList);

    @Update
    void update(EClientInfo eClientInfo);

    @Query("SELECT * FROM Client_Info_Master")
    LiveData<EClientInfo> getClientInfo();
}
