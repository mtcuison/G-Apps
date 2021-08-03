package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import org.rmj.g3appdriver.Database.DataAccessObject.DGCardTransactionLedger;
import org.rmj.g3appdriver.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.SessionManager;

import java.util.List;

public class RGCardTransactionLedger implements DGCardTransactionLedger {
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DGCardTransactionLedger ledgerDao;
    public RGCardTransactionLedger(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.ledgerDao = database.EGCardTransactionLedgerDao();
    }

    @Override
    public void insert(EGCardTransactionLedger egCardTransactionLedger) {
        ledgerDao.insert(egCardTransactionLedger);
    }

    @Override
    public void insertBulkData(List<EGCardTransactionLedger> egCardTransactionLedgerList) {
        ledgerDao.insertBulkData(egCardTransactionLedgerList);
    }

    @Override
    public void update(EGCardTransactionLedger egCardTransactionLedger) {
        ledgerDao.update(egCardTransactionLedger);
    }

    @Override
    public void deleteGCardTrans() {
        new DeleteUserTask(application, ledgerDao).execute();
    }

    public static class DeleteUserTask extends AsyncTask<Void, Void, Void> {
        private DGCardTransactionLedger dGcardApp;
        private SessionManager sessionManager;
        public DeleteUserTask(Application application,DGCardTransactionLedger dGcardApp ) {
            this.dGcardApp = dGcardApp;
            this.sessionManager = new SessionManager(application);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            dGcardApp.deleteGCardTrans();
            return null;
        }
    }
}
