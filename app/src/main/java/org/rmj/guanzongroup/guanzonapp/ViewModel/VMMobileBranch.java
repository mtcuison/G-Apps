package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EProvinceInfo;
import org.rmj.g3appdriver.dev.Database.Entities.ETownInfo;
import org.rmj.g3appdriver.lib.Branch.Branches;
import org.rmj.g3appdriver.lib.Branch.GBRANCHES;
import org.rmj.g3appdriver.lib.Branch.iBranch;

import java.util.List;

public class VMMobileBranch extends AndroidViewModel {

    private final iBranch poSys;

    public VMMobileBranch(@NonNull Application application) {
        super(application);
        poSys = new Branches(application).InitBranch(GBRANCHES.MOBILE_PHONE);

    }


    public LiveData<List<EBranchInfo>> getBranchList() {
        return poSys.GetBranchList();
    }

    public LiveData<List<ETownInfo>> getTownList(String args) {
        return poSys.GetTownList(args);
    }

    public LiveData<List<EProvinceInfo>> getProvinceInfo() {
        return poSys.GetProvinceList();
    }

    public LiveData<List<EBranchInfo>> getBranchProvList(String Province) {
        return poSys.GetBranchList(Province);
    }

    public LiveData<List<EBranchInfo>> getBranchProvTownList(String Province, String Town) {
        return poSys.GetBranchList(Province, Town);
    }
}