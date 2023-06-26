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
import org.rmj.g3appdriver.GConnect.room.Entities.EGcardApp;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DGcardApp_Impl implements DGcardApp {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EGcardApp> __insertionAdapterOfEGcardApp;

  private final EntityDeletionOrUpdateAdapter<EGcardApp> __updateAdapterOfEGcardApp;

  private final SharedSQLiteStatement __preparedStmtOfDeactivateGCard;

  private final SharedSQLiteStatement __preparedStmtOfSetActiveGCard;

  private final SharedSQLiteStatement __preparedStmtOfInitDefaultActiveGCard;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAvailablePoints;

  public DGcardApp_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEGcardApp = new EntityInsertionAdapter<EGcardApp>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `GCard_App_Master` (`sGCardNox`,`sCardNmbr`,`sUserIDxx`,`sNmOnCard`,`dMemberxx`,`cCardType`,`sTotPoint`,`sAvlPoint`,`cTranStat`,`cActvStat`,`dModified`,`cNotified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGcardApp value) {
        if (value.getGCardNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGCardNox());
        }
        if (value.getCardNmbr() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCardNmbr());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserIDxx());
        }
        if (value.getNmOnCard() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNmOnCard());
        }
        if (value.getMemberxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMemberxx());
        }
        if (value.getCardType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCardType());
        }
        if (value.getTotPoint() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTotPoint());
        }
        if (value.getAvlPoint() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAvlPoint());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTranStat());
        }
        if (value.getActvStat() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getActvStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getModified());
        }
        if (value.getNotified() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNotified());
        }
      }
    };
    this.__updateAdapterOfEGcardApp = new EntityDeletionOrUpdateAdapter<EGcardApp>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `GCard_App_Master` SET `sGCardNox` = ?,`sCardNmbr` = ?,`sUserIDxx` = ?,`sNmOnCard` = ?,`dMemberxx` = ?,`cCardType` = ?,`sTotPoint` = ?,`sAvlPoint` = ?,`cTranStat` = ?,`cActvStat` = ?,`dModified` = ?,`cNotified` = ? WHERE `sGCardNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EGcardApp value) {
        if (value.getGCardNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getGCardNox());
        }
        if (value.getCardNmbr() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCardNmbr());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUserIDxx());
        }
        if (value.getNmOnCard() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getNmOnCard());
        }
        if (value.getMemberxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMemberxx());
        }
        if (value.getCardType() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getCardType());
        }
        if (value.getTotPoint() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTotPoint());
        }
        if (value.getAvlPoint() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAvlPoint());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTranStat());
        }
        if (value.getActvStat() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getActvStat());
        }
        if (value.getModified() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getModified());
        }
        if (value.getNotified() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getNotified());
        }
        if (value.getGCardNox() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getGCardNox());
        }
      }
    };
    this.__preparedStmtOfDeactivateGCard = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Gcard_App_Master SET cActvStat = '0'";
        return _query;
      }
    };
    this.__preparedStmtOfSetActiveGCard = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Gcard_App_Master SET cActvStat = '1' WHERE sCardNmbr =?";
        return _query;
      }
    };
    this.__preparedStmtOfInitDefaultActiveGCard = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Gcard_App_Master SET cActvStat = '1' WHERE sCardNmbr = (SELECT sCardNmbr FROM Gcard_App_Master WHERE sTotPoint IN (SELECT MAX(sTotPoint) FROM Gcard_App_Master))";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAvailablePoints = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE GCard_App_Master SET sAvlPoint = ? WHERE sGCardNox = ?";
        return _query;
      }
    };
  }

  @Override
  public void Save(final EGcardApp gCardApp) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEGcardApp.insert(gCardApp);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EGcardApp> gCardAppList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEGcardApp.insert(gCardAppList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EGcardApp gCardApp) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEGcardApp.handle(gCardApp);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeactivateGCard() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeactivateGCard.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeactivateGCard.release(_stmt);
    }
  }

  @Override
  public void SetActiveGCard(final String GCardNmbr) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSetActiveGCard.acquire();
    int _argIndex = 1;
    if (GCardNmbr == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, GCardNmbr);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfSetActiveGCard.release(_stmt);
    }
  }

  @Override
  public void InitDefaultActiveGCard() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInitDefaultActiveGCard.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInitDefaultActiveGCard.release(_stmt);
    }
  }

  @Override
  public void updateAvailablePoints(final String fsGcardNo, final String fsNewPts) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAvailablePoints.acquire();
    int _argIndex = 1;
    if (fsNewPts == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsNewPts);
    }
    _argIndex = 2;
    if (fsGcardNo == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsGcardNo);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateAvailablePoints.release(_stmt);
    }
  }

  @Override
  public String GetGCardNumber() {
    final String _sql = "SELECT sCardNmbr FROM Gcard_App_Master WHERE cActvStat = '1'";
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
  public String GetCardNox() {
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
  public LiveData<EGcardApp> GetActiveGCcardInfo() {
    final String _sql = "SELECT * FROM GCard_App_Master WHERE cActvStat = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"GCard_App_Master"}, false, new Callable<EGcardApp>() {
      @Override
      public EGcardApp call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGCardNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGCardNox");
          final int _cursorIndexOfCardNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sCardNmbr");
          final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
          final int _cursorIndexOfNmOnCard = CursorUtil.getColumnIndexOrThrow(_cursor, "sNmOnCard");
          final int _cursorIndexOfMemberxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dMemberxx");
          final int _cursorIndexOfCardType = CursorUtil.getColumnIndexOrThrow(_cursor, "cCardType");
          final int _cursorIndexOfTotPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "sTotPoint");
          final int _cursorIndexOfAvlPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "sAvlPoint");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfActvStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cActvStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
          final EGcardApp _result;
          if(_cursor.moveToFirst()) {
            _result = new EGcardApp();
            final String _tmpGCardNox;
            if (_cursor.isNull(_cursorIndexOfGCardNox)) {
              _tmpGCardNox = null;
            } else {
              _tmpGCardNox = _cursor.getString(_cursorIndexOfGCardNox);
            }
            _result.setGCardNox(_tmpGCardNox);
            final String _tmpCardNmbr;
            if (_cursor.isNull(_cursorIndexOfCardNmbr)) {
              _tmpCardNmbr = null;
            } else {
              _tmpCardNmbr = _cursor.getString(_cursorIndexOfCardNmbr);
            }
            _result.setCardNmbr(_tmpCardNmbr);
            final String _tmpUserIDxx;
            if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
              _tmpUserIDxx = null;
            } else {
              _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
            }
            _result.setUserIDxx(_tmpUserIDxx);
            final String _tmpNmOnCard;
            if (_cursor.isNull(_cursorIndexOfNmOnCard)) {
              _tmpNmOnCard = null;
            } else {
              _tmpNmOnCard = _cursor.getString(_cursorIndexOfNmOnCard);
            }
            _result.setNmOnCard(_tmpNmOnCard);
            final String _tmpMemberxx;
            if (_cursor.isNull(_cursorIndexOfMemberxx)) {
              _tmpMemberxx = null;
            } else {
              _tmpMemberxx = _cursor.getString(_cursorIndexOfMemberxx);
            }
            _result.setMemberxx(_tmpMemberxx);
            final String _tmpCardType;
            if (_cursor.isNull(_cursorIndexOfCardType)) {
              _tmpCardType = null;
            } else {
              _tmpCardType = _cursor.getString(_cursorIndexOfCardType);
            }
            _result.setCardType(_tmpCardType);
            final String _tmpTotPoint;
            if (_cursor.isNull(_cursorIndexOfTotPoint)) {
              _tmpTotPoint = null;
            } else {
              _tmpTotPoint = _cursor.getString(_cursorIndexOfTotPoint);
            }
            _result.setTotPoint(_tmpTotPoint);
            final String _tmpAvlPoint;
            if (_cursor.isNull(_cursorIndexOfAvlPoint)) {
              _tmpAvlPoint = null;
            } else {
              _tmpAvlPoint = _cursor.getString(_cursorIndexOfAvlPoint);
            }
            _result.setAvlPoint(_tmpAvlPoint);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpActvStat;
            if (_cursor.isNull(_cursorIndexOfActvStat)) {
              _tmpActvStat = null;
            } else {
              _tmpActvStat = _cursor.getString(_cursorIndexOfActvStat);
            }
            _result.setActvStat(_tmpActvStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
            final String _tmpNotified;
            if (_cursor.isNull(_cursorIndexOfNotified)) {
              _tmpNotified = null;
            } else {
              _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
            }
            _result.setNotified(_tmpNotified);
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
  public LiveData<List<EGcardApp>> GetAllGCardInfo() {
    final String _sql = "SELECT * FROM GCard_App_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"GCard_App_Master"}, false, new Callable<List<EGcardApp>>() {
      @Override
      public List<EGcardApp> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfGCardNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGCardNox");
          final int _cursorIndexOfCardNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sCardNmbr");
          final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
          final int _cursorIndexOfNmOnCard = CursorUtil.getColumnIndexOrThrow(_cursor, "sNmOnCard");
          final int _cursorIndexOfMemberxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dMemberxx");
          final int _cursorIndexOfCardType = CursorUtil.getColumnIndexOrThrow(_cursor, "cCardType");
          final int _cursorIndexOfTotPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "sTotPoint");
          final int _cursorIndexOfAvlPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "sAvlPoint");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfActvStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cActvStat");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
          final List<EGcardApp> _result = new ArrayList<EGcardApp>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EGcardApp _item;
            _item = new EGcardApp();
            final String _tmpGCardNox;
            if (_cursor.isNull(_cursorIndexOfGCardNox)) {
              _tmpGCardNox = null;
            } else {
              _tmpGCardNox = _cursor.getString(_cursorIndexOfGCardNox);
            }
            _item.setGCardNox(_tmpGCardNox);
            final String _tmpCardNmbr;
            if (_cursor.isNull(_cursorIndexOfCardNmbr)) {
              _tmpCardNmbr = null;
            } else {
              _tmpCardNmbr = _cursor.getString(_cursorIndexOfCardNmbr);
            }
            _item.setCardNmbr(_tmpCardNmbr);
            final String _tmpUserIDxx;
            if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
              _tmpUserIDxx = null;
            } else {
              _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
            }
            _item.setUserIDxx(_tmpUserIDxx);
            final String _tmpNmOnCard;
            if (_cursor.isNull(_cursorIndexOfNmOnCard)) {
              _tmpNmOnCard = null;
            } else {
              _tmpNmOnCard = _cursor.getString(_cursorIndexOfNmOnCard);
            }
            _item.setNmOnCard(_tmpNmOnCard);
            final String _tmpMemberxx;
            if (_cursor.isNull(_cursorIndexOfMemberxx)) {
              _tmpMemberxx = null;
            } else {
              _tmpMemberxx = _cursor.getString(_cursorIndexOfMemberxx);
            }
            _item.setMemberxx(_tmpMemberxx);
            final String _tmpCardType;
            if (_cursor.isNull(_cursorIndexOfCardType)) {
              _tmpCardType = null;
            } else {
              _tmpCardType = _cursor.getString(_cursorIndexOfCardType);
            }
            _item.setCardType(_tmpCardType);
            final String _tmpTotPoint;
            if (_cursor.isNull(_cursorIndexOfTotPoint)) {
              _tmpTotPoint = null;
            } else {
              _tmpTotPoint = _cursor.getString(_cursorIndexOfTotPoint);
            }
            _item.setTotPoint(_tmpTotPoint);
            final String _tmpAvlPoint;
            if (_cursor.isNull(_cursorIndexOfAvlPoint)) {
              _tmpAvlPoint = null;
            } else {
              _tmpAvlPoint = _cursor.getString(_cursorIndexOfAvlPoint);
            }
            _item.setAvlPoint(_tmpAvlPoint);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpActvStat;
            if (_cursor.isNull(_cursorIndexOfActvStat)) {
              _tmpActvStat = null;
            } else {
              _tmpActvStat = _cursor.getString(_cursorIndexOfActvStat);
            }
            _item.setActvStat(_tmpActvStat);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            final String _tmpNotified;
            if (_cursor.isNull(_cursorIndexOfNotified)) {
              _tmpNotified = null;
            } else {
              _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
            }
            _item.setNotified(_tmpNotified);
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
  public List<EGcardApp> getAllGCard() {
    final String _sql = "SELECT * FROM GCard_App_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfGCardNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGCardNox");
      final int _cursorIndexOfCardNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sCardNmbr");
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfNmOnCard = CursorUtil.getColumnIndexOrThrow(_cursor, "sNmOnCard");
      final int _cursorIndexOfMemberxx = CursorUtil.getColumnIndexOrThrow(_cursor, "dMemberxx");
      final int _cursorIndexOfCardType = CursorUtil.getColumnIndexOrThrow(_cursor, "cCardType");
      final int _cursorIndexOfTotPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "sTotPoint");
      final int _cursorIndexOfAvlPoint = CursorUtil.getColumnIndexOrThrow(_cursor, "sAvlPoint");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfActvStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cActvStat");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
      final List<EGcardApp> _result = new ArrayList<EGcardApp>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EGcardApp _item;
        _item = new EGcardApp();
        final String _tmpGCardNox;
        if (_cursor.isNull(_cursorIndexOfGCardNox)) {
          _tmpGCardNox = null;
        } else {
          _tmpGCardNox = _cursor.getString(_cursorIndexOfGCardNox);
        }
        _item.setGCardNox(_tmpGCardNox);
        final String _tmpCardNmbr;
        if (_cursor.isNull(_cursorIndexOfCardNmbr)) {
          _tmpCardNmbr = null;
        } else {
          _tmpCardNmbr = _cursor.getString(_cursorIndexOfCardNmbr);
        }
        _item.setCardNmbr(_tmpCardNmbr);
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _item.setUserIDxx(_tmpUserIDxx);
        final String _tmpNmOnCard;
        if (_cursor.isNull(_cursorIndexOfNmOnCard)) {
          _tmpNmOnCard = null;
        } else {
          _tmpNmOnCard = _cursor.getString(_cursorIndexOfNmOnCard);
        }
        _item.setNmOnCard(_tmpNmOnCard);
        final String _tmpMemberxx;
        if (_cursor.isNull(_cursorIndexOfMemberxx)) {
          _tmpMemberxx = null;
        } else {
          _tmpMemberxx = _cursor.getString(_cursorIndexOfMemberxx);
        }
        _item.setMemberxx(_tmpMemberxx);
        final String _tmpCardType;
        if (_cursor.isNull(_cursorIndexOfCardType)) {
          _tmpCardType = null;
        } else {
          _tmpCardType = _cursor.getString(_cursorIndexOfCardType);
        }
        _item.setCardType(_tmpCardType);
        final String _tmpTotPoint;
        if (_cursor.isNull(_cursorIndexOfTotPoint)) {
          _tmpTotPoint = null;
        } else {
          _tmpTotPoint = _cursor.getString(_cursorIndexOfTotPoint);
        }
        _item.setTotPoint(_tmpTotPoint);
        final String _tmpAvlPoint;
        if (_cursor.isNull(_cursorIndexOfAvlPoint)) {
          _tmpAvlPoint = null;
        } else {
          _tmpAvlPoint = _cursor.getString(_cursorIndexOfAvlPoint);
        }
        _item.setAvlPoint(_tmpAvlPoint);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpActvStat;
        if (_cursor.isNull(_cursorIndexOfActvStat)) {
          _tmpActvStat = null;
        } else {
          _tmpActvStat = _cursor.getString(_cursorIndexOfActvStat);
        }
        _item.setActvStat(_tmpActvStat);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        final String _tmpNotified;
        if (_cursor.isNull(_cursorIndexOfNotified)) {
          _tmpNotified = null;
        } else {
          _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
        }
        _item.setNotified(_tmpNotified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getGCardTotPoints(final String CardNmbr) {
    final String _sql = "SELECT sAvlPoint FROM Gcard_App_Master WHERE sCardNmbr =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (CardNmbr == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, CardNmbr);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getOrderPoints(final String GCardNox) {
    final String _sql = "SELECT SUM(nPointsxx) FROM redeem_item WHERE sGCardNox =? AND cTranStat IN ('0', '1')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (GCardNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, GCardNox);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<String> getActiveGcardNo() {
    final String _sql = "SELECT sGCardNox FROM Gcard_App_Master WHERE cActvStat = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Gcard_App_Master"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<String> getActiveGcardAvlPoints() {
    final String _sql = "SELECT sAvlPoint FROM GCard_App_Master WHERE cActvStat ='1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"GCard_App_Master"}, false, new Callable<String>() {
      @Override
      public String call() throws Exception {
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public double getRemainingActiveCardPoints() {
    final String _sql = "SELECT (SELECT sAvlPoint FROM GCard_App_Master WHERE cActvStat = '1') - (SELECT nPointsxx FROM Redeem_Item WHERE sGCardNox = (SELECT sGCardNox FROM GCard_App_Master WHERE cActvStat = '1')) AS RemainingPoints";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getAvailableGcardPoints() {
    final String _sql = "SELECT sAvlPoint FROM GCard_App_Master WHERE cActvStat = '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double getRedeemItemPoints() {
    final String _sql = "SELECT nPointsxx FROM Redeem_Item WHERE sGCardNox = (SELECT sGCardNox FROM GCard_App_Master WHERE cActvStat = '1') AND cTranStat IN (0, 1)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
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
