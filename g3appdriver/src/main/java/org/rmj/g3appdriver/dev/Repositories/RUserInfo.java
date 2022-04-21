package org.rmj.g3appdriver.dev.Repositories;

import android.content.Context;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DUserInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EUserInfo;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RUserInfo implements DUserInfo {
    private static final String TAG = "RUserInfo";
    private final Context mContext;

    private final DUserInfo userDao;
    public RUserInfo(Context instance){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(instance);
        this.mContext = instance;
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

    @Override
    public EClientInfo getUserInfo() {
        return userDao.getUserInfo();
    }
}
