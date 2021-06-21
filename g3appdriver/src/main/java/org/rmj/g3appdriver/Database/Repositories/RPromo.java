package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import org.rmj.g3appdriver.Database.DataAccessObject.DAppEventInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DPromo;
import org.rmj.g3appdriver.Database.Entities.EPromo;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RPromo implements DPromo{
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DPromo promoDao;
    public RPromo(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.promoDao = database.EPromoDao();
    }

    @Override
    public void insert(EPromo ePromo) {
        promoDao.insert(ePromo);
    }

    @Override
    public void insertBulkData(List<EPromo> ePromoList) {
        promoDao.insertBulkData(ePromoList);
    }

    @Override
    public void update(EPromo ePromo) {
        promoDao.update(ePromo);
    }
}
