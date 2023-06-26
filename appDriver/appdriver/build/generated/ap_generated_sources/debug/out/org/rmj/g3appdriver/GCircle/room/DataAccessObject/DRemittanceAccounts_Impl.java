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
import org.rmj.g3appdriver.GCircle.room.Entities.ERemittanceAccounts;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DRemittanceAccounts_Impl implements DRemittanceAccounts {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ERemittanceAccounts> __insertionAdapterOfERemittanceAccounts;

  private final SharedSQLiteStatement __preparedStmtOfClearRecords;

  public DRemittanceAccounts_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfERemittanceAccounts = new EntityInsertionAdapter<ERemittanceAccounts>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Collection_Account_Remittance` (`sBranchCd`,`sActNumbr`,`sBnkActID`,`sBranchNm`,`sActNamex`) VALUES (?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ERemittanceAccounts value) {
        if (value.getBranchCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBranchCd());
        }
        if (value.getActNumbr() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getActNumbr());
        }
        if (value.getBnkActID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBnkActID());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBranchNm());
        }
        if (value.getActNamex() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getActNamex());
        }
      }
    };
    this.__preparedStmtOfClearRecords = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Collection_Account_Remittance";
        return _query;
      }
    };
  }

  @Override
  public void SaveAccountRemittance(final ERemittanceAccounts foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERemittanceAccounts.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<ERemittanceAccounts> remittanceAccounts) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfERemittanceAccounts.insert(remittanceAccounts);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void ClearRecords() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearRecords.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearRecords.release(_stmt);
    }
  }

  @Override
  public ERemittanceAccounts GetAccount(final String args, final String args1, final String args2) {
    final String _sql = "SELECT * FROM Collection_Account_Remittance WHERE sBranchCd =? AND sBnkActID =? AND sActNamex =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    _argIndex = 2;
    if (args1 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args1);
    }
    _argIndex = 3;
    if (args2 == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args2);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfActNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sActNumbr");
      final int _cursorIndexOfBnkActID = CursorUtil.getColumnIndexOrThrow(_cursor, "sBnkActID");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfActNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sActNamex");
      final ERemittanceAccounts _result;
      if(_cursor.moveToFirst()) {
        _result = new ERemittanceAccounts();
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpActNumbr;
        if (_cursor.isNull(_cursorIndexOfActNumbr)) {
          _tmpActNumbr = null;
        } else {
          _tmpActNumbr = _cursor.getString(_cursorIndexOfActNumbr);
        }
        _result.setActNumbr(_tmpActNumbr);
        final String _tmpBnkActID;
        if (_cursor.isNull(_cursorIndexOfBnkActID)) {
          _tmpBnkActID = null;
        } else {
          _tmpBnkActID = _cursor.getString(_cursorIndexOfBnkActID);
        }
        _result.setBnkActID(_tmpBnkActID);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpActNamex;
        if (_cursor.isNull(_cursorIndexOfActNamex)) {
          _tmpActNamex = null;
        } else {
          _tmpActNamex = _cursor.getString(_cursorIndexOfActNamex);
        }
        _result.setActNamex(_tmpActNamex);
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
  public List<ERemittanceAccounts> getRemittanceAccountsIfExist() {
    final String _sql = "SELECT * FROM Collection_Account_Remittance";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfActNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sActNumbr");
      final int _cursorIndexOfBnkActID = CursorUtil.getColumnIndexOrThrow(_cursor, "sBnkActID");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfActNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sActNamex");
      final List<ERemittanceAccounts> _result = new ArrayList<ERemittanceAccounts>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ERemittanceAccounts _item;
        _item = new ERemittanceAccounts();
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpActNumbr;
        if (_cursor.isNull(_cursorIndexOfActNumbr)) {
          _tmpActNumbr = null;
        } else {
          _tmpActNumbr = _cursor.getString(_cursorIndexOfActNumbr);
        }
        _item.setActNumbr(_tmpActNumbr);
        final String _tmpBnkActID;
        if (_cursor.isNull(_cursorIndexOfBnkActID)) {
          _tmpBnkActID = null;
        } else {
          _tmpBnkActID = _cursor.getString(_cursorIndexOfBnkActID);
        }
        _item.setBnkActID(_tmpBnkActID);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _item.setBranchNm(_tmpBranchNm);
        final String _tmpActNamex;
        if (_cursor.isNull(_cursorIndexOfActNamex)) {
          _tmpActNamex = null;
        } else {
          _tmpActNamex = _cursor.getString(_cursorIndexOfActNamex);
        }
        _item.setActNamex(_tmpActNamex);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<ERemittanceAccounts> getDefaultRemittanceAccount() {
    final String _sql = "SELECT * FROM Collection_Account_Remittance WHERE sBranchCd = (SELECT sBranchCd FROM User_Info_Master)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Collection_Account_Remittance","User_Info_Master"}, false, new Callable<ERemittanceAccounts>() {
      @Override
      public ERemittanceAccounts call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfActNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sActNumbr");
          final int _cursorIndexOfBnkActID = CursorUtil.getColumnIndexOrThrow(_cursor, "sBnkActID");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfActNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sActNamex");
          final ERemittanceAccounts _result;
          if(_cursor.moveToFirst()) {
            _result = new ERemittanceAccounts();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpActNumbr;
            if (_cursor.isNull(_cursorIndexOfActNumbr)) {
              _tmpActNumbr = null;
            } else {
              _tmpActNumbr = _cursor.getString(_cursorIndexOfActNumbr);
            }
            _result.setActNumbr(_tmpActNumbr);
            final String _tmpBnkActID;
            if (_cursor.isNull(_cursorIndexOfBnkActID)) {
              _tmpBnkActID = null;
            } else {
              _tmpBnkActID = _cursor.getString(_cursorIndexOfBnkActID);
            }
            _result.setBnkActID(_tmpBnkActID);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _result.setBranchNm(_tmpBranchNm);
            final String _tmpActNamex;
            if (_cursor.isNull(_cursorIndexOfActNamex)) {
              _tmpActNamex = null;
            } else {
              _tmpActNamex = _cursor.getString(_cursorIndexOfActNamex);
            }
            _result.setActNamex(_tmpActNamex);
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
  public LiveData<List<ERemittanceAccounts>> getRemittanceBankAccountsList() {
    final String _sql = "SELECT * FROM Collection_Account_Remittance WHERE sBranchCd = (SELECT sBranchCd FROM USER_INFO_MASTER) AND sActNumbr NOT LIKE '____GK%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Collection_Account_Remittance","USER_INFO_MASTER"}, false, new Callable<List<ERemittanceAccounts>>() {
      @Override
      public List<ERemittanceAccounts> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfActNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sActNumbr");
          final int _cursorIndexOfBnkActID = CursorUtil.getColumnIndexOrThrow(_cursor, "sBnkActID");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfActNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sActNamex");
          final List<ERemittanceAccounts> _result = new ArrayList<ERemittanceAccounts>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ERemittanceAccounts _item;
            _item = new ERemittanceAccounts();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpActNumbr;
            if (_cursor.isNull(_cursorIndexOfActNumbr)) {
              _tmpActNumbr = null;
            } else {
              _tmpActNumbr = _cursor.getString(_cursorIndexOfActNumbr);
            }
            _item.setActNumbr(_tmpActNumbr);
            final String _tmpBnkActID;
            if (_cursor.isNull(_cursorIndexOfBnkActID)) {
              _tmpBnkActID = null;
            } else {
              _tmpBnkActID = _cursor.getString(_cursorIndexOfBnkActID);
            }
            _item.setBnkActID(_tmpBnkActID);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpActNamex;
            if (_cursor.isNull(_cursorIndexOfActNamex)) {
              _tmpActNamex = null;
            } else {
              _tmpActNamex = _cursor.getString(_cursorIndexOfActNamex);
            }
            _item.setActNamex(_tmpActNamex);
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
  public LiveData<List<ERemittanceAccounts>> getRemittanceOtherAccountsList() {
    final String _sql = "SELECT * FROM Collection_Account_Remittance WHERE sBranchCd = (SELECT sBranchCd FROM USER_INFO_MASTER) AND sActNumbr LIKE '____GK%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Collection_Account_Remittance","USER_INFO_MASTER"}, false, new Callable<List<ERemittanceAccounts>>() {
      @Override
      public List<ERemittanceAccounts> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfActNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sActNumbr");
          final int _cursorIndexOfBnkActID = CursorUtil.getColumnIndexOrThrow(_cursor, "sBnkActID");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfActNamex = CursorUtil.getColumnIndexOrThrow(_cursor, "sActNamex");
          final List<ERemittanceAccounts> _result = new ArrayList<ERemittanceAccounts>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ERemittanceAccounts _item;
            _item = new ERemittanceAccounts();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpActNumbr;
            if (_cursor.isNull(_cursorIndexOfActNumbr)) {
              _tmpActNumbr = null;
            } else {
              _tmpActNumbr = _cursor.getString(_cursorIndexOfActNumbr);
            }
            _item.setActNumbr(_tmpActNumbr);
            final String _tmpBnkActID;
            if (_cursor.isNull(_cursorIndexOfBnkActID)) {
              _tmpBnkActID = null;
            } else {
              _tmpBnkActID = _cursor.getString(_cursorIndexOfBnkActID);
            }
            _item.setBnkActID(_tmpBnkActID);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpActNamex;
            if (_cursor.isNull(_cursorIndexOfActNamex)) {
              _tmpActNamex = null;
            } else {
              _tmpActNamex = _cursor.getString(_cursorIndexOfActNamex);
            }
            _item.setActNamex(_tmpActNamex);
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
