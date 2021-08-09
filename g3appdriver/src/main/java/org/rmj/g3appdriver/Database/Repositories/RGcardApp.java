package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DGCardTransactionLedger;
import org.rmj.g3appdriver.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.Database.DataAccessObject.DMCSerialRegistration;
import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.AppConfigPreference;
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
    public void updateGCardApp() {
        gcardDao.updateGCardApp();
    }

    @Override
    public void updateGCardAppWithHighestPoints() {
        gcardDao.updateGCardAppWithHighestPoints();
    }


    @Override
    public List<EGcardApp> hasGcard() {
        return gcardDao.hasGcard();
    }

    @Override
    public List<EGcardApp> hasActiveGcard() {
        return gcardDao.hasActiveGcard();
    }
    @Override
    public LiveData<EGcardApp> hasNoGcard() {
        return gcardDao.hasNoGcard();
    }

    @Override
    public double getOrderPoints(String CardNmbr) {
        return gcardDao.getOrderPoints(CardNmbr);
    }

    @Override
    public void updateAvailablePoints(String fsGcardNo, String fsNewPts) {
        gcardDao.updateAvailablePoints(fsGcardNo, fsNewPts);
    }

    @Override
    public String getCardNo() {
        return gcardDao.getCardNo();
    }
    @Override
    public String getCardNox() {
        return gcardDao.getCardNox();
    }

    @Override
    public List<EGcardApp> hasMultipleGCard() {
        return gcardDao.hasMultipleGCard();
    }



    @Override
    public LiveData<EGcardApp> getGCardInfo() {
        return gcardDao.getGCardInfo();
    }

    @Override
    public LiveData<List<EGcardApp>> getAllGCardInfo() {
        return gcardDao.getAllGCardInfo();
    }

    @Override
    public double getGCardTotPoints(String CardNmbr) {
        return gcardDao.getGCardTotPoints(CardNmbr);
    }

    @Override
    public LiveData<String> getActiveGcardNo() {
        return gcardDao.getActiveGcardNo();
    }

    @Override
    public LiveData<String> getActiveGcardAvlPoints() {
        return gcardDao.getActiveGcardAvlPoints();
    }

    public void deleteGCard(){
        new DeleteUserTask(application, gcardDao).execute();
    }

    public boolean insertGCard(JSONObject loJson) throws Exception {
        try {
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
                info.setActvStat("1");
                info.setNotified("1");
                gcardDao.insert(info);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void saveGCardUpdate(){
        if (hasGcard().size() > 0){
            if(!(hasActiveGcard().size() > 0)){
                if(hasMultipleGCard().size() <= 1){
                    updateGCardApp();
                } else {
                    updateGCardAppWithHighestPoints();

                }
            }
        }
    }

    public static class DeleteUserTask extends AsyncTask<Void, Void, Void> {
        private DGcardApp dGcardApp;
        public DeleteUserTask(Application application,DGcardApp dGcardApp ) {
            this.dGcardApp = dGcardApp;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dGcardApp.deleteGCard();
            return null;
        }
    }

}
