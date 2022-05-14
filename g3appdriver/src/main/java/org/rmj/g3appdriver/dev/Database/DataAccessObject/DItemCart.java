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

    @Query("SELECT COUNT(*) FROM MarketPlace_Cart WHERE sUserIDxx = (SELECT sUserIDxx FROM User_Info_Master)")
    LiveData<Integer> GetCartItemCount();

    @Query("SELECT * FROM MarketPlace_Cart WHERE sUserIDxx = (SELECT sUserIDxx FROM User_Info_Master)")
    LiveData<List<EItemCart>> GetCartItemsList();

    @Query("SELECT * FROM MarketPlace_Cart WHERE sListIDxx=:fsListID")
    EItemCart CheckIFItemExist(String fsListID);

    @Query("UPDATE MarketPlace_Cart SET nQuantity =:fnQty WHERE sListIDxx =:fsListID")
    void UpdateItem(String fsListID, int fnQty);

    @Query("DELETE FROM MarketPlace_Cart WHERE sListIDxx=:fsListID")
    void DeleteCartItem(String fsListID);
}
