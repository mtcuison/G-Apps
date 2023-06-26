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
import org.rmj.g3appdriver.GCircle.room.Entities.EBranchInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DBranchInfo_Impl implements DBranchInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EBranchInfo> __insertionAdapterOfEBranchInfo;

  private final EntityDeletionOrUpdateAdapter<EBranchInfo> __updateAdapterOfEBranchInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBranchInfo;

  public DBranchInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEBranchInfo = new EntityInsertionAdapter<EBranchInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Branch_Info` (`sBranchCd`,`sBranchNm`,`sDescript`,`sAddressx`,`sTownIDxx`,`sAreaCode`,`cDivision`,`cPromoDiv`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchInfo value) {
        if (value.getBranchCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBranchCd());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchNm());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescript());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddressx());
        }
        if (value.getTownIDxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTownIDxx());
        }
        if (value.getAreaCode() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAreaCode());
        }
        if (value.getDivision() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDivision());
        }
        if (value.getPromoDiv() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPromoDiv());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRecdStat());
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
    this.__updateAdapterOfEBranchInfo = new EntityDeletionOrUpdateAdapter<EBranchInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Branch_Info` SET `sBranchCd` = ?,`sBranchNm` = ?,`sDescript` = ?,`sAddressx` = ?,`sTownIDxx` = ?,`sAreaCode` = ?,`cDivision` = ?,`cPromoDiv` = ?,`cRecdStat` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sBranchCd` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchInfo value) {
        if (value.getBranchCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBranchCd());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchNm());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescript());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddressx());
        }
        if (value.getTownIDxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTownIDxx());
        }
        if (value.getAreaCode() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAreaCode());
        }
        if (value.getDivision() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDivision());
        }
        if (value.getPromoDiv() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPromoDiv());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getRecdStat());
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
        if (value.getBranchCd() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBranchCd());
        }
      }
    };
    this.__preparedStmtOfUpdateBranchInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Branch_Info SET sBranchNm =?,  sDescript=?, sAddressx=?, sTownIDxx=?, sAreaCode=?, cDivision=?, cRecdStat=?, cPromoDiv=?, dTimeStmp=? WHERE sBranchCd=?";
        return _query;
      }
    };
  }

  @Override
  public void SaveBranchInfo(final EBranchInfo branchInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchInfo.insert(branchInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateBranchInfo(final EBranchInfo branchInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEBranchInfo.handle(branchInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateBranchInfo(final String BranchCd, final String BranchNm, final String Descript,
      final String Addressx, final String TownIDxx, final String AreaCode, final String Division,
      final String PromoDiv, final String RecdStat, final String TimeStmp) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBranchInfo.acquire();
    int _argIndex = 1;
    if (BranchNm == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, BranchNm);
    }
    _argIndex = 2;
    if (Descript == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Descript);
    }
    _argIndex = 3;
    if (Addressx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Addressx);
    }
    _argIndex = 4;
    if (TownIDxx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TownIDxx);
    }
    _argIndex = 5;
    if (AreaCode == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, AreaCode);
    }
    _argIndex = 6;
    if (Division == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Division);
    }
    _argIndex = 7;
    if (RecdStat == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, RecdStat);
    }
    _argIndex = 8;
    if (PromoDiv == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, PromoDiv);
    }
    _argIndex = 9;
    if (TimeStmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TimeStmp);
    }
    _argIndex = 10;
    if (BranchCd == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, BranchCd);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateBranchInfo.release(_stmt);
    }
  }

  @Override
  public EBranchInfo GetBranchInfo(final String fsVal) {
    final String _sql = "SELECT * FROM Branch_Info WHERE sBranchCd =?";
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
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EBranchInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EBranchInfo();
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _result.setDescript(_tmpDescript);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _result.setTownIDxx(_tmpTownIDxx);
        final String _tmpAreaCode;
        if (_cursor.isNull(_cursorIndexOfAreaCode)) {
          _tmpAreaCode = null;
        } else {
          _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
        }
        _result.setAreaCode(_tmpAreaCode);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpPromoDiv;
        if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
          _tmpPromoDiv = null;
        } else {
          _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
        }
        _result.setPromoDiv(_tmpPromoDiv);
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
  public EBranchInfo GetLatestBranchInfo() {
    final String _sql = "SELECT * FROM Branch_Info ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EBranchInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EBranchInfo();
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _result.setDescript(_tmpDescript);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _result.setTownIDxx(_tmpTownIDxx);
        final String _tmpAreaCode;
        if (_cursor.isNull(_cursorIndexOfAreaCode)) {
          _tmpAreaCode = null;
        } else {
          _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
        }
        _result.setAreaCode(_tmpAreaCode);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpPromoDiv;
        if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
          _tmpPromoDiv = null;
        } else {
          _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
        }
        _result.setPromoDiv(_tmpPromoDiv);
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
  public LiveData<EBranchInfo> getBranchInfo() {
    final String _sql = "SELECT * FROM Branch_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<EBranchInfo>() {
      @Override
      public EBranchInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final EBranchInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _result.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _result.setTownIDxx(_tmpTownIDxx);
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _result.setAreaCode(_tmpAreaCode);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _result.setDivision(_tmpDivision);
            final String _tmpPromoDiv;
            if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
              _tmpPromoDiv = null;
            } else {
              _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
            }
            _result.setPromoDiv(_tmpPromoDiv);
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
  public LiveData<EBranchInfo> getBranchInfo(final String BranchCd) {
    final String _sql = "SELECT * FROM Branch_Info WHERE sBranchCd =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<EBranchInfo>() {
      @Override
      public EBranchInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final EBranchInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _result.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _result.setTownIDxx(_tmpTownIDxx);
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _result.setAreaCode(_tmpAreaCode);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _result.setDivision(_tmpDivision);
            final String _tmpPromoDiv;
            if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
              _tmpPromoDiv = null;
            } else {
              _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
            }
            _result.setPromoDiv(_tmpPromoDiv);
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
  public LiveData<List<EBranchInfo>> getAllMcBranchInfo() {
    final String _sql = "SELECT * FROM Branch_Info WHERE cDivision = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<List<EBranchInfo>>() {
      @Override
      public List<EBranchInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchInfo _item;
            _item = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _item.setAreaCode(_tmpAreaCode);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _item.setDivision(_tmpDivision);
            final String _tmpPromoDiv;
            if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
              _tmpPromoDiv = null;
            } else {
              _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
            }
            _item.setPromoDiv(_tmpPromoDiv);
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
  public LiveData<List<EBranchInfo>> getAllMpBranchInfo() {
    final String _sql = "SELECT * FROM Branch_Info WHERE cDivision = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<List<EBranchInfo>>() {
      @Override
      public List<EBranchInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchInfo _item;
            _item = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _item.setAreaCode(_tmpAreaCode);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _item.setDivision(_tmpDivision);
            final String _tmpPromoDiv;
            if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
              _tmpPromoDiv = null;
            } else {
              _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
            }
            _item.setPromoDiv(_tmpPromoDiv);
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
  public LiveData<String[]> getMCBranchNames() {
    final String _sql = "SELECT sBranchNm FROM Branch_Info WHERE cDivision = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<String[]>() {
      @Override
      public String[] call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String[] _result = new String[_cursor.getCount()];
          int _index = 0;
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
            _result[_index] = _item;
            _index ++;
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
  public LiveData<String[]> getAllBranchNames() {
    final String _sql = "SELECT sBranchNm FROM Branch_Info WHERE cRecdStat = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<String[]>() {
      @Override
      public String[] call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String[] _result = new String[_cursor.getCount()];
          int _index = 0;
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
            }
            _result[_index] = _item;
            _index ++;
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
  public LiveData<List<EBranchInfo>> getAllBranchInfo() {
    final String _sql = "SELECT * FROM Branch_Info WHERE cRecdStat = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<List<EBranchInfo>>() {
      @Override
      public List<EBranchInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchInfo _item;
            _item = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _item.setAreaCode(_tmpAreaCode);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _item.setDivision(_tmpDivision);
            final String _tmpPromoDiv;
            if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
              _tmpPromoDiv = null;
            } else {
              _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
            }
            _item.setPromoDiv(_tmpPromoDiv);
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
  public LiveData<String> getPromoDivision() {
    final String _sql = "SELECT cPromoDiv FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info","User_Info_Master"}, false, new Callable<String>() {
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
  public LiveData<EBranchInfo> getUserBranchInfo() {
    final String _sql = "SELECT * FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info","User_Info_Master"}, false, new Callable<EBranchInfo>() {
      @Override
      public EBranchInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final EBranchInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _result.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _result.setTownIDxx(_tmpTownIDxx);
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _result.setAreaCode(_tmpAreaCode);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _result.setDivision(_tmpDivision);
            final String _tmpPromoDiv;
            if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
              _tmpPromoDiv = null;
            } else {
              _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
            }
            _result.setPromoDiv(_tmpPromoDiv);
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
  public LiveData<String> getBranchName(final String BranchCde) {
    final String _sql = "SELECT sBranchNm FROM Branch_Info WHERE cRecdStat = 1 AND sBranchCd = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BranchCde == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCde);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<String>() {
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
  public String getLatestDataTime() {
    final String _sql = "SELECT MAX(dTimeStmp) FROM Branch_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final String _result;
      if(_cursor.moveToFirst()) {
        final String _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(0);
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
  public String getBranchNameForNotification(final String sBranchCd) {
    final String _sql = "SELECT sBranchNm FROM Branch_Info WHERE sBranchCd =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (sBranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sBranchCd);
    }
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
  public LiveData<String> getBranchAreaCode(final String fsBranchCd) {
    final String _sql = "SELECT sAreaCode FROM Branch_Info WHERE sBranchCd = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsBranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsBranchCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info"}, false, new Callable<String>() {
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
  public LiveData<List<EBranchInfo>> getAreaBranchList() {
    final String _sql = "SELECT * FROM Branch_Info WHERE sAreaCode = (SELECT sAreaCode FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master))";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info","User_Info_Master"}, false, new Callable<List<EBranchInfo>>() {
      @Override
      public List<EBranchInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchInfo _item;
            _item = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _item.setAreaCode(_tmpAreaCode);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _item.setDivision(_tmpDivision);
            final String _tmpPromoDiv;
            if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
              _tmpPromoDiv = null;
            } else {
              _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
            }
            _item.setPromoDiv(_tmpPromoDiv);
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
  public List<EBranchInfo> getBranchList() {
    final String _sql = "SELECT * FROM Branch_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EBranchInfo _item;
        _item = new EBranchInfo();
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _item.setBranchNm(_tmpBranchNm);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _item.setDescript(_tmpDescript);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _item.setTownIDxx(_tmpTownIDxx);
        final String _tmpAreaCode;
        if (_cursor.isNull(_cursorIndexOfAreaCode)) {
          _tmpAreaCode = null;
        } else {
          _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
        }
        _item.setAreaCode(_tmpAreaCode);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _item.setDivision(_tmpDivision);
        final String _tmpPromoDiv;
        if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
          _tmpPromoDiv = null;
        } else {
          _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
        }
        _item.setPromoDiv(_tmpPromoDiv);
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
      _statement.release();
    }
  }

  @Override
  public List<EBranchInfo> getAreaBranchesList() {
    final String _sql = "SELECT * FROM Branch_Info WHERE sAreaCode = (SELECT sAreaCode FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master))";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EBranchInfo _item;
        _item = new EBranchInfo();
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _item.setBranchNm(_tmpBranchNm);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _item.setDescript(_tmpDescript);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _item.setTownIDxx(_tmpTownIDxx);
        final String _tmpAreaCode;
        if (_cursor.isNull(_cursorIndexOfAreaCode)) {
          _tmpAreaCode = null;
        } else {
          _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
        }
        _item.setAreaCode(_tmpAreaCode);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _item.setDivision(_tmpDivision);
        final String _tmpPromoDiv;
        if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
          _tmpPromoDiv = null;
        } else {
          _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
        }
        _item.setPromoDiv(_tmpPromoDiv);
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
      _statement.release();
    }
  }

  @Override
  public LiveData<EBranchInfo> getSelfieLogBranchInfo() {
    final String _sql = "SELECT * FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM Employee_Log_Selfie WHERE cReqCCntx != '1' || cReqRSIxx != '1' ORDER BY dLogTimex DESC LIMIT 1)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info","Employee_Log_Selfie"}, false, new Callable<EBranchInfo>() {
      @Override
      public EBranchInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfAreaCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sAreaCode");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfPromoDiv = CursorUtil.getColumnIndexOrThrow(_cursor, "cPromoDiv");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final EBranchInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _result.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _result.setTownIDxx(_tmpTownIDxx);
            final String _tmpAreaCode;
            if (_cursor.isNull(_cursorIndexOfAreaCode)) {
              _tmpAreaCode = null;
            } else {
              _tmpAreaCode = _cursor.getString(_cursorIndexOfAreaCode);
            }
            _result.setAreaCode(_tmpAreaCode);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _result.setDivision(_tmpDivision);
            final String _tmpPromoDiv;
            if (_cursor.isNull(_cursorIndexOfPromoDiv)) {
              _tmpPromoDiv = null;
            } else {
              _tmpPromoDiv = _cursor.getString(_cursorIndexOfPromoDiv);
            }
            _result.setPromoDiv(_tmpPromoDiv);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
