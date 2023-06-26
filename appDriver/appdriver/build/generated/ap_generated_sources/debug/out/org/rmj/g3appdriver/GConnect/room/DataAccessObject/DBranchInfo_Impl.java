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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GConnect.room.Entities.EBranchInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.EProvinceInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.ETownInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DBranchInfo_Impl implements DBranchInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EBranchInfo> __insertionAdapterOfEBranchInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateBranchInfo;

  public DBranchInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEBranchInfo = new EntityInsertionAdapter<EBranchInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `BranchInfo` (`sBranchCd`,`sBranchNm`,`sDescript`,`sAddressx`,`sTownIDxx`,`sTownName`,`sProvName`,`nLatitude`,`nLongtude`,`sContactx`,`sTelNumbr`,`sEmailAdd`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchInfo value) {
        if (value.getBranchCd() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBranchCd());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchNm());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescript());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddressx());
        }
        if (value.getTownIDxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getTownIDxx());
        }
        if (value.getTownName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTownName());
        }
        if (value.getProvName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getProvName());
        }
        stmt.bindDouble(8, value.getLatitude());
        stmt.bindDouble(9, value.getLongtude());
        if (value.getContactx() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getContactx());
        }
        if (value.getTelNumbr() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTelNumbr());
        }
        if (value.getEmailAdd() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getEmailAdd());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
      }
    };
    this.__preparedStmtOfUpdateBranchInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE BranchInfo SET sBranchNm =?, sDescript =?, sAddressx =?, sContactx =?, sTelNumbr =?, sEmailAdd =? WHERE sBranchCd =?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EBranchInfo branchInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchInfo.insert(branchInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateBranchInfo(final String BranchCd, final String BranchNm, final String Descript,
      final String Addressx, final String Contactx, final String TelNumbr, final String EmailAdd) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateBranchInfo.acquire();
    int _argIndex = 1;
    if (BranchNm == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, BranchNm);
    }
    _argIndex = 2;
    if (Descript == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Descript);
    }
    _argIndex = 3;
    if (Addressx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Addressx);
    }
    _argIndex = 4;
    if (Contactx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Contactx);
    }
    _argIndex = 5;
    if (TelNumbr == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TelNumbr);
    }
    _argIndex = 6;
    if (EmailAdd == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, EmailAdd);
    }
    _argIndex = 7;
    if (BranchCd == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, BranchCd);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateBranchInfo.release(_stmt);
    }
  }

  @Override
  public LiveData<List<EBranchInfo>> getAllBranchs() {
    final String _sql = "SELECT * FROM BranchInfo";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"BranchInfo"}, false, new Callable<List<EBranchInfo>>() {
      @Override
      public List<EBranchInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongtude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongtude");
          final int _cursorIndexOfContactx = CursorUtil.getColumnIndexOrThrow(_cursor, "sContactx");
          final int _cursorIndexOfTelNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sTelNumbr");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchInfo _item;
            _item = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpProvName;
            if (_cursor.isNull(_cursorIndexOfProvName)) {
              _tmpProvName = null;
            } else {
              _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
            }
            _item.setProvName(_tmpProvName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            _item.setLatitude(_tmpLatitude);
            final double _tmpLongtude;
            _tmpLongtude = _cursor.getDouble(_cursorIndexOfLongtude);
            _item.setLongtude(_tmpLongtude);
            final String _tmpContactx;
            if (_cursor.isNull(_cursorIndexOfContactx)) {
              _tmpContactx = null;
            } else {
              _tmpContactx = _cursor.getString(_cursorIndexOfContactx);
            }
            _item.setContactx(_tmpContactx);
            final String _tmpTelNumbr;
            if (_cursor.isNull(_cursorIndexOfTelNumbr)) {
              _tmpTelNumbr = null;
            } else {
              _tmpTelNumbr = _cursor.getString(_cursorIndexOfTelNumbr);
            }
            _item.setTelNumbr(_tmpTelNumbr);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _item.setEmailAdd(_tmpEmailAdd);
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
  public LiveData<List<EBranchInfo>> getMotorBranches() {
    final String _sql = "SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'M%' ORDER BY sTownIDxx = (SELECT sTownIDx1 FROM Client_Profile_Info) DESC, sBranchCd ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"BranchInfo","Client_Profile_Info"}, false, new Callable<List<EBranchInfo>>() {
      @Override
      public List<EBranchInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongtude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongtude");
          final int _cursorIndexOfContactx = CursorUtil.getColumnIndexOrThrow(_cursor, "sContactx");
          final int _cursorIndexOfTelNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sTelNumbr");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchInfo _item;
            _item = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpProvName;
            if (_cursor.isNull(_cursorIndexOfProvName)) {
              _tmpProvName = null;
            } else {
              _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
            }
            _item.setProvName(_tmpProvName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            _item.setLatitude(_tmpLatitude);
            final double _tmpLongtude;
            _tmpLongtude = _cursor.getDouble(_cursorIndexOfLongtude);
            _item.setLongtude(_tmpLongtude);
            final String _tmpContactx;
            if (_cursor.isNull(_cursorIndexOfContactx)) {
              _tmpContactx = null;
            } else {
              _tmpContactx = _cursor.getString(_cursorIndexOfContactx);
            }
            _item.setContactx(_tmpContactx);
            final String _tmpTelNumbr;
            if (_cursor.isNull(_cursorIndexOfTelNumbr)) {
              _tmpTelNumbr = null;
            } else {
              _tmpTelNumbr = _cursor.getString(_cursorIndexOfTelNumbr);
            }
            _item.setTelNumbr(_tmpTelNumbr);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _item.setEmailAdd(_tmpEmailAdd);
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
  public LiveData<List<EBranchInfo>> getMobileBranches() {
    final String _sql = "SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'C%' ORDER BY sTownIDxx = (SELECT sTownIDx1 FROM Client_Profile_Info) DESC, sBranchCd ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"BranchInfo","Client_Profile_Info"}, false, new Callable<List<EBranchInfo>>() {
      @Override
      public List<EBranchInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongtude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongtude");
          final int _cursorIndexOfContactx = CursorUtil.getColumnIndexOrThrow(_cursor, "sContactx");
          final int _cursorIndexOfTelNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sTelNumbr");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchInfo _item;
            _item = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpProvName;
            if (_cursor.isNull(_cursorIndexOfProvName)) {
              _tmpProvName = null;
            } else {
              _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
            }
            _item.setProvName(_tmpProvName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            _item.setLatitude(_tmpLatitude);
            final double _tmpLongtude;
            _tmpLongtude = _cursor.getDouble(_cursorIndexOfLongtude);
            _item.setLongtude(_tmpLongtude);
            final String _tmpContactx;
            if (_cursor.isNull(_cursorIndexOfContactx)) {
              _tmpContactx = null;
            } else {
              _tmpContactx = _cursor.getString(_cursorIndexOfContactx);
            }
            _item.setContactx(_tmpContactx);
            final String _tmpTelNumbr;
            if (_cursor.isNull(_cursorIndexOfTelNumbr)) {
              _tmpTelNumbr = null;
            } else {
              _tmpTelNumbr = _cursor.getString(_cursorIndexOfTelNumbr);
            }
            _item.setTelNumbr(_tmpTelNumbr);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _item.setEmailAdd(_tmpEmailAdd);
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
  public EBranchInfo getBranchIfExist(final String BranchCde) {
    final String _sql = "SELECT * FROM BranchInfo WHERE sBranchCd=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BranchCde == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCde);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
      final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
      final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
      final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongtude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongtude");
      final int _cursorIndexOfContactx = CursorUtil.getColumnIndexOrThrow(_cursor, "sContactx");
      final int _cursorIndexOfTelNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sTelNumbr");
      final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EBranchInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EBranchInfo();
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpBranchNm;
        if (_cursor.isNull(_cursorIndexOfBranchNm)) {
          _tmpBranchNm = null;
        } else {
          _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
        }
        _result.setBranchNm(_tmpBranchNm);
        final String _tmpDescript;
        if (_cursor.isNull(_cursorIndexOfDescript)) {
          _tmpDescript = null;
        } else {
          _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
        }
        _result.setDescript(_tmpDescript);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpTownIDxx;
        if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
          _tmpTownIDxx = null;
        } else {
          _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
        }
        _result.setTownIDxx(_tmpTownIDxx);
        final String _tmpTownName;
        if (_cursor.isNull(_cursorIndexOfTownName)) {
          _tmpTownName = null;
        } else {
          _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
        }
        _result.setTownName(_tmpTownName);
        final String _tmpProvName;
        if (_cursor.isNull(_cursorIndexOfProvName)) {
          _tmpProvName = null;
        } else {
          _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
        }
        _result.setProvName(_tmpProvName);
        final double _tmpLatitude;
        _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
        _result.setLatitude(_tmpLatitude);
        final double _tmpLongtude;
        _tmpLongtude = _cursor.getDouble(_cursorIndexOfLongtude);
        _result.setLongtude(_tmpLongtude);
        final String _tmpContactx;
        if (_cursor.isNull(_cursorIndexOfContactx)) {
          _tmpContactx = null;
        } else {
          _tmpContactx = _cursor.getString(_cursorIndexOfContactx);
        }
        _result.setContactx(_tmpContactx);
        final String _tmpTelNumbr;
        if (_cursor.isNull(_cursorIndexOfTelNumbr)) {
          _tmpTelNumbr = null;
        } else {
          _tmpTelNumbr = _cursor.getString(_cursorIndexOfTelNumbr);
        }
        _result.setTelNumbr(_tmpTelNumbr);
        final String _tmpEmailAdd;
        if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
          _tmpEmailAdd = null;
        } else {
          _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
        }
        _result.setEmailAdd(_tmpEmailAdd);
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
  public LiveData<List<ETownInfo>> GetTownList(final String args) {
    final String _sql = "SELECT * FROM Town_Info WHERE sTownIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Town_Info"}, false, new Callable<List<ETownInfo>>() {
      @Override
      public List<ETownInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfZippCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sZippCode");
          final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
          final int _cursorIndexOfProvCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvCode");
          final int _cursorIndexOfMuncplCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sMuncplCd");
          final int _cursorIndexOfHasRoute = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRoute");
          final int _cursorIndexOfBlackLst = CursorUtil.getColumnIndexOrThrow(_cursor, "cBlackLst");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<ETownInfo> _result = new ArrayList<ETownInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ETownInfo _item;
            _item = new ETownInfo();
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpZippCode;
            if (_cursor.isNull(_cursorIndexOfZippCode)) {
              _tmpZippCode = null;
            } else {
              _tmpZippCode = _cursor.getString(_cursorIndexOfZippCode);
            }
            _item.setZippCode(_tmpZippCode);
            final String _tmpProvIDxx;
            if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
              _tmpProvIDxx = null;
            } else {
              _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
            }
            _item.setProvIDxx(_tmpProvIDxx);
            final String _tmpProvCode;
            if (_cursor.isNull(_cursorIndexOfProvCode)) {
              _tmpProvCode = null;
            } else {
              _tmpProvCode = _cursor.getString(_cursorIndexOfProvCode);
            }
            _item.setProvCode(_tmpProvCode);
            final String _tmpMuncplCd;
            if (_cursor.isNull(_cursorIndexOfMuncplCd)) {
              _tmpMuncplCd = null;
            } else {
              _tmpMuncplCd = _cursor.getString(_cursorIndexOfMuncplCd);
            }
            _item.setMuncplCd(_tmpMuncplCd);
            final String _tmpHasRoute;
            if (_cursor.isNull(_cursorIndexOfHasRoute)) {
              _tmpHasRoute = null;
            } else {
              _tmpHasRoute = _cursor.getString(_cursorIndexOfHasRoute);
            }
            _item.setHasRoute(_tmpHasRoute);
            final String _tmpBlackLst;
            if (_cursor.isNull(_cursorIndexOfBlackLst)) {
              _tmpBlackLst = null;
            } else {
              _tmpBlackLst = _cursor.getString(_cursorIndexOfBlackLst);
            }
            _item.setBlackLst(_tmpBlackLst);
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
  public LiveData<List<EProvinceInfo>> GetProvinceList() {
    final String _sql = "SELECT * FROM Province_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Province_Info"}, false, new Callable<List<EProvinceInfo>>() {
      @Override
      public List<EProvinceInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfProvIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvIDxx");
          final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EProvinceInfo> _result = new ArrayList<EProvinceInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EProvinceInfo _item;
            _item = new EProvinceInfo();
            final String _tmpProvIDxx;
            if (_cursor.isNull(_cursorIndexOfProvIDxx)) {
              _tmpProvIDxx = null;
            } else {
              _tmpProvIDxx = _cursor.getString(_cursorIndexOfProvIDxx);
            }
            _item.setProvIDxx(_tmpProvIDxx);
            final String _tmpProvName;
            if (_cursor.isNull(_cursorIndexOfProvName)) {
              _tmpProvName = null;
            } else {
              _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
            }
            _item.setProvName(_tmpProvName);
            final char _tmpRecdStat;
            _tmpRecdStat = (char) (_cursor.getInt(_cursorIndexOfRecdStat));
            _item.setRecdStat(_tmpRecdStat);
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
  public LiveData<List<EBranchInfo>> GetMCBranches(final String Town) {
    final String _sql = "SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'M%' AND sTownIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (Town == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Town);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"BranchInfo"}, false, new Callable<List<EBranchInfo>>() {
      @Override
      public List<EBranchInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongtude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongtude");
          final int _cursorIndexOfContactx = CursorUtil.getColumnIndexOrThrow(_cursor, "sContactx");
          final int _cursorIndexOfTelNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sTelNumbr");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchInfo _item;
            _item = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpProvName;
            if (_cursor.isNull(_cursorIndexOfProvName)) {
              _tmpProvName = null;
            } else {
              _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
            }
            _item.setProvName(_tmpProvName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            _item.setLatitude(_tmpLatitude);
            final double _tmpLongtude;
            _tmpLongtude = _cursor.getDouble(_cursorIndexOfLongtude);
            _item.setLongtude(_tmpLongtude);
            final String _tmpContactx;
            if (_cursor.isNull(_cursorIndexOfContactx)) {
              _tmpContactx = null;
            } else {
              _tmpContactx = _cursor.getString(_cursorIndexOfContactx);
            }
            _item.setContactx(_tmpContactx);
            final String _tmpTelNumbr;
            if (_cursor.isNull(_cursorIndexOfTelNumbr)) {
              _tmpTelNumbr = null;
            } else {
              _tmpTelNumbr = _cursor.getString(_cursorIndexOfTelNumbr);
            }
            _item.setTelNumbr(_tmpTelNumbr);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _item.setEmailAdd(_tmpEmailAdd);
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
  public LiveData<List<EBranchInfo>> GetMPBranches(final String Town) {
    final String _sql = "SELECT * FROM BranchInfo WHERE sBranchCd LIKE 'C%' AND sTownIDxx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (Town == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Town);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"BranchInfo"}, false, new Callable<List<EBranchInfo>>() {
      @Override
      public List<EBranchInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfBranchNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchNm");
          final int _cursorIndexOfDescript = CursorUtil.getColumnIndexOrThrow(_cursor, "sDescript");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfTownIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDxx");
          final int _cursorIndexOfTownName = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownName");
          final int _cursorIndexOfProvName = CursorUtil.getColumnIndexOrThrow(_cursor, "sProvName");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongtude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongtude");
          final int _cursorIndexOfContactx = CursorUtil.getColumnIndexOrThrow(_cursor, "sContactx");
          final int _cursorIndexOfTelNumbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sTelNumbr");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<EBranchInfo> _result = new ArrayList<EBranchInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchInfo _item;
            _item = new EBranchInfo();
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpBranchNm;
            if (_cursor.isNull(_cursorIndexOfBranchNm)) {
              _tmpBranchNm = null;
            } else {
              _tmpBranchNm = _cursor.getString(_cursorIndexOfBranchNm);
            }
            _item.setBranchNm(_tmpBranchNm);
            final String _tmpDescript;
            if (_cursor.isNull(_cursorIndexOfDescript)) {
              _tmpDescript = null;
            } else {
              _tmpDescript = _cursor.getString(_cursorIndexOfDescript);
            }
            _item.setDescript(_tmpDescript);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpTownIDxx;
            if (_cursor.isNull(_cursorIndexOfTownIDxx)) {
              _tmpTownIDxx = null;
            } else {
              _tmpTownIDxx = _cursor.getString(_cursorIndexOfTownIDxx);
            }
            _item.setTownIDxx(_tmpTownIDxx);
            final String _tmpTownName;
            if (_cursor.isNull(_cursorIndexOfTownName)) {
              _tmpTownName = null;
            } else {
              _tmpTownName = _cursor.getString(_cursorIndexOfTownName);
            }
            _item.setTownName(_tmpTownName);
            final String _tmpProvName;
            if (_cursor.isNull(_cursorIndexOfProvName)) {
              _tmpProvName = null;
            } else {
              _tmpProvName = _cursor.getString(_cursorIndexOfProvName);
            }
            _item.setProvName(_tmpProvName);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            _item.setLatitude(_tmpLatitude);
            final double _tmpLongtude;
            _tmpLongtude = _cursor.getDouble(_cursorIndexOfLongtude);
            _item.setLongtude(_tmpLongtude);
            final String _tmpContactx;
            if (_cursor.isNull(_cursorIndexOfContactx)) {
              _tmpContactx = null;
            } else {
              _tmpContactx = _cursor.getString(_cursorIndexOfContactx);
            }
            _item.setContactx(_tmpContactx);
            final String _tmpTelNumbr;
            if (_cursor.isNull(_cursorIndexOfTelNumbr)) {
              _tmpTelNumbr = null;
            } else {
              _tmpTelNumbr = _cursor.getString(_cursorIndexOfTelNumbr);
            }
            _item.setTelNumbr(_tmpTelNumbr);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _item.setEmailAdd(_tmpEmailAdd);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
