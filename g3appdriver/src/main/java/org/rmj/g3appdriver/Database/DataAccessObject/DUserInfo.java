package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EUserInfo;

import java.util.List;

@Dao
public interface DUserInfo {

    @Insert
    void insert(EUserInfo eUserInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EUserInfo> eUserInfoList);

    @Update
    void update(EUserInfo eUserInfo);
}
