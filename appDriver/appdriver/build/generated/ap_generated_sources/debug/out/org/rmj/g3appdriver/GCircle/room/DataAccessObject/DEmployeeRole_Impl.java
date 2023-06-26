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
import org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeRole;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DEmployeeRole_Impl implements DEmployeeRole {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EEmployeeRole> __insertionAdapterOfEEmployeeRole;

  private final EntityDeletionOrUpdateAdapter<EEmployeeRole> __updateAdapterOfEEmployeeRole;

  private final SharedSQLiteStatement __preparedStmtOfDeleteEmployeeRole;

  private final SharedSQLiteStatement __preparedStmtOfUpdateEmployeeRole;

  public DEmployeeRole_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEEmployeeRole = new EntityInsertionAdapter<EEmployeeRole>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `xxxAOEmpRole` (`sObjectNm`,`sObjectDs`,`cObjectTp`,`cRecdStat`,`sParentxx`,`sSeqnceCd`,`cHasChild`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEmployeeRole value) {
        if (value.getObjectNm() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getObjectNm());
        }
        if (value.getObjectDs() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getObjectDs());
        }
        if (value.getObjectTP() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getObjectTP());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRecdStat());
        }
        if (value.getParentxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getParentxx());
        }
        if (value.getSeqnceCd() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSeqnceCd());
        }
        if (value.getHasChild() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getHasChild());
        }
        if (value.getModified() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEEmployeeRole = new EntityDeletionOrUpdateAdapter<EEmployeeRole>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `xxxAOEmpRole` SET `sObjectNm` = ?,`sObjectDs` = ?,`cObjectTp` = ?,`cRecdStat` = ?,`sParentxx` = ?,`sSeqnceCd` = ?,`cHasChild` = ?,`dModified` = ?,`dTimeStmp` = ? WHERE `sObjectNm` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EEmployeeRole value) {
        if (value.getObjectNm() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getObjectNm());
        }
        if (value.getObjectDs() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getObjectDs());
        }
        if (value.getObjectTP() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getObjectTP());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getRecdStat());
        }
        if (value.getParentxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getParentxx());
        }
        if (value.getSeqnceCd() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSeqnceCd());
        }
        if (value.getHasChild() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getHasChild());
        }
        if (value.getModified() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTimeStmp());
        }
        if (value.getObjectNm() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getObjectNm());
        }
      }
    };
    this.__preparedStmtOfDeleteEmployeeRole = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM xxxAOEmpRole";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateEmployeeRole = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE xxxAOEmpRole SET cObjectTP=?, sObjectDs=?, sParentxx=?, cHasChild=?, sSeqnceCD=?, cRecdStat=?, dTimeStmp=? WHERE sObjectNm=?";
        return _query;
      }
    };
  }

  @Override
  public void InsertEmployeeRole(final EEmployeeRole role) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEEmployeeRole.insert(role);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateRole(final EEmployeeRole foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEEmployeeRole.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void DeleteEmployeeRole() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteEmployeeRole.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteEmployeeRole.release(_stmt);
    }
  }

  @Override
  public void updateEmployeeRole(final String ObjectNm, final String ObjectTP,
      final String ObjectDs, final String Parentxx, final String HasChild, final String SeqnceCD,
      final String RecdStat, final String TimeStmp) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateEmployeeRole.acquire();
    int _argIndex = 1;
    if (ObjectTP == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ObjectTP);
    }
    _argIndex = 2;
    if (ObjectDs == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ObjectDs);
    }
    _argIndex = 3;
    if (Parentxx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Parentxx);
    }
    _argIndex = 4;
    if (HasChild == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, HasChild);
    }
    _argIndex = 5;
    if (SeqnceCD == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, SeqnceCD);
    }
    _argIndex = 6;
    if (RecdStat == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, RecdStat);
    }
    _argIndex = 7;
    if (TimeStmp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TimeStmp);
    }
    _argIndex = 8;
    if (ObjectNm == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, ObjectNm);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateEmployeeRole.release(_stmt);
    }
  }

  @Override
  public void clearEmployeeRole() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteEmployeeRole.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteEmployeeRole.release(_stmt);
    }
  }

  @Override
  public EEmployeeRole GetEmployeeRole(final String fsVal) {
    final String _sql = "SELECT * FROM xxxAOEmpRole WHERE sObjectNm=?";
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
      final int _cursorIndexOfObjectNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sObjectNm");
      final int _cursorIndexOfObjectDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sObjectDs");
      final int _cursorIndexOfObjectTP = CursorUtil.getColumnIndexOrThrow(_cursor, "cObjectTp");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfParentxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sParentxx");
      final int _cursorIndexOfSeqnceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSeqnceCd");
      final int _cursorIndexOfHasChild = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasChild");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EEmployeeRole _result;
      if(_cursor.moveToFirst()) {
        _result = new EEmployeeRole();
        final String _tmpObjectNm;
        if (_cursor.isNull(_cursorIndexOfObjectNm)) {
          _tmpObjectNm = null;
        } else {
          _tmpObjectNm = _cursor.getString(_cursorIndexOfObjectNm);
        }
        _result.setObjectNm(_tmpObjectNm);
        final String _tmpObjectDs;
        if (_cursor.isNull(_cursorIndexOfObjectDs)) {
          _tmpObjectDs = null;
        } else {
          _tmpObjectDs = _cursor.getString(_cursorIndexOfObjectDs);
        }
        _result.setObjectDs(_tmpObjectDs);
        final String _tmpObjectTP;
        if (_cursor.isNull(_cursorIndexOfObjectTP)) {
          _tmpObjectTP = null;
        } else {
          _tmpObjectTP = _cursor.getString(_cursorIndexOfObjectTP);
        }
        _result.setObjectTP(_tmpObjectTP);
        final String _tmpRecdStat;
        if (_cursor.isNull(_cursorIndexOfRecdStat)) {
          _tmpRecdStat = null;
        } else {
          _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
        }
        _result.setRecdStat(_tmpRecdStat);
        final String _tmpParentxx;
        if (_cursor.isNull(_cursorIndexOfParentxx)) {
          _tmpParentxx = null;
        } else {
          _tmpParentxx = _cursor.getString(_cursorIndexOfParentxx);
        }
        _result.setParentxx(_tmpParentxx);
        final String _tmpSeqnceCd;
        if (_cursor.isNull(_cursorIndexOfSeqnceCd)) {
          _tmpSeqnceCd = null;
        } else {
          _tmpSeqnceCd = _cursor.getString(_cursorIndexOfSeqnceCd);
        }
        _result.setSeqnceCd(_tmpSeqnceCd);
        final String _tmpHasChild;
        if (_cursor.isNull(_cursorIndexOfHasChild)) {
          _tmpHasChild = null;
        } else {
          _tmpHasChild = _cursor.getString(_cursorIndexOfHasChild);
        }
        _result.setHasChild(_tmpHasChild);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
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
  public LiveData<List<EEmployeeRole>> getEmployeeRoles() {
    final String _sql = "SELECT * FROM xxxAOEmpRole WHERE cRecdStat = '1' AND sParentxx = '' ORDER BY sSeqnceCd ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"xxxAOEmpRole"}, false, new Callable<List<EEmployeeRole>>() {
      @Override
      public List<EEmployeeRole> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfObjectNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sObjectNm");
          final int _cursorIndexOfObjectDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sObjectDs");
          final int _cursorIndexOfObjectTP = CursorUtil.getColumnIndexOrThrow(_cursor, "cObjectTp");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfParentxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sParentxx");
          final int _cursorIndexOfSeqnceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSeqnceCd");
          final int _cursorIndexOfHasChild = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasChild");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EEmployeeRole> _result = new ArrayList<EEmployeeRole>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EEmployeeRole _item;
            _item = new EEmployeeRole();
            final String _tmpObjectNm;
            if (_cursor.isNull(_cursorIndexOfObjectNm)) {
              _tmpObjectNm = null;
            } else {
              _tmpObjectNm = _cursor.getString(_cursorIndexOfObjectNm);
            }
            _item.setObjectNm(_tmpObjectNm);
            final String _tmpObjectDs;
            if (_cursor.isNull(_cursorIndexOfObjectDs)) {
              _tmpObjectDs = null;
            } else {
              _tmpObjectDs = _cursor.getString(_cursorIndexOfObjectDs);
            }
            _item.setObjectDs(_tmpObjectDs);
            final String _tmpObjectTP;
            if (_cursor.isNull(_cursorIndexOfObjectTP)) {
              _tmpObjectTP = null;
            } else {
              _tmpObjectTP = _cursor.getString(_cursorIndexOfObjectTP);
            }
            _item.setObjectTP(_tmpObjectTP);
            final String _tmpRecdStat;
            if (_cursor.isNull(_cursorIndexOfRecdStat)) {
              _tmpRecdStat = null;
            } else {
              _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
            }
            _item.setRecdStat(_tmpRecdStat);
            final String _tmpParentxx;
            if (_cursor.isNull(_cursorIndexOfParentxx)) {
              _tmpParentxx = null;
            } else {
              _tmpParentxx = _cursor.getString(_cursorIndexOfParentxx);
            }
            _item.setParentxx(_tmpParentxx);
            final String _tmpSeqnceCd;
            if (_cursor.isNull(_cursorIndexOfSeqnceCd)) {
              _tmpSeqnceCd = null;
            } else {
              _tmpSeqnceCd = _cursor.getString(_cursorIndexOfSeqnceCd);
            }
            _item.setSeqnceCd(_tmpSeqnceCd);
            final String _tmpHasChild;
            if (_cursor.isNull(_cursorIndexOfHasChild)) {
              _tmpHasChild = null;
            } else {
              _tmpHasChild = _cursor.getString(_cursorIndexOfHasChild);
            }
            _item.setHasChild(_tmpHasChild);
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
  public LiveData<List<EEmployeeRole>> getChildRoles() {
    final String _sql = "SELECT * FROM xxxAOEmpRole WHERE sParentxx != '' ORDER BY sSeqnceCd ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"xxxAOEmpRole"}, false, new Callable<List<EEmployeeRole>>() {
      @Override
      public List<EEmployeeRole> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfObjectNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sObjectNm");
          final int _cursorIndexOfObjectDs = CursorUtil.getColumnIndexOrThrow(_cursor, "sObjectDs");
          final int _cursorIndexOfObjectTP = CursorUtil.getColumnIndexOrThrow(_cursor, "cObjectTp");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfParentxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sParentxx");
          final int _cursorIndexOfSeqnceCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sSeqnceCd");
          final int _cursorIndexOfHasChild = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasChild");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EEmployeeRole> _result = new ArrayList<EEmployeeRole>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EEmployeeRole _item;
            _item = new EEmployeeRole();
            final String _tmpObjectNm;
            if (_cursor.isNull(_cursorIndexOfObjectNm)) {
              _tmpObjectNm = null;
            } else {
              _tmpObjectNm = _cursor.getString(_cursorIndexOfObjectNm);
            }
            _item.setObjectNm(_tmpObjectNm);
            final String _tmpObjectDs;
            if (_cursor.isNull(_cursorIndexOfObjectDs)) {
              _tmpObjectDs = null;
            } else {
              _tmpObjectDs = _cursor.getString(_cursorIndexOfObjectDs);
            }
            _item.setObjectDs(_tmpObjectDs);
            final String _tmpObjectTP;
            if (_cursor.isNull(_cursorIndexOfObjectTP)) {
              _tmpObjectTP = null;
            } else {
              _tmpObjectTP = _cursor.getString(_cursorIndexOfObjectTP);
            }
            _item.setObjectTP(_tmpObjectTP);
            final String _tmpRecdStat;
            if (_cursor.isNull(_cursorIndexOfRecdStat)) {
              _tmpRecdStat = null;
            } else {
              _tmpRecdStat = _cursor.getString(_cursorIndexOfRecdStat);
            }
            _item.setRecdStat(_tmpRecdStat);
            final String _tmpParentxx;
            if (_cursor.isNull(_cursorIndexOfParentxx)) {
              _tmpParentxx = null;
            } else {
              _tmpParentxx = _cursor.getString(_cursorIndexOfParentxx);
            }
            _item.setParentxx(_tmpParentxx);
            final String _tmpSeqnceCd;
            if (_cursor.isNull(_cursorIndexOfSeqnceCd)) {
              _tmpSeqnceCd = null;
            } else {
              _tmpSeqnceCd = _cursor.getString(_cursorIndexOfSeqnceCd);
            }
            _item.setSeqnceCd(_tmpSeqnceCd);
            final String _tmpHasChild;
            if (_cursor.isNull(_cursorIndexOfHasChild)) {
              _tmpHasChild = null;
            } else {
              _tmpHasChild = _cursor.getString(_cursorIndexOfHasChild);
            }
            _item.setHasChild(_tmpHasChild);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
