package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

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
import org.rmj.g3appdriver.GConnect.room.Entities.EPromo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DPromo_Impl implements DPromo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EPromo> __insertionAdapterOfEPromo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateReadPromo;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePromoInfo;

  public DPromo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEPromo = new EntityInsertionAdapter<EPromo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Promo_Link_Info` (`sTransNox`,`dTransact`,`dDateFrom`,`dDateThru`,`sCaptionx`,`sImageUrl`,`sImageSld`,`sImgeByte`,`sPromoUrl`,`cNotified`,`cDivision`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPromo value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTransact());
        }
        if (value.getDateFrom() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDateFrom());
        }
        if (value.getDateThru() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDateThru());
        }
        if (value.getCaptionx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCaptionx());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImageUrl());
        }
        if (value.getImageSld() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getImageSld());
        }
        if (value.getImgeByte() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getImgeByte());
        }
        if (value.getPromoUrl() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPromoUrl());
        }
        if (value.getNotified() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getNotified());
        }
        stmt.bindLong(11, value.getDivision());
        if (value.getRecdStat() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getTimeStmp());
        }
      }
    };
    this.__preparedStmtOfUpdateReadPromo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE App_Event_Info SET cNotified = '1', dModified =? WHERE sTransNox =? ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePromoInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE PROMO_LINK_INFO SET dTransact=?, dDateFrom=?, dDateThru=?, sCaptionx=?, sImageUrl=?, sImageSld=?, cRecdStat=?, dTimeStmp=?, sPromoUrl=?, cDivision=?  WHERE sTransNox=?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EPromo ePromo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEPromo.insert(ePromo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateReadPromo(final String date, final String transNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateReadPromo.acquire();
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
      __preparedStmtOfUpdateReadPromo.release(_stmt);
    }
  }

  @Override
  public void UpdatePromoInfo(final String Transact, final String DateFrom, final String DateThru,
      final String Captionx, final String ImageUrl, final String RecdStat, final String ImageSld,
      final String TimeStmp, final String PromoUrl, final String Division, final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePromoInfo.acquire();
    int _argIndex = 1;
    if (Transact == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Transact);
    }
    _argIndex = 2;
    if (DateFrom == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateFrom);
    }
    _argIndex = 3;
    if (DateThru == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateThru);
    }
    _argIndex = 4;
    if (Captionx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Captionx);
    }
    _argIndex = 5;
    if (ImageUrl == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ImageUrl);
    }
    _argIndex = 6;
    if (ImageSld == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ImageSld);
    }
    _argIndex = 7;
    if (RecdStat == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, RecdStat);
    }
    _argIndex = 8;
    if (TimeStmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TimeStmp);
    }
    _argIndex = 9;
    if (PromoUrl == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, PromoUrl);
    }
    _argIndex = 10;
    if (Division == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Division);
    }
    _argIndex = 11;
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
      __preparedStmtOfUpdatePromoInfo.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EPromo>> getAllPromo() {
    final String _sql = "SELECT * FROM Promo_Link_Info WHERE strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dDateFrom AND dDateThru";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Promo_Link_Info"}, false, new Callable<List<EPromo>>() {
      @Override
      public List<EPromo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
          final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
          final int _cursorIndexOfCaptionx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCaptionx");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageUrl");
          final int _cursorIndexOfImageSld = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageSld");
          final int _cursorIndexOfImgeByte = CursorUtil.getColumnIndexOrThrow(_cursor, "sImgeByte");
          final int _cursorIndexOfPromoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sPromoUrl");
          final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EPromo> _result = new ArrayList<EPromo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EPromo _item;
            _item = new EPromo();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpDateFrom;
            if (_cursor.isNull(_cursorIndexOfDateFrom)) {
              _tmpDateFrom = null;
            } else {
              _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
            }
            _item.setDateFrom(_tmpDateFrom);
            final String _tmpDateThru;
            if (_cursor.isNull(_cursorIndexOfDateThru)) {
              _tmpDateThru = null;
            } else {
              _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
            }
            _item.setDateThru(_tmpDateThru);
            final String _tmpCaptionx;
            if (_cursor.isNull(_cursorIndexOfCaptionx)) {
              _tmpCaptionx = null;
            } else {
              _tmpCaptionx = _cursor.getString(_cursorIndexOfCaptionx);
            }
            _item.setCaptionx(_tmpCaptionx);
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            _item.setImageUrl(_tmpImageUrl);
            final String _tmpImageSld;
            if (_cursor.isNull(_cursorIndexOfImageSld)) {
              _tmpImageSld = null;
            } else {
              _tmpImageSld = _cursor.getString(_cursorIndexOfImageSld);
            }
            _item.setImageSld(_tmpImageSld);
            final String _tmpImgeByte;
            if (_cursor.isNull(_cursorIndexOfImgeByte)) {
              _tmpImgeByte = null;
            } else {
              _tmpImgeByte = _cursor.getString(_cursorIndexOfImgeByte);
            }
            _item.setImgeByte(_tmpImgeByte);
            final String _tmpPromoUrl;
            if (_cursor.isNull(_cursorIndexOfPromoUrl)) {
              _tmpPromoUrl = null;
            } else {
              _tmpPromoUrl = _cursor.getString(_cursorIndexOfPromoUrl);
            }
            _item.setPromoUrl(_tmpPromoUrl);
            final String _tmpNotified;
            if (_cursor.isNull(_cursorIndexOfNotified)) {
              _tmpNotified = null;
            } else {
              _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
            }
            _item.setNotified(_tmpNotified);
            final int _tmpDivision;
            _tmpDivision = _cursor.getInt(_cursorIndexOfDivision);
            _item.setDivision(_tmpDivision);
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
  public List<EPromo> getAllPromoForDownloadImg() {
    final String _sql = "SELECT * FROM Promo_Link_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
      final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
      final int _cursorIndexOfCaptionx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCaptionx");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageUrl");
      final int _cursorIndexOfImageSld = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageSld");
      final int _cursorIndexOfImgeByte = CursorUtil.getColumnIndexOrThrow(_cursor, "sImgeByte");
      final int _cursorIndexOfPromoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sPromoUrl");
      final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<EPromo> _result = new ArrayList<EPromo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EPromo _item;
        _item = new EPromo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpDateFrom;
        if (_cursor.isNull(_cursorIndexOfDateFrom)) {
          _tmpDateFrom = null;
        } else {
          _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
        }
        _item.setDateFrom(_tmpDateFrom);
        final String _tmpDateThru;
        if (_cursor.isNull(_cursorIndexOfDateThru)) {
          _tmpDateThru = null;
        } else {
          _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
        }
        _item.setDateThru(_tmpDateThru);
        final String _tmpCaptionx;
        if (_cursor.isNull(_cursorIndexOfCaptionx)) {
          _tmpCaptionx = null;
        } else {
          _tmpCaptionx = _cursor.getString(_cursorIndexOfCaptionx);
        }
        _item.setCaptionx(_tmpCaptionx);
        final String _tmpImageUrl;
        if (_cursor.isNull(_cursorIndexOfImageUrl)) {
          _tmpImageUrl = null;
        } else {
          _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        }
        _item.setImageUrl(_tmpImageUrl);
        final String _tmpImageSld;
        if (_cursor.isNull(_cursorIndexOfImageSld)) {
          _tmpImageSld = null;
        } else {
          _tmpImageSld = _cursor.getString(_cursorIndexOfImageSld);
        }
        _item.setImageSld(_tmpImageSld);
        final String _tmpImgeByte;
        if (_cursor.isNull(_cursorIndexOfImgeByte)) {
          _tmpImgeByte = null;
        } else {
          _tmpImgeByte = _cursor.getString(_cursorIndexOfImgeByte);
        }
        _item.setImgeByte(_tmpImgeByte);
        final String _tmpPromoUrl;
        if (_cursor.isNull(_cursorIndexOfPromoUrl)) {
          _tmpPromoUrl = null;
        } else {
          _tmpPromoUrl = _cursor.getString(_cursorIndexOfPromoUrl);
        }
        _item.setPromoUrl(_tmpPromoUrl);
        final String _tmpNotified;
        if (_cursor.isNull(_cursorIndexOfNotified)) {
          _tmpNotified = null;
        } else {
          _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
        }
        _item.setNotified(_tmpNotified);
        final int _tmpDivision;
        _tmpDivision = _cursor.getInt(_cursorIndexOfDivision);
        _item.setDivision(_tmpDivision);
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
      _statement.release();
    }
  }

  @Override
  public LiveData<Integer> getPromoCount() {
    final String _sql = "SELECT COUNT(*) FROM Promo_Link_Info WHERE cNotified = '0' AND strftime('%Y-%m-%d %H:%H:%S', datetime('now', 'localtime'))  BETWEEN dDateFrom AND dDateThru";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Promo_Link_Info"}, false, new Callable<Integer>() {
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
  public boolean getPromoExist(final String TransNox) {
    final String _sql = "SELECT EXISTS(SELECT * FROM Promo_Link_Info WHERE sTransNox =? AND cNotified = '1')";
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
  public EPromo getPromoInfoIfExist(final String TransNox) {
    final String _sql = "SELECT * FROM PROMO_LINK_INFO WHERE sTransNox =?";
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
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
      final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
      final int _cursorIndexOfCaptionx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCaptionx");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageUrl");
      final int _cursorIndexOfImageSld = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageSld");
      final int _cursorIndexOfImgeByte = CursorUtil.getColumnIndexOrThrow(_cursor, "sImgeByte");
      final int _cursorIndexOfPromoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sPromoUrl");
      final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EPromo _result;
      if(_cursor.moveToFirst()) {
        _result = new EPromo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpDateFrom;
        if (_cursor.isNull(_cursorIndexOfDateFrom)) {
          _tmpDateFrom = null;
        } else {
          _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
        }
        _result.setDateFrom(_tmpDateFrom);
        final String _tmpDateThru;
        if (_cursor.isNull(_cursorIndexOfDateThru)) {
          _tmpDateThru = null;
        } else {
          _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
        }
        _result.setDateThru(_tmpDateThru);
        final String _tmpCaptionx;
        if (_cursor.isNull(_cursorIndexOfCaptionx)) {
          _tmpCaptionx = null;
        } else {
          _tmpCaptionx = _cursor.getString(_cursorIndexOfCaptionx);
        }
        _result.setCaptionx(_tmpCaptionx);
        final String _tmpImageUrl;
        if (_cursor.isNull(_cursorIndexOfImageUrl)) {
          _tmpImageUrl = null;
        } else {
          _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        }
        _result.setImageUrl(_tmpImageUrl);
        final String _tmpImageSld;
        if (_cursor.isNull(_cursorIndexOfImageSld)) {
          _tmpImageSld = null;
        } else {
          _tmpImageSld = _cursor.getString(_cursorIndexOfImageSld);
        }
        _result.setImageSld(_tmpImageSld);
        final String _tmpImgeByte;
        if (_cursor.isNull(_cursorIndexOfImgeByte)) {
          _tmpImgeByte = null;
        } else {
          _tmpImgeByte = _cursor.getString(_cursorIndexOfImgeByte);
        }
        _result.setImgeByte(_tmpImgeByte);
        final String _tmpPromoUrl;
        if (_cursor.isNull(_cursorIndexOfPromoUrl)) {
          _tmpPromoUrl = null;
        } else {
          _tmpPromoUrl = _cursor.getString(_cursorIndexOfPromoUrl);
        }
        _result.setPromoUrl(_tmpPromoUrl);
        final String _tmpNotified;
        if (_cursor.isNull(_cursorIndexOfNotified)) {
          _tmpNotified = null;
        } else {
          _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
        }
        _result.setNotified(_tmpNotified);
        final int _tmpDivision;
        _tmpDivision = _cursor.getInt(_cursorIndexOfDivision);
        _result.setDivision(_tmpDivision);
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
  public EPromo CheckPromo() {
    final String _sql = "SELECT * FROM Promo_Link_Info ORDER BY dDateFrom DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfDateFrom = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateFrom");
      final int _cursorIndexOfDateThru = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateThru");
      final int _cursorIndexOfCaptionx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCaptionx");
      final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageUrl");
      final int _cursorIndexOfImageSld = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageSld");
      final int _cursorIndexOfImgeByte = CursorUtil.getColumnIndexOrThrow(_cursor, "sImgeByte");
      final int _cursorIndexOfPromoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "sPromoUrl");
      final int _cursorIndexOfNotified = CursorUtil.getColumnIndexOrThrow(_cursor, "cNotified");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EPromo _result;
      if(_cursor.moveToFirst()) {
        _result = new EPromo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpDateFrom;
        if (_cursor.isNull(_cursorIndexOfDateFrom)) {
          _tmpDateFrom = null;
        } else {
          _tmpDateFrom = _cursor.getString(_cursorIndexOfDateFrom);
        }
        _result.setDateFrom(_tmpDateFrom);
        final String _tmpDateThru;
        if (_cursor.isNull(_cursorIndexOfDateThru)) {
          _tmpDateThru = null;
        } else {
          _tmpDateThru = _cursor.getString(_cursorIndexOfDateThru);
        }
        _result.setDateThru(_tmpDateThru);
        final String _tmpCaptionx;
        if (_cursor.isNull(_cursorIndexOfCaptionx)) {
          _tmpCaptionx = null;
        } else {
          _tmpCaptionx = _cursor.getString(_cursorIndexOfCaptionx);
        }
        _result.setCaptionx(_tmpCaptionx);
        final String _tmpImageUrl;
        if (_cursor.isNull(_cursorIndexOfImageUrl)) {
          _tmpImageUrl = null;
        } else {
          _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
        }
        _result.setImageUrl(_tmpImageUrl);
        final String _tmpImageSld;
        if (_cursor.isNull(_cursorIndexOfImageSld)) {
          _tmpImageSld = null;
        } else {
          _tmpImageSld = _cursor.getString(_cursorIndexOfImageSld);
        }
        _result.setImageSld(_tmpImageSld);
        final String _tmpImgeByte;
        if (_cursor.isNull(_cursorIndexOfImgeByte)) {
          _tmpImgeByte = null;
        } else {
          _tmpImgeByte = _cursor.getString(_cursorIndexOfImgeByte);
        }
        _result.setImgeByte(_tmpImgeByte);
        final String _tmpPromoUrl;
        if (_cursor.isNull(_cursorIndexOfPromoUrl)) {
          _tmpPromoUrl = null;
        } else {
          _tmpPromoUrl = _cursor.getString(_cursorIndexOfPromoUrl);
        }
        _result.setPromoUrl(_tmpPromoUrl);
        final String _tmpNotified;
        if (_cursor.isNull(_cursorIndexOfNotified)) {
          _tmpNotified = null;
        } else {
          _tmpNotified = _cursor.getString(_cursorIndexOfNotified);
        }
        _result.setNotified(_tmpNotified);
        final int _tmpDivision;
        _tmpDivision = _cursor.getInt(_cursorIndexOfDivision);
        _result.setDivision(_tmpDivision);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
