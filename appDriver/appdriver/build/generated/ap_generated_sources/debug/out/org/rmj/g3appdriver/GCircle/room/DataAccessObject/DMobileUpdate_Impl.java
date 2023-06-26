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
import org.rmj.g3appdriver.GCircle.room.Entities.EMobileUpdate;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DMobileUpdate_Impl implements DMobileUpdate {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EMobileUpdate> __insertionAdapterOfEMobileUpdate;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMobileUpdate;

  public DMobileUpdate_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEMobileUpdate = new EntityInsertionAdapter<EMobileUpdate>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Mobile_Update_Request` (`sTransNox`,`sClientID`,`cReqstCDe`,`sMobileNo`,`cPrimaryx`,`sRemarksx`,`cTranStat`,`cSendStat`,`dSendDate`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMobileUpdate value) {
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
        if (value.getMobileNo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getMobileNo());
        }
        if (value.getPrimaryx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPrimaryx());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRemarksx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSendDate());
        }
        if (value.getModified() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTimeStmp());
        }
      }
    };
    this.__preparedStmtOfDeleteMobileUpdate = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Mobile_Update_Request WHERE sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveMobileUpdate(final EMobileUpdate foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMobileUpdate.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteMobileUpdate(final String fsVal) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMobileUpdate.acquire();
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
      __preparedStmtOfDeleteMobileUpdate.release(_stmt);
    }
  }

  @Override
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT (*) FROM Mobile_Update_Request";
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
  public EMobileUpdate GetMobileUpdate(final String fsVal) {
    final String _sql = "SELECT * FROM Mobile_Update_Request WHERE sClientID =?";
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
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfPrimaryx = CursorUtil.getColumnIndexOrThrow(_cursor, "cPrimaryx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EMobileUpdate _result;
      if(_cursor.moveToFirst()) {
        _result = new EMobileUpdate();
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
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final String _tmpPrimaryx;
        if (_cursor.isNull(_cursorIndexOfPrimaryx)) {
          _tmpPrimaryx = null;
        } else {
          _tmpPrimaryx = _cursor.getString(_cursorIndexOfPrimaryx);
        }
        _result.setPrimaryx(_tmpPrimaryx);
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
  public LiveData<List<DMobileUpdate.MobileUpdateInfo>> GetMobileUpdateInfo(final String fsVal) {
    final String _sql = "SELECT sTransNox, sClientID, cReqstCDe, sMobileNo, cPrimaryx, sRemarksx, cTranStat FROM Mobile_Update_Request WHERE sClientID =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mobile_Update_Request"}, false, new Callable<List<DMobileUpdate.MobileUpdateInfo>>() {
      @Override
      public List<DMobileUpdate.MobileUpdateInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfSClientID = 1;
          final int _cursorIndexOfCReqstCDe = 2;
          final int _cursorIndexOfSMobileNo = 3;
          final int _cursorIndexOfCPrimaryx = 4;
          final int _cursorIndexOfSRemarksx = 5;
          final int _cursorIndexOfCTranStat = 6;
          final List<DMobileUpdate.MobileUpdateInfo> _result = new ArrayList<DMobileUpdate.MobileUpdateInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DMobileUpdate.MobileUpdateInfo _item;
            _item = new DMobileUpdate.MobileUpdateInfo();
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
            if (_cursor.isNull(_cursorIndexOfSMobileNo)) {
              _item.sMobileNo = null;
            } else {
              _item.sMobileNo = _cursor.getString(_cursorIndexOfSMobileNo);
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
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
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
