package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

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
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GConnect.room.Entities.EGuanzonPanalo;
import org.rmj.g3appdriver.GConnect.room.Entities.EPanaloReward;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DPanalo_Impl implements DPanalo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EPanaloReward> __insertionAdapterOfEPanaloReward;

  private final EntityInsertionAdapter<EGuanzonPanalo> __insertionAdapterOfEGuanzonPanalo;

  private final EntityDeletionOrUpdateAdapter<EPanaloReward> __updateAdapterOfEPanaloReward;

  private final EntityDeletionOrUpdateAdapter<EGuanzonPanalo> __updateAdapterOfEGuanzonPanalo;

  public DPanalo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEPanaloReward = new EntityInsertionAdapter<EPanaloReward>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Panalo_Reward` (`sPanaloCD`,`cTranStat`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPanaloReward value) {
        if (value.getPanaloCD() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPanaloCD());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTranStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfEGuanzonPanalo = new EntityInsertionAdapter<EGuanzonPanalo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Guanzon_Panalo` (`sPanaloQC`,`dTransact`,`sUserIDxx`,`sPanaloCD`,`sPanaloDs`,`sAcctNmbr`,`nAmountxx`,`sItemCode`,`sItemDesc`,`nItemQtyx`,`nRedeemxx`,`dExpiryDt`,`sBranchNm`,`dRedeemxx`,`cTranStat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGuanzonPanalo value) {
        if (value.getPanaloQC() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPanaloQC());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserIDxx());
        }
        if (value.getPanaloCD() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPanaloCD());
        }
        if (value.getPanaloDs() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPanaloDs());
        }
        if (value.getAcctNmbr() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAcctNmbr());
        }
        if (value.getAmountxx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getAmountxx());
        }
        if (value.getItemCode() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getItemCode());
        }
        if (value.getItemDesc() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getItemDesc());
        }
        if (value.getItemQtyx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getItemQtyx());
        }
        if (value.getRedeemxx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getRedeemxx());
        }
        if (value.getExpiryDt() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getExpiryDt());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getBranchNm());
        }
        if (value.getRedeemed() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRedeemed());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
      }
    };
    this.__updateAdapterOfEPanaloReward = new EntityDeletionOrUpdateAdapter<EPanaloReward>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Panalo_Reward` SET `sPanaloCD` = ?,`cTranStat` = ?,`dModified` = ?,`dTimeStmp` = ? WHERE `sPanaloCD` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPanaloReward value) {
        if (value.getPanaloCD() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPanaloCD());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTranStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
        if (value.getPanaloCD() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPanaloCD());
        }
      }
    };
    this.__updateAdapterOfEGuanzonPanalo = new EntityDeletionOrUpdateAdapter<EGuanzonPanalo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Guanzon_Panalo` SET `sPanaloQC` = ?,`dTransact` = ?,`sUserIDxx` = ?,`sPanaloCD` = ?,`sPanaloDs` = ?,`sAcctNmbr` = ?,`nAmountxx` = ?,`sItemCode` = ?,`sItemDesc` = ?,`nItemQtyx` = ?,`nRedeemxx` = ?,`dExpiryDt` = ?,`sBranchNm` = ?,`dRedeemxx` = ?,`cTranStat` = ? WHERE `sPanaloQC` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGuanzonPanalo value) {
        if (value.getPanaloQC() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPanaloQC());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserIDxx());
        }
        if (value.getPanaloCD() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPanaloCD());
        }
        if (value.getPanaloDs() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPanaloDs());
        }
        if (value.getAcctNmbr() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAcctNmbr());
        }
        if (value.getAmountxx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindDouble(7, value.getAmountxx());
        }
        if (value.getItemCode() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getItemCode());
        }
        if (value.getItemDesc() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getItemDesc());
        }
        if (value.getItemQtyx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getItemQtyx());
        }
        if (value.getRedeemxx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindDouble(11, value.getRedeemxx());
        }
        if (value.getExpiryDt() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getExpiryDt());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getBranchNm());
        }
        if (value.getRedeemed() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getRedeemed());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
        if (value.getPanaloQC() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getPanaloQC());
        }
      }
    };
  }

  @Override
  public void Save(final EPanaloReward foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEPanaloReward.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Save(final EGuanzonPanalo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEGuanzonPanalo.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final EPanaloReward foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEPanaloReward.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final EGuanzonPanalo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEGuanzonPanalo.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public EGuanzonPanalo GetPanaloRedeem() {
    final String _sql = "SELECT * FROM Guanzon_Panalo";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPanaloQC = CursorUtil.getColumnIndexOrThrow(_cursor, "sPanaloQC");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfPanaloCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sPanaloCD");
      final int _cursorIndexOfPanaloDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sPanaloDs");
      final int _cursorIndexOfAcctNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sAcctNmbr");
      final int _cursorIndexOfAmountxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAmountxx");
      final int _cursorIndexOfItemCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sItemCode");
      final int _cursorIndexOfItemDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "sItemDesc");
      final int _cursorIndexOfItemQtyx = CursorUtil.getColumnIndexOrThrow(_cursor, "nItemQtyx");
      final int _cursorIndexOfRedeemxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRedeemxx");
      final int _cursorIndexOfExpiryDt = CursorUtil.getColumnIndexOrThrow(_cursor, "dExpiryDt");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfRedeemed = CursorUtil.getColumnIndexOrThrow(_cursor, "dRedeemxx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final EGuanzonPanalo _result;
      if(_cursor.moveToFirst()) {
        _result = new EGuanzonPanalo();
        final String _tmpPanaloQC;
        if (_cursor.isNull(_cursorIndexOfPanaloQC)) {
          _tmpPanaloQC = null;
        } else {
          _tmpPanaloQC = _cursor.getString(_cursorIndexOfPanaloQC);
        }
        _result.setPanaloQC(_tmpPanaloQC);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpPanaloCD;
        if (_cursor.isNull(_cursorIndexOfPanaloCD)) {
          _tmpPanaloCD = null;
        } else {
          _tmpPanaloCD = _cursor.getString(_cursorIndexOfPanaloCD);
        }
        _result.setPanaloCD(_tmpPanaloCD);
        final String _tmpPanaloDs;
        if (_cursor.isNull(_cursorIndexOfPanaloDs)) {
          _tmpPanaloDs = null;
        } else {
          _tmpPanaloDs = _cursor.getString(_cursorIndexOfPanaloDs);
        }
        _result.setPanaloDs(_tmpPanaloDs);
        final String _tmpAcctNmbr;
        if (_cursor.isNull(_cursorIndexOfAcctNmbr)) {
          _tmpAcctNmbr = null;
        } else {
          _tmpAcctNmbr = _cursor.getString(_cursorIndexOfAcctNmbr);
        }
        _result.setAcctNmbr(_tmpAcctNmbr);
        final Double _tmpAmountxx;
        if (_cursor.isNull(_cursorIndexOfAmountxx)) {
          _tmpAmountxx = null;
        } else {
          _tmpAmountxx = _cursor.getDouble(_cursorIndexOfAmountxx);
        }
        _result.setAmountxx(_tmpAmountxx);
        final String _tmpItemCode;
        if (_cursor.isNull(_cursorIndexOfItemCode)) {
          _tmpItemCode = null;
        } else {
          _tmpItemCode = _cursor.getString(_cursorIndexOfItemCode);
        }
        _result.setItemCode(_tmpItemCode);
        final String _tmpItemDesc;
        if (_cursor.isNull(_cursorIndexOfItemDesc)) {
          _tmpItemDesc = null;
        } else {
          _tmpItemDesc = _cursor.getString(_cursorIndexOfItemDesc);
        }
        _result.setItemDesc(_tmpItemDesc);
        final Integer _tmpItemQtyx;
        if (_cursor.isNull(_cursorIndexOfItemQtyx)) {
          _tmpItemQtyx = null;
        } else {
          _tmpItemQtyx = _cursor.getInt(_cursorIndexOfItemQtyx);
        }
        _result.setItemQtyx(_tmpItemQtyx);
        final Double _tmpRedeemxx;
        if (_cursor.isNull(_cursorIndexOfRedeemxx)) {
          _tmpRedeemxx = null;
        } else {
          _tmpRedeemxx = _cursor.getDouble(_cursorIndexOfRedeemxx);
        }
        _result.setRedeemxx(_tmpRedeemxx);
        final String _tmpExpiryDt;
        if (_cursor.isNull(_cursorIndexOfExpiryDt)) {
          _tmpExpiryDt = null;
        } else {
          _tmpExpiryDt = _cursor.getString(_cursorIndexOfExpiryDt);
        }
        _result.setExpiryDt(_tmpExpiryDt);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpRedeemed;
        if (_cursor.isNull(_cursorIndexOfRedeemed)) {
          _tmpRedeemed = null;
        } else {
          _tmpRedeemed = _cursor.getString(_cursorIndexOfRedeemed);
        }
        _result.setRedeemed(_tmpRedeemed);
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

  @Override
  public LiveData<EPanaloReward> GetPanaloRewardNotice() {
    final String _sql = "SELECT * FROM Panalo_Reward";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Panalo_Reward"}, false, new Callable<EPanaloReward>() {
      @Override
      public EPanaloReward call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPanaloCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sPanaloCD");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final EPanaloReward _result;
          if(_cursor.moveToFirst()) {
            _result = new EPanaloReward();
            final String _tmpPanaloCD;
            if (_cursor.isNull(_cursorIndexOfPanaloCD)) {
              _tmpPanaloCD = null;
            } else {
              _tmpPanaloCD = _cursor.getString(_cursorIndexOfPanaloCD);
            }
            _result.setPanaloCD(_tmpPanaloCD);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
