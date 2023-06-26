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
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.ERelation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DRelation_Impl implements DRelation {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ERelation> __insertionAdapterOfERelation;

  private final EntityDeletionOrUpdateAdapter<ERelation> __updateAdapterOfERelation;

  public DRelation_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfERelation = new EntityInsertionAdapter<ERelation>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Relation` (`sRelatnID`,`sRelatnDs`,`cRecdStats`,`dTimeStmp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERelation value) {
        if (value.getRelatnID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getRelatnID());
        }
        if (value.getRelatnDs() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRelatnDs());
        }
        if (value.getRecdStats() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecdStats());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfERelation = new EntityDeletionOrUpdateAdapter<ERelation>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Relation` SET `sRelatnID` = ?,`sRelatnDs` = ?,`cRecdStats` = ?,`dTimeStmp` = ? WHERE `sRelatnID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERelation value) {
        if (value.getRelatnID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getRelatnID());
        }
        if (value.getRelatnDs() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRelatnDs());
        }
        if (value.getRecdStats() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecdStats());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
        if (value.getRelatnID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRelatnID());
        }
      }
    };
  }

  @Override
  public void insert(final ERelation eRelation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERelation.insert(eRelation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<ERelation> eRelation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERelation.insert(eRelation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ERelation foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfERelation.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Integer GetRelationRecordsCount() {
    final String _sql = "SELECT COUNT(*) FROM RELATION";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Integer _result;
      if(_cursor.moveToFirst()) {
        final Integer _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getInt(0);
        }
        _result = _tmp;
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
  public ERelation GetRelationInfo(final String fsVal) {
    final String _sql = "SELECT * FROM RELATION WHERE sRelatnID=?";
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
      final int _cursorIndexOfRelatnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sRelatnID");
      final int _cursorIndexOfRelatnDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sRelatnDs");
      final int _cursorIndexOfRecdStats = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStats");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ERelation _result;
      if(_cursor.moveToFirst()) {
        _result = new ERelation();
        final String _tmpRelatnID;
        if (_cursor.isNull(_cursorIndexOfRelatnID)) {
          _tmpRelatnID = null;
        } else {
          _tmpRelatnID = _cursor.getString(_cursorIndexOfRelatnID);
        }
        _result.setRelatnID(_tmpRelatnID);
        final String _tmpRelatnDs;
        if (_cursor.isNull(_cursorIndexOfRelatnDs)) {
          _tmpRelatnDs = null;
        } else {
          _tmpRelatnDs = _cursor.getString(_cursorIndexOfRelatnDs);
        }
        _result.setRelatnDs(_tmpRelatnDs);
        final String _tmpRecdStats;
        if (_cursor.isNull(_cursorIndexOfRecdStats)) {
          _tmpRecdStats = null;
        } else {
          _tmpRecdStats = _cursor.getString(_cursorIndexOfRecdStats);
        }
        _result.setRecdStats(_tmpRecdStats);
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
  public ERelation GetLatestRelationInfo() {
    final String _sql = "SELECT * FROM Relation ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfRelatnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sRelatnID");
      final int _cursorIndexOfRelatnDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sRelatnDs");
      final int _cursorIndexOfRecdStats = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStats");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ERelation _result;
      if(_cursor.moveToFirst()) {
        _result = new ERelation();
        final String _tmpRelatnID;
        if (_cursor.isNull(_cursorIndexOfRelatnID)) {
          _tmpRelatnID = null;
        } else {
          _tmpRelatnID = _cursor.getString(_cursorIndexOfRelatnID);
        }
        _result.setRelatnID(_tmpRelatnID);
        final String _tmpRelatnDs;
        if (_cursor.isNull(_cursorIndexOfRelatnDs)) {
          _tmpRelatnDs = null;
        } else {
          _tmpRelatnDs = _cursor.getString(_cursorIndexOfRelatnDs);
        }
        _result.setRelatnDs(_tmpRelatnDs);
        final String _tmpRecdStats;
        if (_cursor.isNull(_cursorIndexOfRecdStats)) {
          _tmpRecdStats = null;
        } else {
          _tmpRecdStats = _cursor.getString(_cursorIndexOfRecdStats);
        }
        _result.setRecdStats(_tmpRecdStats);
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
  public LiveData<List<ERelation>> getRelation() {
    final String _sql = "SELECT * FROM Relation ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Relation"}, false, new Callable<List<ERelation>>() {
      @Override
      public List<ERelation> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRelatnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sRelatnID");
          final int _cursorIndexOfRelatnDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sRelatnDs");
          final int _cursorIndexOfRecdStats = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStats");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<ERelation> _result = new ArrayList<ERelation>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ERelation _item;
            _item = new ERelation();
            final String _tmpRelatnID;
            if (_cursor.isNull(_cursorIndexOfRelatnID)) {
              _tmpRelatnID = null;
            } else {
              _tmpRelatnID = _cursor.getString(_cursorIndexOfRelatnID);
            }
            _item.setRelatnID(_tmpRelatnID);
            final String _tmpRelatnDs;
            if (_cursor.isNull(_cursorIndexOfRelatnDs)) {
              _tmpRelatnDs = null;
            } else {
              _tmpRelatnDs = _cursor.getString(_cursorIndexOfRelatnDs);
            }
            _item.setRelatnDs(_tmpRelatnDs);
            final String _tmpRecdStats;
            if (_cursor.isNull(_cursorIndexOfRecdStats)) {
              _tmpRecdStats = null;
            } else {
              _tmpRecdStats = _cursor.getString(_cursorIndexOfRecdStats);
            }
            _item.setRecdStats(_tmpRecdStats);
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
  public LiveData<String[]> getRelatnDs() {
    final String _sql = "SELECT sRelatnDs FROM Relation";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Relation"}, false, new Callable<String[]>() {
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
  public String getRelationFromId(final String fsRelatId) {
    final String _sql = "SELECT sRelatnDs FROM Relation WHERE sRelatnID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsRelatId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsRelatId);
    }
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
