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
public final class DAddressRequest_Impl implements DAddressRequest {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EAddressUpdate> __insertionAdapterOfEAddressUpdate;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAddressInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAddressStatus;

  public DAddressRequest_Impl(RoomDatabase __db) {
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
    this.__preparedStmtOfDeleteAddressInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Address_Update_Request WHERE sTransNox = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAddressStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Address_Update_Request SET sTransNox =? ,cSendStat = '1', dSendDate =?, dModified=?, dTimeStmp=? WHERE sTransNox=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EAddressUpdate addressUpdate) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEAddressUpdate.insert(addressUpdate);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAddressInfo(final String sTransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAddressInfo.acquire();
    int _argIndex = 1;
    if (sTransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sTransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAddressInfo.release(_stmt);
    }
  }

  @Override
  public void updateAddressStatus(final String TransNox, final String oldTransNox,
      final String DateEntry) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAddressStatus.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (DateEntry == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateEntry);
    }
    _argIndex = 3;
    if (DateEntry == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateEntry);
    }
    _argIndex = 4;
    if (DateEntry == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateEntry);
    }
    _argIndex = 5;
    if (oldTransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, oldTransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAddressStatus.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EAddressUpdate>> getAddressRequestList() {
    final String _sql = "SELECT * FROM Address_Update_Request WHERE cSendStat <> '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Address_Update_Request"}, false, new Callable<List<EAddressUpdate>>() {
      @Override
      public List<EAddressUpdate> call() throws Exception {
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
          final List<EAddressUpdate> _result = new ArrayList<EAddressUpdate>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EAddressUpdate _item;
            _item = new EAddressUpdate();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _item.setClientID(_tmpClientID);
            final String _tmpReqstCDe;
            if (_cursor.isNull(_cursorIndexOfReqstCDe)) {
              _tmpReqstCDe = null;
            } else {
              _tmpReqstCDe = _cursor.getString(_cursorIndexOfReqstCDe);
            }
            _item.setReqstCDe(_tmpReqstCDe);
            final String _tmpAddrssTp;
            if (_cursor.isNull(_cursorIndexOfAddrssTp)) {
              _tmpAddrssTp = null;
            } else {
              _tmpAddrssTp = _cursor.getString(_cursorIndexOfAddrssTp);
            }
            _item.setAddrssTp(_tmpAddrssTp);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _item.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpBrgyIDxx;
            if (_cursor.isNull(_cursorIndexOfBrgyIDxx)) {
              _tmpBrgyIDxx = null;
            } else {
              _tmpBrgyIDxx = _cursor.getString(_cursorIndexOfBrgyIDxx);
            }
            _item.setBrgyIDxx(_tmpBrgyIDxx);
            final String _tmpPrimaryx;
            if (_cursor.isNull(_cursorIndexOfPrimaryx)) {
              _tmpPrimaryx = null;
            } else {
              _tmpPrimaryx = _cursor.getString(_cursorIndexOfPrimaryx);
            }
            _item.setPrimaryx(_tmpPrimaryx);
            final String _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
            }
            _item.setLatitude(_tmpLatitude);
            final String _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
            }
            _item.setLongitud(_tmpLongitud);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
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
  public EAddressUpdate getAddressUpdateInfoForPosting(final String ClientID) {
    final String _sql = "SELECT * FROM Address_Update_Request WHERE sClientID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ClientID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ClientID);
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
  public LiveData<List<DAddressRequest.CustomerAddressInfo>> getAddressNames() {
    final String _sql = "SELECT AU.sTransNox, AU.sClientID, AU.cReqstCDe, AU.cAddrssTp, AU.sHouseNox, AU.sAddressx, AU.sTownIDxx, AU.sBrgyIDxx, AU.cPrimaryx, AU.sRemarksx, B.sBrgyName, T.sTownName, P.sProvName FROM Address_Update_Request AS AU, Barangay_Info AS B, Town_Info AS T, Province_Info AS P WHERE B.sBrgyIDxx = AU.sBrgyIDxx AND T.sTownIDxx = AU.sTownIDxx AND P.sProvIDxx = T.sProvIDxx";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Address_Update_Request","Barangay_Info","Town_Info","Province_Info"}, false, new Callable<List<DAddressRequest.CustomerAddressInfo>>() {
      @Override
      public List<DAddressRequest.CustomerAddressInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfSClientID = 1;
          final int _cursorIndexOfCReqstCDe = 2;
          final int _cursorIndexOfCAddrssTp = 3;
          final int _cursorIndexOfSHouseNox = 4;
          final int _cursorIndexOfSAddressx = 5;
          final int _cursorIndexOfSTownIDxx = 6;
          final int _cursorIndexOfSBrgyIDxx = 7;
          final int _cursorIndexOfCPrimaryx = 8;
          final int _cursorIndexOfSRemarksx = 9;
          final int _cursorIndexOfSBrgyName = 10;
          final int _cursorIndexOfSTownName = 11;
          final int _cursorIndexOfSProvName = 12;
          final List<DAddressRequest.CustomerAddressInfo> _result = new ArrayList<DAddressRequest.CustomerAddressInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DAddressRequest.CustomerAddressInfo _item;
            _item = new DAddressRequest.CustomerAddressInfo();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSClientID)) {
              _item.sClientID = null;
            } else {
              _item.sClientID = _cursor.getString(_cursorIndexOfSClientID);
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
            if (_cursor.isNull(_cursorIndexOfSTownIDxx)) {
              _item.sTownIDxx = null;
            } else {
              _item.sTownIDxx = _cursor.getString(_cursorIndexOfSTownIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyIDxx)) {
              _item.sBrgyIDxx = null;
            } else {
              _item.sBrgyIDxx = _cursor.getString(_cursorIndexOfSBrgyIDxx);
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
  public LiveData<List<DAddressRequest.CNA_AddressInfo>> getCNA_AddressDataList(
      final String sClientID) {
    final String _sql = "SELECT A.cReqstCDe AS addressReqstCDe, A.cAddrssTp, A.sHouseNox, A.sAddressx, T.sTownName AS townName, B.sBrgyName AS brgyName, P.sProvName AS provName, A.cPrimaryx AS addressPrimaryx, A.sRemarksx AS addressRemarksx, A.nLatitude, A.nLongitud FROM LR_DCP_Collection_Detail as C, Address_Update_Request as A , Barangay_Info as B, Town_Info as T, Province_Info as P WHERE C.sRemCodex = \"CNA\" AND C.sClientID = ? AND A.sClientID = C.sClientID AND B.sBrgyIDxx = A.sBrgyIDxx AND T.sTownIDxx = A.sTownIDxx AND P.sProvIDxx = T.sProvIDxx; ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sClientID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sClientID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","Address_Update_Request","Barangay_Info","Town_Info","Province_Info"}, false, new Callable<List<DAddressRequest.CNA_AddressInfo>>() {
      @Override
      public List<DAddressRequest.CNA_AddressInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfAddressReqstCDe = 0;
          final int _cursorIndexOfCAddrssTp = 1;
          final int _cursorIndexOfSHouseNox = 2;
          final int _cursorIndexOfSAddressx = 3;
          final int _cursorIndexOfTownName = 4;
          final int _cursorIndexOfBrgyName = 5;
          final int _cursorIndexOfProvName = 6;
          final int _cursorIndexOfAddressPrimaryx = 7;
          final int _cursorIndexOfAddressRemarksx = 8;
          final int _cursorIndexOfNLatitude = 9;
          final int _cursorIndexOfNLongitud = 10;
          final List<DAddressRequest.CNA_AddressInfo> _result = new ArrayList<DAddressRequest.CNA_AddressInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DAddressRequest.CNA_AddressInfo _item;
            _item = new DAddressRequest.CNA_AddressInfo();
            if (_cursor.isNull(_cursorIndexOfAddressReqstCDe)) {
              _item.addressReqstCDe = null;
            } else {
              _item.addressReqstCDe = _cursor.getString(_cursorIndexOfAddressReqstCDe);
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
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _item.townName = null;
            } else {
              _item.townName = _cursor.getString(_cursorIndexOfTownName);
            }
            if (_cursor.isNull(_cursorIndexOfBrgyName)) {
              _item.brgyName = null;
            } else {
              _item.brgyName = _cursor.getString(_cursorIndexOfBrgyName);
            }
            if (_cursor.isNull(_cursorIndexOfProvName)) {
              _item.provName = null;
            } else {
              _item.provName = _cursor.getString(_cursorIndexOfProvName);
            }
            if (_cursor.isNull(_cursorIndexOfAddressPrimaryx)) {
              _item.addressPrimaryx = null;
            } else {
              _item.addressPrimaryx = _cursor.getString(_cursorIndexOfAddressPrimaryx);
            }
            if (_cursor.isNull(_cursorIndexOfAddressRemarksx)) {
              _item.addressRemarksx = null;
            } else {
              _item.addressRemarksx = _cursor.getString(_cursorIndexOfAddressRemarksx);
            }
            _item.nLatitude = _cursor.getDouble(_cursorIndexOfNLatitude);
            _item.nLongitud = _cursor.getDouble(_cursorIndexOfNLongitud);
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
