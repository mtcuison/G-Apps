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
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EInventoryDetail;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DInventoryDetail_Impl implements DInventoryDetail {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EInventoryDetail> __insertionAdapterOfEInventoryDetail;

  private final SharedSQLiteStatement __preparedStmtOfUpdateInventoryItem;

  private final SharedSQLiteStatement __preparedStmtOfUpdateInventoryItemPostedStatus;

  public DInventoryDetail_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEInventoryDetail = new EntityInsertionAdapter<EInventoryDetail>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Inventory_Count_Detail` (`sTransNox`,`nEntryNox`,`sBarrCode`,`sPartsIDx`,`sDescript`,`sWHouseID`,`sWHouseNm`,`sSectnIDx`,`sSectnNme`,`sBinIDxxx`,`sBinNamex`,`nQtyOnHnd`,`nActCtr01`,`nActCtr02`,`nActCtr03`,`nLedgerNo`,`nBegQtyxx`,`cTranStat`,`sRemarksx`,`dModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EInventoryDetail value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        stmt.bindLong(2, value.getEntryNox());
        if (value.getBarrCode() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBarrCode());
        }
        if (value.getPartsIDx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPartsIDx());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDescript());
        }
        if (value.getWHouseID() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getWHouseID());
        }
        if (value.getWHouseNm() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getWHouseNm());
        }
        if (value.getSectnIDx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSectnIDx());
        }
        if (value.getSectnNme() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSectnNme());
        }
        if (value.getBinIDxxx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBinIDxxx());
        }
        if (value.getBinNamex() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getBinNamex());
        }
        stmt.bindLong(12, value.getQtyOnHnd());
        stmt.bindLong(13, value.getActCtr01());
        stmt.bindLong(14, value.getActCtr02());
        stmt.bindLong(15, value.getActCtr03());
        if (value.getLedgerNo() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getLedgerNo());
        }
        if (value.getBegQtyxx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getBegQtyxx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTranStat());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getRemarksx());
        }
        if (value.getModified() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getModified());
        }
      }
    };
    this.__preparedStmtOfUpdateInventoryItem = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Inventory_Count_Detail SET nActCtr01 =?, sRemarksx=?, cTranStat = '1'WHERE sTransNox=? AND sBarrCode=? AND sPartsIDx=?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateInventoryItemPostedStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Inventory_Count_Detail SET cTranStat = '2' WHERE sTransNox=? AND sPartsIDx=?";
        return _query;
      }
    };
  }

  @Override
  public void insertInventoryDetail(final List<EInventoryDetail> foDetail) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEInventoryDetail.insert(foDetail);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateInventoryItem(final String TransNox, final String BarCode, final String PartID,
      final String ActualQty, final String Remarks) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateInventoryItem.acquire();
    int _argIndex = 1;
    if (ActualQty == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ActualQty);
    }
    _argIndex = 2;
    if (Remarks == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Remarks);
    }
    _argIndex = 3;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 4;
    if (BarCode == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, BarCode);
    }
    _argIndex = 5;
    if (PartID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, PartID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateInventoryItem.release(_stmt);
    }
  }

  @Override
  public void UpdateInventoryItemPostedStatus(final String TransNox, final String PartID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateInventoryItemPostedStatus.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (PartID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, PartID);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateInventoryItemPostedStatus.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EInventoryDetail>> getInventoryDetailForBranch(final String TransNox) {
    final String _sql = "SELECT * FROM Inventory_Count_Detail WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Inventory_Count_Detail"}, false, new Callable<List<EInventoryDetail>>() {
      @Override
      public List<EInventoryDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfBarrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarrCode");
          final int _cursorIndexOfPartsIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPartsIDx");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfWHouseID = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseID");
          final int _cursorIndexOfWHouseNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseNm");
          final int _cursorIndexOfSectnIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnIDx");
          final int _cursorIndexOfSectnNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnNme");
          final int _cursorIndexOfBinIDxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinIDxxx");
          final int _cursorIndexOfBinNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinNamex");
          final int _cursorIndexOfQtyOnHnd = CursorUtil.getColumnIndexOrThrow(_cursor, "nQtyOnHnd");
          final int _cursorIndexOfActCtr01 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr01");
          final int _cursorIndexOfActCtr02 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr02");
          final int _cursorIndexOfActCtr03 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr03");
          final int _cursorIndexOfLedgerNo = CursorUtil.getColumnIndexOrThrow(_cursor, "nLedgerNo");
          final int _cursorIndexOfBegQtyxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nBegQtyxx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final List<EInventoryDetail> _result = new ArrayList<EInventoryDetail>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EInventoryDetail _item;
            _item = new EInventoryDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpBarrCode;
            if (_cursor.isNull(_cursorIndexOfBarrCode)) {
              _tmpBarrCode = null;
            } else {
              _tmpBarrCode = _cursor.getString(_cursorIndexOfBarrCode);
            }
            _item.setBarrCode(_tmpBarrCode);
            final String _tmpPartsIDx;
            if (_cursor.isNull(_cursorIndexOfPartsIDx)) {
              _tmpPartsIDx = null;
            } else {
              _tmpPartsIDx = _cursor.getString(_cursorIndexOfPartsIDx);
            }
            _item.setPartsIDx(_tmpPartsIDx);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpWHouseID;
            if (_cursor.isNull(_cursorIndexOfWHouseID)) {
              _tmpWHouseID = null;
            } else {
              _tmpWHouseID = _cursor.getString(_cursorIndexOfWHouseID);
            }
            _item.setWHouseID(_tmpWHouseID);
            final String _tmpWHouseNm;
            if (_cursor.isNull(_cursorIndexOfWHouseNm)) {
              _tmpWHouseNm = null;
            } else {
              _tmpWHouseNm = _cursor.getString(_cursorIndexOfWHouseNm);
            }
            _item.setWHouseNm(_tmpWHouseNm);
            final String _tmpSectnIDx;
            if (_cursor.isNull(_cursorIndexOfSectnIDx)) {
              _tmpSectnIDx = null;
            } else {
              _tmpSectnIDx = _cursor.getString(_cursorIndexOfSectnIDx);
            }
            _item.setSectnIDx(_tmpSectnIDx);
            final String _tmpSectnNme;
            if (_cursor.isNull(_cursorIndexOfSectnNme)) {
              _tmpSectnNme = null;
            } else {
              _tmpSectnNme = _cursor.getString(_cursorIndexOfSectnNme);
            }
            _item.setSectnNme(_tmpSectnNme);
            final String _tmpBinIDxxx;
            if (_cursor.isNull(_cursorIndexOfBinIDxxx)) {
              _tmpBinIDxxx = null;
            } else {
              _tmpBinIDxxx = _cursor.getString(_cursorIndexOfBinIDxxx);
            }
            _item.setBinIDxxx(_tmpBinIDxxx);
            final String _tmpBinNamex;
            if (_cursor.isNull(_cursorIndexOfBinNamex)) {
              _tmpBinNamex = null;
            } else {
              _tmpBinNamex = _cursor.getString(_cursorIndexOfBinNamex);
            }
            _item.setBinNamex(_tmpBinNamex);
            final int _tmpQtyOnHnd;
            _tmpQtyOnHnd = _cursor.getInt(_cursorIndexOfQtyOnHnd);
            _item.setQtyOnHnd(_tmpQtyOnHnd);
            final int _tmpActCtr01;
            _tmpActCtr01 = _cursor.getInt(_cursorIndexOfActCtr01);
            _item.setActCtr01(_tmpActCtr01);
            final int _tmpActCtr02;
            _tmpActCtr02 = _cursor.getInt(_cursorIndexOfActCtr02);
            _item.setActCtr02(_tmpActCtr02);
            final int _tmpActCtr03;
            _tmpActCtr03 = _cursor.getInt(_cursorIndexOfActCtr03);
            _item.setActCtr03(_tmpActCtr03);
            final String _tmpLedgerNo;
            if (_cursor.isNull(_cursorIndexOfLedgerNo)) {
              _tmpLedgerNo = null;
            } else {
              _tmpLedgerNo = _cursor.getString(_cursorIndexOfLedgerNo);
            }
            _item.setLedgerNo(_tmpLedgerNo);
            final String _tmpBegQtyxx;
            if (_cursor.isNull(_cursorIndexOfBegQtyxx)) {
              _tmpBegQtyxx = null;
            } else {
              _tmpBegQtyxx = _cursor.getString(_cursorIndexOfBegQtyxx);
            }
            _item.setBegQtyxx(_tmpBegQtyxx);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
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
  public LiveData<EInventoryDetail> getInventoryItemDetail(final String TransNox,
      final String PartID, final String BarCode) {
    final String _sql = "SELECT * FROM Inventory_Count_Detail WHERE sTransNox=? AND sPartsIDx=? AND sBarrCode=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (PartID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, PartID);
    }
    _argIndex = 3;
    if (BarCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BarCode);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Inventory_Count_Detail"}, false, new Callable<EInventoryDetail>() {
      @Override
      public EInventoryDetail call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfBarrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarrCode");
          final int _cursorIndexOfPartsIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPartsIDx");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfWHouseID = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseID");
          final int _cursorIndexOfWHouseNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseNm");
          final int _cursorIndexOfSectnIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnIDx");
          final int _cursorIndexOfSectnNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnNme");
          final int _cursorIndexOfBinIDxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinIDxxx");
          final int _cursorIndexOfBinNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinNamex");
          final int _cursorIndexOfQtyOnHnd = CursorUtil.getColumnIndexOrThrow(_cursor, "nQtyOnHnd");
          final int _cursorIndexOfActCtr01 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr01");
          final int _cursorIndexOfActCtr02 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr02");
          final int _cursorIndexOfActCtr03 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr03");
          final int _cursorIndexOfLedgerNo = CursorUtil.getColumnIndexOrThrow(_cursor, "nLedgerNo");
          final int _cursorIndexOfBegQtyxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nBegQtyxx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EInventoryDetail _result;
          if(_cursor.moveToFirst()) {
            _result = new EInventoryDetail();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _result.setEntryNox(_tmpEntryNox);
            final String _tmpBarrCode;
            if (_cursor.isNull(_cursorIndexOfBarrCode)) {
              _tmpBarrCode = null;
            } else {
              _tmpBarrCode = _cursor.getString(_cursorIndexOfBarrCode);
            }
            _result.setBarrCode(_tmpBarrCode);
            final String _tmpPartsIDx;
            if (_cursor.isNull(_cursorIndexOfPartsIDx)) {
              _tmpPartsIDx = null;
            } else {
              _tmpPartsIDx = _cursor.getString(_cursorIndexOfPartsIDx);
            }
            _result.setPartsIDx(_tmpPartsIDx);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _result.setDescript(_tmpDescript);
            final String _tmpWHouseID;
            if (_cursor.isNull(_cursorIndexOfWHouseID)) {
              _tmpWHouseID = null;
            } else {
              _tmpWHouseID = _cursor.getString(_cursorIndexOfWHouseID);
            }
            _result.setWHouseID(_tmpWHouseID);
            final String _tmpWHouseNm;
            if (_cursor.isNull(_cursorIndexOfWHouseNm)) {
              _tmpWHouseNm = null;
            } else {
              _tmpWHouseNm = _cursor.getString(_cursorIndexOfWHouseNm);
            }
            _result.setWHouseNm(_tmpWHouseNm);
            final String _tmpSectnIDx;
            if (_cursor.isNull(_cursorIndexOfSectnIDx)) {
              _tmpSectnIDx = null;
            } else {
              _tmpSectnIDx = _cursor.getString(_cursorIndexOfSectnIDx);
            }
            _result.setSectnIDx(_tmpSectnIDx);
            final String _tmpSectnNme;
            if (_cursor.isNull(_cursorIndexOfSectnNme)) {
              _tmpSectnNme = null;
            } else {
              _tmpSectnNme = _cursor.getString(_cursorIndexOfSectnNme);
            }
            _result.setSectnNme(_tmpSectnNme);
            final String _tmpBinIDxxx;
            if (_cursor.isNull(_cursorIndexOfBinIDxxx)) {
              _tmpBinIDxxx = null;
            } else {
              _tmpBinIDxxx = _cursor.getString(_cursorIndexOfBinIDxxx);
            }
            _result.setBinIDxxx(_tmpBinIDxxx);
            final String _tmpBinNamex;
            if (_cursor.isNull(_cursorIndexOfBinNamex)) {
              _tmpBinNamex = null;
            } else {
              _tmpBinNamex = _cursor.getString(_cursorIndexOfBinNamex);
            }
            _result.setBinNamex(_tmpBinNamex);
            final int _tmpQtyOnHnd;
            _tmpQtyOnHnd = _cursor.getInt(_cursorIndexOfQtyOnHnd);
            _result.setQtyOnHnd(_tmpQtyOnHnd);
            final int _tmpActCtr01;
            _tmpActCtr01 = _cursor.getInt(_cursorIndexOfActCtr01);
            _result.setActCtr01(_tmpActCtr01);
            final int _tmpActCtr02;
            _tmpActCtr02 = _cursor.getInt(_cursorIndexOfActCtr02);
            _result.setActCtr02(_tmpActCtr02);
            final int _tmpActCtr03;
            _tmpActCtr03 = _cursor.getInt(_cursorIndexOfActCtr03);
            _result.setActCtr03(_tmpActCtr03);
            final String _tmpLedgerNo;
            if (_cursor.isNull(_cursorIndexOfLedgerNo)) {
              _tmpLedgerNo = null;
            } else {
              _tmpLedgerNo = _cursor.getString(_cursorIndexOfLedgerNo);
            }
            _result.setLedgerNo(_tmpLedgerNo);
            final String _tmpBegQtyxx;
            if (_cursor.isNull(_cursorIndexOfBegQtyxx)) {
              _tmpBegQtyxx = null;
            } else {
              _tmpBegQtyxx = _cursor.getString(_cursorIndexOfBegQtyxx);
            }
            _result.setBegQtyxx(_tmpBegQtyxx);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
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
  public LiveData<String> getInventoryCountForBranch(final String TransNox) {
    final String _sql = "SELECT (SELECT COUNT(*) FROM Inventory_Count_Detail WHERE sTransNox =? AND cTranStat == '1') || '/' || (SELECT COUNT(*) FROM Inventory_Count_Detail WHERE sTransNox =?) AS Current_Inventory";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Inventory_Count_Detail"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Integer getUncountedInventoryItems(final String TransNox) {
    final String _sql = "SELECT COUNT(*) FROM Inventory_Count_Detail WHERE sTransNox=? AND cTranStat = '0'";
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
      _statement.release();
    }
  }

  @Override
  public List<EInventoryDetail> getInventoryDetailForPosting(final String TransNox) {
    final String _sql = "SELECT * FROM Inventory_Count_Detail WHERE sTransNox=?";
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
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfBarrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarrCode");
      final int _cursorIndexOfPartsIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPartsIDx");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfWHouseID = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseID");
      final int _cursorIndexOfWHouseNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseNm");
      final int _cursorIndexOfSectnIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnIDx");
      final int _cursorIndexOfSectnNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sSectnNme");
      final int _cursorIndexOfBinIDxxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinIDxxx");
      final int _cursorIndexOfBinNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sBinNamex");
      final int _cursorIndexOfQtyOnHnd = CursorUtil.getColumnIndexOrThrow(_cursor, "nQtyOnHnd");
      final int _cursorIndexOfActCtr01 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr01");
      final int _cursorIndexOfActCtr02 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr02");
      final int _cursorIndexOfActCtr03 = CursorUtil.getColumnIndexOrThrow(_cursor, "nActCtr03");
      final int _cursorIndexOfLedgerNo = CursorUtil.getColumnIndexOrThrow(_cursor, "nLedgerNo");
      final int _cursorIndexOfBegQtyxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nBegQtyxx");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EInventoryDetail> _result = new ArrayList<EInventoryDetail>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EInventoryDetail _item;
        _item = new EInventoryDetail();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpBarrCode;
        if (_cursor.isNull(_cursorIndexOfBarrCode)) {
          _tmpBarrCode = null;
        } else {
          _tmpBarrCode = _cursor.getString(_cursorIndexOfBarrCode);
        }
        _item.setBarrCode(_tmpBarrCode);
        final String _tmpPartsIDx;
        if (_cursor.isNull(_cursorIndexOfPartsIDx)) {
          _tmpPartsIDx = null;
        } else {
          _tmpPartsIDx = _cursor.getString(_cursorIndexOfPartsIDx);
        }
        _item.setPartsIDx(_tmpPartsIDx);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _item.setDescript(_tmpDescript);
        final String _tmpWHouseID;
        if (_cursor.isNull(_cursorIndexOfWHouseID)) {
          _tmpWHouseID = null;
        } else {
          _tmpWHouseID = _cursor.getString(_cursorIndexOfWHouseID);
        }
        _item.setWHouseID(_tmpWHouseID);
        final String _tmpWHouseNm;
        if (_cursor.isNull(_cursorIndexOfWHouseNm)) {
          _tmpWHouseNm = null;
        } else {
          _tmpWHouseNm = _cursor.getString(_cursorIndexOfWHouseNm);
        }
        _item.setWHouseNm(_tmpWHouseNm);
        final String _tmpSectnIDx;
        if (_cursor.isNull(_cursorIndexOfSectnIDx)) {
          _tmpSectnIDx = null;
        } else {
          _tmpSectnIDx = _cursor.getString(_cursorIndexOfSectnIDx);
        }
        _item.setSectnIDx(_tmpSectnIDx);
        final String _tmpSectnNme;
        if (_cursor.isNull(_cursorIndexOfSectnNme)) {
          _tmpSectnNme = null;
        } else {
          _tmpSectnNme = _cursor.getString(_cursorIndexOfSectnNme);
        }
        _item.setSectnNme(_tmpSectnNme);
        final String _tmpBinIDxxx;
        if (_cursor.isNull(_cursorIndexOfBinIDxxx)) {
          _tmpBinIDxxx = null;
        } else {
          _tmpBinIDxxx = _cursor.getString(_cursorIndexOfBinIDxxx);
        }
        _item.setBinIDxxx(_tmpBinIDxxx);
        final String _tmpBinNamex;
        if (_cursor.isNull(_cursorIndexOfBinNamex)) {
          _tmpBinNamex = null;
        } else {
          _tmpBinNamex = _cursor.getString(_cursorIndexOfBinNamex);
        }
        _item.setBinNamex(_tmpBinNamex);
        final int _tmpQtyOnHnd;
        _tmpQtyOnHnd = _cursor.getInt(_cursorIndexOfQtyOnHnd);
        _item.setQtyOnHnd(_tmpQtyOnHnd);
        final int _tmpActCtr01;
        _tmpActCtr01 = _cursor.getInt(_cursorIndexOfActCtr01);
        _item.setActCtr01(_tmpActCtr01);
        final int _tmpActCtr02;
        _tmpActCtr02 = _cursor.getInt(_cursorIndexOfActCtr02);
        _item.setActCtr02(_tmpActCtr02);
        final int _tmpActCtr03;
        _tmpActCtr03 = _cursor.getInt(_cursorIndexOfActCtr03);
        _item.setActCtr03(_tmpActCtr03);
        final String _tmpLedgerNo;
        if (_cursor.isNull(_cursorIndexOfLedgerNo)) {
          _tmpLedgerNo = null;
        } else {
          _tmpLedgerNo = _cursor.getString(_cursorIndexOfLedgerNo);
        }
        _item.setLedgerNo(_tmpLedgerNo);
        final String _tmpBegQtyxx;
        if (_cursor.isNull(_cursorIndexOfBegQtyxx)) {
          _tmpBegQtyxx = null;
        } else {
          _tmpBegQtyxx = _cursor.getString(_cursorIndexOfBegQtyxx);
        }
        _item.setBegQtyxx(_tmpBegQtyxx);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
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
      _statement.release();
    }
  }

  @Override
  public Integer checkForUnpostedInventoryDetail(final String TransNox) {
    final String _sql = "SELECT COUNT(*) FROM Inventory_Count_Detail WHERE sTransNox=? AND cTranStat = '1'";
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
      _statement.release();
    }
  }

  @Override
  public String GetLatestBranchCode() {
    final String _sql = "SELECT sBranchCD FROM Employee_Log_Selfie ORDER BY dLogTimex DESC LIMIT 1";
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
