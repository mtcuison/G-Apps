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
import org.rmj.g3appdriver.GCircle.room.Entities.EBranchInfo;
import org.rmj.g3appdriver.GCircle.room.Entities.EImageInfo;
import org.rmj.g3appdriver.GCircle.room.Entities.ESelfieLog;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DSelfieLog_Impl implements DSelfieLog {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ESelfieLog> __insertionAdapterOfESelfieLog;

  private final SharedSQLiteStatement __preparedStmtOfUpdateEmployeeLogStat;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSelfieLogImageID;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUploadedSelfieImageToLog;

  public DSelfieLog_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfESelfieLog = new EntityInsertionAdapter<ESelfieLog>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Employee_Log_Selfie` (`sTransNox`,`sEmployID`,`sBranchCd`,`dTransact`,`dLogTimex`,`nLatitude`,`nLongitud`,`sImageIDx`,`sRemarksx`,`cSendStat`,`dSendDate`,`cReqCCntx`,`cReqRSIxx`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ESelfieLog value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getEmployID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmployID());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBranchCd());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTransact());
        }
        if (value.getLogTimex() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLogTimex());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLatitude());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLongitud());
        }
        if (value.getImageIDx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImageIDx());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRemarksx());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getSendDate());
        }
        if (value.getReqCCntx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getReqCCntx());
        }
        if (value.getReqRSIxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getReqRSIxx());
        }
      }
    };
    this.__preparedStmtOfUpdateEmployeeLogStat = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Employee_Log_Selfie SET sTransNox =?, sImageIDx =?, cSendStat = '1', dSendDate =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSelfieLogImageID = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Employee_Log_Selfie SET sImageIDx =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUploadedSelfieImageToLog = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Employee_Log_Selfie SET cSendStat = '1', sImageIDx =? WHERE sImageIDx =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveSelfieLog(final ESelfieLog log_selfie) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfESelfieLog.insert(log_selfie);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateEmployeeLogStat(final String TransNox, final String OldTransNox,
      final String sImageID, final String DateSent) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateEmployeeLogStat.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (sImageID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, sImageID);
    }
    _argIndex = 3;
    if (DateSent == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateSent);
    }
    _argIndex = 4;
    if (OldTransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, OldTransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateEmployeeLogStat.release(_stmt);
    }
  }

  @Override
  public void updateSelfieLogImageID(final String TransNox, final String ImageID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSelfieLogImageID.acquire();
    int _argIndex = 1;
    if (ImageID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ImageID);
    }
    _argIndex = 2;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSelfieLogImageID.release(_stmt);
    }
  }

  @Override
  public void UpdateUploadedSelfieImageToLog(final String OldImgID, final String NewImgID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUploadedSelfieImageToLog.acquire();
    int _argIndex = 1;
    if (NewImgID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, NewImgID);
    }
    _argIndex = 2;
    if (OldImgID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, OldImgID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUploadedSelfieImageToLog.release(_stmt);
    }
  }

  @Override
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT (*) FROM Employee_Log_Selfie";
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
  public ESelfieLog GetSelfieLog(final String TransNo) {
    final String _sql = "SELECT * FROM Employee_Log_Selfie WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNo);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfLogTimex = CursorUtil.getColumnIndexOrThrow(_cursor, "dLogTimex");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfImageIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageIDx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfReqCCntx = CursorUtil.getColumnIndexOrThrow(_cursor, "cReqCCntx");
      final int _cursorIndexOfReqRSIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cReqRSIxx");
      final ESelfieLog _result;
      if(_cursor.moveToFirst()) {
        _result = new ESelfieLog();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpEmployID;
        if (_cursor.isNull(_cursorIndexOfEmployID)) {
          _tmpEmployID = null;
        } else {
          _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
        }
        _result.setEmployID(_tmpEmployID);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpLogTimex;
        if (_cursor.isNull(_cursorIndexOfLogTimex)) {
          _tmpLogTimex = null;
        } else {
          _tmpLogTimex = _cursor.getString(_cursorIndexOfLogTimex);
        }
        _result.setLogTimex(_tmpLogTimex);
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
        final String _tmpImageIDx;
        if (_cursor.isNull(_cursorIndexOfImageIDx)) {
          _tmpImageIDx = null;
        } else {
          _tmpImageIDx = _cursor.getString(_cursorIndexOfImageIDx);
        }
        _result.setImageIDx(_tmpImageIDx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
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
        final String _tmpReqCCntx;
        if (_cursor.isNull(_cursorIndexOfReqCCntx)) {
          _tmpReqCCntx = null;
        } else {
          _tmpReqCCntx = _cursor.getString(_cursorIndexOfReqCCntx);
        }
        _result.setReqCCntx(_tmpReqCCntx);
        final String _tmpReqRSIxx;
        if (_cursor.isNull(_cursorIndexOfReqRSIxx)) {
          _tmpReqRSIxx = null;
        } else {
          _tmpReqRSIxx = _cursor.getString(_cursorIndexOfReqRSIxx);
        }
        _result.setReqRSIxx(_tmpReqRSIxx);
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
  public List<ESelfieLog> GetSelfieLogsForUpload() {
    final String _sql = "SELECT * FROM Employee_Log_Selfie WHERE cSendStat <> '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfLogTimex = CursorUtil.getColumnIndexOrThrow(_cursor, "dLogTimex");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfImageIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageIDx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfReqCCntx = CursorUtil.getColumnIndexOrThrow(_cursor, "cReqCCntx");
      final int _cursorIndexOfReqRSIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cReqRSIxx");
      final List<ESelfieLog> _result = new ArrayList<ESelfieLog>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ESelfieLog _item;
        _item = new ESelfieLog();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpEmployID;
        if (_cursor.isNull(_cursorIndexOfEmployID)) {
          _tmpEmployID = null;
        } else {
          _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
        }
        _item.setEmployID(_tmpEmployID);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpLogTimex;
        if (_cursor.isNull(_cursorIndexOfLogTimex)) {
          _tmpLogTimex = null;
        } else {
          _tmpLogTimex = _cursor.getString(_cursorIndexOfLogTimex);
        }
        _item.setLogTimex(_tmpLogTimex);
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
        final String _tmpImageIDx;
        if (_cursor.isNull(_cursorIndexOfImageIDx)) {
          _tmpImageIDx = null;
        } else {
          _tmpImageIDx = _cursor.getString(_cursorIndexOfImageIDx);
        }
        _item.setImageIDx(_tmpImageIDx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
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
        final String _tmpReqCCntx;
        if (_cursor.isNull(_cursorIndexOfReqCCntx)) {
          _tmpReqCCntx = null;
        } else {
          _tmpReqCCntx = _cursor.getString(_cursorIndexOfReqCCntx);
        }
        _item.setReqCCntx(_tmpReqCCntx);
        final String _tmpReqRSIxx;
        if (_cursor.isNull(_cursorIndexOfReqRSIxx)) {
          _tmpReqRSIxx = null;
        } else {
          _tmpReqRSIxx = _cursor.getString(_cursorIndexOfReqRSIxx);
        }
        _item.setReqRSIxx(_tmpReqRSIxx);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<ESelfieLog>> getAllEmployeeTimeLog(final String fsVal) {
    final String _sql = "SELECT * FROM Employee_Log_Selfie WHERE sEmployID = (SELECT sEmployID FROM User_Info_Master) AND dTransact =? ORDER BY dLogTimex DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Log_Selfie","User_Info_Master"}, false, new Callable<List<ESelfieLog>>() {
      @Override
      public List<ESelfieLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfLogTimex = CursorUtil.getColumnIndexOrThrow(_cursor, "dLogTimex");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfImageIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageIDx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfReqCCntx = CursorUtil.getColumnIndexOrThrow(_cursor, "cReqCCntx");
          final int _cursorIndexOfReqRSIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cReqRSIxx");
          final List<ESelfieLog> _result = new ArrayList<ESelfieLog>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ESelfieLog _item;
            _item = new ESelfieLog();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpEmployID;
            if (_cursor.isNull(_cursorIndexOfEmployID)) {
              _tmpEmployID = null;
            } else {
              _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
            }
            _item.setEmployID(_tmpEmployID);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpLogTimex;
            if (_cursor.isNull(_cursorIndexOfLogTimex)) {
              _tmpLogTimex = null;
            } else {
              _tmpLogTimex = _cursor.getString(_cursorIndexOfLogTimex);
            }
            _item.setLogTimex(_tmpLogTimex);
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
            final String _tmpImageIDx;
            if (_cursor.isNull(_cursorIndexOfImageIDx)) {
              _tmpImageIDx = null;
            } else {
              _tmpImageIDx = _cursor.getString(_cursorIndexOfImageIDx);
            }
            _item.setImageIDx(_tmpImageIDx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
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
            final String _tmpReqCCntx;
            if (_cursor.isNull(_cursorIndexOfReqCCntx)) {
              _tmpReqCCntx = null;
            } else {
              _tmpReqCCntx = _cursor.getString(_cursorIndexOfReqCCntx);
            }
            _item.setReqCCntx(_tmpReqCCntx);
            final String _tmpReqRSIxx;
            if (_cursor.isNull(_cursorIndexOfReqRSIxx)) {
              _tmpReqRSIxx = null;
            } else {
              _tmpReqRSIxx = _cursor.getString(_cursorIndexOfReqRSIxx);
            }
            _item.setReqRSIxx(_tmpReqRSIxx);
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
  public int checkBranchCodeIfExist(final String BranchCd, final String Transact) {
    final String _sql = "SELECT COUNT(*) FROM Employee_Log_Selfie WHERE sBranchCd=? AND dTransact=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
    }
    _argIndex = 2;
    if (Transact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Transact);
    }
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
  public ESelfieLog CheckSelfieLogIfExist(final String BranchCd, final String Transact) {
    final String _sql = "SELECT * FROM Employee_Log_Selfie WHERE sBranchCd=? AND dTransact=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
    }
    _argIndex = 2;
    if (Transact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Transact);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfLogTimex = CursorUtil.getColumnIndexOrThrow(_cursor, "dLogTimex");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfImageIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageIDx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfReqCCntx = CursorUtil.getColumnIndexOrThrow(_cursor, "cReqCCntx");
      final int _cursorIndexOfReqRSIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cReqRSIxx");
      final ESelfieLog _result;
      if(_cursor.moveToFirst()) {
        _result = new ESelfieLog();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpEmployID;
        if (_cursor.isNull(_cursorIndexOfEmployID)) {
          _tmpEmployID = null;
        } else {
          _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
        }
        _result.setEmployID(_tmpEmployID);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpLogTimex;
        if (_cursor.isNull(_cursorIndexOfLogTimex)) {
          _tmpLogTimex = null;
        } else {
          _tmpLogTimex = _cursor.getString(_cursorIndexOfLogTimex);
        }
        _result.setLogTimex(_tmpLogTimex);
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
        final String _tmpImageIDx;
        if (_cursor.isNull(_cursorIndexOfImageIDx)) {
          _tmpImageIDx = null;
        } else {
          _tmpImageIDx = _cursor.getString(_cursorIndexOfImageIDx);
        }
        _result.setImageIDx(_tmpImageIDx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
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
        final String _tmpReqCCntx;
        if (_cursor.isNull(_cursorIndexOfReqCCntx)) {
          _tmpReqCCntx = null;
        } else {
          _tmpReqCCntx = _cursor.getString(_cursorIndexOfReqCCntx);
        }
        _result.setReqCCntx(_tmpReqCCntx);
        final String _tmpReqRSIxx;
        if (_cursor.isNull(_cursorIndexOfReqRSIxx)) {
          _tmpReqRSIxx = null;
        } else {
          _tmpReqRSIxx = _cursor.getString(_cursorIndexOfReqRSIxx);
        }
        _result.setReqRSIxx(_tmpReqRSIxx);
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
  public EBranchInfo GetSelfieLogBranch(final String args) {
    final String _sql = "SELECT * FROM Branch_Info WHERE sBranchCd =?";
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
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EBranchInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EBranchInfo();
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _result.setDescript(_tmpDescript);
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
        final String _tmpAreaCode;
        if (_cursor.isNull(_cursorIndexOfAreaCode)) {
          _tmpAreaCode = null;
        } else {
          _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
        }
        _result.setAreaCode(_tmpAreaCode);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpPromoDiv;
        if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
          _tmpPromoDiv = null;
        } else {
          _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
        }
        _result.setPromoDiv(_tmpPromoDiv);
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
  public LiveData<List<DSelfieLog.LogTime>> GetAllEmployeeTimeLog(final String args) {
    final String _sql = "SELECT a.sTransNox, a.sBranchCd, (SELECT sBranchNm FROM Branch_Info WHERE sBranchCd = a.sBranchCd) AS sBranchNm, a.dTransact, a.dLogTimex, a.cSendStat AS cSlfSentx,b.sTransNox AS sImageIDx, b.sImageNme, b.cSendStat AS cImgSentx, b.sFileLoct,b.dSendDate FROM Employee_Log_Selfie a LEFT JOIN Image_Information b ON a.sImageIDx = b.sTransNox WHERE a.dTransact =? ORDER BY a.dLogTimex DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info","Employee_Log_Selfie","Image_Information"}, false, new Callable<List<DSelfieLog.LogTime>>() {
      @Override
      public List<DSelfieLog.LogTime> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfSBranchCd = 1;
          final int _cursorIndexOfSBranchNm = 2;
          final int _cursorIndexOfDTransact = 3;
          final int _cursorIndexOfDLogTimex = 4;
          final int _cursorIndexOfCSlfSentx = 5;
          final int _cursorIndexOfSImageIDx = 6;
          final int _cursorIndexOfSImageNme = 7;
          final int _cursorIndexOfCImgSentx = 8;
          final int _cursorIndexOfSFileLoct = 9;
          final int _cursorIndexOfDSendDate = 10;
          final List<DSelfieLog.LogTime> _result = new ArrayList<DSelfieLog.LogTime>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DSelfieLog.LogTime _item;
            _item = new DSelfieLog.LogTime();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchCd)) {
              _item.sBranchCd = null;
            } else {
              _item.sBranchCd = _cursor.getString(_cursorIndexOfSBranchCd);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _item.dTransact = null;
            } else {
              _item.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfDLogTimex)) {
              _item.dLogTimex = null;
            } else {
              _item.dLogTimex = _cursor.getString(_cursorIndexOfDLogTimex);
            }
            if (_cursor.isNull(_cursorIndexOfCSlfSentx)) {
              _item.cSlfSentx = null;
            } else {
              _item.cSlfSentx = _cursor.getString(_cursorIndexOfCSlfSentx);
            }
            if (_cursor.isNull(_cursorIndexOfSImageIDx)) {
              _item.sImageIDx = null;
            } else {
              _item.sImageIDx = _cursor.getString(_cursorIndexOfSImageIDx);
            }
            if (_cursor.isNull(_cursorIndexOfSImageNme)) {
              _item.sImageNme = null;
            } else {
              _item.sImageNme = _cursor.getString(_cursorIndexOfSImageNme);
            }
            if (_cursor.isNull(_cursorIndexOfCImgSentx)) {
              _item.cImgSentx = null;
            } else {
              _item.cImgSentx = _cursor.getString(_cursorIndexOfCImgSentx);
            }
            if (_cursor.isNull(_cursorIndexOfSFileLoct)) {
              _item.sFileLoct = null;
            } else {
              _item.sFileLoct = _cursor.getString(_cursorIndexOfSFileLoct);
            }
            if (_cursor.isNull(_cursorIndexOfDSendDate)) {
              _item.dSendDate = null;
            } else {
              _item.dSendDate = _cursor.getString(_cursorIndexOfDSendDate);
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
  public List<EImageInfo> GetSelfieImagesForUpload() {
    final String _sql = "SELECT * FROM Image_Information WHERE sSourceCD = 'LOGa' AND cSendStat = '0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfMD5Hashx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMD5Hashx");
      final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfCaptured = CursorUtil.getColumnIndexOrThrow(_cursor, "dCaptured");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final List<EImageInfo> _result = new ArrayList<EImageInfo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EImageInfo _item;
        _item = new EImageInfo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
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
        final String _tmpDtlSrcNo;
        if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
          _tmpDtlSrcNo = null;
        } else {
          _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
        }
        _item.setDtlSrcNo(_tmpDtlSrcNo);
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _item.setFileCode(_tmpFileCode);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final String _tmpMD5Hashx;
        if (_cursor.isNull(_cursorIndexOfMD5Hashx)) {
          _tmpMD5Hashx = null;
        } else {
          _tmpMD5Hashx = _cursor.getString(_cursorIndexOfMD5Hashx);
        }
        _item.setMD5Hashx(_tmpMD5Hashx);
        final String _tmpFileLoct;
        if (_cursor.isNull(_cursorIndexOfFileLoct)) {
          _tmpFileLoct = null;
        } else {
          _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
        }
        _item.setFileLoct(_tmpFileLoct);
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
        final String _tmpCaptured;
        if (_cursor.isNull(_cursorIndexOfCaptured)) {
          _tmpCaptured = null;
        } else {
          _tmpCaptured = _cursor.getString(_cursorIndexOfCaptured);
        }
        _item.setCaptured(_tmpCaptured);
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
        _result.add(_item);
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
