package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import org.rmj.g3appdriver.dev.Database.Entities.EOrderDetail;

import java.util.List;

@Dao
public interface DOrderDetail {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void SaveDetailOrder(EOrderDetail foVal);

    @Query("SELECT * FROM MarketPlace_Order_Detail WHERE sTransNox =:fsTransNo")
    LiveData<List<EOrderDetail>> GetOrderDetail(String fsTransNo);

    @Query("SELECT COUNT(sTransNox) FROM MarketPlace_Order_Detail")
    int CheckIfDetailHasRecord();

    @Query("SELECT dTimeStmp FROM MarketPlace_Order_Detail ORDER BY dTimeStmp DESC LIMIT 1")
    String getDetailLatestTimeStmp();

    @Query("SELECT * FROM MarketPlace_Order_Detail WHERE sTransNox =:fsTransNo")
    LiveData<List<EOrderDetail>> GetDetailInfo(String fsTransNo);

    @Query("UPDATE MarketPlace_Order_Detail SET cReviewed = '1' WHERE sTransNox =:OrderID AND sReferNox =:ListID")
    void UpdateReviewedItem(String OrderID, String ListID);

    @Query("SELECT a.nEntryNox, " +
            "a.nQuantity, " +
            "a.nUnitPrce, " +
            "a.nDiscount, " +
            "b.sBriefDsc, " +
            "b.xBarCodex, " +
            "b.xBrandNme, " +
            "b.xModelNme, " +
            "b.xColorNme, " +
            "b.xCategrNm, " +
            "c.cTranStat " +
            "FROM MarketPlace_Order_Detail a " +
            "LEFT JOIN Product_Inventory b " +
            "ON a.sReferNox = b.sListngID " +
            "LEFT JOIN MarketPlace_Order_Master c " +
            "ON a.sTransNox = c.sTransNox " +
            "WHERE c.sTransNox =:fsVal " +
            "AND c.sClientID = (" +
            "SELECT sClientID " +
            "FROM Client_Info_Master) " +
            "ORDER BY c.dTransact DESC")
    LiveData<List<OrderHistoryDetail>> GetOrderHistoryDetail(String fsVal);

    @Query("SELECT a.sListngID AS sListIDxx, " +
            "a.xModelNme, " +
            "a.nUnitPrce, " +
            "b.nQuantity, " +
            "b.cReviewed " +
            "FROM Product_Inventory a " +
            "LEFT JOIN MarketPlace_Order_Detail b " +
            "ON a.sListngID = b.sReferNox WHERE b.sTransNox =:fsVal")
    LiveData<List<OrderedItemsInfo>> GetOrderedItems(String fsVal);

    class OrderHistoryDetail{
        public String nEntryNox;
        public String nQuantity;
        public String nUnitPrce;
        public String nDiscount;
        public String sBriefDsc;
        public String xBarCodex;
        public String xBrandNme;
        public String xModelNme;
        public String xColorNme;
        public String xCategrNm;
        public String cTranStat;
    }

    class OrderedItemsInfo{
        public String sListIDxx;
        public String xModelNme;
        public String nUnitPrce;
        public String nQuantity;
        public String cReviewed;
    }
}
