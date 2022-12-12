package org.rmj.g3appdriver.dev.Repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DBranchInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EProvinceInfo;
import org.rmj.g3appdriver.dev.Database.Entities.ETownInfo;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RBranchInfo implements DBranchInfo {
    private static final String TAG = "RAppEventInfo";
    private final Context mContext;

    private final DBranchInfo poDao;
    public RBranchInfo(Context context){
        this.mContext = context;
        this.poDao = GGC_GuanzonAppDB.getInstance(mContext).EBranchDao();
    }

    @Override
    public void insert(EBranchInfo branchInfo) {
        poDao.insert(branchInfo);
    }

    @Override
    public LiveData<List<EBranchInfo>> getAllBranchs() {
        return poDao.getAllBranchs();
    }

    @Override
    public LiveData<List<EBranchInfo>> getMotorBranches() {
        return poDao.getMotorBranches();
    }

    @Override
    public LiveData<List<EBranchInfo>> getMobileBranches() {
        return poDao.getMobileBranches();
    }

    @Override
    public EBranchInfo getBranchIfExist(String BranchCde) {
        return poDao.getBranchIfExist(BranchCde);
    }

    @Override
    public LiveData<List<ETownInfo>> GetTownList(String args) {
        return null;
    }

    @Override
    public LiveData<List<EProvinceInfo>> GetProvinceList() {
        return null;
    }

    @Override
    public LiveData<List<EBranchInfo>> GetMCBranches(String Province) {
        return null;
    }

    @Override
    public LiveData<List<EBranchInfo>> GetMCBranches(String Province, String Town) {
        return null;
    }

    @Override
    public LiveData<List<EBranchInfo>> GetMPBranches(String Province) {
        return null;
    }

    @Override
    public LiveData<List<EBranchInfo>> GetMPBranches(String Province, String Town) {
        return null;
    }

    @Override
    public void UpdateBranchInfo(String BranchCd,
                                 String BranchNm,
                                 String Descript,
                                 String Addressx,
                                 String Contactx,
                                 String TelNumbr,
                                 String EmailAdd) {
        poDao.UpdateBranchInfo(BranchCd,
                BranchNm,
                Descript,
                Addressx,
                Contactx,
                TelNumbr,
                EmailAdd);
    }
}