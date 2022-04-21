package org.rmj.g3appdriver.dev.Repositories;

import android.content.Context;
import android.os.AsyncTask;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMCSerialRegistration;
import org.rmj.g3appdriver.dev.Database.Entities.EMCSerialRegistration;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.SessionManager;

import java.util.List;

public class RMCSerialRegistration implements DMCSerialRegistration {
    private static final String TAG = "RAppEventInfo";
    private final Context mContext;

    private final DMCSerialRegistration mcDao;
    public RMCSerialRegistration(Context instance){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(instance);
        this.mContext = instance;
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
        new DeleteUserTask(mContext, mcDao).execute();
    }

    public static class DeleteUserTask extends AsyncTask<Void, Void, Void> {
        private DMCSerialRegistration mcDao;
        private SessionManager sessionManager;
        public DeleteUserTask(Context instance,DMCSerialRegistration mcDao ) {
            this.mcDao = mcDao;
            this.sessionManager = new SessionManager(instance);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            mcDao.deleteMC();
            return null;
        }
    }
}
