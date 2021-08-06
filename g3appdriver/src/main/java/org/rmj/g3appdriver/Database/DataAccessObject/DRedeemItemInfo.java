package org.rmj.g3appdriver.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;

import java.util.List;

@Dao
public interface DRedeemItemInfo {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ERedeemItemInfo redeemItemInfo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<ERedeemItemInfo> redeemItemInfoList);

    @Update
    void update(ERedeemItemInfo redeemItemInfo);

    @Query("UPDATE Redeem_Item SET nItemQtyx = :fnNewCnt, nPointsxx = :fnNewPts WHERE sPromoIDx = :fsPromoId AND sGCardNox = :fsGcardNo")
    void updateItemDetails(String fsGcardNo, String fsPromoId, int fnNewCnt, double fnNewPts);

    @Query("SELECT nItemQtyx AS quantity, nPointsxx AS points FROM Redeem_Item WHERE sPromoIDx = :fsPromoId")
    LiveData<List<ItemDetail>> getExistingItemDetail(String fsPromoId);

    class ItemDetail {
        public int quantity;
        public double points;
    }
}
