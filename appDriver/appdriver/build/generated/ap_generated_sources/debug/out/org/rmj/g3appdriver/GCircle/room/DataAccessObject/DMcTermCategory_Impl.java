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
import org.rmj.g3appdriver.GCircle.room.Entities.EMcTermCategory;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DMcTermCategory_Impl implements DMcTermCategory {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EMcTermCategory> __insertionAdapterOfEMcTermCategory;

  private final EntityInsertionAdapter<EMcTermCategory> __insertionAdapterOfEMcTermCategory_1;

  private final EntityDeletionOrUpdateAdapter<EMcTermCategory> __updateAdapterOfEMcTermCategory;

  public DMcTermCategory_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEMcTermCategory = new EntityInsertionAdapter<EMcTermCategory>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MC_Term_Category` (`sMCCatIDx`,`nAcctTerm`,`nAcctThru`,`nFactorRt`,`dPricexxx`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcTermCategory value) {
        if (value.getMCCatIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMCCatIDx());
        }
        if (value.getAcctTerm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAcctTerm());
        }
        if (value.getAcctThru() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAcctThru());
        }
        if (value.getFactorRt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFactorRt());
        }
        if (value.getPricexxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPricexxx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfEMcTermCategory_1 = new EntityInsertionAdapter<EMcTermCategory>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MC_Term_Category` (`sMCCatIDx`,`nAcctTerm`,`nAcctThru`,`nFactorRt`,`dPricexxx`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcTermCategory value) {
        if (value.getMCCatIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMCCatIDx());
        }
        if (value.getAcctTerm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAcctTerm());
        }
        if (value.getAcctThru() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAcctThru());
        }
        if (value.getFactorRt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFactorRt());
        }
        if (value.getPricexxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPricexxx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEMcTermCategory = new EntityDeletionOrUpdateAdapter<EMcTermCategory>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MC_Term_Category` SET `sMCCatIDx` = ?,`nAcctTerm` = ?,`nAcctThru` = ?,`nFactorRt` = ?,`dPricexxx` = ?,`cRecdStat` = ?,`dTimeStmp` = ? WHERE `sMCCatIDx` = ? AND `nAcctTerm` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcTermCategory value) {
        if (value.getMCCatIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMCCatIDx());
        }
        if (value.getAcctTerm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getAcctTerm());
        }
        if (value.getAcctThru() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAcctThru());
        }
        if (value.getFactorRt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getFactorRt());
        }
        if (value.getPricexxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPricexxx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStmp());
        }
        if (value.getMCCatIDx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMCCatIDx());
        }
        if (value.getAcctTerm() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getAcctTerm());
        }
      }
    };
  }

  @Override
  public void insert(final EMcTermCategory mcTermCategory) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMcTermCategory.insert(mcTermCategory);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EMcTermCategory> categories) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMcTermCategory_1.insert(categories);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EMcTermCategory mcTermCategory) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEMcTermCategory.handle(mcTermCategory);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public EMcTermCategory GetMcTermCategory(final String fsVal, final String fsVal1) {
    final String _sql = "SELECT * FROM MC_Term_Category WHERE sMCCatIDx =? AND nAcctTerm =?";
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
      final int _cursorIndexOfMCCatIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMCCatIDx");
      final int _cursorIndexOfAcctTerm = CursorUtil.getColumnIndexOrThrow(_cursor, "nAcctTerm");
      final int _cursorIndexOfAcctThru = CursorUtil.getColumnIndexOrThrow(_cursor, "nAcctThru");
      final int _cursorIndexOfFactorRt = CursorUtil.getColumnIndexOrThrow(_cursor, "nFactorRt");
      final int _cursorIndexOfPricexxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dPricexxx");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EMcTermCategory _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcTermCategory();
        final String _tmpMCCatIDx;
        if (_cursor.isNull(_cursorIndexOfMCCatIDx)) {
          _tmpMCCatIDx = null;
        } else {
          _tmpMCCatIDx = _cursor.getString(_cursorIndexOfMCCatIDx);
        }
        _result.setMCCatIDx(_tmpMCCatIDx);
        final String _tmpAcctTerm;
        if (_cursor.isNull(_cursorIndexOfAcctTerm)) {
          _tmpAcctTerm = null;
        } else {
          _tmpAcctTerm = _cursor.getString(_cursorIndexOfAcctTerm);
        }
        _result.setAcctTerm(_tmpAcctTerm);
        final String _tmpAcctThru;
        if (_cursor.isNull(_cursorIndexOfAcctThru)) {
          _tmpAcctThru = null;
        } else {
          _tmpAcctThru = _cursor.getString(_cursorIndexOfAcctThru);
        }
        _result.setAcctThru(_tmpAcctThru);
        final String _tmpFactorRt;
        if (_cursor.isNull(_cursorIndexOfFactorRt)) {
          _tmpFactorRt = null;
        } else {
          _tmpFactorRt = _cursor.getString(_cursorIndexOfFactorRt);
        }
        _result.setFactorRt(_tmpFactorRt);
        final String _tmpPricexxx;
        if (_cursor.isNull(_cursorIndexOfPricexxx)) {
          _tmpPricexxx = null;
        } else {
          _tmpPricexxx = _cursor.getString(_cursorIndexOfPricexxx);
        }
        _result.setPricexxx(_tmpPricexxx);
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
  public EMcTermCategory GetLatestMcTermCategory() {
    final String _sql = "SELECT * FROM MC_Term_Category ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMCCatIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMCCatIDx");
      final int _cursorIndexOfAcctTerm = CursorUtil.getColumnIndexOrThrow(_cursor, "nAcctTerm");
      final int _cursorIndexOfAcctThru = CursorUtil.getColumnIndexOrThrow(_cursor, "nAcctThru");
      final int _cursorIndexOfFactorRt = CursorUtil.getColumnIndexOrThrow(_cursor, "nFactorRt");
      final int _cursorIndexOfPricexxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dPricexxx");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EMcTermCategory _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcTermCategory();
        final String _tmpMCCatIDx;
        if (_cursor.isNull(_cursorIndexOfMCCatIDx)) {
          _tmpMCCatIDx = null;
        } else {
          _tmpMCCatIDx = _cursor.getString(_cursorIndexOfMCCatIDx);
        }
        _result.setMCCatIDx(_tmpMCCatIDx);
        final String _tmpAcctTerm;
        if (_cursor.isNull(_cursorIndexOfAcctTerm)) {
          _tmpAcctTerm = null;
        } else {
          _tmpAcctTerm = _cursor.getString(_cursorIndexOfAcctTerm);
        }
        _result.setAcctTerm(_tmpAcctTerm);
        final String _tmpAcctThru;
        if (_cursor.isNull(_cursorIndexOfAcctThru)) {
          _tmpAcctThru = null;
        } else {
          _tmpAcctThru = _cursor.getString(_cursorIndexOfAcctThru);
        }
        _result.setAcctThru(_tmpAcctThru);
        final String _tmpFactorRt;
        if (_cursor.isNull(_cursorIndexOfFactorRt)) {
          _tmpFactorRt = null;
        } else {
          _tmpFactorRt = _cursor.getString(_cursorIndexOfFactorRt);
        }
        _result.setFactorRt(_tmpFactorRt);
        final String _tmpPricexxx;
        if (_cursor.isNull(_cursorIndexOfPricexxx)) {
          _tmpPricexxx = null;
        } else {
          _tmpPricexxx = _cursor.getString(_cursorIndexOfPricexxx);
        }
        _result.setPricexxx(_tmpPricexxx);
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
  public LiveData<List<EMcTermCategory>> getAllMcTermCategory() {
    final String _sql = "SELECT * FROM MC_Term_Category";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Term_Category"}, false, new Callable<List<EMcTermCategory>>() {
      @Override
      public List<EMcTermCategory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMCCatIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMCCatIDx");
          final int _cursorIndexOfAcctTerm = CursorUtil.getColumnIndexOrThrow(_cursor, "nAcctTerm");
          final int _cursorIndexOfAcctThru = CursorUtil.getColumnIndexOrThrow(_cursor, "nAcctThru");
          final int _cursorIndexOfFactorRt = CursorUtil.getColumnIndexOrThrow(_cursor, "nFactorRt");
          final int _cursorIndexOfPricexxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dPricexxx");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EMcTermCategory> _result = new ArrayList<EMcTermCategory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMcTermCategory _item;
            _item = new EMcTermCategory();
            final String _tmpMCCatIDx;
            if (_cursor.isNull(_cursorIndexOfMCCatIDx)) {
              _tmpMCCatIDx = null;
            } else {
              _tmpMCCatIDx = _cursor.getString(_cursorIndexOfMCCatIDx);
            }
            _item.setMCCatIDx(_tmpMCCatIDx);
            final String _tmpAcctTerm;
            if (_cursor.isNull(_cursorIndexOfAcctTerm)) {
              _tmpAcctTerm = null;
            } else {
              _tmpAcctTerm = _cursor.getString(_cursorIndexOfAcctTerm);
            }
            _item.setAcctTerm(_tmpAcctTerm);
            final String _tmpAcctThru;
            if (_cursor.isNull(_cursorIndexOfAcctThru)) {
              _tmpAcctThru = null;
            } else {
              _tmpAcctThru = _cursor.getString(_cursorIndexOfAcctThru);
            }
            _item.setAcctThru(_tmpAcctThru);
            final String _tmpFactorRt;
            if (_cursor.isNull(_cursorIndexOfFactorRt)) {
              _tmpFactorRt = null;
            } else {
              _tmpFactorRt = _cursor.getString(_cursorIndexOfFactorRt);
            }
            _item.setFactorRt(_tmpFactorRt);
            final String _tmpPricexxx;
            if (_cursor.isNull(_cursorIndexOfPricexxx)) {
              _tmpPricexxx = null;
            } else {
              _tmpPricexxx = _cursor.getString(_cursorIndexOfPricexxx);
            }
            _item.setPricexxx(_tmpPricexxx);
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
    final String _sql = "SELECT MAX(dTimeStmp) FROM MC_Term_Category";
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
