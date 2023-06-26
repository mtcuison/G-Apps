package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

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
import org.rmj.g3appdriver.GConnect.room.Entities.EMCSerialRegistration;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DMCSerialRegistration_Impl implements DMCSerialRegistration {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EMCSerialRegistration> __insertionAdapterOfEMCSerialRegistration;

  private final EntityDeletionOrUpdateAdapter<EMCSerialRegistration> __updateAdapterOfEMCSerialRegistration;

  private final SharedSQLiteStatement __preparedStmtOfDeleteMC;

  public DMCSerialRegistration_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEMCSerialRegistration = new EntityInsertionAdapter<EMCSerialRegistration>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MC_Serial_Registration` (`sSerialID`,`sGCardNox`,`sEngineNo`,`sFrameNox`,`sModelNme`,`sFSEPStat`,`cRegStatx`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMCSerialRegistration value) {
        if (value.getSerialID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSerialID());
        }
        if (value.getGCardNox() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGCardNox());
        }
        if (value.getEngineNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEngineNo());
        }
        if (value.getFrameNox() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFrameNox());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModelNme());
        }
        if (value.getFSEPStat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFSEPStat());
        }
        if (value.getRegStatx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRegStatx());
        }
      }
    };
    this.__updateAdapterOfEMCSerialRegistration = new EntityDeletionOrUpdateAdapter<EMCSerialRegistration>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MC_Serial_Registration` SET `sSerialID` = ?,`sGCardNox` = ?,`sEngineNo` = ?,`sFrameNox` = ?,`sModelNme` = ?,`sFSEPStat` = ?,`cRegStatx` = ? WHERE `sSerialID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMCSerialRegistration value) {
        if (value.getSerialID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSerialID());
        }
        if (value.getGCardNox() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGCardNox());
        }
        if (value.getEngineNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEngineNo());
        }
        if (value.getFrameNox() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFrameNox());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModelNme());
        }
        if (value.getFSEPStat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFSEPStat());
        }
        if (value.getRegStatx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRegStatx());
        }
        if (value.getSerialID() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSerialID());
        }
      }
    };
    this.__preparedStmtOfDeleteMC = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MC_Serial_Registration";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EMCSerialRegistration emcSerialRegistration) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMCSerialRegistration.insert(emcSerialRegistration);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EMCSerialRegistration> emcSerialRegistrationList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMCSerialRegistration.insert(emcSerialRegistrationList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EMCSerialRegistration emcSerialRegistration) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEMCSerialRegistration.handle(emcSerialRegistration);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteMC() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteMC.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteMC.release(_stmt);
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
