/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:18 PM
 */

package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.dev.Database.Entities.EMcCategory;

import java.util.List;

@Dao
public interface DMcCategory {

    @Insert
    void insert(EMcCategory mcCategory);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insetBulkData(List<EMcCategory> categories);

    @Update
    void update(EMcCategory mcCategory);

    @Query("SELECT * FROM MC_Category WHERE sMcCatIDx =:fsVal")
    EMcCategory GetMcCategory(String fsVal);

    @Query("SELECT * FROM MC_Category ORDER BY dTimeStmp DESC LIMIT 1")
    EMcCategory GetLatestMcCategory();

    @Query("SELECT * FROM MC_Category")
    LiveData<List<EMcCategory>> getAllMcCategory();

    @Query("SELECT MAX(dTimeStmp) FROM MC_Category")
    String getLatestDataTime();
}
