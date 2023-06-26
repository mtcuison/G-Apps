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
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GConnect.room.Entities.EEvents;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DEvents_Impl implements DEvents {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EEvents> __insertionAdapterOfEEvents;

  private final EntityDeletionOrUpdateAdapter<EEvents> __updateAdapterOfEEvents;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReadEvent;

  private final SharedSQLiteStatement __preparedStmtOfUpdateEventImgPath;

  public DEvents_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEEvents = new EntityInsertionAdapter<EEvents>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `App_Event_Info` (`sTransNox`,`sBranchNm`,`dEvntFrom`,`dEvntThru`,`sEventTle`,`sAddressx`,`sEventURL`,`sImageURL`,`cNotified`,`dModified`,`sDirectoryFolder`,`sImagePath`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEvents value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchNm());
        }
        if (value.getEvntFrom() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEvntFrom());
        }
        if (value.getEvntThru() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEvntThru());
        }
        if (value.getEventTle() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEventTle());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAddressx());
        }
        if (value.getEventURL() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEventURL());
        }
        if (value.getImageURL() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImageURL());
        }
        if (value.getNotified() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getNotified());
        }
        if (value.getModified() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModified());
        }
        if (value.getDirectoryFolder() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDirectoryFolder());
        }
        if (value.getImagePath() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getImagePath());
        }
      }
    };
    this.__updateAdapterOfEEvents = new EntityDeletionOrUpdateAdapter<EEvents>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `App_Event_Info` SET `sTransNox` = ?,`sBranchNm` = ?,`dEvntFrom` = ?,`dEvntThru` = ?,`sEventTle` = ?,`sAddressx` = ?,`sEventURL` = ?,`sImageURL` = ?,`cNotified` = ?,`dModified` = ?,`sDirectoryFolder` = ?,`sImagePath` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEvents value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchNm());
        }
        if (value.getEvntFrom() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEvntFrom());
        }
        if (value.getEvntThru() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getEvntThru());
        }
        if (value.getEventTle() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEventTle());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAddressx());
        }
        if (value.getEventURL() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEventURL());
        }
        if (value.getImageURL() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImageURL());
        }
        if (value.getNotified() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getNotified());
        }
        if (value.getModified() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModified());
        }
        if (value.getDirectoryFolder() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDirectoryFolder());
        }
        if (value.getImagePath() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getImagePath());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateReadEvent = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE App_Event_Info SET cNotified = '1', dModified =? WHERE sTransNox =? ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateEventImgPath = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE App_Event_Info SET sImagePath =? WHERE sTransNox =? ";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EEvents events) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEEvents.insert(events);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EEvents> events) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEEvents.insert(events);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EEvents events) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEEvents.handle(events);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateReadEvent(final String date, final String transNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReadEvent.acquire();
    int _argIndex = 1;
    if (date == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, date);
    }
    _argIndex = 2;
    if (transNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, transNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateReadEvent.release(_stmt);
    }
  }

  @Override
  public void updateEventImgPath(final String imgPath, final String transNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateEventImgPath.acquire();
    int _argIndex = 1;
    if (imgPath == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, imgPath);
    }
    _argIndex = 2;
    if (transNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, transNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateEventImgPath.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EEvents>> getAllEvents() {
    final String _sql = "SELECT * FROM App_Event_Info ORDER BY sTransNox ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"App_Event_Info"}, false, new Callable<List<EEvents>>() {
      @Override
      public List<EEvents> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfEvntFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dEvntFrom");
          final int _cursorIndexOfEvntThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dEvntThru");
          final int _cursorIndexOfEventTle = CursorUtil.getColumnIndexOrThrow(_cursor, "sEventTle");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfEventURL = CursorUtil.getColumnIndexOrThrow(_cursor, "sEventURL");
          final int _cursorIndexOfImageURL = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageURL");
          final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfDirectoryFolder = CursorUtil.getColumnIndexOrThrow(_cursor, "sDirectoryFolder");
          final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "sImagePath");
          final List<EEvents> _result = new ArrayList<EEvents>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EEvents _item;
            _item = new EEvents();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpEvntFrom;
            if (_cursor.isNull(_cursorIndexOfEvntFrom)) {
              _tmpEvntFrom = null;
            } else {
              _tmpEvntFrom = _cursor.getString(_cursorIndexOfEvntFrom);
            }
            _item.setEvntFrom(_tmpEvntFrom);
            final String _tmpEvntThru;
            if (_cursor.isNull(_cursorIndexOfEvntThru)) {
              _tmpEvntThru = null;
            } else {
              _tmpEvntThru = _cursor.getString(_cursorIndexOfEvntThru);
            }
            _item.setEvntThru(_tmpEvntThru);
            final String _tmpEventTle;
            if (_cursor.isNull(_cursorIndexOfEventTle)) {
              _tmpEventTle = null;
            } else {
              _tmpEventTle = _cursor.getString(_cursorIndexOfEventTle);
            }
            _item.setEventTle(_tmpEventTle);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpEventURL;
            if (_cursor.isNull(_cursorIndexOfEventURL)) {
              _tmpEventURL = null;
            } else {
              _tmpEventURL = _cursor.getString(_cursorIndexOfEventURL);
            }
            _item.setEventURL(_tmpEventURL);
            final String _tmpImageURL;
            if (_cursor.isNull(_cursorIndexOfImageURL)) {
              _tmpImageURL = null;
            } else {
              _tmpImageURL = _cursor.getString(_cursorIndexOfImageURL);
            }
            _item.setImageURL(_tmpImageURL);
            final String _tmpNotified;
            if (_cursor.isNull(_cursorIndexOfNotified)) {
              _tmpNotified = null;
            } else {
              _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
            }
            _item.setNotified(_tmpNotified);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            final String _tmpDirectoryFolder;
            if (_cursor.isNull(_cursorIndexOfDirectoryFolder)) {
              _tmpDirectoryFolder = null;
            } else {
              _tmpDirectoryFolder = _cursor.getString(_cursorIndexOfDirectoryFolder);
            }
            _item.setDirectoryFolder(_tmpDirectoryFolder);
            final String _tmpImagePath;
            if (_cursor.isNull(_cursorIndexOfImagePath)) {
              _tmpImagePath = null;
            } else {
              _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
            }
            _item.setImagePath(_tmpImagePath);
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
  public List<EEvents> getAllEventsForDownloadImg() {
    final String _sql = "SELECT * FROM App_Event_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfEvntFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dEvntFrom");
      final int _cursorIndexOfEvntThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dEvntThru");
      final int _cursorIndexOfEventTle = CursorUtil.getColumnIndexOrThrow(_cursor, "sEventTle");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfEventURL = CursorUtil.getColumnIndexOrThrow(_cursor, "sEventURL");
      final int _cursorIndexOfImageURL = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageURL");
      final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfDirectoryFolder = CursorUtil.getColumnIndexOrThrow(_cursor, "sDirectoryFolder");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "sImagePath");
      final List<EEvents> _result = new ArrayList<EEvents>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EEvents _item;
        _item = new EEvents();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _item.setBranchNm(_tmpBranchNm);
        final String _tmpEvntFrom;
        if (_cursor.isNull(_cursorIndexOfEvntFrom)) {
          _tmpEvntFrom = null;
        } else {
          _tmpEvntFrom = _cursor.getString(_cursorIndexOfEvntFrom);
        }
        _item.setEvntFrom(_tmpEvntFrom);
        final String _tmpEvntThru;
        if (_cursor.isNull(_cursorIndexOfEvntThru)) {
          _tmpEvntThru = null;
        } else {
          _tmpEvntThru = _cursor.getString(_cursorIndexOfEvntThru);
        }
        _item.setEvntThru(_tmpEvntThru);
        final String _tmpEventTle;
        if (_cursor.isNull(_cursorIndexOfEventTle)) {
          _tmpEventTle = null;
        } else {
          _tmpEventTle = _cursor.getString(_cursorIndexOfEventTle);
        }
        _item.setEventTle(_tmpEventTle);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpEventURL;
        if (_cursor.isNull(_cursorIndexOfEventURL)) {
          _tmpEventURL = null;
        } else {
          _tmpEventURL = _cursor.getString(_cursorIndexOfEventURL);
        }
        _item.setEventURL(_tmpEventURL);
        final String _tmpImageURL;
        if (_cursor.isNull(_cursorIndexOfImageURL)) {
          _tmpImageURL = null;
        } else {
          _tmpImageURL = _cursor.getString(_cursorIndexOfImageURL);
        }
        _item.setImageURL(_tmpImageURL);
        final String _tmpNotified;
        if (_cursor.isNull(_cursorIndexOfNotified)) {
          _tmpNotified = null;
        } else {
          _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
        }
        _item.setNotified(_tmpNotified);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        final String _tmpDirectoryFolder;
        if (_cursor.isNull(_cursorIndexOfDirectoryFolder)) {
          _tmpDirectoryFolder = null;
        } else {
          _tmpDirectoryFolder = _cursor.getString(_cursorIndexOfDirectoryFolder);
        }
        _item.setDirectoryFolder(_tmpDirectoryFolder);
        final String _tmpImagePath;
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _tmpImagePath = null;
        } else {
          _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
        _item.setImagePath(_tmpImagePath);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public boolean getEventExist(final String TransNox) {
    final String _sql = "SELECT EXISTS(SELECT * FROM App_Event_Info WHERE sTransNox =? AND cNotified = '1')";
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
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<Integer> getEventCount() {
    final String _sql = "SELECT COUNT(*) FROM App_Event_Info WHERE cNotified = '0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"App_Event_Info"}, false, new Callable<Integer>() {
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
  public EEvents CheckEvent() {
    final String _sql = "SELECT * FROM App_Event_Info ORDER BY dEvntFrom DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfEvntFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dEvntFrom");
      final int _cursorIndexOfEvntThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dEvntThru");
      final int _cursorIndexOfEventTle = CursorUtil.getColumnIndexOrThrow(_cursor, "sEventTle");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfEventURL = CursorUtil.getColumnIndexOrThrow(_cursor, "sEventURL");
      final int _cursorIndexOfImageURL = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageURL");
      final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfDirectoryFolder = CursorUtil.getColumnIndexOrThrow(_cursor, "sDirectoryFolder");
      final int _cursorIndexOfImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "sImagePath");
      final EEvents _result;
      if(_cursor.moveToFirst()) {
        _result = new EEvents();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpEvntFrom;
        if (_cursor.isNull(_cursorIndexOfEvntFrom)) {
          _tmpEvntFrom = null;
        } else {
          _tmpEvntFrom = _cursor.getString(_cursorIndexOfEvntFrom);
        }
        _result.setEvntFrom(_tmpEvntFrom);
        final String _tmpEvntThru;
        if (_cursor.isNull(_cursorIndexOfEvntThru)) {
          _tmpEvntThru = null;
        } else {
          _tmpEvntThru = _cursor.getString(_cursorIndexOfEvntThru);
        }
        _result.setEvntThru(_tmpEvntThru);
        final String _tmpEventTle;
        if (_cursor.isNull(_cursorIndexOfEventTle)) {
          _tmpEventTle = null;
        } else {
          _tmpEventTle = _cursor.getString(_cursorIndexOfEventTle);
        }
        _result.setEventTle(_tmpEventTle);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpEventURL;
        if (_cursor.isNull(_cursorIndexOfEventURL)) {
          _tmpEventURL = null;
        } else {
          _tmpEventURL = _cursor.getString(_cursorIndexOfEventURL);
        }
        _result.setEventURL(_tmpEventURL);
        final String _tmpImageURL;
        if (_cursor.isNull(_cursorIndexOfImageURL)) {
          _tmpImageURL = null;
        } else {
          _tmpImageURL = _cursor.getString(_cursorIndexOfImageURL);
        }
        _result.setImageURL(_tmpImageURL);
        final String _tmpNotified;
        if (_cursor.isNull(_cursorIndexOfNotified)) {
          _tmpNotified = null;
        } else {
          _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
        }
        _result.setNotified(_tmpNotified);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
        final String _tmpDirectoryFolder;
        if (_cursor.isNull(_cursorIndexOfDirectoryFolder)) {
          _tmpDirectoryFolder = null;
        } else {
          _tmpDirectoryFolder = _cursor.getString(_cursorIndexOfDirectoryFolder);
        }
        _result.setDirectoryFolder(_tmpDirectoryFolder);
        final String _tmpImagePath;
        if (_cursor.isNull(_cursorIndexOfImagePath)) {
          _tmpImagePath = null;
        } else {
          _tmpImagePath = _cursor.getString(_cursorIndexOfImagePath);
        }
        _result.setImagePath(_tmpImagePath);
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
