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
import org.rmj.g3appdriver.GCircle.room.Entities.EPacitaEvaluation;
import org.rmj.g3appdriver.GCircle.room.Entities.EPacitaRule;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DPacita_Impl implements DPacita {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EPacitaRule> __insertionAdapterOfEPacitaRule;

  private final EntityInsertionAdapter<EPacitaEvaluation> __insertionAdapterOfEPacitaEvaluation;

  private final EntityDeletionOrUpdateAdapter<EPacitaRule> __updateAdapterOfEPacitaRule;

  private final EntityDeletionOrUpdateAdapter<EPacitaEvaluation> __updateAdapterOfEPacitaEvaluation;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePosted;

  private final SharedSQLiteStatement __preparedStmtOfResetPacitaRewardForBranch;

  public DPacita_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEPacitaRule = new EntityInsertionAdapter<EPacitaRule>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Pacita_Rule` (`nEntryNox`,`sFieldNmx`,`nMaxValue`,`cParentxx`,`cRecdStat`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPacitaRule value) {
        if (value.getEntryNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getEntryNox());
        }
        if (value.getFieldNmx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFieldNmx());
        }
        if (value.getMaxValue() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getMaxValue());
        }
        if (value.getParentxx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getParentxx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRecdStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfEPacitaEvaluation = new EntityInsertionAdapter<EPacitaEvaluation>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Pacita_Evaluation` (`sTransNox`,`dTransact`,`sUserIDxx`,`sBranchCD`,`sPayloadx`,`nRatingxx`,`sEvalType`,`cTranStat`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPacitaEvaluation value) {
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
        if (value.getUserIDxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserIDxx());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBranchCD());
        }
        if (value.getPayloadx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPayloadx());
        }
        if (value.getRatingxx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getRatingxx());
        }
        if (value.getEvalType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEvalType());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTranStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEPacitaRule = new EntityDeletionOrUpdateAdapter<EPacitaRule>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Pacita_Rule` SET `nEntryNox` = ?,`sFieldNmx` = ?,`nMaxValue` = ?,`cParentxx` = ?,`cRecdStat` = ?,`dModified` = ?,`dTimeStmp` = ? WHERE `nEntryNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPacitaRule value) {
        if (value.getEntryNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getEntryNox());
        }
        if (value.getFieldNmx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFieldNmx());
        }
        if (value.getMaxValue() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindDouble(3, value.getMaxValue());
        }
        if (value.getParentxx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getParentxx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRecdStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStmp());
        }
        if (value.getEntryNox() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, value.getEntryNox());
        }
      }
    };
    this.__updateAdapterOfEPacitaEvaluation = new EntityDeletionOrUpdateAdapter<EPacitaEvaluation>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Pacita_Evaluation` SET `sTransNox` = ?,`dTransact` = ?,`sUserIDxx` = ?,`sBranchCD` = ?,`sPayloadx` = ?,`nRatingxx` = ?,`sEvalType` = ?,`cTranStat` = ?,`dModified` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPacitaEvaluation value) {
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
        if (value.getUserIDxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserIDxx());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBranchCD());
        }
        if (value.getPayloadx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPayloadx());
        }
        if (value.getRatingxx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getRatingxx());
        }
        if (value.getEvalType() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEvalType());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTranStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdatePosted = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Pacita_Evaluation SET cTranStat = 1, sTransNox =? WHERE sTransNox=?";
        return _query;
      }
    };
    this.__preparedStmtOfResetPacitaRewardForBranch = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Pacita_Evaluation WHERE sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void Save(final EPacitaRule foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEPacitaRule.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Save(final EPacitaEvaluation foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEPacitaEvaluation.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final EPacitaRule foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEPacitaRule.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final EPacitaEvaluation foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEPacitaEvaluation.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdatePosted(final String transNo, final String NextCde) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePosted.acquire();
    int _argIndex = 1;
    if (NextCde == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, NextCde);
    }
    _argIndex = 2;
    if (transNo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, transNo);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdatePosted.release(_stmt);
    }
  }

  @Override
  public void ResetPacitaRewardForBranch(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfResetPacitaRewardForBranch.acquire();
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
      __preparedStmtOfResetPacitaRewardForBranch.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EPacitaRule>> GetPacitaRules() {
    final String _sql = "SELECT * FROM Pacita_Rule";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Pacita_Rule"}, false, new Callable<List<EPacitaRule>>() {
      @Override
      public List<EPacitaRule> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfFieldNmx = CursorUtil.getColumnIndexOrThrow(_cursor, "sFieldNmx");
          final int _cursorIndexOfMaxValue = CursorUtil.getColumnIndexOrThrow(_cursor, "nMaxValue");
          final int _cursorIndexOfParentxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cParentxx");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EPacitaRule> _result = new ArrayList<EPacitaRule>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EPacitaRule _item;
            _item = new EPacitaRule();
            final Integer _tmpEntryNox;
            if (_cursor.isNull(_cursorIndexOfEntryNox)) {
              _tmpEntryNox = null;
            } else {
              _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            }
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpFieldNmx;
            if (_cursor.isNull(_cursorIndexOfFieldNmx)) {
              _tmpFieldNmx = null;
            } else {
              _tmpFieldNmx = _cursor.getString(_cursorIndexOfFieldNmx);
            }
            _item.setFieldNmx(_tmpFieldNmx);
            final Double _tmpMaxValue;
            if (_cursor.isNull(_cursorIndexOfMaxValue)) {
              _tmpMaxValue = null;
            } else {
              _tmpMaxValue = _cursor.getDouble(_cursorIndexOfMaxValue);
            }
            _item.setMaxValue(_tmpMaxValue);
            final String _tmpParentxx;
            if (_cursor.isNull(_cursorIndexOfParentxx)) {
              _tmpParentxx = null;
            } else {
              _tmpParentxx = _cursor.getString(_cursorIndexOfParentxx);
            }
            _item.setParentxx(_tmpParentxx);
            final String _tmpRecdStat;
            if (_cursor.isNull(_cursorIndexOfRecdStat)) {
              _tmpRecdStat = null;
            } else {
              _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
            }
            _item.setRecdStat(_tmpRecdStat);
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
  public String GetLatestRecordTimeStamp() {
    final String _sql = "SELECT dTimeStmp FROM Pacita_Rule ORDER BY dTimeStmp DESC LIMIT 1";
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
  public String GetDepartmentID() {
    final String _sql = "SELECT sDeptIDxx FROM User_Info_Master LIMIT 1";
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
  public LiveData<EPacitaEvaluation> GetPacitaEvaluation(final String TransNox) {
    final String _sql = "SELECT * FROM Pacita_Evaluation WHERE sTransNox=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Pacita_Evaluation"}, false, new Callable<EPacitaEvaluation>() {
      @Override
      public EPacitaEvaluation call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
          final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
          final int _cursorIndexOfPayloadx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPayloadx");
          final int _cursorIndexOfRatingxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRatingxx");
          final int _cursorIndexOfEvalType = CursorUtil.getColumnIndexOrThrow(_cursor, "sEvalType");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final EPacitaEvaluation _result;
          if(_cursor.moveToFirst()) {
            _result = new EPacitaEvaluation();
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
            final String _tmpUserIDxx;
            if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
              _tmpUserIDxx = null;
            } else {
              _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
            }
            _result.setUserIDxx(_tmpUserIDxx);
            final String _tmpBranchCD;
            if (_cursor.isNull(_cursorIndexOfBranchCD)) {
              _tmpBranchCD = null;
            } else {
              _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
            }
            _result.setBranchCD(_tmpBranchCD);
            final String _tmpPayloadx;
            if (_cursor.isNull(_cursorIndexOfPayloadx)) {
              _tmpPayloadx = null;
            } else {
              _tmpPayloadx = _cursor.getString(_cursorIndexOfPayloadx);
            }
            _result.setPayloadx(_tmpPayloadx);
            final Double _tmpRatingxx;
            if (_cursor.isNull(_cursorIndexOfRatingxx)) {
              _tmpRatingxx = null;
            } else {
              _tmpRatingxx = _cursor.getDouble(_cursorIndexOfRatingxx);
            }
            _result.setRatingxx(_tmpRatingxx);
            final String _tmpEvalType;
            if (_cursor.isNull(_cursorIndexOfEvalType)) {
              _tmpEvalType = null;
            } else {
              _tmpEvalType = _cursor.getString(_cursorIndexOfEvalType);
            }
            _result.setEvalType(_tmpEvalType);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
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
  public EPacitaRule GetPacitaRule(final int entryNox) {
    final String _sql = "SELECT * FROM Pacita_Rule WHERE nEntryNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, entryNox);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfFieldNmx = CursorUtil.getColumnIndexOrThrow(_cursor, "sFieldNmx");
      final int _cursorIndexOfMaxValue = CursorUtil.getColumnIndexOrThrow(_cursor, "nMaxValue");
      final int _cursorIndexOfParentxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cParentxx");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EPacitaRule _result;
      if(_cursor.moveToFirst()) {
        _result = new EPacitaRule();
        final Integer _tmpEntryNox;
        if (_cursor.isNull(_cursorIndexOfEntryNox)) {
          _tmpEntryNox = null;
        } else {
          _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        }
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpFieldNmx;
        if (_cursor.isNull(_cursorIndexOfFieldNmx)) {
          _tmpFieldNmx = null;
        } else {
          _tmpFieldNmx = _cursor.getString(_cursorIndexOfFieldNmx);
        }
        _result.setFieldNmx(_tmpFieldNmx);
        final Double _tmpMaxValue;
        if (_cursor.isNull(_cursorIndexOfMaxValue)) {
          _tmpMaxValue = null;
        } else {
          _tmpMaxValue = _cursor.getDouble(_cursorIndexOfMaxValue);
        }
        _result.setMaxValue(_tmpMaxValue);
        final String _tmpParentxx;
        if (_cursor.isNull(_cursorIndexOfParentxx)) {
          _tmpParentxx = null;
        } else {
          _tmpParentxx = _cursor.getString(_cursorIndexOfParentxx);
        }
        _result.setParentxx(_tmpParentxx);
        final String _tmpRecdStat;
        if (_cursor.isNull(_cursorIndexOfRecdStat)) {
          _tmpRecdStat = null;
        } else {
          _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
        }
        _result.setRecdStat(_tmpRecdStat);
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
  public EPacitaEvaluation GetEvaluationForPosting(final String args) {
    final String _sql = "SELECT * FROM Pacita_Evaluation WHERE sTransNox=?";
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
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
      final int _cursorIndexOfPayloadx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPayloadx");
      final int _cursorIndexOfRatingxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRatingxx");
      final int _cursorIndexOfEvalType = CursorUtil.getColumnIndexOrThrow(_cursor, "sEvalType");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EPacitaEvaluation _result;
      if(_cursor.moveToFirst()) {
        _result = new EPacitaEvaluation();
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
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpBranchCD;
        if (_cursor.isNull(_cursorIndexOfBranchCD)) {
          _tmpBranchCD = null;
        } else {
          _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
        }
        _result.setBranchCD(_tmpBranchCD);
        final String _tmpPayloadx;
        if (_cursor.isNull(_cursorIndexOfPayloadx)) {
          _tmpPayloadx = null;
        } else {
          _tmpPayloadx = _cursor.getString(_cursorIndexOfPayloadx);
        }
        _result.setPayloadx(_tmpPayloadx);
        final Double _tmpRatingxx;
        if (_cursor.isNull(_cursorIndexOfRatingxx)) {
          _tmpRatingxx = null;
        } else {
          _tmpRatingxx = _cursor.getDouble(_cursorIndexOfRatingxx);
        }
        _result.setRatingxx(_tmpRatingxx);
        final String _tmpEvalType;
        if (_cursor.isNull(_cursorIndexOfEvalType)) {
          _tmpEvalType = null;
        } else {
          _tmpEvalType = _cursor.getString(_cursorIndexOfEvalType);
        }
        _result.setEvalType(_tmpEvalType);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
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
  public EPacitaEvaluation CheckEvaulationRecord(final String args) {
    final String _sql = "SELECT * FROM Pacita_Evaluation WHERE sTransNox=?";
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
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
      final int _cursorIndexOfPayloadx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPayloadx");
      final int _cursorIndexOfRatingxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRatingxx");
      final int _cursorIndexOfEvalType = CursorUtil.getColumnIndexOrThrow(_cursor, "sEvalType");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EPacitaEvaluation _result;
      if(_cursor.moveToFirst()) {
        _result = new EPacitaEvaluation();
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
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpBranchCD;
        if (_cursor.isNull(_cursorIndexOfBranchCD)) {
          _tmpBranchCD = null;
        } else {
          _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
        }
        _result.setBranchCD(_tmpBranchCD);
        final String _tmpPayloadx;
        if (_cursor.isNull(_cursorIndexOfPayloadx)) {
          _tmpPayloadx = null;
        } else {
          _tmpPayloadx = _cursor.getString(_cursorIndexOfPayloadx);
        }
        _result.setPayloadx(_tmpPayloadx);
        final Double _tmpRatingxx;
        if (_cursor.isNull(_cursorIndexOfRatingxx)) {
          _tmpRatingxx = null;
        } else {
          _tmpRatingxx = _cursor.getDouble(_cursorIndexOfRatingxx);
        }
        _result.setRatingxx(_tmpRatingxx);
        final String _tmpEvalType;
        if (_cursor.isNull(_cursorIndexOfEvalType)) {
          _tmpEvalType = null;
        } else {
          _tmpEvalType = _cursor.getString(_cursorIndexOfEvalType);
        }
        _result.setEvalType(_tmpEvalType);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
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
  public EPacitaEvaluation GetEvaluationForInitialization(final String BranchCd,
      final String dTransact) {
    final String _sql = "SELECT * FROM Pacita_Evaluation WHERE sBranchCD=? AND dTransact =? ORDER BY dTransact DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
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
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
      final int _cursorIndexOfPayloadx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPayloadx");
      final int _cursorIndexOfRatingxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRatingxx");
      final int _cursorIndexOfEvalType = CursorUtil.getColumnIndexOrThrow(_cursor, "sEvalType");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EPacitaEvaluation _result;
      if(_cursor.moveToFirst()) {
        _result = new EPacitaEvaluation();
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
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpBranchCD;
        if (_cursor.isNull(_cursorIndexOfBranchCD)) {
          _tmpBranchCD = null;
        } else {
          _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
        }
        _result.setBranchCD(_tmpBranchCD);
        final String _tmpPayloadx;
        if (_cursor.isNull(_cursorIndexOfPayloadx)) {
          _tmpPayloadx = null;
        } else {
          _tmpPayloadx = _cursor.getString(_cursorIndexOfPayloadx);
        }
        _result.setPayloadx(_tmpPayloadx);
        final Double _tmpRatingxx;
        if (_cursor.isNull(_cursorIndexOfRatingxx)) {
          _tmpRatingxx = null;
        } else {
          _tmpRatingxx = _cursor.getDouble(_cursorIndexOfRatingxx);
        }
        _result.setRatingxx(_tmpRatingxx);
        final String _tmpEvalType;
        if (_cursor.isNull(_cursorIndexOfEvalType)) {
          _tmpEvalType = null;
        } else {
          _tmpEvalType = _cursor.getString(_cursorIndexOfEvalType);
        }
        _result.setEvalType(_tmpEvalType);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
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
  public LiveData<List<EBranchInfo>> GetBranchList() {
    final String _sql = "SELECT * FROM Branch_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<List<EBranchInfo>>() {
      @Override
      public List<EBranchInfo> call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT(*) FROM Pacita_Evaluation";
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
  public List<Integer> GetPacitaRulesEntryNo() {
    final String _sql = "SELECT nEntryNox FROM Pacita_Rule";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<Integer> _result = new ArrayList<Integer>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Integer _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getInt(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String GetUserID() {
    final String _sql = "SELECT sUserIDxx FROM User_Info_Master";
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
  public LiveData<List<DPacita.BranchRecords>> GetBranchRecords(final String BranchCD) {
    final String _sql = "SELECT sTransNox, dTransact, nRatingxx FROM Pacita_Evaluation WHERE sBranchCD =? ORDER BY dTransact DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BranchCD == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCD);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Pacita_Evaluation"}, false, new Callable<List<DPacita.BranchRecords>>() {
      @Override
      public List<DPacita.BranchRecords> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfDTransact = 1;
          final int _cursorIndexOfNRatingxx = 2;
          final List<DPacita.BranchRecords> _result = new ArrayList<DPacita.BranchRecords>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DPacita.BranchRecords _item;
            _item = new DPacita.BranchRecords();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _item.dTransact = null;
            } else {
              _item.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfNRatingxx)) {
              _item.nRatingxx = null;
            } else {
              _item.nRatingxx = _cursor.getString(_cursorIndexOfNRatingxx);
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
  public LiveData<List<DPacita.RecentRecords>> GetRecentRecords() {
    final String _sql = "SELECT a.sTransNox, (SELECT sBranchCD FROM Branch_Info WHERE sBranchCd = a.sBranchCD) AS sBranchCD, (SELECT sBranchNm FROM Branch_Info WHERE sBranchCd = a.sBranchCD) AS sBranchNm, a.dTransact, a.nRatingxx FROM Pacita_Evaluation a ORDER BY a.dTransact DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info","Pacita_Evaluation"}, false, new Callable<List<DPacita.RecentRecords>>() {
      @Override
      public List<DPacita.RecentRecords> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfSBranchCD = 1;
          final int _cursorIndexOfSBranchNm = 2;
          final int _cursorIndexOfDTransact = 3;
          final int _cursorIndexOfNRatingxx = 4;
          final List<DPacita.RecentRecords> _result = new ArrayList<DPacita.RecentRecords>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DPacita.RecentRecords _item;
            _item = new DPacita.RecentRecords();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchCD)) {
              _item.sBranchCD = null;
            } else {
              _item.sBranchCD = _cursor.getString(_cursorIndexOfSBranchCD);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _item.dTransact = null;
            } else {
              _item.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfNRatingxx)) {
              _item.nRatingxx = null;
            } else {
              _item.nRatingxx = _cursor.getString(_cursorIndexOfNRatingxx);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
