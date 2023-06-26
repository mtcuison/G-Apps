package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GConnect.room.Entities.EAddressInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.EMobileInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DMobileAddressInfo_Impl implements DMobileAddressInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EAddressInfo> __insertionAdapterOfEAddressInfo;

  private final EntityInsertionAdapter<EMobileInfo> __insertionAdapterOfEMobileInfo;

  private final EntityDeletionOrUpdateAdapter<EAddressInfo> __updateAdapterOfEAddressInfo;

  private final EntityDeletionOrUpdateAdapter<EMobileInfo> __updateAdapterOfEMobileInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNewAddressID;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNewContactID;

  public DMobileAddressInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEAddressInfo = new EntityInsertionAdapter<EAddressInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Address_Update_Request` (`sTransNox`,`sClientID`,`cReqstCDe`,`cAddrssTp`,`sHouseNox`,`sAddressx`,`sTownIDxx`,`sBrgyIDxx`,`cPrimaryx`,`sSourceCD`,`sSourceNo`,`nLatitude`,`nLongitud`,`sRemarksx`,`cTranStat`,`cSendStat`,`dSendDate`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EAddressInfo value) {
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
        if (value.getSourceCD() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSourceCD());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getSourceNo());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLatitude());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLongitud());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRemarksx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSendDate());
        }
        if (value.getModified() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfEMobileInfo = new EntityInsertionAdapter<EMobileInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `App_User_Mobile` (`sUserIDxx`,`dTransact`,`sMobileNo`,`cUserVrfd`,`dUserVrfd`,`dVerified`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMobileInfo value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMobileNo());
        }
        stmt.bindLong(4, value.getUserVrfd());
        if (value.getDateVrfd() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDateVrfd());
        }
        if (value.getVerified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getVerified());
        }
        stmt.bindLong(7, value.getRecdStat());
        if (value.getTimeStmp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEAddressInfo = new EntityDeletionOrUpdateAdapter<EAddressInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Address_Update_Request` SET `sTransNox` = ?,`sClientID` = ?,`cReqstCDe` = ?,`cAddrssTp` = ?,`sHouseNox` = ?,`sAddressx` = ?,`sTownIDxx` = ?,`sBrgyIDxx` = ?,`cPrimaryx` = ?,`sSourceCD` = ?,`sSourceNo` = ?,`nLatitude` = ?,`nLongitud` = ?,`sRemarksx` = ?,`cTranStat` = ?,`cSendStat` = ?,`dSendDate` = ?,`dModified` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EAddressInfo value) {
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
        if (value.getSourceCD() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSourceCD());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getSourceNo());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLatitude());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLongitud());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRemarksx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSendDate());
        }
        if (value.getModified() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getTransNox());
        }
      }
    };
    this.__updateAdapterOfEMobileInfo = new EntityDeletionOrUpdateAdapter<EMobileInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `App_User_Mobile` SET `sUserIDxx` = ?,`dTransact` = ?,`sMobileNo` = ?,`cUserVrfd` = ?,`dUserVrfd` = ?,`dVerified` = ?,`cRecdStat` = ?,`dTimeStmp` = ? WHERE `sUserIDxx` = ? AND `dTransact` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMobileInfo value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMobileNo());
        }
        stmt.bindLong(4, value.getUserVrfd());
        if (value.getDateVrfd() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDateVrfd());
        }
        if (value.getVerified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getVerified());
        }
        stmt.bindLong(7, value.getRecdStat());
        if (value.getTimeStmp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTimeStmp());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getUserIDxx());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTransact());
        }
      }
    };
    this.__preparedStmtOfUpdateNewAddressID = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Address_Update_Request SET sTransNox =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNewContactID = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE App_User_Mobile SET sUserIDxx =? WHERE sUserIDxx =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveAddress(final EAddressInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEAddressInfo.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void SaveMobile(final EMobileInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMobileInfo.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateAddress(final EAddressInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEAddressInfo.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateMobile(final EMobileInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEMobileInfo.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateNewAddressID(final String fsOldTran, final String fsNewTran) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNewAddressID.acquire();
    int _argIndex = 1;
    if (fsNewTran == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsNewTran);
    }
    _argIndex = 2;
    if (fsOldTran == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsOldTran);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateNewAddressID.release(_stmt);
    }
  }

  @Override
  public void UpdateNewContactID(final String fsOldTran, final String fsNewTran) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNewContactID.acquire();
    int _argIndex = 1;
    if (fsNewTran == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsNewTran);
    }
    _argIndex = 2;
    if (fsOldTran == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsOldTran);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateNewContactID.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EAddressInfo>> GetAddressInfoList() {
    final String _sql = "SELECT * FROM Address_Update_Request";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Address_Update_Request"}, false, new Callable<List<EAddressInfo>>() {
      @Override
      public List<EAddressInfo> call() throws Exception {
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
          final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EAddressInfo> _result = new ArrayList<EAddressInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EAddressInfo _item;
            _item = new EAddressInfo();
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
            final String _tmpSourceCD;
            if (_cursor.isNull(_cursorIndexOfSourceCD)) {
              _tmpSourceCD = null;
            } else {
              _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
            }
            _item.setSourceCD(_tmpSourceCD);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _item.setSourceNo(_tmpSourceNo);
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
  public LiveData<List<EMobileInfo>> GetMobileInfoList() {
    final String _sql = "SELECT * FROM App_User_Mobile";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"App_User_Mobile"}, false, new Callable<List<EMobileInfo>>() {
      @Override
      public List<EMobileInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfUserVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "cUserVrfd");
          final int _cursorIndexOfDateVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "dUserVrfd");
          final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EMobileInfo> _result = new ArrayList<EMobileInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMobileInfo _item;
            _item = new EMobileInfo();
            final String _tmpUserIDxx;
            if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
              _tmpUserIDxx = null;
            } else {
              _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
            }
            _item.setUserIDxx(_tmpUserIDxx);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final int _tmpUserVrfd;
            _tmpUserVrfd = _cursor.getInt(_cursorIndexOfUserVrfd);
            _item.setUserVrfd(_tmpUserVrfd);
            final String _tmpDateVrfd;
            if (_cursor.isNull(_cursorIndexOfDateVrfd)) {
              _tmpDateVrfd = null;
            } else {
              _tmpDateVrfd = _cursor.getString(_cursorIndexOfDateVrfd);
            }
            _item.setDateVrfd(_tmpDateVrfd);
            final String _tmpVerified;
            if (_cursor.isNull(_cursorIndexOfVerified)) {
              _tmpVerified = null;
            } else {
              _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
            }
            _item.setVerified(_tmpVerified);
            final int _tmpRecdStat;
            _tmpRecdStat = _cursor.getInt(_cursorIndexOfRecdStat);
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
  public LiveData<EAddressInfo> GetAddressInfo(final String fsTransNo) {
    final String _sql = "SELECT * FROM Address_Update_Request WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsTransNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsTransNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Address_Update_Request"}, false, new Callable<EAddressInfo>() {
      @Override
      public EAddressInfo call() throws Exception {
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
          final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final EAddressInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EAddressInfo();
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
            final String _tmpSourceCD;
            if (_cursor.isNull(_cursorIndexOfSourceCD)) {
              _tmpSourceCD = null;
            } else {
              _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
            }
            _result.setSourceCD(_tmpSourceCD);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _result.setSourceNo(_tmpSourceNo);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<EMobileInfo> GetMobileInfo(final String fsTransNo) {
    final String _sql = "SELECT * FROM App_User_Mobile WHERE sUserIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsTransNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsTransNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"App_User_Mobile"}, false, new Callable<EMobileInfo>() {
      @Override
      public EMobileInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfUserVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "cUserVrfd");
          final int _cursorIndexOfDateVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "dUserVrfd");
          final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final EMobileInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EMobileInfo();
            final String _tmpUserIDxx;
            if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
              _tmpUserIDxx = null;
            } else {
              _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
            }
            _result.setUserIDxx(_tmpUserIDxx);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _result.setTransact(_tmpTransact);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final int _tmpUserVrfd;
            _tmpUserVrfd = _cursor.getInt(_cursorIndexOfUserVrfd);
            _result.setUserVrfd(_tmpUserVrfd);
            final String _tmpDateVrfd;
            if (_cursor.isNull(_cursorIndexOfDateVrfd)) {
              _tmpDateVrfd = null;
            } else {
              _tmpDateVrfd = _cursor.getString(_cursorIndexOfDateVrfd);
            }
            _result.setDateVrfd(_tmpDateVrfd);
            final String _tmpVerified;
            if (_cursor.isNull(_cursorIndexOfVerified)) {
              _tmpVerified = null;
            } else {
              _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
            }
            _result.setVerified(_tmpVerified);
            final int _tmpRecdStat;
            _tmpRecdStat = _cursor.getInt(_cursorIndexOfRecdStat);
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
