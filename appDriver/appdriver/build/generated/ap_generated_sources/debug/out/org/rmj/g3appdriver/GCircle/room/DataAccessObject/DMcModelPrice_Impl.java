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
import org.rmj.g3appdriver.GCircle.room.Entities.EMcModelPrice;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DMcModelPrice_Impl implements DMcModelPrice {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EMcModelPrice> __insertionAdapterOfEMcModelPrice;

  private final EntityInsertionAdapter<EMcModelPrice> __insertionAdapterOfEMcModelPrice_1;

  private final EntityDeletionOrUpdateAdapter<EMcModelPrice> __updateAdapterOfEMcModelPrice;

  public DMcModelPrice_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEMcModelPrice = new EntityInsertionAdapter<EMcModelPrice>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Mc_Model_Price` (`sModelIDx`,`nSelPrice`,`nLastPrce`,`nDealrPrc`,`nMinDownx`,`sMCCatIDx`,`dPricexxx`,`dInsPrice`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcModelPrice value) {
        if (value.getModelIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getModelIDx());
        }
        if (value.getSelPrice() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSelPrice());
        }
        if (value.getLastPrce() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastPrce());
        }
        if (value.getDealrPrc() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDealrPrc());
        }
        if (value.getMinDownx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMinDownx());
        }
        if (value.getMCCatIDx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMCCatIDx());
        }
        if (value.getPricexxx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPricexxx());
        }
        if (value.getInsPrice() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getInsPrice());
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
    this.__insertionAdapterOfEMcModelPrice_1 = new EntityInsertionAdapter<EMcModelPrice>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Mc_Model_Price` (`sModelIDx`,`nSelPrice`,`nLastPrce`,`nDealrPrc`,`nMinDownx`,`sMCCatIDx`,`dPricexxx`,`dInsPrice`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcModelPrice value) {
        if (value.getModelIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getModelIDx());
        }
        if (value.getSelPrice() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSelPrice());
        }
        if (value.getLastPrce() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastPrce());
        }
        if (value.getDealrPrc() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDealrPrc());
        }
        if (value.getMinDownx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMinDownx());
        }
        if (value.getMCCatIDx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMCCatIDx());
        }
        if (value.getPricexxx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPricexxx());
        }
        if (value.getInsPrice() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getInsPrice());
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
    this.__updateAdapterOfEMcModelPrice = new EntityDeletionOrUpdateAdapter<EMcModelPrice>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Mc_Model_Price` SET `sModelIDx` = ?,`nSelPrice` = ?,`nLastPrce` = ?,`nDealrPrc` = ?,`nMinDownx` = ?,`sMCCatIDx` = ?,`dPricexxx` = ?,`dInsPrice` = ?,`cRecdStat` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sModelIDx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcModelPrice value) {
        if (value.getModelIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getModelIDx());
        }
        if (value.getSelPrice() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSelPrice());
        }
        if (value.getLastPrce() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastPrce());
        }
        if (value.getDealrPrc() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDealrPrc());
        }
        if (value.getMinDownx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMinDownx());
        }
        if (value.getMCCatIDx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getMCCatIDx());
        }
        if (value.getPricexxx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getPricexxx());
        }
        if (value.getInsPrice() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getInsPrice());
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
        if (value.getModelIDx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getModelIDx());
        }
      }
    };
  }

  @Override
  public void insert(final EMcModelPrice mcModelPrice) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMcModelPrice.insert(mcModelPrice);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkdData(final List<EMcModelPrice> mcModelPrices) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMcModelPrice_1.insert(mcModelPrices);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EMcModelPrice mcModelPrice) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEMcModelPrice.handle(mcModelPrice);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public EMcModelPrice GetModelPrice(final String fsVal) {
    final String _sql = "SELECT * FROM MC_MODEL_PRICE WHERE sModelIDx =?";
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
      final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
      final int _cursorIndexOfSelPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "nSelPrice");
      final int _cursorIndexOfLastPrce = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPrce");
      final int _cursorIndexOfDealrPrc = CursorUtil.getColumnIndexOrThrow(_cursor, "nDealrPrc");
      final int _cursorIndexOfMinDownx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMinDownx");
      final int _cursorIndexOfMCCatIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMCCatIDx");
      final int _cursorIndexOfPricexxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dPricexxx");
      final int _cursorIndexOfInsPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "dInsPrice");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EMcModelPrice _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcModelPrice();
        final String _tmpModelIDx;
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _tmpModelIDx = null;
        } else {
          _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        _result.setModelIDx(_tmpModelIDx);
        final String _tmpSelPrice;
        if (_cursor.isNull(_cursorIndexOfSelPrice)) {
          _tmpSelPrice = null;
        } else {
          _tmpSelPrice = _cursor.getString(_cursorIndexOfSelPrice);
        }
        _result.setSelPrice(_tmpSelPrice);
        final String _tmpLastPrce;
        if (_cursor.isNull(_cursorIndexOfLastPrce)) {
          _tmpLastPrce = null;
        } else {
          _tmpLastPrce = _cursor.getString(_cursorIndexOfLastPrce);
        }
        _result.setLastPrce(_tmpLastPrce);
        final String _tmpDealrPrc;
        if (_cursor.isNull(_cursorIndexOfDealrPrc)) {
          _tmpDealrPrc = null;
        } else {
          _tmpDealrPrc = _cursor.getString(_cursorIndexOfDealrPrc);
        }
        _result.setDealrPrc(_tmpDealrPrc);
        final String _tmpMinDownx;
        if (_cursor.isNull(_cursorIndexOfMinDownx)) {
          _tmpMinDownx = null;
        } else {
          _tmpMinDownx = _cursor.getString(_cursorIndexOfMinDownx);
        }
        _result.setMinDownx(_tmpMinDownx);
        final String _tmpMCCatIDx;
        if (_cursor.isNull(_cursorIndexOfMCCatIDx)) {
          _tmpMCCatIDx = null;
        } else {
          _tmpMCCatIDx = _cursor.getString(_cursorIndexOfMCCatIDx);
        }
        _result.setMCCatIDx(_tmpMCCatIDx);
        final String _tmpPricexxx;
        if (_cursor.isNull(_cursorIndexOfPricexxx)) {
          _tmpPricexxx = null;
        } else {
          _tmpPricexxx = _cursor.getString(_cursorIndexOfPricexxx);
        }
        _result.setPricexxx(_tmpPricexxx);
        final String _tmpInsPrice;
        if (_cursor.isNull(_cursorIndexOfInsPrice)) {
          _tmpInsPrice = null;
        } else {
          _tmpInsPrice = _cursor.getString(_cursorIndexOfInsPrice);
        }
        _result.setInsPrice(_tmpInsPrice);
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
  public EMcModelPrice GetLatestModelPrice() {
    final String _sql = "SELECT * FROM MC_MODEL_PRICE ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
      final int _cursorIndexOfSelPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "nSelPrice");
      final int _cursorIndexOfLastPrce = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPrce");
      final int _cursorIndexOfDealrPrc = CursorUtil.getColumnIndexOrThrow(_cursor, "nDealrPrc");
      final int _cursorIndexOfMinDownx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMinDownx");
      final int _cursorIndexOfMCCatIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMCCatIDx");
      final int _cursorIndexOfPricexxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dPricexxx");
      final int _cursorIndexOfInsPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "dInsPrice");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EMcModelPrice _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcModelPrice();
        final String _tmpModelIDx;
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _tmpModelIDx = null;
        } else {
          _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        _result.setModelIDx(_tmpModelIDx);
        final String _tmpSelPrice;
        if (_cursor.isNull(_cursorIndexOfSelPrice)) {
          _tmpSelPrice = null;
        } else {
          _tmpSelPrice = _cursor.getString(_cursorIndexOfSelPrice);
        }
        _result.setSelPrice(_tmpSelPrice);
        final String _tmpLastPrce;
        if (_cursor.isNull(_cursorIndexOfLastPrce)) {
          _tmpLastPrce = null;
        } else {
          _tmpLastPrce = _cursor.getString(_cursorIndexOfLastPrce);
        }
        _result.setLastPrce(_tmpLastPrce);
        final String _tmpDealrPrc;
        if (_cursor.isNull(_cursorIndexOfDealrPrc)) {
          _tmpDealrPrc = null;
        } else {
          _tmpDealrPrc = _cursor.getString(_cursorIndexOfDealrPrc);
        }
        _result.setDealrPrc(_tmpDealrPrc);
        final String _tmpMinDownx;
        if (_cursor.isNull(_cursorIndexOfMinDownx)) {
          _tmpMinDownx = null;
        } else {
          _tmpMinDownx = _cursor.getString(_cursorIndexOfMinDownx);
        }
        _result.setMinDownx(_tmpMinDownx);
        final String _tmpMCCatIDx;
        if (_cursor.isNull(_cursorIndexOfMCCatIDx)) {
          _tmpMCCatIDx = null;
        } else {
          _tmpMCCatIDx = _cursor.getString(_cursorIndexOfMCCatIDx);
        }
        _result.setMCCatIDx(_tmpMCCatIDx);
        final String _tmpPricexxx;
        if (_cursor.isNull(_cursorIndexOfPricexxx)) {
          _tmpPricexxx = null;
        } else {
          _tmpPricexxx = _cursor.getString(_cursorIndexOfPricexxx);
        }
        _result.setPricexxx(_tmpPricexxx);
        final String _tmpInsPrice;
        if (_cursor.isNull(_cursorIndexOfInsPrice)) {
          _tmpInsPrice = null;
        } else {
          _tmpInsPrice = _cursor.getString(_cursorIndexOfInsPrice);
        }
        _result.setInsPrice(_tmpInsPrice);
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
  public LiveData<List<EMcModelPrice>> getAllModelPrice(final String BrandID) {
    final String _sql = "SELECT * FROM Mc_Model_Price WHERE sModelIDx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BrandID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BrandID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mc_Model_Price"}, false, new Callable<List<EMcModelPrice>>() {
      @Override
      public List<EMcModelPrice> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
          final int _cursorIndexOfSelPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "nSelPrice");
          final int _cursorIndexOfLastPrce = CursorUtil.getColumnIndexOrThrow(_cursor, "nLastPrce");
          final int _cursorIndexOfDealrPrc = CursorUtil.getColumnIndexOrThrow(_cursor, "nDealrPrc");
          final int _cursorIndexOfMinDownx = CursorUtil.getColumnIndexOrThrow(_cursor, "nMinDownx");
          final int _cursorIndexOfMCCatIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMCCatIDx");
          final int _cursorIndexOfPricexxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dPricexxx");
          final int _cursorIndexOfInsPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "dInsPrice");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EMcModelPrice> _result = new ArrayList<EMcModelPrice>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMcModelPrice _item;
            _item = new EMcModelPrice();
            final String _tmpModelIDx;
            if (_cursor.isNull(_cursorIndexOfModelIDx)) {
              _tmpModelIDx = null;
            } else {
              _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
            }
            _item.setModelIDx(_tmpModelIDx);
            final String _tmpSelPrice;
            if (_cursor.isNull(_cursorIndexOfSelPrice)) {
              _tmpSelPrice = null;
            } else {
              _tmpSelPrice = _cursor.getString(_cursorIndexOfSelPrice);
            }
            _item.setSelPrice(_tmpSelPrice);
            final String _tmpLastPrce;
            if (_cursor.isNull(_cursorIndexOfLastPrce)) {
              _tmpLastPrce = null;
            } else {
              _tmpLastPrce = _cursor.getString(_cursorIndexOfLastPrce);
            }
            _item.setLastPrce(_tmpLastPrce);
            final String _tmpDealrPrc;
            if (_cursor.isNull(_cursorIndexOfDealrPrc)) {
              _tmpDealrPrc = null;
            } else {
              _tmpDealrPrc = _cursor.getString(_cursorIndexOfDealrPrc);
            }
            _item.setDealrPrc(_tmpDealrPrc);
            final String _tmpMinDownx;
            if (_cursor.isNull(_cursorIndexOfMinDownx)) {
              _tmpMinDownx = null;
            } else {
              _tmpMinDownx = _cursor.getString(_cursorIndexOfMinDownx);
            }
            _item.setMinDownx(_tmpMinDownx);
            final String _tmpMCCatIDx;
            if (_cursor.isNull(_cursorIndexOfMCCatIDx)) {
              _tmpMCCatIDx = null;
            } else {
              _tmpMCCatIDx = _cursor.getString(_cursorIndexOfMCCatIDx);
            }
            _item.setMCCatIDx(_tmpMCCatIDx);
            final String _tmpPricexxx;
            if (_cursor.isNull(_cursorIndexOfPricexxx)) {
              _tmpPricexxx = null;
            } else {
              _tmpPricexxx = _cursor.getString(_cursorIndexOfPricexxx);
            }
            _item.setPricexxx(_tmpPricexxx);
            final String _tmpInsPrice;
            if (_cursor.isNull(_cursorIndexOfInsPrice)) {
              _tmpInsPrice = null;
            } else {
              _tmpInsPrice = _cursor.getString(_cursorIndexOfInsPrice);
            }
            _item.setInsPrice(_tmpInsPrice);
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
  public String getLatestDataTime() {
    final String _sql = "SELECT MAX(dTimeStmp) FROM Mc_Model_Price";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
