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
import org.rmj.g3appdriver.GCircle.room.Entities.ECreditApplicantInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DCreditApplicantInfo_Impl implements DCreditApplicantInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ECreditApplicantInfo> __insertionAdapterOfECreditApplicantInfo;

  private final EntityDeletionOrUpdateAdapter<ECreditApplicantInfo> __updateAdapterOfECreditApplicantInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateApplicantResidenceInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateOtherInfo;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllCreditApp;

  public DCreditApplicantInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfECreditApplicantInfo = new EntityInsertionAdapter<ECreditApplicantInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Credit_Applicant_Info` (`sTransNox`,`sClientNm`,`sDetlInfo`,`sPurchase`,`sApplInfo`,`sResidnce`,`cSameAddx`,`sAppMeans`,`sEmplymnt`,`sBusnInfo`,`sFinancex`,`sPensionx`,`sOtherInc`,`sSpousexx`,`sSpsResdx`,`sSpsMEans`,`sSpsEmplx`,`sSpsBusnx`,`sSpsPensn`,`sSpOthInc`,`sDisbrsmt`,`sDependnt`,`sProperty`,`sOthrInfo`,`sComakerx`,`sCmResidx`,`cIsSpouse`,`cIsComakr`,`sBranchCd`,`cAppliedx`,`dTransact`,`dCreatedx`,`nDownPaym`,`cTranStat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECreditApplicantInfo value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClientNm());
        }
        if (value.getDetlInfo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDetlInfo());
        }
        if (value.getPurchase() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPurchase());
        }
        if (value.getApplInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getApplInfo());
        }
        if (value.getResidnce() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getResidnce());
        }
        if (value.getSameAddx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSameAddx());
        }
        if (value.getAppMeans() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAppMeans());
        }
        if (value.getEmplymnt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getEmplymnt());
        }
        if (value.getBusnInfo() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBusnInfo());
        }
        if (value.getFinancex() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFinancex());
        }
        if (value.getPensionx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPensionx());
        }
        if (value.getOtherInc() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getOtherInc());
        }
        if (value.getSpousexx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSpousexx());
        }
        if (value.getSpsResdx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSpsResdx());
        }
        if (value.getSpsMeans() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSpsMeans());
        }
        if (value.getSpsEmplx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSpsEmplx());
        }
        if (value.getSpsBusnx() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getSpsBusnx());
        }
        if (value.getSpsPensn() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getSpsPensn());
        }
        if (value.getSpOthInc() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getSpOthInc());
        }
        if (value.getDisbrsmt() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getDisbrsmt());
        }
        if (value.getDependnt() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDependnt());
        }
        if (value.getProperty() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getProperty());
        }
        if (value.getOthrInfo() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getOthrInfo());
        }
        if (value.getComakerx() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getComakerx());
        }
        if (value.getCmResidx() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getCmResidx());
        }
        if (value.getIsSpouse() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getIsSpouse());
        }
        if (value.getIsComakr() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getIsComakr());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getBranchCd());
        }
        if (value.getAppliedx() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getAppliedx());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getTransact());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getCreatedx());
        }
        stmt.bindDouble(33, value.getDownPaym());
        if (value.getTranStat() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getTranStat());
        }
      }
    };
    this.__updateAdapterOfECreditApplicantInfo = new EntityDeletionOrUpdateAdapter<ECreditApplicantInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Credit_Applicant_Info` SET `sTransNox` = ?,`sClientNm` = ?,`sDetlInfo` = ?,`sPurchase` = ?,`sApplInfo` = ?,`sResidnce` = ?,`cSameAddx` = ?,`sAppMeans` = ?,`sEmplymnt` = ?,`sBusnInfo` = ?,`sFinancex` = ?,`sPensionx` = ?,`sOtherInc` = ?,`sSpousexx` = ?,`sSpsResdx` = ?,`sSpsMEans` = ?,`sSpsEmplx` = ?,`sSpsBusnx` = ?,`sSpsPensn` = ?,`sSpOthInc` = ?,`sDisbrsmt` = ?,`sDependnt` = ?,`sProperty` = ?,`sOthrInfo` = ?,`sComakerx` = ?,`sCmResidx` = ?,`cIsSpouse` = ?,`cIsComakr` = ?,`sBranchCd` = ?,`cAppliedx` = ?,`dTransact` = ?,`dCreatedx` = ?,`nDownPaym` = ?,`cTranStat` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECreditApplicantInfo value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClientNm());
        }
        if (value.getDetlInfo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDetlInfo());
        }
        if (value.getPurchase() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPurchase());
        }
        if (value.getApplInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getApplInfo());
        }
        if (value.getResidnce() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getResidnce());
        }
        if (value.getSameAddx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSameAddx());
        }
        if (value.getAppMeans() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAppMeans());
        }
        if (value.getEmplymnt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getEmplymnt());
        }
        if (value.getBusnInfo() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBusnInfo());
        }
        if (value.getFinancex() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFinancex());
        }
        if (value.getPensionx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPensionx());
        }
        if (value.getOtherInc() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getOtherInc());
        }
        if (value.getSpousexx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSpousexx());
        }
        if (value.getSpsResdx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSpsResdx());
        }
        if (value.getSpsMeans() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSpsMeans());
        }
        if (value.getSpsEmplx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSpsEmplx());
        }
        if (value.getSpsBusnx() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getSpsBusnx());
        }
        if (value.getSpsPensn() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getSpsPensn());
        }
        if (value.getSpOthInc() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getSpOthInc());
        }
        if (value.getDisbrsmt() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getDisbrsmt());
        }
        if (value.getDependnt() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDependnt());
        }
        if (value.getProperty() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getProperty());
        }
        if (value.getOthrInfo() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getOthrInfo());
        }
        if (value.getComakerx() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getComakerx());
        }
        if (value.getCmResidx() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getCmResidx());
        }
        if (value.getIsSpouse() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getIsSpouse());
        }
        if (value.getIsComakr() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getIsComakr());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getBranchCd());
        }
        if (value.getAppliedx() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getAppliedx());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getTransact());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getCreatedx());
        }
        stmt.bindDouble(33, value.getDownPaym());
        if (value.getTranStat() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getTranStat());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateApplicantResidenceInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Applicant_Info SET sResidnce =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateOtherInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Applicant_Info SET sOthrInfo =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllCreditApp = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Credit_Applicant_Info";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ECreditApplicantInfo creditApplicantInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECreditApplicantInfo.insert(creditApplicantInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ECreditApplicantInfo creditApplicantInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfECreditApplicantInfo.handle(creditApplicantInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateApplicantResidenceInfo(final String TransNox, final String Residence) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateApplicantResidenceInfo.acquire();
    int _argIndex = 1;
    if (Residence == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Residence);
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
      __preparedStmtOfUpdateApplicantResidenceInfo.release(_stmt);
    }
  }

  @Override
  public void updateOtherInfo(final String TransNox, final String OtherInfo) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateOtherInfo.acquire();
    int _argIndex = 1;
    if (OtherInfo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, OtherInfo);
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
      __preparedStmtOfUpdateOtherInfo.release(_stmt);
    }
  }

  @Override
  public void deleteAllCreditApp() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllCreditApp.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllCreditApp.release(_stmt);
    }
  }

  @Override
  public LiveData<ECreditApplicantInfo> getCreditApplicantInfo(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Applicant_Info WHERE sTransNox = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Applicant_Info"}, false, new Callable<ECreditApplicantInfo>() {
      @Override
      public ECreditApplicantInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
          final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurchase");
          final int _cursorIndexOfApplInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sApplInfo");
          final int _cursorIndexOfResidnce = CursorUtil.getColumnIndexOrThrow(_cursor, "sResidnce");
          final int _cursorIndexOfSameAddx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSameAddx");
          final int _cursorIndexOfAppMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppMeans");
          final int _cursorIndexOfEmplymnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmplymnt");
          final int _cursorIndexOfBusnInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sBusnInfo");
          final int _cursorIndexOfFinancex = CursorUtil.getColumnIndexOrThrow(_cursor, "sFinancex");
          final int _cursorIndexOfPensionx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPensionx");
          final int _cursorIndexOfOtherInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sOtherInc");
          final int _cursorIndexOfSpousexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpousexx");
          final int _cursorIndexOfSpsResdx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsResdx");
          final int _cursorIndexOfSpsMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsMEans");
          final int _cursorIndexOfSpsEmplx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsEmplx");
          final int _cursorIndexOfSpsBusnx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsBusnx");
          final int _cursorIndexOfSpsPensn = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsPensn");
          final int _cursorIndexOfSpOthInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpOthInc");
          final int _cursorIndexOfDisbrsmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDisbrsmt");
          final int _cursorIndexOfDependnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDependnt");
          final int _cursorIndexOfProperty = CursorUtil.getColumnIndexOrThrow(_cursor, "sProperty");
          final int _cursorIndexOfOthrInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sOthrInfo");
          final int _cursorIndexOfComakerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sComakerx");
          final int _cursorIndexOfCmResidx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCmResidx");
          final int _cursorIndexOfIsSpouse = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsSpouse");
          final int _cursorIndexOfIsComakr = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsComakr");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfAppliedx = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppliedx");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
          final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final ECreditApplicantInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new ECreditApplicantInfo();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpClientNm;
            if (_cursor.isNull(_cursorIndexOfClientNm)) {
              _tmpClientNm = null;
            } else {
              _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
            }
            _result.setClientNm(_tmpClientNm);
            final String _tmpDetlInfo;
            if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
              _tmpDetlInfo = null;
            } else {
              _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
            }
            _result.setDetlInfo(_tmpDetlInfo);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _result.setPurchase(_tmpPurchase);
            final String _tmpApplInfo;
            if (_cursor.isNull(_cursorIndexOfApplInfo)) {
              _tmpApplInfo = null;
            } else {
              _tmpApplInfo = _cursor.getString(_cursorIndexOfApplInfo);
            }
            _result.setApplInfo(_tmpApplInfo);
            final String _tmpResidnce;
            if (_cursor.isNull(_cursorIndexOfResidnce)) {
              _tmpResidnce = null;
            } else {
              _tmpResidnce = _cursor.getString(_cursorIndexOfResidnce);
            }
            _result.setResidnce(_tmpResidnce);
            final String _tmpSameAddx;
            if (_cursor.isNull(_cursorIndexOfSameAddx)) {
              _tmpSameAddx = null;
            } else {
              _tmpSameAddx = _cursor.getString(_cursorIndexOfSameAddx);
            }
            _result.setSameAddx(_tmpSameAddx);
            final String _tmpAppMeans;
            if (_cursor.isNull(_cursorIndexOfAppMeans)) {
              _tmpAppMeans = null;
            } else {
              _tmpAppMeans = _cursor.getString(_cursorIndexOfAppMeans);
            }
            _result.setAppMeans(_tmpAppMeans);
            final String _tmpEmplymnt;
            if (_cursor.isNull(_cursorIndexOfEmplymnt)) {
              _tmpEmplymnt = null;
            } else {
              _tmpEmplymnt = _cursor.getString(_cursorIndexOfEmplymnt);
            }
            _result.setEmplymnt(_tmpEmplymnt);
            final String _tmpBusnInfo;
            if (_cursor.isNull(_cursorIndexOfBusnInfo)) {
              _tmpBusnInfo = null;
            } else {
              _tmpBusnInfo = _cursor.getString(_cursorIndexOfBusnInfo);
            }
            _result.setBusnInfo(_tmpBusnInfo);
            final String _tmpFinancex;
            if (_cursor.isNull(_cursorIndexOfFinancex)) {
              _tmpFinancex = null;
            } else {
              _tmpFinancex = _cursor.getString(_cursorIndexOfFinancex);
            }
            _result.setFinancex(_tmpFinancex);
            final String _tmpPensionx;
            if (_cursor.isNull(_cursorIndexOfPensionx)) {
              _tmpPensionx = null;
            } else {
              _tmpPensionx = _cursor.getString(_cursorIndexOfPensionx);
            }
            _result.setPensionx(_tmpPensionx);
            final String _tmpOtherInc;
            if (_cursor.isNull(_cursorIndexOfOtherInc)) {
              _tmpOtherInc = null;
            } else {
              _tmpOtherInc = _cursor.getString(_cursorIndexOfOtherInc);
            }
            _result.setOtherInc(_tmpOtherInc);
            final String _tmpSpousexx;
            if (_cursor.isNull(_cursorIndexOfSpousexx)) {
              _tmpSpousexx = null;
            } else {
              _tmpSpousexx = _cursor.getString(_cursorIndexOfSpousexx);
            }
            _result.setSpousexx(_tmpSpousexx);
            final String _tmpSpsResdx;
            if (_cursor.isNull(_cursorIndexOfSpsResdx)) {
              _tmpSpsResdx = null;
            } else {
              _tmpSpsResdx = _cursor.getString(_cursorIndexOfSpsResdx);
            }
            _result.setSpsResdx(_tmpSpsResdx);
            final String _tmpSpsMeans;
            if (_cursor.isNull(_cursorIndexOfSpsMeans)) {
              _tmpSpsMeans = null;
            } else {
              _tmpSpsMeans = _cursor.getString(_cursorIndexOfSpsMeans);
            }
            _result.setSpsMeans(_tmpSpsMeans);
            final String _tmpSpsEmplx;
            if (_cursor.isNull(_cursorIndexOfSpsEmplx)) {
              _tmpSpsEmplx = null;
            } else {
              _tmpSpsEmplx = _cursor.getString(_cursorIndexOfSpsEmplx);
            }
            _result.setSpsEmplx(_tmpSpsEmplx);
            final String _tmpSpsBusnx;
            if (_cursor.isNull(_cursorIndexOfSpsBusnx)) {
              _tmpSpsBusnx = null;
            } else {
              _tmpSpsBusnx = _cursor.getString(_cursorIndexOfSpsBusnx);
            }
            _result.setSpsBusnx(_tmpSpsBusnx);
            final String _tmpSpsPensn;
            if (_cursor.isNull(_cursorIndexOfSpsPensn)) {
              _tmpSpsPensn = null;
            } else {
              _tmpSpsPensn = _cursor.getString(_cursorIndexOfSpsPensn);
            }
            _result.setSpsPensn(_tmpSpsPensn);
            final String _tmpSpOthInc;
            if (_cursor.isNull(_cursorIndexOfSpOthInc)) {
              _tmpSpOthInc = null;
            } else {
              _tmpSpOthInc = _cursor.getString(_cursorIndexOfSpOthInc);
            }
            _result.setSpOthInc(_tmpSpOthInc);
            final String _tmpDisbrsmt;
            if (_cursor.isNull(_cursorIndexOfDisbrsmt)) {
              _tmpDisbrsmt = null;
            } else {
              _tmpDisbrsmt = _cursor.getString(_cursorIndexOfDisbrsmt);
            }
            _result.setDisbrsmt(_tmpDisbrsmt);
            final String _tmpDependnt;
            if (_cursor.isNull(_cursorIndexOfDependnt)) {
              _tmpDependnt = null;
            } else {
              _tmpDependnt = _cursor.getString(_cursorIndexOfDependnt);
            }
            _result.setDependnt(_tmpDependnt);
            final String _tmpProperty;
            if (_cursor.isNull(_cursorIndexOfProperty)) {
              _tmpProperty = null;
            } else {
              _tmpProperty = _cursor.getString(_cursorIndexOfProperty);
            }
            _result.setProperty(_tmpProperty);
            final String _tmpOthrInfo;
            if (_cursor.isNull(_cursorIndexOfOthrInfo)) {
              _tmpOthrInfo = null;
            } else {
              _tmpOthrInfo = _cursor.getString(_cursorIndexOfOthrInfo);
            }
            _result.setOthrInfo(_tmpOthrInfo);
            final String _tmpComakerx;
            if (_cursor.isNull(_cursorIndexOfComakerx)) {
              _tmpComakerx = null;
            } else {
              _tmpComakerx = _cursor.getString(_cursorIndexOfComakerx);
            }
            _result.setComakerx(_tmpComakerx);
            final String _tmpCmResidx;
            if (_cursor.isNull(_cursorIndexOfCmResidx)) {
              _tmpCmResidx = null;
            } else {
              _tmpCmResidx = _cursor.getString(_cursorIndexOfCmResidx);
            }
            _result.setCmResidx(_tmpCmResidx);
            final String _tmpIsSpouse;
            if (_cursor.isNull(_cursorIndexOfIsSpouse)) {
              _tmpIsSpouse = null;
            } else {
              _tmpIsSpouse = _cursor.getString(_cursorIndexOfIsSpouse);
            }
            _result.setIsSpouse(_tmpIsSpouse);
            final String _tmpIsComakr;
            if (_cursor.isNull(_cursorIndexOfIsComakr)) {
              _tmpIsComakr = null;
            } else {
              _tmpIsComakr = _cursor.getString(_cursorIndexOfIsComakr);
            }
            _result.setIsComakr(_tmpIsComakr);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpAppliedx;
            if (_cursor.isNull(_cursorIndexOfAppliedx)) {
              _tmpAppliedx = null;
            } else {
              _tmpAppliedx = _cursor.getString(_cursorIndexOfAppliedx);
            }
            _result.setAppliedx(_tmpAppliedx);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _result.setTransact(_tmpTransact);
            final String _tmpCreatedx;
            if (_cursor.isNull(_cursorIndexOfCreatedx)) {
              _tmpCreatedx = null;
            } else {
              _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
            }
            _result.setCreatedx(_tmpCreatedx);
            final double _tmpDownPaym;
            _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
            _result.setDownPaym(_tmpDownPaym);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
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
  public LiveData<List<ECreditApplicantInfo>> getCreditApplicantList() {
    final String _sql = "SELECT * FROM Credit_Applicant_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Applicant_Info"}, false, new Callable<List<ECreditApplicantInfo>>() {
      @Override
      public List<ECreditApplicantInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
          final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurchase");
          final int _cursorIndexOfApplInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sApplInfo");
          final int _cursorIndexOfResidnce = CursorUtil.getColumnIndexOrThrow(_cursor, "sResidnce");
          final int _cursorIndexOfSameAddx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSameAddx");
          final int _cursorIndexOfAppMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppMeans");
          final int _cursorIndexOfEmplymnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmplymnt");
          final int _cursorIndexOfBusnInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sBusnInfo");
          final int _cursorIndexOfFinancex = CursorUtil.getColumnIndexOrThrow(_cursor, "sFinancex");
          final int _cursorIndexOfPensionx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPensionx");
          final int _cursorIndexOfOtherInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sOtherInc");
          final int _cursorIndexOfSpousexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpousexx");
          final int _cursorIndexOfSpsResdx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsResdx");
          final int _cursorIndexOfSpsMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsMEans");
          final int _cursorIndexOfSpsEmplx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsEmplx");
          final int _cursorIndexOfSpsBusnx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsBusnx");
          final int _cursorIndexOfSpsPensn = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsPensn");
          final int _cursorIndexOfSpOthInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpOthInc");
          final int _cursorIndexOfDisbrsmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDisbrsmt");
          final int _cursorIndexOfDependnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDependnt");
          final int _cursorIndexOfProperty = CursorUtil.getColumnIndexOrThrow(_cursor, "sProperty");
          final int _cursorIndexOfOthrInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sOthrInfo");
          final int _cursorIndexOfComakerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sComakerx");
          final int _cursorIndexOfCmResidx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCmResidx");
          final int _cursorIndexOfIsSpouse = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsSpouse");
          final int _cursorIndexOfIsComakr = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsComakr");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfAppliedx = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppliedx");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
          final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final List<ECreditApplicantInfo> _result = new ArrayList<ECreditApplicantInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ECreditApplicantInfo _item;
            _item = new ECreditApplicantInfo();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpClientNm;
            if (_cursor.isNull(_cursorIndexOfClientNm)) {
              _tmpClientNm = null;
            } else {
              _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
            }
            _item.setClientNm(_tmpClientNm);
            final String _tmpDetlInfo;
            if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
              _tmpDetlInfo = null;
            } else {
              _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
            }
            _item.setDetlInfo(_tmpDetlInfo);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _item.setPurchase(_tmpPurchase);
            final String _tmpApplInfo;
            if (_cursor.isNull(_cursorIndexOfApplInfo)) {
              _tmpApplInfo = null;
            } else {
              _tmpApplInfo = _cursor.getString(_cursorIndexOfApplInfo);
            }
            _item.setApplInfo(_tmpApplInfo);
            final String _tmpResidnce;
            if (_cursor.isNull(_cursorIndexOfResidnce)) {
              _tmpResidnce = null;
            } else {
              _tmpResidnce = _cursor.getString(_cursorIndexOfResidnce);
            }
            _item.setResidnce(_tmpResidnce);
            final String _tmpSameAddx;
            if (_cursor.isNull(_cursorIndexOfSameAddx)) {
              _tmpSameAddx = null;
            } else {
              _tmpSameAddx = _cursor.getString(_cursorIndexOfSameAddx);
            }
            _item.setSameAddx(_tmpSameAddx);
            final String _tmpAppMeans;
            if (_cursor.isNull(_cursorIndexOfAppMeans)) {
              _tmpAppMeans = null;
            } else {
              _tmpAppMeans = _cursor.getString(_cursorIndexOfAppMeans);
            }
            _item.setAppMeans(_tmpAppMeans);
            final String _tmpEmplymnt;
            if (_cursor.isNull(_cursorIndexOfEmplymnt)) {
              _tmpEmplymnt = null;
            } else {
              _tmpEmplymnt = _cursor.getString(_cursorIndexOfEmplymnt);
            }
            _item.setEmplymnt(_tmpEmplymnt);
            final String _tmpBusnInfo;
            if (_cursor.isNull(_cursorIndexOfBusnInfo)) {
              _tmpBusnInfo = null;
            } else {
              _tmpBusnInfo = _cursor.getString(_cursorIndexOfBusnInfo);
            }
            _item.setBusnInfo(_tmpBusnInfo);
            final String _tmpFinancex;
            if (_cursor.isNull(_cursorIndexOfFinancex)) {
              _tmpFinancex = null;
            } else {
              _tmpFinancex = _cursor.getString(_cursorIndexOfFinancex);
            }
            _item.setFinancex(_tmpFinancex);
            final String _tmpPensionx;
            if (_cursor.isNull(_cursorIndexOfPensionx)) {
              _tmpPensionx = null;
            } else {
              _tmpPensionx = _cursor.getString(_cursorIndexOfPensionx);
            }
            _item.setPensionx(_tmpPensionx);
            final String _tmpOtherInc;
            if (_cursor.isNull(_cursorIndexOfOtherInc)) {
              _tmpOtherInc = null;
            } else {
              _tmpOtherInc = _cursor.getString(_cursorIndexOfOtherInc);
            }
            _item.setOtherInc(_tmpOtherInc);
            final String _tmpSpousexx;
            if (_cursor.isNull(_cursorIndexOfSpousexx)) {
              _tmpSpousexx = null;
            } else {
              _tmpSpousexx = _cursor.getString(_cursorIndexOfSpousexx);
            }
            _item.setSpousexx(_tmpSpousexx);
            final String _tmpSpsResdx;
            if (_cursor.isNull(_cursorIndexOfSpsResdx)) {
              _tmpSpsResdx = null;
            } else {
              _tmpSpsResdx = _cursor.getString(_cursorIndexOfSpsResdx);
            }
            _item.setSpsResdx(_tmpSpsResdx);
            final String _tmpSpsMeans;
            if (_cursor.isNull(_cursorIndexOfSpsMeans)) {
              _tmpSpsMeans = null;
            } else {
              _tmpSpsMeans = _cursor.getString(_cursorIndexOfSpsMeans);
            }
            _item.setSpsMeans(_tmpSpsMeans);
            final String _tmpSpsEmplx;
            if (_cursor.isNull(_cursorIndexOfSpsEmplx)) {
              _tmpSpsEmplx = null;
            } else {
              _tmpSpsEmplx = _cursor.getString(_cursorIndexOfSpsEmplx);
            }
            _item.setSpsEmplx(_tmpSpsEmplx);
            final String _tmpSpsBusnx;
            if (_cursor.isNull(_cursorIndexOfSpsBusnx)) {
              _tmpSpsBusnx = null;
            } else {
              _tmpSpsBusnx = _cursor.getString(_cursorIndexOfSpsBusnx);
            }
            _item.setSpsBusnx(_tmpSpsBusnx);
            final String _tmpSpsPensn;
            if (_cursor.isNull(_cursorIndexOfSpsPensn)) {
              _tmpSpsPensn = null;
            } else {
              _tmpSpsPensn = _cursor.getString(_cursorIndexOfSpsPensn);
            }
            _item.setSpsPensn(_tmpSpsPensn);
            final String _tmpSpOthInc;
            if (_cursor.isNull(_cursorIndexOfSpOthInc)) {
              _tmpSpOthInc = null;
            } else {
              _tmpSpOthInc = _cursor.getString(_cursorIndexOfSpOthInc);
            }
            _item.setSpOthInc(_tmpSpOthInc);
            final String _tmpDisbrsmt;
            if (_cursor.isNull(_cursorIndexOfDisbrsmt)) {
              _tmpDisbrsmt = null;
            } else {
              _tmpDisbrsmt = _cursor.getString(_cursorIndexOfDisbrsmt);
            }
            _item.setDisbrsmt(_tmpDisbrsmt);
            final String _tmpDependnt;
            if (_cursor.isNull(_cursorIndexOfDependnt)) {
              _tmpDependnt = null;
            } else {
              _tmpDependnt = _cursor.getString(_cursorIndexOfDependnt);
            }
            _item.setDependnt(_tmpDependnt);
            final String _tmpProperty;
            if (_cursor.isNull(_cursorIndexOfProperty)) {
              _tmpProperty = null;
            } else {
              _tmpProperty = _cursor.getString(_cursorIndexOfProperty);
            }
            _item.setProperty(_tmpProperty);
            final String _tmpOthrInfo;
            if (_cursor.isNull(_cursorIndexOfOthrInfo)) {
              _tmpOthrInfo = null;
            } else {
              _tmpOthrInfo = _cursor.getString(_cursorIndexOfOthrInfo);
            }
            _item.setOthrInfo(_tmpOthrInfo);
            final String _tmpComakerx;
            if (_cursor.isNull(_cursorIndexOfComakerx)) {
              _tmpComakerx = null;
            } else {
              _tmpComakerx = _cursor.getString(_cursorIndexOfComakerx);
            }
            _item.setComakerx(_tmpComakerx);
            final String _tmpCmResidx;
            if (_cursor.isNull(_cursorIndexOfCmResidx)) {
              _tmpCmResidx = null;
            } else {
              _tmpCmResidx = _cursor.getString(_cursorIndexOfCmResidx);
            }
            _item.setCmResidx(_tmpCmResidx);
            final String _tmpIsSpouse;
            if (_cursor.isNull(_cursorIndexOfIsSpouse)) {
              _tmpIsSpouse = null;
            } else {
              _tmpIsSpouse = _cursor.getString(_cursorIndexOfIsSpouse);
            }
            _item.setIsSpouse(_tmpIsSpouse);
            final String _tmpIsComakr;
            if (_cursor.isNull(_cursorIndexOfIsComakr)) {
              _tmpIsComakr = null;
            } else {
              _tmpIsComakr = _cursor.getString(_cursorIndexOfIsComakr);
            }
            _item.setIsComakr(_tmpIsComakr);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpAppliedx;
            if (_cursor.isNull(_cursorIndexOfAppliedx)) {
              _tmpAppliedx = null;
            } else {
              _tmpAppliedx = _cursor.getString(_cursorIndexOfAppliedx);
            }
            _item.setAppliedx(_tmpAppliedx);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpCreatedx;
            if (_cursor.isNull(_cursorIndexOfCreatedx)) {
              _tmpCreatedx = null;
            } else {
              _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
            }
            _item.setCreatedx(_tmpCreatedx);
            final double _tmpDownPaym;
            _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
            _item.setDownPaym(_tmpDownPaym);
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
  public LiveData<String> getAppMeansInfo(final String TransNox) {
    final String _sql = "SELECT sAppMeans FROM Credit_Applicant_Info WHERE sTransNox = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Applicant_Info"}, false, new Callable<String>() {
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
  public ECreditApplicantInfo getCurrentCreditApplicantInfo(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Applicant_Info WHERE sTransNox =?";
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
      final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
      final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurchase");
      final int _cursorIndexOfApplInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sApplInfo");
      final int _cursorIndexOfResidnce = CursorUtil.getColumnIndexOrThrow(_cursor, "sResidnce");
      final int _cursorIndexOfSameAddx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSameAddx");
      final int _cursorIndexOfAppMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppMeans");
      final int _cursorIndexOfEmplymnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmplymnt");
      final int _cursorIndexOfBusnInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sBusnInfo");
      final int _cursorIndexOfFinancex = CursorUtil.getColumnIndexOrThrow(_cursor, "sFinancex");
      final int _cursorIndexOfPensionx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPensionx");
      final int _cursorIndexOfOtherInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sOtherInc");
      final int _cursorIndexOfSpousexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpousexx");
      final int _cursorIndexOfSpsResdx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsResdx");
      final int _cursorIndexOfSpsMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsMEans");
      final int _cursorIndexOfSpsEmplx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsEmplx");
      final int _cursorIndexOfSpsBusnx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsBusnx");
      final int _cursorIndexOfSpsPensn = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsPensn");
      final int _cursorIndexOfSpOthInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpOthInc");
      final int _cursorIndexOfDisbrsmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDisbrsmt");
      final int _cursorIndexOfDependnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDependnt");
      final int _cursorIndexOfProperty = CursorUtil.getColumnIndexOrThrow(_cursor, "sProperty");
      final int _cursorIndexOfOthrInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sOthrInfo");
      final int _cursorIndexOfComakerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sComakerx");
      final int _cursorIndexOfCmResidx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCmResidx");
      final int _cursorIndexOfIsSpouse = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsSpouse");
      final int _cursorIndexOfIsComakr = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsComakr");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfAppliedx = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppliedx");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final ECreditApplicantInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new ECreditApplicantInfo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpClientNm;
        if (_cursor.isNull(_cursorIndexOfClientNm)) {
          _tmpClientNm = null;
        } else {
          _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
        }
        _result.setClientNm(_tmpClientNm);
        final String _tmpDetlInfo;
        if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
          _tmpDetlInfo = null;
        } else {
          _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
        }
        _result.setDetlInfo(_tmpDetlInfo);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _result.setPurchase(_tmpPurchase);
        final String _tmpApplInfo;
        if (_cursor.isNull(_cursorIndexOfApplInfo)) {
          _tmpApplInfo = null;
        } else {
          _tmpApplInfo = _cursor.getString(_cursorIndexOfApplInfo);
        }
        _result.setApplInfo(_tmpApplInfo);
        final String _tmpResidnce;
        if (_cursor.isNull(_cursorIndexOfResidnce)) {
          _tmpResidnce = null;
        } else {
          _tmpResidnce = _cursor.getString(_cursorIndexOfResidnce);
        }
        _result.setResidnce(_tmpResidnce);
        final String _tmpSameAddx;
        if (_cursor.isNull(_cursorIndexOfSameAddx)) {
          _tmpSameAddx = null;
        } else {
          _tmpSameAddx = _cursor.getString(_cursorIndexOfSameAddx);
        }
        _result.setSameAddx(_tmpSameAddx);
        final String _tmpAppMeans;
        if (_cursor.isNull(_cursorIndexOfAppMeans)) {
          _tmpAppMeans = null;
        } else {
          _tmpAppMeans = _cursor.getString(_cursorIndexOfAppMeans);
        }
        _result.setAppMeans(_tmpAppMeans);
        final String _tmpEmplymnt;
        if (_cursor.isNull(_cursorIndexOfEmplymnt)) {
          _tmpEmplymnt = null;
        } else {
          _tmpEmplymnt = _cursor.getString(_cursorIndexOfEmplymnt);
        }
        _result.setEmplymnt(_tmpEmplymnt);
        final String _tmpBusnInfo;
        if (_cursor.isNull(_cursorIndexOfBusnInfo)) {
          _tmpBusnInfo = null;
        } else {
          _tmpBusnInfo = _cursor.getString(_cursorIndexOfBusnInfo);
        }
        _result.setBusnInfo(_tmpBusnInfo);
        final String _tmpFinancex;
        if (_cursor.isNull(_cursorIndexOfFinancex)) {
          _tmpFinancex = null;
        } else {
          _tmpFinancex = _cursor.getString(_cursorIndexOfFinancex);
        }
        _result.setFinancex(_tmpFinancex);
        final String _tmpPensionx;
        if (_cursor.isNull(_cursorIndexOfPensionx)) {
          _tmpPensionx = null;
        } else {
          _tmpPensionx = _cursor.getString(_cursorIndexOfPensionx);
        }
        _result.setPensionx(_tmpPensionx);
        final String _tmpOtherInc;
        if (_cursor.isNull(_cursorIndexOfOtherInc)) {
          _tmpOtherInc = null;
        } else {
          _tmpOtherInc = _cursor.getString(_cursorIndexOfOtherInc);
        }
        _result.setOtherInc(_tmpOtherInc);
        final String _tmpSpousexx;
        if (_cursor.isNull(_cursorIndexOfSpousexx)) {
          _tmpSpousexx = null;
        } else {
          _tmpSpousexx = _cursor.getString(_cursorIndexOfSpousexx);
        }
        _result.setSpousexx(_tmpSpousexx);
        final String _tmpSpsResdx;
        if (_cursor.isNull(_cursorIndexOfSpsResdx)) {
          _tmpSpsResdx = null;
        } else {
          _tmpSpsResdx = _cursor.getString(_cursorIndexOfSpsResdx);
        }
        _result.setSpsResdx(_tmpSpsResdx);
        final String _tmpSpsMeans;
        if (_cursor.isNull(_cursorIndexOfSpsMeans)) {
          _tmpSpsMeans = null;
        } else {
          _tmpSpsMeans = _cursor.getString(_cursorIndexOfSpsMeans);
        }
        _result.setSpsMeans(_tmpSpsMeans);
        final String _tmpSpsEmplx;
        if (_cursor.isNull(_cursorIndexOfSpsEmplx)) {
          _tmpSpsEmplx = null;
        } else {
          _tmpSpsEmplx = _cursor.getString(_cursorIndexOfSpsEmplx);
        }
        _result.setSpsEmplx(_tmpSpsEmplx);
        final String _tmpSpsBusnx;
        if (_cursor.isNull(_cursorIndexOfSpsBusnx)) {
          _tmpSpsBusnx = null;
        } else {
          _tmpSpsBusnx = _cursor.getString(_cursorIndexOfSpsBusnx);
        }
        _result.setSpsBusnx(_tmpSpsBusnx);
        final String _tmpSpsPensn;
        if (_cursor.isNull(_cursorIndexOfSpsPensn)) {
          _tmpSpsPensn = null;
        } else {
          _tmpSpsPensn = _cursor.getString(_cursorIndexOfSpsPensn);
        }
        _result.setSpsPensn(_tmpSpsPensn);
        final String _tmpSpOthInc;
        if (_cursor.isNull(_cursorIndexOfSpOthInc)) {
          _tmpSpOthInc = null;
        } else {
          _tmpSpOthInc = _cursor.getString(_cursorIndexOfSpOthInc);
        }
        _result.setSpOthInc(_tmpSpOthInc);
        final String _tmpDisbrsmt;
        if (_cursor.isNull(_cursorIndexOfDisbrsmt)) {
          _tmpDisbrsmt = null;
        } else {
          _tmpDisbrsmt = _cursor.getString(_cursorIndexOfDisbrsmt);
        }
        _result.setDisbrsmt(_tmpDisbrsmt);
        final String _tmpDependnt;
        if (_cursor.isNull(_cursorIndexOfDependnt)) {
          _tmpDependnt = null;
        } else {
          _tmpDependnt = _cursor.getString(_cursorIndexOfDependnt);
        }
        _result.setDependnt(_tmpDependnt);
        final String _tmpProperty;
        if (_cursor.isNull(_cursorIndexOfProperty)) {
          _tmpProperty = null;
        } else {
          _tmpProperty = _cursor.getString(_cursorIndexOfProperty);
        }
        _result.setProperty(_tmpProperty);
        final String _tmpOthrInfo;
        if (_cursor.isNull(_cursorIndexOfOthrInfo)) {
          _tmpOthrInfo = null;
        } else {
          _tmpOthrInfo = _cursor.getString(_cursorIndexOfOthrInfo);
        }
        _result.setOthrInfo(_tmpOthrInfo);
        final String _tmpComakerx;
        if (_cursor.isNull(_cursorIndexOfComakerx)) {
          _tmpComakerx = null;
        } else {
          _tmpComakerx = _cursor.getString(_cursorIndexOfComakerx);
        }
        _result.setComakerx(_tmpComakerx);
        final String _tmpCmResidx;
        if (_cursor.isNull(_cursorIndexOfCmResidx)) {
          _tmpCmResidx = null;
        } else {
          _tmpCmResidx = _cursor.getString(_cursorIndexOfCmResidx);
        }
        _result.setCmResidx(_tmpCmResidx);
        final String _tmpIsSpouse;
        if (_cursor.isNull(_cursorIndexOfIsSpouse)) {
          _tmpIsSpouse = null;
        } else {
          _tmpIsSpouse = _cursor.getString(_cursorIndexOfIsSpouse);
        }
        _result.setIsSpouse(_tmpIsSpouse);
        final String _tmpIsComakr;
        if (_cursor.isNull(_cursorIndexOfIsComakr)) {
          _tmpIsComakr = null;
        } else {
          _tmpIsComakr = _cursor.getString(_cursorIndexOfIsComakr);
        }
        _result.setIsComakr(_tmpIsComakr);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpAppliedx;
        if (_cursor.isNull(_cursorIndexOfAppliedx)) {
          _tmpAppliedx = null;
        } else {
          _tmpAppliedx = _cursor.getString(_cursorIndexOfAppliedx);
        }
        _result.setAppliedx(_tmpAppliedx);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _result.setCreatedx(_tmpCreatedx);
        final double _tmpDownPaym;
        _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
        _result.setDownPaym(_tmpDownPaym);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
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
