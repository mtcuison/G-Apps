package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.DataAccessObject.DEvents;
import org.rmj.g3appdriver.Database.Entities.EEvents;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class REvents implements DEvents {
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DEvents brnDao;
    public REvents(Application application){
        this.application = application;
        this.brnDao = GGC_GuanzonAppDB.getInstance(application).EventDao();
    }

    @Override
    public void insert(EEvents events) {
        brnDao.insert(events);
    }

    @Override
    public void insertBulkData(List<EEvents> events) {
        brnDao.insertBulkData(events);
    }

    @Override
    public void update(EEvents events) {
        brnDao.update(events);
    }

    @Override
    public LiveData<List<EEvents>> getAllEvents() {
        return brnDao.getAllEvents();
    }


}
