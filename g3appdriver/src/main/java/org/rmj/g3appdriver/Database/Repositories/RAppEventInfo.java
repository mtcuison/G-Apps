package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import org.rmj.g3appdriver.Database.DataAccessObject.DAppEventInfo;
import org.rmj.g3appdriver.Database.Entities.EAppEventInfo;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RAppEventInfo implements DAppEventInfo{

    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DAppEventInfo appEventDao;
    public RAppEventInfo(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.appEventDao = database.EAppEventDao();
    }

    @Override
    public void insert(EAppEventInfo eventInfo) {
        appEventDao.insert(eventInfo);
    }

    @Override
    public void insertBulkData(List<EAppEventInfo> eventInfoList) {
        appEventDao.insertBulkData(eventInfoList);
    }

    @Override
    public void update(EAppEventInfo eventInfo) {
        appEventDao.update(eventInfo);
    }
}
