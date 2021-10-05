package org.rmj.g3appdriver.Database.Repositories;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.json.JSONArray;
import org.json.JSONObject;
import org.rmj.appdriver.base.GConnection;
import org.rmj.apprdiver.util.SQLUtil;
import org.rmj.g3appdriver.Database.DataAccessObject.DPromo;
import org.rmj.g3appdriver.Database.DbConnection;
import org.rmj.g3appdriver.Database.Entities.EEvents;
import org.rmj.g3appdriver.Database.Entities.EPromo;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.etc.ImageDownloader;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class RPromo implements DPromo {
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

    @Override
    public LiveData<List<EPromo>> getAllPromo() {
        return promoDao.getAllPromo();
    }

    @Override
    public List<EPromo> getAllPromoForDownloadImg() {
        return promoDao.getAllPromoForDownloadImg();
    }

    @Override
    public void updateReadPromo(String date, String transNox) {
        Log.e(TAG,"updated");
        promoDao.updateReadPromo(date, transNox);
    }

    @Override
    public LiveData<Integer> getPromoCount() {
        return promoDao.getPromoCount();
    }

    @Override
    public boolean getPromoExist(String TransNox) {
        return promoDao.getPromoExist(TransNox);
    }

    @Override
    public void updatePromoImgPath(String imgPath, String transNox) {
        promoDao.updatePromoImgPath(imgPath, transNox);
    }

}
