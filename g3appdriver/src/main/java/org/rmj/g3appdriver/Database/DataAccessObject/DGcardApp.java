package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EGcardApp;

import java.util.List;

@Dao
public interface DGcardApp {

    @Insert
    void insert(EGcardApp gCardApp);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EGcardApp> gCardAppList);

    @Update
    void update(EGcardApp gCardApp);

    @Query("DELETE FROM GCard_App_Master")
    void deleteGCard();

    @Query("SELECT * FROM GCard_App_Master")
    LiveData<EGcardApp> getGCardInfo();

    @Query("SELECT sCardNmbr FROM GCard_App_Master WHERE cActvStat = '1'")
    String getActiveGcardNo();
}
