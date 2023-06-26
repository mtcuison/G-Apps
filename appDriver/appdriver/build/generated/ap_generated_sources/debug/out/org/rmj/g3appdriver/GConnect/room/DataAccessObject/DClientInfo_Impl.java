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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GConnect.room.Entities.EClientInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.EEmailInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.EMobileInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DClientInfo_Impl implements DClientInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EClientInfo> __insertionAdapterOfEClientInfo;

  private final EntityDeletionOrUpdateAdapter<EClientInfo> __updateAdapterOfEClientInfo;

  private final SharedSQLiteStatement __preparedStmtOfLogoutAccount;

  private final SharedSQLiteStatement __preparedStmtOfLogoutGcard;

  private final SharedSQLiteStatement __preparedStmtOfLogoutItemCart;

  private final SharedSQLiteStatement __preparedStmtOfLogoutRedeemItem;

  private final SharedSQLiteStatement __preparedStmtOfLogoutServiceInfo;

  private final SharedSQLiteStatement __preparedStmtOfLogoutMCSerial;

  private final SharedSQLiteStatement __preparedStmtOfLogoutMasterPurchase;

  private final SharedSQLiteStatement __preparedStmtOfLogoutDetailPurchase;

  public DClientInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEClientInfo = new EntityInsertionAdapter<EClientInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Client_Profile_Info` (`sUserIDxx`,`sClientID`,`sEmailAdd`,`sUserName`,`sLastName`,`sFrstName`,`sMiddName`,`sSuffixNm`,`sMaidenNm`,`cGenderCd`,`cCvilStat`,`sCitizenx`,`dBirthDte`,`sBirthPlc`,`sHouseNo1`,`sAddress1`,`sBrgyIDx1`,`sTownIDx1`,`sHouseNo2`,`sAddress2`,`sBrgyIDx2`,`sTownIDx2`,`sTaxIDNox`,`cRecdStat`,`sMobileNo`,`cVerified`,`dVerified`,`cAgreeTnC`,`dDateMmbr`,`sImagePth`,`dImgeDate`,`cImgeStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EClientInfo value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getClientID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClientID());
        }
        if (value.getEmailAdd() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmailAdd());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLastName());
        }
        if (value.getFrstName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFrstName());
        }
        if (value.getMiddName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMiddName());
        }
        if (value.getSuffixNm() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSuffixNm());
        }
        if (value.getMaidenNm() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMaidenNm());
        }
        if (value.getGenderCd() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getGenderCd());
        }
        if (value.getCvilStat() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCvilStat());
        }
        if (value.getCitizenx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCitizenx());
        }
        if (value.getBirthDte() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getBirthDte());
        }
        if (value.getBirthPlc() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getBirthPlc());
        }
        if (value.getHouseNo1() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getHouseNo1());
        }
        if (value.getAddress1() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getAddress1());
        }
        if (value.getBrgyIDx1() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getBrgyIDx1());
        }
        if (value.getTownIDx1() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTownIDx1());
        }
        if (value.getHouseNo2() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getHouseNo2());
        }
        if (value.getAddress2() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getAddress2());
        }
        if (value.getBrgyIDx2() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getBrgyIDx2());
        }
        if (value.getTownIDx2() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getTownIDx2());
        }
        if (value.getTaxIDNox() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getTaxIDNox());
        }
        stmt.bindLong(24, value.getRecdStat());
        if (value.getMobileNo() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getMobileNo());
        }
        stmt.bindLong(26, value.getVerified());
        if (value.getDateVrfd() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getDateVrfd());
        }
        stmt.bindLong(28, value.getAgreeTnC());
        if (value.getDateMmbr() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getDateMmbr());
        }
        if (value.getImagePth() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getImagePth());
        }
        if (value.getImgeDate() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getImgeDate());
        }
        if (value.getImgeStat() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getImgeStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfEClientInfo = new EntityDeletionOrUpdateAdapter<EClientInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Client_Profile_Info` SET `sUserIDxx` = ?,`sClientID` = ?,`sEmailAdd` = ?,`sUserName` = ?,`sLastName` = ?,`sFrstName` = ?,`sMiddName` = ?,`sSuffixNm` = ?,`sMaidenNm` = ?,`cGenderCd` = ?,`cCvilStat` = ?,`sCitizenx` = ?,`dBirthDte` = ?,`sBirthPlc` = ?,`sHouseNo1` = ?,`sAddress1` = ?,`sBrgyIDx1` = ?,`sTownIDx1` = ?,`sHouseNo2` = ?,`sAddress2` = ?,`sBrgyIDx2` = ?,`sTownIDx2` = ?,`sTaxIDNox` = ?,`cRecdStat` = ?,`sMobileNo` = ?,`cVerified` = ?,`dVerified` = ?,`cAgreeTnC` = ?,`dDateMmbr` = ?,`sImagePth` = ?,`dImgeDate` = ?,`cImgeStat` = ?,`dTimeStmp` = ? WHERE `sUserIDxx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EClientInfo value) {
        if (value.getUserIDxx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserIDxx());
        }
        if (value.getClientID() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClientID());
        }
        if (value.getEmailAdd() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getEmailAdd());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getLastName());
        }
        if (value.getFrstName() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getFrstName());
        }
        if (value.getMiddName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getMiddName());
        }
        if (value.getSuffixNm() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSuffixNm());
        }
        if (value.getMaidenNm() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getMaidenNm());
        }
        if (value.getGenderCd() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getGenderCd());
        }
        if (value.getCvilStat() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCvilStat());
        }
        if (value.getCitizenx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getCitizenx());
        }
        if (value.getBirthDte() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getBirthDte());
        }
        if (value.getBirthPlc() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getBirthPlc());
        }
        if (value.getHouseNo1() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getHouseNo1());
        }
        if (value.getAddress1() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getAddress1());
        }
        if (value.getBrgyIDx1() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getBrgyIDx1());
        }
        if (value.getTownIDx1() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getTownIDx1());
        }
        if (value.getHouseNo2() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getHouseNo2());
        }
        if (value.getAddress2() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getAddress2());
        }
        if (value.getBrgyIDx2() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getBrgyIDx2());
        }
        if (value.getTownIDx2() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getTownIDx2());
        }
        if (value.getTaxIDNox() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getTaxIDNox());
        }
        stmt.bindLong(24, value.getRecdStat());
        if (value.getMobileNo() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getMobileNo());
        }
        stmt.bindLong(26, value.getVerified());
        if (value.getDateVrfd() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getDateVrfd());
        }
        stmt.bindLong(28, value.getAgreeTnC());
        if (value.getDateMmbr() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getDateMmbr());
        }
        if (value.getImagePth() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getImagePth());
        }
        if (value.getImgeDate() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getImgeDate());
        }
        if (value.getImgeStat() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getImgeStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getTimeStmp());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getUserIDxx());
        }
      }
    };
    this.__preparedStmtOfLogoutAccount = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Client_Profile_Info";
        return _query;
      }
    };
    this.__preparedStmtOfLogoutGcard = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM GCard_App_Master";
        return _query;
      }
    };
    this.__preparedStmtOfLogoutItemCart = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MarketPlace_Cart";
        return _query;
      }
    };
    this.__preparedStmtOfLogoutRedeemItem = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM Redeem_Item";
        return _query;
      }
    };
    this.__preparedStmtOfLogoutServiceInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MC_Service";
        return _query;
      }
    };
    this.__preparedStmtOfLogoutMCSerial = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MC_Serial_Registration";
        return _query;
      }
    };
    this.__preparedStmtOfLogoutMasterPurchase = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MarketPlace_Order_Master";
        return _query;
      }
    };
    this.__preparedStmtOfLogoutDetailPurchase = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM MarketPlace_Order_Detail";
        return _query;
      }
    };
  }

  @Override
  public void insert(final EClientInfo eClientInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEClientInfo.insert(eClientInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EClientInfo> eClientInfoList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEClientInfo.insert(eClientInfoList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EClientInfo eClientInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEClientInfo.handle(eClientInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void LogoutAccount() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLogoutAccount.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLogoutAccount.release(_stmt);
    }
  }

  @Override
  public void LogoutGcard() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLogoutGcard.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLogoutGcard.release(_stmt);
    }
  }

  @Override
  public void LogoutItemCart() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLogoutItemCart.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLogoutItemCart.release(_stmt);
    }
  }

  @Override
  public void LogoutGcardLedger() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLogoutGcard.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLogoutGcard.release(_stmt);
    }
  }

  @Override
  public void LogoutRedeemItem() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLogoutRedeemItem.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLogoutRedeemItem.release(_stmt);
    }
  }

  @Override
  public void LogoutServiceInfo() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLogoutServiceInfo.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLogoutServiceInfo.release(_stmt);
    }
  }

  @Override
  public void LogoutMCSerial() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLogoutMCSerial.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLogoutMCSerial.release(_stmt);
    }
  }

  @Override
  public void LogoutMasterPurchase() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLogoutMasterPurchase.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLogoutMasterPurchase.release(_stmt);
    }
  }

  @Override
  public void LogoutDetailPurchase() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfLogoutDetailPurchase.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfLogoutDetailPurchase.release(_stmt);
    }
  }

  @Override
  public EClientInfo GetUserInfo() {
    final String _sql = "SELECT * FROM Client_Profile_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
      final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserName");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "sLastName");
      final int _cursorIndexOfFrstName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFrstName");
      final int _cursorIndexOfMiddName = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiddName");
      final int _cursorIndexOfSuffixNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSuffixNm");
      final int _cursorIndexOfMaidenNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sMaidenNm");
      final int _cursorIndexOfGenderCd = CursorUtil.getColumnIndexOrThrow(_cursor, "cGenderCd");
      final int _cursorIndexOfCvilStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cCvilStat");
      final int _cursorIndexOfCitizenx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCitizenx");
      final int _cursorIndexOfBirthDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthDte");
      final int _cursorIndexOfBirthPlc = CursorUtil.getColumnIndexOrThrow(_cursor, "sBirthPlc");
      final int _cursorIndexOfHouseNo1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNo1");
      final int _cursorIndexOfAddress1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress1");
      final int _cursorIndexOfBrgyIDx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDx1");
      final int _cursorIndexOfTownIDx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDx1");
      final int _cursorIndexOfHouseNo2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNo2");
      final int _cursorIndexOfAddress2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress2");
      final int _cursorIndexOfBrgyIDx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDx2");
      final int _cursorIndexOfTownIDx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDx2");
      final int _cursorIndexOfTaxIDNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTaxIDNox");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "cVerified");
      final int _cursorIndexOfDateVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfAgreeTnC = CursorUtil.getColumnIndexOrThrow(_cursor, "cAgreeTnC");
      final int _cursorIndexOfDateMmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateMmbr");
      final int _cursorIndexOfImagePth = CursorUtil.getColumnIndexOrThrow(_cursor, "sImagePth");
      final int _cursorIndexOfImgeDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dImgeDate");
      final int _cursorIndexOfImgeStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cImgeStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EClientInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EClientInfo();
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpEmailAdd;
        if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
          _tmpEmailAdd = null;
        } else {
          _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
        }
        _result.setEmailAdd(_tmpEmailAdd);
        final String _tmpUserName;
        if (_cursor.isNull(_cursorIndexOfUserName)) {
          _tmpUserName = null;
        } else {
          _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        }
        _result.setUserName(_tmpUserName);
        final String _tmpLastName;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLastName = null;
        } else {
          _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        }
        _result.setLastName(_tmpLastName);
        final String _tmpFrstName;
        if (_cursor.isNull(_cursorIndexOfFrstName)) {
          _tmpFrstName = null;
        } else {
          _tmpFrstName = _cursor.getString(_cursorIndexOfFrstName);
        }
        _result.setFrstName(_tmpFrstName);
        final String _tmpMiddName;
        if (_cursor.isNull(_cursorIndexOfMiddName)) {
          _tmpMiddName = null;
        } else {
          _tmpMiddName = _cursor.getString(_cursorIndexOfMiddName);
        }
        _result.setMiddName(_tmpMiddName);
        final String _tmpSuffixNm;
        if (_cursor.isNull(_cursorIndexOfSuffixNm)) {
          _tmpSuffixNm = null;
        } else {
          _tmpSuffixNm = _cursor.getString(_cursorIndexOfSuffixNm);
        }
        _result.setSuffixNm(_tmpSuffixNm);
        final String _tmpMaidenNm;
        if (_cursor.isNull(_cursorIndexOfMaidenNm)) {
          _tmpMaidenNm = null;
        } else {
          _tmpMaidenNm = _cursor.getString(_cursorIndexOfMaidenNm);
        }
        _result.setMaidenNm(_tmpMaidenNm);
        final String _tmpGenderCd;
        if (_cursor.isNull(_cursorIndexOfGenderCd)) {
          _tmpGenderCd = null;
        } else {
          _tmpGenderCd = _cursor.getString(_cursorIndexOfGenderCd);
        }
        _result.setGenderCd(_tmpGenderCd);
        final String _tmpCvilStat;
        if (_cursor.isNull(_cursorIndexOfCvilStat)) {
          _tmpCvilStat = null;
        } else {
          _tmpCvilStat = _cursor.getString(_cursorIndexOfCvilStat);
        }
        _result.setCvilStat(_tmpCvilStat);
        final String _tmpCitizenx;
        if (_cursor.isNull(_cursorIndexOfCitizenx)) {
          _tmpCitizenx = null;
        } else {
          _tmpCitizenx = _cursor.getString(_cursorIndexOfCitizenx);
        }
        _result.setCitizenx(_tmpCitizenx);
        final String _tmpBirthDte;
        if (_cursor.isNull(_cursorIndexOfBirthDte)) {
          _tmpBirthDte = null;
        } else {
          _tmpBirthDte = _cursor.getString(_cursorIndexOfBirthDte);
        }
        _result.setBirthDte(_tmpBirthDte);
        final String _tmpBirthPlc;
        if (_cursor.isNull(_cursorIndexOfBirthPlc)) {
          _tmpBirthPlc = null;
        } else {
          _tmpBirthPlc = _cursor.getString(_cursorIndexOfBirthPlc);
        }
        _result.setBirthPlc(_tmpBirthPlc);
        final String _tmpHouseNo1;
        if (_cursor.isNull(_cursorIndexOfHouseNo1)) {
          _tmpHouseNo1 = null;
        } else {
          _tmpHouseNo1 = _cursor.getString(_cursorIndexOfHouseNo1);
        }
        _result.setHouseNo1(_tmpHouseNo1);
        final String _tmpAddress1;
        if (_cursor.isNull(_cursorIndexOfAddress1)) {
          _tmpAddress1 = null;
        } else {
          _tmpAddress1 = _cursor.getString(_cursorIndexOfAddress1);
        }
        _result.setAddress1(_tmpAddress1);
        final String _tmpBrgyIDx1;
        if (_cursor.isNull(_cursorIndexOfBrgyIDx1)) {
          _tmpBrgyIDx1 = null;
        } else {
          _tmpBrgyIDx1 = _cursor.getString(_cursorIndexOfBrgyIDx1);
        }
        _result.setBrgyIDx1(_tmpBrgyIDx1);
        final String _tmpTownIDx1;
        if (_cursor.isNull(_cursorIndexOfTownIDx1)) {
          _tmpTownIDx1 = null;
        } else {
          _tmpTownIDx1 = _cursor.getString(_cursorIndexOfTownIDx1);
        }
        _result.setTownIDx1(_tmpTownIDx1);
        final String _tmpHouseNo2;
        if (_cursor.isNull(_cursorIndexOfHouseNo2)) {
          _tmpHouseNo2 = null;
        } else {
          _tmpHouseNo2 = _cursor.getString(_cursorIndexOfHouseNo2);
        }
        _result.setHouseNo2(_tmpHouseNo2);
        final String _tmpAddress2;
        if (_cursor.isNull(_cursorIndexOfAddress2)) {
          _tmpAddress2 = null;
        } else {
          _tmpAddress2 = _cursor.getString(_cursorIndexOfAddress2);
        }
        _result.setAddress2(_tmpAddress2);
        final String _tmpBrgyIDx2;
        if (_cursor.isNull(_cursorIndexOfBrgyIDx2)) {
          _tmpBrgyIDx2 = null;
        } else {
          _tmpBrgyIDx2 = _cursor.getString(_cursorIndexOfBrgyIDx2);
        }
        _result.setBrgyIDx2(_tmpBrgyIDx2);
        final String _tmpTownIDx2;
        if (_cursor.isNull(_cursorIndexOfTownIDx2)) {
          _tmpTownIDx2 = null;
        } else {
          _tmpTownIDx2 = _cursor.getString(_cursorIndexOfTownIDx2);
        }
        _result.setTownIDx2(_tmpTownIDx2);
        final String _tmpTaxIDNox;
        if (_cursor.isNull(_cursorIndexOfTaxIDNox)) {
          _tmpTaxIDNox = null;
        } else {
          _tmpTaxIDNox = _cursor.getString(_cursorIndexOfTaxIDNox);
        }
        _result.setTaxIDNox(_tmpTaxIDNox);
        final int _tmpRecdStat;
        _tmpRecdStat = _cursor.getInt(_cursorIndexOfRecdStat);
        _result.setRecdStat(_tmpRecdStat);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final int _tmpVerified;
        _tmpVerified = _cursor.getInt(_cursorIndexOfVerified);
        _result.setVerified(_tmpVerified);
        final String _tmpDateVrfd;
        if (_cursor.isNull(_cursorIndexOfDateVrfd)) {
          _tmpDateVrfd = null;
        } else {
          _tmpDateVrfd = _cursor.getString(_cursorIndexOfDateVrfd);
        }
        _result.setDateVrfd(_tmpDateVrfd);
        final int _tmpAgreeTnC;
        _tmpAgreeTnC = _cursor.getInt(_cursorIndexOfAgreeTnC);
        _result.setAgreeTnC(_tmpAgreeTnC);
        final String _tmpDateMmbr;
        if (_cursor.isNull(_cursorIndexOfDateMmbr)) {
          _tmpDateMmbr = null;
        } else {
          _tmpDateMmbr = _cursor.getString(_cursorIndexOfDateMmbr);
        }
        _result.setDateMmbr(_tmpDateMmbr);
        final String _tmpImagePth;
        if (_cursor.isNull(_cursorIndexOfImagePth)) {
          _tmpImagePth = null;
        } else {
          _tmpImagePth = _cursor.getString(_cursorIndexOfImagePth);
        }
        _result.setImagePth(_tmpImagePth);
        final String _tmpImgeDate;
        if (_cursor.isNull(_cursorIndexOfImgeDate)) {
          _tmpImgeDate = null;
        } else {
          _tmpImgeDate = _cursor.getString(_cursorIndexOfImgeDate);
        }
        _result.setImgeDate(_tmpImgeDate);
        final String _tmpImgeStat;
        if (_cursor.isNull(_cursorIndexOfImgeStat)) {
          _tmpImgeStat = null;
        } else {
          _tmpImgeStat = _cursor.getString(_cursorIndexOfImgeStat);
        }
        _result.setImgeStat(_tmpImgeStat);
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
  public LiveData<EClientInfo> getClientInfo() {
    final String _sql = "SELECT * FROM Client_Profile_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Client_Profile_Info"}, false, new Callable<EClientInfo>() {
      @Override
      public EClientInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
          final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
          final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
          final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserName");
          final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "sLastName");
          final int _cursorIndexOfFrstName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFrstName");
          final int _cursorIndexOfMiddName = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiddName");
          final int _cursorIndexOfSuffixNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSuffixNm");
          final int _cursorIndexOfMaidenNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sMaidenNm");
          final int _cursorIndexOfGenderCd = CursorUtil.getColumnIndexOrThrow(_cursor, "cGenderCd");
          final int _cursorIndexOfCvilStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cCvilStat");
          final int _cursorIndexOfCitizenx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCitizenx");
          final int _cursorIndexOfBirthDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthDte");
          final int _cursorIndexOfBirthPlc = CursorUtil.getColumnIndexOrThrow(_cursor, "sBirthPlc");
          final int _cursorIndexOfHouseNo1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNo1");
          final int _cursorIndexOfAddress1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress1");
          final int _cursorIndexOfBrgyIDx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDx1");
          final int _cursorIndexOfTownIDx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDx1");
          final int _cursorIndexOfHouseNo2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNo2");
          final int _cursorIndexOfAddress2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress2");
          final int _cursorIndexOfBrgyIDx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDx2");
          final int _cursorIndexOfTownIDx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDx2");
          final int _cursorIndexOfTaxIDNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTaxIDNox");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
          final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "cVerified");
          final int _cursorIndexOfDateVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
          final int _cursorIndexOfAgreeTnC = CursorUtil.getColumnIndexOrThrow(_cursor, "cAgreeTnC");
          final int _cursorIndexOfDateMmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateMmbr");
          final int _cursorIndexOfImagePth = CursorUtil.getColumnIndexOrThrow(_cursor, "sImagePth");
          final int _cursorIndexOfImgeDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dImgeDate");
          final int _cursorIndexOfImgeStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cImgeStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final EClientInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new EClientInfo();
            final String _tmpUserIDxx;
            if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
              _tmpUserIDxx = null;
            } else {
              _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
            }
            _result.setUserIDxx(_tmpUserIDxx);
            final String _tmpClientID;
            if (_cursor.isNull(_cursorIndexOfClientID)) {
              _tmpClientID = null;
            } else {
              _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
            }
            _result.setClientID(_tmpClientID);
            final String _tmpEmailAdd;
            if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
              _tmpEmailAdd = null;
            } else {
              _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
            }
            _result.setEmailAdd(_tmpEmailAdd);
            final String _tmpUserName;
            if (_cursor.isNull(_cursorIndexOfUserName)) {
              _tmpUserName = null;
            } else {
              _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
            }
            _result.setUserName(_tmpUserName);
            final String _tmpLastName;
            if (_cursor.isNull(_cursorIndexOfLastName)) {
              _tmpLastName = null;
            } else {
              _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
            }
            _result.setLastName(_tmpLastName);
            final String _tmpFrstName;
            if (_cursor.isNull(_cursorIndexOfFrstName)) {
              _tmpFrstName = null;
            } else {
              _tmpFrstName = _cursor.getString(_cursorIndexOfFrstName);
            }
            _result.setFrstName(_tmpFrstName);
            final String _tmpMiddName;
            if (_cursor.isNull(_cursorIndexOfMiddName)) {
              _tmpMiddName = null;
            } else {
              _tmpMiddName = _cursor.getString(_cursorIndexOfMiddName);
            }
            _result.setMiddName(_tmpMiddName);
            final String _tmpSuffixNm;
            if (_cursor.isNull(_cursorIndexOfSuffixNm)) {
              _tmpSuffixNm = null;
            } else {
              _tmpSuffixNm = _cursor.getString(_cursorIndexOfSuffixNm);
            }
            _result.setSuffixNm(_tmpSuffixNm);
            final String _tmpMaidenNm;
            if (_cursor.isNull(_cursorIndexOfMaidenNm)) {
              _tmpMaidenNm = null;
            } else {
              _tmpMaidenNm = _cursor.getString(_cursorIndexOfMaidenNm);
            }
            _result.setMaidenNm(_tmpMaidenNm);
            final String _tmpGenderCd;
            if (_cursor.isNull(_cursorIndexOfGenderCd)) {
              _tmpGenderCd = null;
            } else {
              _tmpGenderCd = _cursor.getString(_cursorIndexOfGenderCd);
            }
            _result.setGenderCd(_tmpGenderCd);
            final String _tmpCvilStat;
            if (_cursor.isNull(_cursorIndexOfCvilStat)) {
              _tmpCvilStat = null;
            } else {
              _tmpCvilStat = _cursor.getString(_cursorIndexOfCvilStat);
            }
            _result.setCvilStat(_tmpCvilStat);
            final String _tmpCitizenx;
            if (_cursor.isNull(_cursorIndexOfCitizenx)) {
              _tmpCitizenx = null;
            } else {
              _tmpCitizenx = _cursor.getString(_cursorIndexOfCitizenx);
            }
            _result.setCitizenx(_tmpCitizenx);
            final String _tmpBirthDte;
            if (_cursor.isNull(_cursorIndexOfBirthDte)) {
              _tmpBirthDte = null;
            } else {
              _tmpBirthDte = _cursor.getString(_cursorIndexOfBirthDte);
            }
            _result.setBirthDte(_tmpBirthDte);
            final String _tmpBirthPlc;
            if (_cursor.isNull(_cursorIndexOfBirthPlc)) {
              _tmpBirthPlc = null;
            } else {
              _tmpBirthPlc = _cursor.getString(_cursorIndexOfBirthPlc);
            }
            _result.setBirthPlc(_tmpBirthPlc);
            final String _tmpHouseNo1;
            if (_cursor.isNull(_cursorIndexOfHouseNo1)) {
              _tmpHouseNo1 = null;
            } else {
              _tmpHouseNo1 = _cursor.getString(_cursorIndexOfHouseNo1);
            }
            _result.setHouseNo1(_tmpHouseNo1);
            final String _tmpAddress1;
            if (_cursor.isNull(_cursorIndexOfAddress1)) {
              _tmpAddress1 = null;
            } else {
              _tmpAddress1 = _cursor.getString(_cursorIndexOfAddress1);
            }
            _result.setAddress1(_tmpAddress1);
            final String _tmpBrgyIDx1;
            if (_cursor.isNull(_cursorIndexOfBrgyIDx1)) {
              _tmpBrgyIDx1 = null;
            } else {
              _tmpBrgyIDx1 = _cursor.getString(_cursorIndexOfBrgyIDx1);
            }
            _result.setBrgyIDx1(_tmpBrgyIDx1);
            final String _tmpTownIDx1;
            if (_cursor.isNull(_cursorIndexOfTownIDx1)) {
              _tmpTownIDx1 = null;
            } else {
              _tmpTownIDx1 = _cursor.getString(_cursorIndexOfTownIDx1);
            }
            _result.setTownIDx1(_tmpTownIDx1);
            final String _tmpHouseNo2;
            if (_cursor.isNull(_cursorIndexOfHouseNo2)) {
              _tmpHouseNo2 = null;
            } else {
              _tmpHouseNo2 = _cursor.getString(_cursorIndexOfHouseNo2);
            }
            _result.setHouseNo2(_tmpHouseNo2);
            final String _tmpAddress2;
            if (_cursor.isNull(_cursorIndexOfAddress2)) {
              _tmpAddress2 = null;
            } else {
              _tmpAddress2 = _cursor.getString(_cursorIndexOfAddress2);
            }
            _result.setAddress2(_tmpAddress2);
            final String _tmpBrgyIDx2;
            if (_cursor.isNull(_cursorIndexOfBrgyIDx2)) {
              _tmpBrgyIDx2 = null;
            } else {
              _tmpBrgyIDx2 = _cursor.getString(_cursorIndexOfBrgyIDx2);
            }
            _result.setBrgyIDx2(_tmpBrgyIDx2);
            final String _tmpTownIDx2;
            if (_cursor.isNull(_cursorIndexOfTownIDx2)) {
              _tmpTownIDx2 = null;
            } else {
              _tmpTownIDx2 = _cursor.getString(_cursorIndexOfTownIDx2);
            }
            _result.setTownIDx2(_tmpTownIDx2);
            final String _tmpTaxIDNox;
            if (_cursor.isNull(_cursorIndexOfTaxIDNox)) {
              _tmpTaxIDNox = null;
            } else {
              _tmpTaxIDNox = _cursor.getString(_cursorIndexOfTaxIDNox);
            }
            _result.setTaxIDNox(_tmpTaxIDNox);
            final int _tmpRecdStat;
            _tmpRecdStat = _cursor.getInt(_cursorIndexOfRecdStat);
            _result.setRecdStat(_tmpRecdStat);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _result.setMobileNo(_tmpMobileNo);
            final int _tmpVerified;
            _tmpVerified = _cursor.getInt(_cursorIndexOfVerified);
            _result.setVerified(_tmpVerified);
            final String _tmpDateVrfd;
            if (_cursor.isNull(_cursorIndexOfDateVrfd)) {
              _tmpDateVrfd = null;
            } else {
              _tmpDateVrfd = _cursor.getString(_cursorIndexOfDateVrfd);
            }
            _result.setDateVrfd(_tmpDateVrfd);
            final int _tmpAgreeTnC;
            _tmpAgreeTnC = _cursor.getInt(_cursorIndexOfAgreeTnC);
            _result.setAgreeTnC(_tmpAgreeTnC);
            final String _tmpDateMmbr;
            if (_cursor.isNull(_cursorIndexOfDateMmbr)) {
              _tmpDateMmbr = null;
            } else {
              _tmpDateMmbr = _cursor.getString(_cursorIndexOfDateMmbr);
            }
            _result.setDateMmbr(_tmpDateMmbr);
            final String _tmpImagePth;
            if (_cursor.isNull(_cursorIndexOfImagePth)) {
              _tmpImagePth = null;
            } else {
              _tmpImagePth = _cursor.getString(_cursorIndexOfImagePth);
            }
            _result.setImagePth(_tmpImagePth);
            final String _tmpImgeDate;
            if (_cursor.isNull(_cursorIndexOfImgeDate)) {
              _tmpImgeDate = null;
            } else {
              _tmpImgeDate = _cursor.getString(_cursorIndexOfImgeDate);
            }
            _result.setImgeDate(_tmpImgeDate);
            final String _tmpImgeStat;
            if (_cursor.isNull(_cursorIndexOfImgeStat)) {
              _tmpImgeStat = null;
            } else {
              _tmpImgeStat = _cursor.getString(_cursorIndexOfImgeStat);
            }
            _result.setImgeStat(_tmpImgeStat);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public String GetClientID() {
    final String _sql = "SELECT sClientID FROM Client_Profile_Info";
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
  public String GetUserID() {
    final String _sql = "SELECT sUserIDxx FROM Client_Profile_Info";
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
  public LiveData<DClientInfo.ClientBSAddress> getClientBSAddress() {
    final String _sql = "SELECT a.sHouseNo1, a.sAddress1, a.cVerified, (SELECT sBrgyName FROM Barangay_Info WHERE sBrgyIDxx = a.sBrgyIDx1) AS sBrgyNme1, (SELECT sTownName FROM Town_Info WHERE sTownIDxx = a.sTownIDx1) AS sTownNme1, (SELECT sProvName FROM Province_Info WHERE sProvIDxx = (SELECT sProvIDxx FROM Town_Info WHERE sTownIDxx = a.sTownIDx1)) AS sProvNme1, a.sHouseNo2, a.sAddress2, (SELECT sBrgyName FROM Barangay_Info WHERE sBrgyIDxx = a.sBrgyIDx2) AS sBrgyNme2, (SELECT sTownName FROM Town_Info WHERE sTownIDxx = a.sTownIDx2) AS sTownNme2, (SELECT sProvName FROM Province_Info WHERE sProvIDxx = (SELECT sProvIDxx FROM Town_Info WHERE sTownIDxx = a.sTownIDx2)) AS sProvNme2 FROM Client_Profile_Info a";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Barangay_Info","Town_Info","Province_Info","Client_Profile_Info"}, false, new Callable<DClientInfo.ClientBSAddress>() {
      @Override
      public DClientInfo.ClientBSAddress call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSHouseNo1 = 0;
          final int _cursorIndexOfSAddress1 = 1;
          final int _cursorIndexOfCVerified = 2;
          final int _cursorIndexOfSBrgyNme1 = 3;
          final int _cursorIndexOfSTownNme1 = 4;
          final int _cursorIndexOfSProvNme1 = 5;
          final int _cursorIndexOfSHouseNo2 = 6;
          final int _cursorIndexOfSAddress2 = 7;
          final int _cursorIndexOfSBrgyNme2 = 8;
          final int _cursorIndexOfSTownNme2 = 9;
          final int _cursorIndexOfSProvNme2 = 10;
          final DClientInfo.ClientBSAddress _result;
          if(_cursor.moveToFirst()) {
            _result = new DClientInfo.ClientBSAddress();
            if (_cursor.isNull(_cursorIndexOfSHouseNo1)) {
              _result.sHouseNo1 = null;
            } else {
              _result.sHouseNo1 = _cursor.getString(_cursorIndexOfSHouseNo1);
            }
            if (_cursor.isNull(_cursorIndexOfSAddress1)) {
              _result.sAddress1 = null;
            } else {
              _result.sAddress1 = _cursor.getString(_cursorIndexOfSAddress1);
            }
            if (_cursor.isNull(_cursorIndexOfCVerified)) {
              _result.cVerified = null;
            } else {
              _result.cVerified = _cursor.getString(_cursorIndexOfCVerified);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyNme1)) {
              _result.sBrgyNme1 = null;
            } else {
              _result.sBrgyNme1 = _cursor.getString(_cursorIndexOfSBrgyNme1);
            }
            if (_cursor.isNull(_cursorIndexOfSTownNme1)) {
              _result.sTownNme1 = null;
            } else {
              _result.sTownNme1 = _cursor.getString(_cursorIndexOfSTownNme1);
            }
            if (_cursor.isNull(_cursorIndexOfSProvNme1)) {
              _result.sProvNme1 = null;
            } else {
              _result.sProvNme1 = _cursor.getString(_cursorIndexOfSProvNme1);
            }
            if (_cursor.isNull(_cursorIndexOfSHouseNo2)) {
              _result.sHouseNo2 = null;
            } else {
              _result.sHouseNo2 = _cursor.getString(_cursorIndexOfSHouseNo2);
            }
            if (_cursor.isNull(_cursorIndexOfSAddress2)) {
              _result.sAddress2 = null;
            } else {
              _result.sAddress2 = _cursor.getString(_cursorIndexOfSAddress2);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyNme2)) {
              _result.sBrgyNme2 = null;
            } else {
              _result.sBrgyNme2 = _cursor.getString(_cursorIndexOfSBrgyNme2);
            }
            if (_cursor.isNull(_cursorIndexOfSTownNme2)) {
              _result.sTownNme2 = null;
            } else {
              _result.sTownNme2 = _cursor.getString(_cursorIndexOfSTownNme2);
            }
            if (_cursor.isNull(_cursorIndexOfSProvNme2)) {
              _result.sProvNme2 = null;
            } else {
              _result.sProvNme2 = _cursor.getString(_cursorIndexOfSProvNme2);
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
  public LiveData<DClientInfo.oAddressUpdate> GetBillingAddressInfoForUpdate() {
    final String _sql = "SELECT a.sHouseNo1 AS sHouseNox, a.sAddress1 AS sAddressx, a.sBrgyIDx1 AS sBrgyIDxx, a.sTownIDx1 AS sTownIDxx, (SELECT sBrgyName FROM Barangay_Info WHERE sBrgyIDxx = a.sBrgyIDx1) AS sBrgyName, (SELECT sTownName FROM Town_Info WHERE sTownIDxx = a.sTownIDx1) AS sTownName FROM Client_Profile_Info a";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Barangay_Info","Town_Info","Client_Profile_Info"}, false, new Callable<DClientInfo.oAddressUpdate>() {
      @Override
      public DClientInfo.oAddressUpdate call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSHouseNox = 0;
          final int _cursorIndexOfSAddressx = 1;
          final int _cursorIndexOfSBrgyIDxx = 2;
          final int _cursorIndexOfSTownIDxx = 3;
          final int _cursorIndexOfSBrgyName = 4;
          final int _cursorIndexOfSTownName = 5;
          final DClientInfo.oAddressUpdate _result;
          if(_cursor.moveToFirst()) {
            _result = new DClientInfo.oAddressUpdate();
            if (_cursor.isNull(_cursorIndexOfSHouseNox)) {
              _result.sHouseNox = null;
            } else {
              _result.sHouseNox = _cursor.getString(_cursorIndexOfSHouseNox);
            }
            if (_cursor.isNull(_cursorIndexOfSAddressx)) {
              _result.sAddressx = null;
            } else {
              _result.sAddressx = _cursor.getString(_cursorIndexOfSAddressx);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyIDxx)) {
              _result.sBrgyIDxx = null;
            } else {
              _result.sBrgyIDxx = _cursor.getString(_cursorIndexOfSBrgyIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSTownIDxx)) {
              _result.sTownIDxx = null;
            } else {
              _result.sTownIDxx = _cursor.getString(_cursorIndexOfSTownIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyName)) {
              _result.sBrgyName = null;
            } else {
              _result.sBrgyName = _cursor.getString(_cursorIndexOfSBrgyName);
            }
            if (_cursor.isNull(_cursorIndexOfSTownName)) {
              _result.sTownName = null;
            } else {
              _result.sTownName = _cursor.getString(_cursorIndexOfSTownName);
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
  public LiveData<DClientInfo.oAddressUpdate> GetShippingAddressInfoForUpdate() {
    final String _sql = "SELECT a.sHouseNo2 AS sHouseNox, a.sAddress2 AS sAddressx, a.sBrgyIDx2 AS sBrgyIDxx, a.sTownIDx2 AS sTownIDxx, (SELECT sBrgyName FROM Barangay_Info WHERE sBrgyIDxx = a.sBrgyIDx2) AS sBrgyName, (SELECT sTownName FROM Town_Info WHERE sTownIDxx = a.sTownIDx2) AS sTownName FROM Client_Profile_Info a";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Barangay_Info","Town_Info","Client_Profile_Info"}, false, new Callable<DClientInfo.oAddressUpdate>() {
      @Override
      public DClientInfo.oAddressUpdate call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSHouseNox = 0;
          final int _cursorIndexOfSAddressx = 1;
          final int _cursorIndexOfSBrgyIDxx = 2;
          final int _cursorIndexOfSTownIDxx = 3;
          final int _cursorIndexOfSBrgyName = 4;
          final int _cursorIndexOfSTownName = 5;
          final DClientInfo.oAddressUpdate _result;
          if(_cursor.moveToFirst()) {
            _result = new DClientInfo.oAddressUpdate();
            if (_cursor.isNull(_cursorIndexOfSHouseNox)) {
              _result.sHouseNox = null;
            } else {
              _result.sHouseNox = _cursor.getString(_cursorIndexOfSHouseNox);
            }
            if (_cursor.isNull(_cursorIndexOfSAddressx)) {
              _result.sAddressx = null;
            } else {
              _result.sAddressx = _cursor.getString(_cursorIndexOfSAddressx);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyIDxx)) {
              _result.sBrgyIDxx = null;
            } else {
              _result.sBrgyIDxx = _cursor.getString(_cursorIndexOfSBrgyIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSTownIDxx)) {
              _result.sTownIDxx = null;
            } else {
              _result.sTownIDxx = _cursor.getString(_cursorIndexOfSTownIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSBrgyName)) {
              _result.sBrgyName = null;
            } else {
              _result.sBrgyName = _cursor.getString(_cursorIndexOfSBrgyName);
            }
            if (_cursor.isNull(_cursorIndexOfSTownName)) {
              _result.sTownName = null;
            } else {
              _result.sTownName = _cursor.getString(_cursorIndexOfSTownName);
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
  public EClientInfo GetClientInfo() {
    final String _sql = "SELECT * FROM Client_Profile_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
      final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserName");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "sLastName");
      final int _cursorIndexOfFrstName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFrstName");
      final int _cursorIndexOfMiddName = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiddName");
      final int _cursorIndexOfSuffixNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSuffixNm");
      final int _cursorIndexOfMaidenNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sMaidenNm");
      final int _cursorIndexOfGenderCd = CursorUtil.getColumnIndexOrThrow(_cursor, "cGenderCd");
      final int _cursorIndexOfCvilStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cCvilStat");
      final int _cursorIndexOfCitizenx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCitizenx");
      final int _cursorIndexOfBirthDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthDte");
      final int _cursorIndexOfBirthPlc = CursorUtil.getColumnIndexOrThrow(_cursor, "sBirthPlc");
      final int _cursorIndexOfHouseNo1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNo1");
      final int _cursorIndexOfAddress1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress1");
      final int _cursorIndexOfBrgyIDx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDx1");
      final int _cursorIndexOfTownIDx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDx1");
      final int _cursorIndexOfHouseNo2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNo2");
      final int _cursorIndexOfAddress2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress2");
      final int _cursorIndexOfBrgyIDx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDx2");
      final int _cursorIndexOfTownIDx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDx2");
      final int _cursorIndexOfTaxIDNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTaxIDNox");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "cVerified");
      final int _cursorIndexOfDateVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfAgreeTnC = CursorUtil.getColumnIndexOrThrow(_cursor, "cAgreeTnC");
      final int _cursorIndexOfDateMmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateMmbr");
      final int _cursorIndexOfImagePth = CursorUtil.getColumnIndexOrThrow(_cursor, "sImagePth");
      final int _cursorIndexOfImgeDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dImgeDate");
      final int _cursorIndexOfImgeStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cImgeStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EClientInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EClientInfo();
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpEmailAdd;
        if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
          _tmpEmailAdd = null;
        } else {
          _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
        }
        _result.setEmailAdd(_tmpEmailAdd);
        final String _tmpUserName;
        if (_cursor.isNull(_cursorIndexOfUserName)) {
          _tmpUserName = null;
        } else {
          _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        }
        _result.setUserName(_tmpUserName);
        final String _tmpLastName;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLastName = null;
        } else {
          _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        }
        _result.setLastName(_tmpLastName);
        final String _tmpFrstName;
        if (_cursor.isNull(_cursorIndexOfFrstName)) {
          _tmpFrstName = null;
        } else {
          _tmpFrstName = _cursor.getString(_cursorIndexOfFrstName);
        }
        _result.setFrstName(_tmpFrstName);
        final String _tmpMiddName;
        if (_cursor.isNull(_cursorIndexOfMiddName)) {
          _tmpMiddName = null;
        } else {
          _tmpMiddName = _cursor.getString(_cursorIndexOfMiddName);
        }
        _result.setMiddName(_tmpMiddName);
        final String _tmpSuffixNm;
        if (_cursor.isNull(_cursorIndexOfSuffixNm)) {
          _tmpSuffixNm = null;
        } else {
          _tmpSuffixNm = _cursor.getString(_cursorIndexOfSuffixNm);
        }
        _result.setSuffixNm(_tmpSuffixNm);
        final String _tmpMaidenNm;
        if (_cursor.isNull(_cursorIndexOfMaidenNm)) {
          _tmpMaidenNm = null;
        } else {
          _tmpMaidenNm = _cursor.getString(_cursorIndexOfMaidenNm);
        }
        _result.setMaidenNm(_tmpMaidenNm);
        final String _tmpGenderCd;
        if (_cursor.isNull(_cursorIndexOfGenderCd)) {
          _tmpGenderCd = null;
        } else {
          _tmpGenderCd = _cursor.getString(_cursorIndexOfGenderCd);
        }
        _result.setGenderCd(_tmpGenderCd);
        final String _tmpCvilStat;
        if (_cursor.isNull(_cursorIndexOfCvilStat)) {
          _tmpCvilStat = null;
        } else {
          _tmpCvilStat = _cursor.getString(_cursorIndexOfCvilStat);
        }
        _result.setCvilStat(_tmpCvilStat);
        final String _tmpCitizenx;
        if (_cursor.isNull(_cursorIndexOfCitizenx)) {
          _tmpCitizenx = null;
        } else {
          _tmpCitizenx = _cursor.getString(_cursorIndexOfCitizenx);
        }
        _result.setCitizenx(_tmpCitizenx);
        final String _tmpBirthDte;
        if (_cursor.isNull(_cursorIndexOfBirthDte)) {
          _tmpBirthDte = null;
        } else {
          _tmpBirthDte = _cursor.getString(_cursorIndexOfBirthDte);
        }
        _result.setBirthDte(_tmpBirthDte);
        final String _tmpBirthPlc;
        if (_cursor.isNull(_cursorIndexOfBirthPlc)) {
          _tmpBirthPlc = null;
        } else {
          _tmpBirthPlc = _cursor.getString(_cursorIndexOfBirthPlc);
        }
        _result.setBirthPlc(_tmpBirthPlc);
        final String _tmpHouseNo1;
        if (_cursor.isNull(_cursorIndexOfHouseNo1)) {
          _tmpHouseNo1 = null;
        } else {
          _tmpHouseNo1 = _cursor.getString(_cursorIndexOfHouseNo1);
        }
        _result.setHouseNo1(_tmpHouseNo1);
        final String _tmpAddress1;
        if (_cursor.isNull(_cursorIndexOfAddress1)) {
          _tmpAddress1 = null;
        } else {
          _tmpAddress1 = _cursor.getString(_cursorIndexOfAddress1);
        }
        _result.setAddress1(_tmpAddress1);
        final String _tmpBrgyIDx1;
        if (_cursor.isNull(_cursorIndexOfBrgyIDx1)) {
          _tmpBrgyIDx1 = null;
        } else {
          _tmpBrgyIDx1 = _cursor.getString(_cursorIndexOfBrgyIDx1);
        }
        _result.setBrgyIDx1(_tmpBrgyIDx1);
        final String _tmpTownIDx1;
        if (_cursor.isNull(_cursorIndexOfTownIDx1)) {
          _tmpTownIDx1 = null;
        } else {
          _tmpTownIDx1 = _cursor.getString(_cursorIndexOfTownIDx1);
        }
        _result.setTownIDx1(_tmpTownIDx1);
        final String _tmpHouseNo2;
        if (_cursor.isNull(_cursorIndexOfHouseNo2)) {
          _tmpHouseNo2 = null;
        } else {
          _tmpHouseNo2 = _cursor.getString(_cursorIndexOfHouseNo2);
        }
        _result.setHouseNo2(_tmpHouseNo2);
        final String _tmpAddress2;
        if (_cursor.isNull(_cursorIndexOfAddress2)) {
          _tmpAddress2 = null;
        } else {
          _tmpAddress2 = _cursor.getString(_cursorIndexOfAddress2);
        }
        _result.setAddress2(_tmpAddress2);
        final String _tmpBrgyIDx2;
        if (_cursor.isNull(_cursorIndexOfBrgyIDx2)) {
          _tmpBrgyIDx2 = null;
        } else {
          _tmpBrgyIDx2 = _cursor.getString(_cursorIndexOfBrgyIDx2);
        }
        _result.setBrgyIDx2(_tmpBrgyIDx2);
        final String _tmpTownIDx2;
        if (_cursor.isNull(_cursorIndexOfTownIDx2)) {
          _tmpTownIDx2 = null;
        } else {
          _tmpTownIDx2 = _cursor.getString(_cursorIndexOfTownIDx2);
        }
        _result.setTownIDx2(_tmpTownIDx2);
        final String _tmpTaxIDNox;
        if (_cursor.isNull(_cursorIndexOfTaxIDNox)) {
          _tmpTaxIDNox = null;
        } else {
          _tmpTaxIDNox = _cursor.getString(_cursorIndexOfTaxIDNox);
        }
        _result.setTaxIDNox(_tmpTaxIDNox);
        final int _tmpRecdStat;
        _tmpRecdStat = _cursor.getInt(_cursorIndexOfRecdStat);
        _result.setRecdStat(_tmpRecdStat);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final int _tmpVerified;
        _tmpVerified = _cursor.getInt(_cursorIndexOfVerified);
        _result.setVerified(_tmpVerified);
        final String _tmpDateVrfd;
        if (_cursor.isNull(_cursorIndexOfDateVrfd)) {
          _tmpDateVrfd = null;
        } else {
          _tmpDateVrfd = _cursor.getString(_cursorIndexOfDateVrfd);
        }
        _result.setDateVrfd(_tmpDateVrfd);
        final int _tmpAgreeTnC;
        _tmpAgreeTnC = _cursor.getInt(_cursorIndexOfAgreeTnC);
        _result.setAgreeTnC(_tmpAgreeTnC);
        final String _tmpDateMmbr;
        if (_cursor.isNull(_cursorIndexOfDateMmbr)) {
          _tmpDateMmbr = null;
        } else {
          _tmpDateMmbr = _cursor.getString(_cursorIndexOfDateMmbr);
        }
        _result.setDateMmbr(_tmpDateMmbr);
        final String _tmpImagePth;
        if (_cursor.isNull(_cursorIndexOfImagePth)) {
          _tmpImagePth = null;
        } else {
          _tmpImagePth = _cursor.getString(_cursorIndexOfImagePth);
        }
        _result.setImagePth(_tmpImagePth);
        final String _tmpImgeDate;
        if (_cursor.isNull(_cursorIndexOfImgeDate)) {
          _tmpImgeDate = null;
        } else {
          _tmpImgeDate = _cursor.getString(_cursorIndexOfImgeDate);
        }
        _result.setImgeDate(_tmpImgeDate);
        final String _tmpImgeStat;
        if (_cursor.isNull(_cursorIndexOfImgeStat)) {
          _tmpImgeStat = null;
        } else {
          _tmpImgeStat = _cursor.getString(_cursorIndexOfImgeStat);
        }
        _result.setImgeStat(_tmpImgeStat);
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
  public EClientInfo GetClientCompleteDetail() {
    final String _sql = "SELECT * FROM Client_Profile_Info WHERE sLastName != '' AND sFrstName != '' AND dBirthDte != ''";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfClientID = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientID");
      final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
      final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserName");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "sLastName");
      final int _cursorIndexOfFrstName = CursorUtil.getColumnIndexOrThrow(_cursor, "sFrstName");
      final int _cursorIndexOfMiddName = CursorUtil.getColumnIndexOrThrow(_cursor, "sMiddName");
      final int _cursorIndexOfSuffixNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSuffixNm");
      final int _cursorIndexOfMaidenNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sMaidenNm");
      final int _cursorIndexOfGenderCd = CursorUtil.getColumnIndexOrThrow(_cursor, "cGenderCd");
      final int _cursorIndexOfCvilStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cCvilStat");
      final int _cursorIndexOfCitizenx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCitizenx");
      final int _cursorIndexOfBirthDte = CursorUtil.getColumnIndexOrThrow(_cursor, "dBirthDte");
      final int _cursorIndexOfBirthPlc = CursorUtil.getColumnIndexOrThrow(_cursor, "sBirthPlc");
      final int _cursorIndexOfHouseNo1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNo1");
      final int _cursorIndexOfAddress1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress1");
      final int _cursorIndexOfBrgyIDx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDx1");
      final int _cursorIndexOfTownIDx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDx1");
      final int _cursorIndexOfHouseNo2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sHouseNo2");
      final int _cursorIndexOfAddress2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress2");
      final int _cursorIndexOfBrgyIDx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrgyIDx2");
      final int _cursorIndexOfTownIDx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sTownIDx2");
      final int _cursorIndexOfTaxIDNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTaxIDNox");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "cVerified");
      final int _cursorIndexOfDateVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfAgreeTnC = CursorUtil.getColumnIndexOrThrow(_cursor, "cAgreeTnC");
      final int _cursorIndexOfDateMmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "dDateMmbr");
      final int _cursorIndexOfImagePth = CursorUtil.getColumnIndexOrThrow(_cursor, "sImagePth");
      final int _cursorIndexOfImgeDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dImgeDate");
      final int _cursorIndexOfImgeStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cImgeStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EClientInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EClientInfo();
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpClientID;
        if (_cursor.isNull(_cursorIndexOfClientID)) {
          _tmpClientID = null;
        } else {
          _tmpClientID = _cursor.getString(_cursorIndexOfClientID);
        }
        _result.setClientID(_tmpClientID);
        final String _tmpEmailAdd;
        if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
          _tmpEmailAdd = null;
        } else {
          _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
        }
        _result.setEmailAdd(_tmpEmailAdd);
        final String _tmpUserName;
        if (_cursor.isNull(_cursorIndexOfUserName)) {
          _tmpUserName = null;
        } else {
          _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        }
        _result.setUserName(_tmpUserName);
        final String _tmpLastName;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLastName = null;
        } else {
          _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        }
        _result.setLastName(_tmpLastName);
        final String _tmpFrstName;
        if (_cursor.isNull(_cursorIndexOfFrstName)) {
          _tmpFrstName = null;
        } else {
          _tmpFrstName = _cursor.getString(_cursorIndexOfFrstName);
        }
        _result.setFrstName(_tmpFrstName);
        final String _tmpMiddName;
        if (_cursor.isNull(_cursorIndexOfMiddName)) {
          _tmpMiddName = null;
        } else {
          _tmpMiddName = _cursor.getString(_cursorIndexOfMiddName);
        }
        _result.setMiddName(_tmpMiddName);
        final String _tmpSuffixNm;
        if (_cursor.isNull(_cursorIndexOfSuffixNm)) {
          _tmpSuffixNm = null;
        } else {
          _tmpSuffixNm = _cursor.getString(_cursorIndexOfSuffixNm);
        }
        _result.setSuffixNm(_tmpSuffixNm);
        final String _tmpMaidenNm;
        if (_cursor.isNull(_cursorIndexOfMaidenNm)) {
          _tmpMaidenNm = null;
        } else {
          _tmpMaidenNm = _cursor.getString(_cursorIndexOfMaidenNm);
        }
        _result.setMaidenNm(_tmpMaidenNm);
        final String _tmpGenderCd;
        if (_cursor.isNull(_cursorIndexOfGenderCd)) {
          _tmpGenderCd = null;
        } else {
          _tmpGenderCd = _cursor.getString(_cursorIndexOfGenderCd);
        }
        _result.setGenderCd(_tmpGenderCd);
        final String _tmpCvilStat;
        if (_cursor.isNull(_cursorIndexOfCvilStat)) {
          _tmpCvilStat = null;
        } else {
          _tmpCvilStat = _cursor.getString(_cursorIndexOfCvilStat);
        }
        _result.setCvilStat(_tmpCvilStat);
        final String _tmpCitizenx;
        if (_cursor.isNull(_cursorIndexOfCitizenx)) {
          _tmpCitizenx = null;
        } else {
          _tmpCitizenx = _cursor.getString(_cursorIndexOfCitizenx);
        }
        _result.setCitizenx(_tmpCitizenx);
        final String _tmpBirthDte;
        if (_cursor.isNull(_cursorIndexOfBirthDte)) {
          _tmpBirthDte = null;
        } else {
          _tmpBirthDte = _cursor.getString(_cursorIndexOfBirthDte);
        }
        _result.setBirthDte(_tmpBirthDte);
        final String _tmpBirthPlc;
        if (_cursor.isNull(_cursorIndexOfBirthPlc)) {
          _tmpBirthPlc = null;
        } else {
          _tmpBirthPlc = _cursor.getString(_cursorIndexOfBirthPlc);
        }
        _result.setBirthPlc(_tmpBirthPlc);
        final String _tmpHouseNo1;
        if (_cursor.isNull(_cursorIndexOfHouseNo1)) {
          _tmpHouseNo1 = null;
        } else {
          _tmpHouseNo1 = _cursor.getString(_cursorIndexOfHouseNo1);
        }
        _result.setHouseNo1(_tmpHouseNo1);
        final String _tmpAddress1;
        if (_cursor.isNull(_cursorIndexOfAddress1)) {
          _tmpAddress1 = null;
        } else {
          _tmpAddress1 = _cursor.getString(_cursorIndexOfAddress1);
        }
        _result.setAddress1(_tmpAddress1);
        final String _tmpBrgyIDx1;
        if (_cursor.isNull(_cursorIndexOfBrgyIDx1)) {
          _tmpBrgyIDx1 = null;
        } else {
          _tmpBrgyIDx1 = _cursor.getString(_cursorIndexOfBrgyIDx1);
        }
        _result.setBrgyIDx1(_tmpBrgyIDx1);
        final String _tmpTownIDx1;
        if (_cursor.isNull(_cursorIndexOfTownIDx1)) {
          _tmpTownIDx1 = null;
        } else {
          _tmpTownIDx1 = _cursor.getString(_cursorIndexOfTownIDx1);
        }
        _result.setTownIDx1(_tmpTownIDx1);
        final String _tmpHouseNo2;
        if (_cursor.isNull(_cursorIndexOfHouseNo2)) {
          _tmpHouseNo2 = null;
        } else {
          _tmpHouseNo2 = _cursor.getString(_cursorIndexOfHouseNo2);
        }
        _result.setHouseNo2(_tmpHouseNo2);
        final String _tmpAddress2;
        if (_cursor.isNull(_cursorIndexOfAddress2)) {
          _tmpAddress2 = null;
        } else {
          _tmpAddress2 = _cursor.getString(_cursorIndexOfAddress2);
        }
        _result.setAddress2(_tmpAddress2);
        final String _tmpBrgyIDx2;
        if (_cursor.isNull(_cursorIndexOfBrgyIDx2)) {
          _tmpBrgyIDx2 = null;
        } else {
          _tmpBrgyIDx2 = _cursor.getString(_cursorIndexOfBrgyIDx2);
        }
        _result.setBrgyIDx2(_tmpBrgyIDx2);
        final String _tmpTownIDx2;
        if (_cursor.isNull(_cursorIndexOfTownIDx2)) {
          _tmpTownIDx2 = null;
        } else {
          _tmpTownIDx2 = _cursor.getString(_cursorIndexOfTownIDx2);
        }
        _result.setTownIDx2(_tmpTownIDx2);
        final String _tmpTaxIDNox;
        if (_cursor.isNull(_cursorIndexOfTaxIDNox)) {
          _tmpTaxIDNox = null;
        } else {
          _tmpTaxIDNox = _cursor.getString(_cursorIndexOfTaxIDNox);
        }
        _result.setTaxIDNox(_tmpTaxIDNox);
        final int _tmpRecdStat;
        _tmpRecdStat = _cursor.getInt(_cursorIndexOfRecdStat);
        _result.setRecdStat(_tmpRecdStat);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final int _tmpVerified;
        _tmpVerified = _cursor.getInt(_cursorIndexOfVerified);
        _result.setVerified(_tmpVerified);
        final String _tmpDateVrfd;
        if (_cursor.isNull(_cursorIndexOfDateVrfd)) {
          _tmpDateVrfd = null;
        } else {
          _tmpDateVrfd = _cursor.getString(_cursorIndexOfDateVrfd);
        }
        _result.setDateVrfd(_tmpDateVrfd);
        final int _tmpAgreeTnC;
        _tmpAgreeTnC = _cursor.getInt(_cursorIndexOfAgreeTnC);
        _result.setAgreeTnC(_tmpAgreeTnC);
        final String _tmpDateMmbr;
        if (_cursor.isNull(_cursorIndexOfDateMmbr)) {
          _tmpDateMmbr = null;
        } else {
          _tmpDateMmbr = _cursor.getString(_cursorIndexOfDateMmbr);
        }
        _result.setDateMmbr(_tmpDateMmbr);
        final String _tmpImagePth;
        if (_cursor.isNull(_cursorIndexOfImagePth)) {
          _tmpImagePth = null;
        } else {
          _tmpImagePth = _cursor.getString(_cursorIndexOfImagePth);
        }
        _result.setImagePth(_tmpImagePth);
        final String _tmpImgeDate;
        if (_cursor.isNull(_cursorIndexOfImgeDate)) {
          _tmpImgeDate = null;
        } else {
          _tmpImgeDate = _cursor.getString(_cursorIndexOfImgeDate);
        }
        _result.setImgeDate(_tmpImgeDate);
        final String _tmpImgeStat;
        if (_cursor.isNull(_cursorIndexOfImgeStat)) {
          _tmpImgeStat = null;
        } else {
          _tmpImgeStat = _cursor.getString(_cursorIndexOfImgeStat);
        }
        _result.setImgeStat(_tmpImgeStat);
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
  public LiveData<DClientInfo.ClientDetail> GetClientDetailForPreview() {
    final String _sql = "SELECT a.sUserIDxx, a.sUserName, a.sLastName, a.sFrstName, a.sMiddName, a.sSuffixNm, a.cGenderCd, a.dBirthDte, b.sTownName || ', ' || c.sProvName AS sBirthPlc, a.cCvilStat, a.sEmailAdd, a.sMobileNo, a.sImagePth, a.cVerified FROM Client_Profile_Info a LEFT JOIN Town_Info b ON a.sBirthPlc = b.sTownIDxx LEFT JOIN Province_Info c ON b.sProvIDxx = c.sProvIDxx";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Client_Profile_Info","Town_Info","Province_Info"}, false, new Callable<DClientInfo.ClientDetail>() {
      @Override
      public DClientInfo.ClientDetail call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSUserIDxx = 0;
          final int _cursorIndexOfSUserName = 1;
          final int _cursorIndexOfSLastName = 2;
          final int _cursorIndexOfSFrstName = 3;
          final int _cursorIndexOfSMiddName = 4;
          final int _cursorIndexOfSSuffixNm = 5;
          final int _cursorIndexOfCGenderCd = 6;
          final int _cursorIndexOfDBirthDte = 7;
          final int _cursorIndexOfSBirthPlc = 8;
          final int _cursorIndexOfCCvilStat = 9;
          final int _cursorIndexOfSEmailAdd = 10;
          final int _cursorIndexOfSMobileNo = 11;
          final int _cursorIndexOfSImagePth = 12;
          final int _cursorIndexOfCVerified = 13;
          final DClientInfo.ClientDetail _result;
          if(_cursor.moveToFirst()) {
            _result = new DClientInfo.ClientDetail();
            if (_cursor.isNull(_cursorIndexOfSUserIDxx)) {
              _result.sUserIDxx = null;
            } else {
              _result.sUserIDxx = _cursor.getString(_cursorIndexOfSUserIDxx);
            }
            if (_cursor.isNull(_cursorIndexOfSUserName)) {
              _result.sUserName = null;
            } else {
              _result.sUserName = _cursor.getString(_cursorIndexOfSUserName);
            }
            if (_cursor.isNull(_cursorIndexOfSLastName)) {
              _result.sLastName = null;
            } else {
              _result.sLastName = _cursor.getString(_cursorIndexOfSLastName);
            }
            if (_cursor.isNull(_cursorIndexOfSFrstName)) {
              _result.sFrstName = null;
            } else {
              _result.sFrstName = _cursor.getString(_cursorIndexOfSFrstName);
            }
            if (_cursor.isNull(_cursorIndexOfSMiddName)) {
              _result.sMiddName = null;
            } else {
              _result.sMiddName = _cursor.getString(_cursorIndexOfSMiddName);
            }
            if (_cursor.isNull(_cursorIndexOfSSuffixNm)) {
              _result.sSuffixNm = null;
            } else {
              _result.sSuffixNm = _cursor.getString(_cursorIndexOfSSuffixNm);
            }
            if (_cursor.isNull(_cursorIndexOfCGenderCd)) {
              _result.cGenderCd = null;
            } else {
              _result.cGenderCd = _cursor.getString(_cursorIndexOfCGenderCd);
            }
            if (_cursor.isNull(_cursorIndexOfDBirthDte)) {
              _result.dBirthDte = null;
            } else {
              _result.dBirthDte = _cursor.getString(_cursorIndexOfDBirthDte);
            }
            if (_cursor.isNull(_cursorIndexOfSBirthPlc)) {
              _result.sBirthPlc = null;
            } else {
              _result.sBirthPlc = _cursor.getString(_cursorIndexOfSBirthPlc);
            }
            if (_cursor.isNull(_cursorIndexOfCCvilStat)) {
              _result.cCvilStat = null;
            } else {
              _result.cCvilStat = _cursor.getString(_cursorIndexOfCCvilStat);
            }
            if (_cursor.isNull(_cursorIndexOfSEmailAdd)) {
              _result.sEmailAdd = null;
            } else {
              _result.sEmailAdd = _cursor.getString(_cursorIndexOfSEmailAdd);
            }
            if (_cursor.isNull(_cursorIndexOfSMobileNo)) {
              _result.sMobileNo = null;
            } else {
              _result.sMobileNo = _cursor.getString(_cursorIndexOfSMobileNo);
            }
            if (_cursor.isNull(_cursorIndexOfSImagePth)) {
              _result.sImagePth = null;
            } else {
              _result.sImagePth = _cursor.getString(_cursorIndexOfSImagePth);
            }
            if (_cursor.isNull(_cursorIndexOfCVerified)) {
              _result.cVerified = null;
            } else {
              _result.cVerified = _cursor.getString(_cursorIndexOfCVerified);
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
  public EEmailInfo GetEmailInfo(final String args) {
    final String _sql = "SELECT * FROM Client_Email_Info WHERE sEmailAdd =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfEmailAdd = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmailAdd");
      final int _cursorIndexOfIsVerifd = CursorUtil.getColumnIndexOrThrow(_cursor, "cVerified");
      final int _cursorIndexOfDateVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EEmailInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EEmailInfo();
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpEmailAdd;
        if (_cursor.isNull(_cursorIndexOfEmailAdd)) {
          _tmpEmailAdd = null;
        } else {
          _tmpEmailAdd = _cursor.getString(_cursorIndexOfEmailAdd);
        }
        _result.setEmailAdd(_tmpEmailAdd);
        final int _tmpIsVerifd;
        _tmpIsVerifd = _cursor.getInt(_cursorIndexOfIsVerifd);
        _result.setIsVerifd(_tmpIsVerifd);
        final String _tmpDateVrfd;
        if (_cursor.isNull(_cursorIndexOfDateVrfd)) {
          _tmpDateVrfd = null;
        } else {
          _tmpDateVrfd = _cursor.getString(_cursorIndexOfDateVrfd);
        }
        _result.setDateVrfd(_tmpDateVrfd);
        final int _tmpRecdStat;
        _tmpRecdStat = _cursor.getInt(_cursorIndexOfRecdStat);
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
  public EMobileInfo GetMobileInfo(final String args) {
    final String _sql = "SELECT * FROM App_User_Mobile WHERE sMobileNo =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (args == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, args);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserIDxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sUserIDxx");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfUserVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "cUserVrfd");
      final int _cursorIndexOfDateVrfd = CursorUtil.getColumnIndexOrThrow(_cursor, "dUserVrfd");
      final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EMobileInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new EMobileInfo();
        final String _tmpUserIDxx;
        if (_cursor.isNull(_cursorIndexOfUserIDxx)) {
          _tmpUserIDxx = null;
        } else {
          _tmpUserIDxx = _cursor.getString(_cursorIndexOfUserIDxx);
        }
        _result.setUserIDxx(_tmpUserIDxx);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final int _tmpUserVrfd;
        _tmpUserVrfd = _cursor.getInt(_cursorIndexOfUserVrfd);
        _result.setUserVrfd(_tmpUserVrfd);
        final String _tmpDateVrfd;
        if (_cursor.isNull(_cursorIndexOfDateVrfd)) {
          _tmpDateVrfd = null;
        } else {
          _tmpDateVrfd = _cursor.getString(_cursorIndexOfDateVrfd);
        }
        _result.setDateVrfd(_tmpDateVrfd);
        final String _tmpVerified;
        if (_cursor.isNull(_cursorIndexOfVerified)) {
          _tmpVerified = null;
        } else {
          _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
        }
        _result.setVerified(_tmpVerified);
        final int _tmpRecdStat;
        _tmpRecdStat = _cursor.getInt(_cursorIndexOfRecdStat);
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
