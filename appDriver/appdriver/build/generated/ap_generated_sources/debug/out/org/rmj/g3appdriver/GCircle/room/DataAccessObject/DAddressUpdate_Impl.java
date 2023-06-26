package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
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
import org.rmj.g3appdriver.GCircle.room.Entities.EAddressUpdate;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAddressUpdate_Impl implements DAddressUpdate {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EAddressUpdate> __insertionAdapterOfEAddressUpdate;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAddressUpdate;

  public DAddressUpdate_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEAddressUpdate = new EntityInsertionAdapter<EAddressUpdate>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Address_Update_Request` (`sTransNox`,`sClientID`,`cReqstCDe`,`cAddrssTp`,`sHouseNox`,`sAddressx`,`sTownIDxx`,`sBrgyIDxx`,`cPrimaryx`,`nLatitude`,`nLongitud`,`sRemarksx`,`cTranStat`,`cSendStat`,`dSendDate`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EAddressUpdate value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getClientID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClientID());
        }
        if (value.getReqstCDe() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReqstCDe());
        }
        if (value.getAddrssTp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddrssTp());
        }
        if (value.getHouseNox() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getHouseNox());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAddressx());
        }
        if (value.getTownIDxx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTownIDxx());
        }
        if (value.getBrgyIDxx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBrgyIDxx());
        }
        if (value.getPrimaryx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPrimaryx());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getLatitude());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getLongitud());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getRemarksx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSendDate());
        }
        if (value.getModified() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getTimeStmp());
        }
      }
    };
    this.__preparedStmtOfDeleteAddressUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Address_Update_Request WHERE sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveAddressUpdate(final EAddressUpdate foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEAddressUpdate.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteAddressUpdate(final String fsVal) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAddressUpdate.acquire();
    int _argIndex = 1;
    if (fsVal == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsVal);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAddressUpdate.release(_stmt);
    }
  }

  @Override
  public EAddressUpdate GetAddressInfo(final String fsVal) {
    final String _sql = "SELECT * FROM Address_Update_Request WHERE sClientID =?";
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
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfReqstCDe = CursorUtil.getColumnIndexOrThrow(_cursor, "cReqstCDe");
      final int _cursorIndexOfAddrssTp = CursorUtil.getColumnIndexOrThrow(_cursor, "cAddrssTp");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfBrgyIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDxx");
      final int _cursorIndexOfPrimaryx = CursorUtil.getColumnIndexOrThrow(_cursor, "cPrimaryx");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EAddressUpdate _result;
      if(_cursor.moveToFirst()) {
        _result = new EAddressUpdate();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpReqstCDe;
        if (_cursor.isNull(_cursorIndexOfReqstCDe)) {
          _tmpReqstCDe = null;
        } else {
          _tmpReqstCDe = _cursor.getString(_cursorIndexOfReqstCDe);
        }
        _result.setReqstCDe(_tmpReqstCDe);
        final String _tmpAddrssTp;
        if (_cursor.isNull(_cursorIndexOfAddrssTp)) {
          _tmpAddrssTp = null;
        } else {
          _tmpAddrssTp = _cursor.getString(_cursorIndexOfAddrssTp);
        }
        _result.setAddrssTp(_tmpAddrssTp);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _result.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _result.setTownIDxx(_tmpTownIDxx);
        final String _tmpBrgyIDxx;
        if (_cursor.isNull(_cursorIndexOfBrgyIDxx)) {
          _tmpBrgyIDxx = null;
        } else {
          _tmpBrgyIDxx = _cursor.getString(_cursorIndexOfBrgyIDxx);
        }
        _result.setBrgyIDxx(_tmpBrgyIDxx);
        final String _tmpPrimaryx;
        if (_cursor.isNull(_cursorIndexOfPrimaryx)) {
          _tmpPrimaryx = null;
        } else {
          _tmpPrimaryx = _cursor.getString(_cursorIndexOfPrimaryx);
        }
        _result.setPrimaryx(_tmpPrimaryx);
        final String _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final String _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
        }
        _result.setLongitud(_tmpLongitud);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
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
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT (*) FROM Address_Update_Request";
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
  public LiveData<List<DAddressUpdate.AddressUpdateInfo>> GetAddressUpdateInfo(final String fsVal) {
    final String _sql = "SELECT a.sTransNox, a.cReqstCDe, a.cAddrssTp, IFNULL(a.sHouseNox, '') AS sHouseNox, IFNULL(a.sAddressx, '') AS sAddressx,b.sBrgyName, c.sTownName, d.sProvName, a.cPrimaryx, a.sRemarksx FROM Address_Update_Request a LEFT JOIN Barangay_Info b ON a.sBrgyIDxx = b.sBrgyIDxx LEFT JOIN Town_Info c ON b.sTownIDxx = c.sTownIDxx LEFT JOIN Province_Info d ON c.sProvIDxx = d.sProvIDxx WHERE a.sClientID =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Address_Update_Request","Barangay_Info","Town_Info","Province_Info"}, false, new Callable<List<DAddressUpdate.AddressUpdateInfo>>() {
      @Override
      public List<DAddressUpdate.AddressUpdateInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfCReqstCDe = 1;
          final int _cursorIndexOfCAddrssTp = 2;
          final int _cursorIndexOfSHouseNox = 3;
          final int _cursorIndexOfSAddressx = 4;
          final int _cursorIndexOfSBrgyName = 5;
          final int _cursorIndexOfSTownName = 6;
          final int _cursorIndexOfSProvName = 7;
          final int _cursorIndexOfCPrimaryx = 8;
          final int _cursorIndexOfSRemarksx = 9;
          final List<DAddressUpdate.AddressUpdateInfo> _result = new ArrayList<DAddressUpdate.AddressUpdateInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DAddressUpdate.AddressUpdateInfo _item;
            _item = new DAddressUpdate.AddressUpdateInfo();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfCReqstCDe)) {
              _item.cReqstCDe = null;
            } else {
              _item.cReqstCDe = _cursor.getString(_cursorIndexOfCReqstCDe);
            }
            if (_cursor.isNull(_cursorIndexOfCAddrssTp)) {
              _item.cAddrssTp = null;
            } else {
              _item.cAddrssTp = _cursor.getString(_cursorIndexOfCAddrssTp);
            }
            if (_cursor.isNull(_cursorIndexOfSHouseNox)) {
              _item.sHouseNox = null;
            } else {
              _item.sHouseNox = _cursor.getString(_cursorIndexOfSHouseNox);
            }
            if (_cursor.isNull(_cursorIndexOfSAddressx)) {
              _item.sAddressx = null;
            } else {
              _item.sAddressx = _cursor.getString(_cursorIndexOfSAddressx);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyName)) {
              _item.sBrgyName = null;
            } else {
              _item.sBrgyName = _cursor.getString(_cursorIndexOfSBrgyName);
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
            if (_cursor.isNull(_cursorIndexOfCPrimaryx)) {
              _item.cPrimaryx = null;
            } else {
              _item.cPrimaryx = _cursor.getString(_cursorIndexOfCPrimaryx);
            }
            if (_cursor.isNull(_cursorIndexOfSRemarksx)) {
              _item.sRemarksx = null;
            } else {
              _item.sRemarksx = _cursor.getString(_cursorIndexOfSRemarksx);
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
