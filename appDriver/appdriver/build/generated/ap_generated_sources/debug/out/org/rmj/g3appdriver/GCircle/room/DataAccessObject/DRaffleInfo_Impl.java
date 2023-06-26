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
import org.rmj.g3appdriver.GCircle.room.Entities.ERaffleBasis;
import org.rmj.g3appdriver.GCircle.room.Entities.ERaffleInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DRaffleInfo_Impl implements DRaffleInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ERaffleInfo> __insertionAdapterOfERaffleInfo;

  private final EntityInsertionAdapter<ERaffleBasis> __insertionAdapterOfERaffleBasis;

  private final EntityDeletionOrUpdateAdapter<ERaffleInfo> __updateAdapterOfERaffleInfo;

  public DRaffleInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfERaffleInfo = new EntityInsertionAdapter<ERaffleInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `PromoLocal_Detail` (`sBranchCd`,`dTransact`,`sClientNm`,`sAddressx`,`sTownIDxx`,`sProvIDxx`,`sDocTypex`,`sDocNoxxx`,`sMobileNo`,`cSendStat`,`sTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERaffleInfo value) {
        if (value.getBranchCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBranchCd());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getClientNm());
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
        if (value.getProvIDxx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProvIDxx());
        }
        if (value.getDocTypex() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDocTypex());
        }
        if (value.getDocNoxxx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDocNoxxx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMobileNo());
        }
        stmt.bindLong(10, value.getSendStat());
        if (value.getTimeStmp() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfERaffleBasis = new EntityInsertionAdapter<ERaffleBasis>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `FB_Raffle_Transaction_Basis` (`sDivision`,`sTableNme`,`sReferCde`,`sReferNme`,`cCltInfox`,`cRecdStat`,`dModified`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERaffleBasis value) {
        if (value.getDivision() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getDivision());
        }
        if (value.getTableNme() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTableNme());
        }
        if (value.getReferCde() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReferCde());
        }
        if (value.getReferNme() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getReferNme());
        }
        if (value.getCltInfox() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCltInfox());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecdStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
      }
    };
    this.__updateAdapterOfERaffleInfo = new EntityDeletionOrUpdateAdapter<ERaffleInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PromoLocal_Detail` SET `sBranchCd` = ?,`dTransact` = ?,`sClientNm` = ?,`sAddressx` = ?,`sTownIDxx` = ?,`sProvIDxx` = ?,`sDocTypex` = ?,`sDocNoxxx` = ?,`sMobileNo` = ?,`cSendStat` = ?,`sTimeStmp` = ? WHERE `sBranchCd` = ? AND `dTransact` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERaffleInfo value) {
        if (value.getBranchCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBranchCd());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getClientNm());
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
        if (value.getProvIDxx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getProvIDxx());
        }
        if (value.getDocTypex() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDocTypex());
        }
        if (value.getDocNoxxx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDocNoxxx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMobileNo());
        }
        stmt.bindLong(10, value.getSendStat());
        if (value.getTimeStmp() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTimeStmp());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBranchCd());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getTransact());
        }
      }
    };
  }

  @Override
  public void insert(final ERaffleInfo raffleEntry) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERaffleInfo.insert(raffleEntry);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<ERaffleBasis> raffleEntries) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERaffleBasis.insert(raffleEntries);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ERaffleInfo raffleEntry) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfERaffleInfo.handle(raffleEntry);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<ERaffleBasis>> getRaffleBasis() {
    final String _sql = "SELECT * FROM FB_Raffle_Transaction_Basis WHERE cRecdStat = '1' AND sDivision = (SELECT cPromoDiv FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)) GROUP BY sReferNme ORDER BY sReferNme";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"FB_Raffle_Transaction_Basis","Branch_Info","User_Info_Master"}, false, new Callable<List<ERaffleBasis>>() {
      @Override
      public List<ERaffleBasis> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "sDivision");
          final int _cursorIndexOfTableNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sTableNme");
          final int _cursorIndexOfReferCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferCde");
          final int _cursorIndexOfReferNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNme");
          final int _cursorIndexOfCltInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "cCltInfox");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final List<ERaffleBasis> _result = new ArrayList<ERaffleBasis>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ERaffleBasis _item;
            _item = new ERaffleBasis();
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _item.setDivision(_tmpDivision);
            final String _tmpTableNme;
            if (_cursor.isNull(_cursorIndexOfTableNme)) {
              _tmpTableNme = null;
            } else {
              _tmpTableNme = _cursor.getString(_cursorIndexOfTableNme);
            }
            _item.setTableNme(_tmpTableNme);
            final String _tmpReferCde;
            if (_cursor.isNull(_cursorIndexOfReferCde)) {
              _tmpReferCde = null;
            } else {
              _tmpReferCde = _cursor.getString(_cursorIndexOfReferCde);
            }
            _item.setReferCde(_tmpReferCde);
            final String _tmpReferNme;
            if (_cursor.isNull(_cursorIndexOfReferNme)) {
              _tmpReferNme = null;
            } else {
              _tmpReferNme = _cursor.getString(_cursorIndexOfReferNme);
            }
            _item.setReferNme(_tmpReferNme);
            final String _tmpCltInfox;
            if (_cursor.isNull(_cursorIndexOfCltInfox)) {
              _tmpCltInfox = null;
            } else {
              _tmpCltInfox = _cursor.getString(_cursorIndexOfCltInfox);
            }
            _item.setCltInfox(_tmpCltInfox);
            final String _tmpRecdStat;
            if (_cursor.isNull(_cursorIndexOfRecdStat)) {
              _tmpRecdStat = null;
            } else {
              _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
            }
            _item.setRecdStat(_tmpRecdStat);
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
  public LiveData<String[]> getRaffleBasisDesc() {
    final String _sql = "SELECT sReferNme FROM FB_Raffle_Transaction_Basis WHERE cRecdStat = '1' AND sDivision = (SELECT cPromoDiv FROM Branch_Info WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master))GROUP BY sReferNme ORDER BY sReferNme";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"FB_Raffle_Transaction_Basis","Branch_Info","User_Info_Master"}, false, new Callable<String[]>() {
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
  public LiveData<ERaffleInfo> getRaffleInfo() {
    final String _sql = "SELECT * FROM PromoLocal_Detail";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"PromoLocal_Detail"}, false, new Callable<ERaffleInfo>() {
      @Override
      public ERaffleInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
          final int _cursorIndexOfDocTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "sDocTypex");
          final int _cursorIndexOfDocNoxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sDocNoxxx");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "sTimeStmp");
          final ERaffleInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new ERaffleInfo();
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
            final String _tmpClientNm;
            if (_cursor.isNull(_cursorIndexOfClientNm)) {
              _tmpClientNm = null;
            } else {
              _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
            }
            _result.setClientNm(_tmpClientNm);
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
            final String _tmpProvIDxx;
            if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
              _tmpProvIDxx = null;
            } else {
              _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
            }
            _result.setProvIDxx(_tmpProvIDxx);
            final String _tmpDocTypex;
            if (_cursor.isNull(_cursorIndexOfDocTypex)) {
              _tmpDocTypex = null;
            } else {
              _tmpDocTypex = _cursor.getString(_cursorIndexOfDocTypex);
            }
            _result.setDocTypex(_tmpDocTypex);
            final String _tmpDocNoxxx;
            if (_cursor.isNull(_cursorIndexOfDocNoxxx)) {
              _tmpDocNoxxx = null;
            } else {
              _tmpDocNoxxx = _cursor.getString(_cursorIndexOfDocNoxxx);
            }
            _result.setDocNoxxx(_tmpDocNoxxx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final char _tmpSendStat;
            _tmpSendStat = (char) (_cursor.getInt(_cursorIndexOfSendStat));
            _result.setSendStat(_tmpSendStat);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
