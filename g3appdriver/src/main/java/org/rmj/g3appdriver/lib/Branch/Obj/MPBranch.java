package org.rmj.g3appdriver.lib.Branch.Obj;

import android.content.Context;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DBranchInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EProvinceInfo;
import org.rmj.g3appdriver.dev.Database.Entities.ETownInfo;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.lib.Branch.iBranch;

import java.util.List;

public class MPBranch implements iBranch {
    private static final String TAG = MPBranch.class.getSimpleName();

    private final Context mContext;

    private final DBranchInfo poDao;

    public MPBranch(Context context) {
        this.mContext = context;
        this.poDao = GGC_GuanzonAppDB.getInstance(mContext).EBranchDao();
    }

    @Override
    public LiveData<List<EBranchInfo>> GetBranchList() {
        return poDao.getMobileBranches();
    }

    @Override
    public LiveData<List<ETownInfo>> GetTownList(String args) {
        return poDao.GetTownList(args);
    }

    @Override
    public LiveData<List<EProvinceInfo>> GetProvinceList() {
        return poDao.GetProvinceList();
    }

    @Override
    public LiveData<List<EBranchInfo>> GetBranchList(String Town) {
        return poDao.GetMPBranches(Town);
    }
}
