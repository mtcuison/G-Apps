package org.rmj.g3appdriver.Database.Repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.Database.GGC_GuanzonAppDB;

import java.util.List;

public class RRedeemItemInfo implements DRedeemItemInfo{
    private static final String TAG = RRedeemItemInfo.class.getSimpleName();
    private final Application application;

    private final DRedeemItemInfo itemDao;
    public RRedeemItemInfo(Application application){
        GGC_GuanzonAppDB database = GGC_GuanzonAppDB.getInstance(application);
        this.application = application;
        this.itemDao = database.ERedeemItemDao();
    }

    @Override
    public void insert(ERedeemItemInfo redeemItemInfo) {
        new InsertAsyncTask(itemDao).execute(redeemItemInfo);
    }

    @Override
    public void insertBulkData(List<ERedeemItemInfo> redeemItemInfoList) {
        itemDao.insertBulkData(redeemItemInfoList);
    }

    @Override
    public void update(ERedeemItemInfo redeemItemInfo) {
        itemDao.update(redeemItemInfo);
    }

    @Override
    public LiveData<Integer> getCartItemCount(String GCardNox) {
        return itemDao.getCartItemCount(GCardNox);
    }

    @Override
    public void updateItemDetails(String fsGcardNo, String fsPromoId, int fnNewCnt, double fnNewPts) {
        itemDao.updateItemDetails(fsGcardNo, fsPromoId, fnNewCnt, fnNewPts);
    }

    @Override
    public LiveData<List<ItemDetail>> getExistingItemDetail(String fsPromoId) {
        return itemDao.getExistingItemDetail(fsPromoId);
    }

    @Override
    public LiveData<List<CartItemsDetail>> getCartItemsDetail(String fsGcardNo) {
        return itemDao.getCartItemsDetail(fsGcardNo);
    }

    @Override
    public LiveData<Double> getTotalCartPoints(String fsGcardNo) {
        return itemDao.getTotalCartPoints(fsGcardNo);
    }

    @Override
    public void removeItemFromCart(String fsPromoId) {
        itemDao.removeItemFromCart(fsPromoId);
    }

    private static class InsertAsyncTask extends AsyncTask<ERedeemItemInfo, Void, Void> {

        private final DRedeemItemInfo dao;

        private InsertAsyncTask(DRedeemItemInfo dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(ERedeemItemInfo... redeemItem) {
            dao.insert(redeemItem[0]);
            return null;
        }
    }

}
