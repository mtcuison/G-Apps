package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeInfo;
import org.rmj.g3appdriver.GCircle.room.Entities.EGLocatorSysLog;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DLocatorSysLog_Impl implements DLocatorSysLog {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EGLocatorSysLog> __insertionAdapterOfEGLocatorSysLog;

  private final EntityDeletionOrUpdateAdapter<EGLocatorSysLog> __updateAdapterOfEGLocatorSysLog;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSysLogStatus;

  public DLocatorSysLog_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEGLocatorSysLog = new EntityInsertionAdapter<EGLocatorSysLog>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `GLocator_Sys_log` (`sLoctnIDx`,`sUserIDxx`,`sDeviceID`,`dTransact`,`nLongitud`,`nLatitude`,`cSendStat`,`cGpsEnbld`,`sRemarksx`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGLocatorSysLog value) {
        if (value.getLoctnIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getLoctnIDx());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserIDxx());
        }
        if (value.getDeviceID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeviceID());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTransact());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getLongitud());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getLatitude());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSendStat());
        }
        if (value.getGpsEnbld() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getGpsEnbld());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRemarksx());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getLstUpdte());
        }
      }
    };
    this.__updateAdapterOfEGLocatorSysLog = new EntityDeletionOrUpdateAdapter<EGLocatorSysLog>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `GLocator_Sys_log` SET `sLoctnIDx` = ?,`sUserIDxx` = ?,`sDeviceID` = ?,`dTransact` = ?,`nLongitud` = ?,`nLatitude` = ?,`cSendStat` = ?,`cGpsEnbld` = ?,`sRemarksx` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sLoctnIDx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGLocatorSysLog value) {
        if (value.getLoctnIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getLoctnIDx());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserIDxx());
        }
        if (value.getDeviceID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDeviceID());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTransact());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindDouble(5, value.getLongitud());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindDouble(6, value.getLatitude());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSendStat());
        }
        if (value.getGpsEnbld() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getGpsEnbld());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRemarksx());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getLstUpdte());
        }
        if (value.getLoctnIDx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLoctnIDx());
        }
      }
    };
    this.__preparedStmtOfUpdateSysLogStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE GLocator_Sys_log SET cSendStat = '1', dTimeStmp =? WHERE sLoctnIDx =?";
        return _query;
      }
    };
  }

  @Override
  public void insertLocation(final EGLocatorSysLog locatorSysLog) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEGLocatorSysLog.insert(locatorSysLog);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final EGLocatorSysLog foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEGLocatorSysLog.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSysLogStatus(final String dTimeStmp, final String LoctID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSysLogStatus.acquire();
    int _argIndex = 1;
    if (dTimeStmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, dTimeStmp);
    }
    _argIndex = 2;
    if (LoctID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, LoctID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSysLogStatus.release(_stmt);
    }
  }

  @Override
  public List<EGLocatorSysLog> GetTrackingLocations() {
    final String _sql = "SELECT * FROM GLocator_Sys_log WHERE cSendStat == '0' ORDER BY dTransact DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfLoctnIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sLoctnIDx");
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfDeviceID = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeviceID");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfGpsEnbld = CursorUtil.getColumnIndexOrThrow(_cursor, "cGpsEnbld");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final List<EGLocatorSysLog> _result = new ArrayList<EGLocatorSysLog>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EGLocatorSysLog _item;
        _item = new EGLocatorSysLog();
        final String _tmpLoctnIDx;
        if (_cursor.isNull(_cursorIndexOfLoctnIDx)) {
          _tmpLoctnIDx = null;
        } else {
          _tmpLoctnIDx = _cursor.getString(_cursorIndexOfLoctnIDx);
        }
        _item.setLoctnIDx(_tmpLoctnIDx);
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _item.setUserIDxx(_tmpUserIDxx);
        final String _tmpDeviceID;
        if (_cursor.isNull(_cursorIndexOfDeviceID)) {
          _tmpDeviceID = null;
        } else {
          _tmpDeviceID = _cursor.getString(_cursorIndexOfDeviceID);
        }
        _item.setDeviceID(_tmpDeviceID);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final Double _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getDouble(_cursorIndexOfLongitud);
        }
        _item.setLongitud(_tmpLongitud);
        final Double _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpGpsEnbld;
        if (_cursor.isNull(_cursorIndexOfGpsEnbld)) {
          _tmpGpsEnbld = null;
        } else {
          _tmpGpsEnbld = _cursor.getString(_cursorIndexOfGpsEnbld);
        }
        _item.setGpsEnbld(_tmpGpsEnbld);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpTimeStmp;
        if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
          _tmpTimeStmp = null;
        } else {
          _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
        }
        _item.setTimeStmp(_tmpTimeStmp);
        final String _tmpLstUpdte;
        if (_cursor.isNull(_cursorIndexOfLstUpdte)) {
          _tmpLstUpdte = null;
        } else {
          _tmpLstUpdte = _cursor.getString(_cursorIndexOfLstUpdte);
        }
        _item.setLstUpdte(_tmpLstUpdte);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public EEmployeeInfo GetUserInfo() {
    final String _sql = "SELECT * FROM User_Info_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfLogNoxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sLogNoxxx");
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
      final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserName");
      final int _cursorIndexOfUserLevl = CursorUtil.getColumnIndexOrThrow(_cursor, "nUserLevl");
      final int _cursorIndexOfDeptIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptIDxx");
      final int _cursorIndexOfPositnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnID");
      final int _cursorIndexOfEmpLevID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmpLevID");
      final int _cursorIndexOfSlfieLog = CursorUtil.getColumnIndexOrThrow(_cursor, "cSlfieLog");
      final int _cursorIndexOfAllowUpd = CursorUtil.getColumnIndexOrThrow(_cursor, "cAllowUpd");
      final int _cursorIndexOfLoginxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dLoginxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfSessionx = CursorUtil.getColumnIndexOrThrow(_cursor, "dSessionx");
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
      final int _cursorIndexOfPrivatex = CursorUtil.getColumnIndexOrThrow(_cursor, "cPrivatex");
      final int _cursorIndexOfDeviceID = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeviceID");
      final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
      final EEmployeeInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EEmployeeInfo();
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpBranchCD;
        if (_cursor.isNull(_cursorIndexOfBranchCD)) {
          _tmpBranchCD = null;
        } else {
          _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
        }
        _result.setBranchCD(_tmpBranchCD);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpLogNoxxx;
        if (_cursor.isNull(_cursorIndexOfLogNoxxx)) {
          _tmpLogNoxxx = null;
        } else {
          _tmpLogNoxxx = _cursor.getString(_cursorIndexOfLogNoxxx);
        }
        _result.setLogNoxxx(_tmpLogNoxxx);
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpEmailAdd;
        if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
          _tmpEmailAdd = null;
        } else {
          _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
        }
        _result.setEmailAdd(_tmpEmailAdd);
        final String _tmpUserName;
        if (_cursor.isNull(_cursorIndexOfUserName)) {
          _tmpUserName = null;
        } else {
          _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        }
        _result.setUserName(_tmpUserName);
        final String _tmpUserLevl;
        if (_cursor.isNull(_cursorIndexOfUserLevl)) {
          _tmpUserLevl = null;
        } else {
          _tmpUserLevl = _cursor.getString(_cursorIndexOfUserLevl);
        }
        _result.setUserLevl(_tmpUserLevl);
        final String _tmpDeptIDxx;
        if (_cursor.isNull(_cursorIndexOfDeptIDxx)) {
          _tmpDeptIDxx = null;
        } else {
          _tmpDeptIDxx = _cursor.getString(_cursorIndexOfDeptIDxx);
        }
        _result.setDeptIDxx(_tmpDeptIDxx);
        final String _tmpPositnID;
        if (_cursor.isNull(_cursorIndexOfPositnID)) {
          _tmpPositnID = null;
        } else {
          _tmpPositnID = _cursor.getString(_cursorIndexOfPositnID);
        }
        _result.setPositnID(_tmpPositnID);
        final Integer _tmpEmpLevID;
        if (_cursor.isNull(_cursorIndexOfEmpLevID)) {
          _tmpEmpLevID = null;
        } else {
          _tmpEmpLevID = _cursor.getInt(_cursorIndexOfEmpLevID);
        }
        _result.setEmpLevID(_tmpEmpLevID);
        final String _tmpSlfieLog;
        if (_cursor.isNull(_cursorIndexOfSlfieLog)) {
          _tmpSlfieLog = null;
        } else {
          _tmpSlfieLog = _cursor.getString(_cursorIndexOfSlfieLog);
        }
        _result.setSlfieLog(_tmpSlfieLog);
        final String _tmpAllowUpd;
        if (_cursor.isNull(_cursorIndexOfAllowUpd)) {
          _tmpAllowUpd = null;
        } else {
          _tmpAllowUpd = _cursor.getString(_cursorIndexOfAllowUpd);
        }
        _result.setAllowUpd(_tmpAllowUpd);
        final String _tmpLoginxxx;
        if (_cursor.isNull(_cursorIndexOfLoginxxx)) {
          _tmpLoginxxx = null;
        } else {
          _tmpLoginxxx = _cursor.getString(_cursorIndexOfLoginxxx);
        }
        _result.setLoginxxx(_tmpLoginxxx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final String _tmpSessionx;
        if (_cursor.isNull(_cursorIndexOfSessionx)) {
          _tmpSessionx = null;
        } else {
          _tmpSessionx = _cursor.getString(_cursorIndexOfSessionx);
        }
        _result.setSessionx(_tmpSessionx);
        final String _tmpEmployID;
        if (_cursor.isNull(_cursorIndexOfEmployID)) {
          _tmpEmployID = null;
        } else {
          _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
        }
        _result.setEmployID(_tmpEmployID);
        final String _tmpPrivatex;
        if (_cursor.isNull(_cursorIndexOfPrivatex)) {
          _tmpPrivatex = null;
        } else {
          _tmpPrivatex = _cursor.getString(_cursorIndexOfPrivatex);
        }
        _result.setPrivatex(_tmpPrivatex);
        final String _tmpDeviceID;
        if (_cursor.isNull(_cursorIndexOfDeviceID)) {
          _tmpDeviceID = null;
        } else {
          _tmpDeviceID = _cursor.getString(_cursorIndexOfDeviceID);
        }
        _result.setDeviceID(_tmpDeviceID);
        final String _tmpModelIDx;
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _tmpModelIDx = null;
        } else {
          _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        _result.setModelIDx(_tmpModelIDx);
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
  public String getUserID() {
    final String _sql = "SELECT sUserIDxx FROM User_Info_Master";
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
  public int GetRowsCountForID() {
    final String _sql = "SELECT  COUNT(sLoctnIDx) FROM GLocator_Sys_log";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
