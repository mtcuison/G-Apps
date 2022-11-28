package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.dev.Database.Entities.EOrderMaster;

import java.util.List;

@Dao
public interface DOrderMaster {

    @Insert
    void SaveOrderMaster(EOrderMaster foVal);

    @Update
    void UpdateMaster(EOrderMaster foVal);

    @Query("SELECT * FROM MarketPlace_Order_Master WHERE sTransNox=:fsTransNo")
    EOrderMaster CheckOrderMasterIfExist(String fsTransNo);

    @Query("SELECT COUNT(sTransNox) FROM MarketPlace_Order_Master")
    int CheckIfMasterHasRecord();

    @Query("SELECT dTimeStmp FROM MarketPlace_Order_Detail ORDER BY dTimeStmp DESC LIMIT 1")
    String getMasterLatestTimeStmp();

    @Query("SELECT COUNT(*) FROM MarketPlace_Order_Master WHERE cTranStat != '3'")
    LiveData<Integer> GetOrdersCount();

    @Query("SELECT * FROM MarketPlace_Order_Master WHERE sTransNox =:fsTransNo")
    LiveData<EOrderMaster> GetMasterInfo(String fsTransNo);

    @Query("SELECT * FROM MarketPlace_Order_Master WHERE cTranStat =:fcStatus")
    LiveData<List<EOrderMaster>> GetMasterOrderHistory(String fcStatus);

    @Query("SELECT * FROM MarketPlace_Order_Master")
    LiveData<List<EOrderMaster>> GetMasterOrderHistory();

    @Query("SELECT nTranTotl - nProcPaym FROM MarketPlace_Order_Master WHERE sTransNox=:args")
    LiveData<String> GetOrderAmount(String args);

    @Query("SELECT a.sTransNox, " +
            "a.cTranStat, " +
            "a.nTranTotl, " +
            "a.nFreightx, " +
            "a.nAmtPaidx, " +
            "a.nDiscount, " +
            "CASE WHEN a.nProcPaym = '0.00' THEN a.nTranTotl ELSE a.nProcPaym END nProcPaym, " +
            "a.sTermCode, " +
            "b.nEntryNox, " +
            "b.nQuantity, " +
            "b.nUnitPrce, " +
            "b.nDiscount, " +
            "b.nDiscount, " +
            "(SELECT sBriefDsc FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS sBriefDsc, " +
            "(SELECT xBarCodex FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xBarCodex, " +
            "(SELECT sImagesxx FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS sImagesxx, " +
            "(SELECT xBrandNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xBrandNme, " +
            "(SELECT xModelNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xModelNme, " +
            "(SELECT xColorNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xColorNme, " +
            "(SELECT xCategrNm FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xCategrNm " +
            "FROM MarketPlace_Order_Master a " +
            "LEFT JOIN MarketPlace_Order_Detail b " +
            "ON a.sTransNox = b.sTransNox " +
            "WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) " +
            "GROUP BY a.sTransNox " +
            "ORDER BY a.dTimeStmp DESC")
    LiveData<List<OrderHistory>> GetOrderHistoryList();

    @Query("SELECT COUNT(a.sTransNox) FROM MarketPlace_Order_Master a " +
            "WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) " +
            "AND a.sTermCode == '' " +
            "AND a.cTranStat == '0' " +
            "OR a.cPaymType == '2' " +
            "AND a.sTermCode = 'C0W2011' " +
            "AND a.nTranTotl > (SELECT " +
            "CASE WHEN nProcPaym = '0.00' " +
            "THEN nTranTotl " +
            "ELSE nProcPaym " +
            "END nProcPaym FROM MarketPlace_Order_Master WHERE sTransNox = a.sTransNox AND  cPaymType = '2' AND sTermCode = 'C0W2011' AND cTranStat = '0') " +
            "AND a.cTranStat == '0'")
    LiveData<Integer> GetToPayOrdersCount();

    @Query("SELECT COUNT(*) FROM MarketPlace_Order_Master " +
            "WHERE cTranStat = '0' " +
            "AND sAppUsrID = (" +
            "SELECT sUserIDxx FROM Client_Profile_Info)")
    LiveData<Integer> GetProcessingOrdersCount();

    @Query("SELECT COUNT(*) FROM MarketPlace_Order_Master " +
            "WHERE cTranStat = '1' " +
            "AND sAppUsrID = (" +
            "SELECT sUserIDxx FROM Client_Profile_Info)")
    LiveData<Integer> GetToShipOrdersCount();

    @Query("SELECT COUNT(*) FROM MarketPlace_Order_Master " +
            "WHERE cTranStat = '4' " +
            "AND sAppUsrID = (" +
            "SELECT sUserIDxx FROM Client_Profile_Info)")
    LiveData<Integer> GetDeliveredOrdersCount();

    @Query("SELECT COUNT(*) FROM MarketPlace_Order_Master " +
            "WHERE cTranStat = '3' " +
            "AND sAppUsrID = (" +
            "SELECT sUserIDxx FROM Client_Profile_Info)")
    LiveData<Integer> GetCancelledOrdersCount();

    @Query("SELECT a.sTransNox, " +
            "a.cTranStat, " +
            "a.nTranTotl, " +
            "a.nFreightx, " +
            "a.nAmtPaidx, " +
            "a.nDiscount, " +
            "CASE WHEN a.nProcPaym = '0.00' THEN a.nTranTotl ELSE a.nProcPaym END nProcPaym, " +
            "a.sTermCode, " +
            "b.nEntryNox, " +
            "b.nQuantity, " +
            "b.nUnitPrce, " +
            "b.nDiscount, " +
            "(SELECT sBriefDsc FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS sBriefDsc, " +
            "(SELECT xBarCodex FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xBarCodex, " +
            "(SELECT sImagesxx FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS sImagesxx, " +
            "(SELECT xBrandNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xBrandNme, " +
            "(SELECT xModelNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xModelNme, " +
            "(SELECT xColorNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xColorNme, " +
            "(SELECT xCategrNm FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xCategrNm " +
            "FROM MarketPlace_Order_Master a " +
            "LEFT JOIN MarketPlace_Order_Detail b " +
            "ON a.sTransNox = b.sTransNox " +
            "WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) " +
            "AND a.sTermCode != '' " +
            "AND a.cTranStat=:fsVal " +
            "OR a.cPaymType == '2' " +
            "AND a.nTranTotl <= (SELECT " +
                    "CASE WHEN nProcPaym = '0.00' " +
                    "THEN nTranTotl " +
                    "ELSE nProcPaym " +
                    "END nProcPaym FROM MarketPlace_Order_Master WHERE sTransNox = a.sTransNox AND cPaymType = '2' AND sTermCode = 'C0W2011' AND cTranStat = '0') " +
            "GROUP BY a.sTransNox " +
            "ORDER BY a.dTimeStmp DESC")
    LiveData<List<OrderHistory>> GetOrderHistoryList(String fsVal);

    @Query("SELECT a.sTransNox, " +
            "a.cTranStat, " +
            "a.nTranTotl, " +
            "a.nFreightx, " +
            "a.nAmtPaidx, " +
            "a.nDiscount, " +
            "CASE WHEN a.nProcPaym = '0.00' THEN a.nTranTotl ELSE a.nProcPaym END nProcPaym, " +
            "a.sTermCode, " +
            "b.nEntryNox, " +
            "b.nQuantity, " +
            "b.nUnitPrce, " +
            "b.nDiscount, " +
            "c.sBriefDsc, " +
            "c.xBarCodex, " +
            "c.sImagesxx, " +
            "c.xBrandNme, " +
            "c.xModelNme, " +
            "c.xColorNme, " +
            "c.xCategrNm " +
            "FROM MarketPlace_Order_Master a " +
            "LEFT JOIN MarketPlace_Order_Detail b " +
            "ON a.sTransNox = b.sTransNox " +
            "LEFT JOIN Product_Inventory c " +
            "ON b.sStockIDx = c.sStockIDx " +
            "WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) " +
            "AND a.sTermCode == '' " +
            "AND a.cTranStat == '0' " +
            "OR a.cPaymType == '2' " +
            "AND a.nTranTotl > (SELECT " +
            "CASE WHEN nProcPaym = '0.00' " +
            "THEN nTranTotl " +
            "ELSE nProcPaym " +
            "END nProcPaym FROM MarketPlace_Order_Master WHERE sTransNox = a.sTransNox AND cPaymType = '2' AND sTermCode = 'C0W2011' AND cTranStat = '0') " +
            "AND a.sTermCode = 'C0W2011' " +
            "AND a.cTranStat == '0' " +
            "GROUP BY a.sTransNox " +
            "ORDER BY a.dTimeStmp DESC")
    LiveData<List<OrderHistory>> GetToPayOrderList();

    @Query("SELECT a.sTransNox," +
            " a.dTransact," +
            " IFNULL(a.dExpected, ''), dExpected," +
            " a.sReferNox," +
            " a.nTranTotl," +
            " a.nFreightx," +
            " a.nDiscount," +
            " CASE WHEN a.nProcPaym = '0.00' " +
            "THEN a.nTranTotl " +
            "ELSE a.nProcPaym " +
            "END nProcPaym," +
            "(SELECT "+
            "CASE WHEN sTermCode = '' " +
            "THEN 1 "+
            "ELSE 0 END cUnPaidxx FROM MarketPlace_Order_Master " +
            "WHERE sTransNox = a.sTransNox) cUnPaidxx, "+
            "(SELECT CASE "+
            "WHEN nTranTotl > (SELECT CASE nProcPaym WHEN '0.00' " +
            "THEN nTranTotl " +
            "ELSE nProcPaym END cNeedPaym FROM MarketPlace_Order_Master " +
            "WHERE sTransNox = a.sTransNox) "+
            "THEN 1 ELSE 0 END cNeedPaym FROM MarketPlace_Order_Master " +
            "WHERE sTransNox = a.sTransNox) cNeedPaym, "+
            " a.nAmtPaidx," +
            " a.sTermCode," +
            " a.cTranStat," +
            " b.sFrstName || ' ' || b.sMiddName || ' ' || b.sLastName || ' ' || IFNULL(b.sSuffixNm, '') AS sUserName," +
            " IFNULL(b.sHouseNo2, '') || ' ' || IFNULL(b.sAddress2, '') || ' ' || c.sBrgyName || ' ' ||  d.sTownName || ' ' || e.sProvName AS sAddressx," +
            " b.sMobileNo" +
            " FROM MarketPlace_Order_Master a " +
            " LEFT JOIN Client_Profile_Info b " +
            " ON a.sAppUsrID = b.sUserIDxx " +
            " LEFT JOIN Barangay_Info c " +
            " ON b.sBrgyIDx2 = c.sBrgyIDxx" +
            " LEFT JOIN Town_Info d" +
            " ON c.sTownIDxx = d.sTownIDxx" +
            " LEFT JOIN Province_Info e" +
            " ON d.sProvIDxx = e.sProvIDxx " +
            " WHERE a.sTransNox =:fsVal")
    LiveData<DetailedOrderHistory> GetDetailOrderHistory(String fsVal);



    //POJO use for list
    class OrderHistory{
        public String sTransNox;
        public String cTranStat;
        public String nTranTotl;
        public String nFreightx;
        public String nAmtPaidx;
        public String nProcPaym;
        public String sTermCode;
        public String nEntryNox;
        public String nQuantity;
        public String nUnitPrce;
        public String nDiscount;
        public String sBriefDsc;
        public String xBarCodex;
        public String sImagesxx;
        public String xBrandNme;
        public String xModelNme;
        public String xColorNme;
        public String xCategrNm;
    }

    class DetailedOrderHistory{
        public String sTransNox;
        public String dTransact;
        public String dExpected;
        public String sReferNox;
        public String nTranTotl;
        public String nDiscount;
        public String nFreightx;
        public String nProcPaym;
        public String cUnPaidxx;
        public String cNeedPaym;
        public String nAmtPaidx;
        public String sTermCode;
        public String cTranStat;
        public String sUserName;
        public String sAddressx;
        public String sMobileNo;
    }

}
