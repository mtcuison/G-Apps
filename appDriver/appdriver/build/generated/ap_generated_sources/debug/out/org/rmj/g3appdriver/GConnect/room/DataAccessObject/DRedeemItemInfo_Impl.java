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
import org.rmj.g3appdriver.GConnect.room.Entities.EBranchInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.ERedeemItemInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DRedeemItemInfo_Impl implements DRedeemItemInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ERedeemItemInfo> __insertionAdapterOfERedeemItemInfo;

  private final EntityDeletionOrUpdateAdapter<ERedeemItemInfo> __updateAdapterOfERedeemItemInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateItemDetails;

  private final SharedSQLiteStatement __preparedStmtOfRemoveItemFromCart;

  private final SharedSQLiteStatement __preparedStmtOfPlaceOrder;

  private final SharedSQLiteStatement __preparedStmtOfUpdateExistingItemOnCart;

  public DRedeemItemInfo_Impl(RoomDatabase __db) {
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
    this.__updateAdapterOfERedeemItemInfo = new EntityDeletionOrUpdateAdapter<ERedeemItemInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Redeem_Item` SET `sPromoIDx` = ?,`sBatchNox` = ?,`sTransNox` = ?,`sGCardNox` = ?,`nItemQtyx` = ?,`nPointsxx` = ?,`sBranchCd` = ?,`sReferNox` = ?,`dOrderedx` = ?,`dPlacOrdr` = ?,`dPickupxx` = ?,`cTranStat` = ?,`cPlcOrder` = ?,`cNotified` = ? WHERE `sPromoIDx` = ?";
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
        if (value.getPromoIDx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getPromoIDx());
        }
      }
    };
    this.__preparedStmtOfUpdateItemDetails = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Redeem_Item SET nItemQtyx = ?, nPointsxx = ? WHERE sPromoIDx = ? AND sGCardNox = ?";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveItemFromCart = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM redeem_item WHERE sTransNox = ?";
        return _query;
      }
    };
    this.__preparedStmtOfPlaceOrder = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Redeem_Item SET sBranchCd = ?, cTranStat = '1', cPlcOrder = '1' WHERE sGCardNox = ?";
        return _query;
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
  public void insert(final ERedeemItemInfo redeemItemInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERedeemItemInfo.insert(redeemItemInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<ERedeemItemInfo> redeemItemInfoList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERedeemItemInfo.insert(redeemItemInfoList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ERedeemItemInfo redeemItemInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfERedeemItemInfo.handle(redeemItemInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateItemDetails(final String fsGcardNo, final String fsPromoId, final int fnNewCnt,
      final double fnNewPts) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateItemDetails.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, fnNewCnt);
    _argIndex = 2;
    _stmt.bindDouble(_argIndex, fnNewPts);
    _argIndex = 3;
    if (fsPromoId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsPromoId);
    }
    _argIndex = 4;
    if (fsGcardNo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsGcardNo);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateItemDetails.release(_stmt);
    }
  }

  @Override
  public void removeItemFromCart(final String fsPromoId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveItemFromCart.acquire();
    int _argIndex = 1;
    if (fsPromoId == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsPromoId);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveItemFromCart.release(_stmt);
    }
  }

  @Override
  public void placeOrder(final String fsGcardNo, final String fsBranch) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfPlaceOrder.acquire();
    int _argIndex = 1;
    if (fsBranch == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsBranch);
    }
    _argIndex = 2;
    if (fsGcardNo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsGcardNo);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfPlaceOrder.release(_stmt);
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
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT(*) FROM Redeem_Item";
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
  public String getCardNox() {
    final String _sql = "SELECT sGCardNox FROM Gcard_App_Master WHERE cActvStat = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public String GetGCardNumber() {
    final String _sql = "SELECT sCardNmbr FROM Gcard_App_Master WHERE cActvStat = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public String GetUserID() {
    final String _sql = "SELECT sUserIDxx FROM Client_Profile_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public double GetRemainingGcardPoints() {
    final String _sql = "SELECT (SELECT sAvlPoint FROM GCard_App_Master WHERE cActvStat = '1') - (SELECT nPointsxx FROM Redeem_Item WHERE sGCardNox = (SELECT sGCardNox FROM GCard_App_Master WHERE cActvStat = '1')) AS RemainingPoints";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getGCardTotPoints(final String CardNmbr) {
    final String _sql = "SELECT sAvlPoint FROM Gcard_App_Master WHERE sCardNmbr =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (CardNmbr == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, CardNmbr);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getOrderPoints(final String GCardNox) {
    final String _sql = "SELECT SUM(nPointsxx) FROM redeem_item WHERE sGCardNox =? AND cTranStat IN ('0', '1')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (GCardNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, GCardNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<ERedeemItemInfo>> getCartItems() {
    final String _sql = "SELECT * FROM Redeem_Item WHERE sGCardNox = (SELECT sGCardNox FROM GCard_App_Master WHERE cActvStat = '1')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeem_Item","GCard_App_Master"}, false, new Callable<List<ERedeemItemInfo>>() {
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
  public LiveData<Integer> getCartItemCount(final String GCardNox) {
    final String _sql = "SELECT COUNT(*) FROM Redeem_Item WHERE sGCardNox =? AND cTranStat = '0' AND cPlcOrder = '0'";
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
  public LiveData<Integer> getCartOrderCount(final String GCardNox) {
    final String _sql = "SELECT COUNT(*) FROM Redeem_Item WHERE sGCardNox =? AND cTranStat = '1' AND cPlcOrder = '1'";
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
  public LiveData<List<DRedeemItemInfo.ItemDetail>> getExistingItemDetail(final String fsPromoId) {
    final String _sql = "SELECT nItemQtyx AS quantity, nPointsxx AS points FROM Redeem_Item WHERE sPromoIDx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsPromoId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsPromoId);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeem_Item"}, false, new Callable<List<DRedeemItemInfo.ItemDetail>>() {
      @Override
      public List<DRedeemItemInfo.ItemDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfQuantity = 0;
          final int _cursorIndexOfPoints = 1;
          final List<DRedeemItemInfo.ItemDetail> _result = new ArrayList<DRedeemItemInfo.ItemDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DRedeemItemInfo.ItemDetail _item;
            _item = new DRedeemItemInfo.ItemDetail();
            _item.quantity = _cursor.getInt(_cursorIndexOfQuantity);
            _item.points = _cursor.getDouble(_cursorIndexOfPoints);
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
  public LiveData<List<DRedeemItemInfo.CartItemsDetail>> getCartItemsDetail(
      final String fsGcardNo) {
    final String _sql = "SELECT C.sPromoIDx, C.sBatchNox, C.sTransNox, C.sGCardNox, C.nItemQtyx, C.nPointsxx, C.sBranchCd, C.sReferNox, C.dOrderedx, C.dPlacOrdr, C.dPickupxx, C.cTranStat, C.cPlcOrder, C.cNotified, R.sPromoDsc, R.nPointsxx AS origPoints, R.sImageUrl, G.sAvlPoint FROM redeem_item as C LEFT JOIN redeemables as R ON C.sPromoIDx = R.sTransNox LEFT JOIN gcard_app_master as G ON C.sGCardNox = G.sGCardNox WHERE C.cTranStat = '0' AND C.sGCardNox = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsGcardNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsGcardNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"redeem_item","redeemables","gcard_app_master"}, false, new Callable<List<DRedeemItemInfo.CartItemsDetail>>() {
      @Override
      public List<DRedeemItemInfo.CartItemsDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSPromoIDx = 0;
          final int _cursorIndexOfSBatchNox = 1;
          final int _cursorIndexOfSTransNox = 2;
          final int _cursorIndexOfSGCardNox = 3;
          final int _cursorIndexOfNItemQtyx = 4;
          final int _cursorIndexOfNPointsxx = 5;
          final int _cursorIndexOfSBranchCd = 6;
          final int _cursorIndexOfSReferNox = 7;
          final int _cursorIndexOfDOrderedx = 8;
          final int _cursorIndexOfDPlacOrdr = 9;
          final int _cursorIndexOfDPickupxx = 10;
          final int _cursorIndexOfCTranStat = 11;
          final int _cursorIndexOfCPlcOrder = 12;
          final int _cursorIndexOfCNotified = 13;
          final int _cursorIndexOfSPromoDsc = 14;
          final int _cursorIndexOfOrigPoints = 15;
          final int _cursorIndexOfSImageUrl = 16;
          final int _cursorIndexOfSAvlPoint = 17;
          final List<DRedeemItemInfo.CartItemsDetail> _result = new ArrayList<DRedeemItemInfo.CartItemsDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DRedeemItemInfo.CartItemsDetail _item;
            _item = new DRedeemItemInfo.CartItemsDetail();
            if (_cursor.isNull(_cursorIndexOfSPromoIDx)) {
              _item.sPromoIDx = null;
            } else {
              _item.sPromoIDx = _cursor.getString(_cursorIndexOfSPromoIDx);
            }
            if (_cursor.isNull(_cursorIndexOfSBatchNox)) {
              _item.sBatchNox = null;
            } else {
              _item.sBatchNox = _cursor.getString(_cursorIndexOfSBatchNox);
            }
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSGCardNox)) {
              _item.sGCardNox = null;
            } else {
              _item.sGCardNox = _cursor.getString(_cursorIndexOfSGCardNox);
            }
            _item.nItemQtyx = _cursor.getInt(_cursorIndexOfNItemQtyx);
            _item.nPointsxx = _cursor.getDouble(_cursorIndexOfNPointsxx);
            if (_cursor.isNull(_cursorIndexOfSBranchCd)) {
              _item.sBranchCd = null;
            } else {
              _item.sBranchCd = _cursor.getString(_cursorIndexOfSBranchCd);
            }
            if (_cursor.isNull(_cursorIndexOfSReferNox)) {
              _item.sReferNox = null;
            } else {
              _item.sReferNox = _cursor.getString(_cursorIndexOfSReferNox);
            }
            if (_cursor.isNull(_cursorIndexOfDOrderedx)) {
              _item.dOrderedx = null;
            } else {
              _item.dOrderedx = _cursor.getString(_cursorIndexOfDOrderedx);
            }
            if (_cursor.isNull(_cursorIndexOfDPlacOrdr)) {
              _item.dPlacOrdr = null;
            } else {
              _item.dPlacOrdr = _cursor.getString(_cursorIndexOfDPlacOrdr);
            }
            if (_cursor.isNull(_cursorIndexOfDPickupxx)) {
              _item.dPickupxx = null;
            } else {
              _item.dPickupxx = _cursor.getString(_cursorIndexOfDPickupxx);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            if (_cursor.isNull(_cursorIndexOfCPlcOrder)) {
              _item.cPlcOrder = null;
            } else {
              _item.cPlcOrder = _cursor.getString(_cursorIndexOfCPlcOrder);
            }
            if (_cursor.isNull(_cursorIndexOfCNotified)) {
              _item.cNotified = null;
            } else {
              _item.cNotified = _cursor.getString(_cursorIndexOfCNotified);
            }
            if (_cursor.isNull(_cursorIndexOfSPromoDsc)) {
              _item.sPromoDsc = null;
            } else {
              _item.sPromoDsc = _cursor.getString(_cursorIndexOfSPromoDsc);
            }
            _item.origPoints = _cursor.getDouble(_cursorIndexOfOrigPoints);
            if (_cursor.isNull(_cursorIndexOfSImageUrl)) {
              _item.sImageUrl = null;
            } else {
              _item.sImageUrl = _cursor.getString(_cursorIndexOfSImageUrl);
            }
            if (_cursor.isNull(_cursorIndexOfSAvlPoint)) {
              _item.sAvlPoint = null;
            } else {
              _item.sAvlPoint = _cursor.getString(_cursorIndexOfSAvlPoint);
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
  public LiveData<Double> getTotalCartPoints(final String fsGcardNo) {
    final String _sql = "SELECT SUM(nPointsxx) FROM redeem_item WHERE cTranStat = '0' AND sGCardNox = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsGcardNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsGcardNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"redeem_item"}, false, new Callable<Double>() {
      @Override
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if(_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
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
  public LiveData<List<DRedeemItemInfo.GCardCartItem>> GetGCardCartItemList() {
    final String _sql = "SELECT a.sTransNox, b.sPromoDsc, a.nPointsxx,a.nItemQtyx, b.sImageUrl FROM Redeem_Item a LEFT JOIN Redeemables b ON a.sPromoIDx = b.sPromoCde WHERE a.sGCardNox = (SELECT sGCardNox FROM GCard_App_Master WHERE cActvStat = '1')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeem_Item","Redeemables","GCard_App_Master"}, false, new Callable<List<DRedeemItemInfo.GCardCartItem>>() {
      @Override
      public List<DRedeemItemInfo.GCardCartItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfSPromoDsc = 1;
          final int _cursorIndexOfNPointsxx = 2;
          final int _cursorIndexOfNItemQtyx = 3;
          final int _cursorIndexOfSImageUrl = 4;
          final List<DRedeemItemInfo.GCardCartItem> _result = new ArrayList<DRedeemItemInfo.GCardCartItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DRedeemItemInfo.GCardCartItem _item;
            _item = new DRedeemItemInfo.GCardCartItem();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSPromoDsc)) {
              _item.sPromoDsc = null;
            } else {
              _item.sPromoDsc = _cursor.getString(_cursorIndexOfSPromoDsc);
            }
            if (_cursor.isNull(_cursorIndexOfNPointsxx)) {
              _item.nPointsxx = null;
            } else {
              _item.nPointsxx = _cursor.getString(_cursorIndexOfNPointsxx);
            }
            if (_cursor.isNull(_cursorIndexOfNItemQtyx)) {
              _item.nItemQtyx = null;
            } else {
              _item.nItemQtyx = _cursor.getString(_cursorIndexOfNItemQtyx);
            }
            if (_cursor.isNull(_cursorIndexOfSImageUrl)) {
              _item.sImageUrl = null;
            } else {
              _item.sImageUrl = _cursor.getString(_cursorIndexOfSImageUrl);
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
  public List<EBranchInfo> GetMCBranchesForRedemption() {
    final String _sql = "SELECT * FROM BranchInfo WHERE sBranchCd LIKE '%M%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongtude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongtude");
      final int _cursorIndexOfContactx = CursorUtil.getColumnIndexOrThrow(_cursor, "sContactx");
      final int _cursorIndexOfTelNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sTelNumbr");
      final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
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
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _item.setTownName(_tmpTownName);
        final String _tmpProvName;
        if (_cursor.isNull(_cursorIndexOfProvName)) {
          _tmpProvName = null;
        } else {
          _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
        }
        _item.setProvName(_tmpProvName);
        final double _tmpLatitude;
        _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        _item.setLatitude(_tmpLatitude);
        final double _tmpLongtude;
        _tmpLongtude = _cursor.getDouble(_cursorIndexOfLongtude);
        _item.setLongtude(_tmpLongtude);
        final String _tmpContactx;
        if (_cursor.isNull(_cursorIndexOfContactx)) {
          _tmpContactx = null;
        } else {
          _tmpContactx = _cursor.getString(_cursorIndexOfContactx);
        }
        _item.setContactx(_tmpContactx);
        final String _tmpTelNumbr;
        if (_cursor.isNull(_cursorIndexOfTelNumbr)) {
          _tmpTelNumbr = null;
        } else {
          _tmpTelNumbr = _cursor.getString(_cursorIndexOfTelNumbr);
        }
        _item.setTelNumbr(_tmpTelNumbr);
        final String _tmpEmailAdd;
        if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
          _tmpEmailAdd = null;
        } else {
          _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
        }
        _item.setEmailAdd(_tmpEmailAdd);
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
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<Integer> GetGcardCartItemCount() {
    final String _sql = "SELECT COUNT(*) FROM Redeem_Item WHERE sGCardNox = (SELECT sGCardNox FROM GCard_App_Master WHERE cActvStat = '1')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeem_Item","GCard_App_Master"}, false, new Callable<Integer>() {
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
  public LiveData<Double> GetGCardCartItenTotalPoints() {
    final String _sql = "SELECT SUM(nPointsxx * nItemQtyx) FROM Redeem_Item WHERE sGCardNox = (SELECT sGCardNox FROM GCard_App_Master WHERE cActvStat = '1')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Redeem_Item","GCard_App_Master"}, false, new Callable<Double>() {
      @Override
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if(_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
