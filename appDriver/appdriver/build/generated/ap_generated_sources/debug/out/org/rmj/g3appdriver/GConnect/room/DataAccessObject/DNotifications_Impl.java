package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
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
import org.rmj.g3appdriver.GConnect.room.Entities.ENotificationMaster;
import org.rmj.g3appdriver.GConnect.room.Entities.ENotificationRecipient;
import org.rmj.g3appdriver.GConnect.room.Entities.ENotificationUser;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DNotifications_Impl implements DNotifications {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ENotificationMaster> __insertionAdapterOfENotificationMaster;

  private final EntityInsertionAdapter<ENotificationRecipient> __insertionAdapterOfENotificationRecipient;

  private final EntityInsertionAdapter<ENotificationUser> __insertionAdapterOfENotificationUser;

  private final EntityDeletionOrUpdateAdapter<ENotificationMaster> __updateAdapterOfENotificationMaster;

  private final EntityDeletionOrUpdateAdapter<ENotificationRecipient> __updateAdapterOfENotificationRecipient;

  private final EntityDeletionOrUpdateAdapter<ENotificationUser> __updateAdapterOfENotificationUser;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNotificationStatusFromOtherDevice;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentResponseStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateRecipientReceivedStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReadReceivedStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateRecipientReadStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateMessageReadStatus;

  public DNotifications_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfENotificationMaster = new EntityInsertionAdapter<ENotificationMaster>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Notification_Info_Master` (`sTransNox`,`sMesgIDxx`,`sParentxx`,`dCreatedx`,`sAppSrcex`,`sCreatrID`,`sCreatrNm`,`sMsgTitle`,`sMessagex`,`sURLxxxxx`,`sDataSndx`,`sMsgTypex`,`cSentxxxx`,`dSentxxxx`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ENotificationMaster value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getMesgIDxx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMesgIDxx());
        }
        if (value.getParentxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getParentxx());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCreatedx());
        }
        if (value.getAppSrcex() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAppSrcex());
        }
        if (value.getCreatrID() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreatrID());
        }
        if (value.getCreatrNm() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCreatrNm());
        }
        if (value.getMsgTitle() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMsgTitle());
        }
        if (value.getMessagex() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMessagex());
        }
        if (value.getURLxxxxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getURLxxxxx());
        }
        if (value.getDataSndx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDataSndx());
        }
        if (value.getMsgTypex() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMsgTypex());
        }
        if (value.getSentcxxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getSentcxxx());
        }
        if (value.getSentdxxx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSentdxxx());
        }
      }
    };
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
    this.__insertionAdapterOfENotificationUser = new EntityInsertionAdapter<ENotificationUser>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Notification_User` (`sUserIDxx`,`sUserName`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ENotificationUser value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserName());
        }
      }
    };
    this.__updateAdapterOfENotificationMaster = new EntityDeletionOrUpdateAdapter<ENotificationMaster>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Notification_Info_Master` SET `sTransNox` = ?,`sMesgIDxx` = ?,`sParentxx` = ?,`dCreatedx` = ?,`sAppSrcex` = ?,`sCreatrID` = ?,`sCreatrNm` = ?,`sMsgTitle` = ?,`sMessagex` = ?,`sURLxxxxx` = ?,`sDataSndx` = ?,`sMsgTypex` = ?,`cSentxxxx` = ?,`dSentxxxx` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ENotificationMaster value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getMesgIDxx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMesgIDxx());
        }
        if (value.getParentxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getParentxx());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCreatedx());
        }
        if (value.getAppSrcex() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAppSrcex());
        }
        if (value.getCreatrID() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreatrID());
        }
        if (value.getCreatrNm() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCreatrNm());
        }
        if (value.getMsgTitle() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMsgTitle());
        }
        if (value.getMessagex() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMessagex());
        }
        if (value.getURLxxxxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getURLxxxxx());
        }
        if (value.getDataSndx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDataSndx());
        }
        if (value.getMsgTypex() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getMsgTypex());
        }
        if (value.getSentcxxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getSentcxxx());
        }
        if (value.getSentdxxx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSentdxxx());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTransNox());
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
    this.__updateAdapterOfENotificationUser = new EntityDeletionOrUpdateAdapter<ENotificationUser>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Notification_User` SET `sUserIDxx` = ?,`sUserName` = ? WHERE `sUserIDxx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ENotificationUser value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserName());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserIDxx());
        }
      }
    };
    this.__preparedStmtOfUpdateNotificationStatusFromOtherDevice = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Notification_Info_Recepient SET cMesgStat =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSentResponseStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Notification_Info_Recepient SET dLastUpdt =?, dReceived =?, cMesgStat =?, cStatSent = '1' WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateRecipientReceivedStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Notification_Info_Recepient SET dLastUpdt =?, dReceived =?, cMesgStat = '2', cStatSent = '1' WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateReadReceivedStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Notification_Info_Recepient SET dLastUpdt =?, dReadxxxx =?, cMesgStat = '3', cStatSent = '1' WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateRecipientReadStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Notification_Info_Recepient SET dReadxxxx =?, cMesgStat = '3', cStatSent = '0' WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateMessageReadStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Notification_Info_Recepient SET dReadxxxx =?, cMesgStat = '3', cStatSent = '0' WHERE sTransNox =(SELECT sMesgIDxx FROM Notification_Info_Master WHERE sCreatrID=?) AND cMesgStat == '2'";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ENotificationMaster notificationMaster) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfENotificationMaster.insert(notificationMaster);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final ENotificationRecipient notificationRecipient) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfENotificationRecipient.insert(notificationRecipient);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final ENotificationUser notificationUser) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfENotificationUser.insert(notificationUser);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ENotificationMaster notificationMaster) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfENotificationMaster.handle(notificationMaster);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ENotificationRecipient notificationRecipient) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfENotificationRecipient.handle(notificationRecipient);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ENotificationUser notificationUser) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfENotificationUser.handle(notificationUser);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateNotificationStatusFromOtherDevice(final String MessageID, final String status) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNotificationStatusFromOtherDevice.acquire();
    int _argIndex = 1;
    if (status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, status);
    }
    _argIndex = 2;
    if (MessageID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, MessageID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateNotificationStatusFromOtherDevice.release(_stmt);
    }
  }

  @Override
  public void UpdateSentResponseStatus(final String MessageID, final String Status,
      final String dateTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSentResponseStatus.acquire();
    int _argIndex = 1;
    if (dateTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, dateTime);
    }
    _argIndex = 2;
    if (dateTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, dateTime);
    }
    _argIndex = 3;
    if (Status == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Status);
    }
    _argIndex = 4;
    if (MessageID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, MessageID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSentResponseStatus.release(_stmt);
    }
  }

  @Override
  public void updateRecipientReceivedStatus(final String MessageID, final String fsArgs) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateRecipientReceivedStatus.acquire();
    int _argIndex = 1;
    if (fsArgs == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsArgs);
    }
    _argIndex = 2;
    if (fsArgs == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsArgs);
    }
    _argIndex = 3;
    if (MessageID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, MessageID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateRecipientReceivedStatus.release(_stmt);
    }
  }

  @Override
  public void updateReadReceivedStatus(final String MessageID, final String fsArgs) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReadReceivedStatus.acquire();
    int _argIndex = 1;
    if (fsArgs == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsArgs);
    }
    _argIndex = 2;
    if (fsArgs == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsArgs);
    }
    _argIndex = 3;
    if (MessageID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, MessageID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateReadReceivedStatus.release(_stmt);
    }
  }

  @Override
  public void updateRecipientReadStatus(final String MessageID, final String DateTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateRecipientReadStatus.acquire();
    int _argIndex = 1;
    if (DateTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateTime);
    }
    _argIndex = 2;
    if (MessageID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, MessageID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateRecipientReadStatus.release(_stmt);
    }
  }

  @Override
  public void updateMessageReadStatus(final String SenderID, final String DateTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateMessageReadStatus.acquire();
    int _argIndex = 1;
    if (DateTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateTime);
    }
    _argIndex = 2;
    if (SenderID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, SenderID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateMessageReadStatus.release(_stmt);
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
  public ENotificationMaster CheckIfMasterExist(final String fsVal) {
    final String _sql = "SELECT * FROM Notification_Info_Master WHERE sMesgIDxx=?";
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
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfMesgIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMesgIDxx");
      final int _cursorIndexOfParentxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sParentxx");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfAppSrcex = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppSrcex");
      final int _cursorIndexOfCreatrID = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatrID");
      final int _cursorIndexOfCreatrNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatrNm");
      final int _cursorIndexOfMsgTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "sMsgTitle");
      final int _cursorIndexOfMessagex = CursorUtil.getColumnIndexOrThrow(_cursor, "sMessagex");
      final int _cursorIndexOfURLxxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sURLxxxxx");
      final int _cursorIndexOfDataSndx = CursorUtil.getColumnIndexOrThrow(_cursor, "sDataSndx");
      final int _cursorIndexOfMsgTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "sMsgTypex");
      final int _cursorIndexOfSentcxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSentxxxx");
      final int _cursorIndexOfSentdxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dSentxxxx");
      final ENotificationMaster _result;
      if(_cursor.moveToFirst()) {
        _result = new ENotificationMaster();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpMesgIDxx;
        if (_cursor.isNull(_cursorIndexOfMesgIDxx)) {
          _tmpMesgIDxx = null;
        } else {
          _tmpMesgIDxx = _cursor.getString(_cursorIndexOfMesgIDxx);
        }
        _result.setMesgIDxx(_tmpMesgIDxx);
        final String _tmpParentxx;
        if (_cursor.isNull(_cursorIndexOfParentxx)) {
          _tmpParentxx = null;
        } else {
          _tmpParentxx = _cursor.getString(_cursorIndexOfParentxx);
        }
        _result.setParentxx(_tmpParentxx);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _result.setCreatedx(_tmpCreatedx);
        final String _tmpAppSrcex;
        if (_cursor.isNull(_cursorIndexOfAppSrcex)) {
          _tmpAppSrcex = null;
        } else {
          _tmpAppSrcex = _cursor.getString(_cursorIndexOfAppSrcex);
        }
        _result.setAppSrcex(_tmpAppSrcex);
        final String _tmpCreatrID;
        if (_cursor.isNull(_cursorIndexOfCreatrID)) {
          _tmpCreatrID = null;
        } else {
          _tmpCreatrID = _cursor.getString(_cursorIndexOfCreatrID);
        }
        _result.setCreatrID(_tmpCreatrID);
        final String _tmpCreatrNm;
        if (_cursor.isNull(_cursorIndexOfCreatrNm)) {
          _tmpCreatrNm = null;
        } else {
          _tmpCreatrNm = _cursor.getString(_cursorIndexOfCreatrNm);
        }
        _result.setCreatrNm(_tmpCreatrNm);
        final String _tmpMsgTitle;
        if (_cursor.isNull(_cursorIndexOfMsgTitle)) {
          _tmpMsgTitle = null;
        } else {
          _tmpMsgTitle = _cursor.getString(_cursorIndexOfMsgTitle);
        }
        _result.setMsgTitle(_tmpMsgTitle);
        final String _tmpMessagex;
        if (_cursor.isNull(_cursorIndexOfMessagex)) {
          _tmpMessagex = null;
        } else {
          _tmpMessagex = _cursor.getString(_cursorIndexOfMessagex);
        }
        _result.setMessagex(_tmpMessagex);
        final String _tmpURLxxxxx;
        if (_cursor.isNull(_cursorIndexOfURLxxxxx)) {
          _tmpURLxxxxx = null;
        } else {
          _tmpURLxxxxx = _cursor.getString(_cursorIndexOfURLxxxxx);
        }
        _result.setURLxxxxx(_tmpURLxxxxx);
        final String _tmpDataSndx;
        if (_cursor.isNull(_cursorIndexOfDataSndx)) {
          _tmpDataSndx = null;
        } else {
          _tmpDataSndx = _cursor.getString(_cursorIndexOfDataSndx);
        }
        _result.setDataSndx(_tmpDataSndx);
        final String _tmpMsgTypex;
        if (_cursor.isNull(_cursorIndexOfMsgTypex)) {
          _tmpMsgTypex = null;
        } else {
          _tmpMsgTypex = _cursor.getString(_cursorIndexOfMsgTypex);
        }
        _result.setMsgTypex(_tmpMsgTypex);
        final String _tmpSentcxxx;
        if (_cursor.isNull(_cursorIndexOfSentcxxx)) {
          _tmpSentcxxx = null;
        } else {
          _tmpSentcxxx = _cursor.getString(_cursorIndexOfSentcxxx);
        }
        _result.setSentcxxx(_tmpSentcxxx);
        final String _tmpSentdxxx;
        if (_cursor.isNull(_cursorIndexOfSentdxxx)) {
          _tmpSentdxxx = null;
        } else {
          _tmpSentdxxx = _cursor.getString(_cursorIndexOfSentdxxx);
        }
        _result.setSentdxxx(_tmpSentdxxx);
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
  public ENotificationRecipient CheckIfRecipientExist(final String fsVal) {
    final String _sql = "SELECT * FROM Notification_Info_Recepient WHERE sTransNox=?";
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
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfAppRcptx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppRcptx");
      final int _cursorIndexOfRecpntID = CursorUtil.getColumnIndexOrThrow(_cursor, "sRecpntID");
      final int _cursorIndexOfRecpntNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sRecpntNm");
      final int _cursorIndexOfGroupIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sGroupIDx");
      final int _cursorIndexOfGroupNmx = CursorUtil.getColumnIndexOrThrow(_cursor, "sGroupNmx");
      final int _cursorIndexOfMonitorx = CursorUtil.getColumnIndexOrThrow(_cursor, "cMonitorx");
      final int _cursorIndexOfMesgStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cMesgStat");
      final int _cursorIndexOfStatSent = CursorUtil.getColumnIndexOrThrow(_cursor, "cStatSent");
      final int _cursorIndexOfSentxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dSentxxxx");
      final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
      final int _cursorIndexOfReadxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dReadxxxx");
      final int _cursorIndexOfLastUpdt = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastUpdt");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ENotificationRecipient _result;
      if(_cursor.moveToFirst()) {
        _result = new ENotificationRecipient();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpAppRcptx;
        if (_cursor.isNull(_cursorIndexOfAppRcptx)) {
          _tmpAppRcptx = null;
        } else {
          _tmpAppRcptx = _cursor.getString(_cursorIndexOfAppRcptx);
        }
        _result.setAppRcptx(_tmpAppRcptx);
        final String _tmpRecpntID;
        if (_cursor.isNull(_cursorIndexOfRecpntID)) {
          _tmpRecpntID = null;
        } else {
          _tmpRecpntID = _cursor.getString(_cursorIndexOfRecpntID);
        }
        _result.setRecpntID(_tmpRecpntID);
        final String _tmpRecpntNm;
        if (_cursor.isNull(_cursorIndexOfRecpntNm)) {
          _tmpRecpntNm = null;
        } else {
          _tmpRecpntNm = _cursor.getString(_cursorIndexOfRecpntNm);
        }
        _result.setRecpntNm(_tmpRecpntNm);
        final String _tmpGroupIDx;
        if (_cursor.isNull(_cursorIndexOfGroupIDx)) {
          _tmpGroupIDx = null;
        } else {
          _tmpGroupIDx = _cursor.getString(_cursorIndexOfGroupIDx);
        }
        _result.setGroupIDx(_tmpGroupIDx);
        final String _tmpGroupNmx;
        if (_cursor.isNull(_cursorIndexOfGroupNmx)) {
          _tmpGroupNmx = null;
        } else {
          _tmpGroupNmx = _cursor.getString(_cursorIndexOfGroupNmx);
        }
        _result.setGroupNmx(_tmpGroupNmx);
        final String _tmpMonitorx;
        if (_cursor.isNull(_cursorIndexOfMonitorx)) {
          _tmpMonitorx = null;
        } else {
          _tmpMonitorx = _cursor.getString(_cursorIndexOfMonitorx);
        }
        _result.setMonitorx(_tmpMonitorx);
        final String _tmpMesgStat;
        if (_cursor.isNull(_cursorIndexOfMesgStat)) {
          _tmpMesgStat = null;
        } else {
          _tmpMesgStat = _cursor.getString(_cursorIndexOfMesgStat);
        }
        _result.setMesgStat(_tmpMesgStat);
        final String _tmpStatSent;
        if (_cursor.isNull(_cursorIndexOfStatSent)) {
          _tmpStatSent = null;
        } else {
          _tmpStatSent = _cursor.getString(_cursorIndexOfStatSent);
        }
        _result.setStatSent(_tmpStatSent);
        final String _tmpSentxxxx;
        if (_cursor.isNull(_cursorIndexOfSentxxxx)) {
          _tmpSentxxxx = null;
        } else {
          _tmpSentxxxx = _cursor.getString(_cursorIndexOfSentxxxx);
        }
        _result.setSentxxxx(_tmpSentxxxx);
        final String _tmpReceived;
        if (_cursor.isNull(_cursorIndexOfReceived)) {
          _tmpReceived = null;
        } else {
          _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
        }
        _result.setReceived(_tmpReceived);
        final String _tmpReadxxxx;
        if (_cursor.isNull(_cursorIndexOfReadxxxx)) {
          _tmpReadxxxx = null;
        } else {
          _tmpReadxxxx = _cursor.getString(_cursorIndexOfReadxxxx);
        }
        _result.setReadxxxx(_tmpReadxxxx);
        final String _tmpLastUpdt;
        if (_cursor.isNull(_cursorIndexOfLastUpdt)) {
          _tmpLastUpdt = null;
        } else {
          _tmpLastUpdt = _cursor.getString(_cursorIndexOfLastUpdt);
        }
        _result.setLastUpdt(_tmpLastUpdt);
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
  public ENotificationUser CheckIfUserExist(final String fsVal) {
    final String _sql = "SELECT * FROM Notification_User WHERE sUserIDxx=?";
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
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserName");
      final ENotificationUser _result;
      if(_cursor.moveToFirst()) {
        _result = new ENotificationUser();
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpUserName;
        if (_cursor.isNull(_cursorIndexOfUserName)) {
          _tmpUserName = null;
        } else {
          _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        }
        _result.setUserName(_tmpUserName);
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
  public int CheckNotificationIfExist(final String TransNox) {
    final String _sql = "SELECT COUNT(*) FROM Notification_Info_Master WHERE sMesgIDxx=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
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
  public LiveData<List<DNotifications.ClientNotificationInfo>> getClientNotificationList() {
    final String _sql = "SELECT a.sMesgIDxx AS MesgIDxx,a.sAppSrcex AS AppSrcex,b.dReceived AS Received,a.sMessagex AS Messagex,a.sCreatrID AS CreatrID,a.sCreatrNm AS CreatrNm,b.cMesgStat AS MesgStat,a.sMsgTitle AS MsgTitle,a.sMsgTypex AS MsgTypex, a.sDataSndx AS DataInfo FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.cMesgStat <> '5' AND b.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info) ORDER BY b.dReceived DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","Client_Profile_Info"}, false, new Callable<List<DNotifications.ClientNotificationInfo>>() {
      @Override
      public List<DNotifications.ClientNotificationInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMesgIDxx = 0;
          final int _cursorIndexOfAppSrcex = 1;
          final int _cursorIndexOfReceived = 2;
          final int _cursorIndexOfMessagex = 3;
          final int _cursorIndexOfCreatrID = 4;
          final int _cursorIndexOfCreatrNm = 5;
          final int _cursorIndexOfMesgStat = 6;
          final int _cursorIndexOfMsgTitle = 7;
          final int _cursorIndexOfMsgTypex = 8;
          final int _cursorIndexOfDataInfo = 9;
          final List<DNotifications.ClientNotificationInfo> _result = new ArrayList<DNotifications.ClientNotificationInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DNotifications.ClientNotificationInfo _item;
            _item = new DNotifications.ClientNotificationInfo();
            if (_cursor.isNull(_cursorIndexOfMesgIDxx)) {
              _item.MesgIDxx = null;
            } else {
              _item.MesgIDxx = _cursor.getString(_cursorIndexOfMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfAppSrcex)) {
              _item.AppSrcex = null;
            } else {
              _item.AppSrcex = _cursor.getString(_cursorIndexOfAppSrcex);
            }
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _item.Received = null;
            } else {
              _item.Received = _cursor.getString(_cursorIndexOfReceived);
            }
            if (_cursor.isNull(_cursorIndexOfMessagex)) {
              _item.Messagex = null;
            } else {
              _item.Messagex = _cursor.getString(_cursorIndexOfMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrID)) {
              _item.CreatrID = null;
            } else {
              _item.CreatrID = _cursor.getString(_cursorIndexOfCreatrID);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrNm)) {
              _item.CreatrNm = null;
            } else {
              _item.CreatrNm = _cursor.getString(_cursorIndexOfCreatrNm);
            }
            if (_cursor.isNull(_cursorIndexOfMesgStat)) {
              _item.MesgStat = null;
            } else {
              _item.MesgStat = _cursor.getString(_cursorIndexOfMesgStat);
            }
            if (_cursor.isNull(_cursorIndexOfMsgTitle)) {
              _item.MsgTitle = null;
            } else {
              _item.MsgTitle = _cursor.getString(_cursorIndexOfMsgTitle);
            }
            if (_cursor.isNull(_cursorIndexOfMsgTypex)) {
              _item.MsgTypex = null;
            } else {
              _item.MsgTypex = _cursor.getString(_cursorIndexOfMsgTypex);
            }
            if (_cursor.isNull(_cursorIndexOfDataInfo)) {
              _item.DataInfo = null;
            } else {
              _item.DataInfo = _cursor.getString(_cursorIndexOfDataInfo);
            }
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
  public LiveData<DNotifications.ClientNotificationInfo> GetNotificationInfo(
      final String fsMesgID) {
    final String _sql = "SELECT a.sMesgIDxx AS MesgIDxx,a.sAppSrcex AS AppSrcex,b.dReceived AS Received,a.sMessagex AS Messagex,a.sCreatrID AS CreatrID,a.sCreatrNm AS CreatrNm,b.cMesgStat AS MesgStat,a.sMsgTitle AS MsgTitle,a.sMsgTypex AS MsgTypex, a.sDataSndx AS DataInfo FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE a.sMesgIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsMesgID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsMesgID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient"}, false, new Callable<DNotifications.ClientNotificationInfo>() {
      @Override
      public DNotifications.ClientNotificationInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMesgIDxx = 0;
          final int _cursorIndexOfAppSrcex = 1;
          final int _cursorIndexOfReceived = 2;
          final int _cursorIndexOfMessagex = 3;
          final int _cursorIndexOfCreatrID = 4;
          final int _cursorIndexOfCreatrNm = 5;
          final int _cursorIndexOfMesgStat = 6;
          final int _cursorIndexOfMsgTitle = 7;
          final int _cursorIndexOfMsgTypex = 8;
          final int _cursorIndexOfDataInfo = 9;
          final DNotifications.ClientNotificationInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new DNotifications.ClientNotificationInfo();
            if (_cursor.isNull(_cursorIndexOfMesgIDxx)) {
              _result.MesgIDxx = null;
            } else {
              _result.MesgIDxx = _cursor.getString(_cursorIndexOfMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfAppSrcex)) {
              _result.AppSrcex = null;
            } else {
              _result.AppSrcex = _cursor.getString(_cursorIndexOfAppSrcex);
            }
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _result.Received = null;
            } else {
              _result.Received = _cursor.getString(_cursorIndexOfReceived);
            }
            if (_cursor.isNull(_cursorIndexOfMessagex)) {
              _result.Messagex = null;
            } else {
              _result.Messagex = _cursor.getString(_cursorIndexOfMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrID)) {
              _result.CreatrID = null;
            } else {
              _result.CreatrID = _cursor.getString(_cursorIndexOfCreatrID);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrNm)) {
              _result.CreatrNm = null;
            } else {
              _result.CreatrNm = _cursor.getString(_cursorIndexOfCreatrNm);
            }
            if (_cursor.isNull(_cursorIndexOfMesgStat)) {
              _result.MesgStat = null;
            } else {
              _result.MesgStat = _cursor.getString(_cursorIndexOfMesgStat);
            }
            if (_cursor.isNull(_cursorIndexOfMsgTitle)) {
              _result.MsgTitle = null;
            } else {
              _result.MsgTitle = _cursor.getString(_cursorIndexOfMsgTitle);
            }
            if (_cursor.isNull(_cursorIndexOfMsgTypex)) {
              _result.MsgTypex = null;
            } else {
              _result.MsgTypex = _cursor.getString(_cursorIndexOfMsgTypex);
            }
            if (_cursor.isNull(_cursorIndexOfDataInfo)) {
              _result.DataInfo = null;
            } else {
              _result.DataInfo = _cursor.getString(_cursorIndexOfDataInfo);
            }
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
  public LiveData<List<DNotifications.UserNotificationInfo>> getUserMessageList() {
    final String _sql = "SELECT a.sMesgIDxx AS MesgIDxx, a.sMsgTitle AS MsgTitle, a.sCreatrID AS CreatrID, a.sCreatrNm AS CreatrNm, a.sMessagex AS Messagex, b.dReceived AS Received FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.cMesgStat <> '5' AND a.sMsgTypex == '00000' AND b.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","Client_Profile_Info"}, false, new Callable<List<DNotifications.UserNotificationInfo>>() {
      @Override
      public List<DNotifications.UserNotificationInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMesgIDxx = 0;
          final int _cursorIndexOfMsgTitle = 1;
          final int _cursorIndexOfCreatrID = 2;
          final int _cursorIndexOfCreatrNm = 3;
          final int _cursorIndexOfMessagex = 4;
          final int _cursorIndexOfReceived = 5;
          final List<DNotifications.UserNotificationInfo> _result = new ArrayList<DNotifications.UserNotificationInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DNotifications.UserNotificationInfo _item;
            _item = new DNotifications.UserNotificationInfo();
            if (_cursor.isNull(_cursorIndexOfMesgIDxx)) {
              _item.MesgIDxx = null;
            } else {
              _item.MesgIDxx = _cursor.getString(_cursorIndexOfMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfMsgTitle)) {
              _item.MsgTitle = null;
            } else {
              _item.MsgTitle = _cursor.getString(_cursorIndexOfMsgTitle);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrID)) {
              _item.CreatrID = null;
            } else {
              _item.CreatrID = _cursor.getString(_cursorIndexOfCreatrID);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrNm)) {
              _item.CreatrNm = null;
            } else {
              _item.CreatrNm = _cursor.getString(_cursorIndexOfCreatrNm);
            }
            if (_cursor.isNull(_cursorIndexOfMessagex)) {
              _item.Messagex = null;
            } else {
              _item.Messagex = _cursor.getString(_cursorIndexOfMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _item.Received = null;
            } else {
              _item.Received = _cursor.getString(_cursorIndexOfReceived);
            }
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
  public LiveData<List<DNotifications.UserNotificationInfo>> getUserMessageListFromSender(
      final String SenderID) {
    final String _sql = "SELECT a.sMesgIDxx AS MesgIDxx, a.sMsgTitle AS MsgTitle, a.sCreatrID AS CreatrID, a.sCreatrNm AS CreatrNm, a.sMessagex AS Messagex, b.dReceived AS Received FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.cMesgStat <> '5' AND a.sMsgTypex == '00000' AND b.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info) AND a.sCreatrID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (SenderID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, SenderID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","Client_Profile_Info"}, false, new Callable<List<DNotifications.UserNotificationInfo>>() {
      @Override
      public List<DNotifications.UserNotificationInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMesgIDxx = 0;
          final int _cursorIndexOfMsgTitle = 1;
          final int _cursorIndexOfCreatrID = 2;
          final int _cursorIndexOfCreatrNm = 3;
          final int _cursorIndexOfMessagex = 4;
          final int _cursorIndexOfReceived = 5;
          final List<DNotifications.UserNotificationInfo> _result = new ArrayList<DNotifications.UserNotificationInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DNotifications.UserNotificationInfo _item;
            _item = new DNotifications.UserNotificationInfo();
            if (_cursor.isNull(_cursorIndexOfMesgIDxx)) {
              _item.MesgIDxx = null;
            } else {
              _item.MesgIDxx = _cursor.getString(_cursorIndexOfMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfMsgTitle)) {
              _item.MsgTitle = null;
            } else {
              _item.MsgTitle = _cursor.getString(_cursorIndexOfMsgTitle);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrID)) {
              _item.CreatrID = null;
            } else {
              _item.CreatrID = _cursor.getString(_cursorIndexOfCreatrID);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrNm)) {
              _item.CreatrNm = null;
            } else {
              _item.CreatrNm = _cursor.getString(_cursorIndexOfCreatrNm);
            }
            if (_cursor.isNull(_cursorIndexOfMessagex)) {
              _item.Messagex = null;
            } else {
              _item.Messagex = _cursor.getString(_cursorIndexOfMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _item.Received = null;
            } else {
              _item.Received = _cursor.getString(_cursorIndexOfReceived);
            }
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
  public LiveData<List<DNotifications.UserNotificationInfo>> getUserMessageListGroupByUser() {
    final String _sql = "SELECT a.sMesgIDxx AS MesgIDxx, a.sMsgTitle AS MsgTitle, a.sCreatrID AS CreatrID, a.sCreatrNm AS CreatrNm, a.sMessagex AS Messagex, b.dReceived AS Received FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.cMesgStat <> '5'AND a.sMsgTypex == '00000' AND a.sMsgTypex == '00000' AND b.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info) GROUP BY a.sCreatrID";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","Client_Profile_Info"}, false, new Callable<List<DNotifications.UserNotificationInfo>>() {
      @Override
      public List<DNotifications.UserNotificationInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMesgIDxx = 0;
          final int _cursorIndexOfMsgTitle = 1;
          final int _cursorIndexOfCreatrID = 2;
          final int _cursorIndexOfCreatrNm = 3;
          final int _cursorIndexOfMessagex = 4;
          final int _cursorIndexOfReceived = 5;
          final List<DNotifications.UserNotificationInfo> _result = new ArrayList<DNotifications.UserNotificationInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DNotifications.UserNotificationInfo _item;
            _item = new DNotifications.UserNotificationInfo();
            if (_cursor.isNull(_cursorIndexOfMesgIDxx)) {
              _item.MesgIDxx = null;
            } else {
              _item.MesgIDxx = _cursor.getString(_cursorIndexOfMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfMsgTitle)) {
              _item.MsgTitle = null;
            } else {
              _item.MsgTitle = _cursor.getString(_cursorIndexOfMsgTitle);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrID)) {
              _item.CreatrID = null;
            } else {
              _item.CreatrID = _cursor.getString(_cursorIndexOfCreatrID);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrNm)) {
              _item.CreatrNm = null;
            } else {
              _item.CreatrNm = _cursor.getString(_cursorIndexOfCreatrNm);
            }
            if (_cursor.isNull(_cursorIndexOfMessagex)) {
              _item.Messagex = null;
            } else {
              _item.Messagex = _cursor.getString(_cursorIndexOfMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _item.Received = null;
            } else {
              _item.Received = _cursor.getString(_cursorIndexOfReceived);
            }
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
  public LiveData<Integer> getUnreadMessagesCount() {
    final String _sql = "SELECT COUNT(*) FROM Notification_Info_Recepient a LEFT JOIN Notification_Info_Master b ON a.sTransNox = b.sMesgIDxx WHERE a.cMesgStat = '2' AND a.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Recepient","Notification_Info_Master","Client_Profile_Info"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> getUnreadNotificationsCount() {
    final String _sql = "SELECT COUNT(*) FROM Notification_Info_Recepient a LEFT JOIN Notification_Info_Master b ON a.sTransNox = b.sMesgIDxx WHERE a.cMesgStat = '2' AND a.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info) AND b.sMsgTypex <> '00000'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Recepient","Notification_Info_Master","Client_Profile_Info"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<DNotifications.UserNotificationInfo>> getUserNotificationList() {
    final String _sql = "SELECT a.sMesgIDxx AS MesgIDxx, a.sMsgTitle AS MsgTitle, a.sCreatrID AS CreatrID, a.sCreatrNm AS CreatrNm, a.sMessagex AS Messagex, b.dReceived AS Received FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.cMesgStat <> '5' AND a.sMsgTypex <> '00000' AND b.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","Client_Profile_Info"}, false, new Callable<List<DNotifications.UserNotificationInfo>>() {
      @Override
      public List<DNotifications.UserNotificationInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMesgIDxx = 0;
          final int _cursorIndexOfMsgTitle = 1;
          final int _cursorIndexOfCreatrID = 2;
          final int _cursorIndexOfCreatrNm = 3;
          final int _cursorIndexOfMessagex = 4;
          final int _cursorIndexOfReceived = 5;
          final List<DNotifications.UserNotificationInfo> _result = new ArrayList<DNotifications.UserNotificationInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DNotifications.UserNotificationInfo _item;
            _item = new DNotifications.UserNotificationInfo();
            if (_cursor.isNull(_cursorIndexOfMesgIDxx)) {
              _item.MesgIDxx = null;
            } else {
              _item.MesgIDxx = _cursor.getString(_cursorIndexOfMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfMsgTitle)) {
              _item.MsgTitle = null;
            } else {
              _item.MsgTitle = _cursor.getString(_cursorIndexOfMsgTitle);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrID)) {
              _item.CreatrID = null;
            } else {
              _item.CreatrID = _cursor.getString(_cursorIndexOfCreatrID);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrNm)) {
              _item.CreatrNm = null;
            } else {
              _item.CreatrNm = _cursor.getString(_cursorIndexOfCreatrNm);
            }
            if (_cursor.isNull(_cursorIndexOfMessagex)) {
              _item.Messagex = null;
            } else {
              _item.Messagex = _cursor.getString(_cursorIndexOfMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _item.Received = null;
            } else {
              _item.Received = _cursor.getString(_cursorIndexOfReceived);
            }
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
  public LiveData<List<DNotifications.UserNotificationInfo>> getPromotionsNotifications() {
    final String _sql = "SELECT a.sMesgIDxx AS MesgIDxx, a.sMsgTitle AS MsgTitle, a.sCreatrID AS CreatrID, a.sCreatrNm AS CreatrNm, a.sMessagex AS Messagex, b.dReceived AS Received FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.cMesgStat <> '5' AND a.sMsgTypex == '00003' AND b.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","Client_Profile_Info"}, false, new Callable<List<DNotifications.UserNotificationInfo>>() {
      @Override
      public List<DNotifications.UserNotificationInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMesgIDxx = 0;
          final int _cursorIndexOfMsgTitle = 1;
          final int _cursorIndexOfCreatrID = 2;
          final int _cursorIndexOfCreatrNm = 3;
          final int _cursorIndexOfMessagex = 4;
          final int _cursorIndexOfReceived = 5;
          final List<DNotifications.UserNotificationInfo> _result = new ArrayList<DNotifications.UserNotificationInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DNotifications.UserNotificationInfo _item;
            _item = new DNotifications.UserNotificationInfo();
            if (_cursor.isNull(_cursorIndexOfMesgIDxx)) {
              _item.MesgIDxx = null;
            } else {
              _item.MesgIDxx = _cursor.getString(_cursorIndexOfMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfMsgTitle)) {
              _item.MsgTitle = null;
            } else {
              _item.MsgTitle = _cursor.getString(_cursorIndexOfMsgTitle);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrID)) {
              _item.CreatrID = null;
            } else {
              _item.CreatrID = _cursor.getString(_cursorIndexOfCreatrID);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrNm)) {
              _item.CreatrNm = null;
            } else {
              _item.CreatrNm = _cursor.getString(_cursorIndexOfCreatrNm);
            }
            if (_cursor.isNull(_cursorIndexOfMessagex)) {
              _item.Messagex = null;
            } else {
              _item.Messagex = _cursor.getString(_cursorIndexOfMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _item.Received = null;
            } else {
              _item.Received = _cursor.getString(_cursorIndexOfReceived);
            }
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
  public LiveData<List<DNotifications.UserNotificationInfo>> getPanaloNotifications() {
    final String _sql = "SELECT a.sMesgIDxx AS MesgIDxx, a.sMsgTitle AS MsgTitle, a.sCreatrID AS CreatrID, a.sCreatrNm AS CreatrNm, a.sMessagex AS Messagex, b.dReceived AS Received FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.cMesgStat <> '5' AND a.sMsgTypex == '00008' AND b.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","Client_Profile_Info"}, false, new Callable<List<DNotifications.UserNotificationInfo>>() {
      @Override
      public List<DNotifications.UserNotificationInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMesgIDxx = 0;
          final int _cursorIndexOfMsgTitle = 1;
          final int _cursorIndexOfCreatrID = 2;
          final int _cursorIndexOfCreatrNm = 3;
          final int _cursorIndexOfMessagex = 4;
          final int _cursorIndexOfReceived = 5;
          final List<DNotifications.UserNotificationInfo> _result = new ArrayList<DNotifications.UserNotificationInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DNotifications.UserNotificationInfo _item;
            _item = new DNotifications.UserNotificationInfo();
            if (_cursor.isNull(_cursorIndexOfMesgIDxx)) {
              _item.MesgIDxx = null;
            } else {
              _item.MesgIDxx = _cursor.getString(_cursorIndexOfMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfMsgTitle)) {
              _item.MsgTitle = null;
            } else {
              _item.MsgTitle = _cursor.getString(_cursorIndexOfMsgTitle);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrID)) {
              _item.CreatrID = null;
            } else {
              _item.CreatrID = _cursor.getString(_cursorIndexOfCreatrID);
            }
            if (_cursor.isNull(_cursorIndexOfCreatrNm)) {
              _item.CreatrNm = null;
            } else {
              _item.CreatrNm = _cursor.getString(_cursorIndexOfCreatrNm);
            }
            if (_cursor.isNull(_cursorIndexOfMessagex)) {
              _item.Messagex = null;
            } else {
              _item.Messagex = _cursor.getString(_cursorIndexOfMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _item.Received = null;
            } else {
              _item.Received = _cursor.getString(_cursorIndexOfReceived);
            }
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
  public List<String> getReadMessagesIDFromSender(final String SenderID) {
    final String _sql = "SELECT a.sMesgIDxx FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE a.sCreatrID =? AND b.cMesgStat == 2 AND a.sMsgTypex == '00000'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (SenderID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, SenderID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final List<String> _result = new ArrayList<String>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final String _item;
        if (_cursor.isNull(0)) {
          _item = null;
        } else {
          _item = _cursor.getString(0);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public String getReadMessageTimeStamp(final String MessageID) {
    final String _sql = "SELECT dReadxxxx FROM Notification_Info_Recepient WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (MessageID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, MessageID);
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

  @Override
  public int GetNotificationCount() {
    final String _sql = "SELECT COUNT(*) FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info) AND cMesgStat = '2'";
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
  public int GetNotificationCountForID() {
    final String _sql = "SELECT COUNT(*) FROM Notification_Info_Master";
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
  public LiveData<List<DNotifications.RegularMessage>> GetRegularMessagesSystemNotif() {
    final String _sql = "SELECT a.sMesgIDxx, b.dReceived, a.sMessagex, a.sCreatrID, a.sCreatrNm, b.sRecpntID, b.cMesgStat, a.sDataSndx FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.sRecpntID = (SELECT sUserIDxx FROM Client_Profile_Info) AND a.sMsgTypex = '00000' AND a.sCreatrID IS NULL OR a.sCreatrID = ''";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","Client_Profile_Info"}, false, new Callable<List<DNotifications.RegularMessage>>() {
      @Override
      public List<DNotifications.RegularMessage> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSMesgIDxx = 0;
          final int _cursorIndexOfDReceived = 1;
          final int _cursorIndexOfSMessagex = 2;
          final int _cursorIndexOfSCreatrID = 3;
          final int _cursorIndexOfSCreatrNm = 4;
          final int _cursorIndexOfSRecpntID = 5;
          final int _cursorIndexOfCMesgStat = 6;
          final int _cursorIndexOfSDataSndx = 7;
          final List<DNotifications.RegularMessage> _result = new ArrayList<DNotifications.RegularMessage>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DNotifications.RegularMessage _item;
            _item = new DNotifications.RegularMessage();
            if (_cursor.isNull(_cursorIndexOfSMesgIDxx)) {
              _item.sMesgIDxx = null;
            } else {
              _item.sMesgIDxx = _cursor.getString(_cursorIndexOfSMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfDReceived)) {
              _item.dReceived = null;
            } else {
              _item.dReceived = _cursor.getString(_cursorIndexOfDReceived);
            }
            if (_cursor.isNull(_cursorIndexOfSMessagex)) {
              _item.sMessagex = null;
            } else {
              _item.sMessagex = _cursor.getString(_cursorIndexOfSMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfSCreatrID)) {
              _item.sCreatrID = null;
            } else {
              _item.sCreatrID = _cursor.getString(_cursorIndexOfSCreatrID);
            }
            if (_cursor.isNull(_cursorIndexOfSCreatrNm)) {
              _item.sCreatrNm = null;
            } else {
              _item.sCreatrNm = _cursor.getString(_cursorIndexOfSCreatrNm);
            }
            if (_cursor.isNull(_cursorIndexOfSRecpntID)) {
              _item.sRecpntID = null;
            } else {
              _item.sRecpntID = _cursor.getString(_cursorIndexOfSRecpntID);
            }
            if (_cursor.isNull(_cursorIndexOfCMesgStat)) {
              _item.cMesgStat = null;
            } else {
              _item.cMesgStat = _cursor.getString(_cursorIndexOfCMesgStat);
            }
            if (_cursor.isNull(_cursorIndexOfSDataSndx)) {
              _item.sDataSndx = null;
            } else {
              _item.sDataSndx = _cursor.getString(_cursorIndexOfSDataSndx);
            }
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
