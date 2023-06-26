package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

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
import org.rmj.g3appdriver.GConnect.room.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.ERedeemablesInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DRedeemablesInfo_Impl implements DRedeemablesInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ERedeemItemInfo> __insertionAdapterOfERedeemItemInfo;

  private final EntityInsertionAdapter<ERedeemablesInfo> __insertionAdapterOfERedeemablesInfo;

  private final EntityDeletionOrUpdateAdapter<ERedeemablesInfo> __updateAdapterOfERedeemablesInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateExistingItemOnCart;

  public DRedeemablesInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfERedeemItemInfo = new EntityInsertionAdapter<ERedeemItemInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Redeem_Item` (`sPromoIDx`,`sBatchNox`,`sTransNox`,`sGCardNox`,`nItemQtyx`,`nPointsxx`,`sBranchCd`,`sReferNox`,`dOrderedx`,`dPlacOrdr`,`dPickupxx`,`cTranStat`,`cPlcOrder`,`cNotified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERedeemItemInfo value) {
        if (value.getPromoIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPromoIDx());
        }
        if (value.getBatchNox() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBatchNox());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransNox());
        }
        if (value.getGCardNox() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getGCardNox());
        }
        stmt.bindLong(5, value.getItemQtyx());
        stmt.bindDouble(6, value.getPointsxx());
        if (value.getBranchCd() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getBranchCd());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getReferNox());
        }
        if (value.getOrderedx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getOrderedx());
        }
        if (value.getPlacOrdr() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPlacOrdr());
        }
        if (value.getPickupxx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getPickupxx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getTranStat());
        }
        if (value.getPlcOrder() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPlcOrder());
        }
        if (value.getNotified() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getNotified());
        }
      }
    };
    this.__insertionAdapterOfERedeemablesInfo = new EntityInsertionAdapter<ERedeemablesInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Redeemables` (`sTransNox`,`sPromoCde`,`sPromoDsc`,`nPointsxx`,`sImageUrl`,`cPreOrder`,`dDateFrom`,`dDateThru`,`cNotified`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERedeemablesInfo value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getPromoCde() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPromoCde());
        }
        if (value.getPromoDsc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPromoDsc());
        }
        stmt.bindDouble(4, value.getPointsxx());
        if (value.getImageUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImageUrl());
        }
        if (value.getPreOrder() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPreOrder());
        }
        if (value.getDateFrom() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDateFrom());
        }
        if (value.getDateThru() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDateThru());
        }
        if (value.getNotified() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getNotified());
        }
      }
    };
    this.__updateAdapterOfERedeemablesInfo = new EntityDeletionOrUpdateAdapter<ERedeemablesInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Redeemables` SET `sTransNox` = ?,`sPromoCde` = ?,`sPromoDsc` = ?,`nPointsxx` = ?,`sImageUrl` = ?,`cPreOrder` = ?,`dDateFrom` = ?,`dDateThru` = ?,`cNotified` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERedeemablesInfo value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getPromoCde() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPromoCde());
        }
        if (value.getPromoDsc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPromoDsc());
        }
        stmt.bindDouble(4, value.getPointsxx());
        if (value.getImageUrl() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImageUrl());
        }
        if (value.getPreOrder() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getPreOrder());
        }
        if (value.getDateFrom() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDateFrom());
        }
        if (value.getDateThru() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDateThru());
        }
        if (value.getNotified() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getNotified());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateExistingItemOnCart = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Redeem_Item SET nItemQtyx =? WHERE sTransNox=? AND sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ERedeemItemInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERedeemItemInfo.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<ERedeemablesInfo> foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERedeemablesInfo.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ERedeemablesInfo redeemablesInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfERedeemablesInfo.handle(redeemablesInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateExistingItemOnCart(final String TransNox, final String PromoIDx,
      final int ItemQty) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateExistingItemOnCart.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, ItemQty);
    _argIndex = 2;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 3;
    if (PromoIDx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, PromoIDx);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateExistingItemOnCart.release(_stmt);
    }
  }

  @Override
  public LiveData<Integer> countRedeemables() {
    final String _sql = "SELECT COUNT(sTransNox) FROM Redeemables";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeemables"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<ERedeemItemInfo> getRedeemableIfExist(final String TransNox, final String PromoIDx) {
    final String _sql = "SELECT * FROM Redeem_Item WHERE sTransNox =? AND sPromoIDx=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (PromoIDx == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, PromoIDx);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPromoIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPromoIDx");
      final int _cursorIndexOfBatchNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sBatchNox");
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfGCardNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGCardNox");
      final int _cursorIndexOfItemQtyx = CursorUtil.getColumnIndexOrThrow(_cursor, "nItemQtyx");
      final int _cursorIndexOfPointsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nPointsxx");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfOrderedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dOrderedx");
      final int _cursorIndexOfPlacOrdr = CursorUtil.getColumnIndexOrThrow(_cursor, "dPlacOrdr");
      final int _cursorIndexOfPickupxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dPickupxx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfPlcOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "cPlcOrder");
      final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
      final List<ERedeemItemInfo> _result = new ArrayList<ERedeemItemInfo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ERedeemItemInfo _item;
        _item = new ERedeemItemInfo();
        final String _tmpPromoIDx;
        if (_cursor.isNull(_cursorIndexOfPromoIDx)) {
          _tmpPromoIDx = null;
        } else {
          _tmpPromoIDx = _cursor.getString(_cursorIndexOfPromoIDx);
        }
        _item.setPromoIDx(_tmpPromoIDx);
        final String _tmpBatchNox;
        if (_cursor.isNull(_cursorIndexOfBatchNox)) {
          _tmpBatchNox = null;
        } else {
          _tmpBatchNox = _cursor.getString(_cursorIndexOfBatchNox);
        }
        _item.setBatchNox(_tmpBatchNox);
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpGCardNox;
        if (_cursor.isNull(_cursorIndexOfGCardNox)) {
          _tmpGCardNox = null;
        } else {
          _tmpGCardNox = _cursor.getString(_cursorIndexOfGCardNox);
        }
        _item.setGCardNox(_tmpGCardNox);
        final int _tmpItemQtyx;
        _tmpItemQtyx = _cursor.getInt(_cursorIndexOfItemQtyx);
        _item.setItemQtyx(_tmpItemQtyx);
        final double _tmpPointsxx;
        _tmpPointsxx = _cursor.getDouble(_cursorIndexOfPointsxx);
        _item.setPointsxx(_tmpPointsxx);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _item.setReferNox(_tmpReferNox);
        final String _tmpOrderedx;
        if (_cursor.isNull(_cursorIndexOfOrderedx)) {
          _tmpOrderedx = null;
        } else {
          _tmpOrderedx = _cursor.getString(_cursorIndexOfOrderedx);
        }
        _item.setOrderedx(_tmpOrderedx);
        final String _tmpPlacOrdr;
        if (_cursor.isNull(_cursorIndexOfPlacOrdr)) {
          _tmpPlacOrdr = null;
        } else {
          _tmpPlacOrdr = _cursor.getString(_cursorIndexOfPlacOrdr);
        }
        _item.setPlacOrdr(_tmpPlacOrdr);
        final String _tmpPickupxx;
        if (_cursor.isNull(_cursorIndexOfPickupxx)) {
          _tmpPickupxx = null;
        } else {
          _tmpPickupxx = _cursor.getString(_cursorIndexOfPickupxx);
        }
        _item.setPickupxx(_tmpPickupxx);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpPlcOrder;
        if (_cursor.isNull(_cursorIndexOfPlcOrder)) {
          _tmpPlcOrder = null;
        } else {
          _tmpPlcOrder = _cursor.getString(_cursorIndexOfPlcOrder);
        }
        _item.setPlcOrder(_tmpPlcOrder);
        final String _tmpNotified;
        if (_cursor.isNull(_cursorIndexOfNotified)) {
          _tmpNotified = null;
        } else {
          _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
        }
        _item.setNotified(_tmpNotified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int GetRedeemablesCount() {
    final String _sql = "SELECT COUNT(*) FROM Redeemables";
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
  public LiveData<Integer> getOrdersCount(final String GCardNox) {
    final String _sql = "SELECT COUNT(sPromoIDx) FROM Redeem_Item WHERE sGcardNox =? AND cTranStat != 0 GROUP BY sReferNox";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (GCardNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, GCardNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeem_Item"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<ERedeemItemInfo>> getOrdersList(final String GCardNox) {
    final String _sql = "SELECT * FROM Redeem_Item WHERE sGcardNox =? AND cTranStat != 0 GROUP BY sReferNox";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (GCardNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, GCardNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeem_Item"}, false, new Callable<List<ERedeemItemInfo>>() {
      @Override
      public List<ERedeemItemInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfPromoIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPromoIDx");
          final int _cursorIndexOfBatchNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sBatchNox");
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfGCardNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGCardNox");
          final int _cursorIndexOfItemQtyx = CursorUtil.getColumnIndexOrThrow(_cursor, "nItemQtyx");
          final int _cursorIndexOfPointsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nPointsxx");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfOrderedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dOrderedx");
          final int _cursorIndexOfPlacOrdr = CursorUtil.getColumnIndexOrThrow(_cursor, "dPlacOrdr");
          final int _cursorIndexOfPickupxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dPickupxx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfPlcOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "cPlcOrder");
          final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
          final List<ERedeemItemInfo> _result = new ArrayList<ERedeemItemInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ERedeemItemInfo _item;
            _item = new ERedeemItemInfo();
            final String _tmpPromoIDx;
            if (_cursor.isNull(_cursorIndexOfPromoIDx)) {
              _tmpPromoIDx = null;
            } else {
              _tmpPromoIDx = _cursor.getString(_cursorIndexOfPromoIDx);
            }
            _item.setPromoIDx(_tmpPromoIDx);
            final String _tmpBatchNox;
            if (_cursor.isNull(_cursorIndexOfBatchNox)) {
              _tmpBatchNox = null;
            } else {
              _tmpBatchNox = _cursor.getString(_cursorIndexOfBatchNox);
            }
            _item.setBatchNox(_tmpBatchNox);
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpGCardNox;
            if (_cursor.isNull(_cursorIndexOfGCardNox)) {
              _tmpGCardNox = null;
            } else {
              _tmpGCardNox = _cursor.getString(_cursorIndexOfGCardNox);
            }
            _item.setGCardNox(_tmpGCardNox);
            final int _tmpItemQtyx;
            _tmpItemQtyx = _cursor.getInt(_cursorIndexOfItemQtyx);
            _item.setItemQtyx(_tmpItemQtyx);
            final double _tmpPointsxx;
            _tmpPointsxx = _cursor.getDouble(_cursorIndexOfPointsxx);
            _item.setPointsxx(_tmpPointsxx);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpOrderedx;
            if (_cursor.isNull(_cursorIndexOfOrderedx)) {
              _tmpOrderedx = null;
            } else {
              _tmpOrderedx = _cursor.getString(_cursorIndexOfOrderedx);
            }
            _item.setOrderedx(_tmpOrderedx);
            final String _tmpPlacOrdr;
            if (_cursor.isNull(_cursorIndexOfPlacOrdr)) {
              _tmpPlacOrdr = null;
            } else {
              _tmpPlacOrdr = _cursor.getString(_cursorIndexOfPlacOrdr);
            }
            _item.setPlacOrdr(_tmpPlacOrdr);
            final String _tmpPickupxx;
            if (_cursor.isNull(_cursorIndexOfPickupxx)) {
              _tmpPickupxx = null;
            } else {
              _tmpPickupxx = _cursor.getString(_cursorIndexOfPickupxx);
            }
            _item.setPickupxx(_tmpPickupxx);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpPlcOrder;
            if (_cursor.isNull(_cursorIndexOfPlcOrder)) {
              _tmpPlcOrder = null;
            } else {
              _tmpPlcOrder = _cursor.getString(_cursorIndexOfPlcOrder);
            }
            _item.setPlcOrder(_tmpPlcOrder);
            final String _tmpNotified;
            if (_cursor.isNull(_cursorIndexOfNotified)) {
              _tmpNotified = null;
            } else {
              _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
            }
            _item.setNotified(_tmpNotified);
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
  public LiveData<List<ERedeemablesInfo>> getRedeemablesList() {
    final String _sql = "SELECT * FROM Redeemables WHERE strftime('%Y-%m-%d','now') BETWEEN dDateFrom AND IFNULL(dDateThru, strftime('%Y-%m-%d','now'))";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeemables"}, false, new Callable<List<ERedeemablesInfo>>() {
      @Override
      public List<ERedeemablesInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfPromoCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sPromoCde");
          final int _cursorIndexOfPromoDsc = CursorUtil.getColumnIndexOrThrow(_cursor, "sPromoDsc");
          final int _cursorIndexOfPointsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nPointsxx");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageUrl");
          final int _cursorIndexOfPreOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "cPreOrder");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
          final List<ERedeemablesInfo> _result = new ArrayList<ERedeemablesInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ERedeemablesInfo _item;
            _item = new ERedeemablesInfo();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpPromoCde;
            if (_cursor.isNull(_cursorIndexOfPromoCde)) {
              _tmpPromoCde = null;
            } else {
              _tmpPromoCde = _cursor.getString(_cursorIndexOfPromoCde);
            }
            _item.setPromoCde(_tmpPromoCde);
            final String _tmpPromoDsc;
            if (_cursor.isNull(_cursorIndexOfPromoDsc)) {
              _tmpPromoDsc = null;
            } else {
              _tmpPromoDsc = _cursor.getString(_cursorIndexOfPromoDsc);
            }
            _item.setPromoDsc(_tmpPromoDsc);
            final double _tmpPointsxx;
            _tmpPointsxx = _cursor.getDouble(_cursorIndexOfPointsxx);
            _item.setPointsxx(_tmpPointsxx);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            _item.setImageUrl(_tmpImageUrl);
            final String _tmpPreOrder;
            if (_cursor.isNull(_cursorIndexOfPreOrder)) {
              _tmpPreOrder = null;
            } else {
              _tmpPreOrder = _cursor.getString(_cursorIndexOfPreOrder);
            }
            _item.setPreOrder(_tmpPreOrder);
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
            final String _tmpNotified;
            if (_cursor.isNull(_cursorIndexOfNotified)) {
              _tmpNotified = null;
            } else {
              _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
            }
            _item.setNotified(_tmpNotified);
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
  public LiveData<List<ERedeemablesInfo>> getRedeemablesList(final String fsVal) {
    final String _sql = "SELECT * FROM Redeemables WHERE nPointsxx =? AND strftime('%Y-%m-%d','now') BETWEEN dDateFrom AND IFNULL(dDateThru, strftime('%Y-%m-%d','now'))";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeemables"}, false, new Callable<List<ERedeemablesInfo>>() {
      @Override
      public List<ERedeemablesInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfPromoCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sPromoCde");
          final int _cursorIndexOfPromoDsc = CursorUtil.getColumnIndexOrThrow(_cursor, "sPromoDsc");
          final int _cursorIndexOfPointsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nPointsxx");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageUrl");
          final int _cursorIndexOfPreOrder = CursorUtil.getColumnIndexOrThrow(_cursor, "cPreOrder");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
          final List<ERedeemablesInfo> _result = new ArrayList<ERedeemablesInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ERedeemablesInfo _item;
            _item = new ERedeemablesInfo();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpPromoCde;
            if (_cursor.isNull(_cursorIndexOfPromoCde)) {
              _tmpPromoCde = null;
            } else {
              _tmpPromoCde = _cursor.getString(_cursorIndexOfPromoCde);
            }
            _item.setPromoCde(_tmpPromoCde);
            final String _tmpPromoDsc;
            if (_cursor.isNull(_cursorIndexOfPromoDsc)) {
              _tmpPromoDsc = null;
            } else {
              _tmpPromoDsc = _cursor.getString(_cursorIndexOfPromoDsc);
            }
            _item.setPromoDsc(_tmpPromoDsc);
            final double _tmpPointsxx;
            _tmpPointsxx = _cursor.getDouble(_cursorIndexOfPointsxx);
            _item.setPointsxx(_tmpPointsxx);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            _item.setImageUrl(_tmpImageUrl);
            final String _tmpPreOrder;
            if (_cursor.isNull(_cursorIndexOfPreOrder)) {
              _tmpPreOrder = null;
            } else {
              _tmpPreOrder = _cursor.getString(_cursorIndexOfPreOrder);
            }
            _item.setPreOrder(_tmpPreOrder);
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
            final String _tmpNotified;
            if (_cursor.isNull(_cursorIndexOfNotified)) {
              _tmpNotified = null;
            } else {
              _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
            }
            _item.setNotified(_tmpNotified);
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
  public LiveData<List<Double>> GetRedeemablePointsFilter() {
    final String _sql = "SELECT nPointsxx AS Filter FROM Redeemables WHERE strftime('%Y-%m-%d','now') BETWEEN dDateFrom AND IFNULL(dDateThru, strftime('%Y-%m-%d','now')) GROUP BY nPointsxx";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeemables"}, false, new Callable<List<Double>>() {
      @Override
      public List<Double> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<Double> _result = new ArrayList<Double>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Double _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getDouble(0);
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
  public LiveData<List<DRedeemablesInfo.TransactionOrder>> getTransactionOrderList(
      final String GCardNox) {
    final String _sql = "SELECT c.sReferNox, c.dOrderedx, b.sBranchNm, b.sAddressx, SUM(c.nPointsxx) as TotAmnt FROM Redeem_Item c LEFT JOIN BranchInfo b ON c.sBranchCd = b.sBranchCd LEFT JOIN Redeemables a ON a.sTransNox = c.sPromoIDx WHERE c.sGCardNox =? AND c.cPlcOrder = '1' AND c.cTranStat = '1' GROUP BY c.sReferNox";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (GCardNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, GCardNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeem_Item","BranchInfo","Redeemables"}, false, new Callable<List<DRedeemablesInfo.TransactionOrder>>() {
      @Override
      public List<DRedeemablesInfo.TransactionOrder> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTotAmnt = 4;
          final List<DRedeemablesInfo.TransactionOrder> _result = new ArrayList<DRedeemablesInfo.TransactionOrder>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DRedeemablesInfo.TransactionOrder _item;
            _item = new DRedeemablesInfo.TransactionOrder();
            if (_cursor.isNull(_cursorIndexOfTotAmnt)) {
              _item.TotAmnt = null;
            } else {
              _item.TotAmnt = _cursor.getString(_cursorIndexOfTotAmnt);
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
  public LiveData<List<DRedeemablesInfo.OrderItems>> getOrderItems(final String ReferNox,
      final String GCardNox) {
    final String _sql = "SELECT a.sPromoIDx as itemID, b.sPromoDsc as itemName, a.nItemQtyx as itemQtyx, a.nPointsxx as itemPnts FROM Redeem_Item a LEFT JOIN Redeemables b ON a.sPromoIDx = b.sTransNox WHERE a.cTranStat = '1' AND a.cPlcOrder = '1' AND a.sGCardNox =? AND a.sReferNox =? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (GCardNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, GCardNox);
    }
    _argIndex = 2;
    if (ReferNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ReferNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeem_Item","Redeemables"}, false, new Callable<List<DRedeemablesInfo.OrderItems>>() {
      @Override
      public List<DRedeemablesInfo.OrderItems> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfItemID = 0;
          final int _cursorIndexOfItemName = 1;
          final int _cursorIndexOfItemQtyx = 2;
          final int _cursorIndexOfItemPnts = 3;
          final List<DRedeemablesInfo.OrderItems> _result = new ArrayList<DRedeemablesInfo.OrderItems>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DRedeemablesInfo.OrderItems _item;
            _item = new DRedeemablesInfo.OrderItems();
            if (_cursor.isNull(_cursorIndexOfItemID)) {
              _item.itemID = null;
            } else {
              _item.itemID = _cursor.getString(_cursorIndexOfItemID);
            }
            if (_cursor.isNull(_cursorIndexOfItemName)) {
              _item.itemName = null;
            } else {
              _item.itemName = _cursor.getString(_cursorIndexOfItemName);
            }
            if (_cursor.isNull(_cursorIndexOfItemQtyx)) {
              _item.itemQtyx = null;
            } else {
              _item.itemQtyx = _cursor.getString(_cursorIndexOfItemQtyx);
            }
            if (_cursor.isNull(_cursorIndexOfItemPnts)) {
              _item.itemPnts = null;
            } else {
              _item.itemPnts = _cursor.getString(_cursorIndexOfItemPnts);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
