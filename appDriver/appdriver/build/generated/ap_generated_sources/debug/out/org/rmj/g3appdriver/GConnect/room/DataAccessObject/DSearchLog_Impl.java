package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

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
import org.rmj.g3appdriver.GConnect.room.Entities.ESearchLog;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DSearchLog_Impl implements DSearchLog {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ESearchLog> __insertionAdapterOfESearchLog;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSearch;

  public DSearchLog_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfESearchLog = new EntityInsertionAdapter<ESearchLog>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Mkt_Search_log` (`nEntryNox`,`sSearchxx`,`dTimeStmp`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ESearchLog value) {
        stmt.bindLong(1, value.getEntryNox());
        if (value.getSearchxx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSearchxx());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTimeStmp());
        }
      }
    };
    this.__preparedStmtOfUpdateSearch = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Mkt_Search_log SET dTimeStmp =? WHERE nEntryNox =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveNewSearch(final ESearchLog foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfESearchLog.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateSearch(final int fnArgs, final String DateTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSearch.acquire();
    int _argIndex = 1;
    if (DateTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateTime);
    }
    _argIndex = 2;
    _stmt.bindLong(_argIndex, fnArgs);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSearch.release(_stmt);
    }
  }

  @Override
  public ESearchLog CheckIfExist(final String fsArgs) {
    final String _sql = "SELECT * FROM Mkt_Search_log WHERE sSearchxx=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsArgs == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsArgs);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfSearchxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSearchxx");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ESearchLog _result;
      if(_cursor.moveToFirst()) {
        _result = new ESearchLog();
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpSearchxx;
        if (_cursor.isNull(_cursorIndexOfSearchxx)) {
          _tmpSearchxx = null;
        } else {
          _tmpSearchxx = _cursor.getString(_cursorIndexOfSearchxx);
        }
        _result.setSearchxx(_tmpSearchxx);
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
  public int CreateNewEntryNox() {
    final String _sql = "SELECT COUNT(*) + 1 AS nEntryNox FROM Mkt_Search_log";
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
  public LiveData<List<ESearchLog>> GetSearchLog() {
    final String _sql = "SELECT * FROM Mkt_Search_log ORDER BY dTimeStmp DESC LIMIT 10";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mkt_Search_log"}, false, new Callable<List<ESearchLog>>() {
      @Override
      public List<ESearchLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfSearchxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSearchxx");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<ESearchLog> _result = new ArrayList<ESearchLog>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ESearchLog _item;
            _item = new ESearchLog();
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpSearchxx;
            if (_cursor.isNull(_cursorIndexOfSearchxx)) {
              _tmpSearchxx = null;
            } else {
              _tmpSearchxx = _cursor.getString(_cursorIndexOfSearchxx);
            }
            _item.setSearchxx(_tmpSearchxx);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
