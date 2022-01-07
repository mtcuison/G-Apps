package org.rmj.guanzongroup.appcore.Database.Repositories;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.guanzongroup.appcore.Database.DataAccessObject.DEvents;
import org.rmj.guanzongroup.appcore.Database.Entities.EEvents;
import org.rmj.guanzongroup.appcore.Database.GGC_GuanzonAppDB;
import org.rmj.guanzongroup.appcore.Etc.AppConstants;

import java.util.ArrayList;
import java.util.List;

public class REvents implements DEvents {
    private static final String TAG = "RAppEventInfo";
    private final Context mContext;

    private final DEvents eventsDao;
    public REvents(Context context){
        this.mContext = context;
        this.eventsDao = GGC_GuanzonAppDB.getInstance(mContext).EventDao();
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
