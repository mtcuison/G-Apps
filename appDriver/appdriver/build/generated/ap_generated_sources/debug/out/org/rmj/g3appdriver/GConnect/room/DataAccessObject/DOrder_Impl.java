package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

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
import org.rmj.g3appdriver.GConnect.room.Entities.EItemCart;
import org.rmj.g3appdriver.GConnect.room.Entities.EOrderMaster;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DOrder_Impl implements DOrder {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EOrderMaster> __insertionAdapterOfEOrderMaster;

  private final EntityInsertionAdapter<EItemCart> __insertionAdapterOfEItemCart;

  private final EntityDeletionOrUpdateAdapter<EOrderMaster> __updateAdapterOfEOrderMaster;

  private final SharedSQLiteStatement __preparedStmtOfRemoveItemFromCart;

  public DOrder_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEOrderMaster = new EntityInsertionAdapter<EOrderMaster>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MarketPlace_Order_Master` (`sTransNox`,`sBranchCd`,`dTransact`,`dExpected`,`sClientID`,`sAppUsrID`,`sReferNox`,`sRemarksx`,`nTranTotl`,`nVATRatex`,`nDiscount`,`nAddDiscx`,`nFreightx`,`nProcPaym`,`nAmtPaidx`,`dDueDatex`,`sTermCode`,`sSourceNo`,`sSourceCd`,`cTranStat`,`dWaybillx`,`sWaybilNo`,`sBatchNox`,`dPickedUp`,`cPaymPstd`,`cPaymType`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EOrderMaster value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCd());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getExpected() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getExpected());
        }
        if (value.getClientID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getClientID());
        }
        if (value.getAppUsrID() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAppUsrID());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getReferNox());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRemarksx());
        }
        if (value.getTranTotl() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getTranTotl());
        }
        if (value.getVATRatex() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getVATRatex());
        }
        if (value.getDiscount() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getDiscount());
        }
        if (value.getAddDiscx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindDouble(12, value.getAddDiscx());
        }
        if (value.getFreightx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindDouble(13, value.getFreightx());
        }
        if (value.getProcPaym() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindDouble(14, value.getProcPaym());
        }
        if (value.getAmtPaidx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindDouble(15, value.getAmtPaidx());
        }
        if (value.getDueDatex() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getDueDatex());
        }
        if (value.getTermCode() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getTermCode());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getSourceNo());
        }
        if (value.getSourceCd() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getSourceCd());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getTranStat());
        }
        if (value.getWaybillx() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getWaybillx());
        }
        if (value.getWaybilNo() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getWaybilNo());
        }
        if (value.getBatchNox() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getBatchNox());
        }
        if (value.getPickedUp() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getPickedUp());
        }
        if (value.getPaymPstd() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getPaymPstd());
        }
        if (value.getPaymType() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getPaymType());
        }
        if (value.getModified() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfEItemCart = new EntityInsertionAdapter<EItemCart>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MarketPlace_Cart` (`sUserIDxx`,`sListIDxx`,`cBuyNowxx`,`nQuantity`,`nAvlQtyxx`,`dCreatedx`,`cTranStat`,`cCheckOut`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EItemCart value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getListIDxx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getListIDxx());
        }
        if (value.getBuyNowxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBuyNowxx());
        }
        if (value.getQuantity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getQuantity());
        }
        if (value.getAvlQtyxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getAvlQtyxx());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreatedx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTranStat());
        }
        if (value.getCheckOut() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCheckOut());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEOrderMaster = new EntityDeletionOrUpdateAdapter<EOrderMaster>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MarketPlace_Order_Master` SET `sTransNox` = ?,`sBranchCd` = ?,`dTransact` = ?,`dExpected` = ?,`sClientID` = ?,`sAppUsrID` = ?,`sReferNox` = ?,`sRemarksx` = ?,`nTranTotl` = ?,`nVATRatex` = ?,`nDiscount` = ?,`nAddDiscx` = ?,`nFreightx` = ?,`nProcPaym` = ?,`nAmtPaidx` = ?,`dDueDatex` = ?,`sTermCode` = ?,`sSourceNo` = ?,`sSourceCd` = ?,`cTranStat` = ?,`dWaybillx` = ?,`sWaybilNo` = ?,`sBatchNox` = ?,`dPickedUp` = ?,`cPaymPstd` = ?,`cPaymType` = ?,`dModified` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EOrderMaster value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCd());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getExpected() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getExpected());
        }
        if (value.getClientID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getClientID());
        }
        if (value.getAppUsrID() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAppUsrID());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getReferNox());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRemarksx());
        }
        if (value.getTranTotl() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindDouble(9, value.getTranTotl());
        }
        if (value.getVATRatex() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindDouble(10, value.getVATRatex());
        }
        if (value.getDiscount() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getDiscount());
        }
        if (value.getAddDiscx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindDouble(12, value.getAddDiscx());
        }
        if (value.getFreightx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindDouble(13, value.getFreightx());
        }
        if (value.getProcPaym() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindDouble(14, value.getProcPaym());
        }
        if (value.getAmtPaidx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindDouble(15, value.getAmtPaidx());
        }
        if (value.getDueDatex() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getDueDatex());
        }
        if (value.getTermCode() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getTermCode());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getSourceNo());
        }
        if (value.getSourceCd() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getSourceCd());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getTranStat());
        }
        if (value.getWaybillx() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getWaybillx());
        }
        if (value.getWaybilNo() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getWaybilNo());
        }
        if (value.getBatchNox() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getBatchNox());
        }
        if (value.getPickedUp() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getPickedUp());
        }
        if (value.getPaymPstd() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getPaymPstd());
        }
        if (value.getPaymType() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getPaymType());
        }
        if (value.getModified() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfRemoveItemFromCart = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MarketPlace_Cart WHERE cBuyNowxx = '1' AND cCheckOut = '1'";
        return _query;
      }
    };
  }

  @Override
  public void SaveOrderMaster(final EOrderMaster foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEOrderMaster.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void SaveItemInfo(final EItemCart foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEItemCart.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateMaster(final EOrderMaster foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEOrderMaster.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void RemoveItemFromCart() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveItemFromCart.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveItemFromCart.release(_stmt);
    }
  }

  @Override
  public EOrderMaster CheckOrderMasterIfExist(final String fsTransNo) {
    final String _sql = "SELECT * FROM MarketPlace_Order_Master WHERE sTransNox=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsTransNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsTransNo);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfExpected = CursorUtil.getColumnIndexOrThrow(_cursor, "dExpected");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfAppUsrID = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppUsrID");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
      final int _cursorIndexOfVATRatex = CursorUtil.getColumnIndexOrThrow(_cursor, "nVATRatex");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfAddDiscx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAddDiscx");
      final int _cursorIndexOfFreightx = CursorUtil.getColumnIndexOrThrow(_cursor, "nFreightx");
      final int _cursorIndexOfProcPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nProcPaym");
      final int _cursorIndexOfAmtPaidx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtPaidx");
      final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
      final int _cursorIndexOfTermCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sTermCode");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfSourceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCd");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfWaybillx = CursorUtil.getColumnIndexOrThrow(_cursor, "dWaybillx");
      final int _cursorIndexOfWaybilNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sWaybilNo");
      final int _cursorIndexOfBatchNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sBatchNox");
      final int _cursorIndexOfPickedUp = CursorUtil.getColumnIndexOrThrow(_cursor, "dPickedUp");
      final int _cursorIndexOfPaymPstd = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymPstd");
      final int _cursorIndexOfPaymType = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymType");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EOrderMaster _result;
      if(_cursor.moveToFirst()) {
        _result = new EOrderMaster();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpExpected;
        if (_cursor.isNull(_cursorIndexOfExpected)) {
          _tmpExpected = null;
        } else {
          _tmpExpected = _cursor.getString(_cursorIndexOfExpected);
        }
        _result.setExpected(_tmpExpected);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpAppUsrID;
        if (_cursor.isNull(_cursorIndexOfAppUsrID)) {
          _tmpAppUsrID = null;
        } else {
          _tmpAppUsrID = _cursor.getString(_cursorIndexOfAppUsrID);
        }
        _result.setAppUsrID(_tmpAppUsrID);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final Double _tmpTranTotl;
        if (_cursor.isNull(_cursorIndexOfTranTotl)) {
          _tmpTranTotl = null;
        } else {
          _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
        }
        _result.setTranTotl(_tmpTranTotl);
        final Double _tmpVATRatex;
        if (_cursor.isNull(_cursorIndexOfVATRatex)) {
          _tmpVATRatex = null;
        } else {
          _tmpVATRatex = _cursor.getDouble(_cursorIndexOfVATRatex);
        }
        _result.setVATRatex(_tmpVATRatex);
        final Double _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
        }
        _result.setDiscount(_tmpDiscount);
        final Double _tmpAddDiscx;
        if (_cursor.isNull(_cursorIndexOfAddDiscx)) {
          _tmpAddDiscx = null;
        } else {
          _tmpAddDiscx = _cursor.getDouble(_cursorIndexOfAddDiscx);
        }
        _result.setAddDiscx(_tmpAddDiscx);
        final Double _tmpFreightx;
        if (_cursor.isNull(_cursorIndexOfFreightx)) {
          _tmpFreightx = null;
        } else {
          _tmpFreightx = _cursor.getDouble(_cursorIndexOfFreightx);
        }
        _result.setFreightx(_tmpFreightx);
        final Double _tmpProcPaym;
        if (_cursor.isNull(_cursorIndexOfProcPaym)) {
          _tmpProcPaym = null;
        } else {
          _tmpProcPaym = _cursor.getDouble(_cursorIndexOfProcPaym);
        }
        _result.setProcPaym(_tmpProcPaym);
        final Double _tmpAmtPaidx;
        if (_cursor.isNull(_cursorIndexOfAmtPaidx)) {
          _tmpAmtPaidx = null;
        } else {
          _tmpAmtPaidx = _cursor.getDouble(_cursorIndexOfAmtPaidx);
        }
        _result.setAmtPaidx(_tmpAmtPaidx);
        final String _tmpDueDatex;
        if (_cursor.isNull(_cursorIndexOfDueDatex)) {
          _tmpDueDatex = null;
        } else {
          _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
        }
        _result.setDueDatex(_tmpDueDatex);
        final String _tmpTermCode;
        if (_cursor.isNull(_cursorIndexOfTermCode)) {
          _tmpTermCode = null;
        } else {
          _tmpTermCode = _cursor.getString(_cursorIndexOfTermCode);
        }
        _result.setTermCode(_tmpTermCode);
        final String _tmpSourceNo;
        if (_cursor.isNull(_cursorIndexOfSourceNo)) {
          _tmpSourceNo = null;
        } else {
          _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
        }
        _result.setSourceNo(_tmpSourceNo);
        final String _tmpSourceCd;
        if (_cursor.isNull(_cursorIndexOfSourceCd)) {
          _tmpSourceCd = null;
        } else {
          _tmpSourceCd = _cursor.getString(_cursorIndexOfSourceCd);
        }
        _result.setSourceCd(_tmpSourceCd);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpWaybillx;
        if (_cursor.isNull(_cursorIndexOfWaybillx)) {
          _tmpWaybillx = null;
        } else {
          _tmpWaybillx = _cursor.getString(_cursorIndexOfWaybillx);
        }
        _result.setWaybillx(_tmpWaybillx);
        final String _tmpWaybilNo;
        if (_cursor.isNull(_cursorIndexOfWaybilNo)) {
          _tmpWaybilNo = null;
        } else {
          _tmpWaybilNo = _cursor.getString(_cursorIndexOfWaybilNo);
        }
        _result.setWaybilNo(_tmpWaybilNo);
        final String _tmpBatchNox;
        if (_cursor.isNull(_cursorIndexOfBatchNox)) {
          _tmpBatchNox = null;
        } else {
          _tmpBatchNox = _cursor.getString(_cursorIndexOfBatchNox);
        }
        _result.setBatchNox(_tmpBatchNox);
        final String _tmpPickedUp;
        if (_cursor.isNull(_cursorIndexOfPickedUp)) {
          _tmpPickedUp = null;
        } else {
          _tmpPickedUp = _cursor.getString(_cursorIndexOfPickedUp);
        }
        _result.setPickedUp(_tmpPickedUp);
        final String _tmpPaymPstd;
        if (_cursor.isNull(_cursorIndexOfPaymPstd)) {
          _tmpPaymPstd = null;
        } else {
          _tmpPaymPstd = _cursor.getString(_cursorIndexOfPaymPstd);
        }
        _result.setPaymPstd(_tmpPaymPstd);
        final String _tmpPaymType;
        if (_cursor.isNull(_cursorIndexOfPaymType)) {
          _tmpPaymType = null;
        } else {
          _tmpPaymType = _cursor.getString(_cursorIndexOfPaymType);
        }
        _result.setPaymType(_tmpPaymType);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
        final String _tmpTimeStmp;
        if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
          _tmpTimeStmp = null;
        } else {
          _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
        }
        _result.setTimeStmp(_tmpTimeStmp);
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
  public int CheckIfMasterHasRecord() {
    final String _sql = "SELECT COUNT(sTransNox) FROM MarketPlace_Order_Master";
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
  public String getMasterLatestTimeStmp() {
    final String _sql = "SELECT dTimeStmp FROM MarketPlace_Order_Detail ORDER BY dTimeStmp DESC LIMIT 1";
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
  public LiveData<Integer> GetOrdersCount() {
    final String _sql = "SELECT COUNT(*) FROM MarketPlace_Order_Master WHERE cTranStat != '3'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master"}, false, new Callable<Integer>() {
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
  public LiveData<EOrderMaster> GetMasterInfo(final String fsTransNo) {
    final String _sql = "SELECT * FROM MarketPlace_Order_Master WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsTransNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsTransNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master"}, false, new Callable<EOrderMaster>() {
      @Override
      public EOrderMaster call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfExpected = CursorUtil.getColumnIndexOrThrow(_cursor, "dExpected");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfAppUsrID = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppUsrID");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfVATRatex = CursorUtil.getColumnIndexOrThrow(_cursor, "nVATRatex");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfAddDiscx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAddDiscx");
          final int _cursorIndexOfFreightx = CursorUtil.getColumnIndexOrThrow(_cursor, "nFreightx");
          final int _cursorIndexOfProcPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nProcPaym");
          final int _cursorIndexOfAmtPaidx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtPaidx");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfTermCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sTermCode");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfSourceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCd");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfWaybillx = CursorUtil.getColumnIndexOrThrow(_cursor, "dWaybillx");
          final int _cursorIndexOfWaybilNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sWaybilNo");
          final int _cursorIndexOfBatchNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sBatchNox");
          final int _cursorIndexOfPickedUp = CursorUtil.getColumnIndexOrThrow(_cursor, "dPickedUp");
          final int _cursorIndexOfPaymPstd = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymPstd");
          final int _cursorIndexOfPaymType = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymType");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final EOrderMaster _result;
          if(_cursor.moveToFirst()) {
            _result = new EOrderMaster();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _result.setTransact(_tmpTransact);
            final String _tmpExpected;
            if (_cursor.isNull(_cursorIndexOfExpected)) {
              _tmpExpected = null;
            } else {
              _tmpExpected = _cursor.getString(_cursorIndexOfExpected);
            }
            _result.setExpected(_tmpExpected);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _result.setClientID(_tmpClientID);
            final String _tmpAppUsrID;
            if (_cursor.isNull(_cursorIndexOfAppUsrID)) {
              _tmpAppUsrID = null;
            } else {
              _tmpAppUsrID = _cursor.getString(_cursorIndexOfAppUsrID);
            }
            _result.setAppUsrID(_tmpAppUsrID);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _result.setReferNox(_tmpReferNox);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _result.setTranTotl(_tmpTranTotl);
            final Double _tmpVATRatex;
            if (_cursor.isNull(_cursorIndexOfVATRatex)) {
              _tmpVATRatex = null;
            } else {
              _tmpVATRatex = _cursor.getDouble(_cursorIndexOfVATRatex);
            }
            _result.setVATRatex(_tmpVATRatex);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _result.setDiscount(_tmpDiscount);
            final Double _tmpAddDiscx;
            if (_cursor.isNull(_cursorIndexOfAddDiscx)) {
              _tmpAddDiscx = null;
            } else {
              _tmpAddDiscx = _cursor.getDouble(_cursorIndexOfAddDiscx);
            }
            _result.setAddDiscx(_tmpAddDiscx);
            final Double _tmpFreightx;
            if (_cursor.isNull(_cursorIndexOfFreightx)) {
              _tmpFreightx = null;
            } else {
              _tmpFreightx = _cursor.getDouble(_cursorIndexOfFreightx);
            }
            _result.setFreightx(_tmpFreightx);
            final Double _tmpProcPaym;
            if (_cursor.isNull(_cursorIndexOfProcPaym)) {
              _tmpProcPaym = null;
            } else {
              _tmpProcPaym = _cursor.getDouble(_cursorIndexOfProcPaym);
            }
            _result.setProcPaym(_tmpProcPaym);
            final Double _tmpAmtPaidx;
            if (_cursor.isNull(_cursorIndexOfAmtPaidx)) {
              _tmpAmtPaidx = null;
            } else {
              _tmpAmtPaidx = _cursor.getDouble(_cursorIndexOfAmtPaidx);
            }
            _result.setAmtPaidx(_tmpAmtPaidx);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _result.setDueDatex(_tmpDueDatex);
            final String _tmpTermCode;
            if (_cursor.isNull(_cursorIndexOfTermCode)) {
              _tmpTermCode = null;
            } else {
              _tmpTermCode = _cursor.getString(_cursorIndexOfTermCode);
            }
            _result.setTermCode(_tmpTermCode);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _result.setSourceNo(_tmpSourceNo);
            final String _tmpSourceCd;
            if (_cursor.isNull(_cursorIndexOfSourceCd)) {
              _tmpSourceCd = null;
            } else {
              _tmpSourceCd = _cursor.getString(_cursorIndexOfSourceCd);
            }
            _result.setSourceCd(_tmpSourceCd);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpWaybillx;
            if (_cursor.isNull(_cursorIndexOfWaybillx)) {
              _tmpWaybillx = null;
            } else {
              _tmpWaybillx = _cursor.getString(_cursorIndexOfWaybillx);
            }
            _result.setWaybillx(_tmpWaybillx);
            final String _tmpWaybilNo;
            if (_cursor.isNull(_cursorIndexOfWaybilNo)) {
              _tmpWaybilNo = null;
            } else {
              _tmpWaybilNo = _cursor.getString(_cursorIndexOfWaybilNo);
            }
            _result.setWaybilNo(_tmpWaybilNo);
            final String _tmpBatchNox;
            if (_cursor.isNull(_cursorIndexOfBatchNox)) {
              _tmpBatchNox = null;
            } else {
              _tmpBatchNox = _cursor.getString(_cursorIndexOfBatchNox);
            }
            _result.setBatchNox(_tmpBatchNox);
            final String _tmpPickedUp;
            if (_cursor.isNull(_cursorIndexOfPickedUp)) {
              _tmpPickedUp = null;
            } else {
              _tmpPickedUp = _cursor.getString(_cursorIndexOfPickedUp);
            }
            _result.setPickedUp(_tmpPickedUp);
            final String _tmpPaymPstd;
            if (_cursor.isNull(_cursorIndexOfPaymPstd)) {
              _tmpPaymPstd = null;
            } else {
              _tmpPaymPstd = _cursor.getString(_cursorIndexOfPaymPstd);
            }
            _result.setPaymPstd(_tmpPaymPstd);
            final String _tmpPaymType;
            if (_cursor.isNull(_cursorIndexOfPaymType)) {
              _tmpPaymType = null;
            } else {
              _tmpPaymType = _cursor.getString(_cursorIndexOfPaymType);
            }
            _result.setPaymType(_tmpPaymType);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
            final String _tmpTimeStmp;
            if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
              _tmpTimeStmp = null;
            } else {
              _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
            }
            _result.setTimeStmp(_tmpTimeStmp);
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
  public LiveData<List<EOrderMaster>> GetMasterOrderHistory(final String fcStatus) {
    final String _sql = "SELECT * FROM MarketPlace_Order_Master WHERE cTranStat =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fcStatus == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fcStatus);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master"}, false, new Callable<List<EOrderMaster>>() {
      @Override
      public List<EOrderMaster> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfExpected = CursorUtil.getColumnIndexOrThrow(_cursor, "dExpected");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfAppUsrID = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppUsrID");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfVATRatex = CursorUtil.getColumnIndexOrThrow(_cursor, "nVATRatex");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfAddDiscx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAddDiscx");
          final int _cursorIndexOfFreightx = CursorUtil.getColumnIndexOrThrow(_cursor, "nFreightx");
          final int _cursorIndexOfProcPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nProcPaym");
          final int _cursorIndexOfAmtPaidx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtPaidx");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfTermCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sTermCode");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfSourceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCd");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfWaybillx = CursorUtil.getColumnIndexOrThrow(_cursor, "dWaybillx");
          final int _cursorIndexOfWaybilNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sWaybilNo");
          final int _cursorIndexOfBatchNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sBatchNox");
          final int _cursorIndexOfPickedUp = CursorUtil.getColumnIndexOrThrow(_cursor, "dPickedUp");
          final int _cursorIndexOfPaymPstd = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymPstd");
          final int _cursorIndexOfPaymType = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymType");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EOrderMaster> _result = new ArrayList<EOrderMaster>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EOrderMaster _item;
            _item = new EOrderMaster();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpExpected;
            if (_cursor.isNull(_cursorIndexOfExpected)) {
              _tmpExpected = null;
            } else {
              _tmpExpected = _cursor.getString(_cursorIndexOfExpected);
            }
            _item.setExpected(_tmpExpected);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _item.setClientID(_tmpClientID);
            final String _tmpAppUsrID;
            if (_cursor.isNull(_cursorIndexOfAppUsrID)) {
              _tmpAppUsrID = null;
            } else {
              _tmpAppUsrID = _cursor.getString(_cursorIndexOfAppUsrID);
            }
            _item.setAppUsrID(_tmpAppUsrID);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _item.setTranTotl(_tmpTranTotl);
            final Double _tmpVATRatex;
            if (_cursor.isNull(_cursorIndexOfVATRatex)) {
              _tmpVATRatex = null;
            } else {
              _tmpVATRatex = _cursor.getDouble(_cursorIndexOfVATRatex);
            }
            _item.setVATRatex(_tmpVATRatex);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _item.setDiscount(_tmpDiscount);
            final Double _tmpAddDiscx;
            if (_cursor.isNull(_cursorIndexOfAddDiscx)) {
              _tmpAddDiscx = null;
            } else {
              _tmpAddDiscx = _cursor.getDouble(_cursorIndexOfAddDiscx);
            }
            _item.setAddDiscx(_tmpAddDiscx);
            final Double _tmpFreightx;
            if (_cursor.isNull(_cursorIndexOfFreightx)) {
              _tmpFreightx = null;
            } else {
              _tmpFreightx = _cursor.getDouble(_cursorIndexOfFreightx);
            }
            _item.setFreightx(_tmpFreightx);
            final Double _tmpProcPaym;
            if (_cursor.isNull(_cursorIndexOfProcPaym)) {
              _tmpProcPaym = null;
            } else {
              _tmpProcPaym = _cursor.getDouble(_cursorIndexOfProcPaym);
            }
            _item.setProcPaym(_tmpProcPaym);
            final Double _tmpAmtPaidx;
            if (_cursor.isNull(_cursorIndexOfAmtPaidx)) {
              _tmpAmtPaidx = null;
            } else {
              _tmpAmtPaidx = _cursor.getDouble(_cursorIndexOfAmtPaidx);
            }
            _item.setAmtPaidx(_tmpAmtPaidx);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _item.setDueDatex(_tmpDueDatex);
            final String _tmpTermCode;
            if (_cursor.isNull(_cursorIndexOfTermCode)) {
              _tmpTermCode = null;
            } else {
              _tmpTermCode = _cursor.getString(_cursorIndexOfTermCode);
            }
            _item.setTermCode(_tmpTermCode);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _item.setSourceNo(_tmpSourceNo);
            final String _tmpSourceCd;
            if (_cursor.isNull(_cursorIndexOfSourceCd)) {
              _tmpSourceCd = null;
            } else {
              _tmpSourceCd = _cursor.getString(_cursorIndexOfSourceCd);
            }
            _item.setSourceCd(_tmpSourceCd);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpWaybillx;
            if (_cursor.isNull(_cursorIndexOfWaybillx)) {
              _tmpWaybillx = null;
            } else {
              _tmpWaybillx = _cursor.getString(_cursorIndexOfWaybillx);
            }
            _item.setWaybillx(_tmpWaybillx);
            final String _tmpWaybilNo;
            if (_cursor.isNull(_cursorIndexOfWaybilNo)) {
              _tmpWaybilNo = null;
            } else {
              _tmpWaybilNo = _cursor.getString(_cursorIndexOfWaybilNo);
            }
            _item.setWaybilNo(_tmpWaybilNo);
            final String _tmpBatchNox;
            if (_cursor.isNull(_cursorIndexOfBatchNox)) {
              _tmpBatchNox = null;
            } else {
              _tmpBatchNox = _cursor.getString(_cursorIndexOfBatchNox);
            }
            _item.setBatchNox(_tmpBatchNox);
            final String _tmpPickedUp;
            if (_cursor.isNull(_cursorIndexOfPickedUp)) {
              _tmpPickedUp = null;
            } else {
              _tmpPickedUp = _cursor.getString(_cursorIndexOfPickedUp);
            }
            _item.setPickedUp(_tmpPickedUp);
            final String _tmpPaymPstd;
            if (_cursor.isNull(_cursorIndexOfPaymPstd)) {
              _tmpPaymPstd = null;
            } else {
              _tmpPaymPstd = _cursor.getString(_cursorIndexOfPaymPstd);
            }
            _item.setPaymPstd(_tmpPaymPstd);
            final String _tmpPaymType;
            if (_cursor.isNull(_cursorIndexOfPaymType)) {
              _tmpPaymType = null;
            } else {
              _tmpPaymType = _cursor.getString(_cursorIndexOfPaymType);
            }
            _item.setPaymType(_tmpPaymType);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<EOrderMaster>> GetMasterOrderHistory() {
    final String _sql = "SELECT * FROM MarketPlace_Order_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master"}, false, new Callable<List<EOrderMaster>>() {
      @Override
      public List<EOrderMaster> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfExpected = CursorUtil.getColumnIndexOrThrow(_cursor, "dExpected");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfAppUsrID = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppUsrID");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfTranTotl = CursorUtil.getColumnIndexOrThrow(_cursor, "nTranTotl");
          final int _cursorIndexOfVATRatex = CursorUtil.getColumnIndexOrThrow(_cursor, "nVATRatex");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfAddDiscx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAddDiscx");
          final int _cursorIndexOfFreightx = CursorUtil.getColumnIndexOrThrow(_cursor, "nFreightx");
          final int _cursorIndexOfProcPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nProcPaym");
          final int _cursorIndexOfAmtPaidx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmtPaidx");
          final int _cursorIndexOfDueDatex = CursorUtil.getColumnIndexOrThrow(_cursor, "dDueDatex");
          final int _cursorIndexOfTermCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sTermCode");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfSourceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCd");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfWaybillx = CursorUtil.getColumnIndexOrThrow(_cursor, "dWaybillx");
          final int _cursorIndexOfWaybilNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sWaybilNo");
          final int _cursorIndexOfBatchNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sBatchNox");
          final int _cursorIndexOfPickedUp = CursorUtil.getColumnIndexOrThrow(_cursor, "dPickedUp");
          final int _cursorIndexOfPaymPstd = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymPstd");
          final int _cursorIndexOfPaymType = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymType");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EOrderMaster> _result = new ArrayList<EOrderMaster>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EOrderMaster _item;
            _item = new EOrderMaster();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpExpected;
            if (_cursor.isNull(_cursorIndexOfExpected)) {
              _tmpExpected = null;
            } else {
              _tmpExpected = _cursor.getString(_cursorIndexOfExpected);
            }
            _item.setExpected(_tmpExpected);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _item.setClientID(_tmpClientID);
            final String _tmpAppUsrID;
            if (_cursor.isNull(_cursorIndexOfAppUsrID)) {
              _tmpAppUsrID = null;
            } else {
              _tmpAppUsrID = _cursor.getString(_cursorIndexOfAppUsrID);
            }
            _item.setAppUsrID(_tmpAppUsrID);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final Double _tmpTranTotl;
            if (_cursor.isNull(_cursorIndexOfTranTotl)) {
              _tmpTranTotl = null;
            } else {
              _tmpTranTotl = _cursor.getDouble(_cursorIndexOfTranTotl);
            }
            _item.setTranTotl(_tmpTranTotl);
            final Double _tmpVATRatex;
            if (_cursor.isNull(_cursorIndexOfVATRatex)) {
              _tmpVATRatex = null;
            } else {
              _tmpVATRatex = _cursor.getDouble(_cursorIndexOfVATRatex);
            }
            _item.setVATRatex(_tmpVATRatex);
            final Double _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getDouble(_cursorIndexOfDiscount);
            }
            _item.setDiscount(_tmpDiscount);
            final Double _tmpAddDiscx;
            if (_cursor.isNull(_cursorIndexOfAddDiscx)) {
              _tmpAddDiscx = null;
            } else {
              _tmpAddDiscx = _cursor.getDouble(_cursorIndexOfAddDiscx);
            }
            _item.setAddDiscx(_tmpAddDiscx);
            final Double _tmpFreightx;
            if (_cursor.isNull(_cursorIndexOfFreightx)) {
              _tmpFreightx = null;
            } else {
              _tmpFreightx = _cursor.getDouble(_cursorIndexOfFreightx);
            }
            _item.setFreightx(_tmpFreightx);
            final Double _tmpProcPaym;
            if (_cursor.isNull(_cursorIndexOfProcPaym)) {
              _tmpProcPaym = null;
            } else {
              _tmpProcPaym = _cursor.getDouble(_cursorIndexOfProcPaym);
            }
            _item.setProcPaym(_tmpProcPaym);
            final Double _tmpAmtPaidx;
            if (_cursor.isNull(_cursorIndexOfAmtPaidx)) {
              _tmpAmtPaidx = null;
            } else {
              _tmpAmtPaidx = _cursor.getDouble(_cursorIndexOfAmtPaidx);
            }
            _item.setAmtPaidx(_tmpAmtPaidx);
            final String _tmpDueDatex;
            if (_cursor.isNull(_cursorIndexOfDueDatex)) {
              _tmpDueDatex = null;
            } else {
              _tmpDueDatex = _cursor.getString(_cursorIndexOfDueDatex);
            }
            _item.setDueDatex(_tmpDueDatex);
            final String _tmpTermCode;
            if (_cursor.isNull(_cursorIndexOfTermCode)) {
              _tmpTermCode = null;
            } else {
              _tmpTermCode = _cursor.getString(_cursorIndexOfTermCode);
            }
            _item.setTermCode(_tmpTermCode);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _item.setSourceNo(_tmpSourceNo);
            final String _tmpSourceCd;
            if (_cursor.isNull(_cursorIndexOfSourceCd)) {
              _tmpSourceCd = null;
            } else {
              _tmpSourceCd = _cursor.getString(_cursorIndexOfSourceCd);
            }
            _item.setSourceCd(_tmpSourceCd);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpWaybillx;
            if (_cursor.isNull(_cursorIndexOfWaybillx)) {
              _tmpWaybillx = null;
            } else {
              _tmpWaybillx = _cursor.getString(_cursorIndexOfWaybillx);
            }
            _item.setWaybillx(_tmpWaybillx);
            final String _tmpWaybilNo;
            if (_cursor.isNull(_cursorIndexOfWaybilNo)) {
              _tmpWaybilNo = null;
            } else {
              _tmpWaybilNo = _cursor.getString(_cursorIndexOfWaybilNo);
            }
            _item.setWaybilNo(_tmpWaybilNo);
            final String _tmpBatchNox;
            if (_cursor.isNull(_cursorIndexOfBatchNox)) {
              _tmpBatchNox = null;
            } else {
              _tmpBatchNox = _cursor.getString(_cursorIndexOfBatchNox);
            }
            _item.setBatchNox(_tmpBatchNox);
            final String _tmpPickedUp;
            if (_cursor.isNull(_cursorIndexOfPickedUp)) {
              _tmpPickedUp = null;
            } else {
              _tmpPickedUp = _cursor.getString(_cursorIndexOfPickedUp);
            }
            _item.setPickedUp(_tmpPickedUp);
            final String _tmpPaymPstd;
            if (_cursor.isNull(_cursorIndexOfPaymPstd)) {
              _tmpPaymPstd = null;
            } else {
              _tmpPaymPstd = _cursor.getString(_cursorIndexOfPaymPstd);
            }
            _item.setPaymPstd(_tmpPaymPstd);
            final String _tmpPaymType;
            if (_cursor.isNull(_cursorIndexOfPaymType)) {
              _tmpPaymType = null;
            } else {
              _tmpPaymType = _cursor.getString(_cursorIndexOfPaymType);
            }
            _item.setPaymType(_tmpPaymType);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<String> GetOrderAmount(final String args) {
    final String _sql = "SELECT nTranTotl - nProcPaym FROM MarketPlace_Order_Master WHERE sTransNox=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master"}, false, new Callable<String>() {
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
  public LiveData<List<DOrder.OrderHistory>> GetOrderHistoryList() {
    final String _sql = "SELECT a.sTransNox, a.cTranStat, a.nTranTotl, a.nFreightx, a.nAmtPaidx, a.nDiscount, a.nProcPaym, a.sTermCode, a.cPaymPstd, b.nEntryNox, b.nQuantity, b.nUnitPrce, b.nDiscount, b.nDiscount, (SELECT sBriefDsc FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS sBriefDsc, (SELECT xBarCodex FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xBarCodex, (SELECT sImagesxx FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS sImagesxx, (SELECT xBrandNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xBrandNme, (SELECT xModelNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xModelNme, (SELECT xColorNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xColorNme, (SELECT xCategrNm FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xCategrNm FROM MarketPlace_Order_Master a LEFT JOIN MarketPlace_Order_Detail b ON a.sTransNox = b.sTransNox WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) GROUP BY a.sTransNox ORDER BY a.dTimeStmp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory","MarketPlace_Order_Master","MarketPlace_Order_Detail","Client_Profile_Info"}, false, new Callable<List<DOrder.OrderHistory>>() {
      @Override
      public List<DOrder.OrderHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfCTranStat = 1;
          final int _cursorIndexOfNTranTotl = 2;
          final int _cursorIndexOfNFreightx = 3;
          final int _cursorIndexOfNAmtPaidx = 4;
          final int _cursorIndexOfNDiscount = 5;
          final int _cursorIndexOfNProcPaym = 6;
          final int _cursorIndexOfSTermCode = 7;
          final int _cursorIndexOfCPaymPstd = 8;
          final int _cursorIndexOfNEntryNox = 9;
          final int _cursorIndexOfNQuantity = 10;
          final int _cursorIndexOfNUnitPrce = 11;
          final int _cursorIndexOfSBriefDsc = 14;
          final int _cursorIndexOfXBarCodex = 15;
          final int _cursorIndexOfSImagesxx = 16;
          final int _cursorIndexOfXBrandNme = 17;
          final int _cursorIndexOfXModelNme = 18;
          final int _cursorIndexOfXColorNme = 19;
          final int _cursorIndexOfXCategrNm = 20;
          final List<DOrder.OrderHistory> _result = new ArrayList<DOrder.OrderHistory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DOrder.OrderHistory _item;
            _item = new DOrder.OrderHistory();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            _item.nTranTotl = _cursor.getDouble(_cursorIndexOfNTranTotl);
            _item.nFreightx = _cursor.getDouble(_cursorIndexOfNFreightx);
            _item.nAmtPaidx = _cursor.getDouble(_cursorIndexOfNAmtPaidx);
            _item.nDiscount = _cursor.getDouble(_cursorIndexOfNDiscount);
            _item.nProcPaym = _cursor.getDouble(_cursorIndexOfNProcPaym);
            if (_cursor.isNull(_cursorIndexOfSTermCode)) {
              _item.sTermCode = null;
            } else {
              _item.sTermCode = _cursor.getString(_cursorIndexOfSTermCode);
            }
            if (_cursor.isNull(_cursorIndexOfCPaymPstd)) {
              _item.cPaymPstd = null;
            } else {
              _item.cPaymPstd = _cursor.getString(_cursorIndexOfCPaymPstd);
            }
            _item.nEntryNox = _cursor.getInt(_cursorIndexOfNEntryNox);
            _item.nQuantity = _cursor.getInt(_cursorIndexOfNQuantity);
            _item.nUnitPrce = _cursor.getDouble(_cursorIndexOfNUnitPrce);
            if (_cursor.isNull(_cursorIndexOfSBriefDsc)) {
              _item.sBriefDsc = null;
            } else {
              _item.sBriefDsc = _cursor.getString(_cursorIndexOfSBriefDsc);
            }
            if (_cursor.isNull(_cursorIndexOfXBarCodex)) {
              _item.xBarCodex = null;
            } else {
              _item.xBarCodex = _cursor.getString(_cursorIndexOfXBarCodex);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfXBrandNme)) {
              _item.xBrandNme = null;
            } else {
              _item.xBrandNme = _cursor.getString(_cursorIndexOfXBrandNme);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXColorNme)) {
              _item.xColorNme = null;
            } else {
              _item.xColorNme = _cursor.getString(_cursorIndexOfXColorNme);
            }
            if (_cursor.isNull(_cursorIndexOfXCategrNm)) {
              _item.xCategrNm = null;
            } else {
              _item.xCategrNm = _cursor.getString(_cursorIndexOfXCategrNm);
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
  public LiveData<Integer> GetToPayOrdersCount() {
    final String _sql = "SELECT COUNT(a.sTransNox) FROM MarketPlace_Order_Master a WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) AND a.sTermCode == '' AND a.cTranStat == '0' OR a.sTermCode = 'C0W2011' AND a.cTranStat == '0' AND a.cPaymPstd <> '0' AND a.nTranTotl > a.nProcPaym";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","Client_Profile_Info"}, false, new Callable<Integer>() {
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
  public LiveData<Integer> GetProcessingOrdersCount() {
    final String _sql = "SELECT COUNT(*) FROM MarketPlace_Order_Master WHERE cTranStat = '0' AND sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info)AND cTranStat= '0' AND cPaymType == '1'OR cTranStat= '0' AND cPaymType == '2' AND cPaymPstd == '1' OR cTranStat= '0' AND cPaymType == '2' AND cPaymPstd == '0' AND nTranTotl <= nProcPaym";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","Client_Profile_Info"}, false, new Callable<Integer>() {
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
  public LiveData<Integer> GetToShipOrdersCount() {
    final String _sql = "SELECT COUNT(*) FROM MarketPlace_Order_Master WHERE cTranStat = '1' AND sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","Client_Profile_Info"}, false, new Callable<Integer>() {
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
  public LiveData<Integer> GetDeliveredOrdersCount() {
    final String _sql = "SELECT COUNT(*) FROM MarketPlace_Order_Master WHERE cTranStat = '4' AND sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","Client_Profile_Info"}, false, new Callable<Integer>() {
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
  public LiveData<Integer> GetCancelledOrdersCount() {
    final String _sql = "SELECT COUNT(*) FROM MarketPlace_Order_Master WHERE cTranStat = '3' AND sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","Client_Profile_Info"}, false, new Callable<Integer>() {
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
  public LiveData<List<DOrder.OrderHistory>> GetProcessingOrderList() {
    final String _sql = "SELECT a.sTransNox, a.cTranStat, a.nTranTotl, a.nFreightx, a.nAmtPaidx, a.nDiscount, a.nProcPaym, a.sTermCode, a.cPaymPstd, b.nEntryNox, b.nQuantity, b.nUnitPrce, b.nDiscount, (SELECT sBriefDsc FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS sBriefDsc, (SELECT xBarCodex FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xBarCodex, (SELECT sImagesxx FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS sImagesxx, (SELECT xBrandNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xBrandNme, (SELECT xModelNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xModelNme, (SELECT xColorNme FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xColorNme, (SELECT xCategrNm FROM Product_Inventory WHERE sStockIDx = b.sStockIDx) AS xCategrNm FROM MarketPlace_Order_Master a LEFT JOIN MarketPlace_Order_Detail b ON a.sTransNox = b.sTransNox WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) AND a.cTranStat == '0' AND a.cPaymType == '1' OR a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) AND a.cTranStat == '0' AND a.cPaymType == '2' AND a.cPaymPstd == '1' AND a.nTranTotl <= a.nProcPaym OR a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) AND a.cTranStat == '0' AND a.cPaymType == '2' AND a.cPaymPstd == '0' GROUP BY a.sTransNox ORDER BY a.dTimeStmp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory","MarketPlace_Order_Master","MarketPlace_Order_Detail","Client_Profile_Info"}, false, new Callable<List<DOrder.OrderHistory>>() {
      @Override
      public List<DOrder.OrderHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfCTranStat = 1;
          final int _cursorIndexOfNTranTotl = 2;
          final int _cursorIndexOfNFreightx = 3;
          final int _cursorIndexOfNAmtPaidx = 4;
          final int _cursorIndexOfNDiscount = 5;
          final int _cursorIndexOfNProcPaym = 6;
          final int _cursorIndexOfSTermCode = 7;
          final int _cursorIndexOfCPaymPstd = 8;
          final int _cursorIndexOfNEntryNox = 9;
          final int _cursorIndexOfNQuantity = 10;
          final int _cursorIndexOfNUnitPrce = 11;
          final int _cursorIndexOfSBriefDsc = 13;
          final int _cursorIndexOfXBarCodex = 14;
          final int _cursorIndexOfSImagesxx = 15;
          final int _cursorIndexOfXBrandNme = 16;
          final int _cursorIndexOfXModelNme = 17;
          final int _cursorIndexOfXColorNme = 18;
          final int _cursorIndexOfXCategrNm = 19;
          final List<DOrder.OrderHistory> _result = new ArrayList<DOrder.OrderHistory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DOrder.OrderHistory _item;
            _item = new DOrder.OrderHistory();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            _item.nTranTotl = _cursor.getDouble(_cursorIndexOfNTranTotl);
            _item.nFreightx = _cursor.getDouble(_cursorIndexOfNFreightx);
            _item.nAmtPaidx = _cursor.getDouble(_cursorIndexOfNAmtPaidx);
            _item.nDiscount = _cursor.getDouble(_cursorIndexOfNDiscount);
            _item.nProcPaym = _cursor.getDouble(_cursorIndexOfNProcPaym);
            if (_cursor.isNull(_cursorIndexOfSTermCode)) {
              _item.sTermCode = null;
            } else {
              _item.sTermCode = _cursor.getString(_cursorIndexOfSTermCode);
            }
            if (_cursor.isNull(_cursorIndexOfCPaymPstd)) {
              _item.cPaymPstd = null;
            } else {
              _item.cPaymPstd = _cursor.getString(_cursorIndexOfCPaymPstd);
            }
            _item.nEntryNox = _cursor.getInt(_cursorIndexOfNEntryNox);
            _item.nQuantity = _cursor.getInt(_cursorIndexOfNQuantity);
            _item.nUnitPrce = _cursor.getDouble(_cursorIndexOfNUnitPrce);
            if (_cursor.isNull(_cursorIndexOfSBriefDsc)) {
              _item.sBriefDsc = null;
            } else {
              _item.sBriefDsc = _cursor.getString(_cursorIndexOfSBriefDsc);
            }
            if (_cursor.isNull(_cursorIndexOfXBarCodex)) {
              _item.xBarCodex = null;
            } else {
              _item.xBarCodex = _cursor.getString(_cursorIndexOfXBarCodex);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfXBrandNme)) {
              _item.xBrandNme = null;
            } else {
              _item.xBrandNme = _cursor.getString(_cursorIndexOfXBrandNme);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXColorNme)) {
              _item.xColorNme = null;
            } else {
              _item.xColorNme = _cursor.getString(_cursorIndexOfXColorNme);
            }
            if (_cursor.isNull(_cursorIndexOfXCategrNm)) {
              _item.xCategrNm = null;
            } else {
              _item.xCategrNm = _cursor.getString(_cursorIndexOfXCategrNm);
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
  public LiveData<List<DOrder.OrderHistory>> GetToPayOrderList() {
    final String _sql = "SELECT a.sTransNox, a.cTranStat, a.nTranTotl, a.nFreightx, a.nAmtPaidx, a.nDiscount, a.nProcPaym, a.sTermCode, a.cPaymPstd, b.nEntryNox, b.nQuantity, b.nUnitPrce, b.nDiscount, c.sBriefDsc, c.xBarCodex, c.sImagesxx, c.xBrandNme, c.xModelNme, c.xColorNme, c.xCategrNm FROM MarketPlace_Order_Master a LEFT JOIN MarketPlace_Order_Detail b ON a.sTransNox = b.sTransNox LEFT JOIN Product_Inventory c ON b.sStockIDx = c.sStockIDx WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) AND a.sTermCode == '' AND a.cTranStat == '0' OR a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) AND a.cPaymType = '2' AND a.cPaymPstd == '1' AND a.cTranStat == '0' AND a.nTranTotl > a.nProcPaym GROUP BY a.sTransNox ORDER BY a.dTimeStmp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","MarketPlace_Order_Detail","Product_Inventory","Client_Profile_Info"}, false, new Callable<List<DOrder.OrderHistory>>() {
      @Override
      public List<DOrder.OrderHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfCTranStat = 1;
          final int _cursorIndexOfNTranTotl = 2;
          final int _cursorIndexOfNFreightx = 3;
          final int _cursorIndexOfNAmtPaidx = 4;
          final int _cursorIndexOfNDiscount = 5;
          final int _cursorIndexOfNProcPaym = 6;
          final int _cursorIndexOfSTermCode = 7;
          final int _cursorIndexOfCPaymPstd = 8;
          final int _cursorIndexOfNEntryNox = 9;
          final int _cursorIndexOfNQuantity = 10;
          final int _cursorIndexOfNUnitPrce = 11;
          final int _cursorIndexOfSBriefDsc = 13;
          final int _cursorIndexOfXBarCodex = 14;
          final int _cursorIndexOfSImagesxx = 15;
          final int _cursorIndexOfXBrandNme = 16;
          final int _cursorIndexOfXModelNme = 17;
          final int _cursorIndexOfXColorNme = 18;
          final int _cursorIndexOfXCategrNm = 19;
          final List<DOrder.OrderHistory> _result = new ArrayList<DOrder.OrderHistory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DOrder.OrderHistory _item;
            _item = new DOrder.OrderHistory();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            _item.nTranTotl = _cursor.getDouble(_cursorIndexOfNTranTotl);
            _item.nFreightx = _cursor.getDouble(_cursorIndexOfNFreightx);
            _item.nAmtPaidx = _cursor.getDouble(_cursorIndexOfNAmtPaidx);
            _item.nDiscount = _cursor.getDouble(_cursorIndexOfNDiscount);
            _item.nProcPaym = _cursor.getDouble(_cursorIndexOfNProcPaym);
            if (_cursor.isNull(_cursorIndexOfSTermCode)) {
              _item.sTermCode = null;
            } else {
              _item.sTermCode = _cursor.getString(_cursorIndexOfSTermCode);
            }
            if (_cursor.isNull(_cursorIndexOfCPaymPstd)) {
              _item.cPaymPstd = null;
            } else {
              _item.cPaymPstd = _cursor.getString(_cursorIndexOfCPaymPstd);
            }
            _item.nEntryNox = _cursor.getInt(_cursorIndexOfNEntryNox);
            _item.nQuantity = _cursor.getInt(_cursorIndexOfNQuantity);
            _item.nUnitPrce = _cursor.getDouble(_cursorIndexOfNUnitPrce);
            if (_cursor.isNull(_cursorIndexOfSBriefDsc)) {
              _item.sBriefDsc = null;
            } else {
              _item.sBriefDsc = _cursor.getString(_cursorIndexOfSBriefDsc);
            }
            if (_cursor.isNull(_cursorIndexOfXBarCodex)) {
              _item.xBarCodex = null;
            } else {
              _item.xBarCodex = _cursor.getString(_cursorIndexOfXBarCodex);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfXBrandNme)) {
              _item.xBrandNme = null;
            } else {
              _item.xBrandNme = _cursor.getString(_cursorIndexOfXBrandNme);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXColorNme)) {
              _item.xColorNme = null;
            } else {
              _item.xColorNme = _cursor.getString(_cursorIndexOfXColorNme);
            }
            if (_cursor.isNull(_cursorIndexOfXCategrNm)) {
              _item.xCategrNm = null;
            } else {
              _item.xCategrNm = _cursor.getString(_cursorIndexOfXCategrNm);
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
  public LiveData<List<DOrder.OrderHistory>> GetToShipOrdersList() {
    final String _sql = "SELECT a.sTransNox, a.cTranStat, a.nTranTotl, a.nFreightx, a.nAmtPaidx, a.nDiscount, a.nProcPaym, a.sTermCode, a.cPaymPstd, b.nEntryNox, b.nQuantity, b.nUnitPrce, b.nDiscount, c.sBriefDsc, c.xBarCodex, c.sImagesxx, c.xBrandNme, c.xModelNme, c.xColorNme, c.xCategrNm FROM MarketPlace_Order_Master a LEFT JOIN MarketPlace_Order_Detail b ON a.sTransNox = b.sTransNox LEFT JOIN Product_Inventory c ON b.sStockIDx = c.sStockIDx WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info)AND a.cTranStat == '1'GROUP BY a.sTransNox ORDER BY a.dTimeStmp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","MarketPlace_Order_Detail","Product_Inventory","Client_Profile_Info"}, false, new Callable<List<DOrder.OrderHistory>>() {
      @Override
      public List<DOrder.OrderHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfCTranStat = 1;
          final int _cursorIndexOfNTranTotl = 2;
          final int _cursorIndexOfNFreightx = 3;
          final int _cursorIndexOfNAmtPaidx = 4;
          final int _cursorIndexOfNDiscount = 5;
          final int _cursorIndexOfNProcPaym = 6;
          final int _cursorIndexOfSTermCode = 7;
          final int _cursorIndexOfCPaymPstd = 8;
          final int _cursorIndexOfNEntryNox = 9;
          final int _cursorIndexOfNQuantity = 10;
          final int _cursorIndexOfNUnitPrce = 11;
          final int _cursorIndexOfSBriefDsc = 13;
          final int _cursorIndexOfXBarCodex = 14;
          final int _cursorIndexOfSImagesxx = 15;
          final int _cursorIndexOfXBrandNme = 16;
          final int _cursorIndexOfXModelNme = 17;
          final int _cursorIndexOfXColorNme = 18;
          final int _cursorIndexOfXCategrNm = 19;
          final List<DOrder.OrderHistory> _result = new ArrayList<DOrder.OrderHistory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DOrder.OrderHistory _item;
            _item = new DOrder.OrderHistory();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            _item.nTranTotl = _cursor.getDouble(_cursorIndexOfNTranTotl);
            _item.nFreightx = _cursor.getDouble(_cursorIndexOfNFreightx);
            _item.nAmtPaidx = _cursor.getDouble(_cursorIndexOfNAmtPaidx);
            _item.nDiscount = _cursor.getDouble(_cursorIndexOfNDiscount);
            _item.nProcPaym = _cursor.getDouble(_cursorIndexOfNProcPaym);
            if (_cursor.isNull(_cursorIndexOfSTermCode)) {
              _item.sTermCode = null;
            } else {
              _item.sTermCode = _cursor.getString(_cursorIndexOfSTermCode);
            }
            if (_cursor.isNull(_cursorIndexOfCPaymPstd)) {
              _item.cPaymPstd = null;
            } else {
              _item.cPaymPstd = _cursor.getString(_cursorIndexOfCPaymPstd);
            }
            _item.nEntryNox = _cursor.getInt(_cursorIndexOfNEntryNox);
            _item.nQuantity = _cursor.getInt(_cursorIndexOfNQuantity);
            _item.nUnitPrce = _cursor.getDouble(_cursorIndexOfNUnitPrce);
            if (_cursor.isNull(_cursorIndexOfSBriefDsc)) {
              _item.sBriefDsc = null;
            } else {
              _item.sBriefDsc = _cursor.getString(_cursorIndexOfSBriefDsc);
            }
            if (_cursor.isNull(_cursorIndexOfXBarCodex)) {
              _item.xBarCodex = null;
            } else {
              _item.xBarCodex = _cursor.getString(_cursorIndexOfXBarCodex);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfXBrandNme)) {
              _item.xBrandNme = null;
            } else {
              _item.xBrandNme = _cursor.getString(_cursorIndexOfXBrandNme);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXColorNme)) {
              _item.xColorNme = null;
            } else {
              _item.xColorNme = _cursor.getString(_cursorIndexOfXColorNme);
            }
            if (_cursor.isNull(_cursorIndexOfXCategrNm)) {
              _item.xCategrNm = null;
            } else {
              _item.xCategrNm = _cursor.getString(_cursorIndexOfXCategrNm);
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
  public LiveData<List<DOrder.OrderHistory>> GetShippedOrdersList() {
    final String _sql = "SELECT a.sTransNox, a.cTranStat, a.nTranTotl, a.nFreightx, a.nAmtPaidx, a.nDiscount, a.nProcPaym, a.sTermCode, a.cPaymPstd, b.nEntryNox, b.nQuantity, b.nUnitPrce, b.nDiscount, c.sBriefDsc, c.xBarCodex, c.sImagesxx, c.xBrandNme, c.xModelNme, c.xColorNme, c.xCategrNm FROM MarketPlace_Order_Master a LEFT JOIN MarketPlace_Order_Detail b ON a.sTransNox = b.sTransNox LEFT JOIN Product_Inventory c ON b.sStockIDx = c.sStockIDx WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info)AND a.dWaybillx <> '' AND a.sWaybilNo <> ''GROUP BY a.sTransNox ORDER BY a.dTimeStmp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","MarketPlace_Order_Detail","Product_Inventory","Client_Profile_Info"}, false, new Callable<List<DOrder.OrderHistory>>() {
      @Override
      public List<DOrder.OrderHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfCTranStat = 1;
          final int _cursorIndexOfNTranTotl = 2;
          final int _cursorIndexOfNFreightx = 3;
          final int _cursorIndexOfNAmtPaidx = 4;
          final int _cursorIndexOfNDiscount = 5;
          final int _cursorIndexOfNProcPaym = 6;
          final int _cursorIndexOfSTermCode = 7;
          final int _cursorIndexOfCPaymPstd = 8;
          final int _cursorIndexOfNEntryNox = 9;
          final int _cursorIndexOfNQuantity = 10;
          final int _cursorIndexOfNUnitPrce = 11;
          final int _cursorIndexOfSBriefDsc = 13;
          final int _cursorIndexOfXBarCodex = 14;
          final int _cursorIndexOfSImagesxx = 15;
          final int _cursorIndexOfXBrandNme = 16;
          final int _cursorIndexOfXModelNme = 17;
          final int _cursorIndexOfXColorNme = 18;
          final int _cursorIndexOfXCategrNm = 19;
          final List<DOrder.OrderHistory> _result = new ArrayList<DOrder.OrderHistory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DOrder.OrderHistory _item;
            _item = new DOrder.OrderHistory();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            _item.nTranTotl = _cursor.getDouble(_cursorIndexOfNTranTotl);
            _item.nFreightx = _cursor.getDouble(_cursorIndexOfNFreightx);
            _item.nAmtPaidx = _cursor.getDouble(_cursorIndexOfNAmtPaidx);
            _item.nDiscount = _cursor.getDouble(_cursorIndexOfNDiscount);
            _item.nProcPaym = _cursor.getDouble(_cursorIndexOfNProcPaym);
            if (_cursor.isNull(_cursorIndexOfSTermCode)) {
              _item.sTermCode = null;
            } else {
              _item.sTermCode = _cursor.getString(_cursorIndexOfSTermCode);
            }
            if (_cursor.isNull(_cursorIndexOfCPaymPstd)) {
              _item.cPaymPstd = null;
            } else {
              _item.cPaymPstd = _cursor.getString(_cursorIndexOfCPaymPstd);
            }
            _item.nEntryNox = _cursor.getInt(_cursorIndexOfNEntryNox);
            _item.nQuantity = _cursor.getInt(_cursorIndexOfNQuantity);
            _item.nUnitPrce = _cursor.getDouble(_cursorIndexOfNUnitPrce);
            if (_cursor.isNull(_cursorIndexOfSBriefDsc)) {
              _item.sBriefDsc = null;
            } else {
              _item.sBriefDsc = _cursor.getString(_cursorIndexOfSBriefDsc);
            }
            if (_cursor.isNull(_cursorIndexOfXBarCodex)) {
              _item.xBarCodex = null;
            } else {
              _item.xBarCodex = _cursor.getString(_cursorIndexOfXBarCodex);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfXBrandNme)) {
              _item.xBrandNme = null;
            } else {
              _item.xBrandNme = _cursor.getString(_cursorIndexOfXBrandNme);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXColorNme)) {
              _item.xColorNme = null;
            } else {
              _item.xColorNme = _cursor.getString(_cursorIndexOfXColorNme);
            }
            if (_cursor.isNull(_cursorIndexOfXCategrNm)) {
              _item.xCategrNm = null;
            } else {
              _item.xCategrNm = _cursor.getString(_cursorIndexOfXCategrNm);
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
  public LiveData<List<DOrder.OrderHistory>> GetCancelledOrdersList() {
    final String _sql = "SELECT a.sTransNox, a.cTranStat, a.nTranTotl, a.nFreightx, a.nAmtPaidx, a.nDiscount, a.nProcPaym, a.sTermCode, a.cPaymPstd, b.nEntryNox, b.nQuantity, b.nUnitPrce, b.nDiscount, c.sBriefDsc, c.xBarCodex, c.sImagesxx, c.xBrandNme, c.xModelNme, c.xColorNme, c.xCategrNm FROM MarketPlace_Order_Master a LEFT JOIN MarketPlace_Order_Detail b ON a.sTransNox = b.sTransNox LEFT JOIN Product_Inventory c ON b.sStockIDx = c.sStockIDx WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info)AND a.cTranStat == '3' GROUP BY a.sTransNox ORDER BY a.dTimeStmp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","MarketPlace_Order_Detail","Product_Inventory","Client_Profile_Info"}, false, new Callable<List<DOrder.OrderHistory>>() {
      @Override
      public List<DOrder.OrderHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfCTranStat = 1;
          final int _cursorIndexOfNTranTotl = 2;
          final int _cursorIndexOfNFreightx = 3;
          final int _cursorIndexOfNAmtPaidx = 4;
          final int _cursorIndexOfNDiscount = 5;
          final int _cursorIndexOfNProcPaym = 6;
          final int _cursorIndexOfSTermCode = 7;
          final int _cursorIndexOfCPaymPstd = 8;
          final int _cursorIndexOfNEntryNox = 9;
          final int _cursorIndexOfNQuantity = 10;
          final int _cursorIndexOfNUnitPrce = 11;
          final int _cursorIndexOfSBriefDsc = 13;
          final int _cursorIndexOfXBarCodex = 14;
          final int _cursorIndexOfSImagesxx = 15;
          final int _cursorIndexOfXBrandNme = 16;
          final int _cursorIndexOfXModelNme = 17;
          final int _cursorIndexOfXColorNme = 18;
          final int _cursorIndexOfXCategrNm = 19;
          final List<DOrder.OrderHistory> _result = new ArrayList<DOrder.OrderHistory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DOrder.OrderHistory _item;
            _item = new DOrder.OrderHistory();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            _item.nTranTotl = _cursor.getDouble(_cursorIndexOfNTranTotl);
            _item.nFreightx = _cursor.getDouble(_cursorIndexOfNFreightx);
            _item.nAmtPaidx = _cursor.getDouble(_cursorIndexOfNAmtPaidx);
            _item.nDiscount = _cursor.getDouble(_cursorIndexOfNDiscount);
            _item.nProcPaym = _cursor.getDouble(_cursorIndexOfNProcPaym);
            if (_cursor.isNull(_cursorIndexOfSTermCode)) {
              _item.sTermCode = null;
            } else {
              _item.sTermCode = _cursor.getString(_cursorIndexOfSTermCode);
            }
            if (_cursor.isNull(_cursorIndexOfCPaymPstd)) {
              _item.cPaymPstd = null;
            } else {
              _item.cPaymPstd = _cursor.getString(_cursorIndexOfCPaymPstd);
            }
            _item.nEntryNox = _cursor.getInt(_cursorIndexOfNEntryNox);
            _item.nQuantity = _cursor.getInt(_cursorIndexOfNQuantity);
            _item.nUnitPrce = _cursor.getDouble(_cursorIndexOfNUnitPrce);
            if (_cursor.isNull(_cursorIndexOfSBriefDsc)) {
              _item.sBriefDsc = null;
            } else {
              _item.sBriefDsc = _cursor.getString(_cursorIndexOfSBriefDsc);
            }
            if (_cursor.isNull(_cursorIndexOfXBarCodex)) {
              _item.xBarCodex = null;
            } else {
              _item.xBarCodex = _cursor.getString(_cursorIndexOfXBarCodex);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfXBrandNme)) {
              _item.xBrandNme = null;
            } else {
              _item.xBrandNme = _cursor.getString(_cursorIndexOfXBrandNme);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXColorNme)) {
              _item.xColorNme = null;
            } else {
              _item.xColorNme = _cursor.getString(_cursorIndexOfXColorNme);
            }
            if (_cursor.isNull(_cursorIndexOfXCategrNm)) {
              _item.xCategrNm = null;
            } else {
              _item.xCategrNm = _cursor.getString(_cursorIndexOfXCategrNm);
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
  public LiveData<List<DOrder.OrderHistory>> GetDeliveredOrdersList() {
    final String _sql = "SELECT a.sTransNox, a.cTranStat, a.nTranTotl, a.nFreightx, a.nAmtPaidx, a.nDiscount, a.nProcPaym, a.sTermCode, a.cPaymPstd, b.nEntryNox, b.nQuantity, b.nUnitPrce, b.nDiscount, c.sBriefDsc, c.xBarCodex, c.sImagesxx, c.xBrandNme, c.xModelNme, c.xColorNme, c.xCategrNm FROM MarketPlace_Order_Master a LEFT JOIN MarketPlace_Order_Detail b ON a.sTransNox = b.sTransNox LEFT JOIN Product_Inventory c ON b.sStockIDx = c.sStockIDx WHERE a.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info)AND a.cTranStat == '4'GROUP BY a.sTransNox ORDER BY a.dTimeStmp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","MarketPlace_Order_Detail","Product_Inventory","Client_Profile_Info"}, false, new Callable<List<DOrder.OrderHistory>>() {
      @Override
      public List<DOrder.OrderHistory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfCTranStat = 1;
          final int _cursorIndexOfNTranTotl = 2;
          final int _cursorIndexOfNFreightx = 3;
          final int _cursorIndexOfNAmtPaidx = 4;
          final int _cursorIndexOfNDiscount = 5;
          final int _cursorIndexOfNProcPaym = 6;
          final int _cursorIndexOfSTermCode = 7;
          final int _cursorIndexOfCPaymPstd = 8;
          final int _cursorIndexOfNEntryNox = 9;
          final int _cursorIndexOfNQuantity = 10;
          final int _cursorIndexOfNUnitPrce = 11;
          final int _cursorIndexOfSBriefDsc = 13;
          final int _cursorIndexOfXBarCodex = 14;
          final int _cursorIndexOfSImagesxx = 15;
          final int _cursorIndexOfXBrandNme = 16;
          final int _cursorIndexOfXModelNme = 17;
          final int _cursorIndexOfXColorNme = 18;
          final int _cursorIndexOfXCategrNm = 19;
          final List<DOrder.OrderHistory> _result = new ArrayList<DOrder.OrderHistory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DOrder.OrderHistory _item;
            _item = new DOrder.OrderHistory();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            _item.nTranTotl = _cursor.getDouble(_cursorIndexOfNTranTotl);
            _item.nFreightx = _cursor.getDouble(_cursorIndexOfNFreightx);
            _item.nAmtPaidx = _cursor.getDouble(_cursorIndexOfNAmtPaidx);
            _item.nDiscount = _cursor.getDouble(_cursorIndexOfNDiscount);
            _item.nProcPaym = _cursor.getDouble(_cursorIndexOfNProcPaym);
            if (_cursor.isNull(_cursorIndexOfSTermCode)) {
              _item.sTermCode = null;
            } else {
              _item.sTermCode = _cursor.getString(_cursorIndexOfSTermCode);
            }
            if (_cursor.isNull(_cursorIndexOfCPaymPstd)) {
              _item.cPaymPstd = null;
            } else {
              _item.cPaymPstd = _cursor.getString(_cursorIndexOfCPaymPstd);
            }
            _item.nEntryNox = _cursor.getInt(_cursorIndexOfNEntryNox);
            _item.nQuantity = _cursor.getInt(_cursorIndexOfNQuantity);
            _item.nUnitPrce = _cursor.getDouble(_cursorIndexOfNUnitPrce);
            if (_cursor.isNull(_cursorIndexOfSBriefDsc)) {
              _item.sBriefDsc = null;
            } else {
              _item.sBriefDsc = _cursor.getString(_cursorIndexOfSBriefDsc);
            }
            if (_cursor.isNull(_cursorIndexOfXBarCodex)) {
              _item.xBarCodex = null;
            } else {
              _item.xBarCodex = _cursor.getString(_cursorIndexOfXBarCodex);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfXBrandNme)) {
              _item.xBrandNme = null;
            } else {
              _item.xBrandNme = _cursor.getString(_cursorIndexOfXBrandNme);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXColorNme)) {
              _item.xColorNme = null;
            } else {
              _item.xColorNme = _cursor.getString(_cursorIndexOfXColorNme);
            }
            if (_cursor.isNull(_cursorIndexOfXCategrNm)) {
              _item.xCategrNm = null;
            } else {
              _item.xCategrNm = _cursor.getString(_cursorIndexOfXCategrNm);
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
  public LiveData<DOrder.DetailedOrderHistory> GetDetailOrderHistory(final String fsVal) {
    final String _sql = "SELECT a.sTransNox, a.dTransact, IFNULL(a.dExpected, ''), dExpected, a.sReferNox, a.nTranTotl, a.nFreightx, a.nDiscount, a.cPaymPstd, a.nProcPaym, a.nAmtPaidx, a.sWaybilNo, a.dWaybillx, a.dPickedUp, a.sBatchNox, a.sTermCode, a.cTranStat, b.sFrstName || ' ' || b.sMiddName || ' ' || b.sLastName || ' ' || IFNULL(b.sSuffixNm, '') AS sUserName, IFNULL(b.sHouseNo2, '') || ' ' || IFNULL(b.sAddress2, '') || ' ' || c.sBrgyName || ' ' ||  d.sTownName || ' ' || e.sProvName AS sAddressx, b.sMobileNo FROM MarketPlace_Order_Master a  LEFT JOIN Client_Profile_Info b  ON a.sAppUsrID = b.sUserIDxx  LEFT JOIN Barangay_Info c  ON b.sBrgyIDx2 = c.sBrgyIDxx LEFT JOIN Town_Info d ON c.sTownIDxx = d.sTownIDxx LEFT JOIN Province_Info e ON d.sProvIDxx = e.sProvIDxx  WHERE a.sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Master","Client_Profile_Info","Barangay_Info","Town_Info","Province_Info"}, false, new Callable<DOrder.DetailedOrderHistory>() {
      @Override
      public DOrder.DetailedOrderHistory call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfDTransact = 1;
          final int _cursorIndexOfDExpected = 3;
          final int _cursorIndexOfSReferNox = 4;
          final int _cursorIndexOfNTranTotl = 5;
          final int _cursorIndexOfNFreightx = 6;
          final int _cursorIndexOfNDiscount = 7;
          final int _cursorIndexOfCPaymPstd = 8;
          final int _cursorIndexOfNProcPaym = 9;
          final int _cursorIndexOfNAmtPaidx = 10;
          final int _cursorIndexOfSWaybilNo = 11;
          final int _cursorIndexOfDWaybillx = 12;
          final int _cursorIndexOfDPickedUp = 13;
          final int _cursorIndexOfSBatchNox = 14;
          final int _cursorIndexOfSTermCode = 15;
          final int _cursorIndexOfCTranStat = 16;
          final int _cursorIndexOfSUserName = 17;
          final int _cursorIndexOfSAddressx = 18;
          final int _cursorIndexOfSMobileNo = 19;
          final DOrder.DetailedOrderHistory _result;
          if(_cursor.moveToFirst()) {
            _result = new DOrder.DetailedOrderHistory();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _result.sTransNox = null;
            } else {
              _result.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _result.dTransact = null;
            } else {
              _result.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfDExpected)) {
              _result.dExpected = null;
            } else {
              _result.dExpected = _cursor.getString(_cursorIndexOfDExpected);
            }
            if (_cursor.isNull(_cursorIndexOfSReferNox)) {
              _result.sReferNox = null;
            } else {
              _result.sReferNox = _cursor.getString(_cursorIndexOfSReferNox);
            }
            _result.nTranTotl = _cursor.getDouble(_cursorIndexOfNTranTotl);
            _result.nFreightx = _cursor.getDouble(_cursorIndexOfNFreightx);
            _result.nDiscount = _cursor.getDouble(_cursorIndexOfNDiscount);
            if (_cursor.isNull(_cursorIndexOfCPaymPstd)) {
              _result.cPaymPstd = null;
            } else {
              _result.cPaymPstd = _cursor.getString(_cursorIndexOfCPaymPstd);
            }
            _result.nProcPaym = _cursor.getDouble(_cursorIndexOfNProcPaym);
            _result.nAmtPaidx = _cursor.getDouble(_cursorIndexOfNAmtPaidx);
            if (_cursor.isNull(_cursorIndexOfSWaybilNo)) {
              _result.sWaybilNo = null;
            } else {
              _result.sWaybilNo = _cursor.getString(_cursorIndexOfSWaybilNo);
            }
            if (_cursor.isNull(_cursorIndexOfDWaybillx)) {
              _result.dWaybillx = null;
            } else {
              _result.dWaybillx = _cursor.getString(_cursorIndexOfDWaybillx);
            }
            if (_cursor.isNull(_cursorIndexOfDPickedUp)) {
              _result.dPickedUp = null;
            } else {
              _result.dPickedUp = _cursor.getString(_cursorIndexOfDPickedUp);
            }
            if (_cursor.isNull(_cursorIndexOfSBatchNox)) {
              _result.sBatchNox = null;
            } else {
              _result.sBatchNox = _cursor.getString(_cursorIndexOfSBatchNox);
            }
            if (_cursor.isNull(_cursorIndexOfSTermCode)) {
              _result.sTermCode = null;
            } else {
              _result.sTermCode = _cursor.getString(_cursorIndexOfSTermCode);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _result.cTranStat = null;
            } else {
              _result.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            if (_cursor.isNull(_cursorIndexOfSUserName)) {
              _result.sUserName = null;
            } else {
              _result.sUserName = _cursor.getString(_cursorIndexOfSUserName);
            }
            if (_cursor.isNull(_cursorIndexOfSAddressx)) {
              _result.sAddressx = null;
            } else {
              _result.sAddressx = _cursor.getString(_cursorIndexOfSAddressx);
            }
            if (_cursor.isNull(_cursorIndexOfSMobileNo)) {
              _result.sMobileNo = null;
            } else {
              _result.sMobileNo = _cursor.getString(_cursorIndexOfSMobileNo);
            }
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
