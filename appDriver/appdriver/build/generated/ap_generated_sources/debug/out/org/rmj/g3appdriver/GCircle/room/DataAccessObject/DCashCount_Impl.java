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
import org.rmj.g3appdriver.GCircle.room.Entities.EBranchInfo;
import org.rmj.g3appdriver.GCircle.room.Entities.ECashCount;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DCashCount_Impl implements DCashCount {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ECashCount> __insertionAdapterOfECashCount;

  private final EntityDeletionOrUpdateAdapter<ECashCount> __updateAdapterOfECashCount;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUploadedCashCount;

  public DCashCount_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfECashCount = new EntityInsertionAdapter<ECashCount>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Cash_Count_Master` (`sTransNox`,`sBranchCd`,`dTransact`,`nCn0001cx`,`nCn0005cx`,`nCn0010cx`,`nCn0025cx`,`nCn0050cx`,`nCn0001px`,`nCn0005px`,`nCn0010px`,`nNte0020p`,`nNte0050p`,`nNte0100p`,`nNte0200p`,`nNte0500p`,`nNte1000p`,`sPettyAmt`,`sORNoxxxx`,`sSINoxxxx`,`sPRNoxxxx`,`sCRNoxxxx`,`sORNoxNPt`,`sPRNoxNPt`,`sDRNoxxxx`,`dEntryDte`,`sReqstdBy`,`sRemarksx`,`dModified`,`sSendStat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECashCount value) {
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
        if (value.getCn0001cx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getCn0001cx());
        }
        if (value.getCn0005cx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCn0005cx());
        }
        if (value.getCn0010cx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCn0010cx());
        }
        if (value.getCn0025cx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getCn0025cx());
        }
        if (value.getCn0050cx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getCn0050cx());
        }
        if (value.getCn0001px() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getCn0001px());
        }
        if (value.getCn0005px() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getCn0005px());
        }
        if (value.getCn0010px() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getCn0010px());
        }
        if (value.getNte0020p() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getNte0020p());
        }
        if (value.getNte0050p() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getNte0050p());
        }
        if (value.getNte0100p() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getNte0100p());
        }
        if (value.getNte0200p() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.getNte0200p());
        }
        if (value.getNte0500p() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindLong(16, value.getNte0500p());
        }
        if (value.getNte1000p() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.getNte1000p());
        }
        if (value.getPettyAmt() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindDouble(18, value.getPettyAmt());
        }
        if (value.getORNoxxxx() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getORNoxxxx());
        }
        if (value.getSINoxxxx() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getSINoxxxx());
        }
        if (value.getPRNoxxxx() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getPRNoxxxx());
        }
        if (value.getCRNoxxxx() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getCRNoxxxx());
        }
        if (value.getORNoxNPt() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getORNoxNPt());
        }
        if (value.getPRNoxNPt() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getPRNoxNPt());
        }
        if (value.getDRNoxxxx() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getDRNoxxxx());
        }
        if (value.getEntryDte() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getEntryDte());
        }
        if (value.getReqstdBy() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getReqstdBy());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getRemarksx());
        }
        if (value.getModified() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getModified());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindLong(30, value.getSendStat());
        }
      }
    };
    this.__updateAdapterOfECashCount = new EntityDeletionOrUpdateAdapter<ECashCount>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Cash_Count_Master` SET `sTransNox` = ?,`sBranchCd` = ?,`dTransact` = ?,`nCn0001cx` = ?,`nCn0005cx` = ?,`nCn0010cx` = ?,`nCn0025cx` = ?,`nCn0050cx` = ?,`nCn0001px` = ?,`nCn0005px` = ?,`nCn0010px` = ?,`nNte0020p` = ?,`nNte0050p` = ?,`nNte0100p` = ?,`nNte0200p` = ?,`nNte0500p` = ?,`nNte1000p` = ?,`sPettyAmt` = ?,`sORNoxxxx` = ?,`sSINoxxxx` = ?,`sPRNoxxxx` = ?,`sCRNoxxxx` = ?,`sORNoxNPt` = ?,`sPRNoxNPt` = ?,`sDRNoxxxx` = ?,`dEntryDte` = ?,`sReqstdBy` = ?,`sRemarksx` = ?,`dModified` = ?,`sSendStat` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECashCount value) {
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
        if (value.getCn0001cx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getCn0001cx());
        }
        if (value.getCn0005cx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getCn0005cx());
        }
        if (value.getCn0010cx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindLong(6, value.getCn0010cx());
        }
        if (value.getCn0025cx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getCn0025cx());
        }
        if (value.getCn0050cx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getCn0050cx());
        }
        if (value.getCn0001px() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getCn0001px());
        }
        if (value.getCn0005px() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getCn0005px());
        }
        if (value.getCn0010px() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getCn0010px());
        }
        if (value.getNte0020p() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindLong(12, value.getNte0020p());
        }
        if (value.getNte0050p() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindLong(13, value.getNte0050p());
        }
        if (value.getNte0100p() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getNte0100p());
        }
        if (value.getNte0200p() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindLong(15, value.getNte0200p());
        }
        if (value.getNte0500p() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindLong(16, value.getNte0500p());
        }
        if (value.getNte1000p() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.getNte1000p());
        }
        if (value.getPettyAmt() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindDouble(18, value.getPettyAmt());
        }
        if (value.getORNoxxxx() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getORNoxxxx());
        }
        if (value.getSINoxxxx() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getSINoxxxx());
        }
        if (value.getPRNoxxxx() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getPRNoxxxx());
        }
        if (value.getCRNoxxxx() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getCRNoxxxx());
        }
        if (value.getORNoxNPt() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getORNoxNPt());
        }
        if (value.getPRNoxNPt() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getPRNoxNPt());
        }
        if (value.getDRNoxxxx() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getDRNoxxxx());
        }
        if (value.getEntryDte() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getEntryDte());
        }
        if (value.getReqstdBy() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getReqstdBy());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getRemarksx());
        }
        if (value.getModified() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getModified());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindLong(30, value.getSendStat());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateUploadedCashCount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Cash_Count_Master SET sTransNox =?, sSendStat = 1,dModified =? WHERE sTransNox =? ";
        return _query;
      }
    };
  }

  @Override
  public void SaveCashCount(final ECashCount cashCount) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECashCount.insert(cashCount);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateCashCount(final ECashCount cashCount) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfECashCount.handle(cashCount);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateUploadedCashCount(final String transNox, final String fsVal,
      final String dateTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUploadedCashCount.acquire();
    int _argIndex = 1;
    if (transNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, transNox);
    }
    _argIndex = 2;
    if (dateTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, dateTime);
    }
    _argIndex = 3;
    if (fsVal == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsVal);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUploadedCashCount.release(_stmt);
    }
  }

  @Override
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT (*) FROM Cash_Count_Master";
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
  public ECashCount CheckCashCountIfExist(final String lsBranchCd, final double lsPettyAmt,
      final String lsEntryDte, final String lsTransact, final int lnCn0001cx, final int lnCn0005cx,
      final int lnCn0010cx, final int lnCn0025cx, final int lnCn0050cx, final int lnCn0001px,
      final int lnCn0005px, final int lnCn0010px, final int lnNte0020p, final int lnNte0050p,
      final int lnNte0100p, final int lnNte0200p, final int lnNte0500p, final int lnNte1000p) {
    final String _sql = "SELECT * FROM Cash_Count_Master WHERE sBranchCd=? AND sPettyAmt=? AND dEntryDte=? AND dTransact=? AND nCn0001cx=? AND nCn0005cx=? AND nCn0010cx=? AND nCn0025cx=? AND nCn0050cx=? AND nCn0001px=? AND nCn0005px=? AND nCn0010px=? AND nNte0020p=? AND nNte0050p=? AND nNte0100p=? AND nNte0200p=? AND nNte0500p=? AND nNte1000p=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 18);
    int _argIndex = 1;
    if (lsBranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, lsBranchCd);
    }
    _argIndex = 2;
    _statement.bindDouble(_argIndex, lsPettyAmt);
    _argIndex = 3;
    if (lsEntryDte == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, lsEntryDte);
    }
    _argIndex = 4;
    if (lsTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, lsTransact);
    }
    _argIndex = 5;
    _statement.bindLong(_argIndex, lnCn0001cx);
    _argIndex = 6;
    _statement.bindLong(_argIndex, lnCn0005cx);
    _argIndex = 7;
    _statement.bindLong(_argIndex, lnCn0010cx);
    _argIndex = 8;
    _statement.bindLong(_argIndex, lnCn0025cx);
    _argIndex = 9;
    _statement.bindLong(_argIndex, lnCn0050cx);
    _argIndex = 10;
    _statement.bindLong(_argIndex, lnCn0001px);
    _argIndex = 11;
    _statement.bindLong(_argIndex, lnCn0005px);
    _argIndex = 12;
    _statement.bindLong(_argIndex, lnCn0010px);
    _argIndex = 13;
    _statement.bindLong(_argIndex, lnNte0020p);
    _argIndex = 14;
    _statement.bindLong(_argIndex, lnNte0050p);
    _argIndex = 15;
    _statement.bindLong(_argIndex, lnNte0100p);
    _argIndex = 16;
    _statement.bindLong(_argIndex, lnNte0200p);
    _argIndex = 17;
    _statement.bindLong(_argIndex, lnNte0500p);
    _argIndex = 18;
    _statement.bindLong(_argIndex, lnNte1000p);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfCn0001cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001cx");
      final int _cursorIndexOfCn0005cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005cx");
      final int _cursorIndexOfCn0010cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010cx");
      final int _cursorIndexOfCn0025cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0025cx");
      final int _cursorIndexOfCn0050cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0050cx");
      final int _cursorIndexOfCn0001px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001px");
      final int _cursorIndexOfCn0005px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005px");
      final int _cursorIndexOfCn0010px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010px");
      final int _cursorIndexOfNte0020p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0020p");
      final int _cursorIndexOfNte0050p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0050p");
      final int _cursorIndexOfNte0100p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0100p");
      final int _cursorIndexOfNte0200p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0200p");
      final int _cursorIndexOfNte0500p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0500p");
      final int _cursorIndexOfNte1000p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte1000p");
      final int _cursorIndexOfPettyAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPettyAmt");
      final int _cursorIndexOfORNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxxxx");
      final int _cursorIndexOfSINoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSINoxxxx");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfCRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCRNoxxxx");
      final int _cursorIndexOfORNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxNPt");
      final int _cursorIndexOfPRNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxNPt");
      final int _cursorIndexOfDRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sDRNoxxxx");
      final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
      final int _cursorIndexOfReqstdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdBy");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "sSendStat");
      final ECashCount _result;
      if(_cursor.moveToFirst()) {
        _result = new ECashCount();
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
        final Integer _tmpCn0001cx;
        if (_cursor.isNull(_cursorIndexOfCn0001cx)) {
          _tmpCn0001cx = null;
        } else {
          _tmpCn0001cx = _cursor.getInt(_cursorIndexOfCn0001cx);
        }
        _result.setCn0001cx(_tmpCn0001cx);
        final Integer _tmpCn0005cx;
        if (_cursor.isNull(_cursorIndexOfCn0005cx)) {
          _tmpCn0005cx = null;
        } else {
          _tmpCn0005cx = _cursor.getInt(_cursorIndexOfCn0005cx);
        }
        _result.setCn0005cx(_tmpCn0005cx);
        final Integer _tmpCn0010cx;
        if (_cursor.isNull(_cursorIndexOfCn0010cx)) {
          _tmpCn0010cx = null;
        } else {
          _tmpCn0010cx = _cursor.getInt(_cursorIndexOfCn0010cx);
        }
        _result.setCn0010cx(_tmpCn0010cx);
        final Integer _tmpCn0025cx;
        if (_cursor.isNull(_cursorIndexOfCn0025cx)) {
          _tmpCn0025cx = null;
        } else {
          _tmpCn0025cx = _cursor.getInt(_cursorIndexOfCn0025cx);
        }
        _result.setCn0025cx(_tmpCn0025cx);
        final Integer _tmpCn0050cx;
        if (_cursor.isNull(_cursorIndexOfCn0050cx)) {
          _tmpCn0050cx = null;
        } else {
          _tmpCn0050cx = _cursor.getInt(_cursorIndexOfCn0050cx);
        }
        _result.setCn0050cx(_tmpCn0050cx);
        final Integer _tmpCn0001px;
        if (_cursor.isNull(_cursorIndexOfCn0001px)) {
          _tmpCn0001px = null;
        } else {
          _tmpCn0001px = _cursor.getInt(_cursorIndexOfCn0001px);
        }
        _result.setCn0001px(_tmpCn0001px);
        final Integer _tmpCn0005px;
        if (_cursor.isNull(_cursorIndexOfCn0005px)) {
          _tmpCn0005px = null;
        } else {
          _tmpCn0005px = _cursor.getInt(_cursorIndexOfCn0005px);
        }
        _result.setCn0005px(_tmpCn0005px);
        final Integer _tmpCn0010px;
        if (_cursor.isNull(_cursorIndexOfCn0010px)) {
          _tmpCn0010px = null;
        } else {
          _tmpCn0010px = _cursor.getInt(_cursorIndexOfCn0010px);
        }
        _result.setCn0010px(_tmpCn0010px);
        final Integer _tmpNte0020p;
        if (_cursor.isNull(_cursorIndexOfNte0020p)) {
          _tmpNte0020p = null;
        } else {
          _tmpNte0020p = _cursor.getInt(_cursorIndexOfNte0020p);
        }
        _result.setNte0020p(_tmpNte0020p);
        final Integer _tmpNte0050p;
        if (_cursor.isNull(_cursorIndexOfNte0050p)) {
          _tmpNte0050p = null;
        } else {
          _tmpNte0050p = _cursor.getInt(_cursorIndexOfNte0050p);
        }
        _result.setNte0050p(_tmpNte0050p);
        final Integer _tmpNte0100p;
        if (_cursor.isNull(_cursorIndexOfNte0100p)) {
          _tmpNte0100p = null;
        } else {
          _tmpNte0100p = _cursor.getInt(_cursorIndexOfNte0100p);
        }
        _result.setNte0100p(_tmpNte0100p);
        final Integer _tmpNte0200p;
        if (_cursor.isNull(_cursorIndexOfNte0200p)) {
          _tmpNte0200p = null;
        } else {
          _tmpNte0200p = _cursor.getInt(_cursorIndexOfNte0200p);
        }
        _result.setNte0200p(_tmpNte0200p);
        final Integer _tmpNte0500p;
        if (_cursor.isNull(_cursorIndexOfNte0500p)) {
          _tmpNte0500p = null;
        } else {
          _tmpNte0500p = _cursor.getInt(_cursorIndexOfNte0500p);
        }
        _result.setNte0500p(_tmpNte0500p);
        final Integer _tmpNte1000p;
        if (_cursor.isNull(_cursorIndexOfNte1000p)) {
          _tmpNte1000p = null;
        } else {
          _tmpNte1000p = _cursor.getInt(_cursorIndexOfNte1000p);
        }
        _result.setNte1000p(_tmpNte1000p);
        final Double _tmpPettyAmt;
        if (_cursor.isNull(_cursorIndexOfPettyAmt)) {
          _tmpPettyAmt = null;
        } else {
          _tmpPettyAmt = _cursor.getDouble(_cursorIndexOfPettyAmt);
        }
        _result.setPettyAmt(_tmpPettyAmt);
        final String _tmpORNoxxxx;
        if (_cursor.isNull(_cursorIndexOfORNoxxxx)) {
          _tmpORNoxxxx = null;
        } else {
          _tmpORNoxxxx = _cursor.getString(_cursorIndexOfORNoxxxx);
        }
        _result.setORNoxxxx(_tmpORNoxxxx);
        final String _tmpSINoxxxx;
        if (_cursor.isNull(_cursorIndexOfSINoxxxx)) {
          _tmpSINoxxxx = null;
        } else {
          _tmpSINoxxxx = _cursor.getString(_cursorIndexOfSINoxxxx);
        }
        _result.setSINoxxxx(_tmpSINoxxxx);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _result.setPRNoxxxx(_tmpPRNoxxxx);
        final String _tmpCRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfCRNoxxxx)) {
          _tmpCRNoxxxx = null;
        } else {
          _tmpCRNoxxxx = _cursor.getString(_cursorIndexOfCRNoxxxx);
        }
        _result.setCRNoxxxx(_tmpCRNoxxxx);
        final String _tmpORNoxNPt;
        if (_cursor.isNull(_cursorIndexOfORNoxNPt)) {
          _tmpORNoxNPt = null;
        } else {
          _tmpORNoxNPt = _cursor.getString(_cursorIndexOfORNoxNPt);
        }
        _result.setORNoxNPt(_tmpORNoxNPt);
        final String _tmpPRNoxNPt;
        if (_cursor.isNull(_cursorIndexOfPRNoxNPt)) {
          _tmpPRNoxNPt = null;
        } else {
          _tmpPRNoxNPt = _cursor.getString(_cursorIndexOfPRNoxNPt);
        }
        _result.setPRNoxNPt(_tmpPRNoxNPt);
        final String _tmpDRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfDRNoxxxx)) {
          _tmpDRNoxxxx = null;
        } else {
          _tmpDRNoxxxx = _cursor.getString(_cursorIndexOfDRNoxxxx);
        }
        _result.setDRNoxxxx(_tmpDRNoxxxx);
        final String _tmpEntryDte;
        if (_cursor.isNull(_cursorIndexOfEntryDte)) {
          _tmpEntryDte = null;
        } else {
          _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
        }
        _result.setEntryDte(_tmpEntryDte);
        final String _tmpReqstdBy;
        if (_cursor.isNull(_cursorIndexOfReqstdBy)) {
          _tmpReqstdBy = null;
        } else {
          _tmpReqstdBy = _cursor.getString(_cursorIndexOfReqstdBy);
        }
        _result.setReqstdBy(_tmpReqstdBy);
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
        final Integer _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getInt(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
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
  public ECashCount GetCashCountDetail(final String fsVal) {
    final String _sql = "SELECT * FROM Cash_Count_Master WHERE sTransNox =?";
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
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfCn0001cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001cx");
      final int _cursorIndexOfCn0005cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005cx");
      final int _cursorIndexOfCn0010cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010cx");
      final int _cursorIndexOfCn0025cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0025cx");
      final int _cursorIndexOfCn0050cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0050cx");
      final int _cursorIndexOfCn0001px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001px");
      final int _cursorIndexOfCn0005px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005px");
      final int _cursorIndexOfCn0010px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010px");
      final int _cursorIndexOfNte0020p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0020p");
      final int _cursorIndexOfNte0050p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0050p");
      final int _cursorIndexOfNte0100p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0100p");
      final int _cursorIndexOfNte0200p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0200p");
      final int _cursorIndexOfNte0500p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0500p");
      final int _cursorIndexOfNte1000p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte1000p");
      final int _cursorIndexOfPettyAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPettyAmt");
      final int _cursorIndexOfORNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxxxx");
      final int _cursorIndexOfSINoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSINoxxxx");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfCRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCRNoxxxx");
      final int _cursorIndexOfORNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxNPt");
      final int _cursorIndexOfPRNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxNPt");
      final int _cursorIndexOfDRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sDRNoxxxx");
      final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
      final int _cursorIndexOfReqstdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdBy");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "sSendStat");
      final ECashCount _result;
      if(_cursor.moveToFirst()) {
        _result = new ECashCount();
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
        final Integer _tmpCn0001cx;
        if (_cursor.isNull(_cursorIndexOfCn0001cx)) {
          _tmpCn0001cx = null;
        } else {
          _tmpCn0001cx = _cursor.getInt(_cursorIndexOfCn0001cx);
        }
        _result.setCn0001cx(_tmpCn0001cx);
        final Integer _tmpCn0005cx;
        if (_cursor.isNull(_cursorIndexOfCn0005cx)) {
          _tmpCn0005cx = null;
        } else {
          _tmpCn0005cx = _cursor.getInt(_cursorIndexOfCn0005cx);
        }
        _result.setCn0005cx(_tmpCn0005cx);
        final Integer _tmpCn0010cx;
        if (_cursor.isNull(_cursorIndexOfCn0010cx)) {
          _tmpCn0010cx = null;
        } else {
          _tmpCn0010cx = _cursor.getInt(_cursorIndexOfCn0010cx);
        }
        _result.setCn0010cx(_tmpCn0010cx);
        final Integer _tmpCn0025cx;
        if (_cursor.isNull(_cursorIndexOfCn0025cx)) {
          _tmpCn0025cx = null;
        } else {
          _tmpCn0025cx = _cursor.getInt(_cursorIndexOfCn0025cx);
        }
        _result.setCn0025cx(_tmpCn0025cx);
        final Integer _tmpCn0050cx;
        if (_cursor.isNull(_cursorIndexOfCn0050cx)) {
          _tmpCn0050cx = null;
        } else {
          _tmpCn0050cx = _cursor.getInt(_cursorIndexOfCn0050cx);
        }
        _result.setCn0050cx(_tmpCn0050cx);
        final Integer _tmpCn0001px;
        if (_cursor.isNull(_cursorIndexOfCn0001px)) {
          _tmpCn0001px = null;
        } else {
          _tmpCn0001px = _cursor.getInt(_cursorIndexOfCn0001px);
        }
        _result.setCn0001px(_tmpCn0001px);
        final Integer _tmpCn0005px;
        if (_cursor.isNull(_cursorIndexOfCn0005px)) {
          _tmpCn0005px = null;
        } else {
          _tmpCn0005px = _cursor.getInt(_cursorIndexOfCn0005px);
        }
        _result.setCn0005px(_tmpCn0005px);
        final Integer _tmpCn0010px;
        if (_cursor.isNull(_cursorIndexOfCn0010px)) {
          _tmpCn0010px = null;
        } else {
          _tmpCn0010px = _cursor.getInt(_cursorIndexOfCn0010px);
        }
        _result.setCn0010px(_tmpCn0010px);
        final Integer _tmpNte0020p;
        if (_cursor.isNull(_cursorIndexOfNte0020p)) {
          _tmpNte0020p = null;
        } else {
          _tmpNte0020p = _cursor.getInt(_cursorIndexOfNte0020p);
        }
        _result.setNte0020p(_tmpNte0020p);
        final Integer _tmpNte0050p;
        if (_cursor.isNull(_cursorIndexOfNte0050p)) {
          _tmpNte0050p = null;
        } else {
          _tmpNte0050p = _cursor.getInt(_cursorIndexOfNte0050p);
        }
        _result.setNte0050p(_tmpNte0050p);
        final Integer _tmpNte0100p;
        if (_cursor.isNull(_cursorIndexOfNte0100p)) {
          _tmpNte0100p = null;
        } else {
          _tmpNte0100p = _cursor.getInt(_cursorIndexOfNte0100p);
        }
        _result.setNte0100p(_tmpNte0100p);
        final Integer _tmpNte0200p;
        if (_cursor.isNull(_cursorIndexOfNte0200p)) {
          _tmpNte0200p = null;
        } else {
          _tmpNte0200p = _cursor.getInt(_cursorIndexOfNte0200p);
        }
        _result.setNte0200p(_tmpNte0200p);
        final Integer _tmpNte0500p;
        if (_cursor.isNull(_cursorIndexOfNte0500p)) {
          _tmpNte0500p = null;
        } else {
          _tmpNte0500p = _cursor.getInt(_cursorIndexOfNte0500p);
        }
        _result.setNte0500p(_tmpNte0500p);
        final Integer _tmpNte1000p;
        if (_cursor.isNull(_cursorIndexOfNte1000p)) {
          _tmpNte1000p = null;
        } else {
          _tmpNte1000p = _cursor.getInt(_cursorIndexOfNte1000p);
        }
        _result.setNte1000p(_tmpNte1000p);
        final Double _tmpPettyAmt;
        if (_cursor.isNull(_cursorIndexOfPettyAmt)) {
          _tmpPettyAmt = null;
        } else {
          _tmpPettyAmt = _cursor.getDouble(_cursorIndexOfPettyAmt);
        }
        _result.setPettyAmt(_tmpPettyAmt);
        final String _tmpORNoxxxx;
        if (_cursor.isNull(_cursorIndexOfORNoxxxx)) {
          _tmpORNoxxxx = null;
        } else {
          _tmpORNoxxxx = _cursor.getString(_cursorIndexOfORNoxxxx);
        }
        _result.setORNoxxxx(_tmpORNoxxxx);
        final String _tmpSINoxxxx;
        if (_cursor.isNull(_cursorIndexOfSINoxxxx)) {
          _tmpSINoxxxx = null;
        } else {
          _tmpSINoxxxx = _cursor.getString(_cursorIndexOfSINoxxxx);
        }
        _result.setSINoxxxx(_tmpSINoxxxx);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _result.setPRNoxxxx(_tmpPRNoxxxx);
        final String _tmpCRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfCRNoxxxx)) {
          _tmpCRNoxxxx = null;
        } else {
          _tmpCRNoxxxx = _cursor.getString(_cursorIndexOfCRNoxxxx);
        }
        _result.setCRNoxxxx(_tmpCRNoxxxx);
        final String _tmpORNoxNPt;
        if (_cursor.isNull(_cursorIndexOfORNoxNPt)) {
          _tmpORNoxNPt = null;
        } else {
          _tmpORNoxNPt = _cursor.getString(_cursorIndexOfORNoxNPt);
        }
        _result.setORNoxNPt(_tmpORNoxNPt);
        final String _tmpPRNoxNPt;
        if (_cursor.isNull(_cursorIndexOfPRNoxNPt)) {
          _tmpPRNoxNPt = null;
        } else {
          _tmpPRNoxNPt = _cursor.getString(_cursorIndexOfPRNoxNPt);
        }
        _result.setPRNoxNPt(_tmpPRNoxNPt);
        final String _tmpDRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfDRNoxxxx)) {
          _tmpDRNoxxxx = null;
        } else {
          _tmpDRNoxxxx = _cursor.getString(_cursorIndexOfDRNoxxxx);
        }
        _result.setDRNoxxxx(_tmpDRNoxxxx);
        final String _tmpEntryDte;
        if (_cursor.isNull(_cursorIndexOfEntryDte)) {
          _tmpEntryDte = null;
        } else {
          _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
        }
        _result.setEntryDte(_tmpEntryDte);
        final String _tmpReqstdBy;
        if (_cursor.isNull(_cursorIndexOfReqstdBy)) {
          _tmpReqstdBy = null;
        } else {
          _tmpReqstdBy = _cursor.getString(_cursorIndexOfReqstdBy);
        }
        _result.setReqstdBy(_tmpReqstdBy);
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
        final Integer _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getInt(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
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
  public LiveData<ECashCount> getCashCounDetetail(final String TransNox) {
    final String _sql = "SELECT * FROM Cash_Count_Master WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Cash_Count_Master"}, false, new Callable<ECashCount>() {
      @Override
      public ECashCount call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfCn0001cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001cx");
          final int _cursorIndexOfCn0005cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005cx");
          final int _cursorIndexOfCn0010cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010cx");
          final int _cursorIndexOfCn0025cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0025cx");
          final int _cursorIndexOfCn0050cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0050cx");
          final int _cursorIndexOfCn0001px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001px");
          final int _cursorIndexOfCn0005px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005px");
          final int _cursorIndexOfCn0010px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010px");
          final int _cursorIndexOfNte0020p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0020p");
          final int _cursorIndexOfNte0050p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0050p");
          final int _cursorIndexOfNte0100p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0100p");
          final int _cursorIndexOfNte0200p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0200p");
          final int _cursorIndexOfNte0500p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0500p");
          final int _cursorIndexOfNte1000p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte1000p");
          final int _cursorIndexOfPettyAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPettyAmt");
          final int _cursorIndexOfORNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxxxx");
          final int _cursorIndexOfSINoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSINoxxxx");
          final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfCRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCRNoxxxx");
          final int _cursorIndexOfORNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxNPt");
          final int _cursorIndexOfPRNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxNPt");
          final int _cursorIndexOfDRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sDRNoxxxx");
          final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
          final int _cursorIndexOfReqstdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdBy");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "sSendStat");
          final ECashCount _result;
          if(_cursor.moveToFirst()) {
            _result = new ECashCount();
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
            final Integer _tmpCn0001cx;
            if (_cursor.isNull(_cursorIndexOfCn0001cx)) {
              _tmpCn0001cx = null;
            } else {
              _tmpCn0001cx = _cursor.getInt(_cursorIndexOfCn0001cx);
            }
            _result.setCn0001cx(_tmpCn0001cx);
            final Integer _tmpCn0005cx;
            if (_cursor.isNull(_cursorIndexOfCn0005cx)) {
              _tmpCn0005cx = null;
            } else {
              _tmpCn0005cx = _cursor.getInt(_cursorIndexOfCn0005cx);
            }
            _result.setCn0005cx(_tmpCn0005cx);
            final Integer _tmpCn0010cx;
            if (_cursor.isNull(_cursorIndexOfCn0010cx)) {
              _tmpCn0010cx = null;
            } else {
              _tmpCn0010cx = _cursor.getInt(_cursorIndexOfCn0010cx);
            }
            _result.setCn0010cx(_tmpCn0010cx);
            final Integer _tmpCn0025cx;
            if (_cursor.isNull(_cursorIndexOfCn0025cx)) {
              _tmpCn0025cx = null;
            } else {
              _tmpCn0025cx = _cursor.getInt(_cursorIndexOfCn0025cx);
            }
            _result.setCn0025cx(_tmpCn0025cx);
            final Integer _tmpCn0050cx;
            if (_cursor.isNull(_cursorIndexOfCn0050cx)) {
              _tmpCn0050cx = null;
            } else {
              _tmpCn0050cx = _cursor.getInt(_cursorIndexOfCn0050cx);
            }
            _result.setCn0050cx(_tmpCn0050cx);
            final Integer _tmpCn0001px;
            if (_cursor.isNull(_cursorIndexOfCn0001px)) {
              _tmpCn0001px = null;
            } else {
              _tmpCn0001px = _cursor.getInt(_cursorIndexOfCn0001px);
            }
            _result.setCn0001px(_tmpCn0001px);
            final Integer _tmpCn0005px;
            if (_cursor.isNull(_cursorIndexOfCn0005px)) {
              _tmpCn0005px = null;
            } else {
              _tmpCn0005px = _cursor.getInt(_cursorIndexOfCn0005px);
            }
            _result.setCn0005px(_tmpCn0005px);
            final Integer _tmpCn0010px;
            if (_cursor.isNull(_cursorIndexOfCn0010px)) {
              _tmpCn0010px = null;
            } else {
              _tmpCn0010px = _cursor.getInt(_cursorIndexOfCn0010px);
            }
            _result.setCn0010px(_tmpCn0010px);
            final Integer _tmpNte0020p;
            if (_cursor.isNull(_cursorIndexOfNte0020p)) {
              _tmpNte0020p = null;
            } else {
              _tmpNte0020p = _cursor.getInt(_cursorIndexOfNte0020p);
            }
            _result.setNte0020p(_tmpNte0020p);
            final Integer _tmpNte0050p;
            if (_cursor.isNull(_cursorIndexOfNte0050p)) {
              _tmpNte0050p = null;
            } else {
              _tmpNte0050p = _cursor.getInt(_cursorIndexOfNte0050p);
            }
            _result.setNte0050p(_tmpNte0050p);
            final Integer _tmpNte0100p;
            if (_cursor.isNull(_cursorIndexOfNte0100p)) {
              _tmpNte0100p = null;
            } else {
              _tmpNte0100p = _cursor.getInt(_cursorIndexOfNte0100p);
            }
            _result.setNte0100p(_tmpNte0100p);
            final Integer _tmpNte0200p;
            if (_cursor.isNull(_cursorIndexOfNte0200p)) {
              _tmpNte0200p = null;
            } else {
              _tmpNte0200p = _cursor.getInt(_cursorIndexOfNte0200p);
            }
            _result.setNte0200p(_tmpNte0200p);
            final Integer _tmpNte0500p;
            if (_cursor.isNull(_cursorIndexOfNte0500p)) {
              _tmpNte0500p = null;
            } else {
              _tmpNte0500p = _cursor.getInt(_cursorIndexOfNte0500p);
            }
            _result.setNte0500p(_tmpNte0500p);
            final Integer _tmpNte1000p;
            if (_cursor.isNull(_cursorIndexOfNte1000p)) {
              _tmpNte1000p = null;
            } else {
              _tmpNte1000p = _cursor.getInt(_cursorIndexOfNte1000p);
            }
            _result.setNte1000p(_tmpNte1000p);
            final Double _tmpPettyAmt;
            if (_cursor.isNull(_cursorIndexOfPettyAmt)) {
              _tmpPettyAmt = null;
            } else {
              _tmpPettyAmt = _cursor.getDouble(_cursorIndexOfPettyAmt);
            }
            _result.setPettyAmt(_tmpPettyAmt);
            final String _tmpORNoxxxx;
            if (_cursor.isNull(_cursorIndexOfORNoxxxx)) {
              _tmpORNoxxxx = null;
            } else {
              _tmpORNoxxxx = _cursor.getString(_cursorIndexOfORNoxxxx);
            }
            _result.setORNoxxxx(_tmpORNoxxxx);
            final String _tmpSINoxxxx;
            if (_cursor.isNull(_cursorIndexOfSINoxxxx)) {
              _tmpSINoxxxx = null;
            } else {
              _tmpSINoxxxx = _cursor.getString(_cursorIndexOfSINoxxxx);
            }
            _result.setSINoxxxx(_tmpSINoxxxx);
            final String _tmpPRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
              _tmpPRNoxxxx = null;
            } else {
              _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
            }
            _result.setPRNoxxxx(_tmpPRNoxxxx);
            final String _tmpCRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfCRNoxxxx)) {
              _tmpCRNoxxxx = null;
            } else {
              _tmpCRNoxxxx = _cursor.getString(_cursorIndexOfCRNoxxxx);
            }
            _result.setCRNoxxxx(_tmpCRNoxxxx);
            final String _tmpORNoxNPt;
            if (_cursor.isNull(_cursorIndexOfORNoxNPt)) {
              _tmpORNoxNPt = null;
            } else {
              _tmpORNoxNPt = _cursor.getString(_cursorIndexOfORNoxNPt);
            }
            _result.setORNoxNPt(_tmpORNoxNPt);
            final String _tmpPRNoxNPt;
            if (_cursor.isNull(_cursorIndexOfPRNoxNPt)) {
              _tmpPRNoxNPt = null;
            } else {
              _tmpPRNoxNPt = _cursor.getString(_cursorIndexOfPRNoxNPt);
            }
            _result.setPRNoxNPt(_tmpPRNoxNPt);
            final String _tmpDRNoxxxx;
            if (_cursor.isNull(_cursorIndexOfDRNoxxxx)) {
              _tmpDRNoxxxx = null;
            } else {
              _tmpDRNoxxxx = _cursor.getString(_cursorIndexOfDRNoxxxx);
            }
            _result.setDRNoxxxx(_tmpDRNoxxxx);
            final String _tmpEntryDte;
            if (_cursor.isNull(_cursorIndexOfEntryDte)) {
              _tmpEntryDte = null;
            } else {
              _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
            }
            _result.setEntryDte(_tmpEntryDte);
            final String _tmpReqstdBy;
            if (_cursor.isNull(_cursorIndexOfReqstdBy)) {
              _tmpReqstdBy = null;
            } else {
              _tmpReqstdBy = _cursor.getString(_cursorIndexOfReqstdBy);
            }
            _result.setReqstdBy(_tmpReqstdBy);
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
            final Integer _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getInt(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
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
  public LiveData<EBranchInfo> GetBranchForCashCount(final String args) {
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

  @Override
  public List<EBranchInfo> GetBranchesForCashCount(final String args) {
    final String _sql = "SELECT a.* FROM Branch_Info a LEFT JOIN Employee_Log_Selfie b ON a.sBranchCd = b.sBranchCd WHERE b.dTransact=? AND b.sBranchCd NOT IN (SELECT sBranchCd FROM Cash_Count_Master WHERE dTransact=?)";
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
  public List<ECashCount> GetUnsentCashCountEntries() {
    final String _sql = "SELECT * FROM Cash_Count_Master WHERE sSendStat == 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfCn0001cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001cx");
      final int _cursorIndexOfCn0005cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005cx");
      final int _cursorIndexOfCn0010cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010cx");
      final int _cursorIndexOfCn0025cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0025cx");
      final int _cursorIndexOfCn0050cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0050cx");
      final int _cursorIndexOfCn0001px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001px");
      final int _cursorIndexOfCn0005px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005px");
      final int _cursorIndexOfCn0010px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010px");
      final int _cursorIndexOfNte0020p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0020p");
      final int _cursorIndexOfNte0050p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0050p");
      final int _cursorIndexOfNte0100p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0100p");
      final int _cursorIndexOfNte0200p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0200p");
      final int _cursorIndexOfNte0500p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0500p");
      final int _cursorIndexOfNte1000p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte1000p");
      final int _cursorIndexOfPettyAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPettyAmt");
      final int _cursorIndexOfORNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxxxx");
      final int _cursorIndexOfSINoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSINoxxxx");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfCRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCRNoxxxx");
      final int _cursorIndexOfORNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxNPt");
      final int _cursorIndexOfPRNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxNPt");
      final int _cursorIndexOfDRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sDRNoxxxx");
      final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
      final int _cursorIndexOfReqstdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdBy");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "sSendStat");
      final List<ECashCount> _result = new ArrayList<ECashCount>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ECashCount _item;
        _item = new ECashCount();
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
        final Integer _tmpCn0001cx;
        if (_cursor.isNull(_cursorIndexOfCn0001cx)) {
          _tmpCn0001cx = null;
        } else {
          _tmpCn0001cx = _cursor.getInt(_cursorIndexOfCn0001cx);
        }
        _item.setCn0001cx(_tmpCn0001cx);
        final Integer _tmpCn0005cx;
        if (_cursor.isNull(_cursorIndexOfCn0005cx)) {
          _tmpCn0005cx = null;
        } else {
          _tmpCn0005cx = _cursor.getInt(_cursorIndexOfCn0005cx);
        }
        _item.setCn0005cx(_tmpCn0005cx);
        final Integer _tmpCn0010cx;
        if (_cursor.isNull(_cursorIndexOfCn0010cx)) {
          _tmpCn0010cx = null;
        } else {
          _tmpCn0010cx = _cursor.getInt(_cursorIndexOfCn0010cx);
        }
        _item.setCn0010cx(_tmpCn0010cx);
        final Integer _tmpCn0025cx;
        if (_cursor.isNull(_cursorIndexOfCn0025cx)) {
          _tmpCn0025cx = null;
        } else {
          _tmpCn0025cx = _cursor.getInt(_cursorIndexOfCn0025cx);
        }
        _item.setCn0025cx(_tmpCn0025cx);
        final Integer _tmpCn0050cx;
        if (_cursor.isNull(_cursorIndexOfCn0050cx)) {
          _tmpCn0050cx = null;
        } else {
          _tmpCn0050cx = _cursor.getInt(_cursorIndexOfCn0050cx);
        }
        _item.setCn0050cx(_tmpCn0050cx);
        final Integer _tmpCn0001px;
        if (_cursor.isNull(_cursorIndexOfCn0001px)) {
          _tmpCn0001px = null;
        } else {
          _tmpCn0001px = _cursor.getInt(_cursorIndexOfCn0001px);
        }
        _item.setCn0001px(_tmpCn0001px);
        final Integer _tmpCn0005px;
        if (_cursor.isNull(_cursorIndexOfCn0005px)) {
          _tmpCn0005px = null;
        } else {
          _tmpCn0005px = _cursor.getInt(_cursorIndexOfCn0005px);
        }
        _item.setCn0005px(_tmpCn0005px);
        final Integer _tmpCn0010px;
        if (_cursor.isNull(_cursorIndexOfCn0010px)) {
          _tmpCn0010px = null;
        } else {
          _tmpCn0010px = _cursor.getInt(_cursorIndexOfCn0010px);
        }
        _item.setCn0010px(_tmpCn0010px);
        final Integer _tmpNte0020p;
        if (_cursor.isNull(_cursorIndexOfNte0020p)) {
          _tmpNte0020p = null;
        } else {
          _tmpNte0020p = _cursor.getInt(_cursorIndexOfNte0020p);
        }
        _item.setNte0020p(_tmpNte0020p);
        final Integer _tmpNte0050p;
        if (_cursor.isNull(_cursorIndexOfNte0050p)) {
          _tmpNte0050p = null;
        } else {
          _tmpNte0050p = _cursor.getInt(_cursorIndexOfNte0050p);
        }
        _item.setNte0050p(_tmpNte0050p);
        final Integer _tmpNte0100p;
        if (_cursor.isNull(_cursorIndexOfNte0100p)) {
          _tmpNte0100p = null;
        } else {
          _tmpNte0100p = _cursor.getInt(_cursorIndexOfNte0100p);
        }
        _item.setNte0100p(_tmpNte0100p);
        final Integer _tmpNte0200p;
        if (_cursor.isNull(_cursorIndexOfNte0200p)) {
          _tmpNte0200p = null;
        } else {
          _tmpNte0200p = _cursor.getInt(_cursorIndexOfNte0200p);
        }
        _item.setNte0200p(_tmpNte0200p);
        final Integer _tmpNte0500p;
        if (_cursor.isNull(_cursorIndexOfNte0500p)) {
          _tmpNte0500p = null;
        } else {
          _tmpNte0500p = _cursor.getInt(_cursorIndexOfNte0500p);
        }
        _item.setNte0500p(_tmpNte0500p);
        final Integer _tmpNte1000p;
        if (_cursor.isNull(_cursorIndexOfNte1000p)) {
          _tmpNte1000p = null;
        } else {
          _tmpNte1000p = _cursor.getInt(_cursorIndexOfNte1000p);
        }
        _item.setNte1000p(_tmpNte1000p);
        final Double _tmpPettyAmt;
        if (_cursor.isNull(_cursorIndexOfPettyAmt)) {
          _tmpPettyAmt = null;
        } else {
          _tmpPettyAmt = _cursor.getDouble(_cursorIndexOfPettyAmt);
        }
        _item.setPettyAmt(_tmpPettyAmt);
        final String _tmpORNoxxxx;
        if (_cursor.isNull(_cursorIndexOfORNoxxxx)) {
          _tmpORNoxxxx = null;
        } else {
          _tmpORNoxxxx = _cursor.getString(_cursorIndexOfORNoxxxx);
        }
        _item.setORNoxxxx(_tmpORNoxxxx);
        final String _tmpSINoxxxx;
        if (_cursor.isNull(_cursorIndexOfSINoxxxx)) {
          _tmpSINoxxxx = null;
        } else {
          _tmpSINoxxxx = _cursor.getString(_cursorIndexOfSINoxxxx);
        }
        _item.setSINoxxxx(_tmpSINoxxxx);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _item.setPRNoxxxx(_tmpPRNoxxxx);
        final String _tmpCRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfCRNoxxxx)) {
          _tmpCRNoxxxx = null;
        } else {
          _tmpCRNoxxxx = _cursor.getString(_cursorIndexOfCRNoxxxx);
        }
        _item.setCRNoxxxx(_tmpCRNoxxxx);
        final String _tmpORNoxNPt;
        if (_cursor.isNull(_cursorIndexOfORNoxNPt)) {
          _tmpORNoxNPt = null;
        } else {
          _tmpORNoxNPt = _cursor.getString(_cursorIndexOfORNoxNPt);
        }
        _item.setORNoxNPt(_tmpORNoxNPt);
        final String _tmpPRNoxNPt;
        if (_cursor.isNull(_cursorIndexOfPRNoxNPt)) {
          _tmpPRNoxNPt = null;
        } else {
          _tmpPRNoxNPt = _cursor.getString(_cursorIndexOfPRNoxNPt);
        }
        _item.setPRNoxNPt(_tmpPRNoxNPt);
        final String _tmpDRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfDRNoxxxx)) {
          _tmpDRNoxxxx = null;
        } else {
          _tmpDRNoxxxx = _cursor.getString(_cursorIndexOfDRNoxxxx);
        }
        _item.setDRNoxxxx(_tmpDRNoxxxx);
        final String _tmpEntryDte;
        if (_cursor.isNull(_cursorIndexOfEntryDte)) {
          _tmpEntryDte = null;
        } else {
          _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
        }
        _item.setEntryDte(_tmpEntryDte);
        final String _tmpReqstdBy;
        if (_cursor.isNull(_cursorIndexOfReqstdBy)) {
          _tmpReqstdBy = null;
        } else {
          _tmpReqstdBy = _cursor.getString(_cursorIndexOfReqstdBy);
        }
        _item.setReqstdBy(_tmpReqstdBy);
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
        final Integer _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getInt(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<DCashCount.CashCountLog>> getCashCountLog() {
    final String _sql = "SELECT a.*, b.sBranchNm FROM Cash_Count_Master a LEFT JOIN Branch_Info b ON a.sBranchCd = b.sBranchCd";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Cash_Count_Master","Branch_Info"}, false, new Callable<List<DCashCount.CashCountLog>>() {
      @Override
      public List<DCashCount.CashCountLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfSBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfDTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfNCn0001cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001cx");
          final int _cursorIndexOfNCn0005cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005cx");
          final int _cursorIndexOfNCn0010cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010cx");
          final int _cursorIndexOfNCn0025cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0025cx");
          final int _cursorIndexOfNCn0050cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0050cx");
          final int _cursorIndexOfNCn0001px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001px");
          final int _cursorIndexOfNCn0005px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005px");
          final int _cursorIndexOfNCn0010px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010px");
          final int _cursorIndexOfNNte0020p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0020p");
          final int _cursorIndexOfNNte0050p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0050p");
          final int _cursorIndexOfNNte0100p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0100p");
          final int _cursorIndexOfNNte0200p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0200p");
          final int _cursorIndexOfNNte0500p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0500p");
          final int _cursorIndexOfNNte1000p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte1000p");
          final int _cursorIndexOfSPettyAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPettyAmt");
          final int _cursorIndexOfSORNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxxxx");
          final int _cursorIndexOfSSINoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSINoxxxx");
          final int _cursorIndexOfSPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
          final int _cursorIndexOfSCRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCRNoxxxx");
          final int _cursorIndexOfSORNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxNPt");
          final int _cursorIndexOfSPRNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxNPt");
          final int _cursorIndexOfSDRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sDRNoxxxx");
          final int _cursorIndexOfDEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
          final int _cursorIndexOfSReqstdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdBy");
          final int _cursorIndexOfSRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfDModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfSSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "sSendStat");
          final int _cursorIndexOfSBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final List<DCashCount.CashCountLog> _result = new ArrayList<DCashCount.CashCountLog>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DCashCount.CashCountLog _item;
            _item = new DCashCount.CashCountLog();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchCd)) {
              _item.sBranchCd = null;
            } else {
              _item.sBranchCd = _cursor.getString(_cursorIndexOfSBranchCd);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _item.dTransact = null;
            } else {
              _item.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfNCn0001cx)) {
              _item.nCn0001cx = null;
            } else {
              _item.nCn0001cx = _cursor.getString(_cursorIndexOfNCn0001cx);
            }
            if (_cursor.isNull(_cursorIndexOfNCn0005cx)) {
              _item.nCn0005cx = null;
            } else {
              _item.nCn0005cx = _cursor.getString(_cursorIndexOfNCn0005cx);
            }
            if (_cursor.isNull(_cursorIndexOfNCn0010cx)) {
              _item.nCn0010cx = null;
            } else {
              _item.nCn0010cx = _cursor.getString(_cursorIndexOfNCn0010cx);
            }
            if (_cursor.isNull(_cursorIndexOfNCn0025cx)) {
              _item.nCn0025cx = null;
            } else {
              _item.nCn0025cx = _cursor.getString(_cursorIndexOfNCn0025cx);
            }
            if (_cursor.isNull(_cursorIndexOfNCn0050cx)) {
              _item.nCn0050cx = null;
            } else {
              _item.nCn0050cx = _cursor.getString(_cursorIndexOfNCn0050cx);
            }
            if (_cursor.isNull(_cursorIndexOfNCn0001px)) {
              _item.nCn0001px = null;
            } else {
              _item.nCn0001px = _cursor.getString(_cursorIndexOfNCn0001px);
            }
            if (_cursor.isNull(_cursorIndexOfNCn0005px)) {
              _item.nCn0005px = null;
            } else {
              _item.nCn0005px = _cursor.getString(_cursorIndexOfNCn0005px);
            }
            if (_cursor.isNull(_cursorIndexOfNCn0010px)) {
              _item.nCn0010px = null;
            } else {
              _item.nCn0010px = _cursor.getString(_cursorIndexOfNCn0010px);
            }
            if (_cursor.isNull(_cursorIndexOfNNte0020p)) {
              _item.nNte0020p = null;
            } else {
              _item.nNte0020p = _cursor.getString(_cursorIndexOfNNte0020p);
            }
            if (_cursor.isNull(_cursorIndexOfNNte0050p)) {
              _item.nNte0050p = null;
            } else {
              _item.nNte0050p = _cursor.getString(_cursorIndexOfNNte0050p);
            }
            if (_cursor.isNull(_cursorIndexOfNNte0100p)) {
              _item.nNte0100p = null;
            } else {
              _item.nNte0100p = _cursor.getString(_cursorIndexOfNNte0100p);
            }
            if (_cursor.isNull(_cursorIndexOfNNte0200p)) {
              _item.nNte0200p = null;
            } else {
              _item.nNte0200p = _cursor.getString(_cursorIndexOfNNte0200p);
            }
            if (_cursor.isNull(_cursorIndexOfNNte0500p)) {
              _item.nNte0500p = null;
            } else {
              _item.nNte0500p = _cursor.getString(_cursorIndexOfNNte0500p);
            }
            if (_cursor.isNull(_cursorIndexOfNNte1000p)) {
              _item.nNte1000p = null;
            } else {
              _item.nNte1000p = _cursor.getString(_cursorIndexOfNNte1000p);
            }
            if (_cursor.isNull(_cursorIndexOfSPettyAmt)) {
              _item.sPettyAmt = null;
            } else {
              _item.sPettyAmt = _cursor.getString(_cursorIndexOfSPettyAmt);
            }
            if (_cursor.isNull(_cursorIndexOfSORNoxxxx)) {
              _item.sORNoxxxx = null;
            } else {
              _item.sORNoxxxx = _cursor.getString(_cursorIndexOfSORNoxxxx);
            }
            if (_cursor.isNull(_cursorIndexOfSSINoxxxx)) {
              _item.sSINoxxxx = null;
            } else {
              _item.sSINoxxxx = _cursor.getString(_cursorIndexOfSSINoxxxx);
            }
            if (_cursor.isNull(_cursorIndexOfSPRNoxxxx)) {
              _item.sPRNoxxxx = null;
            } else {
              _item.sPRNoxxxx = _cursor.getString(_cursorIndexOfSPRNoxxxx);
            }
            if (_cursor.isNull(_cursorIndexOfSCRNoxxxx)) {
              _item.sCRNoxxxx = null;
            } else {
              _item.sCRNoxxxx = _cursor.getString(_cursorIndexOfSCRNoxxxx);
            }
            if (_cursor.isNull(_cursorIndexOfSORNoxNPt)) {
              _item.sORNoxNPt = null;
            } else {
              _item.sORNoxNPt = _cursor.getString(_cursorIndexOfSORNoxNPt);
            }
            if (_cursor.isNull(_cursorIndexOfSPRNoxNPt)) {
              _item.sPRNoxNPt = null;
            } else {
              _item.sPRNoxNPt = _cursor.getString(_cursorIndexOfSPRNoxNPt);
            }
            if (_cursor.isNull(_cursorIndexOfSDRNoxxxx)) {
              _item.sDRNoxxxx = null;
            } else {
              _item.sDRNoxxxx = _cursor.getString(_cursorIndexOfSDRNoxxxx);
            }
            if (_cursor.isNull(_cursorIndexOfDEntryDte)) {
              _item.dEntryDte = null;
            } else {
              _item.dEntryDte = _cursor.getString(_cursorIndexOfDEntryDte);
            }
            if (_cursor.isNull(_cursorIndexOfSReqstdBy)) {
              _item.sReqstdBy = null;
            } else {
              _item.sReqstdBy = _cursor.getString(_cursorIndexOfSReqstdBy);
            }
            if (_cursor.isNull(_cursorIndexOfSRemarksx)) {
              _item.sRemarksx = null;
            } else {
              _item.sRemarksx = _cursor.getString(_cursorIndexOfSRemarksx);
            }
            if (_cursor.isNull(_cursorIndexOfDModified)) {
              _item.dModified = null;
            } else {
              _item.dModified = _cursor.getString(_cursorIndexOfDModified);
            }
            if (_cursor.isNull(_cursorIndexOfSSendStat)) {
              _item.sSendStat = null;
            } else {
              _item.sSendStat = _cursor.getString(_cursorIndexOfSSendStat);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
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
  public ECashCount GetCashCountForBranch(final String BranchCd, final String Transact) {
    final String _sql = "SELECT * FROM Cash_Count_Master WHERE sBranchCd =? AND dTransact=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
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
      final int _cursorIndexOfCn0001cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001cx");
      final int _cursorIndexOfCn0005cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005cx");
      final int _cursorIndexOfCn0010cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010cx");
      final int _cursorIndexOfCn0025cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0025cx");
      final int _cursorIndexOfCn0050cx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0050cx");
      final int _cursorIndexOfCn0001px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0001px");
      final int _cursorIndexOfCn0005px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0005px");
      final int _cursorIndexOfCn0010px = CursorUtil.getColumnIndexOrThrow(_cursor, "nCn0010px");
      final int _cursorIndexOfNte0020p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0020p");
      final int _cursorIndexOfNte0050p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0050p");
      final int _cursorIndexOfNte0100p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0100p");
      final int _cursorIndexOfNte0200p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0200p");
      final int _cursorIndexOfNte0500p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte0500p");
      final int _cursorIndexOfNte1000p = CursorUtil.getColumnIndexOrThrow(_cursor, "nNte1000p");
      final int _cursorIndexOfPettyAmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPettyAmt");
      final int _cursorIndexOfORNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxxxx");
      final int _cursorIndexOfSINoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSINoxxxx");
      final int _cursorIndexOfPRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxxxx");
      final int _cursorIndexOfCRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCRNoxxxx");
      final int _cursorIndexOfORNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sORNoxNPt");
      final int _cursorIndexOfPRNoxNPt = CursorUtil.getColumnIndexOrThrow(_cursor, "sPRNoxNPt");
      final int _cursorIndexOfDRNoxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sDRNoxxxx");
      final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
      final int _cursorIndexOfReqstdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdBy");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "sSendStat");
      final ECashCount _result;
      if(_cursor.moveToFirst()) {
        _result = new ECashCount();
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
        final Integer _tmpCn0001cx;
        if (_cursor.isNull(_cursorIndexOfCn0001cx)) {
          _tmpCn0001cx = null;
        } else {
          _tmpCn0001cx = _cursor.getInt(_cursorIndexOfCn0001cx);
        }
        _result.setCn0001cx(_tmpCn0001cx);
        final Integer _tmpCn0005cx;
        if (_cursor.isNull(_cursorIndexOfCn0005cx)) {
          _tmpCn0005cx = null;
        } else {
          _tmpCn0005cx = _cursor.getInt(_cursorIndexOfCn0005cx);
        }
        _result.setCn0005cx(_tmpCn0005cx);
        final Integer _tmpCn0010cx;
        if (_cursor.isNull(_cursorIndexOfCn0010cx)) {
          _tmpCn0010cx = null;
        } else {
          _tmpCn0010cx = _cursor.getInt(_cursorIndexOfCn0010cx);
        }
        _result.setCn0010cx(_tmpCn0010cx);
        final Integer _tmpCn0025cx;
        if (_cursor.isNull(_cursorIndexOfCn0025cx)) {
          _tmpCn0025cx = null;
        } else {
          _tmpCn0025cx = _cursor.getInt(_cursorIndexOfCn0025cx);
        }
        _result.setCn0025cx(_tmpCn0025cx);
        final Integer _tmpCn0050cx;
        if (_cursor.isNull(_cursorIndexOfCn0050cx)) {
          _tmpCn0050cx = null;
        } else {
          _tmpCn0050cx = _cursor.getInt(_cursorIndexOfCn0050cx);
        }
        _result.setCn0050cx(_tmpCn0050cx);
        final Integer _tmpCn0001px;
        if (_cursor.isNull(_cursorIndexOfCn0001px)) {
          _tmpCn0001px = null;
        } else {
          _tmpCn0001px = _cursor.getInt(_cursorIndexOfCn0001px);
        }
        _result.setCn0001px(_tmpCn0001px);
        final Integer _tmpCn0005px;
        if (_cursor.isNull(_cursorIndexOfCn0005px)) {
          _tmpCn0005px = null;
        } else {
          _tmpCn0005px = _cursor.getInt(_cursorIndexOfCn0005px);
        }
        _result.setCn0005px(_tmpCn0005px);
        final Integer _tmpCn0010px;
        if (_cursor.isNull(_cursorIndexOfCn0010px)) {
          _tmpCn0010px = null;
        } else {
          _tmpCn0010px = _cursor.getInt(_cursorIndexOfCn0010px);
        }
        _result.setCn0010px(_tmpCn0010px);
        final Integer _tmpNte0020p;
        if (_cursor.isNull(_cursorIndexOfNte0020p)) {
          _tmpNte0020p = null;
        } else {
          _tmpNte0020p = _cursor.getInt(_cursorIndexOfNte0020p);
        }
        _result.setNte0020p(_tmpNte0020p);
        final Integer _tmpNte0050p;
        if (_cursor.isNull(_cursorIndexOfNte0050p)) {
          _tmpNte0050p = null;
        } else {
          _tmpNte0050p = _cursor.getInt(_cursorIndexOfNte0050p);
        }
        _result.setNte0050p(_tmpNte0050p);
        final Integer _tmpNte0100p;
        if (_cursor.isNull(_cursorIndexOfNte0100p)) {
          _tmpNte0100p = null;
        } else {
          _tmpNte0100p = _cursor.getInt(_cursorIndexOfNte0100p);
        }
        _result.setNte0100p(_tmpNte0100p);
        final Integer _tmpNte0200p;
        if (_cursor.isNull(_cursorIndexOfNte0200p)) {
          _tmpNte0200p = null;
        } else {
          _tmpNte0200p = _cursor.getInt(_cursorIndexOfNte0200p);
        }
        _result.setNte0200p(_tmpNte0200p);
        final Integer _tmpNte0500p;
        if (_cursor.isNull(_cursorIndexOfNte0500p)) {
          _tmpNte0500p = null;
        } else {
          _tmpNte0500p = _cursor.getInt(_cursorIndexOfNte0500p);
        }
        _result.setNte0500p(_tmpNte0500p);
        final Integer _tmpNte1000p;
        if (_cursor.isNull(_cursorIndexOfNte1000p)) {
          _tmpNte1000p = null;
        } else {
          _tmpNte1000p = _cursor.getInt(_cursorIndexOfNte1000p);
        }
        _result.setNte1000p(_tmpNte1000p);
        final Double _tmpPettyAmt;
        if (_cursor.isNull(_cursorIndexOfPettyAmt)) {
          _tmpPettyAmt = null;
        } else {
          _tmpPettyAmt = _cursor.getDouble(_cursorIndexOfPettyAmt);
        }
        _result.setPettyAmt(_tmpPettyAmt);
        final String _tmpORNoxxxx;
        if (_cursor.isNull(_cursorIndexOfORNoxxxx)) {
          _tmpORNoxxxx = null;
        } else {
          _tmpORNoxxxx = _cursor.getString(_cursorIndexOfORNoxxxx);
        }
        _result.setORNoxxxx(_tmpORNoxxxx);
        final String _tmpSINoxxxx;
        if (_cursor.isNull(_cursorIndexOfSINoxxxx)) {
          _tmpSINoxxxx = null;
        } else {
          _tmpSINoxxxx = _cursor.getString(_cursorIndexOfSINoxxxx);
        }
        _result.setSINoxxxx(_tmpSINoxxxx);
        final String _tmpPRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfPRNoxxxx)) {
          _tmpPRNoxxxx = null;
        } else {
          _tmpPRNoxxxx = _cursor.getString(_cursorIndexOfPRNoxxxx);
        }
        _result.setPRNoxxxx(_tmpPRNoxxxx);
        final String _tmpCRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfCRNoxxxx)) {
          _tmpCRNoxxxx = null;
        } else {
          _tmpCRNoxxxx = _cursor.getString(_cursorIndexOfCRNoxxxx);
        }
        _result.setCRNoxxxx(_tmpCRNoxxxx);
        final String _tmpORNoxNPt;
        if (_cursor.isNull(_cursorIndexOfORNoxNPt)) {
          _tmpORNoxNPt = null;
        } else {
          _tmpORNoxNPt = _cursor.getString(_cursorIndexOfORNoxNPt);
        }
        _result.setORNoxNPt(_tmpORNoxNPt);
        final String _tmpPRNoxNPt;
        if (_cursor.isNull(_cursorIndexOfPRNoxNPt)) {
          _tmpPRNoxNPt = null;
        } else {
          _tmpPRNoxNPt = _cursor.getString(_cursorIndexOfPRNoxNPt);
        }
        _result.setPRNoxNPt(_tmpPRNoxNPt);
        final String _tmpDRNoxxxx;
        if (_cursor.isNull(_cursorIndexOfDRNoxxxx)) {
          _tmpDRNoxxxx = null;
        } else {
          _tmpDRNoxxxx = _cursor.getString(_cursorIndexOfDRNoxxxx);
        }
        _result.setDRNoxxxx(_tmpDRNoxxxx);
        final String _tmpEntryDte;
        if (_cursor.isNull(_cursorIndexOfEntryDte)) {
          _tmpEntryDte = null;
        } else {
          _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
        }
        _result.setEntryDte(_tmpEntryDte);
        final String _tmpReqstdBy;
        if (_cursor.isNull(_cursorIndexOfReqstdBy)) {
          _tmpReqstdBy = null;
        } else {
          _tmpReqstdBy = _cursor.getString(_cursorIndexOfReqstdBy);
        }
        _result.setReqstdBy(_tmpReqstdBy);
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
        final Integer _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getInt(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
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
  public String GetBranchAreaCode(final String BranchCd) {
    final String _sql = "SELECT sAreaCode FROM Branch_Info WHERE sBranchCd =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
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
  public String GetUserAreaCode() {
    final String _sql = "SELECT sAreaCode FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)";
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
  public int GetEmployeeLevel() {
    final String _sql = "SELECT sEmpLevID FROM User_Info_Master";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
