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
import org.rmj.g3appdriver.GCircle.room.Entities.EBankInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DBankInfo_Impl implements DBankInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EBankInfo> __insertionAdapterOfEBankInfo;

  private final EntityDeletionOrUpdateAdapter<EBankInfo> __updateAdapterOfEBankInfo;

  public DBankInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEBankInfo = new EntityInsertionAdapter<EBankInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Bank_Info` (`sBankIDxx`,`sBankName`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBankInfo value) {
        if (value.getBankIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBankIDxx());
        }
        if (value.getBankName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBankName());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEBankInfo = new EntityDeletionOrUpdateAdapter<EBankInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Bank_Info` SET `sBankIDxx` = ?,`sBankName` = ?,`cRecdStat` = ?,`dTimeStmp` = ? WHERE `sBankIDxx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBankInfo value) {
        if (value.getBankIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBankIDxx());
        }
        if (value.getBankName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBankName());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
        if (value.getBankIDxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBankIDxx());
        }
      }
    };
  }

  @Override
  public void SaveBankInfo(final EBankInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBankInfo.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateBankInfo(final EBankInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEBankInfo.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<EBankInfo>> getBankInfoList() {
    final String _sql = "SELECT * FROM Bank_Info WHERE cRecdStat = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Bank_Info"}, false, new Callable<List<EBankInfo>>() {
      @Override
      public List<EBankInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
          final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankName");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBankInfo> _result = new ArrayList<EBankInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBankInfo _item;
            _item = new EBankInfo();
            final String _tmpBankIDxx;
            if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
              _tmpBankIDxx = null;
            } else {
              _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
            }
            _item.setBankIDxx(_tmpBankIDxx);
            final String _tmpBankName;
            if (_cursor.isNull(_cursorIndexOfBankName)) {
              _tmpBankName = null;
            } else {
              _tmpBankName = _cursor.getString(_cursorIndexOfBankName);
            }
            _item.setBankName(_tmpBankName);
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
  public EBankInfo GetBankInfo(final String BankID) {
    final String _sql = "SELECT * FROM Bank_Info WHERE sBankIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BankID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BankID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBankIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankIDxx");
      final int _cursorIndexOfBankName = CursorUtil.getColumnIndexOrThrow(_cursor, "sBankName");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EBankInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EBankInfo();
        final String _tmpBankIDxx;
        if (_cursor.isNull(_cursorIndexOfBankIDxx)) {
          _tmpBankIDxx = null;
        } else {
          _tmpBankIDxx = _cursor.getString(_cursorIndexOfBankIDxx);
        }
        _result.setBankIDxx(_tmpBankIDxx);
        final String _tmpBankName;
        if (_cursor.isNull(_cursorIndexOfBankName)) {
          _tmpBankName = null;
        } else {
          _tmpBankName = _cursor.getString(_cursorIndexOfBankName);
        }
        _result.setBankName(_tmpBankName);
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
  public LiveData<String[]> getBankNameList() {
    final String _sql = "SELECT sBankName FROM Bank_Info WHERE cRecdStat = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Bank_Info"}, false, new Callable<String[]>() {
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
  public LiveData<String> getBankNameFromId(final String fsBankId) {
    final String _sql = "SELECT sBankName FROM Bank_Info WHERE cRecdStat = 1 AND sBankIDxx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsBankId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsBankId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Bank_Info"}, false, new Callable<String>() {
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
