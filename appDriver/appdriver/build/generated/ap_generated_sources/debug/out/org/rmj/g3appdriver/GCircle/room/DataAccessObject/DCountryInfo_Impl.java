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
import org.rmj.g3appdriver.GCircle.room.Entities.ECountryInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DCountryInfo_Impl implements DCountryInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ECountryInfo> __insertionAdapterOfECountryInfo;

  private final EntityInsertionAdapter<ECountryInfo> __insertionAdapterOfECountryInfo_1;

  private final EntityDeletionOrUpdateAdapter<ECountryInfo> __updateAdapterOfECountryInfo;

  public DCountryInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfECountryInfo = new EntityInsertionAdapter<ECountryInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Country_Info` (`sCntryCde`,`sCntryNme`,`sNational`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECountryInfo value) {
        if (value.getCntryCde() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCntryCde());
        }
        if (value.getCntryNme() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCntryNme());
        }
        if (value.getNational() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNational());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLstUpdte());
        }
      }
    };
    this.__insertionAdapterOfECountryInfo_1 = new EntityInsertionAdapter<ECountryInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Country_Info` (`sCntryCde`,`sCntryNme`,`sNational`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECountryInfo value) {
        if (value.getCntryCde() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCntryCde());
        }
        if (value.getCntryNme() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCntryNme());
        }
        if (value.getNational() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNational());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLstUpdte());
        }
      }
    };
    this.__updateAdapterOfECountryInfo = new EntityDeletionOrUpdateAdapter<ECountryInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Country_Info` SET `sCntryCde` = ?,`sCntryNme` = ?,`sNational` = ?,`cRecdStat` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sCntryCde` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECountryInfo value) {
        if (value.getCntryCde() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getCntryCde());
        }
        if (value.getCntryNme() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCntryNme());
        }
        if (value.getNational() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNational());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLstUpdte());
        }
        if (value.getCntryCde() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCntryCde());
        }
      }
    };
  }

  @Override
  public void insert(final ECountryInfo countryInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECountryInfo.insert(countryInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<ECountryInfo> countryInfos) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECountryInfo_1.insert(countryInfos);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ECountryInfo countryInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfECountryInfo.handle(countryInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public ECountryInfo GetCountryInfo(final String fsVal) {
    final String _sql = "SELECT * FROM Country_Info WHERE sCntryCde =?";
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
      final int _cursorIndexOfCntryCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sCntryCde");
      final int _cursorIndexOfCntryNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sCntryNme");
      final int _cursorIndexOfNational = CursorUtil.getColumnIndexOrThrow(_cursor, "sNational");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final ECountryInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new ECountryInfo();
        final String _tmpCntryCde;
        if (_cursor.isNull(_cursorIndexOfCntryCde)) {
          _tmpCntryCde = null;
        } else {
          _tmpCntryCde = _cursor.getString(_cursorIndexOfCntryCde);
        }
        _result.setCntryCde(_tmpCntryCde);
        final String _tmpCntryNme;
        if (_cursor.isNull(_cursorIndexOfCntryNme)) {
          _tmpCntryNme = null;
        } else {
          _tmpCntryNme = _cursor.getString(_cursorIndexOfCntryNme);
        }
        _result.setCntryNme(_tmpCntryNme);
        final String _tmpNational;
        if (_cursor.isNull(_cursorIndexOfNational)) {
          _tmpNational = null;
        } else {
          _tmpNational = _cursor.getString(_cursorIndexOfNational);
        }
        _result.setNational(_tmpNational);
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
  public ECountryInfo GetLatestCountryInfo() {
    final String _sql = "SELECT * FROM Country_Info ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfCntryCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sCntryCde");
      final int _cursorIndexOfCntryNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sCntryNme");
      final int _cursorIndexOfNational = CursorUtil.getColumnIndexOrThrow(_cursor, "sNational");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final ECountryInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new ECountryInfo();
        final String _tmpCntryCde;
        if (_cursor.isNull(_cursorIndexOfCntryCde)) {
          _tmpCntryCde = null;
        } else {
          _tmpCntryCde = _cursor.getString(_cursorIndexOfCntryCde);
        }
        _result.setCntryCde(_tmpCntryCde);
        final String _tmpCntryNme;
        if (_cursor.isNull(_cursorIndexOfCntryNme)) {
          _tmpCntryNme = null;
        } else {
          _tmpCntryNme = _cursor.getString(_cursorIndexOfCntryNme);
        }
        _result.setCntryNme(_tmpCntryNme);
        final String _tmpNational;
        if (_cursor.isNull(_cursorIndexOfNational)) {
          _tmpNational = null;
        } else {
          _tmpNational = _cursor.getString(_cursorIndexOfNational);
        }
        _result.setNational(_tmpNational);
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
  public LiveData<List<ECountryInfo>> getAllCountryInfo() {
    final String _sql = "SELECT * FROM Country_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Country_Info"}, false, new Callable<List<ECountryInfo>>() {
      @Override
      public List<ECountryInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfCntryCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sCntryCde");
          final int _cursorIndexOfCntryNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sCntryNme");
          final int _cursorIndexOfNational = CursorUtil.getColumnIndexOrThrow(_cursor, "sNational");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<ECountryInfo> _result = new ArrayList<ECountryInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ECountryInfo _item;
            _item = new ECountryInfo();
            final String _tmpCntryCde;
            if (_cursor.isNull(_cursorIndexOfCntryCde)) {
              _tmpCntryCde = null;
            } else {
              _tmpCntryCde = _cursor.getString(_cursorIndexOfCntryCde);
            }
            _item.setCntryCde(_tmpCntryCde);
            final String _tmpCntryNme;
            if (_cursor.isNull(_cursorIndexOfCntryNme)) {
              _tmpCntryNme = null;
            } else {
              _tmpCntryNme = _cursor.getString(_cursorIndexOfCntryNme);
            }
            _item.setCntryNme(_tmpCntryNme);
            final String _tmpNational;
            if (_cursor.isNull(_cursorIndexOfNational)) {
              _tmpNational = null;
            } else {
              _tmpNational = _cursor.getString(_cursorIndexOfNational);
            }
            _item.setNational(_tmpNational);
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
  public LiveData<String[]> getAllCountryNames() {
    final String _sql = "SELECT sCntryNme FROM Country_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Country_Info"}, false, new Callable<String[]>() {
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
  public LiveData<String[]> getAllCountryCitizenNames() {
    final String _sql = "SELECT sNational FROM Country_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Country_Info"}, false, new Callable<String[]>() {
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
    final String _sql = "SELECT MAX(dTimeStmp) FROM Country_Info";
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
  public ECountryInfo getCountryInfo(final String ID) {
    final String _sql = "SELECT * FROM Country_Info WHERE sCntryCde=?";
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
      final int _cursorIndexOfCntryCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sCntryCde");
      final int _cursorIndexOfCntryNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sCntryNme");
      final int _cursorIndexOfNational = CursorUtil.getColumnIndexOrThrow(_cursor, "sNational");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final ECountryInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new ECountryInfo();
        final String _tmpCntryCde;
        if (_cursor.isNull(_cursorIndexOfCntryCde)) {
          _tmpCntryCde = null;
        } else {
          _tmpCntryCde = _cursor.getString(_cursorIndexOfCntryCde);
        }
        _result.setCntryCde(_tmpCntryCde);
        final String _tmpCntryNme;
        if (_cursor.isNull(_cursorIndexOfCntryNme)) {
          _tmpCntryNme = null;
        } else {
          _tmpCntryNme = _cursor.getString(_cursorIndexOfCntryNme);
        }
        _result.setCntryNme(_tmpCntryNme);
        final String _tmpNational;
        if (_cursor.isNull(_cursorIndexOfNational)) {
          _tmpNational = null;
        } else {
          _tmpNational = _cursor.getString(_cursorIndexOfNational);
        }
        _result.setNational(_tmpNational);
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
  public LiveData<String> getClientCitizenship(final String CntryCde) {
    final String _sql = "SELECT sNational FROM Country_Info WHERE sCntryCde =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (CntryCde == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, CntryCde);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Country_Info"}, false, new Callable<String>() {
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
  public LiveData<String> getCountryNameFromId(final String fsCntryCd) {
    final String _sql = "SELECT sCntryNme FROM Country_Info WHERE sCntryCde =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsCntryCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsCntryCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Country_Info"}, false, new Callable<String>() {
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
