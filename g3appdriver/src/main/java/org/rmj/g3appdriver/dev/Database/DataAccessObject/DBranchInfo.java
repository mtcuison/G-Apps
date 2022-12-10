package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;

import java.util.List;

@Dao
public interface DBranchInfo {

    @Insert
    void insert(EBranchInfo branchInfo);

    @Query("SELECT * FROM BranchInfo")
    LiveData<List<EBranchInfo>> getAllBranchs();

    @Query("SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'M%'")
    LiveData<List<EBranchInfo>> getMotorBranches();

    @Query("SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'C%'")
    LiveData<List<EBranchInfo>> getMobileBranches();

    @Query("SELECT * FROM BranchInfo WHERE sBranchCd=:BranchCde")
    EBranchInfo getBranchIfExist(String BranchCde);

    @Query("SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'C%' AND sProvIDxx =:Province")
    LiveData<List<EBranchInfo>> GetMCBranches(String Province);

    @Query("SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'M%' AND sProvIDxx =:Province AND sTownIDxx =:Town")
    LiveData<List<EBranchInfo>> GetMCBranches(String Province, String Town);

    @Query("SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'C%' AND sProvIDxx =:Province")
    LiveData<List<EBranchInfo>> GetMPBranches(String Province);

    @Query("SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'C%' AND sProvIDxx =:Province AND sTownIDxx =:Town")
    LiveData<List<EBranchInfo>> GetMPBranches(String Province, String Town);

    @Query("UPDATE BranchInfo SET " +
            "sBranchNm =:BranchNm, " +
            "sDescript =:Descript, " +
            "sAddressx =:Addressx, " +
            "sContactx =:Contactx, " +
            "sTelNumbr =:TelNumbr, " +
            "sEmailAdd =:EmailAdd " +
            "WHERE sBranchCd =:BranchCd")
    void UpdateBranchInfo(String BranchCd,
                            String BranchNm,
                            String Descript,
                            String Addressx,
                            String Contactx,
                            String TelNumbr,
                            String EmailAdd);
}
