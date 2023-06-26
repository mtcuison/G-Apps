package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EClientUpdate;
import org.rmj.g3appdriver.GCircle.room.Entities.EDCPCollectionDetail;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DDCPCollectionDetail_Impl implements DDCPCollectionDetail {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EDCPCollectionDetail> __insertionAdapterOfEDCPCollectionDetail;

  private final EntityInsertionAdapter<EDCPCollectionDetail> __insertionAdapterOfEDCPCollectionDetail_1;

  private final EntityDeletionOrUpdateAdapter<EDCPCollectionDetail> __deletionAdapterOfEDCPCollectionDetail;

  private final EntityDeletionOrUpdateAdapter<EDCPCollectionDetail> __updateAdapterOfEDCPCollectionDetail;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCNADetails;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCollectionDetailInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCollectionDetailStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCollectionDetailStatusWithRemarks;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCustomerDetailImage;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNotVisitedCollections;

  public DDCPCollectionDetail_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEDCPCollectionDetail = new EntityInsertionAdapter<EDCPCollectionDetail>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `LR_DCP_Collection_Detail` (`sTransNox`,`nEntryNox`,`sAcctNmbr`,`xFullName`,`sPRNoxxxx`,`nTranAmtx`,`nDiscount`,`nOthersxx`,`sRemarksx`,`sBankIDxx`,`sCheckDte`,`sCheckNox`,`sCheckAct`,`dPromised`,`sRemCodex`,`cTranType`,`nTranTotl`,`sReferNox`,`cPaymForm`,`cIsDCPxxx`,`sMobileNo`,`sHouseNox`,`sAddressx`,`sBrgyName`,`sTownName`,`dPurchase`,`nMonAmort`,`nAmtDuexx`,`cApntUnit`,`sBranchCd`,`dDueDatex`,`sImageNme`,`nLongitud`,`nLatitude`,`sClientID`,`sSerialID`,`sSerialNo`,`nLastPaym`,`dLastPaym`,`nABalance`,`nDelayAvg`,`cTranStat`,`cSendStat`,`dSendDate`,`dModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EDCPCollectionDetail value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        stmt.bindLong(2, value.getEntryNox());
        if (value.getAcctNmbr() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAcctNmbr());
        }
        if (value.getFullName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFullName());
        }
        if (value.getPRNoxxxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPRNoxxxx());
        }
        if (value.getTranAmtx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getTranAmtx());
        }
        if (value.getDiscount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getDiscount());
        }
        if (value.getOthersxx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getOthersxx());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRemarksx());
        }
        if (value.getBankIDxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBankIDxx());
        }
        if (value.getCheckDte() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCheckDte());
        }
        if (value.getCheckNox() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCheckNox());
        }
        if (value.getCheckAct() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCheckAct());
        }
        if (value.getPromised() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getPromised());
        }
        if (value.getRemCodex() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRemCodex());
        }
        if (value.getTranType() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTranType());
        }
        if (value.getTranTotl() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindDouble(17, value.getTranTotl());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getReferNox());
        }
        if (value.getPaymForm() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getPaymForm());
        }
        if (value.getIsDCPxxx() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getIsDCPxxx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getMobileNo());
        }
        if (value.getHouseNox() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getHouseNox());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getAddressx());
        }
        if (value.getBrgyName() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getBrgyName());
        }
        if (value.getTownName() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getTownName());
        }
        if (value.getPurchase() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getPurchase());
        }
        if (value.getMonAmort() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindDouble(27, value.getMonAmort());
        }
        if (value.getAmtDuexx() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindDouble(28, value.getAmtDuexx());
        }
        if (value.getApntUnit() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getApntUnit());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getBranchCd());
        }
        if (value.getDueDatex() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getDueDatex());
        }
        if (value.getImageNme() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getImageNme());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindDouble(33, value.getLongitud());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindDouble(34, value.getLatitude());
        }
        if (value.getClientID() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getClientID());
        }
        if (value.getSerialID() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getSerialID());
        }
        if (value.getSerialNo() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getSerialNo());
        }
        if (value.getLastPaym() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindDouble(38, value.getLastPaym());
        }
        if (value.getLastPaid() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, value.getLastPaid());
        }
        if (value.getABalance() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindString(40, value.getABalance());
        }
        if (value.getDelayAvg() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindDouble(41, value.getDelayAvg());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindString(42, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindString(44, value.getSendDate());
        }
        if (value.getModified() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindString(45, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfEDCPCollectionDetail_1 = new EntityInsertionAdapter<EDCPCollectionDetail>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `LR_DCP_Collection_Detail` (`sTransNox`,`nEntryNox`,`sAcctNmbr`,`xFullName`,`sPRNoxxxx`,`nTranAmtx`,`nDiscount`,`nOthersxx`,`sRemarksx`,`sBankIDxx`,`sCheckDte`,`sCheckNox`,`sCheckAct`,`dPromised`,`sRemCodex`,`cTranType`,`nTranTotl`,`sReferNox`,`cPaymForm`,`cIsDCPxxx`,`sMobileNo`,`sHouseNox`,`sAddressx`,`sBrgyName`,`sTownName`,`dPurchase`,`nMonAmort`,`nAmtDuexx`,`cApntUnit`,`sBranchCd`,`dDueDatex`,`sImageNme`,`nLongitud`,`nLatitude`,`sClientID`,`sSerialID`,`sSerialNo`,`nLastPaym`,`dLastPaym`,`nABalance`,`nDelayAvg`,`cTranStat`,`cSendStat`,`dSendDate`,`dModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EDCPCollectionDetail value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        stmt.bindLong(2, value.getEntryNox());
        if (value.getAcctNmbr() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAcctNmbr());
        }
        if (value.getFullName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFullName());
        }
        if (value.getPRNoxxxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPRNoxxxx());
        }
        if (value.getTranAmtx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getTranAmtx());
        }
        if (value.getDiscount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getDiscount());
        }
        if (value.getOthersxx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getOthersxx());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRemarksx());
        }
        if (value.getBankIDxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBankIDxx());
        }
        if (value.getCheckDte() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCheckDte());
        }
        if (value.getCheckNox() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCheckNox());
        }
        if (value.getCheckAct() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCheckAct());
        }
        if (value.getPromised() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getPromised());
        }
        if (value.getRemCodex() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRemCodex());
        }
        if (value.getTranType() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTranType());
        }
        if (value.getTranTotl() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindDouble(17, value.getTranTotl());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getReferNox());
        }
        if (value.getPaymForm() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getPaymForm());
        }
        if (value.getIsDCPxxx() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getIsDCPxxx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getMobileNo());
        }
        if (value.getHouseNox() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getHouseNox());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getAddressx());
        }
        if (value.getBrgyName() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getBrgyName());
        }
        if (value.getTownName() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getTownName());
        }
        if (value.getPurchase() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getPurchase());
        }
        if (value.getMonAmort() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindDouble(27, value.getMonAmort());
        }
        if (value.getAmtDuexx() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindDouble(28, value.getAmtDuexx());
        }
        if (value.getApntUnit() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getApntUnit());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getBranchCd());
        }
        if (value.getDueDatex() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getDueDatex());
        }
        if (value.getImageNme() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getImageNme());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindDouble(33, value.getLongitud());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindDouble(34, value.getLatitude());
        }
        if (value.getClientID() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getClientID());
        }
        if (value.getSerialID() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getSerialID());
        }
        if (value.getSerialNo() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getSerialNo());
        }
        if (value.getLastPaym() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindDouble(38, value.getLastPaym());
        }
        if (value.getLastPaid() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, value.getLastPaid());
        }
        if (value.getABalance() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindString(40, value.getABalance());
        }
        if (value.getDelayAvg() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindDouble(41, value.getDelayAvg());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindString(42, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindString(44, value.getSendDate());
        }
        if (value.getModified() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindString(45, value.getModified());
        }
      }
    };
    this.__deletionAdapterOfEDCPCollectionDetail = new EntityDeletionOrUpdateAdapter<EDCPCollectionDetail>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `LR_DCP_Collection_Detail` WHERE `sTransNox` = ? AND `nEntryNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EDCPCollectionDetail value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        stmt.bindLong(2, value.getEntryNox());
      }
    };
    this.__updateAdapterOfEDCPCollectionDetail = new EntityDeletionOrUpdateAdapter<EDCPCollectionDetail>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `LR_DCP_Collection_Detail` SET `sTransNox` = ?,`nEntryNox` = ?,`sAcctNmbr` = ?,`xFullName` = ?,`sPRNoxxxx` = ?,`nTranAmtx` = ?,`nDiscount` = ?,`nOthersxx` = ?,`sRemarksx` = ?,`sBankIDxx` = ?,`sCheckDte` = ?,`sCheckNox` = ?,`sCheckAct` = ?,`dPromised` = ?,`sRemCodex` = ?,`cTranType` = ?,`nTranTotl` = ?,`sReferNox` = ?,`cPaymForm` = ?,`cIsDCPxxx` = ?,`sMobileNo` = ?,`sHouseNox` = ?,`sAddressx` = ?,`sBrgyName` = ?,`sTownName` = ?,`dPurchase` = ?,`nMonAmort` = ?,`nAmtDuexx` = ?,`cApntUnit` = ?,`sBranchCd` = ?,`dDueDatex` = ?,`sImageNme` = ?,`nLongitud` = ?,`nLatitude` = ?,`sClientID` = ?,`sSerialID` = ?,`sSerialNo` = ?,`nLastPaym` = ?,`dLastPaym` = ?,`nABalance` = ?,`nDelayAvg` = ?,`cTranStat` = ?,`cSendStat` = ?,`dSendDate` = ?,`dModified` = ? WHERE `sTransNox` = ? AND `nEntryNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EDCPCollectionDetail value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        stmt.bindLong(2, value.getEntryNox());
        if (value.getAcctNmbr() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAcctNmbr());
        }
        if (value.getFullName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFullName());
        }
        if (value.getPRNoxxxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPRNoxxxx());
        }
        if (value.getTranAmtx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getTranAmtx());
        }
        if (value.getDiscount() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getDiscount());
        }
        if (value.getOthersxx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindDouble(8, value.getOthersxx());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRemarksx());
        }
        if (value.getBankIDxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBankIDxx());
        }
        if (value.getCheckDte() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCheckDte());
        }
        if (value.getCheckNox() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCheckNox());
        }
        if (value.getCheckAct() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCheckAct());
        }
        if (value.getPromised() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getPromised());
        }
        if (value.getRemCodex() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getRemCodex());
        }
        if (value.getTranType() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTranType());
        }
        if (value.getTranTotl() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindDouble(17, value.getTranTotl());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getReferNox());
        }
        if (value.getPaymForm() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getPaymForm());
        }
        if (value.getIsDCPxxx() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getIsDCPxxx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getMobileNo());
        }
        if (value.getHouseNox() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getHouseNox());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getAddressx());
        }
        if (value.getBrgyName() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getBrgyName());
        }
        if (value.getTownName() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getTownName());
        }
        if (value.getPurchase() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getPurchase());
        }
        if (value.getMonAmort() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindDouble(27, value.getMonAmort());
        }
        if (value.getAmtDuexx() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindDouble(28, value.getAmtDuexx());
        }
        if (value.getApntUnit() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getApntUnit());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getBranchCd());
        }
        if (value.getDueDatex() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getDueDatex());
        }
        if (value.getImageNme() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getImageNme());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindDouble(33, value.getLongitud());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindDouble(34, value.getLatitude());
        }
        if (value.getClientID() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getClientID());
        }
        if (value.getSerialID() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getSerialID());
        }
        if (value.getSerialNo() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getSerialNo());
        }
        if (value.getLastPaym() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindDouble(38, value.getLastPaym());
        }
        if (value.getLastPaid() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, value.getLastPaid());
        }
        if (value.getABalance() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindString(40, value.getABalance());
        }
        if (value.getDelayAvg() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindDouble(41, value.getDelayAvg());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindString(42, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindString(44, value.getSendDate());
        }
        if (value.getModified() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindString(45, value.getModified());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(46);
        } else {
          stmt.bindString(46, value.getTransNox());
        }
        stmt.bindLong(47, value.getEntryNox());
      }
    };
    this.__preparedStmtOfUpdateCNADetails = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE LR_DCP_Collection_Detail SET sRemCodex = 'CNA', sRemarksx =?, cTranStat = '1',dModified =? WHERE sTransNox =(SELECT sTransNox FROM LR_DCP_Collection_Master WHERE cSendStat IS NULL) AND sAcctNmbr =? AND nEntryNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCollectionDetailInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE LR_DCP_Collection_Detail SET sRemCodex =?, sRemarksx =?, cSendStat = '0', cTranStat = '1', sImageNme = (SELECT a.sImageNme FROM Image_Information a LEFT JOIN LR_DCP_Collection_Detail b  ON a.sSourceNo = b.sTransNox AND a.sDtlSrcNo = sAcctNmbr WHERE a.sSourceNo = b.sTransNox AND b.nEntryNox =?), nLongitud = (SELECT a.nLongitud FROM Image_Information a LEFT JOIN LR_DCP_Collection_Detail b  ON a.sDtlSrcNo = sAcctNmbr WHERE a.sSourceNo = b.sTransNox), nLatitude = (SELECT a.nLatitude FROM Image_Information a LEFT JOIN LR_DCP_Collection_Detail b  ON a.sDtlSrcNo = sAcctNmbr WHERE a.sSourceNo = b.sTransNox), dModified =? WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master ORDER BY dReferDte DESC LIMIT 1) AND nEntryNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCollectionDetailStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE LR_DCP_Collection_Detail SET cSendStat='1', cTranstat = '2', dSendDate =?, dModified =? WHERE sTransNox =? AND nEntryNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCollectionDetailStatusWithRemarks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE LR_DCP_Collection_Detail SET cSendStat='1', sRemCodex = 'NV', sRemarksx =?, cTranstat = '2', dModified=? WHERE sTransNox =? AND nEntryNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCustomerDetailImage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE LR_DCP_Collection_Detail SET sImageNme= (SELECT a.sTransNox FROM Image_Information a LEFT JOIN LR_DCP_Collection_Detail b  ON a.sSourceNo = b.sTransNox AND a.sDtlSrcNo = sAcctNmbr WHERE a.sSourceNo = b.sTransNox) WHERE sAcctNmbr =? AND sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master ORDER BY dTransact DESC LIMIT 1)";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNotVisitedCollections = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE LR_DCP_Collection_Detail SET sRemCodex = 'NV', sRemarksx =?, dModified =? WHERE sTransNox =? AND sRemCodex = ''";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EDCPCollectionDetail collectionDetail) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEDCPCollectionDetail.insert(collectionDetail);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EDCPCollectionDetail> collectionDetails) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEDCPCollectionDetail_1.insert(collectionDetails);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final EDCPCollectionDetail collectionDetail) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEDCPCollectionDetail.handle(collectionDetail);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EDCPCollectionDetail collectionDetail) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEDCPCollectionDetail.handle(collectionDetail);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateCNADetails(final String AccNmbr, final int EntryNo, final String Remarks,
      final String DateTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCNADetails.acquire();
    int _argIndex = 1;
    if (Remarks == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Remarks);
    }
    _argIndex = 2;
    if (DateTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateTime);
    }
    _argIndex = 3;
    if (AccNmbr == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, AccNmbr);
    }
    _argIndex = 4;
    _stmt.bindLong(_argIndex, EntryNo);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCNADetails.release(_stmt);
    }
  }

  @Override
  public void updateCollectionDetailInfo(final int EntryNox, final String RemCode,
      final String Remarks, final String DateModified) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCollectionDetailInfo.acquire();
    int _argIndex = 1;
    if (RemCode == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, RemCode);
    }
    _argIndex = 2;
    if (Remarks == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Remarks);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, EntryNox);
    _argIndex = 4;
    if (DateModified == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateModified);
    }
    _argIndex = 5;
    _stmt.bindLong(_argIndex, EntryNox);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCollectionDetailInfo.release(_stmt);
    }
  }

  @Override
  public void updateCollectionDetailStatus(final String TransNox, final int EntryNox,
      final String DateEntry) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCollectionDetailStatus.acquire();
    int _argIndex = 1;
    if (DateEntry == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateEntry);
    }
    _argIndex = 2;
    if (DateEntry == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateEntry);
    }
    _argIndex = 3;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 4;
    _stmt.bindLong(_argIndex, EntryNox);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCollectionDetailStatus.release(_stmt);
    }
  }

  @Override
  public void updateCollectionDetailStatusWithRemarks(final String TransNox, final int EntryNox,
      final String DateEntry, final String Remarks) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCollectionDetailStatusWithRemarks.acquire();
    int _argIndex = 1;
    if (Remarks == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Remarks);
    }
    _argIndex = 2;
    if (DateEntry == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateEntry);
    }
    _argIndex = 3;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 4;
    _stmt.bindLong(_argIndex, EntryNox);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCollectionDetailStatusWithRemarks.release(_stmt);
    }
  }

  @Override
  public void updateCustomerDetailImage(final String AccountNo) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCustomerDetailImage.acquire();
    int _argIndex = 1;
    if (AccountNo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, AccountNo);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCustomerDetailImage.release(_stmt);
    }
  }

  @Override
  public void updateNotVisitedCollections(final String Remarks, final String TransNox,
      final String dModfied) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNotVisitedCollections.acquire();
    int _argIndex = 1;
    if (Remarks == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Remarks);
    }
    _argIndex = 2;
    if (dModfied == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, dModfied);
    }
    _argIndex = 3;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateNotVisitedCollections.release(_stmt);
    }
  }

  @Override
  public EDCPCollectionDetail GetCollectionDetail(final String TransNox, final String EntryNo,
      final String AcctNox) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox=? AND nEntryNox=? AND sAcctNmbr=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (EntryNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, EntryNo);
    }
    _argIndex = 3;
    if (AcctNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AcctNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EDCPCollectionDetail _result;
      if(_cursor.moveToFirst()) {
        _result = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _result.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _result.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _result.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _result.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _result.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _result.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _result.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _result.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _result.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _result.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _result.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _result.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _result.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _result.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _result.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _result.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _result.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _result.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _result.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _result.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _result.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _result.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _result.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _result.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _result.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _result.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _result.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _result.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _result.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _result.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _result.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getClientDuplicateAccNox(final String AccountNox) {
    final String _sql = "SELECT sAcctNmbr FROM LR_DCP_Collection_Detail WHERE sAcctNmbr =? AND sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master ORDER BY dReferDte DESC LIMIT 1)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (AccountNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AccountNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getClientDuplicateSerialNox(final String SerialNox) {
    final String _sql = "SELECT sSerialNo FROM LR_DCP_Collection_Detail WHERE sSerialNo =? AND sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master ORDER BY dReferDte DESC LIMIT 1)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (SerialNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, SerialNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getAccountNoCount(final String TransNox) {
    final String _sql = "SELECT COUNT(*) FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND sAcctNmbr != ''";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int getUnsentCollectionDetail(final String TransNox) {
    final String _sql = "SELECT COUNT(*) FROM LR_DCP_Collection_Detail WHERE cSendStat = '0' AND sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getMasterSendStatus(final String TransNox) {
    final String _sql = "SELECT cSendStat FROM LR_DCP_Collection_Master WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getUnpostedDcpMaster() {
    final String _sql = "SELECT sTransNox FROM LR_DCP_Collection_Master WHERE cSendStat IS NULL ORDER BY dReferDte DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<EDCPCollectionDetail>> getCollectionDetailList() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE cTranStat != '2' ORDER BY dModified ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail"}, false, new Callable<List<EDCPCollectionDetail>>() {
      @Override
      public List<EDCPCollectionDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
          final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
          final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
          final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
          final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
          final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
          final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
          final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
          final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
          final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
          final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
          final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
          final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
          final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
          final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
          final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EDCPCollectionDetail _item;
            _item = new EDCPCollectionDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpAcctNmbr;
            if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
              _tmpAcctNmbr = null;
            } else {
              _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
            }
            _item.setAcctNmbr(_tmpAcctNmbr);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _item.setFullName(_tmpFullName);
            final String _tmpPRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
              _tmpPRNoxxxx = null;
            } else {
              _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
            }
            _item.setPRNoxxxx(_tmpPRNoxxxx);
            final Double _tmpTranAmtx;
            if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
              _tmpTranAmtx = null;
            } else {
              _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
            }
            _item.setTranAmtx(_tmpTranAmtx);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _item.setDiscount(_tmpDiscount);
            final Double _tmpOthersxx;
            if (_cursor.isNull(_cursorIndexOfOthersxx)) {
              _tmpOthersxx = null;
            } else {
              _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
            }
            _item.setOthersxx(_tmpOthersxx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpBankIDxx;
            if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
              _tmpBankIDxx = null;
            } else {
              _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
            }
            _item.setBankIDxx(_tmpBankIDxx);
            final String _tmpCheckDte;
            if (_cursor.isNull(_cursorIndexOfCheckDte)) {
              _tmpCheckDte = null;
            } else {
              _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
            }
            _item.setCheckDte(_tmpCheckDte);
            final String _tmpCheckNox;
            if (_cursor.isNull(_cursorIndexOfCheckNox)) {
              _tmpCheckNox = null;
            } else {
              _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
            }
            _item.setCheckNox(_tmpCheckNox);
            final String _tmpCheckAct;
            if (_cursor.isNull(_cursorIndexOfCheckAct)) {
              _tmpCheckAct = null;
            } else {
              _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
            }
            _item.setCheckAct(_tmpCheckAct);
            final String _tmpPromised;
            if (_cursor.isNull(_cursorIndexOfPromised)) {
              _tmpPromised = null;
            } else {
              _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
            }
            _item.setPromised(_tmpPromised);
            final String _tmpRemCodex;
            if (_cursor.isNull(_cursorIndexOfRemCodex)) {
              _tmpRemCodex = null;
            } else {
              _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
            }
            _item.setRemCodex(_tmpRemCodex);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _item.setTranType(_tmpTranType);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _item.setTranTotl(_tmpTranTotl);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpPaymForm;
            if (_cursor.isNull(_cursorIndexOfPaymForm)) {
              _tmpPaymForm = null;
            } else {
              _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
            }
            _item.setPaymForm(_tmpPaymForm);
            final String _tmpIsDCPxxx;
            if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
              _tmpIsDCPxxx = null;
            } else {
              _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
            }
            _item.setIsDCPxxx(_tmpIsDCPxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _item.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _item.setBrgyName(_tmpBrgyName);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _item.setPurchase(_tmpPurchase);
            final Double _tmpMonAmort;
            if (_cursor.isNull(_cursorIndexOfMonAmort)) {
              _tmpMonAmort = null;
            } else {
              _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
            }
            _item.setMonAmort(_tmpMonAmort);
            final Double _tmpAmtDuexx;
            if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
              _tmpAmtDuexx = null;
            } else {
              _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
            }
            _item.setAmtDuexx(_tmpAmtDuexx);
            final String _tmpApntUnit;
            if (_cursor.isNull(_cursorIndexOfApntUnit)) {
              _tmpApntUnit = null;
            } else {
              _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
            }
            _item.setApntUnit(_tmpApntUnit);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _item.setDueDatex(_tmpDueDatex);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _item.setImageNme(_tmpImageNme);
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            _item.setLongitud(_tmpLongitud);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            _item.setLatitude(_tmpLatitude);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _item.setClientID(_tmpClientID);
            final String _tmpSerialID;
            if (_cursor.isNull(_cursorIndexOfSerialID)) {
              _tmpSerialID = null;
            } else {
              _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
            }
            _item.setSerialID(_tmpSerialID);
            final String _tmpSerialNo;
            if (_cursor.isNull(_cursorIndexOfSerialNo)) {
              _tmpSerialNo = null;
            } else {
              _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
            }
            _item.setSerialNo(_tmpSerialNo);
            final Double _tmpLastPaym;
            if (_cursor.isNull(_cursorIndexOfLastPaym)) {
              _tmpLastPaym = null;
            } else {
              _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
            }
            _item.setLastPaym(_tmpLastPaym);
            final String _tmpLastPaid;
            if (_cursor.isNull(_cursorIndexOfLastPaid)) {
              _tmpLastPaid = null;
            } else {
              _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
            }
            _item.setLastPaid(_tmpLastPaid);
            final String _tmpABalance;
            if (_cursor.isNull(_cursorIndexOfABalance)) {
              _tmpABalance = null;
            } else {
              _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
            }
            _item.setABalance(_tmpABalance);
            final Double _tmpDelayAvg;
            if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
              _tmpDelayAvg = null;
            } else {
              _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
            }
            _item.setDelayAvg(_tmpDelayAvg);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<EClientUpdate> getClient_Update_Info(final String AccountNox) {
    final String _sql = "SELECT * FROM Client_Update_Request WHERE sDtlSrcNo = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (AccountNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AccountNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Client_Update_Request"}, false, new Callable<EClientUpdate>() {
      @Override
      public EClientUpdate call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSourceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCd");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "sLastName");
          final int _cursorIndexOfFrstName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFrstName");
          final int _cursorIndexOfMiddName = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiddName");
          final int _cursorIndexOfSuffixNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSuffixNm");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBarangay = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarangay");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfGenderxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cGenderxx");
          final int _cursorIndexOfCivlStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cCivlStat");
          final int _cursorIndexOfBirthDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthDte");
          final int _cursorIndexOfBirthPlc = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthPlc");
          final int _cursorIndexOfLandline = CursorUtil.getColumnIndexOrThrow(_cursor, "sLandline");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EClientUpdate _result;
          if(_cursor.moveToFirst()) {
            _result = new EClientUpdate();
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _result.setClientID(_tmpClientID);
            final String _tmpSourceCd;
            if (_cursor.isNull(_cursorIndexOfSourceCd)) {
              _tmpSourceCd = null;
            } else {
              _tmpSourceCd = _cursor.getString(_cursorIndexOfSourceCd);
            }
            _result.setSourceCd(_tmpSourceCd);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _result.setSourceNo(_tmpSourceNo);
            final String _tmpDtlSrcNo;
            if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
              _tmpDtlSrcNo = null;
            } else {
              _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
            }
            _result.setDtlSrcNo(_tmpDtlSrcNo);
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            _result.setLastName(_tmpLastName);
            final String _tmpFrstName;
            if (_cursor.isNull(_cursorIndexOfFrstName)) {
              _tmpFrstName = null;
            } else {
              _tmpFrstName = _cursor.getString(_cursorIndexOfFrstName);
            }
            _result.setFrstName(_tmpFrstName);
            final String _tmpMiddName;
            if (_cursor.isNull(_cursorIndexOfMiddName)) {
              _tmpMiddName = null;
            } else {
              _tmpMiddName = _cursor.getString(_cursorIndexOfMiddName);
            }
            _result.setMiddName(_tmpMiddName);
            final String _tmpSuffixNm;
            if (_cursor.isNull(_cursorIndexOfSuffixNm)) {
              _tmpSuffixNm = null;
            } else {
              _tmpSuffixNm = _cursor.getString(_cursorIndexOfSuffixNm);
            }
            _result.setSuffixNm(_tmpSuffixNm);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _result.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpBarangay;
            if (_cursor.isNull(_cursorIndexOfBarangay)) {
              _tmpBarangay = null;
            } else {
              _tmpBarangay = _cursor.getString(_cursorIndexOfBarangay);
            }
            _result.setBarangay(_tmpBarangay);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _result.setTownIDxx(_tmpTownIDxx);
            final String _tmpGenderxx;
            if (_cursor.isNull(_cursorIndexOfGenderxx)) {
              _tmpGenderxx = null;
            } else {
              _tmpGenderxx = _cursor.getString(_cursorIndexOfGenderxx);
            }
            _result.setGenderxx(_tmpGenderxx);
            final String _tmpCivlStat;
            if (_cursor.isNull(_cursorIndexOfCivlStat)) {
              _tmpCivlStat = null;
            } else {
              _tmpCivlStat = _cursor.getString(_cursorIndexOfCivlStat);
            }
            _result.setCivlStat(_tmpCivlStat);
            final String _tmpBirthDte;
            if (_cursor.isNull(_cursorIndexOfBirthDte)) {
              _tmpBirthDte = null;
            } else {
              _tmpBirthDte = _cursor.getString(_cursorIndexOfBirthDte);
            }
            _result.setBirthDte(_tmpBirthDte);
            final String _tmpBirthPlc;
            if (_cursor.isNull(_cursorIndexOfBirthPlc)) {
              _tmpBirthPlc = null;
            } else {
              _tmpBirthPlc = _cursor.getString(_cursorIndexOfBirthPlc);
            }
            _result.setBirthPlc(_tmpBirthPlc);
            final String _tmpLandline;
            if (_cursor.isNull(_cursorIndexOfLandline)) {
              _tmpLandline = null;
            } else {
              _tmpLandline = _cursor.getString(_cursorIndexOfLandline);
            }
            _result.setLandline(_tmpLandline);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _result.setEmailAdd(_tmpEmailAdd);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _result.setImageNme(_tmpImageNme);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<EDCPCollectionDetail>> getCollectionDetailLog() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE cSendStat = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail"}, false, new Callable<List<EDCPCollectionDetail>>() {
      @Override
      public List<EDCPCollectionDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
          final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
          final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
          final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
          final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
          final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
          final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
          final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
          final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
          final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
          final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
          final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
          final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
          final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
          final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
          final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EDCPCollectionDetail _item;
            _item = new EDCPCollectionDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpAcctNmbr;
            if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
              _tmpAcctNmbr = null;
            } else {
              _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
            }
            _item.setAcctNmbr(_tmpAcctNmbr);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _item.setFullName(_tmpFullName);
            final String _tmpPRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
              _tmpPRNoxxxx = null;
            } else {
              _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
            }
            _item.setPRNoxxxx(_tmpPRNoxxxx);
            final Double _tmpTranAmtx;
            if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
              _tmpTranAmtx = null;
            } else {
              _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
            }
            _item.setTranAmtx(_tmpTranAmtx);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _item.setDiscount(_tmpDiscount);
            final Double _tmpOthersxx;
            if (_cursor.isNull(_cursorIndexOfOthersxx)) {
              _tmpOthersxx = null;
            } else {
              _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
            }
            _item.setOthersxx(_tmpOthersxx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpBankIDxx;
            if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
              _tmpBankIDxx = null;
            } else {
              _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
            }
            _item.setBankIDxx(_tmpBankIDxx);
            final String _tmpCheckDte;
            if (_cursor.isNull(_cursorIndexOfCheckDte)) {
              _tmpCheckDte = null;
            } else {
              _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
            }
            _item.setCheckDte(_tmpCheckDte);
            final String _tmpCheckNox;
            if (_cursor.isNull(_cursorIndexOfCheckNox)) {
              _tmpCheckNox = null;
            } else {
              _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
            }
            _item.setCheckNox(_tmpCheckNox);
            final String _tmpCheckAct;
            if (_cursor.isNull(_cursorIndexOfCheckAct)) {
              _tmpCheckAct = null;
            } else {
              _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
            }
            _item.setCheckAct(_tmpCheckAct);
            final String _tmpPromised;
            if (_cursor.isNull(_cursorIndexOfPromised)) {
              _tmpPromised = null;
            } else {
              _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
            }
            _item.setPromised(_tmpPromised);
            final String _tmpRemCodex;
            if (_cursor.isNull(_cursorIndexOfRemCodex)) {
              _tmpRemCodex = null;
            } else {
              _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
            }
            _item.setRemCodex(_tmpRemCodex);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _item.setTranType(_tmpTranType);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _item.setTranTotl(_tmpTranTotl);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpPaymForm;
            if (_cursor.isNull(_cursorIndexOfPaymForm)) {
              _tmpPaymForm = null;
            } else {
              _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
            }
            _item.setPaymForm(_tmpPaymForm);
            final String _tmpIsDCPxxx;
            if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
              _tmpIsDCPxxx = null;
            } else {
              _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
            }
            _item.setIsDCPxxx(_tmpIsDCPxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _item.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _item.setBrgyName(_tmpBrgyName);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _item.setPurchase(_tmpPurchase);
            final Double _tmpMonAmort;
            if (_cursor.isNull(_cursorIndexOfMonAmort)) {
              _tmpMonAmort = null;
            } else {
              _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
            }
            _item.setMonAmort(_tmpMonAmort);
            final Double _tmpAmtDuexx;
            if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
              _tmpAmtDuexx = null;
            } else {
              _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
            }
            _item.setAmtDuexx(_tmpAmtDuexx);
            final String _tmpApntUnit;
            if (_cursor.isNull(_cursorIndexOfApntUnit)) {
              _tmpApntUnit = null;
            } else {
              _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
            }
            _item.setApntUnit(_tmpApntUnit);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _item.setDueDatex(_tmpDueDatex);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _item.setImageNme(_tmpImageNme);
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            _item.setLongitud(_tmpLongitud);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            _item.setLatitude(_tmpLatitude);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _item.setClientID(_tmpClientID);
            final String _tmpSerialID;
            if (_cursor.isNull(_cursorIndexOfSerialID)) {
              _tmpSerialID = null;
            } else {
              _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
            }
            _item.setSerialID(_tmpSerialID);
            final String _tmpSerialNo;
            if (_cursor.isNull(_cursorIndexOfSerialNo)) {
              _tmpSerialNo = null;
            } else {
              _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
            }
            _item.setSerialNo(_tmpSerialNo);
            final Double _tmpLastPaym;
            if (_cursor.isNull(_cursorIndexOfLastPaym)) {
              _tmpLastPaym = null;
            } else {
              _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
            }
            _item.setLastPaym(_tmpLastPaym);
            final String _tmpLastPaid;
            if (_cursor.isNull(_cursorIndexOfLastPaid)) {
              _tmpLastPaid = null;
            } else {
              _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
            }
            _item.setLastPaid(_tmpLastPaid);
            final String _tmpABalance;
            if (_cursor.isNull(_cursorIndexOfABalance)) {
              _tmpABalance = null;
            } else {
              _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
            }
            _item.setABalance(_tmpABalance);
            final Double _tmpDelayAvg;
            if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
              _tmpDelayAvg = null;
            } else {
              _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
            }
            _item.setDelayAvg(_tmpDelayAvg);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<EDCPCollectionDetail> getCollectionDetail(final String TransNox,
      final int EntryNox) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = ? AND nEntryNox = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, EntryNox);
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail"}, false, new Callable<EDCPCollectionDetail>() {
      @Override
      public EDCPCollectionDetail call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
          final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
          final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
          final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
          final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
          final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
          final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
          final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
          final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
          final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
          final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
          final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
          final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
          final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
          final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
          final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EDCPCollectionDetail _result;
          if(_cursor.moveToFirst()) {
            _result = new EDCPCollectionDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _result.setEntryNox(_tmpEntryNox);
            final String _tmpAcctNmbr;
            if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
              _tmpAcctNmbr = null;
            } else {
              _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
            }
            _result.setAcctNmbr(_tmpAcctNmbr);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _result.setFullName(_tmpFullName);
            final String _tmpPRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
              _tmpPRNoxxxx = null;
            } else {
              _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
            }
            _result.setPRNoxxxx(_tmpPRNoxxxx);
            final Double _tmpTranAmtx;
            if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
              _tmpTranAmtx = null;
            } else {
              _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
            }
            _result.setTranAmtx(_tmpTranAmtx);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _result.setDiscount(_tmpDiscount);
            final Double _tmpOthersxx;
            if (_cursor.isNull(_cursorIndexOfOthersxx)) {
              _tmpOthersxx = null;
            } else {
              _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
            }
            _result.setOthersxx(_tmpOthersxx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final String _tmpBankIDxx;
            if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
              _tmpBankIDxx = null;
            } else {
              _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
            }
            _result.setBankIDxx(_tmpBankIDxx);
            final String _tmpCheckDte;
            if (_cursor.isNull(_cursorIndexOfCheckDte)) {
              _tmpCheckDte = null;
            } else {
              _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
            }
            _result.setCheckDte(_tmpCheckDte);
            final String _tmpCheckNox;
            if (_cursor.isNull(_cursorIndexOfCheckNox)) {
              _tmpCheckNox = null;
            } else {
              _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
            }
            _result.setCheckNox(_tmpCheckNox);
            final String _tmpCheckAct;
            if (_cursor.isNull(_cursorIndexOfCheckAct)) {
              _tmpCheckAct = null;
            } else {
              _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
            }
            _result.setCheckAct(_tmpCheckAct);
            final String _tmpPromised;
            if (_cursor.isNull(_cursorIndexOfPromised)) {
              _tmpPromised = null;
            } else {
              _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
            }
            _result.setPromised(_tmpPromised);
            final String _tmpRemCodex;
            if (_cursor.isNull(_cursorIndexOfRemCodex)) {
              _tmpRemCodex = null;
            } else {
              _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
            }
            _result.setRemCodex(_tmpRemCodex);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _result.setTranType(_tmpTranType);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _result.setTranTotl(_tmpTranTotl);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _result.setReferNox(_tmpReferNox);
            final String _tmpPaymForm;
            if (_cursor.isNull(_cursorIndexOfPaymForm)) {
              _tmpPaymForm = null;
            } else {
              _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
            }
            _result.setPaymForm(_tmpPaymForm);
            final String _tmpIsDCPxxx;
            if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
              _tmpIsDCPxxx = null;
            } else {
              _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
            }
            _result.setIsDCPxxx(_tmpIsDCPxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _result.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _result.setBrgyName(_tmpBrgyName);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _result.setTownName(_tmpTownName);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _result.setPurchase(_tmpPurchase);
            final Double _tmpMonAmort;
            if (_cursor.isNull(_cursorIndexOfMonAmort)) {
              _tmpMonAmort = null;
            } else {
              _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
            }
            _result.setMonAmort(_tmpMonAmort);
            final Double _tmpAmtDuexx;
            if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
              _tmpAmtDuexx = null;
            } else {
              _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
            }
            _result.setAmtDuexx(_tmpAmtDuexx);
            final String _tmpApntUnit;
            if (_cursor.isNull(_cursorIndexOfApntUnit)) {
              _tmpApntUnit = null;
            } else {
              _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
            }
            _result.setApntUnit(_tmpApntUnit);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _result.setDueDatex(_tmpDueDatex);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _result.setImageNme(_tmpImageNme);
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            _result.setLongitud(_tmpLongitud);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            _result.setLatitude(_tmpLatitude);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _result.setClientID(_tmpClientID);
            final String _tmpSerialID;
            if (_cursor.isNull(_cursorIndexOfSerialID)) {
              _tmpSerialID = null;
            } else {
              _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
            }
            _result.setSerialID(_tmpSerialID);
            final String _tmpSerialNo;
            if (_cursor.isNull(_cursorIndexOfSerialNo)) {
              _tmpSerialNo = null;
            } else {
              _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
            }
            _result.setSerialNo(_tmpSerialNo);
            final Double _tmpLastPaym;
            if (_cursor.isNull(_cursorIndexOfLastPaym)) {
              _tmpLastPaym = null;
            } else {
              _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
            }
            _result.setLastPaym(_tmpLastPaym);
            final String _tmpLastPaid;
            if (_cursor.isNull(_cursorIndexOfLastPaid)) {
              _tmpLastPaid = null;
            } else {
              _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
            }
            _result.setLastPaid(_tmpLastPaid);
            final String _tmpABalance;
            if (_cursor.isNull(_cursorIndexOfABalance)) {
              _tmpABalance = null;
            } else {
              _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
            }
            _result.setABalance(_tmpABalance);
            final Double _tmpDelayAvg;
            if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
              _tmpDelayAvg = null;
            } else {
              _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
            }
            _result.setDelayAvg(_tmpDelayAvg);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _result.setSendDate(_tmpSendDate);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public EDCPCollectionDetail getCollectionDetail(final String TransNox, final String Account) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND sAcctNmbr=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (Account == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Account);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EDCPCollectionDetail _result;
      if(_cursor.moveToFirst()) {
        _result = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _result.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _result.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _result.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _result.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _result.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _result.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _result.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _result.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _result.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _result.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _result.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _result.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _result.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _result.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _result.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _result.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _result.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _result.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _result.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _result.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _result.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _result.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _result.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _result.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _result.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _result.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _result.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _result.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _result.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _result.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _result.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<EDCPCollectionDetail> getCollectionLastEntry(final String dReferDte) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?) ORDER BY nEntryNox DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dReferDte == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dReferDte);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","LR_DCP_Collection_Master"}, false, new Callable<EDCPCollectionDetail>() {
      @Override
      public EDCPCollectionDetail call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
          final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
          final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
          final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
          final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
          final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
          final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
          final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
          final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
          final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
          final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
          final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
          final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
          final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
          final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
          final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EDCPCollectionDetail _result;
          if(_cursor.moveToFirst()) {
            _result = new EDCPCollectionDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _result.setEntryNox(_tmpEntryNox);
            final String _tmpAcctNmbr;
            if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
              _tmpAcctNmbr = null;
            } else {
              _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
            }
            _result.setAcctNmbr(_tmpAcctNmbr);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _result.setFullName(_tmpFullName);
            final String _tmpPRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
              _tmpPRNoxxxx = null;
            } else {
              _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
            }
            _result.setPRNoxxxx(_tmpPRNoxxxx);
            final Double _tmpTranAmtx;
            if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
              _tmpTranAmtx = null;
            } else {
              _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
            }
            _result.setTranAmtx(_tmpTranAmtx);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _result.setDiscount(_tmpDiscount);
            final Double _tmpOthersxx;
            if (_cursor.isNull(_cursorIndexOfOthersxx)) {
              _tmpOthersxx = null;
            } else {
              _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
            }
            _result.setOthersxx(_tmpOthersxx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final String _tmpBankIDxx;
            if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
              _tmpBankIDxx = null;
            } else {
              _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
            }
            _result.setBankIDxx(_tmpBankIDxx);
            final String _tmpCheckDte;
            if (_cursor.isNull(_cursorIndexOfCheckDte)) {
              _tmpCheckDte = null;
            } else {
              _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
            }
            _result.setCheckDte(_tmpCheckDte);
            final String _tmpCheckNox;
            if (_cursor.isNull(_cursorIndexOfCheckNox)) {
              _tmpCheckNox = null;
            } else {
              _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
            }
            _result.setCheckNox(_tmpCheckNox);
            final String _tmpCheckAct;
            if (_cursor.isNull(_cursorIndexOfCheckAct)) {
              _tmpCheckAct = null;
            } else {
              _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
            }
            _result.setCheckAct(_tmpCheckAct);
            final String _tmpPromised;
            if (_cursor.isNull(_cursorIndexOfPromised)) {
              _tmpPromised = null;
            } else {
              _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
            }
            _result.setPromised(_tmpPromised);
            final String _tmpRemCodex;
            if (_cursor.isNull(_cursorIndexOfRemCodex)) {
              _tmpRemCodex = null;
            } else {
              _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
            }
            _result.setRemCodex(_tmpRemCodex);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _result.setTranType(_tmpTranType);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _result.setTranTotl(_tmpTranTotl);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _result.setReferNox(_tmpReferNox);
            final String _tmpPaymForm;
            if (_cursor.isNull(_cursorIndexOfPaymForm)) {
              _tmpPaymForm = null;
            } else {
              _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
            }
            _result.setPaymForm(_tmpPaymForm);
            final String _tmpIsDCPxxx;
            if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
              _tmpIsDCPxxx = null;
            } else {
              _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
            }
            _result.setIsDCPxxx(_tmpIsDCPxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _result.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _result.setBrgyName(_tmpBrgyName);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _result.setTownName(_tmpTownName);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _result.setPurchase(_tmpPurchase);
            final Double _tmpMonAmort;
            if (_cursor.isNull(_cursorIndexOfMonAmort)) {
              _tmpMonAmort = null;
            } else {
              _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
            }
            _result.setMonAmort(_tmpMonAmort);
            final Double _tmpAmtDuexx;
            if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
              _tmpAmtDuexx = null;
            } else {
              _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
            }
            _result.setAmtDuexx(_tmpAmtDuexx);
            final String _tmpApntUnit;
            if (_cursor.isNull(_cursorIndexOfApntUnit)) {
              _tmpApntUnit = null;
            } else {
              _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
            }
            _result.setApntUnit(_tmpApntUnit);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _result.setDueDatex(_tmpDueDatex);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _result.setImageNme(_tmpImageNme);
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            _result.setLongitud(_tmpLongitud);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            _result.setLatitude(_tmpLatitude);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _result.setClientID(_tmpClientID);
            final String _tmpSerialID;
            if (_cursor.isNull(_cursorIndexOfSerialID)) {
              _tmpSerialID = null;
            } else {
              _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
            }
            _result.setSerialID(_tmpSerialID);
            final String _tmpSerialNo;
            if (_cursor.isNull(_cursorIndexOfSerialNo)) {
              _tmpSerialNo = null;
            } else {
              _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
            }
            _result.setSerialNo(_tmpSerialNo);
            final Double _tmpLastPaym;
            if (_cursor.isNull(_cursorIndexOfLastPaym)) {
              _tmpLastPaym = null;
            } else {
              _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
            }
            _result.setLastPaym(_tmpLastPaym);
            final String _tmpLastPaid;
            if (_cursor.isNull(_cursorIndexOfLastPaid)) {
              _tmpLastPaid = null;
            } else {
              _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
            }
            _result.setLastPaid(_tmpLastPaid);
            final String _tmpABalance;
            if (_cursor.isNull(_cursorIndexOfABalance)) {
              _tmpABalance = null;
            } else {
              _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
            }
            _result.setABalance(_tmpABalance);
            final Double _tmpDelayAvg;
            if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
              _tmpDelayAvg = null;
            } else {
              _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
            }
            _result.setDelayAvg(_tmpDelayAvg);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _result.setSendDate(_tmpSendDate);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public String getCurrentDateTransNox(final String dReferDte) {
    final String _sql = "SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dReferDte == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dReferDte);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        if (_cursor.isNull(0)) {
          _result = null;
        } else {
          _result = _cursor.getString(0);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<EDCPCollectionDetail> getDuplicateSerialEntry(final String SerialNo) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master ORDER BY dTransact DESC LIMIT 1) AND sSerialNo =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (SerialNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, SerialNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","LR_DCP_Collection_Master"}, false, new Callable<EDCPCollectionDetail>() {
      @Override
      public EDCPCollectionDetail call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
          final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
          final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
          final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
          final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
          final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
          final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
          final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
          final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
          final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
          final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
          final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
          final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
          final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
          final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
          final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EDCPCollectionDetail _result;
          if(_cursor.moveToFirst()) {
            _result = new EDCPCollectionDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _result.setEntryNox(_tmpEntryNox);
            final String _tmpAcctNmbr;
            if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
              _tmpAcctNmbr = null;
            } else {
              _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
            }
            _result.setAcctNmbr(_tmpAcctNmbr);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _result.setFullName(_tmpFullName);
            final String _tmpPRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
              _tmpPRNoxxxx = null;
            } else {
              _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
            }
            _result.setPRNoxxxx(_tmpPRNoxxxx);
            final Double _tmpTranAmtx;
            if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
              _tmpTranAmtx = null;
            } else {
              _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
            }
            _result.setTranAmtx(_tmpTranAmtx);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _result.setDiscount(_tmpDiscount);
            final Double _tmpOthersxx;
            if (_cursor.isNull(_cursorIndexOfOthersxx)) {
              _tmpOthersxx = null;
            } else {
              _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
            }
            _result.setOthersxx(_tmpOthersxx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final String _tmpBankIDxx;
            if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
              _tmpBankIDxx = null;
            } else {
              _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
            }
            _result.setBankIDxx(_tmpBankIDxx);
            final String _tmpCheckDte;
            if (_cursor.isNull(_cursorIndexOfCheckDte)) {
              _tmpCheckDte = null;
            } else {
              _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
            }
            _result.setCheckDte(_tmpCheckDte);
            final String _tmpCheckNox;
            if (_cursor.isNull(_cursorIndexOfCheckNox)) {
              _tmpCheckNox = null;
            } else {
              _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
            }
            _result.setCheckNox(_tmpCheckNox);
            final String _tmpCheckAct;
            if (_cursor.isNull(_cursorIndexOfCheckAct)) {
              _tmpCheckAct = null;
            } else {
              _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
            }
            _result.setCheckAct(_tmpCheckAct);
            final String _tmpPromised;
            if (_cursor.isNull(_cursorIndexOfPromised)) {
              _tmpPromised = null;
            } else {
              _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
            }
            _result.setPromised(_tmpPromised);
            final String _tmpRemCodex;
            if (_cursor.isNull(_cursorIndexOfRemCodex)) {
              _tmpRemCodex = null;
            } else {
              _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
            }
            _result.setRemCodex(_tmpRemCodex);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _result.setTranType(_tmpTranType);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _result.setTranTotl(_tmpTranTotl);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _result.setReferNox(_tmpReferNox);
            final String _tmpPaymForm;
            if (_cursor.isNull(_cursorIndexOfPaymForm)) {
              _tmpPaymForm = null;
            } else {
              _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
            }
            _result.setPaymForm(_tmpPaymForm);
            final String _tmpIsDCPxxx;
            if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
              _tmpIsDCPxxx = null;
            } else {
              _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
            }
            _result.setIsDCPxxx(_tmpIsDCPxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _result.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _result.setBrgyName(_tmpBrgyName);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _result.setTownName(_tmpTownName);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _result.setPurchase(_tmpPurchase);
            final Double _tmpMonAmort;
            if (_cursor.isNull(_cursorIndexOfMonAmort)) {
              _tmpMonAmort = null;
            } else {
              _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
            }
            _result.setMonAmort(_tmpMonAmort);
            final Double _tmpAmtDuexx;
            if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
              _tmpAmtDuexx = null;
            } else {
              _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
            }
            _result.setAmtDuexx(_tmpAmtDuexx);
            final String _tmpApntUnit;
            if (_cursor.isNull(_cursorIndexOfApntUnit)) {
              _tmpApntUnit = null;
            } else {
              _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
            }
            _result.setApntUnit(_tmpApntUnit);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _result.setDueDatex(_tmpDueDatex);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _result.setImageNme(_tmpImageNme);
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            _result.setLongitud(_tmpLongitud);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            _result.setLatitude(_tmpLatitude);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _result.setClientID(_tmpClientID);
            final String _tmpSerialID;
            if (_cursor.isNull(_cursorIndexOfSerialID)) {
              _tmpSerialID = null;
            } else {
              _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
            }
            _result.setSerialID(_tmpSerialID);
            final String _tmpSerialNo;
            if (_cursor.isNull(_cursorIndexOfSerialNo)) {
              _tmpSerialNo = null;
            } else {
              _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
            }
            _result.setSerialNo(_tmpSerialNo);
            final Double _tmpLastPaym;
            if (_cursor.isNull(_cursorIndexOfLastPaym)) {
              _tmpLastPaym = null;
            } else {
              _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
            }
            _result.setLastPaym(_tmpLastPaym);
            final String _tmpLastPaid;
            if (_cursor.isNull(_cursorIndexOfLastPaid)) {
              _tmpLastPaid = null;
            } else {
              _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
            }
            _result.setLastPaid(_tmpLastPaid);
            final String _tmpABalance;
            if (_cursor.isNull(_cursorIndexOfABalance)) {
              _tmpABalance = null;
            } else {
              _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
            }
            _result.setABalance(_tmpABalance);
            final Double _tmpDelayAvg;
            if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
              _tmpDelayAvg = null;
            } else {
              _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
            }
            _result.setDelayAvg(_tmpDelayAvg);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _result.setSendDate(_tmpSendDate);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<String> getCollectedCheckTotalPayment(final String dTransact) {
    final String _sql = "SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sCheckNox <> '' AND  sCheckDte <> '' AND sCheckAct <> '' AND sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","LR_DCP_Collection_Master"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            final String _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<String> getCollectedTotalPayment(final String dTransact) {
    final String _sql = "SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sCheckNox == '' AND  sCheckDte == '' AND sCheckAct == '' AND sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","LR_DCP_Collection_Master"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            final String _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<String> getCollectedTotal(final String dTransact) {
    final String _sql = "SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","LR_DCP_Collection_Master"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            final String _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> getCurrentDCPCount() {
    final String _sql = "SELECT COUNT(*) FROM LR_DCP_Collection_Detail WHERE cTranStat != '2'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<String> getTotalRemittedPayment(final String dTransact) {
    final String _sql = "SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Remittance","LR_DCP_Collection_Master"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String _result;
          if(_cursor.moveToFirst()) {
            final String _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<EDCPCollectionDetail>> getCollectionDetailForDate(final String dTransact) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?) AND cTranStat = '2'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","LR_DCP_Collection_Master"}, false, new Callable<List<EDCPCollectionDetail>>() {
      @Override
      public List<EDCPCollectionDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
          final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
          final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
          final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
          final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
          final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
          final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
          final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
          final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
          final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
          final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
          final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
          final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
          final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
          final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
          final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EDCPCollectionDetail _item;
            _item = new EDCPCollectionDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpAcctNmbr;
            if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
              _tmpAcctNmbr = null;
            } else {
              _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
            }
            _item.setAcctNmbr(_tmpAcctNmbr);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _item.setFullName(_tmpFullName);
            final String _tmpPRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
              _tmpPRNoxxxx = null;
            } else {
              _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
            }
            _item.setPRNoxxxx(_tmpPRNoxxxx);
            final Double _tmpTranAmtx;
            if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
              _tmpTranAmtx = null;
            } else {
              _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
            }
            _item.setTranAmtx(_tmpTranAmtx);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _item.setDiscount(_tmpDiscount);
            final Double _tmpOthersxx;
            if (_cursor.isNull(_cursorIndexOfOthersxx)) {
              _tmpOthersxx = null;
            } else {
              _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
            }
            _item.setOthersxx(_tmpOthersxx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpBankIDxx;
            if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
              _tmpBankIDxx = null;
            } else {
              _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
            }
            _item.setBankIDxx(_tmpBankIDxx);
            final String _tmpCheckDte;
            if (_cursor.isNull(_cursorIndexOfCheckDte)) {
              _tmpCheckDte = null;
            } else {
              _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
            }
            _item.setCheckDte(_tmpCheckDte);
            final String _tmpCheckNox;
            if (_cursor.isNull(_cursorIndexOfCheckNox)) {
              _tmpCheckNox = null;
            } else {
              _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
            }
            _item.setCheckNox(_tmpCheckNox);
            final String _tmpCheckAct;
            if (_cursor.isNull(_cursorIndexOfCheckAct)) {
              _tmpCheckAct = null;
            } else {
              _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
            }
            _item.setCheckAct(_tmpCheckAct);
            final String _tmpPromised;
            if (_cursor.isNull(_cursorIndexOfPromised)) {
              _tmpPromised = null;
            } else {
              _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
            }
            _item.setPromised(_tmpPromised);
            final String _tmpRemCodex;
            if (_cursor.isNull(_cursorIndexOfRemCodex)) {
              _tmpRemCodex = null;
            } else {
              _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
            }
            _item.setRemCodex(_tmpRemCodex);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _item.setTranType(_tmpTranType);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _item.setTranTotl(_tmpTranTotl);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpPaymForm;
            if (_cursor.isNull(_cursorIndexOfPaymForm)) {
              _tmpPaymForm = null;
            } else {
              _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
            }
            _item.setPaymForm(_tmpPaymForm);
            final String _tmpIsDCPxxx;
            if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
              _tmpIsDCPxxx = null;
            } else {
              _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
            }
            _item.setIsDCPxxx(_tmpIsDCPxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _item.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _item.setBrgyName(_tmpBrgyName);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _item.setPurchase(_tmpPurchase);
            final Double _tmpMonAmort;
            if (_cursor.isNull(_cursorIndexOfMonAmort)) {
              _tmpMonAmort = null;
            } else {
              _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
            }
            _item.setMonAmort(_tmpMonAmort);
            final Double _tmpAmtDuexx;
            if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
              _tmpAmtDuexx = null;
            } else {
              _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
            }
            _item.setAmtDuexx(_tmpAmtDuexx);
            final String _tmpApntUnit;
            if (_cursor.isNull(_cursorIndexOfApntUnit)) {
              _tmpApntUnit = null;
            } else {
              _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
            }
            _item.setApntUnit(_tmpApntUnit);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _item.setDueDatex(_tmpDueDatex);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _item.setImageNme(_tmpImageNme);
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            _item.setLongitud(_tmpLongitud);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            _item.setLatitude(_tmpLatitude);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _item.setClientID(_tmpClientID);
            final String _tmpSerialID;
            if (_cursor.isNull(_cursorIndexOfSerialID)) {
              _tmpSerialID = null;
            } else {
              _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
            }
            _item.setSerialID(_tmpSerialID);
            final String _tmpSerialNo;
            if (_cursor.isNull(_cursorIndexOfSerialNo)) {
              _tmpSerialNo = null;
            } else {
              _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
            }
            _item.setSerialNo(_tmpSerialNo);
            final Double _tmpLastPaym;
            if (_cursor.isNull(_cursorIndexOfLastPaym)) {
              _tmpLastPaym = null;
            } else {
              _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
            }
            _item.setLastPaym(_tmpLastPaym);
            final String _tmpLastPaid;
            if (_cursor.isNull(_cursorIndexOfLastPaid)) {
              _tmpLastPaid = null;
            } else {
              _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
            }
            _item.setLastPaid(_tmpLastPaid);
            final String _tmpABalance;
            if (_cursor.isNull(_cursorIndexOfABalance)) {
              _tmpABalance = null;
            } else {
              _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
            }
            _item.setABalance(_tmpABalance);
            final Double _tmpDelayAvg;
            if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
              _tmpDelayAvg = null;
            } else {
              _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
            }
            _item.setDelayAvg(_tmpDelayAvg);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<EDCPCollectionDetail>> getUnpostedCollectionDetail(final String dTransact) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","LR_DCP_Collection_Master"}, false, new Callable<List<EDCPCollectionDetail>>() {
      @Override
      public List<EDCPCollectionDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
          final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
          final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
          final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
          final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
          final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
          final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
          final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
          final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
          final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
          final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
          final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
          final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
          final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
          final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
          final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EDCPCollectionDetail _item;
            _item = new EDCPCollectionDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpAcctNmbr;
            if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
              _tmpAcctNmbr = null;
            } else {
              _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
            }
            _item.setAcctNmbr(_tmpAcctNmbr);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _item.setFullName(_tmpFullName);
            final String _tmpPRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
              _tmpPRNoxxxx = null;
            } else {
              _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
            }
            _item.setPRNoxxxx(_tmpPRNoxxxx);
            final Double _tmpTranAmtx;
            if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
              _tmpTranAmtx = null;
            } else {
              _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
            }
            _item.setTranAmtx(_tmpTranAmtx);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _item.setDiscount(_tmpDiscount);
            final Double _tmpOthersxx;
            if (_cursor.isNull(_cursorIndexOfOthersxx)) {
              _tmpOthersxx = null;
            } else {
              _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
            }
            _item.setOthersxx(_tmpOthersxx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpBankIDxx;
            if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
              _tmpBankIDxx = null;
            } else {
              _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
            }
            _item.setBankIDxx(_tmpBankIDxx);
            final String _tmpCheckDte;
            if (_cursor.isNull(_cursorIndexOfCheckDte)) {
              _tmpCheckDte = null;
            } else {
              _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
            }
            _item.setCheckDte(_tmpCheckDte);
            final String _tmpCheckNox;
            if (_cursor.isNull(_cursorIndexOfCheckNox)) {
              _tmpCheckNox = null;
            } else {
              _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
            }
            _item.setCheckNox(_tmpCheckNox);
            final String _tmpCheckAct;
            if (_cursor.isNull(_cursorIndexOfCheckAct)) {
              _tmpCheckAct = null;
            } else {
              _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
            }
            _item.setCheckAct(_tmpCheckAct);
            final String _tmpPromised;
            if (_cursor.isNull(_cursorIndexOfPromised)) {
              _tmpPromised = null;
            } else {
              _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
            }
            _item.setPromised(_tmpPromised);
            final String _tmpRemCodex;
            if (_cursor.isNull(_cursorIndexOfRemCodex)) {
              _tmpRemCodex = null;
            } else {
              _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
            }
            _item.setRemCodex(_tmpRemCodex);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _item.setTranType(_tmpTranType);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _item.setTranTotl(_tmpTranTotl);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpPaymForm;
            if (_cursor.isNull(_cursorIndexOfPaymForm)) {
              _tmpPaymForm = null;
            } else {
              _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
            }
            _item.setPaymForm(_tmpPaymForm);
            final String _tmpIsDCPxxx;
            if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
              _tmpIsDCPxxx = null;
            } else {
              _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
            }
            _item.setIsDCPxxx(_tmpIsDCPxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _item.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _item.setBrgyName(_tmpBrgyName);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _item.setPurchase(_tmpPurchase);
            final Double _tmpMonAmort;
            if (_cursor.isNull(_cursorIndexOfMonAmort)) {
              _tmpMonAmort = null;
            } else {
              _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
            }
            _item.setMonAmort(_tmpMonAmort);
            final Double _tmpAmtDuexx;
            if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
              _tmpAmtDuexx = null;
            } else {
              _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
            }
            _item.setAmtDuexx(_tmpAmtDuexx);
            final String _tmpApntUnit;
            if (_cursor.isNull(_cursorIndexOfApntUnit)) {
              _tmpApntUnit = null;
            } else {
              _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
            }
            _item.setApntUnit(_tmpApntUnit);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _item.setDueDatex(_tmpDueDatex);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _item.setImageNme(_tmpImageNme);
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            _item.setLongitud(_tmpLongitud);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            _item.setLatitude(_tmpLatitude);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _item.setClientID(_tmpClientID);
            final String _tmpSerialID;
            if (_cursor.isNull(_cursorIndexOfSerialID)) {
              _tmpSerialID = null;
            } else {
              _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
            }
            _item.setSerialID(_tmpSerialID);
            final String _tmpSerialNo;
            if (_cursor.isNull(_cursorIndexOfSerialNo)) {
              _tmpSerialNo = null;
            } else {
              _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
            }
            _item.setSerialNo(_tmpSerialNo);
            final Double _tmpLastPaym;
            if (_cursor.isNull(_cursorIndexOfLastPaym)) {
              _tmpLastPaym = null;
            } else {
              _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
            }
            _item.setLastPaym(_tmpLastPaym);
            final String _tmpLastPaid;
            if (_cursor.isNull(_cursorIndexOfLastPaid)) {
              _tmpLastPaid = null;
            } else {
              _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
            }
            _item.setLastPaid(_tmpLastPaid);
            final String _tmpABalance;
            if (_cursor.isNull(_cursorIndexOfABalance)) {
              _tmpABalance = null;
            } else {
              _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
            }
            _item.setABalance(_tmpABalance);
            final Double _tmpDelayAvg;
            if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
              _tmpDelayAvg = null;
            } else {
              _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
            }
            _item.setDelayAvg(_tmpDelayAvg);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<EDCPCollectionDetail> getUnsentPaidCollection() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE cSendStat <> '1' AND sRemCodex == 'PAY'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EDCPCollectionDetail _item;
        _item = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _item.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _item.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _item.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _item.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _item.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _item.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _item.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _item.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _item.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _item.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _item.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _item.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _item.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _item.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _item.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _item.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _item.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _item.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _item.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _item.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _item.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _item.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _item.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _item.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _item.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _item.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _item.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _item.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _item.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _item.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _item.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _item.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _item.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _item.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EDCPCollectionDetail> getDetailCollection(final String TransNox) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox =? ORDER BY nEntryNox DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EDCPCollectionDetail _item;
        _item = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _item.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _item.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _item.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _item.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _item.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _item.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _item.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _item.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _item.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _item.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _item.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _item.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _item.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _item.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _item.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _item.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _item.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _item.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _item.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _item.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _item.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _item.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _item.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _item.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _item.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _item.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _item.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _item.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _item.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _item.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _item.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _item.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _item.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _item.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EDCPCollectionDetail> CheckCollectionDetailNoRemCode(final String TransNox) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND sRemCodex = '' ORDER BY nEntryNox DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EDCPCollectionDetail _item;
        _item = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _item.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _item.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _item.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _item.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _item.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _item.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _item.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _item.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _item.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _item.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _item.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _item.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _item.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _item.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _item.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _item.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _item.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _item.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _item.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _item.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _item.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _item.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _item.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _item.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _item.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _item.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _item.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _item.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _item.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _item.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _item.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _item.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _item.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _item.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public EDCPCollectionDetail CheckIFAccountExist(final String ReferDte, final String AccNmbr) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?) AND sAcctNmbr =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (ReferDte == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ReferDte);
    }
    _argIndex = 2;
    if (AccNmbr == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AccNmbr);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EDCPCollectionDetail _result;
      if(_cursor.moveToFirst()) {
        _result = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _result.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _result.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _result.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _result.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _result.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _result.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _result.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _result.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _result.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _result.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _result.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _result.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _result.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _result.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _result.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _result.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _result.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _result.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _result.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _result.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _result.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _result.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _result.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _result.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _result.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _result.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _result.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _result.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _result.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _result.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _result.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Integer getDCPStatus(final String dTransact) {
    final String _sql = "SELECT (SELECT COUNT(cTranStat) FROM LR_DCP_Collection_Detail WHERE cTranStat <> '2' AND sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?)) - (SELECT COUNT(cTranStat) FROM LR_DCP_Collection_Detail WHERE cTranStat = 2 AND sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?))";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    _argIndex = 2;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Integer _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(0);
        }
        _result = _tmp;
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EDCPCollectionDetail> checkDCPPAYTransaction() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox=(SELECT sTransNox FROM LR_DCP_Collection_Master WHERE cSendStat IS NULL) AND sRemCodex = 'PAY'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EDCPCollectionDetail _item;
        _item = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _item.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _item.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _item.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _item.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _item.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _item.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _item.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _item.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _item.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _item.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _item.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _item.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _item.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _item.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _item.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _item.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _item.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _item.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _item.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _item.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _item.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _item.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _item.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _item.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _item.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _item.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _item.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _item.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _item.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _item.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _item.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _item.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _item.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _item.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EDCPCollectionDetail> checkCollectionRemarksCode() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE cSendStat IS NULL) AND sRemCodex <> ''";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EDCPCollectionDetail _item;
        _item = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _item.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _item.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _item.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _item.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _item.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _item.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _item.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _item.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _item.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _item.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _item.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _item.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _item.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _item.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _item.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _item.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _item.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _item.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _item.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _item.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _item.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _item.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _item.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _item.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _item.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _item.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _item.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _item.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _item.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _item.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _item.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _item.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _item.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _item.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<DDCPCollectionDetail.CollectionDetail>> getCollectionDetailForPosting() {
    final String _sql = "SELECT a.sTransNox, a.nEntryNox, a.sAcctNmbr, a.sRemCodex, a.dModified, a.xFullName, a.sPRNoxxxx, a.nTranAmtx, a.nDiscount, a.dPromised, a.nOthersxx, a.sRemarksx, a.cTranType, a.nTranTotl, a.cApntUnit, a.sBranchCd, b.sTransNox AS sImageIDx, b.sFileCode, b.sSourceCD, b.sImageNme, b.sMD5Hashx, b.sFileLoct, b.nLongitud, b.nLatitude, c.sLastName, c.sFrstName, c.sMiddName, c.sSuffixNm, c.sHouseNox, c.sAddressx, c.sTownIDxx, c.cGenderxx, c.cCivlStat, c.dBirthDte, c.dBirthPlc, c.sLandline, c.sMobileNo, c.sEmailAdd, d.cReqstCDe AS saReqstCde, d.cAddrssTp AS saAddrsTp, d.sHouseNox AS saHouseNox, d.sAddressx AS saAddress, d.sTownIDxx AS saTownIDxx, d.sBrgyIDxx AS saBrgyIDxx, d.cPrimaryx AS saPrimaryx, d.nLatitude AS saLatitude, d.nLongitud AS saLongitude, d.sRemarksx AS saRemarksx,e.cReqstCDe AS smReqstCde, e.sMobileNo AS smContactNox, e.cPrimaryx AS smPrimaryx, e.sRemarksx AS smRemarksx FROM LR_DCP_Collection_Detail a LEFT JOIN Image_Information b ON a.sTransNox = b.sSourceNo AND a.sAcctNmbr = b.sDtlSrcNo LEFT JOIN Client_Update_Request c ON a.sTransNox = c.sSourceNo AND a.sAcctNmbr = c.sDtlSrcNo LEFT JOIN Address_Update_Request d ON a.sClientID = d.sClientID LEFT JOIN MOBILE_UPDATE_REQUEST e ON a.sClientID = e.sClientID WHERE a.cSendStat IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","Image_Information","Client_Update_Request","Address_Update_Request","MOBILE_UPDATE_REQUEST"}, false, new Callable<List<DDCPCollectionDetail.CollectionDetail>>() {
      @Override
      public List<DDCPCollectionDetail.CollectionDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfNEntryNox = 1;
          final int _cursorIndexOfSAcctNmbr = 2;
          final int _cursorIndexOfSRemCodex = 3;
          final int _cursorIndexOfDModified = 4;
          final int _cursorIndexOfXFullName = 5;
          final int _cursorIndexOfSPRNoxxxx = 6;
          final int _cursorIndexOfNTranAmtx = 7;
          final int _cursorIndexOfNDiscount = 8;
          final int _cursorIndexOfDPromised = 9;
          final int _cursorIndexOfNOthersxx = 10;
          final int _cursorIndexOfSRemarksx = 11;
          final int _cursorIndexOfCTranType = 12;
          final int _cursorIndexOfNTranTotl = 13;
          final int _cursorIndexOfCApntUnit = 14;
          final int _cursorIndexOfSBranchCd = 15;
          final int _cursorIndexOfSImageIDx = 16;
          final int _cursorIndexOfSFileCode = 17;
          final int _cursorIndexOfSSourceCD = 18;
          final int _cursorIndexOfSImageNme = 19;
          final int _cursorIndexOfSMD5Hashx = 20;
          final int _cursorIndexOfSFileLoct = 21;
          final int _cursorIndexOfNLongitud = 22;
          final int _cursorIndexOfNLatitude = 23;
          final int _cursorIndexOfSLastName = 24;
          final int _cursorIndexOfSFrstName = 25;
          final int _cursorIndexOfSMiddName = 26;
          final int _cursorIndexOfSSuffixNm = 27;
          final int _cursorIndexOfSHouseNox = 28;
          final int _cursorIndexOfSAddressx = 29;
          final int _cursorIndexOfSTownIDxx = 30;
          final int _cursorIndexOfCGenderxx = 31;
          final int _cursorIndexOfCCivlStat = 32;
          final int _cursorIndexOfDBirthDte = 33;
          final int _cursorIndexOfDBirthPlc = 34;
          final int _cursorIndexOfSLandline = 35;
          final int _cursorIndexOfSMobileNo = 36;
          final int _cursorIndexOfSEmailAdd = 37;
          final int _cursorIndexOfSaReqstCde = 38;
          final int _cursorIndexOfSaAddrsTp = 39;
          final int _cursorIndexOfSaHouseNox = 40;
          final int _cursorIndexOfSaAddress = 41;
          final int _cursorIndexOfSaTownIDxx = 42;
          final int _cursorIndexOfSaBrgyIDxx = 43;
          final int _cursorIndexOfSaPrimaryx = 44;
          final int _cursorIndexOfSaLatitude = 45;
          final int _cursorIndexOfSaLongitude = 46;
          final int _cursorIndexOfSaRemarksx = 47;
          final int _cursorIndexOfSmReqstCde = 48;
          final int _cursorIndexOfSmContactNox = 49;
          final int _cursorIndexOfSmPrimaryx = 50;
          final int _cursorIndexOfSmRemarksx = 51;
          final List<DDCPCollectionDetail.CollectionDetail> _result = new ArrayList<DDCPCollectionDetail.CollectionDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DDCPCollectionDetail.CollectionDetail _item;
            _item = new DDCPCollectionDetail.CollectionDetail();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            _item.nEntryNox = _cursor.getInt(_cursorIndexOfNEntryNox);
            if (_cursor.isNull(_cursorIndexOfSAcctNmbr)) {
              _item.sAcctNmbr = null;
            } else {
              _item.sAcctNmbr = _cursor.getString(_cursorIndexOfSAcctNmbr);
            }
            if (_cursor.isNull(_cursorIndexOfSRemCodex)) {
              _item.sRemCodex = null;
            } else {
              _item.sRemCodex = _cursor.getString(_cursorIndexOfSRemCodex);
            }
            if (_cursor.isNull(_cursorIndexOfDModified)) {
              _item.dModified = null;
            } else {
              _item.dModified = _cursor.getString(_cursorIndexOfDModified);
            }
            if (_cursor.isNull(_cursorIndexOfXFullName)) {
              _item.xFullName = null;
            } else {
              _item.xFullName = _cursor.getString(_cursorIndexOfXFullName);
            }
            if (_cursor.isNull(_cursorIndexOfSPRNoxxxx)) {
              _item.sPRNoxxxx = null;
            } else {
              _item.sPRNoxxxx = _cursor.getString(_cursorIndexOfSPRNoxxxx);
            }
            if (_cursor.isNull(_cursorIndexOfNTranAmtx)) {
              _item.nTranAmtx = null;
            } else {
              _item.nTranAmtx = _cursor.getString(_cursorIndexOfNTranAmtx);
            }
            if (_cursor.isNull(_cursorIndexOfNDiscount)) {
              _item.nDiscount = null;
            } else {
              _item.nDiscount = _cursor.getString(_cursorIndexOfNDiscount);
            }
            if (_cursor.isNull(_cursorIndexOfDPromised)) {
              _item.dPromised = null;
            } else {
              _item.dPromised = _cursor.getString(_cursorIndexOfDPromised);
            }
            if (_cursor.isNull(_cursorIndexOfNOthersxx)) {
              _item.nOthersxx = null;
            } else {
              _item.nOthersxx = _cursor.getString(_cursorIndexOfNOthersxx);
            }
            if (_cursor.isNull(_cursorIndexOfSRemarksx)) {
              _item.sRemarksx = null;
            } else {
              _item.sRemarksx = _cursor.getString(_cursorIndexOfSRemarksx);
            }
            if (_cursor.isNull(_cursorIndexOfCTranType)) {
              _item.cTranType = null;
            } else {
              _item.cTranType = _cursor.getString(_cursorIndexOfCTranType);
            }
            if (_cursor.isNull(_cursorIndexOfNTranTotl)) {
              _item.nTranTotl = null;
            } else {
              _item.nTranTotl = _cursor.getString(_cursorIndexOfNTranTotl);
            }
            if (_cursor.isNull(_cursorIndexOfCApntUnit)) {
              _item.cApntUnit = null;
            } else {
              _item.cApntUnit = _cursor.getString(_cursorIndexOfCApntUnit);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchCd)) {
              _item.sBranchCd = null;
            } else {
              _item.sBranchCd = _cursor.getString(_cursorIndexOfSBranchCd);
            }
            if (_cursor.isNull(_cursorIndexOfSImageIDx)) {
              _item.sImageIDx = null;
            } else {
              _item.sImageIDx = _cursor.getString(_cursorIndexOfSImageIDx);
            }
            if (_cursor.isNull(_cursorIndexOfSFileCode)) {
              _item.sFileCode = null;
            } else {
              _item.sFileCode = _cursor.getString(_cursorIndexOfSFileCode);
            }
            if (_cursor.isNull(_cursorIndexOfSSourceCD)) {
              _item.sSourceCD = null;
            } else {
              _item.sSourceCD = _cursor.getString(_cursorIndexOfSSourceCD);
            }
            if (_cursor.isNull(_cursorIndexOfSImageNme)) {
              _item.sImageNme = null;
            } else {
              _item.sImageNme = _cursor.getString(_cursorIndexOfSImageNme);
            }
            if (_cursor.isNull(_cursorIndexOfSMD5Hashx)) {
              _item.sMD5Hashx = null;
            } else {
              _item.sMD5Hashx = _cursor.getString(_cursorIndexOfSMD5Hashx);
            }
            if (_cursor.isNull(_cursorIndexOfSFileLoct)) {
              _item.sFileLoct = null;
            } else {
              _item.sFileLoct = _cursor.getString(_cursorIndexOfSFileLoct);
            }
            if (_cursor.isNull(_cursorIndexOfNLongitud)) {
              _item.nLongitud = null;
            } else {
              _item.nLongitud = _cursor.getString(_cursorIndexOfNLongitud);
            }
            if (_cursor.isNull(_cursorIndexOfNLatitude)) {
              _item.nLatitude = null;
            } else {
              _item.nLatitude = _cursor.getString(_cursorIndexOfNLatitude);
            }
            if (_cursor.isNull(_cursorIndexOfSLastName)) {
              _item.sLastName = null;
            } else {
              _item.sLastName = _cursor.getString(_cursorIndexOfSLastName);
            }
            if (_cursor.isNull(_cursorIndexOfSFrstName)) {
              _item.sFrstName = null;
            } else {
              _item.sFrstName = _cursor.getString(_cursorIndexOfSFrstName);
            }
            if (_cursor.isNull(_cursorIndexOfSMiddName)) {
              _item.sMiddName = null;
            } else {
              _item.sMiddName = _cursor.getString(_cursorIndexOfSMiddName);
            }
            if (_cursor.isNull(_cursorIndexOfSSuffixNm)) {
              _item.sSuffixNm = null;
            } else {
              _item.sSuffixNm = _cursor.getString(_cursorIndexOfSSuffixNm);
            }
            if (_cursor.isNull(_cursorIndexOfSHouseNox)) {
              _item.sHouseNox = null;
            } else {
              _item.sHouseNox = _cursor.getString(_cursorIndexOfSHouseNox);
            }
            if (_cursor.isNull(_cursorIndexOfSAddressx)) {
              _item.sAddressx = null;
            } else {
              _item.sAddressx = _cursor.getString(_cursorIndexOfSAddressx);
            }
            if (_cursor.isNull(_cursorIndexOfSTownIDxx)) {
              _item.sTownIDxx = null;
            } else {
              _item.sTownIDxx = _cursor.getString(_cursorIndexOfSTownIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfCGenderxx)) {
              _item.cGenderxx = null;
            } else {
              _item.cGenderxx = _cursor.getString(_cursorIndexOfCGenderxx);
            }
            if (_cursor.isNull(_cursorIndexOfCCivlStat)) {
              _item.cCivlStat = null;
            } else {
              _item.cCivlStat = _cursor.getString(_cursorIndexOfCCivlStat);
            }
            if (_cursor.isNull(_cursorIndexOfDBirthDte)) {
              _item.dBirthDte = null;
            } else {
              _item.dBirthDte = _cursor.getString(_cursorIndexOfDBirthDte);
            }
            if (_cursor.isNull(_cursorIndexOfDBirthPlc)) {
              _item.dBirthPlc = null;
            } else {
              _item.dBirthPlc = _cursor.getString(_cursorIndexOfDBirthPlc);
            }
            if (_cursor.isNull(_cursorIndexOfSLandline)) {
              _item.sLandline = null;
            } else {
              _item.sLandline = _cursor.getString(_cursorIndexOfSLandline);
            }
            if (_cursor.isNull(_cursorIndexOfSMobileNo)) {
              _item.sMobileNo = null;
            } else {
              _item.sMobileNo = _cursor.getString(_cursorIndexOfSMobileNo);
            }
            if (_cursor.isNull(_cursorIndexOfSEmailAdd)) {
              _item.sEmailAdd = null;
            } else {
              _item.sEmailAdd = _cursor.getString(_cursorIndexOfSEmailAdd);
            }
            if (_cursor.isNull(_cursorIndexOfSaReqstCde)) {
              _item.saReqstCde = null;
            } else {
              _item.saReqstCde = _cursor.getString(_cursorIndexOfSaReqstCde);
            }
            if (_cursor.isNull(_cursorIndexOfSaAddrsTp)) {
              _item.saAddrsTp = null;
            } else {
              _item.saAddrsTp = _cursor.getString(_cursorIndexOfSaAddrsTp);
            }
            if (_cursor.isNull(_cursorIndexOfSaHouseNox)) {
              _item.saHouseNox = null;
            } else {
              _item.saHouseNox = _cursor.getString(_cursorIndexOfSaHouseNox);
            }
            if (_cursor.isNull(_cursorIndexOfSaAddress)) {
              _item.saAddress = null;
            } else {
              _item.saAddress = _cursor.getString(_cursorIndexOfSaAddress);
            }
            if (_cursor.isNull(_cursorIndexOfSaTownIDxx)) {
              _item.saTownIDxx = null;
            } else {
              _item.saTownIDxx = _cursor.getString(_cursorIndexOfSaTownIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSaBrgyIDxx)) {
              _item.saBrgyIDxx = null;
            } else {
              _item.saBrgyIDxx = _cursor.getString(_cursorIndexOfSaBrgyIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSaPrimaryx)) {
              _item.saPrimaryx = null;
            } else {
              _item.saPrimaryx = _cursor.getString(_cursorIndexOfSaPrimaryx);
            }
            if (_cursor.isNull(_cursorIndexOfSaLatitude)) {
              _item.saLatitude = null;
            } else {
              _item.saLatitude = _cursor.getString(_cursorIndexOfSaLatitude);
            }
            if (_cursor.isNull(_cursorIndexOfSaLongitude)) {
              _item.saLongitude = null;
            } else {
              _item.saLongitude = _cursor.getString(_cursorIndexOfSaLongitude);
            }
            if (_cursor.isNull(_cursorIndexOfSaRemarksx)) {
              _item.saRemarksx = null;
            } else {
              _item.saRemarksx = _cursor.getString(_cursorIndexOfSaRemarksx);
            }
            if (_cursor.isNull(_cursorIndexOfSmReqstCde)) {
              _item.smReqstCde = null;
            } else {
              _item.smReqstCde = _cursor.getString(_cursorIndexOfSmReqstCde);
            }
            if (_cursor.isNull(_cursorIndexOfSmContactNox)) {
              _item.smContactNox = null;
            } else {
              _item.smContactNox = _cursor.getString(_cursorIndexOfSmContactNox);
            }
            if (_cursor.isNull(_cursorIndexOfSmPrimaryx)) {
              _item.smPrimaryx = null;
            } else {
              _item.smPrimaryx = _cursor.getString(_cursorIndexOfSmPrimaryx);
            }
            if (_cursor.isNull(_cursorIndexOfSmRemarksx)) {
              _item.smRemarksx = null;
            } else {
              _item.smRemarksx = _cursor.getString(_cursorIndexOfSmRemarksx);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<EDCPCollectionDetail>> getDCPDetailForPosting(final String dTransact) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","LR_DCP_Collection_Master"}, false, new Callable<List<EDCPCollectionDetail>>() {
      @Override
      public List<EDCPCollectionDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
          final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
          final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
          final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
          final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
          final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
          final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
          final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
          final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
          final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
          final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
          final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
          final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
          final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
          final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
          final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EDCPCollectionDetail _item;
            _item = new EDCPCollectionDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpAcctNmbr;
            if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
              _tmpAcctNmbr = null;
            } else {
              _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
            }
            _item.setAcctNmbr(_tmpAcctNmbr);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _item.setFullName(_tmpFullName);
            final String _tmpPRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
              _tmpPRNoxxxx = null;
            } else {
              _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
            }
            _item.setPRNoxxxx(_tmpPRNoxxxx);
            final Double _tmpTranAmtx;
            if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
              _tmpTranAmtx = null;
            } else {
              _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
            }
            _item.setTranAmtx(_tmpTranAmtx);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _item.setDiscount(_tmpDiscount);
            final Double _tmpOthersxx;
            if (_cursor.isNull(_cursorIndexOfOthersxx)) {
              _tmpOthersxx = null;
            } else {
              _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
            }
            _item.setOthersxx(_tmpOthersxx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpBankIDxx;
            if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
              _tmpBankIDxx = null;
            } else {
              _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
            }
            _item.setBankIDxx(_tmpBankIDxx);
            final String _tmpCheckDte;
            if (_cursor.isNull(_cursorIndexOfCheckDte)) {
              _tmpCheckDte = null;
            } else {
              _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
            }
            _item.setCheckDte(_tmpCheckDte);
            final String _tmpCheckNox;
            if (_cursor.isNull(_cursorIndexOfCheckNox)) {
              _tmpCheckNox = null;
            } else {
              _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
            }
            _item.setCheckNox(_tmpCheckNox);
            final String _tmpCheckAct;
            if (_cursor.isNull(_cursorIndexOfCheckAct)) {
              _tmpCheckAct = null;
            } else {
              _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
            }
            _item.setCheckAct(_tmpCheckAct);
            final String _tmpPromised;
            if (_cursor.isNull(_cursorIndexOfPromised)) {
              _tmpPromised = null;
            } else {
              _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
            }
            _item.setPromised(_tmpPromised);
            final String _tmpRemCodex;
            if (_cursor.isNull(_cursorIndexOfRemCodex)) {
              _tmpRemCodex = null;
            } else {
              _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
            }
            _item.setRemCodex(_tmpRemCodex);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _item.setTranType(_tmpTranType);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _item.setTranTotl(_tmpTranTotl);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpPaymForm;
            if (_cursor.isNull(_cursorIndexOfPaymForm)) {
              _tmpPaymForm = null;
            } else {
              _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
            }
            _item.setPaymForm(_tmpPaymForm);
            final String _tmpIsDCPxxx;
            if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
              _tmpIsDCPxxx = null;
            } else {
              _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
            }
            _item.setIsDCPxxx(_tmpIsDCPxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _item.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _item.setBrgyName(_tmpBrgyName);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _item.setPurchase(_tmpPurchase);
            final Double _tmpMonAmort;
            if (_cursor.isNull(_cursorIndexOfMonAmort)) {
              _tmpMonAmort = null;
            } else {
              _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
            }
            _item.setMonAmort(_tmpMonAmort);
            final Double _tmpAmtDuexx;
            if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
              _tmpAmtDuexx = null;
            } else {
              _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
            }
            _item.setAmtDuexx(_tmpAmtDuexx);
            final String _tmpApntUnit;
            if (_cursor.isNull(_cursorIndexOfApntUnit)) {
              _tmpApntUnit = null;
            } else {
              _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
            }
            _item.setApntUnit(_tmpApntUnit);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _item.setDueDatex(_tmpDueDatex);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _item.setImageNme(_tmpImageNme);
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            _item.setLongitud(_tmpLongitud);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            _item.setLatitude(_tmpLatitude);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _item.setClientID(_tmpClientID);
            final String _tmpSerialID;
            if (_cursor.isNull(_cursorIndexOfSerialID)) {
              _tmpSerialID = null;
            } else {
              _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
            }
            _item.setSerialID(_tmpSerialID);
            final String _tmpSerialNo;
            if (_cursor.isNull(_cursorIndexOfSerialNo)) {
              _tmpSerialNo = null;
            } else {
              _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
            }
            _item.setSerialNo(_tmpSerialNo);
            final Double _tmpLastPaym;
            if (_cursor.isNull(_cursorIndexOfLastPaym)) {
              _tmpLastPaym = null;
            } else {
              _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
            }
            _item.setLastPaym(_tmpLastPaym);
            final String _tmpLastPaid;
            if (_cursor.isNull(_cursorIndexOfLastPaid)) {
              _tmpLastPaid = null;
            } else {
              _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
            }
            _item.setLastPaid(_tmpLastPaid);
            final String _tmpABalance;
            if (_cursor.isNull(_cursorIndexOfABalance)) {
              _tmpABalance = null;
            } else {
              _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
            }
            _item.setABalance(_tmpABalance);
            final Double _tmpDelayAvg;
            if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
              _tmpDelayAvg = null;
            } else {
              _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
            }
            _item.setDelayAvg(_tmpDelayAvg);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<EDCPCollectionDetail> getCheckPostedCollectionDetail(final String TransNox) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EDCPCollectionDetail _item;
        _item = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _item.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _item.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _item.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _item.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _item.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _item.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _item.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _item.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _item.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _item.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _item.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _item.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _item.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _item.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _item.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _item.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _item.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _item.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _item.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _item.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _item.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _item.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _item.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _item.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _item.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _item.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _item.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _item.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _item.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _item.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _item.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _item.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _item.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _item.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<EDCPCollectionDetail> getPostedCollectionDetail(final String TransNox,
      final String Acctnox, final String RemCode) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = ? AND sAcctNmbr = ? AND sRemCodex = ? AND cTranStat = 2";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (Acctnox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Acctnox);
    }
    _argIndex = 3;
    if (RemCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, RemCode);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail"}, false, new Callable<EDCPCollectionDetail>() {
      @Override
      public EDCPCollectionDetail call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
          final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
          final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
          final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
          final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
          final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
          final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
          final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
          final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
          final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
          final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
          final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
          final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
          final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
          final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
          final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EDCPCollectionDetail _result;
          if(_cursor.moveToFirst()) {
            _result = new EDCPCollectionDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _result.setEntryNox(_tmpEntryNox);
            final String _tmpAcctNmbr;
            if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
              _tmpAcctNmbr = null;
            } else {
              _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
            }
            _result.setAcctNmbr(_tmpAcctNmbr);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _result.setFullName(_tmpFullName);
            final String _tmpPRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
              _tmpPRNoxxxx = null;
            } else {
              _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
            }
            _result.setPRNoxxxx(_tmpPRNoxxxx);
            final Double _tmpTranAmtx;
            if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
              _tmpTranAmtx = null;
            } else {
              _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
            }
            _result.setTranAmtx(_tmpTranAmtx);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _result.setDiscount(_tmpDiscount);
            final Double _tmpOthersxx;
            if (_cursor.isNull(_cursorIndexOfOthersxx)) {
              _tmpOthersxx = null;
            } else {
              _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
            }
            _result.setOthersxx(_tmpOthersxx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final String _tmpBankIDxx;
            if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
              _tmpBankIDxx = null;
            } else {
              _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
            }
            _result.setBankIDxx(_tmpBankIDxx);
            final String _tmpCheckDte;
            if (_cursor.isNull(_cursorIndexOfCheckDte)) {
              _tmpCheckDte = null;
            } else {
              _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
            }
            _result.setCheckDte(_tmpCheckDte);
            final String _tmpCheckNox;
            if (_cursor.isNull(_cursorIndexOfCheckNox)) {
              _tmpCheckNox = null;
            } else {
              _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
            }
            _result.setCheckNox(_tmpCheckNox);
            final String _tmpCheckAct;
            if (_cursor.isNull(_cursorIndexOfCheckAct)) {
              _tmpCheckAct = null;
            } else {
              _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
            }
            _result.setCheckAct(_tmpCheckAct);
            final String _tmpPromised;
            if (_cursor.isNull(_cursorIndexOfPromised)) {
              _tmpPromised = null;
            } else {
              _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
            }
            _result.setPromised(_tmpPromised);
            final String _tmpRemCodex;
            if (_cursor.isNull(_cursorIndexOfRemCodex)) {
              _tmpRemCodex = null;
            } else {
              _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
            }
            _result.setRemCodex(_tmpRemCodex);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _result.setTranType(_tmpTranType);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _result.setTranTotl(_tmpTranTotl);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _result.setReferNox(_tmpReferNox);
            final String _tmpPaymForm;
            if (_cursor.isNull(_cursorIndexOfPaymForm)) {
              _tmpPaymForm = null;
            } else {
              _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
            }
            _result.setPaymForm(_tmpPaymForm);
            final String _tmpIsDCPxxx;
            if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
              _tmpIsDCPxxx = null;
            } else {
              _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
            }
            _result.setIsDCPxxx(_tmpIsDCPxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _result.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _result.setBrgyName(_tmpBrgyName);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _result.setTownName(_tmpTownName);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _result.setPurchase(_tmpPurchase);
            final Double _tmpMonAmort;
            if (_cursor.isNull(_cursorIndexOfMonAmort)) {
              _tmpMonAmort = null;
            } else {
              _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
            }
            _result.setMonAmort(_tmpMonAmort);
            final Double _tmpAmtDuexx;
            if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
              _tmpAmtDuexx = null;
            } else {
              _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
            }
            _result.setAmtDuexx(_tmpAmtDuexx);
            final String _tmpApntUnit;
            if (_cursor.isNull(_cursorIndexOfApntUnit)) {
              _tmpApntUnit = null;
            } else {
              _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
            }
            _result.setApntUnit(_tmpApntUnit);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _result.setDueDatex(_tmpDueDatex);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _result.setImageNme(_tmpImageNme);
            final Double _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
            }
            _result.setLongitud(_tmpLongitud);
            final Double _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            }
            _result.setLatitude(_tmpLatitude);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _result.setClientID(_tmpClientID);
            final String _tmpSerialID;
            if (_cursor.isNull(_cursorIndexOfSerialID)) {
              _tmpSerialID = null;
            } else {
              _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
            }
            _result.setSerialID(_tmpSerialID);
            final String _tmpSerialNo;
            if (_cursor.isNull(_cursorIndexOfSerialNo)) {
              _tmpSerialNo = null;
            } else {
              _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
            }
            _result.setSerialNo(_tmpSerialNo);
            final Double _tmpLastPaym;
            if (_cursor.isNull(_cursorIndexOfLastPaym)) {
              _tmpLastPaym = null;
            } else {
              _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
            }
            _result.setLastPaym(_tmpLastPaym);
            final String _tmpLastPaid;
            if (_cursor.isNull(_cursorIndexOfLastPaid)) {
              _tmpLastPaid = null;
            } else {
              _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
            }
            _result.setLastPaid(_tmpLastPaid);
            final String _tmpABalance;
            if (_cursor.isNull(_cursorIndexOfABalance)) {
              _tmpABalance = null;
            } else {
              _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
            }
            _result.setABalance(_tmpABalance);
            final Double _tmpDelayAvg;
            if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
              _tmpDelayAvg = null;
            } else {
              _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
            }
            _result.setDelayAvg(_tmpDelayAvg);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _result.setSendDate(_tmpSendDate);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public EDCPCollectionDetail checkCollectionImport(final String sTransNox, final int nEntryNox) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = ? AND nEntryNox = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (sTransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sTransNox);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, nEntryNox);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EDCPCollectionDetail _result;
      if(_cursor.moveToFirst()) {
        _result = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _result.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _result.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _result.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _result.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _result.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _result.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _result.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _result.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _result.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _result.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _result.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _result.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _result.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _result.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _result.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _result.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _result.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _result.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _result.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _result.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _result.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _result.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _result.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _result.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _result.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _result.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _result.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _result.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _result.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _result.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _result.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<DDCPCollectionDetail.Location_Data_Trigger> getDCP_COH_StatusForTracking(
      final String dTransact) {
    final String _sql = "SELECT (SELECT COUNT(*) FROM LR_DCP_Collection_Master WHERE dReferDte ==?) AS CollectionMaster, (SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox == (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE cTranStat == '1') AND sRemCodex == 'PAY') - (SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE dTransact == (SELECT dReferDte FROM LR_DCP_Collection_Master WHERE cTranStat == '1' AND cSendStat == '0')) AS Cash_On_Hand, (SELECT COUNT(*) FROM LR_DCP_Collection_Master WHERE dReferDte ==? AND cTranStat == '2' AND cSendStat == '1') AS PostedCollection";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    _argIndex = 2;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Master","LR_DCP_Collection_Detail","LR_DCP_Remittance"}, false, new Callable<DDCPCollectionDetail.Location_Data_Trigger>() {
      @Override
      public DDCPCollectionDetail.Location_Data_Trigger call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCollectionMaster = 0;
          final int _cursorIndexOfCashOnHand = 1;
          final int _cursorIndexOfPostedCollection = 2;
          final DDCPCollectionDetail.Location_Data_Trigger _result;
          if(_cursor.moveToFirst()) {
            _result = new DDCPCollectionDetail.Location_Data_Trigger();
            _result.CollectionMaster = _cursor.getInt(_cursorIndexOfCollectionMaster);
            if (_cursor.isNull(_cursorIndexOfCashOnHand)) {
              _result.Cash_On_Hand = null;
            } else {
              _result.Cash_On_Hand = _cursor.getString(_cursorIndexOfCashOnHand);
            }
            _result.PostedCollection = _cursor.getInt(_cursorIndexOfPostedCollection);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public DDCPCollectionDetail.DCP_Posting_Validation_Data getValidationData(
      final String dTransact) {
    final String _sql = "SELECT (SELECT COUNT(*) FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?) AND sRemCodex = 'PAY') AS Paid_Collection, (SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE dReferDte =?) AND sRemCodex = 'PAY') - (SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE dTransact =?) AS Remitted_Collection";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    _argIndex = 2;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    _argIndex = 3;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPaidCollection = 0;
      final int _cursorIndexOfRemittedCollection = 1;
      final DDCPCollectionDetail.DCP_Posting_Validation_Data _result;
      if(_cursor.moveToFirst()) {
        _result = new DDCPCollectionDetail.DCP_Posting_Validation_Data();
        _result.Paid_Collection = _cursor.getInt(_cursorIndexOfPaidCollection);
        if (_cursor.isNull(_cursorIndexOfRemittedCollection)) {
          _result.Remitted_Collection = null;
        } else {
          _result.Remitted_Collection = _cursor.getString(_cursorIndexOfRemittedCollection);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EDCPCollectionDetail> getLRDCPCollectionForPosting() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE cSendStat <> '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "xFullName");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfTranAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranAmtx");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfOthersxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthersxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfCheckDte = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckDte");
      final int _cursorIndexOfCheckNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckNox");
      final int _cursorIndexOfCheckAct = CursorUtil.getColumnIndexOrThrow(_cursor, "sCheckAct");
      final int _cursorIndexOfPromised = CursorUtil.getColumnIndexOrThrow(_cursor, "dPromised");
      final int _cursorIndexOfRemCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemCodex");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranType");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfIsDCPxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsDCPxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
      final int _cursorIndexOfMonAmort = CursorUtil.getColumnIndexOrThrow(_cursor, "nMonAmort");
      final int _cursorIndexOfAmtDuexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtDuexx");
      final int _cursorIndexOfApntUnit = CursorUtil.getColumnIndexOrThrow(_cursor, "cApntUnit");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
      final int _cursorIndexOfSerialNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialNo");
      final int _cursorIndexOfLastPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPaym");
      final int _cursorIndexOfLastPaid = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastPaym");
      final int _cursorIndexOfABalance = CursorUtil.getColumnIndexOrThrow(_cursor, "nABalance");
      final int _cursorIndexOfDelayAvg = CursorUtil.getColumnIndexOrThrow(_cursor, "nDelayAvg");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EDCPCollectionDetail> _result = new ArrayList<EDCPCollectionDetail>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EDCPCollectionDetail _item;
        _item = new EDCPCollectionDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _item.setAcctNmbr(_tmpAcctNmbr);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _item.setPRNoxxxx(_tmpPRNoxxxx);
        final Double _tmpTranAmtx;
        if (_cursor.isNull(_cursorIndexOfTranAmtx)) {
          _tmpTranAmtx = null;
        } else {
          _tmpTranAmtx = _cursor.getDouble(_cursorIndexOfTranAmtx);
        }
        _item.setTranAmtx(_tmpTranAmtx);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _item.setDiscount(_tmpDiscount);
        final Double _tmpOthersxx;
        if (_cursor.isNull(_cursorIndexOfOthersxx)) {
          _tmpOthersxx = null;
        } else {
          _tmpOthersxx = _cursor.getDouble(_cursorIndexOfOthersxx);
        }
        _item.setOthersxx(_tmpOthersxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _item.setBankIDxx(_tmpBankIDxx);
        final String _tmpCheckDte;
        if (_cursor.isNull(_cursorIndexOfCheckDte)) {
          _tmpCheckDte = null;
        } else {
          _tmpCheckDte = _cursor.getString(_cursorIndexOfCheckDte);
        }
        _item.setCheckDte(_tmpCheckDte);
        final String _tmpCheckNox;
        if (_cursor.isNull(_cursorIndexOfCheckNox)) {
          _tmpCheckNox = null;
        } else {
          _tmpCheckNox = _cursor.getString(_cursorIndexOfCheckNox);
        }
        _item.setCheckNox(_tmpCheckNox);
        final String _tmpCheckAct;
        if (_cursor.isNull(_cursorIndexOfCheckAct)) {
          _tmpCheckAct = null;
        } else {
          _tmpCheckAct = _cursor.getString(_cursorIndexOfCheckAct);
        }
        _item.setCheckAct(_tmpCheckAct);
        final String _tmpPromised;
        if (_cursor.isNull(_cursorIndexOfPromised)) {
          _tmpPromised = null;
        } else {
          _tmpPromised = _cursor.getString(_cursorIndexOfPromised);
        }
        _item.setPromised(_tmpPromised);
        final String _tmpRemCodex;
        if (_cursor.isNull(_cursorIndexOfRemCodex)) {
          _tmpRemCodex = null;
        } else {
          _tmpRemCodex = _cursor.getString(_cursorIndexOfRemCodex);
        }
        _item.setRemCodex(_tmpRemCodex);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _item.setTranType(_tmpTranType);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _item.setTranTotl(_tmpTranTotl);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _item.setReferNox(_tmpReferNox);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _item.setPaymForm(_tmpPaymForm);
        final String _tmpIsDCPxxx;
        if (_cursor.isNull(_cursorIndexOfIsDCPxxx)) {
          _tmpIsDCPxxx = null;
        } else {
          _tmpIsDCPxxx = _cursor.getString(_cursorIndexOfIsDCPxxx);
        }
        _item.setIsDCPxxx(_tmpIsDCPxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _item.setMobileNo(_tmpMobileNo);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _item.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _item.setBrgyName(_tmpBrgyName);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _item.setTownName(_tmpTownName);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _item.setPurchase(_tmpPurchase);
        final Double _tmpMonAmort;
        if (_cursor.isNull(_cursorIndexOfMonAmort)) {
          _tmpMonAmort = null;
        } else {
          _tmpMonAmort = _cursor.getDouble(_cursorIndexOfMonAmort);
        }
        _item.setMonAmort(_tmpMonAmort);
        final Double _tmpAmtDuexx;
        if (_cursor.isNull(_cursorIndexOfAmtDuexx)) {
          _tmpAmtDuexx = null;
        } else {
          _tmpAmtDuexx = _cursor.getDouble(_cursorIndexOfAmtDuexx);
        }
        _item.setAmtDuexx(_tmpAmtDuexx);
        final String _tmpApntUnit;
        if (_cursor.isNull(_cursorIndexOfApntUnit)) {
          _tmpApntUnit = null;
        } else {
          _tmpApntUnit = _cursor.getString(_cursorIndexOfApntUnit);
        }
        _item.setApntUnit(_tmpApntUnit);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _item.setDueDatex(_tmpDueDatex);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _item.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _item.setClientID(_tmpClientID);
        final String _tmpSerialID;
        if (_cursor.isNull(_cursorIndexOfSerialID)) {
          _tmpSerialID = null;
        } else {
          _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
        }
        _item.setSerialID(_tmpSerialID);
        final String _tmpSerialNo;
        if (_cursor.isNull(_cursorIndexOfSerialNo)) {
          _tmpSerialNo = null;
        } else {
          _tmpSerialNo = _cursor.getString(_cursorIndexOfSerialNo);
        }
        _item.setSerialNo(_tmpSerialNo);
        final Double _tmpLastPaym;
        if (_cursor.isNull(_cursorIndexOfLastPaym)) {
          _tmpLastPaym = null;
        } else {
          _tmpLastPaym = _cursor.getDouble(_cursorIndexOfLastPaym);
        }
        _item.setLastPaym(_tmpLastPaym);
        final String _tmpLastPaid;
        if (_cursor.isNull(_cursorIndexOfLastPaid)) {
          _tmpLastPaid = null;
        } else {
          _tmpLastPaid = _cursor.getString(_cursorIndexOfLastPaid);
        }
        _item.setLastPaid(_tmpLastPaid);
        final String _tmpABalance;
        if (_cursor.isNull(_cursorIndexOfABalance)) {
          _tmpABalance = null;
        } else {
          _tmpABalance = _cursor.getString(_cursorIndexOfABalance);
        }
        _item.setABalance(_tmpABalance);
        final Double _tmpDelayAvg;
        if (_cursor.isNull(_cursorIndexOfDelayAvg)) {
          _tmpDelayAvg = null;
        } else {
          _tmpDelayAvg = _cursor.getDouble(_cursorIndexOfDelayAvg);
        }
        _item.setDelayAvg(_tmpDelayAvg);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _item.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
