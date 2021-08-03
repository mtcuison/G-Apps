package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Repositories.RBranchInfo;

import java.util.List;

public class VMBranches extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final RBranchInfo poBranch;
    private MutableLiveData<List<EBranchInfo>> eBranchInfoList;
    private MutableLiveData<Integer> mobiltek =  new MutableLiveData<>();
    private MutableLiveData<Integer> motor =  new MutableLiveData<>();
    public VMBranches(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poBranch = new RBranchInfo(application);

    }
    public LiveData<List<EBranchInfo>> getAllBranchs(){
        return poBranch.getAllBranchs();
    }
    public LiveData<List<EBranchInfo>> getMotorBranches(){
        return poBranch.getMotorBranches();
    }
    public LiveData<List<EBranchInfo>> getMobileBranches(){
        return poBranch.getMobileBranches();
    }
}
