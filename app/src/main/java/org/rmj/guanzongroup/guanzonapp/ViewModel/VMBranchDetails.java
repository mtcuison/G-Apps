package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.dev.Repositories.RBranchInfo;

import java.util.List;

public class VMBranchDetails extends AndroidViewModel {
    private final RBranchInfo poBranchx;

    public VMBranchDetails(@NonNull Application application) {
        super(application);
        this.poBranchx = new RBranchInfo(application);
    }

    public LiveData<List<EBranchInfo>> getMotorBranches() {
        return poBranchx.getMotorBranches();
    }

    public LiveData<List<EBranchInfo>> getMobileBranches() {
        return poBranchx.getMobileBranches();
    }

}
