package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

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
import org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeBusinessTrip;
import org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DEmployeeBusinessTrip_Impl implements DEmployeeBusinessTrip {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EEmployeeBusinessTrip> __insertionAdapterOfEEmployeeBusinessTrip;

  private final EntityDeletionOrUpdateAdapter<EEmployeeBusinessTrip> __updateAdapterOfEEmployeeBusinessTrip;

  private final SharedSQLiteStatement __preparedStmtOfUpdateOBSentStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateObApprovalPostedStatus;

  public DEmployeeBusinessTrip_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEEmployeeBusinessTrip = new EntityInsertionAdapter<EEmployeeBusinessTrip>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Employee_Business_Trip` (`sTransNox`,`dTransact`,`xEmployee`,`sFullName`,`sBranchNm`,`sDeptName`,`sPositnNm`,`dDateFrom`,`dDateThru`,`sDestinat`,`sRemarksx`,`sApproved`,`dApproved`,`dAppldFrx`,`dAppldTox`,`cTranStat`,`cSendStat`,`sModified`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEmployeeBusinessTrip value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getEmployee() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmployee());
        }
        if (value.getFullName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFullName());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBranchNm());
        }
        if (value.getDeptName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDeptName());
        }
        if (value.getPositnNm() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPositnNm());
        }
        if (value.getDateFrom() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDateFrom());
        }
        if (value.getDateThru() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDateThru());
        }
        if (value.getDestinat() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getDestinat());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getRemarksx());
        }
        if (value.getApproved() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getApproved());
        }
        if (value.getDapprove() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDapprove());
        }
        if (value.getAppldFrx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getAppldFrx());
        }
        if (value.getAppldTox() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getAppldTox());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSendStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getModified());
        }
        if (value.getDModfied() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getDModfied());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEEmployeeBusinessTrip = new EntityDeletionOrUpdateAdapter<EEmployeeBusinessTrip>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Employee_Business_Trip` SET `sTransNox` = ?,`dTransact` = ?,`xEmployee` = ?,`sFullName` = ?,`sBranchNm` = ?,`sDeptName` = ?,`sPositnNm` = ?,`dDateFrom` = ?,`dDateThru` = ?,`sDestinat` = ?,`sRemarksx` = ?,`sApproved` = ?,`dApproved` = ?,`dAppldFrx` = ?,`dAppldTox` = ?,`cTranStat` = ?,`cSendStat` = ?,`sModified` = ?,`dModified` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEmployeeBusinessTrip value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getEmployee() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmployee());
        }
        if (value.getFullName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFullName());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBranchNm());
        }
        if (value.getDeptName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDeptName());
        }
        if (value.getPositnNm() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPositnNm());
        }
        if (value.getDateFrom() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDateFrom());
        }
        if (value.getDateThru() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDateThru());
        }
        if (value.getDestinat() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getDestinat());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getRemarksx());
        }
        if (value.getApproved() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getApproved());
        }
        if (value.getDapprove() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getDapprove());
        }
        if (value.getAppldFrx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getAppldFrx());
        }
        if (value.getAppldTox() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getAppldTox());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSendStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getModified());
        }
        if (value.getDModfied() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getDModfied());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateOBSentStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Employee_Business_Trip SET cSendStat = '1', sTransNox =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateObApprovalPostedStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Employee_Business_Trip SET cSendStat = '1' WHERE sTransNox=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EEmployeeBusinessTrip obLeave) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEEmployeeBusinessTrip.insert(obLeave);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EEmployeeBusinessTrip obLeave) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEEmployeeBusinessTrip.handle(obLeave);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateOBSentStatus(final String TransNox, final String newTransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateOBSentStatus.acquire();
    int _argIndex = 1;
    if (newTransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, newTransNox);
    }
    _argIndex = 2;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateOBSentStatus.release(_stmt);
    }
  }

  @Override
  public void updateObApprovalPostedStatus(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateObApprovalPostedStatus.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateObApprovalPostedStatus.release(_stmt);
    }
  }

  @Override
  public EEmployeeInfo GetEmployeeInfo() {
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
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT (*) FROM Employee_Business_Trip";
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
  public EEmployeeBusinessTrip GetEmployeeBusinessTrip(final String TransNox) {
    final String _sql = "SELECT * FROM Employee_Business_Trip WHERE sTransNox =?";
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
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfEmployee = CursorUtil.getColumnIndexOrThrow(_cursor, "xEmployee");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFullName");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
      final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
      final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
      final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
      final int _cursorIndexOfDestinat = CursorUtil.getColumnIndexOrThrow(_cursor, "sDestinat");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDapprove = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
      final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
      final int _cursorIndexOfDModfied = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EEmployeeBusinessTrip _result;
      if(_cursor.moveToFirst()) {
        _result = new EEmployeeBusinessTrip();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpEmployee;
        if (_cursor.isNull(_cursorIndexOfEmployee)) {
          _tmpEmployee = null;
        } else {
          _tmpEmployee = _cursor.getString(_cursorIndexOfEmployee);
        }
        _result.setEmployee(_tmpEmployee);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _result.setFullName(_tmpFullName);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpDeptName;
        if (_cursor.isNull(_cursorIndexOfDeptName)) {
          _tmpDeptName = null;
        } else {
          _tmpDeptName = _cursor.getString(_cursorIndexOfDeptName);
        }
        _result.setDeptName(_tmpDeptName);
        final String _tmpPositnNm;
        if (_cursor.isNull(_cursorIndexOfPositnNm)) {
          _tmpPositnNm = null;
        } else {
          _tmpPositnNm = _cursor.getString(_cursorIndexOfPositnNm);
        }
        _result.setPositnNm(_tmpPositnNm);
        final String _tmpDateFrom;
        if (_cursor.isNull(_cursorIndexOfDateFrom)) {
          _tmpDateFrom = null;
        } else {
          _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
        }
        _result.setDateFrom(_tmpDateFrom);
        final String _tmpDateThru;
        if (_cursor.isNull(_cursorIndexOfDateThru)) {
          _tmpDateThru = null;
        } else {
          _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
        }
        _result.setDateThru(_tmpDateThru);
        final String _tmpDestinat;
        if (_cursor.isNull(_cursorIndexOfDestinat)) {
          _tmpDestinat = null;
        } else {
          _tmpDestinat = _cursor.getString(_cursorIndexOfDestinat);
        }
        _result.setDestinat(_tmpDestinat);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _result.setApproved(_tmpApproved);
        final String _tmpDapprove;
        if (_cursor.isNull(_cursorIndexOfDapprove)) {
          _tmpDapprove = null;
        } else {
          _tmpDapprove = _cursor.getString(_cursorIndexOfDapprove);
        }
        _result.setDapprove(_tmpDapprove);
        final String _tmpAppldFrx;
        if (_cursor.isNull(_cursorIndexOfAppldFrx)) {
          _tmpAppldFrx = null;
        } else {
          _tmpAppldFrx = _cursor.getString(_cursorIndexOfAppldFrx);
        }
        _result.setAppldFrx(_tmpAppldFrx);
        final String _tmpAppldTox;
        if (_cursor.isNull(_cursorIndexOfAppldTox)) {
          _tmpAppldTox = null;
        } else {
          _tmpAppldTox = _cursor.getString(_cursorIndexOfAppldTox);
        }
        _result.setAppldTox(_tmpAppldTox);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
        final String _tmpDModfied;
        if (_cursor.isNull(_cursorIndexOfDModfied)) {
          _tmpDModfied = null;
        } else {
          _tmpDModfied = _cursor.getString(_cursorIndexOfDModfied);
        }
        _result.setDModfied(_tmpDModfied);
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
  public EEmployeeBusinessTrip CheckIfApplicationExist(final String DateFrom, final String DateThru,
      final String Destinat, final String Remarksx) {
    final String _sql = "SELECT * FROM Employee_Business_Trip WHERE dDateFrom=? AND dDateThru=? AND sDestinat=? AND sRemarksx=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (DateFrom == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, DateFrom);
    }
    _argIndex = 2;
    if (DateThru == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, DateThru);
    }
    _argIndex = 3;
    if (Destinat == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Destinat);
    }
    _argIndex = 4;
    if (Remarksx == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Remarksx);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfEmployee = CursorUtil.getColumnIndexOrThrow(_cursor, "xEmployee");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFullName");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
      final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
      final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
      final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
      final int _cursorIndexOfDestinat = CursorUtil.getColumnIndexOrThrow(_cursor, "sDestinat");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDapprove = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
      final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
      final int _cursorIndexOfDModfied = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EEmployeeBusinessTrip _result;
      if(_cursor.moveToFirst()) {
        _result = new EEmployeeBusinessTrip();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpEmployee;
        if (_cursor.isNull(_cursorIndexOfEmployee)) {
          _tmpEmployee = null;
        } else {
          _tmpEmployee = _cursor.getString(_cursorIndexOfEmployee);
        }
        _result.setEmployee(_tmpEmployee);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _result.setFullName(_tmpFullName);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpDeptName;
        if (_cursor.isNull(_cursorIndexOfDeptName)) {
          _tmpDeptName = null;
        } else {
          _tmpDeptName = _cursor.getString(_cursorIndexOfDeptName);
        }
        _result.setDeptName(_tmpDeptName);
        final String _tmpPositnNm;
        if (_cursor.isNull(_cursorIndexOfPositnNm)) {
          _tmpPositnNm = null;
        } else {
          _tmpPositnNm = _cursor.getString(_cursorIndexOfPositnNm);
        }
        _result.setPositnNm(_tmpPositnNm);
        final String _tmpDateFrom;
        if (_cursor.isNull(_cursorIndexOfDateFrom)) {
          _tmpDateFrom = null;
        } else {
          _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
        }
        _result.setDateFrom(_tmpDateFrom);
        final String _tmpDateThru;
        if (_cursor.isNull(_cursorIndexOfDateThru)) {
          _tmpDateThru = null;
        } else {
          _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
        }
        _result.setDateThru(_tmpDateThru);
        final String _tmpDestinat;
        if (_cursor.isNull(_cursorIndexOfDestinat)) {
          _tmpDestinat = null;
        } else {
          _tmpDestinat = _cursor.getString(_cursorIndexOfDestinat);
        }
        _result.setDestinat(_tmpDestinat);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _result.setApproved(_tmpApproved);
        final String _tmpDapprove;
        if (_cursor.isNull(_cursorIndexOfDapprove)) {
          _tmpDapprove = null;
        } else {
          _tmpDapprove = _cursor.getString(_cursorIndexOfDapprove);
        }
        _result.setDapprove(_tmpDapprove);
        final String _tmpAppldFrx;
        if (_cursor.isNull(_cursorIndexOfAppldFrx)) {
          _tmpAppldFrx = null;
        } else {
          _tmpAppldFrx = _cursor.getString(_cursorIndexOfAppldFrx);
        }
        _result.setAppldFrx(_tmpAppldFrx);
        final String _tmpAppldTox;
        if (_cursor.isNull(_cursorIndexOfAppldTox)) {
          _tmpAppldTox = null;
        } else {
          _tmpAppldTox = _cursor.getString(_cursorIndexOfAppldTox);
        }
        _result.setAppldTox(_tmpAppldTox);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
        final String _tmpDModfied;
        if (_cursor.isNull(_cursorIndexOfDModfied)) {
          _tmpDModfied = null;
        } else {
          _tmpDModfied = _cursor.getString(_cursorIndexOfDModfied);
        }
        _result.setDModfied(_tmpDModfied);
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
  public List<EEmployeeBusinessTrip> GetUnpostedApprovals() {
    final String _sql = "SELECT * FROM EMPLOYEE_BUSINESS_TRIP WHERE cSendStat != '1' AND cTranStat != '0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfEmployee = CursorUtil.getColumnIndexOrThrow(_cursor, "xEmployee");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFullName");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
      final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
      final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
      final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
      final int _cursorIndexOfDestinat = CursorUtil.getColumnIndexOrThrow(_cursor, "sDestinat");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDapprove = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
      final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
      final int _cursorIndexOfDModfied = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<EEmployeeBusinessTrip> _result = new ArrayList<EEmployeeBusinessTrip>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EEmployeeBusinessTrip _item;
        _item = new EEmployeeBusinessTrip();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpEmployee;
        if (_cursor.isNull(_cursorIndexOfEmployee)) {
          _tmpEmployee = null;
        } else {
          _tmpEmployee = _cursor.getString(_cursorIndexOfEmployee);
        }
        _item.setEmployee(_tmpEmployee);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _item.setBranchNm(_tmpBranchNm);
        final String _tmpDeptName;
        if (_cursor.isNull(_cursorIndexOfDeptName)) {
          _tmpDeptName = null;
        } else {
          _tmpDeptName = _cursor.getString(_cursorIndexOfDeptName);
        }
        _item.setDeptName(_tmpDeptName);
        final String _tmpPositnNm;
        if (_cursor.isNull(_cursorIndexOfPositnNm)) {
          _tmpPositnNm = null;
        } else {
          _tmpPositnNm = _cursor.getString(_cursorIndexOfPositnNm);
        }
        _item.setPositnNm(_tmpPositnNm);
        final String _tmpDateFrom;
        if (_cursor.isNull(_cursorIndexOfDateFrom)) {
          _tmpDateFrom = null;
        } else {
          _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
        }
        _item.setDateFrom(_tmpDateFrom);
        final String _tmpDateThru;
        if (_cursor.isNull(_cursorIndexOfDateThru)) {
          _tmpDateThru = null;
        } else {
          _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
        }
        _item.setDateThru(_tmpDateThru);
        final String _tmpDestinat;
        if (_cursor.isNull(_cursorIndexOfDestinat)) {
          _tmpDestinat = null;
        } else {
          _tmpDestinat = _cursor.getString(_cursorIndexOfDestinat);
        }
        _item.setDestinat(_tmpDestinat);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _item.setApproved(_tmpApproved);
        final String _tmpDapprove;
        if (_cursor.isNull(_cursorIndexOfDapprove)) {
          _tmpDapprove = null;
        } else {
          _tmpDapprove = _cursor.getString(_cursorIndexOfDapprove);
        }
        _item.setDapprove(_tmpDapprove);
        final String _tmpAppldFrx;
        if (_cursor.isNull(_cursorIndexOfAppldFrx)) {
          _tmpAppldFrx = null;
        } else {
          _tmpAppldFrx = _cursor.getString(_cursorIndexOfAppldFrx);
        }
        _item.setAppldFrx(_tmpAppldFrx);
        final String _tmpAppldTox;
        if (_cursor.isNull(_cursorIndexOfAppldTox)) {
          _tmpAppldTox = null;
        } else {
          _tmpAppldTox = _cursor.getString(_cursorIndexOfAppldTox);
        }
        _item.setAppldTox(_tmpAppldTox);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        final String _tmpDModfied;
        if (_cursor.isNull(_cursorIndexOfDModfied)) {
          _tmpDModfied = null;
        } else {
          _tmpDModfied = _cursor.getString(_cursorIndexOfDModfied);
        }
        _item.setDModfied(_tmpDModfied);
        final String _tmpTimeStmp;
        if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
          _tmpTimeStmp = null;
        } else {
          _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
        }
        _item.setTimeStmp(_tmpTimeStmp);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<EEmployeeBusinessTrip> GetUnpostedOBApplications() {
    final String _sql = "SELECT * FROM Employee_Business_Trip WHERE cSendStat != '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfEmployee = CursorUtil.getColumnIndexOrThrow(_cursor, "xEmployee");
      final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFullName");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
      final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
      final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
      final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
      final int _cursorIndexOfDestinat = CursorUtil.getColumnIndexOrThrow(_cursor, "sDestinat");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDapprove = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
      final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
      final int _cursorIndexOfDModfied = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<EEmployeeBusinessTrip> _result = new ArrayList<EEmployeeBusinessTrip>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EEmployeeBusinessTrip _item;
        _item = new EEmployeeBusinessTrip();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpEmployee;
        if (_cursor.isNull(_cursorIndexOfEmployee)) {
          _tmpEmployee = null;
        } else {
          _tmpEmployee = _cursor.getString(_cursorIndexOfEmployee);
        }
        _item.setEmployee(_tmpEmployee);
        final String _tmpFullName;
        if (_cursor.isNull(_cursorIndexOfFullName)) {
          _tmpFullName = null;
        } else {
          _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
        }
        _item.setFullName(_tmpFullName);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _item.setBranchNm(_tmpBranchNm);
        final String _tmpDeptName;
        if (_cursor.isNull(_cursorIndexOfDeptName)) {
          _tmpDeptName = null;
        } else {
          _tmpDeptName = _cursor.getString(_cursorIndexOfDeptName);
        }
        _item.setDeptName(_tmpDeptName);
        final String _tmpPositnNm;
        if (_cursor.isNull(_cursorIndexOfPositnNm)) {
          _tmpPositnNm = null;
        } else {
          _tmpPositnNm = _cursor.getString(_cursorIndexOfPositnNm);
        }
        _item.setPositnNm(_tmpPositnNm);
        final String _tmpDateFrom;
        if (_cursor.isNull(_cursorIndexOfDateFrom)) {
          _tmpDateFrom = null;
        } else {
          _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
        }
        _item.setDateFrom(_tmpDateFrom);
        final String _tmpDateThru;
        if (_cursor.isNull(_cursorIndexOfDateThru)) {
          _tmpDateThru = null;
        } else {
          _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
        }
        _item.setDateThru(_tmpDateThru);
        final String _tmpDestinat;
        if (_cursor.isNull(_cursorIndexOfDestinat)) {
          _tmpDestinat = null;
        } else {
          _tmpDestinat = _cursor.getString(_cursorIndexOfDestinat);
        }
        _item.setDestinat(_tmpDestinat);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _item.setApproved(_tmpApproved);
        final String _tmpDapprove;
        if (_cursor.isNull(_cursorIndexOfDapprove)) {
          _tmpDapprove = null;
        } else {
          _tmpDapprove = _cursor.getString(_cursorIndexOfDapprove);
        }
        _item.setDapprove(_tmpDapprove);
        final String _tmpAppldFrx;
        if (_cursor.isNull(_cursorIndexOfAppldFrx)) {
          _tmpAppldFrx = null;
        } else {
          _tmpAppldFrx = _cursor.getString(_cursorIndexOfAppldFrx);
        }
        _item.setAppldFrx(_tmpAppldFrx);
        final String _tmpAppldTox;
        if (_cursor.isNull(_cursorIndexOfAppldTox)) {
          _tmpAppldTox = null;
        } else {
          _tmpAppldTox = _cursor.getString(_cursorIndexOfAppldTox);
        }
        _item.setAppldTox(_tmpAppldTox);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        final String _tmpDModfied;
        if (_cursor.isNull(_cursorIndexOfDModfied)) {
          _tmpDModfied = null;
        } else {
          _tmpDModfied = _cursor.getString(_cursorIndexOfDModfied);
        }
        _item.setDModfied(_tmpDModfied);
        final String _tmpTimeStmp;
        if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
          _tmpTimeStmp = null;
        } else {
          _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
        }
        _item.setTimeStmp(_tmpTimeStmp);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<EEmployeeBusinessTrip> getBusinessTripInfo(final String TransNox) {
    final String _sql = "SELECT * FROM Employee_Business_Trip WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Business_Trip"}, false, new Callable<EEmployeeBusinessTrip>() {
      @Override
      public EEmployeeBusinessTrip call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfEmployee = CursorUtil.getColumnIndexOrThrow(_cursor, "xEmployee");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFullName");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
          final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfDestinat = CursorUtil.getColumnIndexOrThrow(_cursor, "sDestinat");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDapprove = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
          final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
          final int _cursorIndexOfDModfied = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final EEmployeeBusinessTrip _result;
          if(_cursor.moveToFirst()) {
            _result = new EEmployeeBusinessTrip();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _result.setTransact(_tmpTransact);
            final String _tmpEmployee;
            if (_cursor.isNull(_cursorIndexOfEmployee)) {
              _tmpEmployee = null;
            } else {
              _tmpEmployee = _cursor.getString(_cursorIndexOfEmployee);
            }
            _result.setEmployee(_tmpEmployee);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _result.setFullName(_tmpFullName);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final String _tmpDeptName;
            if (_cursor.isNull(_cursorIndexOfDeptName)) {
              _tmpDeptName = null;
            } else {
              _tmpDeptName = _cursor.getString(_cursorIndexOfDeptName);
            }
            _result.setDeptName(_tmpDeptName);
            final String _tmpPositnNm;
            if (_cursor.isNull(_cursorIndexOfPositnNm)) {
              _tmpPositnNm = null;
            } else {
              _tmpPositnNm = _cursor.getString(_cursorIndexOfPositnNm);
            }
            _result.setPositnNm(_tmpPositnNm);
            final String _tmpDateFrom;
            if (_cursor.isNull(_cursorIndexOfDateFrom)) {
              _tmpDateFrom = null;
            } else {
              _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
            }
            _result.setDateFrom(_tmpDateFrom);
            final String _tmpDateThru;
            if (_cursor.isNull(_cursorIndexOfDateThru)) {
              _tmpDateThru = null;
            } else {
              _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
            }
            _result.setDateThru(_tmpDateThru);
            final String _tmpDestinat;
            if (_cursor.isNull(_cursorIndexOfDestinat)) {
              _tmpDestinat = null;
            } else {
              _tmpDestinat = _cursor.getString(_cursorIndexOfDestinat);
            }
            _result.setDestinat(_tmpDestinat);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _result.setApproved(_tmpApproved);
            final String _tmpDapprove;
            if (_cursor.isNull(_cursorIndexOfDapprove)) {
              _tmpDapprove = null;
            } else {
              _tmpDapprove = _cursor.getString(_cursorIndexOfDapprove);
            }
            _result.setDapprove(_tmpDapprove);
            final String _tmpAppldFrx;
            if (_cursor.isNull(_cursorIndexOfAppldFrx)) {
              _tmpAppldFrx = null;
            } else {
              _tmpAppldFrx = _cursor.getString(_cursorIndexOfAppldFrx);
            }
            _result.setAppldFrx(_tmpAppldFrx);
            final String _tmpAppldTox;
            if (_cursor.isNull(_cursorIndexOfAppldTox)) {
              _tmpAppldTox = null;
            } else {
              _tmpAppldTox = _cursor.getString(_cursorIndexOfAppldTox);
            }
            _result.setAppldTox(_tmpAppldTox);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
            final String _tmpDModfied;
            if (_cursor.isNull(_cursorIndexOfDModfied)) {
              _tmpDModfied = null;
            } else {
              _tmpDModfied = _cursor.getString(_cursorIndexOfDModfied);
            }
            _result.setDModfied(_tmpDModfied);
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
  public LiveData<List<EEmployeeBusinessTrip>> getOBListForApproval() {
    final String _sql = "SELECT * FROM Employee_Business_Trip WHERE sApproved IS NULL AND dApproved IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Business_Trip"}, false, new Callable<List<EEmployeeBusinessTrip>>() {
      @Override
      public List<EEmployeeBusinessTrip> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfEmployee = CursorUtil.getColumnIndexOrThrow(_cursor, "xEmployee");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFullName");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
          final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfDestinat = CursorUtil.getColumnIndexOrThrow(_cursor, "sDestinat");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDapprove = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
          final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
          final int _cursorIndexOfDModfied = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EEmployeeBusinessTrip> _result = new ArrayList<EEmployeeBusinessTrip>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EEmployeeBusinessTrip _item;
            _item = new EEmployeeBusinessTrip();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpEmployee;
            if (_cursor.isNull(_cursorIndexOfEmployee)) {
              _tmpEmployee = null;
            } else {
              _tmpEmployee = _cursor.getString(_cursorIndexOfEmployee);
            }
            _item.setEmployee(_tmpEmployee);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _item.setFullName(_tmpFullName);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDeptName;
            if (_cursor.isNull(_cursorIndexOfDeptName)) {
              _tmpDeptName = null;
            } else {
              _tmpDeptName = _cursor.getString(_cursorIndexOfDeptName);
            }
            _item.setDeptName(_tmpDeptName);
            final String _tmpPositnNm;
            if (_cursor.isNull(_cursorIndexOfPositnNm)) {
              _tmpPositnNm = null;
            } else {
              _tmpPositnNm = _cursor.getString(_cursorIndexOfPositnNm);
            }
            _item.setPositnNm(_tmpPositnNm);
            final String _tmpDateFrom;
            if (_cursor.isNull(_cursorIndexOfDateFrom)) {
              _tmpDateFrom = null;
            } else {
              _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
            }
            _item.setDateFrom(_tmpDateFrom);
            final String _tmpDateThru;
            if (_cursor.isNull(_cursorIndexOfDateThru)) {
              _tmpDateThru = null;
            } else {
              _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
            }
            _item.setDateThru(_tmpDateThru);
            final String _tmpDestinat;
            if (_cursor.isNull(_cursorIndexOfDestinat)) {
              _tmpDestinat = null;
            } else {
              _tmpDestinat = _cursor.getString(_cursorIndexOfDestinat);
            }
            _item.setDestinat(_tmpDestinat);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _item.setApproved(_tmpApproved);
            final String _tmpDapprove;
            if (_cursor.isNull(_cursorIndexOfDapprove)) {
              _tmpDapprove = null;
            } else {
              _tmpDapprove = _cursor.getString(_cursorIndexOfDapprove);
            }
            _item.setDapprove(_tmpDapprove);
            final String _tmpAppldFrx;
            if (_cursor.isNull(_cursorIndexOfAppldFrx)) {
              _tmpAppldFrx = null;
            } else {
              _tmpAppldFrx = _cursor.getString(_cursorIndexOfAppldFrx);
            }
            _item.setAppldFrx(_tmpAppldFrx);
            final String _tmpAppldTox;
            if (_cursor.isNull(_cursorIndexOfAppldTox)) {
              _tmpAppldTox = null;
            } else {
              _tmpAppldTox = _cursor.getString(_cursorIndexOfAppldTox);
            }
            _item.setAppldTox(_tmpAppldTox);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            final String _tmpDModfied;
            if (_cursor.isNull(_cursorIndexOfDModfied)) {
              _tmpDModfied = null;
            } else {
              _tmpDModfied = _cursor.getString(_cursorIndexOfDModfied);
            }
            _item.setDModfied(_tmpDModfied);
            final String _tmpTimeStmp;
            if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
              _tmpTimeStmp = null;
            } else {
              _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
            }
            _item.setTimeStmp(_tmpTimeStmp);
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
  public LiveData<List<EEmployeeBusinessTrip>> getOBList() {
    final String _sql = "SELECT * FROM Employee_Business_Trip WHERE xEmployee = (SELECT sEmployID FROM User_Info_Master)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Business_Trip","User_Info_Master"}, false, new Callable<List<EEmployeeBusinessTrip>>() {
      @Override
      public List<EEmployeeBusinessTrip> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfEmployee = CursorUtil.getColumnIndexOrThrow(_cursor, "xEmployee");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFullName");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
          final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfDestinat = CursorUtil.getColumnIndexOrThrow(_cursor, "sDestinat");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDapprove = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
          final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
          final int _cursorIndexOfDModfied = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EEmployeeBusinessTrip> _result = new ArrayList<EEmployeeBusinessTrip>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EEmployeeBusinessTrip _item;
            _item = new EEmployeeBusinessTrip();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpEmployee;
            if (_cursor.isNull(_cursorIndexOfEmployee)) {
              _tmpEmployee = null;
            } else {
              _tmpEmployee = _cursor.getString(_cursorIndexOfEmployee);
            }
            _item.setEmployee(_tmpEmployee);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _item.setFullName(_tmpFullName);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDeptName;
            if (_cursor.isNull(_cursorIndexOfDeptName)) {
              _tmpDeptName = null;
            } else {
              _tmpDeptName = _cursor.getString(_cursorIndexOfDeptName);
            }
            _item.setDeptName(_tmpDeptName);
            final String _tmpPositnNm;
            if (_cursor.isNull(_cursorIndexOfPositnNm)) {
              _tmpPositnNm = null;
            } else {
              _tmpPositnNm = _cursor.getString(_cursorIndexOfPositnNm);
            }
            _item.setPositnNm(_tmpPositnNm);
            final String _tmpDateFrom;
            if (_cursor.isNull(_cursorIndexOfDateFrom)) {
              _tmpDateFrom = null;
            } else {
              _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
            }
            _item.setDateFrom(_tmpDateFrom);
            final String _tmpDateThru;
            if (_cursor.isNull(_cursorIndexOfDateThru)) {
              _tmpDateThru = null;
            } else {
              _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
            }
            _item.setDateThru(_tmpDateThru);
            final String _tmpDestinat;
            if (_cursor.isNull(_cursorIndexOfDestinat)) {
              _tmpDestinat = null;
            } else {
              _tmpDestinat = _cursor.getString(_cursorIndexOfDestinat);
            }
            _item.setDestinat(_tmpDestinat);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _item.setApproved(_tmpApproved);
            final String _tmpDapprove;
            if (_cursor.isNull(_cursorIndexOfDapprove)) {
              _tmpDapprove = null;
            } else {
              _tmpDapprove = _cursor.getString(_cursorIndexOfDapprove);
            }
            _item.setDapprove(_tmpDapprove);
            final String _tmpAppldFrx;
            if (_cursor.isNull(_cursorIndexOfAppldFrx)) {
              _tmpAppldFrx = null;
            } else {
              _tmpAppldFrx = _cursor.getString(_cursorIndexOfAppldFrx);
            }
            _item.setAppldFrx(_tmpAppldFrx);
            final String _tmpAppldTox;
            if (_cursor.isNull(_cursorIndexOfAppldTox)) {
              _tmpAppldTox = null;
            } else {
              _tmpAppldTox = _cursor.getString(_cursorIndexOfAppldTox);
            }
            _item.setAppldTox(_tmpAppldTox);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            final String _tmpDModfied;
            if (_cursor.isNull(_cursorIndexOfDModfied)) {
              _tmpDModfied = null;
            } else {
              _tmpDModfied = _cursor.getString(_cursorIndexOfDModfied);
            }
            _item.setDModfied(_tmpDModfied);
            final String _tmpTimeStmp;
            if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
              _tmpTimeStmp = null;
            } else {
              _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
            }
            _item.setTimeStmp(_tmpTimeStmp);
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
  public LiveData<List<EEmployeeBusinessTrip>> GetApproveBusTrip() {
    final String _sql = "SELECT * FROM Employee_Business_Trip WHERE cTranStat <> '0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Business_Trip"}, false, new Callable<List<EEmployeeBusinessTrip>>() {
      @Override
      public List<EEmployeeBusinessTrip> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfEmployee = CursorUtil.getColumnIndexOrThrow(_cursor, "xEmployee");
          final int _cursorIndexOfFullName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFullName");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
          final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfDestinat = CursorUtil.getColumnIndexOrThrow(_cursor, "sDestinat");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDapprove = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
          final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
          final int _cursorIndexOfDModfied = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EEmployeeBusinessTrip> _result = new ArrayList<EEmployeeBusinessTrip>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EEmployeeBusinessTrip _item;
            _item = new EEmployeeBusinessTrip();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpEmployee;
            if (_cursor.isNull(_cursorIndexOfEmployee)) {
              _tmpEmployee = null;
            } else {
              _tmpEmployee = _cursor.getString(_cursorIndexOfEmployee);
            }
            _item.setEmployee(_tmpEmployee);
            final String _tmpFullName;
            if (_cursor.isNull(_cursorIndexOfFullName)) {
              _tmpFullName = null;
            } else {
              _tmpFullName = _cursor.getString(_cursorIndexOfFullName);
            }
            _item.setFullName(_tmpFullName);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDeptName;
            if (_cursor.isNull(_cursorIndexOfDeptName)) {
              _tmpDeptName = null;
            } else {
              _tmpDeptName = _cursor.getString(_cursorIndexOfDeptName);
            }
            _item.setDeptName(_tmpDeptName);
            final String _tmpPositnNm;
            if (_cursor.isNull(_cursorIndexOfPositnNm)) {
              _tmpPositnNm = null;
            } else {
              _tmpPositnNm = _cursor.getString(_cursorIndexOfPositnNm);
            }
            _item.setPositnNm(_tmpPositnNm);
            final String _tmpDateFrom;
            if (_cursor.isNull(_cursorIndexOfDateFrom)) {
              _tmpDateFrom = null;
            } else {
              _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
            }
            _item.setDateFrom(_tmpDateFrom);
            final String _tmpDateThru;
            if (_cursor.isNull(_cursorIndexOfDateThru)) {
              _tmpDateThru = null;
            } else {
              _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
            }
            _item.setDateThru(_tmpDateThru);
            final String _tmpDestinat;
            if (_cursor.isNull(_cursorIndexOfDestinat)) {
              _tmpDestinat = null;
            } else {
              _tmpDestinat = _cursor.getString(_cursorIndexOfDestinat);
            }
            _item.setDestinat(_tmpDestinat);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _item.setApproved(_tmpApproved);
            final String _tmpDapprove;
            if (_cursor.isNull(_cursorIndexOfDapprove)) {
              _tmpDapprove = null;
            } else {
              _tmpDapprove = _cursor.getString(_cursorIndexOfDapprove);
            }
            _item.setDapprove(_tmpDapprove);
            final String _tmpAppldFrx;
            if (_cursor.isNull(_cursorIndexOfAppldFrx)) {
              _tmpAppldFrx = null;
            } else {
              _tmpAppldFrx = _cursor.getString(_cursorIndexOfAppldFrx);
            }
            _item.setAppldFrx(_tmpAppldFrx);
            final String _tmpAppldTox;
            if (_cursor.isNull(_cursorIndexOfAppldTox)) {
              _tmpAppldTox = null;
            } else {
              _tmpAppldTox = _cursor.getString(_cursorIndexOfAppldTox);
            }
            _item.setAppldTox(_tmpAppldTox);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            final String _tmpDModfied;
            if (_cursor.isNull(_cursorIndexOfDModfied)) {
              _tmpDModfied = null;
            } else {
              _tmpDModfied = _cursor.getString(_cursorIndexOfDModfied);
            }
            _item.setDModfied(_tmpDModfied);
            final String _tmpTimeStmp;
            if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
              _tmpTimeStmp = null;
            } else {
              _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
            }
            _item.setTimeStmp(_tmpTimeStmp);
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
