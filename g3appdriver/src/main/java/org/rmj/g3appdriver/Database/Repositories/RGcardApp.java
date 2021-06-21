package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.DataAccessObject.DAppEventInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RGcardApp implements DGcardApp{
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DGcardApp gcardDao;
    public RGcardApp(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.gcardDao = database.EGcardAppDao();
    }

    @Override
    public void insert(EGcardApp gcardApp) {
        gcardDao.insert(gcardApp);
    }

    @Override
    public void insertBulkData(List<EGcardApp> gcardAppList) {
        gcardDao.insertBulkData(gcardAppList);
    }

    @Override
    public void update(EGcardApp gcardApp) {
        gcardDao.update(gcardApp);
    }

    @Override
    public LiveData<EGcardApp> getGCardInfo() {
        return gcardDao.getGCardInfo();
    }
}
