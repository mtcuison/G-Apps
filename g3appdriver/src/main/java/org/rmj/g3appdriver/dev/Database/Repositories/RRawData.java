/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:18 PM
 */

package org.rmj.g3appdriver.dev.Database.Repositories;

import android.app.Application;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRawDao;
import org.rmj.g3appdriver.dev.Database.Entities.ETokenInfo;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;

public class RRawData implements DRawDao {

    private DRawDao rawDao;

    public RRawData(Application application){
        GGC_GuanzonAppDB GGCGriderDB = GGC_GuanzonAppDB.getInstance(application);
        rawDao = GGCGriderDB.RawDao();
    }


    @Override
    public void insertTokenInfo(ETokenInfo tokenInfo) {
        rawDao.insertTokenInfo(tokenInfo);
    }

    @Override
    public void clearTokenInfo() {
        rawDao.clearTokenInfo();
    }

    @Override
    public String getTokenInfo() {
        return rawDao.getTokenInfo();
    }
}
