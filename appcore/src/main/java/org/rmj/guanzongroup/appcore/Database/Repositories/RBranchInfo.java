package org.rmj.guanzongroup.appcore.Database.Repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.guanzongroup.appcore.Database.DataAccessObject.DBranchInfo;
import org.rmj.guanzongroup.appcore.Database.Entities.EBranchInfo;
import org.rmj.guanzongroup.appcore.Database.GGC_GuanzonAppDB;

import java.util.ArrayList;
import java.util.List;

public class RBranchInfo implements DBranchInfo {
    private static final String TAG = "RAppEventInfo";
    private final Context mContext;

    private final DBranchInfo brnDao;
    public RBranchInfo(Context context){
        this.mContext = context;
        this.brnDao = GGC_GuanzonAppDB.getInstance(mContext).EBranchDao();
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
    public LiveData<List<EBranchInfo>> getMotorBranches() {
        return brnDao.getMotorBranches();
    }

    @Override
    public LiveData<List<EBranchInfo>> getMobileBranches() {
        return brnDao.getMobileBranches();
    }

    public boolean insertBranchInfos(JSONArray faJson) throws Exception {
        try {
            List<EBranchInfo> brnList = new ArrayList<>();
            for (int x = 0; x < faJson.length(); x++) {
                JSONObject loJson = faJson.getJSONObject(x);
                EBranchInfo info = new EBranchInfo();
                info.setBranchCd(loJson.getString("sBranchCD"));
                info.setBranchNm(loJson.getString("sBranchNm"));
                info.setDescript(loJson.getString("sDescript"));
                info.setAddressx(loJson.getString("sAddressx"));
                info.setContactx(loJson.getString("sContactx"));
                info.setTelNumbr(loJson.getString("sTelNumbr"));
                info.setEmailAdd(loJson.getString("sEMailAdd"));
                brnList.add(info);
            }
            brnDao.insertBulkData(brnList);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



}
