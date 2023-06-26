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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.ECIEvaluation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DCIEvaluation_Impl implements DCIEvaluation {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ECIEvaluation> __insertionAdapterOfECIEvaluation;

  private final EntityDeletionOrUpdateAdapter<ECIEvaluation> __updateAdapterOfECIEvaluation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateCIInfo;

  public DCIEvaluation_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfECIEvaluation = new EntityInsertionAdapter<ECIEvaluation>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Credit_Online_Application_List_CI` (`sTransNox`,`sCredInvx`,`sLandMark`,`cOwnershp`,`cOwnOther`,`cHouseTyp`,`cGaragexx`,`nLatitude`,`nLongitud`,`cHasOther`,`cHasRecrd`,`sRemRecrd`,`sNeighbr1`,`sAddress1`,`sReltnCD1`,`sMobileN1`,`cFeedBck1`,`sFeedBck1`,`sNeighbr2`,`sAddress2`,`sReltnCD2`,`sMobileN2`,`cFeedBck2`,`sFBRemrk2`,`sNeighbr3`,`sAddress3`,`sReltnCD3`,`sMobileN3`,`cFeedBck3`,`sFBRemrk3`,`nWaterBil`,`nElctrcBl`,`nFoodAllw`,`nLoanAmtx`,`nEducExpn`,`nOthrExpn`,`cGamblerx`,`cWomanizr`,`cHvyBrwer`,`cWithRepo`,`cWithMort`,`cArrogant`,`sOtherBad`,`sRemarksx`,`cTranStat`,`dApproved`,`dReceived`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECIEvaluation value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getCredInvx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCredInvx());
        }
        if (value.getLandMark() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLandMark());
        }
        if (value.getOwnershp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOwnershp());
        }
        if (value.getOwnOther() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOwnOther());
        }
        if (value.getHouseTyp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getHouseTyp());
        }
        if (value.getGaragexx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGaragexx());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLatitude());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLongitud());
        }
        if (value.getHasOther() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getHasOther());
        }
        if (value.getHasRecrd() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getHasRecrd());
        }
        if (value.getRemRecrd() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getRemRecrd());
        }
        if (value.getNeighbr1() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getNeighbr1());
        }
        if (value.getAddress1() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getAddress1());
        }
        if (value.getReltnCD1() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getReltnCD1());
        }
        if (value.getMobileN1() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getMobileN1());
        }
        if (value.getFeedBck1() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getFeedBck1());
        }
        if (value.getFBRemrk1() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getFBRemrk1());
        }
        if (value.getNeighbr2() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getNeighbr2());
        }
        if (value.getAddress2() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getAddress2());
        }
        if (value.getReltnCD2() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getReltnCD2());
        }
        if (value.getMobileN2() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getMobileN2());
        }
        if (value.getFeedBck2() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getFeedBck2());
        }
        if (value.getFBRemrk2() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getFBRemrk2());
        }
        if (value.getNeighbr3() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getNeighbr3());
        }
        if (value.getAddress3() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getAddress3());
        }
        if (value.getReltnCD3() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getReltnCD3());
        }
        if (value.getMobileN3() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getMobileN3());
        }
        if (value.getFeedBck3() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getFeedBck3());
        }
        if (value.getFBRemrk3() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getFBRemrk3());
        }
        if (value.getWaterBil() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getWaterBil());
        }
        if (value.getElctrcBl() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getElctrcBl());
        }
        if (value.getFoodAllw() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getFoodAllw());
        }
        if (value.getLoanAmtx() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getLoanAmtx());
        }
        if (value.getEducExpn() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getEducExpn());
        }
        if (value.getOthrExpn() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getOthrExpn());
        }
        if (value.getGamblerx() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getGamblerx());
        }
        if (value.getWomanizr() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getWomanizr());
        }
        if (value.getHvyBrwer() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, value.getHvyBrwer());
        }
        if (value.getWithRepo() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindString(40, value.getWithRepo());
        }
        if (value.getWithMort() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindString(41, value.getWithMort());
        }
        if (value.getArrogant() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindString(42, value.getArrogant());
        }
        if (value.getOtherBad() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, value.getOtherBad());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindString(44, value.getRemarksx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindString(45, value.getTranStat());
        }
        if (value.getApproved() == null) {
          stmt.bindNull(46);
        } else {
          stmt.bindString(46, value.getApproved());
        }
        if (value.getReceived() == null) {
          stmt.bindNull(47);
        } else {
          stmt.bindString(47, value.getReceived());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(48);
        } else {
          stmt.bindString(48, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfECIEvaluation = new EntityDeletionOrUpdateAdapter<ECIEvaluation>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `Credit_Online_Application_List_CI` SET `sTransNox` = ?,`sCredInvx` = ?,`sLandMark` = ?,`cOwnershp` = ?,`cOwnOther` = ?,`cHouseTyp` = ?,`cGaragexx` = ?,`nLatitude` = ?,`nLongitud` = ?,`cHasOther` = ?,`cHasRecrd` = ?,`sRemRecrd` = ?,`sNeighbr1` = ?,`sAddress1` = ?,`sReltnCD1` = ?,`sMobileN1` = ?,`cFeedBck1` = ?,`sFeedBck1` = ?,`sNeighbr2` = ?,`sAddress2` = ?,`sReltnCD2` = ?,`sMobileN2` = ?,`cFeedBck2` = ?,`sFBRemrk2` = ?,`sNeighbr3` = ?,`sAddress3` = ?,`sReltnCD3` = ?,`sMobileN3` = ?,`cFeedBck3` = ?,`sFBRemrk3` = ?,`nWaterBil` = ?,`nElctrcBl` = ?,`nFoodAllw` = ?,`nLoanAmtx` = ?,`nEducExpn` = ?,`nOthrExpn` = ?,`cGamblerx` = ?,`cWomanizr` = ?,`cHvyBrwer` = ?,`cWithRepo` = ?,`cWithMort` = ?,`cArrogant` = ?,`sOtherBad` = ?,`sRemarksx` = ?,`cTranStat` = ?,`dApproved` = ?,`dReceived` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECIEvaluation value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getCredInvx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCredInvx());
        }
        if (value.getLandMark() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLandMark());
        }
        if (value.getOwnershp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getOwnershp());
        }
        if (value.getOwnOther() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getOwnOther());
        }
        if (value.getHouseTyp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getHouseTyp());
        }
        if (value.getGaragexx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGaragexx());
        }
        if (value.getLatitude() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getLatitude());
        }
        if (value.getLongitud() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getLongitud());
        }
        if (value.getHasOther() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getHasOther());
        }
        if (value.getHasRecrd() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getHasRecrd());
        }
        if (value.getRemRecrd() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getRemRecrd());
        }
        if (value.getNeighbr1() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getNeighbr1());
        }
        if (value.getAddress1() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getAddress1());
        }
        if (value.getReltnCD1() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getReltnCD1());
        }
        if (value.getMobileN1() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getMobileN1());
        }
        if (value.getFeedBck1() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getFeedBck1());
        }
        if (value.getFBRemrk1() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getFBRemrk1());
        }
        if (value.getNeighbr2() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getNeighbr2());
        }
        if (value.getAddress2() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getAddress2());
        }
        if (value.getReltnCD2() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getReltnCD2());
        }
        if (value.getMobileN2() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getMobileN2());
        }
        if (value.getFeedBck2() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getFeedBck2());
        }
        if (value.getFBRemrk2() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getFBRemrk2());
        }
        if (value.getNeighbr3() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getNeighbr3());
        }
        if (value.getAddress3() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getAddress3());
        }
        if (value.getReltnCD3() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getReltnCD3());
        }
        if (value.getMobileN3() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getMobileN3());
        }
        if (value.getFeedBck3() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getFeedBck3());
        }
        if (value.getFBRemrk3() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getFBRemrk3());
        }
        if (value.getWaterBil() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getWaterBil());
        }
        if (value.getElctrcBl() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getElctrcBl());
        }
        if (value.getFoodAllw() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getFoodAllw());
        }
        if (value.getLoanAmtx() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getLoanAmtx());
        }
        if (value.getEducExpn() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getEducExpn());
        }
        if (value.getOthrExpn() == null) {
          stmt.bindNull(36);
        } else {
          stmt.bindString(36, value.getOthrExpn());
        }
        if (value.getGamblerx() == null) {
          stmt.bindNull(37);
        } else {
          stmt.bindString(37, value.getGamblerx());
        }
        if (value.getWomanizr() == null) {
          stmt.bindNull(38);
        } else {
          stmt.bindString(38, value.getWomanizr());
        }
        if (value.getHvyBrwer() == null) {
          stmt.bindNull(39);
        } else {
          stmt.bindString(39, value.getHvyBrwer());
        }
        if (value.getWithRepo() == null) {
          stmt.bindNull(40);
        } else {
          stmt.bindString(40, value.getWithRepo());
        }
        if (value.getWithMort() == null) {
          stmt.bindNull(41);
        } else {
          stmt.bindString(41, value.getWithMort());
        }
        if (value.getArrogant() == null) {
          stmt.bindNull(42);
        } else {
          stmt.bindString(42, value.getArrogant());
        }
        if (value.getOtherBad() == null) {
          stmt.bindNull(43);
        } else {
          stmt.bindString(43, value.getOtherBad());
        }
        if (value.getRemarksx() == null) {
          stmt.bindNull(44);
        } else {
          stmt.bindString(44, value.getRemarksx());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(45);
        } else {
          stmt.bindString(45, value.getTranStat());
        }
        if (value.getApproved() == null) {
          stmt.bindNull(46);
        } else {
          stmt.bindString(46, value.getApproved());
        }
        if (value.getReceived() == null) {
          stmt.bindNull(47);
        } else {
          stmt.bindString(47, value.getReceived());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(48);
        } else {
          stmt.bindString(48, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(49);
        } else {
          stmt.bindString(49, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateCIInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_List_CI SET sLandMark =?, cOwnershp =?, cOwnOther =?, cHouseTyp =?, cGaragexx =?, nLatitude =?, nLongitud =? WHERE sTransNox =? ";
        return _query;
      }
    };
  }

  @Override
  public void insert(final ECIEvaluation eciEvaluation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECIEvaluation.insert(eciEvaluation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertNewCiApplication(final ECIEvaluation eciEvaluation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECIEvaluation.insert(eciEvaluation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final ECIEvaluation eciEvaluation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfECIEvaluation.handle(eciEvaluation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateCIInfo(final String TransNox, final String LandMark, final String Ownershp,
      final String OwnOther, final String HouseTyp, final String Garagexx, final String Latitude,
      final String Longitud) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateCIInfo.acquire();
    int _argIndex = 1;
    if (LandMark == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, LandMark);
    }
    _argIndex = 2;
    if (Ownershp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Ownershp);
    }
    _argIndex = 3;
    if (OwnOther == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, OwnOther);
    }
    _argIndex = 4;
    if (HouseTyp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, HouseTyp);
    }
    _argIndex = 5;
    if (Garagexx == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Garagexx);
    }
    _argIndex = 6;
    if (Latitude == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Latitude);
    }
    _argIndex = 7;
    if (Longitud == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Longitud);
    }
    _argIndex = 8;
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
      __preparedStmtOfUpdateCIInfo.release(_stmt);
    }
  }

  @Override
  public LiveData<ECIEvaluation> getCIInfoOfTransNox(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Online_Application_List_CI WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_List_CI"}, false, new Callable<ECIEvaluation>() {
      @Override
      public ECIEvaluation call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
          final int _cursorIndexOfLandMark = CursorUtil.getColumnIndexOrThrow(_cursor, "sLandMark");
          final int _cursorIndexOfOwnershp = CursorUtil.getColumnIndexOrThrow(_cursor, "cOwnershp");
          final int _cursorIndexOfOwnOther = CursorUtil.getColumnIndexOrThrow(_cursor, "cOwnOther");
          final int _cursorIndexOfHouseTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cHouseTyp");
          final int _cursorIndexOfGaragexx = CursorUtil.getColumnIndexOrThrow(_cursor, "cGaragexx");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfHasOther = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasOther");
          final int _cursorIndexOfHasRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRecrd");
          final int _cursorIndexOfRemRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemRecrd");
          final int _cursorIndexOfNeighbr1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighbr1");
          final int _cursorIndexOfAddress1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress1");
          final int _cursorIndexOfReltnCD1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sReltnCD1");
          final int _cursorIndexOfMobileN1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileN1");
          final int _cursorIndexOfFeedBck1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cFeedBck1");
          final int _cursorIndexOfFBRemrk1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sFeedBck1");
          final int _cursorIndexOfNeighbr2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighbr2");
          final int _cursorIndexOfAddress2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress2");
          final int _cursorIndexOfReltnCD2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sReltnCD2");
          final int _cursorIndexOfMobileN2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileN2");
          final int _cursorIndexOfFeedBck2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cFeedBck2");
          final int _cursorIndexOfFBRemrk2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sFBRemrk2");
          final int _cursorIndexOfNeighbr3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighbr3");
          final int _cursorIndexOfAddress3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress3");
          final int _cursorIndexOfReltnCD3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sReltnCD3");
          final int _cursorIndexOfMobileN3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileN3");
          final int _cursorIndexOfFeedBck3 = CursorUtil.getColumnIndexOrThrow(_cursor, "cFeedBck3");
          final int _cursorIndexOfFBRemrk3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sFBRemrk3");
          final int _cursorIndexOfWaterBil = CursorUtil.getColumnIndexOrThrow(_cursor, "nWaterBil");
          final int _cursorIndexOfElctrcBl = CursorUtil.getColumnIndexOrThrow(_cursor, "nElctrcBl");
          final int _cursorIndexOfFoodAllw = CursorUtil.getColumnIndexOrThrow(_cursor, "nFoodAllw");
          final int _cursorIndexOfLoanAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLoanAmtx");
          final int _cursorIndexOfEducExpn = CursorUtil.getColumnIndexOrThrow(_cursor, "nEducExpn");
          final int _cursorIndexOfOthrExpn = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthrExpn");
          final int _cursorIndexOfGamblerx = CursorUtil.getColumnIndexOrThrow(_cursor, "cGamblerx");
          final int _cursorIndexOfWomanizr = CursorUtil.getColumnIndexOrThrow(_cursor, "cWomanizr");
          final int _cursorIndexOfHvyBrwer = CursorUtil.getColumnIndexOrThrow(_cursor, "cHvyBrwer");
          final int _cursorIndexOfWithRepo = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithRepo");
          final int _cursorIndexOfWithMort = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithMort");
          final int _cursorIndexOfArrogant = CursorUtil.getColumnIndexOrThrow(_cursor, "cArrogant");
          final int _cursorIndexOfOtherBad = CursorUtil.getColumnIndexOrThrow(_cursor, "sOtherBad");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final ECIEvaluation _result;
          if(_cursor.moveToFirst()) {
            _result = new ECIEvaluation();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpCredInvx;
            if (_cursor.isNull(_cursorIndexOfCredInvx)) {
              _tmpCredInvx = null;
            } else {
              _tmpCredInvx = _cursor.getString(_cursorIndexOfCredInvx);
            }
            _result.setCredInvx(_tmpCredInvx);
            final String _tmpLandMark;
            if (_cursor.isNull(_cursorIndexOfLandMark)) {
              _tmpLandMark = null;
            } else {
              _tmpLandMark = _cursor.getString(_cursorIndexOfLandMark);
            }
            _result.setLandMark(_tmpLandMark);
            final String _tmpOwnershp;
            if (_cursor.isNull(_cursorIndexOfOwnershp)) {
              _tmpOwnershp = null;
            } else {
              _tmpOwnershp = _cursor.getString(_cursorIndexOfOwnershp);
            }
            _result.setOwnershp(_tmpOwnershp);
            final String _tmpOwnOther;
            if (_cursor.isNull(_cursorIndexOfOwnOther)) {
              _tmpOwnOther = null;
            } else {
              _tmpOwnOther = _cursor.getString(_cursorIndexOfOwnOther);
            }
            _result.setOwnOther(_tmpOwnOther);
            final String _tmpHouseTyp;
            if (_cursor.isNull(_cursorIndexOfHouseTyp)) {
              _tmpHouseTyp = null;
            } else {
              _tmpHouseTyp = _cursor.getString(_cursorIndexOfHouseTyp);
            }
            _result.setHouseTyp(_tmpHouseTyp);
            final String _tmpGaragexx;
            if (_cursor.isNull(_cursorIndexOfGaragexx)) {
              _tmpGaragexx = null;
            } else {
              _tmpGaragexx = _cursor.getString(_cursorIndexOfGaragexx);
            }
            _result.setGaragexx(_tmpGaragexx);
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
            final String _tmpHasOther;
            if (_cursor.isNull(_cursorIndexOfHasOther)) {
              _tmpHasOther = null;
            } else {
              _tmpHasOther = _cursor.getString(_cursorIndexOfHasOther);
            }
            _result.setHasOther(_tmpHasOther);
            final String _tmpHasRecrd;
            if (_cursor.isNull(_cursorIndexOfHasRecrd)) {
              _tmpHasRecrd = null;
            } else {
              _tmpHasRecrd = _cursor.getString(_cursorIndexOfHasRecrd);
            }
            _result.setHasRecrd(_tmpHasRecrd);
            final String _tmpRemRecrd;
            if (_cursor.isNull(_cursorIndexOfRemRecrd)) {
              _tmpRemRecrd = null;
            } else {
              _tmpRemRecrd = _cursor.getString(_cursorIndexOfRemRecrd);
            }
            _result.setRemRecrd(_tmpRemRecrd);
            final String _tmpNeighbr1;
            if (_cursor.isNull(_cursorIndexOfNeighbr1)) {
              _tmpNeighbr1 = null;
            } else {
              _tmpNeighbr1 = _cursor.getString(_cursorIndexOfNeighbr1);
            }
            _result.setNeighbr1(_tmpNeighbr1);
            final String _tmpAddress1;
            if (_cursor.isNull(_cursorIndexOfAddress1)) {
              _tmpAddress1 = null;
            } else {
              _tmpAddress1 = _cursor.getString(_cursorIndexOfAddress1);
            }
            _result.setAddress1(_tmpAddress1);
            final String _tmpReltnCD1;
            if (_cursor.isNull(_cursorIndexOfReltnCD1)) {
              _tmpReltnCD1 = null;
            } else {
              _tmpReltnCD1 = _cursor.getString(_cursorIndexOfReltnCD1);
            }
            _result.setReltnCD1(_tmpReltnCD1);
            final String _tmpMobileN1;
            if (_cursor.isNull(_cursorIndexOfMobileN1)) {
              _tmpMobileN1 = null;
            } else {
              _tmpMobileN1 = _cursor.getString(_cursorIndexOfMobileN1);
            }
            _result.setMobileN1(_tmpMobileN1);
            final String _tmpFeedBck1;
            if (_cursor.isNull(_cursorIndexOfFeedBck1)) {
              _tmpFeedBck1 = null;
            } else {
              _tmpFeedBck1 = _cursor.getString(_cursorIndexOfFeedBck1);
            }
            _result.setFeedBck1(_tmpFeedBck1);
            final String _tmpFBRemrk1;
            if (_cursor.isNull(_cursorIndexOfFBRemrk1)) {
              _tmpFBRemrk1 = null;
            } else {
              _tmpFBRemrk1 = _cursor.getString(_cursorIndexOfFBRemrk1);
            }
            _result.setFBRemrk1(_tmpFBRemrk1);
            final String _tmpNeighbr2;
            if (_cursor.isNull(_cursorIndexOfNeighbr2)) {
              _tmpNeighbr2 = null;
            } else {
              _tmpNeighbr2 = _cursor.getString(_cursorIndexOfNeighbr2);
            }
            _result.setNeighbr2(_tmpNeighbr2);
            final String _tmpAddress2;
            if (_cursor.isNull(_cursorIndexOfAddress2)) {
              _tmpAddress2 = null;
            } else {
              _tmpAddress2 = _cursor.getString(_cursorIndexOfAddress2);
            }
            _result.setAddress2(_tmpAddress2);
            final String _tmpReltnCD2;
            if (_cursor.isNull(_cursorIndexOfReltnCD2)) {
              _tmpReltnCD2 = null;
            } else {
              _tmpReltnCD2 = _cursor.getString(_cursorIndexOfReltnCD2);
            }
            _result.setReltnCD2(_tmpReltnCD2);
            final String _tmpMobileN2;
            if (_cursor.isNull(_cursorIndexOfMobileN2)) {
              _tmpMobileN2 = null;
            } else {
              _tmpMobileN2 = _cursor.getString(_cursorIndexOfMobileN2);
            }
            _result.setMobileN2(_tmpMobileN2);
            final String _tmpFeedBck2;
            if (_cursor.isNull(_cursorIndexOfFeedBck2)) {
              _tmpFeedBck2 = null;
            } else {
              _tmpFeedBck2 = _cursor.getString(_cursorIndexOfFeedBck2);
            }
            _result.setFeedBck2(_tmpFeedBck2);
            final String _tmpFBRemrk2;
            if (_cursor.isNull(_cursorIndexOfFBRemrk2)) {
              _tmpFBRemrk2 = null;
            } else {
              _tmpFBRemrk2 = _cursor.getString(_cursorIndexOfFBRemrk2);
            }
            _result.setFBRemrk2(_tmpFBRemrk2);
            final String _tmpNeighbr3;
            if (_cursor.isNull(_cursorIndexOfNeighbr3)) {
              _tmpNeighbr3 = null;
            } else {
              _tmpNeighbr3 = _cursor.getString(_cursorIndexOfNeighbr3);
            }
            _result.setNeighbr3(_tmpNeighbr3);
            final String _tmpAddress3;
            if (_cursor.isNull(_cursorIndexOfAddress3)) {
              _tmpAddress3 = null;
            } else {
              _tmpAddress3 = _cursor.getString(_cursorIndexOfAddress3);
            }
            _result.setAddress3(_tmpAddress3);
            final String _tmpReltnCD3;
            if (_cursor.isNull(_cursorIndexOfReltnCD3)) {
              _tmpReltnCD3 = null;
            } else {
              _tmpReltnCD3 = _cursor.getString(_cursorIndexOfReltnCD3);
            }
            _result.setReltnCD3(_tmpReltnCD3);
            final String _tmpMobileN3;
            if (_cursor.isNull(_cursorIndexOfMobileN3)) {
              _tmpMobileN3 = null;
            } else {
              _tmpMobileN3 = _cursor.getString(_cursorIndexOfMobileN3);
            }
            _result.setMobileN3(_tmpMobileN3);
            final String _tmpFeedBck3;
            if (_cursor.isNull(_cursorIndexOfFeedBck3)) {
              _tmpFeedBck3 = null;
            } else {
              _tmpFeedBck3 = _cursor.getString(_cursorIndexOfFeedBck3);
            }
            _result.setFeedBck3(_tmpFeedBck3);
            final String _tmpFBRemrk3;
            if (_cursor.isNull(_cursorIndexOfFBRemrk3)) {
              _tmpFBRemrk3 = null;
            } else {
              _tmpFBRemrk3 = _cursor.getString(_cursorIndexOfFBRemrk3);
            }
            _result.setFBRemrk3(_tmpFBRemrk3);
            final String _tmpWaterBil;
            if (_cursor.isNull(_cursorIndexOfWaterBil)) {
              _tmpWaterBil = null;
            } else {
              _tmpWaterBil = _cursor.getString(_cursorIndexOfWaterBil);
            }
            _result.setWaterBil(_tmpWaterBil);
            final String _tmpElctrcBl;
            if (_cursor.isNull(_cursorIndexOfElctrcBl)) {
              _tmpElctrcBl = null;
            } else {
              _tmpElctrcBl = _cursor.getString(_cursorIndexOfElctrcBl);
            }
            _result.setElctrcBl(_tmpElctrcBl);
            final String _tmpFoodAllw;
            if (_cursor.isNull(_cursorIndexOfFoodAllw)) {
              _tmpFoodAllw = null;
            } else {
              _tmpFoodAllw = _cursor.getString(_cursorIndexOfFoodAllw);
            }
            _result.setFoodAllw(_tmpFoodAllw);
            final String _tmpLoanAmtx;
            if (_cursor.isNull(_cursorIndexOfLoanAmtx)) {
              _tmpLoanAmtx = null;
            } else {
              _tmpLoanAmtx = _cursor.getString(_cursorIndexOfLoanAmtx);
            }
            _result.setLoanAmtx(_tmpLoanAmtx);
            final String _tmpEducExpn;
            if (_cursor.isNull(_cursorIndexOfEducExpn)) {
              _tmpEducExpn = null;
            } else {
              _tmpEducExpn = _cursor.getString(_cursorIndexOfEducExpn);
            }
            _result.setEducExpn(_tmpEducExpn);
            final String _tmpOthrExpn;
            if (_cursor.isNull(_cursorIndexOfOthrExpn)) {
              _tmpOthrExpn = null;
            } else {
              _tmpOthrExpn = _cursor.getString(_cursorIndexOfOthrExpn);
            }
            _result.setOthrExpn(_tmpOthrExpn);
            final String _tmpGamblerx;
            if (_cursor.isNull(_cursorIndexOfGamblerx)) {
              _tmpGamblerx = null;
            } else {
              _tmpGamblerx = _cursor.getString(_cursorIndexOfGamblerx);
            }
            _result.setGamblerx(_tmpGamblerx);
            final String _tmpWomanizr;
            if (_cursor.isNull(_cursorIndexOfWomanizr)) {
              _tmpWomanizr = null;
            } else {
              _tmpWomanizr = _cursor.getString(_cursorIndexOfWomanizr);
            }
            _result.setWomanizr(_tmpWomanizr);
            final String _tmpHvyBrwer;
            if (_cursor.isNull(_cursorIndexOfHvyBrwer)) {
              _tmpHvyBrwer = null;
            } else {
              _tmpHvyBrwer = _cursor.getString(_cursorIndexOfHvyBrwer);
            }
            _result.setHvyBrwer(_tmpHvyBrwer);
            final String _tmpWithRepo;
            if (_cursor.isNull(_cursorIndexOfWithRepo)) {
              _tmpWithRepo = null;
            } else {
              _tmpWithRepo = _cursor.getString(_cursorIndexOfWithRepo);
            }
            _result.setWithRepo(_tmpWithRepo);
            final String _tmpWithMort;
            if (_cursor.isNull(_cursorIndexOfWithMort)) {
              _tmpWithMort = null;
            } else {
              _tmpWithMort = _cursor.getString(_cursorIndexOfWithMort);
            }
            _result.setWithMort(_tmpWithMort);
            final String _tmpArrogant;
            if (_cursor.isNull(_cursorIndexOfArrogant)) {
              _tmpArrogant = null;
            } else {
              _tmpArrogant = _cursor.getString(_cursorIndexOfArrogant);
            }
            _result.setArrogant(_tmpArrogant);
            final String _tmpOtherBad;
            if (_cursor.isNull(_cursorIndexOfOtherBad)) {
              _tmpOtherBad = null;
            } else {
              _tmpOtherBad = _cursor.getString(_cursorIndexOfOtherBad);
            }
            _result.setOtherBad(_tmpOtherBad);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _result.setApproved(_tmpApproved);
            final String _tmpReceived;
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _tmpReceived = null;
            } else {
              _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
            }
            _result.setReceived(_tmpReceived);
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
  public LiveData<ECIEvaluation> getAllDoneCiInfo(final String fsTransNo) {
    final String _sql = "SELECT * FROM Credit_Online_Application_List_CI WHERE sTransNox = ? AND sCredInvx = (SELECT sEmployID FROM User_Info_Master) AND (cTranStat = 1 OR cTranStat = 3)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsTransNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsTransNo);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_List_CI","User_Info_Master"}, false, new Callable<ECIEvaluation>() {
      @Override
      public ECIEvaluation call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
          final int _cursorIndexOfLandMark = CursorUtil.getColumnIndexOrThrow(_cursor, "sLandMark");
          final int _cursorIndexOfOwnershp = CursorUtil.getColumnIndexOrThrow(_cursor, "cOwnershp");
          final int _cursorIndexOfOwnOther = CursorUtil.getColumnIndexOrThrow(_cursor, "cOwnOther");
          final int _cursorIndexOfHouseTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cHouseTyp");
          final int _cursorIndexOfGaragexx = CursorUtil.getColumnIndexOrThrow(_cursor, "cGaragexx");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
          final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
          final int _cursorIndexOfHasOther = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasOther");
          final int _cursorIndexOfHasRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRecrd");
          final int _cursorIndexOfRemRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemRecrd");
          final int _cursorIndexOfNeighbr1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighbr1");
          final int _cursorIndexOfAddress1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress1");
          final int _cursorIndexOfReltnCD1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sReltnCD1");
          final int _cursorIndexOfMobileN1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileN1");
          final int _cursorIndexOfFeedBck1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cFeedBck1");
          final int _cursorIndexOfFBRemrk1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sFeedBck1");
          final int _cursorIndexOfNeighbr2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighbr2");
          final int _cursorIndexOfAddress2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress2");
          final int _cursorIndexOfReltnCD2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sReltnCD2");
          final int _cursorIndexOfMobileN2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileN2");
          final int _cursorIndexOfFeedBck2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cFeedBck2");
          final int _cursorIndexOfFBRemrk2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sFBRemrk2");
          final int _cursorIndexOfNeighbr3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighbr3");
          final int _cursorIndexOfAddress3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddress3");
          final int _cursorIndexOfReltnCD3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sReltnCD3");
          final int _cursorIndexOfMobileN3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileN3");
          final int _cursorIndexOfFeedBck3 = CursorUtil.getColumnIndexOrThrow(_cursor, "cFeedBck3");
          final int _cursorIndexOfFBRemrk3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sFBRemrk3");
          final int _cursorIndexOfWaterBil = CursorUtil.getColumnIndexOrThrow(_cursor, "nWaterBil");
          final int _cursorIndexOfElctrcBl = CursorUtil.getColumnIndexOrThrow(_cursor, "nElctrcBl");
          final int _cursorIndexOfFoodAllw = CursorUtil.getColumnIndexOrThrow(_cursor, "nFoodAllw");
          final int _cursorIndexOfLoanAmtx = CursorUtil.getColumnIndexOrThrow(_cursor, "nLoanAmtx");
          final int _cursorIndexOfEducExpn = CursorUtil.getColumnIndexOrThrow(_cursor, "nEducExpn");
          final int _cursorIndexOfOthrExpn = CursorUtil.getColumnIndexOrThrow(_cursor, "nOthrExpn");
          final int _cursorIndexOfGamblerx = CursorUtil.getColumnIndexOrThrow(_cursor, "cGamblerx");
          final int _cursorIndexOfWomanizr = CursorUtil.getColumnIndexOrThrow(_cursor, "cWomanizr");
          final int _cursorIndexOfHvyBrwer = CursorUtil.getColumnIndexOrThrow(_cursor, "cHvyBrwer");
          final int _cursorIndexOfWithRepo = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithRepo");
          final int _cursorIndexOfWithMort = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithMort");
          final int _cursorIndexOfArrogant = CursorUtil.getColumnIndexOrThrow(_cursor, "cArrogant");
          final int _cursorIndexOfOtherBad = CursorUtil.getColumnIndexOrThrow(_cursor, "sOtherBad");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final ECIEvaluation _result;
          if(_cursor.moveToFirst()) {
            _result = new ECIEvaluation();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpCredInvx;
            if (_cursor.isNull(_cursorIndexOfCredInvx)) {
              _tmpCredInvx = null;
            } else {
              _tmpCredInvx = _cursor.getString(_cursorIndexOfCredInvx);
            }
            _result.setCredInvx(_tmpCredInvx);
            final String _tmpLandMark;
            if (_cursor.isNull(_cursorIndexOfLandMark)) {
              _tmpLandMark = null;
            } else {
              _tmpLandMark = _cursor.getString(_cursorIndexOfLandMark);
            }
            _result.setLandMark(_tmpLandMark);
            final String _tmpOwnershp;
            if (_cursor.isNull(_cursorIndexOfOwnershp)) {
              _tmpOwnershp = null;
            } else {
              _tmpOwnershp = _cursor.getString(_cursorIndexOfOwnershp);
            }
            _result.setOwnershp(_tmpOwnershp);
            final String _tmpOwnOther;
            if (_cursor.isNull(_cursorIndexOfOwnOther)) {
              _tmpOwnOther = null;
            } else {
              _tmpOwnOther = _cursor.getString(_cursorIndexOfOwnOther);
            }
            _result.setOwnOther(_tmpOwnOther);
            final String _tmpHouseTyp;
            if (_cursor.isNull(_cursorIndexOfHouseTyp)) {
              _tmpHouseTyp = null;
            } else {
              _tmpHouseTyp = _cursor.getString(_cursorIndexOfHouseTyp);
            }
            _result.setHouseTyp(_tmpHouseTyp);
            final String _tmpGaragexx;
            if (_cursor.isNull(_cursorIndexOfGaragexx)) {
              _tmpGaragexx = null;
            } else {
              _tmpGaragexx = _cursor.getString(_cursorIndexOfGaragexx);
            }
            _result.setGaragexx(_tmpGaragexx);
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
            final String _tmpHasOther;
            if (_cursor.isNull(_cursorIndexOfHasOther)) {
              _tmpHasOther = null;
            } else {
              _tmpHasOther = _cursor.getString(_cursorIndexOfHasOther);
            }
            _result.setHasOther(_tmpHasOther);
            final String _tmpHasRecrd;
            if (_cursor.isNull(_cursorIndexOfHasRecrd)) {
              _tmpHasRecrd = null;
            } else {
              _tmpHasRecrd = _cursor.getString(_cursorIndexOfHasRecrd);
            }
            _result.setHasRecrd(_tmpHasRecrd);
            final String _tmpRemRecrd;
            if (_cursor.isNull(_cursorIndexOfRemRecrd)) {
              _tmpRemRecrd = null;
            } else {
              _tmpRemRecrd = _cursor.getString(_cursorIndexOfRemRecrd);
            }
            _result.setRemRecrd(_tmpRemRecrd);
            final String _tmpNeighbr1;
            if (_cursor.isNull(_cursorIndexOfNeighbr1)) {
              _tmpNeighbr1 = null;
            } else {
              _tmpNeighbr1 = _cursor.getString(_cursorIndexOfNeighbr1);
            }
            _result.setNeighbr1(_tmpNeighbr1);
            final String _tmpAddress1;
            if (_cursor.isNull(_cursorIndexOfAddress1)) {
              _tmpAddress1 = null;
            } else {
              _tmpAddress1 = _cursor.getString(_cursorIndexOfAddress1);
            }
            _result.setAddress1(_tmpAddress1);
            final String _tmpReltnCD1;
            if (_cursor.isNull(_cursorIndexOfReltnCD1)) {
              _tmpReltnCD1 = null;
            } else {
              _tmpReltnCD1 = _cursor.getString(_cursorIndexOfReltnCD1);
            }
            _result.setReltnCD1(_tmpReltnCD1);
            final String _tmpMobileN1;
            if (_cursor.isNull(_cursorIndexOfMobileN1)) {
              _tmpMobileN1 = null;
            } else {
              _tmpMobileN1 = _cursor.getString(_cursorIndexOfMobileN1);
            }
            _result.setMobileN1(_tmpMobileN1);
            final String _tmpFeedBck1;
            if (_cursor.isNull(_cursorIndexOfFeedBck1)) {
              _tmpFeedBck1 = null;
            } else {
              _tmpFeedBck1 = _cursor.getString(_cursorIndexOfFeedBck1);
            }
            _result.setFeedBck1(_tmpFeedBck1);
            final String _tmpFBRemrk1;
            if (_cursor.isNull(_cursorIndexOfFBRemrk1)) {
              _tmpFBRemrk1 = null;
            } else {
              _tmpFBRemrk1 = _cursor.getString(_cursorIndexOfFBRemrk1);
            }
            _result.setFBRemrk1(_tmpFBRemrk1);
            final String _tmpNeighbr2;
            if (_cursor.isNull(_cursorIndexOfNeighbr2)) {
              _tmpNeighbr2 = null;
            } else {
              _tmpNeighbr2 = _cursor.getString(_cursorIndexOfNeighbr2);
            }
            _result.setNeighbr2(_tmpNeighbr2);
            final String _tmpAddress2;
            if (_cursor.isNull(_cursorIndexOfAddress2)) {
              _tmpAddress2 = null;
            } else {
              _tmpAddress2 = _cursor.getString(_cursorIndexOfAddress2);
            }
            _result.setAddress2(_tmpAddress2);
            final String _tmpReltnCD2;
            if (_cursor.isNull(_cursorIndexOfReltnCD2)) {
              _tmpReltnCD2 = null;
            } else {
              _tmpReltnCD2 = _cursor.getString(_cursorIndexOfReltnCD2);
            }
            _result.setReltnCD2(_tmpReltnCD2);
            final String _tmpMobileN2;
            if (_cursor.isNull(_cursorIndexOfMobileN2)) {
              _tmpMobileN2 = null;
            } else {
              _tmpMobileN2 = _cursor.getString(_cursorIndexOfMobileN2);
            }
            _result.setMobileN2(_tmpMobileN2);
            final String _tmpFeedBck2;
            if (_cursor.isNull(_cursorIndexOfFeedBck2)) {
              _tmpFeedBck2 = null;
            } else {
              _tmpFeedBck2 = _cursor.getString(_cursorIndexOfFeedBck2);
            }
            _result.setFeedBck2(_tmpFeedBck2);
            final String _tmpFBRemrk2;
            if (_cursor.isNull(_cursorIndexOfFBRemrk2)) {
              _tmpFBRemrk2 = null;
            } else {
              _tmpFBRemrk2 = _cursor.getString(_cursorIndexOfFBRemrk2);
            }
            _result.setFBRemrk2(_tmpFBRemrk2);
            final String _tmpNeighbr3;
            if (_cursor.isNull(_cursorIndexOfNeighbr3)) {
              _tmpNeighbr3 = null;
            } else {
              _tmpNeighbr3 = _cursor.getString(_cursorIndexOfNeighbr3);
            }
            _result.setNeighbr3(_tmpNeighbr3);
            final String _tmpAddress3;
            if (_cursor.isNull(_cursorIndexOfAddress3)) {
              _tmpAddress3 = null;
            } else {
              _tmpAddress3 = _cursor.getString(_cursorIndexOfAddress3);
            }
            _result.setAddress3(_tmpAddress3);
            final String _tmpReltnCD3;
            if (_cursor.isNull(_cursorIndexOfReltnCD3)) {
              _tmpReltnCD3 = null;
            } else {
              _tmpReltnCD3 = _cursor.getString(_cursorIndexOfReltnCD3);
            }
            _result.setReltnCD3(_tmpReltnCD3);
            final String _tmpMobileN3;
            if (_cursor.isNull(_cursorIndexOfMobileN3)) {
              _tmpMobileN3 = null;
            } else {
              _tmpMobileN3 = _cursor.getString(_cursorIndexOfMobileN3);
            }
            _result.setMobileN3(_tmpMobileN3);
            final String _tmpFeedBck3;
            if (_cursor.isNull(_cursorIndexOfFeedBck3)) {
              _tmpFeedBck3 = null;
            } else {
              _tmpFeedBck3 = _cursor.getString(_cursorIndexOfFeedBck3);
            }
            _result.setFeedBck3(_tmpFeedBck3);
            final String _tmpFBRemrk3;
            if (_cursor.isNull(_cursorIndexOfFBRemrk3)) {
              _tmpFBRemrk3 = null;
            } else {
              _tmpFBRemrk3 = _cursor.getString(_cursorIndexOfFBRemrk3);
            }
            _result.setFBRemrk3(_tmpFBRemrk3);
            final String _tmpWaterBil;
            if (_cursor.isNull(_cursorIndexOfWaterBil)) {
              _tmpWaterBil = null;
            } else {
              _tmpWaterBil = _cursor.getString(_cursorIndexOfWaterBil);
            }
            _result.setWaterBil(_tmpWaterBil);
            final String _tmpElctrcBl;
            if (_cursor.isNull(_cursorIndexOfElctrcBl)) {
              _tmpElctrcBl = null;
            } else {
              _tmpElctrcBl = _cursor.getString(_cursorIndexOfElctrcBl);
            }
            _result.setElctrcBl(_tmpElctrcBl);
            final String _tmpFoodAllw;
            if (_cursor.isNull(_cursorIndexOfFoodAllw)) {
              _tmpFoodAllw = null;
            } else {
              _tmpFoodAllw = _cursor.getString(_cursorIndexOfFoodAllw);
            }
            _result.setFoodAllw(_tmpFoodAllw);
            final String _tmpLoanAmtx;
            if (_cursor.isNull(_cursorIndexOfLoanAmtx)) {
              _tmpLoanAmtx = null;
            } else {
              _tmpLoanAmtx = _cursor.getString(_cursorIndexOfLoanAmtx);
            }
            _result.setLoanAmtx(_tmpLoanAmtx);
            final String _tmpEducExpn;
            if (_cursor.isNull(_cursorIndexOfEducExpn)) {
              _tmpEducExpn = null;
            } else {
              _tmpEducExpn = _cursor.getString(_cursorIndexOfEducExpn);
            }
            _result.setEducExpn(_tmpEducExpn);
            final String _tmpOthrExpn;
            if (_cursor.isNull(_cursorIndexOfOthrExpn)) {
              _tmpOthrExpn = null;
            } else {
              _tmpOthrExpn = _cursor.getString(_cursorIndexOfOthrExpn);
            }
            _result.setOthrExpn(_tmpOthrExpn);
            final String _tmpGamblerx;
            if (_cursor.isNull(_cursorIndexOfGamblerx)) {
              _tmpGamblerx = null;
            } else {
              _tmpGamblerx = _cursor.getString(_cursorIndexOfGamblerx);
            }
            _result.setGamblerx(_tmpGamblerx);
            final String _tmpWomanizr;
            if (_cursor.isNull(_cursorIndexOfWomanizr)) {
              _tmpWomanizr = null;
            } else {
              _tmpWomanizr = _cursor.getString(_cursorIndexOfWomanizr);
            }
            _result.setWomanizr(_tmpWomanizr);
            final String _tmpHvyBrwer;
            if (_cursor.isNull(_cursorIndexOfHvyBrwer)) {
              _tmpHvyBrwer = null;
            } else {
              _tmpHvyBrwer = _cursor.getString(_cursorIndexOfHvyBrwer);
            }
            _result.setHvyBrwer(_tmpHvyBrwer);
            final String _tmpWithRepo;
            if (_cursor.isNull(_cursorIndexOfWithRepo)) {
              _tmpWithRepo = null;
            } else {
              _tmpWithRepo = _cursor.getString(_cursorIndexOfWithRepo);
            }
            _result.setWithRepo(_tmpWithRepo);
            final String _tmpWithMort;
            if (_cursor.isNull(_cursorIndexOfWithMort)) {
              _tmpWithMort = null;
            } else {
              _tmpWithMort = _cursor.getString(_cursorIndexOfWithMort);
            }
            _result.setWithMort(_tmpWithMort);
            final String _tmpArrogant;
            if (_cursor.isNull(_cursorIndexOfArrogant)) {
              _tmpArrogant = null;
            } else {
              _tmpArrogant = _cursor.getString(_cursorIndexOfArrogant);
            }
            _result.setArrogant(_tmpArrogant);
            final String _tmpOtherBad;
            if (_cursor.isNull(_cursorIndexOfOtherBad)) {
              _tmpOtherBad = null;
            } else {
              _tmpOtherBad = _cursor.getString(_cursorIndexOfOtherBad);
            }
            _result.setOtherBad(_tmpOtherBad);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _result.setApproved(_tmpApproved);
            final String _tmpReceived;
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _tmpReceived = null;
            } else {
              _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
            }
            _result.setReceived(_tmpReceived);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
