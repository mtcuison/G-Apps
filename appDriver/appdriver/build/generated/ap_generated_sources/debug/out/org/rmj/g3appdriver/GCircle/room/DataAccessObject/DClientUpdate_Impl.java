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
import org.rmj.g3appdriver.GCircle.room.Entities.EClientUpdate;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DClientUpdate_Impl implements DClientUpdate {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EClientUpdate> __insertionAdapterOfEClientUpdate;

  private final EntityDeletionOrUpdateAdapter<EClientUpdate> __updateAdapterOfEClientUpdate;

  private final SharedSQLiteStatement __preparedStmtOfUpdateClientInfoStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateClientInfoImage;

  public DClientUpdate_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEClientUpdate = new EntityInsertionAdapter<EClientUpdate>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Client_Update_Request` (`sClientID`,`sSourceCd`,`sSourceNo`,`sDtlSrcNo`,`sLastName`,`sFrstName`,`sMiddName`,`sSuffixNm`,`sHouseNox`,`sAddressx`,`sBarangay`,`sTownIDxx`,`cGenderxx`,`cCivlStat`,`dBirthDte`,`dBirthPlc`,`sLandline`,`sMobileNo`,`sEmailAdd`,`sImageNme`,`cSendStat`,`dModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EClientUpdate value) {
        if (value.getClientID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getClientID());
        }
        if (value.getSourceCd() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSourceCd());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSourceNo());
        }
        if (value.getDtlSrcNo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDtlSrcNo());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLastName());
        }
        if (value.getFrstName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFrstName());
        }
        if (value.getMiddName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMiddName());
        }
        if (value.getSuffixNm() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSuffixNm());
        }
        if (value.getHouseNox() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getHouseNox());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getAddressx());
        }
        if (value.getBarangay() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getBarangay());
        }
        if (value.getTownIDxx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTownIDxx());
        }
        if (value.getGenderxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getGenderxx());
        }
        if (value.getCivlStat() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getCivlStat());
        }
        if (value.getBirthDte() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getBirthDte());
        }
        if (value.getBirthPlc() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getBirthPlc());
        }
        if (value.getLandline() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getLandline());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getMobileNo());
        }
        if (value.getEmailAdd() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getEmailAdd());
        }
        if (value.getImageNme() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getImageNme());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getSendStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getModified());
        }
      }
    };
    this.__updateAdapterOfEClientUpdate = new EntityDeletionOrUpdateAdapter<EClientUpdate>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Client_Update_Request` SET `sClientID` = ?,`sSourceCd` = ?,`sSourceNo` = ?,`sDtlSrcNo` = ?,`sLastName` = ?,`sFrstName` = ?,`sMiddName` = ?,`sSuffixNm` = ?,`sHouseNox` = ?,`sAddressx` = ?,`sBarangay` = ?,`sTownIDxx` = ?,`cGenderxx` = ?,`cCivlStat` = ?,`dBirthDte` = ?,`dBirthPlc` = ?,`sLandline` = ?,`sMobileNo` = ?,`sEmailAdd` = ?,`sImageNme` = ?,`cSendStat` = ?,`dModified` = ? WHERE `sClientID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EClientUpdate value) {
        if (value.getClientID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getClientID());
        }
        if (value.getSourceCd() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSourceCd());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSourceNo());
        }
        if (value.getDtlSrcNo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDtlSrcNo());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLastName());
        }
        if (value.getFrstName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFrstName());
        }
        if (value.getMiddName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMiddName());
        }
        if (value.getSuffixNm() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSuffixNm());
        }
        if (value.getHouseNox() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getHouseNox());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getAddressx());
        }
        if (value.getBarangay() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getBarangay());
        }
        if (value.getTownIDxx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTownIDxx());
        }
        if (value.getGenderxx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getGenderxx());
        }
        if (value.getCivlStat() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getCivlStat());
        }
        if (value.getBirthDte() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getBirthDte());
        }
        if (value.getBirthPlc() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getBirthPlc());
        }
        if (value.getLandline() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getLandline());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getMobileNo());
        }
        if (value.getEmailAdd() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getEmailAdd());
        }
        if (value.getImageNme() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getImageNme());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getSendStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getModified());
        }
        if (value.getClientID() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getClientID());
        }
      }
    };
    this.__preparedStmtOfUpdateClientInfoStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Client_Update_Request SET cSendStat = '1', dModified=? WHERE sSourceNo = (SELECT sTransNox FROM LR_DCP_Collection_Master ORDER BY dTransact DESC LIMIT 1) AND sClientID =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateClientInfoImage = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Client_Update_Request SET sImageNme =? WHERE sSourceNo = (SELECT sTransNox FROM LR_DCP_Collection_Master ORDER BY dTransact DESC LIMIT 1) AND sClientID =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveClientUpdate(final EClientUpdate clientUpdate) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEClientUpdate.insert(clientUpdate);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateClientInfo(final EClientUpdate clientUpdate) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEClientUpdate.handle(clientUpdate);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateClientInfoStatus(final String ClientID, final String dModified) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateClientInfoStatus.acquire();
    int _argIndex = 1;
    if (dModified == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, dModified);
    }
    _argIndex = 2;
    if (ClientID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ClientID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateClientInfoStatus.release(_stmt);
    }
  }

  @Override
  public void updateClientInfoImage(final String ClientID, final String ImageName) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateClientInfoImage.acquire();
    int _argIndex = 1;
    if (ImageName == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ImageName);
    }
    _argIndex = 2;
    if (ClientID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ClientID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateClientInfoImage.release(_stmt);
    }
  }

  @Override
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT (*) FROM Client_Update_Request";
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
  public LiveData<EClientUpdate> getClientUpdateInfo(final String ClientID) {
    final String _sql = "SELECT * FROM Client_Update_Request WHERE sSourceNo = (SELECT sTransNox FROM LR_DCP_Collection_Master ORDER BY dTransact DESC LIMIT 1) AND sClientID =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ClientID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ClientID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Client_Update_Request","LR_DCP_Collection_Master"}, false, new Callable<EClientUpdate>() {
      @Override
      public EClientUpdate call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSourceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCd");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "sLastName");
          final int _cursorIndexOfFrstName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFrstName");
          final int _cursorIndexOfMiddName = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiddName");
          final int _cursorIndexOfSuffixNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSuffixNm");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBarangay = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarangay");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfGenderxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cGenderxx");
          final int _cursorIndexOfCivlStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cCivlStat");
          final int _cursorIndexOfBirthDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthDte");
          final int _cursorIndexOfBirthPlc = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthPlc");
          final int _cursorIndexOfLandline = CursorUtil.getColumnIndexOrThrow(_cursor, "sLandline");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EClientUpdate _result;
          if(_cursor.moveToFirst()) {
            _result = new EClientUpdate();
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _result.setClientID(_tmpClientID);
            final String _tmpSourceCd;
            if (_cursor.isNull(_cursorIndexOfSourceCd)) {
              _tmpSourceCd = null;
            } else {
              _tmpSourceCd = _cursor.getString(_cursorIndexOfSourceCd);
            }
            _result.setSourceCd(_tmpSourceCd);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _result.setSourceNo(_tmpSourceNo);
            final String _tmpDtlSrcNo;
            if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
              _tmpDtlSrcNo = null;
            } else {
              _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
            }
            _result.setDtlSrcNo(_tmpDtlSrcNo);
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            _result.setLastName(_tmpLastName);
            final String _tmpFrstName;
            if (_cursor.isNull(_cursorIndexOfFrstName)) {
              _tmpFrstName = null;
            } else {
              _tmpFrstName = _cursor.getString(_cursorIndexOfFrstName);
            }
            _result.setFrstName(_tmpFrstName);
            final String _tmpMiddName;
            if (_cursor.isNull(_cursorIndexOfMiddName)) {
              _tmpMiddName = null;
            } else {
              _tmpMiddName = _cursor.getString(_cursorIndexOfMiddName);
            }
            _result.setMiddName(_tmpMiddName);
            final String _tmpSuffixNm;
            if (_cursor.isNull(_cursorIndexOfSuffixNm)) {
              _tmpSuffixNm = null;
            } else {
              _tmpSuffixNm = _cursor.getString(_cursorIndexOfSuffixNm);
            }
            _result.setSuffixNm(_tmpSuffixNm);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _result.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpBarangay;
            if (_cursor.isNull(_cursorIndexOfBarangay)) {
              _tmpBarangay = null;
            } else {
              _tmpBarangay = _cursor.getString(_cursorIndexOfBarangay);
            }
            _result.setBarangay(_tmpBarangay);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _result.setTownIDxx(_tmpTownIDxx);
            final String _tmpGenderxx;
            if (_cursor.isNull(_cursorIndexOfGenderxx)) {
              _tmpGenderxx = null;
            } else {
              _tmpGenderxx = _cursor.getString(_cursorIndexOfGenderxx);
            }
            _result.setGenderxx(_tmpGenderxx);
            final String _tmpCivlStat;
            if (_cursor.isNull(_cursorIndexOfCivlStat)) {
              _tmpCivlStat = null;
            } else {
              _tmpCivlStat = _cursor.getString(_cursorIndexOfCivlStat);
            }
            _result.setCivlStat(_tmpCivlStat);
            final String _tmpBirthDte;
            if (_cursor.isNull(_cursorIndexOfBirthDte)) {
              _tmpBirthDte = null;
            } else {
              _tmpBirthDte = _cursor.getString(_cursorIndexOfBirthDte);
            }
            _result.setBirthDte(_tmpBirthDte);
            final String _tmpBirthPlc;
            if (_cursor.isNull(_cursorIndexOfBirthPlc)) {
              _tmpBirthPlc = null;
            } else {
              _tmpBirthPlc = _cursor.getString(_cursorIndexOfBirthPlc);
            }
            _result.setBirthPlc(_tmpBirthPlc);
            final String _tmpLandline;
            if (_cursor.isNull(_cursorIndexOfLandline)) {
              _tmpLandline = null;
            } else {
              _tmpLandline = _cursor.getString(_cursorIndexOfLandline);
            }
            _result.setLandline(_tmpLandline);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _result.setEmailAdd(_tmpEmailAdd);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _result.setImageNme(_tmpImageNme);
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
  public EClientUpdate getClientUpdateInfoForPosting(final String TransNox, final String AcctNox) {
    final String _sql = "SELECT * FROM Client_Update_Request WHERE sSourceNo =? AND sDtlSrcNo =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (AcctNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AcctNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfSourceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCd");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "sLastName");
      final int _cursorIndexOfFrstName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFrstName");
      final int _cursorIndexOfMiddName = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiddName");
      final int _cursorIndexOfSuffixNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSuffixNm");
      final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfBarangay = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarangay");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfGenderxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cGenderxx");
      final int _cursorIndexOfCivlStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cCivlStat");
      final int _cursorIndexOfBirthDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthDte");
      final int _cursorIndexOfBirthPlc = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthPlc");
      final int _cursorIndexOfLandline = CursorUtil.getColumnIndexOrThrow(_cursor, "sLandline");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EClientUpdate _result;
      if(_cursor.moveToFirst()) {
        _result = new EClientUpdate();
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpSourceCd;
        if (_cursor.isNull(_cursorIndexOfSourceCd)) {
          _tmpSourceCd = null;
        } else {
          _tmpSourceCd = _cursor.getString(_cursorIndexOfSourceCd);
        }
        _result.setSourceCd(_tmpSourceCd);
        final String _tmpSourceNo;
        if (_cursor.isNull(_cursorIndexOfSourceNo)) {
          _tmpSourceNo = null;
        } else {
          _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
        }
        _result.setSourceNo(_tmpSourceNo);
        final String _tmpDtlSrcNo;
        if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
          _tmpDtlSrcNo = null;
        } else {
          _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
        }
        _result.setDtlSrcNo(_tmpDtlSrcNo);
        final String _tmpLastName;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLastName = null;
        } else {
          _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        }
        _result.setLastName(_tmpLastName);
        final String _tmpFrstName;
        if (_cursor.isNull(_cursorIndexOfFrstName)) {
          _tmpFrstName = null;
        } else {
          _tmpFrstName = _cursor.getString(_cursorIndexOfFrstName);
        }
        _result.setFrstName(_tmpFrstName);
        final String _tmpMiddName;
        if (_cursor.isNull(_cursorIndexOfMiddName)) {
          _tmpMiddName = null;
        } else {
          _tmpMiddName = _cursor.getString(_cursorIndexOfMiddName);
        }
        _result.setMiddName(_tmpMiddName);
        final String _tmpSuffixNm;
        if (_cursor.isNull(_cursorIndexOfSuffixNm)) {
          _tmpSuffixNm = null;
        } else {
          _tmpSuffixNm = _cursor.getString(_cursorIndexOfSuffixNm);
        }
        _result.setSuffixNm(_tmpSuffixNm);
        final String _tmpHouseNox;
        if (_cursor.isNull(_cursorIndexOfHouseNox)) {
          _tmpHouseNox = null;
        } else {
          _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
        }
        _result.setHouseNox(_tmpHouseNox);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpBarangay;
        if (_cursor.isNull(_cursorIndexOfBarangay)) {
          _tmpBarangay = null;
        } else {
          _tmpBarangay = _cursor.getString(_cursorIndexOfBarangay);
        }
        _result.setBarangay(_tmpBarangay);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _result.setTownIDxx(_tmpTownIDxx);
        final String _tmpGenderxx;
        if (_cursor.isNull(_cursorIndexOfGenderxx)) {
          _tmpGenderxx = null;
        } else {
          _tmpGenderxx = _cursor.getString(_cursorIndexOfGenderxx);
        }
        _result.setGenderxx(_tmpGenderxx);
        final String _tmpCivlStat;
        if (_cursor.isNull(_cursorIndexOfCivlStat)) {
          _tmpCivlStat = null;
        } else {
          _tmpCivlStat = _cursor.getString(_cursorIndexOfCivlStat);
        }
        _result.setCivlStat(_tmpCivlStat);
        final String _tmpBirthDte;
        if (_cursor.isNull(_cursorIndexOfBirthDte)) {
          _tmpBirthDte = null;
        } else {
          _tmpBirthDte = _cursor.getString(_cursorIndexOfBirthDte);
        }
        _result.setBirthDte(_tmpBirthDte);
        final String _tmpBirthPlc;
        if (_cursor.isNull(_cursorIndexOfBirthPlc)) {
          _tmpBirthPlc = null;
        } else {
          _tmpBirthPlc = _cursor.getString(_cursorIndexOfBirthPlc);
        }
        _result.setBirthPlc(_tmpBirthPlc);
        final String _tmpLandline;
        if (_cursor.isNull(_cursorIndexOfLandline)) {
          _tmpLandline = null;
        } else {
          _tmpLandline = _cursor.getString(_cursorIndexOfLandline);
        }
        _result.setLandline(_tmpLandline);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final String _tmpEmailAdd;
        if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
          _tmpEmailAdd = null;
        } else {
          _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
        }
        _result.setEmailAdd(_tmpEmailAdd);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
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
  public LiveData<List<EClientUpdate>> selectClientUpdate() {
    final String _sql = "SELECT * FROM Client_Update_Request";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Client_Update_Request"}, false, new Callable<List<EClientUpdate>>() {
      @Override
      public List<EClientUpdate> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSourceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCd");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "sLastName");
          final int _cursorIndexOfFrstName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFrstName");
          final int _cursorIndexOfMiddName = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiddName");
          final int _cursorIndexOfSuffixNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSuffixNm");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBarangay = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarangay");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfGenderxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cGenderxx");
          final int _cursorIndexOfCivlStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cCivlStat");
          final int _cursorIndexOfBirthDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthDte");
          final int _cursorIndexOfBirthPlc = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthPlc");
          final int _cursorIndexOfLandline = CursorUtil.getColumnIndexOrThrow(_cursor, "sLandline");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final List<EClientUpdate> _result = new ArrayList<EClientUpdate>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EClientUpdate _item;
            _item = new EClientUpdate();
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _item.setClientID(_tmpClientID);
            final String _tmpSourceCd;
            if (_cursor.isNull(_cursorIndexOfSourceCd)) {
              _tmpSourceCd = null;
            } else {
              _tmpSourceCd = _cursor.getString(_cursorIndexOfSourceCd);
            }
            _item.setSourceCd(_tmpSourceCd);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _item.setSourceNo(_tmpSourceNo);
            final String _tmpDtlSrcNo;
            if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
              _tmpDtlSrcNo = null;
            } else {
              _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
            }
            _item.setDtlSrcNo(_tmpDtlSrcNo);
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            _item.setLastName(_tmpLastName);
            final String _tmpFrstName;
            if (_cursor.isNull(_cursorIndexOfFrstName)) {
              _tmpFrstName = null;
            } else {
              _tmpFrstName = _cursor.getString(_cursorIndexOfFrstName);
            }
            _item.setFrstName(_tmpFrstName);
            final String _tmpMiddName;
            if (_cursor.isNull(_cursorIndexOfMiddName)) {
              _tmpMiddName = null;
            } else {
              _tmpMiddName = _cursor.getString(_cursorIndexOfMiddName);
            }
            _item.setMiddName(_tmpMiddName);
            final String _tmpSuffixNm;
            if (_cursor.isNull(_cursorIndexOfSuffixNm)) {
              _tmpSuffixNm = null;
            } else {
              _tmpSuffixNm = _cursor.getString(_cursorIndexOfSuffixNm);
            }
            _item.setSuffixNm(_tmpSuffixNm);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _item.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpBarangay;
            if (_cursor.isNull(_cursorIndexOfBarangay)) {
              _tmpBarangay = null;
            } else {
              _tmpBarangay = _cursor.getString(_cursorIndexOfBarangay);
            }
            _item.setBarangay(_tmpBarangay);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpGenderxx;
            if (_cursor.isNull(_cursorIndexOfGenderxx)) {
              _tmpGenderxx = null;
            } else {
              _tmpGenderxx = _cursor.getString(_cursorIndexOfGenderxx);
            }
            _item.setGenderxx(_tmpGenderxx);
            final String _tmpCivlStat;
            if (_cursor.isNull(_cursorIndexOfCivlStat)) {
              _tmpCivlStat = null;
            } else {
              _tmpCivlStat = _cursor.getString(_cursorIndexOfCivlStat);
            }
            _item.setCivlStat(_tmpCivlStat);
            final String _tmpBirthDte;
            if (_cursor.isNull(_cursorIndexOfBirthDte)) {
              _tmpBirthDte = null;
            } else {
              _tmpBirthDte = _cursor.getString(_cursorIndexOfBirthDte);
            }
            _item.setBirthDte(_tmpBirthDte);
            final String _tmpBirthPlc;
            if (_cursor.isNull(_cursorIndexOfBirthPlc)) {
              _tmpBirthPlc = null;
            } else {
              _tmpBirthPlc = _cursor.getString(_cursorIndexOfBirthPlc);
            }
            _item.setBirthPlc(_tmpBirthPlc);
            final String _tmpLandline;
            if (_cursor.isNull(_cursorIndexOfLandline)) {
              _tmpLandline = null;
            } else {
              _tmpLandline = _cursor.getString(_cursorIndexOfLandline);
            }
            _item.setLandline(_tmpLandline);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _item.setEmailAdd(_tmpEmailAdd);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _item.setImageNme(_tmpImageNme);
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
  public LiveData<EClientUpdate> selectClient(final String sSourceNo, final String sDtlSrcNo) {
    final String _sql = "SELECT * FROM Client_Update_Request WHERE sSourceNo =? AND sDtlSrcNo =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (sSourceNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sSourceNo);
    }
    _argIndex = 2;
    if (sDtlSrcNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDtlSrcNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Client_Update_Request"}, false, new Callable<EClientUpdate>() {
      @Override
      public EClientUpdate call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfSourceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCd");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "sLastName");
          final int _cursorIndexOfFrstName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFrstName");
          final int _cursorIndexOfMiddName = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiddName");
          final int _cursorIndexOfSuffixNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSuffixNm");
          final int _cursorIndexOfHouseNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNox");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfBarangay = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarangay");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfGenderxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cGenderxx");
          final int _cursorIndexOfCivlStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cCivlStat");
          final int _cursorIndexOfBirthDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthDte");
          final int _cursorIndexOfBirthPlc = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthPlc");
          final int _cursorIndexOfLandline = CursorUtil.getColumnIndexOrThrow(_cursor, "sLandline");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EClientUpdate _result;
          if(_cursor.moveToFirst()) {
            _result = new EClientUpdate();
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _result.setClientID(_tmpClientID);
            final String _tmpSourceCd;
            if (_cursor.isNull(_cursorIndexOfSourceCd)) {
              _tmpSourceCd = null;
            } else {
              _tmpSourceCd = _cursor.getString(_cursorIndexOfSourceCd);
            }
            _result.setSourceCd(_tmpSourceCd);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _result.setSourceNo(_tmpSourceNo);
            final String _tmpDtlSrcNo;
            if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
              _tmpDtlSrcNo = null;
            } else {
              _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
            }
            _result.setDtlSrcNo(_tmpDtlSrcNo);
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            _result.setLastName(_tmpLastName);
            final String _tmpFrstName;
            if (_cursor.isNull(_cursorIndexOfFrstName)) {
              _tmpFrstName = null;
            } else {
              _tmpFrstName = _cursor.getString(_cursorIndexOfFrstName);
            }
            _result.setFrstName(_tmpFrstName);
            final String _tmpMiddName;
            if (_cursor.isNull(_cursorIndexOfMiddName)) {
              _tmpMiddName = null;
            } else {
              _tmpMiddName = _cursor.getString(_cursorIndexOfMiddName);
            }
            _result.setMiddName(_tmpMiddName);
            final String _tmpSuffixNm;
            if (_cursor.isNull(_cursorIndexOfSuffixNm)) {
              _tmpSuffixNm = null;
            } else {
              _tmpSuffixNm = _cursor.getString(_cursorIndexOfSuffixNm);
            }
            _result.setSuffixNm(_tmpSuffixNm);
            final String _tmpHouseNox;
            if (_cursor.isNull(_cursorIndexOfHouseNox)) {
              _tmpHouseNox = null;
            } else {
              _tmpHouseNox = _cursor.getString(_cursorIndexOfHouseNox);
            }
            _result.setHouseNox(_tmpHouseNox);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpBarangay;
            if (_cursor.isNull(_cursorIndexOfBarangay)) {
              _tmpBarangay = null;
            } else {
              _tmpBarangay = _cursor.getString(_cursorIndexOfBarangay);
            }
            _result.setBarangay(_tmpBarangay);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _result.setTownIDxx(_tmpTownIDxx);
            final String _tmpGenderxx;
            if (_cursor.isNull(_cursorIndexOfGenderxx)) {
              _tmpGenderxx = null;
            } else {
              _tmpGenderxx = _cursor.getString(_cursorIndexOfGenderxx);
            }
            _result.setGenderxx(_tmpGenderxx);
            final String _tmpCivlStat;
            if (_cursor.isNull(_cursorIndexOfCivlStat)) {
              _tmpCivlStat = null;
            } else {
              _tmpCivlStat = _cursor.getString(_cursorIndexOfCivlStat);
            }
            _result.setCivlStat(_tmpCivlStat);
            final String _tmpBirthDte;
            if (_cursor.isNull(_cursorIndexOfBirthDte)) {
              _tmpBirthDte = null;
            } else {
              _tmpBirthDte = _cursor.getString(_cursorIndexOfBirthDte);
            }
            _result.setBirthDte(_tmpBirthDte);
            final String _tmpBirthPlc;
            if (_cursor.isNull(_cursorIndexOfBirthPlc)) {
              _tmpBirthPlc = null;
            } else {
              _tmpBirthPlc = _cursor.getString(_cursorIndexOfBirthPlc);
            }
            _result.setBirthPlc(_tmpBirthPlc);
            final String _tmpLandline;
            if (_cursor.isNull(_cursorIndexOfLandline)) {
              _tmpLandline = null;
            } else {
              _tmpLandline = _cursor.getString(_cursorIndexOfLandline);
            }
            _result.setLandline(_tmpLandline);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _result.setEmailAdd(_tmpEmailAdd);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _result.setImageNme(_tmpImageNme);
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
