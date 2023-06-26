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
import org.rmj.g3appdriver.GConnect.room.Entities.EItemCart;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DItemCart_Impl implements DItemCart {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EItemCart> __insertionAdapterOfEItemCart;

  private final EntityDeletionOrUpdateAdapter<EItemCart> __updateAdapterOfEItemCart;

  private final SharedSQLiteStatement __preparedStmtOfUpdateItem;

  private final SharedSQLiteStatement __preparedStmtOfDeleteCartItem;

  private final SharedSQLiteStatement __preparedStmtOfCancelBuyNowItem;

  private final SharedSQLiteStatement __preparedStmtOfUpdateForCheckOut;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSelectAllCheckOut;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUnselectAllCheckOut;

  private final SharedSQLiteStatement __preparedStmtOfRemoveForCheckOut;

  private final SharedSQLiteStatement __preparedStmtOfUpdateProdcutQuantity;

  public DItemCart_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEItemCart = new EntityInsertionAdapter<EItemCart>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MarketPlace_Cart` (`sUserIDxx`,`sListIDxx`,`cBuyNowxx`,`nQuantity`,`nAvlQtyxx`,`dCreatedx`,`cTranStat`,`cCheckOut`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EItemCart value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getListIDxx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getListIDxx());
        }
        if (value.getBuyNowxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBuyNowxx());
        }
        if (value.getQuantity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getQuantity());
        }
        if (value.getAvlQtyxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getAvlQtyxx());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreatedx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTranStat());
        }
        if (value.getCheckOut() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCheckOut());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEItemCart = new EntityDeletionOrUpdateAdapter<EItemCart>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MarketPlace_Cart` SET `sUserIDxx` = ?,`sListIDxx` = ?,`cBuyNowxx` = ?,`nQuantity` = ?,`nAvlQtyxx` = ?,`dCreatedx` = ?,`cTranStat` = ?,`cCheckOut` = ?,`dTimeStmp` = ? WHERE `sUserIDxx` = ? AND `sListIDxx` = ? AND `cBuyNowxx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EItemCart value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getListIDxx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getListIDxx());
        }
        if (value.getBuyNowxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBuyNowxx());
        }
        if (value.getQuantity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getQuantity());
        }
        if (value.getAvlQtyxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getAvlQtyxx());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCreatedx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTranStat());
        }
        if (value.getCheckOut() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getCheckOut());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTimeStmp());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getUserIDxx());
        }
        if (value.getListIDxx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getListIDxx());
        }
        if (value.getBuyNowxx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getBuyNowxx());
        }
      }
    };
    this.__preparedStmtOfUpdateItem = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE MarketPlace_Cart SET nQuantity = ? WHERE sListIDxx =?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteCartItem = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MarketPlace_Cart WHERE sListIDxx=?";
        return _query;
      }
    };
    this.__preparedStmtOfCancelBuyNowItem = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MarketPlace_Cart WHERE cBuyNowxx = '1' AND cCheckOut = '1'";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateForCheckOut = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE MarketPlace_Cart SET cCheckOut = '1' WHERE sListIDxx =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSelectAllCheckOut = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE MarketPlace_Cart SET cCheckOut = '1'";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUnselectAllCheckOut = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE MarketPlace_Cart SET cCheckOut = '0'";
        return _query;
      }
    };
    this.__preparedStmtOfRemoveForCheckOut = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE MarketPlace_Cart SET cCheckOut = '0' WHERE sListIDxx =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateProdcutQuantity = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Product_Inventory SET nTotalQty =?, nQtyOnHnd =?, nResvOrdr =?, nSoldQtyx =?, nUnitPrce =? WHERE sListngID=?";
        return _query;
      }
    };
  }

  @Override
  public void SaveItemInfo(final EItemCart foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEItemCart.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateItemInfo(final EItemCart foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEItemCart.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateItem(final String fsListID, final int fnQty) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateItem.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, fnQty);
    _argIndex = 2;
    if (fsListID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsListID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateItem.release(_stmt);
    }
  }

  @Override
  public void DeleteCartItem(final String fsListID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteCartItem.acquire();
    int _argIndex = 1;
    if (fsListID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsListID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteCartItem.release(_stmt);
    }
  }

  @Override
  public void CancelBuyNowItem() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfCancelBuyNowItem.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfCancelBuyNowItem.release(_stmt);
    }
  }

  @Override
  public void UpdateForCheckOut(final String fsListID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateForCheckOut.acquire();
    int _argIndex = 1;
    if (fsListID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsListID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateForCheckOut.release(_stmt);
    }
  }

  @Override
  public void UpdateSelectAllCheckOut() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSelectAllCheckOut.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSelectAllCheckOut.release(_stmt);
    }
  }

  @Override
  public void UpdateUnselectAllCheckOut() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUnselectAllCheckOut.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateUnselectAllCheckOut.release(_stmt);
    }
  }

  @Override
  public void RemoveForCheckOut(final String fsListID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfRemoveForCheckOut.acquire();
    int _argIndex = 1;
    if (fsListID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsListID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfRemoveForCheckOut.release(_stmt);
    }
  }

  @Override
  public void UpdateProdcutQuantity(final String fsLstID, final String nTotalQty,
      final String nQtyOnHnd, final String nResvOrdr, final String nSoldQtyx,
      final String nUnitPrce) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateProdcutQuantity.acquire();
    int _argIndex = 1;
    if (nTotalQty == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, nTotalQty);
    }
    _argIndex = 2;
    if (nQtyOnHnd == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, nQtyOnHnd);
    }
    _argIndex = 3;
    if (nResvOrdr == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, nResvOrdr);
    }
    _argIndex = 4;
    if (nSoldQtyx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, nSoldQtyx);
    }
    _argIndex = 5;
    if (nUnitPrce == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, nUnitPrce);
    }
    _argIndex = 6;
    if (fsLstID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsLstID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateProdcutQuantity.release(_stmt);
    }
  }

  @Override
  public EItemCart GetItemCart(final String ListngID) {
    final String _sql = "SELECT * FROM MarketPlace_Cart WHERE sListIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ListngID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ListngID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfListIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sListIDxx");
      final int _cursorIndexOfBuyNowxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cBuyNowxx");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "nQuantity");
      final int _cursorIndexOfAvlQtyxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAvlQtyxx");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfCheckOut = CursorUtil.getColumnIndexOrThrow(_cursor, "cCheckOut");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EItemCart _result;
      if(_cursor.moveToFirst()) {
        _result = new EItemCart();
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpListIDxx;
        if (_cursor.isNull(_cursorIndexOfListIDxx)) {
          _tmpListIDxx = null;
        } else {
          _tmpListIDxx = _cursor.getString(_cursorIndexOfListIDxx);
        }
        _result.setListIDxx(_tmpListIDxx);
        final String _tmpBuyNowxx;
        if (_cursor.isNull(_cursorIndexOfBuyNowxx)) {
          _tmpBuyNowxx = null;
        } else {
          _tmpBuyNowxx = _cursor.getString(_cursorIndexOfBuyNowxx);
        }
        _result.setBuyNowxx(_tmpBuyNowxx);
        final Integer _tmpQuantity;
        if (_cursor.isNull(_cursorIndexOfQuantity)) {
          _tmpQuantity = null;
        } else {
          _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
        }
        _result.setQuantity(_tmpQuantity);
        final Integer _tmpAvlQtyxx;
        if (_cursor.isNull(_cursorIndexOfAvlQtyxx)) {
          _tmpAvlQtyxx = null;
        } else {
          _tmpAvlQtyxx = _cursor.getInt(_cursorIndexOfAvlQtyxx);
        }
        _result.setAvlQtyxx(_tmpAvlQtyxx);
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
        final String _tmpCheckOut;
        if (_cursor.isNull(_cursorIndexOfCheckOut)) {
          _tmpCheckOut = null;
        } else {
          _tmpCheckOut = _cursor.getString(_cursorIndexOfCheckOut);
        }
        _result.setCheckOut(_tmpCheckOut);
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
  public LiveData<Integer> GetMartketplaceCartItemCount() {
    final String _sql = "SELECT COUNT(*) FROM MarketPlace_Cart WHERE sUserIDxx = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Cart","Client_Profile_Info"}, false, new Callable<Integer>() {
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
  public LiveData<Integer> GetCartItemCount() {
    final String _sql = "SELECT ((SELECT COUNT(*) FROM MarketPlace_Cart) + (SELECT COUNT(*) FROM Redeem_Item WHERE sBatchNox IS NULL)) AS CartItemCount";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Cart","Redeem_Item"}, false, new Callable<Integer>() {
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
  public int CheckIfCartHasRecord() {
    final String _sql = "SELECT COUNT(*) FROM MarketPlace_Cart";
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
  public String GetLatestCartTimeStamp() {
    final String _sql = "SELECT dTimeStmp FROM MarketPlace_Cart ORDER BY dTimeStmp DESC LIMIT 1";
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
  public LiveData<List<DItemCart.oMarketplaceCartItem>> CheckCartIfHasForPlaceOrder() {
    final String _sql = "SELECT * FROM MarketPlace_Cart WHERE cBuyNowxx = '1' AND cCheckOut = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Cart"}, false, new Callable<List<DItemCart.oMarketplaceCartItem>>() {
      @Override
      public List<DItemCart.oMarketplaceCartItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSListIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sListIDxx");
          final int _cursorIndexOfNQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "nQuantity");
          final int _cursorIndexOfCCheckOut = CursorUtil.getColumnIndexOrThrow(_cursor, "cCheckOut");
          final List<DItemCart.oMarketplaceCartItem> _result = new ArrayList<DItemCart.oMarketplaceCartItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DItemCart.oMarketplaceCartItem _item;
            _item = new DItemCart.oMarketplaceCartItem();
            if (_cursor.isNull(_cursorIndexOfSListIDxx)) {
              _item.sListIDxx = null;
            } else {
              _item.sListIDxx = _cursor.getString(_cursorIndexOfSListIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfNQuantity)) {
              _item.nQuantity = null;
            } else {
              _item.nQuantity = _cursor.getString(_cursorIndexOfNQuantity);
            }
            if (_cursor.isNull(_cursorIndexOfCCheckOut)) {
              _item.cCheckOut = null;
            } else {
              _item.cCheckOut = _cursor.getString(_cursorIndexOfCCheckOut);
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
  public int CheckIfItemForBuyNowExist(final String fsListID) {
    final String _sql = "SELECT COUNT(*) FROM MarketPlace_Cart WHERE sListIDxx =? AND sUserIDxx = (SELECT sUserIDxx FROM Client_Profile_Info) AND cBuyNowxx = '1' AND cCheckOut = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsListID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsListID);
    }
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
  public EItemCart CheckIFItemExist(final String fsListID) {
    final String _sql = "SELECT * FROM MarketPlace_Cart WHERE sListIDxx=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsListID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsListID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfListIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sListIDxx");
      final int _cursorIndexOfBuyNowxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cBuyNowxx");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "nQuantity");
      final int _cursorIndexOfAvlQtyxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAvlQtyxx");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfCheckOut = CursorUtil.getColumnIndexOrThrow(_cursor, "cCheckOut");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EItemCart _result;
      if(_cursor.moveToFirst()) {
        _result = new EItemCart();
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpListIDxx;
        if (_cursor.isNull(_cursorIndexOfListIDxx)) {
          _tmpListIDxx = null;
        } else {
          _tmpListIDxx = _cursor.getString(_cursorIndexOfListIDxx);
        }
        _result.setListIDxx(_tmpListIDxx);
        final String _tmpBuyNowxx;
        if (_cursor.isNull(_cursorIndexOfBuyNowxx)) {
          _tmpBuyNowxx = null;
        } else {
          _tmpBuyNowxx = _cursor.getString(_cursorIndexOfBuyNowxx);
        }
        _result.setBuyNowxx(_tmpBuyNowxx);
        final Integer _tmpQuantity;
        if (_cursor.isNull(_cursorIndexOfQuantity)) {
          _tmpQuantity = null;
        } else {
          _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
        }
        _result.setQuantity(_tmpQuantity);
        final Integer _tmpAvlQtyxx;
        if (_cursor.isNull(_cursorIndexOfAvlQtyxx)) {
          _tmpAvlQtyxx = null;
        } else {
          _tmpAvlQtyxx = _cursor.getInt(_cursorIndexOfAvlQtyxx);
        }
        _result.setAvlQtyxx(_tmpAvlQtyxx);
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
        final String _tmpCheckOut;
        if (_cursor.isNull(_cursorIndexOfCheckOut)) {
          _tmpCheckOut = null;
        } else {
          _tmpCheckOut = _cursor.getString(_cursorIndexOfCheckOut);
        }
        _result.setCheckOut(_tmpCheckOut);
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
  public List<EItemCart> GetAllItemCart() {
    final String _sql = "SELECT * FROM MarketPlace_Cart";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfListIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sListIDxx");
      final int _cursorIndexOfBuyNowxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cBuyNowxx");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "nQuantity");
      final int _cursorIndexOfAvlQtyxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAvlQtyxx");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfCheckOut = CursorUtil.getColumnIndexOrThrow(_cursor, "cCheckOut");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<EItemCart> _result = new ArrayList<EItemCart>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EItemCart _item;
        _item = new EItemCart();
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _item.setUserIDxx(_tmpUserIDxx);
        final String _tmpListIDxx;
        if (_cursor.isNull(_cursorIndexOfListIDxx)) {
          _tmpListIDxx = null;
        } else {
          _tmpListIDxx = _cursor.getString(_cursorIndexOfListIDxx);
        }
        _item.setListIDxx(_tmpListIDxx);
        final String _tmpBuyNowxx;
        if (_cursor.isNull(_cursorIndexOfBuyNowxx)) {
          _tmpBuyNowxx = null;
        } else {
          _tmpBuyNowxx = _cursor.getString(_cursorIndexOfBuyNowxx);
        }
        _item.setBuyNowxx(_tmpBuyNowxx);
        final Integer _tmpQuantity;
        if (_cursor.isNull(_cursorIndexOfQuantity)) {
          _tmpQuantity = null;
        } else {
          _tmpQuantity = _cursor.getInt(_cursorIndexOfQuantity);
        }
        _item.setQuantity(_tmpQuantity);
        final Integer _tmpAvlQtyxx;
        if (_cursor.isNull(_cursorIndexOfAvlQtyxx)) {
          _tmpAvlQtyxx = null;
        } else {
          _tmpAvlQtyxx = _cursor.getInt(_cursorIndexOfAvlQtyxx);
        }
        _item.setAvlQtyxx(_tmpAvlQtyxx);
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
        final String _tmpCheckOut;
        if (_cursor.isNull(_cursorIndexOfCheckOut)) {
          _tmpCheckOut = null;
        } else {
          _tmpCheckOut = _cursor.getString(_cursorIndexOfCheckOut);
        }
        _item.setCheckOut(_tmpCheckOut);
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
  public int CheckCartItemsForOrder() {
    final String _sql = "SELECT COUNT(*) FROM MarketPlace_Cart WHERE cCheckOut ='1'";
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
  public LiveData<Double> GetSelectedItemCartTotalPrice() {
    final String _sql = "SELECT IFNULL(SUM(b.nUnitPrce * a.nQuantity), 0) AS CART_TOTAL FROM MarketPlace_Cart a LEFT JOIN Product_Inventory b ON a.sListIDxx = b.sListngID  WHERE a.sUserIDxx = (SELECT sUserIDxx FROM Client_Profile_Info) AND cCheckOut = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Cart","Product_Inventory","Client_Profile_Info"}, false, new Callable<Double>() {
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
  public Double GetPlacedOrderTotalPrice() {
    final String _sql = "SELECT IFNULL(SUM(b.nUnitPrce * a.nQuantity), 0) AS CART_TOTAL FROM MarketPlace_Cart a LEFT JOIN Product_Inventory b ON a.sListIDxx = b.sListngID  WHERE a.sUserIDxx = (SELECT sUserIDxx FROM Client_Profile_Info) AND cCheckOut = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
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
      _statement.release();
    }
  }

  @Override
  public LiveData<Integer> GetSelectedItemCartTotalCount() {
    final String _sql = "SELECT IFNULL(COUNT (a.sListIDxx), 0) FROM MARKETPLACE_CART a LEFT JOIN Product_Inventory b ON a.sListIDxx = b.sListngID WHERE a.sUserIDxx = (SELECT sUserIDxx FROM Client_Profile_Info) AND a.cCheckOut = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MARKETPLACE_CART","Product_Inventory","Client_Profile_Info"}, false, new Callable<Integer>() {
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
  public LiveData<List<DItemCart.oMarketplaceCartItem>> GetCartItemsList() {
    final String _sql = "SELECT a.sListIDxx AS sListIDxx, a.nQuantity AS nQuantity, a.cCheckOut AS cCheckOut, b.xModelNme AS xModelNme, b.xDescript AS xDescript,b.sImagesxx,b.nUnitPrce AS nUnitPrce FROM MarketPlace_Cart a LEFT JOIN Product_Inventory b ON a.sListIDxx = b.sListngID WHERE a.cBuyNowxx = '0' AND a.sUserIDxx = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Cart","Product_Inventory","Client_Profile_Info"}, false, new Callable<List<DItemCart.oMarketplaceCartItem>>() {
      @Override
      public List<DItemCart.oMarketplaceCartItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSListIDxx = 0;
          final int _cursorIndexOfNQuantity = 1;
          final int _cursorIndexOfCCheckOut = 2;
          final int _cursorIndexOfXModelNme = 3;
          final int _cursorIndexOfXDescript = 4;
          final int _cursorIndexOfSImagesxx = 5;
          final int _cursorIndexOfNUnitPrce = 6;
          final List<DItemCart.oMarketplaceCartItem> _result = new ArrayList<DItemCart.oMarketplaceCartItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DItemCart.oMarketplaceCartItem _item;
            _item = new DItemCart.oMarketplaceCartItem();
            if (_cursor.isNull(_cursorIndexOfSListIDxx)) {
              _item.sListIDxx = null;
            } else {
              _item.sListIDxx = _cursor.getString(_cursorIndexOfSListIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfNQuantity)) {
              _item.nQuantity = null;
            } else {
              _item.nQuantity = _cursor.getString(_cursorIndexOfNQuantity);
            }
            if (_cursor.isNull(_cursorIndexOfCCheckOut)) {
              _item.cCheckOut = null;
            } else {
              _item.cCheckOut = _cursor.getString(_cursorIndexOfCCheckOut);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXDescript)) {
              _item.xDescript = null;
            } else {
              _item.xDescript = _cursor.getString(_cursorIndexOfXDescript);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfNUnitPrce)) {
              _item.nUnitPrce = null;
            } else {
              _item.nUnitPrce = _cursor.getString(_cursorIndexOfNUnitPrce);
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
  public LiveData<List<DItemCart.oMarketplaceCartItem>> GetBuyNowItem() {
    final String _sql = "SELECT a.sListIDxx AS sListIDxx, a.nQuantity AS nQuantity, b.xModelNme AS xModelNme, b.xDescript AS xDescript,b.sImagesxx,b.nUnitPrce AS nUnitPrce FROM MarketPlace_Cart a LEFT JOIN Product_Inventory b ON a.sListIDxx = b.sListngID  WHERE a.cBuyNowxx = '1' AND cCheckOut = '1' AND a.sUserIDxx = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Cart","Product_Inventory","Client_Profile_Info"}, false, new Callable<List<DItemCart.oMarketplaceCartItem>>() {
      @Override
      public List<DItemCart.oMarketplaceCartItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSListIDxx = 0;
          final int _cursorIndexOfNQuantity = 1;
          final int _cursorIndexOfXModelNme = 2;
          final int _cursorIndexOfXDescript = 3;
          final int _cursorIndexOfSImagesxx = 4;
          final int _cursorIndexOfNUnitPrce = 5;
          final List<DItemCart.oMarketplaceCartItem> _result = new ArrayList<DItemCart.oMarketplaceCartItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DItemCart.oMarketplaceCartItem _item;
            _item = new DItemCart.oMarketplaceCartItem();
            if (_cursor.isNull(_cursorIndexOfSListIDxx)) {
              _item.sListIDxx = null;
            } else {
              _item.sListIDxx = _cursor.getString(_cursorIndexOfSListIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfNQuantity)) {
              _item.nQuantity = null;
            } else {
              _item.nQuantity = _cursor.getString(_cursorIndexOfNQuantity);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXDescript)) {
              _item.xDescript = null;
            } else {
              _item.xDescript = _cursor.getString(_cursorIndexOfXDescript);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfNUnitPrce)) {
              _item.nUnitPrce = null;
            } else {
              _item.nUnitPrce = _cursor.getString(_cursorIndexOfNUnitPrce);
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
  public LiveData<List<DItemCart.oMarketplaceCartItem>> GetItemsForCheckOut() {
    final String _sql = "SELECT a.sListIDxx AS sListIDxx, a.nQuantity AS nQuantity, a.cCheckOut AS cCheckOut, b.xModelNme AS xModelNme, b.xDescript AS xDescript,b.sImagesxx,b.nUnitPrce AS nUnitPrce FROM MarketPlace_Cart a LEFT JOIN Product_Inventory b ON a.sListIDxx = b.sListngID  WHERE a.cBuyNowxx = '0' AND cCheckOut = '1' AND a.sUserIDxx = (SELECT sUserIDxx FROM Client_Profile_Info)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Cart","Product_Inventory","Client_Profile_Info"}, false, new Callable<List<DItemCart.oMarketplaceCartItem>>() {
      @Override
      public List<DItemCart.oMarketplaceCartItem> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSListIDxx = 0;
          final int _cursorIndexOfNQuantity = 1;
          final int _cursorIndexOfCCheckOut = 2;
          final int _cursorIndexOfXModelNme = 3;
          final int _cursorIndexOfXDescript = 4;
          final int _cursorIndexOfSImagesxx = 5;
          final int _cursorIndexOfNUnitPrce = 6;
          final List<DItemCart.oMarketplaceCartItem> _result = new ArrayList<DItemCart.oMarketplaceCartItem>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DItemCart.oMarketplaceCartItem _item;
            _item = new DItemCart.oMarketplaceCartItem();
            if (_cursor.isNull(_cursorIndexOfSListIDxx)) {
              _item.sListIDxx = null;
            } else {
              _item.sListIDxx = _cursor.getString(_cursorIndexOfSListIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfNQuantity)) {
              _item.nQuantity = null;
            } else {
              _item.nQuantity = _cursor.getString(_cursorIndexOfNQuantity);
            }
            if (_cursor.isNull(_cursorIndexOfCCheckOut)) {
              _item.cCheckOut = null;
            } else {
              _item.cCheckOut = _cursor.getString(_cursorIndexOfCCheckOut);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXDescript)) {
              _item.xDescript = null;
            } else {
              _item.xDescript = _cursor.getString(_cursorIndexOfXDescript);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfNUnitPrce)) {
              _item.nUnitPrce = null;
            } else {
              _item.nUnitPrce = _cursor.getString(_cursorIndexOfNUnitPrce);
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
