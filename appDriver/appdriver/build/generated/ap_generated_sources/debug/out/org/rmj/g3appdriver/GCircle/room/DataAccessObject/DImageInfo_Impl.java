package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

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
import org.rmj.g3appdriver.GCircle.room.Entities.EImageInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DImageInfo_Impl implements DImageInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EImageInfo> __insertionAdapterOfEImageInfo;

  private final EntityDeletionOrUpdateAdapter<EImageInfo> __updateAdapterOfEImageInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateImageInfo;

  public DImageInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEImageInfo = new EntityInsertionAdapter<EImageInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Image_Information` (`sTransNox`,`sSourceCD`,`sSourceNo`,`sDtlSrcNo`,`sFileCode`,`sImageNme`,`sMD5Hashx`,`sFileLoct`,`nLatitude`,`nLongitud`,`dCaptured`,`cSendStat`,`dSendDate`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EImageInfo value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getSourceCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSourceCD());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSourceNo());
        }
        if (value.getDtlSrcNo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDtlSrcNo());
        }
        if (value.getFileCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFileCode());
        }
        if (value.getImageNme() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImageNme());
        }
        if (value.getMD5Hashx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMD5Hashx());
        }
        if (value.getFileLoct() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFileLoct());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLatitude());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getLongitud());
        }
        if (value.getCaptured() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCaptured());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getSendDate());
        }
      }
    };
    this.__updateAdapterOfEImageInfo = new EntityDeletionOrUpdateAdapter<EImageInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `Image_Information` SET `sTransNox` = ?,`sSourceCD` = ?,`sSourceNo` = ?,`sDtlSrcNo` = ?,`sFileCode` = ?,`sImageNme` = ?,`sMD5Hashx` = ?,`sFileLoct` = ?,`nLatitude` = ?,`nLongitud` = ?,`dCaptured` = ?,`cSendStat` = ?,`dSendDate` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EImageInfo value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getSourceCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSourceCD());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSourceNo());
        }
        if (value.getDtlSrcNo() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDtlSrcNo());
        }
        if (value.getFileCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getFileCode());
        }
        if (value.getImageNme() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImageNme());
        }
        if (value.getMD5Hashx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMD5Hashx());
        }
        if (value.getFileLoct() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFileLoct());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLatitude());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getLongitud());
        }
        if (value.getCaptured() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCaptured());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSendStat());
        }
        if (value.getSendDate() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getSendDate());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateImageInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Image_Information SET sTransNox =?, cSendStat = '1', dSendDate =? WHERE sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void SaveImageInfo(final EImageInfo imageInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEImageInfo.insert(imageInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EImageInfo imageInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEImageInfo.handle(imageInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateImageInfo(final String TransNox, final String DateModifield,
      final String oldTransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateImageInfo.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (DateModifield == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateModifield);
    }
    _argIndex = 3;
    if (oldTransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, oldTransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateImageInfo.release(_stmt);
    }
  }

  @Override
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT (*) FROM Image_Information";
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
  public EImageInfo GetImageInfo(final String TransNox) {
    final String _sql = "SELECT * FROM Image_Information WHERE sTransNox =?";
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
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfMD5Hashx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMD5Hashx");
      final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfCaptured = CursorUtil.getColumnIndexOrThrow(_cursor, "dCaptured");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final EImageInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EImageInfo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _result.setSourceCD(_tmpSourceCD);
        final String _tmpSourceNo;
        if (_cursor.isNull(_cursorIndexOfSourceNo)) {
          _tmpSourceNo = null;
        } else {
          _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
        }
        _result.setSourceNo(_tmpSourceNo);
        final String _tmpDtlSrcNo;
        if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
          _tmpDtlSrcNo = null;
        } else {
          _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
        }
        _result.setDtlSrcNo(_tmpDtlSrcNo);
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _result.setFileCode(_tmpFileCode);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
        final String _tmpMD5Hashx;
        if (_cursor.isNull(_cursorIndexOfMD5Hashx)) {
          _tmpMD5Hashx = null;
        } else {
          _tmpMD5Hashx = _cursor.getString(_cursorIndexOfMD5Hashx);
        }
        _result.setMD5Hashx(_tmpMD5Hashx);
        final String _tmpFileLoct;
        if (_cursor.isNull(_cursorIndexOfFileLoct)) {
          _tmpFileLoct = null;
        } else {
          _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
        }
        _result.setFileLoct(_tmpFileLoct);
        final String _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final String _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
        }
        _result.setLongitud(_tmpLongitud);
        final String _tmpCaptured;
        if (_cursor.isNull(_cursorIndexOfCaptured)) {
          _tmpCaptured = null;
        } else {
          _tmpCaptured = _cursor.getString(_cursorIndexOfCaptured);
        }
        _result.setCaptured(_tmpCaptured);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
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
  public LiveData<List<EImageInfo>> getUnsentDCPImageInfoList() {
    final String _sql = "SELECT * FROM Image_Information WHERE cSendStat = 0 AND sSourceNo = (SELECT sTransNox FROM LR_DCP_Collection_Master ORDER BY dTransact DESC LIMIT 1) AND sFileCode = (SELECT sFileCode FROM EDocSys_File WHERE sBarrcode = 'DCP001')";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Image_Information","LR_DCP_Collection_Master","EDocSys_File"}, false, new Callable<List<EImageInfo>>() {
      @Override
      public List<EImageInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
          final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfMD5Hashx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMD5Hashx");
          final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfCaptured = CursorUtil.getColumnIndexOrThrow(_cursor, "dCaptured");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final List<EImageInfo> _result = new ArrayList<EImageInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EImageInfo _item;
            _item = new EImageInfo();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpSourceCD;
            if (_cursor.isNull(_cursorIndexOfSourceCD)) {
              _tmpSourceCD = null;
            } else {
              _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
            }
            _item.setSourceCD(_tmpSourceCD);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _item.setSourceNo(_tmpSourceNo);
            final String _tmpDtlSrcNo;
            if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
              _tmpDtlSrcNo = null;
            } else {
              _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
            }
            _item.setDtlSrcNo(_tmpDtlSrcNo);
            final String _tmpFileCode;
            if (_cursor.isNull(_cursorIndexOfFileCode)) {
              _tmpFileCode = null;
            } else {
              _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
            }
            _item.setFileCode(_tmpFileCode);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _item.setImageNme(_tmpImageNme);
            final String _tmpMD5Hashx;
            if (_cursor.isNull(_cursorIndexOfMD5Hashx)) {
              _tmpMD5Hashx = null;
            } else {
              _tmpMD5Hashx = _cursor.getString(_cursorIndexOfMD5Hashx);
            }
            _item.setMD5Hashx(_tmpMD5Hashx);
            final String _tmpFileLoct;
            if (_cursor.isNull(_cursorIndexOfFileLoct)) {
              _tmpFileLoct = null;
            } else {
              _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
            }
            _item.setFileLoct(_tmpFileLoct);
            final String _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
            }
            _item.setLatitude(_tmpLatitude);
            final String _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
            }
            _item.setLongitud(_tmpLongitud);
            final String _tmpCaptured;
            if (_cursor.isNull(_cursorIndexOfCaptured)) {
              _tmpCaptured = null;
            } else {
              _tmpCaptured = _cursor.getString(_cursorIndexOfCaptured);
            }
            _item.setCaptured(_tmpCaptured);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _item.setSendDate(_tmpSendDate);
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
  public LiveData<EImageInfo> getImageLocation(final String sDtlSrcNo, final String sImageNme) {
    final String _sql = "SELECT * FROM Image_Information WHERE sDtlSrcNo = ? AND sImageNme = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (sDtlSrcNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sDtlSrcNo);
    }
    _argIndex = 2;
    if (sImageNme == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sImageNme);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Image_Information"}, false, new Callable<EImageInfo>() {
      @Override
      public EImageInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
          final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
          final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
          final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
          final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
          final int _cursorIndexOfMD5Hashx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMD5Hashx");
          final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfCaptured = CursorUtil.getColumnIndexOrThrow(_cursor, "dCaptured");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final EImageInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EImageInfo();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpSourceCD;
            if (_cursor.isNull(_cursorIndexOfSourceCD)) {
              _tmpSourceCD = null;
            } else {
              _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
            }
            _result.setSourceCD(_tmpSourceCD);
            final String _tmpSourceNo;
            if (_cursor.isNull(_cursorIndexOfSourceNo)) {
              _tmpSourceNo = null;
            } else {
              _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
            }
            _result.setSourceNo(_tmpSourceNo);
            final String _tmpDtlSrcNo;
            if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
              _tmpDtlSrcNo = null;
            } else {
              _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
            }
            _result.setDtlSrcNo(_tmpDtlSrcNo);
            final String _tmpFileCode;
            if (_cursor.isNull(_cursorIndexOfFileCode)) {
              _tmpFileCode = null;
            } else {
              _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
            }
            _result.setFileCode(_tmpFileCode);
            final String _tmpImageNme;
            if (_cursor.isNull(_cursorIndexOfImageNme)) {
              _tmpImageNme = null;
            } else {
              _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
            }
            _result.setImageNme(_tmpImageNme);
            final String _tmpMD5Hashx;
            if (_cursor.isNull(_cursorIndexOfMD5Hashx)) {
              _tmpMD5Hashx = null;
            } else {
              _tmpMD5Hashx = _cursor.getString(_cursorIndexOfMD5Hashx);
            }
            _result.setMD5Hashx(_tmpMD5Hashx);
            final String _tmpFileLoct;
            if (_cursor.isNull(_cursorIndexOfFileLoct)) {
              _tmpFileLoct = null;
            } else {
              _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
            }
            _result.setFileLoct(_tmpFileLoct);
            final String _tmpLatitude;
            if (_cursor.isNull(_cursorIndexOfLatitude)) {
              _tmpLatitude = null;
            } else {
              _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
            }
            _result.setLatitude(_tmpLatitude);
            final String _tmpLongitud;
            if (_cursor.isNull(_cursorIndexOfLongitud)) {
              _tmpLongitud = null;
            } else {
              _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
            }
            _result.setLongitud(_tmpLongitud);
            final String _tmpCaptured;
            if (_cursor.isNull(_cursorIndexOfCaptured)) {
              _tmpCaptured = null;
            } else {
              _tmpCaptured = _cursor.getString(_cursorIndexOfCaptured);
            }
            _result.setCaptured(_tmpCaptured);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
            final String _tmpSendDate;
            if (_cursor.isNull(_cursorIndexOfSendDate)) {
              _tmpSendDate = null;
            } else {
              _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
            }
            _result.setSendDate(_tmpSendDate);
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
  public String GetImageFileLocation(final String TrasNox) {
    final String _sql = "SELECT sFileLoct FROM Image_Information WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TrasNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TrasNox);
    }
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
  public List<EImageInfo> getUnsentLoginImageInfo() {
    final String _sql = "SELECT * FROM Image_Information WHERE sFileCode = '0021' AND cSendStat <> '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfMD5Hashx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMD5Hashx");
      final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfCaptured = CursorUtil.getColumnIndexOrThrow(_cursor, "dCaptured");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final List<EImageInfo> _result = new ArrayList<EImageInfo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EImageInfo _item;
        _item = new EImageInfo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _item.setSourceCD(_tmpSourceCD);
        final String _tmpSourceNo;
        if (_cursor.isNull(_cursorIndexOfSourceNo)) {
          _tmpSourceNo = null;
        } else {
          _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
        }
        _item.setSourceNo(_tmpSourceNo);
        final String _tmpDtlSrcNo;
        if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
          _tmpDtlSrcNo = null;
        } else {
          _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
        }
        _item.setDtlSrcNo(_tmpDtlSrcNo);
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _item.setFileCode(_tmpFileCode);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final String _tmpMD5Hashx;
        if (_cursor.isNull(_cursorIndexOfMD5Hashx)) {
          _tmpMD5Hashx = null;
        } else {
          _tmpMD5Hashx = _cursor.getString(_cursorIndexOfMD5Hashx);
        }
        _item.setMD5Hashx(_tmpMD5Hashx);
        final String _tmpFileLoct;
        if (_cursor.isNull(_cursorIndexOfFileLoct)) {
          _tmpFileLoct = null;
        } else {
          _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
        }
        _item.setFileLoct(_tmpFileLoct);
        final String _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final String _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
        }
        _item.setLongitud(_tmpLongitud);
        final String _tmpCaptured;
        if (_cursor.isNull(_cursorIndexOfCaptured)) {
          _tmpCaptured = null;
        } else {
          _tmpCaptured = _cursor.getString(_cursorIndexOfCaptured);
        }
        _item.setCaptured(_tmpCaptured);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _item.setSendDate(_tmpSendDate);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public EImageInfo CheckImageForCIExist(final String fsSource, final String fsDetail) {
    final String _sql = "SELECT * FROM Image_Information WHERE sSourceNo =? AND sDtlSrcNo =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsSource == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsSource);
    }
    _argIndex = 2;
    if (fsDetail == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsDetail);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfMD5Hashx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMD5Hashx");
      final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfCaptured = CursorUtil.getColumnIndexOrThrow(_cursor, "dCaptured");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final EImageInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EImageInfo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _result.setSourceCD(_tmpSourceCD);
        final String _tmpSourceNo;
        if (_cursor.isNull(_cursorIndexOfSourceNo)) {
          _tmpSourceNo = null;
        } else {
          _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
        }
        _result.setSourceNo(_tmpSourceNo);
        final String _tmpDtlSrcNo;
        if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
          _tmpDtlSrcNo = null;
        } else {
          _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
        }
        _result.setDtlSrcNo(_tmpDtlSrcNo);
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _result.setFileCode(_tmpFileCode);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
        final String _tmpMD5Hashx;
        if (_cursor.isNull(_cursorIndexOfMD5Hashx)) {
          _tmpMD5Hashx = null;
        } else {
          _tmpMD5Hashx = _cursor.getString(_cursorIndexOfMD5Hashx);
        }
        _result.setMD5Hashx(_tmpMD5Hashx);
        final String _tmpFileLoct;
        if (_cursor.isNull(_cursorIndexOfFileLoct)) {
          _tmpFileLoct = null;
        } else {
          _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
        }
        _result.setFileLoct(_tmpFileLoct);
        final String _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final String _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
        }
        _result.setLongitud(_tmpLongitud);
        final String _tmpCaptured;
        if (_cursor.isNull(_cursorIndexOfCaptured)) {
          _tmpCaptured = null;
        } else {
          _tmpCaptured = _cursor.getString(_cursorIndexOfCaptured);
        }
        _result.setCaptured(_tmpCaptured);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
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
  public EImageInfo CheckCreditAppDocumentIfExist(final String fsSource, final String FileCode) {
    final String _sql = "SELECT * FROM Image_Information WHERE sSourceNo =? AND sFileCode =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (fsSource == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsSource);
    }
    _argIndex = 2;
    if (FileCode == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, FileCode);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfMD5Hashx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMD5Hashx");
      final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfCaptured = CursorUtil.getColumnIndexOrThrow(_cursor, "dCaptured");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final EImageInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EImageInfo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _result.setSourceCD(_tmpSourceCD);
        final String _tmpSourceNo;
        if (_cursor.isNull(_cursorIndexOfSourceNo)) {
          _tmpSourceNo = null;
        } else {
          _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
        }
        _result.setSourceNo(_tmpSourceNo);
        final String _tmpDtlSrcNo;
        if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
          _tmpDtlSrcNo = null;
        } else {
          _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
        }
        _result.setDtlSrcNo(_tmpDtlSrcNo);
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _result.setFileCode(_tmpFileCode);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
        final String _tmpMD5Hashx;
        if (_cursor.isNull(_cursorIndexOfMD5Hashx)) {
          _tmpMD5Hashx = null;
        } else {
          _tmpMD5Hashx = _cursor.getString(_cursorIndexOfMD5Hashx);
        }
        _result.setMD5Hashx(_tmpMD5Hashx);
        final String _tmpFileLoct;
        if (_cursor.isNull(_cursorIndexOfFileLoct)) {
          _tmpFileLoct = null;
        } else {
          _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
        }
        _result.setFileLoct(_tmpFileLoct);
        final String _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final String _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
        }
        _result.setLongitud(_tmpLongitud);
        final String _tmpCaptured;
        if (_cursor.isNull(_cursorIndexOfCaptured)) {
          _tmpCaptured = null;
        } else {
          _tmpCaptured = _cursor.getString(_cursorIndexOfCaptured);
        }
        _result.setCaptured(_tmpCaptured);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
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
  public EImageInfo getDCPImageInfoForPosting(final String TransNox, final String AccntNo) {
    final String _sql = "SELECT * FROM Image_Information WHERE sSourceNo =? AND sDtlSrcNo=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (AccntNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, AccntNo);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfMD5Hashx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMD5Hashx");
      final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfCaptured = CursorUtil.getColumnIndexOrThrow(_cursor, "dCaptured");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final EImageInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EImageInfo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _result.setSourceCD(_tmpSourceCD);
        final String _tmpSourceNo;
        if (_cursor.isNull(_cursorIndexOfSourceNo)) {
          _tmpSourceNo = null;
        } else {
          _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
        }
        _result.setSourceNo(_tmpSourceNo);
        final String _tmpDtlSrcNo;
        if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
          _tmpDtlSrcNo = null;
        } else {
          _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
        }
        _result.setDtlSrcNo(_tmpDtlSrcNo);
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _result.setFileCode(_tmpFileCode);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
        final String _tmpMD5Hashx;
        if (_cursor.isNull(_cursorIndexOfMD5Hashx)) {
          _tmpMD5Hashx = null;
        } else {
          _tmpMD5Hashx = _cursor.getString(_cursorIndexOfMD5Hashx);
        }
        _result.setMD5Hashx(_tmpMD5Hashx);
        final String _tmpFileLoct;
        if (_cursor.isNull(_cursorIndexOfFileLoct)) {
          _tmpFileLoct = null;
        } else {
          _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
        }
        _result.setFileLoct(_tmpFileLoct);
        final String _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
        }
        _result.setLatitude(_tmpLatitude);
        final String _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
        }
        _result.setLongitud(_tmpLongitud);
        final String _tmpCaptured;
        if (_cursor.isNull(_cursorIndexOfCaptured)) {
          _tmpCaptured = null;
        } else {
          _tmpCaptured = _cursor.getString(_cursorIndexOfCaptured);
        }
        _result.setCaptured(_tmpCaptured);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpSendDate;
        if (_cursor.isNull(_cursorIndexOfSendDate)) {
          _tmpSendDate = null;
        } else {
          _tmpSendDate = _cursor.getString(_cursorIndexOfSendDate);
        }
        _result.setSendDate(_tmpSendDate);
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
