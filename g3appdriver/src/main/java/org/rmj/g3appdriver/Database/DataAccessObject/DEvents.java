package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EEvents;

import java.util.List;

@Dao
public interface DEvents {

    @Insert
    void insert(EEvents events);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EEvents> events);

    @Update
    void update(EEvents events);

    @Query("SELECT * FROM App_Event_Info")
    LiveData<List<EEvents>> getAllEvents();

//    @Query("SELECT * FROM App_Event_Info")
//    LiveData<List<EEvents>> getAllEvents();

    @Query("UPDATE App_Event_Info SET cNotified = '1', dModified =:date WHERE sTransNox =:transNox ")
    void updateReadEvent(String date, String transNox);



}
