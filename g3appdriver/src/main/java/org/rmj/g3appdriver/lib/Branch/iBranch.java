package org.rmj.g3appdriver.lib.Branch;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;

import java.util.List;

public interface iBranch {
    LiveData<List<EBranchInfo>> GetBranchList();
    LiveData<List<EBranchInfo>> GetBranchList(String Province);
    LiveData<List<EBranchInfo>> GetBranchList(String Province, String Town);
}
