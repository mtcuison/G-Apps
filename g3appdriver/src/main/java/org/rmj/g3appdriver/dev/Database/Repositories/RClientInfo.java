package org.rmj.g3appdriver.dev.Database.Repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RClientInfo implements DClientInfo {
    private static final String TAG = "RAppEventInfo";

    private final DClientInfo clientDao;

    public RClientInfo(Context context){
        this.clientDao = GGC_GuanzonAppDB.getInstance(context).EClientDao();
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
        clientDao.deleteClient();
    }

    @Override
    public LiveData<EClientInfo> getClientInfo() {
        return clientDao.getClientInfo();
    }
}
