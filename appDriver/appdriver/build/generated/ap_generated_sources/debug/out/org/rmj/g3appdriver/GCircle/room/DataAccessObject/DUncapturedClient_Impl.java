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
import org.rmj.g3appdriver.GCircle.room.Entities.EUncapturedClient;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DUncapturedClient_Impl implements DUncapturedClient {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EUncapturedClient> __insertionAdapterOfEUncapturedClient;

  public DUncapturedClient_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEUncapturedClient = new EntityInsertionAdapter<EUncapturedClient>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Uncaptured_Client_Image` (`sTransNox`,`sClientNm`,`sSourceNo`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EUncapturedClient value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClientNm());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSourceNo());
        }
      }
    };
  }

  @Override
  public void insert(final EUncapturedClient uncapturedClient) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEUncapturedClient.insert(uncapturedClient);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
