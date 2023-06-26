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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EItinerary;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DItinerary_Impl implements DItinerary {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EItinerary> __insertionAdapterOfEItinerary;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentItinerary;

  private final SharedSQLiteStatement __preparedStmtOfUpdateItineraryStatus;

  public DItinerary_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEItinerary = new EntityInsertionAdapter<EItinerary>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Employee_Itinerary` (`sTransNox`,`sEmployID`,`dTransact`,`dTimeFrom`,`dTimeThru`,`sLocation`,`sRemarksx`,`cSendStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EItinerary value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getEmployID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getEmployID());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getTimeFrom() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeFrom());
        }
        if (value.getTimeThru() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTimeThru());
        }
        if (value.getLocation() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getLocation());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getRemarksx());
        }
        stmt.bindLong(8, value.getSendStat());
        if (value.getTimeStmp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTimeStmp());
        }
      }
    };
    this.__preparedStmtOfUpdateSentItinerary = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Employee_Itinerary SET cSendStat = 1, sTransNox =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateItineraryStatus = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Employee_Itinerary SET cSendStat = 2 WHERE sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void Save(final EItinerary foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEItinerary.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateSentItinerary(final String TransNox, final String TransNo1) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSentItinerary.acquire();
    int _argIndex = 1;
    if (TransNo1 == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNo1);
    }
    _argIndex = 2;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSentItinerary.release(_stmt);
    }
  }

  @Override
  public void UpdateItineraryStatus(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateItineraryStatus.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateItineraryStatus.release(_stmt);
    }
  }

  @Override
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT (*) FROM Employee_Itinerary";
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
  public EItinerary GetItineraryForUpload(final String TransNox) {
    final String _sql = "SELECT * FROM Employee_Itinerary WHERE sTransNox =?";
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
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfTimeFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeFrom");
      final int _cursorIndexOfTimeThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeThru");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "sLocation");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EItinerary _result;
      if(_cursor.moveToFirst()) {
        _result = new EItinerary();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpEmployID;
        if (_cursor.isNull(_cursorIndexOfEmployID)) {
          _tmpEmployID = null;
        } else {
          _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
        }
        _result.setEmployID(_tmpEmployID);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpTimeFrom;
        if (_cursor.isNull(_cursorIndexOfTimeFrom)) {
          _tmpTimeFrom = null;
        } else {
          _tmpTimeFrom = _cursor.getString(_cursorIndexOfTimeFrom);
        }
        _result.setTimeFrom(_tmpTimeFrom);
        final String _tmpTimeThru;
        if (_cursor.isNull(_cursorIndexOfTimeThru)) {
          _tmpTimeThru = null;
        } else {
          _tmpTimeThru = _cursor.getString(_cursorIndexOfTimeThru);
        }
        _result.setTimeThru(_tmpTimeThru);
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        _result.setLocation(_tmpLocation);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final int _tmpSendStat;
        _tmpSendStat = _cursor.getInt(_cursorIndexOfSendStat);
        _result.setSendStat(_tmpSendStat);
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
  public List<EItinerary> GetUnsentItineraryList() {
    final String _sql = "SELECT * FROM Employee_Itinerary WHERE cSendStat = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfTimeFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeFrom");
      final int _cursorIndexOfTimeThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeThru");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "sLocation");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<EItinerary> _result = new ArrayList<EItinerary>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EItinerary _item;
        _item = new EItinerary();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpEmployID;
        if (_cursor.isNull(_cursorIndexOfEmployID)) {
          _tmpEmployID = null;
        } else {
          _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
        }
        _item.setEmployID(_tmpEmployID);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpTimeFrom;
        if (_cursor.isNull(_cursorIndexOfTimeFrom)) {
          _tmpTimeFrom = null;
        } else {
          _tmpTimeFrom = _cursor.getString(_cursorIndexOfTimeFrom);
        }
        _item.setTimeFrom(_tmpTimeFrom);
        final String _tmpTimeThru;
        if (_cursor.isNull(_cursorIndexOfTimeThru)) {
          _tmpTimeThru = null;
        } else {
          _tmpTimeThru = _cursor.getString(_cursorIndexOfTimeThru);
        }
        _item.setTimeThru(_tmpTimeThru);
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        _item.setLocation(_tmpLocation);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final int _tmpSendStat;
        _tmpSendStat = _cursor.getInt(_cursorIndexOfSendStat);
        _item.setSendStat(_tmpSendStat);
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
  public LiveData<List<EItinerary>> GetItineraryListForCurrentDay() {
    final String _sql = "SELECT * FROM Employee_Itinerary WHERE sEmployID = (SELECT sEmployID FROM User_Info_Master) AND strftime('%Y-%m-%d', datetime('now', 'localtime')) = dTransact ORDER BY dTransact DESC, dTimeFrom DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Itinerary","User_Info_Master"}, false, new Callable<List<EItinerary>>() {
      @Override
      public List<EItinerary> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfTimeFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeFrom");
          final int _cursorIndexOfTimeThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeThru");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "sLocation");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EItinerary> _result = new ArrayList<EItinerary>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EItinerary _item;
            _item = new EItinerary();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpEmployID;
            if (_cursor.isNull(_cursorIndexOfEmployID)) {
              _tmpEmployID = null;
            } else {
              _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
            }
            _item.setEmployID(_tmpEmployID);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpTimeFrom;
            if (_cursor.isNull(_cursorIndexOfTimeFrom)) {
              _tmpTimeFrom = null;
            } else {
              _tmpTimeFrom = _cursor.getString(_cursorIndexOfTimeFrom);
            }
            _item.setTimeFrom(_tmpTimeFrom);
            final String _tmpTimeThru;
            if (_cursor.isNull(_cursorIndexOfTimeThru)) {
              _tmpTimeThru = null;
            } else {
              _tmpTimeThru = _cursor.getString(_cursorIndexOfTimeThru);
            }
            _item.setTimeThru(_tmpTimeThru);
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _item.setLocation(_tmpLocation);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final int _tmpSendStat;
            _tmpSendStat = _cursor.getInt(_cursorIndexOfSendStat);
            _item.setSendStat(_tmpSendStat);
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
  public List<EItinerary> GetUnsentItinerary() {
    final String _sql = "SELECT * FROM Employee_Itinerary WHERE sEmployID = (SELECT sEmployID FROM User_Info_Master) AND cSendStat == '0' ORDER BY dTransact DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfTimeFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeFrom");
      final int _cursorIndexOfTimeThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeThru");
      final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "sLocation");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<EItinerary> _result = new ArrayList<EItinerary>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EItinerary _item;
        _item = new EItinerary();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpEmployID;
        if (_cursor.isNull(_cursorIndexOfEmployID)) {
          _tmpEmployID = null;
        } else {
          _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
        }
        _item.setEmployID(_tmpEmployID);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpTimeFrom;
        if (_cursor.isNull(_cursorIndexOfTimeFrom)) {
          _tmpTimeFrom = null;
        } else {
          _tmpTimeFrom = _cursor.getString(_cursorIndexOfTimeFrom);
        }
        _item.setTimeFrom(_tmpTimeFrom);
        final String _tmpTimeThru;
        if (_cursor.isNull(_cursorIndexOfTimeThru)) {
          _tmpTimeThru = null;
        } else {
          _tmpTimeThru = _cursor.getString(_cursorIndexOfTimeThru);
        }
        _item.setTimeThru(_tmpTimeThru);
        final String _tmpLocation;
        if (_cursor.isNull(_cursorIndexOfLocation)) {
          _tmpLocation = null;
        } else {
          _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
        }
        _item.setLocation(_tmpLocation);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final int _tmpSendStat;
        _tmpSendStat = _cursor.getInt(_cursorIndexOfSendStat);
        _item.setSendStat(_tmpSendStat);
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
  public LiveData<List<EItinerary>> GetItineraryListForFilteredDate(final String dDateFrom,
      final String dDateThru) {
    final String _sql = "SELECT * FROM Employee_Itinerary WHERE sEmployID = (SELECT sEmployID FROM User_Info_Master) AND dTransact >= strftime('%Y-%m-%d', ?) AND dTransact <= strftime('%Y-%m-%d', ?) ORDER BY dTransact DESC, dTimeFrom DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (dDateFrom == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dDateFrom);
    }
    _argIndex = 2;
    if (dDateThru == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dDateThru);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Employee_Itinerary","User_Info_Master"}, false, new Callable<List<EItinerary>>() {
      @Override
      public List<EItinerary> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfEmployID = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmployID");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfTimeFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeFrom");
          final int _cursorIndexOfTimeThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeThru");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "sLocation");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EItinerary> _result = new ArrayList<EItinerary>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EItinerary _item;
            _item = new EItinerary();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpEmployID;
            if (_cursor.isNull(_cursorIndexOfEmployID)) {
              _tmpEmployID = null;
            } else {
              _tmpEmployID = _cursor.getString(_cursorIndexOfEmployID);
            }
            _item.setEmployID(_tmpEmployID);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpTimeFrom;
            if (_cursor.isNull(_cursorIndexOfTimeFrom)) {
              _tmpTimeFrom = null;
            } else {
              _tmpTimeFrom = _cursor.getString(_cursorIndexOfTimeFrom);
            }
            _item.setTimeFrom(_tmpTimeFrom);
            final String _tmpTimeThru;
            if (_cursor.isNull(_cursorIndexOfTimeThru)) {
              _tmpTimeThru = null;
            } else {
              _tmpTimeThru = _cursor.getString(_cursorIndexOfTimeThru);
            }
            _item.setTimeThru(_tmpTimeThru);
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _item.setLocation(_tmpLocation);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final int _tmpSendStat;
            _tmpSendStat = _cursor.getInt(_cursorIndexOfSendStat);
            _item.setSendStat(_tmpSendStat);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
