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
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EBranchInfo;
import org.rmj.g3appdriver.GCircle.room.Entities.EInventoryDetail;
import org.rmj.g3appdriver.GCircle.room.Entities.EInventoryMaster;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DInventoryDao_Impl implements DInventoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EInventoryMaster> __insertionAdapterOfEInventoryMaster;

  private final EntityInsertionAdapter<EInventoryDetail> __insertionAdapterOfEInventoryDetail;

  private final EntityDeletionOrUpdateAdapter<EInventoryMaster> __updateAdapterOfEInventoryMaster;

  private final EntityDeletionOrUpdateAdapter<EInventoryDetail> __updateAdapterOfEInventoryDetail;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUploadedDetails;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUploadedMaster;

  public DInventoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEInventoryMaster = new EntityInsertionAdapter<EInventoryMaster>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Inventory_Count_Master` (`sTransNox`,`sBranchCd`,`dTransact`,`sRemarksx`,`nEntryNox`,`sRqstdByx`,`sVerified`,`dVerified`,`sApproved`,`dApproved`,`cTranStat`,`sModified`,`dModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EInventoryMaster value) {
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
        if (value.getRemarksx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRemarksx());
        }
        stmt.bindLong(5, value.getEntryNox());
        if (value.getRqstdByx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRqstdByx());
        }
        if (value.getVerifyBy() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getVerifyBy());
        }
        if (value.getDateVrfy() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDateVrfy());
        }
        if (value.getApprveBy() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getApprveBy());
        }
        if (value.getDateAppv() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getDateAppv());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTranStat());
        }
        if (value.getModifier() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getModifier());
        }
        if (value.getModified() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getModified());
        }
      }
    };
    this.__insertionAdapterOfEInventoryDetail = new EntityInsertionAdapter<EInventoryDetail>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Inventory_Count_Detail` (`sTransNox`,`nEntryNox`,`sBarrCode`,`sPartsIDx`,`sDescript`,`sWHouseID`,`sWHouseNm`,`sSectnIDx`,`sSectnNme`,`sBinIDxxx`,`sBinNamex`,`nQtyOnHnd`,`nActCtr01`,`nActCtr02`,`nActCtr03`,`nLedgerNo`,`nBegQtyxx`,`cTranStat`,`sRemarksx`,`dModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EInventoryDetail value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        stmt.bindLong(2, value.getEntryNox());
        if (value.getBarrCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBarrCode());
        }
        if (value.getPartsIDx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPartsIDx());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDescript());
        }
        if (value.getWHouseID() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getWHouseID());
        }
        if (value.getWHouseNm() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getWHouseNm());
        }
        if (value.getSectnIDx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSectnIDx());
        }
        if (value.getSectnNme() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSectnNme());
        }
        if (value.getBinIDxxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBinIDxxx());
        }
        if (value.getBinNamex() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getBinNamex());
        }
        stmt.bindLong(12, value.getQtyOnHnd());
        stmt.bindLong(13, value.getActCtr01());
        stmt.bindLong(14, value.getActCtr02());
        stmt.bindLong(15, value.getActCtr03());
        if (value.getLedgerNo() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getLedgerNo());
        }
        if (value.getBegQtyxx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getBegQtyxx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTranStat());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getRemarksx());
        }
        if (value.getModified() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getModified());
        }
      }
    };
    this.__updateAdapterOfEInventoryMaster = new EntityDeletionOrUpdateAdapter<EInventoryMaster>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Inventory_Count_Master` SET `sTransNox` = ?,`sBranchCd` = ?,`dTransact` = ?,`sRemarksx` = ?,`nEntryNox` = ?,`sRqstdByx` = ?,`sVerified` = ?,`dVerified` = ?,`sApproved` = ?,`dApproved` = ?,`cTranStat` = ?,`sModified` = ?,`dModified` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EInventoryMaster value) {
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
        if (value.getRemarksx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRemarksx());
        }
        stmt.bindLong(5, value.getEntryNox());
        if (value.getRqstdByx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRqstdByx());
        }
        if (value.getVerifyBy() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getVerifyBy());
        }
        if (value.getDateVrfy() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDateVrfy());
        }
        if (value.getApprveBy() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getApprveBy());
        }
        if (value.getDateAppv() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getDateAppv());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTranStat());
        }
        if (value.getModifier() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getModifier());
        }
        if (value.getModified() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getModified());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTransNox());
        }
      }
    };
    this.__updateAdapterOfEInventoryDetail = new EntityDeletionOrUpdateAdapter<EInventoryDetail>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Inventory_Count_Detail` SET `sTransNox` = ?,`nEntryNox` = ?,`sBarrCode` = ?,`sPartsIDx` = ?,`sDescript` = ?,`sWHouseID` = ?,`sWHouseNm` = ?,`sSectnIDx` = ?,`sSectnNme` = ?,`sBinIDxxx` = ?,`sBinNamex` = ?,`nQtyOnHnd` = ?,`nActCtr01` = ?,`nActCtr02` = ?,`nActCtr03` = ?,`nLedgerNo` = ?,`nBegQtyxx` = ?,`cTranStat` = ?,`sRemarksx` = ?,`dModified` = ? WHERE `sTransNox` = ? AND `nEntryNox` = ? AND `sBarrCode` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EInventoryDetail value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        stmt.bindLong(2, value.getEntryNox());
        if (value.getBarrCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBarrCode());
        }
        if (value.getPartsIDx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPartsIDx());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDescript());
        }
        if (value.getWHouseID() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getWHouseID());
        }
        if (value.getWHouseNm() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getWHouseNm());
        }
        if (value.getSectnIDx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSectnIDx());
        }
        if (value.getSectnNme() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSectnNme());
        }
        if (value.getBinIDxxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBinIDxxx());
        }
        if (value.getBinNamex() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getBinNamex());
        }
        stmt.bindLong(12, value.getQtyOnHnd());
        stmt.bindLong(13, value.getActCtr01());
        stmt.bindLong(14, value.getActCtr02());
        stmt.bindLong(15, value.getActCtr03());
        if (value.getLedgerNo() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getLedgerNo());
        }
        if (value.getBegQtyxx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getBegQtyxx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTranStat());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getRemarksx());
        }
        if (value.getModified() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getModified());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getTransNox());
        }
        stmt.bindLong(22, value.getEntryNox());
        if (value.getBarrCode() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getBarrCode());
        }
      }
    };
    this.__preparedStmtOfUpdateUploadedDetails = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Inventory_Count_Detail SET cTranStat = '2' WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUploadedMaster = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Inventory_Count_Master SET cTranStat = '2' WHERE sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveMaster(final EInventoryMaster foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEInventoryMaster.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void SaveDetail(final EInventoryDetail foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEInventoryDetail.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateMaster(final EInventoryMaster foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEInventoryMaster.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateDetail(final EInventoryDetail foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEInventoryDetail.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateUploadedDetails(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUploadedDetails.acquire();
    int _argIndex = 1;
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
      __preparedStmtOfUpdateUploadedDetails.release(_stmt);
    }
  }

  @Override
  public void UpdateUploadedMaster(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUploadedMaster.acquire();
    int _argIndex = 1;
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
      __preparedStmtOfUpdateUploadedMaster.release(_stmt);
    }
  }

  @Override
  public EInventoryMaster GetMaster(final String TransNox) {
    final String _sql = "SELECT * FROM Inventory_Count_Master WHERE sTransNox=?";
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
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfRqstdByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRqstdByx");
      final int _cursorIndexOfVerifyBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
      final int _cursorIndexOfDateVrfy = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfApprveBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDateAppv = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfModifier = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EInventoryMaster _result;
      if(_cursor.moveToFirst()) {
        _result = new EInventoryMaster();
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
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpRqstdByx;
        if (_cursor.isNull(_cursorIndexOfRqstdByx)) {
          _tmpRqstdByx = null;
        } else {
          _tmpRqstdByx = _cursor.getString(_cursorIndexOfRqstdByx);
        }
        _result.setRqstdByx(_tmpRqstdByx);
        final String _tmpVerifyBy;
        if (_cursor.isNull(_cursorIndexOfVerifyBy)) {
          _tmpVerifyBy = null;
        } else {
          _tmpVerifyBy = _cursor.getString(_cursorIndexOfVerifyBy);
        }
        _result.setVerifyBy(_tmpVerifyBy);
        final String _tmpDateVrfy;
        if (_cursor.isNull(_cursorIndexOfDateVrfy)) {
          _tmpDateVrfy = null;
        } else {
          _tmpDateVrfy = _cursor.getString(_cursorIndexOfDateVrfy);
        }
        _result.setDateVrfy(_tmpDateVrfy);
        final String _tmpApprveBy;
        if (_cursor.isNull(_cursorIndexOfApprveBy)) {
          _tmpApprveBy = null;
        } else {
          _tmpApprveBy = _cursor.getString(_cursorIndexOfApprveBy);
        }
        _result.setApprveBy(_tmpApprveBy);
        final String _tmpDateAppv;
        if (_cursor.isNull(_cursorIndexOfDateAppv)) {
          _tmpDateAppv = null;
        } else {
          _tmpDateAppv = _cursor.getString(_cursorIndexOfDateAppv);
        }
        _result.setDateAppv(_tmpDateAppv);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpModifier;
        if (_cursor.isNull(_cursorIndexOfModifier)) {
          _tmpModifier = null;
        } else {
          _tmpModifier = _cursor.getString(_cursorIndexOfModifier);
        }
        _result.setModifier(_tmpModifier);
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
  public EInventoryMaster GetMasterIfExists(final String Branchd, final String Transact) {
    final String _sql = "SELECT * FROM Inventory_Count_Master WHERE sBranchCd=? AND dTransact=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (Branchd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Branchd);
    }
    _argIndex = 2;
    if (Transact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Transact);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfRqstdByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRqstdByx");
      final int _cursorIndexOfVerifyBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
      final int _cursorIndexOfDateVrfy = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfApprveBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDateAppv = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfModifier = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EInventoryMaster _result;
      if(_cursor.moveToFirst()) {
        _result = new EInventoryMaster();
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
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpRqstdByx;
        if (_cursor.isNull(_cursorIndexOfRqstdByx)) {
          _tmpRqstdByx = null;
        } else {
          _tmpRqstdByx = _cursor.getString(_cursorIndexOfRqstdByx);
        }
        _result.setRqstdByx(_tmpRqstdByx);
        final String _tmpVerifyBy;
        if (_cursor.isNull(_cursorIndexOfVerifyBy)) {
          _tmpVerifyBy = null;
        } else {
          _tmpVerifyBy = _cursor.getString(_cursorIndexOfVerifyBy);
        }
        _result.setVerifyBy(_tmpVerifyBy);
        final String _tmpDateVrfy;
        if (_cursor.isNull(_cursorIndexOfDateVrfy)) {
          _tmpDateVrfy = null;
        } else {
          _tmpDateVrfy = _cursor.getString(_cursorIndexOfDateVrfy);
        }
        _result.setDateVrfy(_tmpDateVrfy);
        final String _tmpApprveBy;
        if (_cursor.isNull(_cursorIndexOfApprveBy)) {
          _tmpApprveBy = null;
        } else {
          _tmpApprveBy = _cursor.getString(_cursorIndexOfApprveBy);
        }
        _result.setApprveBy(_tmpApprveBy);
        final String _tmpDateAppv;
        if (_cursor.isNull(_cursorIndexOfDateAppv)) {
          _tmpDateAppv = null;
        } else {
          _tmpDateAppv = _cursor.getString(_cursorIndexOfDateAppv);
        }
        _result.setDateAppv(_tmpDateAppv);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpModifier;
        if (_cursor.isNull(_cursorIndexOfModifier)) {
          _tmpModifier = null;
        } else {
          _tmpModifier = _cursor.getString(_cursorIndexOfModifier);
        }
        _result.setModifier(_tmpModifier);
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
  public LiveData<EInventoryDetail> GetItemDetail(final String TransNox, final String EntryNox,
      final String BarrCode) {
    final String _sql = "SELECT * FROM Inventory_Count_Detail WHERE sTransNox =? AND nEntryNox =? AND sBarrCode =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (EntryNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, EntryNox);
    }
    _argIndex = 3;
    if (BarrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BarrCode);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Inventory_Count_Detail"}, false, new Callable<EInventoryDetail>() {
      @Override
      public EInventoryDetail call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfBarrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarrCode");
          final int _cursorIndexOfPartsIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPartsIDx");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfWHouseID = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseID");
          final int _cursorIndexOfWHouseNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseNm");
          final int _cursorIndexOfSectnIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnIDx");
          final int _cursorIndexOfSectnNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnNme");
          final int _cursorIndexOfBinIDxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinIDxxx");
          final int _cursorIndexOfBinNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinNamex");
          final int _cursorIndexOfQtyOnHnd = CursorUtil.getColumnIndexOrThrow(_cursor, "nQtyOnHnd");
          final int _cursorIndexOfActCtr01 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr01");
          final int _cursorIndexOfActCtr02 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr02");
          final int _cursorIndexOfActCtr03 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr03");
          final int _cursorIndexOfLedgerNo = CursorUtil.getColumnIndexOrThrow(_cursor, "nLedgerNo");
          final int _cursorIndexOfBegQtyxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nBegQtyxx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EInventoryDetail _result;
          if(_cursor.moveToFirst()) {
            _result = new EInventoryDetail();
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
            final String _tmpBarrCode;
            if (_cursor.isNull(_cursorIndexOfBarrCode)) {
              _tmpBarrCode = null;
            } else {
              _tmpBarrCode = _cursor.getString(_cursorIndexOfBarrCode);
            }
            _result.setBarrCode(_tmpBarrCode);
            final String _tmpPartsIDx;
            if (_cursor.isNull(_cursorIndexOfPartsIDx)) {
              _tmpPartsIDx = null;
            } else {
              _tmpPartsIDx = _cursor.getString(_cursorIndexOfPartsIDx);
            }
            _result.setPartsIDx(_tmpPartsIDx);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _result.setDescript(_tmpDescript);
            final String _tmpWHouseID;
            if (_cursor.isNull(_cursorIndexOfWHouseID)) {
              _tmpWHouseID = null;
            } else {
              _tmpWHouseID = _cursor.getString(_cursorIndexOfWHouseID);
            }
            _result.setWHouseID(_tmpWHouseID);
            final String _tmpWHouseNm;
            if (_cursor.isNull(_cursorIndexOfWHouseNm)) {
              _tmpWHouseNm = null;
            } else {
              _tmpWHouseNm = _cursor.getString(_cursorIndexOfWHouseNm);
            }
            _result.setWHouseNm(_tmpWHouseNm);
            final String _tmpSectnIDx;
            if (_cursor.isNull(_cursorIndexOfSectnIDx)) {
              _tmpSectnIDx = null;
            } else {
              _tmpSectnIDx = _cursor.getString(_cursorIndexOfSectnIDx);
            }
            _result.setSectnIDx(_tmpSectnIDx);
            final String _tmpSectnNme;
            if (_cursor.isNull(_cursorIndexOfSectnNme)) {
              _tmpSectnNme = null;
            } else {
              _tmpSectnNme = _cursor.getString(_cursorIndexOfSectnNme);
            }
            _result.setSectnNme(_tmpSectnNme);
            final String _tmpBinIDxxx;
            if (_cursor.isNull(_cursorIndexOfBinIDxxx)) {
              _tmpBinIDxxx = null;
            } else {
              _tmpBinIDxxx = _cursor.getString(_cursorIndexOfBinIDxxx);
            }
            _result.setBinIDxxx(_tmpBinIDxxx);
            final String _tmpBinNamex;
            if (_cursor.isNull(_cursorIndexOfBinNamex)) {
              _tmpBinNamex = null;
            } else {
              _tmpBinNamex = _cursor.getString(_cursorIndexOfBinNamex);
            }
            _result.setBinNamex(_tmpBinNamex);
            final int _tmpQtyOnHnd;
            _tmpQtyOnHnd = _cursor.getInt(_cursorIndexOfQtyOnHnd);
            _result.setQtyOnHnd(_tmpQtyOnHnd);
            final int _tmpActCtr01;
            _tmpActCtr01 = _cursor.getInt(_cursorIndexOfActCtr01);
            _result.setActCtr01(_tmpActCtr01);
            final int _tmpActCtr02;
            _tmpActCtr02 = _cursor.getInt(_cursorIndexOfActCtr02);
            _result.setActCtr02(_tmpActCtr02);
            final int _tmpActCtr03;
            _tmpActCtr03 = _cursor.getInt(_cursorIndexOfActCtr03);
            _result.setActCtr03(_tmpActCtr03);
            final String _tmpLedgerNo;
            if (_cursor.isNull(_cursorIndexOfLedgerNo)) {
              _tmpLedgerNo = null;
            } else {
              _tmpLedgerNo = _cursor.getString(_cursorIndexOfLedgerNo);
            }
            _result.setLedgerNo(_tmpLedgerNo);
            final String _tmpBegQtyxx;
            if (_cursor.isNull(_cursorIndexOfBegQtyxx)) {
              _tmpBegQtyxx = null;
            } else {
              _tmpBegQtyxx = _cursor.getString(_cursorIndexOfBegQtyxx);
            }
            _result.setBegQtyxx(_tmpBegQtyxx);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
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
  public LiveData<EInventoryMaster> GetInventoryMaster(final String fsVal, final String Transact) {
    final String _sql = "SELECT * FROM Inventory_Count_Master WHERE sBranchCd =? AND dTransact =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    _argIndex = 2;
    if (Transact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Transact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Inventory_Count_Master"}, false, new Callable<EInventoryMaster>() {
      @Override
      public EInventoryMaster call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfRqstdByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRqstdByx");
          final int _cursorIndexOfVerifyBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
          final int _cursorIndexOfDateVrfy = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
          final int _cursorIndexOfApprveBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDateAppv = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfModifier = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EInventoryMaster _result;
          if(_cursor.moveToFirst()) {
            _result = new EInventoryMaster();
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
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _result.setEntryNox(_tmpEntryNox);
            final String _tmpRqstdByx;
            if (_cursor.isNull(_cursorIndexOfRqstdByx)) {
              _tmpRqstdByx = null;
            } else {
              _tmpRqstdByx = _cursor.getString(_cursorIndexOfRqstdByx);
            }
            _result.setRqstdByx(_tmpRqstdByx);
            final String _tmpVerifyBy;
            if (_cursor.isNull(_cursorIndexOfVerifyBy)) {
              _tmpVerifyBy = null;
            } else {
              _tmpVerifyBy = _cursor.getString(_cursorIndexOfVerifyBy);
            }
            _result.setVerifyBy(_tmpVerifyBy);
            final String _tmpDateVrfy;
            if (_cursor.isNull(_cursorIndexOfDateVrfy)) {
              _tmpDateVrfy = null;
            } else {
              _tmpDateVrfy = _cursor.getString(_cursorIndexOfDateVrfy);
            }
            _result.setDateVrfy(_tmpDateVrfy);
            final String _tmpApprveBy;
            if (_cursor.isNull(_cursorIndexOfApprveBy)) {
              _tmpApprveBy = null;
            } else {
              _tmpApprveBy = _cursor.getString(_cursorIndexOfApprveBy);
            }
            _result.setApprveBy(_tmpApprveBy);
            final String _tmpDateAppv;
            if (_cursor.isNull(_cursorIndexOfDateAppv)) {
              _tmpDateAppv = null;
            } else {
              _tmpDateAppv = _cursor.getString(_cursorIndexOfDateAppv);
            }
            _result.setDateAppv(_tmpDateAppv);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpModifier;
            if (_cursor.isNull(_cursorIndexOfModifier)) {
              _tmpModifier = null;
            } else {
              _tmpModifier = _cursor.getString(_cursorIndexOfModifier);
            }
            _result.setModifier(_tmpModifier);
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
  public LiveData<List<EInventoryDetail>> GetInventoryItems(final String TransNox) {
    final String _sql = "SELECT * FROM Inventory_Count_Detail WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Inventory_Count_Detail"}, false, new Callable<List<EInventoryDetail>>() {
      @Override
      public List<EInventoryDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfBarrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarrCode");
          final int _cursorIndexOfPartsIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPartsIDx");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfWHouseID = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseID");
          final int _cursorIndexOfWHouseNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseNm");
          final int _cursorIndexOfSectnIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnIDx");
          final int _cursorIndexOfSectnNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnNme");
          final int _cursorIndexOfBinIDxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinIDxxx");
          final int _cursorIndexOfBinNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinNamex");
          final int _cursorIndexOfQtyOnHnd = CursorUtil.getColumnIndexOrThrow(_cursor, "nQtyOnHnd");
          final int _cursorIndexOfActCtr01 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr01");
          final int _cursorIndexOfActCtr02 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr02");
          final int _cursorIndexOfActCtr03 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr03");
          final int _cursorIndexOfLedgerNo = CursorUtil.getColumnIndexOrThrow(_cursor, "nLedgerNo");
          final int _cursorIndexOfBegQtyxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nBegQtyxx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final List<EInventoryDetail> _result = new ArrayList<EInventoryDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EInventoryDetail _item;
            _item = new EInventoryDetail();
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
            final String _tmpBarrCode;
            if (_cursor.isNull(_cursorIndexOfBarrCode)) {
              _tmpBarrCode = null;
            } else {
              _tmpBarrCode = _cursor.getString(_cursorIndexOfBarrCode);
            }
            _item.setBarrCode(_tmpBarrCode);
            final String _tmpPartsIDx;
            if (_cursor.isNull(_cursorIndexOfPartsIDx)) {
              _tmpPartsIDx = null;
            } else {
              _tmpPartsIDx = _cursor.getString(_cursorIndexOfPartsIDx);
            }
            _item.setPartsIDx(_tmpPartsIDx);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpWHouseID;
            if (_cursor.isNull(_cursorIndexOfWHouseID)) {
              _tmpWHouseID = null;
            } else {
              _tmpWHouseID = _cursor.getString(_cursorIndexOfWHouseID);
            }
            _item.setWHouseID(_tmpWHouseID);
            final String _tmpWHouseNm;
            if (_cursor.isNull(_cursorIndexOfWHouseNm)) {
              _tmpWHouseNm = null;
            } else {
              _tmpWHouseNm = _cursor.getString(_cursorIndexOfWHouseNm);
            }
            _item.setWHouseNm(_tmpWHouseNm);
            final String _tmpSectnIDx;
            if (_cursor.isNull(_cursorIndexOfSectnIDx)) {
              _tmpSectnIDx = null;
            } else {
              _tmpSectnIDx = _cursor.getString(_cursorIndexOfSectnIDx);
            }
            _item.setSectnIDx(_tmpSectnIDx);
            final String _tmpSectnNme;
            if (_cursor.isNull(_cursorIndexOfSectnNme)) {
              _tmpSectnNme = null;
            } else {
              _tmpSectnNme = _cursor.getString(_cursorIndexOfSectnNme);
            }
            _item.setSectnNme(_tmpSectnNme);
            final String _tmpBinIDxxx;
            if (_cursor.isNull(_cursorIndexOfBinIDxxx)) {
              _tmpBinIDxxx = null;
            } else {
              _tmpBinIDxxx = _cursor.getString(_cursorIndexOfBinIDxxx);
            }
            _item.setBinIDxxx(_tmpBinIDxxx);
            final String _tmpBinNamex;
            if (_cursor.isNull(_cursorIndexOfBinNamex)) {
              _tmpBinNamex = null;
            } else {
              _tmpBinNamex = _cursor.getString(_cursorIndexOfBinNamex);
            }
            _item.setBinNamex(_tmpBinNamex);
            final int _tmpQtyOnHnd;
            _tmpQtyOnHnd = _cursor.getInt(_cursorIndexOfQtyOnHnd);
            _item.setQtyOnHnd(_tmpQtyOnHnd);
            final int _tmpActCtr01;
            _tmpActCtr01 = _cursor.getInt(_cursorIndexOfActCtr01);
            _item.setActCtr01(_tmpActCtr01);
            final int _tmpActCtr02;
            _tmpActCtr02 = _cursor.getInt(_cursorIndexOfActCtr02);
            _item.setActCtr02(_tmpActCtr02);
            final int _tmpActCtr03;
            _tmpActCtr03 = _cursor.getInt(_cursorIndexOfActCtr03);
            _item.setActCtr03(_tmpActCtr03);
            final String _tmpLedgerNo;
            if (_cursor.isNull(_cursorIndexOfLedgerNo)) {
              _tmpLedgerNo = null;
            } else {
              _tmpLedgerNo = _cursor.getString(_cursorIndexOfLedgerNo);
            }
            _item.setLedgerNo(_tmpLedgerNo);
            final String _tmpBegQtyxx;
            if (_cursor.isNull(_cursorIndexOfBegQtyxx)) {
              _tmpBegQtyxx = null;
            } else {
              _tmpBegQtyxx = _cursor.getString(_cursorIndexOfBegQtyxx);
            }
            _item.setBegQtyxx(_tmpBegQtyxx);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
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
  public EInventoryDetail GetDetail(final String TransNox, final int EntryNox,
      final String BarrCode) {
    final String _sql = "SELECT * FROM Inventory_Count_Detail WHERE sTransNox =? AND nEntryNox =? AND sBarrCode =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, EntryNox);
    _argIndex = 3;
    if (BarrCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BarrCode);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfBarrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarrCode");
      final int _cursorIndexOfPartsIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPartsIDx");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfWHouseID = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseID");
      final int _cursorIndexOfWHouseNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseNm");
      final int _cursorIndexOfSectnIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnIDx");
      final int _cursorIndexOfSectnNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnNme");
      final int _cursorIndexOfBinIDxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinIDxxx");
      final int _cursorIndexOfBinNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinNamex");
      final int _cursorIndexOfQtyOnHnd = CursorUtil.getColumnIndexOrThrow(_cursor, "nQtyOnHnd");
      final int _cursorIndexOfActCtr01 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr01");
      final int _cursorIndexOfActCtr02 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr02");
      final int _cursorIndexOfActCtr03 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr03");
      final int _cursorIndexOfLedgerNo = CursorUtil.getColumnIndexOrThrow(_cursor, "nLedgerNo");
      final int _cursorIndexOfBegQtyxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nBegQtyxx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EInventoryDetail _result;
      if(_cursor.moveToFirst()) {
        _result = new EInventoryDetail();
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
        final String _tmpBarrCode;
        if (_cursor.isNull(_cursorIndexOfBarrCode)) {
          _tmpBarrCode = null;
        } else {
          _tmpBarrCode = _cursor.getString(_cursorIndexOfBarrCode);
        }
        _result.setBarrCode(_tmpBarrCode);
        final String _tmpPartsIDx;
        if (_cursor.isNull(_cursorIndexOfPartsIDx)) {
          _tmpPartsIDx = null;
        } else {
          _tmpPartsIDx = _cursor.getString(_cursorIndexOfPartsIDx);
        }
        _result.setPartsIDx(_tmpPartsIDx);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _result.setDescript(_tmpDescript);
        final String _tmpWHouseID;
        if (_cursor.isNull(_cursorIndexOfWHouseID)) {
          _tmpWHouseID = null;
        } else {
          _tmpWHouseID = _cursor.getString(_cursorIndexOfWHouseID);
        }
        _result.setWHouseID(_tmpWHouseID);
        final String _tmpWHouseNm;
        if (_cursor.isNull(_cursorIndexOfWHouseNm)) {
          _tmpWHouseNm = null;
        } else {
          _tmpWHouseNm = _cursor.getString(_cursorIndexOfWHouseNm);
        }
        _result.setWHouseNm(_tmpWHouseNm);
        final String _tmpSectnIDx;
        if (_cursor.isNull(_cursorIndexOfSectnIDx)) {
          _tmpSectnIDx = null;
        } else {
          _tmpSectnIDx = _cursor.getString(_cursorIndexOfSectnIDx);
        }
        _result.setSectnIDx(_tmpSectnIDx);
        final String _tmpSectnNme;
        if (_cursor.isNull(_cursorIndexOfSectnNme)) {
          _tmpSectnNme = null;
        } else {
          _tmpSectnNme = _cursor.getString(_cursorIndexOfSectnNme);
        }
        _result.setSectnNme(_tmpSectnNme);
        final String _tmpBinIDxxx;
        if (_cursor.isNull(_cursorIndexOfBinIDxxx)) {
          _tmpBinIDxxx = null;
        } else {
          _tmpBinIDxxx = _cursor.getString(_cursorIndexOfBinIDxxx);
        }
        _result.setBinIDxxx(_tmpBinIDxxx);
        final String _tmpBinNamex;
        if (_cursor.isNull(_cursorIndexOfBinNamex)) {
          _tmpBinNamex = null;
        } else {
          _tmpBinNamex = _cursor.getString(_cursorIndexOfBinNamex);
        }
        _result.setBinNamex(_tmpBinNamex);
        final int _tmpQtyOnHnd;
        _tmpQtyOnHnd = _cursor.getInt(_cursorIndexOfQtyOnHnd);
        _result.setQtyOnHnd(_tmpQtyOnHnd);
        final int _tmpActCtr01;
        _tmpActCtr01 = _cursor.getInt(_cursorIndexOfActCtr01);
        _result.setActCtr01(_tmpActCtr01);
        final int _tmpActCtr02;
        _tmpActCtr02 = _cursor.getInt(_cursorIndexOfActCtr02);
        _result.setActCtr02(_tmpActCtr02);
        final int _tmpActCtr03;
        _tmpActCtr03 = _cursor.getInt(_cursorIndexOfActCtr03);
        _result.setActCtr03(_tmpActCtr03);
        final String _tmpLedgerNo;
        if (_cursor.isNull(_cursorIndexOfLedgerNo)) {
          _tmpLedgerNo = null;
        } else {
          _tmpLedgerNo = _cursor.getString(_cursorIndexOfLedgerNo);
        }
        _result.setLedgerNo(_tmpLedgerNo);
        final String _tmpBegQtyxx;
        if (_cursor.isNull(_cursorIndexOfBegQtyxx)) {
          _tmpBegQtyxx = null;
        } else {
          _tmpBegQtyxx = _cursor.getString(_cursorIndexOfBegQtyxx);
        }
        _result.setBegQtyxx(_tmpBegQtyxx);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
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
  public List<EInventoryDetail> GetInventoryDetails(final String fsVal) {
    final String _sql = "SELECT * FROM Inventory_Count_Detail WHERE sTransNox =?";
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
      final int _cursorIndexOfBarrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarrCode");
      final int _cursorIndexOfPartsIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPartsIDx");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfWHouseID = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseID");
      final int _cursorIndexOfWHouseNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseNm");
      final int _cursorIndexOfSectnIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnIDx");
      final int _cursorIndexOfSectnNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnNme");
      final int _cursorIndexOfBinIDxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinIDxxx");
      final int _cursorIndexOfBinNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinNamex");
      final int _cursorIndexOfQtyOnHnd = CursorUtil.getColumnIndexOrThrow(_cursor, "nQtyOnHnd");
      final int _cursorIndexOfActCtr01 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr01");
      final int _cursorIndexOfActCtr02 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr02");
      final int _cursorIndexOfActCtr03 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr03");
      final int _cursorIndexOfLedgerNo = CursorUtil.getColumnIndexOrThrow(_cursor, "nLedgerNo");
      final int _cursorIndexOfBegQtyxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nBegQtyxx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EInventoryDetail> _result = new ArrayList<EInventoryDetail>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EInventoryDetail _item;
        _item = new EInventoryDetail();
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
        final String _tmpBarrCode;
        if (_cursor.isNull(_cursorIndexOfBarrCode)) {
          _tmpBarrCode = null;
        } else {
          _tmpBarrCode = _cursor.getString(_cursorIndexOfBarrCode);
        }
        _item.setBarrCode(_tmpBarrCode);
        final String _tmpPartsIDx;
        if (_cursor.isNull(_cursorIndexOfPartsIDx)) {
          _tmpPartsIDx = null;
        } else {
          _tmpPartsIDx = _cursor.getString(_cursorIndexOfPartsIDx);
        }
        _item.setPartsIDx(_tmpPartsIDx);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _item.setDescript(_tmpDescript);
        final String _tmpWHouseID;
        if (_cursor.isNull(_cursorIndexOfWHouseID)) {
          _tmpWHouseID = null;
        } else {
          _tmpWHouseID = _cursor.getString(_cursorIndexOfWHouseID);
        }
        _item.setWHouseID(_tmpWHouseID);
        final String _tmpWHouseNm;
        if (_cursor.isNull(_cursorIndexOfWHouseNm)) {
          _tmpWHouseNm = null;
        } else {
          _tmpWHouseNm = _cursor.getString(_cursorIndexOfWHouseNm);
        }
        _item.setWHouseNm(_tmpWHouseNm);
        final String _tmpSectnIDx;
        if (_cursor.isNull(_cursorIndexOfSectnIDx)) {
          _tmpSectnIDx = null;
        } else {
          _tmpSectnIDx = _cursor.getString(_cursorIndexOfSectnIDx);
        }
        _item.setSectnIDx(_tmpSectnIDx);
        final String _tmpSectnNme;
        if (_cursor.isNull(_cursorIndexOfSectnNme)) {
          _tmpSectnNme = null;
        } else {
          _tmpSectnNme = _cursor.getString(_cursorIndexOfSectnNme);
        }
        _item.setSectnNme(_tmpSectnNme);
        final String _tmpBinIDxxx;
        if (_cursor.isNull(_cursorIndexOfBinIDxxx)) {
          _tmpBinIDxxx = null;
        } else {
          _tmpBinIDxxx = _cursor.getString(_cursorIndexOfBinIDxxx);
        }
        _item.setBinIDxxx(_tmpBinIDxxx);
        final String _tmpBinNamex;
        if (_cursor.isNull(_cursorIndexOfBinNamex)) {
          _tmpBinNamex = null;
        } else {
          _tmpBinNamex = _cursor.getString(_cursorIndexOfBinNamex);
        }
        _item.setBinNamex(_tmpBinNamex);
        final int _tmpQtyOnHnd;
        _tmpQtyOnHnd = _cursor.getInt(_cursorIndexOfQtyOnHnd);
        _item.setQtyOnHnd(_tmpQtyOnHnd);
        final int _tmpActCtr01;
        _tmpActCtr01 = _cursor.getInt(_cursorIndexOfActCtr01);
        _item.setActCtr01(_tmpActCtr01);
        final int _tmpActCtr02;
        _tmpActCtr02 = _cursor.getInt(_cursorIndexOfActCtr02);
        _item.setActCtr02(_tmpActCtr02);
        final int _tmpActCtr03;
        _tmpActCtr03 = _cursor.getInt(_cursorIndexOfActCtr03);
        _item.setActCtr03(_tmpActCtr03);
        final String _tmpLedgerNo;
        if (_cursor.isNull(_cursorIndexOfLedgerNo)) {
          _tmpLedgerNo = null;
        } else {
          _tmpLedgerNo = _cursor.getString(_cursorIndexOfLedgerNo);
        }
        _item.setLedgerNo(_tmpLedgerNo);
        final String _tmpBegQtyxx;
        if (_cursor.isNull(_cursorIndexOfBegQtyxx)) {
          _tmpBegQtyxx = null;
        } else {
          _tmpBegQtyxx = _cursor.getString(_cursorIndexOfBegQtyxx);
        }
        _item.setBegQtyxx(_tmpBegQtyxx);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
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
  public List<EInventoryMaster> GetMasterInventoryForUpload() {
    final String _sql = "SELECT * FROM Inventory_Count_Master WHERE cTranStat != '2'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfRqstdByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRqstdByx");
      final int _cursorIndexOfVerifyBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
      final int _cursorIndexOfDateVrfy = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfApprveBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDateAppv = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfModifier = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EInventoryMaster> _result = new ArrayList<EInventoryMaster>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EInventoryMaster _item;
        _item = new EInventoryMaster();
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
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpRqstdByx;
        if (_cursor.isNull(_cursorIndexOfRqstdByx)) {
          _tmpRqstdByx = null;
        } else {
          _tmpRqstdByx = _cursor.getString(_cursorIndexOfRqstdByx);
        }
        _item.setRqstdByx(_tmpRqstdByx);
        final String _tmpVerifyBy;
        if (_cursor.isNull(_cursorIndexOfVerifyBy)) {
          _tmpVerifyBy = null;
        } else {
          _tmpVerifyBy = _cursor.getString(_cursorIndexOfVerifyBy);
        }
        _item.setVerifyBy(_tmpVerifyBy);
        final String _tmpDateVrfy;
        if (_cursor.isNull(_cursorIndexOfDateVrfy)) {
          _tmpDateVrfy = null;
        } else {
          _tmpDateVrfy = _cursor.getString(_cursorIndexOfDateVrfy);
        }
        _item.setDateVrfy(_tmpDateVrfy);
        final String _tmpApprveBy;
        if (_cursor.isNull(_cursorIndexOfApprveBy)) {
          _tmpApprveBy = null;
        } else {
          _tmpApprveBy = _cursor.getString(_cursorIndexOfApprveBy);
        }
        _item.setApprveBy(_tmpApprveBy);
        final String _tmpDateAppv;
        if (_cursor.isNull(_cursorIndexOfDateAppv)) {
          _tmpDateAppv = null;
        } else {
          _tmpDateAppv = _cursor.getString(_cursorIndexOfDateAppv);
        }
        _item.setDateAppv(_tmpDateAppv);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpModifier;
        if (_cursor.isNull(_cursorIndexOfModifier)) {
          _tmpModifier = null;
        } else {
          _tmpModifier = _cursor.getString(_cursorIndexOfModifier);
        }
        _item.setModifier(_tmpModifier);
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
  public List<EBranchInfo> GetBranchesForInventory(final String args) {
    final String _sql = "SELECT c.* FROM Employee_Log_Selfie a LEFT JOIN Inventory_Count_Master b ON a.sBranchCd = b.sBranchCd LEFT JOIN Branch_Info c ON a.sBranchCd = c.sBranchCd WHERE a.dTransact =? AND b.sBranchCd IS NULL OR a.dTransact =? AND b.cTranStat == 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    _argIndex = 2;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EBranchInfo _item;
        _item = new EBranchInfo();
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _item.setBranchNm(_tmpBranchNm);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _item.setDescript(_tmpDescript);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _item.setTownIDxx(_tmpTownIDxx);
        final String _tmpAreaCode;
        if (_cursor.isNull(_cursorIndexOfAreaCode)) {
          _tmpAreaCode = null;
        } else {
          _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
        }
        _item.setAreaCode(_tmpAreaCode);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _item.setDivision(_tmpDivision);
        final String _tmpPromoDiv;
        if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
          _tmpPromoDiv = null;
        } else {
          _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
        }
        _item.setPromoDiv(_tmpPromoDiv);
        final String _tmpRecdStat;
        if (_cursor.isNull(_cursorIndexOfRecdStat)) {
          _tmpRecdStat = null;
        } else {
          _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
        }
        _item.setRecdStat(_tmpRecdStat);
        final String _tmpTimeStmp;
        if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
          _tmpTimeStmp = null;
        } else {
          _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
        }
        _item.setTimeStmp(_tmpTimeStmp);
        final String _tmpLstUpdte;
        if (_cursor.isNull(_cursorIndexOfLstUpdte)) {
          _tmpLstUpdte = null;
        } else {
          _tmpLstUpdte = _cursor.getString(_cursorIndexOfLstUpdte);
        }
        _item.setLstUpdte(_tmpLstUpdte);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<EBranchInfo> GetBranchInfo(final String args) {
    final String _sql = "SELECT * FROM Branch_Info WHERE sBranchCd =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<EBranchInfo>() {
      @Override
      public EBranchInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final EBranchInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _result.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _result.setTownIDxx(_tmpTownIDxx);
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _result.setAreaCode(_tmpAreaCode);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _result.setDivision(_tmpDivision);
            final String _tmpPromoDiv;
            if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
              _tmpPromoDiv = null;
            } else {
              _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
            }
            _result.setPromoDiv(_tmpPromoDiv);
            final String _tmpRecdStat;
            if (_cursor.isNull(_cursorIndexOfRecdStat)) {
              _tmpRecdStat = null;
            } else {
              _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
            }
            _result.setRecdStat(_tmpRecdStat);
            final String _tmpTimeStmp;
            if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
              _tmpTimeStmp = null;
            } else {
              _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
            }
            _result.setTimeStmp(_tmpTimeStmp);
            final String _tmpLstUpdte;
            if (_cursor.isNull(_cursorIndexOfLstUpdte)) {
              _tmpLstUpdte = null;
            } else {
              _tmpLstUpdte = _cursor.getString(_cursorIndexOfLstUpdte);
            }
            _result.setLstUpdte(_tmpLstUpdte);
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
  public int CheckIfHasSelfieLog(final String args) {
    final String _sql = "SELECT COUNT(*) FROM Employee_Log_Selfie WHERE dTransact =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
