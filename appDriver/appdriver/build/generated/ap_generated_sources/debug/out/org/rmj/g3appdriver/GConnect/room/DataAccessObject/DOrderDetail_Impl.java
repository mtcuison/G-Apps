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
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GConnect.room.Entities.EOrderDetail;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DOrderDetail_Impl implements DOrderDetail {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EOrderDetail> __insertionAdapterOfEOrderDetail;

  private final EntityDeletionOrUpdateAdapter<EOrderDetail> __updateAdapterOfEOrderDetail;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReviewedItem;

  public DOrderDetail_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEOrderDetail = new EntityInsertionAdapter<EOrderDetail>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MarketPlace_Order_Detail` (`sTransNox`,`nEntryNox`,`sStockIDx`,`nQuantity`,`nUnitPrce`,`nDiscount`,`nAddDiscx`,`nApproved`,`nIssuedxx`,`nCancelld`,`sReferNox`,`sNotesxxx`,`cReviewed`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EOrderDetail value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getEntryNox() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEntryNox());
        }
        if (value.getStockIDx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStockIDx());
        }
        if (value.getQuantity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getQuantity());
        }
        if (value.getUnitPrce() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUnitPrce());
        }
        if (value.getDiscount() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDiscount());
        }
        if (value.getAddDiscx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAddDiscx());
        }
        if (value.getApproved() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getApproved());
        }
        if (value.getIssuedxx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getIssuedxx());
        }
        if (value.getCancelld() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCancelld());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReferNox());
        }
        if (value.getNotesxxx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNotesxxx());
        }
        if (value.getReviewed() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getReviewed());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEOrderDetail = new EntityDeletionOrUpdateAdapter<EOrderDetail>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MarketPlace_Order_Detail` SET `sTransNox` = ?,`nEntryNox` = ?,`sStockIDx` = ?,`nQuantity` = ?,`nUnitPrce` = ?,`nDiscount` = ?,`nAddDiscx` = ?,`nApproved` = ?,`nIssuedxx` = ?,`nCancelld` = ?,`sReferNox` = ?,`sNotesxxx` = ?,`cReviewed` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ? AND `nEntryNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EOrderDetail value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getEntryNox() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEntryNox());
        }
        if (value.getStockIDx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStockIDx());
        }
        if (value.getQuantity() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getQuantity());
        }
        if (value.getUnitPrce() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUnitPrce());
        }
        if (value.getDiscount() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDiscount());
        }
        if (value.getAddDiscx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAddDiscx());
        }
        if (value.getApproved() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getApproved());
        }
        if (value.getIssuedxx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getIssuedxx());
        }
        if (value.getCancelld() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getCancelld());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReferNox());
        }
        if (value.getNotesxxx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNotesxxx());
        }
        if (value.getReviewed() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getReviewed());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTransNox());
        }
        if (value.getEntryNox() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getEntryNox());
        }
      }
    };
    this.__preparedStmtOfUpdateReviewedItem = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE MarketPlace_Order_Detail SET cReviewed = '1' WHERE sTransNox =? AND sReferNox =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveDetailOrder(final EOrderDetail foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEOrderDetail.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateDetail(final EOrderDetail foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEOrderDetail.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateReviewedItem(final String OrderID, final String ListID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReviewedItem.acquire();
    int _argIndex = 1;
    if (OrderID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, OrderID);
    }
    _argIndex = 2;
    if (ListID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ListID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateReviewedItem.release(_stmt);
    }
  }

  @Override
  public EOrderDetail GetOrderDetail(final String fsVal, final String fsVal1) {
    final String _sql = "SELECT * FROM MarketPlace_Order_Detail WHERE sTransNox =? AND nEntryNox=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    _argIndex = 2;
    if (fsVal1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal1);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfStockIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sStockIDx");
      final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "nQuantity");
      final int _cursorIndexOfUnitPrce = CursorUtil.getColumnIndexOrThrow(_cursor, "nUnitPrce");
      final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
      final int _cursorIndexOfAddDiscx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAddDiscx");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "nApproved");
      final int _cursorIndexOfIssuedxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nIssuedxx");
      final int _cursorIndexOfCancelld = CursorUtil.getColumnIndexOrThrow(_cursor, "nCancelld");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfNotesxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sNotesxxx");
      final int _cursorIndexOfReviewed = CursorUtil.getColumnIndexOrThrow(_cursor, "cReviewed");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EOrderDetail _result;
      if(_cursor.moveToFirst()) {
        _result = new EOrderDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpEntryNox;
        if (_cursor.isNull(_cursorIndexOfEntryNox)) {
          _tmpEntryNox = null;
        } else {
          _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
        }
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpStockIDx;
        if (_cursor.isNull(_cursorIndexOfStockIDx)) {
          _tmpStockIDx = null;
        } else {
          _tmpStockIDx = _cursor.getString(_cursorIndexOfStockIDx);
        }
        _result.setStockIDx(_tmpStockIDx);
        final String _tmpQuantity;
        if (_cursor.isNull(_cursorIndexOfQuantity)) {
          _tmpQuantity = null;
        } else {
          _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
        }
        _result.setQuantity(_tmpQuantity);
        final String _tmpUnitPrce;
        if (_cursor.isNull(_cursorIndexOfUnitPrce)) {
          _tmpUnitPrce = null;
        } else {
          _tmpUnitPrce = _cursor.getString(_cursorIndexOfUnitPrce);
        }
        _result.setUnitPrce(_tmpUnitPrce);
        final String _tmpDiscount;
        if (_cursor.isNull(_cursorIndexOfDiscount)) {
          _tmpDiscount = null;
        } else {
          _tmpDiscount = _cursor.getString(_cursorIndexOfDiscount);
        }
        _result.setDiscount(_tmpDiscount);
        final String _tmpAddDiscx;
        if (_cursor.isNull(_cursorIndexOfAddDiscx)) {
          _tmpAddDiscx = null;
        } else {
          _tmpAddDiscx = _cursor.getString(_cursorIndexOfAddDiscx);
        }
        _result.setAddDiscx(_tmpAddDiscx);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _result.setApproved(_tmpApproved);
        final String _tmpIssuedxx;
        if (_cursor.isNull(_cursorIndexOfIssuedxx)) {
          _tmpIssuedxx = null;
        } else {
          _tmpIssuedxx = _cursor.getString(_cursorIndexOfIssuedxx);
        }
        _result.setIssuedxx(_tmpIssuedxx);
        final String _tmpCancelld;
        if (_cursor.isNull(_cursorIndexOfCancelld)) {
          _tmpCancelld = null;
        } else {
          _tmpCancelld = _cursor.getString(_cursorIndexOfCancelld);
        }
        _result.setCancelld(_tmpCancelld);
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpNotesxxx;
        if (_cursor.isNull(_cursorIndexOfNotesxxx)) {
          _tmpNotesxxx = null;
        } else {
          _tmpNotesxxx = _cursor.getString(_cursorIndexOfNotesxxx);
        }
        _result.setNotesxxx(_tmpNotesxxx);
        final String _tmpReviewed;
        if (_cursor.isNull(_cursorIndexOfReviewed)) {
          _tmpReviewed = null;
        } else {
          _tmpReviewed = _cursor.getString(_cursorIndexOfReviewed);
        }
        _result.setReviewed(_tmpReviewed);
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
  public LiveData<List<EOrderDetail>> GetOrderDetail(final String fsTransNo) {
    final String _sql = "SELECT * FROM MarketPlace_Order_Detail WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsTransNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsTransNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Detail"}, false, new Callable<List<EOrderDetail>>() {
      @Override
      public List<EOrderDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfStockIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sStockIDx");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "nQuantity");
          final int _cursorIndexOfUnitPrce = CursorUtil.getColumnIndexOrThrow(_cursor, "nUnitPrce");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfAddDiscx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAddDiscx");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "nApproved");
          final int _cursorIndexOfIssuedxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nIssuedxx");
          final int _cursorIndexOfCancelld = CursorUtil.getColumnIndexOrThrow(_cursor, "nCancelld");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfNotesxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sNotesxxx");
          final int _cursorIndexOfReviewed = CursorUtil.getColumnIndexOrThrow(_cursor, "cReviewed");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EOrderDetail> _result = new ArrayList<EOrderDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EOrderDetail _item;
            _item = new EOrderDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpEntryNox;
            if (_cursor.isNull(_cursorIndexOfEntryNox)) {
              _tmpEntryNox = null;
            } else {
              _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
            }
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpStockIDx;
            if (_cursor.isNull(_cursorIndexOfStockIDx)) {
              _tmpStockIDx = null;
            } else {
              _tmpStockIDx = _cursor.getString(_cursorIndexOfStockIDx);
            }
            _item.setStockIDx(_tmpStockIDx);
            final String _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
            }
            _item.setQuantity(_tmpQuantity);
            final String _tmpUnitPrce;
            if (_cursor.isNull(_cursorIndexOfUnitPrce)) {
              _tmpUnitPrce = null;
            } else {
              _tmpUnitPrce = _cursor.getString(_cursorIndexOfUnitPrce);
            }
            _item.setUnitPrce(_tmpUnitPrce);
            final String _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getString(_cursorIndexOfDiscount);
            }
            _item.setDiscount(_tmpDiscount);
            final String _tmpAddDiscx;
            if (_cursor.isNull(_cursorIndexOfAddDiscx)) {
              _tmpAddDiscx = null;
            } else {
              _tmpAddDiscx = _cursor.getString(_cursorIndexOfAddDiscx);
            }
            _item.setAddDiscx(_tmpAddDiscx);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _item.setApproved(_tmpApproved);
            final String _tmpIssuedxx;
            if (_cursor.isNull(_cursorIndexOfIssuedxx)) {
              _tmpIssuedxx = null;
            } else {
              _tmpIssuedxx = _cursor.getString(_cursorIndexOfIssuedxx);
            }
            _item.setIssuedxx(_tmpIssuedxx);
            final String _tmpCancelld;
            if (_cursor.isNull(_cursorIndexOfCancelld)) {
              _tmpCancelld = null;
            } else {
              _tmpCancelld = _cursor.getString(_cursorIndexOfCancelld);
            }
            _item.setCancelld(_tmpCancelld);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpNotesxxx;
            if (_cursor.isNull(_cursorIndexOfNotesxxx)) {
              _tmpNotesxxx = null;
            } else {
              _tmpNotesxxx = _cursor.getString(_cursorIndexOfNotesxxx);
            }
            _item.setNotesxxx(_tmpNotesxxx);
            final String _tmpReviewed;
            if (_cursor.isNull(_cursorIndexOfReviewed)) {
              _tmpReviewed = null;
            } else {
              _tmpReviewed = _cursor.getString(_cursorIndexOfReviewed);
            }
            _item.setReviewed(_tmpReviewed);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public int CheckIfDetailHasRecord() {
    final String _sql = "SELECT COUNT(sTransNox) FROM MarketPlace_Order_Detail";
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
  public String getDetailLatestTimeStmp() {
    final String _sql = "SELECT dTimeStmp FROM MarketPlace_Order_Detail ORDER BY dTimeStmp DESC LIMIT 1";
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
  public LiveData<List<EOrderDetail>> GetDetailInfo(final String fsTransNo) {
    final String _sql = "SELECT * FROM MarketPlace_Order_Detail WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsTransNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsTransNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Detail"}, false, new Callable<List<EOrderDetail>>() {
      @Override
      public List<EOrderDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfStockIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sStockIDx");
          final int _cursorIndexOfQuantity = CursorUtil.getColumnIndexOrThrow(_cursor, "nQuantity");
          final int _cursorIndexOfUnitPrce = CursorUtil.getColumnIndexOrThrow(_cursor, "nUnitPrce");
          final int _cursorIndexOfDiscount = CursorUtil.getColumnIndexOrThrow(_cursor, "nDiscount");
          final int _cursorIndexOfAddDiscx = CursorUtil.getColumnIndexOrThrow(_cursor, "nAddDiscx");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "nApproved");
          final int _cursorIndexOfIssuedxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nIssuedxx");
          final int _cursorIndexOfCancelld = CursorUtil.getColumnIndexOrThrow(_cursor, "nCancelld");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfNotesxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sNotesxxx");
          final int _cursorIndexOfReviewed = CursorUtil.getColumnIndexOrThrow(_cursor, "cReviewed");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EOrderDetail> _result = new ArrayList<EOrderDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EOrderDetail _item;
            _item = new EOrderDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpEntryNox;
            if (_cursor.isNull(_cursorIndexOfEntryNox)) {
              _tmpEntryNox = null;
            } else {
              _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
            }
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpStockIDx;
            if (_cursor.isNull(_cursorIndexOfStockIDx)) {
              _tmpStockIDx = null;
            } else {
              _tmpStockIDx = _cursor.getString(_cursorIndexOfStockIDx);
            }
            _item.setStockIDx(_tmpStockIDx);
            final String _tmpQuantity;
            if (_cursor.isNull(_cursorIndexOfQuantity)) {
              _tmpQuantity = null;
            } else {
              _tmpQuantity = _cursor.getString(_cursorIndexOfQuantity);
            }
            _item.setQuantity(_tmpQuantity);
            final String _tmpUnitPrce;
            if (_cursor.isNull(_cursorIndexOfUnitPrce)) {
              _tmpUnitPrce = null;
            } else {
              _tmpUnitPrce = _cursor.getString(_cursorIndexOfUnitPrce);
            }
            _item.setUnitPrce(_tmpUnitPrce);
            final String _tmpDiscount;
            if (_cursor.isNull(_cursorIndexOfDiscount)) {
              _tmpDiscount = null;
            } else {
              _tmpDiscount = _cursor.getString(_cursorIndexOfDiscount);
            }
            _item.setDiscount(_tmpDiscount);
            final String _tmpAddDiscx;
            if (_cursor.isNull(_cursorIndexOfAddDiscx)) {
              _tmpAddDiscx = null;
            } else {
              _tmpAddDiscx = _cursor.getString(_cursorIndexOfAddDiscx);
            }
            _item.setAddDiscx(_tmpAddDiscx);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _item.setApproved(_tmpApproved);
            final String _tmpIssuedxx;
            if (_cursor.isNull(_cursorIndexOfIssuedxx)) {
              _tmpIssuedxx = null;
            } else {
              _tmpIssuedxx = _cursor.getString(_cursorIndexOfIssuedxx);
            }
            _item.setIssuedxx(_tmpIssuedxx);
            final String _tmpCancelld;
            if (_cursor.isNull(_cursorIndexOfCancelld)) {
              _tmpCancelld = null;
            } else {
              _tmpCancelld = _cursor.getString(_cursorIndexOfCancelld);
            }
            _item.setCancelld(_tmpCancelld);
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpNotesxxx;
            if (_cursor.isNull(_cursorIndexOfNotesxxx)) {
              _tmpNotesxxx = null;
            } else {
              _tmpNotesxxx = _cursor.getString(_cursorIndexOfNotesxxx);
            }
            _item.setNotesxxx(_tmpNotesxxx);
            final String _tmpReviewed;
            if (_cursor.isNull(_cursorIndexOfReviewed)) {
              _tmpReviewed = null;
            } else {
              _tmpReviewed = _cursor.getString(_cursorIndexOfReviewed);
            }
            _item.setReviewed(_tmpReviewed);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<DOrderDetail.OrderHistoryDetail>> GetOrderHistoryDetail(final String fsVal) {
    final String _sql = "SELECT a.nEntryNox, a.nQuantity, a.nUnitPrce, a.nDiscount, b.sBriefDsc, b.xBarCodex, b.xBrandNme, b.xModelNme, b.xColorNme, b.xCategrNm, c.cTranStat FROM MarketPlace_Order_Detail a LEFT JOIN Product_Inventory b ON a.sStockIDx = b.sStockIDx LEFT JOIN MarketPlace_Order_Master c ON a.sTransNox = c.sTransNox WHERE c.sTransNox =? AND c.sAppUsrID = (SELECT sUserIDxx FROM Client_Profile_Info) ORDER BY c.dTransact DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"MarketPlace_Order_Detail","Product_Inventory","MarketPlace_Order_Master","Client_Profile_Info"}, false, new Callable<List<DOrderDetail.OrderHistoryDetail>>() {
      @Override
      public List<DOrderDetail.OrderHistoryDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfNEntryNox = 0;
          final int _cursorIndexOfNQuantity = 1;
          final int _cursorIndexOfNUnitPrce = 2;
          final int _cursorIndexOfNDiscount = 3;
          final int _cursorIndexOfSBriefDsc = 4;
          final int _cursorIndexOfXBarCodex = 5;
          final int _cursorIndexOfXBrandNme = 6;
          final int _cursorIndexOfXModelNme = 7;
          final int _cursorIndexOfXColorNme = 8;
          final int _cursorIndexOfXCategrNm = 9;
          final int _cursorIndexOfCTranStat = 10;
          final List<DOrderDetail.OrderHistoryDetail> _result = new ArrayList<DOrderDetail.OrderHistoryDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DOrderDetail.OrderHistoryDetail _item;
            _item = new DOrderDetail.OrderHistoryDetail();
            if (_cursor.isNull(_cursorIndexOfNEntryNox)) {
              _item.nEntryNox = null;
            } else {
              _item.nEntryNox = _cursor.getString(_cursorIndexOfNEntryNox);
            }
            if (_cursor.isNull(_cursorIndexOfNQuantity)) {
              _item.nQuantity = null;
            } else {
              _item.nQuantity = _cursor.getString(_cursorIndexOfNQuantity);
            }
            if (_cursor.isNull(_cursorIndexOfNUnitPrce)) {
              _item.nUnitPrce = null;
            } else {
              _item.nUnitPrce = _cursor.getString(_cursorIndexOfNUnitPrce);
            }
            if (_cursor.isNull(_cursorIndexOfNDiscount)) {
              _item.nDiscount = null;
            } else {
              _item.nDiscount = _cursor.getString(_cursorIndexOfNDiscount);
            }
            if (_cursor.isNull(_cursorIndexOfSBriefDsc)) {
              _item.sBriefDsc = null;
            } else {
              _item.sBriefDsc = _cursor.getString(_cursorIndexOfSBriefDsc);
            }
            if (_cursor.isNull(_cursorIndexOfXBarCodex)) {
              _item.xBarCodex = null;
            } else {
              _item.xBarCodex = _cursor.getString(_cursorIndexOfXBarCodex);
            }
            if (_cursor.isNull(_cursorIndexOfXBrandNme)) {
              _item.xBrandNme = null;
            } else {
              _item.xBrandNme = _cursor.getString(_cursorIndexOfXBrandNme);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfXColorNme)) {
              _item.xColorNme = null;
            } else {
              _item.xColorNme = _cursor.getString(_cursorIndexOfXColorNme);
            }
            if (_cursor.isNull(_cursorIndexOfXCategrNm)) {
              _item.xCategrNm = null;
            } else {
              _item.xCategrNm = _cursor.getString(_cursorIndexOfXCategrNm);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
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
  public LiveData<List<DOrderDetail.OrderedItemsInfo>> GetOrderedItems(final String fsVal) {
    final String _sql = "SELECT a.sListngID AS sListIDxx, a.xModelNme, a.nUnitPrce, a.sStockIDx, a.sImagesxx, b.nQuantity, b.cReviewed FROM Product_Inventory a LEFT JOIN MarketPlace_Order_Detail b ON a.sListngID = b.sReferNox WHERE b.sTransNox =? AND a.cTranStat == '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory","MarketPlace_Order_Detail"}, false, new Callable<List<DOrderDetail.OrderedItemsInfo>>() {
      @Override
      public List<DOrderDetail.OrderedItemsInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSListIDxx = 0;
          final int _cursorIndexOfXModelNme = 1;
          final int _cursorIndexOfNUnitPrce = 2;
          final int _cursorIndexOfSStockIDx = 3;
          final int _cursorIndexOfSImagesxx = 4;
          final int _cursorIndexOfNQuantity = 5;
          final int _cursorIndexOfCReviewed = 6;
          final List<DOrderDetail.OrderedItemsInfo> _result = new ArrayList<DOrderDetail.OrderedItemsInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DOrderDetail.OrderedItemsInfo _item;
            _item = new DOrderDetail.OrderedItemsInfo();
            if (_cursor.isNull(_cursorIndexOfSListIDxx)) {
              _item.sListIDxx = null;
            } else {
              _item.sListIDxx = _cursor.getString(_cursorIndexOfSListIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfXModelNme)) {
              _item.xModelNme = null;
            } else {
              _item.xModelNme = _cursor.getString(_cursorIndexOfXModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfNUnitPrce)) {
              _item.nUnitPrce = null;
            } else {
              _item.nUnitPrce = _cursor.getString(_cursorIndexOfNUnitPrce);
            }
            if (_cursor.isNull(_cursorIndexOfSStockIDx)) {
              _item.sStockIDx = null;
            } else {
              _item.sStockIDx = _cursor.getString(_cursorIndexOfSStockIDx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfNQuantity)) {
              _item.nQuantity = null;
            } else {
              _item.nQuantity = _cursor.getString(_cursorIndexOfNQuantity);
            }
            if (_cursor.isNull(_cursorIndexOfCReviewed)) {
              _item.cReviewed = null;
            } else {
              _item.cReviewed = _cursor.getString(_cursorIndexOfCReviewed);
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
