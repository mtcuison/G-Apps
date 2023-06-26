package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
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
import org.rmj.g3appdriver.GCircle.room.Entities.EInventoryMaster;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DInventoryMaster_Impl implements DInventoryMaster {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EInventoryMaster> __insertionAdapterOfEInventoryMaster;

  private final SharedSQLiteStatement __preparedStmtOfUpdateInventoryMasterRemarks;

  private final SharedSQLiteStatement __preparedStmtOfUpdateInventoryMasterPostedStatus;

  public DInventoryMaster_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEInventoryMaster = new EntityInsertionAdapter<EInventoryMaster>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Inventory_Count_Master` (`sTransNox`,`sBranchCd`,`dTransact`,`sRemarksx`,`nEntryNox`,`sRqstdByx`,`sVerified`,`dVerified`,`sApproved`,`dApproved`,`cTranStat`,`sModified`,`dModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EInventoryMaster value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCd());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRemarksx());
        }
        stmt.bindLong(5, value.getEntryNox());
        if (value.getRqstdByx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRqstdByx());
        }
        if (value.getVerifyBy() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getVerifyBy());
        }
        if (value.getDateVrfy() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDateVrfy());
        }
        if (value.getApprveBy() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getApprveBy());
        }
        if (value.getDateAppv() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getDateAppv());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTranStat());
        }
        if (value.getModifier() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getModifier());
        }
        if (value.getModified() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getModified());
        }
      }
    };
    this.__preparedStmtOfUpdateInventoryMasterRemarks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Inventory_Count_Master SET sRemarksx =? WHERE sTransNox=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateInventoryMasterPostedStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Inventory_Count_Master SET cTranStat = '2' WHERE sTransNox=?";
        return _query;
      }
    };
  }

  @Override
  public void insertInventoryMaster(final EInventoryMaster foMaster) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEInventoryMaster.insert(foMaster);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateInventoryMasterRemarks(final String TransNox, final String Remarks) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateInventoryMasterRemarks.acquire();
    int _argIndex = 1;
    if (Remarks == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Remarks);
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
      __preparedStmtOfUpdateInventoryMasterRemarks.release(_stmt);
    }
  }

  @Override
  public void UpdateInventoryMasterPostedStatus(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateInventoryMasterPostedStatus.acquire();
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
      __preparedStmtOfUpdateInventoryMasterPostedStatus.release(_stmt);
    }
  }

  @Override
  public LiveData<EInventoryMaster> getInventoryMasterForBranch(final String Transact,
      final String BranchCd) {
    final String _sql = "SELECT * FROM Inventory_Count_Master WHERE dTransact =? AND sBranchCd =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (Transact == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Transact);
    }
    _argIndex = 2;
    if (BranchCd == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCd);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Inventory_Count_Master"}, false, new Callable<EInventoryMaster>() {
      @Override
      public EInventoryMaster call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfRqstdByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRqstdByx");
          final int _cursorIndexOfVerifyBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
          final int _cursorIndexOfDateVrfy = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
          final int _cursorIndexOfApprveBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDateAppv = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfModifier = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EInventoryMaster _result;
          if(_cursor.moveToFirst()) {
            _result = new EInventoryMaster();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _result.setTransact(_tmpTransact);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _result.setEntryNox(_tmpEntryNox);
            final String _tmpRqstdByx;
            if (_cursor.isNull(_cursorIndexOfRqstdByx)) {
              _tmpRqstdByx = null;
            } else {
              _tmpRqstdByx = _cursor.getString(_cursorIndexOfRqstdByx);
            }
            _result.setRqstdByx(_tmpRqstdByx);
            final String _tmpVerifyBy;
            if (_cursor.isNull(_cursorIndexOfVerifyBy)) {
              _tmpVerifyBy = null;
            } else {
              _tmpVerifyBy = _cursor.getString(_cursorIndexOfVerifyBy);
            }
            _result.setVerifyBy(_tmpVerifyBy);
            final String _tmpDateVrfy;
            if (_cursor.isNull(_cursorIndexOfDateVrfy)) {
              _tmpDateVrfy = null;
            } else {
              _tmpDateVrfy = _cursor.getString(_cursorIndexOfDateVrfy);
            }
            _result.setDateVrfy(_tmpDateVrfy);
            final String _tmpApprveBy;
            if (_cursor.isNull(_cursorIndexOfApprveBy)) {
              _tmpApprveBy = null;
            } else {
              _tmpApprveBy = _cursor.getString(_cursorIndexOfApprveBy);
            }
            _result.setApprveBy(_tmpApprveBy);
            final String _tmpDateAppv;
            if (_cursor.isNull(_cursorIndexOfDateAppv)) {
              _tmpDateAppv = null;
            } else {
              _tmpDateAppv = _cursor.getString(_cursorIndexOfDateAppv);
            }
            _result.setDateAppv(_tmpDateAppv);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpModifier;
            if (_cursor.isNull(_cursorIndexOfModifier)) {
              _tmpModifier = null;
            } else {
              _tmpModifier = _cursor.getString(_cursorIndexOfModifier);
            }
            _result.setModifier(_tmpModifier);
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
  public EInventoryMaster getInventoryMasterForPosting(final String TransNox) {
    final String _sql = "SELECT * FROM Inventory_Count_Master WHERE sTransNox=?";
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
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfRqstdByx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRqstdByx");
      final int _cursorIndexOfVerifyBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
      final int _cursorIndexOfDateVrfy = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfApprveBy = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDateAppv = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfModifier = CursorUtil.getColumnIndexOrThrow(_cursor, "sModified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EInventoryMaster _result;
      if(_cursor.moveToFirst()) {
        _result = new EInventoryMaster();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpRqstdByx;
        if (_cursor.isNull(_cursorIndexOfRqstdByx)) {
          _tmpRqstdByx = null;
        } else {
          _tmpRqstdByx = _cursor.getString(_cursorIndexOfRqstdByx);
        }
        _result.setRqstdByx(_tmpRqstdByx);
        final String _tmpVerifyBy;
        if (_cursor.isNull(_cursorIndexOfVerifyBy)) {
          _tmpVerifyBy = null;
        } else {
          _tmpVerifyBy = _cursor.getString(_cursorIndexOfVerifyBy);
        }
        _result.setVerifyBy(_tmpVerifyBy);
        final String _tmpDateVrfy;
        if (_cursor.isNull(_cursorIndexOfDateVrfy)) {
          _tmpDateVrfy = null;
        } else {
          _tmpDateVrfy = _cursor.getString(_cursorIndexOfDateVrfy);
        }
        _result.setDateVrfy(_tmpDateVrfy);
        final String _tmpApprveBy;
        if (_cursor.isNull(_cursorIndexOfApprveBy)) {
          _tmpApprveBy = null;
        } else {
          _tmpApprveBy = _cursor.getString(_cursorIndexOfApprveBy);
        }
        _result.setApprveBy(_tmpApprveBy);
        final String _tmpDateAppv;
        if (_cursor.isNull(_cursorIndexOfDateAppv)) {
          _tmpDateAppv = null;
        } else {
          _tmpDateAppv = _cursor.getString(_cursorIndexOfDateAppv);
        }
        _result.setDateAppv(_tmpDateAppv);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpModifier;
        if (_cursor.isNull(_cursorIndexOfModifier)) {
          _tmpModifier = null;
        } else {
          _tmpModifier = _cursor.getString(_cursorIndexOfModifier);
        }
        _result.setModifier(_tmpModifier);
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
  public List<EBranchInfo> GetBranchesForInventory() {
    final String _sql = "SELECT b.* FROM Employee_Log_Selfie a LEFT JOIN Branch_Info b ON a.sBranchCd = b.sBranchCd LEFT JOIN Inventory_Count_Master c ON b.sBranchCd = c.sBranchCd WHERE c.sBranchCd IS NULL OR c.cTranStat = '0'";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
