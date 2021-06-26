package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EServiceInfo;

import java.util.List;

@Dao
public interface DServiceInfo {

    @Insert
    void insert(EServiceInfo eServiceInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EServiceInfo> eServiceInforInfoList);

    @Update
    void update(EServiceInfo eServiceInforInfo);
}
