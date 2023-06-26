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
import org.rmj.g3appdriver.GCircle.room.Entities.EMcBrand;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DMcBrand_Impl implements DMcBrand {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EMcBrand> __insertionAdapterOfEMcBrand;

  private final EntityInsertionAdapter<EMcBrand> __insertionAdapterOfEMcBrand_1;

  private final EntityDeletionOrUpdateAdapter<EMcBrand> __updateAdapterOfEMcBrand;

  public DMcBrand_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEMcBrand = new EntityInsertionAdapter<EMcBrand>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MC_Brand` (`sBrandIDx`,`sBrandNme`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcBrand value) {
        if (value.getBrandIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBrandIDx());
        }
        if (value.getBrandNme() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBrandNme());
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
    this.__insertionAdapterOfEMcBrand_1 = new EntityInsertionAdapter<EMcBrand>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MC_Brand` (`sBrandIDx`,`sBrandNme`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcBrand value) {
        if (value.getBrandIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBrandIDx());
        }
        if (value.getBrandNme() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBrandNme());
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
    this.__updateAdapterOfEMcBrand = new EntityDeletionOrUpdateAdapter<EMcBrand>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MC_Brand` SET `sBrandIDx` = ?,`sBrandNme` = ?,`cRecdStat` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sBrandIDx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcBrand value) {
        if (value.getBrandIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBrandIDx());
        }
        if (value.getBrandNme() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBrandNme());
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
        if (value.getBrandIDx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getBrandIDx());
        }
      }
    };
  }

  @Override
  public void insert(final EMcBrand mcBrand) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMcBrand.insert(mcBrand);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EMcBrand> brands) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMcBrand_1.insert(brands);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EMcBrand mcBrand) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEMcBrand.handle(mcBrand);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public EMcBrand GetBrandInfo(final String fsVal) {
    final String _sql = "SELECT * FROM MC_Brand WHERE sBrandIDx =?";
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
      final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
      final int _cursorIndexOfBrandNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandNme");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EMcBrand _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcBrand();
        final String _tmpBrandIDx;
        if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
          _tmpBrandIDx = null;
        } else {
          _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
        }
        _result.setBrandIDx(_tmpBrandIDx);
        final String _tmpBrandNme;
        if (_cursor.isNull(_cursorIndexOfBrandNme)) {
          _tmpBrandNme = null;
        } else {
          _tmpBrandNme = _cursor.getString(_cursorIndexOfBrandNme);
        }
        _result.setBrandNme(_tmpBrandNme);
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
  public EMcBrand GetLatestBrandInfo() {
    final String _sql = "SELECT * FROM MC_Brand ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
      final int _cursorIndexOfBrandNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandNme");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EMcBrand _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcBrand();
        final String _tmpBrandIDx;
        if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
          _tmpBrandIDx = null;
        } else {
          _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
        }
        _result.setBrandIDx(_tmpBrandIDx);
        final String _tmpBrandNme;
        if (_cursor.isNull(_cursorIndexOfBrandNme)) {
          _tmpBrandNme = null;
        } else {
          _tmpBrandNme = _cursor.getString(_cursorIndexOfBrandNme);
        }
        _result.setBrandNme(_tmpBrandNme);
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
  public LiveData<List<EMcBrand>> getAllMcBrand() {
    final String _sql = "SELECT * FROM MC_Brand";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Brand"}, false, new Callable<List<EMcBrand>>() {
      @Override
      public List<EMcBrand> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
          final int _cursorIndexOfBrandNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandNme");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EMcBrand> _result = new ArrayList<EMcBrand>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMcBrand _item;
            _item = new EMcBrand();
            final String _tmpBrandIDx;
            if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
              _tmpBrandIDx = null;
            } else {
              _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
            }
            _item.setBrandIDx(_tmpBrandIDx);
            final String _tmpBrandNme;
            if (_cursor.isNull(_cursorIndexOfBrandNme)) {
              _tmpBrandNme = null;
            } else {
              _tmpBrandNme = _cursor.getString(_cursorIndexOfBrandNme);
            }
            _item.setBrandNme(_tmpBrandNme);
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
  public LiveData<String[]> getAllBrandName() {
    final String _sql = "SELECT sBrandNme FROM MC_Brand";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Brand"}, false, new Callable<String[]>() {
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
    final String _sql = "SELECT MAX(dTimeStmp) FROM MC_Brand";
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
  public EMcBrand getMcBrandInfo(final String BrandID) {
    final String _sql = "SELECT * FROM MC_Brand WHERE sBrandIDx=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BrandID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BrandID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
      final int _cursorIndexOfBrandNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandNme");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EMcBrand _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcBrand();
        final String _tmpBrandIDx;
        if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
          _tmpBrandIDx = null;
        } else {
          _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
        }
        _result.setBrandIDx(_tmpBrandIDx);
        final String _tmpBrandNme;
        if (_cursor.isNull(_cursorIndexOfBrandNme)) {
          _tmpBrandNme = null;
        } else {
          _tmpBrandNme = _cursor.getString(_cursorIndexOfBrandNme);
        }
        _result.setBrandNme(_tmpBrandNme);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
