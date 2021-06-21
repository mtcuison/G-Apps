package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import org.rmj.g3appdriver.Database.DataAccessObject.DAppEventInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemablesInfo;
import org.rmj.g3appdriver.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RRedeemablesInfo implements DRedeemablesInfo{
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DRedeemablesInfo redeemDao;
    public RRedeemablesInfo(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.redeemDao = database.ERedeemablesDao();
    }

    @Override
    public void insert(ERedeemablesInfo redeemablesInfo) {
        redeemDao.insert(redeemablesInfo);
    }

    @Override
    public void insertBulkData(List<ERedeemablesInfo> redeemablesInfoList) {
        redeemDao.insertBulkData(redeemablesInfoList);
    }

    @Override
    public void update(ERedeemablesInfo redeemablesInfo) {
        redeemDao.update(redeemablesInfo);
    }
}
