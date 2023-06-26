package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GConnect.room.Entities.EServiceInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DServiceInfo_Impl implements DServiceInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EServiceInfo> __insertionAdapterOfEServiceInfo;

  private final EntityDeletionOrUpdateAdapter<EServiceInfo> __updateAdapterOfEServiceInfo;

  public DServiceInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEServiceInfo = new EntityInsertionAdapter<EServiceInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MC_Service` (`sGCardNox`,`sSerialID`,`sEngineNo`,`sFrameNox`,`sBrandNme`,`sModelNme`,`cFSEPStat`,`dPurchase`,`nYellowxx`,`nWhitexxx`,`nYlwCtrxx`,`nWhtCtrxx`,`dLastSrvc`,`nMIlAgexx`,`dNxtRmnds`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EServiceInfo value) {
        if (value.getGCardNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGCardNox());
        }
        if (value.getSerialID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSerialID());
        }
        if (value.getEngineNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEngineNo());
        }
        if (value.getFrameNox() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFrameNox());
        }
        if (value.getBrandNme() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBrandNme());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModelNme());
        }
        if (value.getFSEPStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFSEPStat());
        }
        if (value.getPurchase() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPurchase());
        }
        stmt.bindLong(9, value.getYellowxx());
        stmt.bindLong(10, value.getWhitexxx());
        stmt.bindLong(11, value.getYlwCtrxx());
        stmt.bindLong(12, value.getWhtCtrxx());
        if (value.getLastSrvc() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLastSrvc());
        }
        stmt.bindLong(14, value.getMIlAgexx());
        if (value.getNxtRmnds() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getNxtRmnds());
        }
      }
    };
    this.__updateAdapterOfEServiceInfo = new EntityDeletionOrUpdateAdapter<EServiceInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MC_Service` SET `sGCardNox` = ?,`sSerialID` = ?,`sEngineNo` = ?,`sFrameNox` = ?,`sBrandNme` = ?,`sModelNme` = ?,`cFSEPStat` = ?,`dPurchase` = ?,`nYellowxx` = ?,`nWhitexxx` = ?,`nYlwCtrxx` = ?,`nWhtCtrxx` = ?,`dLastSrvc` = ?,`nMIlAgexx` = ?,`dNxtRmnds` = ? WHERE `sGCardNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EServiceInfo value) {
        if (value.getGCardNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGCardNox());
        }
        if (value.getSerialID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSerialID());
        }
        if (value.getEngineNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEngineNo());
        }
        if (value.getFrameNox() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFrameNox());
        }
        if (value.getBrandNme() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBrandNme());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getModelNme());
        }
        if (value.getFSEPStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getFSEPStat());
        }
        if (value.getPurchase() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPurchase());
        }
        stmt.bindLong(9, value.getYellowxx());
        stmt.bindLong(10, value.getWhitexxx());
        stmt.bindLong(11, value.getYlwCtrxx());
        stmt.bindLong(12, value.getWhtCtrxx());
        if (value.getLastSrvc() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLastSrvc());
        }
        stmt.bindLong(14, value.getMIlAgexx());
        if (value.getNxtRmnds() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getNxtRmnds());
        }
        if (value.getGCardNox() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getGCardNox());
        }
      }
    };
  }

  @Override
  public void insert(final EServiceInfo eServiceInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEServiceInfo.insert(eServiceInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EServiceInfo> eServiceInforInfoList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEServiceInfo.insert(eServiceInforInfoList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EServiceInfo eServiceInforInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEServiceInfo.handle(eServiceInforInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public String GetGCardNumber() {
    final String _sql = "SELECT sCardNmbr FROM Gcard_App_Master WHERE cActvStat = '1'";
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
  public LiveData<EServiceInfo> getActiveServiceInfo() {
    final String _sql = "SELECT S.* FROM MC_Service as S LEFT JOIN GCard_App_Master as G ON S.sGCardNox = G.sGCardNox WHERE G.cActvStat = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Service","GCard_App_Master"}, false, new Callable<EServiceInfo>() {
      @Override
      public EServiceInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGCardNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGCardNox");
          final int _cursorIndexOfSerialID = CursorUtil.getColumnIndexOrThrow(_cursor, "sSerialID");
          final int _cursorIndexOfEngineNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sEngineNo");
          final int _cursorIndexOfFrameNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sFrameNox");
          final int _cursorIndexOfBrandNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandNme");
          final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelNme");
          final int _cursorIndexOfFSEPStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cFSEPStat");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "dPurchase");
          final int _cursorIndexOfYellowxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nYellowxx");
          final int _cursorIndexOfWhitexxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nWhitexxx");
          final int _cursorIndexOfYlwCtrxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nYlwCtrxx");
          final int _cursorIndexOfWhtCtrxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nWhtCtrxx");
          final int _cursorIndexOfLastSrvc = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastSrvc");
          final int _cursorIndexOfMIlAgexx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMIlAgexx");
          final int _cursorIndexOfNxtRmnds = CursorUtil.getColumnIndexOrThrow(_cursor, "dNxtRmnds");
          final EServiceInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EServiceInfo();
            final String _tmpGCardNox;
            if (_cursor.isNull(_cursorIndexOfGCardNox)) {
              _tmpGCardNox = null;
            } else {
              _tmpGCardNox = _cursor.getString(_cursorIndexOfGCardNox);
            }
            _result.setGCardNox(_tmpGCardNox);
            final String _tmpSerialID;
            if (_cursor.isNull(_cursorIndexOfSerialID)) {
              _tmpSerialID = null;
            } else {
              _tmpSerialID = _cursor.getString(_cursorIndexOfSerialID);
            }
            _result.setSerialID(_tmpSerialID);
            final String _tmpEngineNo;
            if (_cursor.isNull(_cursorIndexOfEngineNo)) {
              _tmpEngineNo = null;
            } else {
              _tmpEngineNo = _cursor.getString(_cursorIndexOfEngineNo);
            }
            _result.setEngineNo(_tmpEngineNo);
            final String _tmpFrameNox;
            if (_cursor.isNull(_cursorIndexOfFrameNox)) {
              _tmpFrameNox = null;
            } else {
              _tmpFrameNox = _cursor.getString(_cursorIndexOfFrameNox);
            }
            _result.setFrameNox(_tmpFrameNox);
            final String _tmpBrandNme;
            if (_cursor.isNull(_cursorIndexOfBrandNme)) {
              _tmpBrandNme = null;
            } else {
              _tmpBrandNme = _cursor.getString(_cursorIndexOfBrandNme);
            }
            _result.setBrandNme(_tmpBrandNme);
            final String _tmpModelNme;
            if (_cursor.isNull(_cursorIndexOfModelNme)) {
              _tmpModelNme = null;
            } else {
              _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
            }
            _result.setModelNme(_tmpModelNme);
            final String _tmpFSEPStat;
            if (_cursor.isNull(_cursorIndexOfFSEPStat)) {
              _tmpFSEPStat = null;
            } else {
              _tmpFSEPStat = _cursor.getString(_cursorIndexOfFSEPStat);
            }
            _result.setFSEPStat(_tmpFSEPStat);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _result.setPurchase(_tmpPurchase);
            final int _tmpYellowxx;
            _tmpYellowxx = _cursor.getInt(_cursorIndexOfYellowxx);
            _result.setYellowxx(_tmpYellowxx);
            final int _tmpWhitexxx;
            _tmpWhitexxx = _cursor.getInt(_cursorIndexOfWhitexxx);
            _result.setWhitexxx(_tmpWhitexxx);
            final int _tmpYlwCtrxx;
            _tmpYlwCtrxx = _cursor.getInt(_cursorIndexOfYlwCtrxx);
            _result.setYlwCtrxx(_tmpYlwCtrxx);
            final int _tmpWhtCtrxx;
            _tmpWhtCtrxx = _cursor.getInt(_cursorIndexOfWhtCtrxx);
            _result.setWhtCtrxx(_tmpWhtCtrxx);
            final String _tmpLastSrvc;
            if (_cursor.isNull(_cursorIndexOfLastSrvc)) {
              _tmpLastSrvc = null;
            } else {
              _tmpLastSrvc = _cursor.getString(_cursorIndexOfLastSrvc);
            }
            _result.setLastSrvc(_tmpLastSrvc);
            final int _tmpMIlAgexx;
            _tmpMIlAgexx = _cursor.getInt(_cursorIndexOfMIlAgexx);
            _result.setMIlAgexx(_tmpMIlAgexx);
            final String _tmpNxtRmnds;
            if (_cursor.isNull(_cursorIndexOfNxtRmnds)) {
              _tmpNxtRmnds = null;
            } else {
              _tmpNxtRmnds = _cursor.getString(_cursorIndexOfNxtRmnds);
            }
            _result.setNxtRmnds(_tmpNxtRmnds);
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
