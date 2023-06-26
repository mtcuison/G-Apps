package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import org.rmj.g3appdriver.GCircle.room.Entities.ETokenInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DToken_Impl implements DToken {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ETokenInfo> __insertionAdapterOfETokenInfo;

  private final EntityDeletionOrUpdateAdapter<ETokenInfo> __updateAdapterOfETokenInfo;

  public DToken_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfETokenInfo = new EntityInsertionAdapter<ETokenInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `App_Token_Info` (`sTokenIDx`,`sTokenInf`,`sDescript`,`sTokenTpe`,`dGeneratd`,`dExpirexx`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ETokenInfo value) {
        if (value.getTokenIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTokenIDx());
        }
        if (value.getTokenInf() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTokenInf());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescript());
        }
        if (value.getTokenTpe() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTokenTpe());
        }
        if (value.getGeneratd() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGeneratd());
        }
        if (value.getExpirexx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getExpirexx());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfETokenInfo = new EntityDeletionOrUpdateAdapter<ETokenInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `App_Token_Info` SET `sTokenIDx` = ?,`sTokenInf` = ?,`sDescript` = ?,`sTokenTpe` = ?,`dGeneratd` = ?,`dExpirexx` = ?,`dModified` = ?,`dTimeStmp` = ? WHERE `sTokenIDx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ETokenInfo value) {
        if (value.getTokenIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTokenIDx());
        }
        if (value.getTokenInf() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTokenInf());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescript());
        }
        if (value.getTokenTpe() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTokenTpe());
        }
        if (value.getGeneratd() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGeneratd());
        }
        if (value.getExpirexx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getExpirexx());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTimeStmp());
        }
        if (value.getTokenIDx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTokenIDx());
        }
      }
    };
  }

  @Override
  public void SaveToken(final ETokenInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfETokenInfo.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateToken(final ETokenInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfETokenInfo.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public ETokenInfo GetFirebaseToken(final String fsVal) {
    final String _sql = "SELECT * FROM App_Token_Info WHERE sTokenInf =?";
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
      final int _cursorIndexOfTokenIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTokenIDx");
      final int _cursorIndexOfTokenInf = CursorUtil.getColumnIndexOrThrow(_cursor, "sTokenInf");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfTokenTpe = CursorUtil.getColumnIndexOrThrow(_cursor, "sTokenTpe");
      final int _cursorIndexOfGeneratd = CursorUtil.getColumnIndexOrThrow(_cursor, "dGeneratd");
      final int _cursorIndexOfExpirexx = CursorUtil.getColumnIndexOrThrow(_cursor, "dExpirexx");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ETokenInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new ETokenInfo();
        final String _tmpTokenIDx;
        if (_cursor.isNull(_cursorIndexOfTokenIDx)) {
          _tmpTokenIDx = null;
        } else {
          _tmpTokenIDx = _cursor.getString(_cursorIndexOfTokenIDx);
        }
        _result.setTokenIDx(_tmpTokenIDx);
        final String _tmpTokenInf;
        if (_cursor.isNull(_cursorIndexOfTokenInf)) {
          _tmpTokenInf = null;
        } else {
          _tmpTokenInf = _cursor.getString(_cursorIndexOfTokenInf);
        }
        _result.setTokenInf(_tmpTokenInf);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _result.setDescript(_tmpDescript);
        final String _tmpTokenTpe;
        if (_cursor.isNull(_cursorIndexOfTokenTpe)) {
          _tmpTokenTpe = null;
        } else {
          _tmpTokenTpe = _cursor.getString(_cursorIndexOfTokenTpe);
        }
        _result.setTokenTpe(_tmpTokenTpe);
        final String _tmpGeneratd;
        if (_cursor.isNull(_cursorIndexOfGeneratd)) {
          _tmpGeneratd = null;
        } else {
          _tmpGeneratd = _cursor.getString(_cursorIndexOfGeneratd);
        }
        _result.setGeneratd(_tmpGeneratd);
        final String _tmpExpirexx;
        if (_cursor.isNull(_cursorIndexOfExpirexx)) {
          _tmpExpirexx = null;
        } else {
          _tmpExpirexx = _cursor.getString(_cursorIndexOfExpirexx);
        }
        _result.setExpirexx(_tmpExpirexx);
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
  public int GetTokenRowsForID() {
    final String _sql = "SELECT COUNT (*) FROM App_Token_Info";
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
  public ETokenInfo GetClientToken() {
    final String _sql = "SELECT * FROM App_Token_Info WHERE sTokenTpe = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTokenIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTokenIDx");
      final int _cursorIndexOfTokenInf = CursorUtil.getColumnIndexOrThrow(_cursor, "sTokenInf");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfTokenTpe = CursorUtil.getColumnIndexOrThrow(_cursor, "sTokenTpe");
      final int _cursorIndexOfGeneratd = CursorUtil.getColumnIndexOrThrow(_cursor, "dGeneratd");
      final int _cursorIndexOfExpirexx = CursorUtil.getColumnIndexOrThrow(_cursor, "dExpirexx");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ETokenInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new ETokenInfo();
        final String _tmpTokenIDx;
        if (_cursor.isNull(_cursorIndexOfTokenIDx)) {
          _tmpTokenIDx = null;
        } else {
          _tmpTokenIDx = _cursor.getString(_cursorIndexOfTokenIDx);
        }
        _result.setTokenIDx(_tmpTokenIDx);
        final String _tmpTokenInf;
        if (_cursor.isNull(_cursorIndexOfTokenInf)) {
          _tmpTokenInf = null;
        } else {
          _tmpTokenInf = _cursor.getString(_cursorIndexOfTokenInf);
        }
        _result.setTokenInf(_tmpTokenInf);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _result.setDescript(_tmpDescript);
        final String _tmpTokenTpe;
        if (_cursor.isNull(_cursorIndexOfTokenTpe)) {
          _tmpTokenTpe = null;
        } else {
          _tmpTokenTpe = _cursor.getString(_cursorIndexOfTokenTpe);
        }
        _result.setTokenTpe(_tmpTokenTpe);
        final String _tmpGeneratd;
        if (_cursor.isNull(_cursorIndexOfGeneratd)) {
          _tmpGeneratd = null;
        } else {
          _tmpGeneratd = _cursor.getString(_cursorIndexOfGeneratd);
        }
        _result.setGeneratd(_tmpGeneratd);
        final String _tmpExpirexx;
        if (_cursor.isNull(_cursorIndexOfExpirexx)) {
          _tmpExpirexx = null;
        } else {
          _tmpExpirexx = _cursor.getString(_cursorIndexOfExpirexx);
        }
        _result.setExpirexx(_tmpExpirexx);
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
  public ETokenInfo GetAccessToken() {
    final String _sql = "SELECT * FROM App_Token_Info WHERE sTokenTpe = '2'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTokenIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTokenIDx");
      final int _cursorIndexOfTokenInf = CursorUtil.getColumnIndexOrThrow(_cursor, "sTokenInf");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfTokenTpe = CursorUtil.getColumnIndexOrThrow(_cursor, "sTokenTpe");
      final int _cursorIndexOfGeneratd = CursorUtil.getColumnIndexOrThrow(_cursor, "dGeneratd");
      final int _cursorIndexOfExpirexx = CursorUtil.getColumnIndexOrThrow(_cursor, "dExpirexx");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ETokenInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new ETokenInfo();
        final String _tmpTokenIDx;
        if (_cursor.isNull(_cursorIndexOfTokenIDx)) {
          _tmpTokenIDx = null;
        } else {
          _tmpTokenIDx = _cursor.getString(_cursorIndexOfTokenIDx);
        }
        _result.setTokenIDx(_tmpTokenIDx);
        final String _tmpTokenInf;
        if (_cursor.isNull(_cursorIndexOfTokenInf)) {
          _tmpTokenInf = null;
        } else {
          _tmpTokenInf = _cursor.getString(_cursorIndexOfTokenInf);
        }
        _result.setTokenInf(_tmpTokenInf);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _result.setDescript(_tmpDescript);
        final String _tmpTokenTpe;
        if (_cursor.isNull(_cursorIndexOfTokenTpe)) {
          _tmpTokenTpe = null;
        } else {
          _tmpTokenTpe = _cursor.getString(_cursorIndexOfTokenTpe);
        }
        _result.setTokenTpe(_tmpTokenTpe);
        final String _tmpGeneratd;
        if (_cursor.isNull(_cursorIndexOfGeneratd)) {
          _tmpGeneratd = null;
        } else {
          _tmpGeneratd = _cursor.getString(_cursorIndexOfGeneratd);
        }
        _result.setGeneratd(_tmpGeneratd);
        final String _tmpExpirexx;
        if (_cursor.isNull(_cursorIndexOfExpirexx)) {
          _tmpExpirexx = null;
        } else {
          _tmpExpirexx = _cursor.getString(_cursorIndexOfExpirexx);
        }
        _result.setExpirexx(_tmpExpirexx);
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
  public String GetClientID() {
    final String _sql = "SELECT sClientID FROM User_Info_Master";
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
    final String _sql = "SELECT sUserIDxx FROM User_Info_Master";
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
