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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EGanadoOnline;
import org.rmj.g3appdriver.GCircle.room.Entities.EMCColor;
import org.rmj.g3appdriver.GCircle.room.Entities.EMcBrand;
import org.rmj.g3appdriver.GCircle.room.Entities.EMcModel;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DGanadoOnline_Impl implements DGanadoOnline {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EGanadoOnline> __insertionAdapterOfEGanadoOnline;

  private final EntityDeletionOrUpdateAdapter<EGanadoOnline> __updateAdapterOfEGanadoOnline;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentInquiry;

  public DGanadoOnline_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEGanadoOnline = new EntityInsertionAdapter<EGanadoOnline>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Ganado_Online` (`sTransNox`,`dTransact`,`cGanadoTp`,`cPaymForm`,`sClientNm`,`sClntInfo`,`sProdInfo`,`sPaymInfo`,`dTargetxx`,`dFollowUp`,`sRemarksx`,`sReferdBy`,`sRelatnID`,`dCreatedx`,`cTranStat`,`cSendStat`,`dModified`,`dLastUpdt`,`sBranchCD`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGanadoOnline value) {
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
        if (value.getGanadoTp() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGanadoTp());
        }
        if (value.getPaymForm() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPaymForm());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getClientNm());
        }
        if (value.getClntInfo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getClntInfo());
        }
        if (value.getProdInfo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getProdInfo());
        }
        if (value.getPaymInfo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPaymInfo());
        }
        if (value.getTargetxx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTargetxx());
        }
        if (value.getFollowUp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFollowUp());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getRemarksx());
        }
        if (value.getReferdBy() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getReferdBy());
        }
        if (value.getRelatnID() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getRelatnID());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getCreatedx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSendStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getModified());
        }
        if (value.getLastUpdt() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getLastUpdt());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getBranchCD());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEGanadoOnline = new EntityDeletionOrUpdateAdapter<EGanadoOnline>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Ganado_Online` SET `sTransNox` = ?,`dTransact` = ?,`cGanadoTp` = ?,`cPaymForm` = ?,`sClientNm` = ?,`sClntInfo` = ?,`sProdInfo` = ?,`sPaymInfo` = ?,`dTargetxx` = ?,`dFollowUp` = ?,`sRemarksx` = ?,`sReferdBy` = ?,`sRelatnID` = ?,`dCreatedx` = ?,`cTranStat` = ?,`cSendStat` = ?,`dModified` = ?,`dLastUpdt` = ?,`sBranchCD` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGanadoOnline value) {
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
        if (value.getGanadoTp() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getGanadoTp());
        }
        if (value.getPaymForm() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPaymForm());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getClientNm());
        }
        if (value.getClntInfo() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getClntInfo());
        }
        if (value.getProdInfo() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getProdInfo());
        }
        if (value.getPaymInfo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPaymInfo());
        }
        if (value.getTargetxx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTargetxx());
        }
        if (value.getFollowUp() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getFollowUp());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getRemarksx());
        }
        if (value.getReferdBy() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getReferdBy());
        }
        if (value.getRelatnID() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getRelatnID());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getCreatedx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSendStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getModified());
        }
        if (value.getLastUpdt() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getLastUpdt());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getBranchCD());
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
    this.__preparedStmtOfUpdateSentInquiry = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Ganado_Online SET cSendStat = '1', sTransNox =? WHERE sTransNox=?";
        return _query;
      }
    };
  }

  @Override
  public void Save(final EGanadoOnline foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEGanadoOnline.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final EGanadoOnline foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEGanadoOnline.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateSentInquiry(final String TransNox, final String NewTransNo) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSentInquiry.acquire();
    int _argIndex = 1;
    if (NewTransNo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, NewTransNo);
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
      __preparedStmtOfUpdateSentInquiry.release(_stmt);
    }
  }

  @Override
  public EGanadoOnline GetInquiry(final String TransNox) {
    final String _sql = "SELECT * FROM Ganado_Online WHERE sTransNox =?";
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
      final int _cursorIndexOfGanadoTp = CursorUtil.getColumnIndexOrThrow(_cursor, "cGanadoTp");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
      final int _cursorIndexOfClntInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sClntInfo");
      final int _cursorIndexOfProdInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sProdInfo");
      final int _cursorIndexOfPaymInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sPaymInfo");
      final int _cursorIndexOfTargetxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetxx");
      final int _cursorIndexOfFollowUp = CursorUtil.getColumnIndexOrThrow(_cursor, "dFollowUp");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfReferdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferdBy");
      final int _cursorIndexOfRelatnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sRelatnID");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfLastUpdt = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastUpdt");
      final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EGanadoOnline _result;
      if(_cursor.moveToFirst()) {
        _result = new EGanadoOnline();
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
        final String _tmpGanadoTp;
        if (_cursor.isNull(_cursorIndexOfGanadoTp)) {
          _tmpGanadoTp = null;
        } else {
          _tmpGanadoTp = _cursor.getString(_cursorIndexOfGanadoTp);
        }
        _result.setGanadoTp(_tmpGanadoTp);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _result.setPaymForm(_tmpPaymForm);
        final String _tmpClientNm;
        if (_cursor.isNull(_cursorIndexOfClientNm)) {
          _tmpClientNm = null;
        } else {
          _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
        }
        _result.setClientNm(_tmpClientNm);
        final String _tmpClntInfo;
        if (_cursor.isNull(_cursorIndexOfClntInfo)) {
          _tmpClntInfo = null;
        } else {
          _tmpClntInfo = _cursor.getString(_cursorIndexOfClntInfo);
        }
        _result.setClntInfo(_tmpClntInfo);
        final String _tmpProdInfo;
        if (_cursor.isNull(_cursorIndexOfProdInfo)) {
          _tmpProdInfo = null;
        } else {
          _tmpProdInfo = _cursor.getString(_cursorIndexOfProdInfo);
        }
        _result.setProdInfo(_tmpProdInfo);
        final String _tmpPaymInfo;
        if (_cursor.isNull(_cursorIndexOfPaymInfo)) {
          _tmpPaymInfo = null;
        } else {
          _tmpPaymInfo = _cursor.getString(_cursorIndexOfPaymInfo);
        }
        _result.setPaymInfo(_tmpPaymInfo);
        final String _tmpTargetxx;
        if (_cursor.isNull(_cursorIndexOfTargetxx)) {
          _tmpTargetxx = null;
        } else {
          _tmpTargetxx = _cursor.getString(_cursorIndexOfTargetxx);
        }
        _result.setTargetxx(_tmpTargetxx);
        final String _tmpFollowUp;
        if (_cursor.isNull(_cursorIndexOfFollowUp)) {
          _tmpFollowUp = null;
        } else {
          _tmpFollowUp = _cursor.getString(_cursorIndexOfFollowUp);
        }
        _result.setFollowUp(_tmpFollowUp);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpReferdBy;
        if (_cursor.isNull(_cursorIndexOfReferdBy)) {
          _tmpReferdBy = null;
        } else {
          _tmpReferdBy = _cursor.getString(_cursorIndexOfReferdBy);
        }
        _result.setReferdBy(_tmpReferdBy);
        final String _tmpRelatnID;
        if (_cursor.isNull(_cursorIndexOfRelatnID)) {
          _tmpRelatnID = null;
        } else {
          _tmpRelatnID = _cursor.getString(_cursorIndexOfRelatnID);
        }
        _result.setRelatnID(_tmpRelatnID);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _result.setCreatedx(_tmpCreatedx);
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
        final String _tmpLastUpdt;
        if (_cursor.isNull(_cursorIndexOfLastUpdt)) {
          _tmpLastUpdt = null;
        } else {
          _tmpLastUpdt = _cursor.getString(_cursorIndexOfLastUpdt);
        }
        _result.setLastUpdt(_tmpLastUpdt);
        final String _tmpBranchCD;
        if (_cursor.isNull(_cursorIndexOfBranchCD)) {
          _tmpBranchCD = null;
        } else {
          _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
        }
        _result.setBranchCD(_tmpBranchCD);
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
  public EGanadoOnline GetLatestData() {
    final String _sql = "SELECT * FROM Ganado_Online ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfGanadoTp = CursorUtil.getColumnIndexOrThrow(_cursor, "cGanadoTp");
      final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
      final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
      final int _cursorIndexOfClntInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sClntInfo");
      final int _cursorIndexOfProdInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sProdInfo");
      final int _cursorIndexOfPaymInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sPaymInfo");
      final int _cursorIndexOfTargetxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetxx");
      final int _cursorIndexOfFollowUp = CursorUtil.getColumnIndexOrThrow(_cursor, "dFollowUp");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfReferdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferdBy");
      final int _cursorIndexOfRelatnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sRelatnID");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfLastUpdt = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastUpdt");
      final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EGanadoOnline _result;
      if(_cursor.moveToFirst()) {
        _result = new EGanadoOnline();
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
        final String _tmpGanadoTp;
        if (_cursor.isNull(_cursorIndexOfGanadoTp)) {
          _tmpGanadoTp = null;
        } else {
          _tmpGanadoTp = _cursor.getString(_cursorIndexOfGanadoTp);
        }
        _result.setGanadoTp(_tmpGanadoTp);
        final String _tmpPaymForm;
        if (_cursor.isNull(_cursorIndexOfPaymForm)) {
          _tmpPaymForm = null;
        } else {
          _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
        }
        _result.setPaymForm(_tmpPaymForm);
        final String _tmpClientNm;
        if (_cursor.isNull(_cursorIndexOfClientNm)) {
          _tmpClientNm = null;
        } else {
          _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
        }
        _result.setClientNm(_tmpClientNm);
        final String _tmpClntInfo;
        if (_cursor.isNull(_cursorIndexOfClntInfo)) {
          _tmpClntInfo = null;
        } else {
          _tmpClntInfo = _cursor.getString(_cursorIndexOfClntInfo);
        }
        _result.setClntInfo(_tmpClntInfo);
        final String _tmpProdInfo;
        if (_cursor.isNull(_cursorIndexOfProdInfo)) {
          _tmpProdInfo = null;
        } else {
          _tmpProdInfo = _cursor.getString(_cursorIndexOfProdInfo);
        }
        _result.setProdInfo(_tmpProdInfo);
        final String _tmpPaymInfo;
        if (_cursor.isNull(_cursorIndexOfPaymInfo)) {
          _tmpPaymInfo = null;
        } else {
          _tmpPaymInfo = _cursor.getString(_cursorIndexOfPaymInfo);
        }
        _result.setPaymInfo(_tmpPaymInfo);
        final String _tmpTargetxx;
        if (_cursor.isNull(_cursorIndexOfTargetxx)) {
          _tmpTargetxx = null;
        } else {
          _tmpTargetxx = _cursor.getString(_cursorIndexOfTargetxx);
        }
        _result.setTargetxx(_tmpTargetxx);
        final String _tmpFollowUp;
        if (_cursor.isNull(_cursorIndexOfFollowUp)) {
          _tmpFollowUp = null;
        } else {
          _tmpFollowUp = _cursor.getString(_cursorIndexOfFollowUp);
        }
        _result.setFollowUp(_tmpFollowUp);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpReferdBy;
        if (_cursor.isNull(_cursorIndexOfReferdBy)) {
          _tmpReferdBy = null;
        } else {
          _tmpReferdBy = _cursor.getString(_cursorIndexOfReferdBy);
        }
        _result.setReferdBy(_tmpReferdBy);
        final String _tmpRelatnID;
        if (_cursor.isNull(_cursorIndexOfRelatnID)) {
          _tmpRelatnID = null;
        } else {
          _tmpRelatnID = _cursor.getString(_cursorIndexOfRelatnID);
        }
        _result.setRelatnID(_tmpRelatnID);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _result.setCreatedx(_tmpCreatedx);
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
        final String _tmpLastUpdt;
        if (_cursor.isNull(_cursorIndexOfLastUpdt)) {
          _tmpLastUpdt = null;
        } else {
          _tmpLastUpdt = _cursor.getString(_cursorIndexOfLastUpdt);
        }
        _result.setLastUpdt(_tmpLastUpdt);
        final String _tmpBranchCD;
        if (_cursor.isNull(_cursorIndexOfBranchCD)) {
          _tmpBranchCD = null;
        } else {
          _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
        }
        _result.setBranchCD(_tmpBranchCD);
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
    final String _sql = "SELECT COUNT(sTransNox) FROM GANADO_ONLINE";
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
  public LiveData<List<EMcBrand>> getAllMcBrand() {
    final String _sql = "SELECT * FROM MC_Brand WHERE sBrandNme IN ('HONDA', 'SUZUKI', 'KAWASAKI', 'YAMAHA')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Brand"}, false, new Callable<List<EMcBrand>>() {
      @Override
      public List<EMcBrand> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
          final int _cursorIndexOfBrandNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandNme");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EMcBrand> _result = new ArrayList<EMcBrand>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMcBrand _item;
            _item = new EMcBrand();
            final String _tmpBrandIDx;
            if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
              _tmpBrandIDx = null;
            } else {
              _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
            }
            _item.setBrandIDx(_tmpBrandIDx);
            final String _tmpBrandNme;
            if (_cursor.isNull(_cursorIndexOfBrandNme)) {
              _tmpBrandNme = null;
            } else {
              _tmpBrandNme = _cursor.getString(_cursorIndexOfBrandNme);
            }
            _item.setBrandNme(_tmpBrandNme);
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
  public LiveData<List<EMcModel>> getAllModeFromBrand(final String BrandID) {
    final String _sql = "SELECT * FROM Mc_Model WHERE cRecdStat = '1' AND sBrandIDx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BrandID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BrandID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mc_Model"}, false, new Callable<List<EMcModel>>() {
      @Override
      public List<EMcModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
          final int _cursorIndexOfModelCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelCde");
          final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelNme");
          final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
          final int _cursorIndexOfMotorTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cMotorTyp");
          final int _cursorIndexOfRegisTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cRegisTyp");
          final int _cursorIndexOfEndOfLfe = CursorUtil.getColumnIndexOrThrow(_cursor, "cEndOfLfe");
          final int _cursorIndexOfEngineTp = CursorUtil.getColumnIndexOrThrow(_cursor, "cEngineTp");
          final int _cursorIndexOfHotItemx = CursorUtil.getColumnIndexOrThrow(_cursor, "cHotItemx");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EMcModel> _result = new ArrayList<EMcModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMcModel _item;
            _item = new EMcModel();
            final String _tmpModelIDx;
            if (_cursor.isNull(_cursorIndexOfModelIDx)) {
              _tmpModelIDx = null;
            } else {
              _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
            }
            _item.setModelIDx(_tmpModelIDx);
            final String _tmpModelCde;
            if (_cursor.isNull(_cursorIndexOfModelCde)) {
              _tmpModelCde = null;
            } else {
              _tmpModelCde = _cursor.getString(_cursorIndexOfModelCde);
            }
            _item.setModelCde(_tmpModelCde);
            final String _tmpModelNme;
            if (_cursor.isNull(_cursorIndexOfModelNme)) {
              _tmpModelNme = null;
            } else {
              _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
            }
            _item.setModelNme(_tmpModelNme);
            final String _tmpBrandIDx;
            if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
              _tmpBrandIDx = null;
            } else {
              _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
            }
            _item.setBrandIDx(_tmpBrandIDx);
            final String _tmpMotorTyp;
            if (_cursor.isNull(_cursorIndexOfMotorTyp)) {
              _tmpMotorTyp = null;
            } else {
              _tmpMotorTyp = _cursor.getString(_cursorIndexOfMotorTyp);
            }
            _item.setMotorTyp(_tmpMotorTyp);
            final String _tmpRegisTyp;
            if (_cursor.isNull(_cursorIndexOfRegisTyp)) {
              _tmpRegisTyp = null;
            } else {
              _tmpRegisTyp = _cursor.getString(_cursorIndexOfRegisTyp);
            }
            _item.setRegisTyp(_tmpRegisTyp);
            final String _tmpEndOfLfe;
            if (_cursor.isNull(_cursorIndexOfEndOfLfe)) {
              _tmpEndOfLfe = null;
            } else {
              _tmpEndOfLfe = _cursor.getString(_cursorIndexOfEndOfLfe);
            }
            _item.setEndOfLfe(_tmpEndOfLfe);
            final String _tmpEngineTp;
            if (_cursor.isNull(_cursorIndexOfEngineTp)) {
              _tmpEngineTp = null;
            } else {
              _tmpEngineTp = _cursor.getString(_cursorIndexOfEngineTp);
            }
            _item.setEngineTp(_tmpEngineTp);
            final String _tmpHotItemx;
            if (_cursor.isNull(_cursorIndexOfHotItemx)) {
              _tmpHotItemx = null;
            } else {
              _tmpHotItemx = _cursor.getString(_cursorIndexOfHotItemx);
            }
            _item.setHotItemx(_tmpHotItemx);
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
  public LiveData<EMcModel> getModeFromBrand(final String BrandID, final String ModelID) {
    final String _sql = "SELECT * FROM Mc_Model WHERE cRecdStat = '1' AND sBrandIDx = ? AND sModelIDx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (BrandID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BrandID);
    }
    _argIndex = 2;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mc_Model"}, false, new Callable<EMcModel>() {
      @Override
      public EMcModel call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
          final int _cursorIndexOfModelCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelCde");
          final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelNme");
          final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
          final int _cursorIndexOfMotorTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cMotorTyp");
          final int _cursorIndexOfRegisTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cRegisTyp");
          final int _cursorIndexOfEndOfLfe = CursorUtil.getColumnIndexOrThrow(_cursor, "cEndOfLfe");
          final int _cursorIndexOfEngineTp = CursorUtil.getColumnIndexOrThrow(_cursor, "cEngineTp");
          final int _cursorIndexOfHotItemx = CursorUtil.getColumnIndexOrThrow(_cursor, "cHotItemx");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final EMcModel _result;
          if(_cursor.moveToFirst()) {
            _result = new EMcModel();
            final String _tmpModelIDx;
            if (_cursor.isNull(_cursorIndexOfModelIDx)) {
              _tmpModelIDx = null;
            } else {
              _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
            }
            _result.setModelIDx(_tmpModelIDx);
            final String _tmpModelCde;
            if (_cursor.isNull(_cursorIndexOfModelCde)) {
              _tmpModelCde = null;
            } else {
              _tmpModelCde = _cursor.getString(_cursorIndexOfModelCde);
            }
            _result.setModelCde(_tmpModelCde);
            final String _tmpModelNme;
            if (_cursor.isNull(_cursorIndexOfModelNme)) {
              _tmpModelNme = null;
            } else {
              _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
            }
            _result.setModelNme(_tmpModelNme);
            final String _tmpBrandIDx;
            if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
              _tmpBrandIDx = null;
            } else {
              _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
            }
            _result.setBrandIDx(_tmpBrandIDx);
            final String _tmpMotorTyp;
            if (_cursor.isNull(_cursorIndexOfMotorTyp)) {
              _tmpMotorTyp = null;
            } else {
              _tmpMotorTyp = _cursor.getString(_cursorIndexOfMotorTyp);
            }
            _result.setMotorTyp(_tmpMotorTyp);
            final String _tmpRegisTyp;
            if (_cursor.isNull(_cursorIndexOfRegisTyp)) {
              _tmpRegisTyp = null;
            } else {
              _tmpRegisTyp = _cursor.getString(_cursorIndexOfRegisTyp);
            }
            _result.setRegisTyp(_tmpRegisTyp);
            final String _tmpEndOfLfe;
            if (_cursor.isNull(_cursorIndexOfEndOfLfe)) {
              _tmpEndOfLfe = null;
            } else {
              _tmpEndOfLfe = _cursor.getString(_cursorIndexOfEndOfLfe);
            }
            _result.setEndOfLfe(_tmpEndOfLfe);
            final String _tmpEngineTp;
            if (_cursor.isNull(_cursorIndexOfEngineTp)) {
              _tmpEngineTp = null;
            } else {
              _tmpEngineTp = _cursor.getString(_cursorIndexOfEngineTp);
            }
            _result.setEngineTp(_tmpEngineTp);
            final String _tmpHotItemx;
            if (_cursor.isNull(_cursorIndexOfHotItemx)) {
              _tmpHotItemx = null;
            } else {
              _tmpHotItemx = _cursor.getString(_cursorIndexOfHotItemx);
            }
            _result.setHotItemx(_tmpHotItemx);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<EMCColor>> GetModelColors(final String ModelID) {
    final String _sql = "SELECT * FROM MC_Model_Color WHERE sModelIDx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Model_Color"}, false, new Callable<List<EMCColor>>() {
      @Override
      public List<EMCColor> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
          final int _cursorIndexOfColorIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sColorIDx");
          final int _cursorIndexOfColorNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sColorNme");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EMCColor> _result = new ArrayList<EMCColor>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMCColor _item;
            _item = new EMCColor();
            final String _tmpModelIDx;
            if (_cursor.isNull(_cursorIndexOfModelIDx)) {
              _tmpModelIDx = null;
            } else {
              _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
            }
            _item.setModelIDx(_tmpModelIDx);
            final String _tmpColorIDx;
            if (_cursor.isNull(_cursorIndexOfColorIDx)) {
              _tmpColorIDx = null;
            } else {
              _tmpColorIDx = _cursor.getString(_cursorIndexOfColorIDx);
            }
            _item.setColorIDx(_tmpColorIDx);
            final String _tmpColorNme;
            if (_cursor.isNull(_cursorIndexOfColorNme)) {
              _tmpColorNme = null;
            } else {
              _tmpColorNme = _cursor.getString(_cursorIndexOfColorNme);
            }
            _item.setColorNme(_tmpColorNme);
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
  public LiveData<List<EGanadoOnline>> GetInquiries() {
    final String _sql = "SELECT * FROM Ganado_Online WHERE sReferdBy = (SELECT sUserIDxx FROM User_Info_Master)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Ganado_Online","User_Info_Master"}, false, new Callable<List<EGanadoOnline>>() {
      @Override
      public List<EGanadoOnline> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfGanadoTp = CursorUtil.getColumnIndexOrThrow(_cursor, "cGanadoTp");
          final int _cursorIndexOfPaymForm = CursorUtil.getColumnIndexOrThrow(_cursor, "cPaymForm");
          final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
          final int _cursorIndexOfClntInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sClntInfo");
          final int _cursorIndexOfProdInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sProdInfo");
          final int _cursorIndexOfPaymInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sPaymInfo");
          final int _cursorIndexOfTargetxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetxx");
          final int _cursorIndexOfFollowUp = CursorUtil.getColumnIndexOrThrow(_cursor, "dFollowUp");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfReferdBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferdBy");
          final int _cursorIndexOfRelatnID = CursorUtil.getColumnIndexOrThrow(_cursor, "sRelatnID");
          final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfLastUpdt = CursorUtil.getColumnIndexOrThrow(_cursor, "dLastUpdt");
          final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EGanadoOnline> _result = new ArrayList<EGanadoOnline>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EGanadoOnline _item;
            _item = new EGanadoOnline();
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
            final String _tmpGanadoTp;
            if (_cursor.isNull(_cursorIndexOfGanadoTp)) {
              _tmpGanadoTp = null;
            } else {
              _tmpGanadoTp = _cursor.getString(_cursorIndexOfGanadoTp);
            }
            _item.setGanadoTp(_tmpGanadoTp);
            final String _tmpPaymForm;
            if (_cursor.isNull(_cursorIndexOfPaymForm)) {
              _tmpPaymForm = null;
            } else {
              _tmpPaymForm = _cursor.getString(_cursorIndexOfPaymForm);
            }
            _item.setPaymForm(_tmpPaymForm);
            final String _tmpClientNm;
            if (_cursor.isNull(_cursorIndexOfClientNm)) {
              _tmpClientNm = null;
            } else {
              _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
            }
            _item.setClientNm(_tmpClientNm);
            final String _tmpClntInfo;
            if (_cursor.isNull(_cursorIndexOfClntInfo)) {
              _tmpClntInfo = null;
            } else {
              _tmpClntInfo = _cursor.getString(_cursorIndexOfClntInfo);
            }
            _item.setClntInfo(_tmpClntInfo);
            final String _tmpProdInfo;
            if (_cursor.isNull(_cursorIndexOfProdInfo)) {
              _tmpProdInfo = null;
            } else {
              _tmpProdInfo = _cursor.getString(_cursorIndexOfProdInfo);
            }
            _item.setProdInfo(_tmpProdInfo);
            final String _tmpPaymInfo;
            if (_cursor.isNull(_cursorIndexOfPaymInfo)) {
              _tmpPaymInfo = null;
            } else {
              _tmpPaymInfo = _cursor.getString(_cursorIndexOfPaymInfo);
            }
            _item.setPaymInfo(_tmpPaymInfo);
            final String _tmpTargetxx;
            if (_cursor.isNull(_cursorIndexOfTargetxx)) {
              _tmpTargetxx = null;
            } else {
              _tmpTargetxx = _cursor.getString(_cursorIndexOfTargetxx);
            }
            _item.setTargetxx(_tmpTargetxx);
            final String _tmpFollowUp;
            if (_cursor.isNull(_cursorIndexOfFollowUp)) {
              _tmpFollowUp = null;
            } else {
              _tmpFollowUp = _cursor.getString(_cursorIndexOfFollowUp);
            }
            _item.setFollowUp(_tmpFollowUp);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpReferdBy;
            if (_cursor.isNull(_cursorIndexOfReferdBy)) {
              _tmpReferdBy = null;
            } else {
              _tmpReferdBy = _cursor.getString(_cursorIndexOfReferdBy);
            }
            _item.setReferdBy(_tmpReferdBy);
            final String _tmpRelatnID;
            if (_cursor.isNull(_cursorIndexOfRelatnID)) {
              _tmpRelatnID = null;
            } else {
              _tmpRelatnID = _cursor.getString(_cursorIndexOfRelatnID);
            }
            _item.setRelatnID(_tmpRelatnID);
            final String _tmpCreatedx;
            if (_cursor.isNull(_cursorIndexOfCreatedx)) {
              _tmpCreatedx = null;
            } else {
              _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
            }
            _item.setCreatedx(_tmpCreatedx);
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
            final String _tmpLastUpdt;
            if (_cursor.isNull(_cursorIndexOfLastUpdt)) {
              _tmpLastUpdt = null;
            } else {
              _tmpLastUpdt = _cursor.getString(_cursorIndexOfLastUpdt);
            }
            _item.setLastUpdt(_tmpLastUpdt);
            final String _tmpBranchCD;
            if (_cursor.isNull(_cursorIndexOfBranchCD)) {
              _tmpBranchCD = null;
            } else {
              _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
            }
            _item.setBranchCD(_tmpBranchCD);
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
  public DGanadoOnline.McInfo GetMCInfo(final String ModelID, final String BrandID,
      final String ColorID) {
    final String _sql = "SELECT a.sModelIDx AS ModelIDx ,a.sModelNme AS ModelNme ,a.sBrandIDx AS BrandIDx,c.sColorIDx AS ColorIDx,c.sColorNme AS ColorNme FROM MC_MODEL a , MC_Model_Color c    ON a.sModelIDx = c.sModelIDx  WHERE a.sModelIDx =? AND a.sBrandIDx =? AND c.sColorIDx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    _argIndex = 2;
    if (BrandID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BrandID);
    }
    _argIndex = 3;
    if (ColorID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ColorID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfModelIDx = 0;
      final int _cursorIndexOfModelNme = 1;
      final int _cursorIndexOfBrandIDx = 2;
      final int _cursorIndexOfColorIDx = 3;
      final int _cursorIndexOfColorNme = 4;
      final DGanadoOnline.McInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new DGanadoOnline.McInfo();
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _result.ModelIDx = null;
        } else {
          _result.ModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        if (_cursor.isNull(_cursorIndexOfModelNme)) {
          _result.ModelNme = null;
        } else {
          _result.ModelNme = _cursor.getString(_cursorIndexOfModelNme);
        }
        if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
          _result.BrandIDx = null;
        } else {
          _result.BrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
        }
        if (_cursor.isNull(_cursorIndexOfColorIDx)) {
          _result.ColorIDx = null;
        } else {
          _result.ColorIDx = _cursor.getString(_cursorIndexOfColorIDx);
        }
        if (_cursor.isNull(_cursorIndexOfColorNme)) {
          _result.ColorNme = null;
        } else {
          _result.ColorNme = _cursor.getString(_cursorIndexOfColorNme);
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
  public DGanadoOnline.McAmortization GetMonthlyPayment(final String ModelID, final int Term) {
    final String _sql = "SELECT  a.nSelPrice, a.nMinDownx, b.nMiscChrg, b.nRebatesx, b.nEndMrtgg, c.nAcctThru, c.nFactorRt FROM Mc_Model_Price a, MC_Category b, MC_Term_Category c, Mc_Model d WHERE a.sMCCatIDx = b.sMCCatIDx AND a.sMCCatIDx = c.sMCCatIDx AND a.sModelIDx = d.sModelIDx AND a.sModelIDx = ? AND c.nAcctThru = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, Term);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfNSelPrice = 0;
      final int _cursorIndexOfNMinDownx = 1;
      final int _cursorIndexOfNMiscChrg = 2;
      final int _cursorIndexOfNRebatesx = 3;
      final int _cursorIndexOfNEndMrtgg = 4;
      final int _cursorIndexOfNAcctThru = 5;
      final int _cursorIndexOfNFactorRt = 6;
      final DGanadoOnline.McAmortization _result;
      if(_cursor.moveToFirst()) {
        _result = new DGanadoOnline.McAmortization();
        if (_cursor.isNull(_cursorIndexOfNSelPrice)) {
          _result.nSelPrice = null;
        } else {
          _result.nSelPrice = _cursor.getString(_cursorIndexOfNSelPrice);
        }
        if (_cursor.isNull(_cursorIndexOfNMinDownx)) {
          _result.nMinDownx = null;
        } else {
          _result.nMinDownx = _cursor.getString(_cursorIndexOfNMinDownx);
        }
        if (_cursor.isNull(_cursorIndexOfNMiscChrg)) {
          _result.nMiscChrg = null;
        } else {
          _result.nMiscChrg = _cursor.getString(_cursorIndexOfNMiscChrg);
        }
        if (_cursor.isNull(_cursorIndexOfNRebatesx)) {
          _result.nRebatesx = null;
        } else {
          _result.nRebatesx = _cursor.getString(_cursorIndexOfNRebatesx);
        }
        if (_cursor.isNull(_cursorIndexOfNEndMrtgg)) {
          _result.nEndMrtgg = null;
        } else {
          _result.nEndMrtgg = _cursor.getString(_cursorIndexOfNEndMrtgg);
        }
        if (_cursor.isNull(_cursorIndexOfNAcctThru)) {
          _result.nAcctThru = null;
        } else {
          _result.nAcctThru = _cursor.getString(_cursorIndexOfNAcctThru);
        }
        if (_cursor.isNull(_cursorIndexOfNFactorRt)) {
          _result.nFactorRt = null;
        } else {
          _result.nFactorRt = _cursor.getString(_cursorIndexOfNFactorRt);
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
  public DGanadoOnline.McDownpayment getDownpayment(final String ModelID) {
    final String _sql = "SELECT  a.sModelIDx AS ModelIDx, a.sModelNme AS ModelNme, b.nMinDownx AS MinDownx, c.nRebatesx AS Rebatesx, c.nMiscChrg AS MiscChrg, c.nEndMrtgg AS EndMrtgg, b.nSelPrice AS SelPrice, b.nLastPrce AS LastPrce FROM Mc_Model a, Mc_Model_Price b, MC_Category c WHERE a.sModelIDx = b.sModelIDx AND b.cRecdStat = '1' AND b.sMCCatIDx = c.sMCCatIDx AND (a.sModelIDx = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfModelIDx = 0;
      final int _cursorIndexOfModelNme = 1;
      final int _cursorIndexOfMinDownx = 2;
      final int _cursorIndexOfRebatesx = 3;
      final int _cursorIndexOfMiscChrg = 4;
      final int _cursorIndexOfEndMrtgg = 5;
      final int _cursorIndexOfSelPrice = 6;
      final int _cursorIndexOfLastPrce = 7;
      final DGanadoOnline.McDownpayment _result;
      if(_cursor.moveToFirst()) {
        _result = new DGanadoOnline.McDownpayment();
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _result.ModelIDx = null;
        } else {
          _result.ModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        if (_cursor.isNull(_cursorIndexOfModelNme)) {
          _result.ModelNme = null;
        } else {
          _result.ModelNme = _cursor.getString(_cursorIndexOfModelNme);
        }
        if (_cursor.isNull(_cursorIndexOfMinDownx)) {
          _result.MinDownx = null;
        } else {
          _result.MinDownx = _cursor.getString(_cursorIndexOfMinDownx);
        }
        if (_cursor.isNull(_cursorIndexOfRebatesx)) {
          _result.Rebatesx = null;
        } else {
          _result.Rebatesx = _cursor.getString(_cursorIndexOfRebatesx);
        }
        if (_cursor.isNull(_cursorIndexOfMiscChrg)) {
          _result.MiscChrg = null;
        } else {
          _result.MiscChrg = _cursor.getString(_cursorIndexOfMiscChrg);
        }
        if (_cursor.isNull(_cursorIndexOfEndMrtgg)) {
          _result.EndMrtgg = null;
        } else {
          _result.EndMrtgg = _cursor.getString(_cursorIndexOfEndMrtgg);
        }
        if (_cursor.isNull(_cursorIndexOfSelPrice)) {
          _result.SelPrice = null;
        } else {
          _result.SelPrice = _cursor.getString(_cursorIndexOfSelPrice);
        }
        if (_cursor.isNull(_cursorIndexOfLastPrce)) {
          _result.LastPrce = null;
        } else {
          _result.LastPrce = _cursor.getString(_cursorIndexOfLastPrce);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
