package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
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
public final class DNotification_Impl implements DNotification {
  private final RoomDatabase __db;

  public DNotification_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public LiveData<List<DNotification.NotificationListDetail>> GetNotificationList() {
    final String _sql = "SELECT a.sMesgIDxx, a.sCreatrNm, a.sMsgTitle, a.sMessagex, b.dReceived, b.cMesgStat FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.sRecpntID = (SELECT sUserIDxx FROM user_info_master) AND a.sMsgTypex == '00000'AND a.sMsgTitle NOT LIKE '%PAYSLIP%'AND a.sCreatrID = 'SYSTEM'AND a.sMsgTitle <> 'Branch Opening'ORDER BY b.dReceived DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","user_info_master"}, false, new Callable<List<DNotification.NotificationListDetail>>() {
      @Override
      public List<DNotification.NotificationListDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSMesgIDxx = 0;
          final int _cursorIndexOfSCreatrNm = 1;
          final int _cursorIndexOfSMsgTitle = 2;
          final int _cursorIndexOfSMessagex = 3;
          final int _cursorIndexOfDReceived = 4;
          final int _cursorIndexOfCMesgStat = 5;
          final List<DNotification.NotificationListDetail> _result = new ArrayList<DNotification.NotificationListDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DNotification.NotificationListDetail _item;
            _item = new DNotification.NotificationListDetail();
            if (_cursor.isNull(_cursorIndexOfSMesgIDxx)) {
              _item.sMesgIDxx = null;
            } else {
              _item.sMesgIDxx = _cursor.getString(_cursorIndexOfSMesgIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSCreatrNm)) {
              _item.sCreatrNm = null;
            } else {
              _item.sCreatrNm = _cursor.getString(_cursorIndexOfSCreatrNm);
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
            if (_cursor.isNull(_cursorIndexOfDReceived)) {
              _item.dReceived = null;
            } else {
              _item.dReceived = _cursor.getString(_cursorIndexOfDReceived);
            }
            if (_cursor.isNull(_cursorIndexOfCMesgStat)) {
              _item.cMesgStat = null;
            } else {
              _item.cMesgStat = _cursor.getString(_cursorIndexOfCMesgStat);
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
  public LiveData<Integer> GetUnreadNotificationCount() {
    final String _sql = "SELECT COUNT(a.sMesgIDxx) FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.sRecpntID = (SELECT sUserIDxx FROM user_info_master) AND a.sMsgTypex == '00000'AND a.sCreatrID = 'SYSTEM'AND a.sMsgTitle NOT LIKE '%PAYSLIP%'AND a.sMsgTitle <> 'Branch Opening'AND b.cMesgStat == '2'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","user_info_master"}, false, new Callable<Integer>() {
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
  public LiveData<ENotificationMaster> GetNotificationMaster(final String args) {
    final String _sql = "SELECT * FROM Notification_Info_Master WHERE sMesgIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master"}, false, new Callable<ENotificationMaster>() {
      @Override
      public ENotificationMaster call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<ENotificationRecipient> GetNotificationDetail(final String args) {
    final String _sql = "SELECT * FROM Notification_Info_Recepient WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Recepient"}, false, new Callable<ENotificationRecipient>() {
      @Override
      public ENotificationRecipient call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> GetAllUnreadNotificationCount() {
    final String _sql = "SELECT COUNT(a.sTransNox) FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox AND a.sMsgTypex == '00000'AND a.sMsgTitle <> 'Branch Opening'WHERE b.sRecpntID = (SELECT sUserIDxx FROM User_Info_Master) AND b.cMesgStat == '2'";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
