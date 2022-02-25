package org.rmj.g3appdriver.dev.Database.Repositories;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DGCardTransactionLedger;
import org.rmj.g3appdriver.dev.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.SessionManager;

import java.util.List;

public class RGCardTransactionLedger implements DGCardTransactionLedger {
    private static final String TAG = "RAppEventInfo";
    private final Context mContext;

    private final DGCardTransactionLedger ledgerDao;
    public RGCardTransactionLedger(Context context){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(context);
        this.mContext = context;
        this.ledgerDao = database.EGCardTransactionLedgerDao();
    }

    @Override
    public void Save(EGCardTransactionLedger egCardTransactionLedger) {
        ledgerDao.Save(egCardTransactionLedger);
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
        new DeleteUserTask(mContext, ledgerDao).execute();
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> getRedemptionTransactionsList() {
        return ledgerDao.getRedemptionTransactionsList();
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> getAllTransactionsList() {
        return ledgerDao.getAllTransactionsList();
    }

    @Override
    public LiveData<List<EGCardTransactionLedger>> getPointsEntryTransactionsList() {
        return ledgerDao.getPointsEntryTransactionsList();
    }

    @Override
    public LiveData<Integer> isTransactionValid(String gcardNo, String srcedsc, String referno, String trandsc, String srcenox, String pointsx) {
        return ledgerDao.isTransactionValid(gcardNo,  srcedsc,  referno,  trandsc,  srcenox,  pointsx);
    }

    public static class DeleteUserTask extends AsyncTask<Void, Void, Void> {
        private DGCardTransactionLedger dGcardApp;
        private SessionManager sessionManager;
        public DeleteUserTask(Context context,DGCardTransactionLedger dGcardApp ) {
            this.dGcardApp = dGcardApp;
            this.sessionManager = new SessionManager(context);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            dGcardApp.deleteGCardTrans();
            return null;
        }
    }
}
