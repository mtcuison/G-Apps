package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EAppEventInfo;

import java.util.List;

@Dao
public interface DAppEventInfo {
    @Insert
    void insert(EAppEventInfo eventInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EAppEventInfo> eventInfoList);

    @Update
    void update(EAppEventInfo eventInfo);
}
