package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.DataAccessObject.DEvents;
import org.rmj.g3appdriver.Database.Entities.EEvents;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class REvents implements DEvents {
    private static final String TAG = "RAppEventInfo";
    private final Application application;

    private final DEvents eventsDao;
    public REvents(Application application){
        this.application = application;
        this.eventsDao = GGC_GuanzonAppDB.getInstance(application).EventDao();
    }

    @Override
    public void insert(EEvents events) {
        eventsDao.insert(events);
    }

    @Override
    public void insertBulkData(List<EEvents> events) {
        eventsDao.insertBulkData(events);
    }

    @Override
    public void update(EEvents events) {
        eventsDao.update(events);
    }

    @Override
    public LiveData<List<EEvents>> getAllEvents() {
        return eventsDao.getAllEvents();
    }

    @Override
    public void updateReadEvent(String date, String transNox) {
        eventsDao.updateReadEvent(date, transNox);
    }

    public boolean insertEvents(JSONArray laJson) throws Exception{
        try{
            List<EEvents> eEventsList = new ArrayList<>();
            for(int x = 0; x < laJson.length(); x++){
                JSONObject loJson = laJson.getJSONObject(x);
                EEvents info = new EEvents();
                info.setTransNox(loJson.getString("sTransNox"));
                info.setBranchNm(loJson.getString("sBranchNm"));
                info.setEvntFrom(loJson.getString("dEvntFrom"));
                info.setEvntThru(loJson.getString("dEvntThru"));
                info.setEventTle(loJson.getString("sEventTle"));
                info.setAddressx(loJson.getString("sAddressx"));
                info.setEventURL(loJson.getString("sEventURL"));
                info.setImageURL(loJson.getString("sImageURL"));
                info.setNotified("0");
                info.setModified(AppConstants.DATE_MODIFIED);
                eEventsList.add(info);
            }

            eventsDao.insertBulkData(eEventsList);
            return true;
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
        
    }
}
