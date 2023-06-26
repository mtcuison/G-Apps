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
import org.rmj.g3appdriver.GCircle.room.Entities.ENotificationMaster;
import org.rmj.g3appdriver.GCircle.room.Entities.ENotificationRecipient;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DPayslip_Impl implements DPayslip {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ENotificationMaster> __insertionAdapterOfENotificationMaster;

  private final EntityInsertionAdapter<ENotificationRecipient> __insertionAdapterOfENotificationRecipient;

  private final EntityDeletionOrUpdateAdapter<ENotificationRecipient> __updateAdapterOfENotificationRecipient;

  public DPayslip_Impl(RoomDatabase __db) {
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

  @Override
  public LiveData<List<DPayslip.Payslip>> GetPaySlipList() {
    final String _sql = "SELECT b.sTransNox, a.sMesgIDxx, a.sMsgTitle, a.sMessagex, b.cMesgStat, b.dReceived FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE a.sMsgTypex = '00000' AND a.sAppSrcex = 'IntegSys' AND a.sMsgTitle LIKE 'PAYSLIP%' AND b.sRecpntID = (SELECT sUserIDxx FROM User_Info_Master) ORDER BY dCreatedx ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","User_Info_Master"}, false, new Callable<List<DPayslip.Payslip>>() {
      @Override
      public List<DPayslip.Payslip> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfSMesgIDxx = 1;
          final int _cursorIndexOfSMsgTitle = 2;
          final int _cursorIndexOfSMessagex = 3;
          final int _cursorIndexOfCMesgStat = 4;
          final int _cursorIndexOfDReceived = 5;
          final List<DPayslip.Payslip> _result = new ArrayList<DPayslip.Payslip>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DPayslip.Payslip _item;
            _item = new DPayslip.Payslip();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSMesgIDxx)) {
              _item.sMesgIDxx = null;
            } else {
              _item.sMesgIDxx = _cursor.getString(_cursorIndexOfSMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSMsgTitle)) {
              _item.sMsgTitle = null;
            } else {
              _item.sMsgTitle = _cursor.getString(_cursorIndexOfSMsgTitle);
            }
            if (_cursor.isNull(_cursorIndexOfSMessagex)) {
              _item.sMessagex = null;
            } else {
              _item.sMessagex = _cursor.getString(_cursorIndexOfSMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfCMesgStat)) {
              _item.cMesgStat = null;
            } else {
              _item.cMesgStat = _cursor.getString(_cursorIndexOfCMesgStat);
            }
            if (_cursor.isNull(_cursorIndexOfDReceived)) {
              _item.dReceived = null;
            } else {
              _item.dReceived = _cursor.getString(_cursorIndexOfDReceived);
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
  public LiveData<Integer> GetUnreadPayslipCount() {
    final String _sql = "SELECT COUNT(b.sTransNox) FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE a.sMsgTypex = '00000' AND b.cMesgStat == '2'AND a.sAppSrcex = 'IntegSys' AND a.sMsgTitle LIKE 'PAYSLIP%' AND b.sRecpntID = (SELECT sUserIDxx FROM User_Info_Master)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","User_Info_Master"}, false, new Callable<Integer>() {
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
  public ENotificationMaster CheckIfExist(final String MesgID) {
    final String _sql = "SELECT * FROM Notification_Info_Master WHERE sMesgIDxx=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (MesgID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, MesgID);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
