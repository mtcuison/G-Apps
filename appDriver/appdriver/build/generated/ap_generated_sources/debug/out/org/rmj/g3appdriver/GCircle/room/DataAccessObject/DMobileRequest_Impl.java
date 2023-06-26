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
public final class DMobileRequest_Impl implements DMobileRequest {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EMobileUpdate> __insertionAdapterOfEMobileUpdate;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMobileStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMobileInfo;

  public DMobileRequest_Impl(RoomDatabase __db) {
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
    this.__preparedStmtOfUpdateMobileStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Address_Update_Request SET sTransNox =? ,cSendStat = '1', dSendDate =?, dModified=?, dTimeStmp=? WHERE sTransNox=?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteMobileInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Mobile_Update_Request WHERE sTransNox = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EMobileUpdate mobileUpdate) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMobileUpdate.insert(mobileUpdate);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateMobileStatus(final String TransNox, final String oldTransNox,
      final String DateEntry) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMobileStatus.acquire();
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
      __preparedStmtOfUpdateMobileStatus.release(_stmt);
    }
  }

  @Override
  public void deleteMobileInfo(final String sTransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMobileInfo.acquire();
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
      __preparedStmtOfDeleteMobileInfo.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EMobileUpdate>> getMobileRequestList() {
    final String _sql = "SELECT * FROM Mobile_Update_Request";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mobile_Update_Request"}, false, new Callable<List<EMobileUpdate>>() {
      @Override
      public List<EMobileUpdate> call() throws Exception {
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
          final List<EMobileUpdate> _result = new ArrayList<EMobileUpdate>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMobileUpdate _item;
            _item = new EMobileUpdate();
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
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final String _tmpPrimaryx;
            if (_cursor.isNull(_cursorIndexOfPrimaryx)) {
              _tmpPrimaryx = null;
            } else {
              _tmpPrimaryx = _cursor.getString(_cursorIndexOfPrimaryx);
            }
            _item.setPrimaryx(_tmpPrimaryx);
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
  public LiveData<List<EMobileUpdate>> getMobileRequestListForClient(final String ClientID) {
    final String _sql = "SELECT * FROM Mobile_Update_Request WHERE sClientID =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ClientID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ClientID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mobile_Update_Request"}, false, new Callable<List<EMobileUpdate>>() {
      @Override
      public List<EMobileUpdate> call() throws Exception {
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
          final List<EMobileUpdate> _result = new ArrayList<EMobileUpdate>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMobileUpdate _item;
            _item = new EMobileUpdate();
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
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final String _tmpPrimaryx;
            if (_cursor.isNull(_cursorIndexOfPrimaryx)) {
              _tmpPrimaryx = null;
            } else {
              _tmpPrimaryx = _cursor.getString(_cursorIndexOfPrimaryx);
            }
            _item.setPrimaryx(_tmpPrimaryx);
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
  public EMobileUpdate getMobileUpdateInfoForPosting(final String ClientID) {
    final String _sql = "SELECT * FROM Mobile_Update_Request WHERE sClientID =?";
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
  public LiveData<List<DMobileRequest.CNAMobileInfo>> getCNAMobileDataList(final String sClientID) {
    final String _sql = "SELECT M.cReqstCDe AS mobileReqstCDe, M.sMobileNo, M.cPrimaryx AS mobilePrimaryx, M.sRemarksx AS mobileRemarksx, I.nLatitude, I.nLongitud FROM LR_DCP_Collection_Detail as C, Mobile_Update_Request as M, Image_Information as I WHERE C.sClientID = ? AND C.sRemCodex = \"CNA\" AND M.sClientID = C.sClientID AND I.sImageNme = C.sImageNme";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sClientID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sClientID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Detail","Mobile_Update_Request","Image_Information"}, false, new Callable<List<DMobileRequest.CNAMobileInfo>>() {
      @Override
      public List<DMobileRequest.CNAMobileInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMobileReqstCDe = 0;
          final int _cursorIndexOfSMobileNo = 1;
          final int _cursorIndexOfMobilePrimaryx = 2;
          final int _cursorIndexOfMobileRemarksx = 3;
          final int _cursorIndexOfNLatitude = 4;
          final int _cursorIndexOfNLongitud = 5;
          final List<DMobileRequest.CNAMobileInfo> _result = new ArrayList<DMobileRequest.CNAMobileInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DMobileRequest.CNAMobileInfo _item;
            _item = new DMobileRequest.CNAMobileInfo();
            if (_cursor.isNull(_cursorIndexOfMobileReqstCDe)) {
              _item.mobileReqstCDe = null;
            } else {
              _item.mobileReqstCDe = _cursor.getString(_cursorIndexOfMobileReqstCDe);
            }
            if (_cursor.isNull(_cursorIndexOfSMobileNo)) {
              _item.sMobileNo = null;
            } else {
              _item.sMobileNo = _cursor.getString(_cursorIndexOfSMobileNo);
            }
            if (_cursor.isNull(_cursorIndexOfMobilePrimaryx)) {
              _item.mobilePrimaryx = null;
            } else {
              _item.mobilePrimaryx = _cursor.getString(_cursorIndexOfMobilePrimaryx);
            }
            if (_cursor.isNull(_cursorIndexOfMobileRemarksx)) {
              _item.mobileRemarksx = null;
            } else {
              _item.mobileRemarksx = _cursor.getString(_cursorIndexOfMobileRemarksx);
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
