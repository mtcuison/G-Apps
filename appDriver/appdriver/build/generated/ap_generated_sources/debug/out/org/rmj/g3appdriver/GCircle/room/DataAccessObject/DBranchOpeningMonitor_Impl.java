package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

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
import org.rmj.g3appdriver.GCircle.room.Entities.EBranchOpenMonitor;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DBranchOpeningMonitor_Impl implements DBranchOpeningMonitor {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EBranchOpenMonitor> __insertionAdapterOfEBranchOpenMonitor;

  public DBranchOpeningMonitor_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEBranchOpenMonitor = new EntityInsertionAdapter<EBranchOpenMonitor>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Branch_Opening` (`sBranchCD`,`dTransact`,`sTimeOpen`,`sOpenNowx`,`dSendDate`,`dNotified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchOpenMonitor value) {
        if (value.getBranchCD() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBranchCD());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getTimeOpen() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTimeOpen());
        }
        if (value.getOpenNowx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOpenNowx());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSendDate());
        }
        if (value.getNotified() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getNotified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStmp());
        }
      }
    };
  }

  @Override
  public void insert(final EBranchOpenMonitor branchOpenMonitor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchOpenMonitor.insert(branchOpenMonitor);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<EBranchOpenMonitor>> getBranchOpeningForDashBoard(final String dTransact) {
    final String _sql = "SELECT * FROM Branch_Opening WHERE dTransact =? ORDER BY dTimeStmp DESC LIMIT 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Opening"}, false, new Callable<List<EBranchOpenMonitor>>() {
      @Override
      public List<EBranchOpenMonitor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfTimeOpen = CursorUtil.getColumnIndexOrThrow(_cursor, "sTimeOpen");
          final int _cursorIndexOfOpenNowx = CursorUtil.getColumnIndexOrThrow(_cursor, "sOpenNowx");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "dNotified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBranchOpenMonitor> _result = new ArrayList<EBranchOpenMonitor>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchOpenMonitor _item;
            _item = new EBranchOpenMonitor();
            final String _tmpBranchCD;
            if (_cursor.isNull(_cursorIndexOfBranchCD)) {
              _tmpBranchCD = null;
            } else {
              _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
            }
            _item.setBranchCD(_tmpBranchCD);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpTimeOpen;
            if (_cursor.isNull(_cursorIndexOfTimeOpen)) {
              _tmpTimeOpen = null;
            } else {
              _tmpTimeOpen = _cursor.getString(_cursorIndexOfTimeOpen);
            }
            _item.setTimeOpen(_tmpTimeOpen);
            final String _tmpOpenNowx;
            if (_cursor.isNull(_cursorIndexOfOpenNowx)) {
              _tmpOpenNowx = null;
            } else {
              _tmpOpenNowx = _cursor.getString(_cursorIndexOfOpenNowx);
            }
            _item.setOpenNowx(_tmpOpenNowx);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final String _tmpNotified;
            if (_cursor.isNull(_cursorIndexOfNotified)) {
              _tmpNotified = null;
            } else {
              _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
            }
            _item.setNotified(_tmpNotified);
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
  public LiveData<List<EBranchOpenMonitor>> getBranchOpeningForDate(final String dTransact) {
    final String _sql = "SELECT * FROM Branch_Opening WHERE dTransact =? ORDER BY dTimeStmp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Opening"}, false, new Callable<List<EBranchOpenMonitor>>() {
      @Override
      public List<EBranchOpenMonitor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfTimeOpen = CursorUtil.getColumnIndexOrThrow(_cursor, "sTimeOpen");
          final int _cursorIndexOfOpenNowx = CursorUtil.getColumnIndexOrThrow(_cursor, "sOpenNowx");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "dNotified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBranchOpenMonitor> _result = new ArrayList<EBranchOpenMonitor>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchOpenMonitor _item;
            _item = new EBranchOpenMonitor();
            final String _tmpBranchCD;
            if (_cursor.isNull(_cursorIndexOfBranchCD)) {
              _tmpBranchCD = null;
            } else {
              _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
            }
            _item.setBranchCD(_tmpBranchCD);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpTimeOpen;
            if (_cursor.isNull(_cursorIndexOfTimeOpen)) {
              _tmpTimeOpen = null;
            } else {
              _tmpTimeOpen = _cursor.getString(_cursorIndexOfTimeOpen);
            }
            _item.setTimeOpen(_tmpTimeOpen);
            final String _tmpOpenNowx;
            if (_cursor.isNull(_cursorIndexOfOpenNowx)) {
              _tmpOpenNowx = null;
            } else {
              _tmpOpenNowx = _cursor.getString(_cursorIndexOfOpenNowx);
            }
            _item.setOpenNowx(_tmpOpenNowx);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final String _tmpNotified;
            if (_cursor.isNull(_cursorIndexOfNotified)) {
              _tmpNotified = null;
            } else {
              _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
            }
            _item.setNotified(_tmpNotified);
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
  public LiveData<List<DBranchOpeningMonitor.BranchOpeningInfo>> GetBranchOpeningInfoForDashBoard(
      final String dTransact) {
    final String _sql = "SELECT a.sBranchNm,b.sBranchCD, b.dTransact, b.sTimeOpen, b.sOpenNowx, b.dSendDate, b.dNotified FROM Branch_Info a LEFT JOIN Branch_Opening b ON a.sBranchCd = b.sBranchCD WHERE b.dTransact =? ORDER BY b.dTimeStmp DESC LIMIT 5";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info","Branch_Opening"}, false, new Callable<List<DBranchOpeningMonitor.BranchOpeningInfo>>() {
      @Override
      public List<DBranchOpeningMonitor.BranchOpeningInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSBranchNm = 0;
          final int _cursorIndexOfSBranchCD = 1;
          final int _cursorIndexOfDTransact = 2;
          final int _cursorIndexOfSTimeOpen = 3;
          final int _cursorIndexOfSOpenNowx = 4;
          final int _cursorIndexOfDSendDate = 5;
          final int _cursorIndexOfDNotified = 6;
          final List<DBranchOpeningMonitor.BranchOpeningInfo> _result = new ArrayList<DBranchOpeningMonitor.BranchOpeningInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DBranchOpeningMonitor.BranchOpeningInfo _item;
            _item = new DBranchOpeningMonitor.BranchOpeningInfo();
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchCD)) {
              _item.sBranchCD = null;
            } else {
              _item.sBranchCD = _cursor.getString(_cursorIndexOfSBranchCD);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _item.dTransact = null;
            } else {
              _item.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfSTimeOpen)) {
              _item.sTimeOpen = null;
            } else {
              _item.sTimeOpen = _cursor.getString(_cursorIndexOfSTimeOpen);
            }
            if (_cursor.isNull(_cursorIndexOfSOpenNowx)) {
              _item.sOpenNowx = null;
            } else {
              _item.sOpenNowx = _cursor.getString(_cursorIndexOfSOpenNowx);
            }
            if (_cursor.isNull(_cursorIndexOfDSendDate)) {
              _item.dSendDate = null;
            } else {
              _item.dSendDate = _cursor.getString(_cursorIndexOfDSendDate);
            }
            if (_cursor.isNull(_cursorIndexOfDNotified)) {
              _item.dNotified = null;
            } else {
              _item.dNotified = _cursor.getString(_cursorIndexOfDNotified);
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
  public LiveData<List<DBranchOpeningMonitor.BranchOpeningInfo>> getBranchOpeningInfo(
      final String dTransact) {
    final String _sql = "SELECT a.sBranchNm,b.sBranchCD, b.dTransact, b.sTimeOpen, b.sOpenNowx, b.dSendDate, b.dNotified FROM Branch_Info a LEFT JOIN Branch_Opening b ON a.sBranchCd = b.sBranchCD WHERE b.dTransact =? ORDER BY b.dTimeStmp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (dTransact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dTransact);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info","Branch_Opening"}, false, new Callable<List<DBranchOpeningMonitor.BranchOpeningInfo>>() {
      @Override
      public List<DBranchOpeningMonitor.BranchOpeningInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSBranchNm = 0;
          final int _cursorIndexOfSBranchCD = 1;
          final int _cursorIndexOfDTransact = 2;
          final int _cursorIndexOfSTimeOpen = 3;
          final int _cursorIndexOfSOpenNowx = 4;
          final int _cursorIndexOfDSendDate = 5;
          final int _cursorIndexOfDNotified = 6;
          final List<DBranchOpeningMonitor.BranchOpeningInfo> _result = new ArrayList<DBranchOpeningMonitor.BranchOpeningInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DBranchOpeningMonitor.BranchOpeningInfo _item;
            _item = new DBranchOpeningMonitor.BranchOpeningInfo();
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchCD)) {
              _item.sBranchCD = null;
            } else {
              _item.sBranchCD = _cursor.getString(_cursorIndexOfSBranchCD);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _item.dTransact = null;
            } else {
              _item.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfSTimeOpen)) {
              _item.sTimeOpen = null;
            } else {
              _item.sTimeOpen = _cursor.getString(_cursorIndexOfSTimeOpen);
            }
            if (_cursor.isNull(_cursorIndexOfSOpenNowx)) {
              _item.sOpenNowx = null;
            } else {
              _item.sOpenNowx = _cursor.getString(_cursorIndexOfSOpenNowx);
            }
            if (_cursor.isNull(_cursorIndexOfDSendDate)) {
              _item.dSendDate = null;
            } else {
              _item.dSendDate = _cursor.getString(_cursorIndexOfDSendDate);
            }
            if (_cursor.isNull(_cursorIndexOfDNotified)) {
              _item.dNotified = null;
            } else {
              _item.dNotified = _cursor.getString(_cursorIndexOfDNotified);
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
