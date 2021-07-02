package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.Repositories.RBranchInfo;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;

import java.util.List;

import javax.crypto.spec.RC2ParameterSpec;

public class VMDashboard extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final RBranchInfo poBranch;
    private final RClientInfo poClient;
    private MutableLiveData<List<EBranchInfo>> eBranchInfoList;
    public VMDashboard(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poBranch = new RBranchInfo(application);
        this.poClient = new RClientInfo(application);
    }

    public LiveData<EClientInfo> getClientInfo(){
        return poClient.getClientInfo();
    }
}
