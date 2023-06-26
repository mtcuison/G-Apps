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
import org.rmj.g3appdriver.GCircle.room.Entities.EBranchLoanApplication;
import org.rmj.g3appdriver.GCircle.room.Entities.ECreditOnlineApplicationCI;
import org.rmj.g3appdriver.GCircle.room.Entities.EImageInfo;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DCreditOnlineApplicationCI_Impl implements DCreditOnlineApplicationCI {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ECreditOnlineApplicationCI> __insertionAdapterOfECreditOnlineApplicationCI;

  private final EntityInsertionAdapter<EBranchLoanApplication> __insertionAdapterOfEBranchLoanApplication;

  private final EntityInsertionAdapter<EBranchLoanApplication> __insertionAdapterOfEBranchLoanApplication_1;

  private final EntityDeletionOrUpdateAdapter<ECreditOnlineApplicationCI> __updateAdapterOfECreditOnlineApplicationCI;

  private final EntityDeletionOrUpdateAdapter<EBranchLoanApplication> __updateAdapterOfEBranchLoanApplication;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTransactionSendStat;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAddressEvaluation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateAssetEvaluation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateIncomeEvaluation;

  private final SharedSQLiteStatement __preparedStmtOfUpdateRecordInfo;

  private final SharedSQLiteStatement __preparedStmtOfUpdateRecordRemarks;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePresentBarangay;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePosition;

  private final SharedSQLiteStatement __preparedStmtOfUpdateContact;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNeighbor1;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNeighbor2;

  private final SharedSQLiteStatement __preparedStmtOfUpdateNeighbor3;

  private final SharedSQLiteStatement __preparedStmtOfSaveCIApproval;

  private final SharedSQLiteStatement __preparedStmtOfSaveBHApproval;

  private final SharedSQLiteStatement __preparedStmtOfUpdateUploadedResult;

  public DCreditOnlineApplicationCI_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfECreditOnlineApplicationCI = new EntityInsertionAdapter<ECreditOnlineApplicationCI>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Credit_Online_Application_CI` (`sTransNox`,`sCredInvx`,`sManagerx`,`sAddressx`,`sAddrFndg`,`sAssetsxx`,`sAsstFndg`,`sIncomexx`,`sIncmFndg`,`cHasRecrd`,`sRecrdRem`,`sPrsnBrgy`,`sPrsnPstn`,`sPrsnNmbr`,`sNeighBr1`,`sNeighBr2`,`sNeighBr3`,`dRcmdRcd1`,`dRcmdtnx1`,`cRcmdtnx1`,`sRcmdtnx1`,`dRcmdRcd2`,`dRcmdtnx2`,`cRcmdtnx2`,`sRcmdtnx2`,`cTranStat`,`cUploaded`,`cSendStat`,`cTransfer`,`sApproved`,`dApproved`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECreditOnlineApplicationCI value) {
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
        if (value.getManagerx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getManagerx());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddressx());
        }
        if (value.getAddrFndg() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAddrFndg());
        }
        if (value.getAssetsxx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAssetsxx());
        }
        if (value.getAsstFndg() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAsstFndg());
        }
        if (value.getIncomexx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getIncomexx());
        }
        if (value.getIncmFndg() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getIncmFndg());
        }
        if (value.getHasRecrd() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getHasRecrd());
        }
        if (value.getRecrdRem() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getRecrdRem());
        }
        if (value.getPrsnBrgy() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPrsnBrgy());
        }
        if (value.getPrsnPstn() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPrsnPstn());
        }
        if (value.getPrsnNmbr() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getPrsnNmbr());
        }
        if (value.getNeighBr1() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getNeighBr1());
        }
        if (value.getNeighBr2() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getNeighBr2());
        }
        if (value.getNeighBr3() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getNeighBr3());
        }
        if (value.getRcmdRcd1() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getRcmdRcd1());
        }
        if (value.getRcmdtnx1() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getRcmdtnx1());
        }
        if (value.getRcmdtnc1() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getRcmdtnc1());
        }
        if (value.getRcmdtns1() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getRcmdtns1());
        }
        if (value.getRcmdRcd2() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getRcmdRcd2());
        }
        if (value.getRcmdtnx2() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getRcmdtnx2());
        }
        if (value.getRcmdtnc2() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getRcmdtnc2());
        }
        if (value.getRcmdtns2() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getRcmdtns2());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getTranStat());
        }
        if (value.getUploaded() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getUploaded());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getSendStat());
        }
        if (value.getTransfer() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getTransfer());
        }
        if (value.getApproved() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getApproved());
        }
        if (value.getDapprovd() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getDapprovd());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfEBranchLoanApplication = new EntityInsertionAdapter<EBranchLoanApplication>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `Credit_Online_Application_List` (`sTransNox`,`sBranchCD`,`dTransact`,`sCredInvx`,`sCompnyNm`,`sSpouseNm`,`sAddressx`,`sMobileNo`,`sQMAppCde`,`sModelNme`,`nDownPaym`,`nAcctTerm`,`sCreatedx`,`dTimeStmp`,`cTranStat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchLoanApplication value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCD());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getCredInvx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCredInvx());
        }
        if (value.getCompnyNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCompnyNm());
        }
        if (value.getSpouseNm() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSpouseNm());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAddressx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMobileNo());
        }
        if (value.getQMAppCde() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getQMAppCde());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModelNme());
        }
        if (value.getDownPaym() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDownPaym());
        }
        if (value.getAcctTerm() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getAcctTerm());
        }
        if (value.getCreatedX() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatedX());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
      }
    };
    this.__insertionAdapterOfEBranchLoanApplication_1 = new EntityInsertionAdapter<EBranchLoanApplication>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Credit_Online_Application_List` (`sTransNox`,`sBranchCD`,`dTransact`,`sCredInvx`,`sCompnyNm`,`sSpouseNm`,`sAddressx`,`sMobileNo`,`sQMAppCde`,`sModelNme`,`nDownPaym`,`nAcctTerm`,`sCreatedx`,`dTimeStmp`,`cTranStat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchLoanApplication value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCD());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getCredInvx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCredInvx());
        }
        if (value.getCompnyNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCompnyNm());
        }
        if (value.getSpouseNm() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSpouseNm());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAddressx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMobileNo());
        }
        if (value.getQMAppCde() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getQMAppCde());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModelNme());
        }
        if (value.getDownPaym() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDownPaym());
        }
        if (value.getAcctTerm() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getAcctTerm());
        }
        if (value.getCreatedX() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatedX());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
      }
    };
    this.__updateAdapterOfECreditOnlineApplicationCI = new EntityDeletionOrUpdateAdapter<ECreditOnlineApplicationCI>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Credit_Online_Application_CI` SET `sTransNox` = ?,`sCredInvx` = ?,`sManagerx` = ?,`sAddressx` = ?,`sAddrFndg` = ?,`sAssetsxx` = ?,`sAsstFndg` = ?,`sIncomexx` = ?,`sIncmFndg` = ?,`cHasRecrd` = ?,`sRecrdRem` = ?,`sPrsnBrgy` = ?,`sPrsnPstn` = ?,`sPrsnNmbr` = ?,`sNeighBr1` = ?,`sNeighBr2` = ?,`sNeighBr3` = ?,`dRcmdRcd1` = ?,`dRcmdtnx1` = ?,`cRcmdtnx1` = ?,`sRcmdtnx1` = ?,`dRcmdRcd2` = ?,`dRcmdtnx2` = ?,`cRcmdtnx2` = ?,`sRcmdtnx2` = ?,`cTranStat` = ?,`cUploaded` = ?,`cSendStat` = ?,`cTransfer` = ?,`sApproved` = ?,`dApproved` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECreditOnlineApplicationCI value) {
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
        if (value.getManagerx() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getManagerx());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAddressx());
        }
        if (value.getAddrFndg() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getAddrFndg());
        }
        if (value.getAssetsxx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getAssetsxx());
        }
        if (value.getAsstFndg() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAsstFndg());
        }
        if (value.getIncomexx() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getIncomexx());
        }
        if (value.getIncmFndg() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getIncmFndg());
        }
        if (value.getHasRecrd() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getHasRecrd());
        }
        if (value.getRecrdRem() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getRecrdRem());
        }
        if (value.getPrsnBrgy() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPrsnBrgy());
        }
        if (value.getPrsnPstn() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getPrsnPstn());
        }
        if (value.getPrsnNmbr() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getPrsnNmbr());
        }
        if (value.getNeighBr1() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getNeighBr1());
        }
        if (value.getNeighBr2() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getNeighBr2());
        }
        if (value.getNeighBr3() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getNeighBr3());
        }
        if (value.getRcmdRcd1() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getRcmdRcd1());
        }
        if (value.getRcmdtnx1() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getRcmdtnx1());
        }
        if (value.getRcmdtnc1() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getRcmdtnc1());
        }
        if (value.getRcmdtns1() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getRcmdtns1());
        }
        if (value.getRcmdRcd2() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getRcmdRcd2());
        }
        if (value.getRcmdtnx2() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getRcmdtnx2());
        }
        if (value.getRcmdtnc2() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getRcmdtnc2());
        }
        if (value.getRcmdtns2() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getRcmdtns2());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getTranStat());
        }
        if (value.getUploaded() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getUploaded());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getSendStat());
        }
        if (value.getTransfer() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getTransfer());
        }
        if (value.getApproved() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getApproved());
        }
        if (value.getDapprovd() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getDapprovd());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(33);
        } else {
          stmt.bindString(33, value.getTransNox());
        }
      }
    };
    this.__updateAdapterOfEBranchLoanApplication = new EntityDeletionOrUpdateAdapter<EBranchLoanApplication>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Credit_Online_Application_List` SET `sTransNox` = ?,`sBranchCD` = ?,`dTransact` = ?,`sCredInvx` = ?,`sCompnyNm` = ?,`sSpouseNm` = ?,`sAddressx` = ?,`sMobileNo` = ?,`sQMAppCde` = ?,`sModelNme` = ?,`nDownPaym` = ?,`nAcctTerm` = ?,`sCreatedx` = ?,`dTimeStmp` = ?,`cTranStat` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EBranchLoanApplication value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCD() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCD());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getCredInvx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCredInvx());
        }
        if (value.getCompnyNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCompnyNm());
        }
        if (value.getSpouseNm() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSpouseNm());
        }
        if (value.getAddressx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getAddressx());
        }
        if (value.getMobileNo() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getMobileNo());
        }
        if (value.getQMAppCde() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getQMAppCde());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getModelNme());
        }
        if (value.getDownPaym() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getDownPaym());
        }
        if (value.getAcctTerm() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getAcctTerm());
        }
        if (value.getCreatedX() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getCreatedX());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getTimeStmp());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getTranStat());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getTransNox());
        }
      }
    };
    this.__preparedStmtOfUpdateTransactionSendStat = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "Update Credit_Online_Application_CI SET cSendStat = '1' WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAddressEvaluation = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET sAddrFndg=? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateAssetEvaluation = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET sAsstFndg=? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateIncomeEvaluation = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET sIncmFndg=? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateRecordInfo = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET cHasRecrd =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateRecordRemarks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET sRecrdRem =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePresentBarangay = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET sPrsnBrgy =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdatePosition = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET sPrsnPstn =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateContact = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET sPrsnNmbr =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNeighbor1 = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET sNeighBr1 =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNeighbor2 = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET sNeighBr2 =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateNeighbor3 = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET sNeighBr3 =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfSaveCIApproval = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET dRcmdtnx1 =?, cRcmdtnx1 =?, sRcmdtnx1 =?, cSendStat = '0', sApproved = (SELECT sEmployID FROM User_Info_Master), dApproved =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfSaveBHApproval = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET cRcmdtnx2 =?, sRcmdtnx2 =?, cSendStat = '0' WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateUploadedResult = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_CI SET cUploaded = '1' WHERE sTransNox=?";
        return _query;
      }
    };
  }

  @Override
  public void SaveApplicationInfo(final ECreditOnlineApplicationCI foCI) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECreditOnlineApplicationCI.insert(foCI);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void SaveCreditApplication(final EBranchLoanApplication foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchLoanApplication.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void SaveNewRecord(final EBranchLoanApplication foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchLoanApplication_1.insert(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateApplication(final ECreditOnlineApplicationCI foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfECreditOnlineApplicationCI.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateExistingRecord(final EBranchLoanApplication foVal) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEBranchLoanApplication.handle(foVal);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void UpdateTransactionSendStat(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTransactionSendStat.acquire();
    int _argIndex = 1;
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
      __preparedStmtOfUpdateTransactionSendStat.release(_stmt);
    }
  }

  @Override
  public void updateAddressEvaluation(final String TransNox, final String Findings) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAddressEvaluation.acquire();
    int _argIndex = 1;
    if (Findings == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Findings);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateAddressEvaluation.release(_stmt);
    }
  }

  @Override
  public void updateAssetEvaluation(final String TransNox, final String Findings) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateAssetEvaluation.acquire();
    int _argIndex = 1;
    if (Findings == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Findings);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateAssetEvaluation.release(_stmt);
    }
  }

  @Override
  public void updateIncomeEvaluation(final String TransNox, final String Findings) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateIncomeEvaluation.acquire();
    int _argIndex = 1;
    if (Findings == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, Findings);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateIncomeEvaluation.release(_stmt);
    }
  }

  @Override
  public void UpdateRecordInfo(final String TransNox, final String val) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateRecordInfo.acquire();
    int _argIndex = 1;
    if (val == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, val);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateRecordInfo.release(_stmt);
    }
  }

  @Override
  public void UpdateRecordRemarks(final String TransNox, final String val) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateRecordRemarks.acquire();
    int _argIndex = 1;
    if (val == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, val);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateRecordRemarks.release(_stmt);
    }
  }

  @Override
  public void UpdatePresentBarangay(final String TransNox, final String val) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePresentBarangay.acquire();
    int _argIndex = 1;
    if (val == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, val);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdatePresentBarangay.release(_stmt);
    }
  }

  @Override
  public void UpdatePosition(final String TransNox, final String val) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePosition.acquire();
    int _argIndex = 1;
    if (val == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, val);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdatePosition.release(_stmt);
    }
  }

  @Override
  public void UpdateContact(final String TransNox, final String val) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateContact.acquire();
    int _argIndex = 1;
    if (val == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, val);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateContact.release(_stmt);
    }
  }

  @Override
  public void UpdateNeighbor1(final String TransNox, final String val) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNeighbor1.acquire();
    int _argIndex = 1;
    if (val == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, val);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateNeighbor1.release(_stmt);
    }
  }

  @Override
  public void UpdateNeighbor2(final String TransNox, final String val) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNeighbor2.acquire();
    int _argIndex = 1;
    if (val == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, val);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateNeighbor2.release(_stmt);
    }
  }

  @Override
  public void UpdateNeighbor3(final String TransNox, final String val) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateNeighbor3.acquire();
    int _argIndex = 1;
    if (val == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, val);
    }
    _argIndex = 2;
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
      __preparedStmtOfUpdateNeighbor3.release(_stmt);
    }
  }

  @Override
  public void SaveCIApproval(final String TransNox, final String fsResult, final String fsRemarks,
      final String DateApp) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSaveCIApproval.acquire();
    int _argIndex = 1;
    if (DateApp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateApp);
    }
    _argIndex = 2;
    if (fsResult == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsResult);
    }
    _argIndex = 3;
    if (fsRemarks == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsRemarks);
    }
    _argIndex = 4;
    if (DateApp == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateApp);
    }
    _argIndex = 5;
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
      __preparedStmtOfSaveCIApproval.release(_stmt);
    }
  }

  @Override
  public void SaveBHApproval(final String TransNox, final String fsResult, final String fsRemarks) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfSaveBHApproval.acquire();
    int _argIndex = 1;
    if (fsResult == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsResult);
    }
    _argIndex = 2;
    if (fsRemarks == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, fsRemarks);
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
      __preparedStmtOfSaveBHApproval.release(_stmt);
    }
  }

  @Override
  public void UpdateUploadedResult(final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateUploadedResult.acquire();
    int _argIndex = 1;
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
      __preparedStmtOfUpdateUploadedResult.release(_stmt);
    }
  }

  @Override
  public List<ECreditOnlineApplicationCI> GetCIRecommendationsForUpload() {
    final String _sql = "SELECT * FROM Credit_Online_Application_CI WHERE cUploaded != '0' AND cRcmdtnx1 IS NOT NULL AND cSendStat == '0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
      final int _cursorIndexOfManagerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sManagerx");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfAddrFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddrFndg");
      final int _cursorIndexOfAssetsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAssetsxx");
      final int _cursorIndexOfAsstFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAsstFndg");
      final int _cursorIndexOfIncomexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncomexx");
      final int _cursorIndexOfIncmFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncmFndg");
      final int _cursorIndexOfHasRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRecrd");
      final int _cursorIndexOfRecrdRem = CursorUtil.getColumnIndexOrThrow(_cursor, "sRecrdRem");
      final int _cursorIndexOfPrsnBrgy = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnBrgy");
      final int _cursorIndexOfPrsnPstn = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnPstn");
      final int _cursorIndexOfPrsnNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnNmbr");
      final int _cursorIndexOfNeighBr1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr1");
      final int _cursorIndexOfNeighBr2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr2");
      final int _cursorIndexOfNeighBr3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr3");
      final int _cursorIndexOfRcmdRcd1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd1");
      final int _cursorIndexOfRcmdtnx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx1");
      final int _cursorIndexOfRcmdtnc1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx1");
      final int _cursorIndexOfRcmdtns1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx1");
      final int _cursorIndexOfRcmdRcd2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd2");
      final int _cursorIndexOfRcmdtnx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx2");
      final int _cursorIndexOfRcmdtnc2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx2");
      final int _cursorIndexOfRcmdtns2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx2");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "cUploaded");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfTransfer = CursorUtil.getColumnIndexOrThrow(_cursor, "cTransfer");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDapprovd = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<ECreditOnlineApplicationCI> _result = new ArrayList<ECreditOnlineApplicationCI>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ECreditOnlineApplicationCI _item;
        _item = new ECreditOnlineApplicationCI();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpCredInvx;
        if (_cursor.isNull(_cursorIndexOfCredInvx)) {
          _tmpCredInvx = null;
        } else {
          _tmpCredInvx = _cursor.getString(_cursorIndexOfCredInvx);
        }
        _item.setCredInvx(_tmpCredInvx);
        final String _tmpManagerx;
        if (_cursor.isNull(_cursorIndexOfManagerx)) {
          _tmpManagerx = null;
        } else {
          _tmpManagerx = _cursor.getString(_cursorIndexOfManagerx);
        }
        _item.setManagerx(_tmpManagerx);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _item.setAddressx(_tmpAddressx);
        final String _tmpAddrFndg;
        if (_cursor.isNull(_cursorIndexOfAddrFndg)) {
          _tmpAddrFndg = null;
        } else {
          _tmpAddrFndg = _cursor.getString(_cursorIndexOfAddrFndg);
        }
        _item.setAddrFndg(_tmpAddrFndg);
        final String _tmpAssetsxx;
        if (_cursor.isNull(_cursorIndexOfAssetsxx)) {
          _tmpAssetsxx = null;
        } else {
          _tmpAssetsxx = _cursor.getString(_cursorIndexOfAssetsxx);
        }
        _item.setAssetsxx(_tmpAssetsxx);
        final String _tmpAsstFndg;
        if (_cursor.isNull(_cursorIndexOfAsstFndg)) {
          _tmpAsstFndg = null;
        } else {
          _tmpAsstFndg = _cursor.getString(_cursorIndexOfAsstFndg);
        }
        _item.setAsstFndg(_tmpAsstFndg);
        final String _tmpIncomexx;
        if (_cursor.isNull(_cursorIndexOfIncomexx)) {
          _tmpIncomexx = null;
        } else {
          _tmpIncomexx = _cursor.getString(_cursorIndexOfIncomexx);
        }
        _item.setIncomexx(_tmpIncomexx);
        final String _tmpIncmFndg;
        if (_cursor.isNull(_cursorIndexOfIncmFndg)) {
          _tmpIncmFndg = null;
        } else {
          _tmpIncmFndg = _cursor.getString(_cursorIndexOfIncmFndg);
        }
        _item.setIncmFndg(_tmpIncmFndg);
        final String _tmpHasRecrd;
        if (_cursor.isNull(_cursorIndexOfHasRecrd)) {
          _tmpHasRecrd = null;
        } else {
          _tmpHasRecrd = _cursor.getString(_cursorIndexOfHasRecrd);
        }
        _item.setHasRecrd(_tmpHasRecrd);
        final String _tmpRecrdRem;
        if (_cursor.isNull(_cursorIndexOfRecrdRem)) {
          _tmpRecrdRem = null;
        } else {
          _tmpRecrdRem = _cursor.getString(_cursorIndexOfRecrdRem);
        }
        _item.setRecrdRem(_tmpRecrdRem);
        final String _tmpPrsnBrgy;
        if (_cursor.isNull(_cursorIndexOfPrsnBrgy)) {
          _tmpPrsnBrgy = null;
        } else {
          _tmpPrsnBrgy = _cursor.getString(_cursorIndexOfPrsnBrgy);
        }
        _item.setPrsnBrgy(_tmpPrsnBrgy);
        final String _tmpPrsnPstn;
        if (_cursor.isNull(_cursorIndexOfPrsnPstn)) {
          _tmpPrsnPstn = null;
        } else {
          _tmpPrsnPstn = _cursor.getString(_cursorIndexOfPrsnPstn);
        }
        _item.setPrsnPstn(_tmpPrsnPstn);
        final String _tmpPrsnNmbr;
        if (_cursor.isNull(_cursorIndexOfPrsnNmbr)) {
          _tmpPrsnNmbr = null;
        } else {
          _tmpPrsnNmbr = _cursor.getString(_cursorIndexOfPrsnNmbr);
        }
        _item.setPrsnNmbr(_tmpPrsnNmbr);
        final String _tmpNeighBr1;
        if (_cursor.isNull(_cursorIndexOfNeighBr1)) {
          _tmpNeighBr1 = null;
        } else {
          _tmpNeighBr1 = _cursor.getString(_cursorIndexOfNeighBr1);
        }
        _item.setNeighBr1(_tmpNeighBr1);
        final String _tmpNeighBr2;
        if (_cursor.isNull(_cursorIndexOfNeighBr2)) {
          _tmpNeighBr2 = null;
        } else {
          _tmpNeighBr2 = _cursor.getString(_cursorIndexOfNeighBr2);
        }
        _item.setNeighBr2(_tmpNeighBr2);
        final String _tmpNeighBr3;
        if (_cursor.isNull(_cursorIndexOfNeighBr3)) {
          _tmpNeighBr3 = null;
        } else {
          _tmpNeighBr3 = _cursor.getString(_cursorIndexOfNeighBr3);
        }
        _item.setNeighBr3(_tmpNeighBr3);
        final String _tmpRcmdRcd1;
        if (_cursor.isNull(_cursorIndexOfRcmdRcd1)) {
          _tmpRcmdRcd1 = null;
        } else {
          _tmpRcmdRcd1 = _cursor.getString(_cursorIndexOfRcmdRcd1);
        }
        _item.setRcmdRcd1(_tmpRcmdRcd1);
        final String _tmpRcmdtnx1;
        if (_cursor.isNull(_cursorIndexOfRcmdtnx1)) {
          _tmpRcmdtnx1 = null;
        } else {
          _tmpRcmdtnx1 = _cursor.getString(_cursorIndexOfRcmdtnx1);
        }
        _item.setRcmdtnx1(_tmpRcmdtnx1);
        final String _tmpRcmdtnc1;
        if (_cursor.isNull(_cursorIndexOfRcmdtnc1)) {
          _tmpRcmdtnc1 = null;
        } else {
          _tmpRcmdtnc1 = _cursor.getString(_cursorIndexOfRcmdtnc1);
        }
        _item.setRcmdtnc1(_tmpRcmdtnc1);
        final String _tmpRcmdtns1;
        if (_cursor.isNull(_cursorIndexOfRcmdtns1)) {
          _tmpRcmdtns1 = null;
        } else {
          _tmpRcmdtns1 = _cursor.getString(_cursorIndexOfRcmdtns1);
        }
        _item.setRcmdtns1(_tmpRcmdtns1);
        final String _tmpRcmdRcd2;
        if (_cursor.isNull(_cursorIndexOfRcmdRcd2)) {
          _tmpRcmdRcd2 = null;
        } else {
          _tmpRcmdRcd2 = _cursor.getString(_cursorIndexOfRcmdRcd2);
        }
        _item.setRcmdRcd2(_tmpRcmdRcd2);
        final String _tmpRcmdtnx2;
        if (_cursor.isNull(_cursorIndexOfRcmdtnx2)) {
          _tmpRcmdtnx2 = null;
        } else {
          _tmpRcmdtnx2 = _cursor.getString(_cursorIndexOfRcmdtnx2);
        }
        _item.setRcmdtnx2(_tmpRcmdtnx2);
        final String _tmpRcmdtnc2;
        if (_cursor.isNull(_cursorIndexOfRcmdtnc2)) {
          _tmpRcmdtnc2 = null;
        } else {
          _tmpRcmdtnc2 = _cursor.getString(_cursorIndexOfRcmdtnc2);
        }
        _item.setRcmdtnc2(_tmpRcmdtnc2);
        final String _tmpRcmdtns2;
        if (_cursor.isNull(_cursorIndexOfRcmdtns2)) {
          _tmpRcmdtns2 = null;
        } else {
          _tmpRcmdtns2 = _cursor.getString(_cursorIndexOfRcmdtns2);
        }
        _item.setRcmdtns2(_tmpRcmdtns2);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpUploaded;
        if (_cursor.isNull(_cursorIndexOfUploaded)) {
          _tmpUploaded = null;
        } else {
          _tmpUploaded = _cursor.getString(_cursorIndexOfUploaded);
        }
        _item.setUploaded(_tmpUploaded);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpTransfer;
        if (_cursor.isNull(_cursorIndexOfTransfer)) {
          _tmpTransfer = null;
        } else {
          _tmpTransfer = _cursor.getString(_cursorIndexOfTransfer);
        }
        _item.setTransfer(_tmpTransfer);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _item.setApproved(_tmpApproved);
        final String _tmpDapprovd;
        if (_cursor.isNull(_cursorIndexOfDapprovd)) {
          _tmpDapprovd = null;
        } else {
          _tmpDapprovd = _cursor.getString(_cursorIndexOfDapprovd);
        }
        _item.setDapprovd(_tmpDapprovd);
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
      _statement.release();
    }
  }

  @Override
  public ECreditOnlineApplicationCI GetApplication(final String fsVal) {
    final String _sql = "SELECT * FROM Credit_Online_Application_CI WHERE sTransNox=?";
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
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
      final int _cursorIndexOfManagerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sManagerx");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfAddrFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddrFndg");
      final int _cursorIndexOfAssetsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAssetsxx");
      final int _cursorIndexOfAsstFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAsstFndg");
      final int _cursorIndexOfIncomexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncomexx");
      final int _cursorIndexOfIncmFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncmFndg");
      final int _cursorIndexOfHasRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRecrd");
      final int _cursorIndexOfRecrdRem = CursorUtil.getColumnIndexOrThrow(_cursor, "sRecrdRem");
      final int _cursorIndexOfPrsnBrgy = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnBrgy");
      final int _cursorIndexOfPrsnPstn = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnPstn");
      final int _cursorIndexOfPrsnNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnNmbr");
      final int _cursorIndexOfNeighBr1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr1");
      final int _cursorIndexOfNeighBr2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr2");
      final int _cursorIndexOfNeighBr3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr3");
      final int _cursorIndexOfRcmdRcd1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd1");
      final int _cursorIndexOfRcmdtnx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx1");
      final int _cursorIndexOfRcmdtnc1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx1");
      final int _cursorIndexOfRcmdtns1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx1");
      final int _cursorIndexOfRcmdRcd2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd2");
      final int _cursorIndexOfRcmdtnx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx2");
      final int _cursorIndexOfRcmdtnc2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx2");
      final int _cursorIndexOfRcmdtns2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx2");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "cUploaded");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfTransfer = CursorUtil.getColumnIndexOrThrow(_cursor, "cTransfer");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDapprovd = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ECreditOnlineApplicationCI _result;
      if(_cursor.moveToFirst()) {
        _result = new ECreditOnlineApplicationCI();
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
        final String _tmpManagerx;
        if (_cursor.isNull(_cursorIndexOfManagerx)) {
          _tmpManagerx = null;
        } else {
          _tmpManagerx = _cursor.getString(_cursorIndexOfManagerx);
        }
        _result.setManagerx(_tmpManagerx);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpAddrFndg;
        if (_cursor.isNull(_cursorIndexOfAddrFndg)) {
          _tmpAddrFndg = null;
        } else {
          _tmpAddrFndg = _cursor.getString(_cursorIndexOfAddrFndg);
        }
        _result.setAddrFndg(_tmpAddrFndg);
        final String _tmpAssetsxx;
        if (_cursor.isNull(_cursorIndexOfAssetsxx)) {
          _tmpAssetsxx = null;
        } else {
          _tmpAssetsxx = _cursor.getString(_cursorIndexOfAssetsxx);
        }
        _result.setAssetsxx(_tmpAssetsxx);
        final String _tmpAsstFndg;
        if (_cursor.isNull(_cursorIndexOfAsstFndg)) {
          _tmpAsstFndg = null;
        } else {
          _tmpAsstFndg = _cursor.getString(_cursorIndexOfAsstFndg);
        }
        _result.setAsstFndg(_tmpAsstFndg);
        final String _tmpIncomexx;
        if (_cursor.isNull(_cursorIndexOfIncomexx)) {
          _tmpIncomexx = null;
        } else {
          _tmpIncomexx = _cursor.getString(_cursorIndexOfIncomexx);
        }
        _result.setIncomexx(_tmpIncomexx);
        final String _tmpIncmFndg;
        if (_cursor.isNull(_cursorIndexOfIncmFndg)) {
          _tmpIncmFndg = null;
        } else {
          _tmpIncmFndg = _cursor.getString(_cursorIndexOfIncmFndg);
        }
        _result.setIncmFndg(_tmpIncmFndg);
        final String _tmpHasRecrd;
        if (_cursor.isNull(_cursorIndexOfHasRecrd)) {
          _tmpHasRecrd = null;
        } else {
          _tmpHasRecrd = _cursor.getString(_cursorIndexOfHasRecrd);
        }
        _result.setHasRecrd(_tmpHasRecrd);
        final String _tmpRecrdRem;
        if (_cursor.isNull(_cursorIndexOfRecrdRem)) {
          _tmpRecrdRem = null;
        } else {
          _tmpRecrdRem = _cursor.getString(_cursorIndexOfRecrdRem);
        }
        _result.setRecrdRem(_tmpRecrdRem);
        final String _tmpPrsnBrgy;
        if (_cursor.isNull(_cursorIndexOfPrsnBrgy)) {
          _tmpPrsnBrgy = null;
        } else {
          _tmpPrsnBrgy = _cursor.getString(_cursorIndexOfPrsnBrgy);
        }
        _result.setPrsnBrgy(_tmpPrsnBrgy);
        final String _tmpPrsnPstn;
        if (_cursor.isNull(_cursorIndexOfPrsnPstn)) {
          _tmpPrsnPstn = null;
        } else {
          _tmpPrsnPstn = _cursor.getString(_cursorIndexOfPrsnPstn);
        }
        _result.setPrsnPstn(_tmpPrsnPstn);
        final String _tmpPrsnNmbr;
        if (_cursor.isNull(_cursorIndexOfPrsnNmbr)) {
          _tmpPrsnNmbr = null;
        } else {
          _tmpPrsnNmbr = _cursor.getString(_cursorIndexOfPrsnNmbr);
        }
        _result.setPrsnNmbr(_tmpPrsnNmbr);
        final String _tmpNeighBr1;
        if (_cursor.isNull(_cursorIndexOfNeighBr1)) {
          _tmpNeighBr1 = null;
        } else {
          _tmpNeighBr1 = _cursor.getString(_cursorIndexOfNeighBr1);
        }
        _result.setNeighBr1(_tmpNeighBr1);
        final String _tmpNeighBr2;
        if (_cursor.isNull(_cursorIndexOfNeighBr2)) {
          _tmpNeighBr2 = null;
        } else {
          _tmpNeighBr2 = _cursor.getString(_cursorIndexOfNeighBr2);
        }
        _result.setNeighBr2(_tmpNeighBr2);
        final String _tmpNeighBr3;
        if (_cursor.isNull(_cursorIndexOfNeighBr3)) {
          _tmpNeighBr3 = null;
        } else {
          _tmpNeighBr3 = _cursor.getString(_cursorIndexOfNeighBr3);
        }
        _result.setNeighBr3(_tmpNeighBr3);
        final String _tmpRcmdRcd1;
        if (_cursor.isNull(_cursorIndexOfRcmdRcd1)) {
          _tmpRcmdRcd1 = null;
        } else {
          _tmpRcmdRcd1 = _cursor.getString(_cursorIndexOfRcmdRcd1);
        }
        _result.setRcmdRcd1(_tmpRcmdRcd1);
        final String _tmpRcmdtnx1;
        if (_cursor.isNull(_cursorIndexOfRcmdtnx1)) {
          _tmpRcmdtnx1 = null;
        } else {
          _tmpRcmdtnx1 = _cursor.getString(_cursorIndexOfRcmdtnx1);
        }
        _result.setRcmdtnx1(_tmpRcmdtnx1);
        final String _tmpRcmdtnc1;
        if (_cursor.isNull(_cursorIndexOfRcmdtnc1)) {
          _tmpRcmdtnc1 = null;
        } else {
          _tmpRcmdtnc1 = _cursor.getString(_cursorIndexOfRcmdtnc1);
        }
        _result.setRcmdtnc1(_tmpRcmdtnc1);
        final String _tmpRcmdtns1;
        if (_cursor.isNull(_cursorIndexOfRcmdtns1)) {
          _tmpRcmdtns1 = null;
        } else {
          _tmpRcmdtns1 = _cursor.getString(_cursorIndexOfRcmdtns1);
        }
        _result.setRcmdtns1(_tmpRcmdtns1);
        final String _tmpRcmdRcd2;
        if (_cursor.isNull(_cursorIndexOfRcmdRcd2)) {
          _tmpRcmdRcd2 = null;
        } else {
          _tmpRcmdRcd2 = _cursor.getString(_cursorIndexOfRcmdRcd2);
        }
        _result.setRcmdRcd2(_tmpRcmdRcd2);
        final String _tmpRcmdtnx2;
        if (_cursor.isNull(_cursorIndexOfRcmdtnx2)) {
          _tmpRcmdtnx2 = null;
        } else {
          _tmpRcmdtnx2 = _cursor.getString(_cursorIndexOfRcmdtnx2);
        }
        _result.setRcmdtnx2(_tmpRcmdtnx2);
        final String _tmpRcmdtnc2;
        if (_cursor.isNull(_cursorIndexOfRcmdtnc2)) {
          _tmpRcmdtnc2 = null;
        } else {
          _tmpRcmdtnc2 = _cursor.getString(_cursorIndexOfRcmdtnc2);
        }
        _result.setRcmdtnc2(_tmpRcmdtnc2);
        final String _tmpRcmdtns2;
        if (_cursor.isNull(_cursorIndexOfRcmdtns2)) {
          _tmpRcmdtns2 = null;
        } else {
          _tmpRcmdtns2 = _cursor.getString(_cursorIndexOfRcmdtns2);
        }
        _result.setRcmdtns2(_tmpRcmdtns2);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpUploaded;
        if (_cursor.isNull(_cursorIndexOfUploaded)) {
          _tmpUploaded = null;
        } else {
          _tmpUploaded = _cursor.getString(_cursorIndexOfUploaded);
        }
        _result.setUploaded(_tmpUploaded);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpTransfer;
        if (_cursor.isNull(_cursorIndexOfTransfer)) {
          _tmpTransfer = null;
        } else {
          _tmpTransfer = _cursor.getString(_cursorIndexOfTransfer);
        }
        _result.setTransfer(_tmpTransfer);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _result.setApproved(_tmpApproved);
        final String _tmpDapprovd;
        if (_cursor.isNull(_cursorIndexOfDapprovd)) {
          _tmpDapprovd = null;
        } else {
          _tmpDapprovd = _cursor.getString(_cursorIndexOfDapprovd);
        }
        _result.setDapprovd(_tmpDapprovd);
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
  public ECreditOnlineApplicationCI CheckIfExist(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Online_Application_CI WHERE sTransNox =?";
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
      final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
      final int _cursorIndexOfManagerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sManagerx");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfAddrFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddrFndg");
      final int _cursorIndexOfAssetsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAssetsxx");
      final int _cursorIndexOfAsstFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAsstFndg");
      final int _cursorIndexOfIncomexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncomexx");
      final int _cursorIndexOfIncmFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncmFndg");
      final int _cursorIndexOfHasRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRecrd");
      final int _cursorIndexOfRecrdRem = CursorUtil.getColumnIndexOrThrow(_cursor, "sRecrdRem");
      final int _cursorIndexOfPrsnBrgy = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnBrgy");
      final int _cursorIndexOfPrsnPstn = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnPstn");
      final int _cursorIndexOfPrsnNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnNmbr");
      final int _cursorIndexOfNeighBr1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr1");
      final int _cursorIndexOfNeighBr2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr2");
      final int _cursorIndexOfNeighBr3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr3");
      final int _cursorIndexOfRcmdRcd1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd1");
      final int _cursorIndexOfRcmdtnx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx1");
      final int _cursorIndexOfRcmdtnc1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx1");
      final int _cursorIndexOfRcmdtns1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx1");
      final int _cursorIndexOfRcmdRcd2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd2");
      final int _cursorIndexOfRcmdtnx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx2");
      final int _cursorIndexOfRcmdtnc2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx2");
      final int _cursorIndexOfRcmdtns2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx2");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "cUploaded");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfTransfer = CursorUtil.getColumnIndexOrThrow(_cursor, "cTransfer");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDapprovd = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ECreditOnlineApplicationCI _result;
      if(_cursor.moveToFirst()) {
        _result = new ECreditOnlineApplicationCI();
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
        final String _tmpManagerx;
        if (_cursor.isNull(_cursorIndexOfManagerx)) {
          _tmpManagerx = null;
        } else {
          _tmpManagerx = _cursor.getString(_cursorIndexOfManagerx);
        }
        _result.setManagerx(_tmpManagerx);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpAddrFndg;
        if (_cursor.isNull(_cursorIndexOfAddrFndg)) {
          _tmpAddrFndg = null;
        } else {
          _tmpAddrFndg = _cursor.getString(_cursorIndexOfAddrFndg);
        }
        _result.setAddrFndg(_tmpAddrFndg);
        final String _tmpAssetsxx;
        if (_cursor.isNull(_cursorIndexOfAssetsxx)) {
          _tmpAssetsxx = null;
        } else {
          _tmpAssetsxx = _cursor.getString(_cursorIndexOfAssetsxx);
        }
        _result.setAssetsxx(_tmpAssetsxx);
        final String _tmpAsstFndg;
        if (_cursor.isNull(_cursorIndexOfAsstFndg)) {
          _tmpAsstFndg = null;
        } else {
          _tmpAsstFndg = _cursor.getString(_cursorIndexOfAsstFndg);
        }
        _result.setAsstFndg(_tmpAsstFndg);
        final String _tmpIncomexx;
        if (_cursor.isNull(_cursorIndexOfIncomexx)) {
          _tmpIncomexx = null;
        } else {
          _tmpIncomexx = _cursor.getString(_cursorIndexOfIncomexx);
        }
        _result.setIncomexx(_tmpIncomexx);
        final String _tmpIncmFndg;
        if (_cursor.isNull(_cursorIndexOfIncmFndg)) {
          _tmpIncmFndg = null;
        } else {
          _tmpIncmFndg = _cursor.getString(_cursorIndexOfIncmFndg);
        }
        _result.setIncmFndg(_tmpIncmFndg);
        final String _tmpHasRecrd;
        if (_cursor.isNull(_cursorIndexOfHasRecrd)) {
          _tmpHasRecrd = null;
        } else {
          _tmpHasRecrd = _cursor.getString(_cursorIndexOfHasRecrd);
        }
        _result.setHasRecrd(_tmpHasRecrd);
        final String _tmpRecrdRem;
        if (_cursor.isNull(_cursorIndexOfRecrdRem)) {
          _tmpRecrdRem = null;
        } else {
          _tmpRecrdRem = _cursor.getString(_cursorIndexOfRecrdRem);
        }
        _result.setRecrdRem(_tmpRecrdRem);
        final String _tmpPrsnBrgy;
        if (_cursor.isNull(_cursorIndexOfPrsnBrgy)) {
          _tmpPrsnBrgy = null;
        } else {
          _tmpPrsnBrgy = _cursor.getString(_cursorIndexOfPrsnBrgy);
        }
        _result.setPrsnBrgy(_tmpPrsnBrgy);
        final String _tmpPrsnPstn;
        if (_cursor.isNull(_cursorIndexOfPrsnPstn)) {
          _tmpPrsnPstn = null;
        } else {
          _tmpPrsnPstn = _cursor.getString(_cursorIndexOfPrsnPstn);
        }
        _result.setPrsnPstn(_tmpPrsnPstn);
        final String _tmpPrsnNmbr;
        if (_cursor.isNull(_cursorIndexOfPrsnNmbr)) {
          _tmpPrsnNmbr = null;
        } else {
          _tmpPrsnNmbr = _cursor.getString(_cursorIndexOfPrsnNmbr);
        }
        _result.setPrsnNmbr(_tmpPrsnNmbr);
        final String _tmpNeighBr1;
        if (_cursor.isNull(_cursorIndexOfNeighBr1)) {
          _tmpNeighBr1 = null;
        } else {
          _tmpNeighBr1 = _cursor.getString(_cursorIndexOfNeighBr1);
        }
        _result.setNeighBr1(_tmpNeighBr1);
        final String _tmpNeighBr2;
        if (_cursor.isNull(_cursorIndexOfNeighBr2)) {
          _tmpNeighBr2 = null;
        } else {
          _tmpNeighBr2 = _cursor.getString(_cursorIndexOfNeighBr2);
        }
        _result.setNeighBr2(_tmpNeighBr2);
        final String _tmpNeighBr3;
        if (_cursor.isNull(_cursorIndexOfNeighBr3)) {
          _tmpNeighBr3 = null;
        } else {
          _tmpNeighBr3 = _cursor.getString(_cursorIndexOfNeighBr3);
        }
        _result.setNeighBr3(_tmpNeighBr3);
        final String _tmpRcmdRcd1;
        if (_cursor.isNull(_cursorIndexOfRcmdRcd1)) {
          _tmpRcmdRcd1 = null;
        } else {
          _tmpRcmdRcd1 = _cursor.getString(_cursorIndexOfRcmdRcd1);
        }
        _result.setRcmdRcd1(_tmpRcmdRcd1);
        final String _tmpRcmdtnx1;
        if (_cursor.isNull(_cursorIndexOfRcmdtnx1)) {
          _tmpRcmdtnx1 = null;
        } else {
          _tmpRcmdtnx1 = _cursor.getString(_cursorIndexOfRcmdtnx1);
        }
        _result.setRcmdtnx1(_tmpRcmdtnx1);
        final String _tmpRcmdtnc1;
        if (_cursor.isNull(_cursorIndexOfRcmdtnc1)) {
          _tmpRcmdtnc1 = null;
        } else {
          _tmpRcmdtnc1 = _cursor.getString(_cursorIndexOfRcmdtnc1);
        }
        _result.setRcmdtnc1(_tmpRcmdtnc1);
        final String _tmpRcmdtns1;
        if (_cursor.isNull(_cursorIndexOfRcmdtns1)) {
          _tmpRcmdtns1 = null;
        } else {
          _tmpRcmdtns1 = _cursor.getString(_cursorIndexOfRcmdtns1);
        }
        _result.setRcmdtns1(_tmpRcmdtns1);
        final String _tmpRcmdRcd2;
        if (_cursor.isNull(_cursorIndexOfRcmdRcd2)) {
          _tmpRcmdRcd2 = null;
        } else {
          _tmpRcmdRcd2 = _cursor.getString(_cursorIndexOfRcmdRcd2);
        }
        _result.setRcmdRcd2(_tmpRcmdRcd2);
        final String _tmpRcmdtnx2;
        if (_cursor.isNull(_cursorIndexOfRcmdtnx2)) {
          _tmpRcmdtnx2 = null;
        } else {
          _tmpRcmdtnx2 = _cursor.getString(_cursorIndexOfRcmdtnx2);
        }
        _result.setRcmdtnx2(_tmpRcmdtnx2);
        final String _tmpRcmdtnc2;
        if (_cursor.isNull(_cursorIndexOfRcmdtnc2)) {
          _tmpRcmdtnc2 = null;
        } else {
          _tmpRcmdtnc2 = _cursor.getString(_cursorIndexOfRcmdtnc2);
        }
        _result.setRcmdtnc2(_tmpRcmdtnc2);
        final String _tmpRcmdtns2;
        if (_cursor.isNull(_cursorIndexOfRcmdtns2)) {
          _tmpRcmdtns2 = null;
        } else {
          _tmpRcmdtns2 = _cursor.getString(_cursorIndexOfRcmdtns2);
        }
        _result.setRcmdtns2(_tmpRcmdtns2);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpUploaded;
        if (_cursor.isNull(_cursorIndexOfUploaded)) {
          _tmpUploaded = null;
        } else {
          _tmpUploaded = _cursor.getString(_cursorIndexOfUploaded);
        }
        _result.setUploaded(_tmpUploaded);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpTransfer;
        if (_cursor.isNull(_cursorIndexOfTransfer)) {
          _tmpTransfer = null;
        } else {
          _tmpTransfer = _cursor.getString(_cursorIndexOfTransfer);
        }
        _result.setTransfer(_tmpTransfer);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _result.setApproved(_tmpApproved);
        final String _tmpDapprovd;
        if (_cursor.isNull(_cursorIndexOfDapprovd)) {
          _tmpDapprovd = null;
        } else {
          _tmpDapprovd = _cursor.getString(_cursorIndexOfDapprovd);
        }
        _result.setDapprovd(_tmpDapprovd);
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
  public LiveData<List<ECreditOnlineApplicationCI>> getForEvaluationList() {
    final String _sql = "SELECT * FROM Credit_Online_Application_CI WHERE cTranStat = '0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_CI"}, false, new Callable<List<ECreditOnlineApplicationCI>>() {
      @Override
      public List<ECreditOnlineApplicationCI> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
          final int _cursorIndexOfManagerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sManagerx");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfAddrFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddrFndg");
          final int _cursorIndexOfAssetsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAssetsxx");
          final int _cursorIndexOfAsstFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAsstFndg");
          final int _cursorIndexOfIncomexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncomexx");
          final int _cursorIndexOfIncmFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncmFndg");
          final int _cursorIndexOfHasRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRecrd");
          final int _cursorIndexOfRecrdRem = CursorUtil.getColumnIndexOrThrow(_cursor, "sRecrdRem");
          final int _cursorIndexOfPrsnBrgy = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnBrgy");
          final int _cursorIndexOfPrsnPstn = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnPstn");
          final int _cursorIndexOfPrsnNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnNmbr");
          final int _cursorIndexOfNeighBr1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr1");
          final int _cursorIndexOfNeighBr2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr2");
          final int _cursorIndexOfNeighBr3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr3");
          final int _cursorIndexOfRcmdRcd1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd1");
          final int _cursorIndexOfRcmdtnx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx1");
          final int _cursorIndexOfRcmdtnc1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx1");
          final int _cursorIndexOfRcmdtns1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx1");
          final int _cursorIndexOfRcmdRcd2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd2");
          final int _cursorIndexOfRcmdtnx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx2");
          final int _cursorIndexOfRcmdtnc2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx2");
          final int _cursorIndexOfRcmdtns2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx2");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "cUploaded");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfTransfer = CursorUtil.getColumnIndexOrThrow(_cursor, "cTransfer");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDapprovd = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<ECreditOnlineApplicationCI> _result = new ArrayList<ECreditOnlineApplicationCI>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ECreditOnlineApplicationCI _item;
            _item = new ECreditOnlineApplicationCI();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpCredInvx;
            if (_cursor.isNull(_cursorIndexOfCredInvx)) {
              _tmpCredInvx = null;
            } else {
              _tmpCredInvx = _cursor.getString(_cursorIndexOfCredInvx);
            }
            _item.setCredInvx(_tmpCredInvx);
            final String _tmpManagerx;
            if (_cursor.isNull(_cursorIndexOfManagerx)) {
              _tmpManagerx = null;
            } else {
              _tmpManagerx = _cursor.getString(_cursorIndexOfManagerx);
            }
            _item.setManagerx(_tmpManagerx);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpAddrFndg;
            if (_cursor.isNull(_cursorIndexOfAddrFndg)) {
              _tmpAddrFndg = null;
            } else {
              _tmpAddrFndg = _cursor.getString(_cursorIndexOfAddrFndg);
            }
            _item.setAddrFndg(_tmpAddrFndg);
            final String _tmpAssetsxx;
            if (_cursor.isNull(_cursorIndexOfAssetsxx)) {
              _tmpAssetsxx = null;
            } else {
              _tmpAssetsxx = _cursor.getString(_cursorIndexOfAssetsxx);
            }
            _item.setAssetsxx(_tmpAssetsxx);
            final String _tmpAsstFndg;
            if (_cursor.isNull(_cursorIndexOfAsstFndg)) {
              _tmpAsstFndg = null;
            } else {
              _tmpAsstFndg = _cursor.getString(_cursorIndexOfAsstFndg);
            }
            _item.setAsstFndg(_tmpAsstFndg);
            final String _tmpIncomexx;
            if (_cursor.isNull(_cursorIndexOfIncomexx)) {
              _tmpIncomexx = null;
            } else {
              _tmpIncomexx = _cursor.getString(_cursorIndexOfIncomexx);
            }
            _item.setIncomexx(_tmpIncomexx);
            final String _tmpIncmFndg;
            if (_cursor.isNull(_cursorIndexOfIncmFndg)) {
              _tmpIncmFndg = null;
            } else {
              _tmpIncmFndg = _cursor.getString(_cursorIndexOfIncmFndg);
            }
            _item.setIncmFndg(_tmpIncmFndg);
            final String _tmpHasRecrd;
            if (_cursor.isNull(_cursorIndexOfHasRecrd)) {
              _tmpHasRecrd = null;
            } else {
              _tmpHasRecrd = _cursor.getString(_cursorIndexOfHasRecrd);
            }
            _item.setHasRecrd(_tmpHasRecrd);
            final String _tmpRecrdRem;
            if (_cursor.isNull(_cursorIndexOfRecrdRem)) {
              _tmpRecrdRem = null;
            } else {
              _tmpRecrdRem = _cursor.getString(_cursorIndexOfRecrdRem);
            }
            _item.setRecrdRem(_tmpRecrdRem);
            final String _tmpPrsnBrgy;
            if (_cursor.isNull(_cursorIndexOfPrsnBrgy)) {
              _tmpPrsnBrgy = null;
            } else {
              _tmpPrsnBrgy = _cursor.getString(_cursorIndexOfPrsnBrgy);
            }
            _item.setPrsnBrgy(_tmpPrsnBrgy);
            final String _tmpPrsnPstn;
            if (_cursor.isNull(_cursorIndexOfPrsnPstn)) {
              _tmpPrsnPstn = null;
            } else {
              _tmpPrsnPstn = _cursor.getString(_cursorIndexOfPrsnPstn);
            }
            _item.setPrsnPstn(_tmpPrsnPstn);
            final String _tmpPrsnNmbr;
            if (_cursor.isNull(_cursorIndexOfPrsnNmbr)) {
              _tmpPrsnNmbr = null;
            } else {
              _tmpPrsnNmbr = _cursor.getString(_cursorIndexOfPrsnNmbr);
            }
            _item.setPrsnNmbr(_tmpPrsnNmbr);
            final String _tmpNeighBr1;
            if (_cursor.isNull(_cursorIndexOfNeighBr1)) {
              _tmpNeighBr1 = null;
            } else {
              _tmpNeighBr1 = _cursor.getString(_cursorIndexOfNeighBr1);
            }
            _item.setNeighBr1(_tmpNeighBr1);
            final String _tmpNeighBr2;
            if (_cursor.isNull(_cursorIndexOfNeighBr2)) {
              _tmpNeighBr2 = null;
            } else {
              _tmpNeighBr2 = _cursor.getString(_cursorIndexOfNeighBr2);
            }
            _item.setNeighBr2(_tmpNeighBr2);
            final String _tmpNeighBr3;
            if (_cursor.isNull(_cursorIndexOfNeighBr3)) {
              _tmpNeighBr3 = null;
            } else {
              _tmpNeighBr3 = _cursor.getString(_cursorIndexOfNeighBr3);
            }
            _item.setNeighBr3(_tmpNeighBr3);
            final String _tmpRcmdRcd1;
            if (_cursor.isNull(_cursorIndexOfRcmdRcd1)) {
              _tmpRcmdRcd1 = null;
            } else {
              _tmpRcmdRcd1 = _cursor.getString(_cursorIndexOfRcmdRcd1);
            }
            _item.setRcmdRcd1(_tmpRcmdRcd1);
            final String _tmpRcmdtnx1;
            if (_cursor.isNull(_cursorIndexOfRcmdtnx1)) {
              _tmpRcmdtnx1 = null;
            } else {
              _tmpRcmdtnx1 = _cursor.getString(_cursorIndexOfRcmdtnx1);
            }
            _item.setRcmdtnx1(_tmpRcmdtnx1);
            final String _tmpRcmdtnc1;
            if (_cursor.isNull(_cursorIndexOfRcmdtnc1)) {
              _tmpRcmdtnc1 = null;
            } else {
              _tmpRcmdtnc1 = _cursor.getString(_cursorIndexOfRcmdtnc1);
            }
            _item.setRcmdtnc1(_tmpRcmdtnc1);
            final String _tmpRcmdtns1;
            if (_cursor.isNull(_cursorIndexOfRcmdtns1)) {
              _tmpRcmdtns1 = null;
            } else {
              _tmpRcmdtns1 = _cursor.getString(_cursorIndexOfRcmdtns1);
            }
            _item.setRcmdtns1(_tmpRcmdtns1);
            final String _tmpRcmdRcd2;
            if (_cursor.isNull(_cursorIndexOfRcmdRcd2)) {
              _tmpRcmdRcd2 = null;
            } else {
              _tmpRcmdRcd2 = _cursor.getString(_cursorIndexOfRcmdRcd2);
            }
            _item.setRcmdRcd2(_tmpRcmdRcd2);
            final String _tmpRcmdtnx2;
            if (_cursor.isNull(_cursorIndexOfRcmdtnx2)) {
              _tmpRcmdtnx2 = null;
            } else {
              _tmpRcmdtnx2 = _cursor.getString(_cursorIndexOfRcmdtnx2);
            }
            _item.setRcmdtnx2(_tmpRcmdtnx2);
            final String _tmpRcmdtnc2;
            if (_cursor.isNull(_cursorIndexOfRcmdtnc2)) {
              _tmpRcmdtnc2 = null;
            } else {
              _tmpRcmdtnc2 = _cursor.getString(_cursorIndexOfRcmdtnc2);
            }
            _item.setRcmdtnc2(_tmpRcmdtnc2);
            final String _tmpRcmdtns2;
            if (_cursor.isNull(_cursorIndexOfRcmdtns2)) {
              _tmpRcmdtns2 = null;
            } else {
              _tmpRcmdtns2 = _cursor.getString(_cursorIndexOfRcmdtns2);
            }
            _item.setRcmdtns2(_tmpRcmdtns2);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpUploaded;
            if (_cursor.isNull(_cursorIndexOfUploaded)) {
              _tmpUploaded = null;
            } else {
              _tmpUploaded = _cursor.getString(_cursorIndexOfUploaded);
            }
            _item.setUploaded(_tmpUploaded);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpTransfer;
            if (_cursor.isNull(_cursorIndexOfTransfer)) {
              _tmpTransfer = null;
            } else {
              _tmpTransfer = _cursor.getString(_cursorIndexOfTransfer);
            }
            _item.setTransfer(_tmpTransfer);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _item.setApproved(_tmpApproved);
            final String _tmpDapprovd;
            if (_cursor.isNull(_cursorIndexOfDapprovd)) {
              _tmpDapprovd = null;
            } else {
              _tmpDapprovd = _cursor.getString(_cursorIndexOfDapprovd);
            }
            _item.setDapprovd(_tmpDapprovd);
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
  public LiveData<List<ECreditOnlineApplicationCI>> getForPreviewResultList() {
    final String _sql = "SELECT * FROM Credit_Online_Application_CI WHERE cTranStat = '1' AND cRcmdtnx1 IS NOT NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_CI"}, false, new Callable<List<ECreditOnlineApplicationCI>>() {
      @Override
      public List<ECreditOnlineApplicationCI> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
          final int _cursorIndexOfManagerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sManagerx");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfAddrFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddrFndg");
          final int _cursorIndexOfAssetsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAssetsxx");
          final int _cursorIndexOfAsstFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAsstFndg");
          final int _cursorIndexOfIncomexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncomexx");
          final int _cursorIndexOfIncmFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncmFndg");
          final int _cursorIndexOfHasRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRecrd");
          final int _cursorIndexOfRecrdRem = CursorUtil.getColumnIndexOrThrow(_cursor, "sRecrdRem");
          final int _cursorIndexOfPrsnBrgy = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnBrgy");
          final int _cursorIndexOfPrsnPstn = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnPstn");
          final int _cursorIndexOfPrsnNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnNmbr");
          final int _cursorIndexOfNeighBr1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr1");
          final int _cursorIndexOfNeighBr2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr2");
          final int _cursorIndexOfNeighBr3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr3");
          final int _cursorIndexOfRcmdRcd1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd1");
          final int _cursorIndexOfRcmdtnx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx1");
          final int _cursorIndexOfRcmdtnc1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx1");
          final int _cursorIndexOfRcmdtns1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx1");
          final int _cursorIndexOfRcmdRcd2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd2");
          final int _cursorIndexOfRcmdtnx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx2");
          final int _cursorIndexOfRcmdtnc2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx2");
          final int _cursorIndexOfRcmdtns2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx2");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "cUploaded");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfTransfer = CursorUtil.getColumnIndexOrThrow(_cursor, "cTransfer");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDapprovd = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<ECreditOnlineApplicationCI> _result = new ArrayList<ECreditOnlineApplicationCI>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ECreditOnlineApplicationCI _item;
            _item = new ECreditOnlineApplicationCI();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpCredInvx;
            if (_cursor.isNull(_cursorIndexOfCredInvx)) {
              _tmpCredInvx = null;
            } else {
              _tmpCredInvx = _cursor.getString(_cursorIndexOfCredInvx);
            }
            _item.setCredInvx(_tmpCredInvx);
            final String _tmpManagerx;
            if (_cursor.isNull(_cursorIndexOfManagerx)) {
              _tmpManagerx = null;
            } else {
              _tmpManagerx = _cursor.getString(_cursorIndexOfManagerx);
            }
            _item.setManagerx(_tmpManagerx);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpAddrFndg;
            if (_cursor.isNull(_cursorIndexOfAddrFndg)) {
              _tmpAddrFndg = null;
            } else {
              _tmpAddrFndg = _cursor.getString(_cursorIndexOfAddrFndg);
            }
            _item.setAddrFndg(_tmpAddrFndg);
            final String _tmpAssetsxx;
            if (_cursor.isNull(_cursorIndexOfAssetsxx)) {
              _tmpAssetsxx = null;
            } else {
              _tmpAssetsxx = _cursor.getString(_cursorIndexOfAssetsxx);
            }
            _item.setAssetsxx(_tmpAssetsxx);
            final String _tmpAsstFndg;
            if (_cursor.isNull(_cursorIndexOfAsstFndg)) {
              _tmpAsstFndg = null;
            } else {
              _tmpAsstFndg = _cursor.getString(_cursorIndexOfAsstFndg);
            }
            _item.setAsstFndg(_tmpAsstFndg);
            final String _tmpIncomexx;
            if (_cursor.isNull(_cursorIndexOfIncomexx)) {
              _tmpIncomexx = null;
            } else {
              _tmpIncomexx = _cursor.getString(_cursorIndexOfIncomexx);
            }
            _item.setIncomexx(_tmpIncomexx);
            final String _tmpIncmFndg;
            if (_cursor.isNull(_cursorIndexOfIncmFndg)) {
              _tmpIncmFndg = null;
            } else {
              _tmpIncmFndg = _cursor.getString(_cursorIndexOfIncmFndg);
            }
            _item.setIncmFndg(_tmpIncmFndg);
            final String _tmpHasRecrd;
            if (_cursor.isNull(_cursorIndexOfHasRecrd)) {
              _tmpHasRecrd = null;
            } else {
              _tmpHasRecrd = _cursor.getString(_cursorIndexOfHasRecrd);
            }
            _item.setHasRecrd(_tmpHasRecrd);
            final String _tmpRecrdRem;
            if (_cursor.isNull(_cursorIndexOfRecrdRem)) {
              _tmpRecrdRem = null;
            } else {
              _tmpRecrdRem = _cursor.getString(_cursorIndexOfRecrdRem);
            }
            _item.setRecrdRem(_tmpRecrdRem);
            final String _tmpPrsnBrgy;
            if (_cursor.isNull(_cursorIndexOfPrsnBrgy)) {
              _tmpPrsnBrgy = null;
            } else {
              _tmpPrsnBrgy = _cursor.getString(_cursorIndexOfPrsnBrgy);
            }
            _item.setPrsnBrgy(_tmpPrsnBrgy);
            final String _tmpPrsnPstn;
            if (_cursor.isNull(_cursorIndexOfPrsnPstn)) {
              _tmpPrsnPstn = null;
            } else {
              _tmpPrsnPstn = _cursor.getString(_cursorIndexOfPrsnPstn);
            }
            _item.setPrsnPstn(_tmpPrsnPstn);
            final String _tmpPrsnNmbr;
            if (_cursor.isNull(_cursorIndexOfPrsnNmbr)) {
              _tmpPrsnNmbr = null;
            } else {
              _tmpPrsnNmbr = _cursor.getString(_cursorIndexOfPrsnNmbr);
            }
            _item.setPrsnNmbr(_tmpPrsnNmbr);
            final String _tmpNeighBr1;
            if (_cursor.isNull(_cursorIndexOfNeighBr1)) {
              _tmpNeighBr1 = null;
            } else {
              _tmpNeighBr1 = _cursor.getString(_cursorIndexOfNeighBr1);
            }
            _item.setNeighBr1(_tmpNeighBr1);
            final String _tmpNeighBr2;
            if (_cursor.isNull(_cursorIndexOfNeighBr2)) {
              _tmpNeighBr2 = null;
            } else {
              _tmpNeighBr2 = _cursor.getString(_cursorIndexOfNeighBr2);
            }
            _item.setNeighBr2(_tmpNeighBr2);
            final String _tmpNeighBr3;
            if (_cursor.isNull(_cursorIndexOfNeighBr3)) {
              _tmpNeighBr3 = null;
            } else {
              _tmpNeighBr3 = _cursor.getString(_cursorIndexOfNeighBr3);
            }
            _item.setNeighBr3(_tmpNeighBr3);
            final String _tmpRcmdRcd1;
            if (_cursor.isNull(_cursorIndexOfRcmdRcd1)) {
              _tmpRcmdRcd1 = null;
            } else {
              _tmpRcmdRcd1 = _cursor.getString(_cursorIndexOfRcmdRcd1);
            }
            _item.setRcmdRcd1(_tmpRcmdRcd1);
            final String _tmpRcmdtnx1;
            if (_cursor.isNull(_cursorIndexOfRcmdtnx1)) {
              _tmpRcmdtnx1 = null;
            } else {
              _tmpRcmdtnx1 = _cursor.getString(_cursorIndexOfRcmdtnx1);
            }
            _item.setRcmdtnx1(_tmpRcmdtnx1);
            final String _tmpRcmdtnc1;
            if (_cursor.isNull(_cursorIndexOfRcmdtnc1)) {
              _tmpRcmdtnc1 = null;
            } else {
              _tmpRcmdtnc1 = _cursor.getString(_cursorIndexOfRcmdtnc1);
            }
            _item.setRcmdtnc1(_tmpRcmdtnc1);
            final String _tmpRcmdtns1;
            if (_cursor.isNull(_cursorIndexOfRcmdtns1)) {
              _tmpRcmdtns1 = null;
            } else {
              _tmpRcmdtns1 = _cursor.getString(_cursorIndexOfRcmdtns1);
            }
            _item.setRcmdtns1(_tmpRcmdtns1);
            final String _tmpRcmdRcd2;
            if (_cursor.isNull(_cursorIndexOfRcmdRcd2)) {
              _tmpRcmdRcd2 = null;
            } else {
              _tmpRcmdRcd2 = _cursor.getString(_cursorIndexOfRcmdRcd2);
            }
            _item.setRcmdRcd2(_tmpRcmdRcd2);
            final String _tmpRcmdtnx2;
            if (_cursor.isNull(_cursorIndexOfRcmdtnx2)) {
              _tmpRcmdtnx2 = null;
            } else {
              _tmpRcmdtnx2 = _cursor.getString(_cursorIndexOfRcmdtnx2);
            }
            _item.setRcmdtnx2(_tmpRcmdtnx2);
            final String _tmpRcmdtnc2;
            if (_cursor.isNull(_cursorIndexOfRcmdtnc2)) {
              _tmpRcmdtnc2 = null;
            } else {
              _tmpRcmdtnc2 = _cursor.getString(_cursorIndexOfRcmdtnc2);
            }
            _item.setRcmdtnc2(_tmpRcmdtnc2);
            final String _tmpRcmdtns2;
            if (_cursor.isNull(_cursorIndexOfRcmdtns2)) {
              _tmpRcmdtns2 = null;
            } else {
              _tmpRcmdtns2 = _cursor.getString(_cursorIndexOfRcmdtns2);
            }
            _item.setRcmdtns2(_tmpRcmdtns2);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpUploaded;
            if (_cursor.isNull(_cursorIndexOfUploaded)) {
              _tmpUploaded = null;
            } else {
              _tmpUploaded = _cursor.getString(_cursorIndexOfUploaded);
            }
            _item.setUploaded(_tmpUploaded);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpTransfer;
            if (_cursor.isNull(_cursorIndexOfTransfer)) {
              _tmpTransfer = null;
            } else {
              _tmpTransfer = _cursor.getString(_cursorIndexOfTransfer);
            }
            _item.setTransfer(_tmpTransfer);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _item.setApproved(_tmpApproved);
            final String _tmpDapprovd;
            if (_cursor.isNull(_cursorIndexOfDapprovd)) {
              _tmpDapprovd = null;
            } else {
              _tmpDapprovd = _cursor.getString(_cursorIndexOfDapprovd);
            }
            _item.setDapprovd(_tmpDapprovd);
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
  public ECreditOnlineApplicationCI getApplication(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Online_Application_CI WHERE sTransNox=?";
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
      final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
      final int _cursorIndexOfManagerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sManagerx");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfAddrFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddrFndg");
      final int _cursorIndexOfAssetsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAssetsxx");
      final int _cursorIndexOfAsstFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAsstFndg");
      final int _cursorIndexOfIncomexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncomexx");
      final int _cursorIndexOfIncmFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncmFndg");
      final int _cursorIndexOfHasRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRecrd");
      final int _cursorIndexOfRecrdRem = CursorUtil.getColumnIndexOrThrow(_cursor, "sRecrdRem");
      final int _cursorIndexOfPrsnBrgy = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnBrgy");
      final int _cursorIndexOfPrsnPstn = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnPstn");
      final int _cursorIndexOfPrsnNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnNmbr");
      final int _cursorIndexOfNeighBr1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr1");
      final int _cursorIndexOfNeighBr2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr2");
      final int _cursorIndexOfNeighBr3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr3");
      final int _cursorIndexOfRcmdRcd1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd1");
      final int _cursorIndexOfRcmdtnx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx1");
      final int _cursorIndexOfRcmdtnc1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx1");
      final int _cursorIndexOfRcmdtns1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx1");
      final int _cursorIndexOfRcmdRcd2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd2");
      final int _cursorIndexOfRcmdtnx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx2");
      final int _cursorIndexOfRcmdtnc2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx2");
      final int _cursorIndexOfRcmdtns2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx2");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "cUploaded");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfTransfer = CursorUtil.getColumnIndexOrThrow(_cursor, "cTransfer");
      final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
      final int _cursorIndexOfDapprovd = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ECreditOnlineApplicationCI _result;
      if(_cursor.moveToFirst()) {
        _result = new ECreditOnlineApplicationCI();
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
        final String _tmpManagerx;
        if (_cursor.isNull(_cursorIndexOfManagerx)) {
          _tmpManagerx = null;
        } else {
          _tmpManagerx = _cursor.getString(_cursorIndexOfManagerx);
        }
        _result.setManagerx(_tmpManagerx);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpAddrFndg;
        if (_cursor.isNull(_cursorIndexOfAddrFndg)) {
          _tmpAddrFndg = null;
        } else {
          _tmpAddrFndg = _cursor.getString(_cursorIndexOfAddrFndg);
        }
        _result.setAddrFndg(_tmpAddrFndg);
        final String _tmpAssetsxx;
        if (_cursor.isNull(_cursorIndexOfAssetsxx)) {
          _tmpAssetsxx = null;
        } else {
          _tmpAssetsxx = _cursor.getString(_cursorIndexOfAssetsxx);
        }
        _result.setAssetsxx(_tmpAssetsxx);
        final String _tmpAsstFndg;
        if (_cursor.isNull(_cursorIndexOfAsstFndg)) {
          _tmpAsstFndg = null;
        } else {
          _tmpAsstFndg = _cursor.getString(_cursorIndexOfAsstFndg);
        }
        _result.setAsstFndg(_tmpAsstFndg);
        final String _tmpIncomexx;
        if (_cursor.isNull(_cursorIndexOfIncomexx)) {
          _tmpIncomexx = null;
        } else {
          _tmpIncomexx = _cursor.getString(_cursorIndexOfIncomexx);
        }
        _result.setIncomexx(_tmpIncomexx);
        final String _tmpIncmFndg;
        if (_cursor.isNull(_cursorIndexOfIncmFndg)) {
          _tmpIncmFndg = null;
        } else {
          _tmpIncmFndg = _cursor.getString(_cursorIndexOfIncmFndg);
        }
        _result.setIncmFndg(_tmpIncmFndg);
        final String _tmpHasRecrd;
        if (_cursor.isNull(_cursorIndexOfHasRecrd)) {
          _tmpHasRecrd = null;
        } else {
          _tmpHasRecrd = _cursor.getString(_cursorIndexOfHasRecrd);
        }
        _result.setHasRecrd(_tmpHasRecrd);
        final String _tmpRecrdRem;
        if (_cursor.isNull(_cursorIndexOfRecrdRem)) {
          _tmpRecrdRem = null;
        } else {
          _tmpRecrdRem = _cursor.getString(_cursorIndexOfRecrdRem);
        }
        _result.setRecrdRem(_tmpRecrdRem);
        final String _tmpPrsnBrgy;
        if (_cursor.isNull(_cursorIndexOfPrsnBrgy)) {
          _tmpPrsnBrgy = null;
        } else {
          _tmpPrsnBrgy = _cursor.getString(_cursorIndexOfPrsnBrgy);
        }
        _result.setPrsnBrgy(_tmpPrsnBrgy);
        final String _tmpPrsnPstn;
        if (_cursor.isNull(_cursorIndexOfPrsnPstn)) {
          _tmpPrsnPstn = null;
        } else {
          _tmpPrsnPstn = _cursor.getString(_cursorIndexOfPrsnPstn);
        }
        _result.setPrsnPstn(_tmpPrsnPstn);
        final String _tmpPrsnNmbr;
        if (_cursor.isNull(_cursorIndexOfPrsnNmbr)) {
          _tmpPrsnNmbr = null;
        } else {
          _tmpPrsnNmbr = _cursor.getString(_cursorIndexOfPrsnNmbr);
        }
        _result.setPrsnNmbr(_tmpPrsnNmbr);
        final String _tmpNeighBr1;
        if (_cursor.isNull(_cursorIndexOfNeighBr1)) {
          _tmpNeighBr1 = null;
        } else {
          _tmpNeighBr1 = _cursor.getString(_cursorIndexOfNeighBr1);
        }
        _result.setNeighBr1(_tmpNeighBr1);
        final String _tmpNeighBr2;
        if (_cursor.isNull(_cursorIndexOfNeighBr2)) {
          _tmpNeighBr2 = null;
        } else {
          _tmpNeighBr2 = _cursor.getString(_cursorIndexOfNeighBr2);
        }
        _result.setNeighBr2(_tmpNeighBr2);
        final String _tmpNeighBr3;
        if (_cursor.isNull(_cursorIndexOfNeighBr3)) {
          _tmpNeighBr3 = null;
        } else {
          _tmpNeighBr3 = _cursor.getString(_cursorIndexOfNeighBr3);
        }
        _result.setNeighBr3(_tmpNeighBr3);
        final String _tmpRcmdRcd1;
        if (_cursor.isNull(_cursorIndexOfRcmdRcd1)) {
          _tmpRcmdRcd1 = null;
        } else {
          _tmpRcmdRcd1 = _cursor.getString(_cursorIndexOfRcmdRcd1);
        }
        _result.setRcmdRcd1(_tmpRcmdRcd1);
        final String _tmpRcmdtnx1;
        if (_cursor.isNull(_cursorIndexOfRcmdtnx1)) {
          _tmpRcmdtnx1 = null;
        } else {
          _tmpRcmdtnx1 = _cursor.getString(_cursorIndexOfRcmdtnx1);
        }
        _result.setRcmdtnx1(_tmpRcmdtnx1);
        final String _tmpRcmdtnc1;
        if (_cursor.isNull(_cursorIndexOfRcmdtnc1)) {
          _tmpRcmdtnc1 = null;
        } else {
          _tmpRcmdtnc1 = _cursor.getString(_cursorIndexOfRcmdtnc1);
        }
        _result.setRcmdtnc1(_tmpRcmdtnc1);
        final String _tmpRcmdtns1;
        if (_cursor.isNull(_cursorIndexOfRcmdtns1)) {
          _tmpRcmdtns1 = null;
        } else {
          _tmpRcmdtns1 = _cursor.getString(_cursorIndexOfRcmdtns1);
        }
        _result.setRcmdtns1(_tmpRcmdtns1);
        final String _tmpRcmdRcd2;
        if (_cursor.isNull(_cursorIndexOfRcmdRcd2)) {
          _tmpRcmdRcd2 = null;
        } else {
          _tmpRcmdRcd2 = _cursor.getString(_cursorIndexOfRcmdRcd2);
        }
        _result.setRcmdRcd2(_tmpRcmdRcd2);
        final String _tmpRcmdtnx2;
        if (_cursor.isNull(_cursorIndexOfRcmdtnx2)) {
          _tmpRcmdtnx2 = null;
        } else {
          _tmpRcmdtnx2 = _cursor.getString(_cursorIndexOfRcmdtnx2);
        }
        _result.setRcmdtnx2(_tmpRcmdtnx2);
        final String _tmpRcmdtnc2;
        if (_cursor.isNull(_cursorIndexOfRcmdtnc2)) {
          _tmpRcmdtnc2 = null;
        } else {
          _tmpRcmdtnc2 = _cursor.getString(_cursorIndexOfRcmdtnc2);
        }
        _result.setRcmdtnc2(_tmpRcmdtnc2);
        final String _tmpRcmdtns2;
        if (_cursor.isNull(_cursorIndexOfRcmdtns2)) {
          _tmpRcmdtns2 = null;
        } else {
          _tmpRcmdtns2 = _cursor.getString(_cursorIndexOfRcmdtns2);
        }
        _result.setRcmdtns2(_tmpRcmdtns2);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpUploaded;
        if (_cursor.isNull(_cursorIndexOfUploaded)) {
          _tmpUploaded = null;
        } else {
          _tmpUploaded = _cursor.getString(_cursorIndexOfUploaded);
        }
        _result.setUploaded(_tmpUploaded);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpTransfer;
        if (_cursor.isNull(_cursorIndexOfTransfer)) {
          _tmpTransfer = null;
        } else {
          _tmpTransfer = _cursor.getString(_cursorIndexOfTransfer);
        }
        _result.setTransfer(_tmpTransfer);
        final String _tmpApproved;
        if (_cursor.isNull(_cursorIndexOfApproved)) {
          _tmpApproved = null;
        } else {
          _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
        }
        _result.setApproved(_tmpApproved);
        final String _tmpDapprovd;
        if (_cursor.isNull(_cursorIndexOfDapprovd)) {
          _tmpDapprovd = null;
        } else {
          _tmpDapprovd = _cursor.getString(_cursorIndexOfDapprovd);
        }
        _result.setDapprovd(_tmpDapprovd);
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
  public LiveData<ECreditOnlineApplicationCI> getApplications(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Online_Application_CI WHERE sTransNox=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_CI"}, false, new Callable<ECreditOnlineApplicationCI>() {
      @Override
      public ECreditOnlineApplicationCI call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
          final int _cursorIndexOfManagerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sManagerx");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfAddrFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddrFndg");
          final int _cursorIndexOfAssetsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAssetsxx");
          final int _cursorIndexOfAsstFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAsstFndg");
          final int _cursorIndexOfIncomexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncomexx");
          final int _cursorIndexOfIncmFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncmFndg");
          final int _cursorIndexOfHasRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRecrd");
          final int _cursorIndexOfRecrdRem = CursorUtil.getColumnIndexOrThrow(_cursor, "sRecrdRem");
          final int _cursorIndexOfPrsnBrgy = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnBrgy");
          final int _cursorIndexOfPrsnPstn = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnPstn");
          final int _cursorIndexOfPrsnNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnNmbr");
          final int _cursorIndexOfNeighBr1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr1");
          final int _cursorIndexOfNeighBr2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr2");
          final int _cursorIndexOfNeighBr3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr3");
          final int _cursorIndexOfRcmdRcd1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd1");
          final int _cursorIndexOfRcmdtnx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx1");
          final int _cursorIndexOfRcmdtnc1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx1");
          final int _cursorIndexOfRcmdtns1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx1");
          final int _cursorIndexOfRcmdRcd2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd2");
          final int _cursorIndexOfRcmdtnx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx2");
          final int _cursorIndexOfRcmdtnc2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx2");
          final int _cursorIndexOfRcmdtns2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx2");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "cUploaded");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfTransfer = CursorUtil.getColumnIndexOrThrow(_cursor, "cTransfer");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDapprovd = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final ECreditOnlineApplicationCI _result;
          if(_cursor.moveToFirst()) {
            _result = new ECreditOnlineApplicationCI();
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
            final String _tmpManagerx;
            if (_cursor.isNull(_cursorIndexOfManagerx)) {
              _tmpManagerx = null;
            } else {
              _tmpManagerx = _cursor.getString(_cursorIndexOfManagerx);
            }
            _result.setManagerx(_tmpManagerx);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpAddrFndg;
            if (_cursor.isNull(_cursorIndexOfAddrFndg)) {
              _tmpAddrFndg = null;
            } else {
              _tmpAddrFndg = _cursor.getString(_cursorIndexOfAddrFndg);
            }
            _result.setAddrFndg(_tmpAddrFndg);
            final String _tmpAssetsxx;
            if (_cursor.isNull(_cursorIndexOfAssetsxx)) {
              _tmpAssetsxx = null;
            } else {
              _tmpAssetsxx = _cursor.getString(_cursorIndexOfAssetsxx);
            }
            _result.setAssetsxx(_tmpAssetsxx);
            final String _tmpAsstFndg;
            if (_cursor.isNull(_cursorIndexOfAsstFndg)) {
              _tmpAsstFndg = null;
            } else {
              _tmpAsstFndg = _cursor.getString(_cursorIndexOfAsstFndg);
            }
            _result.setAsstFndg(_tmpAsstFndg);
            final String _tmpIncomexx;
            if (_cursor.isNull(_cursorIndexOfIncomexx)) {
              _tmpIncomexx = null;
            } else {
              _tmpIncomexx = _cursor.getString(_cursorIndexOfIncomexx);
            }
            _result.setIncomexx(_tmpIncomexx);
            final String _tmpIncmFndg;
            if (_cursor.isNull(_cursorIndexOfIncmFndg)) {
              _tmpIncmFndg = null;
            } else {
              _tmpIncmFndg = _cursor.getString(_cursorIndexOfIncmFndg);
            }
            _result.setIncmFndg(_tmpIncmFndg);
            final String _tmpHasRecrd;
            if (_cursor.isNull(_cursorIndexOfHasRecrd)) {
              _tmpHasRecrd = null;
            } else {
              _tmpHasRecrd = _cursor.getString(_cursorIndexOfHasRecrd);
            }
            _result.setHasRecrd(_tmpHasRecrd);
            final String _tmpRecrdRem;
            if (_cursor.isNull(_cursorIndexOfRecrdRem)) {
              _tmpRecrdRem = null;
            } else {
              _tmpRecrdRem = _cursor.getString(_cursorIndexOfRecrdRem);
            }
            _result.setRecrdRem(_tmpRecrdRem);
            final String _tmpPrsnBrgy;
            if (_cursor.isNull(_cursorIndexOfPrsnBrgy)) {
              _tmpPrsnBrgy = null;
            } else {
              _tmpPrsnBrgy = _cursor.getString(_cursorIndexOfPrsnBrgy);
            }
            _result.setPrsnBrgy(_tmpPrsnBrgy);
            final String _tmpPrsnPstn;
            if (_cursor.isNull(_cursorIndexOfPrsnPstn)) {
              _tmpPrsnPstn = null;
            } else {
              _tmpPrsnPstn = _cursor.getString(_cursorIndexOfPrsnPstn);
            }
            _result.setPrsnPstn(_tmpPrsnPstn);
            final String _tmpPrsnNmbr;
            if (_cursor.isNull(_cursorIndexOfPrsnNmbr)) {
              _tmpPrsnNmbr = null;
            } else {
              _tmpPrsnNmbr = _cursor.getString(_cursorIndexOfPrsnNmbr);
            }
            _result.setPrsnNmbr(_tmpPrsnNmbr);
            final String _tmpNeighBr1;
            if (_cursor.isNull(_cursorIndexOfNeighBr1)) {
              _tmpNeighBr1 = null;
            } else {
              _tmpNeighBr1 = _cursor.getString(_cursorIndexOfNeighBr1);
            }
            _result.setNeighBr1(_tmpNeighBr1);
            final String _tmpNeighBr2;
            if (_cursor.isNull(_cursorIndexOfNeighBr2)) {
              _tmpNeighBr2 = null;
            } else {
              _tmpNeighBr2 = _cursor.getString(_cursorIndexOfNeighBr2);
            }
            _result.setNeighBr2(_tmpNeighBr2);
            final String _tmpNeighBr3;
            if (_cursor.isNull(_cursorIndexOfNeighBr3)) {
              _tmpNeighBr3 = null;
            } else {
              _tmpNeighBr3 = _cursor.getString(_cursorIndexOfNeighBr3);
            }
            _result.setNeighBr3(_tmpNeighBr3);
            final String _tmpRcmdRcd1;
            if (_cursor.isNull(_cursorIndexOfRcmdRcd1)) {
              _tmpRcmdRcd1 = null;
            } else {
              _tmpRcmdRcd1 = _cursor.getString(_cursorIndexOfRcmdRcd1);
            }
            _result.setRcmdRcd1(_tmpRcmdRcd1);
            final String _tmpRcmdtnx1;
            if (_cursor.isNull(_cursorIndexOfRcmdtnx1)) {
              _tmpRcmdtnx1 = null;
            } else {
              _tmpRcmdtnx1 = _cursor.getString(_cursorIndexOfRcmdtnx1);
            }
            _result.setRcmdtnx1(_tmpRcmdtnx1);
            final String _tmpRcmdtnc1;
            if (_cursor.isNull(_cursorIndexOfRcmdtnc1)) {
              _tmpRcmdtnc1 = null;
            } else {
              _tmpRcmdtnc1 = _cursor.getString(_cursorIndexOfRcmdtnc1);
            }
            _result.setRcmdtnc1(_tmpRcmdtnc1);
            final String _tmpRcmdtns1;
            if (_cursor.isNull(_cursorIndexOfRcmdtns1)) {
              _tmpRcmdtns1 = null;
            } else {
              _tmpRcmdtns1 = _cursor.getString(_cursorIndexOfRcmdtns1);
            }
            _result.setRcmdtns1(_tmpRcmdtns1);
            final String _tmpRcmdRcd2;
            if (_cursor.isNull(_cursorIndexOfRcmdRcd2)) {
              _tmpRcmdRcd2 = null;
            } else {
              _tmpRcmdRcd2 = _cursor.getString(_cursorIndexOfRcmdRcd2);
            }
            _result.setRcmdRcd2(_tmpRcmdRcd2);
            final String _tmpRcmdtnx2;
            if (_cursor.isNull(_cursorIndexOfRcmdtnx2)) {
              _tmpRcmdtnx2 = null;
            } else {
              _tmpRcmdtnx2 = _cursor.getString(_cursorIndexOfRcmdtnx2);
            }
            _result.setRcmdtnx2(_tmpRcmdtnx2);
            final String _tmpRcmdtnc2;
            if (_cursor.isNull(_cursorIndexOfRcmdtnc2)) {
              _tmpRcmdtnc2 = null;
            } else {
              _tmpRcmdtnc2 = _cursor.getString(_cursorIndexOfRcmdtnc2);
            }
            _result.setRcmdtnc2(_tmpRcmdtnc2);
            final String _tmpRcmdtns2;
            if (_cursor.isNull(_cursorIndexOfRcmdtns2)) {
              _tmpRcmdtns2 = null;
            } else {
              _tmpRcmdtns2 = _cursor.getString(_cursorIndexOfRcmdtns2);
            }
            _result.setRcmdtns2(_tmpRcmdtns2);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpUploaded;
            if (_cursor.isNull(_cursorIndexOfUploaded)) {
              _tmpUploaded = null;
            } else {
              _tmpUploaded = _cursor.getString(_cursorIndexOfUploaded);
            }
            _result.setUploaded(_tmpUploaded);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
            final String _tmpTransfer;
            if (_cursor.isNull(_cursorIndexOfTransfer)) {
              _tmpTransfer = null;
            } else {
              _tmpTransfer = _cursor.getString(_cursorIndexOfTransfer);
            }
            _result.setTransfer(_tmpTransfer);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _result.setApproved(_tmpApproved);
            final String _tmpDapprovd;
            if (_cursor.isNull(_cursorIndexOfDapprovd)) {
              _tmpDapprovd = null;
            } else {
              _tmpDapprovd = _cursor.getString(_cursorIndexOfDapprovd);
            }
            _result.setDapprovd(_tmpDapprovd);
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
  public LiveData<ECreditOnlineApplicationCI> RetrieveApplicationData(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Online_Application_CI WHERE sTransNox=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_CI"}, false, new Callable<ECreditOnlineApplicationCI>() {
      @Override
      public ECreditOnlineApplicationCI call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
          final int _cursorIndexOfManagerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sManagerx");
          final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
          final int _cursorIndexOfAddrFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddrFndg");
          final int _cursorIndexOfAssetsxx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAssetsxx");
          final int _cursorIndexOfAsstFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sAsstFndg");
          final int _cursorIndexOfIncomexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncomexx");
          final int _cursorIndexOfIncmFndg = CursorUtil.getColumnIndexOrThrow(_cursor, "sIncmFndg");
          final int _cursorIndexOfHasRecrd = CursorUtil.getColumnIndexOrThrow(_cursor, "cHasRecrd");
          final int _cursorIndexOfRecrdRem = CursorUtil.getColumnIndexOrThrow(_cursor, "sRecrdRem");
          final int _cursorIndexOfPrsnBrgy = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnBrgy");
          final int _cursorIndexOfPrsnPstn = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnPstn");
          final int _cursorIndexOfPrsnNmbr = CursorUtil.getColumnIndexOrThrow(_cursor, "sPrsnNmbr");
          final int _cursorIndexOfNeighBr1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr1");
          final int _cursorIndexOfNeighBr2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr2");
          final int _cursorIndexOfNeighBr3 = CursorUtil.getColumnIndexOrThrow(_cursor, "sNeighBr3");
          final int _cursorIndexOfRcmdRcd1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd1");
          final int _cursorIndexOfRcmdtnx1 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx1");
          final int _cursorIndexOfRcmdtnc1 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx1");
          final int _cursorIndexOfRcmdtns1 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx1");
          final int _cursorIndexOfRcmdRcd2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdRcd2");
          final int _cursorIndexOfRcmdtnx2 = CursorUtil.getColumnIndexOrThrow(_cursor, "dRcmdtnx2");
          final int _cursorIndexOfRcmdtnc2 = CursorUtil.getColumnIndexOrThrow(_cursor, "cRcmdtnx2");
          final int _cursorIndexOfRcmdtns2 = CursorUtil.getColumnIndexOrThrow(_cursor, "sRcmdtnx2");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfUploaded = CursorUtil.getColumnIndexOrThrow(_cursor, "cUploaded");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfTransfer = CursorUtil.getColumnIndexOrThrow(_cursor, "cTransfer");
          final int _cursorIndexOfApproved = CursorUtil.getColumnIndexOrThrow(_cursor, "sApproved");
          final int _cursorIndexOfDapprovd = CursorUtil.getColumnIndexOrThrow(_cursor, "dApproved");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final ECreditOnlineApplicationCI _result;
          if(_cursor.moveToFirst()) {
            _result = new ECreditOnlineApplicationCI();
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
            final String _tmpManagerx;
            if (_cursor.isNull(_cursorIndexOfManagerx)) {
              _tmpManagerx = null;
            } else {
              _tmpManagerx = _cursor.getString(_cursorIndexOfManagerx);
            }
            _result.setManagerx(_tmpManagerx);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _result.setAddressx(_tmpAddressx);
            final String _tmpAddrFndg;
            if (_cursor.isNull(_cursorIndexOfAddrFndg)) {
              _tmpAddrFndg = null;
            } else {
              _tmpAddrFndg = _cursor.getString(_cursorIndexOfAddrFndg);
            }
            _result.setAddrFndg(_tmpAddrFndg);
            final String _tmpAssetsxx;
            if (_cursor.isNull(_cursorIndexOfAssetsxx)) {
              _tmpAssetsxx = null;
            } else {
              _tmpAssetsxx = _cursor.getString(_cursorIndexOfAssetsxx);
            }
            _result.setAssetsxx(_tmpAssetsxx);
            final String _tmpAsstFndg;
            if (_cursor.isNull(_cursorIndexOfAsstFndg)) {
              _tmpAsstFndg = null;
            } else {
              _tmpAsstFndg = _cursor.getString(_cursorIndexOfAsstFndg);
            }
            _result.setAsstFndg(_tmpAsstFndg);
            final String _tmpIncomexx;
            if (_cursor.isNull(_cursorIndexOfIncomexx)) {
              _tmpIncomexx = null;
            } else {
              _tmpIncomexx = _cursor.getString(_cursorIndexOfIncomexx);
            }
            _result.setIncomexx(_tmpIncomexx);
            final String _tmpIncmFndg;
            if (_cursor.isNull(_cursorIndexOfIncmFndg)) {
              _tmpIncmFndg = null;
            } else {
              _tmpIncmFndg = _cursor.getString(_cursorIndexOfIncmFndg);
            }
            _result.setIncmFndg(_tmpIncmFndg);
            final String _tmpHasRecrd;
            if (_cursor.isNull(_cursorIndexOfHasRecrd)) {
              _tmpHasRecrd = null;
            } else {
              _tmpHasRecrd = _cursor.getString(_cursorIndexOfHasRecrd);
            }
            _result.setHasRecrd(_tmpHasRecrd);
            final String _tmpRecrdRem;
            if (_cursor.isNull(_cursorIndexOfRecrdRem)) {
              _tmpRecrdRem = null;
            } else {
              _tmpRecrdRem = _cursor.getString(_cursorIndexOfRecrdRem);
            }
            _result.setRecrdRem(_tmpRecrdRem);
            final String _tmpPrsnBrgy;
            if (_cursor.isNull(_cursorIndexOfPrsnBrgy)) {
              _tmpPrsnBrgy = null;
            } else {
              _tmpPrsnBrgy = _cursor.getString(_cursorIndexOfPrsnBrgy);
            }
            _result.setPrsnBrgy(_tmpPrsnBrgy);
            final String _tmpPrsnPstn;
            if (_cursor.isNull(_cursorIndexOfPrsnPstn)) {
              _tmpPrsnPstn = null;
            } else {
              _tmpPrsnPstn = _cursor.getString(_cursorIndexOfPrsnPstn);
            }
            _result.setPrsnPstn(_tmpPrsnPstn);
            final String _tmpPrsnNmbr;
            if (_cursor.isNull(_cursorIndexOfPrsnNmbr)) {
              _tmpPrsnNmbr = null;
            } else {
              _tmpPrsnNmbr = _cursor.getString(_cursorIndexOfPrsnNmbr);
            }
            _result.setPrsnNmbr(_tmpPrsnNmbr);
            final String _tmpNeighBr1;
            if (_cursor.isNull(_cursorIndexOfNeighBr1)) {
              _tmpNeighBr1 = null;
            } else {
              _tmpNeighBr1 = _cursor.getString(_cursorIndexOfNeighBr1);
            }
            _result.setNeighBr1(_tmpNeighBr1);
            final String _tmpNeighBr2;
            if (_cursor.isNull(_cursorIndexOfNeighBr2)) {
              _tmpNeighBr2 = null;
            } else {
              _tmpNeighBr2 = _cursor.getString(_cursorIndexOfNeighBr2);
            }
            _result.setNeighBr2(_tmpNeighBr2);
            final String _tmpNeighBr3;
            if (_cursor.isNull(_cursorIndexOfNeighBr3)) {
              _tmpNeighBr3 = null;
            } else {
              _tmpNeighBr3 = _cursor.getString(_cursorIndexOfNeighBr3);
            }
            _result.setNeighBr3(_tmpNeighBr3);
            final String _tmpRcmdRcd1;
            if (_cursor.isNull(_cursorIndexOfRcmdRcd1)) {
              _tmpRcmdRcd1 = null;
            } else {
              _tmpRcmdRcd1 = _cursor.getString(_cursorIndexOfRcmdRcd1);
            }
            _result.setRcmdRcd1(_tmpRcmdRcd1);
            final String _tmpRcmdtnx1;
            if (_cursor.isNull(_cursorIndexOfRcmdtnx1)) {
              _tmpRcmdtnx1 = null;
            } else {
              _tmpRcmdtnx1 = _cursor.getString(_cursorIndexOfRcmdtnx1);
            }
            _result.setRcmdtnx1(_tmpRcmdtnx1);
            final String _tmpRcmdtnc1;
            if (_cursor.isNull(_cursorIndexOfRcmdtnc1)) {
              _tmpRcmdtnc1 = null;
            } else {
              _tmpRcmdtnc1 = _cursor.getString(_cursorIndexOfRcmdtnc1);
            }
            _result.setRcmdtnc1(_tmpRcmdtnc1);
            final String _tmpRcmdtns1;
            if (_cursor.isNull(_cursorIndexOfRcmdtns1)) {
              _tmpRcmdtns1 = null;
            } else {
              _tmpRcmdtns1 = _cursor.getString(_cursorIndexOfRcmdtns1);
            }
            _result.setRcmdtns1(_tmpRcmdtns1);
            final String _tmpRcmdRcd2;
            if (_cursor.isNull(_cursorIndexOfRcmdRcd2)) {
              _tmpRcmdRcd2 = null;
            } else {
              _tmpRcmdRcd2 = _cursor.getString(_cursorIndexOfRcmdRcd2);
            }
            _result.setRcmdRcd2(_tmpRcmdRcd2);
            final String _tmpRcmdtnx2;
            if (_cursor.isNull(_cursorIndexOfRcmdtnx2)) {
              _tmpRcmdtnx2 = null;
            } else {
              _tmpRcmdtnx2 = _cursor.getString(_cursorIndexOfRcmdtnx2);
            }
            _result.setRcmdtnx2(_tmpRcmdtnx2);
            final String _tmpRcmdtnc2;
            if (_cursor.isNull(_cursorIndexOfRcmdtnc2)) {
              _tmpRcmdtnc2 = null;
            } else {
              _tmpRcmdtnc2 = _cursor.getString(_cursorIndexOfRcmdtnc2);
            }
            _result.setRcmdtnc2(_tmpRcmdtnc2);
            final String _tmpRcmdtns2;
            if (_cursor.isNull(_cursorIndexOfRcmdtns2)) {
              _tmpRcmdtns2 = null;
            } else {
              _tmpRcmdtns2 = _cursor.getString(_cursorIndexOfRcmdtns2);
            }
            _result.setRcmdtns2(_tmpRcmdtns2);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpUploaded;
            if (_cursor.isNull(_cursorIndexOfUploaded)) {
              _tmpUploaded = null;
            } else {
              _tmpUploaded = _cursor.getString(_cursorIndexOfUploaded);
            }
            _result.setUploaded(_tmpUploaded);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
            final String _tmpTransfer;
            if (_cursor.isNull(_cursorIndexOfTransfer)) {
              _tmpTransfer = null;
            } else {
              _tmpTransfer = _cursor.getString(_cursorIndexOfTransfer);
            }
            _result.setTransfer(_tmpTransfer);
            final String _tmpApproved;
            if (_cursor.isNull(_cursorIndexOfApproved)) {
              _tmpApproved = null;
            } else {
              _tmpApproved = _cursor.getString(_cursorIndexOfApproved);
            }
            _result.setApproved(_tmpApproved);
            final String _tmpDapprovd;
            if (_cursor.isNull(_cursorIndexOfDapprovd)) {
              _tmpDapprovd = null;
            } else {
              _tmpDapprovd = _cursor.getString(_cursorIndexOfDapprovd);
            }
            _result.setDapprovd(_tmpDapprovd);
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
  public String getAddressForEvaluation(final String TransNox) {
    final String _sql = "SELECT sAddrFndg FROM Credit_Online_Application_CI WHERE sTransNox =?";
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
  public String getAssetsForEvaluation(final String TransNox) {
    final String _sql = "SELECT sAsstFndg FROM Credit_Online_Application_CI WHERE sTransNox =?";
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
  public String GetEmployeeID() {
    final String _sql = "SELECT sEmployID FROM User_Info_Master";
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
  public String getIncomeForEvaluation(final String TransNox) {
    final String _sql = "SELECT sIncmFndg FROM Credit_Online_Application_CI WHERE sTransNox =?";
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
  public List<EImageInfo> GetCIImagesForPosting(final String args, final String args1) {
    final String _sql = "SELECT * FROM Image_Information WHERE sSourceNo =? AND sDtlSrcNo =? ORDER BY dCaptured DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
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
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfSourceNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceNo");
      final int _cursorIndexOfDtlSrcNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDtlSrcNo");
      final int _cursorIndexOfFileCode = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileCode");
      final int _cursorIndexOfImageNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sImageNme");
      final int _cursorIndexOfMD5Hashx = CursorUtil.getColumnIndexOrThrow(_cursor, "sMD5Hashx");
      final int _cursorIndexOfFileLoct = CursorUtil.getColumnIndexOrThrow(_cursor, "sFileLoct");
      final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "nLatitude");
      final int _cursorIndexOfLongitud = CursorUtil.getColumnIndexOrThrow(_cursor, "nLongitud");
      final int _cursorIndexOfCaptured = CursorUtil.getColumnIndexOrThrow(_cursor, "dCaptured");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfSendDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dSendDate");
      final List<EImageInfo> _result = new ArrayList<EImageInfo>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final EImageInfo _item;
        _item = new EImageInfo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _item.setSourceCD(_tmpSourceCD);
        final String _tmpSourceNo;
        if (_cursor.isNull(_cursorIndexOfSourceNo)) {
          _tmpSourceNo = null;
        } else {
          _tmpSourceNo = _cursor.getString(_cursorIndexOfSourceNo);
        }
        _item.setSourceNo(_tmpSourceNo);
        final String _tmpDtlSrcNo;
        if (_cursor.isNull(_cursorIndexOfDtlSrcNo)) {
          _tmpDtlSrcNo = null;
        } else {
          _tmpDtlSrcNo = _cursor.getString(_cursorIndexOfDtlSrcNo);
        }
        _item.setDtlSrcNo(_tmpDtlSrcNo);
        final String _tmpFileCode;
        if (_cursor.isNull(_cursorIndexOfFileCode)) {
          _tmpFileCode = null;
        } else {
          _tmpFileCode = _cursor.getString(_cursorIndexOfFileCode);
        }
        _item.setFileCode(_tmpFileCode);
        final String _tmpImageNme;
        if (_cursor.isNull(_cursorIndexOfImageNme)) {
          _tmpImageNme = null;
        } else {
          _tmpImageNme = _cursor.getString(_cursorIndexOfImageNme);
        }
        _item.setImageNme(_tmpImageNme);
        final String _tmpMD5Hashx;
        if (_cursor.isNull(_cursorIndexOfMD5Hashx)) {
          _tmpMD5Hashx = null;
        } else {
          _tmpMD5Hashx = _cursor.getString(_cursorIndexOfMD5Hashx);
        }
        _item.setMD5Hashx(_tmpMD5Hashx);
        final String _tmpFileLoct;
        if (_cursor.isNull(_cursorIndexOfFileLoct)) {
          _tmpFileLoct = null;
        } else {
          _tmpFileLoct = _cursor.getString(_cursorIndexOfFileLoct);
        }
        _item.setFileLoct(_tmpFileLoct);
        final String _tmpLatitude;
        if (_cursor.isNull(_cursorIndexOfLatitude)) {
          _tmpLatitude = null;
        } else {
          _tmpLatitude = _cursor.getString(_cursorIndexOfLatitude);
        }
        _item.setLatitude(_tmpLatitude);
        final String _tmpLongitud;
        if (_cursor.isNull(_cursorIndexOfLongitud)) {
          _tmpLongitud = null;
        } else {
          _tmpLongitud = _cursor.getString(_cursorIndexOfLongitud);
        }
        _item.setLongitud(_tmpLongitud);
        final String _tmpCaptured;
        if (_cursor.isNull(_cursorIndexOfCaptured)) {
          _tmpCaptured = null;
        } else {
          _tmpCaptured = _cursor.getString(_cursorIndexOfCaptured);
        }
        _item.setCaptured(_tmpCaptured);
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
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<DCreditOnlineApplicationCI.oDataEvaluationInfo>> getForEvaluationListData() {
    final String _sql = "SELECT a.sTransNox, a.sCredInvx, a.sAddressx, a.sAddrFndg, a.sAssetsxx, a.sAsstFndg, a.sIncomexx, a.sIncmFndg, a.cHasRecrd, a.sRecrdRem, b.sCompnyNm AS sClientNm, b.dTransact, c.sBranchNm, b.nDownPaym, a.sRcmdtnx1, CASE WHEN a.cRcmdtnx1 IS NULL THEN 'N/A' WHEN a.cRcmdTnx1 > 0 THEN 'Approved' ELSE 'Disapproved' END AS cRcmdtnx1 FROM CREDIT_ONLINE_APPLICATION_CI a LEFT JOIN Credit_Online_Application_List b ON a.sTransNox = b.sTransNox LEFT JOIN Branch_Info c ON b.sBranchCd = c.sBranchCd WHERE a.cRcmdtnx1 isNull OR a.cRcmdtnx1 == '' OR a.cRcmdtnx1 == 'null'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"CREDIT_ONLINE_APPLICATION_CI","Credit_Online_Application_List","Branch_Info"}, false, new Callable<List<DCreditOnlineApplicationCI.oDataEvaluationInfo>>() {
      @Override
      public List<DCreditOnlineApplicationCI.oDataEvaluationInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfSCredInvx = 1;
          final int _cursorIndexOfSAddressx = 2;
          final int _cursorIndexOfSAddrFndg = 3;
          final int _cursorIndexOfSAssetsxx = 4;
          final int _cursorIndexOfSAsstFndg = 5;
          final int _cursorIndexOfSIncomexx = 6;
          final int _cursorIndexOfSIncmFndg = 7;
          final int _cursorIndexOfCHasRecrd = 8;
          final int _cursorIndexOfSRecrdRem = 9;
          final int _cursorIndexOfSClientNm = 10;
          final int _cursorIndexOfDTransact = 11;
          final int _cursorIndexOfSBranchNm = 12;
          final int _cursorIndexOfNDownPaym = 13;
          final int _cursorIndexOfSRcmdtnx1 = 14;
          final int _cursorIndexOfCRcmdtnx1 = 15;
          final List<DCreditOnlineApplicationCI.oDataEvaluationInfo> _result = new ArrayList<DCreditOnlineApplicationCI.oDataEvaluationInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DCreditOnlineApplicationCI.oDataEvaluationInfo _item;
            _item = new DCreditOnlineApplicationCI.oDataEvaluationInfo();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSCredInvx)) {
              _item.sCredInvx = null;
            } else {
              _item.sCredInvx = _cursor.getString(_cursorIndexOfSCredInvx);
            }
            if (_cursor.isNull(_cursorIndexOfSAddressx)) {
              _item.sAddressx = null;
            } else {
              _item.sAddressx = _cursor.getString(_cursorIndexOfSAddressx);
            }
            if (_cursor.isNull(_cursorIndexOfSAddrFndg)) {
              _item.sAddrFndg = null;
            } else {
              _item.sAddrFndg = _cursor.getString(_cursorIndexOfSAddrFndg);
            }
            if (_cursor.isNull(_cursorIndexOfSAssetsxx)) {
              _item.sAssetsxx = null;
            } else {
              _item.sAssetsxx = _cursor.getString(_cursorIndexOfSAssetsxx);
            }
            if (_cursor.isNull(_cursorIndexOfSAsstFndg)) {
              _item.sAsstFndg = null;
            } else {
              _item.sAsstFndg = _cursor.getString(_cursorIndexOfSAsstFndg);
            }
            if (_cursor.isNull(_cursorIndexOfSIncomexx)) {
              _item.sIncomexx = null;
            } else {
              _item.sIncomexx = _cursor.getString(_cursorIndexOfSIncomexx);
            }
            if (_cursor.isNull(_cursorIndexOfSIncmFndg)) {
              _item.sIncmFndg = null;
            } else {
              _item.sIncmFndg = _cursor.getString(_cursorIndexOfSIncmFndg);
            }
            if (_cursor.isNull(_cursorIndexOfCHasRecrd)) {
              _item.cHasRecrd = null;
            } else {
              _item.cHasRecrd = _cursor.getString(_cursorIndexOfCHasRecrd);
            }
            if (_cursor.isNull(_cursorIndexOfSRecrdRem)) {
              _item.sRecrdRem = null;
            } else {
              _item.sRecrdRem = _cursor.getString(_cursorIndexOfSRecrdRem);
            }
            if (_cursor.isNull(_cursorIndexOfSClientNm)) {
              _item.sClientNm = null;
            } else {
              _item.sClientNm = _cursor.getString(_cursorIndexOfSClientNm);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _item.dTransact = null;
            } else {
              _item.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfNDownPaym)) {
              _item.nDownPaym = null;
            } else {
              _item.nDownPaym = _cursor.getString(_cursorIndexOfNDownPaym);
            }
            if (_cursor.isNull(_cursorIndexOfSRcmdtnx1)) {
              _item.sRcmdtnx1 = null;
            } else {
              _item.sRcmdtnx1 = _cursor.getString(_cursorIndexOfSRcmdtnx1);
            }
            if (_cursor.isNull(_cursorIndexOfCRcmdtnx1)) {
              _item.cRcmdtnx1 = null;
            } else {
              _item.cRcmdtnx1 = _cursor.getString(_cursorIndexOfCRcmdtnx1);
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

  @Override
  public LiveData<List<DCreditOnlineApplicationCI.oDataEvaluationInfo>> getForEvaluationListDataPreview(
      ) {
    final String _sql = "SELECT a.sTransNox, a.sCredInvx, a.sAddressx, a.sAddrFndg, a.sAssetsxx, a.sAsstFndg, a.sIncomexx, a.sIncmFndg, a.cHasRecrd, a.sRecrdRem, b.sCompnyNm AS sClientNm, b.dTransact, c.sBranchNm, b.nDownPaym, a.sRcmdtnx1, CASE WHEN a.cRcmdtnx1 IS NULL THEN 'N/A' WHEN a.cRcmdTnx1 > 0 THEN 'Approved' ELSE 'Disapproved' END AS cRcmdtnx1 FROM CREDIT_ONLINE_APPLICATION_CI a LEFT JOIN Credit_Online_Application_List b ON a.sTransNox = b.sTransNox LEFT JOIN Branch_Info c ON b.sBranchCd = c.sBranchCd WHERE a.cRcmdtnx1 notNull";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"CREDIT_ONLINE_APPLICATION_CI","Credit_Online_Application_List","Branch_Info"}, false, new Callable<List<DCreditOnlineApplicationCI.oDataEvaluationInfo>>() {
      @Override
      public List<DCreditOnlineApplicationCI.oDataEvaluationInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfSCredInvx = 1;
          final int _cursorIndexOfSAddressx = 2;
          final int _cursorIndexOfSAddrFndg = 3;
          final int _cursorIndexOfSAssetsxx = 4;
          final int _cursorIndexOfSAsstFndg = 5;
          final int _cursorIndexOfSIncomexx = 6;
          final int _cursorIndexOfSIncmFndg = 7;
          final int _cursorIndexOfCHasRecrd = 8;
          final int _cursorIndexOfSRecrdRem = 9;
          final int _cursorIndexOfSClientNm = 10;
          final int _cursorIndexOfDTransact = 11;
          final int _cursorIndexOfSBranchNm = 12;
          final int _cursorIndexOfNDownPaym = 13;
          final int _cursorIndexOfSRcmdtnx1 = 14;
          final int _cursorIndexOfCRcmdtnx1 = 15;
          final List<DCreditOnlineApplicationCI.oDataEvaluationInfo> _result = new ArrayList<DCreditOnlineApplicationCI.oDataEvaluationInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DCreditOnlineApplicationCI.oDataEvaluationInfo _item;
            _item = new DCreditOnlineApplicationCI.oDataEvaluationInfo();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSCredInvx)) {
              _item.sCredInvx = null;
            } else {
              _item.sCredInvx = _cursor.getString(_cursorIndexOfSCredInvx);
            }
            if (_cursor.isNull(_cursorIndexOfSAddressx)) {
              _item.sAddressx = null;
            } else {
              _item.sAddressx = _cursor.getString(_cursorIndexOfSAddressx);
            }
            if (_cursor.isNull(_cursorIndexOfSAddrFndg)) {
              _item.sAddrFndg = null;
            } else {
              _item.sAddrFndg = _cursor.getString(_cursorIndexOfSAddrFndg);
            }
            if (_cursor.isNull(_cursorIndexOfSAssetsxx)) {
              _item.sAssetsxx = null;
            } else {
              _item.sAssetsxx = _cursor.getString(_cursorIndexOfSAssetsxx);
            }
            if (_cursor.isNull(_cursorIndexOfSAsstFndg)) {
              _item.sAsstFndg = null;
            } else {
              _item.sAsstFndg = _cursor.getString(_cursorIndexOfSAsstFndg);
            }
            if (_cursor.isNull(_cursorIndexOfSIncomexx)) {
              _item.sIncomexx = null;
            } else {
              _item.sIncomexx = _cursor.getString(_cursorIndexOfSIncomexx);
            }
            if (_cursor.isNull(_cursorIndexOfSIncmFndg)) {
              _item.sIncmFndg = null;
            } else {
              _item.sIncmFndg = _cursor.getString(_cursorIndexOfSIncmFndg);
            }
            if (_cursor.isNull(_cursorIndexOfCHasRecrd)) {
              _item.cHasRecrd = null;
            } else {
              _item.cHasRecrd = _cursor.getString(_cursorIndexOfCHasRecrd);
            }
            if (_cursor.isNull(_cursorIndexOfSRecrdRem)) {
              _item.sRecrdRem = null;
            } else {
              _item.sRecrdRem = _cursor.getString(_cursorIndexOfSRecrdRem);
            }
            if (_cursor.isNull(_cursorIndexOfSClientNm)) {
              _item.sClientNm = null;
            } else {
              _item.sClientNm = _cursor.getString(_cursorIndexOfSClientNm);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _item.dTransact = null;
            } else {
              _item.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfNDownPaym)) {
              _item.nDownPaym = null;
            } else {
              _item.nDownPaym = _cursor.getString(_cursorIndexOfNDownPaym);
            }
            if (_cursor.isNull(_cursorIndexOfSRcmdtnx1)) {
              _item.sRcmdtnx1 = null;
            } else {
              _item.sRcmdtnx1 = _cursor.getString(_cursorIndexOfSRcmdtnx1);
            }
            if (_cursor.isNull(_cursorIndexOfCRcmdtnx1)) {
              _item.cRcmdtnx1 = null;
            } else {
              _item.cRcmdtnx1 = _cursor.getString(_cursorIndexOfCRcmdtnx1);
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

  @Override
  public LiveData<DCreditOnlineApplicationCI.oDataEvaluationInfo> getForEvaluateInfo(
      final String TransNox) {
    final String _sql = "SELECT a.sTransNox, a.sCredInvx, a.sAddressx, a.sAddrFndg, a.sAssetsxx, a.sAsstFndg, a.sIncomexx, a.sIncmFndg, a.cHasRecrd, a.sRecrdRem, b.sCompnyNm AS sClientNm, b.dTransact, c.sBranchNm, b.nDownPaym, a.sRcmdtnx1, CASE WHEN a.cRcmdtnx1 IS NULL THEN 'N/A' WHEN a.cRcmdTnx1 > 0 THEN 'Approved' ELSE 'Disapproved' END AS cRcmdtnx1 FROM CREDIT_ONLINE_APPLICATION_CI a LEFT JOIN Credit_Online_Application_List b ON a.sTransNox = b.sTransNox LEFT JOIN Branch_Info c ON b.sBranchCd = c.sBranchCd WHERE a.sTransNox=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (TransNox == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, TransNox);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"CREDIT_ONLINE_APPLICATION_CI","Credit_Online_Application_List","Branch_Info"}, false, new Callable<DCreditOnlineApplicationCI.oDataEvaluationInfo>() {
      @Override
      public DCreditOnlineApplicationCI.oDataEvaluationInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSTransNox = 0;
          final int _cursorIndexOfSCredInvx = 1;
          final int _cursorIndexOfSAddressx = 2;
          final int _cursorIndexOfSAddrFndg = 3;
          final int _cursorIndexOfSAssetsxx = 4;
          final int _cursorIndexOfSAsstFndg = 5;
          final int _cursorIndexOfSIncomexx = 6;
          final int _cursorIndexOfSIncmFndg = 7;
          final int _cursorIndexOfCHasRecrd = 8;
          final int _cursorIndexOfSRecrdRem = 9;
          final int _cursorIndexOfSClientNm = 10;
          final int _cursorIndexOfDTransact = 11;
          final int _cursorIndexOfSBranchNm = 12;
          final int _cursorIndexOfNDownPaym = 13;
          final int _cursorIndexOfSRcmdtnx1 = 14;
          final int _cursorIndexOfCRcmdtnx1 = 15;
          final DCreditOnlineApplicationCI.oDataEvaluationInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new DCreditOnlineApplicationCI.oDataEvaluationInfo();
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _result.sTransNox = null;
            } else {
              _result.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSCredInvx)) {
              _result.sCredInvx = null;
            } else {
              _result.sCredInvx = _cursor.getString(_cursorIndexOfSCredInvx);
            }
            if (_cursor.isNull(_cursorIndexOfSAddressx)) {
              _result.sAddressx = null;
            } else {
              _result.sAddressx = _cursor.getString(_cursorIndexOfSAddressx);
            }
            if (_cursor.isNull(_cursorIndexOfSAddrFndg)) {
              _result.sAddrFndg = null;
            } else {
              _result.sAddrFndg = _cursor.getString(_cursorIndexOfSAddrFndg);
            }
            if (_cursor.isNull(_cursorIndexOfSAssetsxx)) {
              _result.sAssetsxx = null;
            } else {
              _result.sAssetsxx = _cursor.getString(_cursorIndexOfSAssetsxx);
            }
            if (_cursor.isNull(_cursorIndexOfSAsstFndg)) {
              _result.sAsstFndg = null;
            } else {
              _result.sAsstFndg = _cursor.getString(_cursorIndexOfSAsstFndg);
            }
            if (_cursor.isNull(_cursorIndexOfSIncomexx)) {
              _result.sIncomexx = null;
            } else {
              _result.sIncomexx = _cursor.getString(_cursorIndexOfSIncomexx);
            }
            if (_cursor.isNull(_cursorIndexOfSIncmFndg)) {
              _result.sIncmFndg = null;
            } else {
              _result.sIncmFndg = _cursor.getString(_cursorIndexOfSIncmFndg);
            }
            if (_cursor.isNull(_cursorIndexOfCHasRecrd)) {
              _result.cHasRecrd = null;
            } else {
              _result.cHasRecrd = _cursor.getString(_cursorIndexOfCHasRecrd);
            }
            if (_cursor.isNull(_cursorIndexOfSRecrdRem)) {
              _result.sRecrdRem = null;
            } else {
              _result.sRecrdRem = _cursor.getString(_cursorIndexOfSRecrdRem);
            }
            if (_cursor.isNull(_cursorIndexOfSClientNm)) {
              _result.sClientNm = null;
            } else {
              _result.sClientNm = _cursor.getString(_cursorIndexOfSClientNm);
            }
            if (_cursor.isNull(_cursorIndexOfDTransact)) {
              _result.dTransact = null;
            } else {
              _result.dTransact = _cursor.getString(_cursorIndexOfDTransact);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _result.sBranchNm = null;
            } else {
              _result.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfNDownPaym)) {
              _result.nDownPaym = null;
            } else {
              _result.nDownPaym = _cursor.getString(_cursorIndexOfNDownPaym);
            }
            if (_cursor.isNull(_cursorIndexOfSRcmdtnx1)) {
              _result.sRcmdtnx1 = null;
            } else {
              _result.sRcmdtnx1 = _cursor.getString(_cursorIndexOfSRcmdtnx1);
            }
            if (_cursor.isNull(_cursorIndexOfCRcmdtnx1)) {
              _result.cRcmdtnx1 = null;
            } else {
              _result.cRcmdtnx1 = _cursor.getString(_cursorIndexOfCRcmdtnx1);
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
  public EBranchLoanApplication CheckIFExist(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Online_Application_List WHERE sTransNox =?";
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
      final int _cursorIndexOfBranchCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCD");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfCredInvx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCredInvx");
      final int _cursorIndexOfCompnyNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sCompnyNm");
      final int _cursorIndexOfSpouseNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpouseNm");
      final int _cursorIndexOfAddressx = CursorUtil.getColumnIndexOrThrow(_cursor, "sAddressx");
      final int _cursorIndexOfMobileNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sMobileNo");
      final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
      final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelNme");
      final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
      final int _cursorIndexOfAcctTerm = CursorUtil.getColumnIndexOrThrow(_cursor, "nAcctTerm");
      final int _cursorIndexOfCreatedX = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final EBranchLoanApplication _result;
      if(_cursor.moveToFirst()) {
        _result = new EBranchLoanApplication();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpBranchCD;
        if (_cursor.isNull(_cursorIndexOfBranchCD)) {
          _tmpBranchCD = null;
        } else {
          _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
        }
        _result.setBranchCD(_tmpBranchCD);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpCredInvx;
        if (_cursor.isNull(_cursorIndexOfCredInvx)) {
          _tmpCredInvx = null;
        } else {
          _tmpCredInvx = _cursor.getString(_cursorIndexOfCredInvx);
        }
        _result.setCredInvx(_tmpCredInvx);
        final String _tmpCompnyNm;
        if (_cursor.isNull(_cursorIndexOfCompnyNm)) {
          _tmpCompnyNm = null;
        } else {
          _tmpCompnyNm = _cursor.getString(_cursorIndexOfCompnyNm);
        }
        _result.setCompnyNm(_tmpCompnyNm);
        final String _tmpSpouseNm;
        if (_cursor.isNull(_cursorIndexOfSpouseNm)) {
          _tmpSpouseNm = null;
        } else {
          _tmpSpouseNm = _cursor.getString(_cursorIndexOfSpouseNm);
        }
        _result.setSpouseNm(_tmpSpouseNm);
        final String _tmpAddressx;
        if (_cursor.isNull(_cursorIndexOfAddressx)) {
          _tmpAddressx = null;
        } else {
          _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
        }
        _result.setAddressx(_tmpAddressx);
        final String _tmpMobileNo;
        if (_cursor.isNull(_cursorIndexOfMobileNo)) {
          _tmpMobileNo = null;
        } else {
          _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
        }
        _result.setMobileNo(_tmpMobileNo);
        final String _tmpQMAppCde;
        if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
          _tmpQMAppCde = null;
        } else {
          _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
        }
        _result.setQMAppCde(_tmpQMAppCde);
        final String _tmpModelNme;
        if (_cursor.isNull(_cursorIndexOfModelNme)) {
          _tmpModelNme = null;
        } else {
          _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
        }
        _result.setModelNme(_tmpModelNme);
        final String _tmpDownPaym;
        if (_cursor.isNull(_cursorIndexOfDownPaym)) {
          _tmpDownPaym = null;
        } else {
          _tmpDownPaym = _cursor.getString(_cursorIndexOfDownPaym);
        }
        _result.setDownPaym(_tmpDownPaym);
        final String _tmpAcctTerm;
        if (_cursor.isNull(_cursorIndexOfAcctTerm)) {
          _tmpAcctTerm = null;
        } else {
          _tmpAcctTerm = _cursor.getString(_cursorIndexOfAcctTerm);
        }
        _result.setAcctTerm(_tmpAcctTerm);
        final String _tmpCreatedX;
        if (_cursor.isNull(_cursorIndexOfCreatedX)) {
          _tmpCreatedX = null;
        } else {
          _tmpCreatedX = _cursor.getString(_cursorIndexOfCreatedX);
        }
        _result.setCreatedX(_tmpCreatedX);
        final String _tmpTimeStmp;
        if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
          _tmpTimeStmp = null;
        } else {
          _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
        }
        _result.setTimeStmp(_tmpTimeStmp);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
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
