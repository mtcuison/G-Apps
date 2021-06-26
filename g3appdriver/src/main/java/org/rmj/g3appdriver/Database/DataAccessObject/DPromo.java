package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EPromo;

import java.util.List;

@Dao
public interface DPromo {

    @Insert
    void insert(EPromo ePromo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EPromo> ePromoList);

    @Update
    void update(EPromo ePromo);

    @Query("SELECT * FROM tbl_promo_link")
    LiveData<List<EPromo>> getAllPromo();
}
