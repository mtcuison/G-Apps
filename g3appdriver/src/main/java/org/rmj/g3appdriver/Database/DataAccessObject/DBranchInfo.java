package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.EBranchInfo;

import java.util.List;

@Dao
public interface DBranchInfo {
    @Insert
    void insert(EBranchInfo branchInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EBranchInfo> branchInfoList);

    @Update
    void update(EBranchInfo branchInfo);

    @Query("SELECT * FROM tbl_branch")
    LiveData<List<EBranchInfo>> getAllBranchs();

    @Query("SELECT * FROM tbl_branch WHERE sBranchCd LIKE 'M%'")
    LiveData<List<EBranchInfo>> getMotorBranches();

    @Query("SELECT * FROM tbl_branch WHERE sBranchCd LIKE 'C%'")
    LiveData<List<EBranchInfo>> getMobileBranches();

}
