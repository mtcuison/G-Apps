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
import org.rmj.g3appdriver.GCircle.room.Entities.EBarangayInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DBarangayInfo_Impl implements DBarangayInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EBarangayInfo> __insertionAdapterOfEBarangayInfo;

  private final EntityInsertionAdapter<EBarangayInfo> __insertionAdapterOfEBarangayInfo_1;

  private final EntityDeletionOrUpdateAdapter<EBarangayInfo> __updateAdapterOfEBarangayInfo;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllBarangayInfo;

  public DBarangayInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEBarangayInfo = new EntityInsertionAdapter<EBarangayInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Barangay_Info` (`sBrgyIDxx`,`sBrgyName`,`sTownIDxx`,`cHasRoute`,`cBlackLst`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBarangayInfo value) {
        if (value.getBrgyIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBrgyIDxx());
        }
        if (value.getBrgyName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBrgyName());
        }
        if (value.getTownIDxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTownIDxx());
        }
        if (value.getHasRoute() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getHasRoute());
        }
        if (value.getBlackLst() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBlackLst());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfEBarangayInfo_1 = new EntityInsertionAdapter<EBarangayInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Barangay_Info` (`sBrgyIDxx`,`sBrgyName`,`sTownIDxx`,`cHasRoute`,`cBlackLst`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBarangayInfo value) {
        if (value.getBrgyIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBrgyIDxx());
        }
        if (value.getBrgyName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBrgyName());
        }
        if (value.getTownIDxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTownIDxx());
        }
        if (value.getHasRoute() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getHasRoute());
        }
        if (value.getBlackLst() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBlackLst());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEBarangayInfo = new EntityDeletionOrUpdateAdapter<EBarangayInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Barangay_Info` SET `sBrgyIDxx` = ?,`sBrgyName` = ?,`sTownIDxx` = ?,`cHasRoute` = ?,`cBlackLst` = ?,`cRecdStat` = ?,`dTimeStmp` = ? WHERE `sBrgyIDxx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBarangayInfo value) {
        if (value.getBrgyIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBrgyIDxx());
        }
        if (value.getBrgyName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBrgyName());
        }
        if (value.getTownIDxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTownIDxx());
        }
        if (value.getHasRoute() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getHasRoute());
        }
        if (value.getBlackLst() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBlackLst());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStmp());
        }
        if (value.getBrgyIDxx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBrgyIDxx());
        }
      }
    };
    this.__preparedStmtOfDeleteAllBarangayInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Barangay_Info";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EBarangayInfo barangayInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBarangayInfo.insert(barangayInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkBarangayData(final List<EBarangayInfo> barangayInfoList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBarangayInfo_1.insert(barangayInfoList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EBarangayInfo barangayInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEBarangayInfo.handle(barangayInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllBarangayInfo() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllBarangayInfo.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllBarangayInfo.release(_stmt);
    }
  }

  @Override
  public EBarangayInfo GetBarangayInfo(final String fsVal) {
    final String _sql = "SELECT * FROM Barangay_Info WHERE sBrgyIDxx =?";
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
      final int _cursorIndexOfBrgyIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDxx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
      final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EBarangayInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EBarangayInfo();
        final String _tmpBrgyIDxx;
        if (_cursor.isNull(_cursorIndexOfBrgyIDxx)) {
          _tmpBrgyIDxx = null;
        } else {
          _tmpBrgyIDxx = _cursor.getString(_cursorIndexOfBrgyIDxx);
        }
        _result.setBrgyIDxx(_tmpBrgyIDxx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _result.setBrgyName(_tmpBrgyName);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _result.setTownIDxx(_tmpTownIDxx);
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
  public EBarangayInfo GetLatestBarangayInfo() {
    final String _sql = "SELECT * FROM Barangay_Info ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBrgyIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDxx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
      final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EBarangayInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EBarangayInfo();
        final String _tmpBrgyIDxx;
        if (_cursor.isNull(_cursorIndexOfBrgyIDxx)) {
          _tmpBrgyIDxx = null;
        } else {
          _tmpBrgyIDxx = _cursor.getString(_cursorIndexOfBrgyIDxx);
        }
        _result.setBrgyIDxx(_tmpBrgyIDxx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _result.setBrgyName(_tmpBrgyName);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _result.setTownIDxx(_tmpTownIDxx);
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
  public Integer GetBarangayRecordCount() {
    final String _sql = "SELECT COUNT(*) FROM Barangay_Info";
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
  public EBarangayInfo CheckIfExist(final String fsVal) {
    final String _sql = "SELECT * FROM Barangay_Info WHERE sBrgyIDxx=?";
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
      final int _cursorIndexOfBrgyIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDxx");
      final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
      final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EBarangayInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EBarangayInfo();
        final String _tmpBrgyIDxx;
        if (_cursor.isNull(_cursorIndexOfBrgyIDxx)) {
          _tmpBrgyIDxx = null;
        } else {
          _tmpBrgyIDxx = _cursor.getString(_cursorIndexOfBrgyIDxx);
        }
        _result.setBrgyIDxx(_tmpBrgyIDxx);
        final String _tmpBrgyName;
        if (_cursor.isNull(_cursorIndexOfBrgyName)) {
          _tmpBrgyName = null;
        } else {
          _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
        }
        _result.setBrgyName(_tmpBrgyName);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _result.setTownIDxx(_tmpTownIDxx);
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
  public LiveData<List<EBarangayInfo>> getAllBarangayInfo() {
    final String _sql = "SELECT * FROM Barangay_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Barangay_Info"}, false, new Callable<List<EBarangayInfo>>() {
      @Override
      public List<EBarangayInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBrgyIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDxx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
          final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBarangayInfo> _result = new ArrayList<EBarangayInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBarangayInfo _item;
            _item = new EBarangayInfo();
            final String _tmpBrgyIDxx;
            if (_cursor.isNull(_cursorIndexOfBrgyIDxx)) {
              _tmpBrgyIDxx = null;
            } else {
              _tmpBrgyIDxx = _cursor.getString(_cursorIndexOfBrgyIDxx);
            }
            _item.setBrgyIDxx(_tmpBrgyIDxx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _item.setBrgyName(_tmpBrgyName);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
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
    final String _sql = "SELECT MAX(dTimeStmp) FROM Barangay_Info";
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
  public LiveData<List<EBarangayInfo>> getAllBarangayInfoFromTown(final String TownID) {
    final String _sql = "SELECT * FROM Barangay_Info WHERE sTownIDxx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TownID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TownID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Barangay_Info"}, false, new Callable<List<EBarangayInfo>>() {
      @Override
      public List<EBarangayInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBrgyIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDxx");
          final int _cursorIndexOfBrgyName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyName");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
          final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBarangayInfo> _result = new ArrayList<EBarangayInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBarangayInfo _item;
            _item = new EBarangayInfo();
            final String _tmpBrgyIDxx;
            if (_cursor.isNull(_cursorIndexOfBrgyIDxx)) {
              _tmpBrgyIDxx = null;
            } else {
              _tmpBrgyIDxx = _cursor.getString(_cursorIndexOfBrgyIDxx);
            }
            _item.setBrgyIDxx(_tmpBrgyIDxx);
            final String _tmpBrgyName;
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _tmpBrgyName = null;
            } else {
              _tmpBrgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            _item.setBrgyName(_tmpBrgyName);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
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
  public LiveData<String[]> getAllBarangayNameFromTown(final String TownID) {
    final String _sql = "SELECT sBrgyName FROM Barangay_Info WHERE sTownIDxx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TownID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TownID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Barangay_Info"}, false, new Callable<String[]>() {
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
  public LiveData<String> getBarangayInfoFromID(final String fsID) {
    final String _sql = "SELECT sBrgyName FROM Barangay_Info WHERE sBrgyIDxx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Barangay_Info"}, false, new Callable<String>() {
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
  public DBarangayInfo.BrgyTownProvNames getBrgyTownProvName(final String BrgyID) {
    final String _sql = "SELECT a.sBrgyName, b.sTownName, c.sProvName FROM Barangay_Info a LEFT JOIN Town_Info b ON a.sTownIDxx = b.sTownIDxx LEFT JOIN Province_Info c ON b.sProvIDxx = c.sProvIDxx WHERE a.sBrgyIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BrgyID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BrgyID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfSBrgyName = 0;
      final int _cursorIndexOfSTownName = 1;
      final int _cursorIndexOfSProvName = 2;
      final DBarangayInfo.BrgyTownProvNames _result;
      if(_cursor.moveToFirst()) {
        _result = new DBarangayInfo.BrgyTownProvNames();
        if (_cursor.isNull(_cursorIndexOfSBrgyName)) {
          _result.sBrgyName = null;
        } else {
          _result.sBrgyName = _cursor.getString(_cursorIndexOfSBrgyName);
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
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
