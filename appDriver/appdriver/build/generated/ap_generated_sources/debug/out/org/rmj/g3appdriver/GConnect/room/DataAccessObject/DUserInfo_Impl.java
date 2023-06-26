package org.rmj.g3appdriver.GConnect.room.DataAccessObject;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import org.rmj.g3appdriver.GConnect.room.Entities.EClientInfo;
import org.rmj.g3appdriver.GConnect.room.Entities.EUserInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DUserInfo_Impl implements DUserInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EUserInfo> __insertionAdapterOfEUserInfo;

  private final EntityDeletionOrUpdateAdapter<EUserInfo> __updateAdapterOfEUserInfo;

  public DUserInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEUserInfo = new EntityInsertionAdapter<EUserInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tbl_user` (`name`,`gcard_number`,`avl_points`,`d_modified`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EUserInfo value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getGcard_number() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGcard_number());
        }
        stmt.bindDouble(3, value.getAvl_points());
        if (value.getD_modified() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getD_modified());
        }
      }
    };
    this.__updateAdapterOfEUserInfo = new EntityDeletionOrUpdateAdapter<EUserInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `tbl_user` SET `name` = ?,`gcard_number` = ?,`avl_points` = ?,`d_modified` = ? WHERE `name` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EUserInfo value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getGcard_number() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGcard_number());
        }
        stmt.bindDouble(3, value.getAvl_points());
        if (value.getD_modified() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getD_modified());
        }
        if (value.getName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getName());
        }
      }
    };
  }

  @Override
  public void insert(final EUserInfo eUserInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEUserInfo.insert(eUserInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EUserInfo> eUserInfoList) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEUserInfo.insert(eUserInfoList);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EUserInfo eUserInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEUserInfo.handle(eUserInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public EClientInfo getUserInfo() {
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
