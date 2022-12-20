package org.rmj.g3appdriver.lib.Branch;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EProvinceInfo;
import org.rmj.g3appdriver.dev.Database.Entities.ETownInfo;

import java.util.List;

public interface iBranch {
    LiveData<List<EBranchInfo>> GetBranchList();
    LiveData<List<ETownInfo>> GetTownList(String args);
    LiveData<List<EProvinceInfo>> GetProvinceList();
    LiveData<List<EBranchInfo>> GetBranchList(String Town);
}
