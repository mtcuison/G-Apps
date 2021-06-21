package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import org.rmj.g3appdriver.Database.DataAccessObject.DAppEventInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RClientInfo implements DClientInfo{
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DClientInfo clientDao;
    public RClientInfo(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.clientDao = database.EClientDao();
    }

    @Override
    public void insert(EClientInfo eClientInfo) {
        clientDao.insert(eClientInfo);
    }

    @Override
    public void insertBulkData(List<EClientInfo> eClientInfoList) {
        clientDao.insertBulkData(eClientInfoList);
    }

    @Override
    public void update(EClientInfo eClientInfo) {
        clientDao.update(eClientInfo);
    }
}
