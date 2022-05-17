package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import org.rmj.g3appdriver.dev.Database.Entities.EItemCart;

import java.util.List;

@Dao
public interface DItemCart {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void SaveItemInfo(EItemCart foVal);

    @Query("SELECT COUNT(*) FROM MarketPlace_Cart WHERE sUserIDxx = (SELECT sUserIDxx FROM Client_Info_Master)")
    LiveData<Integer> GetCartItemCount();

    @Query("SELECT * FROM MarketPlace_Cart WHERE sListIDxx=:fsListID")
    EItemCart CheckIFItemExist(String fsListID);

    @Query("UPDATE MarketPlace_Cart SET nQuantity = nQuantity +:fnQty WHERE sListIDxx =:fsListID")
    void UpdateItem(String fsListID, int fnQty);

    @Query("DELETE FROM MarketPlace_Cart WHERE sListIDxx=:fsListID")
    void DeleteCartItem(String fsListID);

    @Query("DELETE FROM MarketPlace_Cart WHERE cBuyNowxx = '1' AND cCheckOut = '1'")
    void CancelBuyNowItem();

    @Query("UPDATE MarketPlace_Cart SET cCheckOut = '1' WHERE sListIDxx =:fsListID")
    void UpdateForCheckOut(String fsListID);

    @Query("SELECT COUNT(*) FROM MarketPlace_Cart WHERE cCheckOut ='1'")
    int CheckCartItemsForOrder();

    @Query("SELECT a.sListIDxx AS sListIDxx, " +
            "a.nQuantity AS nQuantity, " +
            "b.xModelNme AS xModelNme, " +
            "b.xDescript AS xDescript," +
            "b.nUnitPrce AS nUnitPrce " +
            "FROM MarketPlace_Cart a " +
            "LEFT JOIN Product_Inventory b " +
            "ON a.sListIDxx = b.sListngID " +
            "WHERE a.cBuyNowxx = '0' AND a.cCheckOut = '1'")
    LiveData<List<oMarketplaceCartItem>> GetCartItemsList();

    @Query("SELECT a.sListIDxx AS sListIDxx, " +
            "a.nQuantity AS nQuantity, " +
            "b.xModelNme AS xModelNme, " +
            "b.xDescript AS xDescript," +
            "b.nUnitPrce AS nUnitPrce " +
            "FROM MarketPlace_Cart a " +
            "LEFT JOIN Product_Inventory b " +
            "ON a.sListIDxx = b.sListngID " +
            "WHERE a.cBuyNowxx = '1' AND cCheckOut = '1'")
    LiveData<List<oMarketplaceCartItem>> GetBuyNowItem();

    public class oMarketplaceCartItem{
        public String sListIDxx;
        public String nQuantity;
        public String xModelNme;
        public String xDescript;
        public String nUnitPrce;
        public String cCheckOut;
    }
}
