package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class RGcardApp implements DGcardApp {
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DGcardApp gcardDao;
    private final SessionManager session;
    public RGcardApp(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.session = new SessionManager(application);
        this.gcardDao = database.EGcardAppDao();
    }

    @Override
    public void insert(EGcardApp gcardApp) {
        gcardDao.insert(gcardApp);
    }

    @Override
    public void insertBulkData(List<EGcardApp> gcardAppList) {
        gcardDao.insertBulkData(gcardAppList);
    }

    @Override
    public void update(EGcardApp gcardApp) {
        gcardDao.update(gcardApp);
    }

    @Override
    public void deleteGCard() {
    }

    @Override
    public LiveData<EGcardApp> getGCardInfo() {
        return gcardDao.getGCardInfo();
    }
    public boolean insertGCard(JSONObject jsonResponse) throws Exception {
        try {
            JSONArray jsonArray = jsonResponse.getJSONArray("detail");
            List<EGcardApp> gcardList = new ArrayList<>();
            for(int x = 0; x < jsonArray.length(); x++){
                JSONObject loJson = jsonArray.getJSONObject(x);
                EGcardApp info = new EGcardApp();
                info.setGCardNox(loJson.getString("sGCardNox"));
                info.setCardNmbr(loJson.getString("sCardNmbr"));
                info.setUserIDxx(session.getUserID());
                info.setNmOnCard(loJson.getString("sNmOnCard"));
                info.setMemberxx(loJson.getString("dMemberxx"));
                info.setCardType(loJson.getString("cCardType"));
                info.setAvlPoint(loJson.getString("nAvlPoint"));
                info.setTotPoint(loJson.getString("nTotPoint"));
                info.setTranStat(loJson.getString("cCardStat"));
                info.setActvStat("0");
                info.setNotified("1");
                gcardList.add(info);
            }
            gcardDao.insertBulkData(gcardList);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
