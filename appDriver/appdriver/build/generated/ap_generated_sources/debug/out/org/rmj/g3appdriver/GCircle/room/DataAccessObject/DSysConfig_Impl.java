package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import org.rmj.g3appdriver.GCircle.room.Entities.ESysConfig;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DSysConfig_Impl implements DSysConfig {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ESysConfig> __insertionAdapterOfESysConfig;

  private final EntityInsertionAdapter<ESysConfig> __insertionAdapterOfESysConfig_1;

  private final EntityDeletionOrUpdateAdapter<ESysConfig> __updateAdapterOfESysConfig;

  public DSysConfig_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfESysConfig = new EntityInsertionAdapter<ESysConfig>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `xxxSysConfig` (`sConfigCd`,`sConfigDs`,`sConfigVl`,`dTimeStmp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ESysConfig value) {
        if (value.getConfigCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConfigCd());
        }
        if (value.getConfigDs() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getConfigDs());
        }
        if (value.getConfigVl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getConfigVl());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfESysConfig_1 = new EntityInsertionAdapter<ESysConfig>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `xxxSysConfig` (`sConfigCd`,`sConfigDs`,`sConfigVl`,`dTimeStmp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ESysConfig value) {
        if (value.getConfigCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConfigCd());
        }
        if (value.getConfigDs() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getConfigDs());
        }
        if (value.getConfigVl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getConfigVl());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfESysConfig = new EntityDeletionOrUpdateAdapter<ESysConfig>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `xxxSysConfig` SET `sConfigCd` = ?,`sConfigDs` = ?,`sConfigVl` = ?,`dTimeStmp` = ? WHERE `sConfigCd` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ESysConfig value) {
        if (value.getConfigCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConfigCd());
        }
        if (value.getConfigDs() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getConfigDs());
        }
        if (value.getConfigVl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getConfigVl());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
        if (value.getConfigCd() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getConfigCd());
        }
      }
    };
  }

  @Override
  public void SaveSysConfig(final ESysConfig sysConfig) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfESysConfig.insert(sysConfig);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertSysConfig(final List<ESysConfig> sysConfigs) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfESysConfig_1.insert(sysConfigs);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateSysConfig(final ESysConfig foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfESysConfig.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public ESysConfig GetLatestSysConfig() {
    final String _sql = "SELECT * FROM xxxSysConfig ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfConfigCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sConfigCd");
      final int _cursorIndexOfConfigDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sConfigDs");
      final int _cursorIndexOfConfigVl = CursorUtil.getColumnIndexOrThrow(_cursor, "sConfigVl");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ESysConfig _result;
      if(_cursor.moveToFirst()) {
        _result = new ESysConfig();
        final String _tmpConfigCd;
        if (_cursor.isNull(_cursorIndexOfConfigCd)) {
          _tmpConfigCd = null;
        } else {
          _tmpConfigCd = _cursor.getString(_cursorIndexOfConfigCd);
        }
        _result.setConfigCd(_tmpConfigCd);
        final String _tmpConfigDs;
        if (_cursor.isNull(_cursorIndexOfConfigDs)) {
          _tmpConfigDs = null;
        } else {
          _tmpConfigDs = _cursor.getString(_cursorIndexOfConfigDs);
        }
        _result.setConfigDs(_tmpConfigDs);
        final String _tmpConfigVl;
        if (_cursor.isNull(_cursorIndexOfConfigVl)) {
          _tmpConfigVl = null;
        } else {
          _tmpConfigVl = _cursor.getString(_cursorIndexOfConfigVl);
        }
        _result.setConfigVl(_tmpConfigVl);
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
  public ESysConfig GetSysConfig(final String fsVal) {
    final String _sql = "SELECT * FROM xxxSysConfig WHERE sConfigCd =?";
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
      final int _cursorIndexOfConfigCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sConfigCd");
      final int _cursorIndexOfConfigDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sConfigDs");
      final int _cursorIndexOfConfigVl = CursorUtil.getColumnIndexOrThrow(_cursor, "sConfigVl");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ESysConfig _result;
      if(_cursor.moveToFirst()) {
        _result = new ESysConfig();
        final String _tmpConfigCd;
        if (_cursor.isNull(_cursorIndexOfConfigCd)) {
          _tmpConfigCd = null;
        } else {
          _tmpConfigCd = _cursor.getString(_cursorIndexOfConfigCd);
        }
        _result.setConfigCd(_tmpConfigCd);
        final String _tmpConfigDs;
        if (_cursor.isNull(_cursorIndexOfConfigDs)) {
          _tmpConfigDs = null;
        } else {
          _tmpConfigDs = _cursor.getString(_cursorIndexOfConfigDs);
        }
        _result.setConfigDs(_tmpConfigDs);
        final String _tmpConfigVl;
        if (_cursor.isNull(_cursorIndexOfConfigVl)) {
          _tmpConfigVl = null;
        } else {
          _tmpConfigVl = _cursor.getString(_cursorIndexOfConfigVl);
        }
        _result.setConfigVl(_tmpConfigVl);
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
  public String getLocationInterval() {
    final String _sql = "SELECT sConfigVl FROM xxxSysConfig WHERE sConfigCd = 'dcp.coordinates.capturing.interval'";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
