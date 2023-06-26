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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EBranchLoanApplication;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DBranchLoanApplication_Impl implements DBranchLoanApplication {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EBranchLoanApplication> __insertionAdapterOfEBranchLoanApplication;

  private final EntityInsertionAdapter<EBranchLoanApplication> __insertionAdapterOfEBranchLoanApplication_1;

  private final EntityDeletionOrUpdateAdapter<EBranchLoanApplication> __updateAdapterOfEBranchLoanApplication;

  public DBranchLoanApplication_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEBranchLoanApplication = new EntityInsertionAdapter<EBranchLoanApplication>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Credit_Online_Application_List` (`sTransNox`,`sBranchCD`,`dTransact`,`sCredInvx`,`sCompnyNm`,`sSpouseNm`,`sAddressx`,`sMobileNo`,`sQMAppCde`,`sModelNme`,`nDownPaym`,`nAcctTerm`,`sCreatedx`,`dTimeStmp`,`cTranStat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchLoanApplication value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCD());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getCredInvx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCredInvx());
        }
        if (value.getCompnyNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCompnyNm());
        }
        if (value.getSpouseNm() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSpouseNm());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAddressx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMobileNo());
        }
        if (value.getQMAppCde() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getQMAppCde());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModelNme());
        }
        if (value.getDownPaym() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDownPaym());
        }
        if (value.getAcctTerm() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getAcctTerm());
        }
        if (value.getCreatedX() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatedX());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
      }
    };
    this.__insertionAdapterOfEBranchLoanApplication_1 = new EntityInsertionAdapter<EBranchLoanApplication>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Credit_Online_Application_List` (`sTransNox`,`sBranchCD`,`dTransact`,`sCredInvx`,`sCompnyNm`,`sSpouseNm`,`sAddressx`,`sMobileNo`,`sQMAppCde`,`sModelNme`,`nDownPaym`,`nAcctTerm`,`sCreatedx`,`dTimeStmp`,`cTranStat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchLoanApplication value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCD());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getCredInvx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCredInvx());
        }
        if (value.getCompnyNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCompnyNm());
        }
        if (value.getSpouseNm() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSpouseNm());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAddressx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMobileNo());
        }
        if (value.getQMAppCde() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getQMAppCde());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModelNme());
        }
        if (value.getDownPaym() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDownPaym());
        }
        if (value.getAcctTerm() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getAcctTerm());
        }
        if (value.getCreatedX() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatedX());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
      }
    };
    this.__updateAdapterOfEBranchLoanApplication = new EntityDeletionOrUpdateAdapter<EBranchLoanApplication>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Credit_Online_Application_List` SET `sTransNox` = ?,`sBranchCD` = ?,`dTransact` = ?,`sCredInvx` = ?,`sCompnyNm` = ?,`sSpouseNm` = ?,`sAddressx` = ?,`sMobileNo` = ?,`sQMAppCde` = ?,`sModelNme` = ?,`nDownPaym` = ?,`nAcctTerm` = ?,`sCreatedx` = ?,`dTimeStmp` = ?,`cTranStat` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchLoanApplication value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCD());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getCredInvx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCredInvx());
        }
        if (value.getCompnyNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCompnyNm());
        }
        if (value.getSpouseNm() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSpouseNm());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAddressx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMobileNo());
        }
        if (value.getQMAppCde() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getQMAppCde());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModelNme());
        }
        if (value.getDownPaym() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDownPaym());
        }
        if (value.getAcctTerm() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getAcctTerm());
        }
        if (value.getCreatedX() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatedX());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTransNox());
        }
      }
    };
  }

  @Override
  public void insert(final EBranchLoanApplication branchLoanApplication) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchLoanApplication.insert(branchLoanApplication);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EBranchLoanApplication> branchLoanApplication) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchLoanApplication_1.insert(branchLoanApplication);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertNewApplication(final EBranchLoanApplication loanApplication) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchLoanApplication.insert(loanApplication);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EBranchLoanApplication branchLoanApplication) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEBranchLoanApplication.handle(branchLoanApplication);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<EBranchLoanApplication>> getAllBranchCreditApplication() {
    final String _sql = "SELECT * FROM Credit_Online_Application_List WHERE sBranchCD = (SELECT sBranchCD FROM User_Info_Master) ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_List","User_Info_Master"}, false, new Callable<List<EBranchLoanApplication>>() {
      @Override
      public List<EBranchLoanApplication> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
          final int _cursorIndexOfCompnyNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sCompnyNm");
          final int _cursorIndexOfSpouseNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpouseNm");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
          final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelNme");
          final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
          final int _cursorIndexOfAcctTerm = CursorUtil.getColumnIndexOrThrow(_cursor, "nAcctTerm");
          final int _cursorIndexOfCreatedX = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final List<EBranchLoanApplication> _result = new ArrayList<EBranchLoanApplication>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchLoanApplication _item;
            _item = new EBranchLoanApplication();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpBranchCD;
            if (_cursor.isNull(_cursorIndexOfBranchCD)) {
              _tmpBranchCD = null;
            } else {
              _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
            }
            _item.setBranchCD(_tmpBranchCD);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpCredInvx;
            if (_cursor.isNull(_cursorIndexOfCredInvx)) {
              _tmpCredInvx = null;
            } else {
              _tmpCredInvx = _cursor.getString(_cursorIndexOfCredInvx);
            }
            _item.setCredInvx(_tmpCredInvx);
            final String _tmpCompnyNm;
            if (_cursor.isNull(_cursorIndexOfCompnyNm)) {
              _tmpCompnyNm = null;
            } else {
              _tmpCompnyNm = _cursor.getString(_cursorIndexOfCompnyNm);
            }
            _item.setCompnyNm(_tmpCompnyNm);
            final String _tmpSpouseNm;
            if (_cursor.isNull(_cursorIndexOfSpouseNm)) {
              _tmpSpouseNm = null;
            } else {
              _tmpSpouseNm = _cursor.getString(_cursorIndexOfSpouseNm);
            }
            _item.setSpouseNm(_tmpSpouseNm);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final String _tmpQMAppCde;
            if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
              _tmpQMAppCde = null;
            } else {
              _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
            }
            _item.setQMAppCde(_tmpQMAppCde);
            final String _tmpModelNme;
            if (_cursor.isNull(_cursorIndexOfModelNme)) {
              _tmpModelNme = null;
            } else {
              _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
            }
            _item.setModelNme(_tmpModelNme);
            final String _tmpDownPaym;
            if (_cursor.isNull(_cursorIndexOfDownPaym)) {
              _tmpDownPaym = null;
            } else {
              _tmpDownPaym = _cursor.getString(_cursorIndexOfDownPaym);
            }
            _item.setDownPaym(_tmpDownPaym);
            final String _tmpAcctTerm;
            if (_cursor.isNull(_cursorIndexOfAcctTerm)) {
              _tmpAcctTerm = null;
            } else {
              _tmpAcctTerm = _cursor.getString(_cursorIndexOfAcctTerm);
            }
            _item.setAcctTerm(_tmpAcctTerm);
            final String _tmpCreatedX;
            if (_cursor.isNull(_cursorIndexOfCreatedX)) {
              _tmpCreatedX = null;
            } else {
              _tmpCreatedX = _cursor.getString(_cursorIndexOfCreatedX);
            }
            _item.setCreatedX(_tmpCreatedX);
            final String _tmpTimeStmp;
            if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
              _tmpTimeStmp = null;
            } else {
              _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
            }
            _item.setTimeStmp(_tmpTimeStmp);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
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
  public LiveData<List<DBranchLoanApplication.CIEvaluationList>> getAllCICreditApplicationLog() {
    final String _sql = "SELECT a.sTransNox,a.dTransact,a.sCredInvx,a.sCompnyNm,a.sSpouseNm,a.sAddressx,a.sMobileNo,a.sQMAppCde,a.sModelNme,a.nDownPaym,a.nAcctTerm,a.cTranStat,a.dTimeStmp,b.cTranStat As ciTranStat FROM Credit_Online_Application_List a LEFT JOIN Credit_Online_Application_List_CI b ON a.sTransNox = b.sTransNox  WHERE b.cTranStat <> \"0\" AND b.sCredInvx = (SELECT sEmployID FROM User_Info_Master)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_List","Credit_Online_Application_List_CI","User_Info_Master"}, false, new Callable<List<DBranchLoanApplication.CIEvaluationList>>() {
      @Override
      public List<DBranchLoanApplication.CIEvaluationList> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfDTransact = 1;
          final int _cursorIndexOfSCredInvx = 2;
          final int _cursorIndexOfSCompnyNm = 3;
          final int _cursorIndexOfSSpouseNm = 4;
          final int _cursorIndexOfSAddressx = 5;
          final int _cursorIndexOfSMobileNo = 6;
          final int _cursorIndexOfSQMAppCde = 7;
          final int _cursorIndexOfSModelNme = 8;
          final int _cursorIndexOfNDownPaym = 9;
          final int _cursorIndexOfNAcctTerm = 10;
          final int _cursorIndexOfCTranStat = 11;
          final int _cursorIndexOfDTimeStmp = 12;
          final int _cursorIndexOfCiTranStat = 13;
          final List<DBranchLoanApplication.CIEvaluationList> _result = new ArrayList<DBranchLoanApplication.CIEvaluationList>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DBranchLoanApplication.CIEvaluationList _item;
            _item = new DBranchLoanApplication.CIEvaluationList();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _item.dTransact = null;
            } else {
              _item.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfSCredInvx)) {
              _item.sCredInvx = null;
            } else {
              _item.sCredInvx = _cursor.getString(_cursorIndexOfSCredInvx);
            }
            if (_cursor.isNull(_cursorIndexOfSCompnyNm)) {
              _item.sCompnyNm = null;
            } else {
              _item.sCompnyNm = _cursor.getString(_cursorIndexOfSCompnyNm);
            }
            if (_cursor.isNull(_cursorIndexOfSSpouseNm)) {
              _item.sSpouseNm = null;
            } else {
              _item.sSpouseNm = _cursor.getString(_cursorIndexOfSSpouseNm);
            }
            if (_cursor.isNull(_cursorIndexOfSAddressx)) {
              _item.sAddressx = null;
            } else {
              _item.sAddressx = _cursor.getString(_cursorIndexOfSAddressx);
            }
            if (_cursor.isNull(_cursorIndexOfSMobileNo)) {
              _item.sMobileNo = null;
            } else {
              _item.sMobileNo = _cursor.getString(_cursorIndexOfSMobileNo);
            }
            if (_cursor.isNull(_cursorIndexOfSQMAppCde)) {
              _item.sQMAppCde = null;
            } else {
              _item.sQMAppCde = _cursor.getString(_cursorIndexOfSQMAppCde);
            }
            if (_cursor.isNull(_cursorIndexOfSModelNme)) {
              _item.sModelNme = null;
            } else {
              _item.sModelNme = _cursor.getString(_cursorIndexOfSModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfNDownPaym)) {
              _item.nDownPaym = null;
            } else {
              _item.nDownPaym = _cursor.getString(_cursorIndexOfNDownPaym);
            }
            if (_cursor.isNull(_cursorIndexOfNAcctTerm)) {
              _item.nAcctTerm = null;
            } else {
              _item.nAcctTerm = _cursor.getString(_cursorIndexOfNAcctTerm);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            if (_cursor.isNull(_cursorIndexOfDTimeStmp)) {
              _item.dTimeStmp = null;
            } else {
              _item.dTimeStmp = _cursor.getString(_cursorIndexOfDTimeStmp);
            }
            if (_cursor.isNull(_cursorIndexOfCiTranStat)) {
              _item.ciTranStat = null;
            } else {
              _item.ciTranStat = _cursor.getString(_cursorIndexOfCiTranStat);
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
  public List<EBranchLoanApplication> getDuplicateTransNox(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Online_Application_List WHERE sTransNox =? ";
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
      final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
      final int _cursorIndexOfCompnyNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sCompnyNm");
      final int _cursorIndexOfSpouseNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpouseNm");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
      final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelNme");
      final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
      final int _cursorIndexOfAcctTerm = CursorUtil.getColumnIndexOrThrow(_cursor, "nAcctTerm");
      final int _cursorIndexOfCreatedX = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final List<EBranchLoanApplication> _result = new ArrayList<EBranchLoanApplication>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EBranchLoanApplication _item;
        _item = new EBranchLoanApplication();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpBranchCD;
        if (_cursor.isNull(_cursorIndexOfBranchCD)) {
          _tmpBranchCD = null;
        } else {
          _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
        }
        _item.setBranchCD(_tmpBranchCD);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpCredInvx;
        if (_cursor.isNull(_cursorIndexOfCredInvx)) {
          _tmpCredInvx = null;
        } else {
          _tmpCredInvx = _cursor.getString(_cursorIndexOfCredInvx);
        }
        _item.setCredInvx(_tmpCredInvx);
        final String _tmpCompnyNm;
        if (_cursor.isNull(_cursorIndexOfCompnyNm)) {
          _tmpCompnyNm = null;
        } else {
          _tmpCompnyNm = _cursor.getString(_cursorIndexOfCompnyNm);
        }
        _item.setCompnyNm(_tmpCompnyNm);
        final String _tmpSpouseNm;
        if (_cursor.isNull(_cursorIndexOfSpouseNm)) {
          _tmpSpouseNm = null;
        } else {
          _tmpSpouseNm = _cursor.getString(_cursorIndexOfSpouseNm);
        }
        _item.setSpouseNm(_tmpSpouseNm);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _item.setMobileNo(_tmpMobileNo);
        final String _tmpQMAppCde;
        if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
          _tmpQMAppCde = null;
        } else {
          _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
        }
        _item.setQMAppCde(_tmpQMAppCde);
        final String _tmpModelNme;
        if (_cursor.isNull(_cursorIndexOfModelNme)) {
          _tmpModelNme = null;
        } else {
          _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
        }
        _item.setModelNme(_tmpModelNme);
        final String _tmpDownPaym;
        if (_cursor.isNull(_cursorIndexOfDownPaym)) {
          _tmpDownPaym = null;
        } else {
          _tmpDownPaym = _cursor.getString(_cursorIndexOfDownPaym);
        }
        _item.setDownPaym(_tmpDownPaym);
        final String _tmpAcctTerm;
        if (_cursor.isNull(_cursorIndexOfAcctTerm)) {
          _tmpAcctTerm = null;
        } else {
          _tmpAcctTerm = _cursor.getString(_cursorIndexOfAcctTerm);
        }
        _item.setAcctTerm(_tmpAcctTerm);
        final String _tmpCreatedX;
        if (_cursor.isNull(_cursorIndexOfCreatedX)) {
          _tmpCreatedX = null;
        } else {
          _tmpCreatedX = _cursor.getString(_cursorIndexOfCreatedX);
        }
        _item.setCreatedX(_tmpCreatedX);
        final String _tmpTimeStmp;
        if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
          _tmpTimeStmp = null;
        } else {
          _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
        }
        _item.setTimeStmp(_tmpTimeStmp);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<DBranchLoanApplication.CIEvaluationList>> getAllCICreditApplications() {
    final String _sql = "SELECT a.sTransNox,a.dTransact,a.sCredInvx,a.sCompnyNm,a.sSpouseNm,a.sAddressx,a.sMobileNo,a.sQMAppCde,a.sModelNme,a.nDownPaym,a.nAcctTerm,a.cTranStat,a.dTimeStmp,b.cTranStat AS ciTranStat FROM Credit_Online_Application_List a LEFT JOIN Credit_Online_Application_List_CI b ON a.sTransNox = b.sTransNox WHERE a.cTranStat = 1 AND COALESCE(b.cTranStat, NULL) IS NULL OR ciTranStat = 0 ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_List","Credit_Online_Application_List_CI"}, false, new Callable<List<DBranchLoanApplication.CIEvaluationList>>() {
      @Override
      public List<DBranchLoanApplication.CIEvaluationList> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfDTransact = 1;
          final int _cursorIndexOfSCredInvx = 2;
          final int _cursorIndexOfSCompnyNm = 3;
          final int _cursorIndexOfSSpouseNm = 4;
          final int _cursorIndexOfSAddressx = 5;
          final int _cursorIndexOfSMobileNo = 6;
          final int _cursorIndexOfSQMAppCde = 7;
          final int _cursorIndexOfSModelNme = 8;
          final int _cursorIndexOfNDownPaym = 9;
          final int _cursorIndexOfNAcctTerm = 10;
          final int _cursorIndexOfCTranStat = 11;
          final int _cursorIndexOfDTimeStmp = 12;
          final int _cursorIndexOfCiTranStat = 13;
          final List<DBranchLoanApplication.CIEvaluationList> _result = new ArrayList<DBranchLoanApplication.CIEvaluationList>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DBranchLoanApplication.CIEvaluationList _item;
            _item = new DBranchLoanApplication.CIEvaluationList();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _item.dTransact = null;
            } else {
              _item.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfSCredInvx)) {
              _item.sCredInvx = null;
            } else {
              _item.sCredInvx = _cursor.getString(_cursorIndexOfSCredInvx);
            }
            if (_cursor.isNull(_cursorIndexOfSCompnyNm)) {
              _item.sCompnyNm = null;
            } else {
              _item.sCompnyNm = _cursor.getString(_cursorIndexOfSCompnyNm);
            }
            if (_cursor.isNull(_cursorIndexOfSSpouseNm)) {
              _item.sSpouseNm = null;
            } else {
              _item.sSpouseNm = _cursor.getString(_cursorIndexOfSSpouseNm);
            }
            if (_cursor.isNull(_cursorIndexOfSAddressx)) {
              _item.sAddressx = null;
            } else {
              _item.sAddressx = _cursor.getString(_cursorIndexOfSAddressx);
            }
            if (_cursor.isNull(_cursorIndexOfSMobileNo)) {
              _item.sMobileNo = null;
            } else {
              _item.sMobileNo = _cursor.getString(_cursorIndexOfSMobileNo);
            }
            if (_cursor.isNull(_cursorIndexOfSQMAppCde)) {
              _item.sQMAppCde = null;
            } else {
              _item.sQMAppCde = _cursor.getString(_cursorIndexOfSQMAppCde);
            }
            if (_cursor.isNull(_cursorIndexOfSModelNme)) {
              _item.sModelNme = null;
            } else {
              _item.sModelNme = _cursor.getString(_cursorIndexOfSModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfNDownPaym)) {
              _item.nDownPaym = null;
            } else {
              _item.nDownPaym = _cursor.getString(_cursorIndexOfNDownPaym);
            }
            if (_cursor.isNull(_cursorIndexOfNAcctTerm)) {
              _item.nAcctTerm = null;
            } else {
              _item.nAcctTerm = _cursor.getString(_cursorIndexOfNAcctTerm);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            if (_cursor.isNull(_cursorIndexOfDTimeStmp)) {
              _item.dTimeStmp = null;
            } else {
              _item.dTimeStmp = _cursor.getString(_cursorIndexOfDTimeStmp);
            }
            if (_cursor.isNull(_cursorIndexOfCiTranStat)) {
              _item.ciTranStat = null;
            } else {
              _item.ciTranStat = _cursor.getString(_cursorIndexOfCiTranStat);
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
  public LiveData<DBranchLoanApplication.CiDetail> getCiDetail(final String fsTransNo) {
    final String _sql = "SELECT I.sFileLoct, C.sTransNox, C.sCompnyNm, C.sModelNme, C.nDownPaym, C.nAcctTerm FROM Credit_Online_Application_List AS C LEFT JOIN Image_Information AS I ON C.sTransNox = I.sDtlSrcNo WHERE C.sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsTransNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsTransNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_List","Image_Information"}, false, new Callable<DBranchLoanApplication.CiDetail>() {
      @Override
      public DBranchLoanApplication.CiDetail call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSFileLoct = 0;
          final int _cursorIndexOfSTransNox = 1;
          final int _cursorIndexOfSCompnyNm = 2;
          final int _cursorIndexOfSModelNme = 3;
          final int _cursorIndexOfNDownPaym = 4;
          final int _cursorIndexOfNAcctTerm = 5;
          final DBranchLoanApplication.CiDetail _result;
          if(_cursor.moveToFirst()) {
            _result = new DBranchLoanApplication.CiDetail();
            if (_cursor.isNull(_cursorIndexOfSFileLoct)) {
              _result.sFileLoct = null;
            } else {
              _result.sFileLoct = _cursor.getString(_cursorIndexOfSFileLoct);
            }
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _result.sTransNox = null;
            } else {
              _result.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSCompnyNm)) {
              _result.sCompnyNm = null;
            } else {
              _result.sCompnyNm = _cursor.getString(_cursorIndexOfSCompnyNm);
            }
            if (_cursor.isNull(_cursorIndexOfSModelNme)) {
              _result.sModelNme = null;
            } else {
              _result.sModelNme = _cursor.getString(_cursorIndexOfSModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfNDownPaym)) {
              _result.nDownPaym = null;
            } else {
              _result.nDownPaym = _cursor.getString(_cursorIndexOfNDownPaym);
            }
            if (_cursor.isNull(_cursorIndexOfNAcctTerm)) {
              _result.nAcctTerm = null;
            } else {
              _result.nAcctTerm = _cursor.getString(_cursorIndexOfNAcctTerm);
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
