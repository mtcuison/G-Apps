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
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.ETownInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DTownInfo_Impl implements DTownInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ETownInfo> __insertionAdapterOfETownInfo;

  private final EntityDeletionOrUpdateAdapter<ETownInfo> __updateAdapterOfETownInfo;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllTownInfo;

  public DTownInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfETownInfo = new EntityInsertionAdapter<ETownInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Town_Info` (`sTownIDxx`,`sTownName`,`sZippCode`,`sProvIDxx`,`sProvCode`,`sMuncplCd`,`cHasRoute`,`cBlackLst`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ETownInfo value) {
        if (value.getTownIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTownIDxx());
        }
        if (value.getTownName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTownName());
        }
        if (value.getZippCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getZippCode());
        }
        if (value.getProvIDxx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProvIDxx());
        }
        if (value.getProvCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getProvCode());
        }
        if (value.getMuncplCd() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMuncplCd());
        }
        if (value.getHasRoute() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getHasRoute());
        }
        if (value.getBlackLst() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBlackLst());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfETownInfo = new EntityDeletionOrUpdateAdapter<ETownInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Town_Info` SET `sTownIDxx` = ?,`sTownName` = ?,`sZippCode` = ?,`sProvIDxx` = ?,`sProvCode` = ?,`sMuncplCd` = ?,`cHasRoute` = ?,`cBlackLst` = ?,`cRecdStat` = ?,`dTimeStmp` = ? WHERE `sTownIDxx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ETownInfo value) {
        if (value.getTownIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTownIDxx());
        }
        if (value.getTownName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTownName());
        }
        if (value.getZippCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getZippCode());
        }
        if (value.getProvIDxx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getProvIDxx());
        }
        if (value.getProvCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getProvCode());
        }
        if (value.getMuncplCd() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMuncplCd());
        }
        if (value.getHasRoute() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getHasRoute());
        }
        if (value.getBlackLst() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBlackLst());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTimeStmp());
        }
        if (value.getTownIDxx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTownIDxx());
        }
      }
    };
    this.__preparedStmtOfDeleteAllTownInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Town_Info";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ETownInfo townInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfETownInfo.insert(townInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<ETownInfo> townInfoList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfETownInfo.insert(townInfoList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ETownInfo townInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfETownInfo.handle(townInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllTownInfo() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllTownInfo.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllTownInfo.release(_stmt);
    }
  }

  @Override
  public Integer GetTownRecordsCount() {
    final String _sql = "SELECT COUNT(*) FROM Town_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public ETownInfo GetTown(final String fsVal) {
    final String _sql = "SELECT * FROM Town_Info WHERE sTownIDxx =?";
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
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfZippCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sZippCode");
      final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
      final int _cursorIndexOfProvCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvCode");
      final int _cursorIndexOfMuncplCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sMuncplCd");
      final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
      final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ETownInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new ETownInfo();
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _result.setTownIDxx(_tmpTownIDxx);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _result.setTownName(_tmpTownName);
        final String _tmpZippCode;
        if (_cursor.isNull(_cursorIndexOfZippCode)) {
          _tmpZippCode = null;
        } else {
          _tmpZippCode = _cursor.getString(_cursorIndexOfZippCode);
        }
        _result.setZippCode(_tmpZippCode);
        final String _tmpProvIDxx;
        if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
          _tmpProvIDxx = null;
        } else {
          _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
        }
        _result.setProvIDxx(_tmpProvIDxx);
        final String _tmpProvCode;
        if (_cursor.isNull(_cursorIndexOfProvCode)) {
          _tmpProvCode = null;
        } else {
          _tmpProvCode = _cursor.getString(_cursorIndexOfProvCode);
        }
        _result.setProvCode(_tmpProvCode);
        final String _tmpMuncplCd;
        if (_cursor.isNull(_cursorIndexOfMuncplCd)) {
          _tmpMuncplCd = null;
        } else {
          _tmpMuncplCd = _cursor.getString(_cursorIndexOfMuncplCd);
        }
        _result.setMuncplCd(_tmpMuncplCd);
        final String _tmpHasRoute;
        if (_cursor.isNull(_cursorIndexOfHasRoute)) {
          _tmpHasRoute = null;
        } else {
          _tmpHasRoute = _cursor.getString(_cursorIndexOfHasRoute);
        }
        _result.setHasRoute(_tmpHasRoute);
        final String _tmpBlackLst;
        if (_cursor.isNull(_cursorIndexOfBlackLst)) {
          _tmpBlackLst = null;
        } else {
          _tmpBlackLst = _cursor.getString(_cursorIndexOfBlackLst);
        }
        _result.setBlackLst(_tmpBlackLst);
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
  public ETownInfo GetLatestTown() {
    final String _sql = "SELECT * FROM Town_Info ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfZippCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sZippCode");
      final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
      final int _cursorIndexOfProvCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvCode");
      final int _cursorIndexOfMuncplCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sMuncplCd");
      final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
      final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ETownInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new ETownInfo();
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _result.setTownIDxx(_tmpTownIDxx);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _result.setTownName(_tmpTownName);
        final String _tmpZippCode;
        if (_cursor.isNull(_cursorIndexOfZippCode)) {
          _tmpZippCode = null;
        } else {
          _tmpZippCode = _cursor.getString(_cursorIndexOfZippCode);
        }
        _result.setZippCode(_tmpZippCode);
        final String _tmpProvIDxx;
        if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
          _tmpProvIDxx = null;
        } else {
          _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
        }
        _result.setProvIDxx(_tmpProvIDxx);
        final String _tmpProvCode;
        if (_cursor.isNull(_cursorIndexOfProvCode)) {
          _tmpProvCode = null;
        } else {
          _tmpProvCode = _cursor.getString(_cursorIndexOfProvCode);
        }
        _result.setProvCode(_tmpProvCode);
        final String _tmpMuncplCd;
        if (_cursor.isNull(_cursorIndexOfMuncplCd)) {
          _tmpMuncplCd = null;
        } else {
          _tmpMuncplCd = _cursor.getString(_cursorIndexOfMuncplCd);
        }
        _result.setMuncplCd(_tmpMuncplCd);
        final String _tmpHasRoute;
        if (_cursor.isNull(_cursorIndexOfHasRoute)) {
          _tmpHasRoute = null;
        } else {
          _tmpHasRoute = _cursor.getString(_cursorIndexOfHasRoute);
        }
        _result.setHasRoute(_tmpHasRoute);
        final String _tmpBlackLst;
        if (_cursor.isNull(_cursorIndexOfBlackLst)) {
          _tmpBlackLst = null;
        } else {
          _tmpBlackLst = _cursor.getString(_cursorIndexOfBlackLst);
        }
        _result.setBlackLst(_tmpBlackLst);
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
  public LiveData<List<ETownInfo>> getAllTownInfo() {
    final String _sql = "SELECT * FROM Town_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info"}, false, new Callable<List<ETownInfo>>() {
      @Override
      public List<ETownInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfZippCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sZippCode");
          final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
          final int _cursorIndexOfProvCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvCode");
          final int _cursorIndexOfMuncplCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sMuncplCd");
          final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
          final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<ETownInfo> _result = new ArrayList<ETownInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ETownInfo _item;
            _item = new ETownInfo();
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpZippCode;
            if (_cursor.isNull(_cursorIndexOfZippCode)) {
              _tmpZippCode = null;
            } else {
              _tmpZippCode = _cursor.getString(_cursorIndexOfZippCode);
            }
            _item.setZippCode(_tmpZippCode);
            final String _tmpProvIDxx;
            if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
              _tmpProvIDxx = null;
            } else {
              _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
            }
            _item.setProvIDxx(_tmpProvIDxx);
            final String _tmpProvCode;
            if (_cursor.isNull(_cursorIndexOfProvCode)) {
              _tmpProvCode = null;
            } else {
              _tmpProvCode = _cursor.getString(_cursorIndexOfProvCode);
            }
            _item.setProvCode(_tmpProvCode);
            final String _tmpMuncplCd;
            if (_cursor.isNull(_cursorIndexOfMuncplCd)) {
              _tmpMuncplCd = null;
            } else {
              _tmpMuncplCd = _cursor.getString(_cursorIndexOfMuncplCd);
            }
            _item.setMuncplCd(_tmpMuncplCd);
            final String _tmpHasRoute;
            if (_cursor.isNull(_cursorIndexOfHasRoute)) {
              _tmpHasRoute = null;
            } else {
              _tmpHasRoute = _cursor.getString(_cursorIndexOfHasRoute);
            }
            _item.setHasRoute(_tmpHasRoute);
            final String _tmpBlackLst;
            if (_cursor.isNull(_cursorIndexOfBlackLst)) {
              _tmpBlackLst = null;
            } else {
              _tmpBlackLst = _cursor.getString(_cursorIndexOfBlackLst);
            }
            _item.setBlackLst(_tmpBlackLst);
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
  public String getLatestDataTime() {
    final String _sql = "SELECT MAX(dTimeStmp) FROM Town_Info";
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
  public LiveData<List<ETownInfo>> getAllTownInfoFromProvince(final String ProvinceID) {
    final String _sql = "SELECT * FROM Town_Info WHERE sProvIDxx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ProvinceID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ProvinceID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info"}, false, new Callable<List<ETownInfo>>() {
      @Override
      public List<ETownInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfZippCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sZippCode");
          final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
          final int _cursorIndexOfProvCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvCode");
          final int _cursorIndexOfMuncplCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sMuncplCd");
          final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
          final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<ETownInfo> _result = new ArrayList<ETownInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ETownInfo _item;
            _item = new ETownInfo();
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpZippCode;
            if (_cursor.isNull(_cursorIndexOfZippCode)) {
              _tmpZippCode = null;
            } else {
              _tmpZippCode = _cursor.getString(_cursorIndexOfZippCode);
            }
            _item.setZippCode(_tmpZippCode);
            final String _tmpProvIDxx;
            if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
              _tmpProvIDxx = null;
            } else {
              _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
            }
            _item.setProvIDxx(_tmpProvIDxx);
            final String _tmpProvCode;
            if (_cursor.isNull(_cursorIndexOfProvCode)) {
              _tmpProvCode = null;
            } else {
              _tmpProvCode = _cursor.getString(_cursorIndexOfProvCode);
            }
            _item.setProvCode(_tmpProvCode);
            final String _tmpMuncplCd;
            if (_cursor.isNull(_cursorIndexOfMuncplCd)) {
              _tmpMuncplCd = null;
            } else {
              _tmpMuncplCd = _cursor.getString(_cursorIndexOfMuncplCd);
            }
            _item.setMuncplCd(_tmpMuncplCd);
            final String _tmpHasRoute;
            if (_cursor.isNull(_cursorIndexOfHasRoute)) {
              _tmpHasRoute = null;
            } else {
              _tmpHasRoute = _cursor.getString(_cursorIndexOfHasRoute);
            }
            _item.setHasRoute(_tmpHasRoute);
            final String _tmpBlackLst;
            if (_cursor.isNull(_cursorIndexOfBlackLst)) {
              _tmpBlackLst = null;
            } else {
              _tmpBlackLst = _cursor.getString(_cursorIndexOfBlackLst);
            }
            _item.setBlackLst(_tmpBlackLst);
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
  public LiveData<String[]> getTownNamesFromProvince(final String ProvinceID) {
    final String _sql = "SELECT sTownName FROM Town_Info WHERE sProvIDxx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ProvinceID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ProvinceID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info"}, false, new Callable<String[]>() {
      @Override
      public String[] call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String[] _result = new String[_cursor.getCount()];
          int _index = 0;
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
            _result[_index] = _item;
            _index ++;
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
  public LiveData<ETownInfo> getTownNameAndProvID(final String townID) {
    final String _sql = "SELECT * FROM Town_Info WHERE sTownIDxx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (townID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, townID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info"}, false, new Callable<ETownInfo>() {
      @Override
      public ETownInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfZippCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sZippCode");
          final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
          final int _cursorIndexOfProvCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvCode");
          final int _cursorIndexOfMuncplCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sMuncplCd");
          final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
          final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final ETownInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new ETownInfo();
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _result.setTownIDxx(_tmpTownIDxx);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _result.setTownName(_tmpTownName);
            final String _tmpZippCode;
            if (_cursor.isNull(_cursorIndexOfZippCode)) {
              _tmpZippCode = null;
            } else {
              _tmpZippCode = _cursor.getString(_cursorIndexOfZippCode);
            }
            _result.setZippCode(_tmpZippCode);
            final String _tmpProvIDxx;
            if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
              _tmpProvIDxx = null;
            } else {
              _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
            }
            _result.setProvIDxx(_tmpProvIDxx);
            final String _tmpProvCode;
            if (_cursor.isNull(_cursorIndexOfProvCode)) {
              _tmpProvCode = null;
            } else {
              _tmpProvCode = _cursor.getString(_cursorIndexOfProvCode);
            }
            _result.setProvCode(_tmpProvCode);
            final String _tmpMuncplCd;
            if (_cursor.isNull(_cursorIndexOfMuncplCd)) {
              _tmpMuncplCd = null;
            } else {
              _tmpMuncplCd = _cursor.getString(_cursorIndexOfMuncplCd);
            }
            _result.setMuncplCd(_tmpMuncplCd);
            final String _tmpHasRoute;
            if (_cursor.isNull(_cursorIndexOfHasRoute)) {
              _tmpHasRoute = null;
            } else {
              _tmpHasRoute = _cursor.getString(_cursorIndexOfHasRoute);
            }
            _result.setHasRoute(_tmpHasRoute);
            final String _tmpBlackLst;
            if (_cursor.isNull(_cursorIndexOfBlackLst)) {
              _tmpBlackLst = null;
            } else {
              _tmpBlackLst = _cursor.getString(_cursorIndexOfBlackLst);
            }
            _result.setBlackLst(_tmpBlackLst);
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
  public LiveData<List<DTownInfo.TownProvinceInfo>> getTownProvinceInfo() {
    final String _sql = "SELECT a.sTownIDxx, b.sProvIDxx, a.sTownName, b.sProvName FROM Town_Info a LEFT JOIN Province_Info b ON a.sProvIDxx = b.sProvIDxx";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info","Province_Info"}, false, new Callable<List<DTownInfo.TownProvinceInfo>>() {
      @Override
      public List<DTownInfo.TownProvinceInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTownIDxx = 0;
          final int _cursorIndexOfSProvIDxx = 1;
          final int _cursorIndexOfSTownName = 2;
          final int _cursorIndexOfSProvName = 3;
          final List<DTownInfo.TownProvinceInfo> _result = new ArrayList<DTownInfo.TownProvinceInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DTownInfo.TownProvinceInfo _item;
            _item = new DTownInfo.TownProvinceInfo();
            if (_cursor.isNull(_cursorIndexOfSTownIDxx)) {
              _item.sTownIDxx = null;
            } else {
              _item.sTownIDxx = _cursor.getString(_cursorIndexOfSTownIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSProvIDxx)) {
              _item.sProvIDxx = null;
            } else {
              _item.sProvIDxx = _cursor.getString(_cursorIndexOfSProvIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSTownName)) {
              _item.sTownName = null;
            } else {
              _item.sTownName = _cursor.getString(_cursorIndexOfSTownName);
            }
            if (_cursor.isNull(_cursorIndexOfSProvName)) {
              _item.sProvName = null;
            } else {
              _item.sProvName = _cursor.getString(_cursorIndexOfSProvName);
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
  public LiveData<DTownInfo.BrgyTownProvinceInfo> getTownProvinceInfo(final String townID) {
    final String _sql = "SELECT a.sTownName, b.sProvName,'' AS sBrgyName FROM Town_Info a INNER JOIN Province_Info b ON a.sProvIDxx = b.sProvIDxx AND a.sTownIDxx  =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (townID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, townID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info","Province_Info"}, false, new Callable<DTownInfo.BrgyTownProvinceInfo>() {
      @Override
      public DTownInfo.BrgyTownProvinceInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTownName = 0;
          final int _cursorIndexOfSProvName = 1;
          final int _cursorIndexOfSBrgyName = 2;
          final DTownInfo.BrgyTownProvinceInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new DTownInfo.BrgyTownProvinceInfo();
            if (_cursor.isNull(_cursorIndexOfSTownName)) {
              _result.sTownName = null;
            } else {
              _result.sTownName = _cursor.getString(_cursorIndexOfSTownName);
            }
            if (_cursor.isNull(_cursorIndexOfSProvName)) {
              _result.sProvName = null;
            } else {
              _result.sProvName = _cursor.getString(_cursorIndexOfSProvName);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyName)) {
              _result.sBrgyName = null;
            } else {
              _result.sBrgyName = _cursor.getString(_cursorIndexOfSBrgyName);
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
  public LiveData<DTownInfo.BrgyTownProvinceInfo> getBrgyTownProvinceInfo(final String BrgyID) {
    final String _sql = "SELECT a.sTownName, b.sProvName, c.sBrgyName FROM Town_Info a INNER JOIN Province_Info b INNER JOIN Barangay_Info c ON a.sProvIDxx = b.sProvIDxx AND a.sTownIDxx = c.sTownIDxx AND c.sBrgyIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BrgyID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BrgyID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info","Province_Info","Barangay_Info"}, false, new Callable<DTownInfo.BrgyTownProvinceInfo>() {
      @Override
      public DTownInfo.BrgyTownProvinceInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTownName = 0;
          final int _cursorIndexOfSProvName = 1;
          final int _cursorIndexOfSBrgyName = 2;
          final DTownInfo.BrgyTownProvinceInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new DTownInfo.BrgyTownProvinceInfo();
            if (_cursor.isNull(_cursorIndexOfSTownName)) {
              _result.sTownName = null;
            } else {
              _result.sTownName = _cursor.getString(_cursorIndexOfSTownName);
            }
            if (_cursor.isNull(_cursorIndexOfSProvName)) {
              _result.sProvName = null;
            } else {
              _result.sProvName = _cursor.getString(_cursorIndexOfSProvName);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyName)) {
              _result.sBrgyName = null;
            } else {
              _result.sBrgyName = _cursor.getString(_cursorIndexOfSBrgyName);
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
  public DTownInfo.TownProvinceName getTownProvinceNames(final String TownID) {
    final String _sql = "SELECT a.sTownName, b.sProvName FROM Town_Info a LEFT JOIN Province_Info b ON a.sProvIDxx = b.sProvIDxx WHERE sTownIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TownID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TownID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSTownName = 0;
      final int _cursorIndexOfSProvName = 1;
      final DTownInfo.TownProvinceName _result;
      if(_cursor.moveToFirst()) {
        _result = new DTownInfo.TownProvinceName();
        if (_cursor.isNull(_cursorIndexOfSTownName)) {
          _result.sTownName = null;
        } else {
          _result.sTownName = _cursor.getString(_cursorIndexOfSTownName);
        }
        if (_cursor.isNull(_cursorIndexOfSProvName)) {
          _result.sProvName = null;
        } else {
          _result.sProvName = _cursor.getString(_cursorIndexOfSProvName);
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
  public LiveData<DTownInfo.TownProvinceName> getLiveTownProvinceNames(final String TownID) {
    final String _sql = "SELECT a.sTownName, b.sProvName FROM Town_Info a LEFT JOIN Province_Info b ON a.sProvIDxx = b.sProvIDxx WHERE sTownIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TownID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TownID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info","Province_Info"}, false, new Callable<DTownInfo.TownProvinceName>() {
      @Override
      public DTownInfo.TownProvinceName call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTownName = 0;
          final int _cursorIndexOfSProvName = 1;
          final DTownInfo.TownProvinceName _result;
          if(_cursor.moveToFirst()) {
            _result = new DTownInfo.TownProvinceName();
            if (_cursor.isNull(_cursorIndexOfSTownName)) {
              _result.sTownName = null;
            } else {
              _result.sTownName = _cursor.getString(_cursorIndexOfSTownName);
            }
            if (_cursor.isNull(_cursorIndexOfSProvName)) {
              _result.sProvName = null;
            } else {
              _result.sProvName = _cursor.getString(_cursorIndexOfSProvName);
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
  public LiveData<DTownInfo.TownProvinceInfo> getTownProvinceByTownID(final String TownID) {
    final String _sql = "SELECT a.sTownIDxx, b.sProvIDxx, a.sTownName, b.sProvName FROM Town_Info a LEFT JOIN Province_Info b ON a.sProvIDxx = b.sProvIDxx WHERE sTownIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TownID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TownID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info","Province_Info"}, false, new Callable<DTownInfo.TownProvinceInfo>() {
      @Override
      public DTownInfo.TownProvinceInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTownIDxx = 0;
          final int _cursorIndexOfSProvIDxx = 1;
          final int _cursorIndexOfSTownName = 2;
          final int _cursorIndexOfSProvName = 3;
          final DTownInfo.TownProvinceInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new DTownInfo.TownProvinceInfo();
            if (_cursor.isNull(_cursorIndexOfSTownIDxx)) {
              _result.sTownIDxx = null;
            } else {
              _result.sTownIDxx = _cursor.getString(_cursorIndexOfSTownIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSProvIDxx)) {
              _result.sProvIDxx = null;
            } else {
              _result.sProvIDxx = _cursor.getString(_cursorIndexOfSProvIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSTownName)) {
              _result.sTownName = null;
            } else {
              _result.sTownName = _cursor.getString(_cursorIndexOfSTownName);
            }
            if (_cursor.isNull(_cursorIndexOfSProvName)) {
              _result.sProvName = null;
            } else {
              _result.sProvName = _cursor.getString(_cursorIndexOfSProvName);
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
  public LiveData<DTownInfo.TownProvinceInfo> getTownProvinceByTownName(final String TownNm) {
    final String _sql = "SELECT a.sTownIDxx, b.sProvIDxx, a.sTownName, b.sProvName FROM Town_Info a LEFT JOIN Province_Info b ON a.sProvIDxx = b.sProvIDxx WHERE sTownName =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TownNm == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TownNm);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info","Province_Info"}, false, new Callable<DTownInfo.TownProvinceInfo>() {
      @Override
      public DTownInfo.TownProvinceInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTownIDxx = 0;
          final int _cursorIndexOfSProvIDxx = 1;
          final int _cursorIndexOfSTownName = 2;
          final int _cursorIndexOfSProvName = 3;
          final DTownInfo.TownProvinceInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new DTownInfo.TownProvinceInfo();
            if (_cursor.isNull(_cursorIndexOfSTownIDxx)) {
              _result.sTownIDxx = null;
            } else {
              _result.sTownIDxx = _cursor.getString(_cursorIndexOfSTownIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSProvIDxx)) {
              _result.sProvIDxx = null;
            } else {
              _result.sProvIDxx = _cursor.getString(_cursorIndexOfSProvIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSTownName)) {
              _result.sTownName = null;
            } else {
              _result.sTownName = _cursor.getString(_cursorIndexOfSTownName);
            }
            if (_cursor.isNull(_cursorIndexOfSProvName)) {
              _result.sProvName = null;
            } else {
              _result.sProvName = _cursor.getString(_cursorIndexOfSProvName);
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
  public LiveData<DTownInfo.BrgyTownProvinceInfoWithID> getBrgyTownProvinceInfoWithID(
      final String BrgyID) {
    final String _sql = "SELECT a.sBrgyIDxx, a.sBrgyName, b.sTownIDxx, b.sTownName, c.sProvIDxx, c.sProvName FROM Barangay_Info a LEFT JOIN Town_Info b ON a.sTownIDxx = b.sTownIDxx LEFT JOIN Province_Info c ON b.sProvIDxx = c.sProvIDxx WHERE a.sBrgyIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BrgyID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BrgyID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Barangay_Info","Town_Info","Province_Info"}, false, new Callable<DTownInfo.BrgyTownProvinceInfoWithID>() {
      @Override
      public DTownInfo.BrgyTownProvinceInfoWithID call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSBrgyIDxx = 0;
          final int _cursorIndexOfSBrgyName = 1;
          final int _cursorIndexOfSTownIDxx = 2;
          final int _cursorIndexOfSTownName = 3;
          final int _cursorIndexOfSProvIDxx = 4;
          final int _cursorIndexOfSProvName = 5;
          final DTownInfo.BrgyTownProvinceInfoWithID _result;
          if(_cursor.moveToFirst()) {
            _result = new DTownInfo.BrgyTownProvinceInfoWithID();
            if (_cursor.isNull(_cursorIndexOfSBrgyIDxx)) {
              _result.sBrgyIDxx = null;
            } else {
              _result.sBrgyIDxx = _cursor.getString(_cursorIndexOfSBrgyIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyName)) {
              _result.sBrgyName = null;
            } else {
              _result.sBrgyName = _cursor.getString(_cursorIndexOfSBrgyName);
            }
            if (_cursor.isNull(_cursorIndexOfSTownIDxx)) {
              _result.sTownIDxx = null;
            } else {
              _result.sTownIDxx = _cursor.getString(_cursorIndexOfSTownIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSTownName)) {
              _result.sTownName = null;
            } else {
              _result.sTownName = _cursor.getString(_cursorIndexOfSTownName);
            }
            if (_cursor.isNull(_cursorIndexOfSProvIDxx)) {
              _result.sProvIDxx = null;
            } else {
              _result.sProvIDxx = _cursor.getString(_cursorIndexOfSProvIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSProvName)) {
              _result.sProvName = null;
            } else {
              _result.sProvName = _cursor.getString(_cursorIndexOfSProvName);
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
