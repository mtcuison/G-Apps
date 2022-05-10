package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import org.rmj.g3appdriver.dev.Database.Entities.EProducts;

import java.util.List;

@Dao
public interface DProduct {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void SaveProductInfo(List<EProducts> foValue);

    @Query("SELECT * FROM Product_Inventory LIMIT 10 OFFSET:nIndex")
    LiveData<List<EProducts>> GetProductList(int nIndex);

    @Query("SELECT * FROM Product_Inventory WHERE sListngID=:fsLstID")
    LiveData<EProducts> GetProductInfo(String fsLstID);

    @Query("UPDATE Product_Inventory " +
            "SET nTotalQty =:nTotalQty, " +
                "nQtyOnHnd =:nQtyOnHnd, " +
                "nResvOrdr =:nResvOrdr, " +
                "nSoldQtyx =:nSoldQtyx, " +
                "nUnitPrce =:nUnitPrce " +
            "WHERE sListngID=:fsLstID")
    void UpdateProductQtyInfo(String fsLstID, String nTotalQty, String nQtyOnHnd,
                            String nResvOrdr, String nSoldQtyx, String nUnitPrce);

    @Query("SELECT sListngID AS sProdctID, " +
            "xBrandNme|| ' ' ||xModelNme  AS sProdctNm, " +
            "nUnitPrce AS sPricexxx, " +
            "nSoldQtyx AS sUntsSold " +
            "FROM Product_Inventory " +
            "LIMIT 10 OFFSET:fnIndex")
    LiveData<List<oProduct>> GetProductsList(int fnIndex);

    @Query("SELECT sListngID AS sProdctID, " +
            "xBrandNme|| ' ' ||xModelNme  AS sProdctNm, " +
            "nUnitPrce AS sPricexxx, " +
            "nSoldQtyx AS sUntsSold " +
            "FROM Product_Inventory " +
            "ORDER BY nUnitPrce ASC " +
            "LIMIT 10 OFFSET:nIndex")
    LiveData<List<oProduct>> GetProductsListPriceSortASC(int nIndex);

    @Query("SELECT sListngID AS sProdctID, " +
            "xBrandNme|| ' ' ||xModelNme  AS sProdctNm, " +
            "nUnitPrce AS sPricexxx, " +
            "nSoldQtyx AS sUntsSold " +
            "FROM Product_Inventory " +
            "ORDER BY nUnitPrce DESC " +
            "LIMIT 10 OFFSET:nIndex ")
    LiveData<List<oProduct>> GetProductsListPriceSortDESC(int nIndex);

    @Query("SELECT sListngID AS sProdctID, " +
            "xBrandNme|| ' ' ||xModelNme  AS sProdctNm, " +
            "nUnitPrce AS sPricexxx," +
            "nSoldQtyx AS sUntsSold " +
            "FROM Product_Inventory " +
            "WHERE xCategrNm =:fsCategory " +
            "LIMIT 10 OFFSET:nIndex")
    LiveData<List<oProduct>> GetProductsListFilterCategory(int nIndex, String fsCategory);

    @Query("SELECT sListngID AS sProdctID, " +
            "xBrandNme|| ' ' ||xModelNme  AS sProdctNm, " +
            "nUnitPrce AS sPricexxx," +
            "nSoldQtyx AS sUntsSold " +
            "FROM Product_Inventory " +
            "WHERE xBrandNme LIKE:fsName " +
            "LIMIT 10 OFFSET:nIndex")
    LiveData<List<oProduct>> GetProductsListFilterBrandName(int nIndex, String fsName);

    @Query("SELECT sListngID AS sProdctID, " +
            "xBrandNme|| ' ' ||xModelNme  AS sProdctNm, " +
            "nUnitPrce AS sPricexxx," +
            "nSoldQtyx AS sUntsSold " +
            "FROM Product_Inventory " +
            "WHERE nUnitPrce BETWEEN :fnFrom AND :fnToxx " +
            "ORDER BY nUnitPrce ASC " +
            "LIMIT 10 OFFSET:nIndex")
    LiveData<List<oProduct>> GetProductsListFilterPriceRange(int nIndex, String fnFrom, String fnToxx);

    class oProduct{
        public String sProdctID;
        public String sProdctNm;
        public String sPricexxx;
        public String sUntsSold;
    }
}
