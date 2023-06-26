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
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.rmj.g3appdriver.GCircle.room.Entities.EBranchLoanApplication;
import org.rmj.g3appdriver.GCircle.room.Entities.ECreditApplicantInfo;
import org.rmj.g3appdriver.GCircle.room.Entities.ECreditApplication;
import org.rmj.g3appdriver.GCircle.room.Entities.ELoanTerm;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DCreditApplication_Impl implements DCreditApplication {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ECreditApplication> __insertionAdapterOfECreditApplication;

  private final EntityInsertionAdapter<ECreditApplicantInfo> __insertionAdapterOfECreditApplicantInfo;

  private final EntityInsertionAdapter<EBranchLoanApplication> __insertionAdapterOfEBranchLoanApplication;

  private final EntityInsertionAdapter<ELoanTerm> __insertionAdapterOfELoanTerm;

  private final EntityDeletionOrUpdateAdapter<ECreditApplication> __updateAdapterOfECreditApplication;

  private final EntityDeletionOrUpdateAdapter<ECreditApplicantInfo> __updateAdapterOfECreditApplicantInfo;

  private final EntityDeletionOrUpdateAdapter<EBranchLoanApplication> __updateAdapterOfEBranchLoanApplication;

  private final EntityDeletionOrUpdateAdapter<ELoanTerm> __updateAdapterOfELoanTerm;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSentLoanAppl;

  private final SharedSQLiteStatement __preparedStmtOfUpdateApplicationListTransNox;

  private final SharedSQLiteStatement __preparedStmtOfUpdateApplicationDocsTransNox;

  public DCreditApplication_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfECreditApplication = new EntityInsertionAdapter<ECreditApplication>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Credit_Online_Application` (`sTransNox`,`sBranchCd`,`dTransact`,`dTargetDt`,`sClientNm`,`sGOCASNox`,`sGOCASNoF`,`cUnitAppl`,`sSourceCD`,`sDetlInfo`,`sCatInfox`,`sDesInfox`,`sQMatchNo`,`sQMAppCde`,`nCrdtScrx`,`cWithCIxx`,`nDownPaym`,`nDownPayF`,`sRemarksx`,`dReceived`,`sCreatedx`,`dCreatedx`,`cSendStat`,`sVerified`,`dVerified`,`dModified`,`cTranStat`,`cDivision`,`cApplStat`,`dTimeStmp`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECreditApplication value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCd());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getTargetDt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTargetDt());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getClientNm());
        }
        if (value.getGOCASNox() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getGOCASNox());
        }
        if (value.getGOCASNoF() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGOCASNoF());
        }
        if (value.getUnitAppl() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUnitAppl());
        }
        if (value.getSourceCD() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSourceCD());
        }
        if (value.getDetlInfo() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getDetlInfo());
        }
        if (value.getCatInfox() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCatInfox());
        }
        if (value.getDesInfox() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDesInfox());
        }
        if (value.getQMatchNo() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getQMatchNo());
        }
        if (value.getQMAppCde() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getQMAppCde());
        }
        stmt.bindLong(15, value.getCrdtScrx());
        if (value.getWithCIxx() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getWithCIxx());
        }
        stmt.bindDouble(17, value.getDownPaym());
        stmt.bindDouble(18, value.getDownPayF());
        if (value.getRemarksx() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getRemarksx());
        }
        if (value.getReceived() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getReceived());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getCreatedx());
        }
        if (value.getDateCreatedx() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDateCreatedx());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getSendStat());
        }
        if (value.getVerified() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getVerified());
        }
        if (value.getDateVerified() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getDateVerified());
        }
        if (value.getModified() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getModified());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getTranStat());
        }
        if (value.getDivision() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getDivision());
        }
        if (value.getApplStat() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getApplStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfECreditApplicantInfo = new EntityInsertionAdapter<ECreditApplicantInfo>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Credit_Applicant_Info` (`sTransNox`,`sClientNm`,`sDetlInfo`,`sPurchase`,`sApplInfo`,`sResidnce`,`cSameAddx`,`sAppMeans`,`sEmplymnt`,`sBusnInfo`,`sFinancex`,`sPensionx`,`sOtherInc`,`sSpousexx`,`sSpsResdx`,`sSpsMEans`,`sSpsEmplx`,`sSpsBusnx`,`sSpsPensn`,`sSpOthInc`,`sDisbrsmt`,`sDependnt`,`sProperty`,`sOthrInfo`,`sComakerx`,`sCmResidx`,`cIsSpouse`,`cIsComakr`,`sBranchCd`,`cAppliedx`,`dTransact`,`dCreatedx`,`nDownPaym`,`cTranStat`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECreditApplicantInfo value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClientNm());
        }
        if (value.getDetlInfo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDetlInfo());
        }
        if (value.getPurchase() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPurchase());
        }
        if (value.getApplInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getApplInfo());
        }
        if (value.getResidnce() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getResidnce());
        }
        if (value.getSameAddx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSameAddx());
        }
        if (value.getAppMeans() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAppMeans());
        }
        if (value.getEmplymnt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getEmplymnt());
        }
        if (value.getBusnInfo() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBusnInfo());
        }
        if (value.getFinancex() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFinancex());
        }
        if (value.getPensionx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPensionx());
        }
        if (value.getOtherInc() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getOtherInc());
        }
        if (value.getSpousexx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSpousexx());
        }
        if (value.getSpsResdx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSpsResdx());
        }
        if (value.getSpsMeans() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSpsMeans());
        }
        if (value.getSpsEmplx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSpsEmplx());
        }
        if (value.getSpsBusnx() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getSpsBusnx());
        }
        if (value.getSpsPensn() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getSpsPensn());
        }
        if (value.getSpOthInc() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getSpOthInc());
        }
        if (value.getDisbrsmt() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getDisbrsmt());
        }
        if (value.getDependnt() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDependnt());
        }
        if (value.getProperty() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getProperty());
        }
        if (value.getOthrInfo() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getOthrInfo());
        }
        if (value.getComakerx() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getComakerx());
        }
        if (value.getCmResidx() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getCmResidx());
        }
        if (value.getIsSpouse() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getIsSpouse());
        }
        if (value.getIsComakr() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getIsComakr());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getBranchCd());
        }
        if (value.getAppliedx() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getAppliedx());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getTransact());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getCreatedx());
        }
        stmt.bindDouble(33, value.getDownPaym());
        if (value.getTranStat() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getTranStat());
        }
      }
    };
    this.__insertionAdapterOfEBranchLoanApplication = new EntityInsertionAdapter<EBranchLoanApplication>(__db) {
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
    this.__insertionAdapterOfELoanTerm = new EntityInsertionAdapter<ELoanTerm>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Installment_Term` (`nTermCode`,`sTermDesc`,`cRecdStat`,`dTimeStmp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ELoanTerm value) {
        if (value.getTermCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getTermCode());
        }
        if (value.getTermDesc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTermDesc());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
      }
    };
    this.__updateAdapterOfECreditApplication = new EntityDeletionOrUpdateAdapter<ECreditApplication>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Credit_Online_Application` SET `sTransNox` = ?,`sBranchCd` = ?,`dTransact` = ?,`dTargetDt` = ?,`sClientNm` = ?,`sGOCASNox` = ?,`sGOCASNoF` = ?,`cUnitAppl` = ?,`sSourceCD` = ?,`sDetlInfo` = ?,`sCatInfox` = ?,`sDesInfox` = ?,`sQMatchNo` = ?,`sQMAppCde` = ?,`nCrdtScrx` = ?,`cWithCIxx` = ?,`nDownPaym` = ?,`nDownPayF` = ?,`sRemarksx` = ?,`dReceived` = ?,`sCreatedx` = ?,`dCreatedx` = ?,`cSendStat` = ?,`sVerified` = ?,`dVerified` = ?,`dModified` = ?,`cTranStat` = ?,`cDivision` = ?,`cApplStat` = ?,`dTimeStmp` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECreditApplication value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getBranchCd());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTransact());
        }
        if (value.getTargetDt() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTargetDt());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getClientNm());
        }
        if (value.getGOCASNox() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getGOCASNox());
        }
        if (value.getGOCASNoF() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGOCASNoF());
        }
        if (value.getUnitAppl() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUnitAppl());
        }
        if (value.getSourceCD() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getSourceCD());
        }
        if (value.getDetlInfo() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getDetlInfo());
        }
        if (value.getCatInfox() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getCatInfox());
        }
        if (value.getDesInfox() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getDesInfox());
        }
        if (value.getQMatchNo() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getQMatchNo());
        }
        if (value.getQMAppCde() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getQMAppCde());
        }
        stmt.bindLong(15, value.getCrdtScrx());
        if (value.getWithCIxx() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getWithCIxx());
        }
        stmt.bindDouble(17, value.getDownPaym());
        stmt.bindDouble(18, value.getDownPayF());
        if (value.getRemarksx() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getRemarksx());
        }
        if (value.getReceived() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getReceived());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getCreatedx());
        }
        if (value.getDateCreatedx() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDateCreatedx());
        }
        if (value.getSendStat() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getSendStat());
        }
        if (value.getVerified() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getVerified());
        }
        if (value.getDateVerified() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getDateVerified());
        }
        if (value.getModified() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getModified());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getTranStat());
        }
        if (value.getDivision() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getDivision());
        }
        if (value.getApplStat() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getApplStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getTimeStmp());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getTransNox());
        }
      }
    };
    this.__updateAdapterOfECreditApplicantInfo = new EntityDeletionOrUpdateAdapter<ECreditApplicantInfo>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Credit_Applicant_Info` SET `sTransNox` = ?,`sClientNm` = ?,`sDetlInfo` = ?,`sPurchase` = ?,`sApplInfo` = ?,`sResidnce` = ?,`cSameAddx` = ?,`sAppMeans` = ?,`sEmplymnt` = ?,`sBusnInfo` = ?,`sFinancex` = ?,`sPensionx` = ?,`sOtherInc` = ?,`sSpousexx` = ?,`sSpsResdx` = ?,`sSpsMEans` = ?,`sSpsEmplx` = ?,`sSpsBusnx` = ?,`sSpsPensn` = ?,`sSpOthInc` = ?,`sDisbrsmt` = ?,`sDependnt` = ?,`sProperty` = ?,`sOthrInfo` = ?,`sComakerx` = ?,`sCmResidx` = ?,`cIsSpouse` = ?,`cIsComakr` = ?,`sBranchCd` = ?,`cAppliedx` = ?,`dTransact` = ?,`dCreatedx` = ?,`nDownPaym` = ?,`cTranStat` = ? WHERE `sTransNox` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ECreditApplicantInfo value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getClientNm() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getClientNm());
        }
        if (value.getDetlInfo() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDetlInfo());
        }
        if (value.getPurchase() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPurchase());
        }
        if (value.getApplInfo() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getApplInfo());
        }
        if (value.getResidnce() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getResidnce());
        }
        if (value.getSameAddx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSameAddx());
        }
        if (value.getAppMeans() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAppMeans());
        }
        if (value.getEmplymnt() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getEmplymnt());
        }
        if (value.getBusnInfo() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getBusnInfo());
        }
        if (value.getFinancex() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getFinancex());
        }
        if (value.getPensionx() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getPensionx());
        }
        if (value.getOtherInc() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getOtherInc());
        }
        if (value.getSpousexx() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindString(14, value.getSpousexx());
        }
        if (value.getSpsResdx() == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, value.getSpsResdx());
        }
        if (value.getSpsMeans() == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, value.getSpsMeans());
        }
        if (value.getSpsEmplx() == null) {
          stmt.bindNull(17);
        } else {
          stmt.bindString(17, value.getSpsEmplx());
        }
        if (value.getSpsBusnx() == null) {
          stmt.bindNull(18);
        } else {
          stmt.bindString(18, value.getSpsBusnx());
        }
        if (value.getSpsPensn() == null) {
          stmt.bindNull(19);
        } else {
          stmt.bindString(19, value.getSpsPensn());
        }
        if (value.getSpOthInc() == null) {
          stmt.bindNull(20);
        } else {
          stmt.bindString(20, value.getSpOthInc());
        }
        if (value.getDisbrsmt() == null) {
          stmt.bindNull(21);
        } else {
          stmt.bindString(21, value.getDisbrsmt());
        }
        if (value.getDependnt() == null) {
          stmt.bindNull(22);
        } else {
          stmt.bindString(22, value.getDependnt());
        }
        if (value.getProperty() == null) {
          stmt.bindNull(23);
        } else {
          stmt.bindString(23, value.getProperty());
        }
        if (value.getOthrInfo() == null) {
          stmt.bindNull(24);
        } else {
          stmt.bindString(24, value.getOthrInfo());
        }
        if (value.getComakerx() == null) {
          stmt.bindNull(25);
        } else {
          stmt.bindString(25, value.getComakerx());
        }
        if (value.getCmResidx() == null) {
          stmt.bindNull(26);
        } else {
          stmt.bindString(26, value.getCmResidx());
        }
        if (value.getIsSpouse() == null) {
          stmt.bindNull(27);
        } else {
          stmt.bindString(27, value.getIsSpouse());
        }
        if (value.getIsComakr() == null) {
          stmt.bindNull(28);
        } else {
          stmt.bindString(28, value.getIsComakr());
        }
        if (value.getBranchCd() == null) {
          stmt.bindNull(29);
        } else {
          stmt.bindString(29, value.getBranchCd());
        }
        if (value.getAppliedx() == null) {
          stmt.bindNull(30);
        } else {
          stmt.bindString(30, value.getAppliedx());
        }
        if (value.getTransact() == null) {
          stmt.bindNull(31);
        } else {
          stmt.bindString(31, value.getTransact());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(32);
        } else {
          stmt.bindString(32, value.getCreatedx());
        }
        stmt.bindDouble(33, value.getDownPaym());
        if (value.getTranStat() == null) {
          stmt.bindNull(34);
        } else {
          stmt.bindString(34, value.getTranStat());
        }
        if (value.getTransNox() == null) {
          stmt.bindNull(35);
        } else {
          stmt.bindString(35, value.getTransNox());
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
    this.__updateAdapterOfELoanTerm = new EntityDeletionOrUpdateAdapter<ELoanTerm>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Installment_Term` SET `nTermCode` = ?,`sTermDesc` = ?,`cRecdStat` = ?,`dTimeStmp` = ? WHERE `nTermCode` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ELoanTerm value) {
        if (value.getTermCode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getTermCode());
        }
        if (value.getTermDesc() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTermDesc());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
        if (value.getTermCode() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindLong(5, value.getTermCode());
        }
      }
    };
    this.__preparedStmtOfUpdateSentLoanAppl = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application SET sTransNox =?, cSendStat = '1', dModified =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateApplicationListTransNox = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_List SET sTransNox =? WHERE sTransNox =?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateApplicationDocsTransNox = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE Credit_Online_Application_Documents SET sTransNox =? WHERE sTransNox =?";
        return _query;
      }
    };
  }

  @Override
  public void Save(final ECreditApplication creditApplication) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECreditApplication.insert(creditApplication);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Save(final ECreditApplicantInfo creditApplicantInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfECreditApplicantInfo.insert(creditApplicantInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Save(final EBranchLoanApplication branchLoanApplication) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEBranchLoanApplication.insert(branchLoanApplication);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Save(final ELoanTerm loanTerm) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfELoanTerm.insert(loanTerm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final ECreditApplication creditApplication) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfECreditApplication.handle(creditApplication);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final ECreditApplicantInfo creditApplicantInfo) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfECreditApplicantInfo.handle(creditApplicantInfo);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final EBranchLoanApplication branchLoanApplication) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEBranchLoanApplication.handle(branchLoanApplication);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void Update(final ELoanTerm loanTerm) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfELoanTerm.handle(loanTerm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateSentLoanAppl(final String oldTransNox, final String TransNox,
      final String DateTime) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSentLoanAppl.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (DateTime == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, DateTime);
    }
    _argIndex = 3;
    if (oldTransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, oldTransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateSentLoanAppl.release(_stmt);
    }
  }

  @Override
  public void updateApplicationListTransNox(final String oldTransNox, final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateApplicationListTransNox.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (oldTransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, oldTransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateApplicationListTransNox.release(_stmt);
    }
  }

  @Override
  public void updateApplicationImageTransNox(final String oldTransNox, final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateApplicationListTransNox.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (oldTransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, oldTransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateApplicationListTransNox.release(_stmt);
    }
  }

  @Override
  public void updateApplicationDocsTransNox(final String oldTransNox, final String TransNox) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateApplicationDocsTransNox.acquire();
    int _argIndex = 1;
    if (TransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, TransNox);
    }
    _argIndex = 2;
    if (oldTransNox == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, oldTransNox);
    }
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateApplicationDocsTransNox.release(_stmt);
    }
  }

  @Override
  public ECreditApplication CheckIfApplicantExist(final String ClientNm, final String BranchCD,
      final String UnitAppl, final double DownPaym, final String dCreated) {
    final String _sql = "SELECT * FROM Credit_Online_Application WHERE sClientNm=? AND sBranchCd=? AND cUnitAppl=? AND nDownPaym=? AND dCreatedx=?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 5);
    int _argIndex = 1;
    if (ClientNm == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ClientNm);
    }
    _argIndex = 2;
    if (BranchCD == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchCD);
    }
    _argIndex = 3;
    if (UnitAppl == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, UnitAppl);
    }
    _argIndex = 4;
    _statement.bindDouble(_argIndex, DownPaym);
    _argIndex = 5;
    if (dCreated == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dCreated);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfTargetDt = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetDt");
      final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
      final int _cursorIndexOfGOCASNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNox");
      final int _cursorIndexOfGOCASNoF = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNoF");
      final int _cursorIndexOfUnitAppl = CursorUtil.getColumnIndexOrThrow(_cursor, "cUnitAppl");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
      final int _cursorIndexOfCatInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCatInfox");
      final int _cursorIndexOfDesInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sDesInfox");
      final int _cursorIndexOfQMatchNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMatchNo");
      final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
      final int _cursorIndexOfCrdtScrx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCrdtScrx");
      final int _cursorIndexOfWithCIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithCIxx");
      final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
      final int _cursorIndexOfDownPayF = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPayF");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
      final int _cursorIndexOfDateCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
      final int _cursorIndexOfDateVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfApplStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cApplStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ECreditApplication _result;
      if(_cursor.moveToFirst()) {
        _result = new ECreditApplication();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpTargetDt;
        if (_cursor.isNull(_cursorIndexOfTargetDt)) {
          _tmpTargetDt = null;
        } else {
          _tmpTargetDt = _cursor.getString(_cursorIndexOfTargetDt);
        }
        _result.setTargetDt(_tmpTargetDt);
        final String _tmpClientNm;
        if (_cursor.isNull(_cursorIndexOfClientNm)) {
          _tmpClientNm = null;
        } else {
          _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
        }
        _result.setClientNm(_tmpClientNm);
        final String _tmpGOCASNox;
        if (_cursor.isNull(_cursorIndexOfGOCASNox)) {
          _tmpGOCASNox = null;
        } else {
          _tmpGOCASNox = _cursor.getString(_cursorIndexOfGOCASNox);
        }
        _result.setGOCASNox(_tmpGOCASNox);
        final String _tmpGOCASNoF;
        if (_cursor.isNull(_cursorIndexOfGOCASNoF)) {
          _tmpGOCASNoF = null;
        } else {
          _tmpGOCASNoF = _cursor.getString(_cursorIndexOfGOCASNoF);
        }
        _result.setGOCASNoF(_tmpGOCASNoF);
        final String _tmpUnitAppl;
        if (_cursor.isNull(_cursorIndexOfUnitAppl)) {
          _tmpUnitAppl = null;
        } else {
          _tmpUnitAppl = _cursor.getString(_cursorIndexOfUnitAppl);
        }
        _result.setUnitAppl(_tmpUnitAppl);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _result.setSourceCD(_tmpSourceCD);
        final String _tmpDetlInfo;
        if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
          _tmpDetlInfo = null;
        } else {
          _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
        }
        _result.setDetlInfo(_tmpDetlInfo);
        final String _tmpCatInfox;
        if (_cursor.isNull(_cursorIndexOfCatInfox)) {
          _tmpCatInfox = null;
        } else {
          _tmpCatInfox = _cursor.getString(_cursorIndexOfCatInfox);
        }
        _result.setCatInfox(_tmpCatInfox);
        final String _tmpDesInfox;
        if (_cursor.isNull(_cursorIndexOfDesInfox)) {
          _tmpDesInfox = null;
        } else {
          _tmpDesInfox = _cursor.getString(_cursorIndexOfDesInfox);
        }
        _result.setDesInfox(_tmpDesInfox);
        final String _tmpQMatchNo;
        if (_cursor.isNull(_cursorIndexOfQMatchNo)) {
          _tmpQMatchNo = null;
        } else {
          _tmpQMatchNo = _cursor.getString(_cursorIndexOfQMatchNo);
        }
        _result.setQMatchNo(_tmpQMatchNo);
        final String _tmpQMAppCde;
        if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
          _tmpQMAppCde = null;
        } else {
          _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
        }
        _result.setQMAppCde(_tmpQMAppCde);
        final int _tmpCrdtScrx;
        _tmpCrdtScrx = _cursor.getInt(_cursorIndexOfCrdtScrx);
        _result.setCrdtScrx(_tmpCrdtScrx);
        final String _tmpWithCIxx;
        if (_cursor.isNull(_cursorIndexOfWithCIxx)) {
          _tmpWithCIxx = null;
        } else {
          _tmpWithCIxx = _cursor.getString(_cursorIndexOfWithCIxx);
        }
        _result.setWithCIxx(_tmpWithCIxx);
        final double _tmpDownPaym;
        _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
        _result.setDownPaym(_tmpDownPaym);
        final double _tmpDownPayF;
        _tmpDownPayF = _cursor.getDouble(_cursorIndexOfDownPayF);
        _result.setDownPayF(_tmpDownPayF);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpReceived;
        if (_cursor.isNull(_cursorIndexOfReceived)) {
          _tmpReceived = null;
        } else {
          _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
        }
        _result.setReceived(_tmpReceived);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _result.setCreatedx(_tmpCreatedx);
        final String _tmpDateCreatedx;
        if (_cursor.isNull(_cursorIndexOfDateCreatedx)) {
          _tmpDateCreatedx = null;
        } else {
          _tmpDateCreatedx = _cursor.getString(_cursorIndexOfDateCreatedx);
        }
        _result.setDateCreatedx(_tmpDateCreatedx);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpVerified;
        if (_cursor.isNull(_cursorIndexOfVerified)) {
          _tmpVerified = null;
        } else {
          _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
        }
        _result.setVerified(_tmpVerified);
        final String _tmpDateVerified;
        if (_cursor.isNull(_cursorIndexOfDateVerified)) {
          _tmpDateVerified = null;
        } else {
          _tmpDateVerified = _cursor.getString(_cursorIndexOfDateVerified);
        }
        _result.setDateVerified(_tmpDateVerified);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpApplStat;
        if (_cursor.isNull(_cursorIndexOfApplStat)) {
          _tmpApplStat = null;
        } else {
          _tmpApplStat = _cursor.getString(_cursorIndexOfApplStat);
        }
        _result.setApplStat(_tmpApplStat);
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
  public ELoanTerm GetLoanTerm(final int args) {
    final String _sql = "SELECT * FROM Installment_Term WHERE nTermCode =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, args);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTermCode = CursorUtil.getColumnIndexOrThrow(_cursor, "nTermCode");
      final int _cursorIndexOfTermDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "sTermDesc");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ELoanTerm _result;
      if(_cursor.moveToFirst()) {
        _result = new ELoanTerm();
        final Integer _tmpTermCode;
        if (_cursor.isNull(_cursorIndexOfTermCode)) {
          _tmpTermCode = null;
        } else {
          _tmpTermCode = _cursor.getInt(_cursorIndexOfTermCode);
        }
        _result.setTermCode(_tmpTermCode);
        final String _tmpTermDesc;
        if (_cursor.isNull(_cursorIndexOfTermDesc)) {
          _tmpTermDesc = null;
        } else {
          _tmpTermDesc = _cursor.getString(_cursorIndexOfTermDesc);
        }
        _result.setTermDesc(_tmpTermDesc);
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
  public LiveData<List<ELoanTerm>> GetLoanTerms() {
    final String _sql = "SELECT * FROM Installment_Term ORDER BY nTermCode DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Installment_Term"}, false, new Callable<List<ELoanTerm>>() {
      @Override
      public List<ELoanTerm> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTermCode = CursorUtil.getColumnIndexOrThrow(_cursor, "nTermCode");
          final int _cursorIndexOfTermDesc = CursorUtil.getColumnIndexOrThrow(_cursor, "sTermDesc");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<ELoanTerm> _result = new ArrayList<ELoanTerm>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ELoanTerm _item;
            _item = new ELoanTerm();
            final Integer _tmpTermCode;
            if (_cursor.isNull(_cursorIndexOfTermCode)) {
              _tmpTermCode = null;
            } else {
              _tmpTermCode = _cursor.getInt(_cursorIndexOfTermCode);
            }
            _item.setTermCode(_tmpTermCode);
            final String _tmpTermDesc;
            if (_cursor.isNull(_cursorIndexOfTermDesc)) {
              _tmpTermDesc = null;
            } else {
              _tmpTermDesc = _cursor.getString(_cursorIndexOfTermDesc);
            }
            _item.setTermDesc(_tmpTermDesc);
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
  public ECreditApplication GetLatestRecord() {
    final String _sql = "SELECT * FROM Credit_Online_Application ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfTargetDt = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetDt");
      final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
      final int _cursorIndexOfGOCASNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNox");
      final int _cursorIndexOfGOCASNoF = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNoF");
      final int _cursorIndexOfUnitAppl = CursorUtil.getColumnIndexOrThrow(_cursor, "cUnitAppl");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
      final int _cursorIndexOfCatInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCatInfox");
      final int _cursorIndexOfDesInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sDesInfox");
      final int _cursorIndexOfQMatchNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMatchNo");
      final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
      final int _cursorIndexOfCrdtScrx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCrdtScrx");
      final int _cursorIndexOfWithCIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithCIxx");
      final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
      final int _cursorIndexOfDownPayF = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPayF");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
      final int _cursorIndexOfDateCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
      final int _cursorIndexOfDateVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfApplStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cApplStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ECreditApplication _result;
      if(_cursor.moveToFirst()) {
        _result = new ECreditApplication();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpTargetDt;
        if (_cursor.isNull(_cursorIndexOfTargetDt)) {
          _tmpTargetDt = null;
        } else {
          _tmpTargetDt = _cursor.getString(_cursorIndexOfTargetDt);
        }
        _result.setTargetDt(_tmpTargetDt);
        final String _tmpClientNm;
        if (_cursor.isNull(_cursorIndexOfClientNm)) {
          _tmpClientNm = null;
        } else {
          _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
        }
        _result.setClientNm(_tmpClientNm);
        final String _tmpGOCASNox;
        if (_cursor.isNull(_cursorIndexOfGOCASNox)) {
          _tmpGOCASNox = null;
        } else {
          _tmpGOCASNox = _cursor.getString(_cursorIndexOfGOCASNox);
        }
        _result.setGOCASNox(_tmpGOCASNox);
        final String _tmpGOCASNoF;
        if (_cursor.isNull(_cursorIndexOfGOCASNoF)) {
          _tmpGOCASNoF = null;
        } else {
          _tmpGOCASNoF = _cursor.getString(_cursorIndexOfGOCASNoF);
        }
        _result.setGOCASNoF(_tmpGOCASNoF);
        final String _tmpUnitAppl;
        if (_cursor.isNull(_cursorIndexOfUnitAppl)) {
          _tmpUnitAppl = null;
        } else {
          _tmpUnitAppl = _cursor.getString(_cursorIndexOfUnitAppl);
        }
        _result.setUnitAppl(_tmpUnitAppl);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _result.setSourceCD(_tmpSourceCD);
        final String _tmpDetlInfo;
        if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
          _tmpDetlInfo = null;
        } else {
          _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
        }
        _result.setDetlInfo(_tmpDetlInfo);
        final String _tmpCatInfox;
        if (_cursor.isNull(_cursorIndexOfCatInfox)) {
          _tmpCatInfox = null;
        } else {
          _tmpCatInfox = _cursor.getString(_cursorIndexOfCatInfox);
        }
        _result.setCatInfox(_tmpCatInfox);
        final String _tmpDesInfox;
        if (_cursor.isNull(_cursorIndexOfDesInfox)) {
          _tmpDesInfox = null;
        } else {
          _tmpDesInfox = _cursor.getString(_cursorIndexOfDesInfox);
        }
        _result.setDesInfox(_tmpDesInfox);
        final String _tmpQMatchNo;
        if (_cursor.isNull(_cursorIndexOfQMatchNo)) {
          _tmpQMatchNo = null;
        } else {
          _tmpQMatchNo = _cursor.getString(_cursorIndexOfQMatchNo);
        }
        _result.setQMatchNo(_tmpQMatchNo);
        final String _tmpQMAppCde;
        if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
          _tmpQMAppCde = null;
        } else {
          _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
        }
        _result.setQMAppCde(_tmpQMAppCde);
        final int _tmpCrdtScrx;
        _tmpCrdtScrx = _cursor.getInt(_cursorIndexOfCrdtScrx);
        _result.setCrdtScrx(_tmpCrdtScrx);
        final String _tmpWithCIxx;
        if (_cursor.isNull(_cursorIndexOfWithCIxx)) {
          _tmpWithCIxx = null;
        } else {
          _tmpWithCIxx = _cursor.getString(_cursorIndexOfWithCIxx);
        }
        _result.setWithCIxx(_tmpWithCIxx);
        final double _tmpDownPaym;
        _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
        _result.setDownPaym(_tmpDownPaym);
        final double _tmpDownPayF;
        _tmpDownPayF = _cursor.getDouble(_cursorIndexOfDownPayF);
        _result.setDownPayF(_tmpDownPayF);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpReceived;
        if (_cursor.isNull(_cursorIndexOfReceived)) {
          _tmpReceived = null;
        } else {
          _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
        }
        _result.setReceived(_tmpReceived);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _result.setCreatedx(_tmpCreatedx);
        final String _tmpDateCreatedx;
        if (_cursor.isNull(_cursorIndexOfDateCreatedx)) {
          _tmpDateCreatedx = null;
        } else {
          _tmpDateCreatedx = _cursor.getString(_cursorIndexOfDateCreatedx);
        }
        _result.setDateCreatedx(_tmpDateCreatedx);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpVerified;
        if (_cursor.isNull(_cursorIndexOfVerified)) {
          _tmpVerified = null;
        } else {
          _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
        }
        _result.setVerified(_tmpVerified);
        final String _tmpDateVerified;
        if (_cursor.isNull(_cursorIndexOfDateVerified)) {
          _tmpDateVerified = null;
        } else {
          _tmpDateVerified = _cursor.getString(_cursorIndexOfDateVerified);
        }
        _result.setDateVerified(_tmpDateVerified);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpApplStat;
        if (_cursor.isNull(_cursorIndexOfApplStat)) {
          _tmpApplStat = null;
        } else {
          _tmpApplStat = _cursor.getString(_cursorIndexOfApplStat);
        }
        _result.setApplStat(_tmpApplStat);
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
  public ECreditApplication GetCreditOnlineApplication(final String fsVal) {
    final String _sql = "SELECT * FROM Credit_Online_Application WHERE sTransNox =?";
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
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfTargetDt = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetDt");
      final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
      final int _cursorIndexOfGOCASNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNox");
      final int _cursorIndexOfGOCASNoF = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNoF");
      final int _cursorIndexOfUnitAppl = CursorUtil.getColumnIndexOrThrow(_cursor, "cUnitAppl");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
      final int _cursorIndexOfCatInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCatInfox");
      final int _cursorIndexOfDesInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sDesInfox");
      final int _cursorIndexOfQMatchNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMatchNo");
      final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
      final int _cursorIndexOfCrdtScrx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCrdtScrx");
      final int _cursorIndexOfWithCIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithCIxx");
      final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
      final int _cursorIndexOfDownPayF = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPayF");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
      final int _cursorIndexOfDateCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
      final int _cursorIndexOfDateVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfApplStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cApplStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ECreditApplication _result;
      if(_cursor.moveToFirst()) {
        _result = new ECreditApplication();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpTargetDt;
        if (_cursor.isNull(_cursorIndexOfTargetDt)) {
          _tmpTargetDt = null;
        } else {
          _tmpTargetDt = _cursor.getString(_cursorIndexOfTargetDt);
        }
        _result.setTargetDt(_tmpTargetDt);
        final String _tmpClientNm;
        if (_cursor.isNull(_cursorIndexOfClientNm)) {
          _tmpClientNm = null;
        } else {
          _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
        }
        _result.setClientNm(_tmpClientNm);
        final String _tmpGOCASNox;
        if (_cursor.isNull(_cursorIndexOfGOCASNox)) {
          _tmpGOCASNox = null;
        } else {
          _tmpGOCASNox = _cursor.getString(_cursorIndexOfGOCASNox);
        }
        _result.setGOCASNox(_tmpGOCASNox);
        final String _tmpGOCASNoF;
        if (_cursor.isNull(_cursorIndexOfGOCASNoF)) {
          _tmpGOCASNoF = null;
        } else {
          _tmpGOCASNoF = _cursor.getString(_cursorIndexOfGOCASNoF);
        }
        _result.setGOCASNoF(_tmpGOCASNoF);
        final String _tmpUnitAppl;
        if (_cursor.isNull(_cursorIndexOfUnitAppl)) {
          _tmpUnitAppl = null;
        } else {
          _tmpUnitAppl = _cursor.getString(_cursorIndexOfUnitAppl);
        }
        _result.setUnitAppl(_tmpUnitAppl);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _result.setSourceCD(_tmpSourceCD);
        final String _tmpDetlInfo;
        if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
          _tmpDetlInfo = null;
        } else {
          _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
        }
        _result.setDetlInfo(_tmpDetlInfo);
        final String _tmpCatInfox;
        if (_cursor.isNull(_cursorIndexOfCatInfox)) {
          _tmpCatInfox = null;
        } else {
          _tmpCatInfox = _cursor.getString(_cursorIndexOfCatInfox);
        }
        _result.setCatInfox(_tmpCatInfox);
        final String _tmpDesInfox;
        if (_cursor.isNull(_cursorIndexOfDesInfox)) {
          _tmpDesInfox = null;
        } else {
          _tmpDesInfox = _cursor.getString(_cursorIndexOfDesInfox);
        }
        _result.setDesInfox(_tmpDesInfox);
        final String _tmpQMatchNo;
        if (_cursor.isNull(_cursorIndexOfQMatchNo)) {
          _tmpQMatchNo = null;
        } else {
          _tmpQMatchNo = _cursor.getString(_cursorIndexOfQMatchNo);
        }
        _result.setQMatchNo(_tmpQMatchNo);
        final String _tmpQMAppCde;
        if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
          _tmpQMAppCde = null;
        } else {
          _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
        }
        _result.setQMAppCde(_tmpQMAppCde);
        final int _tmpCrdtScrx;
        _tmpCrdtScrx = _cursor.getInt(_cursorIndexOfCrdtScrx);
        _result.setCrdtScrx(_tmpCrdtScrx);
        final String _tmpWithCIxx;
        if (_cursor.isNull(_cursorIndexOfWithCIxx)) {
          _tmpWithCIxx = null;
        } else {
          _tmpWithCIxx = _cursor.getString(_cursorIndexOfWithCIxx);
        }
        _result.setWithCIxx(_tmpWithCIxx);
        final double _tmpDownPaym;
        _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
        _result.setDownPaym(_tmpDownPaym);
        final double _tmpDownPayF;
        _tmpDownPayF = _cursor.getDouble(_cursorIndexOfDownPayF);
        _result.setDownPayF(_tmpDownPayF);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpReceived;
        if (_cursor.isNull(_cursorIndexOfReceived)) {
          _tmpReceived = null;
        } else {
          _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
        }
        _result.setReceived(_tmpReceived);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _result.setCreatedx(_tmpCreatedx);
        final String _tmpDateCreatedx;
        if (_cursor.isNull(_cursorIndexOfDateCreatedx)) {
          _tmpDateCreatedx = null;
        } else {
          _tmpDateCreatedx = _cursor.getString(_cursorIndexOfDateCreatedx);
        }
        _result.setDateCreatedx(_tmpDateCreatedx);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpVerified;
        if (_cursor.isNull(_cursorIndexOfVerified)) {
          _tmpVerified = null;
        } else {
          _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
        }
        _result.setVerified(_tmpVerified);
        final String _tmpDateVerified;
        if (_cursor.isNull(_cursorIndexOfDateVerified)) {
          _tmpDateVerified = null;
        } else {
          _tmpDateVerified = _cursor.getString(_cursorIndexOfDateVerified);
        }
        _result.setDateVerified(_tmpDateVerified);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpApplStat;
        if (_cursor.isNull(_cursorIndexOfApplStat)) {
          _tmpApplStat = null;
        } else {
          _tmpApplStat = _cursor.getString(_cursorIndexOfApplStat);
        }
        _result.setApplStat(_tmpApplStat);
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
  public LiveData<ECreditApplication> GetCreditApplication(final String fsVal) {
    final String _sql = "SELECT * FROM Credit_Online_Application WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application"}, false, new Callable<ECreditApplication>() {
      @Override
      public ECreditApplication call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfTargetDt = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetDt");
          final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
          final int _cursorIndexOfGOCASNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNox");
          final int _cursorIndexOfGOCASNoF = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNoF");
          final int _cursorIndexOfUnitAppl = CursorUtil.getColumnIndexOrThrow(_cursor, "cUnitAppl");
          final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
          final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
          final int _cursorIndexOfCatInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCatInfox");
          final int _cursorIndexOfDesInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sDesInfox");
          final int _cursorIndexOfQMatchNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMatchNo");
          final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
          final int _cursorIndexOfCrdtScrx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCrdtScrx");
          final int _cursorIndexOfWithCIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithCIxx");
          final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
          final int _cursorIndexOfDownPayF = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPayF");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
          final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
          final int _cursorIndexOfDateCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
          final int _cursorIndexOfDateVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfApplStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cApplStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final ECreditApplication _result;
          if(_cursor.moveToFirst()) {
            _result = new ECreditApplication();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _result.setTransact(_tmpTransact);
            final String _tmpTargetDt;
            if (_cursor.isNull(_cursorIndexOfTargetDt)) {
              _tmpTargetDt = null;
            } else {
              _tmpTargetDt = _cursor.getString(_cursorIndexOfTargetDt);
            }
            _result.setTargetDt(_tmpTargetDt);
            final String _tmpClientNm;
            if (_cursor.isNull(_cursorIndexOfClientNm)) {
              _tmpClientNm = null;
            } else {
              _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
            }
            _result.setClientNm(_tmpClientNm);
            final String _tmpGOCASNox;
            if (_cursor.isNull(_cursorIndexOfGOCASNox)) {
              _tmpGOCASNox = null;
            } else {
              _tmpGOCASNox = _cursor.getString(_cursorIndexOfGOCASNox);
            }
            _result.setGOCASNox(_tmpGOCASNox);
            final String _tmpGOCASNoF;
            if (_cursor.isNull(_cursorIndexOfGOCASNoF)) {
              _tmpGOCASNoF = null;
            } else {
              _tmpGOCASNoF = _cursor.getString(_cursorIndexOfGOCASNoF);
            }
            _result.setGOCASNoF(_tmpGOCASNoF);
            final String _tmpUnitAppl;
            if (_cursor.isNull(_cursorIndexOfUnitAppl)) {
              _tmpUnitAppl = null;
            } else {
              _tmpUnitAppl = _cursor.getString(_cursorIndexOfUnitAppl);
            }
            _result.setUnitAppl(_tmpUnitAppl);
            final String _tmpSourceCD;
            if (_cursor.isNull(_cursorIndexOfSourceCD)) {
              _tmpSourceCD = null;
            } else {
              _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
            }
            _result.setSourceCD(_tmpSourceCD);
            final String _tmpDetlInfo;
            if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
              _tmpDetlInfo = null;
            } else {
              _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
            }
            _result.setDetlInfo(_tmpDetlInfo);
            final String _tmpCatInfox;
            if (_cursor.isNull(_cursorIndexOfCatInfox)) {
              _tmpCatInfox = null;
            } else {
              _tmpCatInfox = _cursor.getString(_cursorIndexOfCatInfox);
            }
            _result.setCatInfox(_tmpCatInfox);
            final String _tmpDesInfox;
            if (_cursor.isNull(_cursorIndexOfDesInfox)) {
              _tmpDesInfox = null;
            } else {
              _tmpDesInfox = _cursor.getString(_cursorIndexOfDesInfox);
            }
            _result.setDesInfox(_tmpDesInfox);
            final String _tmpQMatchNo;
            if (_cursor.isNull(_cursorIndexOfQMatchNo)) {
              _tmpQMatchNo = null;
            } else {
              _tmpQMatchNo = _cursor.getString(_cursorIndexOfQMatchNo);
            }
            _result.setQMatchNo(_tmpQMatchNo);
            final String _tmpQMAppCde;
            if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
              _tmpQMAppCde = null;
            } else {
              _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
            }
            _result.setQMAppCde(_tmpQMAppCde);
            final int _tmpCrdtScrx;
            _tmpCrdtScrx = _cursor.getInt(_cursorIndexOfCrdtScrx);
            _result.setCrdtScrx(_tmpCrdtScrx);
            final String _tmpWithCIxx;
            if (_cursor.isNull(_cursorIndexOfWithCIxx)) {
              _tmpWithCIxx = null;
            } else {
              _tmpWithCIxx = _cursor.getString(_cursorIndexOfWithCIxx);
            }
            _result.setWithCIxx(_tmpWithCIxx);
            final double _tmpDownPaym;
            _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
            _result.setDownPaym(_tmpDownPaym);
            final double _tmpDownPayF;
            _tmpDownPayF = _cursor.getDouble(_cursorIndexOfDownPayF);
            _result.setDownPayF(_tmpDownPayF);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _result.setRemarksx(_tmpRemarksx);
            final String _tmpReceived;
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _tmpReceived = null;
            } else {
              _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
            }
            _result.setReceived(_tmpReceived);
            final String _tmpCreatedx;
            if (_cursor.isNull(_cursorIndexOfCreatedx)) {
              _tmpCreatedx = null;
            } else {
              _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
            }
            _result.setCreatedx(_tmpCreatedx);
            final String _tmpDateCreatedx;
            if (_cursor.isNull(_cursorIndexOfDateCreatedx)) {
              _tmpDateCreatedx = null;
            } else {
              _tmpDateCreatedx = _cursor.getString(_cursorIndexOfDateCreatedx);
            }
            _result.setDateCreatedx(_tmpDateCreatedx);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _result.setSendStat(_tmpSendStat);
            final String _tmpVerified;
            if (_cursor.isNull(_cursorIndexOfVerified)) {
              _tmpVerified = null;
            } else {
              _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
            }
            _result.setVerified(_tmpVerified);
            final String _tmpDateVerified;
            if (_cursor.isNull(_cursorIndexOfDateVerified)) {
              _tmpDateVerified = null;
            } else {
              _tmpDateVerified = _cursor.getString(_cursorIndexOfDateVerified);
            }
            _result.setDateVerified(_tmpDateVerified);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _result.setModified(_tmpModified);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _result.setTranStat(_tmpTranStat);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _result.setDivision(_tmpDivision);
            final String _tmpApplStat;
            if (_cursor.isNull(_cursorIndexOfApplStat)) {
              _tmpApplStat = null;
            } else {
              _tmpApplStat = _cursor.getString(_cursorIndexOfApplStat);
            }
            _result.setApplStat(_tmpApplStat);
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
  public LiveData<ECreditApplicantInfo> GetApplicantInfo(final String fsVal) {
    final String _sql = "SELECT * FROM Credit_Applicant_Info WHERE sTransNox =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fsVal == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fsVal);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Applicant_Info"}, false, new Callable<ECreditApplicantInfo>() {
      @Override
      public ECreditApplicantInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
          final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurchase");
          final int _cursorIndexOfApplInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sApplInfo");
          final int _cursorIndexOfResidnce = CursorUtil.getColumnIndexOrThrow(_cursor, "sResidnce");
          final int _cursorIndexOfSameAddx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSameAddx");
          final int _cursorIndexOfAppMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppMeans");
          final int _cursorIndexOfEmplymnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmplymnt");
          final int _cursorIndexOfBusnInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sBusnInfo");
          final int _cursorIndexOfFinancex = CursorUtil.getColumnIndexOrThrow(_cursor, "sFinancex");
          final int _cursorIndexOfPensionx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPensionx");
          final int _cursorIndexOfOtherInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sOtherInc");
          final int _cursorIndexOfSpousexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpousexx");
          final int _cursorIndexOfSpsResdx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsResdx");
          final int _cursorIndexOfSpsMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsMEans");
          final int _cursorIndexOfSpsEmplx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsEmplx");
          final int _cursorIndexOfSpsBusnx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsBusnx");
          final int _cursorIndexOfSpsPensn = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsPensn");
          final int _cursorIndexOfSpOthInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpOthInc");
          final int _cursorIndexOfDisbrsmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDisbrsmt");
          final int _cursorIndexOfDependnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDependnt");
          final int _cursorIndexOfProperty = CursorUtil.getColumnIndexOrThrow(_cursor, "sProperty");
          final int _cursorIndexOfOthrInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sOthrInfo");
          final int _cursorIndexOfComakerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sComakerx");
          final int _cursorIndexOfCmResidx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCmResidx");
          final int _cursorIndexOfIsSpouse = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsSpouse");
          final int _cursorIndexOfIsComakr = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsComakr");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfAppliedx = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppliedx");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
          final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final ECreditApplicantInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new ECreditApplicantInfo();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _result.setTransNox(_tmpTransNox);
            final String _tmpClientNm;
            if (_cursor.isNull(_cursorIndexOfClientNm)) {
              _tmpClientNm = null;
            } else {
              _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
            }
            _result.setClientNm(_tmpClientNm);
            final String _tmpDetlInfo;
            if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
              _tmpDetlInfo = null;
            } else {
              _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
            }
            _result.setDetlInfo(_tmpDetlInfo);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _result.setPurchase(_tmpPurchase);
            final String _tmpApplInfo;
            if (_cursor.isNull(_cursorIndexOfApplInfo)) {
              _tmpApplInfo = null;
            } else {
              _tmpApplInfo = _cursor.getString(_cursorIndexOfApplInfo);
            }
            _result.setApplInfo(_tmpApplInfo);
            final String _tmpResidnce;
            if (_cursor.isNull(_cursorIndexOfResidnce)) {
              _tmpResidnce = null;
            } else {
              _tmpResidnce = _cursor.getString(_cursorIndexOfResidnce);
            }
            _result.setResidnce(_tmpResidnce);
            final String _tmpSameAddx;
            if (_cursor.isNull(_cursorIndexOfSameAddx)) {
              _tmpSameAddx = null;
            } else {
              _tmpSameAddx = _cursor.getString(_cursorIndexOfSameAddx);
            }
            _result.setSameAddx(_tmpSameAddx);
            final String _tmpAppMeans;
            if (_cursor.isNull(_cursorIndexOfAppMeans)) {
              _tmpAppMeans = null;
            } else {
              _tmpAppMeans = _cursor.getString(_cursorIndexOfAppMeans);
            }
            _result.setAppMeans(_tmpAppMeans);
            final String _tmpEmplymnt;
            if (_cursor.isNull(_cursorIndexOfEmplymnt)) {
              _tmpEmplymnt = null;
            } else {
              _tmpEmplymnt = _cursor.getString(_cursorIndexOfEmplymnt);
            }
            _result.setEmplymnt(_tmpEmplymnt);
            final String _tmpBusnInfo;
            if (_cursor.isNull(_cursorIndexOfBusnInfo)) {
              _tmpBusnInfo = null;
            } else {
              _tmpBusnInfo = _cursor.getString(_cursorIndexOfBusnInfo);
            }
            _result.setBusnInfo(_tmpBusnInfo);
            final String _tmpFinancex;
            if (_cursor.isNull(_cursorIndexOfFinancex)) {
              _tmpFinancex = null;
            } else {
              _tmpFinancex = _cursor.getString(_cursorIndexOfFinancex);
            }
            _result.setFinancex(_tmpFinancex);
            final String _tmpPensionx;
            if (_cursor.isNull(_cursorIndexOfPensionx)) {
              _tmpPensionx = null;
            } else {
              _tmpPensionx = _cursor.getString(_cursorIndexOfPensionx);
            }
            _result.setPensionx(_tmpPensionx);
            final String _tmpOtherInc;
            if (_cursor.isNull(_cursorIndexOfOtherInc)) {
              _tmpOtherInc = null;
            } else {
              _tmpOtherInc = _cursor.getString(_cursorIndexOfOtherInc);
            }
            _result.setOtherInc(_tmpOtherInc);
            final String _tmpSpousexx;
            if (_cursor.isNull(_cursorIndexOfSpousexx)) {
              _tmpSpousexx = null;
            } else {
              _tmpSpousexx = _cursor.getString(_cursorIndexOfSpousexx);
            }
            _result.setSpousexx(_tmpSpousexx);
            final String _tmpSpsResdx;
            if (_cursor.isNull(_cursorIndexOfSpsResdx)) {
              _tmpSpsResdx = null;
            } else {
              _tmpSpsResdx = _cursor.getString(_cursorIndexOfSpsResdx);
            }
            _result.setSpsResdx(_tmpSpsResdx);
            final String _tmpSpsMeans;
            if (_cursor.isNull(_cursorIndexOfSpsMeans)) {
              _tmpSpsMeans = null;
            } else {
              _tmpSpsMeans = _cursor.getString(_cursorIndexOfSpsMeans);
            }
            _result.setSpsMeans(_tmpSpsMeans);
            final String _tmpSpsEmplx;
            if (_cursor.isNull(_cursorIndexOfSpsEmplx)) {
              _tmpSpsEmplx = null;
            } else {
              _tmpSpsEmplx = _cursor.getString(_cursorIndexOfSpsEmplx);
            }
            _result.setSpsEmplx(_tmpSpsEmplx);
            final String _tmpSpsBusnx;
            if (_cursor.isNull(_cursorIndexOfSpsBusnx)) {
              _tmpSpsBusnx = null;
            } else {
              _tmpSpsBusnx = _cursor.getString(_cursorIndexOfSpsBusnx);
            }
            _result.setSpsBusnx(_tmpSpsBusnx);
            final String _tmpSpsPensn;
            if (_cursor.isNull(_cursorIndexOfSpsPensn)) {
              _tmpSpsPensn = null;
            } else {
              _tmpSpsPensn = _cursor.getString(_cursorIndexOfSpsPensn);
            }
            _result.setSpsPensn(_tmpSpsPensn);
            final String _tmpSpOthInc;
            if (_cursor.isNull(_cursorIndexOfSpOthInc)) {
              _tmpSpOthInc = null;
            } else {
              _tmpSpOthInc = _cursor.getString(_cursorIndexOfSpOthInc);
            }
            _result.setSpOthInc(_tmpSpOthInc);
            final String _tmpDisbrsmt;
            if (_cursor.isNull(_cursorIndexOfDisbrsmt)) {
              _tmpDisbrsmt = null;
            } else {
              _tmpDisbrsmt = _cursor.getString(_cursorIndexOfDisbrsmt);
            }
            _result.setDisbrsmt(_tmpDisbrsmt);
            final String _tmpDependnt;
            if (_cursor.isNull(_cursorIndexOfDependnt)) {
              _tmpDependnt = null;
            } else {
              _tmpDependnt = _cursor.getString(_cursorIndexOfDependnt);
            }
            _result.setDependnt(_tmpDependnt);
            final String _tmpProperty;
            if (_cursor.isNull(_cursorIndexOfProperty)) {
              _tmpProperty = null;
            } else {
              _tmpProperty = _cursor.getString(_cursorIndexOfProperty);
            }
            _result.setProperty(_tmpProperty);
            final String _tmpOthrInfo;
            if (_cursor.isNull(_cursorIndexOfOthrInfo)) {
              _tmpOthrInfo = null;
            } else {
              _tmpOthrInfo = _cursor.getString(_cursorIndexOfOthrInfo);
            }
            _result.setOthrInfo(_tmpOthrInfo);
            final String _tmpComakerx;
            if (_cursor.isNull(_cursorIndexOfComakerx)) {
              _tmpComakerx = null;
            } else {
              _tmpComakerx = _cursor.getString(_cursorIndexOfComakerx);
            }
            _result.setComakerx(_tmpComakerx);
            final String _tmpCmResidx;
            if (_cursor.isNull(_cursorIndexOfCmResidx)) {
              _tmpCmResidx = null;
            } else {
              _tmpCmResidx = _cursor.getString(_cursorIndexOfCmResidx);
            }
            _result.setCmResidx(_tmpCmResidx);
            final String _tmpIsSpouse;
            if (_cursor.isNull(_cursorIndexOfIsSpouse)) {
              _tmpIsSpouse = null;
            } else {
              _tmpIsSpouse = _cursor.getString(_cursorIndexOfIsSpouse);
            }
            _result.setIsSpouse(_tmpIsSpouse);
            final String _tmpIsComakr;
            if (_cursor.isNull(_cursorIndexOfIsComakr)) {
              _tmpIsComakr = null;
            } else {
              _tmpIsComakr = _cursor.getString(_cursorIndexOfIsComakr);
            }
            _result.setIsComakr(_tmpIsComakr);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _result.setBranchCd(_tmpBranchCd);
            final String _tmpAppliedx;
            if (_cursor.isNull(_cursorIndexOfAppliedx)) {
              _tmpAppliedx = null;
            } else {
              _tmpAppliedx = _cursor.getString(_cursorIndexOfAppliedx);
            }
            _result.setAppliedx(_tmpAppliedx);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _result.setTransact(_tmpTransact);
            final String _tmpCreatedx;
            if (_cursor.isNull(_cursorIndexOfCreatedx)) {
              _tmpCreatedx = null;
            } else {
              _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
            }
            _result.setCreatedx(_tmpCreatedx);
            final double _tmpDownPaym;
            _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
            _result.setDownPaym(_tmpDownPaym);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public ECreditApplicantInfo GetApplicantDetails(final String fsVal) {
    final String _sql = "SELECT * FROM Credit_Applicant_Info WHERE sTransNox =?";
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
      final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
      final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
      final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurchase");
      final int _cursorIndexOfApplInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sApplInfo");
      final int _cursorIndexOfResidnce = CursorUtil.getColumnIndexOrThrow(_cursor, "sResidnce");
      final int _cursorIndexOfSameAddx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSameAddx");
      final int _cursorIndexOfAppMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppMeans");
      final int _cursorIndexOfEmplymnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmplymnt");
      final int _cursorIndexOfBusnInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sBusnInfo");
      final int _cursorIndexOfFinancex = CursorUtil.getColumnIndexOrThrow(_cursor, "sFinancex");
      final int _cursorIndexOfPensionx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPensionx");
      final int _cursorIndexOfOtherInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sOtherInc");
      final int _cursorIndexOfSpousexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpousexx");
      final int _cursorIndexOfSpsResdx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsResdx");
      final int _cursorIndexOfSpsMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsMEans");
      final int _cursorIndexOfSpsEmplx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsEmplx");
      final int _cursorIndexOfSpsBusnx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsBusnx");
      final int _cursorIndexOfSpsPensn = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsPensn");
      final int _cursorIndexOfSpOthInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpOthInc");
      final int _cursorIndexOfDisbrsmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDisbrsmt");
      final int _cursorIndexOfDependnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDependnt");
      final int _cursorIndexOfProperty = CursorUtil.getColumnIndexOrThrow(_cursor, "sProperty");
      final int _cursorIndexOfOthrInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sOthrInfo");
      final int _cursorIndexOfComakerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sComakerx");
      final int _cursorIndexOfCmResidx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCmResidx");
      final int _cursorIndexOfIsSpouse = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsSpouse");
      final int _cursorIndexOfIsComakr = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsComakr");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfAppliedx = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppliedx");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final ECreditApplicantInfo _result;
      if(_cursor.moveToFirst()) {
        _result = new ECreditApplicantInfo();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpClientNm;
        if (_cursor.isNull(_cursorIndexOfClientNm)) {
          _tmpClientNm = null;
        } else {
          _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
        }
        _result.setClientNm(_tmpClientNm);
        final String _tmpDetlInfo;
        if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
          _tmpDetlInfo = null;
        } else {
          _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
        }
        _result.setDetlInfo(_tmpDetlInfo);
        final String _tmpPurchase;
        if (_cursor.isNull(_cursorIndexOfPurchase)) {
          _tmpPurchase = null;
        } else {
          _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
        }
        _result.setPurchase(_tmpPurchase);
        final String _tmpApplInfo;
        if (_cursor.isNull(_cursorIndexOfApplInfo)) {
          _tmpApplInfo = null;
        } else {
          _tmpApplInfo = _cursor.getString(_cursorIndexOfApplInfo);
        }
        _result.setApplInfo(_tmpApplInfo);
        final String _tmpResidnce;
        if (_cursor.isNull(_cursorIndexOfResidnce)) {
          _tmpResidnce = null;
        } else {
          _tmpResidnce = _cursor.getString(_cursorIndexOfResidnce);
        }
        _result.setResidnce(_tmpResidnce);
        final String _tmpSameAddx;
        if (_cursor.isNull(_cursorIndexOfSameAddx)) {
          _tmpSameAddx = null;
        } else {
          _tmpSameAddx = _cursor.getString(_cursorIndexOfSameAddx);
        }
        _result.setSameAddx(_tmpSameAddx);
        final String _tmpAppMeans;
        if (_cursor.isNull(_cursorIndexOfAppMeans)) {
          _tmpAppMeans = null;
        } else {
          _tmpAppMeans = _cursor.getString(_cursorIndexOfAppMeans);
        }
        _result.setAppMeans(_tmpAppMeans);
        final String _tmpEmplymnt;
        if (_cursor.isNull(_cursorIndexOfEmplymnt)) {
          _tmpEmplymnt = null;
        } else {
          _tmpEmplymnt = _cursor.getString(_cursorIndexOfEmplymnt);
        }
        _result.setEmplymnt(_tmpEmplymnt);
        final String _tmpBusnInfo;
        if (_cursor.isNull(_cursorIndexOfBusnInfo)) {
          _tmpBusnInfo = null;
        } else {
          _tmpBusnInfo = _cursor.getString(_cursorIndexOfBusnInfo);
        }
        _result.setBusnInfo(_tmpBusnInfo);
        final String _tmpFinancex;
        if (_cursor.isNull(_cursorIndexOfFinancex)) {
          _tmpFinancex = null;
        } else {
          _tmpFinancex = _cursor.getString(_cursorIndexOfFinancex);
        }
        _result.setFinancex(_tmpFinancex);
        final String _tmpPensionx;
        if (_cursor.isNull(_cursorIndexOfPensionx)) {
          _tmpPensionx = null;
        } else {
          _tmpPensionx = _cursor.getString(_cursorIndexOfPensionx);
        }
        _result.setPensionx(_tmpPensionx);
        final String _tmpOtherInc;
        if (_cursor.isNull(_cursorIndexOfOtherInc)) {
          _tmpOtherInc = null;
        } else {
          _tmpOtherInc = _cursor.getString(_cursorIndexOfOtherInc);
        }
        _result.setOtherInc(_tmpOtherInc);
        final String _tmpSpousexx;
        if (_cursor.isNull(_cursorIndexOfSpousexx)) {
          _tmpSpousexx = null;
        } else {
          _tmpSpousexx = _cursor.getString(_cursorIndexOfSpousexx);
        }
        _result.setSpousexx(_tmpSpousexx);
        final String _tmpSpsResdx;
        if (_cursor.isNull(_cursorIndexOfSpsResdx)) {
          _tmpSpsResdx = null;
        } else {
          _tmpSpsResdx = _cursor.getString(_cursorIndexOfSpsResdx);
        }
        _result.setSpsResdx(_tmpSpsResdx);
        final String _tmpSpsMeans;
        if (_cursor.isNull(_cursorIndexOfSpsMeans)) {
          _tmpSpsMeans = null;
        } else {
          _tmpSpsMeans = _cursor.getString(_cursorIndexOfSpsMeans);
        }
        _result.setSpsMeans(_tmpSpsMeans);
        final String _tmpSpsEmplx;
        if (_cursor.isNull(_cursorIndexOfSpsEmplx)) {
          _tmpSpsEmplx = null;
        } else {
          _tmpSpsEmplx = _cursor.getString(_cursorIndexOfSpsEmplx);
        }
        _result.setSpsEmplx(_tmpSpsEmplx);
        final String _tmpSpsBusnx;
        if (_cursor.isNull(_cursorIndexOfSpsBusnx)) {
          _tmpSpsBusnx = null;
        } else {
          _tmpSpsBusnx = _cursor.getString(_cursorIndexOfSpsBusnx);
        }
        _result.setSpsBusnx(_tmpSpsBusnx);
        final String _tmpSpsPensn;
        if (_cursor.isNull(_cursorIndexOfSpsPensn)) {
          _tmpSpsPensn = null;
        } else {
          _tmpSpsPensn = _cursor.getString(_cursorIndexOfSpsPensn);
        }
        _result.setSpsPensn(_tmpSpsPensn);
        final String _tmpSpOthInc;
        if (_cursor.isNull(_cursorIndexOfSpOthInc)) {
          _tmpSpOthInc = null;
        } else {
          _tmpSpOthInc = _cursor.getString(_cursorIndexOfSpOthInc);
        }
        _result.setSpOthInc(_tmpSpOthInc);
        final String _tmpDisbrsmt;
        if (_cursor.isNull(_cursorIndexOfDisbrsmt)) {
          _tmpDisbrsmt = null;
        } else {
          _tmpDisbrsmt = _cursor.getString(_cursorIndexOfDisbrsmt);
        }
        _result.setDisbrsmt(_tmpDisbrsmt);
        final String _tmpDependnt;
        if (_cursor.isNull(_cursorIndexOfDependnt)) {
          _tmpDependnt = null;
        } else {
          _tmpDependnt = _cursor.getString(_cursorIndexOfDependnt);
        }
        _result.setDependnt(_tmpDependnt);
        final String _tmpProperty;
        if (_cursor.isNull(_cursorIndexOfProperty)) {
          _tmpProperty = null;
        } else {
          _tmpProperty = _cursor.getString(_cursorIndexOfProperty);
        }
        _result.setProperty(_tmpProperty);
        final String _tmpOthrInfo;
        if (_cursor.isNull(_cursorIndexOfOthrInfo)) {
          _tmpOthrInfo = null;
        } else {
          _tmpOthrInfo = _cursor.getString(_cursorIndexOfOthrInfo);
        }
        _result.setOthrInfo(_tmpOthrInfo);
        final String _tmpComakerx;
        if (_cursor.isNull(_cursorIndexOfComakerx)) {
          _tmpComakerx = null;
        } else {
          _tmpComakerx = _cursor.getString(_cursorIndexOfComakerx);
        }
        _result.setComakerx(_tmpComakerx);
        final String _tmpCmResidx;
        if (_cursor.isNull(_cursorIndexOfCmResidx)) {
          _tmpCmResidx = null;
        } else {
          _tmpCmResidx = _cursor.getString(_cursorIndexOfCmResidx);
        }
        _result.setCmResidx(_tmpCmResidx);
        final String _tmpIsSpouse;
        if (_cursor.isNull(_cursorIndexOfIsSpouse)) {
          _tmpIsSpouse = null;
        } else {
          _tmpIsSpouse = _cursor.getString(_cursorIndexOfIsSpouse);
        }
        _result.setIsSpouse(_tmpIsSpouse);
        final String _tmpIsComakr;
        if (_cursor.isNull(_cursorIndexOfIsComakr)) {
          _tmpIsComakr = null;
        } else {
          _tmpIsComakr = _cursor.getString(_cursorIndexOfIsComakr);
        }
        _result.setIsComakr(_tmpIsComakr);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpAppliedx;
        if (_cursor.isNull(_cursorIndexOfAppliedx)) {
          _tmpAppliedx = null;
        } else {
          _tmpAppliedx = _cursor.getString(_cursorIndexOfAppliedx);
        }
        _result.setAppliedx(_tmpAppliedx);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _result.setCreatedx(_tmpCreatedx);
        final double _tmpDownPaym;
        _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
        _result.setDownPaym(_tmpDownPaym);
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

  @Override
  public String GetBirthPlace(final String fsVal) {
    final String _sql = "SELECT a.sTownName || ', ' || b.sProvName FROM Town_Info a LEFT JOIN Province_Info b ON a.sProvIDxx = b.sProvIDxx WHERE a.sTownIDxx=?";
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
      final String _result;
      if(_cursor.moveToFirst()) {
        final String _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getString(0);
        }
        _result = _tmp;
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
  public String GetCitizenship(final String fsVal) {
    final String _sql = "SELECT sNational FROM Country_Info WHERE sCntryCde =?";
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
  public int GetRowsCountForID() {
    final String _sql = "SELECT COUNT (*) FROM Credit_Online_Application";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public int GetRowsCountForUniqueID() {
    final String _sql = "SELECT COUNT (*) FROM Credit_Applicant_Info";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<ECreditApplication>> GetAllCreditApplication() {
    final String _sql = "SELECT * FROM Credit_Online_Application";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application"}, false, new Callable<List<ECreditApplication>>() {
      @Override
      public List<ECreditApplication> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfTargetDt = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetDt");
          final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
          final int _cursorIndexOfGOCASNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNox");
          final int _cursorIndexOfGOCASNoF = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNoF");
          final int _cursorIndexOfUnitAppl = CursorUtil.getColumnIndexOrThrow(_cursor, "cUnitAppl");
          final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
          final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
          final int _cursorIndexOfCatInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCatInfox");
          final int _cursorIndexOfDesInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sDesInfox");
          final int _cursorIndexOfQMatchNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMatchNo");
          final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
          final int _cursorIndexOfCrdtScrx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCrdtScrx");
          final int _cursorIndexOfWithCIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithCIxx");
          final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
          final int _cursorIndexOfDownPayF = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPayF");
          final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
          final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
          final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
          final int _cursorIndexOfDateCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
          final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
          final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
          final int _cursorIndexOfDateVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
          final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
          final int _cursorIndexOfApplStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cApplStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final List<ECreditApplication> _result = new ArrayList<ECreditApplication>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ECreditApplication _item;
            _item = new ECreditApplication();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpTargetDt;
            if (_cursor.isNull(_cursorIndexOfTargetDt)) {
              _tmpTargetDt = null;
            } else {
              _tmpTargetDt = _cursor.getString(_cursorIndexOfTargetDt);
            }
            _item.setTargetDt(_tmpTargetDt);
            final String _tmpClientNm;
            if (_cursor.isNull(_cursorIndexOfClientNm)) {
              _tmpClientNm = null;
            } else {
              _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
            }
            _item.setClientNm(_tmpClientNm);
            final String _tmpGOCASNox;
            if (_cursor.isNull(_cursorIndexOfGOCASNox)) {
              _tmpGOCASNox = null;
            } else {
              _tmpGOCASNox = _cursor.getString(_cursorIndexOfGOCASNox);
            }
            _item.setGOCASNox(_tmpGOCASNox);
            final String _tmpGOCASNoF;
            if (_cursor.isNull(_cursorIndexOfGOCASNoF)) {
              _tmpGOCASNoF = null;
            } else {
              _tmpGOCASNoF = _cursor.getString(_cursorIndexOfGOCASNoF);
            }
            _item.setGOCASNoF(_tmpGOCASNoF);
            final String _tmpUnitAppl;
            if (_cursor.isNull(_cursorIndexOfUnitAppl)) {
              _tmpUnitAppl = null;
            } else {
              _tmpUnitAppl = _cursor.getString(_cursorIndexOfUnitAppl);
            }
            _item.setUnitAppl(_tmpUnitAppl);
            final String _tmpSourceCD;
            if (_cursor.isNull(_cursorIndexOfSourceCD)) {
              _tmpSourceCD = null;
            } else {
              _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
            }
            _item.setSourceCD(_tmpSourceCD);
            final String _tmpDetlInfo;
            if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
              _tmpDetlInfo = null;
            } else {
              _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
            }
            _item.setDetlInfo(_tmpDetlInfo);
            final String _tmpCatInfox;
            if (_cursor.isNull(_cursorIndexOfCatInfox)) {
              _tmpCatInfox = null;
            } else {
              _tmpCatInfox = _cursor.getString(_cursorIndexOfCatInfox);
            }
            _item.setCatInfox(_tmpCatInfox);
            final String _tmpDesInfox;
            if (_cursor.isNull(_cursorIndexOfDesInfox)) {
              _tmpDesInfox = null;
            } else {
              _tmpDesInfox = _cursor.getString(_cursorIndexOfDesInfox);
            }
            _item.setDesInfox(_tmpDesInfox);
            final String _tmpQMatchNo;
            if (_cursor.isNull(_cursorIndexOfQMatchNo)) {
              _tmpQMatchNo = null;
            } else {
              _tmpQMatchNo = _cursor.getString(_cursorIndexOfQMatchNo);
            }
            _item.setQMatchNo(_tmpQMatchNo);
            final String _tmpQMAppCde;
            if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
              _tmpQMAppCde = null;
            } else {
              _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
            }
            _item.setQMAppCde(_tmpQMAppCde);
            final int _tmpCrdtScrx;
            _tmpCrdtScrx = _cursor.getInt(_cursorIndexOfCrdtScrx);
            _item.setCrdtScrx(_tmpCrdtScrx);
            final String _tmpWithCIxx;
            if (_cursor.isNull(_cursorIndexOfWithCIxx)) {
              _tmpWithCIxx = null;
            } else {
              _tmpWithCIxx = _cursor.getString(_cursorIndexOfWithCIxx);
            }
            _item.setWithCIxx(_tmpWithCIxx);
            final double _tmpDownPaym;
            _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
            _item.setDownPaym(_tmpDownPaym);
            final double _tmpDownPayF;
            _tmpDownPayF = _cursor.getDouble(_cursorIndexOfDownPayF);
            _item.setDownPayF(_tmpDownPayF);
            final String _tmpRemarksx;
            if (_cursor.isNull(_cursorIndexOfRemarksx)) {
              _tmpRemarksx = null;
            } else {
              _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
            }
            _item.setRemarksx(_tmpRemarksx);
            final String _tmpReceived;
            if (_cursor.isNull(_cursorIndexOfReceived)) {
              _tmpReceived = null;
            } else {
              _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
            }
            _item.setReceived(_tmpReceived);
            final String _tmpCreatedx;
            if (_cursor.isNull(_cursorIndexOfCreatedx)) {
              _tmpCreatedx = null;
            } else {
              _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
            }
            _item.setCreatedx(_tmpCreatedx);
            final String _tmpDateCreatedx;
            if (_cursor.isNull(_cursorIndexOfDateCreatedx)) {
              _tmpDateCreatedx = null;
            } else {
              _tmpDateCreatedx = _cursor.getString(_cursorIndexOfDateCreatedx);
            }
            _item.setDateCreatedx(_tmpDateCreatedx);
            final String _tmpSendStat;
            if (_cursor.isNull(_cursorIndexOfSendStat)) {
              _tmpSendStat = null;
            } else {
              _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
            }
            _item.setSendStat(_tmpSendStat);
            final String _tmpVerified;
            if (_cursor.isNull(_cursorIndexOfVerified)) {
              _tmpVerified = null;
            } else {
              _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
            }
            _item.setVerified(_tmpVerified);
            final String _tmpDateVerified;
            if (_cursor.isNull(_cursorIndexOfDateVerified)) {
              _tmpDateVerified = null;
            } else {
              _tmpDateVerified = _cursor.getString(_cursorIndexOfDateVerified);
            }
            _item.setDateVerified(_tmpDateVerified);
            final String _tmpModified;
            if (_cursor.isNull(_cursorIndexOfModified)) {
              _tmpModified = null;
            } else {
              _tmpModified = _cursor.getString(_cursorIndexOfModified);
            }
            _item.setModified(_tmpModified);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
            final String _tmpDivision;
            if (_cursor.isNull(_cursorIndexOfDivision)) {
              _tmpDivision = null;
            } else {
              _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
            }
            _item.setDivision(_tmpDivision);
            final String _tmpApplStat;
            if (_cursor.isNull(_cursorIndexOfApplStat)) {
              _tmpApplStat = null;
            } else {
              _tmpApplStat = _cursor.getString(_cursorIndexOfApplStat);
            }
            _item.setApplStat(_tmpApplStat);
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
  public LiveData<List<EBranchLoanApplication>> GetBranchApplications() {
    final String _sql = "SELECT * FROM Credit_Online_Application_List";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application_List"}, false, new Callable<List<EBranchLoanApplication>>() {
      @Override
      public List<EBranchLoanApplication> call() throws Exception {
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
          final List<EBranchLoanApplication> _result = new ArrayList<EBranchLoanApplication>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EBranchLoanApplication _item;
            _item = new EBranchLoanApplication();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpBranchCD;
            if (_cursor.isNull(_cursorIndexOfBranchCD)) {
              _tmpBranchCD = null;
            } else {
              _tmpBranchCD = _cursor.getString(_cursorIndexOfBranchCD);
            }
            _item.setBranchCD(_tmpBranchCD);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpCredInvx;
            if (_cursor.isNull(_cursorIndexOfCredInvx)) {
              _tmpCredInvx = null;
            } else {
              _tmpCredInvx = _cursor.getString(_cursorIndexOfCredInvx);
            }
            _item.setCredInvx(_tmpCredInvx);
            final String _tmpCompnyNm;
            if (_cursor.isNull(_cursorIndexOfCompnyNm)) {
              _tmpCompnyNm = null;
            } else {
              _tmpCompnyNm = _cursor.getString(_cursorIndexOfCompnyNm);
            }
            _item.setCompnyNm(_tmpCompnyNm);
            final String _tmpSpouseNm;
            if (_cursor.isNull(_cursorIndexOfSpouseNm)) {
              _tmpSpouseNm = null;
            } else {
              _tmpSpouseNm = _cursor.getString(_cursorIndexOfSpouseNm);
            }
            _item.setSpouseNm(_tmpSpouseNm);
            final String _tmpAddressx;
            if (_cursor.isNull(_cursorIndexOfAddressx)) {
              _tmpAddressx = null;
            } else {
              _tmpAddressx = _cursor.getString(_cursorIndexOfAddressx);
            }
            _item.setAddressx(_tmpAddressx);
            final String _tmpMobileNo;
            if (_cursor.isNull(_cursorIndexOfMobileNo)) {
              _tmpMobileNo = null;
            } else {
              _tmpMobileNo = _cursor.getString(_cursorIndexOfMobileNo);
            }
            _item.setMobileNo(_tmpMobileNo);
            final String _tmpQMAppCde;
            if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
              _tmpQMAppCde = null;
            } else {
              _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
            }
            _item.setQMAppCde(_tmpQMAppCde);
            final String _tmpModelNme;
            if (_cursor.isNull(_cursorIndexOfModelNme)) {
              _tmpModelNme = null;
            } else {
              _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
            }
            _item.setModelNme(_tmpModelNme);
            final String _tmpDownPaym;
            if (_cursor.isNull(_cursorIndexOfDownPaym)) {
              _tmpDownPaym = null;
            } else {
              _tmpDownPaym = _cursor.getString(_cursorIndexOfDownPaym);
            }
            _item.setDownPaym(_tmpDownPaym);
            final String _tmpAcctTerm;
            if (_cursor.isNull(_cursorIndexOfAcctTerm)) {
              _tmpAcctTerm = null;
            } else {
              _tmpAcctTerm = _cursor.getString(_cursorIndexOfAcctTerm);
            }
            _item.setAcctTerm(_tmpAcctTerm);
            final String _tmpCreatedX;
            if (_cursor.isNull(_cursorIndexOfCreatedX)) {
              _tmpCreatedX = null;
            } else {
              _tmpCreatedX = _cursor.getString(_cursorIndexOfCreatedX);
            }
            _item.setCreatedX(_tmpCreatedX);
            final String _tmpTimeStmp;
            if (_cursor.isNull(_cursorIndexOfTimeStmp)) {
              _tmpTimeStmp = null;
            } else {
              _tmpTimeStmp = _cursor.getString(_cursorIndexOfTimeStmp);
            }
            _item.setTimeStmp(_tmpTimeStmp);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
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
  public EBranchLoanApplication GetBranchApplication(final String args) {
    final String _sql = "SELECT * FROM Credit_Online_Application_List WHERE sTransNox =?";
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

  @Override
  public ECreditApplication getLoanInfoOfTransNox(final String TransNox) {
    final String _sql = "SELECT * FROM Credit_Online_Application WHERE sTransNox =?";
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
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfTargetDt = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetDt");
      final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
      final int _cursorIndexOfGOCASNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNox");
      final int _cursorIndexOfGOCASNoF = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNoF");
      final int _cursorIndexOfUnitAppl = CursorUtil.getColumnIndexOrThrow(_cursor, "cUnitAppl");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
      final int _cursorIndexOfCatInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCatInfox");
      final int _cursorIndexOfDesInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sDesInfox");
      final int _cursorIndexOfQMatchNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMatchNo");
      final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
      final int _cursorIndexOfCrdtScrx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCrdtScrx");
      final int _cursorIndexOfWithCIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithCIxx");
      final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
      final int _cursorIndexOfDownPayF = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPayF");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
      final int _cursorIndexOfDateCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
      final int _cursorIndexOfDateVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfApplStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cApplStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final ECreditApplication _result;
      if(_cursor.moveToFirst()) {
        _result = new ECreditApplication();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _result.setTransNox(_tmpTransNox);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _result.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _result.setTransact(_tmpTransact);
        final String _tmpTargetDt;
        if (_cursor.isNull(_cursorIndexOfTargetDt)) {
          _tmpTargetDt = null;
        } else {
          _tmpTargetDt = _cursor.getString(_cursorIndexOfTargetDt);
        }
        _result.setTargetDt(_tmpTargetDt);
        final String _tmpClientNm;
        if (_cursor.isNull(_cursorIndexOfClientNm)) {
          _tmpClientNm = null;
        } else {
          _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
        }
        _result.setClientNm(_tmpClientNm);
        final String _tmpGOCASNox;
        if (_cursor.isNull(_cursorIndexOfGOCASNox)) {
          _tmpGOCASNox = null;
        } else {
          _tmpGOCASNox = _cursor.getString(_cursorIndexOfGOCASNox);
        }
        _result.setGOCASNox(_tmpGOCASNox);
        final String _tmpGOCASNoF;
        if (_cursor.isNull(_cursorIndexOfGOCASNoF)) {
          _tmpGOCASNoF = null;
        } else {
          _tmpGOCASNoF = _cursor.getString(_cursorIndexOfGOCASNoF);
        }
        _result.setGOCASNoF(_tmpGOCASNoF);
        final String _tmpUnitAppl;
        if (_cursor.isNull(_cursorIndexOfUnitAppl)) {
          _tmpUnitAppl = null;
        } else {
          _tmpUnitAppl = _cursor.getString(_cursorIndexOfUnitAppl);
        }
        _result.setUnitAppl(_tmpUnitAppl);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _result.setSourceCD(_tmpSourceCD);
        final String _tmpDetlInfo;
        if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
          _tmpDetlInfo = null;
        } else {
          _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
        }
        _result.setDetlInfo(_tmpDetlInfo);
        final String _tmpCatInfox;
        if (_cursor.isNull(_cursorIndexOfCatInfox)) {
          _tmpCatInfox = null;
        } else {
          _tmpCatInfox = _cursor.getString(_cursorIndexOfCatInfox);
        }
        _result.setCatInfox(_tmpCatInfox);
        final String _tmpDesInfox;
        if (_cursor.isNull(_cursorIndexOfDesInfox)) {
          _tmpDesInfox = null;
        } else {
          _tmpDesInfox = _cursor.getString(_cursorIndexOfDesInfox);
        }
        _result.setDesInfox(_tmpDesInfox);
        final String _tmpQMatchNo;
        if (_cursor.isNull(_cursorIndexOfQMatchNo)) {
          _tmpQMatchNo = null;
        } else {
          _tmpQMatchNo = _cursor.getString(_cursorIndexOfQMatchNo);
        }
        _result.setQMatchNo(_tmpQMatchNo);
        final String _tmpQMAppCde;
        if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
          _tmpQMAppCde = null;
        } else {
          _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
        }
        _result.setQMAppCde(_tmpQMAppCde);
        final int _tmpCrdtScrx;
        _tmpCrdtScrx = _cursor.getInt(_cursorIndexOfCrdtScrx);
        _result.setCrdtScrx(_tmpCrdtScrx);
        final String _tmpWithCIxx;
        if (_cursor.isNull(_cursorIndexOfWithCIxx)) {
          _tmpWithCIxx = null;
        } else {
          _tmpWithCIxx = _cursor.getString(_cursorIndexOfWithCIxx);
        }
        _result.setWithCIxx(_tmpWithCIxx);
        final double _tmpDownPaym;
        _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
        _result.setDownPaym(_tmpDownPaym);
        final double _tmpDownPayF;
        _tmpDownPayF = _cursor.getDouble(_cursorIndexOfDownPayF);
        _result.setDownPayF(_tmpDownPayF);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _result.setRemarksx(_tmpRemarksx);
        final String _tmpReceived;
        if (_cursor.isNull(_cursorIndexOfReceived)) {
          _tmpReceived = null;
        } else {
          _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
        }
        _result.setReceived(_tmpReceived);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _result.setCreatedx(_tmpCreatedx);
        final String _tmpDateCreatedx;
        if (_cursor.isNull(_cursorIndexOfDateCreatedx)) {
          _tmpDateCreatedx = null;
        } else {
          _tmpDateCreatedx = _cursor.getString(_cursorIndexOfDateCreatedx);
        }
        _result.setDateCreatedx(_tmpDateCreatedx);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _result.setSendStat(_tmpSendStat);
        final String _tmpVerified;
        if (_cursor.isNull(_cursorIndexOfVerified)) {
          _tmpVerified = null;
        } else {
          _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
        }
        _result.setVerified(_tmpVerified);
        final String _tmpDateVerified;
        if (_cursor.isNull(_cursorIndexOfDateVerified)) {
          _tmpDateVerified = null;
        } else {
          _tmpDateVerified = _cursor.getString(_cursorIndexOfDateVerified);
        }
        _result.setDateVerified(_tmpDateVerified);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _result.setModified(_tmpModified);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _result.setTranStat(_tmpTranStat);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _result.setDivision(_tmpDivision);
        final String _tmpApplStat;
        if (_cursor.isNull(_cursorIndexOfApplStat)) {
          _tmpApplStat = null;
        } else {
          _tmpApplStat = _cursor.getString(_cursorIndexOfApplStat);
        }
        _result.setApplStat(_tmpApplStat);
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
  public List<ECreditApplication> GetApplicationsForUpload() {
    final String _sql = "SELECT * FROM Credit_Online_Application WHERE cSendStat = '0'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfTargetDt = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetDt");
      final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
      final int _cursorIndexOfGOCASNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNox");
      final int _cursorIndexOfGOCASNoF = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNoF");
      final int _cursorIndexOfUnitAppl = CursorUtil.getColumnIndexOrThrow(_cursor, "cUnitAppl");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
      final int _cursorIndexOfCatInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCatInfox");
      final int _cursorIndexOfDesInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sDesInfox");
      final int _cursorIndexOfQMatchNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMatchNo");
      final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
      final int _cursorIndexOfCrdtScrx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCrdtScrx");
      final int _cursorIndexOfWithCIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithCIxx");
      final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
      final int _cursorIndexOfDownPayF = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPayF");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
      final int _cursorIndexOfDateCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
      final int _cursorIndexOfDateVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfApplStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cApplStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<ECreditApplication> _result = new ArrayList<ECreditApplication>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ECreditApplication _item;
        _item = new ECreditApplication();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpTargetDt;
        if (_cursor.isNull(_cursorIndexOfTargetDt)) {
          _tmpTargetDt = null;
        } else {
          _tmpTargetDt = _cursor.getString(_cursorIndexOfTargetDt);
        }
        _item.setTargetDt(_tmpTargetDt);
        final String _tmpClientNm;
        if (_cursor.isNull(_cursorIndexOfClientNm)) {
          _tmpClientNm = null;
        } else {
          _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
        }
        _item.setClientNm(_tmpClientNm);
        final String _tmpGOCASNox;
        if (_cursor.isNull(_cursorIndexOfGOCASNox)) {
          _tmpGOCASNox = null;
        } else {
          _tmpGOCASNox = _cursor.getString(_cursorIndexOfGOCASNox);
        }
        _item.setGOCASNox(_tmpGOCASNox);
        final String _tmpGOCASNoF;
        if (_cursor.isNull(_cursorIndexOfGOCASNoF)) {
          _tmpGOCASNoF = null;
        } else {
          _tmpGOCASNoF = _cursor.getString(_cursorIndexOfGOCASNoF);
        }
        _item.setGOCASNoF(_tmpGOCASNoF);
        final String _tmpUnitAppl;
        if (_cursor.isNull(_cursorIndexOfUnitAppl)) {
          _tmpUnitAppl = null;
        } else {
          _tmpUnitAppl = _cursor.getString(_cursorIndexOfUnitAppl);
        }
        _item.setUnitAppl(_tmpUnitAppl);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _item.setSourceCD(_tmpSourceCD);
        final String _tmpDetlInfo;
        if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
          _tmpDetlInfo = null;
        } else {
          _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
        }
        _item.setDetlInfo(_tmpDetlInfo);
        final String _tmpCatInfox;
        if (_cursor.isNull(_cursorIndexOfCatInfox)) {
          _tmpCatInfox = null;
        } else {
          _tmpCatInfox = _cursor.getString(_cursorIndexOfCatInfox);
        }
        _item.setCatInfox(_tmpCatInfox);
        final String _tmpDesInfox;
        if (_cursor.isNull(_cursorIndexOfDesInfox)) {
          _tmpDesInfox = null;
        } else {
          _tmpDesInfox = _cursor.getString(_cursorIndexOfDesInfox);
        }
        _item.setDesInfox(_tmpDesInfox);
        final String _tmpQMatchNo;
        if (_cursor.isNull(_cursorIndexOfQMatchNo)) {
          _tmpQMatchNo = null;
        } else {
          _tmpQMatchNo = _cursor.getString(_cursorIndexOfQMatchNo);
        }
        _item.setQMatchNo(_tmpQMatchNo);
        final String _tmpQMAppCde;
        if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
          _tmpQMAppCde = null;
        } else {
          _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
        }
        _item.setQMAppCde(_tmpQMAppCde);
        final int _tmpCrdtScrx;
        _tmpCrdtScrx = _cursor.getInt(_cursorIndexOfCrdtScrx);
        _item.setCrdtScrx(_tmpCrdtScrx);
        final String _tmpWithCIxx;
        if (_cursor.isNull(_cursorIndexOfWithCIxx)) {
          _tmpWithCIxx = null;
        } else {
          _tmpWithCIxx = _cursor.getString(_cursorIndexOfWithCIxx);
        }
        _item.setWithCIxx(_tmpWithCIxx);
        final double _tmpDownPaym;
        _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
        _item.setDownPaym(_tmpDownPaym);
        final double _tmpDownPayF;
        _tmpDownPayF = _cursor.getDouble(_cursorIndexOfDownPayF);
        _item.setDownPayF(_tmpDownPayF);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpReceived;
        if (_cursor.isNull(_cursorIndexOfReceived)) {
          _tmpReceived = null;
        } else {
          _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
        }
        _item.setReceived(_tmpReceived);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _item.setCreatedx(_tmpCreatedx);
        final String _tmpDateCreatedx;
        if (_cursor.isNull(_cursorIndexOfDateCreatedx)) {
          _tmpDateCreatedx = null;
        } else {
          _tmpDateCreatedx = _cursor.getString(_cursorIndexOfDateCreatedx);
        }
        _item.setDateCreatedx(_tmpDateCreatedx);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpVerified;
        if (_cursor.isNull(_cursorIndexOfVerified)) {
          _tmpVerified = null;
        } else {
          _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
        }
        _item.setVerified(_tmpVerified);
        final String _tmpDateVerified;
        if (_cursor.isNull(_cursorIndexOfDateVerified)) {
          _tmpDateVerified = null;
        } else {
          _tmpDateVerified = _cursor.getString(_cursorIndexOfDateVerified);
        }
        _item.setDateVerified(_tmpDateVerified);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _item.setDivision(_tmpDivision);
        final String _tmpApplStat;
        if (_cursor.isNull(_cursorIndexOfApplStat)) {
          _tmpApplStat = null;
        } else {
          _tmpApplStat = _cursor.getString(_cursorIndexOfApplStat);
        }
        _item.setApplStat(_tmpApplStat);
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
  public List<ECreditApplication> getUnsentLoanApplication() {
    final String _sql = "SELECT * FROM Credit_Online_Application WHERE cSendStat <> '1'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
      final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
      final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
      final int _cursorIndexOfTargetDt = CursorUtil.getColumnIndexOrThrow(_cursor, "dTargetDt");
      final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
      final int _cursorIndexOfGOCASNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNox");
      final int _cursorIndexOfGOCASNoF = CursorUtil.getColumnIndexOrThrow(_cursor, "sGOCASNoF");
      final int _cursorIndexOfUnitAppl = CursorUtil.getColumnIndexOrThrow(_cursor, "cUnitAppl");
      final int _cursorIndexOfSourceCD = CursorUtil.getColumnIndexOrThrow(_cursor, "sSourceCD");
      final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
      final int _cursorIndexOfCatInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sCatInfox");
      final int _cursorIndexOfDesInfox = CursorUtil.getColumnIndexOrThrow(_cursor, "sDesInfox");
      final int _cursorIndexOfQMatchNo = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMatchNo");
      final int _cursorIndexOfQMAppCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sQMAppCde");
      final int _cursorIndexOfCrdtScrx = CursorUtil.getColumnIndexOrThrow(_cursor, "nCrdtScrx");
      final int _cursorIndexOfWithCIxx = CursorUtil.getColumnIndexOrThrow(_cursor, "cWithCIxx");
      final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
      final int _cursorIndexOfDownPayF = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPayF");
      final int _cursorIndexOfRemarksx = CursorUtil.getColumnIndexOrThrow(_cursor, "sRemarksx");
      final int _cursorIndexOfReceived = CursorUtil.getColumnIndexOrThrow(_cursor, "dReceived");
      final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCreatedx");
      final int _cursorIndexOfDateCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
      final int _cursorIndexOfSendStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cSendStat");
      final int _cursorIndexOfVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "sVerified");
      final int _cursorIndexOfDateVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "dVerified");
      final int _cursorIndexOfModified = CursorUtil.getColumnIndexOrThrow(_cursor, "dModified");
      final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
      final int _cursorIndexOfDivision = CursorUtil.getColumnIndexOrThrow(_cursor, "cDivision");
      final int _cursorIndexOfApplStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cApplStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final List<ECreditApplication> _result = new ArrayList<ECreditApplication>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final ECreditApplication _item;
        _item = new ECreditApplication();
        final String _tmpTransNox;
        if (_cursor.isNull(_cursorIndexOfTransNox)) {
          _tmpTransNox = null;
        } else {
          _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
        }
        _item.setTransNox(_tmpTransNox);
        final String _tmpBranchCd;
        if (_cursor.isNull(_cursorIndexOfBranchCd)) {
          _tmpBranchCd = null;
        } else {
          _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
        }
        _item.setBranchCd(_tmpBranchCd);
        final String _tmpTransact;
        if (_cursor.isNull(_cursorIndexOfTransact)) {
          _tmpTransact = null;
        } else {
          _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
        }
        _item.setTransact(_tmpTransact);
        final String _tmpTargetDt;
        if (_cursor.isNull(_cursorIndexOfTargetDt)) {
          _tmpTargetDt = null;
        } else {
          _tmpTargetDt = _cursor.getString(_cursorIndexOfTargetDt);
        }
        _item.setTargetDt(_tmpTargetDt);
        final String _tmpClientNm;
        if (_cursor.isNull(_cursorIndexOfClientNm)) {
          _tmpClientNm = null;
        } else {
          _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
        }
        _item.setClientNm(_tmpClientNm);
        final String _tmpGOCASNox;
        if (_cursor.isNull(_cursorIndexOfGOCASNox)) {
          _tmpGOCASNox = null;
        } else {
          _tmpGOCASNox = _cursor.getString(_cursorIndexOfGOCASNox);
        }
        _item.setGOCASNox(_tmpGOCASNox);
        final String _tmpGOCASNoF;
        if (_cursor.isNull(_cursorIndexOfGOCASNoF)) {
          _tmpGOCASNoF = null;
        } else {
          _tmpGOCASNoF = _cursor.getString(_cursorIndexOfGOCASNoF);
        }
        _item.setGOCASNoF(_tmpGOCASNoF);
        final String _tmpUnitAppl;
        if (_cursor.isNull(_cursorIndexOfUnitAppl)) {
          _tmpUnitAppl = null;
        } else {
          _tmpUnitAppl = _cursor.getString(_cursorIndexOfUnitAppl);
        }
        _item.setUnitAppl(_tmpUnitAppl);
        final String _tmpSourceCD;
        if (_cursor.isNull(_cursorIndexOfSourceCD)) {
          _tmpSourceCD = null;
        } else {
          _tmpSourceCD = _cursor.getString(_cursorIndexOfSourceCD);
        }
        _item.setSourceCD(_tmpSourceCD);
        final String _tmpDetlInfo;
        if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
          _tmpDetlInfo = null;
        } else {
          _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
        }
        _item.setDetlInfo(_tmpDetlInfo);
        final String _tmpCatInfox;
        if (_cursor.isNull(_cursorIndexOfCatInfox)) {
          _tmpCatInfox = null;
        } else {
          _tmpCatInfox = _cursor.getString(_cursorIndexOfCatInfox);
        }
        _item.setCatInfox(_tmpCatInfox);
        final String _tmpDesInfox;
        if (_cursor.isNull(_cursorIndexOfDesInfox)) {
          _tmpDesInfox = null;
        } else {
          _tmpDesInfox = _cursor.getString(_cursorIndexOfDesInfox);
        }
        _item.setDesInfox(_tmpDesInfox);
        final String _tmpQMatchNo;
        if (_cursor.isNull(_cursorIndexOfQMatchNo)) {
          _tmpQMatchNo = null;
        } else {
          _tmpQMatchNo = _cursor.getString(_cursorIndexOfQMatchNo);
        }
        _item.setQMatchNo(_tmpQMatchNo);
        final String _tmpQMAppCde;
        if (_cursor.isNull(_cursorIndexOfQMAppCde)) {
          _tmpQMAppCde = null;
        } else {
          _tmpQMAppCde = _cursor.getString(_cursorIndexOfQMAppCde);
        }
        _item.setQMAppCde(_tmpQMAppCde);
        final int _tmpCrdtScrx;
        _tmpCrdtScrx = _cursor.getInt(_cursorIndexOfCrdtScrx);
        _item.setCrdtScrx(_tmpCrdtScrx);
        final String _tmpWithCIxx;
        if (_cursor.isNull(_cursorIndexOfWithCIxx)) {
          _tmpWithCIxx = null;
        } else {
          _tmpWithCIxx = _cursor.getString(_cursorIndexOfWithCIxx);
        }
        _item.setWithCIxx(_tmpWithCIxx);
        final double _tmpDownPaym;
        _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
        _item.setDownPaym(_tmpDownPaym);
        final double _tmpDownPayF;
        _tmpDownPayF = _cursor.getDouble(_cursorIndexOfDownPayF);
        _item.setDownPayF(_tmpDownPayF);
        final String _tmpRemarksx;
        if (_cursor.isNull(_cursorIndexOfRemarksx)) {
          _tmpRemarksx = null;
        } else {
          _tmpRemarksx = _cursor.getString(_cursorIndexOfRemarksx);
        }
        _item.setRemarksx(_tmpRemarksx);
        final String _tmpReceived;
        if (_cursor.isNull(_cursorIndexOfReceived)) {
          _tmpReceived = null;
        } else {
          _tmpReceived = _cursor.getString(_cursorIndexOfReceived);
        }
        _item.setReceived(_tmpReceived);
        final String _tmpCreatedx;
        if (_cursor.isNull(_cursorIndexOfCreatedx)) {
          _tmpCreatedx = null;
        } else {
          _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
        }
        _item.setCreatedx(_tmpCreatedx);
        final String _tmpDateCreatedx;
        if (_cursor.isNull(_cursorIndexOfDateCreatedx)) {
          _tmpDateCreatedx = null;
        } else {
          _tmpDateCreatedx = _cursor.getString(_cursorIndexOfDateCreatedx);
        }
        _item.setDateCreatedx(_tmpDateCreatedx);
        final String _tmpSendStat;
        if (_cursor.isNull(_cursorIndexOfSendStat)) {
          _tmpSendStat = null;
        } else {
          _tmpSendStat = _cursor.getString(_cursorIndexOfSendStat);
        }
        _item.setSendStat(_tmpSendStat);
        final String _tmpVerified;
        if (_cursor.isNull(_cursorIndexOfVerified)) {
          _tmpVerified = null;
        } else {
          _tmpVerified = _cursor.getString(_cursorIndexOfVerified);
        }
        _item.setVerified(_tmpVerified);
        final String _tmpDateVerified;
        if (_cursor.isNull(_cursorIndexOfDateVerified)) {
          _tmpDateVerified = null;
        } else {
          _tmpDateVerified = _cursor.getString(_cursorIndexOfDateVerified);
        }
        _item.setDateVerified(_tmpDateVerified);
        final String _tmpModified;
        if (_cursor.isNull(_cursorIndexOfModified)) {
          _tmpModified = null;
        } else {
          _tmpModified = _cursor.getString(_cursorIndexOfModified);
        }
        _item.setModified(_tmpModified);
        final String _tmpTranStat;
        if (_cursor.isNull(_cursorIndexOfTranStat)) {
          _tmpTranStat = null;
        } else {
          _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
        }
        _item.setTranStat(_tmpTranStat);
        final String _tmpDivision;
        if (_cursor.isNull(_cursorIndexOfDivision)) {
          _tmpDivision = null;
        } else {
          _tmpDivision = _cursor.getString(_cursorIndexOfDivision);
        }
        _item.setDivision(_tmpDivision);
        final String _tmpApplStat;
        if (_cursor.isNull(_cursorIndexOfApplStat)) {
          _tmpApplStat = null;
        } else {
          _tmpApplStat = _cursor.getString(_cursorIndexOfApplStat);
        }
        _item.setApplStat(_tmpApplStat);
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
  public LiveData<List<DCreditApplication.ApplicationLog>> getApplicationHistory() {
    final String _sql = "Select a.sGOCASNox, a.sTransNox, b.sBranchNm, a.dCreatedx, a.sDetlInfo, a.sClientNm, a.cWithCIxx, a.cSendStat, a.cTranStat, a.dReceived, a.dVerified From Credit_Online_Application a Left Join Branch_Info b ON a.sBranchCd = b.sBranchCd WHERE a.cTranStat != 4 AND sCreatedx = (SELECT sUserIDxx From User_Info_Master) GROUP BY a.sTransNox ORDER BY a.dCreatedx DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application","Branch_Info","User_Info_Master"}, false, new Callable<List<DCreditApplication.ApplicationLog>>() {
      @Override
      public List<DCreditApplication.ApplicationLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSGOCASNox = 0;
          final int _cursorIndexOfSTransNox = 1;
          final int _cursorIndexOfSBranchNm = 2;
          final int _cursorIndexOfDCreatedx = 3;
          final int _cursorIndexOfSDetlInfo = 4;
          final int _cursorIndexOfSClientNm = 5;
          final int _cursorIndexOfCWithCIxx = 6;
          final int _cursorIndexOfCSendStat = 7;
          final int _cursorIndexOfCTranStat = 8;
          final int _cursorIndexOfDReceived = 9;
          final int _cursorIndexOfDVerified = 10;
          final List<DCreditApplication.ApplicationLog> _result = new ArrayList<DCreditApplication.ApplicationLog>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DCreditApplication.ApplicationLog _item;
            _item = new DCreditApplication.ApplicationLog();
            if (_cursor.isNull(_cursorIndexOfSGOCASNox)) {
              _item.sGOCASNox = null;
            } else {
              _item.sGOCASNox = _cursor.getString(_cursorIndexOfSGOCASNox);
            }
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfDCreatedx)) {
              _item.dCreatedx = null;
            } else {
              _item.dCreatedx = _cursor.getString(_cursorIndexOfDCreatedx);
            }
            if (_cursor.isNull(_cursorIndexOfSDetlInfo)) {
              _item.sDetlInfo = null;
            } else {
              _item.sDetlInfo = _cursor.getString(_cursorIndexOfSDetlInfo);
            }
            if (_cursor.isNull(_cursorIndexOfSClientNm)) {
              _item.sClientNm = null;
            } else {
              _item.sClientNm = _cursor.getString(_cursorIndexOfSClientNm);
            }
            if (_cursor.isNull(_cursorIndexOfCWithCIxx)) {
              _item.cWithCIxx = null;
            } else {
              _item.cWithCIxx = _cursor.getString(_cursorIndexOfCWithCIxx);
            }
            if (_cursor.isNull(_cursorIndexOfCSendStat)) {
              _item.cSendStat = null;
            } else {
              _item.cSendStat = _cursor.getString(_cursorIndexOfCSendStat);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            if (_cursor.isNull(_cursorIndexOfDReceived)) {
              _item.dReceived = null;
            } else {
              _item.dReceived = _cursor.getString(_cursorIndexOfDReceived);
            }
            if (_cursor.isNull(_cursorIndexOfDVerified)) {
              _item.dVerified = null;
            } else {
              _item.dVerified = _cursor.getString(_cursorIndexOfDVerified);
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
  public LiveData<List<ECreditApplicantInfo>> getAllCreditApp() {
    final String _sql = "Select * From Credit_Applicant_Info WHERE cTranStat = 0 GROUP BY sTransNox ";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Applicant_Info"}, false, new Callable<List<ECreditApplicantInfo>>() {
      @Override
      public List<ECreditApplicantInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTransNox = CursorUtil.getColumnIndexOrThrow(_cursor, "sTransNox");
          final int _cursorIndexOfClientNm = CursorUtil.getColumnIndexOrThrow(_cursor, "sClientNm");
          final int _cursorIndexOfDetlInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sDetlInfo");
          final int _cursorIndexOfPurchase = CursorUtil.getColumnIndexOrThrow(_cursor, "sPurchase");
          final int _cursorIndexOfApplInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sApplInfo");
          final int _cursorIndexOfResidnce = CursorUtil.getColumnIndexOrThrow(_cursor, "sResidnce");
          final int _cursorIndexOfSameAddx = CursorUtil.getColumnIndexOrThrow(_cursor, "cSameAddx");
          final int _cursorIndexOfAppMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sAppMeans");
          final int _cursorIndexOfEmplymnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sEmplymnt");
          final int _cursorIndexOfBusnInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sBusnInfo");
          final int _cursorIndexOfFinancex = CursorUtil.getColumnIndexOrThrow(_cursor, "sFinancex");
          final int _cursorIndexOfPensionx = CursorUtil.getColumnIndexOrThrow(_cursor, "sPensionx");
          final int _cursorIndexOfOtherInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sOtherInc");
          final int _cursorIndexOfSpousexx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpousexx");
          final int _cursorIndexOfSpsResdx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsResdx");
          final int _cursorIndexOfSpsMeans = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsMEans");
          final int _cursorIndexOfSpsEmplx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsEmplx");
          final int _cursorIndexOfSpsBusnx = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsBusnx");
          final int _cursorIndexOfSpsPensn = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpsPensn");
          final int _cursorIndexOfSpOthInc = CursorUtil.getColumnIndexOrThrow(_cursor, "sSpOthInc");
          final int _cursorIndexOfDisbrsmt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDisbrsmt");
          final int _cursorIndexOfDependnt = CursorUtil.getColumnIndexOrThrow(_cursor, "sDependnt");
          final int _cursorIndexOfProperty = CursorUtil.getColumnIndexOrThrow(_cursor, "sProperty");
          final int _cursorIndexOfOthrInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "sOthrInfo");
          final int _cursorIndexOfComakerx = CursorUtil.getColumnIndexOrThrow(_cursor, "sComakerx");
          final int _cursorIndexOfCmResidx = CursorUtil.getColumnIndexOrThrow(_cursor, "sCmResidx");
          final int _cursorIndexOfIsSpouse = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsSpouse");
          final int _cursorIndexOfIsComakr = CursorUtil.getColumnIndexOrThrow(_cursor, "cIsComakr");
          final int _cursorIndexOfBranchCd = CursorUtil.getColumnIndexOrThrow(_cursor, "sBranchCd");
          final int _cursorIndexOfAppliedx = CursorUtil.getColumnIndexOrThrow(_cursor, "cAppliedx");
          final int _cursorIndexOfTransact = CursorUtil.getColumnIndexOrThrow(_cursor, "dTransact");
          final int _cursorIndexOfCreatedx = CursorUtil.getColumnIndexOrThrow(_cursor, "dCreatedx");
          final int _cursorIndexOfDownPaym = CursorUtil.getColumnIndexOrThrow(_cursor, "nDownPaym");
          final int _cursorIndexOfTranStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cTranStat");
          final List<ECreditApplicantInfo> _result = new ArrayList<ECreditApplicantInfo>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ECreditApplicantInfo _item;
            _item = new ECreditApplicantInfo();
            final String _tmpTransNox;
            if (_cursor.isNull(_cursorIndexOfTransNox)) {
              _tmpTransNox = null;
            } else {
              _tmpTransNox = _cursor.getString(_cursorIndexOfTransNox);
            }
            _item.setTransNox(_tmpTransNox);
            final String _tmpClientNm;
            if (_cursor.isNull(_cursorIndexOfClientNm)) {
              _tmpClientNm = null;
            } else {
              _tmpClientNm = _cursor.getString(_cursorIndexOfClientNm);
            }
            _item.setClientNm(_tmpClientNm);
            final String _tmpDetlInfo;
            if (_cursor.isNull(_cursorIndexOfDetlInfo)) {
              _tmpDetlInfo = null;
            } else {
              _tmpDetlInfo = _cursor.getString(_cursorIndexOfDetlInfo);
            }
            _item.setDetlInfo(_tmpDetlInfo);
            final String _tmpPurchase;
            if (_cursor.isNull(_cursorIndexOfPurchase)) {
              _tmpPurchase = null;
            } else {
              _tmpPurchase = _cursor.getString(_cursorIndexOfPurchase);
            }
            _item.setPurchase(_tmpPurchase);
            final String _tmpApplInfo;
            if (_cursor.isNull(_cursorIndexOfApplInfo)) {
              _tmpApplInfo = null;
            } else {
              _tmpApplInfo = _cursor.getString(_cursorIndexOfApplInfo);
            }
            _item.setApplInfo(_tmpApplInfo);
            final String _tmpResidnce;
            if (_cursor.isNull(_cursorIndexOfResidnce)) {
              _tmpResidnce = null;
            } else {
              _tmpResidnce = _cursor.getString(_cursorIndexOfResidnce);
            }
            _item.setResidnce(_tmpResidnce);
            final String _tmpSameAddx;
            if (_cursor.isNull(_cursorIndexOfSameAddx)) {
              _tmpSameAddx = null;
            } else {
              _tmpSameAddx = _cursor.getString(_cursorIndexOfSameAddx);
            }
            _item.setSameAddx(_tmpSameAddx);
            final String _tmpAppMeans;
            if (_cursor.isNull(_cursorIndexOfAppMeans)) {
              _tmpAppMeans = null;
            } else {
              _tmpAppMeans = _cursor.getString(_cursorIndexOfAppMeans);
            }
            _item.setAppMeans(_tmpAppMeans);
            final String _tmpEmplymnt;
            if (_cursor.isNull(_cursorIndexOfEmplymnt)) {
              _tmpEmplymnt = null;
            } else {
              _tmpEmplymnt = _cursor.getString(_cursorIndexOfEmplymnt);
            }
            _item.setEmplymnt(_tmpEmplymnt);
            final String _tmpBusnInfo;
            if (_cursor.isNull(_cursorIndexOfBusnInfo)) {
              _tmpBusnInfo = null;
            } else {
              _tmpBusnInfo = _cursor.getString(_cursorIndexOfBusnInfo);
            }
            _item.setBusnInfo(_tmpBusnInfo);
            final String _tmpFinancex;
            if (_cursor.isNull(_cursorIndexOfFinancex)) {
              _tmpFinancex = null;
            } else {
              _tmpFinancex = _cursor.getString(_cursorIndexOfFinancex);
            }
            _item.setFinancex(_tmpFinancex);
            final String _tmpPensionx;
            if (_cursor.isNull(_cursorIndexOfPensionx)) {
              _tmpPensionx = null;
            } else {
              _tmpPensionx = _cursor.getString(_cursorIndexOfPensionx);
            }
            _item.setPensionx(_tmpPensionx);
            final String _tmpOtherInc;
            if (_cursor.isNull(_cursorIndexOfOtherInc)) {
              _tmpOtherInc = null;
            } else {
              _tmpOtherInc = _cursor.getString(_cursorIndexOfOtherInc);
            }
            _item.setOtherInc(_tmpOtherInc);
            final String _tmpSpousexx;
            if (_cursor.isNull(_cursorIndexOfSpousexx)) {
              _tmpSpousexx = null;
            } else {
              _tmpSpousexx = _cursor.getString(_cursorIndexOfSpousexx);
            }
            _item.setSpousexx(_tmpSpousexx);
            final String _tmpSpsResdx;
            if (_cursor.isNull(_cursorIndexOfSpsResdx)) {
              _tmpSpsResdx = null;
            } else {
              _tmpSpsResdx = _cursor.getString(_cursorIndexOfSpsResdx);
            }
            _item.setSpsResdx(_tmpSpsResdx);
            final String _tmpSpsMeans;
            if (_cursor.isNull(_cursorIndexOfSpsMeans)) {
              _tmpSpsMeans = null;
            } else {
              _tmpSpsMeans = _cursor.getString(_cursorIndexOfSpsMeans);
            }
            _item.setSpsMeans(_tmpSpsMeans);
            final String _tmpSpsEmplx;
            if (_cursor.isNull(_cursorIndexOfSpsEmplx)) {
              _tmpSpsEmplx = null;
            } else {
              _tmpSpsEmplx = _cursor.getString(_cursorIndexOfSpsEmplx);
            }
            _item.setSpsEmplx(_tmpSpsEmplx);
            final String _tmpSpsBusnx;
            if (_cursor.isNull(_cursorIndexOfSpsBusnx)) {
              _tmpSpsBusnx = null;
            } else {
              _tmpSpsBusnx = _cursor.getString(_cursorIndexOfSpsBusnx);
            }
            _item.setSpsBusnx(_tmpSpsBusnx);
            final String _tmpSpsPensn;
            if (_cursor.isNull(_cursorIndexOfSpsPensn)) {
              _tmpSpsPensn = null;
            } else {
              _tmpSpsPensn = _cursor.getString(_cursorIndexOfSpsPensn);
            }
            _item.setSpsPensn(_tmpSpsPensn);
            final String _tmpSpOthInc;
            if (_cursor.isNull(_cursorIndexOfSpOthInc)) {
              _tmpSpOthInc = null;
            } else {
              _tmpSpOthInc = _cursor.getString(_cursorIndexOfSpOthInc);
            }
            _item.setSpOthInc(_tmpSpOthInc);
            final String _tmpDisbrsmt;
            if (_cursor.isNull(_cursorIndexOfDisbrsmt)) {
              _tmpDisbrsmt = null;
            } else {
              _tmpDisbrsmt = _cursor.getString(_cursorIndexOfDisbrsmt);
            }
            _item.setDisbrsmt(_tmpDisbrsmt);
            final String _tmpDependnt;
            if (_cursor.isNull(_cursorIndexOfDependnt)) {
              _tmpDependnt = null;
            } else {
              _tmpDependnt = _cursor.getString(_cursorIndexOfDependnt);
            }
            _item.setDependnt(_tmpDependnt);
            final String _tmpProperty;
            if (_cursor.isNull(_cursorIndexOfProperty)) {
              _tmpProperty = null;
            } else {
              _tmpProperty = _cursor.getString(_cursorIndexOfProperty);
            }
            _item.setProperty(_tmpProperty);
            final String _tmpOthrInfo;
            if (_cursor.isNull(_cursorIndexOfOthrInfo)) {
              _tmpOthrInfo = null;
            } else {
              _tmpOthrInfo = _cursor.getString(_cursorIndexOfOthrInfo);
            }
            _item.setOthrInfo(_tmpOthrInfo);
            final String _tmpComakerx;
            if (_cursor.isNull(_cursorIndexOfComakerx)) {
              _tmpComakerx = null;
            } else {
              _tmpComakerx = _cursor.getString(_cursorIndexOfComakerx);
            }
            _item.setComakerx(_tmpComakerx);
            final String _tmpCmResidx;
            if (_cursor.isNull(_cursorIndexOfCmResidx)) {
              _tmpCmResidx = null;
            } else {
              _tmpCmResidx = _cursor.getString(_cursorIndexOfCmResidx);
            }
            _item.setCmResidx(_tmpCmResidx);
            final String _tmpIsSpouse;
            if (_cursor.isNull(_cursorIndexOfIsSpouse)) {
              _tmpIsSpouse = null;
            } else {
              _tmpIsSpouse = _cursor.getString(_cursorIndexOfIsSpouse);
            }
            _item.setIsSpouse(_tmpIsSpouse);
            final String _tmpIsComakr;
            if (_cursor.isNull(_cursorIndexOfIsComakr)) {
              _tmpIsComakr = null;
            } else {
              _tmpIsComakr = _cursor.getString(_cursorIndexOfIsComakr);
            }
            _item.setIsComakr(_tmpIsComakr);
            final String _tmpBranchCd;
            if (_cursor.isNull(_cursorIndexOfBranchCd)) {
              _tmpBranchCd = null;
            } else {
              _tmpBranchCd = _cursor.getString(_cursorIndexOfBranchCd);
            }
            _item.setBranchCd(_tmpBranchCd);
            final String _tmpAppliedx;
            if (_cursor.isNull(_cursorIndexOfAppliedx)) {
              _tmpAppliedx = null;
            } else {
              _tmpAppliedx = _cursor.getString(_cursorIndexOfAppliedx);
            }
            _item.setAppliedx(_tmpAppliedx);
            final String _tmpTransact;
            if (_cursor.isNull(_cursorIndexOfTransact)) {
              _tmpTransact = null;
            } else {
              _tmpTransact = _cursor.getString(_cursorIndexOfTransact);
            }
            _item.setTransact(_tmpTransact);
            final String _tmpCreatedx;
            if (_cursor.isNull(_cursorIndexOfCreatedx)) {
              _tmpCreatedx = null;
            } else {
              _tmpCreatedx = _cursor.getString(_cursorIndexOfCreatedx);
            }
            _item.setCreatedx(_tmpCreatedx);
            final double _tmpDownPaym;
            _tmpDownPaym = _cursor.getDouble(_cursorIndexOfDownPaym);
            _item.setDownPaym(_tmpDownPaym);
            final String _tmpTranStat;
            if (_cursor.isNull(_cursorIndexOfTranStat)) {
              _tmpTranStat = null;
            } else {
              _tmpTranStat = _cursor.getString(_cursorIndexOfTranStat);
            }
            _item.setTranStat(_tmpTranStat);
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
  public String GetUserID() {
    final String _sql = "SELECT sUserIDxx FROM User_Info_Master";
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
  public LiveData<List<DCreditApplication.ApplicationLog>> getApplicationByBranch(
      final String BranchID) {
    final String _sql = "SELECT a.sGOCASNox,a.sTransNox,b.sBranchNm,a.dCreatedx,a.sDetlInfo,a.sClientNm,a.cWithCIxx,a.cSendStat,a.cTranStat,a.dReceived,a.dVerified FROM Credit_Online_Application a LEFT JOIN Branch_Info b ON a.sBranchCd = b.sBranchCd WHERE cTranStat != 4 AND a.sBranchCd =? AND sCreatedx = (SELECT sUserIDxx From User_Info_Master) ORDER BY a.dCreatedx DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BranchID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BranchID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Credit_Online_Application","Branch_Info","User_Info_Master"}, false, new Callable<List<DCreditApplication.ApplicationLog>>() {
      @Override
      public List<DCreditApplication.ApplicationLog> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSGOCASNox = 0;
          final int _cursorIndexOfSTransNox = 1;
          final int _cursorIndexOfSBranchNm = 2;
          final int _cursorIndexOfDCreatedx = 3;
          final int _cursorIndexOfSDetlInfo = 4;
          final int _cursorIndexOfSClientNm = 5;
          final int _cursorIndexOfCWithCIxx = 6;
          final int _cursorIndexOfCSendStat = 7;
          final int _cursorIndexOfCTranStat = 8;
          final int _cursorIndexOfDReceived = 9;
          final int _cursorIndexOfDVerified = 10;
          final List<DCreditApplication.ApplicationLog> _result = new ArrayList<DCreditApplication.ApplicationLog>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final DCreditApplication.ApplicationLog _item;
            _item = new DCreditApplication.ApplicationLog();
            if (_cursor.isNull(_cursorIndexOfSGOCASNox)) {
              _item.sGOCASNox = null;
            } else {
              _item.sGOCASNox = _cursor.getString(_cursorIndexOfSGOCASNox);
            }
            if (_cursor.isNull(_cursorIndexOfSTransNox)) {
              _item.sTransNox = null;
            } else {
              _item.sTransNox = _cursor.getString(_cursorIndexOfSTransNox);
            }
            if (_cursor.isNull(_cursorIndexOfSBranchNm)) {
              _item.sBranchNm = null;
            } else {
              _item.sBranchNm = _cursor.getString(_cursorIndexOfSBranchNm);
            }
            if (_cursor.isNull(_cursorIndexOfDCreatedx)) {
              _item.dCreatedx = null;
            } else {
              _item.dCreatedx = _cursor.getString(_cursorIndexOfDCreatedx);
            }
            if (_cursor.isNull(_cursorIndexOfSDetlInfo)) {
              _item.sDetlInfo = null;
            } else {
              _item.sDetlInfo = _cursor.getString(_cursorIndexOfSDetlInfo);
            }
            if (_cursor.isNull(_cursorIndexOfSClientNm)) {
              _item.sClientNm = null;
            } else {
              _item.sClientNm = _cursor.getString(_cursorIndexOfSClientNm);
            }
            if (_cursor.isNull(_cursorIndexOfCWithCIxx)) {
              _item.cWithCIxx = null;
            } else {
              _item.cWithCIxx = _cursor.getString(_cursorIndexOfCWithCIxx);
            }
            if (_cursor.isNull(_cursorIndexOfCSendStat)) {
              _item.cSendStat = null;
            } else {
              _item.cSendStat = _cursor.getString(_cursorIndexOfCSendStat);
            }
            if (_cursor.isNull(_cursorIndexOfCTranStat)) {
              _item.cTranStat = null;
            } else {
              _item.cTranStat = _cursor.getString(_cursorIndexOfCTranStat);
            }
            if (_cursor.isNull(_cursorIndexOfDReceived)) {
              _item.dReceived = null;
            } else {
              _item.dReceived = _cursor.getString(_cursorIndexOfDReceived);
            }
            if (_cursor.isNull(_cursorIndexOfDVerified)) {
              _item.dVerified = null;
            } else {
              _item.dVerified = _cursor.getString(_cursorIndexOfDVerified);
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
