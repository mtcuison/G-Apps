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
import org.rmj.g3appdriver.GCircle.room.Entities.EBranchPerformance;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DBranchPerformance_Impl implements DBranchPerformance {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EBranchPerformance> __insertionAdapterOfEBranchPerformance;

  private final EntityDeletionOrUpdateAdapter<EBranchPerformance> __updateAdapterOfEBranchPerformance;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllBranchPerformanceInfo;

  public DBranchPerformance_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEBranchPerformance = new EntityInsertionAdapter<EBranchPerformance>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MC_Branch_Performance` (`sBranchCd`,`sPeriodxx`,`sBranchNm`,`nMCGoalxx`,`nSPGoalxx`,`nJOGoalxx`,`nLRGoalxx`,`nMCActual`,`nSPActual`,`nJOActual`,`nLRActual`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchPerformance value) {
        if (value.getBranchCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBranchCd());
        }
        if (value.getPeriodxx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPeriodxx());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBranchNm());
        }
        stmt.bindLong(4, value.getMCGoalxx());
        stmt.bindDouble(5, value.getSPGoalxx());
        stmt.bindLong(6, value.getJOGoalxx());
        stmt.bindDouble(7, value.getLRGoalxx());
        stmt.bindLong(8, value.getMCActual());
        stmt.bindDouble(9, value.getSPActual());
        stmt.bindDouble(10, value.getJOActual());
        stmt.bindDouble(11, value.getLRActual());
      }
    };
    this.__updateAdapterOfEBranchPerformance = new EntityDeletionOrUpdateAdapter<EBranchPerformance>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MC_Branch_Performance` SET `sBranchCd` = ?,`sPeriodxx` = ?,`sBranchNm` = ?,`nMCGoalxx` = ?,`nSPGoalxx` = ?,`nJOGoalxx` = ?,`nLRGoalxx` = ?,`nMCActual` = ?,`nSPActual` = ?,`nJOActual` = ?,`nLRActual` = ? WHERE `sBranchCd` = ? AND `sPeriodxx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchPerformance value) {
        if (value.getBranchCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBranchCd());
        }
        if (value.getPeriodxx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPeriodxx());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBranchNm());
        }
        stmt.bindLong(4, value.getMCGoalxx());
        stmt.bindDouble(5, value.getSPGoalxx());
        stmt.bindLong(6, value.getJOGoalxx());
        stmt.bindDouble(7, value.getLRGoalxx());
        stmt.bindLong(8, value.getMCActual());
        stmt.bindDouble(9, value.getSPActual());
        stmt.bindDouble(10, value.getJOActual());
        stmt.bindDouble(11, value.getLRActual());
        if (value.getBranchCd() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBranchCd());
        }
        if (value.getPeriodxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPeriodxx());
        }
      }
    };
    this.__preparedStmtOfDeleteAllBranchPerformanceInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MC_Branch_Performance";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EBranchPerformance branchPerformance) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchPerformance.insert(branchPerformance);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EBranchPerformance> branchPerformances) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchPerformance.insert(branchPerformances);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EBranchPerformance branchPerformance) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEBranchPerformance.handle(branchPerformance);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllBranchPerformanceInfo() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllBranchPerformanceInfo.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllBranchPerformanceInfo.release(_stmt);
    }
  }

  @Override
  public int GetUserLevel() {
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

  @Override
  public String GetUserDepartment() {
    final String _sql = "SELECT sDeptIDxx FROM User_Info_Master";
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
  public EBranchPerformance GetBranchPerformance(final String Period, final String BranchCd) {
    final String _sql = "SELECT * FROM MC_Branch_Performance WHERE sPeriodxx =? AND sBranchCd =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (Period == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Period);
    }
    _argIndex = 2;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
      final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
      final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
      final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
      final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
      final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
      final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
      final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
      final EBranchPerformance _result;
      if(_cursor.moveToFirst()) {
        _result = new EBranchPerformance();
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpPeriodxx;
        if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
          _tmpPeriodxx = null;
        } else {
          _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
        }
        _result.setPeriodxx(_tmpPeriodxx);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final int _tmpMCGoalxx;
        _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
        _result.setMCGoalxx(_tmpMCGoalxx);
        final float _tmpSPGoalxx;
        _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
        _result.setSPGoalxx(_tmpSPGoalxx);
        final int _tmpJOGoalxx;
        _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
        _result.setJOGoalxx(_tmpJOGoalxx);
        final float _tmpLRGoalxx;
        _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
        _result.setLRGoalxx(_tmpLRGoalxx);
        final int _tmpMCActual;
        _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
        _result.setMCActual(_tmpMCActual);
        final float _tmpSPActual;
        _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
        _result.setSPActual(_tmpSPActual);
        final float _tmpJOActual;
        _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
        _result.setJOActual(_tmpJOActual);
        final float _tmpLRActual;
        _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
        _result.setLRActual(_tmpLRActual);
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
  public String GetAreaCode() {
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
  public String GetBranchCode() {
    final String _sql = "SELECT sBranchCd FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)";
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
  public LiveData<List<EBranchPerformance>> getAllBranchPerformanceInfo() {
    final String _sql = "SELECT * FROM MC_Branch_Performance";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public String getUserAreaCode() {
    final String _sql = "SELECT a.sAreaCode FROM Branch_Info a LEFT JOIN Branch_Info b ON a.sBranchCd = b.sBranchCd WHERE b.sBranchCd = (SELECT sBranchCd FROM User_Info_Master)";
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
  public LiveData<List<EBranchPerformance>> getBranchPerformanceForDashBoard() {
    final String _sql = "SELECT * FROM MC_Branch_Performance GROUP BY sBranchCd ORDER BY nSPActual DESC, nMCActual DESC LIMIT 3";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public LiveData<List<EBranchPerformance>> getMCSalesBranchPerformanceASC() {
    final String _sql = "SELECT * FROM MC_Branch_Performance ORDER BY ROUND(nMCActual * 100.0 / 100, 1) ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public LiveData<List<EBranchPerformance>> getMCSalesBranchPerformanceDESC() {
    final String _sql = "SELECT * FROM MC_Branch_Performance ORDER BY ROUND(nMCActual * 100.0 / 100, 1) DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public LiveData<List<EBranchPerformance>> getSPSalesBranchPerformanceASC() {
    final String _sql = "SELECT * FROM MC_Branch_Performance ORDER BY ROUND(nSPActual * 100.0 / 100, 1) ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public LiveData<List<EBranchPerformance>> getSPSalesBranchPerformanceDESC() {
    final String _sql = "SELECT * FROM MC_Branch_Performance ORDER BY ROUND(nSPActual * 100.0 / 100, 1) DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public LiveData<List<EBranchPerformance>> getJOBranchPerformanceASC() {
    final String _sql = "SELECT * FROM MC_Branch_Performance ORDER BY ROUND(nJOGoalxx * 100.0 / 100, 1) ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public LiveData<List<EBranchPerformance>> getJOBranchPerformanceDESC() {
    final String _sql = "SELECT * FROM MC_Branch_Performance ORDER BY ROUND(nJOGoalxx * 100.0 / 100, 1) DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public LiveData<List<EBranchPerformance>> getAllBranchPerformanceInfoByBranch(
      final String BranchCd) {
    final String _sql = "SELECT * FROM MC_Branch_Performance WHERE sBranchCd =? ORDER BY sPeriodxx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public LiveData<List<EBranchPerformance>> getAreaBranchesMCSalesPerformance(
      final String fsPeriodx) {
    final String _sql = "SELECT * FROM MC_Branch_Performance WHERE sPeriodxx= ? ORDER BY nMCActual DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsPeriodx == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsPeriodx);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public LiveData<List<EBranchPerformance>> getAreaBranchesSPSalesPerformance(
      final String fsPeriodx) {
    final String _sql = "SELECT * FROM MC_Branch_Performance WHERE sPeriodxx= ? ORDER BY nSPActual DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsPeriodx == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsPeriodx);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<EBranchPerformance>>() {
      @Override
      public List<EBranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EBranchPerformance> _result = new ArrayList<EBranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchPerformance _item;
            _item = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _item.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _item.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _item.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _item.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _item.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _item.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _item.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _item.setLRActual(_tmpLRActual);
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
  public LiveData<DBranchPerformance.ActualGoal> getMCBranchPerformance() {
    final String _sql = "SELECT nMCActual AS Actual, ROUND (nMCActual * 100.0 / nMCGoalxx) AS Percentage, nMCGoalxx AS Goal FROM MC_Branch_Performance WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance","User_Info_Master"}, false, new Callable<DBranchPerformance.ActualGoal>() {
      @Override
      public DBranchPerformance.ActualGoal call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfActual = 0;
          final int _cursorIndexOfPercentage = 1;
          final int _cursorIndexOfGoal = 2;
          final DBranchPerformance.ActualGoal _result;
          if(_cursor.moveToFirst()) {
            _result = new DBranchPerformance.ActualGoal();
            if (_cursor.isNull(_cursorIndexOfActual)) {
              _result.Actual = null;
            } else {
              _result.Actual = _cursor.getString(_cursorIndexOfActual);
            }
            if (_cursor.isNull(_cursorIndexOfPercentage)) {
              _result.Percentage = null;
            } else {
              _result.Percentage = _cursor.getString(_cursorIndexOfPercentage);
            }
            if (_cursor.isNull(_cursorIndexOfGoal)) {
              _result.Goal = null;
            } else {
              _result.Goal = _cursor.getString(_cursorIndexOfGoal);
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

  @Override
  public LiveData<DBranchPerformance.ActualGoal> getSPBranchPerformance() {
    final String _sql = "SELECT nSPActual AS Actual, ROUND (nSPActual * 100.0 / nSPGoalxx) AS Percentage, nSPGoalxx AS Goal FROM MC_Branch_Performance WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance","User_Info_Master"}, false, new Callable<DBranchPerformance.ActualGoal>() {
      @Override
      public DBranchPerformance.ActualGoal call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfActual = 0;
          final int _cursorIndexOfPercentage = 1;
          final int _cursorIndexOfGoal = 2;
          final DBranchPerformance.ActualGoal _result;
          if(_cursor.moveToFirst()) {
            _result = new DBranchPerformance.ActualGoal();
            if (_cursor.isNull(_cursorIndexOfActual)) {
              _result.Actual = null;
            } else {
              _result.Actual = _cursor.getString(_cursorIndexOfActual);
            }
            if (_cursor.isNull(_cursorIndexOfPercentage)) {
              _result.Percentage = null;
            } else {
              _result.Percentage = _cursor.getString(_cursorIndexOfPercentage);
            }
            if (_cursor.isNull(_cursorIndexOfGoal)) {
              _result.Goal = null;
            } else {
              _result.Goal = _cursor.getString(_cursorIndexOfGoal);
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

  @Override
  public LiveData<EBranchPerformance> getCurrentPeriodPerformance() {
    final String _sql = "SELECT * FROM MC_Branch_Performance ORDER BY sPeriodxx DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<EBranchPerformance>() {
      @Override
      public EBranchPerformance call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final EBranchPerformance _result;
          if(_cursor.moveToFirst()) {
            _result = new EBranchPerformance();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _result.setPeriodxx(_tmpPeriodxx);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final int _tmpMCGoalxx;
            _tmpMCGoalxx = _cursor.getInt(_cursorIndexOfMCGoalxx);
            _result.setMCGoalxx(_tmpMCGoalxx);
            final float _tmpSPGoalxx;
            _tmpSPGoalxx = _cursor.getFloat(_cursorIndexOfSPGoalxx);
            _result.setSPGoalxx(_tmpSPGoalxx);
            final int _tmpJOGoalxx;
            _tmpJOGoalxx = _cursor.getInt(_cursorIndexOfJOGoalxx);
            _result.setJOGoalxx(_tmpJOGoalxx);
            final float _tmpLRGoalxx;
            _tmpLRGoalxx = _cursor.getFloat(_cursorIndexOfLRGoalxx);
            _result.setLRGoalxx(_tmpLRGoalxx);
            final int _tmpMCActual;
            _tmpMCActual = _cursor.getInt(_cursorIndexOfMCActual);
            _result.setMCActual(_tmpMCActual);
            final float _tmpSPActual;
            _tmpSPActual = _cursor.getFloat(_cursorIndexOfSPActual);
            _result.setSPActual(_tmpSPActual);
            final float _tmpJOActual;
            _tmpJOActual = _cursor.getFloat(_cursorIndexOfJOActual);
            _result.setJOActual(_tmpJOActual);
            final float _tmpLRActual;
            _tmpLRActual = _cursor.getFloat(_cursorIndexOfLRActual);
            _result.setLRActual(_tmpLRActual);
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
  public LiveData<List<DBranchPerformance.PeriodicalPerformance>> getMCBranchPeriodicalPerformance(
      ) {
    final String _sql = "SELECT sPeriodxx AS Period, nMCActual AS Actual, nMCGoalxx AS Goal FROM MC_Branch_Performance WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master) ORDER BY sPeriodxx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance","User_Info_Master"}, false, new Callable<List<DBranchPerformance.PeriodicalPerformance>>() {
      @Override
      public List<DBranchPerformance.PeriodicalPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPeriod = 0;
          final int _cursorIndexOfActual = 1;
          final int _cursorIndexOfGoal = 2;
          final List<DBranchPerformance.PeriodicalPerformance> _result = new ArrayList<DBranchPerformance.PeriodicalPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DBranchPerformance.PeriodicalPerformance _item;
            _item = new DBranchPerformance.PeriodicalPerformance();
            if (_cursor.isNull(_cursorIndexOfPeriod)) {
              _item.Period = null;
            } else {
              _item.Period = _cursor.getString(_cursorIndexOfPeriod);
            }
            if (_cursor.isNull(_cursorIndexOfActual)) {
              _item.Actual = null;
            } else {
              _item.Actual = _cursor.getString(_cursorIndexOfActual);
            }
            if (_cursor.isNull(_cursorIndexOfGoal)) {
              _item.Goal = null;
            } else {
              _item.Goal = _cursor.getString(_cursorIndexOfGoal);
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
  public LiveData<List<DBranchPerformance.PeriodicalPerformance>> getSPBranchPeriodicalPerformance(
      ) {
    final String _sql = "SELECT sPeriodxx AS Period, nSPActual AS Actual, nSPGoalxx AS Goal FROM MC_Branch_Performance WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master) ORDER BY sPeriodxx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance","User_Info_Master"}, false, new Callable<List<DBranchPerformance.PeriodicalPerformance>>() {
      @Override
      public List<DBranchPerformance.PeriodicalPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPeriod = 0;
          final int _cursorIndexOfActual = 1;
          final int _cursorIndexOfGoal = 2;
          final List<DBranchPerformance.PeriodicalPerformance> _result = new ArrayList<DBranchPerformance.PeriodicalPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DBranchPerformance.PeriodicalPerformance _item;
            _item = new DBranchPerformance.PeriodicalPerformance();
            if (_cursor.isNull(_cursorIndexOfPeriod)) {
              _item.Period = null;
            } else {
              _item.Period = _cursor.getString(_cursorIndexOfPeriod);
            }
            if (_cursor.isNull(_cursorIndexOfActual)) {
              _item.Actual = null;
            } else {
              _item.Actual = _cursor.getString(_cursorIndexOfActual);
            }
            if (_cursor.isNull(_cursorIndexOfGoal)) {
              _item.Goal = null;
            } else {
              _item.Goal = _cursor.getString(_cursorIndexOfGoal);
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
  public LiveData<List<DBranchPerformance.PeriodicalPerformance>> GetMCSalesPeriodicPerformance(
      final String BranchCd) {
    final String _sql = "SELECT sPeriodxx AS Period, nMCActual AS Actual, nMCGoalxx AS Goal FROM MC_Branch_Performance WHERE sBranchCd =? ORDER BY sPeriodxx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<DBranchPerformance.PeriodicalPerformance>>() {
      @Override
      public List<DBranchPerformance.PeriodicalPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPeriod = 0;
          final int _cursorIndexOfActual = 1;
          final int _cursorIndexOfGoal = 2;
          final List<DBranchPerformance.PeriodicalPerformance> _result = new ArrayList<DBranchPerformance.PeriodicalPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DBranchPerformance.PeriodicalPerformance _item;
            _item = new DBranchPerformance.PeriodicalPerformance();
            if (_cursor.isNull(_cursorIndexOfPeriod)) {
              _item.Period = null;
            } else {
              _item.Period = _cursor.getString(_cursorIndexOfPeriod);
            }
            if (_cursor.isNull(_cursorIndexOfActual)) {
              _item.Actual = null;
            } else {
              _item.Actual = _cursor.getString(_cursorIndexOfActual);
            }
            if (_cursor.isNull(_cursorIndexOfGoal)) {
              _item.Goal = null;
            } else {
              _item.Goal = _cursor.getString(_cursorIndexOfGoal);
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
  public LiveData<List<DBranchPerformance.PeriodicalPerformance>> GetSPSalesPeriodicPerformance(
      final String BranchCd) {
    final String _sql = "SELECT sPeriodxx AS Period, nSPActual AS Actual, nSPGoalxx AS Goal FROM MC_Branch_Performance WHERE sBranchCd =? ORDER BY sPeriodxx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<DBranchPerformance.PeriodicalPerformance>>() {
      @Override
      public List<DBranchPerformance.PeriodicalPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPeriod = 0;
          final int _cursorIndexOfActual = 1;
          final int _cursorIndexOfGoal = 2;
          final List<DBranchPerformance.PeriodicalPerformance> _result = new ArrayList<DBranchPerformance.PeriodicalPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DBranchPerformance.PeriodicalPerformance _item;
            _item = new DBranchPerformance.PeriodicalPerformance();
            if (_cursor.isNull(_cursorIndexOfPeriod)) {
              _item.Period = null;
            } else {
              _item.Period = _cursor.getString(_cursorIndexOfPeriod);
            }
            if (_cursor.isNull(_cursorIndexOfActual)) {
              _item.Actual = null;
            } else {
              _item.Actual = _cursor.getString(_cursorIndexOfActual);
            }
            if (_cursor.isNull(_cursorIndexOfGoal)) {
              _item.Goal = null;
            } else {
              _item.Goal = _cursor.getString(_cursorIndexOfGoal);
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
  public LiveData<List<DBranchPerformance.PeriodicalPerformance>> GetJobOrderPeriodicPerformance(
      final String BranchCd) {
    final String _sql = "SELECT sPeriodxx AS Period, nJOActual AS Actual, nJOGoalxx AS Goal FROM MC_Branch_Performance WHERE sBranchCd =? ORDER BY sPeriodxx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<List<DBranchPerformance.PeriodicalPerformance>>() {
      @Override
      public List<DBranchPerformance.PeriodicalPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPeriod = 0;
          final int _cursorIndexOfActual = 1;
          final int _cursorIndexOfGoal = 2;
          final List<DBranchPerformance.PeriodicalPerformance> _result = new ArrayList<DBranchPerformance.PeriodicalPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DBranchPerformance.PeriodicalPerformance _item;
            _item = new DBranchPerformance.PeriodicalPerformance();
            if (_cursor.isNull(_cursorIndexOfPeriod)) {
              _item.Period = null;
            } else {
              _item.Period = _cursor.getString(_cursorIndexOfPeriod);
            }
            if (_cursor.isNull(_cursorIndexOfActual)) {
              _item.Actual = null;
            } else {
              _item.Actual = _cursor.getString(_cursorIndexOfActual);
            }
            if (_cursor.isNull(_cursorIndexOfGoal)) {
              _item.Goal = null;
            } else {
              _item.Goal = _cursor.getString(_cursorIndexOfGoal);
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
  public LiveData<DBranchPerformance.PeriodRange> getPeriodRange() {
    final String _sql = "SELECT MIN(sPeriodxx) AS Start, MAX(sPeriodxx) AS Current FROM MC_Branch_Performance;";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<DBranchPerformance.PeriodRange>() {
      @Override
      public DBranchPerformance.PeriodRange call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfStart = 0;
          final int _cursorIndexOfCurrent = 1;
          final DBranchPerformance.PeriodRange _result;
          if(_cursor.moveToFirst()) {
            _result = new DBranchPerformance.PeriodRange();
            if (_cursor.isNull(_cursorIndexOfStart)) {
              _result.Start = null;
            } else {
              _result.Start = _cursor.getString(_cursorIndexOfStart);
            }
            if (_cursor.isNull(_cursorIndexOfCurrent)) {
              _result.Current = null;
            } else {
              _result.Current = _cursor.getString(_cursorIndexOfCurrent);
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

  @Override
  public LiveData<DBranchPerformance.MonthlyPieChart> getMonthlyPieChartData(
      final String fsPeriodx) {
    final String _sql = "SELECT SUM(nMCGoalxx) as mcGoal, SUM(nMCActual) as mcActual, SUM(nSPGoalxx) as spGoal, SUM(nSPActual) as spActual FROM MC_Branch_Performance WHERE sPeriodxx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsPeriodx == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsPeriodx);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<DBranchPerformance.MonthlyPieChart>() {
      @Override
      public DBranchPerformance.MonthlyPieChart call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMcGoal = 0;
          final int _cursorIndexOfMcActual = 1;
          final int _cursorIndexOfSpGoal = 2;
          final int _cursorIndexOfSpActual = 3;
          final DBranchPerformance.MonthlyPieChart _result;
          if(_cursor.moveToFirst()) {
            _result = new DBranchPerformance.MonthlyPieChart();
            _result.mcGoal = _cursor.getFloat(_cursorIndexOfMcGoal);
            _result.mcActual = _cursor.getFloat(_cursorIndexOfMcActual);
            _result.spGoal = _cursor.getFloat(_cursorIndexOfSpGoal);
            _result.spActual = _cursor.getFloat(_cursorIndexOfSpActual);
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
  public LiveData<DBranchPerformance.MonthlyPieChart> get12MonthPieChartData(final String fsValue1,
      final String fsValue2) {
    final String _sql = "SELECT SUM(nMCGoalxx) as mcGoal, SUM(nMCActual) as mcActual, SUM(nSPGoalxx) as spGoal, SUM(nSPActual) as spActual FROM MC_Branch_Performance WHERE sPeriodxx BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsValue1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsValue1);
    }
    _argIndex = 2;
    if (fsValue2 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsValue2);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<DBranchPerformance.MonthlyPieChart>() {
      @Override
      public DBranchPerformance.MonthlyPieChart call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMcGoal = 0;
          final int _cursorIndexOfMcActual = 1;
          final int _cursorIndexOfSpGoal = 2;
          final int _cursorIndexOfSpActual = 3;
          final DBranchPerformance.MonthlyPieChart _result;
          if(_cursor.moveToFirst()) {
            _result = new DBranchPerformance.MonthlyPieChart();
            _result.mcGoal = _cursor.getFloat(_cursorIndexOfMcGoal);
            _result.mcActual = _cursor.getFloat(_cursorIndexOfMcActual);
            _result.spGoal = _cursor.getFloat(_cursorIndexOfSpGoal);
            _result.spActual = _cursor.getFloat(_cursorIndexOfSpActual);
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
  public LiveData<DBranchPerformance.MonthlyPieChart> get12MonthBranchPieChartData(
      final String sBranchCd, final String fsValue1, final String fsValue2) {
    final String _sql = "SELECT SUM(nMCGoalxx) as mcGoal, SUM(nMCActual) as mcActual, SUM(nSPGoalxx) as spGoal, SUM(nSPActual) as spActual FROM MC_Branch_Performance WHERE sBranchCd = ? AND sPeriodxx BETWEEN ? AND ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (sBranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sBranchCd);
    }
    _argIndex = 2;
    if (fsValue1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsValue1);
    }
    _argIndex = 3;
    if (fsValue2 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsValue2);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<DBranchPerformance.MonthlyPieChart>() {
      @Override
      public DBranchPerformance.MonthlyPieChart call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMcGoal = 0;
          final int _cursorIndexOfMcActual = 1;
          final int _cursorIndexOfSpGoal = 2;
          final int _cursorIndexOfSpActual = 3;
          final DBranchPerformance.MonthlyPieChart _result;
          if(_cursor.moveToFirst()) {
            _result = new DBranchPerformance.MonthlyPieChart();
            _result.mcGoal = _cursor.getFloat(_cursorIndexOfMcGoal);
            _result.mcActual = _cursor.getFloat(_cursorIndexOfMcActual);
            _result.spGoal = _cursor.getFloat(_cursorIndexOfSpGoal);
            _result.spActual = _cursor.getFloat(_cursorIndexOfSpActual);
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
  public LiveData<String> GetMCSalesPerformance(final String branchCd) {
    final String _sql = "SELECT nMCActual || '/' || nMCGoalxx AS Performance FROM MC_Branch_Performance WHERE sBranchCd =? ORDER BY sPeriodxx DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (branchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, branchCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<String>() {
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
  public LiveData<String> GetSPSalesPerformance(final String branchCd) {
    final String _sql = "SELECT nSPActual || '/' || nSPGoalxx AS Performance FROM MC_Branch_Performance WHERE sBranchCd =? ORDER BY sPeriodxx DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (branchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, branchCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<String>() {
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
  public LiveData<String> GetJobOrderPerformance(final String branchCd) {
    final String _sql = "SELECT nJOActual || '/' || nJOGoalxx AS Performance FROM MC_Branch_Performance WHERE sBranchCd =? ORDER BY sPeriodxx DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (branchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, branchCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance"}, false, new Callable<String>() {
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
