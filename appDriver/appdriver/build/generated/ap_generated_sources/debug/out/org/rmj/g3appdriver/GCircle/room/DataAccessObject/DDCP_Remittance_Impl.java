package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EDCP_Remittance;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DDCP_Remittance_Impl implements DDCP_Remittance {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EDCP_Remittance> __insertionAdapterOfEDCP_Remittance;

  private final EntityDeletionOrUpdateAdapter<EDCP_Remittance> __updateAdapterOfEDCP_Remittance;

  public DDCP_Remittance_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEDCP_Remittance = new EntityInsertionAdapter<EDCP_Remittance>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `LR_DCP_Remittance` (`sTransNox`,`nEntryNox`,`dTransact`,`cPaymForm`,`cRemitTyp`,`sCompnyNm`,`sBankAcct`,`sReferNox`,`nAmountxx`,`cSendStat`,`dDateSent`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EDCP_Remittance value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getEntryNox() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getEntryNox());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getPaymForm() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPaymForm());
        }
        if (value.getRemitTyp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRemitTyp());
        }
        if (value.getCompnyNm() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCompnyNm());
        }
        if (value.getBankAcct() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBankAcct());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getReferNox());
        }
        stmt.bindDouble(9, value.getAmountxx());
        if (value.getSendStat() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSendStat());
        }
        if (value.getDateSent() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDateSent());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEDCP_Remittance = new EntityDeletionOrUpdateAdapter<EDCP_Remittance>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `LR_DCP_Remittance` SET `sTransNox` = ?,`nEntryNox` = ?,`dTransact` = ?,`cPaymForm` = ?,`cRemitTyp` = ?,`sCompnyNm` = ?,`sBankAcct` = ?,`sReferNox` = ?,`nAmountxx` = ?,`cSendStat` = ?,`dDateSent` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ? AND `nEntryNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EDCP_Remittance value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getEntryNox() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getEntryNox());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getPaymForm() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPaymForm());
        }
        if (value.getRemitTyp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRemitTyp());
        }
        if (value.getCompnyNm() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCompnyNm());
        }
        if (value.getBankAcct() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBankAcct());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getReferNox());
        }
        stmt.bindDouble(9, value.getAmountxx());
        if (value.getSendStat() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSendStat());
        }
        if (value.getDateSent() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDateSent());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getTransNox());
        }
        if (value.getEntryNox() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getEntryNox());
        }
      }
    };
  }

  @Override
  public void SaveRemittance(final EDCP_Remittance remittance) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEDCP_Remittance.insert(remittance);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final EDCP_Remittance foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEDCP_Remittance.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public String GetRowsForID() {
    final String _sql = "SELECT COUNT(*) + 1 AS nEntryNox FROM LR_DCP_Remittance";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
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
      _statement.release();
    }
  }

  @Override
  public LiveData<String> GetTotalCollection(final String fsVal) {
    final String _sql = "SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail"}, false, new Callable<String>() {
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
  public LiveData<String> GetRemittedCollection(final String fsVal) {
    final String _sql = "SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Remittance"}, false, new Callable<String>() {
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
  public LiveData<String> GetCashCollection(final String fsVal) {
    final String _sql = "SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND cPaymForm != '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail"}, false, new Callable<String>() {
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
  public LiveData<String> GetCheckCollection(final String fsVal) {
    final String _sql = "SELECT IFNULL((SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND cPaymForm = '1'), 0.00) AS nCheckClt";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail"}, false, new Callable<String>() {
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
  public LiveData<String> GetBranchRemittanceAmount(final String fsVal) {
    final String _sql = "SELECT IFNULL((SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox =? AND cRemitTyp = '0'), 0.00) AS nBrnchRmt";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Remittance"}, false, new Callable<String>() {
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
  public LiveData<String> GetBankRemittanceAmount(final String fsVal) {
    final String _sql = "SELECT IFNULL((SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox =? AND cRemitTyp = '1'), 0.00) AS nBankRmtc";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Remittance"}, false, new Callable<String>() {
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
  public LiveData<String> GetOtherRemittanceAmount(final String fsVal) {
    final String _sql = "SELECT IFNULL((SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox =? AND cRemitTyp = '2'), 0.00) AS nOtherRmt";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Remittance"}, false, new Callable<String>() {
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
  public LiveData<String> GetCashOnHand(final String fsVal) {
    final String _sql = "SELECT (SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND cPaymForm != '1') - IFNULL((SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox =? AND cPaymForm != '1'), 0.00) AS CASH_ON_HAND";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    _argIndex = 2;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","LR_DCP_Remittance"}, false, new Callable<String>() {
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
  public LiveData<String> GetCheckOnHand(final String fsVal) {
    final String _sql = "SELECT IFNULL((SELECT (SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox =? AND cPaymForm = '1') - IFNULL((SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox =? AND cPaymForm = '1'), 0.00)), 0.00) AS CASH_ON_HAND";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    _argIndex = 2;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","LR_DCP_Remittance"}, false, new Callable<String>() {
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
  public EDCP_Remittance GetCollectionRemittance(final String TransNo, final String EntryNo) {
    final String _sql = "SELECT * FROM LR_DCP_Remittance WHERE sTransNox=? AND nEntryNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (TransNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNo);
    }
    _argIndex = 2;
    if (EntryNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, EntryNo);
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
      final EDCP_Remittance _result;
      if(_cursor.moveToFirst()) {
        _result = new EDCP_Remittance();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final Integer _tmpEntryNox;
        if (_cursor.isNull(_cursorIndexOfEntryNox)) {
          _tmpEntryNox = null;
        } else {
          _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        }
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _result.setPaymForm(_tmpPaymForm);
        final String _tmpRemitTyp;
        if (_cursor.isNull(_cursorIndexOfRemitTyp)) {
          _tmpRemitTyp = null;
        } else {
          _tmpRemitTyp = _cursor.getString(_cursorIndexOfRemitTyp);
        }
        _result.setRemitTyp(_tmpRemitTyp);
        final String _tmpCompnyNm;
        if (_cursor.isNull(_cursorIndexOfCompnyNm)) {
          _tmpCompnyNm = null;
        } else {
          _tmpCompnyNm = _cursor.getString(_cursorIndexOfCompnyNm);
        }
        _result.setCompnyNm(_tmpCompnyNm);
        final String _tmpBankAcct;
        if (_cursor.isNull(_cursorIndexOfBankAcct)) {
          _tmpBankAcct = null;
        } else {
          _tmpBankAcct = _cursor.getString(_cursorIndexOfBankAcct);
        }
        _result.setBankAcct(_tmpBankAcct);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final double _tmpAmountxx;
        _tmpAmountxx = _cursor.getDouble(_cursorIndexOfAmountxx);
        _result.setAmountxx(_tmpAmountxx);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpDateSent;
        if (_cursor.isNull(_cursorIndexOfDateSent)) {
          _tmpDateSent = null;
        } else {
          _tmpDateSent = _cursor.getString(_cursorIndexOfDateSent);
        }
        _result.setDateSent(_tmpDateSent);
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
  public double ValidateRemittanceEntry(final String args) {
    final String _sql = "SELECT (SELECT SUM(nTranTotl) FROM LR_DCP_Collection_Detail WHERE sTransNox =?) - IFNULL((SELECT SUM(nAmountxx) FROM LR_DCP_Remittance WHERE sTransNox =?), 0.00) AS RMN_Collection";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
