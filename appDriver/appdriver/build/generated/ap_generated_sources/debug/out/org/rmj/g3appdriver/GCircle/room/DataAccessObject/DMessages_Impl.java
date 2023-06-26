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
import org.rmj.g3appdriver.GCircle.room.Entities.ENotificationRecipient;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DMessages_Impl implements DMessages {
  private final RoomDatabase __db;

  public DMessages_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public LiveData<List<DMessages.MessageUsers>> GetMessageUsers() {
    final String _sql = "SELECT a.*, (SELECT sMessagex FROM Notification_Info_Master WHERE sCreatrID = a.sUserIDxx AND sMsgTypex == '00000' AND sCreatrID <> 'SYSTEM' ORDER BY dCreatedx DESC LIMIT 1) AS sMessagex, (SELECT dReceived FROM Notification_Info_Recepient WHERE sTransNox = (SELECT sMesgIDxx FROM Notification_Info_Master WHERE sCreatrID = a.sUserIDxx ORDER BY dCreatedx DESC LIMIT 1) ORDER BY dReceived DESC LIMIT 1) AS dReceived FROM Notification_User a";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient","Notification_User"}, false, new Callable<List<DMessages.MessageUsers>>() {
      @Override
      public List<DMessages.MessageUsers> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
          final int _cursorIndexOfSUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserName");
          final int _cursorIndexOfSMessagex = CursorUtil.getColumnIndexOrThrow(_cursor, "sMessagex");
          final int _cursorIndexOfDReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
          final List<DMessages.MessageUsers> _result = new ArrayList<DMessages.MessageUsers>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DMessages.MessageUsers _item;
            _item = new DMessages.MessageUsers();
            if (_cursor.isNull(_cursorIndexOfSUserIDxx)) {
              _item.sUserIDxx = null;
            } else {
              _item.sUserIDxx = _cursor.getString(_cursorIndexOfSUserIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUserName)) {
              _item.sUserName = null;
            } else {
              _item.sUserName = _cursor.getString(_cursorIndexOfSUserName);
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
  public LiveData<String> GetSenderName(final String args) {
    final String _sql = "SELECT sUserName FROM Notification_User WHERE sUserIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_User"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<DMessages.UserMessages>> GetUserMessages(final String args) {
    final String _sql = "SELECT a.sMessagex,b.dReadxxxx AS dMsgReadx,b.dReceived FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE a.sCreatrID =? ORDER BY b.dReceived DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Notification_Info_Master","Notification_Info_Recepient"}, false, new Callable<List<DMessages.UserMessages>>() {
      @Override
      public List<DMessages.UserMessages> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSMessagex = 0;
          final int _cursorIndexOfDMsgReadx = 1;
          final int _cursorIndexOfDReceived = 2;
          final List<DMessages.UserMessages> _result = new ArrayList<DMessages.UserMessages>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DMessages.UserMessages _item;
            _item = new DMessages.UserMessages();
            if (_cursor.isNull(_cursorIndexOfSMessagex)) {
              _item.sMessagex = null;
            } else {
              _item.sMessagex = _cursor.getString(_cursorIndexOfSMessagex);
            }
            if (_cursor.isNull(_cursorIndexOfDMsgReadx)) {
              _item.dMsgReadx = null;
            } else {
              _item.dMsgReadx = _cursor.getString(_cursorIndexOfDMsgReadx);
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
  public List<String> GetUnreadMessagesID(final String args) {
    final String _sql = "SELECT a.sMesgIDxx FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE a.sCreatrID =? AND b.cMesgStat == '2' OR a.sCreatrID =? AND b.cMesgStat == '3' AND b.cStatSent == 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    _argIndex = 2;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
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
  public LiveData<Integer> GetUnreadMessagesCount() {
    final String _sql = "SELECT COUNT(a.sMesgIDxx) FROM Notification_Info_Master a LEFT JOIN Notification_Info_Recepient b ON a.sMesgIDxx = b.sTransNox WHERE b.sRecpntID = (SELECT sUserIDxx FROM User_Info_Master) AND a.sMsgTypex == '00000' AND a.sMsgTitle NOT LIKE '%PAYSLIP%'AND a.sCreatrID <> 'SYSTEM' AND b.cMesgStat == '2'";
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
  public ENotificationRecipient GetNotificationInfo(final String args) {
    final String _sql = "SELECT * FROM Notification_Info_Recepient WHERE sTransNox=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
