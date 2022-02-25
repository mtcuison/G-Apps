package org.rmj.g3appdriver.dev.Database.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import org.rmj.g3appdriver.dev.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DGCardTransactionLedger;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMCSerialRegistration;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.SessionManager;

import java.util.List;

public class RClientInfo implements DClientInfo {
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DClientInfo clientDao;
    private final DGcardApp gCardDao;
    private final DGCardTransactionLedger ledgerDao;
    private final DMCSerialRegistration mcDao;
    private final SessionManager sessionManager;
//    private final AppConfigPreference appConfigPreference;
    public RClientInfo(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.sessionManager = new SessionManager(application);
//        this.appConfigPreference = new AppConfigPreference(application);
        this.clientDao = database.EClientDao();
        this.gCardDao = database.EGcardAppDao();
        this.ledgerDao = database.EGCardTransactionLedgerDao();
        this.mcDao = database.EMCSerialRegistrationDao();
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

    @Override
    public void deleteClient() {

    }

    @Override
    public LiveData<EClientInfo> getClientInfo() {
        return clientDao.getClientInfo();
    }

    public void insertLogin(EClientInfo clientInfo){
        new InsertLoginTask(clientDao).execute(clientInfo);
    }
    private static class InsertLoginTask extends AsyncTask<EClientInfo, Void, Void> {
        private DClientInfo dclient;

        public InsertLoginTask(DClientInfo dclient){
            this.dclient = dclient;
        }

        @Override
        protected Void doInBackground(EClientInfo... clientInfos) {
            dclient.deleteClient();
            dclient.insert(clientInfos[0]);
            return null;
        }
    }
    public void LogoutUserSession(){
        sessionManager.initUserLogout();
        new DeleteUserTask(application, clientDao).execute();
    }
    public static class DeleteUserTask extends AsyncTask<Void, Void, Void>{
        private DClientInfo clientInfo;
        private DGCardTransactionLedger dgCardTransactionLedger;
        private DGcardApp dGcardApp;
        private DMCSerialRegistration dmcSerialRegistration;
        private SessionManager sessionManager;
        private AppConfigPreference appConfig;
        public DeleteUserTask(Application application,DClientInfo clientInfo) {
            this.clientInfo = clientInfo;
            this.sessionManager = new SessionManager(application);
        }

        @Override
        protected Void doInBackground(Void... voids) {
            clientInfo.deleteClient();
            return null;
        }
    }
}
