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
import androidx.sqlite.db.SupportSQLiteQuery;
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
import org.rmj.g3appdriver.GCircle.room.Entities.ECodeApproval;
import org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeInfo;
import org.rmj.g3appdriver.GCircle.room.Entities.ESCA_Request;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DApprovalCode_Impl implements DApprovalCode {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ESCA_Request> __insertionAdapterOfESCA_Request;

  private final EntityInsertionAdapter<ECodeApproval> __insertionAdapterOfECodeApproval;

  private final EntityInsertionAdapter<ESCA_Request> __insertionAdapterOfESCA_Request_1;

  private final EntityDeletionOrUpdateAdapter<ESCA_Request> __updateAdapterOfESCA_Request;

  private final EntityDeletionOrUpdateAdapter<ECodeApproval> __updateAdapterOfECodeApproval;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUploaded;

  public DApprovalCode_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfESCA_Request = new EntityInsertionAdapter<ESCA_Request>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `xxxSCA_Request` (`sSCACodex`,`sSCATitle`,`sSCADescx`,`cSCATypex`,`cAreaHead`,`cHCMDeptx`,`cCSSDeptx`,`cComplnce`,`cMktgDept`,`cASMDeptx`,`cTLMDeptx`,`cSCMDeptx`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ESCA_Request value) {
        if (value.getSCACodex() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSCACodex());
        }
        if (value.getSCATitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSCATitle());
        }
        if (value.getSCADescx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSCADescx());
        }
        if (value.getSCATypex() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSCATypex());
        }
        if (value.getAreaHead() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAreaHead());
        }
        if (value.getHCMDeptx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getHCMDeptx());
        }
        if (value.getCSSDeptx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCSSDeptx());
        }
        if (value.getComplnce() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getComplnce());
        }
        if (value.getMktgDept() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMktgDept());
        }
        if (value.getASMDeptx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getASMDeptx());
        }
        if (value.getTLMDeptx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTLMDeptx());
        }
        if (value.getSCMDeptx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSCMDeptx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getLstUpdte());
        }
      }
    };
    this.__insertionAdapterOfECodeApproval = new EntityInsertionAdapter<ECodeApproval>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `System_Code_Approval` (`sTransNox`,`dTransact`,`sSystemCD`,`sReqstdBy`,`dReqstdxx`,`cIssuedBy`,`sMiscInfo`,`sRemarks1`,`sRemarks2`,`sApprCode`,`sEntryByx`,`sApprvByx`,`sReasonxx`,`sReqstdTo`,`cSendxxxx`,`cTranStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECodeApproval value) {
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
        if (value.getSystemCD() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSystemCD());
        }
        if (value.getReqstdBy() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getReqstdBy());
        }
        if (value.getReqstdxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getReqstdxx());
        }
        if (value.getIssuedBy() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getIssuedBy());
        }
        if (value.getMiscInfo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMiscInfo());
        }
        if (value.getRemarks1() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRemarks1());
        }
        if (value.getRemarks2() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRemarks2());
        }
        if (value.getApprCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getApprCode());
        }
        if (value.getEntryByx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getEntryByx());
        }
        if (value.getApprvByx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getApprvByx());
        }
        if (value.getReasonxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getReasonxx());
        }
        if (value.getReqstdTo() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getReqstdTo());
        }
        if (value.getSendxxxx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSendxxxx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTranStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfESCA_Request_1 = new EntityInsertionAdapter<ESCA_Request>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `xxxSCA_Request` (`sSCACodex`,`sSCATitle`,`sSCADescx`,`cSCATypex`,`cAreaHead`,`cHCMDeptx`,`cCSSDeptx`,`cComplnce`,`cMktgDept`,`cASMDeptx`,`cTLMDeptx`,`cSCMDeptx`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ESCA_Request value) {
        if (value.getSCACodex() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSCACodex());
        }
        if (value.getSCATitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSCATitle());
        }
        if (value.getSCADescx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSCADescx());
        }
        if (value.getSCATypex() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSCATypex());
        }
        if (value.getAreaHead() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAreaHead());
        }
        if (value.getHCMDeptx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getHCMDeptx());
        }
        if (value.getCSSDeptx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCSSDeptx());
        }
        if (value.getComplnce() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getComplnce());
        }
        if (value.getMktgDept() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMktgDept());
        }
        if (value.getASMDeptx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getASMDeptx());
        }
        if (value.getTLMDeptx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTLMDeptx());
        }
        if (value.getSCMDeptx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSCMDeptx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getLstUpdte());
        }
      }
    };
    this.__updateAdapterOfESCA_Request = new EntityDeletionOrUpdateAdapter<ESCA_Request>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `xxxSCA_Request` SET `sSCACodex` = ?,`sSCATitle` = ?,`sSCADescx` = ?,`cSCATypex` = ?,`cAreaHead` = ?,`cHCMDeptx` = ?,`cCSSDeptx` = ?,`cComplnce` = ?,`cMktgDept` = ?,`cASMDeptx` = ?,`cTLMDeptx` = ?,`cSCMDeptx` = ?,`cRecdStat` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sSCACodex` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ESCA_Request value) {
        if (value.getSCACodex() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getSCACodex());
        }
        if (value.getSCATitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSCATitle());
        }
        if (value.getSCADescx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSCADescx());
        }
        if (value.getSCATypex() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getSCATypex());
        }
        if (value.getAreaHead() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAreaHead());
        }
        if (value.getHCMDeptx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getHCMDeptx());
        }
        if (value.getCSSDeptx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCSSDeptx());
        }
        if (value.getComplnce() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getComplnce());
        }
        if (value.getMktgDept() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMktgDept());
        }
        if (value.getASMDeptx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getASMDeptx());
        }
        if (value.getTLMDeptx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTLMDeptx());
        }
        if (value.getSCMDeptx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSCMDeptx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getLstUpdte());
        }
        if (value.getSCACodex() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSCACodex());
        }
      }
    };
    this.__updateAdapterOfECodeApproval = new EntityDeletionOrUpdateAdapter<ECodeApproval>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `System_Code_Approval` SET `sTransNox` = ?,`dTransact` = ?,`sSystemCD` = ?,`sReqstdBy` = ?,`dReqstdxx` = ?,`cIssuedBy` = ?,`sMiscInfo` = ?,`sRemarks1` = ?,`sRemarks2` = ?,`sApprCode` = ?,`sEntryByx` = ?,`sApprvByx` = ?,`sReasonxx` = ?,`sReqstdTo` = ?,`cSendxxxx` = ?,`cTranStat` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECodeApproval value) {
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
        if (value.getSystemCD() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSystemCD());
        }
        if (value.getReqstdBy() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getReqstdBy());
        }
        if (value.getReqstdxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getReqstdxx());
        }
        if (value.getIssuedBy() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getIssuedBy());
        }
        if (value.getMiscInfo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMiscInfo());
        }
        if (value.getRemarks1() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getRemarks1());
        }
        if (value.getRemarks2() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRemarks2());
        }
        if (value.getApprCode() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getApprCode());
        }
        if (value.getEntryByx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getEntryByx());
        }
        if (value.getApprvByx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getApprvByx());
        }
        if (value.getReasonxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getReasonxx());
        }
        if (value.getReqstdTo() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getReqstdTo());
        }
        if (value.getSendxxxx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSendxxxx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTranStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateUploaded = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE System_Code_Approval SET sTransNox=?,  cSendxxxx = '1' WHERE sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveSCARequest(final ESCA_Request foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfESCA_Request.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final ECodeApproval codeApproval) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECodeApproval.insert(codeApproval);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<ESCA_Request> requestList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfESCA_Request_1.insert(requestList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateSCARequest(final ESCA_Request foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfESCA_Request.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ECodeApproval codeApproval) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfECodeApproval.handle(codeApproval);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateUploaded(final String TransNox, final String NTransNo) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUploaded.acquire();
    int _argIndex = 1;
    if (NTransNo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, NTransNo);
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
      __preparedStmtOfUpdateUploaded.release(_stmt);
    }
  }

  @Override
  public ESCA_Request GetApprovalCode(final String TransNox) {
    final String _sql = "SELECT * FROM XXXSCA_REQUEST WHERE sSCACodex =?";
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
      final int _cursorIndexOfSCACodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sSCACodex");
      final int _cursorIndexOfSCATitle = CursorUtil.getColumnIndexOrThrow(_cursor, "sSCATitle");
      final int _cursorIndexOfSCADescx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSCADescx");
      final int _cursorIndexOfSCATypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cSCATypex");
      final int _cursorIndexOfAreaHead = CursorUtil.getColumnIndexOrThrow(_cursor, "cAreaHead");
      final int _cursorIndexOfHCMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cHCMDeptx");
      final int _cursorIndexOfCSSDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cCSSDeptx");
      final int _cursorIndexOfComplnce = CursorUtil.getColumnIndexOrThrow(_cursor, "cComplnce");
      final int _cursorIndexOfMktgDept = CursorUtil.getColumnIndexOrThrow(_cursor, "cMktgDept");
      final int _cursorIndexOfASMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cASMDeptx");
      final int _cursorIndexOfTLMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cTLMDeptx");
      final int _cursorIndexOfSCMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSCMDeptx");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final ESCA_Request _result;
      if(_cursor.moveToFirst()) {
        _result = new ESCA_Request();
        final String _tmpSCACodex;
        if (_cursor.isNull(_cursorIndexOfSCACodex)) {
          _tmpSCACodex = null;
        } else {
          _tmpSCACodex = _cursor.getString(_cursorIndexOfSCACodex);
        }
        _result.setSCACodex(_tmpSCACodex);
        final String _tmpSCATitle;
        if (_cursor.isNull(_cursorIndexOfSCATitle)) {
          _tmpSCATitle = null;
        } else {
          _tmpSCATitle = _cursor.getString(_cursorIndexOfSCATitle);
        }
        _result.setSCATitle(_tmpSCATitle);
        final String _tmpSCADescx;
        if (_cursor.isNull(_cursorIndexOfSCADescx)) {
          _tmpSCADescx = null;
        } else {
          _tmpSCADescx = _cursor.getString(_cursorIndexOfSCADescx);
        }
        _result.setSCADescx(_tmpSCADescx);
        final String _tmpSCATypex;
        if (_cursor.isNull(_cursorIndexOfSCATypex)) {
          _tmpSCATypex = null;
        } else {
          _tmpSCATypex = _cursor.getString(_cursorIndexOfSCATypex);
        }
        _result.setSCATypex(_tmpSCATypex);
        final String _tmpAreaHead;
        if (_cursor.isNull(_cursorIndexOfAreaHead)) {
          _tmpAreaHead = null;
        } else {
          _tmpAreaHead = _cursor.getString(_cursorIndexOfAreaHead);
        }
        _result.setAreaHead(_tmpAreaHead);
        final String _tmpHCMDeptx;
        if (_cursor.isNull(_cursorIndexOfHCMDeptx)) {
          _tmpHCMDeptx = null;
        } else {
          _tmpHCMDeptx = _cursor.getString(_cursorIndexOfHCMDeptx);
        }
        _result.setHCMDeptx(_tmpHCMDeptx);
        final String _tmpCSSDeptx;
        if (_cursor.isNull(_cursorIndexOfCSSDeptx)) {
          _tmpCSSDeptx = null;
        } else {
          _tmpCSSDeptx = _cursor.getString(_cursorIndexOfCSSDeptx);
        }
        _result.setCSSDeptx(_tmpCSSDeptx);
        final String _tmpComplnce;
        if (_cursor.isNull(_cursorIndexOfComplnce)) {
          _tmpComplnce = null;
        } else {
          _tmpComplnce = _cursor.getString(_cursorIndexOfComplnce);
        }
        _result.setComplnce(_tmpComplnce);
        final String _tmpMktgDept;
        if (_cursor.isNull(_cursorIndexOfMktgDept)) {
          _tmpMktgDept = null;
        } else {
          _tmpMktgDept = _cursor.getString(_cursorIndexOfMktgDept);
        }
        _result.setMktgDept(_tmpMktgDept);
        final String _tmpASMDeptx;
        if (_cursor.isNull(_cursorIndexOfASMDeptx)) {
          _tmpASMDeptx = null;
        } else {
          _tmpASMDeptx = _cursor.getString(_cursorIndexOfASMDeptx);
        }
        _result.setASMDeptx(_tmpASMDeptx);
        final String _tmpTLMDeptx;
        if (_cursor.isNull(_cursorIndexOfTLMDeptx)) {
          _tmpTLMDeptx = null;
        } else {
          _tmpTLMDeptx = _cursor.getString(_cursorIndexOfTLMDeptx);
        }
        _result.setTLMDeptx(_tmpTLMDeptx);
        final String _tmpSCMDeptx;
        if (_cursor.isNull(_cursorIndexOfSCMDeptx)) {
          _tmpSCMDeptx = null;
        } else {
          _tmpSCMDeptx = _cursor.getString(_cursorIndexOfSCMDeptx);
        }
        _result.setSCMDeptx(_tmpSCMDeptx);
        final String _tmpRecdStat;
        if (_cursor.isNull(_cursorIndexOfRecdStat)) {
          _tmpRecdStat = null;
        } else {
          _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
        }
        _result.setRecdStat(_tmpRecdStat);
        final String _tmpTimeStmp;
        if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
          _tmpTimeStmp = null;
        } else {
          _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
        }
        _result.setTimeStmp(_tmpTimeStmp);
        final String _tmpLstUpdte;
        if (_cursor.isNull(_cursorIndexOfLstUpdte)) {
          _tmpLstUpdte = null;
        } else {
          _tmpLstUpdte = _cursor.getString(_cursorIndexOfLstUpdte);
        }
        _result.setLstUpdte(_tmpLstUpdte);
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
  public ECodeApproval GetCodeApproval(final String fsVal) {
    final String _sql = "SELECT * FROM System_Code_Approval WHERE sApprCode =? AND cSendxxxx != '1'";
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
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfSystemCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSystemCD");
      final int _cursorIndexOfReqstdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdBy");
      final int _cursorIndexOfReqstdxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dReqstdxx");
      final int _cursorIndexOfIssuedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "cIssuedBy");
      final int _cursorIndexOfMiscInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiscInfo");
      final int _cursorIndexOfRemarks1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarks1");
      final int _cursorIndexOfRemarks2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarks2");
      final int _cursorIndexOfApprCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sApprCode");
      final int _cursorIndexOfEntryByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sEntryByx");
      final int _cursorIndexOfApprvByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sApprvByx");
      final int _cursorIndexOfReasonxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sReasonxx");
      final int _cursorIndexOfReqstdTo = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdTo");
      final int _cursorIndexOfSendxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendxxxx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ECodeApproval _result;
      if(_cursor.moveToFirst()) {
        _result = new ECodeApproval();
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
        final String _tmpSystemCD;
        if (_cursor.isNull(_cursorIndexOfSystemCD)) {
          _tmpSystemCD = null;
        } else {
          _tmpSystemCD = _cursor.getString(_cursorIndexOfSystemCD);
        }
        _result.setSystemCD(_tmpSystemCD);
        final String _tmpReqstdBy;
        if (_cursor.isNull(_cursorIndexOfReqstdBy)) {
          _tmpReqstdBy = null;
        } else {
          _tmpReqstdBy = _cursor.getString(_cursorIndexOfReqstdBy);
        }
        _result.setReqstdBy(_tmpReqstdBy);
        final String _tmpReqstdxx;
        if (_cursor.isNull(_cursorIndexOfReqstdxx)) {
          _tmpReqstdxx = null;
        } else {
          _tmpReqstdxx = _cursor.getString(_cursorIndexOfReqstdxx);
        }
        _result.setReqstdxx(_tmpReqstdxx);
        final String _tmpIssuedBy;
        if (_cursor.isNull(_cursorIndexOfIssuedBy)) {
          _tmpIssuedBy = null;
        } else {
          _tmpIssuedBy = _cursor.getString(_cursorIndexOfIssuedBy);
        }
        _result.setIssuedBy(_tmpIssuedBy);
        final String _tmpMiscInfo;
        if (_cursor.isNull(_cursorIndexOfMiscInfo)) {
          _tmpMiscInfo = null;
        } else {
          _tmpMiscInfo = _cursor.getString(_cursorIndexOfMiscInfo);
        }
        _result.setMiscInfo(_tmpMiscInfo);
        final String _tmpRemarks1;
        if (_cursor.isNull(_cursorIndexOfRemarks1)) {
          _tmpRemarks1 = null;
        } else {
          _tmpRemarks1 = _cursor.getString(_cursorIndexOfRemarks1);
        }
        _result.setRemarks1(_tmpRemarks1);
        final String _tmpRemarks2;
        if (_cursor.isNull(_cursorIndexOfRemarks2)) {
          _tmpRemarks2 = null;
        } else {
          _tmpRemarks2 = _cursor.getString(_cursorIndexOfRemarks2);
        }
        _result.setRemarks2(_tmpRemarks2);
        final String _tmpApprCode;
        if (_cursor.isNull(_cursorIndexOfApprCode)) {
          _tmpApprCode = null;
        } else {
          _tmpApprCode = _cursor.getString(_cursorIndexOfApprCode);
        }
        _result.setApprCode(_tmpApprCode);
        final String _tmpEntryByx;
        if (_cursor.isNull(_cursorIndexOfEntryByx)) {
          _tmpEntryByx = null;
        } else {
          _tmpEntryByx = _cursor.getString(_cursorIndexOfEntryByx);
        }
        _result.setEntryByx(_tmpEntryByx);
        final String _tmpApprvByx;
        if (_cursor.isNull(_cursorIndexOfApprvByx)) {
          _tmpApprvByx = null;
        } else {
          _tmpApprvByx = _cursor.getString(_cursorIndexOfApprvByx);
        }
        _result.setApprvByx(_tmpApprvByx);
        final String _tmpReasonxx;
        if (_cursor.isNull(_cursorIndexOfReasonxx)) {
          _tmpReasonxx = null;
        } else {
          _tmpReasonxx = _cursor.getString(_cursorIndexOfReasonxx);
        }
        _result.setReasonxx(_tmpReasonxx);
        final String _tmpReqstdTo;
        if (_cursor.isNull(_cursorIndexOfReqstdTo)) {
          _tmpReqstdTo = null;
        } else {
          _tmpReqstdTo = _cursor.getString(_cursorIndexOfReqstdTo);
        }
        _result.setReqstdTo(_tmpReqstdTo);
        final String _tmpSendxxxx;
        if (_cursor.isNull(_cursorIndexOfSendxxxx)) {
          _tmpSendxxxx = null;
        } else {
          _tmpSendxxxx = _cursor.getString(_cursorIndexOfSendxxxx);
        }
        _result.setSendxxxx(_tmpSendxxxx);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
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
  public LiveData<ECodeApproval> getCodeApprovalEntry() {
    final String _sql = "SELECT * FROM System_Code_Approval ORDER BY dTransact DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"System_Code_Approval"}, false, new Callable<ECodeApproval>() {
      @Override
      public ECodeApproval call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfSystemCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSystemCD");
          final int _cursorIndexOfReqstdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdBy");
          final int _cursorIndexOfReqstdxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dReqstdxx");
          final int _cursorIndexOfIssuedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "cIssuedBy");
          final int _cursorIndexOfMiscInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiscInfo");
          final int _cursorIndexOfRemarks1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarks1");
          final int _cursorIndexOfRemarks2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarks2");
          final int _cursorIndexOfApprCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sApprCode");
          final int _cursorIndexOfEntryByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sEntryByx");
          final int _cursorIndexOfApprvByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sApprvByx");
          final int _cursorIndexOfReasonxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sReasonxx");
          final int _cursorIndexOfReqstdTo = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdTo");
          final int _cursorIndexOfSendxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendxxxx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final ECodeApproval _result;
          if(_cursor.moveToFirst()) {
            _result = new ECodeApproval();
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
            final String _tmpSystemCD;
            if (_cursor.isNull(_cursorIndexOfSystemCD)) {
              _tmpSystemCD = null;
            } else {
              _tmpSystemCD = _cursor.getString(_cursorIndexOfSystemCD);
            }
            _result.setSystemCD(_tmpSystemCD);
            final String _tmpReqstdBy;
            if (_cursor.isNull(_cursorIndexOfReqstdBy)) {
              _tmpReqstdBy = null;
            } else {
              _tmpReqstdBy = _cursor.getString(_cursorIndexOfReqstdBy);
            }
            _result.setReqstdBy(_tmpReqstdBy);
            final String _tmpReqstdxx;
            if (_cursor.isNull(_cursorIndexOfReqstdxx)) {
              _tmpReqstdxx = null;
            } else {
              _tmpReqstdxx = _cursor.getString(_cursorIndexOfReqstdxx);
            }
            _result.setReqstdxx(_tmpReqstdxx);
            final String _tmpIssuedBy;
            if (_cursor.isNull(_cursorIndexOfIssuedBy)) {
              _tmpIssuedBy = null;
            } else {
              _tmpIssuedBy = _cursor.getString(_cursorIndexOfIssuedBy);
            }
            _result.setIssuedBy(_tmpIssuedBy);
            final String _tmpMiscInfo;
            if (_cursor.isNull(_cursorIndexOfMiscInfo)) {
              _tmpMiscInfo = null;
            } else {
              _tmpMiscInfo = _cursor.getString(_cursorIndexOfMiscInfo);
            }
            _result.setMiscInfo(_tmpMiscInfo);
            final String _tmpRemarks1;
            if (_cursor.isNull(_cursorIndexOfRemarks1)) {
              _tmpRemarks1 = null;
            } else {
              _tmpRemarks1 = _cursor.getString(_cursorIndexOfRemarks1);
            }
            _result.setRemarks1(_tmpRemarks1);
            final String _tmpRemarks2;
            if (_cursor.isNull(_cursorIndexOfRemarks2)) {
              _tmpRemarks2 = null;
            } else {
              _tmpRemarks2 = _cursor.getString(_cursorIndexOfRemarks2);
            }
            _result.setRemarks2(_tmpRemarks2);
            final String _tmpApprCode;
            if (_cursor.isNull(_cursorIndexOfApprCode)) {
              _tmpApprCode = null;
            } else {
              _tmpApprCode = _cursor.getString(_cursorIndexOfApprCode);
            }
            _result.setApprCode(_tmpApprCode);
            final String _tmpEntryByx;
            if (_cursor.isNull(_cursorIndexOfEntryByx)) {
              _tmpEntryByx = null;
            } else {
              _tmpEntryByx = _cursor.getString(_cursorIndexOfEntryByx);
            }
            _result.setEntryByx(_tmpEntryByx);
            final String _tmpApprvByx;
            if (_cursor.isNull(_cursorIndexOfApprvByx)) {
              _tmpApprvByx = null;
            } else {
              _tmpApprvByx = _cursor.getString(_cursorIndexOfApprvByx);
            }
            _result.setApprvByx(_tmpApprvByx);
            final String _tmpReasonxx;
            if (_cursor.isNull(_cursorIndexOfReasonxx)) {
              _tmpReasonxx = null;
            } else {
              _tmpReasonxx = _cursor.getString(_cursorIndexOfReasonxx);
            }
            _result.setReasonxx(_tmpReasonxx);
            final String _tmpReqstdTo;
            if (_cursor.isNull(_cursorIndexOfReqstdTo)) {
              _tmpReqstdTo = null;
            } else {
              _tmpReqstdTo = _cursor.getString(_cursorIndexOfReqstdTo);
            }
            _result.setReqstdTo(_tmpReqstdTo);
            final String _tmpSendxxxx;
            if (_cursor.isNull(_cursorIndexOfSendxxxx)) {
              _tmpSendxxxx = null;
            } else {
              _tmpSendxxxx = _cursor.getString(_cursorIndexOfSendxxxx);
            }
            _result.setSendxxxx(_tmpSendxxxx);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
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
  public LiveData<List<ESCA_Request>> getSCA_AuthReference() {
    final String _sql = "SELECT * FROM xxxSCA_Request WHERE cSCATypex = '1' AND cRecdStat = '1' ORDER BY sSCATitle";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"xxxSCA_Request"}, false, new Callable<List<ESCA_Request>>() {
      @Override
      public List<ESCA_Request> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSCACodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sSCACodex");
          final int _cursorIndexOfSCATitle = CursorUtil.getColumnIndexOrThrow(_cursor, "sSCATitle");
          final int _cursorIndexOfSCADescx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSCADescx");
          final int _cursorIndexOfSCATypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cSCATypex");
          final int _cursorIndexOfAreaHead = CursorUtil.getColumnIndexOrThrow(_cursor, "cAreaHead");
          final int _cursorIndexOfHCMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cHCMDeptx");
          final int _cursorIndexOfCSSDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cCSSDeptx");
          final int _cursorIndexOfComplnce = CursorUtil.getColumnIndexOrThrow(_cursor, "cComplnce");
          final int _cursorIndexOfMktgDept = CursorUtil.getColumnIndexOrThrow(_cursor, "cMktgDept");
          final int _cursorIndexOfASMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cASMDeptx");
          final int _cursorIndexOfTLMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cTLMDeptx");
          final int _cursorIndexOfSCMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSCMDeptx");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<ESCA_Request> _result = new ArrayList<ESCA_Request>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ESCA_Request _item;
            _item = new ESCA_Request();
            final String _tmpSCACodex;
            if (_cursor.isNull(_cursorIndexOfSCACodex)) {
              _tmpSCACodex = null;
            } else {
              _tmpSCACodex = _cursor.getString(_cursorIndexOfSCACodex);
            }
            _item.setSCACodex(_tmpSCACodex);
            final String _tmpSCATitle;
            if (_cursor.isNull(_cursorIndexOfSCATitle)) {
              _tmpSCATitle = null;
            } else {
              _tmpSCATitle = _cursor.getString(_cursorIndexOfSCATitle);
            }
            _item.setSCATitle(_tmpSCATitle);
            final String _tmpSCADescx;
            if (_cursor.isNull(_cursorIndexOfSCADescx)) {
              _tmpSCADescx = null;
            } else {
              _tmpSCADescx = _cursor.getString(_cursorIndexOfSCADescx);
            }
            _item.setSCADescx(_tmpSCADescx);
            final String _tmpSCATypex;
            if (_cursor.isNull(_cursorIndexOfSCATypex)) {
              _tmpSCATypex = null;
            } else {
              _tmpSCATypex = _cursor.getString(_cursorIndexOfSCATypex);
            }
            _item.setSCATypex(_tmpSCATypex);
            final String _tmpAreaHead;
            if (_cursor.isNull(_cursorIndexOfAreaHead)) {
              _tmpAreaHead = null;
            } else {
              _tmpAreaHead = _cursor.getString(_cursorIndexOfAreaHead);
            }
            _item.setAreaHead(_tmpAreaHead);
            final String _tmpHCMDeptx;
            if (_cursor.isNull(_cursorIndexOfHCMDeptx)) {
              _tmpHCMDeptx = null;
            } else {
              _tmpHCMDeptx = _cursor.getString(_cursorIndexOfHCMDeptx);
            }
            _item.setHCMDeptx(_tmpHCMDeptx);
            final String _tmpCSSDeptx;
            if (_cursor.isNull(_cursorIndexOfCSSDeptx)) {
              _tmpCSSDeptx = null;
            } else {
              _tmpCSSDeptx = _cursor.getString(_cursorIndexOfCSSDeptx);
            }
            _item.setCSSDeptx(_tmpCSSDeptx);
            final String _tmpComplnce;
            if (_cursor.isNull(_cursorIndexOfComplnce)) {
              _tmpComplnce = null;
            } else {
              _tmpComplnce = _cursor.getString(_cursorIndexOfComplnce);
            }
            _item.setComplnce(_tmpComplnce);
            final String _tmpMktgDept;
            if (_cursor.isNull(_cursorIndexOfMktgDept)) {
              _tmpMktgDept = null;
            } else {
              _tmpMktgDept = _cursor.getString(_cursorIndexOfMktgDept);
            }
            _item.setMktgDept(_tmpMktgDept);
            final String _tmpASMDeptx;
            if (_cursor.isNull(_cursorIndexOfASMDeptx)) {
              _tmpASMDeptx = null;
            } else {
              _tmpASMDeptx = _cursor.getString(_cursorIndexOfASMDeptx);
            }
            _item.setASMDeptx(_tmpASMDeptx);
            final String _tmpTLMDeptx;
            if (_cursor.isNull(_cursorIndexOfTLMDeptx)) {
              _tmpTLMDeptx = null;
            } else {
              _tmpTLMDeptx = _cursor.getString(_cursorIndexOfTLMDeptx);
            }
            _item.setTLMDeptx(_tmpTLMDeptx);
            final String _tmpSCMDeptx;
            if (_cursor.isNull(_cursorIndexOfSCMDeptx)) {
              _tmpSCMDeptx = null;
            } else {
              _tmpSCMDeptx = _cursor.getString(_cursorIndexOfSCMDeptx);
            }
            _item.setSCMDeptx(_tmpSCMDeptx);
            final String _tmpRecdStat;
            if (_cursor.isNull(_cursorIndexOfRecdStat)) {
              _tmpRecdStat = null;
            } else {
              _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
            }
            _item.setRecdStat(_tmpRecdStat);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<ESCA_Request>> getSCA_AuthName() {
    final String _sql = "SELECT * FROM xxxSCA_Request WHERE cSCATypex = '2' AND cRecdStat = '1' ORDER BY sSCATitle";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"xxxSCA_Request"}, false, new Callable<List<ESCA_Request>>() {
      @Override
      public List<ESCA_Request> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSCACodex = CursorUtil.getColumnIndexOrThrow(_cursor, "sSCACodex");
          final int _cursorIndexOfSCATitle = CursorUtil.getColumnIndexOrThrow(_cursor, "sSCATitle");
          final int _cursorIndexOfSCADescx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSCADescx");
          final int _cursorIndexOfSCATypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cSCATypex");
          final int _cursorIndexOfAreaHead = CursorUtil.getColumnIndexOrThrow(_cursor, "cAreaHead");
          final int _cursorIndexOfHCMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cHCMDeptx");
          final int _cursorIndexOfCSSDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cCSSDeptx");
          final int _cursorIndexOfComplnce = CursorUtil.getColumnIndexOrThrow(_cursor, "cComplnce");
          final int _cursorIndexOfMktgDept = CursorUtil.getColumnIndexOrThrow(_cursor, "cMktgDept");
          final int _cursorIndexOfASMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cASMDeptx");
          final int _cursorIndexOfTLMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cTLMDeptx");
          final int _cursorIndexOfSCMDeptx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSCMDeptx");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<ESCA_Request> _result = new ArrayList<ESCA_Request>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ESCA_Request _item;
            _item = new ESCA_Request();
            final String _tmpSCACodex;
            if (_cursor.isNull(_cursorIndexOfSCACodex)) {
              _tmpSCACodex = null;
            } else {
              _tmpSCACodex = _cursor.getString(_cursorIndexOfSCACodex);
            }
            _item.setSCACodex(_tmpSCACodex);
            final String _tmpSCATitle;
            if (_cursor.isNull(_cursorIndexOfSCATitle)) {
              _tmpSCATitle = null;
            } else {
              _tmpSCATitle = _cursor.getString(_cursorIndexOfSCATitle);
            }
            _item.setSCATitle(_tmpSCATitle);
            final String _tmpSCADescx;
            if (_cursor.isNull(_cursorIndexOfSCADescx)) {
              _tmpSCADescx = null;
            } else {
              _tmpSCADescx = _cursor.getString(_cursorIndexOfSCADescx);
            }
            _item.setSCADescx(_tmpSCADescx);
            final String _tmpSCATypex;
            if (_cursor.isNull(_cursorIndexOfSCATypex)) {
              _tmpSCATypex = null;
            } else {
              _tmpSCATypex = _cursor.getString(_cursorIndexOfSCATypex);
            }
            _item.setSCATypex(_tmpSCATypex);
            final String _tmpAreaHead;
            if (_cursor.isNull(_cursorIndexOfAreaHead)) {
              _tmpAreaHead = null;
            } else {
              _tmpAreaHead = _cursor.getString(_cursorIndexOfAreaHead);
            }
            _item.setAreaHead(_tmpAreaHead);
            final String _tmpHCMDeptx;
            if (_cursor.isNull(_cursorIndexOfHCMDeptx)) {
              _tmpHCMDeptx = null;
            } else {
              _tmpHCMDeptx = _cursor.getString(_cursorIndexOfHCMDeptx);
            }
            _item.setHCMDeptx(_tmpHCMDeptx);
            final String _tmpCSSDeptx;
            if (_cursor.isNull(_cursorIndexOfCSSDeptx)) {
              _tmpCSSDeptx = null;
            } else {
              _tmpCSSDeptx = _cursor.getString(_cursorIndexOfCSSDeptx);
            }
            _item.setCSSDeptx(_tmpCSSDeptx);
            final String _tmpComplnce;
            if (_cursor.isNull(_cursorIndexOfComplnce)) {
              _tmpComplnce = null;
            } else {
              _tmpComplnce = _cursor.getString(_cursorIndexOfComplnce);
            }
            _item.setComplnce(_tmpComplnce);
            final String _tmpMktgDept;
            if (_cursor.isNull(_cursorIndexOfMktgDept)) {
              _tmpMktgDept = null;
            } else {
              _tmpMktgDept = _cursor.getString(_cursorIndexOfMktgDept);
            }
            _item.setMktgDept(_tmpMktgDept);
            final String _tmpASMDeptx;
            if (_cursor.isNull(_cursorIndexOfASMDeptx)) {
              _tmpASMDeptx = null;
            } else {
              _tmpASMDeptx = _cursor.getString(_cursorIndexOfASMDeptx);
            }
            _item.setASMDeptx(_tmpASMDeptx);
            final String _tmpTLMDeptx;
            if (_cursor.isNull(_cursorIndexOfTLMDeptx)) {
              _tmpTLMDeptx = null;
            } else {
              _tmpTLMDeptx = _cursor.getString(_cursorIndexOfTLMDeptx);
            }
            _item.setTLMDeptx(_tmpTLMDeptx);
            final String _tmpSCMDeptx;
            if (_cursor.isNull(_cursorIndexOfSCMDeptx)) {
              _tmpSCMDeptx = null;
            } else {
              _tmpSCMDeptx = _cursor.getString(_cursorIndexOfSCMDeptx);
            }
            _item.setSCMDeptx(_tmpSCMDeptx);
            final String _tmpRecdStat;
            if (_cursor.isNull(_cursorIndexOfRecdStat)) {
              _tmpRecdStat = null;
            } else {
              _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
            }
            _item.setRecdStat(_tmpRecdStat);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<String> getApprovalDesc(final String AppCode) {
    final String _sql = "SELECT sSCATitle FROM xxxSCA_Request WHERE sSCACodex =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (AppCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AppCode);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"xxxSCA_Request"}, false, new Callable<String>() {
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
  public List<ECodeApproval> GetSystemApprovalForUploading() {
    final String _sql = "SELECT * FROM System_Code_Approval WHERE cSendxxxx = '0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfSystemCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSystemCD");
      final int _cursorIndexOfReqstdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdBy");
      final int _cursorIndexOfReqstdxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dReqstdxx");
      final int _cursorIndexOfIssuedBy = CursorUtil.getColumnIndexOrThrow(_cursor, "cIssuedBy");
      final int _cursorIndexOfMiscInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiscInfo");
      final int _cursorIndexOfRemarks1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarks1");
      final int _cursorIndexOfRemarks2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarks2");
      final int _cursorIndexOfApprCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sApprCode");
      final int _cursorIndexOfEntryByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sEntryByx");
      final int _cursorIndexOfApprvByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sApprvByx");
      final int _cursorIndexOfReasonxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sReasonxx");
      final int _cursorIndexOfReqstdTo = CursorUtil.getColumnIndexOrThrow(_cursor, "sReqstdTo");
      final int _cursorIndexOfSendxxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendxxxx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<ECodeApproval> _result = new ArrayList<ECodeApproval>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ECodeApproval _item;
        _item = new ECodeApproval();
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
        final String _tmpSystemCD;
        if (_cursor.isNull(_cursorIndexOfSystemCD)) {
          _tmpSystemCD = null;
        } else {
          _tmpSystemCD = _cursor.getString(_cursorIndexOfSystemCD);
        }
        _item.setSystemCD(_tmpSystemCD);
        final String _tmpReqstdBy;
        if (_cursor.isNull(_cursorIndexOfReqstdBy)) {
          _tmpReqstdBy = null;
        } else {
          _tmpReqstdBy = _cursor.getString(_cursorIndexOfReqstdBy);
        }
        _item.setReqstdBy(_tmpReqstdBy);
        final String _tmpReqstdxx;
        if (_cursor.isNull(_cursorIndexOfReqstdxx)) {
          _tmpReqstdxx = null;
        } else {
          _tmpReqstdxx = _cursor.getString(_cursorIndexOfReqstdxx);
        }
        _item.setReqstdxx(_tmpReqstdxx);
        final String _tmpIssuedBy;
        if (_cursor.isNull(_cursorIndexOfIssuedBy)) {
          _tmpIssuedBy = null;
        } else {
          _tmpIssuedBy = _cursor.getString(_cursorIndexOfIssuedBy);
        }
        _item.setIssuedBy(_tmpIssuedBy);
        final String _tmpMiscInfo;
        if (_cursor.isNull(_cursorIndexOfMiscInfo)) {
          _tmpMiscInfo = null;
        } else {
          _tmpMiscInfo = _cursor.getString(_cursorIndexOfMiscInfo);
        }
        _item.setMiscInfo(_tmpMiscInfo);
        final String _tmpRemarks1;
        if (_cursor.isNull(_cursorIndexOfRemarks1)) {
          _tmpRemarks1 = null;
        } else {
          _tmpRemarks1 = _cursor.getString(_cursorIndexOfRemarks1);
        }
        _item.setRemarks1(_tmpRemarks1);
        final String _tmpRemarks2;
        if (_cursor.isNull(_cursorIndexOfRemarks2)) {
          _tmpRemarks2 = null;
        } else {
          _tmpRemarks2 = _cursor.getString(_cursorIndexOfRemarks2);
        }
        _item.setRemarks2(_tmpRemarks2);
        final String _tmpApprCode;
        if (_cursor.isNull(_cursorIndexOfApprCode)) {
          _tmpApprCode = null;
        } else {
          _tmpApprCode = _cursor.getString(_cursorIndexOfApprCode);
        }
        _item.setApprCode(_tmpApprCode);
        final String _tmpEntryByx;
        if (_cursor.isNull(_cursorIndexOfEntryByx)) {
          _tmpEntryByx = null;
        } else {
          _tmpEntryByx = _cursor.getString(_cursorIndexOfEntryByx);
        }
        _item.setEntryByx(_tmpEntryByx);
        final String _tmpApprvByx;
        if (_cursor.isNull(_cursorIndexOfApprvByx)) {
          _tmpApprvByx = null;
        } else {
          _tmpApprvByx = _cursor.getString(_cursorIndexOfApprvByx);
        }
        _item.setApprvByx(_tmpApprvByx);
        final String _tmpReasonxx;
        if (_cursor.isNull(_cursorIndexOfReasonxx)) {
          _tmpReasonxx = null;
        } else {
          _tmpReasonxx = _cursor.getString(_cursorIndexOfReasonxx);
        }
        _item.setReasonxx(_tmpReasonxx);
        final String _tmpReqstdTo;
        if (_cursor.isNull(_cursorIndexOfReqstdTo)) {
          _tmpReqstdTo = null;
        } else {
          _tmpReqstdTo = _cursor.getString(_cursorIndexOfReqstdTo);
        }
        _item.setReqstdTo(_tmpReqstdTo);
        final String _tmpSendxxxx;
        if (_cursor.isNull(_cursorIndexOfSendxxxx)) {
          _tmpSendxxxx = null;
        } else {
          _tmpSendxxxx = _cursor.getString(_cursorIndexOfSendxxxx);
        }
        _item.setSendxxxx(_tmpSendxxxx);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
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
  public Integer getUnpostedApprovalCode() {
    final String _sql = "SELECT COUNT(*) FROM System_Code_Approval WHERE cSendxxxx = '0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
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
      _statement.release();
    }
  }

  @Override
  public LiveData<List<ESCA_Request>> getAuthorizedFeatures(final SupportSQLiteQuery sqLiteQuery) {
    final SupportSQLiteQuery _internalQuery = sqLiteQuery;
    return __db.getInvalidationTracker().createLiveData(new String[]{"xxxSCA_Request"}, false, new Callable<List<ESCA_Request>>() {
      @Override
      public List<ESCA_Request> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _internalQuery, false, null);
        try {
          final List<ESCA_Request> _result = new ArrayList<ESCA_Request>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ESCA_Request _item;
            _item = __entityCursorConverter_orgRmjG3appdriverGCircleRoomEntitiesESCARequest(_cursor);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private ESCA_Request __entityCursorConverter_orgRmjG3appdriverGCircleRoomEntitiesESCARequest(
      Cursor cursor) {
    final ESCA_Request _entity;
    final int _cursorIndexOfSCACodex = CursorUtil.getColumnIndex(cursor, "sSCACodex");
    final int _cursorIndexOfSCATitle = CursorUtil.getColumnIndex(cursor, "sSCATitle");
    final int _cursorIndexOfSCADescx = CursorUtil.getColumnIndex(cursor, "sSCADescx");
    final int _cursorIndexOfSCATypex = CursorUtil.getColumnIndex(cursor, "cSCATypex");
    final int _cursorIndexOfAreaHead = CursorUtil.getColumnIndex(cursor, "cAreaHead");
    final int _cursorIndexOfHCMDeptx = CursorUtil.getColumnIndex(cursor, "cHCMDeptx");
    final int _cursorIndexOfCSSDeptx = CursorUtil.getColumnIndex(cursor, "cCSSDeptx");
    final int _cursorIndexOfComplnce = CursorUtil.getColumnIndex(cursor, "cComplnce");
    final int _cursorIndexOfMktgDept = CursorUtil.getColumnIndex(cursor, "cMktgDept");
    final int _cursorIndexOfASMDeptx = CursorUtil.getColumnIndex(cursor, "cASMDeptx");
    final int _cursorIndexOfTLMDeptx = CursorUtil.getColumnIndex(cursor, "cTLMDeptx");
    final int _cursorIndexOfSCMDeptx = CursorUtil.getColumnIndex(cursor, "cSCMDeptx");
    final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndex(cursor, "cRecdStat");
    final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndex(cursor, "dTimeStmp");
    final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndex(cursor, "dLstUpdte");
    _entity = new ESCA_Request();
    if (_cursorIndexOfSCACodex != -1) {
      final String _tmpSCACodex;
      if (cursor.isNull(_cursorIndexOfSCACodex)) {
        _tmpSCACodex = null;
      } else {
        _tmpSCACodex = cursor.getString(_cursorIndexOfSCACodex);
      }
      _entity.setSCACodex(_tmpSCACodex);
    }
    if (_cursorIndexOfSCATitle != -1) {
      final String _tmpSCATitle;
      if (cursor.isNull(_cursorIndexOfSCATitle)) {
        _tmpSCATitle = null;
      } else {
        _tmpSCATitle = cursor.getString(_cursorIndexOfSCATitle);
      }
      _entity.setSCATitle(_tmpSCATitle);
    }
    if (_cursorIndexOfSCADescx != -1) {
      final String _tmpSCADescx;
      if (cursor.isNull(_cursorIndexOfSCADescx)) {
        _tmpSCADescx = null;
      } else {
        _tmpSCADescx = cursor.getString(_cursorIndexOfSCADescx);
      }
      _entity.setSCADescx(_tmpSCADescx);
    }
    if (_cursorIndexOfSCATypex != -1) {
      final String _tmpSCATypex;
      if (cursor.isNull(_cursorIndexOfSCATypex)) {
        _tmpSCATypex = null;
      } else {
        _tmpSCATypex = cursor.getString(_cursorIndexOfSCATypex);
      }
      _entity.setSCATypex(_tmpSCATypex);
    }
    if (_cursorIndexOfAreaHead != -1) {
      final String _tmpAreaHead;
      if (cursor.isNull(_cursorIndexOfAreaHead)) {
        _tmpAreaHead = null;
      } else {
        _tmpAreaHead = cursor.getString(_cursorIndexOfAreaHead);
      }
      _entity.setAreaHead(_tmpAreaHead);
    }
    if (_cursorIndexOfHCMDeptx != -1) {
      final String _tmpHCMDeptx;
      if (cursor.isNull(_cursorIndexOfHCMDeptx)) {
        _tmpHCMDeptx = null;
      } else {
        _tmpHCMDeptx = cursor.getString(_cursorIndexOfHCMDeptx);
      }
      _entity.setHCMDeptx(_tmpHCMDeptx);
    }
    if (_cursorIndexOfCSSDeptx != -1) {
      final String _tmpCSSDeptx;
      if (cursor.isNull(_cursorIndexOfCSSDeptx)) {
        _tmpCSSDeptx = null;
      } else {
        _tmpCSSDeptx = cursor.getString(_cursorIndexOfCSSDeptx);
      }
      _entity.setCSSDeptx(_tmpCSSDeptx);
    }
    if (_cursorIndexOfComplnce != -1) {
      final String _tmpComplnce;
      if (cursor.isNull(_cursorIndexOfComplnce)) {
        _tmpComplnce = null;
      } else {
        _tmpComplnce = cursor.getString(_cursorIndexOfComplnce);
      }
      _entity.setComplnce(_tmpComplnce);
    }
    if (_cursorIndexOfMktgDept != -1) {
      final String _tmpMktgDept;
      if (cursor.isNull(_cursorIndexOfMktgDept)) {
        _tmpMktgDept = null;
      } else {
        _tmpMktgDept = cursor.getString(_cursorIndexOfMktgDept);
      }
      _entity.setMktgDept(_tmpMktgDept);
    }
    if (_cursorIndexOfASMDeptx != -1) {
      final String _tmpASMDeptx;
      if (cursor.isNull(_cursorIndexOfASMDeptx)) {
        _tmpASMDeptx = null;
      } else {
        _tmpASMDeptx = cursor.getString(_cursorIndexOfASMDeptx);
      }
      _entity.setASMDeptx(_tmpASMDeptx);
    }
    if (_cursorIndexOfTLMDeptx != -1) {
      final String _tmpTLMDeptx;
      if (cursor.isNull(_cursorIndexOfTLMDeptx)) {
        _tmpTLMDeptx = null;
      } else {
        _tmpTLMDeptx = cursor.getString(_cursorIndexOfTLMDeptx);
      }
      _entity.setTLMDeptx(_tmpTLMDeptx);
    }
    if (_cursorIndexOfSCMDeptx != -1) {
      final String _tmpSCMDeptx;
      if (cursor.isNull(_cursorIndexOfSCMDeptx)) {
        _tmpSCMDeptx = null;
      } else {
        _tmpSCMDeptx = cursor.getString(_cursorIndexOfSCMDeptx);
      }
      _entity.setSCMDeptx(_tmpSCMDeptx);
    }
    if (_cursorIndexOfRecdStat != -1) {
      final String _tmpRecdStat;
      if (cursor.isNull(_cursorIndexOfRecdStat)) {
        _tmpRecdStat = null;
      } else {
        _tmpRecdStat = cursor.getString(_cursorIndexOfRecdStat);
      }
      _entity.setRecdStat(_tmpRecdStat);
    }
    if (_cursorIndexOfTimeStmp != -1) {
      final String _tmpTimeStmp;
      if (cursor.isNull(_cursorIndexOfTimeStmp)) {
        _tmpTimeStmp = null;
      } else {
        _tmpTimeStmp = cursor.getString(_cursorIndexOfTimeStmp);
      }
      _entity.setTimeStmp(_tmpTimeStmp);
    }
    if (_cursorIndexOfLstUpdte != -1) {
      final String _tmpLstUpdte;
      if (cursor.isNull(_cursorIndexOfLstUpdte)) {
        _tmpLstUpdte = null;
      } else {
        _tmpLstUpdte = cursor.getString(_cursorIndexOfLstUpdte);
      }
      _entity.setLstUpdte(_tmpLstUpdte);
    }
    return _entity;
  }
}
