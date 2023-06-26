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
import org.rmj.g3appdriver.GCircle.room.Entities.EDCPCollectionDetail;
import org.rmj.g3appdriver.GCircle.room.Entities.EDCPCollectionMaster;
import org.rmj.g3appdriver.GCircle.room.Entities.EDCP_Remittance;
import org.rmj.g3appdriver.GCircle.room.Entities.EImageInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DLRDcp_Impl implements DLRDcp {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EDCPCollectionMaster> __insertionAdapterOfEDCPCollectionMaster;

  private final EntityInsertionAdapter<EDCPCollectionDetail> __insertionAdapterOfEDCPCollectionDetail;

  private final EntityDeletionOrUpdateAdapter<EDCPCollectionDetail> __updateAdapterOfEDCPCollectionDetail;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePostedDcpMaster;

  private final SharedSQLiteStatement __preparedStmtOfClearMasterDCP;

  private final SharedSQLiteStatement __preparedStmtOfClearDetailDCP;

  private final SharedSQLiteStatement __preparedStmtOfClearDCPRemittance;

  public DLRDcp_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEDCPCollectionMaster = new EntityInsertionAdapter<EDCPCollectionMaster>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `LR_DCP_Collection_Master` (`sTransNox`,`dTransact`,`sReferNox`,`xCollName`,`sRouteNme`,`dReferDte`,`cTranStat`,`cDCPTypex`,`nEntryNox`,`sBranchNm`,`sCollctID`,`cSendStat`,`dSendDate`,`dModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EDCPCollectionMaster value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReferNox());
        }
        if (value.getCollName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCollName());
        }
        if (value.getRouteNme() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRouteNme());
        }
        if (value.getReferDte() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReferDte());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTranStat());
        }
        if (value.getDCPTypex() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDCPTypex());
        }
        if (value.getEntryNox() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getEntryNox());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBranchNm());
        }
        if (value.getCollctID() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCollctID());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getSendDate());
        }
        if (value.getModified() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getModified());
        }
      }
    };
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
    this.__preparedStmtOfUpdatePostedDcpMaster = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE LR_DCP_Collection_Master SET cSendStat = '1', cTranStat = '2', dSendDate =?, dModified =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfClearMasterDCP = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM LR_DCP_Collection_Master";
        return _query;
      }
    };
    this.__preparedStmtOfClearDetailDCP = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM LR_DCP_Collection_Detail";
        return _query;
      }
    };
    this.__preparedStmtOfClearDCPRemittance = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM LR_DCP_Remittance";
        return _query;
      }
    };
  }

  @Override
  public void SaveDcpMaster(final EDCPCollectionMaster foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEDCPCollectionMaster.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void SaveDcpDetail(final EDCPCollectionDetail foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEDCPCollectionDetail.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateCollectionDetail(final EDCPCollectionDetail foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEDCPCollectionDetail.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdatePostedDcpMaster(final String TransNox, final String DatePostd) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePostedDcpMaster.acquire();
    int _argIndex = 1;
    if (DatePostd == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DatePostd);
    }
    _argIndex = 2;
    if (DatePostd == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DatePostd);
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
      __preparedStmtOfUpdatePostedDcpMaster.release(_stmt);
    }
  }

  @Override
  public void ClearMasterDCP() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearMasterDCP.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearMasterDCP.release(_stmt);
    }
  }

  @Override
  public void ClearDetailDCP() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearDetailDCP.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearDetailDCP.release(_stmt);
    }
  }

  @Override
  public void ClearDCPRemittance() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearDCPRemittance.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearDCPRemittance.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EDCPCollectionDetail>> GetCollectionList() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox = (SELECT sTransNox FROM LR_DCP_Collection_Master WHERE cSendStat IS NULL) AND cTranStat != '2' ORDER BY dModified ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public LiveData<EDCPCollectionDetail> GetCollectionDetailForTransaction(final String TransNox,
      final String AccountNo, final String EntryNo) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox=? AND sAcctNmbr =? AND nEntryNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (AccountNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AccountNo);
    }
    _argIndex = 3;
    if (EntryNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, EntryNo);
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
  public String GetEmployID() {
    final String _sql = "SELECT sEmployID FROM User_Info_Master";
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
  public int GetNewEntryNox() {
    final String _sql = "SELECT COUNT (*) + 1 AS nEntryNox FROM LR_DCP_Collection_Detail";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public EDCPCollectionDetail GetCollectionForValidation(final String TransNox,
      final String AccountNo) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox=? AND sAcctNmbr =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (AccountNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AccountNo);
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
  public EDCPCollectionMaster GetMaster(final String TransNox) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Master WHERE sTransNox =?";
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
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfCollName = CursorUtil.getColumnIndexOrThrow(_cursor, "xCollName");
      final int _cursorIndexOfRouteNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sRouteNme");
      final int _cursorIndexOfReferDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dReferDte");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDCPTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCPTypex");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfCollctID = CursorUtil.getColumnIndexOrThrow(_cursor, "sCollctID");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EDCPCollectionMaster _result;
      if(_cursor.moveToFirst()) {
        _result = new EDCPCollectionMaster();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpCollName;
        if (_cursor.isNull(_cursorIndexOfCollName)) {
          _tmpCollName = null;
        } else {
          _tmpCollName = _cursor.getString(_cursorIndexOfCollName);
        }
        _result.setCollName(_tmpCollName);
        final String _tmpRouteNme;
        if (_cursor.isNull(_cursorIndexOfRouteNme)) {
          _tmpRouteNme = null;
        } else {
          _tmpRouteNme = _cursor.getString(_cursorIndexOfRouteNme);
        }
        _result.setRouteNme(_tmpRouteNme);
        final String _tmpReferDte;
        if (_cursor.isNull(_cursorIndexOfReferDte)) {
          _tmpReferDte = null;
        } else {
          _tmpReferDte = _cursor.getString(_cursorIndexOfReferDte);
        }
        _result.setReferDte(_tmpReferDte);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpDCPTypex;
        if (_cursor.isNull(_cursorIndexOfDCPTypex)) {
          _tmpDCPTypex = null;
        } else {
          _tmpDCPTypex = _cursor.getString(_cursorIndexOfDCPTypex);
        }
        _result.setDCPTypex(_tmpDCPTypex);
        final String _tmpEntryNox;
        if (_cursor.isNull(_cursorIndexOfEntryNox)) {
          _tmpEntryNox = null;
        } else {
          _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
        }
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpCollctID;
        if (_cursor.isNull(_cursorIndexOfCollctID)) {
          _tmpCollctID = null;
        } else {
          _tmpCollctID = _cursor.getString(_cursorIndexOfCollctID);
        }
        _result.setCollctID(_tmpCollctID);
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
  public EDCPCollectionMaster GetColletionMasterForPosting() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Master WHERE cSendStat IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfCollName = CursorUtil.getColumnIndexOrThrow(_cursor, "xCollName");
      final int _cursorIndexOfRouteNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sRouteNme");
      final int _cursorIndexOfReferDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dReferDte");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDCPTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCPTypex");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfCollctID = CursorUtil.getColumnIndexOrThrow(_cursor, "sCollctID");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EDCPCollectionMaster _result;
      if(_cursor.moveToFirst()) {
        _result = new EDCPCollectionMaster();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpCollName;
        if (_cursor.isNull(_cursorIndexOfCollName)) {
          _tmpCollName = null;
        } else {
          _tmpCollName = _cursor.getString(_cursorIndexOfCollName);
        }
        _result.setCollName(_tmpCollName);
        final String _tmpRouteNme;
        if (_cursor.isNull(_cursorIndexOfRouteNme)) {
          _tmpRouteNme = null;
        } else {
          _tmpRouteNme = _cursor.getString(_cursorIndexOfRouteNme);
        }
        _result.setRouteNme(_tmpRouteNme);
        final String _tmpReferDte;
        if (_cursor.isNull(_cursorIndexOfReferDte)) {
          _tmpReferDte = null;
        } else {
          _tmpReferDte = _cursor.getString(_cursorIndexOfReferDte);
        }
        _result.setReferDte(_tmpReferDte);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpDCPTypex;
        if (_cursor.isNull(_cursorIndexOfDCPTypex)) {
          _tmpDCPTypex = null;
        } else {
          _tmpDCPTypex = _cursor.getString(_cursorIndexOfDCPTypex);
        }
        _result.setDCPTypex(_tmpDCPTypex);
        final String _tmpEntryNox;
        if (_cursor.isNull(_cursorIndexOfEntryNox)) {
          _tmpEntryNox = null;
        } else {
          _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
        }
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpCollctID;
        if (_cursor.isNull(_cursorIndexOfCollctID)) {
          _tmpCollctID = null;
        } else {
          _tmpCollctID = _cursor.getString(_cursorIndexOfCollctID);
        }
        _result.setCollctID(_tmpCollctID);
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
  public LiveData<EDCPCollectionMaster> GetMasterCollectionForDate(final String fsVal) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Master WHERE dReferDte =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Master"}, false, new Callable<EDCPCollectionMaster>() {
      @Override
      public EDCPCollectionMaster call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfCollName = CursorUtil.getColumnIndexOrThrow(_cursor, "xCollName");
          final int _cursorIndexOfRouteNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sRouteNme");
          final int _cursorIndexOfReferDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dReferDte");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfDCPTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCPTypex");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfCollctID = CursorUtil.getColumnIndexOrThrow(_cursor, "sCollctID");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EDCPCollectionMaster _result;
          if(_cursor.moveToFirst()) {
            _result = new EDCPCollectionMaster();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _result.setTransact(_tmpTransact);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _result.setReferNox(_tmpReferNox);
            final String _tmpCollName;
            if (_cursor.isNull(_cursorIndexOfCollName)) {
              _tmpCollName = null;
            } else {
              _tmpCollName = _cursor.getString(_cursorIndexOfCollName);
            }
            _result.setCollName(_tmpCollName);
            final String _tmpRouteNme;
            if (_cursor.isNull(_cursorIndexOfRouteNme)) {
              _tmpRouteNme = null;
            } else {
              _tmpRouteNme = _cursor.getString(_cursorIndexOfRouteNme);
            }
            _result.setRouteNme(_tmpRouteNme);
            final String _tmpReferDte;
            if (_cursor.isNull(_cursorIndexOfReferDte)) {
              _tmpReferDte = null;
            } else {
              _tmpReferDte = _cursor.getString(_cursorIndexOfReferDte);
            }
            _result.setReferDte(_tmpReferDte);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpDCPTypex;
            if (_cursor.isNull(_cursorIndexOfDCPTypex)) {
              _tmpDCPTypex = null;
            } else {
              _tmpDCPTypex = _cursor.getString(_cursorIndexOfDCPTypex);
            }
            _result.setDCPTypex(_tmpDCPTypex);
            final String _tmpEntryNox;
            if (_cursor.isNull(_cursorIndexOfEntryNox)) {
              _tmpEntryNox = null;
            } else {
              _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
            }
            _result.setEntryNox(_tmpEntryNox);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final String _tmpCollctID;
            if (_cursor.isNull(_cursorIndexOfCollctID)) {
              _tmpCollctID = null;
            } else {
              _tmpCollctID = _cursor.getString(_cursorIndexOfCollctID);
            }
            _result.setCollctID(_tmpCollctID);
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
  public LiveData<List<EDCPCollectionDetail>> GetCollectionDetailForPreview(final String fsVal) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox=? AND cTranStat == '2'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
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
  public List<EDCPCollectionDetail> GetCollectionDetailForPosting(final String TransNox) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND cSendStat <> '1'";
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
  public EImageInfo GetDcpImageForPosting(final String TransNox, final String AccntNo) {
    final String _sql = "SELECT * FROM Image_Information WHERE sSourceNo =? AND sDtlSrcNo=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (AccntNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AccntNo);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfMD5Hashx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMD5Hashx");
      final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfCaptured = CursorUtil.getColumnIndexOrThrow(_cursor, "dCaptured");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final EImageInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EImageInfo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _result.setSourceCD(_tmpSourceCD);
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
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _result.setFileCode(_tmpFileCode);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
        final String _tmpMD5Hashx;
        if (_cursor.isNull(_cursorIndexOfMD5Hashx)) {
          _tmpMD5Hashx = null;
        } else {
          _tmpMD5Hashx = _cursor.getString(_cursorIndexOfMD5Hashx);
        }
        _result.setMD5Hashx(_tmpMD5Hashx);
        final String _tmpFileLoct;
        if (_cursor.isNull(_cursorIndexOfFileLoct)) {
          _tmpFileLoct = null;
        } else {
          _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
        }
        _result.setFileLoct(_tmpFileLoct);
        final String _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final String _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
        }
        _result.setLongitud(_tmpLongitud);
        final String _tmpCaptured;
        if (_cursor.isNull(_cursorIndexOfCaptured)) {
          _tmpCaptured = null;
        } else {
          _tmpCaptured = _cursor.getString(_cursorIndexOfCaptured);
        }
        _result.setCaptured(_tmpCaptured);
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
  public List<EDCPCollectionDetail> GetNotVisitedCollection(final String TransNox) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND sRemCodex == ''";
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
  public int CheckForNotVisitedCollection(final String TransNox) {
    final String _sql = "SELECT COUNT(*) FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND sRemCodex = ''";
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
  public double GetCollectedCashPayments(final String fsVal) {
    final String _sql = "SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND sCheckNox == '' AND sCheckDte == '' AND sCheckAct == ''";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double GetCollectedCheckPayments(final String fsVal) {
    final String _sql = "SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND sCheckNox <> '' AND sCheckDte <> '' AND sCheckAct <> ''";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EDCP_Remittance> GetCollectionRemittance(final String fsVal) {
    final String _sql = "SELECT * FROM LR_DCP_Remittance WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfRemitTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cRemitTyp");
      final int _cursorIndexOfCompnyNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sCompnyNm");
      final int _cursorIndexOfBankAcct = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankAcct");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfAmountxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmountxx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfDateSent = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateSent");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<EDCP_Remittance> _result = new ArrayList<EDCP_Remittance>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EDCP_Remittance _item;
        _item = new EDCP_Remittance();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final Integer _tmpEntryNox;
        if (_cursor.isNull(_cursorIndexOfEntryNox)) {
          _tmpEntryNox = null;
        } else {
          _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        }
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _item.setPaymForm(_tmpPaymForm);
        final String _tmpRemitTyp;
        if (_cursor.isNull(_cursorIndexOfRemitTyp)) {
          _tmpRemitTyp = null;
        } else {
          _tmpRemitTyp = _cursor.getString(_cursorIndexOfRemitTyp);
        }
        _item.setRemitTyp(_tmpRemitTyp);
        final String _tmpCompnyNm;
        if (_cursor.isNull(_cursorIndexOfCompnyNm)) {
          _tmpCompnyNm = null;
        } else {
          _tmpCompnyNm = _cursor.getString(_cursorIndexOfCompnyNm);
        }
        _item.setCompnyNm(_tmpCompnyNm);
        final String _tmpBankAcct;
        if (_cursor.isNull(_cursorIndexOfBankAcct)) {
          _tmpBankAcct = null;
        } else {
          _tmpBankAcct = _cursor.getString(_cursorIndexOfBankAcct);
        }
        _item.setBankAcct(_tmpBankAcct);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _item.setReferNox(_tmpReferNox);
        final double _tmpAmountxx;
        _tmpAmountxx = _cursor.getDouble(_cursorIndexOfAmountxx);
        _item.setAmountxx(_tmpAmountxx);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpDateSent;
        if (_cursor.isNull(_cursorIndexOfDateSent)) {
          _tmpDateSent = null;
        } else {
          _tmpDateSent = _cursor.getString(_cursorIndexOfDateSent);
        }
        _item.setDateSent(_tmpDateSent);
        final String _tmpTimeStmp;
        if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
          _tmpTimeStmp = null;
        } else {
          _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
        }
        _item.setTimeStmp(_tmpTimeStmp);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EDCPCollectionDetail> GetPaidCollections(final String fsVal) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND sRemCodex = 'PAY'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
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
  public double GetRemittedCollection(final String fsVal) {
    final String _sql = "SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double GetCashRemittedCollection(final String fsVal) {
    final String _sql = "SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox =? AND cPaymForm ='0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double GetCheckRemittedCollection(final String fsVal) {
    final String _sql = "SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox =? AND cPaymForm ='1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<EDCPCollectionMaster> GetColletionMasterForRemittance() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Master WHERE cSendStat IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Master"}, false, new Callable<EDCPCollectionMaster>() {
      @Override
      public EDCPCollectionMaster call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfCollName = CursorUtil.getColumnIndexOrThrow(_cursor, "xCollName");
          final int _cursorIndexOfRouteNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sRouteNme");
          final int _cursorIndexOfReferDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dReferDte");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfDCPTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCPTypex");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfCollctID = CursorUtil.getColumnIndexOrThrow(_cursor, "sCollctID");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EDCPCollectionMaster _result;
          if(_cursor.moveToFirst()) {
            _result = new EDCPCollectionMaster();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _result.setTransact(_tmpTransact);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _result.setReferNox(_tmpReferNox);
            final String _tmpCollName;
            if (_cursor.isNull(_cursorIndexOfCollName)) {
              _tmpCollName = null;
            } else {
              _tmpCollName = _cursor.getString(_cursorIndexOfCollName);
            }
            _result.setCollName(_tmpCollName);
            final String _tmpRouteNme;
            if (_cursor.isNull(_cursorIndexOfRouteNme)) {
              _tmpRouteNme = null;
            } else {
              _tmpRouteNme = _cursor.getString(_cursorIndexOfRouteNme);
            }
            _result.setRouteNme(_tmpRouteNme);
            final String _tmpReferDte;
            if (_cursor.isNull(_cursorIndexOfReferDte)) {
              _tmpReferDte = null;
            } else {
              _tmpReferDte = _cursor.getString(_cursorIndexOfReferDte);
            }
            _result.setReferDte(_tmpReferDte);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpDCPTypex;
            if (_cursor.isNull(_cursorIndexOfDCPTypex)) {
              _tmpDCPTypex = null;
            } else {
              _tmpDCPTypex = _cursor.getString(_cursorIndexOfDCPTypex);
            }
            _result.setDCPTypex(_tmpDCPTypex);
            final String _tmpEntryNox;
            if (_cursor.isNull(_cursorIndexOfEntryNox)) {
              _tmpEntryNox = null;
            } else {
              _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
            }
            _result.setEntryNox(_tmpEntryNox);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final String _tmpCollctID;
            if (_cursor.isNull(_cursorIndexOfCollctID)) {
              _tmpCollctID = null;
            } else {
              _tmpCollctID = _cursor.getString(_cursorIndexOfCollctID);
            }
            _result.setCollctID(_tmpCollctID);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
