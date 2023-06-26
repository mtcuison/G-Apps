package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import org.rmj.g3appdriver.GConnect.room.Entities.ETokenInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DRawDao_Impl implements DRawDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ETokenInfo> __insertionAdapterOfETokenInfo;

  private final SharedSQLiteStatement __preparedStmtOfClearTokenInfo;

  public DRawDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfETokenInfo = new EntityInsertionAdapter<ETokenInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `App_Token_Info` (`sAppToken`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ETokenInfo value) {
        if (value.getTokenInf() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTokenInf());
        }
      }
    };
    this.__preparedStmtOfClearTokenInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM App_Token_Info";
        return _query;
      }
    };
  }

  @Override
  public void insertTokenInfo(final ETokenInfo tokenInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfETokenInfo.insert(tokenInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clearTokenInfo() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearTokenInfo.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearTokenInfo.release(_stmt);
    }
  }

  @Override
  public String getTokenInfo() {
    final String _sql = "SELECT sAppToken FROM App_Token_Info";
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

  @Override
  public String GetUserID() {
    final String _sql = "SELECT sUserIDxx FROM Client_Profile_Info";
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

  @Override
  public String GetNotificationRcptID() {
    final String _sql = "SELECT sTransNox FROM Notification_Info_Recepient ORDER BY sTransNox DESC LIMIT 1";
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
