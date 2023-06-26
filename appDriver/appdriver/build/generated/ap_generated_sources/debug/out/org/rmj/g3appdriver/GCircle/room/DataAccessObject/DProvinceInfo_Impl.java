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
import org.rmj.g3appdriver.GCircle.room.Entities.EProvinceInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DProvinceInfo_Impl implements DProvinceInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EProvinceInfo> __insertionAdapterOfEProvinceInfo;

  private final EntityDeletionOrUpdateAdapter<EProvinceInfo> __updateAdapterOfEProvinceInfo;

  public DProvinceInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEProvinceInfo = new EntityInsertionAdapter<EProvinceInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Province_Info` (`sProvIDxx`,`sProvName`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EProvinceInfo value) {
        if (value.getProvIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getProvIDxx());
        }
        if (value.getProvName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProvName());
        }
        stmt.bindLong(3, value.getRecdStat());
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
    this.__updateAdapterOfEProvinceInfo = new EntityDeletionOrUpdateAdapter<EProvinceInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Province_Info` SET `sProvIDxx` = ?,`sProvName` = ?,`cRecdStat` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sProvIDxx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EProvinceInfo value) {
        if (value.getProvIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getProvIDxx());
        }
        if (value.getProvName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProvName());
        }
        stmt.bindLong(3, value.getRecdStat());
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
        if (value.getProvIDxx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProvIDxx());
        }
      }
    };
  }

  @Override
  public void insert(final EProvinceInfo provinceInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEProvinceInfo.insert(provinceInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EProvinceInfo> provinceInfoList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEProvinceInfo.insert(provinceInfoList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EProvinceInfo provinceInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEProvinceInfo.handle(provinceInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Integer GetProvinceRecordsCount() {
    final String _sql = "SELECT COUNT(*) FROM Province_Info";
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
  public EProvinceInfo GetLatestProvince() {
    final String _sql = "SELECT * FROM Province_Info ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
      final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EProvinceInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EProvinceInfo();
        final String _tmpProvIDxx;
        if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
          _tmpProvIDxx = null;
        } else {
          _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
        }
        _result.setProvIDxx(_tmpProvIDxx);
        final String _tmpProvName;
        if (_cursor.isNull(_cursorIndexOfProvName)) {
          _tmpProvName = null;
        } else {
          _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
        }
        _result.setProvName(_tmpProvName);
        final char _tmpRecdStat;
        _tmpRecdStat = (char) (_cursor.getInt(_cursorIndexOfRecdStat));
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
  public EProvinceInfo GetProvince(final String fsVal) {
    final String _sql = "SELECT * FROM Province_Info WHERE sProvIDxx=?";
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
      final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
      final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EProvinceInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EProvinceInfo();
        final String _tmpProvIDxx;
        if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
          _tmpProvIDxx = null;
        } else {
          _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
        }
        _result.setProvIDxx(_tmpProvIDxx);
        final String _tmpProvName;
        if (_cursor.isNull(_cursorIndexOfProvName)) {
          _tmpProvName = null;
        } else {
          _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
        }
        _result.setProvName(_tmpProvName);
        final char _tmpRecdStat;
        _tmpRecdStat = (char) (_cursor.getInt(_cursorIndexOfRecdStat));
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
  public LiveData<List<EProvinceInfo>> getAllProvinceInfo() {
    final String _sql = "SELECT * FROM Province_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Province_Info"}, false, new Callable<List<EProvinceInfo>>() {
      @Override
      public List<EProvinceInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
          final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EProvinceInfo> _result = new ArrayList<EProvinceInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EProvinceInfo _item;
            _item = new EProvinceInfo();
            final String _tmpProvIDxx;
            if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
              _tmpProvIDxx = null;
            } else {
              _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
            }
            _item.setProvIDxx(_tmpProvIDxx);
            final String _tmpProvName;
            if (_cursor.isNull(_cursorIndexOfProvName)) {
              _tmpProvName = null;
            } else {
              _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
            }
            _item.setProvName(_tmpProvName);
            final char _tmpRecdStat;
            _tmpRecdStat = (char) (_cursor.getInt(_cursorIndexOfRecdStat));
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
  public LiveData<List<EProvinceInfo>> getAllProvinceName() {
    final String _sql = "SELECT * FROM Province_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Province_Info"}, false, new Callable<List<EProvinceInfo>>() {
      @Override
      public List<EProvinceInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
          final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EProvinceInfo> _result = new ArrayList<EProvinceInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EProvinceInfo _item;
            _item = new EProvinceInfo();
            final String _tmpProvIDxx;
            if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
              _tmpProvIDxx = null;
            } else {
              _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
            }
            _item.setProvIDxx(_tmpProvIDxx);
            final String _tmpProvName;
            if (_cursor.isNull(_cursorIndexOfProvName)) {
              _tmpProvName = null;
            } else {
              _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
            }
            _item.setProvName(_tmpProvName);
            final char _tmpRecdStat;
            _tmpRecdStat = (char) (_cursor.getInt(_cursorIndexOfRecdStat));
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
  public LiveData<String[]> getAllProvinceNames() {
    final String _sql = "SELECT sProvName FROM Province_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Province_Info"}, false, new Callable<String[]>() {
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
  public LiveData<List<EProvinceInfo>> searchProvinceName(final String ProvinceName) {
    final String _sql = "SELECT * FROM Province_Info WHERE sProvName LIKE?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ProvinceName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ProvinceName);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Province_Info"}, false, new Callable<List<EProvinceInfo>>() {
      @Override
      public List<EProvinceInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
          final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EProvinceInfo> _result = new ArrayList<EProvinceInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EProvinceInfo _item;
            _item = new EProvinceInfo();
            final String _tmpProvIDxx;
            if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
              _tmpProvIDxx = null;
            } else {
              _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
            }
            _item.setProvIDxx(_tmpProvIDxx);
            final String _tmpProvName;
            if (_cursor.isNull(_cursorIndexOfProvName)) {
              _tmpProvName = null;
            } else {
              _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
            }
            _item.setProvName(_tmpProvName);
            final char _tmpRecdStat;
            _tmpRecdStat = (char) (_cursor.getInt(_cursorIndexOfRecdStat));
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
  public LiveData<String> getProvinceNameFromProvID(final String provID) {
    final String _sql = "SELECT sProvName FROM Province_Info WHERE sProvIDxx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (provID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, provID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Province_Info"}, false, new Callable<String>() {
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
  public String getLatestDataTime() {
    final String _sql = "SELECT MAX(dTimeStmp) FROM Province_Info";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
