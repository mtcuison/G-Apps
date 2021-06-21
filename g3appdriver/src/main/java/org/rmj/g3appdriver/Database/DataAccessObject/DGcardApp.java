package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;

import java.util.List;

@Dao
public interface DGcardApp {

    @Insert
    void insert(EGcardApp gcardApp);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EGcardApp> gcardAppList);

    @Update
    void update(EGcardApp gcardApp);

    @Query("SELECT * FROM GCard_App_Master WHERE cActvStat = '1'")
    LiveData<EGcardApp> getGCardInfo();
}
