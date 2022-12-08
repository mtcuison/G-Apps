package org.rmj.g3appdriver.dev.Database.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "Panalo_Reward")
public class EPanaloReward {

    @ColumnInfo(name = "sPanaloCD")
    private String PanaloCD;
    private String cTranStat;
    private String dModified;
    private String dTimeStmp;
}
