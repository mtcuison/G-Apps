package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import org.rmj.g3appdriver.GCircle.room.Entities.EPanaloReward;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DPanalo_Impl implements DPanalo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EPanaloReward> __insertionAdapterOfEPanaloReward;

  private final EntityDeletionOrUpdateAdapter<EPanaloReward> __updateAdapterOfEPanaloReward;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public DPanalo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEPanaloReward = new EntityInsertionAdapter<EPanaloReward>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Panalo_Reward` (`sPanaloCD`,`cTranStat`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPanaloReward value) {
        if (value.getPanaloCD() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPanaloCD());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTranStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEPanaloReward = new EntityDeletionOrUpdateAdapter<EPanaloReward>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Panalo_Reward` SET `sPanaloCD` = ?,`cTranStat` = ?,`dModified` = ?,`dTimeStmp` = ? WHERE `sPanaloCD` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPanaloReward value) {
        if (value.getPanaloCD() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPanaloCD());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTranStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
        if (value.getPanaloCD() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPanaloCD());
        }
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Panalo_Reward WHERE sPanaloCD =?";
        return _query;
      }
    };
  }

  @Override
  public void Insert(final EPanaloReward args) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEPanaloReward.insert(args);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final EPanaloReward args) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEPanaloReward.handle(args);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Delete(final String args) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    if (args == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, args);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
