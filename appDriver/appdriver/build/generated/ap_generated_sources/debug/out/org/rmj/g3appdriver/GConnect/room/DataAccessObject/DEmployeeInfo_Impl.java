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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GConnect.room.Entities.EEmployeeInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DEmployeeInfo_Impl implements DEmployeeInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EEmployeeInfo> __insertionAdapterOfEEmployeeInfo;

  private final EntityDeletionOrUpdateAdapter<EEmployeeInfo> __deletionAdapterOfEEmployeeInfo;

  private final EntityDeletionOrUpdateAdapter<EEmployeeInfo> __updateAdapterOfEEmployeeInfo;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllEmployeeInfo;

  public DEmployeeInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEEmployeeInfo = new EntityInsertionAdapter<EEmployeeInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `User_Info_Master` (`sClientID`,`sBranchCD`,`sBranchNm`,`sLogNoxxx`,`sUserIDxx`,`sEmailAdd`,`sUserName`,`nUserLevl`,`sDeptIDxx`,`sPositnID`,`sEmpLevID`,`cAllowUpd`,`dLoginxxx`,`sMobileNo`,`dSessionx`,`sEmployID`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEmployeeInfo value) {
        if (value.getClientID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getClientID());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCD());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBranchNm());
        }
        if (value.getLogNoxxx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLogNoxxx());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUserIDxx());
        }
        if (value.getEmailAdd() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEmailAdd());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUserName());
        }
        if (value.getUserLevl() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUserLevl());
        }
        if (value.getDeptIDxx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDeptIDxx());
        }
        if (value.getPositnID() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPositnID());
        }
        if (value.getEmpLevID() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getEmpLevID());
        }
        if (value.getAllowUpd() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getAllowUpd());
        }
        if (value.getLoginxxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLoginxxx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMobileNo());
        }
        if (value.getSessionx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSessionx());
        }
        if (value.getEmployID() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getEmployID());
        }
      }
    };
    this.__deletionAdapterOfEEmployeeInfo = new EntityDeletionOrUpdateAdapter<EEmployeeInfo>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `User_Info_Master` WHERE `sClientID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEmployeeInfo value) {
        if (value.getClientID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getClientID());
        }
      }
    };
    this.__updateAdapterOfEEmployeeInfo = new EntityDeletionOrUpdateAdapter<EEmployeeInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `User_Info_Master` SET `sClientID` = ?,`sBranchCD` = ?,`sBranchNm` = ?,`sLogNoxxx` = ?,`sUserIDxx` = ?,`sEmailAdd` = ?,`sUserName` = ?,`nUserLevl` = ?,`sDeptIDxx` = ?,`sPositnID` = ?,`sEmpLevID` = ?,`cAllowUpd` = ?,`dLoginxxx` = ?,`sMobileNo` = ?,`dSessionx` = ?,`sEmployID` = ? WHERE `sClientID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEmployeeInfo value) {
        if (value.getClientID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getClientID());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCD());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBranchNm());
        }
        if (value.getLogNoxxx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLogNoxxx());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUserIDxx());
        }
        if (value.getEmailAdd() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEmailAdd());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUserName());
        }
        if (value.getUserLevl() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUserLevl());
        }
        if (value.getDeptIDxx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDeptIDxx());
        }
        if (value.getPositnID() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPositnID());
        }
        if (value.getEmpLevID() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getEmpLevID());
        }
        if (value.getAllowUpd() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getAllowUpd());
        }
        if (value.getLoginxxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getLoginxxx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getMobileNo());
        }
        if (value.getSessionx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSessionx());
        }
        if (value.getEmployID() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getEmployID());
        }
        if (value.getClientID() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getClientID());
        }
      }
    };
    this.__preparedStmtOfDeleteAllEmployeeInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM User_Info_Master";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EEmployeeInfo employee) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEEmployeeInfo.insert(employee);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final EEmployeeInfo employee) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfEEmployeeInfo.handle(employee);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EEmployeeInfo employee) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEEmployeeInfo.handle(employee);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllEmployeeInfo() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllEmployeeInfo.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllEmployeeInfo.release(_stmt);
    }
  }

  @Override
  public LiveData<EEmployeeInfo> getEmployeeInfo() {
    final String _sql = "SELECT * FROM User_Info_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"User_Info_Master"}, false, new Callable<EEmployeeInfo>() {
      @Override
      public EEmployeeInfo call() throws Exception {
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
          final int _cursorIndexOfAllowUpd = CursorUtil.getColumnIndexOrThrow(_cursor, "cAllowUpd");
          final int _cursorIndexOfLoginxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dLoginxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfSessionx = CursorUtil.getColumnIndexOrThrow(_cursor, "dSessionx");
          final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
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
            final String _tmpEmpLevID;
            if (_cursor.isNull(_cursorIndexOfEmpLevID)) {
              _tmpEmpLevID = null;
            } else {
              _tmpEmpLevID = _cursor.getString(_cursorIndexOfEmpLevID);
            }
            _result.setEmpLevID(_tmpEmpLevID);
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
  public EEmployeeInfo getEmployeeInfoNonLiveData() {
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
      final int _cursorIndexOfAllowUpd = CursorUtil.getColumnIndexOrThrow(_cursor, "cAllowUpd");
      final int _cursorIndexOfLoginxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dLoginxxx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfSessionx = CursorUtil.getColumnIndexOrThrow(_cursor, "dSessionx");
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
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
        final String _tmpEmpLevID;
        if (_cursor.isNull(_cursorIndexOfEmpLevID)) {
          _tmpEmpLevID = null;
        } else {
          _tmpEmpLevID = _cursor.getString(_cursorIndexOfEmpLevID);
        }
        _result.setEmpLevID(_tmpEmpLevID);
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
  public LiveData<String> getUserID() {
    final String _sql = "SELECT sUserIDxx FROM User_Info_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"User_Info_Master"}, false, new Callable<String>() {
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
  public LiveData<String> getLogNumber() {
    final String _sql = "SELECT sLogNoxxx FROM User_Info_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"User_Info_Master"}, false, new Callable<String>() {
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
  public LiveData<String> getClientID() {
    final String _sql = "SELECT sClientID FROM User_Info_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"User_Info_Master"}, false, new Callable<String>() {
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
  public LiveData<String> getSBranchID() {
    final String _sql = "SELECT sBranchCD FROM User_Info_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"User_Info_Master"}, false, new Callable<String>() {
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
  public Cursor getUserInfo() {
    final String _sql = "SELECT * FROM User_Info_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  @Override
  public LiveData<String> getSessionDate() {
    final String _sql = "SELECT dSessionx FROM User_Info_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"User_Info_Master"}, false, new Callable<String>() {
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
