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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.ERaffleStatus;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DRaffleStatus_Impl implements DRaffleStatus {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ERaffleStatus> __insertionAdapterOfERaffleStatus;

  private final EntityDeletionOrUpdateAdapter<ERaffleStatus> __updateAdapterOfERaffleStatus;

  public DRaffleStatus_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfERaffleStatus = new EntityInsertionAdapter<ERaffleStatus>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Raffle_Status` (`sStatusID`,`HasRffle`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERaffleStatus value) {
        if (value.getStatusID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getStatusID());
        }
        if (value.getHasRffle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getHasRffle());
        }
      }
    };
    this.__updateAdapterOfERaffleStatus = new EntityDeletionOrUpdateAdapter<ERaffleStatus>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Raffle_Status` SET `sStatusID` = ?,`HasRffle` = ? WHERE `sStatusID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERaffleStatus value) {
        if (value.getStatusID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getStatusID());
        }
        if (value.getHasRffle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getHasRffle());
        }
        if (value.getStatusID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getStatusID());
        }
      }
    };
  }

  @Override
  public void CreateStatus(final ERaffleStatus foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERaffleStatus.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final ERaffleStatus foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfERaffleStatus.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<ERaffleStatus> HasRaffle() {
    final String _sql = "SELECT * FROM Raffle_Status LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Raffle_Status"}, false, new Callable<ERaffleStatus>() {
      @Override
      public ERaffleStatus call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfStatusID = CursorUtil.getColumnIndexOrThrow(_cursor, "sStatusID");
          final int _cursorIndexOfHasRffle = CursorUtil.getColumnIndexOrThrow(_cursor, "HasRffle");
          final ERaffleStatus _result;
          if(_cursor.moveToFirst()) {
            _result = new ERaffleStatus();
            final Integer _tmpStatusID;
            if (_cursor.isNull(_cursorIndexOfStatusID)) {
              _tmpStatusID = null;
            } else {
              _tmpStatusID = _cursor.getInt(_cursorIndexOfStatusID);
            }
            _result.setStatusID(_tmpStatusID);
            final Integer _tmpHasRffle;
            if (_cursor.isNull(_cursorIndexOfHasRffle)) {
              _tmpHasRffle = null;
            } else {
              _tmpHasRffle = _cursor.getInt(_cursorIndexOfHasRffle);
            }
            _result.setHasRffle(_tmpHasRffle);
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
  public ERaffleStatus GetRaffleStatus() {
    final String _sql = "SELECT * FROM Raffle_Status LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfStatusID = CursorUtil.getColumnIndexOrThrow(_cursor, "sStatusID");
      final int _cursorIndexOfHasRffle = CursorUtil.getColumnIndexOrThrow(_cursor, "HasRffle");
      final ERaffleStatus _result;
      if(_cursor.moveToFirst()) {
        _result = new ERaffleStatus();
        final Integer _tmpStatusID;
        if (_cursor.isNull(_cursorIndexOfStatusID)) {
          _tmpStatusID = null;
        } else {
          _tmpStatusID = _cursor.getInt(_cursorIndexOfStatusID);
        }
        _result.setStatusID(_tmpStatusID);
        final Integer _tmpHasRffle;
        if (_cursor.isNull(_cursorIndexOfHasRffle)) {
          _tmpHasRffle = null;
        } else {
          _tmpHasRffle = _cursor.getInt(_cursorIndexOfHasRffle);
        }
        _result.setHasRffle(_tmpHasRffle);
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
