package org.rmj.g3appdriver.FacilityTrack.room.DataAccessObject;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import org.rmj.g3appdriver.FacilityTrack.room.Entities.EPersonnelInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DAccountInfo_Impl implements DAccountInfo {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EPersonnelInfo> __insertionAdapterOfEPersonnelInfo;

  public DAccountInfo_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEPersonnelInfo = new EntityInsertionAdapter<EPersonnelInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `User_Info_Master` (`sClientID`,`sBranchCD`,`sBranchNm`,`sLogNoxxx`,`sUserIDxx`,`sEmailAdd`,`sUserName`,`nUserLevl`,`sDeptIDxx`,`sPositnID`,`sEmpLevID`,`cSlfieLog`,`cAllowUpd`,`dLoginxxx`,`sMobileNo`,`dSessionx`,`sEmployID`,`cPrivatex`,`sDeviceID`,`sModelIDx`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EPersonnelInfo value) {
        if (value.getClientID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getClientID());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCD());
        }
        if (value.getBranchNm() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getBranchNm());
        }
        if (value.getLogNoxxx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getLogNoxxx());
        }
        if (value.getUserIDxx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getUserIDxx());
        }
        if (value.getEmailAdd() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEmailAdd());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getUserName());
        }
        if (value.getUserLevl() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUserLevl());
        }
        if (value.getDeptIDxx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDeptIDxx());
        }
        if (value.getPositnID() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getPositnID());
        }
        if (value.getEmpLevID() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getEmpLevID());
        }
        if (value.getSlfieLog() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getSlfieLog());
        }
        if (value.getAllowUpd() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getAllowUpd());
        }
        if (value.getLoginxxx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getLoginxxx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getMobileNo());
        }
        if (value.getSessionx() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSessionx());
        }
        if (value.getEmployID() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getEmployID());
        }
        if (value.getPrivatex() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getPrivatex());
        }
        if (value.getDeviceID() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getDeviceID());
        }
        if (value.getModelIDx() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getModelIDx());
        }
      }
    };
  }

  @Override
  public void Save(final EPersonnelInfo foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEPersonnelInfo.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
