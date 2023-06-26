package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
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
import org.rmj.g3appdriver.GConnect.room.Entities.EBarangayInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.ECountryInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.EProvinceInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.ETownInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAddress_Impl implements DAddress {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EBarangayInfo> __insertionAdapterOfEBarangayInfo;

  private final EntityInsertionAdapter<ETownInfo> __insertionAdapterOfETownInfo;

  private final EntityInsertionAdapter<EProvinceInfo> __insertionAdapterOfEProvinceInfo;

  private final EntityInsertionAdapter<ECountryInfo> __insertionAdapterOfECountryInfo;

  public DAddress_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEBarangayInfo = new EntityInsertionAdapter<EBarangayInfo>(__db) {
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
    this.__insertionAdapterOfETownInfo = new EntityInsertionAdapter<ETownInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Town_Info` (`sTownIDxx`,`sTownName`,`sZippCode`,`sProvIDxx`,`sProvCode`,`sMuncplCd`,`cHasRoute`,`cBlackLst`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?)";
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
    this.__insertionAdapterOfEProvinceInfo = new EntityInsertionAdapter<EProvinceInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Province_Info` (`sProvIDxx`,`sProvName`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?)";
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
    this.__insertionAdapterOfECountryInfo = new EntityInsertionAdapter<ECountryInfo>(__db) {
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
  }

  @Override
  public void SaveBarangay(final List<EBarangayInfo> foValue) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBarangayInfo.insert(foValue);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void SaveTown(final List<ETownInfo> foValue) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfETownInfo.insert(foValue);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void SaveProvince(final List<EProvinceInfo> foValue) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEProvinceInfo.insert(foValue);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void SaveCountry(final List<ECountryInfo> foValue) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECountryInfo.insert(foValue);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<EBarangayInfo>> GetBarangayList(final String TownID) {
    final String _sql = "SELECT * FROM Barangay_Info WHERE sTownIDxx =?";
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
  public LiveData<List<ECountryInfo>> GetCountryList() {
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
  public LiveData<String> GetBrgyName(final String fsBrgyID) {
    final String _sql = "SELECT sBrgyName FROM Barangay_Info WHERE sBrgyIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsBrgyID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsBrgyID);
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
  public LiveData<String> GetTownProvName(final String fsTownID) {
    final String _sql = "SELECT a.sTownName || ', ' || b.sProvName FROM Town_Info a LEFT JOIN Province_Info b ON a.sProvIDxx = b.sProvIDxx WHERE a.sTownIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsTownID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsTownID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info","Province_Info"}, false, new Callable<String>() {
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
  public LiveData<String> GetFullAddressName(final String fsBrgyID) {
    final String _sql = "SELECT a.sBrgyName || ', ' || b.sTownName || ', ' || c.sProvName FROM Barangay_Info a LEFT JOIN Town_Info b ON a.sTownIDxx = b.sTownIDxx LEFT JOIN Province_Info c ON b.sProvIDxx = c.sProvIDxx WHERE a.sBrgyIDxx=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsBrgyID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsBrgyID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Barangay_Info","Town_Info","Province_Info"}, false, new Callable<String>() {
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
  public LiveData<List<DAddress.oTownObj>> GetTownList() {
    final String _sql = "SELECT a.sTownIDxx AS sTownID, a.sTownName AS sTownNm, b.sProvName AS sProvNm FROM Town_Info a LEFT JOIN Province_Info b ON a.sProvIDxx = b.sProvIDxx";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info","Province_Info"}, false, new Callable<List<DAddress.oTownObj>>() {
      @Override
      public List<DAddress.oTownObj> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTownID = 0;
          final int _cursorIndexOfSTownNm = 1;
          final int _cursorIndexOfSProvNm = 2;
          final List<DAddress.oTownObj> _result = new ArrayList<DAddress.oTownObj>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DAddress.oTownObj _item;
            _item = new DAddress.oTownObj();
            if (_cursor.isNull(_cursorIndexOfSTownID)) {
              _item.sTownID = null;
            } else {
              _item.sTownID = _cursor.getString(_cursorIndexOfSTownID);
            }
            if (_cursor.isNull(_cursorIndexOfSTownNm)) {
              _item.sTownNm = null;
            } else {
              _item.sTownNm = _cursor.getString(_cursorIndexOfSTownNm);
            }
            if (_cursor.isNull(_cursorIndexOfSProvNm)) {
              _item.sProvNm = null;
            } else {
              _item.sProvNm = _cursor.getString(_cursorIndexOfSProvNm);
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
  public String GetBarangayName(final String args) {
    final String _sql = "SELECT sBrgyName FROM Barangay_Info WHERE sBrgyIDxx =?";
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
  public String GetTownProvinceName(final String args) {
    final String _sql = "SELECT a.sTownName || ', ' || b.sProvName FROM Town_Info a LEFT JOIN Province_Info b ON a.sProvIDxx = b.sProvIDxx WHERE sTownIDxx =?";
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
  public int CheckBarangayInfo() {
    final String _sql = "SELECT COUNT(sBrgyIDxx) FROM Barangay_Info";
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
  public int CheckTownInfo() {
    final String _sql = "SELECT COUNT(sTownIDxx) FROM Town_Info";
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
  public int CheckProvinceInfo() {
    final String _sql = "SELECT COUNT(sProvIDxx) FROM Province_Info";
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
  public int CheckCountryInfo() {
    final String _sql = "SELECT COUNT(sCntryCde) FROM Country_Info";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
