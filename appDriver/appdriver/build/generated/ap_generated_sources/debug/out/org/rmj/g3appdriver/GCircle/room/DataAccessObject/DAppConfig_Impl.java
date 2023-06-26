package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import org.rmj.g3appdriver.GCircle.room.Entities.EAppConfig;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAppConfig_Impl implements DAppConfig {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EAppConfig> __insertionAdapterOfEAppConfig;

  private final EntityInsertionAdapter<EAppConfig> __insertionAdapterOfEAppConfig_1;

  public DAppConfig_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEAppConfig = new EntityInsertionAdapter<EAppConfig>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `xxxAppConfig` (`sConfigCd`,`sConfigDs`,`sConfigVl`,`dTimeStmp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EAppConfig value) {
        if (value.getConfigCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConfigCd());
        }
        if (value.getConfigDs() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getConfigDs());
        }
        if (value.getConfigVl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getConfigVl());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfEAppConfig_1 = new EntityInsertionAdapter<EAppConfig>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `xxxAppConfig` (`sConfigCd`,`sConfigDs`,`sConfigVl`,`dTimeStmp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EAppConfig value) {
        if (value.getConfigCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getConfigCd());
        }
        if (value.getConfigDs() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getConfigDs());
        }
        if (value.getConfigVl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getConfigVl());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
      }
    };
  }

  @Override
  public void insert(final EAppConfig sysConfig) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEAppConfig.insert(sysConfig);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertSysConfig(final List<EAppConfig> sysConfigs) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEAppConfig_1.insert(sysConfigs);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
