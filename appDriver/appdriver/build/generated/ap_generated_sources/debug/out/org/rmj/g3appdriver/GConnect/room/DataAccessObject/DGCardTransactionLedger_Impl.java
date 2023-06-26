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
import org.rmj.g3appdriver.GConnect.room.Entities.EGCardLedger;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DGCardTransactionLedger_Impl implements DGCardTransactionLedger {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EGCardLedger> __insertionAdapterOfEGCardLedger;

  private final EntityInsertionAdapter<EGCardLedger> __insertionAdapterOfEGCardLedger_1;

  private final EntityDeletionOrUpdateAdapter<EGCardLedger> __updateAdapterOfEGCardLedger;

  private final SharedSQLiteStatement __preparedStmtOfDeleteGCardTrans;

  public DGCardTransactionLedger_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEGCardLedger = new EntityInsertionAdapter<EGCardLedger>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `G_Card_Transaction_Ledger` (`sReferNox`,`sGCardNox`,`nEntryNox`,`dTransact`,`sSourceDs`,`sTranType`,`sTranDesc`,`sSourceNo`,`nPointsxx`,`cQRCodexx`,`cReceived`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGCardLedger value) {
        if (value.getReferNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getReferNox());
        }
        if (value.getGCardNox() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGCardNox());
        }
        stmt.bindLong(3, value.getEntryNox());
        if (value.getTransact() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTransact());
        }
        if (value.getSourceDs() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSourceDs());
        }
        if (value.getTranType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTranType());
        }
        if (value.getTranDesc() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTranDesc());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSourceNo());
        }
        stmt.bindDouble(9, value.getPointsxx());
        if (value.getQRCodexx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getQRCodexx());
        }
        if (value.getReceived() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReceived());
        }
      }
    };
    this.__insertionAdapterOfEGCardLedger_1 = new EntityInsertionAdapter<EGCardLedger>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `G_Card_Transaction_Ledger` (`sReferNox`,`sGCardNox`,`nEntryNox`,`dTransact`,`sSourceDs`,`sTranType`,`sTranDesc`,`sSourceNo`,`nPointsxx`,`cQRCodexx`,`cReceived`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGCardLedger value) {
        if (value.getReferNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getReferNox());
        }
        if (value.getGCardNox() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGCardNox());
        }
        stmt.bindLong(3, value.getEntryNox());
        if (value.getTransact() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTransact());
        }
        if (value.getSourceDs() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSourceDs());
        }
        if (value.getTranType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTranType());
        }
        if (value.getTranDesc() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTranDesc());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSourceNo());
        }
        stmt.bindDouble(9, value.getPointsxx());
        if (value.getQRCodexx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getQRCodexx());
        }
        if (value.getReceived() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReceived());
        }
      }
    };
    this.__updateAdapterOfEGCardLedger = new EntityDeletionOrUpdateAdapter<EGCardLedger>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `G_Card_Transaction_Ledger` SET `sReferNox` = ?,`sGCardNox` = ?,`nEntryNox` = ?,`dTransact` = ?,`sSourceDs` = ?,`sTranType` = ?,`sTranDesc` = ?,`sSourceNo` = ?,`nPointsxx` = ?,`cQRCodexx` = ?,`cReceived` = ? WHERE `sReferNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGCardLedger value) {
        if (value.getReferNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getReferNox());
        }
        if (value.getGCardNox() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGCardNox());
        }
        stmt.bindLong(3, value.getEntryNox());
        if (value.getTransact() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTransact());
        }
        if (value.getSourceDs() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getSourceDs());
        }
        if (value.getTranType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTranType());
        }
        if (value.getTranDesc() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTranDesc());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSourceNo());
        }
        stmt.bindDouble(9, value.getPointsxx());
        if (value.getQRCodexx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getQRCodexx());
        }
        if (value.getReceived() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getReceived());
        }
        if (value.getReferNox() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getReferNox());
        }
      }
    };
    this.__preparedStmtOfDeleteGCardTrans = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM G_Card_Transaction_Ledger";
        return _query;
      }
    };
  }

  @Override
  public void Save(final EGCardLedger egCardTransactionLedger) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEGCardLedger.insert(egCardTransactionLedger);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EGCardLedger> egCardTransactionLedgerList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEGCardLedger_1.insert(egCardTransactionLedgerList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EGCardLedger egCardTransactionLedger) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEGCardLedger.handle(egCardTransactionLedger);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteGCardTrans() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteGCardTrans.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteGCardTrans.release(_stmt);
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
  public LiveData<List<EGCardLedger>> GetRedemptionTransactionsList() {
    final String _sql = "SELECT * FROM G_Card_Transaction_Ledger WHERE sGCardNox = (SELECT sGCardNox FROM GCard_App_Master WHERE cActvStat = '1') AND sSourceDs = 'REDEMPTION'OR sSourceDs = 'PREORDER'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"G_Card_Transaction_Ledger","GCard_App_Master"}, false, new Callable<List<EGCardLedger>>() {
      @Override
      public List<EGCardLedger> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfGCardNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGCardNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfSourceDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceDs");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "sTranType");
          final int _cursorIndexOfTranDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "sTranDesc");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfPointsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nPointsxx");
          final int _cursorIndexOfQRCodexx = CursorUtil.getColumnIndexOrThrow(_cursor, "cQRCodexx");
          final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "cReceived");
          final List<EGCardLedger> _result = new ArrayList<EGCardLedger>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EGCardLedger _item;
            _item = new EGCardLedger();
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpGCardNox;
            if (_cursor.isNull(_cursorIndexOfGCardNox)) {
              _tmpGCardNox = null;
            } else {
              _tmpGCardNox = _cursor.getString(_cursorIndexOfGCardNox);
            }
            _item.setGCardNox(_tmpGCardNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpSourceDs;
            if (_cursor.isNull(_cursorIndexOfSourceDs)) {
              _tmpSourceDs = null;
            } else {
              _tmpSourceDs = _cursor.getString(_cursorIndexOfSourceDs);
            }
            _item.setSourceDs(_tmpSourceDs);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _item.setTranType(_tmpTranType);
            final String _tmpTranDesc;
            if (_cursor.isNull(_cursorIndexOfTranDesc)) {
              _tmpTranDesc = null;
            } else {
              _tmpTranDesc = _cursor.getString(_cursorIndexOfTranDesc);
            }
            _item.setTranDesc(_tmpTranDesc);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _item.setSourceNo(_tmpSourceNo);
            final double _tmpPointsxx;
            _tmpPointsxx = _cursor.getDouble(_cursorIndexOfPointsxx);
            _item.setPointsxx(_tmpPointsxx);
            final String _tmpQRCodexx;
            if (_cursor.isNull(_cursorIndexOfQRCodexx)) {
              _tmpQRCodexx = null;
            } else {
              _tmpQRCodexx = _cursor.getString(_cursorIndexOfQRCodexx);
            }
            _item.setQRCodexx(_tmpQRCodexx);
            final String _tmpReceived;
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _tmpReceived = null;
            } else {
              _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
            }
            _item.setReceived(_tmpReceived);
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
  public LiveData<List<EGCardLedger>> GetAllTransactionsList() {
    final String _sql = "SELECT * FROM G_Card_Transaction_Ledger WHERE sGCardNox = (SELECT sGCardNox FROM GCard_App_Master WHERE cActvStat = '1') ORDER BY dTransact DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"G_Card_Transaction_Ledger","GCard_App_Master"}, false, new Callable<List<EGCardLedger>>() {
      @Override
      public List<EGCardLedger> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfGCardNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGCardNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfSourceDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceDs");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "sTranType");
          final int _cursorIndexOfTranDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "sTranDesc");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfPointsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nPointsxx");
          final int _cursorIndexOfQRCodexx = CursorUtil.getColumnIndexOrThrow(_cursor, "cQRCodexx");
          final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "cReceived");
          final List<EGCardLedger> _result = new ArrayList<EGCardLedger>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EGCardLedger _item;
            _item = new EGCardLedger();
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpGCardNox;
            if (_cursor.isNull(_cursorIndexOfGCardNox)) {
              _tmpGCardNox = null;
            } else {
              _tmpGCardNox = _cursor.getString(_cursorIndexOfGCardNox);
            }
            _item.setGCardNox(_tmpGCardNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpSourceDs;
            if (_cursor.isNull(_cursorIndexOfSourceDs)) {
              _tmpSourceDs = null;
            } else {
              _tmpSourceDs = _cursor.getString(_cursorIndexOfSourceDs);
            }
            _item.setSourceDs(_tmpSourceDs);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _item.setTranType(_tmpTranType);
            final String _tmpTranDesc;
            if (_cursor.isNull(_cursorIndexOfTranDesc)) {
              _tmpTranDesc = null;
            } else {
              _tmpTranDesc = _cursor.getString(_cursorIndexOfTranDesc);
            }
            _item.setTranDesc(_tmpTranDesc);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _item.setSourceNo(_tmpSourceNo);
            final double _tmpPointsxx;
            _tmpPointsxx = _cursor.getDouble(_cursorIndexOfPointsxx);
            _item.setPointsxx(_tmpPointsxx);
            final String _tmpQRCodexx;
            if (_cursor.isNull(_cursorIndexOfQRCodexx)) {
              _tmpQRCodexx = null;
            } else {
              _tmpQRCodexx = _cursor.getString(_cursorIndexOfQRCodexx);
            }
            _item.setQRCodexx(_tmpQRCodexx);
            final String _tmpReceived;
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _tmpReceived = null;
            } else {
              _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
            }
            _item.setReceived(_tmpReceived);
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
  public LiveData<List<EGCardLedger>> GetPointsEntryTransactionsList() {
    final String _sql = "SELECT * FROM G_Card_Transaction_Ledger WHERE sGCardNox = (SELECT sGCardNox FROM GCard_App_Master WHERE cActvStat = '1') AND sSourceDs = 'ONLINE' OR sSourceDs = 'OFFLINE'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"G_Card_Transaction_Ledger","GCard_App_Master"}, false, new Callable<List<EGCardLedger>>() {
      @Override
      public List<EGCardLedger> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfGCardNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGCardNox");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfSourceDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceDs");
          final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "sTranType");
          final int _cursorIndexOfTranDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "sTranDesc");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfPointsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nPointsxx");
          final int _cursorIndexOfQRCodexx = CursorUtil.getColumnIndexOrThrow(_cursor, "cQRCodexx");
          final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "cReceived");
          final List<EGCardLedger> _result = new ArrayList<EGCardLedger>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EGCardLedger _item;
            _item = new EGCardLedger();
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpGCardNox;
            if (_cursor.isNull(_cursorIndexOfGCardNox)) {
              _tmpGCardNox = null;
            } else {
              _tmpGCardNox = _cursor.getString(_cursorIndexOfGCardNox);
            }
            _item.setGCardNox(_tmpGCardNox);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpSourceDs;
            if (_cursor.isNull(_cursorIndexOfSourceDs)) {
              _tmpSourceDs = null;
            } else {
              _tmpSourceDs = _cursor.getString(_cursorIndexOfSourceDs);
            }
            _item.setSourceDs(_tmpSourceDs);
            final String _tmpTranType;
            if (_cursor.isNull(_cursorIndexOfTranType)) {
              _tmpTranType = null;
            } else {
              _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
            }
            _item.setTranType(_tmpTranType);
            final String _tmpTranDesc;
            if (_cursor.isNull(_cursorIndexOfTranDesc)) {
              _tmpTranDesc = null;
            } else {
              _tmpTranDesc = _cursor.getString(_cursorIndexOfTranDesc);
            }
            _item.setTranDesc(_tmpTranDesc);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _item.setSourceNo(_tmpSourceNo);
            final double _tmpPointsxx;
            _tmpPointsxx = _cursor.getDouble(_cursorIndexOfPointsxx);
            _item.setPointsxx(_tmpPointsxx);
            final String _tmpQRCodexx;
            if (_cursor.isNull(_cursorIndexOfQRCodexx)) {
              _tmpQRCodexx = null;
            } else {
              _tmpQRCodexx = _cursor.getString(_cursorIndexOfQRCodexx);
            }
            _item.setQRCodexx(_tmpQRCodexx);
            final String _tmpReceived;
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _tmpReceived = null;
            } else {
              _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
            }
            _item.setReceived(_tmpReceived);
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
  public EGCardLedger isTransactionValid(final String gcardNo, final String srcedsc,
      final String referno, final String trandsc, final String srcenox, final String pointsx) {
    final String _sql = "SELECT * FROM G_Card_Transaction_Ledger WHERE sGCardNox =? AND sSourceDs =? AND sReferNox =? AND sTranDesc =? AND sSourceNo =? AND nPointsxx =? ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 6);
    int _argIndex = 1;
    if (gcardNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, gcardNo);
    }
    _argIndex = 2;
    if (srcedsc == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, srcedsc);
    }
    _argIndex = 3;
    if (referno == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, referno);
    }
    _argIndex = 4;
    if (trandsc == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, trandsc);
    }
    _argIndex = 5;
    if (srcenox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, srcenox);
    }
    _argIndex = 6;
    if (pointsx == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, pointsx);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfGCardNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGCardNox");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfSourceDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceDs");
      final int _cursorIndexOfTranType = CursorUtil.getColumnIndexOrThrow(_cursor, "sTranType");
      final int _cursorIndexOfTranDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "sTranDesc");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfPointsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "nPointsxx");
      final int _cursorIndexOfQRCodexx = CursorUtil.getColumnIndexOrThrow(_cursor, "cQRCodexx");
      final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "cReceived");
      final EGCardLedger _result;
      if(_cursor.moveToFirst()) {
        _result = new EGCardLedger();
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpGCardNox;
        if (_cursor.isNull(_cursorIndexOfGCardNox)) {
          _tmpGCardNox = null;
        } else {
          _tmpGCardNox = _cursor.getString(_cursorIndexOfGCardNox);
        }
        _result.setGCardNox(_tmpGCardNox);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpSourceDs;
        if (_cursor.isNull(_cursorIndexOfSourceDs)) {
          _tmpSourceDs = null;
        } else {
          _tmpSourceDs = _cursor.getString(_cursorIndexOfSourceDs);
        }
        _result.setSourceDs(_tmpSourceDs);
        final String _tmpTranType;
        if (_cursor.isNull(_cursorIndexOfTranType)) {
          _tmpTranType = null;
        } else {
          _tmpTranType = _cursor.getString(_cursorIndexOfTranType);
        }
        _result.setTranType(_tmpTranType);
        final String _tmpTranDesc;
        if (_cursor.isNull(_cursorIndexOfTranDesc)) {
          _tmpTranDesc = null;
        } else {
          _tmpTranDesc = _cursor.getString(_cursorIndexOfTranDesc);
        }
        _result.setTranDesc(_tmpTranDesc);
        final String _tmpSourceNo;
        if (_cursor.isNull(_cursorIndexOfSourceNo)) {
          _tmpSourceNo = null;
        } else {
          _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
        }
        _result.setSourceNo(_tmpSourceNo);
        final double _tmpPointsxx;
        _tmpPointsxx = _cursor.getDouble(_cursorIndexOfPointsxx);
        _result.setPointsxx(_tmpPointsxx);
        final String _tmpQRCodexx;
        if (_cursor.isNull(_cursorIndexOfQRCodexx)) {
          _tmpQRCodexx = null;
        } else {
          _tmpQRCodexx = _cursor.getString(_cursorIndexOfQRCodexx);
        }
        _result.setQRCodexx(_tmpQRCodexx);
        final String _tmpReceived;
        if (_cursor.isNull(_cursorIndexOfReceived)) {
          _tmpReceived = null;
        } else {
          _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
        }
        _result.setReceived(_tmpReceived);
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
