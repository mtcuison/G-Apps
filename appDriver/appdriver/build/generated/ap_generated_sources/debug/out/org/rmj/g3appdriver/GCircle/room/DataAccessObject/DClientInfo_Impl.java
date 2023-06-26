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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EClientInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DClientInfo_Impl implements DClientInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EClientInfo> __insertionAdapterOfEClientInfo;

  private final EntityDeletionOrUpdateAdapter<EClientInfo> __updateAdapterOfEClientInfo;

  public DClientInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEClientInfo = new EntityInsertionAdapter<EClientInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Client_Info_Master` (`sUserIDxx`,`sEmailAdd`,`sUserName`,`dLoginxxx`,`sMobileNo`,`dDateMmbr`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EClientInfo value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getEmailAdd() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmailAdd());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserName());
        }
        if (value.getLoginxxx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLoginxxx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMobileNo());
        }
        if (value.getDateMmbr() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDateMmbr());
        }
      }
    };
    this.__updateAdapterOfEClientInfo = new EntityDeletionOrUpdateAdapter<EClientInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Client_Info_Master` SET `sUserIDxx` = ?,`sEmailAdd` = ?,`sUserName` = ?,`dLoginxxx` = ?,`sMobileNo` = ?,`dDateMmbr` = ? WHERE `sUserIDxx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EClientInfo value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getEmailAdd() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmailAdd());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserName());
        }
        if (value.getLoginxxx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLoginxxx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMobileNo());
        }
        if (value.getDateMmbr() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDateMmbr());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUserIDxx());
        }
      }
    };
  }

  @Override
  public void insert(final EClientInfo clientInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEClientInfo.insert(clientInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EClientInfo clientInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEClientInfo.handle(clientInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<EClientInfo> getClientInfo() {
    final String _sql = "SELECT * FROM Client_Info_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Client_Info_Master"}, false, new Callable<EClientInfo>() {
      @Override
      public EClientInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserName");
          final int _cursorIndexOfLoginxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dLoginxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfDateMmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateMmbr");
          final EClientInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EClientInfo();
            final String _tmpUserIDxx;
            if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
              _tmpUserIDxx = null;
            } else {
              _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
            }
            _result.setUserIDxx(_tmpUserIDxx);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _result.setEmailAdd(_tmpEmailAdd);
            final String _tmpUserName;
            if (_cursor.isNull(_cursorIndexOfUserName)) {
              _tmpUserName = null;
            } else {
              _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            }
            _result.setUserName(_tmpUserName);
            final String _tmpLoginxxx;
            if (_cursor.isNull(_cursorIndexOfLoginxxx)) {
              _tmpLoginxxx = null;
            } else {
              _tmpLoginxxx = _cursor.getString(_cursorIndexOfLoginxxx);
            }
            _result.setLoginxxx(_tmpLoginxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final String _tmpDateMmbr;
            if (_cursor.isNull(_cursorIndexOfDateMmbr)) {
              _tmpDateMmbr = null;
            } else {
              _tmpDateMmbr = _cursor.getString(_cursorIndexOfDateMmbr);
            }
            _result.setDateMmbr(_tmpDateMmbr);
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
  public String getUserID() {
    final String _sql = "SELECT sUserIDxx FROM Client_Info_Master";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
