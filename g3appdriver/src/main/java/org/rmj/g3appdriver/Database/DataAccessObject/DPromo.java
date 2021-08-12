package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EEvents;
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

    @Query("SELECT * FROM Promo_Link_Info")
    LiveData<List<EPromo>> getAllPromo();

    @Query("SELECT * FROM App_Event_Info")
    List<EEvents> getAllPromoForDownloadImg();

    @Query("UPDATE App_Event_Info SET cNotified = '1', dModified =:date WHERE sTransNox =:transNox ")
    void updateReadPromo(String date, String transNox);

    @Query("SELECT COUNT(*) FROM Promo_Link_Info WHERE cNotified = '0'")
    LiveData<Integer> getPromoCount();


    @Query("SELECT EXISTS(SELECT * FROM Promo_Link_Info WHERE sTransNox =:TransNox AND cNotified = '1')")
    boolean getPromoExist(String TransNox);

}
