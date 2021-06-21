package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import org.rmj.g3appdriver.Database.DataAccessObject.DMCSerialRegistration;
import org.rmj.g3appdriver.Database.Entities.EMCSerialRegistration;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RMCSerialRegistration implements DMCSerialRegistration{
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DMCSerialRegistration mcDao;
    public RMCSerialRegistration(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.mcDao = database.EMCSerialRegistrationDao();
    }

    @Override
    public void insert(EMCSerialRegistration emcSerialRegistration) {
        mcDao.insert(emcSerialRegistration);
    }

    @Override
    public void insertBulkData(List<EMCSerialRegistration> emcSerialRegistrationList) {
        mcDao.insertBulkData(emcSerialRegistrationList);
    }

    @Override
    public void update(EMCSerialRegistration emcSerialRegistration) {
        mcDao.update(emcSerialRegistration);
    }
}
