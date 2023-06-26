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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EOccupationInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DOccupationInfo_Impl implements DOccupationInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EOccupationInfo> __insertionAdapterOfEOccupationInfo;

  private final EntityDeletionOrUpdateAdapter<EOccupationInfo> __updateAdapterOfEOccupationInfo;

  public DOccupationInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEOccupationInfo = new EntityInsertionAdapter<EOccupationInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Occupation_Info` (`sOccptnID`,`sOccptnNm`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EOccupationInfo value) {
        if (value.getOccptnID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getOccptnID());
        }
        if (value.getOccptnNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOccptnNm());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLstUpdte());
        }
      }
    };
    this.__updateAdapterOfEOccupationInfo = new EntityDeletionOrUpdateAdapter<EOccupationInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Occupation_Info` SET `sOccptnID` = ?,`sOccptnNm` = ?,`cRecdStat` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sOccptnID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EOccupationInfo value) {
        if (value.getOccptnID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getOccptnID());
        }
        if (value.getOccptnNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getOccptnNm());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLstUpdte());
        }
        if (value.getOccptnID() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getOccptnID());
        }
      }
    };
  }

  @Override
  public void insertBulkData(final List<EOccupationInfo> occupationInfos) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEOccupationInfo.insert(occupationInfos);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void SaveOccupation(final EOccupationInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEOccupationInfo.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EOccupationInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEOccupationInfo.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public EOccupationInfo GetLatestDataInfo() {
    final String _sql = "SELECT * FROM Occupation_Info ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfOccptnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sOccptnID");
      final int _cursorIndexOfOccptnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sOccptnNm");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EOccupationInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EOccupationInfo();
        final String _tmpOccptnID;
        if (_cursor.isNull(_cursorIndexOfOccptnID)) {
          _tmpOccptnID = null;
        } else {
          _tmpOccptnID = _cursor.getString(_cursorIndexOfOccptnID);
        }
        _result.setOccptnID(_tmpOccptnID);
        final String _tmpOccptnNm;
        if (_cursor.isNull(_cursorIndexOfOccptnNm)) {
          _tmpOccptnNm = null;
        } else {
          _tmpOccptnNm = _cursor.getString(_cursorIndexOfOccptnNm);
        }
        _result.setOccptnNm(_tmpOccptnNm);
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
      _statement.release();
    }
  }

  @Override
  public Integer GetOccupationRecordsCount() {
    final String _sql = "SELECT COUNT(*) FROM Occupation_Info";
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
  public EOccupationInfo GetOccupationInfo(final String fsVal) {
    final String _sql = "SELECT * FROM Occupation_Info WHERE sOccptnID=?";
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
      final int _cursorIndexOfOccptnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sOccptnID");
      final int _cursorIndexOfOccptnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sOccptnNm");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EOccupationInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EOccupationInfo();
        final String _tmpOccptnID;
        if (_cursor.isNull(_cursorIndexOfOccptnID)) {
          _tmpOccptnID = null;
        } else {
          _tmpOccptnID = _cursor.getString(_cursorIndexOfOccptnID);
        }
        _result.setOccptnID(_tmpOccptnID);
        final String _tmpOccptnNm;
        if (_cursor.isNull(_cursorIndexOfOccptnNm)) {
          _tmpOccptnNm = null;
        } else {
          _tmpOccptnNm = _cursor.getString(_cursorIndexOfOccptnNm);
        }
        _result.setOccptnNm(_tmpOccptnNm);
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
      _statement.release();
    }
  }

  @Override
  public LiveData<List<EOccupationInfo>> getAllOccupationInfo() {
    final String _sql = "SELECT * FROM Occupation_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Occupation_Info"}, false, new Callable<List<EOccupationInfo>>() {
      @Override
      public List<EOccupationInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOccptnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sOccptnID");
          final int _cursorIndexOfOccptnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sOccptnNm");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EOccupationInfo> _result = new ArrayList<EOccupationInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EOccupationInfo _item;
            _item = new EOccupationInfo();
            final String _tmpOccptnID;
            if (_cursor.isNull(_cursorIndexOfOccptnID)) {
              _tmpOccptnID = null;
            } else {
              _tmpOccptnID = _cursor.getString(_cursorIndexOfOccptnID);
            }
            _item.setOccptnID(_tmpOccptnID);
            final String _tmpOccptnNm;
            if (_cursor.isNull(_cursorIndexOfOccptnNm)) {
              _tmpOccptnNm = null;
            } else {
              _tmpOccptnNm = _cursor.getString(_cursorIndexOfOccptnNm);
            }
            _item.setOccptnNm(_tmpOccptnNm);
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
  public LiveData<EOccupationInfo> getOccupationInfo(final String OccupationName) {
    final String _sql = "SELECT * FROM Occupation_Info WHERE sOccptnNm = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (OccupationName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, OccupationName);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Occupation_Info"}, false, new Callable<EOccupationInfo>() {
      @Override
      public EOccupationInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfOccptnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sOccptnID");
          final int _cursorIndexOfOccptnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sOccptnNm");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final EOccupationInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EOccupationInfo();
            final String _tmpOccptnID;
            if (_cursor.isNull(_cursorIndexOfOccptnID)) {
              _tmpOccptnID = null;
            } else {
              _tmpOccptnID = _cursor.getString(_cursorIndexOfOccptnID);
            }
            _result.setOccptnID(_tmpOccptnID);
            final String _tmpOccptnNm;
            if (_cursor.isNull(_cursorIndexOfOccptnNm)) {
              _tmpOccptnNm = null;
            } else {
              _tmpOccptnNm = _cursor.getString(_cursorIndexOfOccptnNm);
            }
            _result.setOccptnNm(_tmpOccptnNm);
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
  public LiveData<String[]> getOccupationNameList() {
    final String _sql = "SELECT sOccptnNm FROM Occupation_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Occupation_Info"}, false, new Callable<String[]>() {
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
  public String getLatestDataTime() {
    final String _sql = "SELECT MAX(dTimeStmp) FROM Occupation_Info";
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
  public String getOccupationName(final String ID) {
    final String _sql = "SELECT sOccptnNm FROM Occupation_Info WHERE sOccptnID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ID);
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
  public LiveData<String> getLiveOccupationName(final String ID) {
    final String _sql = "SELECT sOccptnNm FROM Occupation_Info WHERE sOccptnID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Occupation_Info"}, false, new Callable<String>() {
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
