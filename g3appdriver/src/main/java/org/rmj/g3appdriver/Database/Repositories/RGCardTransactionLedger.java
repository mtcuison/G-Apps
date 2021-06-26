package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import org.rmj.g3appdriver.Database.DataAccessObject.DGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

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
}
