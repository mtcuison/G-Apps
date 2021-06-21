package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import org.rmj.g3appdriver.Database.DataAccessObject.DAppEventInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DUserInfo;
import org.rmj.g3appdriver.Database.Entities.EUserInfo;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RUserInfo implements DUserInfo{
    private static final String TAG = "RUserInfo";
    private final Application application;

    private final DUserInfo userDao;
    public RUserInfo(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.userDao = database.EUserInfoDao();
    }

    @Override
    public void insert(EUserInfo eUserInfo) {
        userDao.insert(eUserInfo);
    }

    @Override
    public void insertBulkData(List<EUserInfo> eUserInfoList) {
        userDao.insertBulkData(eUserInfoList);
    }

    @Override
    public void update(EUserInfo eUserInfo) {
        userDao.update(eUserInfo);
    }
}
