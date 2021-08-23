package org.rmj.g3appdriver.Database.Repositories;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.appdriver.base.GConnection;
import org.rmj.g3appdriver.Database.DataAccessObject.DEvents;
import org.rmj.g3appdriver.Database.DbConnection;
import org.rmj.g3appdriver.Database.Entities.EEvents;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ImageDownloader;
import org.rmj.g3appdriver.utils.SQLUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public List<EEvents> getAllEventsForDownloadImg() {
        return eventsDao.getAllEventsForDownloadImg();
    }

    @Override
    public boolean getEventExist(String TransNox) {
        return eventsDao.getEventExist(TransNox);
    }

    @Override
    public void updateReadEvent(String date, String transNox) {
        Log.e(TAG,"updated");
        eventsDao.updateReadEvent(date, transNox);
    }

    @Override
    public void updateEventImgPath(String imgPath, String transNox) {
        eventsDao.updateEventImgPath(imgPath, transNox);
    }

    @Override
    public LiveData<Integer> getEventCount() {
        return eventsDao.getEventCount();
    }

//    @Override
//    public List<PromoEventsModel> getAllEventsPromo() {
//        return eventsDao.getAllEventsPromo();
//    }

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
