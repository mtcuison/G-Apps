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
import org.rmj.g3appdriver.GCircle.room.Entities.ECreditApplicationDocuments;
import org.rmj.g3appdriver.GCircle.room.Entities.EFileCode;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DFileCode_Impl implements DFileCode {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EFileCode> __insertionAdapterOfEFileCode;

  private final EntityDeletionOrUpdateAdapter<EFileCode> __updateAdapterOfEFileCode;

  private final EntityDeletionOrUpdateAdapter<ECreditApplicationDocuments> __updateAdapterOfECreditApplicationDocuments;

  private final SharedSQLiteStatement __preparedStmtOfInitializeDocumentsList;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDocumentsList;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCheckedFile;

  public DFileCode_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEFileCode = new EntityInsertionAdapter<EFileCode>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `EDocSys_File` (`sFileCode`,`sBarrcode`,`sBriefDsc`,`cRecdStat`,`nEntryNox`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EFileCode value) {
        if (value.getFileCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getFileCode());
        }
        if (value.getBarrcode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBarrcode());
        }
        if (value.getBriefDsc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBriefDsc());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRecdStat());
        }
        stmt.bindLong(5, value.getEntryNox());
        if (value.getTimeStmp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLstUpdte());
        }
      }
    };
    this.__updateAdapterOfEFileCode = new EntityDeletionOrUpdateAdapter<EFileCode>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `EDocSys_File` SET `sFileCode` = ?,`sBarrcode` = ?,`sBriefDsc` = ?,`cRecdStat` = ?,`nEntryNox` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sFileCode` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EFileCode value) {
        if (value.getFileCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getFileCode());
        }
        if (value.getBarrcode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBarrcode());
        }
        if (value.getBriefDsc() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBriefDsc());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRecdStat());
        }
        stmt.bindLong(5, value.getEntryNox());
        if (value.getTimeStmp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getLstUpdte());
        }
        if (value.getFileCode() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getFileCode());
        }
      }
    };
    this.__updateAdapterOfECreditApplicationDocuments = new EntityDeletionOrUpdateAdapter<ECreditApplicationDocuments>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Credit_Online_Application_Documents` SET `sTransNox` = ?,`sFileCode` = ?,`nEntryNox` = ?,`sImageNme` = ?,`sImageIDx` = ?,`sFileLoct` = ?,`cSendStat` = ? WHERE `sTransNox` = ? AND `sFileCode` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECreditApplicationDocuments value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getFileCode() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFileCode());
        }
        stmt.bindLong(3, value.getEntryNox());
        if (value.getImageNme() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getImageNme());
        }
        if (value.getImageIDx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getImageIDx());
        }
        if (value.getFileLoct() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFileLoct());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSendStat());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTransNox());
        }
        if (value.getFileCode() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getFileCode());
        }
      }
    };
    this.__preparedStmtOfInitializeDocumentsList = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "INSERT INTO Credit_Online_Application_Documents (sTransNox, sFileCode, nEntryNox) SELECT a.sTransNox, b.sFileCode, b.nEntryNox FROM Credit_Online_Application_List a LEFT JOIN EDocSys_File b WHERE a.sTransNox =? AND b.sFileCode !='0021' AND b.sFileCode !='0020' ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDocumentsList = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_Documents SET sFileLoct = (SELECT sFileLoct FROM Image_Information WHERE sSourceNo =? AND sFileCode = Credit_Online_Application_Documents.sFileCode), sImageNme = (SELECT sImageNme FROM Image_Information WHERE sSourceNo =? AND sFileCode = Credit_Online_Application_Documents.sFileCode) WHERE sTransNox =? ";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateCheckedFile = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_Documents SET cSendStat = '1' WHERE sTransNox =? AND sFileCode =? ";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EFileCode foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEFileCode.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EFileCode foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEFileCode.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ECreditApplicationDocuments documentsInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfECreditApplicationDocuments.handle(documentsInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void InitializeDocumentsList(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfInitializeDocumentsList.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeInsert();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfInitializeDocumentsList.release(_stmt);
    }
  }

  @Override
  public void UpdateDocumentsList(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDocumentsList.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 3;
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
      __preparedStmtOfUpdateDocumentsList.release(_stmt);
    }
  }

  @Override
  public void UpdateCheckedFile(final String TransNox, final String fileCode) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCheckedFile.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (fileCode == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fileCode);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateCheckedFile.release(_stmt);
    }
  }

  @Override
  public EFileCode GetFileCode(final String fsVal) {
    final String _sql = "SELECT * FROM EDocSys_File WHERE sFileCode =?";
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
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfBarrcode = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarrcode");
      final int _cursorIndexOfBriefDsc = CursorUtil.getColumnIndexOrThrow(_cursor, "sBriefDsc");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EFileCode _result;
      if(_cursor.moveToFirst()) {
        _result = new EFileCode();
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _result.setFileCode(_tmpFileCode);
        final String _tmpBarrcode;
        if (_cursor.isNull(_cursorIndexOfBarrcode)) {
          _tmpBarrcode = null;
        } else {
          _tmpBarrcode = _cursor.getString(_cursorIndexOfBarrcode);
        }
        _result.setBarrcode(_tmpBarrcode);
        final String _tmpBriefDsc;
        if (_cursor.isNull(_cursorIndexOfBriefDsc)) {
          _tmpBriefDsc = null;
        } else {
          _tmpBriefDsc = _cursor.getString(_cursorIndexOfBriefDsc);
        }
        _result.setBriefDsc(_tmpBriefDsc);
        final String _tmpRecdStat;
        if (_cursor.isNull(_cursorIndexOfRecdStat)) {
          _tmpRecdStat = null;
        } else {
          _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
        }
        _result.setRecdStat(_tmpRecdStat);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
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
  public EFileCode GetLatestFileCode() {
    final String _sql = "SELECT * FROM EDocSys_File ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfBarrcode = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarrcode");
      final int _cursorIndexOfBriefDsc = CursorUtil.getColumnIndexOrThrow(_cursor, "sBriefDsc");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EFileCode _result;
      if(_cursor.moveToFirst()) {
        _result = new EFileCode();
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _result.setFileCode(_tmpFileCode);
        final String _tmpBarrcode;
        if (_cursor.isNull(_cursorIndexOfBarrcode)) {
          _tmpBarrcode = null;
        } else {
          _tmpBarrcode = _cursor.getString(_cursorIndexOfBarrcode);
        }
        _result.setBarrcode(_tmpBarrcode);
        final String _tmpBriefDsc;
        if (_cursor.isNull(_cursorIndexOfBriefDsc)) {
          _tmpBriefDsc = null;
        } else {
          _tmpBriefDsc = _cursor.getString(_cursorIndexOfBriefDsc);
        }
        _result.setBriefDsc(_tmpBriefDsc);
        final String _tmpRecdStat;
        if (_cursor.isNull(_cursorIndexOfRecdStat)) {
          _tmpRecdStat = null;
        } else {
          _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
        }
        _result.setRecdStat(_tmpRecdStat);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
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
  public LiveData<List<EFileCode>> selectFileCodeList() {
    final String _sql = "SELECT * FROM EDocSys_File WHERE sFileCode != '0020' AND sFileCode != '0021'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"EDocSys_File"}, false, new Callable<List<EFileCode>>() {
      @Override
      public List<EFileCode> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
          final int _cursorIndexOfBarrcode = CursorUtil.getColumnIndexOrThrow(_cursor, "sBarrcode");
          final int _cursorIndexOfBriefDsc = CursorUtil.getColumnIndexOrThrow(_cursor, "sBriefDsc");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EFileCode> _result = new ArrayList<EFileCode>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EFileCode _item;
            _item = new EFileCode();
            final String _tmpFileCode;
            if (_cursor.isNull(_cursorIndexOfFileCode)) {
              _tmpFileCode = null;
            } else {
              _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
            }
            _item.setFileCode(_tmpFileCode);
            final String _tmpBarrcode;
            if (_cursor.isNull(_cursorIndexOfBarrcode)) {
              _tmpBarrcode = null;
            } else {
              _tmpBarrcode = _cursor.getString(_cursorIndexOfBarrcode);
            }
            _item.setBarrcode(_tmpBarrcode);
            final String _tmpBriefDsc;
            if (_cursor.isNull(_cursorIndexOfBriefDsc)) {
              _tmpBriefDsc = null;
            } else {
              _tmpBriefDsc = _cursor.getString(_cursorIndexOfBriefDsc);
            }
            _item.setBriefDsc(_tmpBriefDsc);
            final String _tmpRecdStat;
            if (_cursor.isNull(_cursorIndexOfRecdStat)) {
              _tmpRecdStat = null;
            } else {
              _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
            }
            _item.setRecdStat(_tmpRecdStat);
            final int _tmpEntryNox;
            _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
            _item.setEntryNox(_tmpEntryNox);
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
    final String _sql = "SELECT MAX(dTimeStmp) AS TimeStamp FROM EDocSys_File";
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

  @Override
  public String getLastUpdate() {
    final String _sql = "SELECT dLstUpdte FROM EDocSys_File ORDER BY dLstUpdte DESC LIMIT 1";
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
  public List<ECreditApplicationDocuments> GetDocumentsList(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Online_Application_Documents WHERE sTransNox =?";
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
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfImageIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageIDx");
      final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final List<ECreditApplicationDocuments> _result = new ArrayList<ECreditApplicationDocuments>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ECreditApplicationDocuments _item;
        _item = new ECreditApplicationDocuments();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _item.setFileCode(_tmpFileCode);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final String _tmpImageIDx;
        if (_cursor.isNull(_cursorIndexOfImageIDx)) {
          _tmpImageIDx = null;
        } else {
          _tmpImageIDx = _cursor.getString(_cursorIndexOfImageIDx);
        }
        _item.setImageIDx(_tmpImageIDx);
        final String _tmpFileLoct;
        if (_cursor.isNull(_cursorIndexOfFileLoct)) {
          _tmpFileLoct = null;
        } else {
          _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
        }
        _item.setFileLoct(_tmpFileLoct);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public ECreditApplicationDocuments GetDocument(final String TransNox, final String FileCode) {
    final String _sql = "SELECT * FROM Credit_Online_Application_Documents WHERE sTransNox =? AND sFileCode =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
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
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfImageIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageIDx");
      final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final ECreditApplicationDocuments _result;
      if(_cursor.moveToFirst()) {
        _result = new ECreditApplicationDocuments();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _result.setFileCode(_tmpFileCode);
        final int _tmpEntryNox;
        _tmpEntryNox = _cursor.getInt(_cursorIndexOfEntryNox);
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _result.setImageNme(_tmpImageNme);
        final String _tmpImageIDx;
        if (_cursor.isNull(_cursorIndexOfImageIDx)) {
          _tmpImageIDx = null;
        } else {
          _tmpImageIDx = _cursor.getString(_cursorIndexOfImageIDx);
        }
        _result.setImageIDx(_tmpImageIDx);
        final String _tmpFileLoct;
        if (_cursor.isNull(_cursorIndexOfFileLoct)) {
          _tmpFileLoct = null;
        } else {
          _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
        }
        _result.setFileLoct(_tmpFileLoct);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
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
  public LiveData<List<DFileCode.ApplicationDocument>> GetCreditAppDocuments(
      final String TransNox) {
    final String _sql = "SELECT a.sTransNox, a.sFileCode, b.sBriefDsc, a.nEntryNox, a.sImageNme, a.sFileLoct, a.cSendStat FROM Credit_Online_Application_Documents a LEFT JOIN EDocSys_File b ON a.sFileCode = b.sFileCode WHERE a.sTransNox =? ORDER BY a.nEntryNox ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_Documents","EDocSys_File"}, false, new Callable<List<DFileCode.ApplicationDocument>>() {
      @Override
      public List<DFileCode.ApplicationDocument> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfSFileCode = 1;
          final int _cursorIndexOfSBriefDsc = 2;
          final int _cursorIndexOfNEntryNox = 3;
          final int _cursorIndexOfSImageNme = 4;
          final int _cursorIndexOfSFileLoct = 5;
          final int _cursorIndexOfCSendStat = 6;
          final List<DFileCode.ApplicationDocument> _result = new ArrayList<DFileCode.ApplicationDocument>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DFileCode.ApplicationDocument _item;
            _item = new DFileCode.ApplicationDocument();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSFileCode)) {
              _item.sFileCode = null;
            } else {
              _item.sFileCode = _cursor.getString(_cursorIndexOfSFileCode);
            }
            if (_cursor.isNull(_cursorIndexOfSBriefDsc)) {
              _item.sBriefDsc = null;
            } else {
              _item.sBriefDsc = _cursor.getString(_cursorIndexOfSBriefDsc);
            }
            _item.nEntryNox = _cursor.getInt(_cursorIndexOfNEntryNox);
            if (_cursor.isNull(_cursorIndexOfSImageNme)) {
              _item.sImageNme = null;
            } else {
              _item.sImageNme = _cursor.getString(_cursorIndexOfSImageNme);
            }
            if (_cursor.isNull(_cursorIndexOfSFileLoct)) {
              _item.sFileLoct = null;
            } else {
              _item.sFileLoct = _cursor.getString(_cursorIndexOfSFileLoct);
            }
            if (_cursor.isNull(_cursorIndexOfCSendStat)) {
              _item.cSendStat = null;
            } else {
              _item.cSendStat = _cursor.getString(_cursorIndexOfCSendStat);
            }
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
