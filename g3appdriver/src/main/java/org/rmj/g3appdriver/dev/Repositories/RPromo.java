package org.rmj.g3appdriver.dev.Repositories;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DPromo;
import org.rmj.g3appdriver.dev.Database.Entities.EPromo;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RPromo implements DPromo {
    private static final String TAG = "RAppEventInfo";
    private final Context mContext;

    private final DPromo poDao;

    public RPromo(Context context){
        this.mContext = context;
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(mContext);
        this.poDao = database.EPromoDao();
    }

    @Override
    public void insert(EPromo ePromo) {
        poDao.insert(ePromo);
    }

    @Override
    public LiveData<List<EPromo>> getAllPromo() {
        return poDao.getAllPromo();
    }

    @Override
    public List<EPromo> getAllPromoForDownloadImg() {
        return poDao.getAllPromoForDownloadImg();
    }

    @Override
    public void updateReadPromo(String date, String transNox) {
        Log.e(TAG,"updated");
        poDao.updateReadPromo(date, transNox);
    }

    @Override
    public LiveData<Integer> getPromoCount() {
        return poDao.getPromoCount();
    }

    @Override
    public boolean getPromoExist(String TransNox) {
        return poDao.getPromoExist(TransNox);
    }

    @Override
    public void updatePromoImgPath(String imgPath, String transNox) {
        poDao.updatePromoImgPath(imgPath, transNox);
    }

    @Override
    public EPromo getPromoInfoIfExist(String TransNox) {
        return poDao.getPromoInfoIfExist(TransNox);
    }

    @Override
    public void UpdatePromoInfo(String Transact, String DateFrom, String DateThru, String Captionx, String ImageUrl, String ImgeByte, String PromoUrl, String Notified, String Division, String TransNox) {
        poDao.UpdatePromoInfo(Transact,
                DateFrom,
                DateThru,
                Captionx,
                ImageUrl,
                ImgeByte,
                PromoUrl,
                Notified,
                Division,
                TransNox);
    }

}
