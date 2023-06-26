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
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeInfo;
import org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeLeave;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DEmployeeLeave_Impl implements DEmployeeLeave {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EEmployeeLeave> __insertionAdapterOfEEmployeeLeave;

  private final EntityDeletionOrUpdateAdapter<EEmployeeLeave> __updateAdapterOfEEmployeeLeave;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSendStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePostedApproval;

  public DEmployeeLeave_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEEmployeeLeave = new EntityInsertionAdapter<EEmployeeLeave>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Employee_Leave` (`sTransNox`,`dTransact`,`sEmployNm`,`sEmployID`,`sBranchNm`,`sDeptName`,`sPositnNm`,`dDateFrom`,`dDateThru`,`nNoDaysxx`,`sPurposex`,`cLeaveTyp`,`dAppldFrx`,`dAppldTox`,`sEntryByx`,`dEntryDte`,`nWithPayx`,`nWithOPay`,`nEqualHrs`,`sApproved`,`dApproved`,`cSentStat`,`cAppvSent`,`dSendDate`,`nLveCredt`,`cTranStat`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEmployeeLeave value) {
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
        if (value.getEmployNm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmployNm());
        }
        if (value.getEmployID() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEmployID());
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
        if (value.getNoDaysxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getNoDaysxx());
        }
        if (value.getPurposex() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPurposex());
        }
        if (value.getLeaveTyp() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLeaveTyp());
        }
        if (value.getAppldFrx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getAppldFrx());
        }
        if (value.getAppldTox() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getAppldTox());
        }
        if (value.getEntryByx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getEntryByx());
        }
        if (value.getEntryDte() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getEntryDte());
        }
        if (value.getWithPayx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.getWithPayx());
        }
        if (value.getWithOPay() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.getWithOPay());
        }
        if (value.getEqualHrs() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindDouble(19, value.getEqualHrs());
        }
        if (value.getApproved() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getApproved());
        }
        if (value.getDApproved() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getDApproved());
        }
        if (value.getSentStat() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getSentStat());
        }
        if (value.getAppvSent() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getAppvSent());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getSendDate());
        }
        if (value.getLveCredt() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindLong(25, value.getLveCredt());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getTranStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEEmployeeLeave = new EntityDeletionOrUpdateAdapter<EEmployeeLeave>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Employee_Leave` SET `sTransNox` = ?,`dTransact` = ?,`sEmployNm` = ?,`sEmployID` = ?,`sBranchNm` = ?,`sDeptName` = ?,`sPositnNm` = ?,`dDateFrom` = ?,`dDateThru` = ?,`nNoDaysxx` = ?,`sPurposex` = ?,`cLeaveTyp` = ?,`dAppldFrx` = ?,`dAppldTox` = ?,`sEntryByx` = ?,`dEntryDte` = ?,`nWithPayx` = ?,`nWithOPay` = ?,`nEqualHrs` = ?,`sApproved` = ?,`dApproved` = ?,`cSentStat` = ?,`cAppvSent` = ?,`dSendDate` = ?,`nLveCredt` = ?,`cTranStat` = ?,`dModified` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEmployeeLeave value) {
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
        if (value.getEmployNm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmployNm());
        }
        if (value.getEmployID() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEmployID());
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
        if (value.getNoDaysxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getNoDaysxx());
        }
        if (value.getPurposex() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPurposex());
        }
        if (value.getLeaveTyp() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLeaveTyp());
        }
        if (value.getAppldFrx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getAppldFrx());
        }
        if (value.getAppldTox() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getAppldTox());
        }
        if (value.getEntryByx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getEntryByx());
        }
        if (value.getEntryDte() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getEntryDte());
        }
        if (value.getWithPayx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindLong(17, value.getWithPayx());
        }
        if (value.getWithOPay() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindLong(18, value.getWithOPay());
        }
        if (value.getEqualHrs() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindDouble(19, value.getEqualHrs());
        }
        if (value.getApproved() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getApproved());
        }
        if (value.getDApproved() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getDApproved());
        }
        if (value.getSentStat() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getSentStat());
        }
        if (value.getAppvSent() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getAppvSent());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getSendDate());
        }
        if (value.getLveCredt() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindLong(25, value.getLveCredt());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getTranStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateSendStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Employee_Leave SET sTransNox =?, cSentStat = '1', dSendDate =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePostedApproval = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Employee_Leave SET cAppvSent = '1' WHERE sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void insertApplication(final EEmployeeLeave poLeave) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEEmployeeLeave.insert(poLeave);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateApplication(final EEmployeeLeave poLeave) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEEmployeeLeave.handle(poLeave);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSendStatus(final String DateSent, final String TransNox,
      final String newTransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSendStatus.acquire();
    int _argIndex = 1;
    if (newTransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, newTransNox);
    }
    _argIndex = 2;
    if (DateSent == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateSent);
    }
    _argIndex = 3;
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
      __preparedStmtOfUpdateSendStatus.release(_stmt);
    }
  }

  @Override
  public void updatePostedApproval(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePostedApproval.acquire();
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
      __preparedStmtOfUpdatePostedApproval.release(_stmt);
    }
  }

  @Override
  public EEmployeeLeave CheckIfApplicationExist(final String EmployID, final String Remarks,
      final String LeaveTp, final String DateFrom, final String DateThru) {
    final String _sql = "SELECT * FROM Employee_Leave WHERE sEntryByx=? AND sPurposex=? AND cLeaveTyp=? AND dDateFrom=? AND dDateThru=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (EmployID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, EmployID);
    }
    _argIndex = 2;
    if (Remarks == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Remarks);
    }
    _argIndex = 3;
    if (LeaveTp == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, LeaveTp);
    }
    _argIndex = 4;
    if (DateFrom == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, DateFrom);
    }
    _argIndex = 5;
    if (DateThru == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, DateThru);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfEmployNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployNm");
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
      final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
      final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
      final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
      final int _cursorIndexOfNoDaysxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nNoDaysxx");
      final int _cursorIndexOfPurposex = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurposex");
      final int _cursorIndexOfLeaveTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cLeaveTyp");
      final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
      final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
      final int _cursorIndexOfEntryByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sEntryByx");
      final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
      final int _cursorIndexOfWithPayx = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithPayx");
      final int _cursorIndexOfWithOPay = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithOPay");
      final int _cursorIndexOfEqualHrs = CursorUtil.getColumnIndexOrThrow(_cursor, "nEqualHrs");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfSentStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSentStat");
      final int _cursorIndexOfAppvSent = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppvSent");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfLveCredt = CursorUtil.getColumnIndexOrThrow(_cursor, "nLveCredt");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EEmployeeLeave _result;
      if(_cursor.moveToFirst()) {
        _result = new EEmployeeLeave();
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
        final String _tmpEmployNm;
        if (_cursor.isNull(_cursorIndexOfEmployNm)) {
          _tmpEmployNm = null;
        } else {
          _tmpEmployNm = _cursor.getString(_cursorIndexOfEmployNm);
        }
        _result.setEmployNm(_tmpEmployNm);
        final String _tmpEmployID;
        if (_cursor.isNull(_cursorIndexOfEmployID)) {
          _tmpEmployID = null;
        } else {
          _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
        }
        _result.setEmployID(_tmpEmployID);
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
        final Integer _tmpNoDaysxx;
        if (_cursor.isNull(_cursorIndexOfNoDaysxx)) {
          _tmpNoDaysxx = null;
        } else {
          _tmpNoDaysxx = _cursor.getInt(_cursorIndexOfNoDaysxx);
        }
        _result.setNoDaysxx(_tmpNoDaysxx);
        final String _tmpPurposex;
        if (_cursor.isNull(_cursorIndexOfPurposex)) {
          _tmpPurposex = null;
        } else {
          _tmpPurposex = _cursor.getString(_cursorIndexOfPurposex);
        }
        _result.setPurposex(_tmpPurposex);
        final String _tmpLeaveTyp;
        if (_cursor.isNull(_cursorIndexOfLeaveTyp)) {
          _tmpLeaveTyp = null;
        } else {
          _tmpLeaveTyp = _cursor.getString(_cursorIndexOfLeaveTyp);
        }
        _result.setLeaveTyp(_tmpLeaveTyp);
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
        final String _tmpEntryByx;
        if (_cursor.isNull(_cursorIndexOfEntryByx)) {
          _tmpEntryByx = null;
        } else {
          _tmpEntryByx = _cursor.getString(_cursorIndexOfEntryByx);
        }
        _result.setEntryByx(_tmpEntryByx);
        final String _tmpEntryDte;
        if (_cursor.isNull(_cursorIndexOfEntryDte)) {
          _tmpEntryDte = null;
        } else {
          _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
        }
        _result.setEntryDte(_tmpEntryDte);
        final Integer _tmpWithPayx;
        if (_cursor.isNull(_cursorIndexOfWithPayx)) {
          _tmpWithPayx = null;
        } else {
          _tmpWithPayx = _cursor.getInt(_cursorIndexOfWithPayx);
        }
        _result.setWithPayx(_tmpWithPayx);
        final Integer _tmpWithOPay;
        if (_cursor.isNull(_cursorIndexOfWithOPay)) {
          _tmpWithOPay = null;
        } else {
          _tmpWithOPay = _cursor.getInt(_cursorIndexOfWithOPay);
        }
        _result.setWithOPay(_tmpWithOPay);
        final Double _tmpEqualHrs;
        if (_cursor.isNull(_cursorIndexOfEqualHrs)) {
          _tmpEqualHrs = null;
        } else {
          _tmpEqualHrs = _cursor.getDouble(_cursorIndexOfEqualHrs);
        }
        _result.setEqualHrs(_tmpEqualHrs);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _result.setApproved(_tmpApproved);
        final String _tmpDApproved;
        if (_cursor.isNull(_cursorIndexOfDApproved)) {
          _tmpDApproved = null;
        } else {
          _tmpDApproved = _cursor.getString(_cursorIndexOfDApproved);
        }
        _result.setDApproved(_tmpDApproved);
        final String _tmpSentStat;
        if (_cursor.isNull(_cursorIndexOfSentStat)) {
          _tmpSentStat = null;
        } else {
          _tmpSentStat = _cursor.getString(_cursorIndexOfSentStat);
        }
        _result.setSentStat(_tmpSentStat);
        final String _tmpAppvSent;
        if (_cursor.isNull(_cursorIndexOfAppvSent)) {
          _tmpAppvSent = null;
        } else {
          _tmpAppvSent = _cursor.getString(_cursorIndexOfAppvSent);
        }
        _result.setAppvSent(_tmpAppvSent);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
        final Integer _tmpLveCredt;
        if (_cursor.isNull(_cursorIndexOfLveCredt)) {
          _tmpLveCredt = null;
        } else {
          _tmpLveCredt = _cursor.getInt(_cursorIndexOfLveCredt);
        }
        _result.setLveCredt(_tmpLveCredt);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
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
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT (*) FROM Employee_Leave";
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
  public EEmployeeLeave GetEmployeeLeave(final String TransNox) {
    final String _sql = "SELECT * FROM Employee_Leave WHERE sTransNox =?";
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
      final int _cursorIndexOfEmployNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployNm");
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
      final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
      final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
      final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
      final int _cursorIndexOfNoDaysxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nNoDaysxx");
      final int _cursorIndexOfPurposex = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurposex");
      final int _cursorIndexOfLeaveTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cLeaveTyp");
      final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
      final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
      final int _cursorIndexOfEntryByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sEntryByx");
      final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
      final int _cursorIndexOfWithPayx = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithPayx");
      final int _cursorIndexOfWithOPay = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithOPay");
      final int _cursorIndexOfEqualHrs = CursorUtil.getColumnIndexOrThrow(_cursor, "nEqualHrs");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfSentStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSentStat");
      final int _cursorIndexOfAppvSent = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppvSent");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfLveCredt = CursorUtil.getColumnIndexOrThrow(_cursor, "nLveCredt");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EEmployeeLeave _result;
      if(_cursor.moveToFirst()) {
        _result = new EEmployeeLeave();
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
        final String _tmpEmployNm;
        if (_cursor.isNull(_cursorIndexOfEmployNm)) {
          _tmpEmployNm = null;
        } else {
          _tmpEmployNm = _cursor.getString(_cursorIndexOfEmployNm);
        }
        _result.setEmployNm(_tmpEmployNm);
        final String _tmpEmployID;
        if (_cursor.isNull(_cursorIndexOfEmployID)) {
          _tmpEmployID = null;
        } else {
          _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
        }
        _result.setEmployID(_tmpEmployID);
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
        final Integer _tmpNoDaysxx;
        if (_cursor.isNull(_cursorIndexOfNoDaysxx)) {
          _tmpNoDaysxx = null;
        } else {
          _tmpNoDaysxx = _cursor.getInt(_cursorIndexOfNoDaysxx);
        }
        _result.setNoDaysxx(_tmpNoDaysxx);
        final String _tmpPurposex;
        if (_cursor.isNull(_cursorIndexOfPurposex)) {
          _tmpPurposex = null;
        } else {
          _tmpPurposex = _cursor.getString(_cursorIndexOfPurposex);
        }
        _result.setPurposex(_tmpPurposex);
        final String _tmpLeaveTyp;
        if (_cursor.isNull(_cursorIndexOfLeaveTyp)) {
          _tmpLeaveTyp = null;
        } else {
          _tmpLeaveTyp = _cursor.getString(_cursorIndexOfLeaveTyp);
        }
        _result.setLeaveTyp(_tmpLeaveTyp);
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
        final String _tmpEntryByx;
        if (_cursor.isNull(_cursorIndexOfEntryByx)) {
          _tmpEntryByx = null;
        } else {
          _tmpEntryByx = _cursor.getString(_cursorIndexOfEntryByx);
        }
        _result.setEntryByx(_tmpEntryByx);
        final String _tmpEntryDte;
        if (_cursor.isNull(_cursorIndexOfEntryDte)) {
          _tmpEntryDte = null;
        } else {
          _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
        }
        _result.setEntryDte(_tmpEntryDte);
        final Integer _tmpWithPayx;
        if (_cursor.isNull(_cursorIndexOfWithPayx)) {
          _tmpWithPayx = null;
        } else {
          _tmpWithPayx = _cursor.getInt(_cursorIndexOfWithPayx);
        }
        _result.setWithPayx(_tmpWithPayx);
        final Integer _tmpWithOPay;
        if (_cursor.isNull(_cursorIndexOfWithOPay)) {
          _tmpWithOPay = null;
        } else {
          _tmpWithOPay = _cursor.getInt(_cursorIndexOfWithOPay);
        }
        _result.setWithOPay(_tmpWithOPay);
        final Double _tmpEqualHrs;
        if (_cursor.isNull(_cursorIndexOfEqualHrs)) {
          _tmpEqualHrs = null;
        } else {
          _tmpEqualHrs = _cursor.getDouble(_cursorIndexOfEqualHrs);
        }
        _result.setEqualHrs(_tmpEqualHrs);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _result.setApproved(_tmpApproved);
        final String _tmpDApproved;
        if (_cursor.isNull(_cursorIndexOfDApproved)) {
          _tmpDApproved = null;
        } else {
          _tmpDApproved = _cursor.getString(_cursorIndexOfDApproved);
        }
        _result.setDApproved(_tmpDApproved);
        final String _tmpSentStat;
        if (_cursor.isNull(_cursorIndexOfSentStat)) {
          _tmpSentStat = null;
        } else {
          _tmpSentStat = _cursor.getString(_cursorIndexOfSentStat);
        }
        _result.setSentStat(_tmpSentStat);
        final String _tmpAppvSent;
        if (_cursor.isNull(_cursorIndexOfAppvSent)) {
          _tmpAppvSent = null;
        } else {
          _tmpAppvSent = _cursor.getString(_cursorIndexOfAppvSent);
        }
        _result.setAppvSent(_tmpAppvSent);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
        final Integer _tmpLveCredt;
        if (_cursor.isNull(_cursorIndexOfLveCredt)) {
          _tmpLveCredt = null;
        } else {
          _tmpLveCredt = _cursor.getInt(_cursorIndexOfLveCredt);
        }
        _result.setLveCredt(_tmpLveCredt);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
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
  public LiveData<EEmployeeLeave> getEmployeeLeaveInfo(final String TransNox) {
    final String _sql = "SELECT * FROM Employee_Leave WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Leave"}, false, new Callable<EEmployeeLeave>() {
      @Override
      public EEmployeeLeave call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfEmployNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployNm");
          final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
          final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfNoDaysxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nNoDaysxx");
          final int _cursorIndexOfPurposex = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurposex");
          final int _cursorIndexOfLeaveTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cLeaveTyp");
          final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
          final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
          final int _cursorIndexOfEntryByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sEntryByx");
          final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
          final int _cursorIndexOfWithPayx = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithPayx");
          final int _cursorIndexOfWithOPay = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithOPay");
          final int _cursorIndexOfEqualHrs = CursorUtil.getColumnIndexOrThrow(_cursor, "nEqualHrs");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfSentStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSentStat");
          final int _cursorIndexOfAppvSent = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppvSent");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfLveCredt = CursorUtil.getColumnIndexOrThrow(_cursor, "nLveCredt");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final EEmployeeLeave _result;
          if(_cursor.moveToFirst()) {
            _result = new EEmployeeLeave();
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
            final String _tmpEmployNm;
            if (_cursor.isNull(_cursorIndexOfEmployNm)) {
              _tmpEmployNm = null;
            } else {
              _tmpEmployNm = _cursor.getString(_cursorIndexOfEmployNm);
            }
            _result.setEmployNm(_tmpEmployNm);
            final String _tmpEmployID;
            if (_cursor.isNull(_cursorIndexOfEmployID)) {
              _tmpEmployID = null;
            } else {
              _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
            }
            _result.setEmployID(_tmpEmployID);
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
            final Integer _tmpNoDaysxx;
            if (_cursor.isNull(_cursorIndexOfNoDaysxx)) {
              _tmpNoDaysxx = null;
            } else {
              _tmpNoDaysxx = _cursor.getInt(_cursorIndexOfNoDaysxx);
            }
            _result.setNoDaysxx(_tmpNoDaysxx);
            final String _tmpPurposex;
            if (_cursor.isNull(_cursorIndexOfPurposex)) {
              _tmpPurposex = null;
            } else {
              _tmpPurposex = _cursor.getString(_cursorIndexOfPurposex);
            }
            _result.setPurposex(_tmpPurposex);
            final String _tmpLeaveTyp;
            if (_cursor.isNull(_cursorIndexOfLeaveTyp)) {
              _tmpLeaveTyp = null;
            } else {
              _tmpLeaveTyp = _cursor.getString(_cursorIndexOfLeaveTyp);
            }
            _result.setLeaveTyp(_tmpLeaveTyp);
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
            final String _tmpEntryByx;
            if (_cursor.isNull(_cursorIndexOfEntryByx)) {
              _tmpEntryByx = null;
            } else {
              _tmpEntryByx = _cursor.getString(_cursorIndexOfEntryByx);
            }
            _result.setEntryByx(_tmpEntryByx);
            final String _tmpEntryDte;
            if (_cursor.isNull(_cursorIndexOfEntryDte)) {
              _tmpEntryDte = null;
            } else {
              _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
            }
            _result.setEntryDte(_tmpEntryDte);
            final Integer _tmpWithPayx;
            if (_cursor.isNull(_cursorIndexOfWithPayx)) {
              _tmpWithPayx = null;
            } else {
              _tmpWithPayx = _cursor.getInt(_cursorIndexOfWithPayx);
            }
            _result.setWithPayx(_tmpWithPayx);
            final Integer _tmpWithOPay;
            if (_cursor.isNull(_cursorIndexOfWithOPay)) {
              _tmpWithOPay = null;
            } else {
              _tmpWithOPay = _cursor.getInt(_cursorIndexOfWithOPay);
            }
            _result.setWithOPay(_tmpWithOPay);
            final Double _tmpEqualHrs;
            if (_cursor.isNull(_cursorIndexOfEqualHrs)) {
              _tmpEqualHrs = null;
            } else {
              _tmpEqualHrs = _cursor.getDouble(_cursorIndexOfEqualHrs);
            }
            _result.setEqualHrs(_tmpEqualHrs);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _result.setApproved(_tmpApproved);
            final String _tmpDApproved;
            if (_cursor.isNull(_cursorIndexOfDApproved)) {
              _tmpDApproved = null;
            } else {
              _tmpDApproved = _cursor.getString(_cursorIndexOfDApproved);
            }
            _result.setDApproved(_tmpDApproved);
            final String _tmpSentStat;
            if (_cursor.isNull(_cursorIndexOfSentStat)) {
              _tmpSentStat = null;
            } else {
              _tmpSentStat = _cursor.getString(_cursorIndexOfSentStat);
            }
            _result.setSentStat(_tmpSentStat);
            final String _tmpAppvSent;
            if (_cursor.isNull(_cursorIndexOfAppvSent)) {
              _tmpAppvSent = null;
            } else {
              _tmpAppvSent = _cursor.getString(_cursorIndexOfAppvSent);
            }
            _result.setAppvSent(_tmpAppvSent);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _result.setSendDate(_tmpSendDate);
            final Integer _tmpLveCredt;
            if (_cursor.isNull(_cursorIndexOfLveCredt)) {
              _tmpLveCredt = null;
            } else {
              _tmpLveCredt = _cursor.getInt(_cursorIndexOfLveCredt);
            }
            _result.setLveCredt(_tmpLveCredt);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
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
  public LiveData<List<EEmployeeLeave>> getEmployeeLeaveForApprovalList() {
    final String _sql = "SELECT * FROM Employee_Leave WHERE cTranStat == '0' ORDER BY dTransact DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Leave"}, false, new Callable<List<EEmployeeLeave>>() {
      @Override
      public List<EEmployeeLeave> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfEmployNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployNm");
          final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
          final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfNoDaysxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nNoDaysxx");
          final int _cursorIndexOfPurposex = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurposex");
          final int _cursorIndexOfLeaveTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cLeaveTyp");
          final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
          final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
          final int _cursorIndexOfEntryByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sEntryByx");
          final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
          final int _cursorIndexOfWithPayx = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithPayx");
          final int _cursorIndexOfWithOPay = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithOPay");
          final int _cursorIndexOfEqualHrs = CursorUtil.getColumnIndexOrThrow(_cursor, "nEqualHrs");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfSentStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSentStat");
          final int _cursorIndexOfAppvSent = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppvSent");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfLveCredt = CursorUtil.getColumnIndexOrThrow(_cursor, "nLveCredt");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EEmployeeLeave> _result = new ArrayList<EEmployeeLeave>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EEmployeeLeave _item;
            _item = new EEmployeeLeave();
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
            final String _tmpEmployNm;
            if (_cursor.isNull(_cursorIndexOfEmployNm)) {
              _tmpEmployNm = null;
            } else {
              _tmpEmployNm = _cursor.getString(_cursorIndexOfEmployNm);
            }
            _item.setEmployNm(_tmpEmployNm);
            final String _tmpEmployID;
            if (_cursor.isNull(_cursorIndexOfEmployID)) {
              _tmpEmployID = null;
            } else {
              _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
            }
            _item.setEmployID(_tmpEmployID);
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
            final Integer _tmpNoDaysxx;
            if (_cursor.isNull(_cursorIndexOfNoDaysxx)) {
              _tmpNoDaysxx = null;
            } else {
              _tmpNoDaysxx = _cursor.getInt(_cursorIndexOfNoDaysxx);
            }
            _item.setNoDaysxx(_tmpNoDaysxx);
            final String _tmpPurposex;
            if (_cursor.isNull(_cursorIndexOfPurposex)) {
              _tmpPurposex = null;
            } else {
              _tmpPurposex = _cursor.getString(_cursorIndexOfPurposex);
            }
            _item.setPurposex(_tmpPurposex);
            final String _tmpLeaveTyp;
            if (_cursor.isNull(_cursorIndexOfLeaveTyp)) {
              _tmpLeaveTyp = null;
            } else {
              _tmpLeaveTyp = _cursor.getString(_cursorIndexOfLeaveTyp);
            }
            _item.setLeaveTyp(_tmpLeaveTyp);
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
            final String _tmpEntryByx;
            if (_cursor.isNull(_cursorIndexOfEntryByx)) {
              _tmpEntryByx = null;
            } else {
              _tmpEntryByx = _cursor.getString(_cursorIndexOfEntryByx);
            }
            _item.setEntryByx(_tmpEntryByx);
            final String _tmpEntryDte;
            if (_cursor.isNull(_cursorIndexOfEntryDte)) {
              _tmpEntryDte = null;
            } else {
              _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
            }
            _item.setEntryDte(_tmpEntryDte);
            final Integer _tmpWithPayx;
            if (_cursor.isNull(_cursorIndexOfWithPayx)) {
              _tmpWithPayx = null;
            } else {
              _tmpWithPayx = _cursor.getInt(_cursorIndexOfWithPayx);
            }
            _item.setWithPayx(_tmpWithPayx);
            final Integer _tmpWithOPay;
            if (_cursor.isNull(_cursorIndexOfWithOPay)) {
              _tmpWithOPay = null;
            } else {
              _tmpWithOPay = _cursor.getInt(_cursorIndexOfWithOPay);
            }
            _item.setWithOPay(_tmpWithOPay);
            final Double _tmpEqualHrs;
            if (_cursor.isNull(_cursorIndexOfEqualHrs)) {
              _tmpEqualHrs = null;
            } else {
              _tmpEqualHrs = _cursor.getDouble(_cursorIndexOfEqualHrs);
            }
            _item.setEqualHrs(_tmpEqualHrs);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _item.setApproved(_tmpApproved);
            final String _tmpDApproved;
            if (_cursor.isNull(_cursorIndexOfDApproved)) {
              _tmpDApproved = null;
            } else {
              _tmpDApproved = _cursor.getString(_cursorIndexOfDApproved);
            }
            _item.setDApproved(_tmpDApproved);
            final String _tmpSentStat;
            if (_cursor.isNull(_cursorIndexOfSentStat)) {
              _tmpSentStat = null;
            } else {
              _tmpSentStat = _cursor.getString(_cursorIndexOfSentStat);
            }
            _item.setSentStat(_tmpSentStat);
            final String _tmpAppvSent;
            if (_cursor.isNull(_cursorIndexOfAppvSent)) {
              _tmpAppvSent = null;
            } else {
              _tmpAppvSent = _cursor.getString(_cursorIndexOfAppvSent);
            }
            _item.setAppvSent(_tmpAppvSent);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final Integer _tmpLveCredt;
            if (_cursor.isNull(_cursorIndexOfLveCredt)) {
              _tmpLveCredt = null;
            } else {
              _tmpLveCredt = _cursor.getInt(_cursorIndexOfLveCredt);
            }
            _item.setLveCredt(_tmpLveCredt);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
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
  public LiveData<List<EEmployeeLeave>> getEmployeeLeaveList() {
    final String _sql = "SELECT * FROM Employee_Leave WHERE sEntryByx = (SELECT sEmployID FROM User_Info_Master)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Leave","User_Info_Master"}, false, new Callable<List<EEmployeeLeave>>() {
      @Override
      public List<EEmployeeLeave> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfEmployNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployNm");
          final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
          final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfNoDaysxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nNoDaysxx");
          final int _cursorIndexOfPurposex = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurposex");
          final int _cursorIndexOfLeaveTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cLeaveTyp");
          final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
          final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
          final int _cursorIndexOfEntryByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sEntryByx");
          final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
          final int _cursorIndexOfWithPayx = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithPayx");
          final int _cursorIndexOfWithOPay = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithOPay");
          final int _cursorIndexOfEqualHrs = CursorUtil.getColumnIndexOrThrow(_cursor, "nEqualHrs");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfSentStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSentStat");
          final int _cursorIndexOfAppvSent = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppvSent");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfLveCredt = CursorUtil.getColumnIndexOrThrow(_cursor, "nLveCredt");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EEmployeeLeave> _result = new ArrayList<EEmployeeLeave>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EEmployeeLeave _item;
            _item = new EEmployeeLeave();
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
            final String _tmpEmployNm;
            if (_cursor.isNull(_cursorIndexOfEmployNm)) {
              _tmpEmployNm = null;
            } else {
              _tmpEmployNm = _cursor.getString(_cursorIndexOfEmployNm);
            }
            _item.setEmployNm(_tmpEmployNm);
            final String _tmpEmployID;
            if (_cursor.isNull(_cursorIndexOfEmployID)) {
              _tmpEmployID = null;
            } else {
              _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
            }
            _item.setEmployID(_tmpEmployID);
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
            final Integer _tmpNoDaysxx;
            if (_cursor.isNull(_cursorIndexOfNoDaysxx)) {
              _tmpNoDaysxx = null;
            } else {
              _tmpNoDaysxx = _cursor.getInt(_cursorIndexOfNoDaysxx);
            }
            _item.setNoDaysxx(_tmpNoDaysxx);
            final String _tmpPurposex;
            if (_cursor.isNull(_cursorIndexOfPurposex)) {
              _tmpPurposex = null;
            } else {
              _tmpPurposex = _cursor.getString(_cursorIndexOfPurposex);
            }
            _item.setPurposex(_tmpPurposex);
            final String _tmpLeaveTyp;
            if (_cursor.isNull(_cursorIndexOfLeaveTyp)) {
              _tmpLeaveTyp = null;
            } else {
              _tmpLeaveTyp = _cursor.getString(_cursorIndexOfLeaveTyp);
            }
            _item.setLeaveTyp(_tmpLeaveTyp);
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
            final String _tmpEntryByx;
            if (_cursor.isNull(_cursorIndexOfEntryByx)) {
              _tmpEntryByx = null;
            } else {
              _tmpEntryByx = _cursor.getString(_cursorIndexOfEntryByx);
            }
            _item.setEntryByx(_tmpEntryByx);
            final String _tmpEntryDte;
            if (_cursor.isNull(_cursorIndexOfEntryDte)) {
              _tmpEntryDte = null;
            } else {
              _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
            }
            _item.setEntryDte(_tmpEntryDte);
            final Integer _tmpWithPayx;
            if (_cursor.isNull(_cursorIndexOfWithPayx)) {
              _tmpWithPayx = null;
            } else {
              _tmpWithPayx = _cursor.getInt(_cursorIndexOfWithPayx);
            }
            _item.setWithPayx(_tmpWithPayx);
            final Integer _tmpWithOPay;
            if (_cursor.isNull(_cursorIndexOfWithOPay)) {
              _tmpWithOPay = null;
            } else {
              _tmpWithOPay = _cursor.getInt(_cursorIndexOfWithOPay);
            }
            _item.setWithOPay(_tmpWithOPay);
            final Double _tmpEqualHrs;
            if (_cursor.isNull(_cursorIndexOfEqualHrs)) {
              _tmpEqualHrs = null;
            } else {
              _tmpEqualHrs = _cursor.getDouble(_cursorIndexOfEqualHrs);
            }
            _item.setEqualHrs(_tmpEqualHrs);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _item.setApproved(_tmpApproved);
            final String _tmpDApproved;
            if (_cursor.isNull(_cursorIndexOfDApproved)) {
              _tmpDApproved = null;
            } else {
              _tmpDApproved = _cursor.getString(_cursorIndexOfDApproved);
            }
            _item.setDApproved(_tmpDApproved);
            final String _tmpSentStat;
            if (_cursor.isNull(_cursorIndexOfSentStat)) {
              _tmpSentStat = null;
            } else {
              _tmpSentStat = _cursor.getString(_cursorIndexOfSentStat);
            }
            _item.setSentStat(_tmpSentStat);
            final String _tmpAppvSent;
            if (_cursor.isNull(_cursorIndexOfAppvSent)) {
              _tmpAppvSent = null;
            } else {
              _tmpAppvSent = _cursor.getString(_cursorIndexOfAppvSent);
            }
            _item.setAppvSent(_tmpAppvSent);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final Integer _tmpLveCredt;
            if (_cursor.isNull(_cursorIndexOfLveCredt)) {
              _tmpLveCredt = null;
            } else {
              _tmpLveCredt = _cursor.getInt(_cursorIndexOfLveCredt);
            }
            _item.setLveCredt(_tmpLveCredt);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
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
  public LiveData<List<EEmployeeLeave>> getApproveLeaveList() {
    final String _sql = "SELECT * FROM Employee_Leave WHERE cTranStat <> '0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Leave"}, false, new Callable<List<EEmployeeLeave>>() {
      @Override
      public List<EEmployeeLeave> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfEmployNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployNm");
          final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
          final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfNoDaysxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nNoDaysxx");
          final int _cursorIndexOfPurposex = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurposex");
          final int _cursorIndexOfLeaveTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cLeaveTyp");
          final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
          final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
          final int _cursorIndexOfEntryByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sEntryByx");
          final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
          final int _cursorIndexOfWithPayx = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithPayx");
          final int _cursorIndexOfWithOPay = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithOPay");
          final int _cursorIndexOfEqualHrs = CursorUtil.getColumnIndexOrThrow(_cursor, "nEqualHrs");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfSentStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSentStat");
          final int _cursorIndexOfAppvSent = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppvSent");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfLveCredt = CursorUtil.getColumnIndexOrThrow(_cursor, "nLveCredt");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EEmployeeLeave> _result = new ArrayList<EEmployeeLeave>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EEmployeeLeave _item;
            _item = new EEmployeeLeave();
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
            final String _tmpEmployNm;
            if (_cursor.isNull(_cursorIndexOfEmployNm)) {
              _tmpEmployNm = null;
            } else {
              _tmpEmployNm = _cursor.getString(_cursorIndexOfEmployNm);
            }
            _item.setEmployNm(_tmpEmployNm);
            final String _tmpEmployID;
            if (_cursor.isNull(_cursorIndexOfEmployID)) {
              _tmpEmployID = null;
            } else {
              _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
            }
            _item.setEmployID(_tmpEmployID);
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
            final Integer _tmpNoDaysxx;
            if (_cursor.isNull(_cursorIndexOfNoDaysxx)) {
              _tmpNoDaysxx = null;
            } else {
              _tmpNoDaysxx = _cursor.getInt(_cursorIndexOfNoDaysxx);
            }
            _item.setNoDaysxx(_tmpNoDaysxx);
            final String _tmpPurposex;
            if (_cursor.isNull(_cursorIndexOfPurposex)) {
              _tmpPurposex = null;
            } else {
              _tmpPurposex = _cursor.getString(_cursorIndexOfPurposex);
            }
            _item.setPurposex(_tmpPurposex);
            final String _tmpLeaveTyp;
            if (_cursor.isNull(_cursorIndexOfLeaveTyp)) {
              _tmpLeaveTyp = null;
            } else {
              _tmpLeaveTyp = _cursor.getString(_cursorIndexOfLeaveTyp);
            }
            _item.setLeaveTyp(_tmpLeaveTyp);
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
            final String _tmpEntryByx;
            if (_cursor.isNull(_cursorIndexOfEntryByx)) {
              _tmpEntryByx = null;
            } else {
              _tmpEntryByx = _cursor.getString(_cursorIndexOfEntryByx);
            }
            _item.setEntryByx(_tmpEntryByx);
            final String _tmpEntryDte;
            if (_cursor.isNull(_cursorIndexOfEntryDte)) {
              _tmpEntryDte = null;
            } else {
              _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
            }
            _item.setEntryDte(_tmpEntryDte);
            final Integer _tmpWithPayx;
            if (_cursor.isNull(_cursorIndexOfWithPayx)) {
              _tmpWithPayx = null;
            } else {
              _tmpWithPayx = _cursor.getInt(_cursorIndexOfWithPayx);
            }
            _item.setWithPayx(_tmpWithPayx);
            final Integer _tmpWithOPay;
            if (_cursor.isNull(_cursorIndexOfWithOPay)) {
              _tmpWithOPay = null;
            } else {
              _tmpWithOPay = _cursor.getInt(_cursorIndexOfWithOPay);
            }
            _item.setWithOPay(_tmpWithOPay);
            final Double _tmpEqualHrs;
            if (_cursor.isNull(_cursorIndexOfEqualHrs)) {
              _tmpEqualHrs = null;
            } else {
              _tmpEqualHrs = _cursor.getDouble(_cursorIndexOfEqualHrs);
            }
            _item.setEqualHrs(_tmpEqualHrs);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _item.setApproved(_tmpApproved);
            final String _tmpDApproved;
            if (_cursor.isNull(_cursorIndexOfDApproved)) {
              _tmpDApproved = null;
            } else {
              _tmpDApproved = _cursor.getString(_cursorIndexOfDApproved);
            }
            _item.setDApproved(_tmpDApproved);
            final String _tmpSentStat;
            if (_cursor.isNull(_cursorIndexOfSentStat)) {
              _tmpSentStat = null;
            } else {
              _tmpSentStat = _cursor.getString(_cursorIndexOfSentStat);
            }
            _item.setSentStat(_tmpSentStat);
            final String _tmpAppvSent;
            if (_cursor.isNull(_cursorIndexOfAppvSent)) {
              _tmpAppvSent = null;
            } else {
              _tmpAppvSent = _cursor.getString(_cursorIndexOfAppvSent);
            }
            _item.setAppvSent(_tmpAppvSent);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
            final Integer _tmpLveCredt;
            if (_cursor.isNull(_cursorIndexOfLveCredt)) {
              _tmpLveCredt = null;
            } else {
              _tmpLveCredt = _cursor.getInt(_cursorIndexOfLveCredt);
            }
            _item.setLveCredt(_tmpLveCredt);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
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
  public List<EEmployeeLeave> getUnsentEmployeeLeave() {
    final String _sql = "SELECT * FROM Employee_Leave WHERE cSentStat <> '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfEmployNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployNm");
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDeptName = CursorUtil.getColumnIndexOrThrow(_cursor, "sDeptName");
      final int _cursorIndexOfPositnNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sPositnNm");
      final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
      final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
      final int _cursorIndexOfNoDaysxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nNoDaysxx");
      final int _cursorIndexOfPurposex = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurposex");
      final int _cursorIndexOfLeaveTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cLeaveTyp");
      final int _cursorIndexOfAppldFrx = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldFrx");
      final int _cursorIndexOfAppldTox = CursorUtil.getColumnIndexOrThrow(_cursor, "dAppldTox");
      final int _cursorIndexOfEntryByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sEntryByx");
      final int _cursorIndexOfEntryDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dEntryDte");
      final int _cursorIndexOfWithPayx = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithPayx");
      final int _cursorIndexOfWithOPay = CursorUtil.getColumnIndexOrThrow(_cursor, "nWithOPay");
      final int _cursorIndexOfEqualHrs = CursorUtil.getColumnIndexOrThrow(_cursor, "nEqualHrs");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfSentStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSentStat");
      final int _cursorIndexOfAppvSent = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppvSent");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfLveCredt = CursorUtil.getColumnIndexOrThrow(_cursor, "nLveCredt");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<EEmployeeLeave> _result = new ArrayList<EEmployeeLeave>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EEmployeeLeave _item;
        _item = new EEmployeeLeave();
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
        final String _tmpEmployNm;
        if (_cursor.isNull(_cursorIndexOfEmployNm)) {
          _tmpEmployNm = null;
        } else {
          _tmpEmployNm = _cursor.getString(_cursorIndexOfEmployNm);
        }
        _item.setEmployNm(_tmpEmployNm);
        final String _tmpEmployID;
        if (_cursor.isNull(_cursorIndexOfEmployID)) {
          _tmpEmployID = null;
        } else {
          _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
        }
        _item.setEmployID(_tmpEmployID);
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
        final Integer _tmpNoDaysxx;
        if (_cursor.isNull(_cursorIndexOfNoDaysxx)) {
          _tmpNoDaysxx = null;
        } else {
          _tmpNoDaysxx = _cursor.getInt(_cursorIndexOfNoDaysxx);
        }
        _item.setNoDaysxx(_tmpNoDaysxx);
        final String _tmpPurposex;
        if (_cursor.isNull(_cursorIndexOfPurposex)) {
          _tmpPurposex = null;
        } else {
          _tmpPurposex = _cursor.getString(_cursorIndexOfPurposex);
        }
        _item.setPurposex(_tmpPurposex);
        final String _tmpLeaveTyp;
        if (_cursor.isNull(_cursorIndexOfLeaveTyp)) {
          _tmpLeaveTyp = null;
        } else {
          _tmpLeaveTyp = _cursor.getString(_cursorIndexOfLeaveTyp);
        }
        _item.setLeaveTyp(_tmpLeaveTyp);
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
        final String _tmpEntryByx;
        if (_cursor.isNull(_cursorIndexOfEntryByx)) {
          _tmpEntryByx = null;
        } else {
          _tmpEntryByx = _cursor.getString(_cursorIndexOfEntryByx);
        }
        _item.setEntryByx(_tmpEntryByx);
        final String _tmpEntryDte;
        if (_cursor.isNull(_cursorIndexOfEntryDte)) {
          _tmpEntryDte = null;
        } else {
          _tmpEntryDte = _cursor.getString(_cursorIndexOfEntryDte);
        }
        _item.setEntryDte(_tmpEntryDte);
        final Integer _tmpWithPayx;
        if (_cursor.isNull(_cursorIndexOfWithPayx)) {
          _tmpWithPayx = null;
        } else {
          _tmpWithPayx = _cursor.getInt(_cursorIndexOfWithPayx);
        }
        _item.setWithPayx(_tmpWithPayx);
        final Integer _tmpWithOPay;
        if (_cursor.isNull(_cursorIndexOfWithOPay)) {
          _tmpWithOPay = null;
        } else {
          _tmpWithOPay = _cursor.getInt(_cursorIndexOfWithOPay);
        }
        _item.setWithOPay(_tmpWithOPay);
        final Double _tmpEqualHrs;
        if (_cursor.isNull(_cursorIndexOfEqualHrs)) {
          _tmpEqualHrs = null;
        } else {
          _tmpEqualHrs = _cursor.getDouble(_cursorIndexOfEqualHrs);
        }
        _item.setEqualHrs(_tmpEqualHrs);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _item.setApproved(_tmpApproved);
        final String _tmpDApproved;
        if (_cursor.isNull(_cursorIndexOfDApproved)) {
          _tmpDApproved = null;
        } else {
          _tmpDApproved = _cursor.getString(_cursorIndexOfDApproved);
        }
        _item.setDApproved(_tmpDApproved);
        final String _tmpSentStat;
        if (_cursor.isNull(_cursorIndexOfSentStat)) {
          _tmpSentStat = null;
        } else {
          _tmpSentStat = _cursor.getString(_cursorIndexOfSentStat);
        }
        _item.setSentStat(_tmpSentStat);
        final String _tmpAppvSent;
        if (_cursor.isNull(_cursorIndexOfAppvSent)) {
          _tmpAppvSent = null;
        } else {
          _tmpAppvSent = _cursor.getString(_cursorIndexOfAppvSent);
        }
        _item.setAppvSent(_tmpAppvSent);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _item.setSendDate(_tmpSendDate);
        final Integer _tmpLveCredt;
        if (_cursor.isNull(_cursorIndexOfLveCredt)) {
          _tmpLveCredt = null;
        } else {
          _tmpLveCredt = _cursor.getInt(_cursorIndexOfLveCredt);
        }
        _item.setLveCredt(_tmpLveCredt);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
