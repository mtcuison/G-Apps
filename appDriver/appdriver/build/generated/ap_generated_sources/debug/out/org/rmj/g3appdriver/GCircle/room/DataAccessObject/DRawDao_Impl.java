package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.ETokenInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DRawDao_Impl implements DRawDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ETokenInfo> __insertionAdapterOfETokenInfo;

  private final SharedSQLiteStatement __preparedStmtOfClearTokenInfo;

  public DRawDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfETokenInfo = new EntityInsertionAdapter<ETokenInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `App_Token_Info` (`sTokenIDx`,`sTokenInf`,`sDescript`,`sTokenTpe`,`dGeneratd`,`dExpirexx`,`dModified`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ETokenInfo value) {
        if (value.getTokenIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTokenIDx());
        }
        if (value.getTokenInf() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTokenInf());
        }
        if (value.getDescript() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDescript());
        }
        if (value.getTokenTpe() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTokenTpe());
        }
        if (value.getGeneratd() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGeneratd());
        }
        if (value.getExpirexx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getExpirexx());
        }
        if (value.getModified() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getModified());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTimeStmp());
        }
      }
    };
    this.__preparedStmtOfClearTokenInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM App_Token_Info";
        return _query;
      }
    };
  }

  @Override
  public void insertTokenInfo(final ETokenInfo tokenInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfETokenInfo.insert(tokenInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clearTokenInfo() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearTokenInfo.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearTokenInfo.release(_stmt);
    }
  }

  @Override
  public String getTokenInfo() {
    final String _sql = "SELECT sTokenInf FROM App_Token_Info";
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
  public LiveData<DRawDao.McDPInfo> getDownpayment(final String ModelID) {
    final String _sql = "SELECT  a.sModelIDx AS ModelIDx, a.sModelNme AS ModelNme, b.nMinDownx AS MinDownx, c.nRebatesx AS Rebatesx, c.nMiscChrg AS MiscChrg, c.nEndMrtgg AS EndMrtgg, b.nSelPrice AS SelPrice, b.nLastPrce AS LastPrce FROM Mc_Model a, Mc_Model_Price b, MC_Category c WHERE a.sModelIDx = b.sModelIDx AND b.cRecdStat = '1' AND b.sMCCatIDx = c.sMCCatIDx AND (a.sModelIDx = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mc_Model","Mc_Model_Price","MC_Category"}, false, new Callable<DRawDao.McDPInfo>() {
      @Override
      public DRawDao.McDPInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfModelIDx = 0;
          final int _cursorIndexOfModelNme = 1;
          final int _cursorIndexOfMinDownx = 2;
          final int _cursorIndexOfRebatesx = 3;
          final int _cursorIndexOfMiscChrg = 4;
          final int _cursorIndexOfEndMrtgg = 5;
          final int _cursorIndexOfSelPrice = 6;
          final int _cursorIndexOfLastPrce = 7;
          final DRawDao.McDPInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new DRawDao.McDPInfo();
            if (_cursor.isNull(_cursorIndexOfModelIDx)) {
              _result.ModelIDx = null;
            } else {
              _result.ModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
            }
            if (_cursor.isNull(_cursorIndexOfModelNme)) {
              _result.ModelNme = null;
            } else {
              _result.ModelNme = _cursor.getString(_cursorIndexOfModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfMinDownx)) {
              _result.MinDownx = null;
            } else {
              _result.MinDownx = _cursor.getString(_cursorIndexOfMinDownx);
            }
            if (_cursor.isNull(_cursorIndexOfRebatesx)) {
              _result.Rebatesx = null;
            } else {
              _result.Rebatesx = _cursor.getString(_cursorIndexOfRebatesx);
            }
            if (_cursor.isNull(_cursorIndexOfMiscChrg)) {
              _result.MiscChrg = null;
            } else {
              _result.MiscChrg = _cursor.getString(_cursorIndexOfMiscChrg);
            }
            if (_cursor.isNull(_cursorIndexOfEndMrtgg)) {
              _result.EndMrtgg = null;
            } else {
              _result.EndMrtgg = _cursor.getString(_cursorIndexOfEndMrtgg);
            }
            if (_cursor.isNull(_cursorIndexOfSelPrice)) {
              _result.SelPrice = null;
            } else {
              _result.SelPrice = _cursor.getString(_cursorIndexOfSelPrice);
            }
            if (_cursor.isNull(_cursorIndexOfLastPrce)) {
              _result.LastPrce = null;
            } else {
              _result.LastPrce = _cursor.getString(_cursorIndexOfLastPrce);
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
  public LiveData<DRawDao.McAmortInfo> getMonthlyAmort(final String ModelID, final int Term) {
    final String _sql = "SELECT  a.nSelPrice AS SelPrice, a.nMinDownx AS MinDownx, b.nMiscChrg AS MiscChrg, b.nRebatesx AS Rebatesx, b.nEndMrtgg AS EndMrtgg, c.nAcctThru AS AcctThru, c.nFactorRt AS FactorRt FROM Mc_Model_Price a, MC_Category b, MC_Term_Category c WHERE a.sMCCatIDx = b.sMCCatIDx AND a.sMCCatIDx = c.sMCCatIDx AND a.sModelIDx = ? AND c.nAcctThru = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, Term);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mc_Model_Price","MC_Category","MC_Term_Category"}, false, new Callable<DRawDao.McAmortInfo>() {
      @Override
      public DRawDao.McAmortInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSelPrice = 0;
          final int _cursorIndexOfMinDownx = 1;
          final int _cursorIndexOfMiscChrg = 2;
          final int _cursorIndexOfRebatesx = 3;
          final int _cursorIndexOfEndMrtgg = 4;
          final int _cursorIndexOfAcctThru = 5;
          final int _cursorIndexOfFactorRt = 6;
          final DRawDao.McAmortInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new DRawDao.McAmortInfo();
            if (_cursor.isNull(_cursorIndexOfSelPrice)) {
              _result.SelPrice = null;
            } else {
              _result.SelPrice = _cursor.getString(_cursorIndexOfSelPrice);
            }
            if (_cursor.isNull(_cursorIndexOfMinDownx)) {
              _result.MinDownx = null;
            } else {
              _result.MinDownx = _cursor.getString(_cursorIndexOfMinDownx);
            }
            if (_cursor.isNull(_cursorIndexOfMiscChrg)) {
              _result.MiscChrg = null;
            } else {
              _result.MiscChrg = _cursor.getString(_cursorIndexOfMiscChrg);
            }
            if (_cursor.isNull(_cursorIndexOfRebatesx)) {
              _result.Rebatesx = null;
            } else {
              _result.Rebatesx = _cursor.getString(_cursorIndexOfRebatesx);
            }
            if (_cursor.isNull(_cursorIndexOfEndMrtgg)) {
              _result.EndMrtgg = null;
            } else {
              _result.EndMrtgg = _cursor.getString(_cursorIndexOfEndMrtgg);
            }
            if (_cursor.isNull(_cursorIndexOfAcctThru)) {
              _result.AcctThru = null;
            } else {
              _result.AcctThru = _cursor.getString(_cursorIndexOfAcctThru);
            }
            if (_cursor.isNull(_cursorIndexOfFactorRt)) {
              _result.FactorRt = null;
            } else {
              _result.FactorRt = _cursor.getString(_cursorIndexOfFactorRt);
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
  public LiveData<DRawDao.AppLocalData> getAppLocalData() {
    final String _sql = "SELECT (SELECT COUNT(*) FROM Branch_Info) AS Branch_Data,(SELECT COUNT(*) FROM Barangay_Info) AS Barangay_Data,(SELECT COUNT(*) FROM Town_Info) AS Town_Data,(SELECT COUNT(*) FROM Province_Info) AS Province_Data,(SELECT COUNT(*) FROM Country_Info) AS Country_Data,(SELECT COUNT(*) FROM MC_Brand) AS Mc_Brand,(SELECT COUNT(*) FROM Mc_Model) AS Mc_Model,(SELECT COUNT(*) FROM MC_Category) AS Mc_Category,(SELECT COUNT(*) FROM Mc_Model_Price) AS Mc_Model_Price,(SELECT COUNT(*) FROM MC_Term_Category) AS Mc_Term_Category,(SELECT COUNT(*) FROM Occupation_Info) AS Occupation_Data,(SELECT COUNT(*) FROM FB_Raffle_Transaction_Basis) AS Raffle_Basis,(SELECT COUNT(*) FROM EDocSys_File) AS File_Code,(SELECT COUNT(*) FROM Bank_Info) AS Bank_Data,(SELECT COUNT(*) FROM Collection_Account_Remittance) AS Remittance_Data,(SELECT COUNT(*) FROM Relation) AS Relation_Data, (SELECT COUNT(*) FROM XXXSCA_REQUEST) AS Approval_Code";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Branch_Info","Barangay_Info","Town_Info","Province_Info","Country_Info","MC_Brand","Mc_Model","MC_Category","Mc_Model_Price","MC_Term_Category","Occupation_Info","FB_Raffle_Transaction_Basis","EDocSys_File","Bank_Info","Collection_Account_Remittance","Relation","XXXSCA_REQUEST"}, false, new Callable<DRawDao.AppLocalData>() {
      @Override
      public DRawDao.AppLocalData call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBranchData = 0;
          final int _cursorIndexOfBarangayData = 1;
          final int _cursorIndexOfTownData = 2;
          final int _cursorIndexOfProvinceData = 3;
          final int _cursorIndexOfCountryData = 4;
          final int _cursorIndexOfMcBrand = 5;
          final int _cursorIndexOfMcModel = 6;
          final int _cursorIndexOfMcCategory = 7;
          final int _cursorIndexOfMcModelPrice = 8;
          final int _cursorIndexOfMcTermCategory = 9;
          final int _cursorIndexOfOccupationData = 10;
          final int _cursorIndexOfRaffleBasis = 11;
          final int _cursorIndexOfFileCode = 12;
          final int _cursorIndexOfBankData = 13;
          final int _cursorIndexOfRemittanceData = 14;
          final int _cursorIndexOfRelationData = 15;
          final int _cursorIndexOfApprovalCode = 16;
          final DRawDao.AppLocalData _result;
          if(_cursor.moveToFirst()) {
            _result = new DRawDao.AppLocalData();
            _result.Branch_Data = _cursor.getInt(_cursorIndexOfBranchData);
            _result.Barangay_Data = _cursor.getInt(_cursorIndexOfBarangayData);
            _result.Town_Data = _cursor.getInt(_cursorIndexOfTownData);
            _result.Province_Data = _cursor.getInt(_cursorIndexOfProvinceData);
            _result.Country_Data = _cursor.getInt(_cursorIndexOfCountryData);
            _result.Mc_Brand = _cursor.getInt(_cursorIndexOfMcBrand);
            _result.Mc_Model = _cursor.getInt(_cursorIndexOfMcModel);
            _result.Mc_Category = _cursor.getInt(_cursorIndexOfMcCategory);
            _result.Mc_Model_Price = _cursor.getInt(_cursorIndexOfMcModelPrice);
            _result.Mc_Term_Category = _cursor.getInt(_cursorIndexOfMcTermCategory);
            _result.Occupation_Data = _cursor.getInt(_cursorIndexOfOccupationData);
            _result.Raffle_Basis = _cursor.getInt(_cursorIndexOfRaffleBasis);
            _result.File_Code = _cursor.getInt(_cursorIndexOfFileCode);
            _result.Bank_Data = _cursor.getInt(_cursorIndexOfBankData);
            _result.Remittance_Data = _cursor.getInt(_cursorIndexOfRemittanceData);
            _result.Relation_Data = _cursor.getInt(_cursorIndexOfRelationData);
            _result.Approval_Code = _cursor.getInt(_cursorIndexOfApprovalCode);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
