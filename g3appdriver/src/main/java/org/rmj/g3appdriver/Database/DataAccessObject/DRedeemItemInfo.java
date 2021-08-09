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

    @Query("SELECT COUNT(*) FROM Redeem_Item WHERE sGCardNox =:GCardNox AND cTranStat = '0' AND cPlcOrder = '0'")
    LiveData<Integer> getCartItemCount(String GCardNox);

    @Query("UPDATE Redeem_Item SET nItemQtyx = :fnNewCnt, nPointsxx = :fnNewPts WHERE sPromoIDx = :fsPromoId AND sGCardNox = :fsGcardNo")
    void updateItemDetails(String fsGcardNo, String fsPromoId, int fnNewCnt, double fnNewPts);

    @Query("SELECT nItemQtyx AS quantity, nPointsxx AS points FROM Redeem_Item WHERE sPromoIDx = :fsPromoId")
    LiveData<List<ItemDetail>> getExistingItemDetail(String fsPromoId);

    @Query("SELECT C.sPromoIDx, " +
            "C.sBatchNox, " +
            "C.sTransNox, " +
            "C.sGCardNox, " +
            "C.nItemQtyx, " +
            "C.nPointsxx, " +
            "C.sBranchCd, " +
            "C.sReferNox, " +
            "C.dOrderedx, " +
            "C.dPlacOrdr, " +
            "C.dPickupxx, " +
            "C.cTranStat, " +
            "C.cPlcOrder, " +
            "C.cNotified, " +
            "R.sPromoDsc, " +
            "R.nPointsxx AS origPoints, " +
            "R.sImageUrl, " +
            "G.sAvlPoint " +
            "FROM redeem_item as C " +
            "LEFT JOIN redeemables as R " +
            "ON C.sPromoIDx = R.sTransNox " +
            "LEFT JOIN gcard_app_master as G " +
            "ON C.sGCardNox = G.sGCardNox " +
            "WHERE C.cTranStat = '0' " +
            "AND C.sGCardNox = :fsGcardNo")
    LiveData<List<CartItemsDetail>> getCartItemsDetail(String fsGcardNo);

    @Query("SELECT SUM(nPointsxx) FROM redeem_item WHERE cTranStat = '0' " +
            "AND sGCardNox = :fsGcardNo")
    LiveData<Double> getTotalCartPoints(String fsGcardNo);

    @Query("DELETE FROM redeem_item WHERE sPromoIDx = :fsPromoId")
    void removeItemFromCart(String fsPromoId);

    @Query("UPDATE Redeem_Item SET sBranchCd = :fsBranch, cTranStat = '1', cPlcOrder = '1' WHERE sGCardNox = :fsGcardNo")
    void placeOrder(String fsGcardNo ,String fsBranch);

    class ItemDetail {
        public int quantity;
        public double points;
    }

    class CartItemsDetail {
        public String sPromoIDx;
        public String sBatchNox;
        public String sTransNox;
        public String sGCardNox;
        public int nItemQtyx;
        public double nPointsxx;
        public String sBranchCd;
        public String sReferNox;
        public String dOrderedx;
        public String dPlacOrdr;
        public String dPickupxx;
        public String cTranStat;
        public String cPlcOrder;
        public String cNotified;
        public String sPromoDsc;
        public double origPoints;
        public String sImageUrl;
        public String sAvlPoint;
    }
}
