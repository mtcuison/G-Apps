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
import org.rmj.g3appdriver.GCircle.room.Entities.EDCPCollectionMaster;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DDCPCollectionMaster_Impl implements DDCPCollectionMaster {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EDCPCollectionMaster> __insertionAdapterOfEDCPCollectionMaster;

  private final EntityDeletionOrUpdateAdapter<EDCPCollectionMaster> __updateAdapterOfEDCPCollectionMaster;

  private final SharedSQLiteStatement __preparedStmtOfUpdateEntryMaster;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentPostedDCPMaster;

  public DDCPCollectionMaster_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEDCPCollectionMaster = new EntityInsertionAdapter<EDCPCollectionMaster>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `LR_DCP_Collection_Master` (`sTransNox`,`dTransact`,`sReferNox`,`xCollName`,`sRouteNme`,`dReferDte`,`cTranStat`,`cDCPTypex`,`nEntryNox`,`sBranchNm`,`sCollctID`,`cSendStat`,`dSendDate`,`dModified`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EDCPCollectionMaster value) {
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
        if (value.getReferNox() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReferNox());
        }
        if (value.getCollName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCollName());
        }
        if (value.getRouteNme() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRouteNme());
        }
        if (value.getReferDte() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReferDte());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTranStat());
        }
        if (value.getDCPTypex() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDCPTypex());
        }
        if (value.getEntryNox() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getEntryNox());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBranchNm());
        }
        if (value.getCollctID() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCollctID());
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
        if (value.getModified() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getModified());
        }
      }
    };
    this.__updateAdapterOfEDCPCollectionMaster = new EntityDeletionOrUpdateAdapter<EDCPCollectionMaster>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `LR_DCP_Collection_Master` SET `sTransNox` = ?,`dTransact` = ?,`sReferNox` = ?,`xCollName` = ?,`sRouteNme` = ?,`dReferDte` = ?,`cTranStat` = ?,`cDCPTypex` = ?,`nEntryNox` = ?,`sBranchNm` = ?,`sCollctID` = ?,`cSendStat` = ?,`dSendDate` = ?,`dModified` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EDCPCollectionMaster value) {
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
        if (value.getReferNox() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getReferNox());
        }
        if (value.getCollName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCollName());
        }
        if (value.getRouteNme() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRouteNme());
        }
        if (value.getReferDte() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReferDte());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTranStat());
        }
        if (value.getDCPTypex() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getDCPTypex());
        }
        if (value.getEntryNox() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getEntryNox());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBranchNm());
        }
        if (value.getCollctID() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCollctID());
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
        if (value.getModified() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getModified());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateEntryMaster = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE LR_DCP_Collection_Master SET nEntryNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateSentPostedDCPMaster = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE LR_DCP_Collection_Master SET cSendStat = '1', cTranStat = '2', dSendDate =?, dModified =? WHERE sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EDCPCollectionMaster collectionMaster) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEDCPCollectionMaster.insert(collectionMaster);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EDCPCollectionMaster collectionMaster) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEDCPCollectionMaster.handle(collectionMaster);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateEntryMaster(final int nEntryNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateEntryMaster.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, nEntryNox);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateEntryMaster.release(_stmt);
    }
  }

  @Override
  public void updateSentPostedDCPMaster(final String Transnox, final String dModified) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSentPostedDCPMaster.acquire();
    int _argIndex = 1;
    if (dModified == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, dModified);
    }
    _argIndex = 2;
    if (dModified == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, dModified);
    }
    _argIndex = 3;
    if (Transnox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Transnox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSentPostedDCPMaster.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EDCPCollectionMaster>> getCollectionMasterList() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Master";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Master"}, false, new Callable<List<EDCPCollectionMaster>>() {
      @Override
      public List<EDCPCollectionMaster> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfCollName = CursorUtil.getColumnIndexOrThrow(_cursor, "xCollName");
          final int _cursorIndexOfRouteNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sRouteNme");
          final int _cursorIndexOfReferDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dReferDte");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfDCPTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCPTypex");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfCollctID = CursorUtil.getColumnIndexOrThrow(_cursor, "sCollctID");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final List<EDCPCollectionMaster> _result = new ArrayList<EDCPCollectionMaster>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EDCPCollectionMaster _item;
            _item = new EDCPCollectionMaster();
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
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _item.setReferNox(_tmpReferNox);
            final String _tmpCollName;
            if (_cursor.isNull(_cursorIndexOfCollName)) {
              _tmpCollName = null;
            } else {
              _tmpCollName = _cursor.getString(_cursorIndexOfCollName);
            }
            _item.setCollName(_tmpCollName);
            final String _tmpRouteNme;
            if (_cursor.isNull(_cursorIndexOfRouteNme)) {
              _tmpRouteNme = null;
            } else {
              _tmpRouteNme = _cursor.getString(_cursorIndexOfRouteNme);
            }
            _item.setRouteNme(_tmpRouteNme);
            final String _tmpReferDte;
            if (_cursor.isNull(_cursorIndexOfReferDte)) {
              _tmpReferDte = null;
            } else {
              _tmpReferDte = _cursor.getString(_cursorIndexOfReferDte);
            }
            _item.setReferDte(_tmpReferDte);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpDCPTypex;
            if (_cursor.isNull(_cursorIndexOfDCPTypex)) {
              _tmpDCPTypex = null;
            } else {
              _tmpDCPTypex = _cursor.getString(_cursorIndexOfDCPTypex);
            }
            _item.setDCPTypex(_tmpDCPTypex);
            final String _tmpEntryNox;
            if (_cursor.isNull(_cursorIndexOfEntryNox)) {
              _tmpEntryNox = null;
            } else {
              _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
            }
            _item.setEntryNox(_tmpEntryNox);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpCollctID;
            if (_cursor.isNull(_cursorIndexOfCollctID)) {
              _tmpCollctID = null;
            } else {
              _tmpCollctID = _cursor.getString(_cursorIndexOfCollctID);
            }
            _item.setCollctID(_tmpCollctID);
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
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
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
  public LiveData<EDCPCollectionMaster> getCollectionMaster() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Master ORDER BY dTransact DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"LR_DCP_Collection_Master"}, false, new Callable<EDCPCollectionMaster>() {
      @Override
      public EDCPCollectionMaster call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
          final int _cursorIndexOfCollName = CursorUtil.getColumnIndexOrThrow(_cursor, "xCollName");
          final int _cursorIndexOfRouteNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sRouteNme");
          final int _cursorIndexOfReferDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dReferDte");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfDCPTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCPTypex");
          final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfCollctID = CursorUtil.getColumnIndexOrThrow(_cursor, "sCollctID");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final EDCPCollectionMaster _result;
          if(_cursor.moveToFirst()) {
            _result = new EDCPCollectionMaster();
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
            final String _tmpReferNox;
            if (_cursor.isNull(_cursorIndexOfReferNox)) {
              _tmpReferNox = null;
            } else {
              _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
            }
            _result.setReferNox(_tmpReferNox);
            final String _tmpCollName;
            if (_cursor.isNull(_cursorIndexOfCollName)) {
              _tmpCollName = null;
            } else {
              _tmpCollName = _cursor.getString(_cursorIndexOfCollName);
            }
            _result.setCollName(_tmpCollName);
            final String _tmpRouteNme;
            if (_cursor.isNull(_cursorIndexOfRouteNme)) {
              _tmpRouteNme = null;
            } else {
              _tmpRouteNme = _cursor.getString(_cursorIndexOfRouteNme);
            }
            _result.setRouteNme(_tmpRouteNme);
            final String _tmpReferDte;
            if (_cursor.isNull(_cursorIndexOfReferDte)) {
              _tmpReferDte = null;
            } else {
              _tmpReferDte = _cursor.getString(_cursorIndexOfReferDte);
            }
            _result.setReferDte(_tmpReferDte);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpDCPTypex;
            if (_cursor.isNull(_cursorIndexOfDCPTypex)) {
              _tmpDCPTypex = null;
            } else {
              _tmpDCPTypex = _cursor.getString(_cursorIndexOfDCPTypex);
            }
            _result.setDCPTypex(_tmpDCPTypex);
            final String _tmpEntryNox;
            if (_cursor.isNull(_cursorIndexOfEntryNox)) {
              _tmpEntryNox = null;
            } else {
              _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
            }
            _result.setEntryNox(_tmpEntryNox);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final String _tmpCollctID;
            if (_cursor.isNull(_cursorIndexOfCollctID)) {
              _tmpCollctID = null;
            } else {
              _tmpCollctID = _cursor.getString(_cursorIndexOfCollctID);
            }
            _result.setCollctID(_tmpCollctID);
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
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
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
  public List<EDCPCollectionMaster> getCollectionMasterIfExist(final String TransNox) {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Master WHERE sTransNox =?";
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
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfCollName = CursorUtil.getColumnIndexOrThrow(_cursor, "xCollName");
      final int _cursorIndexOfRouteNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sRouteNme");
      final int _cursorIndexOfReferDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dReferDte");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDCPTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCPTypex");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfCollctID = CursorUtil.getColumnIndexOrThrow(_cursor, "sCollctID");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final List<EDCPCollectionMaster> _result = new ArrayList<EDCPCollectionMaster>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EDCPCollectionMaster _item;
        _item = new EDCPCollectionMaster();
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
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _item.setReferNox(_tmpReferNox);
        final String _tmpCollName;
        if (_cursor.isNull(_cursorIndexOfCollName)) {
          _tmpCollName = null;
        } else {
          _tmpCollName = _cursor.getString(_cursorIndexOfCollName);
        }
        _item.setCollName(_tmpCollName);
        final String _tmpRouteNme;
        if (_cursor.isNull(_cursorIndexOfRouteNme)) {
          _tmpRouteNme = null;
        } else {
          _tmpRouteNme = _cursor.getString(_cursorIndexOfRouteNme);
        }
        _item.setRouteNme(_tmpRouteNme);
        final String _tmpReferDte;
        if (_cursor.isNull(_cursorIndexOfReferDte)) {
          _tmpReferDte = null;
        } else {
          _tmpReferDte = _cursor.getString(_cursorIndexOfReferDte);
        }
        _item.setReferDte(_tmpReferDte);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpDCPTypex;
        if (_cursor.isNull(_cursorIndexOfDCPTypex)) {
          _tmpDCPTypex = null;
        } else {
          _tmpDCPTypex = _cursor.getString(_cursorIndexOfDCPTypex);
        }
        _item.setDCPTypex(_tmpDCPTypex);
        final String _tmpEntryNox;
        if (_cursor.isNull(_cursorIndexOfEntryNox)) {
          _tmpEntryNox = null;
        } else {
          _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
        }
        _item.setEntryNox(_tmpEntryNox);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _item.setBranchNm(_tmpBranchNm);
        final String _tmpCollctID;
        if (_cursor.isNull(_cursorIndexOfCollctID)) {
          _tmpCollctID = null;
        } else {
          _tmpCollctID = _cursor.getString(_cursorIndexOfCollctID);
        }
        _item.setCollctID(_tmpCollctID);
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
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public EDCPCollectionMaster CheckIfHasCollection() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Master WHERE cSendStat IS NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfCollName = CursorUtil.getColumnIndexOrThrow(_cursor, "xCollName");
      final int _cursorIndexOfRouteNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sRouteNme");
      final int _cursorIndexOfReferDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dReferDte");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDCPTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCPTypex");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfCollctID = CursorUtil.getColumnIndexOrThrow(_cursor, "sCollctID");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EDCPCollectionMaster _result;
      if(_cursor.moveToFirst()) {
        _result = new EDCPCollectionMaster();
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
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpCollName;
        if (_cursor.isNull(_cursorIndexOfCollName)) {
          _tmpCollName = null;
        } else {
          _tmpCollName = _cursor.getString(_cursorIndexOfCollName);
        }
        _result.setCollName(_tmpCollName);
        final String _tmpRouteNme;
        if (_cursor.isNull(_cursorIndexOfRouteNme)) {
          _tmpRouteNme = null;
        } else {
          _tmpRouteNme = _cursor.getString(_cursorIndexOfRouteNme);
        }
        _result.setRouteNme(_tmpRouteNme);
        final String _tmpReferDte;
        if (_cursor.isNull(_cursorIndexOfReferDte)) {
          _tmpReferDte = null;
        } else {
          _tmpReferDte = _cursor.getString(_cursorIndexOfReferDte);
        }
        _result.setReferDte(_tmpReferDte);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpDCPTypex;
        if (_cursor.isNull(_cursorIndexOfDCPTypex)) {
          _tmpDCPTypex = null;
        } else {
          _tmpDCPTypex = _cursor.getString(_cursorIndexOfDCPTypex);
        }
        _result.setDCPTypex(_tmpDCPTypex);
        final String _tmpEntryNox;
        if (_cursor.isNull(_cursorIndexOfEntryNox)) {
          _tmpEntryNox = null;
        } else {
          _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
        }
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpCollctID;
        if (_cursor.isNull(_cursorIndexOfCollctID)) {
          _tmpCollctID = null;
        } else {
          _tmpCollctID = _cursor.getString(_cursorIndexOfCollctID);
        }
        _result.setCollctID(_tmpCollctID);
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
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
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
  public EDCPCollectionMaster getLastCollectionMaster() {
    final String _sql = "SELECT * FROM LR_DCP_Collection_Master ORDER BY dReferDte DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfReferNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sReferNox");
      final int _cursorIndexOfCollName = CursorUtil.getColumnIndexOrThrow(_cursor, "xCollName");
      final int _cursorIndexOfRouteNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sRouteNme");
      final int _cursorIndexOfReferDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dReferDte");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDCPTypex = CursorUtil.getColumnIndexOrThrow(_cursor, "cDCPTypex");
      final int _cursorIndexOfEntryNox = CursorUtil.getColumnIndexOrThrow(_cursor, "nEntryNox");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfCollctID = CursorUtil.getColumnIndexOrThrow(_cursor, "sCollctID");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final EDCPCollectionMaster _result;
      if(_cursor.moveToFirst()) {
        _result = new EDCPCollectionMaster();
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
        final String _tmpReferNox;
        if (_cursor.isNull(_cursorIndexOfReferNox)) {
          _tmpReferNox = null;
        } else {
          _tmpReferNox = _cursor.getString(_cursorIndexOfReferNox);
        }
        _result.setReferNox(_tmpReferNox);
        final String _tmpCollName;
        if (_cursor.isNull(_cursorIndexOfCollName)) {
          _tmpCollName = null;
        } else {
          _tmpCollName = _cursor.getString(_cursorIndexOfCollName);
        }
        _result.setCollName(_tmpCollName);
        final String _tmpRouteNme;
        if (_cursor.isNull(_cursorIndexOfRouteNme)) {
          _tmpRouteNme = null;
        } else {
          _tmpRouteNme = _cursor.getString(_cursorIndexOfRouteNme);
        }
        _result.setRouteNme(_tmpRouteNme);
        final String _tmpReferDte;
        if (_cursor.isNull(_cursorIndexOfReferDte)) {
          _tmpReferDte = null;
        } else {
          _tmpReferDte = _cursor.getString(_cursorIndexOfReferDte);
        }
        _result.setReferDte(_tmpReferDte);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpDCPTypex;
        if (_cursor.isNull(_cursorIndexOfDCPTypex)) {
          _tmpDCPTypex = null;
        } else {
          _tmpDCPTypex = _cursor.getString(_cursorIndexOfDCPTypex);
        }
        _result.setDCPTypex(_tmpDCPTypex);
        final String _tmpEntryNox;
        if (_cursor.isNull(_cursorIndexOfEntryNox)) {
          _tmpEntryNox = null;
        } else {
          _tmpEntryNox = _cursor.getString(_cursorIndexOfEntryNox);
        }
        _result.setEntryNox(_tmpEntryNox);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpCollctID;
        if (_cursor.isNull(_cursorIndexOfCollctID)) {
          _tmpCollctID = null;
        } else {
          _tmpCollctID = _cursor.getString(_cursorIndexOfCollctID);
        }
        _result.setCollctID(_tmpCollctID);
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
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
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
