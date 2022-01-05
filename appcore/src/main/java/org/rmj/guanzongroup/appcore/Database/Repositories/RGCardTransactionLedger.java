package org.rmj.guanzongroup.appcore.Database.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import org.rmj.guanzongroup.appcore.Database.DataAccessObject.DGCardTransactionLedger;
import org.rmj.guanzongroup.appcore.Database.Entities.EGCardTransactionLedger;
import org.rmj.guanzongroup.appcore.Database.GGC_GuanzonAppDB;
import org.rmj.guanzongroup.appcore.Etc.SessionManager;

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

    @Override
    public LiveData<List<EGCardTransactionLedger>> getRedemptionTransactionsList(String GCardNox) {
        return ledgerDao.getRedemptionTransactionsList(GCardNox);
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> getAllTransactionsList(String GCardNox) {
        return ledgerDao.getAllTransactionsList(GCardNox);
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> getPointsEntryTransactionsList(String GCardNox) {
        return ledgerDao.getPointsEntryTransactionsList(GCardNox);
    }

    @Override
    public LiveData<Integer> isTransactionValid(String gcardNo, String srcedsc, String referno, String trandsc, String srcenox, String pointsx) {
        return ledgerDao.isTransactionValid(gcardNo,  srcedsc,  referno,  trandsc,  srcenox,  pointsx);
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
