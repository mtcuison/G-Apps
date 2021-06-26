package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import org.rmj.g3appdriver.Database.DataAccessObject.DServiceInfo;
import org.rmj.g3appdriver.Database.Entities.EServiceInfo;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RServiceInfo implements DServiceInfo {
    private static final String TAG = "RServiceInfo";
    private final Application application;

    private final DServiceInfo serviceDao;
    public RServiceInfo(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.serviceDao = database.EServiceDao();
    }

    @Override
    public void insert(EServiceInfo eServiceInfo) {
        serviceDao.insert(eServiceInfo);
    }

    @Override
    public void insertBulkData(List<EServiceInfo> eServiceInforInfoList) {
        serviceDao.insertBulkData(eServiceInforInfoList);
    }

    @Override
    public void update(EServiceInfo eServiceInforInfo) {
        serviceDao.update(eServiceInforInfo);
    }
}
