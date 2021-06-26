package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Repositories.RBranchInfo;

import java.util.List;

public class VMDashboard extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final RBranchInfo poBranch;
    private MutableLiveData<List<EBranchInfo>> eBranchInfoList;
    public VMDashboard(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poBranch = new RBranchInfo(application);
    }
}
