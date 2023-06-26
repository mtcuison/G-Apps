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
import org.rmj.g3appdriver.GConnect.room.Entities.EProducts;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DProduct_Impl implements DProduct {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EProducts> __insertionAdapterOfEProducts;

  private final EntityDeletionOrUpdateAdapter<EProducts> __updateAdapterOfEProducts;

  private final SharedSQLiteStatement __preparedStmtOfUpdateProductQtyInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateProductListing;

  public DProduct_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEProducts = new EntityInsertionAdapter<EProducts>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Product_Inventory` (`sListngID`,`sBriefDsc`,`sDescript`,`sStockIDx`,`xBarCodex`,`xDescript`,`nRatingxx`,`xBrandNme`,`sModelIDx`,`xModelNme`,`sImagesxx`,`xColorNme`,`xCategrNm`,`nTotalQty`,`nQtyOnHnd`,`nResvOrdr`,`nSoldQtyx`,`nUnitPrce`,`dListStrt`,`dListEndx`,`cAllwCrdt`,`cTranStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EProducts value) {
        if (value.getListngID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getListngID());
        }
        if (value.getBriefDsc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBriefDsc());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescript());
        }
        if (value.getStockIDx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStockIDx());
        }
        if (value.getBarCodex() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBarCodex());
        }
        if (value.getDescrptx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescrptx());
        }
        if (value.getRatingxx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRatingxx());
        }
        if (value.getBrandNme() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBrandNme());
        }
        if (value.getModelIDx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getModelIDx());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModelNme());
        }
        if (value.getImagesxx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getImagesxx());
        }
        if (value.getColorNme() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getColorNme());
        }
        if (value.getCategrNm() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCategrNm());
        }
        if (value.getTotalQty() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTotalQty());
        }
        if (value.getQtyOnHnd() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getQtyOnHnd());
        }
        if (value.getResvOrdr() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getResvOrdr());
        }
        if (value.getSoldQtyx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSoldQtyx());
        }
        if (value.getUnitPrce() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getUnitPrce());
        }
        if (value.getListStrt() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getListStrt());
        }
        if (value.getListEndx() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getListEndx());
        }
        if (value.getAllwCrdt() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getAllwCrdt());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getTranStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEProducts = new EntityDeletionOrUpdateAdapter<EProducts>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Product_Inventory` SET `sListngID` = ?,`sBriefDsc` = ?,`sDescript` = ?,`sStockIDx` = ?,`xBarCodex` = ?,`xDescript` = ?,`nRatingxx` = ?,`xBrandNme` = ?,`sModelIDx` = ?,`xModelNme` = ?,`sImagesxx` = ?,`xColorNme` = ?,`xCategrNm` = ?,`nTotalQty` = ?,`nQtyOnHnd` = ?,`nResvOrdr` = ?,`nSoldQtyx` = ?,`nUnitPrce` = ?,`dListStrt` = ?,`dListEndx` = ?,`cAllwCrdt` = ?,`cTranStat` = ?,`dTimeStmp` = ? WHERE `sListngID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EProducts value) {
        if (value.getListngID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getListngID());
        }
        if (value.getBriefDsc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBriefDsc());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescript());
        }
        if (value.getStockIDx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStockIDx());
        }
        if (value.getBarCodex() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getBarCodex());
        }
        if (value.getDescrptx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDescrptx());
        }
        if (value.getRatingxx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRatingxx());
        }
        if (value.getBrandNme() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getBrandNme());
        }
        if (value.getModelIDx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getModelIDx());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModelNme());
        }
        if (value.getImagesxx() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getImagesxx());
        }
        if (value.getColorNme() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getColorNme());
        }
        if (value.getCategrNm() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCategrNm());
        }
        if (value.getTotalQty() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTotalQty());
        }
        if (value.getQtyOnHnd() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getQtyOnHnd());
        }
        if (value.getResvOrdr() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getResvOrdr());
        }
        if (value.getSoldQtyx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSoldQtyx());
        }
        if (value.getUnitPrce() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getUnitPrce());
        }
        if (value.getListStrt() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getListStrt());
        }
        if (value.getListEndx() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getListEndx());
        }
        if (value.getAllwCrdt() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getAllwCrdt());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getTranStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getTimeStmp());
        }
        if (value.getListngID() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getListngID());
        }
      }
    };
    this.__preparedStmtOfUpdateProductQtyInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Product_Inventory SET nTotalQty =?, nQtyOnHnd =?, nResvOrdr =?, nSoldQtyx =?, nUnitPrce =? WHERE sListngID=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateProductListing = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Product_Inventory SET nTotalQty =?, nQtyOnHnd =?, nResvOrdr =?, nSoldQtyx =?, nUnitPrce =?, dListStrt =?, dListEndx =?, cTranStat =?, dTimeStmp =? WHERE sListngID =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveProductInfo(final EProducts foValue) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEProducts.insert(foValue);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateProductInfo(final EProducts foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEProducts.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateProductQtyInfo(final String fsLstID, final String nTotalQty,
      final String nQtyOnHnd, final String nResvOrdr, final String nSoldQtyx,
      final String nUnitPrce) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateProductQtyInfo.acquire();
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
      __preparedStmtOfUpdateProductQtyInfo.release(_stmt);
    }
  }

  @Override
  public void UpdateProductListing(final String ListngID, final String TotalQty,
      final String QtyOnHnd, final String ResvOrdr, final String SoldQtyx, final String UnitPrce,
      final String ListStrt, final String ListEndx, final String TranStat, final String TimeStmp) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateProductListing.acquire();
    int _argIndex = 1;
    if (TotalQty == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TotalQty);
    }
    _argIndex = 2;
    if (QtyOnHnd == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, QtyOnHnd);
    }
    _argIndex = 3;
    if (ResvOrdr == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ResvOrdr);
    }
    _argIndex = 4;
    if (SoldQtyx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, SoldQtyx);
    }
    _argIndex = 5;
    if (UnitPrce == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, UnitPrce);
    }
    _argIndex = 6;
    if (ListStrt == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ListStrt);
    }
    _argIndex = 7;
    if (ListEndx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ListEndx);
    }
    _argIndex = 8;
    if (TranStat == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TranStat);
    }
    _argIndex = 9;
    if (TimeStmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TimeStmp);
    }
    _argIndex = 10;
    if (ListngID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ListngID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateProductListing.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EProducts>> GetProductList(final int nIndex) {
    final String _sql = "SELECT * FROM Product_Inventory LIMIT 10 OFFSET?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, nIndex);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<EProducts>>() {
      @Override
      public List<EProducts> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfListngID = CursorUtil.getColumnIndexOrThrow(_cursor, "sListngID");
          final int _cursorIndexOfBriefDsc = CursorUtil.getColumnIndexOrThrow(_cursor, "sBriefDsc");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfStockIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sStockIDx");
          final int _cursorIndexOfBarCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "xBarCodex");
          final int _cursorIndexOfDescrptx = CursorUtil.getColumnIndexOrThrow(_cursor, "xDescript");
          final int _cursorIndexOfRatingxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRatingxx");
          final int _cursorIndexOfBrandNme = CursorUtil.getColumnIndexOrThrow(_cursor, "xBrandNme");
          final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
          final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "xModelNme");
          final int _cursorIndexOfImagesxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sImagesxx");
          final int _cursorIndexOfColorNme = CursorUtil.getColumnIndexOrThrow(_cursor, "xColorNme");
          final int _cursorIndexOfCategrNm = CursorUtil.getColumnIndexOrThrow(_cursor, "xCategrNm");
          final int _cursorIndexOfTotalQty = CursorUtil.getColumnIndexOrThrow(_cursor, "nTotalQty");
          final int _cursorIndexOfQtyOnHnd = CursorUtil.getColumnIndexOrThrow(_cursor, "nQtyOnHnd");
          final int _cursorIndexOfResvOrdr = CursorUtil.getColumnIndexOrThrow(_cursor, "nResvOrdr");
          final int _cursorIndexOfSoldQtyx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSoldQtyx");
          final int _cursorIndexOfUnitPrce = CursorUtil.getColumnIndexOrThrow(_cursor, "nUnitPrce");
          final int _cursorIndexOfListStrt = CursorUtil.getColumnIndexOrThrow(_cursor, "dListStrt");
          final int _cursorIndexOfListEndx = CursorUtil.getColumnIndexOrThrow(_cursor, "dListEndx");
          final int _cursorIndexOfAllwCrdt = CursorUtil.getColumnIndexOrThrow(_cursor, "cAllwCrdt");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EProducts> _result = new ArrayList<EProducts>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EProducts _item;
            _item = new EProducts();
            final String _tmpListngID;
            if (_cursor.isNull(_cursorIndexOfListngID)) {
              _tmpListngID = null;
            } else {
              _tmpListngID = _cursor.getString(_cursorIndexOfListngID);
            }
            _item.setListngID(_tmpListngID);
            final String _tmpBriefDsc;
            if (_cursor.isNull(_cursorIndexOfBriefDsc)) {
              _tmpBriefDsc = null;
            } else {
              _tmpBriefDsc = _cursor.getString(_cursorIndexOfBriefDsc);
            }
            _item.setBriefDsc(_tmpBriefDsc);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpStockIDx;
            if (_cursor.isNull(_cursorIndexOfStockIDx)) {
              _tmpStockIDx = null;
            } else {
              _tmpStockIDx = _cursor.getString(_cursorIndexOfStockIDx);
            }
            _item.setStockIDx(_tmpStockIDx);
            final String _tmpBarCodex;
            if (_cursor.isNull(_cursorIndexOfBarCodex)) {
              _tmpBarCodex = null;
            } else {
              _tmpBarCodex = _cursor.getString(_cursorIndexOfBarCodex);
            }
            _item.setBarCodex(_tmpBarCodex);
            final String _tmpDescrptx;
            if (_cursor.isNull(_cursorIndexOfDescrptx)) {
              _tmpDescrptx = null;
            } else {
              _tmpDescrptx = _cursor.getString(_cursorIndexOfDescrptx);
            }
            _item.setDescrptx(_tmpDescrptx);
            final String _tmpRatingxx;
            if (_cursor.isNull(_cursorIndexOfRatingxx)) {
              _tmpRatingxx = null;
            } else {
              _tmpRatingxx = _cursor.getString(_cursorIndexOfRatingxx);
            }
            _item.setRatingxx(_tmpRatingxx);
            final String _tmpBrandNme;
            if (_cursor.isNull(_cursorIndexOfBrandNme)) {
              _tmpBrandNme = null;
            } else {
              _tmpBrandNme = _cursor.getString(_cursorIndexOfBrandNme);
            }
            _item.setBrandNme(_tmpBrandNme);
            final String _tmpModelIDx;
            if (_cursor.isNull(_cursorIndexOfModelIDx)) {
              _tmpModelIDx = null;
            } else {
              _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
            }
            _item.setModelIDx(_tmpModelIDx);
            final String _tmpModelNme;
            if (_cursor.isNull(_cursorIndexOfModelNme)) {
              _tmpModelNme = null;
            } else {
              _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
            }
            _item.setModelNme(_tmpModelNme);
            final String _tmpImagesxx;
            if (_cursor.isNull(_cursorIndexOfImagesxx)) {
              _tmpImagesxx = null;
            } else {
              _tmpImagesxx = _cursor.getString(_cursorIndexOfImagesxx);
            }
            _item.setImagesxx(_tmpImagesxx);
            final String _tmpColorNme;
            if (_cursor.isNull(_cursorIndexOfColorNme)) {
              _tmpColorNme = null;
            } else {
              _tmpColorNme = _cursor.getString(_cursorIndexOfColorNme);
            }
            _item.setColorNme(_tmpColorNme);
            final String _tmpCategrNm;
            if (_cursor.isNull(_cursorIndexOfCategrNm)) {
              _tmpCategrNm = null;
            } else {
              _tmpCategrNm = _cursor.getString(_cursorIndexOfCategrNm);
            }
            _item.setCategrNm(_tmpCategrNm);
            final String _tmpTotalQty;
            if (_cursor.isNull(_cursorIndexOfTotalQty)) {
              _tmpTotalQty = null;
            } else {
              _tmpTotalQty = _cursor.getString(_cursorIndexOfTotalQty);
            }
            _item.setTotalQty(_tmpTotalQty);
            final String _tmpQtyOnHnd;
            if (_cursor.isNull(_cursorIndexOfQtyOnHnd)) {
              _tmpQtyOnHnd = null;
            } else {
              _tmpQtyOnHnd = _cursor.getString(_cursorIndexOfQtyOnHnd);
            }
            _item.setQtyOnHnd(_tmpQtyOnHnd);
            final String _tmpResvOrdr;
            if (_cursor.isNull(_cursorIndexOfResvOrdr)) {
              _tmpResvOrdr = null;
            } else {
              _tmpResvOrdr = _cursor.getString(_cursorIndexOfResvOrdr);
            }
            _item.setResvOrdr(_tmpResvOrdr);
            final String _tmpSoldQtyx;
            if (_cursor.isNull(_cursorIndexOfSoldQtyx)) {
              _tmpSoldQtyx = null;
            } else {
              _tmpSoldQtyx = _cursor.getString(_cursorIndexOfSoldQtyx);
            }
            _item.setSoldQtyx(_tmpSoldQtyx);
            final String _tmpUnitPrce;
            if (_cursor.isNull(_cursorIndexOfUnitPrce)) {
              _tmpUnitPrce = null;
            } else {
              _tmpUnitPrce = _cursor.getString(_cursorIndexOfUnitPrce);
            }
            _item.setUnitPrce(_tmpUnitPrce);
            final String _tmpListStrt;
            if (_cursor.isNull(_cursorIndexOfListStrt)) {
              _tmpListStrt = null;
            } else {
              _tmpListStrt = _cursor.getString(_cursorIndexOfListStrt);
            }
            _item.setListStrt(_tmpListStrt);
            final String _tmpListEndx;
            if (_cursor.isNull(_cursorIndexOfListEndx)) {
              _tmpListEndx = null;
            } else {
              _tmpListEndx = _cursor.getString(_cursorIndexOfListEndx);
            }
            _item.setListEndx(_tmpListEndx);
            final String _tmpAllwCrdt;
            if (_cursor.isNull(_cursorIndexOfAllwCrdt)) {
              _tmpAllwCrdt = null;
            } else {
              _tmpAllwCrdt = _cursor.getString(_cursorIndexOfAllwCrdt);
            }
            _item.setAllwCrdt(_tmpAllwCrdt);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
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
  public LiveData<EProducts> GetProductInfo(final String fsLstID) {
    final String _sql = "SELECT * FROM Product_Inventory WHERE sListngID=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsLstID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsLstID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<EProducts>() {
      @Override
      public EProducts call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfListngID = CursorUtil.getColumnIndexOrThrow(_cursor, "sListngID");
          final int _cursorIndexOfBriefDsc = CursorUtil.getColumnIndexOrThrow(_cursor, "sBriefDsc");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfStockIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sStockIDx");
          final int _cursorIndexOfBarCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "xBarCodex");
          final int _cursorIndexOfDescrptx = CursorUtil.getColumnIndexOrThrow(_cursor, "xDescript");
          final int _cursorIndexOfRatingxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRatingxx");
          final int _cursorIndexOfBrandNme = CursorUtil.getColumnIndexOrThrow(_cursor, "xBrandNme");
          final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
          final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "xModelNme");
          final int _cursorIndexOfImagesxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sImagesxx");
          final int _cursorIndexOfColorNme = CursorUtil.getColumnIndexOrThrow(_cursor, "xColorNme");
          final int _cursorIndexOfCategrNm = CursorUtil.getColumnIndexOrThrow(_cursor, "xCategrNm");
          final int _cursorIndexOfTotalQty = CursorUtil.getColumnIndexOrThrow(_cursor, "nTotalQty");
          final int _cursorIndexOfQtyOnHnd = CursorUtil.getColumnIndexOrThrow(_cursor, "nQtyOnHnd");
          final int _cursorIndexOfResvOrdr = CursorUtil.getColumnIndexOrThrow(_cursor, "nResvOrdr");
          final int _cursorIndexOfSoldQtyx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSoldQtyx");
          final int _cursorIndexOfUnitPrce = CursorUtil.getColumnIndexOrThrow(_cursor, "nUnitPrce");
          final int _cursorIndexOfListStrt = CursorUtil.getColumnIndexOrThrow(_cursor, "dListStrt");
          final int _cursorIndexOfListEndx = CursorUtil.getColumnIndexOrThrow(_cursor, "dListEndx");
          final int _cursorIndexOfAllwCrdt = CursorUtil.getColumnIndexOrThrow(_cursor, "cAllwCrdt");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final EProducts _result;
          if(_cursor.moveToFirst()) {
            _result = new EProducts();
            final String _tmpListngID;
            if (_cursor.isNull(_cursorIndexOfListngID)) {
              _tmpListngID = null;
            } else {
              _tmpListngID = _cursor.getString(_cursorIndexOfListngID);
            }
            _result.setListngID(_tmpListngID);
            final String _tmpBriefDsc;
            if (_cursor.isNull(_cursorIndexOfBriefDsc)) {
              _tmpBriefDsc = null;
            } else {
              _tmpBriefDsc = _cursor.getString(_cursorIndexOfBriefDsc);
            }
            _result.setBriefDsc(_tmpBriefDsc);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _result.setDescript(_tmpDescript);
            final String _tmpStockIDx;
            if (_cursor.isNull(_cursorIndexOfStockIDx)) {
              _tmpStockIDx = null;
            } else {
              _tmpStockIDx = _cursor.getString(_cursorIndexOfStockIDx);
            }
            _result.setStockIDx(_tmpStockIDx);
            final String _tmpBarCodex;
            if (_cursor.isNull(_cursorIndexOfBarCodex)) {
              _tmpBarCodex = null;
            } else {
              _tmpBarCodex = _cursor.getString(_cursorIndexOfBarCodex);
            }
            _result.setBarCodex(_tmpBarCodex);
            final String _tmpDescrptx;
            if (_cursor.isNull(_cursorIndexOfDescrptx)) {
              _tmpDescrptx = null;
            } else {
              _tmpDescrptx = _cursor.getString(_cursorIndexOfDescrptx);
            }
            _result.setDescrptx(_tmpDescrptx);
            final String _tmpRatingxx;
            if (_cursor.isNull(_cursorIndexOfRatingxx)) {
              _tmpRatingxx = null;
            } else {
              _tmpRatingxx = _cursor.getString(_cursorIndexOfRatingxx);
            }
            _result.setRatingxx(_tmpRatingxx);
            final String _tmpBrandNme;
            if (_cursor.isNull(_cursorIndexOfBrandNme)) {
              _tmpBrandNme = null;
            } else {
              _tmpBrandNme = _cursor.getString(_cursorIndexOfBrandNme);
            }
            _result.setBrandNme(_tmpBrandNme);
            final String _tmpModelIDx;
            if (_cursor.isNull(_cursorIndexOfModelIDx)) {
              _tmpModelIDx = null;
            } else {
              _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
            }
            _result.setModelIDx(_tmpModelIDx);
            final String _tmpModelNme;
            if (_cursor.isNull(_cursorIndexOfModelNme)) {
              _tmpModelNme = null;
            } else {
              _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
            }
            _result.setModelNme(_tmpModelNme);
            final String _tmpImagesxx;
            if (_cursor.isNull(_cursorIndexOfImagesxx)) {
              _tmpImagesxx = null;
            } else {
              _tmpImagesxx = _cursor.getString(_cursorIndexOfImagesxx);
            }
            _result.setImagesxx(_tmpImagesxx);
            final String _tmpColorNme;
            if (_cursor.isNull(_cursorIndexOfColorNme)) {
              _tmpColorNme = null;
            } else {
              _tmpColorNme = _cursor.getString(_cursorIndexOfColorNme);
            }
            _result.setColorNme(_tmpColorNme);
            final String _tmpCategrNm;
            if (_cursor.isNull(_cursorIndexOfCategrNm)) {
              _tmpCategrNm = null;
            } else {
              _tmpCategrNm = _cursor.getString(_cursorIndexOfCategrNm);
            }
            _result.setCategrNm(_tmpCategrNm);
            final String _tmpTotalQty;
            if (_cursor.isNull(_cursorIndexOfTotalQty)) {
              _tmpTotalQty = null;
            } else {
              _tmpTotalQty = _cursor.getString(_cursorIndexOfTotalQty);
            }
            _result.setTotalQty(_tmpTotalQty);
            final String _tmpQtyOnHnd;
            if (_cursor.isNull(_cursorIndexOfQtyOnHnd)) {
              _tmpQtyOnHnd = null;
            } else {
              _tmpQtyOnHnd = _cursor.getString(_cursorIndexOfQtyOnHnd);
            }
            _result.setQtyOnHnd(_tmpQtyOnHnd);
            final String _tmpResvOrdr;
            if (_cursor.isNull(_cursorIndexOfResvOrdr)) {
              _tmpResvOrdr = null;
            } else {
              _tmpResvOrdr = _cursor.getString(_cursorIndexOfResvOrdr);
            }
            _result.setResvOrdr(_tmpResvOrdr);
            final String _tmpSoldQtyx;
            if (_cursor.isNull(_cursorIndexOfSoldQtyx)) {
              _tmpSoldQtyx = null;
            } else {
              _tmpSoldQtyx = _cursor.getString(_cursorIndexOfSoldQtyx);
            }
            _result.setSoldQtyx(_tmpSoldQtyx);
            final String _tmpUnitPrce;
            if (_cursor.isNull(_cursorIndexOfUnitPrce)) {
              _tmpUnitPrce = null;
            } else {
              _tmpUnitPrce = _cursor.getString(_cursorIndexOfUnitPrce);
            }
            _result.setUnitPrce(_tmpUnitPrce);
            final String _tmpListStrt;
            if (_cursor.isNull(_cursorIndexOfListStrt)) {
              _tmpListStrt = null;
            } else {
              _tmpListStrt = _cursor.getString(_cursorIndexOfListStrt);
            }
            _result.setListStrt(_tmpListStrt);
            final String _tmpListEndx;
            if (_cursor.isNull(_cursorIndexOfListEndx)) {
              _tmpListEndx = null;
            } else {
              _tmpListEndx = _cursor.getString(_cursorIndexOfListEndx);
            }
            _result.setListEndx(_tmpListEndx);
            final String _tmpAllwCrdt;
            if (_cursor.isNull(_cursorIndexOfAllwCrdt)) {
              _tmpAllwCrdt = null;
            } else {
              _tmpAllwCrdt = _cursor.getString(_cursorIndexOfAllwCrdt);
            }
            _result.setAllwCrdt(_tmpAllwCrdt);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
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

  @Override
  public String GetLatestProductStamp() {
    final String _sql = "SELECT dTimeStmp FROM Product_Inventory ORDER BY dTimeStmp DESC LIMIT 1";
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
  public EProducts GetProductIfExist(final String fsVal) {
    final String _sql = "SELECT * FROM Product_Inventory WHERE sListngID =?";
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
      final int _cursorIndexOfListngID = CursorUtil.getColumnIndexOrThrow(_cursor, "sListngID");
      final int _cursorIndexOfBriefDsc = CursorUtil.getColumnIndexOrThrow(_cursor, "sBriefDsc");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfStockIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sStockIDx");
      final int _cursorIndexOfBarCodex = CursorUtil.getColumnIndexOrThrow(_cursor, "xBarCodex");
      final int _cursorIndexOfDescrptx = CursorUtil.getColumnIndexOrThrow(_cursor, "xDescript");
      final int _cursorIndexOfRatingxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRatingxx");
      final int _cursorIndexOfBrandNme = CursorUtil.getColumnIndexOrThrow(_cursor, "xBrandNme");
      final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
      final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "xModelNme");
      final int _cursorIndexOfImagesxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sImagesxx");
      final int _cursorIndexOfColorNme = CursorUtil.getColumnIndexOrThrow(_cursor, "xColorNme");
      final int _cursorIndexOfCategrNm = CursorUtil.getColumnIndexOrThrow(_cursor, "xCategrNm");
      final int _cursorIndexOfTotalQty = CursorUtil.getColumnIndexOrThrow(_cursor, "nTotalQty");
      final int _cursorIndexOfQtyOnHnd = CursorUtil.getColumnIndexOrThrow(_cursor, "nQtyOnHnd");
      final int _cursorIndexOfResvOrdr = CursorUtil.getColumnIndexOrThrow(_cursor, "nResvOrdr");
      final int _cursorIndexOfSoldQtyx = CursorUtil.getColumnIndexOrThrow(_cursor, "nSoldQtyx");
      final int _cursorIndexOfUnitPrce = CursorUtil.getColumnIndexOrThrow(_cursor, "nUnitPrce");
      final int _cursorIndexOfListStrt = CursorUtil.getColumnIndexOrThrow(_cursor, "dListStrt");
      final int _cursorIndexOfListEndx = CursorUtil.getColumnIndexOrThrow(_cursor, "dListEndx");
      final int _cursorIndexOfAllwCrdt = CursorUtil.getColumnIndexOrThrow(_cursor, "cAllwCrdt");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EProducts _result;
      if(_cursor.moveToFirst()) {
        _result = new EProducts();
        final String _tmpListngID;
        if (_cursor.isNull(_cursorIndexOfListngID)) {
          _tmpListngID = null;
        } else {
          _tmpListngID = _cursor.getString(_cursorIndexOfListngID);
        }
        _result.setListngID(_tmpListngID);
        final String _tmpBriefDsc;
        if (_cursor.isNull(_cursorIndexOfBriefDsc)) {
          _tmpBriefDsc = null;
        } else {
          _tmpBriefDsc = _cursor.getString(_cursorIndexOfBriefDsc);
        }
        _result.setBriefDsc(_tmpBriefDsc);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _result.setDescript(_tmpDescript);
        final String _tmpStockIDx;
        if (_cursor.isNull(_cursorIndexOfStockIDx)) {
          _tmpStockIDx = null;
        } else {
          _tmpStockIDx = _cursor.getString(_cursorIndexOfStockIDx);
        }
        _result.setStockIDx(_tmpStockIDx);
        final String _tmpBarCodex;
        if (_cursor.isNull(_cursorIndexOfBarCodex)) {
          _tmpBarCodex = null;
        } else {
          _tmpBarCodex = _cursor.getString(_cursorIndexOfBarCodex);
        }
        _result.setBarCodex(_tmpBarCodex);
        final String _tmpDescrptx;
        if (_cursor.isNull(_cursorIndexOfDescrptx)) {
          _tmpDescrptx = null;
        } else {
          _tmpDescrptx = _cursor.getString(_cursorIndexOfDescrptx);
        }
        _result.setDescrptx(_tmpDescrptx);
        final String _tmpRatingxx;
        if (_cursor.isNull(_cursorIndexOfRatingxx)) {
          _tmpRatingxx = null;
        } else {
          _tmpRatingxx = _cursor.getString(_cursorIndexOfRatingxx);
        }
        _result.setRatingxx(_tmpRatingxx);
        final String _tmpBrandNme;
        if (_cursor.isNull(_cursorIndexOfBrandNme)) {
          _tmpBrandNme = null;
        } else {
          _tmpBrandNme = _cursor.getString(_cursorIndexOfBrandNme);
        }
        _result.setBrandNme(_tmpBrandNme);
        final String _tmpModelIDx;
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _tmpModelIDx = null;
        } else {
          _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        _result.setModelIDx(_tmpModelIDx);
        final String _tmpModelNme;
        if (_cursor.isNull(_cursorIndexOfModelNme)) {
          _tmpModelNme = null;
        } else {
          _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
        }
        _result.setModelNme(_tmpModelNme);
        final String _tmpImagesxx;
        if (_cursor.isNull(_cursorIndexOfImagesxx)) {
          _tmpImagesxx = null;
        } else {
          _tmpImagesxx = _cursor.getString(_cursorIndexOfImagesxx);
        }
        _result.setImagesxx(_tmpImagesxx);
        final String _tmpColorNme;
        if (_cursor.isNull(_cursorIndexOfColorNme)) {
          _tmpColorNme = null;
        } else {
          _tmpColorNme = _cursor.getString(_cursorIndexOfColorNme);
        }
        _result.setColorNme(_tmpColorNme);
        final String _tmpCategrNm;
        if (_cursor.isNull(_cursorIndexOfCategrNm)) {
          _tmpCategrNm = null;
        } else {
          _tmpCategrNm = _cursor.getString(_cursorIndexOfCategrNm);
        }
        _result.setCategrNm(_tmpCategrNm);
        final String _tmpTotalQty;
        if (_cursor.isNull(_cursorIndexOfTotalQty)) {
          _tmpTotalQty = null;
        } else {
          _tmpTotalQty = _cursor.getString(_cursorIndexOfTotalQty);
        }
        _result.setTotalQty(_tmpTotalQty);
        final String _tmpQtyOnHnd;
        if (_cursor.isNull(_cursorIndexOfQtyOnHnd)) {
          _tmpQtyOnHnd = null;
        } else {
          _tmpQtyOnHnd = _cursor.getString(_cursorIndexOfQtyOnHnd);
        }
        _result.setQtyOnHnd(_tmpQtyOnHnd);
        final String _tmpResvOrdr;
        if (_cursor.isNull(_cursorIndexOfResvOrdr)) {
          _tmpResvOrdr = null;
        } else {
          _tmpResvOrdr = _cursor.getString(_cursorIndexOfResvOrdr);
        }
        _result.setResvOrdr(_tmpResvOrdr);
        final String _tmpSoldQtyx;
        if (_cursor.isNull(_cursorIndexOfSoldQtyx)) {
          _tmpSoldQtyx = null;
        } else {
          _tmpSoldQtyx = _cursor.getString(_cursorIndexOfSoldQtyx);
        }
        _result.setSoldQtyx(_tmpSoldQtyx);
        final String _tmpUnitPrce;
        if (_cursor.isNull(_cursorIndexOfUnitPrce)) {
          _tmpUnitPrce = null;
        } else {
          _tmpUnitPrce = _cursor.getString(_cursorIndexOfUnitPrce);
        }
        _result.setUnitPrce(_tmpUnitPrce);
        final String _tmpListStrt;
        if (_cursor.isNull(_cursorIndexOfListStrt)) {
          _tmpListStrt = null;
        } else {
          _tmpListStrt = _cursor.getString(_cursorIndexOfListStrt);
        }
        _result.setListStrt(_tmpListStrt);
        final String _tmpListEndx;
        if (_cursor.isNull(_cursorIndexOfListEndx)) {
          _tmpListEndx = null;
        } else {
          _tmpListEndx = _cursor.getString(_cursorIndexOfListEndx);
        }
        _result.setListEndx(_tmpListEndx);
        final String _tmpAllwCrdt;
        if (_cursor.isNull(_cursorIndexOfAllwCrdt)) {
          _tmpAllwCrdt = null;
        } else {
          _tmpAllwCrdt = _cursor.getString(_cursorIndexOfAllwCrdt);
        }
        _result.setAllwCrdt(_tmpAllwCrdt);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
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
  public LiveData<List<DProduct.oProduct>> GetProductsList(final int fnIndex) {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx, sImagesxx, nSoldQtyx AS sUntsSold FROM Product_Inventory WHERE strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND nQtyOnHnd > 0 AND cTranStat = '1' ORDER BY dListStrt DESC LIMIT 10 OFFSET?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, fnIndex);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
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
  public LiveData<List<DProduct.oProduct>> GetProductsListPriceSortASC(final int nIndex) {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx, sImagesxx, nSoldQtyx AS sUntsSold FROM Product_Inventory WHERE strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND nQtyOnHnd > 0 AND cTranStat = '1' ORDER BY nUnitPrce ASC LIMIT 10 OFFSET?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, nIndex);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
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
  public LiveData<List<DProduct.oProduct>> GetProductsListPriceSortDESC(final int nIndex) {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx, sImagesxx, nSoldQtyx AS sUntsSold FROM Product_Inventory WHERE strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND nQtyOnHnd > 0 AND cTranStat = '1'ORDER BY nUnitPrce DESC LIMIT 10 OFFSET? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, nIndex);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
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
  public LiveData<List<DProduct.oProduct>> GetProductsListFilterCategory(final int nIndex,
      final String fsCategory) {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx,sImagesxx, nSoldQtyx AS sUntsSold FROM Product_Inventory WHERE xCategrNm =? AND strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND nQtyOnHnd > 0 AND cTranStat = '1'LIMIT 10 OFFSET?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsCategory == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsCategory);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, nIndex);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
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
  public LiveData<List<DProduct.oProduct>> GetProductsListFilterBrandName(final int nIndex,
      final String fsName) {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx,sImagesxx, nSoldQtyx AS sUntsSold FROM Product_Inventory WHERE xBrandNme LIKE '%' || ? || '%' AND strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND nQtyOnHnd > 0 AND cTranStat = '1'LIMIT 10 OFFSET?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsName);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, nIndex);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
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
  public LiveData<List<DProduct.oProduct>> GetProductsListFilterPriceRange(final int nIndex,
      final String fnFrom, final String fnToxx) {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx,sImagesxx, nSoldQtyx AS sUntsSold FROM Product_Inventory WHERE nUnitPrce BETWEEN ? AND ? AND strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND nQtyOnHnd > 0 AND cTranStat = '1'ORDER BY nUnitPrce ASC LIMIT 10 OFFSET?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (fnFrom == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fnFrom);
    }
    _argIndex = 2;
    if (fnToxx == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fnToxx);
    }
    _argIndex = 3;
    _statement.bindLong(_argIndex, nIndex);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
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
  public LiveData<List<DProduct.oProduct>> GetProductListSameBrandSuggestions(final String fsArgs,
      final String fsArgs1) {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx,sImagesxx, nSoldQtyx AS sUntsSold FROM Product_Inventory WHERE xBrandNme LIKE '%' || ? || '%' AND sListngID !=? AND strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND nQtyOnHnd > 0 AND cTranStat = '1'LIMIT 10";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsArgs == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsArgs);
    }
    _argIndex = 2;
    if (fsArgs1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsArgs1);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
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
  public LiveData<List<DProduct.oProduct>> SearchProducts(final String fsVal) {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx,sImagesxx, nSoldQtyx AS sUntsSold FROM Product_Inventory WHERE sProdctNm LIKE '%' || ? || '%' AND strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND nQtyOnHnd > 0 AND cTranStat = '1'ORDER BY nUnitPrce ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
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
  public LiveData<List<String>> GetBrandNames() {
    final String _sql = "SELECT xBrandNme FROM Product_Inventory GROUP BY xBrandNme";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
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
  public LiveData<List<String>> GetPriceFilterForBrand(final String fsArgs) {
    final String _sql = "SELECT nUnitPrce FROM Product_Inventory WHERE xBrandNme LIKE '%' || ? || '%' AND strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND nQtyOnHnd > 0 AND cTranStat = '1'GROUP BY nUnitPrce";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsArgs == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsArgs);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<String>>() {
      @Override
      public List<String> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final List<String> _result = new ArrayList<String>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final String _item;
            if (_cursor.isNull(0)) {
              _item = null;
            } else {
              _item = _cursor.getString(0);
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
  public LiveData<List<DProduct.oProduct>> GetProductsOnBrand(final String fsArgs,
      final String fsArgs1) {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx,sImagesxx, nSoldQtyx AS sUntsSold FROM Product_Inventory WHERE sProdctNm LIKE '%' || ? || '%' AND xBrandNme LIKE '%' || ? || '%' AND strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND nQtyOnHnd > 0 AND cTranStat = '1'ORDER BY nUnitPrce ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsArgs == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsArgs);
    }
    _argIndex = 2;
    if (fsArgs1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsArgs1);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
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
  public LiveData<List<DProduct.oProduct>> GetProductsForLoanApplication() {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx, sImagesxx, nSoldQtyx AS sUntsSold, xBrandNme, sModelIDx FROM Product_Inventory WHERE strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND cAllwCrdt = '1' AND nQtyOnHnd > 0 AND cTranStat = '1' ORDER BY dListStrt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final int _cursorIndexOfXBrandNme = 5;
          final int _cursorIndexOfSModelIDx = 6;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
            }
            if (_cursor.isNull(_cursorIndexOfXBrandNme)) {
              _item.xBrandNme = null;
            } else {
              _item.xBrandNme = _cursor.getString(_cursorIndexOfXBrandNme);
            }
            if (_cursor.isNull(_cursorIndexOfSModelIDx)) {
              _item.sModelIDx = null;
            } else {
              _item.sModelIDx = _cursor.getString(_cursorIndexOfSModelIDx);
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
  public LiveData<List<DProduct.oProduct>> SearchLoanProducts(final String fsVal) {
    final String _sql = "SELECT sListngID AS sProdctID, xBrandNme|| ' ' ||xModelNme  AS sProdctNm, nUnitPrce AS sPricexxx, sImagesxx, nSoldQtyx AS sUntsSold, xBrandNme, sModelIDx FROM Product_Inventory WHERE sProdctNm LIKE '%' || ? || '%' AND strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dListStrt AND dListEndx AND cAllwCrdt = '1' AND nQtyOnHnd > 0 AND cTranStat = '1' ORDER BY dListStrt DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Product_Inventory"}, false, new Callable<List<DProduct.oProduct>>() {
      @Override
      public List<DProduct.oProduct> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSProdctID = 0;
          final int _cursorIndexOfSProdctNm = 1;
          final int _cursorIndexOfSPricexxx = 2;
          final int _cursorIndexOfSImagesxx = 3;
          final int _cursorIndexOfSUntsSold = 4;
          final int _cursorIndexOfXBrandNme = 5;
          final int _cursorIndexOfSModelIDx = 6;
          final List<DProduct.oProduct> _result = new ArrayList<DProduct.oProduct>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DProduct.oProduct _item;
            _item = new DProduct.oProduct();
            if (_cursor.isNull(_cursorIndexOfSProdctID)) {
              _item.sProdctID = null;
            } else {
              _item.sProdctID = _cursor.getString(_cursorIndexOfSProdctID);
            }
            if (_cursor.isNull(_cursorIndexOfSProdctNm)) {
              _item.sProdctNm = null;
            } else {
              _item.sProdctNm = _cursor.getString(_cursorIndexOfSProdctNm);
            }
            if (_cursor.isNull(_cursorIndexOfSPricexxx)) {
              _item.sPricexxx = null;
            } else {
              _item.sPricexxx = _cursor.getString(_cursorIndexOfSPricexxx);
            }
            if (_cursor.isNull(_cursorIndexOfSImagesxx)) {
              _item.sImagesxx = null;
            } else {
              _item.sImagesxx = _cursor.getString(_cursorIndexOfSImagesxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUntsSold)) {
              _item.sUntsSold = null;
            } else {
              _item.sUntsSold = _cursor.getString(_cursorIndexOfSUntsSold);
            }
            if (_cursor.isNull(_cursorIndexOfXBrandNme)) {
              _item.xBrandNme = null;
            } else {
              _item.xBrandNme = _cursor.getString(_cursorIndexOfXBrandNme);
            }
            if (_cursor.isNull(_cursorIndexOfSModelIDx)) {
              _item.sModelIDx = null;
            } else {
              _item.sModelIDx = _cursor.getString(_cursorIndexOfSModelIDx);
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
