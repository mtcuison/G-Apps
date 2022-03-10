package org.rmj.g3appdriver.dev.Database.Repositories;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.SessionManager;

import java.util.ArrayList;
import java.util.List;

public class RGcardApp implements DGcardApp {
    private static final String TAG = "RAppEventInfo";
    private final Context mContext;

    private final DGcardApp gcardDao;
    private final SessionManager session;
    public RGcardApp(Context context){
        this.mContext = context;
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(context);
        this.session = new SessionManager(context);
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
    public void updateGCardActiveStatus(String GCardNmbr) {
        gcardDao.updateGCardActiveStatus(GCardNmbr);
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
    public LiveData<List<EGcardApp>> hasUnCheckGCard() {
        return gcardDao.hasUnCheckGCard();
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
    public List<EGcardApp> getAllGCard() {
        return gcardDao.getAllGCard();
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

    @Override
    public double getRemainingActiveCardPoints() {
        return gcardDao.getRemainingActiveCardPoints();
    }

    public void deleteGCard(){
        new DeleteUserTask(mContext, gcardDao).execute();
    }

    @Override
    public void updateGCardDeactiveStatus() {
        gcardDao.updateGCardDeactiveStatus();
    }

    public boolean insertNewGCard(JSONObject loJson) {
        try {
            Log.e(TAG, loJson.getString("sGCardNox"));
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
            gcardDao.insert(info);
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
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
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static class DeleteUserTask extends AsyncTask<Void, Void, Void> {
        private DGcardApp dGcardApp;
        public DeleteUserTask(Context context,DGcardApp dGcardApp ) {
            this.dGcardApp = dGcardApp;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dGcardApp.deleteGCard();
            return null;
        }
    }

}
