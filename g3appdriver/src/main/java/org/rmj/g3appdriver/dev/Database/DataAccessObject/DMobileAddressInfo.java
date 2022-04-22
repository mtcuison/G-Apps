package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import org.rmj.g3appdriver.dev.Database.Entities.EAddressInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EMobileInfo;

import java.util.List;

@Dao
public interface DMobileAddressInfo {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void SaveAddress(EAddressInfo foVal);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void SaveMobile(EMobileInfo foVal);

    @Query("SELECT * FROM Address_Update_Request")
    LiveData<List<EAddressInfo>> GetAddressList();

    @Query("SELECT * FROM Mobile_Update_Request")
    LiveData<List<EMobileInfo>> GetMobileInfo();
}
