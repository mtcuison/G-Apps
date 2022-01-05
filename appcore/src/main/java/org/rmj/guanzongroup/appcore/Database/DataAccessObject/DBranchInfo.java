package org.rmj.guanzongroup.appcore.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.guanzongroup.appcore.Database.Entities.EBranchInfo;

import java.util.List;

@Dao
public interface DBranchInfo {
    @Insert
    void insert(EBranchInfo branchInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EBranchInfo> branchInfoList);

    @Update
    void update(EBranchInfo branchInfo);

    @Query("SELECT * FROM BranchInfo")
    LiveData<List<EBranchInfo>> getAllBranchs();

    @Query("SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'M%'")
    LiveData<List<EBranchInfo>> getMotorBranches();

    @Query("SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'C%'")
    LiveData<List<EBranchInfo>> getMobileBranches();

}
