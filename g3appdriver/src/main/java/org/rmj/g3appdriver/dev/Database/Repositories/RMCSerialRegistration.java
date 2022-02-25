package org.rmj.g3appdriver.dev.Database.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMCSerialRegistration;
import org.rmj.g3appdriver.dev.Database.Entities.EMCSerialRegistration;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.SessionManager;

import java.util.List;

public class RMCSerialRegistration implements DMCSerialRegistration {
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

    @Override
    public void deleteMC() {
        new DeleteUserTask(application, mcDao).execute();
    }

    public static class DeleteUserTask extends AsyncTask<Void, Void, Void> {
        private DMCSerialRegistration mcDao;
        private SessionManager sessionManager;
        public DeleteUserTask(Application application,DMCSerialRegistration mcDao ) {
            this.mcDao = mcDao;
            this.sessionManager = new SessionManager(application);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mcDao.deleteMC();
            return null;
        }
    }
}
