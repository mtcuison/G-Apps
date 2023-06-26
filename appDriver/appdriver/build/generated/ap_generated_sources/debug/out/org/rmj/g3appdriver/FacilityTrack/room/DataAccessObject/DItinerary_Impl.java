package org.rmj.g3appdriver.FacilityTrack.room.DataAccessObject;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.FacilityTrack.room.Entities.EBuildingVisit;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DItinerary_Impl implements DItinerary {
  private final RoomDatabase __db;

  public DItinerary_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  @Override
  public LiveData<List<EBuildingVisit>> GetItineraries() {
    final String _sql = "SELECT * FROM Building_Visit";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Building_Visit"}, false, new Callable<List<EBuildingVisit>>() {
      @Override
      public List<EBuildingVisit> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfWHouseID = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseID");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBuildingVisit> _result = new ArrayList<EBuildingVisit>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBuildingVisit _item;
            _item = new EBuildingVisit();
            final String _tmpWHouseID;
            if (_cursor.isNull(_cursorIndexOfWHouseID)) {
              _tmpWHouseID = null;
            } else {
              _tmpWHouseID = _cursor.getString(_cursorIndexOfWHouseID);
            }
            _item.setWHouseID(_tmpWHouseID);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpUserIDxx;
            if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
              _tmpUserIDxx = null;
            } else {
              _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
            }
            _item.setUserIDxx(_tmpUserIDxx);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
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
  public List<EBuildingVisit> GetItinerary() {
    final String _sql = "SELECT * FROM Building_Visit";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfWHouseID = CursorUtil.getColumnIndexOrThrow(_cursor, "sWHouseID");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<EBuildingVisit> _result = new ArrayList<EBuildingVisit>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EBuildingVisit _item;
        _item = new EBuildingVisit();
        final String _tmpWHouseID;
        if (_cursor.isNull(_cursorIndexOfWHouseID)) {
          _tmpWHouseID = null;
        } else {
          _tmpWHouseID = _cursor.getString(_cursorIndexOfWHouseID);
        }
        _item.setWHouseID(_tmpWHouseID);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _item.setUserIDxx(_tmpUserIDxx);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
