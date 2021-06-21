package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.DataAccessObject.DAppEventInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RBranchInfo implements DBranchInfo{
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DBranchInfo brnDao;
    public RBranchInfo(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.brnDao = database.EBranchDao();
    }

    @Override
    public void insert(EBranchInfo branchInfo) {
        brnDao.insert(branchInfo);
    }

    @Override
    public void insertBulkData(List<EBranchInfo> branchInfoList) {
        brnDao.insertBulkData(branchInfoList);
    }

    @Override
    public void update(EBranchInfo branchInfo) {
        brnDao.update(branchInfo);
    }
    

    @Override
    public LiveData<List<EBranchInfo>> getAllBranchs() {
        return brnDao.getAllBranchs();
    }

    @Override
    public LiveData<List<EBranchInfo>>  getMotorBranches() {
        return brnDao.getMotorBranches();
    }

    @Override
    public LiveData<List<EBranchInfo>> getMobileBranches() {
        return brnDao.getMobileBranches();
    }
}
