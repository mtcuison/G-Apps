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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EAreaPerformance;
import org.rmj.g3appdriver.GCircle.room.Entities.EBranchPerformance;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAreaPerformance_Impl implements DAreaPerformance {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EAreaPerformance> __insertionAdapterOfEAreaPerformance;

  private final EntityInsertionAdapter<EAreaPerformance> __insertionAdapterOfEAreaPerformance_1;

  private final EntityDeletionOrUpdateAdapter<EAreaPerformance> __updateAdapterOfEAreaPerformance;

  public DAreaPerformance_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEAreaPerformance = new EntityInsertionAdapter<EAreaPerformance>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MC_Area_Performance` (`sAreaCode`,`sAreaDesc`,`sPeriodxx`,`nMCGoalxx`,`nSPGoalxx`,`nJOGoalxx`,`nLRGoalxx`,`nMCActual`,`nSPActual`,`nJOActual`,`nLRActual`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EAreaPerformance value) {
        if (value.getAreaCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getAreaCode());
        }
        if (value.getAreaDesc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAreaDesc());
        }
        if (value.getPeriodxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPeriodxx());
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
    this.__insertionAdapterOfEAreaPerformance_1 = new EntityInsertionAdapter<EAreaPerformance>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MC_Area_Performance` (`sAreaCode`,`sAreaDesc`,`sPeriodxx`,`nMCGoalxx`,`nSPGoalxx`,`nJOGoalxx`,`nLRGoalxx`,`nMCActual`,`nSPActual`,`nJOActual`,`nLRActual`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EAreaPerformance value) {
        if (value.getAreaCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getAreaCode());
        }
        if (value.getAreaDesc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAreaDesc());
        }
        if (value.getPeriodxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPeriodxx());
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
    this.__updateAdapterOfEAreaPerformance = new EntityDeletionOrUpdateAdapter<EAreaPerformance>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MC_Area_Performance` SET `sAreaCode` = ?,`sAreaDesc` = ?,`sPeriodxx` = ?,`nMCGoalxx` = ?,`nSPGoalxx` = ?,`nJOGoalxx` = ?,`nLRGoalxx` = ?,`nMCActual` = ?,`nSPActual` = ?,`nJOActual` = ?,`nLRActual` = ? WHERE `sAreaCode` = ? AND `sPeriodxx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EAreaPerformance value) {
        if (value.getAreaCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getAreaCode());
        }
        if (value.getAreaDesc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAreaDesc());
        }
        if (value.getPeriodxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPeriodxx());
        }
        stmt.bindLong(4, value.getMCGoalxx());
        stmt.bindDouble(5, value.getSPGoalxx());
        stmt.bindLong(6, value.getJOGoalxx());
        stmt.bindDouble(7, value.getLRGoalxx());
        stmt.bindLong(8, value.getMCActual());
        stmt.bindDouble(9, value.getSPActual());
        stmt.bindDouble(10, value.getJOActual());
        stmt.bindDouble(11, value.getLRActual());
        if (value.getAreaCode() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getAreaCode());
        }
        if (value.getPeriodxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPeriodxx());
        }
      }
    };
  }

  @Override
  public void insert(final EAreaPerformance areaPerformance) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEAreaPerformance.insert(areaPerformance);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EAreaPerformance> areaPerformances) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEAreaPerformance_1.insert(areaPerformances);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EAreaPerformance areaPerformance) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEAreaPerformance.handle(areaPerformance);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
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
  public EAreaPerformance GetAreaPerformance(final String Period, final String AreaCode) {
    final String _sql = "SELECT * FROM MC_Area_Performance WHERE sPeriodxx =? AND sAreaCode=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (Period == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Period);
    }
    _argIndex = 2;
    if (AreaCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AreaCode);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
      final int _cursorIndexOfAreaDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaDesc");
      final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
      final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
      final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
      final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
      final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
      final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
      final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
      final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
      final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
      final EAreaPerformance _result;
      if(_cursor.moveToFirst()) {
        _result = new EAreaPerformance();
        final String _tmpAreaCode;
        if (_cursor.isNull(_cursorIndexOfAreaCode)) {
          _tmpAreaCode = null;
        } else {
          _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
        }
        _result.setAreaCode(_tmpAreaCode);
        final String _tmpAreaDesc;
        if (_cursor.isNull(_cursorIndexOfAreaDesc)) {
          _tmpAreaDesc = null;
        } else {
          _tmpAreaDesc = _cursor.getString(_cursorIndexOfAreaDesc);
        }
        _result.setAreaDesc(_tmpAreaDesc);
        final String _tmpPeriodxx;
        if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
          _tmpPeriodxx = null;
        } else {
          _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
        }
        _result.setPeriodxx(_tmpPeriodxx);
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
  public LiveData<List<EAreaPerformance>> getAllAreaPerformanceInfo() {
    final String _sql = "SELECT * FROM MC_Area_Performance ORDER BY sPeriodxx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Area_Performance"}, false, new Callable<List<EAreaPerformance>>() {
      @Override
      public List<EAreaPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfAreaDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaDesc");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EAreaPerformance> _result = new ArrayList<EAreaPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EAreaPerformance _item;
            _item = new EAreaPerformance();
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _item.setAreaCode(_tmpAreaCode);
            final String _tmpAreaDesc;
            if (_cursor.isNull(_cursorIndexOfAreaDesc)) {
              _tmpAreaDesc = null;
            } else {
              _tmpAreaDesc = _cursor.getString(_cursorIndexOfAreaDesc);
            }
            _item.setAreaDesc(_tmpAreaDesc);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
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
  public LiveData<List<EAreaPerformance>> getAreaPerformanceDashboard() {
    final String _sql = "SELECT * FROM MC_Area_Performance ORDER BY ROUND(nMCActual * 100.0 / nMCGoalxx, 1) DESC LIMIT 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Area_Performance"}, false, new Callable<List<EAreaPerformance>>() {
      @Override
      public List<EAreaPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfAreaDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaDesc");
          final int _cursorIndexOfPeriodxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPeriodxx");
          final int _cursorIndexOfMCGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCGoalxx");
          final int _cursorIndexOfSPGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPGoalxx");
          final int _cursorIndexOfJOGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOGoalxx");
          final int _cursorIndexOfLRGoalxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRGoalxx");
          final int _cursorIndexOfMCActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nMCActual");
          final int _cursorIndexOfSPActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nSPActual");
          final int _cursorIndexOfJOActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nJOActual");
          final int _cursorIndexOfLRActual = CursorUtil.getColumnIndexOrThrow(_cursor, "nLRActual");
          final List<EAreaPerformance> _result = new ArrayList<EAreaPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EAreaPerformance _item;
            _item = new EAreaPerformance();
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _item.setAreaCode(_tmpAreaCode);
            final String _tmpAreaDesc;
            if (_cursor.isNull(_cursorIndexOfAreaDesc)) {
              _tmpAreaDesc = null;
            } else {
              _tmpAreaDesc = _cursor.getString(_cursorIndexOfAreaDesc);
            }
            _item.setAreaDesc(_tmpAreaDesc);
            final String _tmpPeriodxx;
            if (_cursor.isNull(_cursorIndexOfPeriodxx)) {
              _tmpPeriodxx = null;
            } else {
              _tmpPeriodxx = _cursor.getString(_cursorIndexOfPeriodxx);
            }
            _item.setPeriodxx(_tmpPeriodxx);
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
  public LiveData<String> getAreaDescription() {
    final String _sql = "SELECT sAreaDesc FROM MC_Area_Performance WHERE sAreaCode = (SELECT sAreaCode FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master))";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Area_Performance","Branch_Info","User_Info_Master"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<String> GetMCSalesPerformance() {
    final String _sql = "SELECT nMCActual || '/' || nMCGoalxx AS Performance FROM MC_Area_Performance ORDER BY sPeriodxx DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Area_Performance"}, false, new Callable<String>() {
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
  public LiveData<String> GetSPSalesPerformance() {
    final String _sql = "SELECT nSPActual || '/' || nSPGoalxx AS Performance FROM MC_Area_Performance ORDER BY sPeriodxx DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Area_Performance"}, false, new Callable<String>() {
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
  public LiveData<String> GetJobOrderPerformance() {
    final String _sql = "SELECT nJOActual || '/' || nJOGoalxx AS Performance FROM MC_Area_Performance ORDER BY sPeriodxx DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Area_Performance"}, false, new Callable<String>() {
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
  public LiveData<List<EBranchPerformance>> GetTopBranchPerformerForMCSales() {
    final String _sql = "SELECT * FROM MC_Branch_Performance WHERE sPeriodxx = (SELECT sPeriodxx FROM MC_Branch_Performance ORDER BY sPeriodxx DESC LIMIT 1)ORDER BY nMCActual=0, nMCActual DESC LIMIT 5";
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
  public LiveData<List<EBranchPerformance>> GetTopBranchPerformerForSPSales() {
    final String _sql = "SELECT * FROM MC_Branch_Performance WHERE sPeriodxx = (SELECT sPeriodxx FROM MC_Branch_Performance ORDER BY sPeriodxx DESC LIMIT 1)ORDER BY nSPActual=0.0, nSPActual DESC LIMIT 5";
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
  public LiveData<List<EBranchPerformance>> GetTopBranchPerformerForJobOrder() {
    final String _sql = "SELECT * FROM MC_Branch_Performance WHERE sPeriodxx = (SELECT sPeriodxx FROM MC_Branch_Performance ORDER BY sPeriodxx DESC LIMIT 1)ORDER BY nJOActual=0.0, nJOActual DESC LIMIT 5";
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
  public LiveData<List<DAreaPerformance.BranchPerformance>> GetMCSalesBranchesPerformance() {
    final String _sql = "SELECT a.sBranchCd, a.sBranchNm, a.nMCActual AS nActualxx,a.nMCGoalxx AS nGoalxxxx FROM MC_Branch_Performance a LEFT JOIN Branch_Info b ON a.sBranchCd = b.sBranchCd WHERE b.sAreaCode = ( SELECT sAreaCode FROM Branch_Info WHERE sBranchCd =(SELECT sBranchCd FROM User_Info_Master)) AND a.sPeriodxx = (SELECT sPeriodxx FROM MC_Area_Performance ORDER BY sPeriodxx DESC LIMIT 1)GROUP BY a.sBranchCd ORDER BY a.nMCActual=0, a.nMCActual DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance","Branch_Info","User_Info_Master","MC_Area_Performance"}, false, new Callable<List<DAreaPerformance.BranchPerformance>>() {
      @Override
      public List<DAreaPerformance.BranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSBranchCd = 0;
          final int _cursorIndexOfSBranchNm = 1;
          final int _cursorIndexOfNActualxx = 2;
          final int _cursorIndexOfNGoalxxxx = 3;
          final List<DAreaPerformance.BranchPerformance> _result = new ArrayList<DAreaPerformance.BranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DAreaPerformance.BranchPerformance _item;
            _item = new DAreaPerformance.BranchPerformance();
            if (_cursor.isNull(_cursorIndexOfSBranchCd)) {
              _item.sBranchCd = null;
            } else {
              _item.sBranchCd = _cursor.getString(_cursorIndexOfSBranchCd);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfNActualxx)) {
              _item.nActualxx = null;
            } else {
              _item.nActualxx = _cursor.getString(_cursorIndexOfNActualxx);
            }
            if (_cursor.isNull(_cursorIndexOfNGoalxxxx)) {
              _item.nGoalxxxx = null;
            } else {
              _item.nGoalxxxx = _cursor.getString(_cursorIndexOfNGoalxxxx);
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
  public LiveData<List<DAreaPerformance.BranchPerformance>> GetSPSalesBranchesPerformance() {
    final String _sql = "SELECT a.sBranchCd, a.sBranchNm, a.nSPActual AS nActualxx,a.nSPGoalxx AS nGoalxxxx FROM MC_Branch_Performance a LEFT JOIN Branch_Info b ON a.sBranchCd = b.sBranchCd WHERE b.sAreaCode = ( SELECT sAreaCode FROM Branch_Info WHERE sBranchCd =(SELECT sBranchCd FROM User_Info_Master)) AND a.sPeriodxx = (SELECT sPeriodxx FROM MC_Area_Performance ORDER BY sPeriodxx DESC LIMIT 1)GROUP BY a.sBranchCd ORDER BY a.nSPActual=0.0, a.nSPActual DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance","Branch_Info","User_Info_Master","MC_Area_Performance"}, false, new Callable<List<DAreaPerformance.BranchPerformance>>() {
      @Override
      public List<DAreaPerformance.BranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSBranchCd = 0;
          final int _cursorIndexOfSBranchNm = 1;
          final int _cursorIndexOfNActualxx = 2;
          final int _cursorIndexOfNGoalxxxx = 3;
          final List<DAreaPerformance.BranchPerformance> _result = new ArrayList<DAreaPerformance.BranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DAreaPerformance.BranchPerformance _item;
            _item = new DAreaPerformance.BranchPerformance();
            if (_cursor.isNull(_cursorIndexOfSBranchCd)) {
              _item.sBranchCd = null;
            } else {
              _item.sBranchCd = _cursor.getString(_cursorIndexOfSBranchCd);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfNActualxx)) {
              _item.nActualxx = null;
            } else {
              _item.nActualxx = _cursor.getString(_cursorIndexOfNActualxx);
            }
            if (_cursor.isNull(_cursorIndexOfNGoalxxxx)) {
              _item.nGoalxxxx = null;
            } else {
              _item.nGoalxxxx = _cursor.getString(_cursorIndexOfNGoalxxxx);
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
  public LiveData<List<DAreaPerformance.BranchPerformance>> GetJobOrderBranchesPerformance() {
    final String _sql = "SELECT a.sBranchCd, a.sBranchNm, a.nJOActual AS nActualxx,a.nJOGoalxx AS nGoalxxxx FROM MC_Branch_Performance a LEFT JOIN Branch_Info b ON a.sBranchCd = b.sBranchCd WHERE b.sAreaCode = ( SELECT sAreaCode FROM Branch_Info WHERE sBranchCd =(SELECT sBranchCd FROM User_Info_Master)) AND a.sPeriodxx = (SELECT sPeriodxx FROM MC_Area_Performance ORDER BY sPeriodxx DESC LIMIT 1)GROUP BY a.sBranchCd ORDER BY a.nJOActual=0.0, a.nJOActual DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Branch_Performance","Branch_Info","User_Info_Master","MC_Area_Performance"}, false, new Callable<List<DAreaPerformance.BranchPerformance>>() {
      @Override
      public List<DAreaPerformance.BranchPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSBranchCd = 0;
          final int _cursorIndexOfSBranchNm = 1;
          final int _cursorIndexOfNActualxx = 2;
          final int _cursorIndexOfNGoalxxxx = 3;
          final List<DAreaPerformance.BranchPerformance> _result = new ArrayList<DAreaPerformance.BranchPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DAreaPerformance.BranchPerformance _item;
            _item = new DAreaPerformance.BranchPerformance();
            if (_cursor.isNull(_cursorIndexOfSBranchCd)) {
              _item.sBranchCd = null;
            } else {
              _item.sBranchCd = _cursor.getString(_cursorIndexOfSBranchCd);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfNActualxx)) {
              _item.nActualxx = null;
            } else {
              _item.nActualxx = _cursor.getString(_cursorIndexOfNActualxx);
            }
            if (_cursor.isNull(_cursorIndexOfNGoalxxxx)) {
              _item.nGoalxxxx = null;
            } else {
              _item.nGoalxxxx = _cursor.getString(_cursorIndexOfNGoalxxxx);
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
  public LiveData<List<DAreaPerformance.PeriodicPerformance>> GetMCSalesPeriodicPerformance() {
    final String _sql = "SELECT sPeriodxx, nMCActual AS nActualxx, nMCGoalxx AS nGoalxxxx FROM MC_Area_Performance WHERE sAreaCode = (SELECT sAreaCode FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)) ORDER BY sPeriodxx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Area_Performance","Branch_Info","User_Info_Master"}, false, new Callable<List<DAreaPerformance.PeriodicPerformance>>() {
      @Override
      public List<DAreaPerformance.PeriodicPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSPeriodxx = 0;
          final int _cursorIndexOfNActualxx = 1;
          final int _cursorIndexOfNGoalxxxx = 2;
          final List<DAreaPerformance.PeriodicPerformance> _result = new ArrayList<DAreaPerformance.PeriodicPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DAreaPerformance.PeriodicPerformance _item;
            _item = new DAreaPerformance.PeriodicPerformance();
            if (_cursor.isNull(_cursorIndexOfSPeriodxx)) {
              _item.sPeriodxx = null;
            } else {
              _item.sPeriodxx = _cursor.getString(_cursorIndexOfSPeriodxx);
            }
            if (_cursor.isNull(_cursorIndexOfNActualxx)) {
              _item.nActualxx = null;
            } else {
              _item.nActualxx = _cursor.getString(_cursorIndexOfNActualxx);
            }
            if (_cursor.isNull(_cursorIndexOfNGoalxxxx)) {
              _item.nGoalxxxx = null;
            } else {
              _item.nGoalxxxx = _cursor.getString(_cursorIndexOfNGoalxxxx);
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
  public LiveData<List<DAreaPerformance.PeriodicPerformance>> GetSPSalesPeriodicPerformance() {
    final String _sql = "SELECT sPeriodxx, nSPActual AS nActualxx, nSPGoalxx AS nGoalxxxx FROM MC_Area_Performance WHERE sAreaCode = (SELECT sAreaCode FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)) ORDER BY sPeriodxx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Area_Performance","Branch_Info","User_Info_Master"}, false, new Callable<List<DAreaPerformance.PeriodicPerformance>>() {
      @Override
      public List<DAreaPerformance.PeriodicPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSPeriodxx = 0;
          final int _cursorIndexOfNActualxx = 1;
          final int _cursorIndexOfNGoalxxxx = 2;
          final List<DAreaPerformance.PeriodicPerformance> _result = new ArrayList<DAreaPerformance.PeriodicPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DAreaPerformance.PeriodicPerformance _item;
            _item = new DAreaPerformance.PeriodicPerformance();
            if (_cursor.isNull(_cursorIndexOfSPeriodxx)) {
              _item.sPeriodxx = null;
            } else {
              _item.sPeriodxx = _cursor.getString(_cursorIndexOfSPeriodxx);
            }
            if (_cursor.isNull(_cursorIndexOfNActualxx)) {
              _item.nActualxx = null;
            } else {
              _item.nActualxx = _cursor.getString(_cursorIndexOfNActualxx);
            }
            if (_cursor.isNull(_cursorIndexOfNGoalxxxx)) {
              _item.nGoalxxxx = null;
            } else {
              _item.nGoalxxxx = _cursor.getString(_cursorIndexOfNGoalxxxx);
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
  public LiveData<List<DAreaPerformance.PeriodicPerformance>> GetJobOrderPeriodicPerformance() {
    final String _sql = "SELECT sPeriodxx, nJOActual AS nActualxx, nJOGoalxx AS nGoalxxxx FROM MC_Area_Performance WHERE sAreaCode = (SELECT sAreaCode FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)) ORDER BY sPeriodxx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Area_Performance","Branch_Info","User_Info_Master"}, false, new Callable<List<DAreaPerformance.PeriodicPerformance>>() {
      @Override
      public List<DAreaPerformance.PeriodicPerformance> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSPeriodxx = 0;
          final int _cursorIndexOfNActualxx = 1;
          final int _cursorIndexOfNGoalxxxx = 2;
          final List<DAreaPerformance.PeriodicPerformance> _result = new ArrayList<DAreaPerformance.PeriodicPerformance>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DAreaPerformance.PeriodicPerformance _item;
            _item = new DAreaPerformance.PeriodicPerformance();
            if (_cursor.isNull(_cursorIndexOfSPeriodxx)) {
              _item.sPeriodxx = null;
            } else {
              _item.sPeriodxx = _cursor.getString(_cursorIndexOfSPeriodxx);
            }
            if (_cursor.isNull(_cursorIndexOfNActualxx)) {
              _item.nActualxx = null;
            } else {
              _item.nActualxx = _cursor.getString(_cursorIndexOfNActualxx);
            }
            if (_cursor.isNull(_cursorIndexOfNGoalxxxx)) {
              _item.nGoalxxxx = null;
            } else {
              _item.nGoalxxxx = _cursor.getString(_cursorIndexOfNGoalxxxx);
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
