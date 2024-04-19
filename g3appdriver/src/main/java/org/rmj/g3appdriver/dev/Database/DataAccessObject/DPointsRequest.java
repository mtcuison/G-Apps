package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.room.Dao;
import androidx.room.Insert;
import org.rmj.g3appdriver.dev.Database.Entities.EPointsRequest;

@Dao
public interface DPointsRequest {
    @Insert
    void SaveRequest(EPointsRequest pointsRequest);
}
