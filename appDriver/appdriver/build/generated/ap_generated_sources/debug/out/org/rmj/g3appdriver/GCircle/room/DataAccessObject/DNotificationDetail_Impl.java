package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import org.rmj.g3appdriver.GCircle.room.Entities.ENotificationRecipient;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DNotificationDetail_Impl implements DNotificationDetail {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ENotificationRecipient> __insertionAdapterOfENotificationRecipient;

  private final EntityDeletionOrUpdateAdapter<ENotificationRecipient> __updateAdapterOfENotificationRecipient;

  public DNotificationDetail_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfENotificationRecipient = new EntityInsertionAdapter<ENotificationRecipient>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Notification_Info_Recepient` (`sTransNox`,`sAppRcptx`,`sRecpntID`,`sRecpntNm`,`sGroupIDx`,`sGroupNmx`,`cMonitorx`,`cMesgStat`,`cStatSent`,`dSentxxxx`,`dReceived`,`dReadxxxx`,`dLastUpdt`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ENotificationRecipient value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getAppRcptx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAppRcptx());
        }
        if (value.getRecpntID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecpntID());
        }
        if (value.getRecpntNm() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRecpntNm());
        }
        if (value.getGroupIDx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGroupIDx());
        }
        if (value.getGroupNmx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getGroupNmx());
        }
        if (value.getMonitorx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMonitorx());
        }
        if (value.getMesgStat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMesgStat());
        }
        if (value.getStatSent() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStatSent());
        }
        if (value.getSentxxxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSentxxxx());
        }
        if (value.getReceived() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReceived());
        }
        if (value.getReadxxxx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getReadxxxx());
        }
        if (value.getLastUpdt() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLastUpdt());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfENotificationRecipient = new EntityDeletionOrUpdateAdapter<ENotificationRecipient>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Notification_Info_Recepient` SET `sTransNox` = ?,`sAppRcptx` = ?,`sRecpntID` = ?,`sRecpntNm` = ?,`sGroupIDx` = ?,`sGroupNmx` = ?,`cMonitorx` = ?,`cMesgStat` = ?,`cStatSent` = ?,`dSentxxxx` = ?,`dReceived` = ?,`dReadxxxx` = ?,`dLastUpdt` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ENotificationRecipient value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getAppRcptx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAppRcptx());
        }
        if (value.getRecpntID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecpntID());
        }
        if (value.getRecpntNm() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRecpntNm());
        }
        if (value.getGroupIDx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGroupIDx());
        }
        if (value.getGroupNmx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getGroupNmx());
        }
        if (value.getMonitorx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMonitorx());
        }
        if (value.getMesgStat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMesgStat());
        }
        if (value.getStatSent() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getStatSent());
        }
        if (value.getSentxxxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getSentxxxx());
        }
        if (value.getReceived() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReceived());
        }
        if (value.getReadxxxx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getReadxxxx());
        }
        if (value.getLastUpdt() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLastUpdt());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTransNox());
        }
      }
    };
  }

  @Override
  public void Insert(final ENotificationRecipient foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfENotificationRecipient.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final ENotificationRecipient foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfENotificationRecipient.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
