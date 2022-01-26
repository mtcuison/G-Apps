package org.rmj.guanzongroup.appcore.Database.Repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.rmj.guanzongroup.appcore.Database.DataAccessObject.DPromo;
import org.rmj.guanzongroup.appcore.Database.Entities.EPromo;
import org.rmj.guanzongroup.appcore.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RPromo implements DPromo {
    private static final String TAG = "RAppEventInfo";
    private final Context mContext;

    private final DPromo promoDao;
    public RPromo(Context context){
        this.mContext = context;
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(mContext);
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
