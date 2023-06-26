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
import org.rmj.g3appdriver.GCircle.room.Entities.EMcCategory;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DMcCategory_Impl implements DMcCategory {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EMcCategory> __insertionAdapterOfEMcCategory;

  private final EntityInsertionAdapter<EMcCategory> __insertionAdapterOfEMcCategory_1;

  private final EntityDeletionOrUpdateAdapter<EMcCategory> __updateAdapterOfEMcCategory;

  public DMcCategory_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEMcCategory = new EntityInsertionAdapter<EMcCategory>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MC_Category` (`sMcCatIDx`,`sMcCatNme`,`nMiscChrg`,`nRebatesx`,`nEndMrtgg`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcCategory value) {
        if (value.getMcCatIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMcCatIDx());
        }
        if (value.getMcCatNme() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMcCatNme());
        }
        if (value.getMiscChrg() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMiscChrg());
        }
        if (value.getRebatesx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRebatesx());
        }
        if (value.getEndMrtgg() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEndMrtgg());
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
        if (value.getLstUpdte() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLstUpdte());
        }
      }
    };
    this.__insertionAdapterOfEMcCategory_1 = new EntityInsertionAdapter<EMcCategory>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `MC_Category` (`sMcCatIDx`,`sMcCatNme`,`nMiscChrg`,`nRebatesx`,`nEndMrtgg`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcCategory value) {
        if (value.getMcCatIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMcCatIDx());
        }
        if (value.getMcCatNme() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMcCatNme());
        }
        if (value.getMiscChrg() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMiscChrg());
        }
        if (value.getRebatesx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRebatesx());
        }
        if (value.getEndMrtgg() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEndMrtgg());
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
        if (value.getLstUpdte() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLstUpdte());
        }
      }
    };
    this.__updateAdapterOfEMcCategory = new EntityDeletionOrUpdateAdapter<EMcCategory>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MC_Category` SET `sMcCatIDx` = ?,`sMcCatNme` = ?,`nMiscChrg` = ?,`nRebatesx` = ?,`nEndMrtgg` = ?,`cRecdStat` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sMcCatIDx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcCategory value) {
        if (value.getMcCatIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getMcCatIDx());
        }
        if (value.getMcCatNme() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getMcCatNme());
        }
        if (value.getMiscChrg() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getMiscChrg());
        }
        if (value.getRebatesx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRebatesx());
        }
        if (value.getEndMrtgg() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEndMrtgg());
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
        if (value.getLstUpdte() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLstUpdte());
        }
        if (value.getMcCatIDx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMcCatIDx());
        }
      }
    };
  }

  @Override
  public void insert(final EMcCategory mcCategory) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMcCategory.insert(mcCategory);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insetBulkData(final List<EMcCategory> categories) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMcCategory_1.insert(categories);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EMcCategory mcCategory) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEMcCategory.handle(mcCategory);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public EMcCategory GetMcCategory(final String fsVal) {
    final String _sql = "SELECT * FROM MC_Category WHERE sMcCatIDx =?";
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
      final int _cursorIndexOfMcCatIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMcCatIDx");
      final int _cursorIndexOfMcCatNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sMcCatNme");
      final int _cursorIndexOfMiscChrg = CursorUtil.getColumnIndexOrThrow(_cursor, "nMiscChrg");
      final int _cursorIndexOfRebatesx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRebatesx");
      final int _cursorIndexOfEndMrtgg = CursorUtil.getColumnIndexOrThrow(_cursor, "nEndMrtgg");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EMcCategory _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcCategory();
        final String _tmpMcCatIDx;
        if (_cursor.isNull(_cursorIndexOfMcCatIDx)) {
          _tmpMcCatIDx = null;
        } else {
          _tmpMcCatIDx = _cursor.getString(_cursorIndexOfMcCatIDx);
        }
        _result.setMcCatIDx(_tmpMcCatIDx);
        final String _tmpMcCatNme;
        if (_cursor.isNull(_cursorIndexOfMcCatNme)) {
          _tmpMcCatNme = null;
        } else {
          _tmpMcCatNme = _cursor.getString(_cursorIndexOfMcCatNme);
        }
        _result.setMcCatNme(_tmpMcCatNme);
        final String _tmpMiscChrg;
        if (_cursor.isNull(_cursorIndexOfMiscChrg)) {
          _tmpMiscChrg = null;
        } else {
          _tmpMiscChrg = _cursor.getString(_cursorIndexOfMiscChrg);
        }
        _result.setMiscChrg(_tmpMiscChrg);
        final String _tmpRebatesx;
        if (_cursor.isNull(_cursorIndexOfRebatesx)) {
          _tmpRebatesx = null;
        } else {
          _tmpRebatesx = _cursor.getString(_cursorIndexOfRebatesx);
        }
        _result.setRebatesx(_tmpRebatesx);
        final String _tmpEndMrtgg;
        if (_cursor.isNull(_cursorIndexOfEndMrtgg)) {
          _tmpEndMrtgg = null;
        } else {
          _tmpEndMrtgg = _cursor.getString(_cursorIndexOfEndMrtgg);
        }
        _result.setEndMrtgg(_tmpEndMrtgg);
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
  public EMcCategory GetLatestMcCategory() {
    final String _sql = "SELECT * FROM MC_Category ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMcCatIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMcCatIDx");
      final int _cursorIndexOfMcCatNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sMcCatNme");
      final int _cursorIndexOfMiscChrg = CursorUtil.getColumnIndexOrThrow(_cursor, "nMiscChrg");
      final int _cursorIndexOfRebatesx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRebatesx");
      final int _cursorIndexOfEndMrtgg = CursorUtil.getColumnIndexOrThrow(_cursor, "nEndMrtgg");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EMcCategory _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcCategory();
        final String _tmpMcCatIDx;
        if (_cursor.isNull(_cursorIndexOfMcCatIDx)) {
          _tmpMcCatIDx = null;
        } else {
          _tmpMcCatIDx = _cursor.getString(_cursorIndexOfMcCatIDx);
        }
        _result.setMcCatIDx(_tmpMcCatIDx);
        final String _tmpMcCatNme;
        if (_cursor.isNull(_cursorIndexOfMcCatNme)) {
          _tmpMcCatNme = null;
        } else {
          _tmpMcCatNme = _cursor.getString(_cursorIndexOfMcCatNme);
        }
        _result.setMcCatNme(_tmpMcCatNme);
        final String _tmpMiscChrg;
        if (_cursor.isNull(_cursorIndexOfMiscChrg)) {
          _tmpMiscChrg = null;
        } else {
          _tmpMiscChrg = _cursor.getString(_cursorIndexOfMiscChrg);
        }
        _result.setMiscChrg(_tmpMiscChrg);
        final String _tmpRebatesx;
        if (_cursor.isNull(_cursorIndexOfRebatesx)) {
          _tmpRebatesx = null;
        } else {
          _tmpRebatesx = _cursor.getString(_cursorIndexOfRebatesx);
        }
        _result.setRebatesx(_tmpRebatesx);
        final String _tmpEndMrtgg;
        if (_cursor.isNull(_cursorIndexOfEndMrtgg)) {
          _tmpEndMrtgg = null;
        } else {
          _tmpEndMrtgg = _cursor.getString(_cursorIndexOfEndMrtgg);
        }
        _result.setEndMrtgg(_tmpEndMrtgg);
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
  public LiveData<List<EMcCategory>> getAllMcCategory() {
    final String _sql = "SELECT * FROM MC_Category";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"MC_Category"}, false, new Callable<List<EMcCategory>>() {
      @Override
      public List<EMcCategory> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfMcCatIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMcCatIDx");
          final int _cursorIndexOfMcCatNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sMcCatNme");
          final int _cursorIndexOfMiscChrg = CursorUtil.getColumnIndexOrThrow(_cursor, "nMiscChrg");
          final int _cursorIndexOfRebatesx = CursorUtil.getColumnIndexOrThrow(_cursor, "nRebatesx");
          final int _cursorIndexOfEndMrtgg = CursorUtil.getColumnIndexOrThrow(_cursor, "nEndMrtgg");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EMcCategory> _result = new ArrayList<EMcCategory>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMcCategory _item;
            _item = new EMcCategory();
            final String _tmpMcCatIDx;
            if (_cursor.isNull(_cursorIndexOfMcCatIDx)) {
              _tmpMcCatIDx = null;
            } else {
              _tmpMcCatIDx = _cursor.getString(_cursorIndexOfMcCatIDx);
            }
            _item.setMcCatIDx(_tmpMcCatIDx);
            final String _tmpMcCatNme;
            if (_cursor.isNull(_cursorIndexOfMcCatNme)) {
              _tmpMcCatNme = null;
            } else {
              _tmpMcCatNme = _cursor.getString(_cursorIndexOfMcCatNme);
            }
            _item.setMcCatNme(_tmpMcCatNme);
            final String _tmpMiscChrg;
            if (_cursor.isNull(_cursorIndexOfMiscChrg)) {
              _tmpMiscChrg = null;
            } else {
              _tmpMiscChrg = _cursor.getString(_cursorIndexOfMiscChrg);
            }
            _item.setMiscChrg(_tmpMiscChrg);
            final String _tmpRebatesx;
            if (_cursor.isNull(_cursorIndexOfRebatesx)) {
              _tmpRebatesx = null;
            } else {
              _tmpRebatesx = _cursor.getString(_cursorIndexOfRebatesx);
            }
            _item.setRebatesx(_tmpRebatesx);
            final String _tmpEndMrtgg;
            if (_cursor.isNull(_cursorIndexOfEndMrtgg)) {
              _tmpEndMrtgg = null;
            } else {
              _tmpEndMrtgg = _cursor.getString(_cursorIndexOfEndMrtgg);
            }
            _item.setEndMrtgg(_tmpEndMrtgg);
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
    final String _sql = "SELECT MAX(dTimeStmp) FROM MC_Category";
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
