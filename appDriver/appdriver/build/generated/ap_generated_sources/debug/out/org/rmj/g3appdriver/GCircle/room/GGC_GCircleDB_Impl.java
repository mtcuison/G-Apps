package org.rmj.g3appdriver.GCircle.room;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DAddressRequest;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DAddressRequest_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DAddressUpdate;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DAddressUpdate_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DAppConfig;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DAppConfig_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DApprovalCode;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DApprovalCode_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DAreaPerformance;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DAreaPerformance_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBankInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBankInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBarangayInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBarangayInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBranchInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBranchInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBranchLoanApplication;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBranchLoanApplication_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBranchOpeningMonitor;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBranchOpeningMonitor_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBranchPerformance;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DBranchPerformance_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCIEvaluation;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCIEvaluation_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCashCount;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCashCount_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DClientInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DClientUpdate;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DClientUpdate_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCountryInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCountryInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCreditApplicantInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCreditApplicantInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCreditApplication;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCreditApplicationDocuments;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCreditApplicationDocuments_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCreditApplication_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCreditOnlineApplicationCI;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DCreditOnlineApplicationCI_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DDCPCollectionDetail;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DDCPCollectionDetail_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DDCPCollectionMaster;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DDCPCollectionMaster_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DDCP_Remittance;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DDCP_Remittance_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DEmployeeBusinessTrip;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DEmployeeBusinessTrip_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DEmployeeInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DEmployeeInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DEmployeeLeave;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DEmployeeLeave_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DEmployeeRole;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DEmployeeRole_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DFileCode;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DFileCode_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DGanadoOnline;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DGanadoOnline_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DImageInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DImageInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DInventoryDao;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DInventoryDao_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DInventoryDetail;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DInventoryDetail_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DInventoryMaster;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DInventoryMaster_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DItinerary;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DItinerary_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DLRDcp;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DLRDcp_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DLocatorSysLog;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DLocatorSysLog_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMcBrand;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMcBrand_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMcCategory;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMcCategory_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMcModel;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMcModelPrice;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMcModelPrice_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMcModel_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMcTermCategory;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMcTermCategory_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMessages;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMessages_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMobileRequest;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMobileRequest_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMobileUpdate;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DMobileUpdate_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNNDMRequest;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNNDMRequest_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNotification;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNotificationDetail;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNotificationDetail_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNotificationMaster;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNotificationMaster_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNotificationReceiver;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNotificationReceiver_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNotificationUser;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNotificationUser_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DNotification_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DOccupationInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DOccupationInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DPacita;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DPacita_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DPanalo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DPanalo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DPayslip;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DPayslip_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DProvinceInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DProvinceInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DRaffleInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DRaffleInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DRaffleStatus;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DRaffleStatus_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DRawDao;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DRawDao_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DRelation;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DRelation_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DRemittanceAccounts;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DRemittanceAccounts_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DSelfieLog;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DSelfieLog_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DSysConfig;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DSysConfig_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DToken;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DToken_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DTownInfo;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DTownInfo_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DUncapturedClient;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DUncapturedClient_Impl;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DevTool;
import org.rmj.g3appdriver.GCircle.room.DataAccessObject.DevTool_Impl;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GGC_GCircleDB_Impl extends GGC_GCircleDB {
  private volatile DEmployeeInfo _dEmployeeInfo;

  private volatile DFileCode _dFileCode;

  private volatile DClientInfo _dClientInfo;

  private volatile DBarangayInfo _dBarangayInfo;

  private volatile DTownInfo _dTownInfo;

  private volatile DProvinceInfo _dProvinceInfo;

  private volatile DCountryInfo _dCountryInfo;

  private volatile DMcCategory _dMcCategory;

  private volatile DMcTermCategory _dMcTermCategory;

  private volatile DMcBrand _dMcBrand;

  private volatile DMcModel _dMcModel;

  private volatile DMcModelPrice _dMcModelPrice;

  private volatile DBranchInfo _dBranchInfo;

  private volatile DOccupationInfo _dOccupationInfo;

  private volatile DCreditApplication _dCreditApplication;

  private volatile DCreditApplicantInfo _dCreditApplicantInfo;

  private volatile DAreaPerformance _dAreaPerformance;

  private volatile DBranchPerformance _dBranchPerformance;

  private volatile DRawDao _dRawDao;

  private volatile DRaffleInfo _dRaffleInfo;

  private volatile DNotificationReceiver _dNotificationReceiver;

  private volatile DApprovalCode _dApprovalCode;

  private volatile DLRDcp _dLRDcp;

  private volatile DDCPCollectionMaster _dDCPCollectionMaster;

  private volatile DDCPCollectionDetail _dDCPCollectionDetail;

  private volatile DAddressRequest _dAddressRequest;

  private volatile DAddressUpdate _dAddressUpdate;

  private volatile DMobileUpdate _dMobileUpdate;

  private volatile DMobileRequest _dMobileRequest;

  private volatile DImageInfo _dImageInfo;

  private volatile DCreditApplicationDocuments _dCreditApplicationDocuments;

  private volatile DClientUpdate _dClientUpdate;

  private volatile DBankInfo _dBankInfo;

  private volatile DSelfieLog _dSelfieLog;

  private volatile DInventoryDao _dInventoryDao;

  private volatile DBranchLoanApplication _dBranchLoanApplication;

  private volatile DUncapturedClient _dUncapturedClient;

  private volatile DCIEvaluation _dCIEvaluation;

  private volatile DRelation _dRelation;

  private volatile DDCP_Remittance _dDCPRemittance;

  private volatile DRemittanceAccounts _dRemittanceAccounts;

  private volatile DSysConfig _dSysConfig;

  private volatile DLocatorSysLog _dLocatorSysLog;

  private volatile DNNDMRequest _dNNDMRequest;

  private volatile DAppConfig _dAppConfig;

  private volatile DCashCount _dCashCount;

  private volatile DBranchOpeningMonitor _dBranchOpeningMonitor;

  private volatile DEmployeeLeave _dEmployeeLeave;

  private volatile DEmployeeBusinessTrip _dEmployeeBusinessTrip;

  private volatile DEmployeeRole _dEmployeeRole;

  private volatile DInventoryMaster _dInventoryMaster;

  private volatile DInventoryDetail _dInventoryDetail;

  private volatile DCreditOnlineApplicationCI _dCreditOnlineApplicationCI;

  private volatile DItinerary _dItinerary;

  private volatile DToken _dToken;

  private volatile DevTool _devTool;

  private volatile DNotificationMaster _dNotificationMaster;

  private volatile DNotificationDetail _dNotificationDetail;

  private volatile DNotificationUser _dNotificationUser;

  private volatile DPanalo _dPanalo;

  private volatile DPayslip _dPayslip;

  private volatile DRaffleStatus _dRaffleStatus;

  private volatile DMessages _dMessages;

  private volatile DNotification _dNotification;

  private volatile DPacita _dPacita;

  private volatile DGanadoOnline _dGanadoOnline;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(39) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Branch_Info` (`sBranchCd` TEXT NOT NULL, `sBranchNm` TEXT, `sDescript` TEXT, `sAddressx` TEXT, `sTownIDxx` TEXT, `sAreaCode` TEXT, `cDivision` TEXT, `cPromoDiv` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sBranchCd`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MC_Brand` (`sBrandIDx` TEXT NOT NULL, `sBrandNme` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sBrandIDx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Mc_Model` (`sModelIDx` TEXT NOT NULL, `sModelCde` TEXT, `sModelNme` TEXT, `sBrandIDx` TEXT, `cMotorTyp` TEXT, `cRegisTyp` TEXT, `cEndOfLfe` TEXT, `cEngineTp` TEXT, `cHotItemx` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sModelIDx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MC_Category` (`sMcCatIDx` TEXT NOT NULL, `sMcCatNme` TEXT, `nMiscChrg` TEXT, `nRebatesx` TEXT, `nEndMrtgg` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sMcCatIDx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Province_Info` (`sProvIDxx` TEXT NOT NULL, `sProvName` TEXT, `cRecdStat` INTEGER NOT NULL, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sProvIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Mc_Model_Price` (`sModelIDx` TEXT NOT NULL, `nSelPrice` TEXT, `nLastPrce` TEXT, `nDealrPrc` TEXT, `nMinDownx` TEXT, `sMCCatIDx` TEXT, `dPricexxx` TEXT, `dInsPrice` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sModelIDx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MC_Model_Color` (`sModelIDx` TEXT NOT NULL, `sColorIDx` TEXT NOT NULL, `sColorNme` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sModelIDx`, `sColorIDx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Town_Info` (`sTownIDxx` TEXT NOT NULL, `sTownName` TEXT, `sZippCode` TEXT, `sProvIDxx` TEXT, `sProvCode` TEXT, `sMuncplCd` TEXT, `cHasRoute` TEXT, `cBlackLst` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTownIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Barangay_Info` (`sBrgyIDxx` TEXT NOT NULL, `sBrgyName` TEXT, `sTownIDxx` TEXT, `cHasRoute` TEXT, `cBlackLst` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sBrgyIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MC_Term_Category` (`sMCCatIDx` TEXT NOT NULL, `nAcctTerm` TEXT NOT NULL, `nAcctThru` TEXT, `nFactorRt` TEXT, `dPricexxx` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sMCCatIDx`, `nAcctTerm`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Country_Info` (`sCntryCde` TEXT NOT NULL, `sCntryNme` TEXT, `sNational` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sCntryCde`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Occupation_Info` (`sOccptnID` TEXT NOT NULL, `sOccptnNm` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sOccptnID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Credit_Online_Application` (`sTransNox` TEXT NOT NULL, `sBranchCd` TEXT, `dTransact` TEXT, `dTargetDt` TEXT, `sClientNm` TEXT, `sGOCASNox` TEXT, `sGOCASNoF` TEXT, `cUnitAppl` TEXT, `sSourceCD` TEXT, `sDetlInfo` TEXT, `sCatInfox` TEXT, `sDesInfox` TEXT, `sQMatchNo` TEXT, `sQMAppCde` TEXT, `nCrdtScrx` INTEGER NOT NULL, `cWithCIxx` TEXT, `nDownPaym` REAL NOT NULL, `nDownPayF` REAL NOT NULL, `sRemarksx` TEXT, `dReceived` TEXT, `sCreatedx` TEXT, `dCreatedx` TEXT, `cSendStat` TEXT, `sVerified` TEXT, `dVerified` TEXT, `dModified` TEXT, `cTranStat` TEXT, `cDivision` TEXT, `cApplStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Credit_Applicant_Info` (`sTransNox` TEXT NOT NULL, `sClientNm` TEXT, `sDetlInfo` TEXT, `sPurchase` TEXT, `sApplInfo` TEXT, `sResidnce` TEXT, `cSameAddx` TEXT, `sAppMeans` TEXT, `sEmplymnt` TEXT, `sBusnInfo` TEXT, `sFinancex` TEXT, `sPensionx` TEXT, `sOtherInc` TEXT, `sSpousexx` TEXT, `sSpsResdx` TEXT, `sSpsMEans` TEXT, `sSpsEmplx` TEXT, `sSpsBusnx` TEXT, `sSpsPensn` TEXT, `sSpOthInc` TEXT, `sDisbrsmt` TEXT, `sDependnt` TEXT, `sProperty` TEXT, `sOthrInfo` TEXT, `sComakerx` TEXT, `sCmResidx` TEXT, `cIsSpouse` TEXT, `cIsComakr` TEXT, `sBranchCd` TEXT, `cAppliedx` TEXT, `dTransact` TEXT, `dCreatedx` TEXT, `nDownPaym` REAL NOT NULL, `cTranStat` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MC_Area_Performance` (`sAreaCode` TEXT NOT NULL, `sAreaDesc` TEXT, `sPeriodxx` TEXT NOT NULL, `nMCGoalxx` INTEGER NOT NULL, `nSPGoalxx` REAL NOT NULL, `nJOGoalxx` INTEGER NOT NULL, `nLRGoalxx` REAL NOT NULL, `nMCActual` INTEGER NOT NULL, `nSPActual` REAL NOT NULL, `nJOActual` REAL NOT NULL, `nLRActual` REAL NOT NULL, PRIMARY KEY(`sAreaCode`, `sPeriodxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MC_Branch_Performance` (`sBranchCd` TEXT NOT NULL, `sPeriodxx` TEXT NOT NULL, `sBranchNm` TEXT, `nMCGoalxx` INTEGER NOT NULL, `nSPGoalxx` REAL NOT NULL, `nJOGoalxx` INTEGER NOT NULL, `nLRGoalxx` REAL NOT NULL, `nMCActual` INTEGER NOT NULL, `nSPActual` REAL NOT NULL, `nJOActual` REAL NOT NULL, `nLRActual` REAL NOT NULL, PRIMARY KEY(`sBranchCd`, `sPeriodxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `FB_Raffle_Transaction_Basis` (`sDivision` TEXT NOT NULL, `sTableNme` TEXT NOT NULL, `sReferCde` TEXT NOT NULL, `sReferNme` TEXT, `cCltInfox` TEXT, `cRecdStat` TEXT, `dModified` TEXT, PRIMARY KEY(`sDivision`, `sTableNme`, `sReferCde`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PromoLocal_Detail` (`sBranchCd` TEXT NOT NULL, `dTransact` TEXT NOT NULL, `sClientNm` TEXT, `sAddressx` TEXT, `sTownIDxx` TEXT, `sProvIDxx` TEXT, `sDocTypex` TEXT, `sDocNoxxx` TEXT, `sMobileNo` TEXT, `cSendStat` INTEGER NOT NULL, `sTimeStmp` TEXT, PRIMARY KEY(`sBranchCd`, `dTransact`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Notification_Info_Master` (`sTransNox` TEXT NOT NULL, `sMesgIDxx` TEXT, `sParentxx` TEXT, `dCreatedx` TEXT, `sAppSrcex` TEXT, `sCreatrID` TEXT, `sCreatrNm` TEXT, `sMsgTitle` TEXT, `sMessagex` TEXT, `sURLxxxxx` TEXT, `sDataSndx` TEXT, `sMsgTypex` TEXT, `cSentxxxx` TEXT, `dSentxxxx` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Notification_Info_Recepient` (`sTransNox` TEXT NOT NULL, `sAppRcptx` TEXT, `sRecpntID` TEXT, `sRecpntNm` TEXT, `sGroupIDx` TEXT, `sGroupNmx` TEXT, `cMonitorx` TEXT, `cMesgStat` TEXT, `cStatSent` TEXT, `dSentxxxx` TEXT, `dReceived` TEXT, `dReadxxxx` TEXT, `dLastUpdt` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Notification_User` (`sUserIDxx` TEXT NOT NULL, `sUserName` TEXT, PRIMARY KEY(`sUserIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `System_Code_Approval` (`sTransNox` TEXT NOT NULL, `dTransact` TEXT, `sSystemCD` TEXT, `sReqstdBy` TEXT, `dReqstdxx` TEXT, `cIssuedBy` TEXT, `sMiscInfo` TEXT, `sRemarks1` TEXT, `sRemarks2` TEXT, `sApprCode` TEXT, `sEntryByx` TEXT, `sApprvByx` TEXT, `sReasonxx` TEXT, `sReqstdTo` TEXT, `cSendxxxx` TEXT, `cTranStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `xxxSCA_Request` (`sSCACodex` TEXT NOT NULL, `sSCATitle` TEXT, `sSCADescx` TEXT, `cSCATypex` TEXT, `cAreaHead` TEXT, `cHCMDeptx` TEXT, `cCSSDeptx` TEXT, `cComplnce` TEXT, `cMktgDept` TEXT, `cASMDeptx` TEXT, `cTLMDeptx` TEXT, `cSCMDeptx` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sSCACodex`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `LR_DCP_Collection_Master` (`sTransNox` TEXT NOT NULL, `dTransact` TEXT, `sReferNox` TEXT, `xCollName` TEXT, `sRouteNme` TEXT, `dReferDte` TEXT, `cTranStat` TEXT, `cDCPTypex` TEXT, `nEntryNox` TEXT, `sBranchNm` TEXT, `sCollctID` TEXT, `cSendStat` TEXT, `dSendDate` TEXT, `dModified` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `LR_DCP_Collection_Detail` (`sTransNox` TEXT NOT NULL, `nEntryNox` INTEGER NOT NULL, `sAcctNmbr` TEXT, `xFullName` TEXT, `sPRNoxxxx` TEXT, `nTranAmtx` REAL, `nDiscount` REAL, `nOthersxx` REAL, `sRemarksx` TEXT, `sBankIDxx` TEXT, `sCheckDte` TEXT, `sCheckNox` TEXT, `sCheckAct` TEXT, `dPromised` TEXT, `sRemCodex` TEXT, `cTranType` TEXT, `nTranTotl` REAL, `sReferNox` TEXT, `cPaymForm` TEXT, `cIsDCPxxx` TEXT, `sMobileNo` TEXT, `sHouseNox` TEXT, `sAddressx` TEXT, `sBrgyName` TEXT, `sTownName` TEXT, `dPurchase` TEXT, `nMonAmort` REAL, `nAmtDuexx` REAL, `cApntUnit` TEXT, `sBranchCd` TEXT, `dDueDatex` TEXT, `sImageNme` TEXT, `nLongitud` REAL, `nLatitude` REAL, `sClientID` TEXT, `sSerialID` TEXT, `sSerialNo` TEXT, `nLastPaym` REAL, `dLastPaym` TEXT, `nABalance` TEXT, `nDelayAvg` REAL, `cTranStat` TEXT, `cSendStat` TEXT, `dSendDate` TEXT, `dModified` TEXT, PRIMARY KEY(`sTransNox`, `nEntryNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Address_Update_Request` (`sTransNox` TEXT NOT NULL, `sClientID` TEXT, `cReqstCDe` TEXT, `cAddrssTp` TEXT, `sHouseNox` TEXT, `sAddressx` TEXT, `sTownIDxx` TEXT, `sBrgyIDxx` TEXT, `cPrimaryx` TEXT, `nLatitude` TEXT, `nLongitud` TEXT, `sRemarksx` TEXT, `cTranStat` TEXT, `cSendStat` TEXT, `dSendDate` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Mobile_Update_Request` (`sTransNox` TEXT NOT NULL, `sClientID` TEXT, `cReqstCDe` TEXT, `sMobileNo` TEXT, `cPrimaryx` TEXT, `sRemarksx` TEXT, `cTranStat` TEXT, `cSendStat` TEXT, `dSendDate` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Image_Information` (`sTransNox` TEXT NOT NULL, `sSourceCD` TEXT, `sSourceNo` TEXT, `sDtlSrcNo` TEXT, `sFileCode` TEXT, `sImageNme` TEXT, `sMD5Hashx` TEXT, `sFileLoct` TEXT, `nLatitude` TEXT, `nLongitud` TEXT, `dCaptured` TEXT, `cSendStat` TEXT, `dSendDate` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `User_Info_Master` (`sClientID` TEXT NOT NULL, `sBranchCD` TEXT, `sBranchNm` TEXT, `sLogNoxxx` TEXT, `sUserIDxx` TEXT, `sEmailAdd` TEXT, `sUserName` TEXT, `nUserLevl` TEXT, `sDeptIDxx` TEXT, `sPositnID` TEXT, `sEmpLevID` INTEGER, `cSlfieLog` TEXT, `cAllowUpd` TEXT, `dLoginxxx` TEXT, `sMobileNo` TEXT, `dSessionx` TEXT, `sEmployID` TEXT, `cPrivatex` TEXT, `sDeviceID` TEXT, `sModelIDx` TEXT, PRIMARY KEY(`sClientID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `EDocSys_File` (`sFileCode` TEXT NOT NULL, `sBarrcode` TEXT, `sBriefDsc` TEXT, `cRecdStat` TEXT, `nEntryNox` INTEGER NOT NULL, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sFileCode`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Client_Info_Master` (`sUserIDxx` TEXT NOT NULL, `sEmailAdd` TEXT, `sUserName` TEXT, `dLoginxxx` TEXT, `sMobileNo` TEXT, `dDateMmbr` TEXT, PRIMARY KEY(`sUserIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `App_Token_Info` (`sTokenIDx` TEXT NOT NULL, `sTokenInf` TEXT, `sDescript` TEXT, `sTokenTpe` TEXT, `dGeneratd` TEXT, `dExpirexx` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTokenIDx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Credit_Online_Application_Documents` (`sTransNox` TEXT NOT NULL, `sFileCode` TEXT NOT NULL, `nEntryNox` INTEGER NOT NULL, `sImageNme` TEXT, `sImageIDx` TEXT, `sFileLoct` TEXT, `cSendStat` TEXT, PRIMARY KEY(`sTransNox`, `sFileCode`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Client_Update_Request` (`sClientID` TEXT NOT NULL, `sSourceCd` TEXT, `sSourceNo` TEXT, `sDtlSrcNo` TEXT, `sLastName` TEXT, `sFrstName` TEXT, `sMiddName` TEXT, `sSuffixNm` TEXT, `sHouseNox` TEXT, `sAddressx` TEXT, `sBarangay` TEXT, `sTownIDxx` TEXT, `cGenderxx` TEXT, `cCivlStat` TEXT, `dBirthDte` TEXT, `dBirthPlc` TEXT, `sLandline` TEXT, `sMobileNo` TEXT, `sEmailAdd` TEXT, `sImageNme` TEXT, `cSendStat` TEXT, `dModified` TEXT, PRIMARY KEY(`sClientID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Bank_Info` (`sBankIDxx` TEXT NOT NULL, `sBankName` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sBankIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Employee_Log_Selfie` (`sTransNox` TEXT NOT NULL, `sEmployID` TEXT, `sBranchCd` TEXT, `dTransact` TEXT, `dLogTimex` TEXT, `nLatitude` TEXT, `nLongitud` TEXT, `sImageIDx` TEXT, `sRemarksx` TEXT, `cSendStat` TEXT, `dSendDate` TEXT, `cReqCCntx` TEXT, `cReqRSIxx` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Credit_Online_Application_List` (`sTransNox` TEXT NOT NULL, `sBranchCD` TEXT, `dTransact` TEXT, `sCredInvx` TEXT, `sCompnyNm` TEXT, `sSpouseNm` TEXT, `sAddressx` TEXT, `sMobileNo` TEXT, `sQMAppCde` TEXT, `sModelNme` TEXT, `nDownPaym` TEXT, `nAcctTerm` TEXT, `sCreatedx` TEXT, `dTimeStmp` TEXT, `cTranStat` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Uncaptured_Client_Image` (`sTransNox` TEXT NOT NULL, `sClientNm` TEXT, `sSourceNo` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Credit_Online_Application_List_CI` (`sTransNox` TEXT NOT NULL, `sCredInvx` TEXT, `sLandMark` TEXT, `cOwnershp` TEXT, `cOwnOther` TEXT, `cHouseTyp` TEXT, `cGaragexx` TEXT, `nLatitude` TEXT, `nLongitud` TEXT, `cHasOther` TEXT, `cHasRecrd` TEXT, `sRemRecrd` TEXT, `sNeighbr1` TEXT, `sAddress1` TEXT, `sReltnCD1` TEXT, `sMobileN1` TEXT, `cFeedBck1` TEXT, `sFeedBck1` TEXT, `sNeighbr2` TEXT, `sAddress2` TEXT, `sReltnCD2` TEXT, `sMobileN2` TEXT, `cFeedBck2` TEXT, `sFBRemrk2` TEXT, `sNeighbr3` TEXT, `sAddress3` TEXT, `sReltnCD3` TEXT, `sMobileN3` TEXT, `cFeedBck3` TEXT, `sFBRemrk3` TEXT, `nWaterBil` TEXT, `nElctrcBl` TEXT, `nFoodAllw` TEXT, `nLoanAmtx` TEXT, `nEducExpn` TEXT, `nOthrExpn` TEXT, `cGamblerx` TEXT, `cWomanizr` TEXT, `cHvyBrwer` TEXT, `cWithRepo` TEXT, `cWithMort` TEXT, `cArrogant` TEXT, `sOtherBad` TEXT, `sRemarksx` TEXT, `cTranStat` TEXT, `dApproved` TEXT, `dReceived` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `LR_DCP_Remittance` (`sTransNox` TEXT NOT NULL, `nEntryNox` INTEGER NOT NULL, `dTransact` TEXT, `cPaymForm` TEXT, `cRemitTyp` TEXT, `sCompnyNm` TEXT, `sBankAcct` TEXT, `sReferNox` TEXT, `nAmountxx` REAL NOT NULL, `cSendStat` TEXT, `dDateSent` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`, `nEntryNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Collection_Account_Remittance` (`sBranchCd` TEXT NOT NULL, `sActNumbr` TEXT NOT NULL, `sBnkActID` TEXT NOT NULL, `sBranchNm` TEXT, `sActNamex` TEXT, PRIMARY KEY(`sBranchCd`, `sBnkActID`, `sActNumbr`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `xxxSysConfig` (`sConfigCd` TEXT NOT NULL, `sConfigDs` TEXT, `sConfigVl` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sConfigCd`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `GLocator_Sys_log` (`sLoctnIDx` TEXT NOT NULL, `sUserIDxx` TEXT, `sDeviceID` TEXT, `dTransact` TEXT, `nLongitud` REAL, `nLatitude` REAL, `cSendStat` TEXT, `cGpsEnbld` TEXT, `sRemarksx` TEXT, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sLoctnIDx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Relation` (`sRelatnID` TEXT NOT NULL, `sRelatnDs` TEXT, `cRecdStats` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sRelatnID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `NNDM_Event_Request` (`sTransNox` TEXT NOT NULL, `sSourceNo` TEXT, `sSourceCD` TEXT, `sReqstTyp` TEXT, `sJsonData` TEXT, `cTranStat` TEXT, `dCreatedx` TEXT, `dReceived` TEXT, `dPostedxx` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `xxxAppConfig` (`sConfigCd` TEXT NOT NULL, `sConfigDs` TEXT, `sConfigVl` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sConfigCd`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Cash_Count_Master` (`sTransNox` TEXT NOT NULL, `sBranchCd` TEXT, `dTransact` TEXT, `nCn0001cx` INTEGER, `nCn0005cx` INTEGER, `nCn0010cx` INTEGER, `nCn0025cx` INTEGER, `nCn0050cx` INTEGER, `nCn0001px` INTEGER, `nCn0005px` INTEGER, `nCn0010px` INTEGER, `nNte0020p` INTEGER, `nNte0050p` INTEGER, `nNte0100p` INTEGER, `nNte0200p` INTEGER, `nNte0500p` INTEGER, `nNte1000p` INTEGER, `sPettyAmt` REAL, `sORNoxxxx` TEXT, `sSINoxxxx` TEXT, `sPRNoxxxx` TEXT, `sCRNoxxxx` TEXT, `sORNoxNPt` TEXT, `sPRNoxNPt` TEXT, `sDRNoxxxx` TEXT, `dEntryDte` TEXT, `sReqstdBy` TEXT, `sRemarksx` TEXT, `dModified` TEXT, `sSendStat` INTEGER, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Branch_Opening` (`sBranchCD` TEXT NOT NULL, `dTransact` TEXT NOT NULL, `sTimeOpen` TEXT NOT NULL, `sOpenNowx` TEXT, `dSendDate` TEXT, `dNotified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sBranchCD`, `dTransact`, `sTimeOpen`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Employee_Leave` (`sTransNox` TEXT NOT NULL, `dTransact` TEXT, `sEmployNm` TEXT, `sEmployID` TEXT, `sBranchNm` TEXT, `sDeptName` TEXT, `sPositnNm` TEXT, `dDateFrom` TEXT, `dDateThru` TEXT, `nNoDaysxx` INTEGER, `sPurposex` TEXT, `cLeaveTyp` TEXT, `dAppldFrx` TEXT, `dAppldTox` TEXT, `sEntryByx` TEXT, `dEntryDte` TEXT, `nWithPayx` INTEGER, `nWithOPay` INTEGER, `nEqualHrs` REAL, `sApproved` TEXT, `dApproved` TEXT, `cSentStat` TEXT, `cAppvSent` TEXT, `dSendDate` TEXT, `nLveCredt` INTEGER, `cTranStat` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Employee_Business_Trip` (`sTransNox` TEXT NOT NULL, `dTransact` TEXT, `xEmployee` TEXT, `sFullName` TEXT, `sBranchNm` TEXT, `sDeptName` TEXT, `sPositnNm` TEXT, `dDateFrom` TEXT, `dDateThru` TEXT, `sDestinat` TEXT, `sRemarksx` TEXT, `sApproved` TEXT, `dApproved` TEXT, `dAppldFrx` TEXT, `dAppldTox` TEXT, `cTranStat` TEXT, `cSendStat` TEXT, `sModified` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `xxxAOEmpRole` (`sObjectNm` TEXT NOT NULL, `sObjectDs` TEXT, `cObjectTp` TEXT, `cRecdStat` TEXT, `sParentxx` TEXT, `sSeqnceCd` TEXT, `cHasChild` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sObjectNm`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Inventory_Count_Master` (`sTransNox` TEXT NOT NULL, `sBranchCd` TEXT, `dTransact` TEXT, `sRemarksx` TEXT, `nEntryNox` INTEGER NOT NULL, `sRqstdByx` TEXT, `sVerified` TEXT, `dVerified` TEXT, `sApproved` TEXT, `dApproved` TEXT, `cTranStat` TEXT, `sModified` TEXT, `dModified` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Inventory_Count_Detail` (`sTransNox` TEXT NOT NULL, `nEntryNox` INTEGER NOT NULL, `sBarrCode` TEXT NOT NULL, `sPartsIDx` TEXT, `sDescript` TEXT, `sWHouseID` TEXT, `sWHouseNm` TEXT, `sSectnIDx` TEXT, `sSectnNme` TEXT, `sBinIDxxx` TEXT, `sBinNamex` TEXT, `nQtyOnHnd` INTEGER NOT NULL, `nActCtr01` INTEGER NOT NULL, `nActCtr02` INTEGER NOT NULL, `nActCtr03` INTEGER NOT NULL, `nLedgerNo` TEXT, `nBegQtyxx` TEXT, `cTranStat` TEXT, `sRemarksx` TEXT, `dModified` TEXT, PRIMARY KEY(`sTransNox`, `nEntryNox`, `sBarrCode`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Credit_Online_Application_CI` (`sTransNox` TEXT NOT NULL, `sCredInvx` TEXT, `sManagerx` TEXT, `sAddressx` TEXT, `sAddrFndg` TEXT, `sAssetsxx` TEXT, `sAsstFndg` TEXT, `sIncomexx` TEXT, `sIncmFndg` TEXT, `cHasRecrd` TEXT, `sRecrdRem` TEXT, `sPrsnBrgy` TEXT, `sPrsnPstn` TEXT, `sPrsnNmbr` TEXT, `sNeighBr1` TEXT, `sNeighBr2` TEXT, `sNeighBr3` TEXT, `dRcmdRcd1` TEXT, `dRcmdtnx1` TEXT, `cRcmdtnx1` TEXT, `sRcmdtnx1` TEXT, `dRcmdRcd2` TEXT, `dRcmdtnx2` TEXT, `cRcmdtnx2` TEXT, `sRcmdtnx2` TEXT, `cTranStat` TEXT, `cUploaded` TEXT, `cSendStat` TEXT, `cTransfer` TEXT, `sApproved` TEXT, `dApproved` TEXT, `dTimeStmp` TEXT DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Employee_Itinerary` (`sTransNox` TEXT NOT NULL, `sEmployID` TEXT, `dTransact` TEXT, `dTimeFrom` TEXT, `dTimeThru` TEXT, `sLocation` TEXT, `sRemarksx` TEXT, `cSendStat` INTEGER NOT NULL, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Panalo_Reward` (`sPanaloCD` TEXT NOT NULL, `cTranStat` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sPanaloCD`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Raffle_Status` (`sStatusID` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `HasRffle` INTEGER)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Pacita_Rule` (`nEntryNox` INTEGER NOT NULL, `sFieldNmx` TEXT, `nMaxValue` REAL, `cParentxx` TEXT, `cRecdStat` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`nEntryNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Pacita_Evaluation` (`sTransNox` TEXT NOT NULL, `dTransact` TEXT, `sUserIDxx` TEXT, `sBranchCD` TEXT, `sPayloadx` TEXT, `nRatingxx` REAL, `sEvalType` TEXT, `cTranStat` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Installment_Term` (`nTermCode` INTEGER NOT NULL, `sTermDesc` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`nTermCode`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Ganado_Online` (`sTransNox` TEXT NOT NULL, `dTransact` TEXT, `cGanadoTp` TEXT, `cPaymForm` TEXT, `sClientNm` TEXT, `sClntInfo` TEXT, `sProdInfo` TEXT, `sPaymInfo` TEXT, `dTargetxx` TEXT, `dFollowUp` TEXT, `sRemarksx` TEXT, `sReferdBy` TEXT, `sRelatnID` TEXT, `dCreatedx` TEXT, `cTranStat` TEXT, `cSendStat` TEXT, `dModified` TEXT, `dLastUpdt` TEXT, `sBranchCD` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd04908b4fdf3de64e7963ca5748f39ac')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Branch_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `MC_Brand`");
        _db.execSQL("DROP TABLE IF EXISTS `Mc_Model`");
        _db.execSQL("DROP TABLE IF EXISTS `MC_Category`");
        _db.execSQL("DROP TABLE IF EXISTS `Province_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Mc_Model_Price`");
        _db.execSQL("DROP TABLE IF EXISTS `MC_Model_Color`");
        _db.execSQL("DROP TABLE IF EXISTS `Town_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Barangay_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `MC_Term_Category`");
        _db.execSQL("DROP TABLE IF EXISTS `Country_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Occupation_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Credit_Online_Application`");
        _db.execSQL("DROP TABLE IF EXISTS `Credit_Applicant_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `MC_Area_Performance`");
        _db.execSQL("DROP TABLE IF EXISTS `MC_Branch_Performance`");
        _db.execSQL("DROP TABLE IF EXISTS `FB_Raffle_Transaction_Basis`");
        _db.execSQL("DROP TABLE IF EXISTS `PromoLocal_Detail`");
        _db.execSQL("DROP TABLE IF EXISTS `Notification_Info_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `Notification_Info_Recepient`");
        _db.execSQL("DROP TABLE IF EXISTS `Notification_User`");
        _db.execSQL("DROP TABLE IF EXISTS `System_Code_Approval`");
        _db.execSQL("DROP TABLE IF EXISTS `xxxSCA_Request`");
        _db.execSQL("DROP TABLE IF EXISTS `LR_DCP_Collection_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `LR_DCP_Collection_Detail`");
        _db.execSQL("DROP TABLE IF EXISTS `Address_Update_Request`");
        _db.execSQL("DROP TABLE IF EXISTS `Mobile_Update_Request`");
        _db.execSQL("DROP TABLE IF EXISTS `Image_Information`");
        _db.execSQL("DROP TABLE IF EXISTS `User_Info_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `EDocSys_File`");
        _db.execSQL("DROP TABLE IF EXISTS `Client_Info_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `App_Token_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Credit_Online_Application_Documents`");
        _db.execSQL("DROP TABLE IF EXISTS `Client_Update_Request`");
        _db.execSQL("DROP TABLE IF EXISTS `Bank_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Employee_Log_Selfie`");
        _db.execSQL("DROP TABLE IF EXISTS `Credit_Online_Application_List`");
        _db.execSQL("DROP TABLE IF EXISTS `Uncaptured_Client_Image`");
        _db.execSQL("DROP TABLE IF EXISTS `Credit_Online_Application_List_CI`");
        _db.execSQL("DROP TABLE IF EXISTS `LR_DCP_Remittance`");
        _db.execSQL("DROP TABLE IF EXISTS `Collection_Account_Remittance`");
        _db.execSQL("DROP TABLE IF EXISTS `xxxSysConfig`");
        _db.execSQL("DROP TABLE IF EXISTS `GLocator_Sys_log`");
        _db.execSQL("DROP TABLE IF EXISTS `Relation`");
        _db.execSQL("DROP TABLE IF EXISTS `NNDM_Event_Request`");
        _db.execSQL("DROP TABLE IF EXISTS `xxxAppConfig`");
        _db.execSQL("DROP TABLE IF EXISTS `Cash_Count_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `Branch_Opening`");
        _db.execSQL("DROP TABLE IF EXISTS `Employee_Leave`");
        _db.execSQL("DROP TABLE IF EXISTS `Employee_Business_Trip`");
        _db.execSQL("DROP TABLE IF EXISTS `xxxAOEmpRole`");
        _db.execSQL("DROP TABLE IF EXISTS `Inventory_Count_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `Inventory_Count_Detail`");
        _db.execSQL("DROP TABLE IF EXISTS `Credit_Online_Application_CI`");
        _db.execSQL("DROP TABLE IF EXISTS `Employee_Itinerary`");
        _db.execSQL("DROP TABLE IF EXISTS `Panalo_Reward`");
        _db.execSQL("DROP TABLE IF EXISTS `Raffle_Status`");
        _db.execSQL("DROP TABLE IF EXISTS `Pacita_Rule`");
        _db.execSQL("DROP TABLE IF EXISTS `Pacita_Evaluation`");
        _db.execSQL("DROP TABLE IF EXISTS `Installment_Term`");
        _db.execSQL("DROP TABLE IF EXISTS `Ganado_Online`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsBranchInfo = new HashMap<String, TableInfo.Column>(11);
        _columnsBranchInfo.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sBranchNm", new TableInfo.Column("sBranchNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sDescript", new TableInfo.Column("sDescript", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sAddressx", new TableInfo.Column("sAddressx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sTownIDxx", new TableInfo.Column("sTownIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sAreaCode", new TableInfo.Column("sAreaCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("cDivision", new TableInfo.Column("cDivision", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("cPromoDiv", new TableInfo.Column("cPromoDiv", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBranchInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBranchInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBranchInfo = new TableInfo("Branch_Info", _columnsBranchInfo, _foreignKeysBranchInfo, _indicesBranchInfo);
        final TableInfo _existingBranchInfo = TableInfo.read(_db, "Branch_Info");
        if (! _infoBranchInfo.equals(_existingBranchInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Branch_Info(org.rmj.g3appdriver.GCircle.room.Entities.EBranchInfo).\n"
                  + " Expected:\n" + _infoBranchInfo + "\n"
                  + " Found:\n" + _existingBranchInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsMCBrand = new HashMap<String, TableInfo.Column>(5);
        _columnsMCBrand.put("sBrandIDx", new TableInfo.Column("sBrandIDx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBrand.put("sBrandNme", new TableInfo.Column("sBrandNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBrand.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBrand.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBrand.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMCBrand = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMCBrand = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMCBrand = new TableInfo("MC_Brand", _columnsMCBrand, _foreignKeysMCBrand, _indicesMCBrand);
        final TableInfo _existingMCBrand = TableInfo.read(_db, "MC_Brand");
        if (! _infoMCBrand.equals(_existingMCBrand)) {
          return new RoomOpenHelper.ValidationResult(false, "MC_Brand(org.rmj.g3appdriver.GCircle.room.Entities.EMcBrand).\n"
                  + " Expected:\n" + _infoMCBrand + "\n"
                  + " Found:\n" + _existingMCBrand);
        }
        final HashMap<String, TableInfo.Column> _columnsMcModel = new HashMap<String, TableInfo.Column>(12);
        _columnsMcModel.put("sModelIDx", new TableInfo.Column("sModelIDx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("sModelCde", new TableInfo.Column("sModelCde", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("sModelNme", new TableInfo.Column("sModelNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("sBrandIDx", new TableInfo.Column("sBrandIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("cMotorTyp", new TableInfo.Column("cMotorTyp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("cRegisTyp", new TableInfo.Column("cRegisTyp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("cEndOfLfe", new TableInfo.Column("cEndOfLfe", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("cEngineTp", new TableInfo.Column("cEngineTp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("cHotItemx", new TableInfo.Column("cHotItemx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModel.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMcModel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMcModel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMcModel = new TableInfo("Mc_Model", _columnsMcModel, _foreignKeysMcModel, _indicesMcModel);
        final TableInfo _existingMcModel = TableInfo.read(_db, "Mc_Model");
        if (! _infoMcModel.equals(_existingMcModel)) {
          return new RoomOpenHelper.ValidationResult(false, "Mc_Model(org.rmj.g3appdriver.GCircle.room.Entities.EMcModel).\n"
                  + " Expected:\n" + _infoMcModel + "\n"
                  + " Found:\n" + _existingMcModel);
        }
        final HashMap<String, TableInfo.Column> _columnsMCCategory = new HashMap<String, TableInfo.Column>(8);
        _columnsMCCategory.put("sMcCatIDx", new TableInfo.Column("sMcCatIDx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCCategory.put("sMcCatNme", new TableInfo.Column("sMcCatNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCCategory.put("nMiscChrg", new TableInfo.Column("nMiscChrg", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCCategory.put("nRebatesx", new TableInfo.Column("nRebatesx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCCategory.put("nEndMrtgg", new TableInfo.Column("nEndMrtgg", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCCategory.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCCategory.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCCategory.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMCCategory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMCCategory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMCCategory = new TableInfo("MC_Category", _columnsMCCategory, _foreignKeysMCCategory, _indicesMCCategory);
        final TableInfo _existingMCCategory = TableInfo.read(_db, "MC_Category");
        if (! _infoMCCategory.equals(_existingMCCategory)) {
          return new RoomOpenHelper.ValidationResult(false, "MC_Category(org.rmj.g3appdriver.GCircle.room.Entities.EMcCategory).\n"
                  + " Expected:\n" + _infoMCCategory + "\n"
                  + " Found:\n" + _existingMCCategory);
        }
        final HashMap<String, TableInfo.Column> _columnsProvinceInfo = new HashMap<String, TableInfo.Column>(5);
        _columnsProvinceInfo.put("sProvIDxx", new TableInfo.Column("sProvIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProvinceInfo.put("sProvName", new TableInfo.Column("sProvName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProvinceInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProvinceInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProvinceInfo.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProvinceInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProvinceInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProvinceInfo = new TableInfo("Province_Info", _columnsProvinceInfo, _foreignKeysProvinceInfo, _indicesProvinceInfo);
        final TableInfo _existingProvinceInfo = TableInfo.read(_db, "Province_Info");
        if (! _infoProvinceInfo.equals(_existingProvinceInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Province_Info(org.rmj.g3appdriver.GCircle.room.Entities.EProvinceInfo).\n"
                  + " Expected:\n" + _infoProvinceInfo + "\n"
                  + " Found:\n" + _existingProvinceInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsMcModelPrice = new HashMap<String, TableInfo.Column>(11);
        _columnsMcModelPrice.put("sModelIDx", new TableInfo.Column("sModelIDx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModelPrice.put("nSelPrice", new TableInfo.Column("nSelPrice", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModelPrice.put("nLastPrce", new TableInfo.Column("nLastPrce", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModelPrice.put("nDealrPrc", new TableInfo.Column("nDealrPrc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModelPrice.put("nMinDownx", new TableInfo.Column("nMinDownx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModelPrice.put("sMCCatIDx", new TableInfo.Column("sMCCatIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModelPrice.put("dPricexxx", new TableInfo.Column("dPricexxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModelPrice.put("dInsPrice", new TableInfo.Column("dInsPrice", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModelPrice.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModelPrice.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMcModelPrice.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMcModelPrice = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMcModelPrice = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMcModelPrice = new TableInfo("Mc_Model_Price", _columnsMcModelPrice, _foreignKeysMcModelPrice, _indicesMcModelPrice);
        final TableInfo _existingMcModelPrice = TableInfo.read(_db, "Mc_Model_Price");
        if (! _infoMcModelPrice.equals(_existingMcModelPrice)) {
          return new RoomOpenHelper.ValidationResult(false, "Mc_Model_Price(org.rmj.g3appdriver.GCircle.room.Entities.EMcModelPrice).\n"
                  + " Expected:\n" + _infoMcModelPrice + "\n"
                  + " Found:\n" + _existingMcModelPrice);
        }
        final HashMap<String, TableInfo.Column> _columnsMCModelColor = new HashMap<String, TableInfo.Column>(4);
        _columnsMCModelColor.put("sModelIDx", new TableInfo.Column("sModelIDx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCModelColor.put("sColorIDx", new TableInfo.Column("sColorIDx", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCModelColor.put("sColorNme", new TableInfo.Column("sColorNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCModelColor.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMCModelColor = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMCModelColor = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMCModelColor = new TableInfo("MC_Model_Color", _columnsMCModelColor, _foreignKeysMCModelColor, _indicesMCModelColor);
        final TableInfo _existingMCModelColor = TableInfo.read(_db, "MC_Model_Color");
        if (! _infoMCModelColor.equals(_existingMCModelColor)) {
          return new RoomOpenHelper.ValidationResult(false, "MC_Model_Color(org.rmj.g3appdriver.GCircle.room.Entities.EMCColor).\n"
                  + " Expected:\n" + _infoMCModelColor + "\n"
                  + " Found:\n" + _existingMCModelColor);
        }
        final HashMap<String, TableInfo.Column> _columnsTownInfo = new HashMap<String, TableInfo.Column>(10);
        _columnsTownInfo.put("sTownIDxx", new TableInfo.Column("sTownIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTownInfo.put("sTownName", new TableInfo.Column("sTownName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTownInfo.put("sZippCode", new TableInfo.Column("sZippCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTownInfo.put("sProvIDxx", new TableInfo.Column("sProvIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTownInfo.put("sProvCode", new TableInfo.Column("sProvCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTownInfo.put("sMuncplCd", new TableInfo.Column("sMuncplCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTownInfo.put("cHasRoute", new TableInfo.Column("cHasRoute", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTownInfo.put("cBlackLst", new TableInfo.Column("cBlackLst", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTownInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTownInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTownInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTownInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTownInfo = new TableInfo("Town_Info", _columnsTownInfo, _foreignKeysTownInfo, _indicesTownInfo);
        final TableInfo _existingTownInfo = TableInfo.read(_db, "Town_Info");
        if (! _infoTownInfo.equals(_existingTownInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Town_Info(org.rmj.g3appdriver.GCircle.room.Entities.ETownInfo).\n"
                  + " Expected:\n" + _infoTownInfo + "\n"
                  + " Found:\n" + _existingTownInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsBarangayInfo = new HashMap<String, TableInfo.Column>(7);
        _columnsBarangayInfo.put("sBrgyIDxx", new TableInfo.Column("sBrgyIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarangayInfo.put("sBrgyName", new TableInfo.Column("sBrgyName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarangayInfo.put("sTownIDxx", new TableInfo.Column("sTownIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarangayInfo.put("cHasRoute", new TableInfo.Column("cHasRoute", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarangayInfo.put("cBlackLst", new TableInfo.Column("cBlackLst", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarangayInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBarangayInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBarangayInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBarangayInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBarangayInfo = new TableInfo("Barangay_Info", _columnsBarangayInfo, _foreignKeysBarangayInfo, _indicesBarangayInfo);
        final TableInfo _existingBarangayInfo = TableInfo.read(_db, "Barangay_Info");
        if (! _infoBarangayInfo.equals(_existingBarangayInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Barangay_Info(org.rmj.g3appdriver.GCircle.room.Entities.EBarangayInfo).\n"
                  + " Expected:\n" + _infoBarangayInfo + "\n"
                  + " Found:\n" + _existingBarangayInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsMCTermCategory = new HashMap<String, TableInfo.Column>(7);
        _columnsMCTermCategory.put("sMCCatIDx", new TableInfo.Column("sMCCatIDx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCTermCategory.put("nAcctTerm", new TableInfo.Column("nAcctTerm", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCTermCategory.put("nAcctThru", new TableInfo.Column("nAcctThru", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCTermCategory.put("nFactorRt", new TableInfo.Column("nFactorRt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCTermCategory.put("dPricexxx", new TableInfo.Column("dPricexxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCTermCategory.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCTermCategory.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMCTermCategory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMCTermCategory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMCTermCategory = new TableInfo("MC_Term_Category", _columnsMCTermCategory, _foreignKeysMCTermCategory, _indicesMCTermCategory);
        final TableInfo _existingMCTermCategory = TableInfo.read(_db, "MC_Term_Category");
        if (! _infoMCTermCategory.equals(_existingMCTermCategory)) {
          return new RoomOpenHelper.ValidationResult(false, "MC_Term_Category(org.rmj.g3appdriver.GCircle.room.Entities.EMcTermCategory).\n"
                  + " Expected:\n" + _infoMCTermCategory + "\n"
                  + " Found:\n" + _existingMCTermCategory);
        }
        final HashMap<String, TableInfo.Column> _columnsCountryInfo = new HashMap<String, TableInfo.Column>(6);
        _columnsCountryInfo.put("sCntryCde", new TableInfo.Column("sCntryCde", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountryInfo.put("sCntryNme", new TableInfo.Column("sCntryNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountryInfo.put("sNational", new TableInfo.Column("sNational", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountryInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountryInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCountryInfo.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCountryInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCountryInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCountryInfo = new TableInfo("Country_Info", _columnsCountryInfo, _foreignKeysCountryInfo, _indicesCountryInfo);
        final TableInfo _existingCountryInfo = TableInfo.read(_db, "Country_Info");
        if (! _infoCountryInfo.equals(_existingCountryInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Country_Info(org.rmj.g3appdriver.GCircle.room.Entities.ECountryInfo).\n"
                  + " Expected:\n" + _infoCountryInfo + "\n"
                  + " Found:\n" + _existingCountryInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsOccupationInfo = new HashMap<String, TableInfo.Column>(5);
        _columnsOccupationInfo.put("sOccptnID", new TableInfo.Column("sOccptnID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOccupationInfo.put("sOccptnNm", new TableInfo.Column("sOccptnNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOccupationInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOccupationInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOccupationInfo.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOccupationInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOccupationInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOccupationInfo = new TableInfo("Occupation_Info", _columnsOccupationInfo, _foreignKeysOccupationInfo, _indicesOccupationInfo);
        final TableInfo _existingOccupationInfo = TableInfo.read(_db, "Occupation_Info");
        if (! _infoOccupationInfo.equals(_existingOccupationInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Occupation_Info(org.rmj.g3appdriver.GCircle.room.Entities.EOccupationInfo).\n"
                  + " Expected:\n" + _infoOccupationInfo + "\n"
                  + " Found:\n" + _existingOccupationInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsCreditOnlineApplication = new HashMap<String, TableInfo.Column>(30);
        _columnsCreditOnlineApplication.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("dTargetDt", new TableInfo.Column("dTargetDt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sClientNm", new TableInfo.Column("sClientNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sGOCASNox", new TableInfo.Column("sGOCASNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sGOCASNoF", new TableInfo.Column("sGOCASNoF", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("cUnitAppl", new TableInfo.Column("cUnitAppl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sSourceCD", new TableInfo.Column("sSourceCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sDetlInfo", new TableInfo.Column("sDetlInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sCatInfox", new TableInfo.Column("sCatInfox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sDesInfox", new TableInfo.Column("sDesInfox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sQMatchNo", new TableInfo.Column("sQMatchNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sQMAppCde", new TableInfo.Column("sQMAppCde", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("nCrdtScrx", new TableInfo.Column("nCrdtScrx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("cWithCIxx", new TableInfo.Column("cWithCIxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("nDownPaym", new TableInfo.Column("nDownPaym", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("nDownPayF", new TableInfo.Column("nDownPayF", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("dReceived", new TableInfo.Column("dReceived", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sCreatedx", new TableInfo.Column("sCreatedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("dCreatedx", new TableInfo.Column("dCreatedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("sVerified", new TableInfo.Column("sVerified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("dVerified", new TableInfo.Column("dVerified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("cDivision", new TableInfo.Column("cDivision", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("cApplStat", new TableInfo.Column("cApplStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplication.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCreditOnlineApplication = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCreditOnlineApplication = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCreditOnlineApplication = new TableInfo("Credit_Online_Application", _columnsCreditOnlineApplication, _foreignKeysCreditOnlineApplication, _indicesCreditOnlineApplication);
        final TableInfo _existingCreditOnlineApplication = TableInfo.read(_db, "Credit_Online_Application");
        if (! _infoCreditOnlineApplication.equals(_existingCreditOnlineApplication)) {
          return new RoomOpenHelper.ValidationResult(false, "Credit_Online_Application(org.rmj.g3appdriver.GCircle.room.Entities.ECreditApplication).\n"
                  + " Expected:\n" + _infoCreditOnlineApplication + "\n"
                  + " Found:\n" + _existingCreditOnlineApplication);
        }
        final HashMap<String, TableInfo.Column> _columnsCreditApplicantInfo = new HashMap<String, TableInfo.Column>(34);
        _columnsCreditApplicantInfo.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sClientNm", new TableInfo.Column("sClientNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sDetlInfo", new TableInfo.Column("sDetlInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sPurchase", new TableInfo.Column("sPurchase", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sApplInfo", new TableInfo.Column("sApplInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sResidnce", new TableInfo.Column("sResidnce", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("cSameAddx", new TableInfo.Column("cSameAddx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sAppMeans", new TableInfo.Column("sAppMeans", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sEmplymnt", new TableInfo.Column("sEmplymnt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sBusnInfo", new TableInfo.Column("sBusnInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sFinancex", new TableInfo.Column("sFinancex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sPensionx", new TableInfo.Column("sPensionx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sOtherInc", new TableInfo.Column("sOtherInc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sSpousexx", new TableInfo.Column("sSpousexx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sSpsResdx", new TableInfo.Column("sSpsResdx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sSpsMEans", new TableInfo.Column("sSpsMEans", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sSpsEmplx", new TableInfo.Column("sSpsEmplx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sSpsBusnx", new TableInfo.Column("sSpsBusnx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sSpsPensn", new TableInfo.Column("sSpsPensn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sSpOthInc", new TableInfo.Column("sSpOthInc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sDisbrsmt", new TableInfo.Column("sDisbrsmt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sDependnt", new TableInfo.Column("sDependnt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sProperty", new TableInfo.Column("sProperty", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sOthrInfo", new TableInfo.Column("sOthrInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sComakerx", new TableInfo.Column("sComakerx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sCmResidx", new TableInfo.Column("sCmResidx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("cIsSpouse", new TableInfo.Column("cIsSpouse", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("cIsComakr", new TableInfo.Column("cIsComakr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("cAppliedx", new TableInfo.Column("cAppliedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("dCreatedx", new TableInfo.Column("dCreatedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("nDownPaym", new TableInfo.Column("nDownPaym", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditApplicantInfo.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCreditApplicantInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCreditApplicantInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCreditApplicantInfo = new TableInfo("Credit_Applicant_Info", _columnsCreditApplicantInfo, _foreignKeysCreditApplicantInfo, _indicesCreditApplicantInfo);
        final TableInfo _existingCreditApplicantInfo = TableInfo.read(_db, "Credit_Applicant_Info");
        if (! _infoCreditApplicantInfo.equals(_existingCreditApplicantInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Credit_Applicant_Info(org.rmj.g3appdriver.GCircle.room.Entities.ECreditApplicantInfo).\n"
                  + " Expected:\n" + _infoCreditApplicantInfo + "\n"
                  + " Found:\n" + _existingCreditApplicantInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsMCAreaPerformance = new HashMap<String, TableInfo.Column>(11);
        _columnsMCAreaPerformance.put("sAreaCode", new TableInfo.Column("sAreaCode", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCAreaPerformance.put("sAreaDesc", new TableInfo.Column("sAreaDesc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCAreaPerformance.put("sPeriodxx", new TableInfo.Column("sPeriodxx", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCAreaPerformance.put("nMCGoalxx", new TableInfo.Column("nMCGoalxx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCAreaPerformance.put("nSPGoalxx", new TableInfo.Column("nSPGoalxx", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCAreaPerformance.put("nJOGoalxx", new TableInfo.Column("nJOGoalxx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCAreaPerformance.put("nLRGoalxx", new TableInfo.Column("nLRGoalxx", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCAreaPerformance.put("nMCActual", new TableInfo.Column("nMCActual", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCAreaPerformance.put("nSPActual", new TableInfo.Column("nSPActual", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCAreaPerformance.put("nJOActual", new TableInfo.Column("nJOActual", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCAreaPerformance.put("nLRActual", new TableInfo.Column("nLRActual", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMCAreaPerformance = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMCAreaPerformance = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMCAreaPerformance = new TableInfo("MC_Area_Performance", _columnsMCAreaPerformance, _foreignKeysMCAreaPerformance, _indicesMCAreaPerformance);
        final TableInfo _existingMCAreaPerformance = TableInfo.read(_db, "MC_Area_Performance");
        if (! _infoMCAreaPerformance.equals(_existingMCAreaPerformance)) {
          return new RoomOpenHelper.ValidationResult(false, "MC_Area_Performance(org.rmj.g3appdriver.GCircle.room.Entities.EAreaPerformance).\n"
                  + " Expected:\n" + _infoMCAreaPerformance + "\n"
                  + " Found:\n" + _existingMCAreaPerformance);
        }
        final HashMap<String, TableInfo.Column> _columnsMCBranchPerformance = new HashMap<String, TableInfo.Column>(11);
        _columnsMCBranchPerformance.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBranchPerformance.put("sPeriodxx", new TableInfo.Column("sPeriodxx", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBranchPerformance.put("sBranchNm", new TableInfo.Column("sBranchNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBranchPerformance.put("nMCGoalxx", new TableInfo.Column("nMCGoalxx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBranchPerformance.put("nSPGoalxx", new TableInfo.Column("nSPGoalxx", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBranchPerformance.put("nJOGoalxx", new TableInfo.Column("nJOGoalxx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBranchPerformance.put("nLRGoalxx", new TableInfo.Column("nLRGoalxx", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBranchPerformance.put("nMCActual", new TableInfo.Column("nMCActual", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBranchPerformance.put("nSPActual", new TableInfo.Column("nSPActual", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBranchPerformance.put("nJOActual", new TableInfo.Column("nJOActual", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCBranchPerformance.put("nLRActual", new TableInfo.Column("nLRActual", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMCBranchPerformance = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMCBranchPerformance = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMCBranchPerformance = new TableInfo("MC_Branch_Performance", _columnsMCBranchPerformance, _foreignKeysMCBranchPerformance, _indicesMCBranchPerformance);
        final TableInfo _existingMCBranchPerformance = TableInfo.read(_db, "MC_Branch_Performance");
        if (! _infoMCBranchPerformance.equals(_existingMCBranchPerformance)) {
          return new RoomOpenHelper.ValidationResult(false, "MC_Branch_Performance(org.rmj.g3appdriver.GCircle.room.Entities.EBranchPerformance).\n"
                  + " Expected:\n" + _infoMCBranchPerformance + "\n"
                  + " Found:\n" + _existingMCBranchPerformance);
        }
        final HashMap<String, TableInfo.Column> _columnsFBRaffleTransactionBasis = new HashMap<String, TableInfo.Column>(7);
        _columnsFBRaffleTransactionBasis.put("sDivision", new TableInfo.Column("sDivision", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFBRaffleTransactionBasis.put("sTableNme", new TableInfo.Column("sTableNme", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFBRaffleTransactionBasis.put("sReferCde", new TableInfo.Column("sReferCde", "TEXT", true, 3, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFBRaffleTransactionBasis.put("sReferNme", new TableInfo.Column("sReferNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFBRaffleTransactionBasis.put("cCltInfox", new TableInfo.Column("cCltInfox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFBRaffleTransactionBasis.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFBRaffleTransactionBasis.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFBRaffleTransactionBasis = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFBRaffleTransactionBasis = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFBRaffleTransactionBasis = new TableInfo("FB_Raffle_Transaction_Basis", _columnsFBRaffleTransactionBasis, _foreignKeysFBRaffleTransactionBasis, _indicesFBRaffleTransactionBasis);
        final TableInfo _existingFBRaffleTransactionBasis = TableInfo.read(_db, "FB_Raffle_Transaction_Basis");
        if (! _infoFBRaffleTransactionBasis.equals(_existingFBRaffleTransactionBasis)) {
          return new RoomOpenHelper.ValidationResult(false, "FB_Raffle_Transaction_Basis(org.rmj.g3appdriver.GCircle.room.Entities.ERaffleBasis).\n"
                  + " Expected:\n" + _infoFBRaffleTransactionBasis + "\n"
                  + " Found:\n" + _existingFBRaffleTransactionBasis);
        }
        final HashMap<String, TableInfo.Column> _columnsPromoLocalDetail = new HashMap<String, TableInfo.Column>(11);
        _columnsPromoLocalDetail.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLocalDetail.put("dTransact", new TableInfo.Column("dTransact", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLocalDetail.put("sClientNm", new TableInfo.Column("sClientNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLocalDetail.put("sAddressx", new TableInfo.Column("sAddressx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLocalDetail.put("sTownIDxx", new TableInfo.Column("sTownIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLocalDetail.put("sProvIDxx", new TableInfo.Column("sProvIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLocalDetail.put("sDocTypex", new TableInfo.Column("sDocTypex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLocalDetail.put("sDocNoxxx", new TableInfo.Column("sDocNoxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLocalDetail.put("sMobileNo", new TableInfo.Column("sMobileNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLocalDetail.put("cSendStat", new TableInfo.Column("cSendStat", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLocalDetail.put("sTimeStmp", new TableInfo.Column("sTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPromoLocalDetail = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPromoLocalDetail = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPromoLocalDetail = new TableInfo("PromoLocal_Detail", _columnsPromoLocalDetail, _foreignKeysPromoLocalDetail, _indicesPromoLocalDetail);
        final TableInfo _existingPromoLocalDetail = TableInfo.read(_db, "PromoLocal_Detail");
        if (! _infoPromoLocalDetail.equals(_existingPromoLocalDetail)) {
          return new RoomOpenHelper.ValidationResult(false, "PromoLocal_Detail(org.rmj.g3appdriver.GCircle.room.Entities.ERaffleInfo).\n"
                  + " Expected:\n" + _infoPromoLocalDetail + "\n"
                  + " Found:\n" + _existingPromoLocalDetail);
        }
        final HashMap<String, TableInfo.Column> _columnsNotificationInfoMaster = new HashMap<String, TableInfo.Column>(14);
        _columnsNotificationInfoMaster.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("sMesgIDxx", new TableInfo.Column("sMesgIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("sParentxx", new TableInfo.Column("sParentxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("dCreatedx", new TableInfo.Column("dCreatedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("sAppSrcex", new TableInfo.Column("sAppSrcex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("sCreatrID", new TableInfo.Column("sCreatrID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("sCreatrNm", new TableInfo.Column("sCreatrNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("sMsgTitle", new TableInfo.Column("sMsgTitle", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("sMessagex", new TableInfo.Column("sMessagex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("sURLxxxxx", new TableInfo.Column("sURLxxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("sDataSndx", new TableInfo.Column("sDataSndx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("sMsgTypex", new TableInfo.Column("sMsgTypex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("cSentxxxx", new TableInfo.Column("cSentxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoMaster.put("dSentxxxx", new TableInfo.Column("dSentxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotificationInfoMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotificationInfoMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotificationInfoMaster = new TableInfo("Notification_Info_Master", _columnsNotificationInfoMaster, _foreignKeysNotificationInfoMaster, _indicesNotificationInfoMaster);
        final TableInfo _existingNotificationInfoMaster = TableInfo.read(_db, "Notification_Info_Master");
        if (! _infoNotificationInfoMaster.equals(_existingNotificationInfoMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "Notification_Info_Master(org.rmj.g3appdriver.GCircle.room.Entities.ENotificationMaster).\n"
                  + " Expected:\n" + _infoNotificationInfoMaster + "\n"
                  + " Found:\n" + _existingNotificationInfoMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsNotificationInfoRecepient = new HashMap<String, TableInfo.Column>(14);
        _columnsNotificationInfoRecepient.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("sAppRcptx", new TableInfo.Column("sAppRcptx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("sRecpntID", new TableInfo.Column("sRecpntID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("sRecpntNm", new TableInfo.Column("sRecpntNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("sGroupIDx", new TableInfo.Column("sGroupIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("sGroupNmx", new TableInfo.Column("sGroupNmx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("cMonitorx", new TableInfo.Column("cMonitorx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("cMesgStat", new TableInfo.Column("cMesgStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("cStatSent", new TableInfo.Column("cStatSent", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("dSentxxxx", new TableInfo.Column("dSentxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("dReceived", new TableInfo.Column("dReceived", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("dReadxxxx", new TableInfo.Column("dReadxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("dLastUpdt", new TableInfo.Column("dLastUpdt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationInfoRecepient.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotificationInfoRecepient = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotificationInfoRecepient = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotificationInfoRecepient = new TableInfo("Notification_Info_Recepient", _columnsNotificationInfoRecepient, _foreignKeysNotificationInfoRecepient, _indicesNotificationInfoRecepient);
        final TableInfo _existingNotificationInfoRecepient = TableInfo.read(_db, "Notification_Info_Recepient");
        if (! _infoNotificationInfoRecepient.equals(_existingNotificationInfoRecepient)) {
          return new RoomOpenHelper.ValidationResult(false, "Notification_Info_Recepient(org.rmj.g3appdriver.GCircle.room.Entities.ENotificationRecipient).\n"
                  + " Expected:\n" + _infoNotificationInfoRecepient + "\n"
                  + " Found:\n" + _existingNotificationInfoRecepient);
        }
        final HashMap<String, TableInfo.Column> _columnsNotificationUser = new HashMap<String, TableInfo.Column>(2);
        _columnsNotificationUser.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNotificationUser.put("sUserName", new TableInfo.Column("sUserName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNotificationUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNotificationUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNotificationUser = new TableInfo("Notification_User", _columnsNotificationUser, _foreignKeysNotificationUser, _indicesNotificationUser);
        final TableInfo _existingNotificationUser = TableInfo.read(_db, "Notification_User");
        if (! _infoNotificationUser.equals(_existingNotificationUser)) {
          return new RoomOpenHelper.ValidationResult(false, "Notification_User(org.rmj.g3appdriver.GCircle.room.Entities.ENotificationUser).\n"
                  + " Expected:\n" + _infoNotificationUser + "\n"
                  + " Found:\n" + _existingNotificationUser);
        }
        final HashMap<String, TableInfo.Column> _columnsSystemCodeApproval = new HashMap<String, TableInfo.Column>(17);
        _columnsSystemCodeApproval.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("sSystemCD", new TableInfo.Column("sSystemCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("sReqstdBy", new TableInfo.Column("sReqstdBy", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("dReqstdxx", new TableInfo.Column("dReqstdxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("cIssuedBy", new TableInfo.Column("cIssuedBy", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("sMiscInfo", new TableInfo.Column("sMiscInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("sRemarks1", new TableInfo.Column("sRemarks1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("sRemarks2", new TableInfo.Column("sRemarks2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("sApprCode", new TableInfo.Column("sApprCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("sEntryByx", new TableInfo.Column("sEntryByx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("sApprvByx", new TableInfo.Column("sApprvByx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("sReasonxx", new TableInfo.Column("sReasonxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("sReqstdTo", new TableInfo.Column("sReqstdTo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("cSendxxxx", new TableInfo.Column("cSendxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSystemCodeApproval.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSystemCodeApproval = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSystemCodeApproval = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSystemCodeApproval = new TableInfo("System_Code_Approval", _columnsSystemCodeApproval, _foreignKeysSystemCodeApproval, _indicesSystemCodeApproval);
        final TableInfo _existingSystemCodeApproval = TableInfo.read(_db, "System_Code_Approval");
        if (! _infoSystemCodeApproval.equals(_existingSystemCodeApproval)) {
          return new RoomOpenHelper.ValidationResult(false, "System_Code_Approval(org.rmj.g3appdriver.GCircle.room.Entities.ECodeApproval).\n"
                  + " Expected:\n" + _infoSystemCodeApproval + "\n"
                  + " Found:\n" + _existingSystemCodeApproval);
        }
        final HashMap<String, TableInfo.Column> _columnsXxxSCARequest = new HashMap<String, TableInfo.Column>(15);
        _columnsXxxSCARequest.put("sSCACodex", new TableInfo.Column("sSCACodex", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("sSCATitle", new TableInfo.Column("sSCATitle", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("sSCADescx", new TableInfo.Column("sSCADescx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("cSCATypex", new TableInfo.Column("cSCATypex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("cAreaHead", new TableInfo.Column("cAreaHead", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("cHCMDeptx", new TableInfo.Column("cHCMDeptx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("cCSSDeptx", new TableInfo.Column("cCSSDeptx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("cComplnce", new TableInfo.Column("cComplnce", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("cMktgDept", new TableInfo.Column("cMktgDept", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("cASMDeptx", new TableInfo.Column("cASMDeptx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("cTLMDeptx", new TableInfo.Column("cTLMDeptx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("cSCMDeptx", new TableInfo.Column("cSCMDeptx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSCARequest.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysXxxSCARequest = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesXxxSCARequest = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoXxxSCARequest = new TableInfo("xxxSCA_Request", _columnsXxxSCARequest, _foreignKeysXxxSCARequest, _indicesXxxSCARequest);
        final TableInfo _existingXxxSCARequest = TableInfo.read(_db, "xxxSCA_Request");
        if (! _infoXxxSCARequest.equals(_existingXxxSCARequest)) {
          return new RoomOpenHelper.ValidationResult(false, "xxxSCA_Request(org.rmj.g3appdriver.GCircle.room.Entities.ESCA_Request).\n"
                  + " Expected:\n" + _infoXxxSCARequest + "\n"
                  + " Found:\n" + _existingXxxSCARequest);
        }
        final HashMap<String, TableInfo.Column> _columnsLRDCPCollectionMaster = new HashMap<String, TableInfo.Column>(14);
        _columnsLRDCPCollectionMaster.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("sReferNox", new TableInfo.Column("sReferNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("xCollName", new TableInfo.Column("xCollName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("sRouteNme", new TableInfo.Column("sRouteNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("dReferDte", new TableInfo.Column("dReferDte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("cDCPTypex", new TableInfo.Column("cDCPTypex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("nEntryNox", new TableInfo.Column("nEntryNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("sBranchNm", new TableInfo.Column("sBranchNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("sCollctID", new TableInfo.Column("sCollctID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("dSendDate", new TableInfo.Column("dSendDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionMaster.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLRDCPCollectionMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLRDCPCollectionMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLRDCPCollectionMaster = new TableInfo("LR_DCP_Collection_Master", _columnsLRDCPCollectionMaster, _foreignKeysLRDCPCollectionMaster, _indicesLRDCPCollectionMaster);
        final TableInfo _existingLRDCPCollectionMaster = TableInfo.read(_db, "LR_DCP_Collection_Master");
        if (! _infoLRDCPCollectionMaster.equals(_existingLRDCPCollectionMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "LR_DCP_Collection_Master(org.rmj.g3appdriver.GCircle.room.Entities.EDCPCollectionMaster).\n"
                  + " Expected:\n" + _infoLRDCPCollectionMaster + "\n"
                  + " Found:\n" + _existingLRDCPCollectionMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsLRDCPCollectionDetail = new HashMap<String, TableInfo.Column>(45);
        _columnsLRDCPCollectionDetail.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nEntryNox", new TableInfo.Column("nEntryNox", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sAcctNmbr", new TableInfo.Column("sAcctNmbr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("xFullName", new TableInfo.Column("xFullName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sPRNoxxxx", new TableInfo.Column("sPRNoxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nTranAmtx", new TableInfo.Column("nTranAmtx", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nDiscount", new TableInfo.Column("nDiscount", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nOthersxx", new TableInfo.Column("nOthersxx", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sBankIDxx", new TableInfo.Column("sBankIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sCheckDte", new TableInfo.Column("sCheckDte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sCheckNox", new TableInfo.Column("sCheckNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sCheckAct", new TableInfo.Column("sCheckAct", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("dPromised", new TableInfo.Column("dPromised", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sRemCodex", new TableInfo.Column("sRemCodex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("cTranType", new TableInfo.Column("cTranType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nTranTotl", new TableInfo.Column("nTranTotl", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sReferNox", new TableInfo.Column("sReferNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("cPaymForm", new TableInfo.Column("cPaymForm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("cIsDCPxxx", new TableInfo.Column("cIsDCPxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sMobileNo", new TableInfo.Column("sMobileNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sHouseNox", new TableInfo.Column("sHouseNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sAddressx", new TableInfo.Column("sAddressx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sBrgyName", new TableInfo.Column("sBrgyName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sTownName", new TableInfo.Column("sTownName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("dPurchase", new TableInfo.Column("dPurchase", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nMonAmort", new TableInfo.Column("nMonAmort", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nAmtDuexx", new TableInfo.Column("nAmtDuexx", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("cApntUnit", new TableInfo.Column("cApntUnit", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("dDueDatex", new TableInfo.Column("dDueDatex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sImageNme", new TableInfo.Column("sImageNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nLongitud", new TableInfo.Column("nLongitud", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nLatitude", new TableInfo.Column("nLatitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sClientID", new TableInfo.Column("sClientID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sSerialID", new TableInfo.Column("sSerialID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("sSerialNo", new TableInfo.Column("sSerialNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nLastPaym", new TableInfo.Column("nLastPaym", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("dLastPaym", new TableInfo.Column("dLastPaym", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nABalance", new TableInfo.Column("nABalance", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("nDelayAvg", new TableInfo.Column("nDelayAvg", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("dSendDate", new TableInfo.Column("dSendDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPCollectionDetail.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLRDCPCollectionDetail = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLRDCPCollectionDetail = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLRDCPCollectionDetail = new TableInfo("LR_DCP_Collection_Detail", _columnsLRDCPCollectionDetail, _foreignKeysLRDCPCollectionDetail, _indicesLRDCPCollectionDetail);
        final TableInfo _existingLRDCPCollectionDetail = TableInfo.read(_db, "LR_DCP_Collection_Detail");
        if (! _infoLRDCPCollectionDetail.equals(_existingLRDCPCollectionDetail)) {
          return new RoomOpenHelper.ValidationResult(false, "LR_DCP_Collection_Detail(org.rmj.g3appdriver.GCircle.room.Entities.EDCPCollectionDetail).\n"
                  + " Expected:\n" + _infoLRDCPCollectionDetail + "\n"
                  + " Found:\n" + _existingLRDCPCollectionDetail);
        }
        final HashMap<String, TableInfo.Column> _columnsAddressUpdateRequest = new HashMap<String, TableInfo.Column>(17);
        _columnsAddressUpdateRequest.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sClientID", new TableInfo.Column("sClientID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("cReqstCDe", new TableInfo.Column("cReqstCDe", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("cAddrssTp", new TableInfo.Column("cAddrssTp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sHouseNox", new TableInfo.Column("sHouseNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sAddressx", new TableInfo.Column("sAddressx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sTownIDxx", new TableInfo.Column("sTownIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sBrgyIDxx", new TableInfo.Column("sBrgyIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("cPrimaryx", new TableInfo.Column("cPrimaryx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("nLatitude", new TableInfo.Column("nLatitude", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("nLongitud", new TableInfo.Column("nLongitud", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("dSendDate", new TableInfo.Column("dSendDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAddressUpdateRequest = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAddressUpdateRequest = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAddressUpdateRequest = new TableInfo("Address_Update_Request", _columnsAddressUpdateRequest, _foreignKeysAddressUpdateRequest, _indicesAddressUpdateRequest);
        final TableInfo _existingAddressUpdateRequest = TableInfo.read(_db, "Address_Update_Request");
        if (! _infoAddressUpdateRequest.equals(_existingAddressUpdateRequest)) {
          return new RoomOpenHelper.ValidationResult(false, "Address_Update_Request(org.rmj.g3appdriver.GCircle.room.Entities.EAddressUpdate).\n"
                  + " Expected:\n" + _infoAddressUpdateRequest + "\n"
                  + " Found:\n" + _existingAddressUpdateRequest);
        }
        final HashMap<String, TableInfo.Column> _columnsMobileUpdateRequest = new HashMap<String, TableInfo.Column>(11);
        _columnsMobileUpdateRequest.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMobileUpdateRequest.put("sClientID", new TableInfo.Column("sClientID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMobileUpdateRequest.put("cReqstCDe", new TableInfo.Column("cReqstCDe", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMobileUpdateRequest.put("sMobileNo", new TableInfo.Column("sMobileNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMobileUpdateRequest.put("cPrimaryx", new TableInfo.Column("cPrimaryx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMobileUpdateRequest.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMobileUpdateRequest.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMobileUpdateRequest.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMobileUpdateRequest.put("dSendDate", new TableInfo.Column("dSendDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMobileUpdateRequest.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMobileUpdateRequest.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMobileUpdateRequest = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMobileUpdateRequest = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMobileUpdateRequest = new TableInfo("Mobile_Update_Request", _columnsMobileUpdateRequest, _foreignKeysMobileUpdateRequest, _indicesMobileUpdateRequest);
        final TableInfo _existingMobileUpdateRequest = TableInfo.read(_db, "Mobile_Update_Request");
        if (! _infoMobileUpdateRequest.equals(_existingMobileUpdateRequest)) {
          return new RoomOpenHelper.ValidationResult(false, "Mobile_Update_Request(org.rmj.g3appdriver.GCircle.room.Entities.EMobileUpdate).\n"
                  + " Expected:\n" + _infoMobileUpdateRequest + "\n"
                  + " Found:\n" + _existingMobileUpdateRequest);
        }
        final HashMap<String, TableInfo.Column> _columnsImageInformation = new HashMap<String, TableInfo.Column>(13);
        _columnsImageInformation.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("sSourceCD", new TableInfo.Column("sSourceCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("sSourceNo", new TableInfo.Column("sSourceNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("sDtlSrcNo", new TableInfo.Column("sDtlSrcNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("sFileCode", new TableInfo.Column("sFileCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("sImageNme", new TableInfo.Column("sImageNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("sMD5Hashx", new TableInfo.Column("sMD5Hashx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("sFileLoct", new TableInfo.Column("sFileLoct", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("nLatitude", new TableInfo.Column("nLatitude", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("nLongitud", new TableInfo.Column("nLongitud", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("dCaptured", new TableInfo.Column("dCaptured", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsImageInformation.put("dSendDate", new TableInfo.Column("dSendDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysImageInformation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesImageInformation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoImageInformation = new TableInfo("Image_Information", _columnsImageInformation, _foreignKeysImageInformation, _indicesImageInformation);
        final TableInfo _existingImageInformation = TableInfo.read(_db, "Image_Information");
        if (! _infoImageInformation.equals(_existingImageInformation)) {
          return new RoomOpenHelper.ValidationResult(false, "Image_Information(org.rmj.g3appdriver.GCircle.room.Entities.EImageInfo).\n"
                  + " Expected:\n" + _infoImageInformation + "\n"
                  + " Found:\n" + _existingImageInformation);
        }
        final HashMap<String, TableInfo.Column> _columnsUserInfoMaster = new HashMap<String, TableInfo.Column>(20);
        _columnsUserInfoMaster.put("sClientID", new TableInfo.Column("sClientID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sBranchCD", new TableInfo.Column("sBranchCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sBranchNm", new TableInfo.Column("sBranchNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sLogNoxxx", new TableInfo.Column("sLogNoxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sEmailAdd", new TableInfo.Column("sEmailAdd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sUserName", new TableInfo.Column("sUserName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("nUserLevl", new TableInfo.Column("nUserLevl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sDeptIDxx", new TableInfo.Column("sDeptIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sPositnID", new TableInfo.Column("sPositnID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sEmpLevID", new TableInfo.Column("sEmpLevID", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("cSlfieLog", new TableInfo.Column("cSlfieLog", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("cAllowUpd", new TableInfo.Column("cAllowUpd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("dLoginxxx", new TableInfo.Column("dLoginxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sMobileNo", new TableInfo.Column("sMobileNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("dSessionx", new TableInfo.Column("dSessionx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sEmployID", new TableInfo.Column("sEmployID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("cPrivatex", new TableInfo.Column("cPrivatex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sDeviceID", new TableInfo.Column("sDeviceID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sModelIDx", new TableInfo.Column("sModelIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserInfoMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserInfoMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserInfoMaster = new TableInfo("User_Info_Master", _columnsUserInfoMaster, _foreignKeysUserInfoMaster, _indicesUserInfoMaster);
        final TableInfo _existingUserInfoMaster = TableInfo.read(_db, "User_Info_Master");
        if (! _infoUserInfoMaster.equals(_existingUserInfoMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "User_Info_Master(org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeInfo).\n"
                  + " Expected:\n" + _infoUserInfoMaster + "\n"
                  + " Found:\n" + _existingUserInfoMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsEDocSysFile = new HashMap<String, TableInfo.Column>(7);
        _columnsEDocSysFile.put("sFileCode", new TableInfo.Column("sFileCode", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEDocSysFile.put("sBarrcode", new TableInfo.Column("sBarrcode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEDocSysFile.put("sBriefDsc", new TableInfo.Column("sBriefDsc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEDocSysFile.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEDocSysFile.put("nEntryNox", new TableInfo.Column("nEntryNox", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEDocSysFile.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEDocSysFile.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEDocSysFile = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEDocSysFile = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEDocSysFile = new TableInfo("EDocSys_File", _columnsEDocSysFile, _foreignKeysEDocSysFile, _indicesEDocSysFile);
        final TableInfo _existingEDocSysFile = TableInfo.read(_db, "EDocSys_File");
        if (! _infoEDocSysFile.equals(_existingEDocSysFile)) {
          return new RoomOpenHelper.ValidationResult(false, "EDocSys_File(org.rmj.g3appdriver.GCircle.room.Entities.EFileCode).\n"
                  + " Expected:\n" + _infoEDocSysFile + "\n"
                  + " Found:\n" + _existingEDocSysFile);
        }
        final HashMap<String, TableInfo.Column> _columnsClientInfoMaster = new HashMap<String, TableInfo.Column>(6);
        _columnsClientInfoMaster.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientInfoMaster.put("sEmailAdd", new TableInfo.Column("sEmailAdd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientInfoMaster.put("sUserName", new TableInfo.Column("sUserName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientInfoMaster.put("dLoginxxx", new TableInfo.Column("dLoginxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientInfoMaster.put("sMobileNo", new TableInfo.Column("sMobileNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientInfoMaster.put("dDateMmbr", new TableInfo.Column("dDateMmbr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClientInfoMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClientInfoMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClientInfoMaster = new TableInfo("Client_Info_Master", _columnsClientInfoMaster, _foreignKeysClientInfoMaster, _indicesClientInfoMaster);
        final TableInfo _existingClientInfoMaster = TableInfo.read(_db, "Client_Info_Master");
        if (! _infoClientInfoMaster.equals(_existingClientInfoMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "Client_Info_Master(org.rmj.g3appdriver.GCircle.room.Entities.EClientInfo).\n"
                  + " Expected:\n" + _infoClientInfoMaster + "\n"
                  + " Found:\n" + _existingClientInfoMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsAppTokenInfo = new HashMap<String, TableInfo.Column>(8);
        _columnsAppTokenInfo.put("sTokenIDx", new TableInfo.Column("sTokenIDx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppTokenInfo.put("sTokenInf", new TableInfo.Column("sTokenInf", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppTokenInfo.put("sDescript", new TableInfo.Column("sDescript", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppTokenInfo.put("sTokenTpe", new TableInfo.Column("sTokenTpe", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppTokenInfo.put("dGeneratd", new TableInfo.Column("dGeneratd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppTokenInfo.put("dExpirexx", new TableInfo.Column("dExpirexx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppTokenInfo.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppTokenInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAppTokenInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAppTokenInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAppTokenInfo = new TableInfo("App_Token_Info", _columnsAppTokenInfo, _foreignKeysAppTokenInfo, _indicesAppTokenInfo);
        final TableInfo _existingAppTokenInfo = TableInfo.read(_db, "App_Token_Info");
        if (! _infoAppTokenInfo.equals(_existingAppTokenInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "App_Token_Info(org.rmj.g3appdriver.GCircle.room.Entities.ETokenInfo).\n"
                  + " Expected:\n" + _infoAppTokenInfo + "\n"
                  + " Found:\n" + _existingAppTokenInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsCreditOnlineApplicationDocuments = new HashMap<String, TableInfo.Column>(7);
        _columnsCreditOnlineApplicationDocuments.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationDocuments.put("sFileCode", new TableInfo.Column("sFileCode", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationDocuments.put("nEntryNox", new TableInfo.Column("nEntryNox", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationDocuments.put("sImageNme", new TableInfo.Column("sImageNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationDocuments.put("sImageIDx", new TableInfo.Column("sImageIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationDocuments.put("sFileLoct", new TableInfo.Column("sFileLoct", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationDocuments.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCreditOnlineApplicationDocuments = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCreditOnlineApplicationDocuments = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCreditOnlineApplicationDocuments = new TableInfo("Credit_Online_Application_Documents", _columnsCreditOnlineApplicationDocuments, _foreignKeysCreditOnlineApplicationDocuments, _indicesCreditOnlineApplicationDocuments);
        final TableInfo _existingCreditOnlineApplicationDocuments = TableInfo.read(_db, "Credit_Online_Application_Documents");
        if (! _infoCreditOnlineApplicationDocuments.equals(_existingCreditOnlineApplicationDocuments)) {
          return new RoomOpenHelper.ValidationResult(false, "Credit_Online_Application_Documents(org.rmj.g3appdriver.GCircle.room.Entities.ECreditApplicationDocuments).\n"
                  + " Expected:\n" + _infoCreditOnlineApplicationDocuments + "\n"
                  + " Found:\n" + _existingCreditOnlineApplicationDocuments);
        }
        final HashMap<String, TableInfo.Column> _columnsClientUpdateRequest = new HashMap<String, TableInfo.Column>(22);
        _columnsClientUpdateRequest.put("sClientID", new TableInfo.Column("sClientID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sSourceCd", new TableInfo.Column("sSourceCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sSourceNo", new TableInfo.Column("sSourceNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sDtlSrcNo", new TableInfo.Column("sDtlSrcNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sLastName", new TableInfo.Column("sLastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sFrstName", new TableInfo.Column("sFrstName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sMiddName", new TableInfo.Column("sMiddName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sSuffixNm", new TableInfo.Column("sSuffixNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sHouseNox", new TableInfo.Column("sHouseNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sAddressx", new TableInfo.Column("sAddressx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sBarangay", new TableInfo.Column("sBarangay", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sTownIDxx", new TableInfo.Column("sTownIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("cGenderxx", new TableInfo.Column("cGenderxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("cCivlStat", new TableInfo.Column("cCivlStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("dBirthDte", new TableInfo.Column("dBirthDte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("dBirthPlc", new TableInfo.Column("dBirthPlc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sLandline", new TableInfo.Column("sLandline", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sMobileNo", new TableInfo.Column("sMobileNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sEmailAdd", new TableInfo.Column("sEmailAdd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("sImageNme", new TableInfo.Column("sImageNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientUpdateRequest.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClientUpdateRequest = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClientUpdateRequest = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClientUpdateRequest = new TableInfo("Client_Update_Request", _columnsClientUpdateRequest, _foreignKeysClientUpdateRequest, _indicesClientUpdateRequest);
        final TableInfo _existingClientUpdateRequest = TableInfo.read(_db, "Client_Update_Request");
        if (! _infoClientUpdateRequest.equals(_existingClientUpdateRequest)) {
          return new RoomOpenHelper.ValidationResult(false, "Client_Update_Request(org.rmj.g3appdriver.GCircle.room.Entities.EClientUpdate).\n"
                  + " Expected:\n" + _infoClientUpdateRequest + "\n"
                  + " Found:\n" + _existingClientUpdateRequest);
        }
        final HashMap<String, TableInfo.Column> _columnsBankInfo = new HashMap<String, TableInfo.Column>(4);
        _columnsBankInfo.put("sBankIDxx", new TableInfo.Column("sBankIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBankInfo.put("sBankName", new TableInfo.Column("sBankName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBankInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBankInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBankInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBankInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBankInfo = new TableInfo("Bank_Info", _columnsBankInfo, _foreignKeysBankInfo, _indicesBankInfo);
        final TableInfo _existingBankInfo = TableInfo.read(_db, "Bank_Info");
        if (! _infoBankInfo.equals(_existingBankInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Bank_Info(org.rmj.g3appdriver.GCircle.room.Entities.EBankInfo).\n"
                  + " Expected:\n" + _infoBankInfo + "\n"
                  + " Found:\n" + _existingBankInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsEmployeeLogSelfie = new HashMap<String, TableInfo.Column>(13);
        _columnsEmployeeLogSelfie.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("sEmployID", new TableInfo.Column("sEmployID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("dLogTimex", new TableInfo.Column("dLogTimex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("nLatitude", new TableInfo.Column("nLatitude", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("nLongitud", new TableInfo.Column("nLongitud", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("sImageIDx", new TableInfo.Column("sImageIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("dSendDate", new TableInfo.Column("dSendDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("cReqCCntx", new TableInfo.Column("cReqCCntx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLogSelfie.put("cReqRSIxx", new TableInfo.Column("cReqRSIxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmployeeLogSelfie = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEmployeeLogSelfie = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEmployeeLogSelfie = new TableInfo("Employee_Log_Selfie", _columnsEmployeeLogSelfie, _foreignKeysEmployeeLogSelfie, _indicesEmployeeLogSelfie);
        final TableInfo _existingEmployeeLogSelfie = TableInfo.read(_db, "Employee_Log_Selfie");
        if (! _infoEmployeeLogSelfie.equals(_existingEmployeeLogSelfie)) {
          return new RoomOpenHelper.ValidationResult(false, "Employee_Log_Selfie(org.rmj.g3appdriver.GCircle.room.Entities.ESelfieLog).\n"
                  + " Expected:\n" + _infoEmployeeLogSelfie + "\n"
                  + " Found:\n" + _existingEmployeeLogSelfie);
        }
        final HashMap<String, TableInfo.Column> _columnsCreditOnlineApplicationList = new HashMap<String, TableInfo.Column>(15);
        _columnsCreditOnlineApplicationList.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("sBranchCD", new TableInfo.Column("sBranchCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("sCredInvx", new TableInfo.Column("sCredInvx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("sCompnyNm", new TableInfo.Column("sCompnyNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("sSpouseNm", new TableInfo.Column("sSpouseNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("sAddressx", new TableInfo.Column("sAddressx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("sMobileNo", new TableInfo.Column("sMobileNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("sQMAppCde", new TableInfo.Column("sQMAppCde", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("sModelNme", new TableInfo.Column("sModelNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("nDownPaym", new TableInfo.Column("nDownPaym", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("nAcctTerm", new TableInfo.Column("nAcctTerm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("sCreatedx", new TableInfo.Column("sCreatedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationList.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCreditOnlineApplicationList = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCreditOnlineApplicationList = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCreditOnlineApplicationList = new TableInfo("Credit_Online_Application_List", _columnsCreditOnlineApplicationList, _foreignKeysCreditOnlineApplicationList, _indicesCreditOnlineApplicationList);
        final TableInfo _existingCreditOnlineApplicationList = TableInfo.read(_db, "Credit_Online_Application_List");
        if (! _infoCreditOnlineApplicationList.equals(_existingCreditOnlineApplicationList)) {
          return new RoomOpenHelper.ValidationResult(false, "Credit_Online_Application_List(org.rmj.g3appdriver.GCircle.room.Entities.EBranchLoanApplication).\n"
                  + " Expected:\n" + _infoCreditOnlineApplicationList + "\n"
                  + " Found:\n" + _existingCreditOnlineApplicationList);
        }
        final HashMap<String, TableInfo.Column> _columnsUncapturedClientImage = new HashMap<String, TableInfo.Column>(3);
        _columnsUncapturedClientImage.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUncapturedClientImage.put("sClientNm", new TableInfo.Column("sClientNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUncapturedClientImage.put("sSourceNo", new TableInfo.Column("sSourceNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUncapturedClientImage = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUncapturedClientImage = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUncapturedClientImage = new TableInfo("Uncaptured_Client_Image", _columnsUncapturedClientImage, _foreignKeysUncapturedClientImage, _indicesUncapturedClientImage);
        final TableInfo _existingUncapturedClientImage = TableInfo.read(_db, "Uncaptured_Client_Image");
        if (! _infoUncapturedClientImage.equals(_existingUncapturedClientImage)) {
          return new RoomOpenHelper.ValidationResult(false, "Uncaptured_Client_Image(org.rmj.g3appdriver.GCircle.room.Entities.EUncapturedClient).\n"
                  + " Expected:\n" + _infoUncapturedClientImage + "\n"
                  + " Found:\n" + _existingUncapturedClientImage);
        }
        final HashMap<String, TableInfo.Column> _columnsCreditOnlineApplicationListCI = new HashMap<String, TableInfo.Column>(48);
        _columnsCreditOnlineApplicationListCI.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sCredInvx", new TableInfo.Column("sCredInvx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sLandMark", new TableInfo.Column("sLandMark", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cOwnershp", new TableInfo.Column("cOwnershp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cOwnOther", new TableInfo.Column("cOwnOther", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cHouseTyp", new TableInfo.Column("cHouseTyp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cGaragexx", new TableInfo.Column("cGaragexx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("nLatitude", new TableInfo.Column("nLatitude", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("nLongitud", new TableInfo.Column("nLongitud", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cHasOther", new TableInfo.Column("cHasOther", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cHasRecrd", new TableInfo.Column("cHasRecrd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sRemRecrd", new TableInfo.Column("sRemRecrd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sNeighbr1", new TableInfo.Column("sNeighbr1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sAddress1", new TableInfo.Column("sAddress1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sReltnCD1", new TableInfo.Column("sReltnCD1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sMobileN1", new TableInfo.Column("sMobileN1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cFeedBck1", new TableInfo.Column("cFeedBck1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sFeedBck1", new TableInfo.Column("sFeedBck1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sNeighbr2", new TableInfo.Column("sNeighbr2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sAddress2", new TableInfo.Column("sAddress2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sReltnCD2", new TableInfo.Column("sReltnCD2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sMobileN2", new TableInfo.Column("sMobileN2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cFeedBck2", new TableInfo.Column("cFeedBck2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sFBRemrk2", new TableInfo.Column("sFBRemrk2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sNeighbr3", new TableInfo.Column("sNeighbr3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sAddress3", new TableInfo.Column("sAddress3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sReltnCD3", new TableInfo.Column("sReltnCD3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sMobileN3", new TableInfo.Column("sMobileN3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cFeedBck3", new TableInfo.Column("cFeedBck3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sFBRemrk3", new TableInfo.Column("sFBRemrk3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("nWaterBil", new TableInfo.Column("nWaterBil", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("nElctrcBl", new TableInfo.Column("nElctrcBl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("nFoodAllw", new TableInfo.Column("nFoodAllw", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("nLoanAmtx", new TableInfo.Column("nLoanAmtx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("nEducExpn", new TableInfo.Column("nEducExpn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("nOthrExpn", new TableInfo.Column("nOthrExpn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cGamblerx", new TableInfo.Column("cGamblerx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cWomanizr", new TableInfo.Column("cWomanizr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cHvyBrwer", new TableInfo.Column("cHvyBrwer", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cWithRepo", new TableInfo.Column("cWithRepo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cWithMort", new TableInfo.Column("cWithMort", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cArrogant", new TableInfo.Column("cArrogant", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sOtherBad", new TableInfo.Column("sOtherBad", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("dApproved", new TableInfo.Column("dApproved", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("dReceived", new TableInfo.Column("dReceived", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationListCI.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCreditOnlineApplicationListCI = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCreditOnlineApplicationListCI = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCreditOnlineApplicationListCI = new TableInfo("Credit_Online_Application_List_CI", _columnsCreditOnlineApplicationListCI, _foreignKeysCreditOnlineApplicationListCI, _indicesCreditOnlineApplicationListCI);
        final TableInfo _existingCreditOnlineApplicationListCI = TableInfo.read(_db, "Credit_Online_Application_List_CI");
        if (! _infoCreditOnlineApplicationListCI.equals(_existingCreditOnlineApplicationListCI)) {
          return new RoomOpenHelper.ValidationResult(false, "Credit_Online_Application_List_CI(org.rmj.g3appdriver.GCircle.room.Entities.ECIEvaluation).\n"
                  + " Expected:\n" + _infoCreditOnlineApplicationListCI + "\n"
                  + " Found:\n" + _existingCreditOnlineApplicationListCI);
        }
        final HashMap<String, TableInfo.Column> _columnsLRDCPRemittance = new HashMap<String, TableInfo.Column>(12);
        _columnsLRDCPRemittance.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("nEntryNox", new TableInfo.Column("nEntryNox", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("cPaymForm", new TableInfo.Column("cPaymForm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("cRemitTyp", new TableInfo.Column("cRemitTyp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("sCompnyNm", new TableInfo.Column("sCompnyNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("sBankAcct", new TableInfo.Column("sBankAcct", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("sReferNox", new TableInfo.Column("sReferNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("nAmountxx", new TableInfo.Column("nAmountxx", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("dDateSent", new TableInfo.Column("dDateSent", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLRDCPRemittance.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLRDCPRemittance = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLRDCPRemittance = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLRDCPRemittance = new TableInfo("LR_DCP_Remittance", _columnsLRDCPRemittance, _foreignKeysLRDCPRemittance, _indicesLRDCPRemittance);
        final TableInfo _existingLRDCPRemittance = TableInfo.read(_db, "LR_DCP_Remittance");
        if (! _infoLRDCPRemittance.equals(_existingLRDCPRemittance)) {
          return new RoomOpenHelper.ValidationResult(false, "LR_DCP_Remittance(org.rmj.g3appdriver.GCircle.room.Entities.EDCP_Remittance).\n"
                  + " Expected:\n" + _infoLRDCPRemittance + "\n"
                  + " Found:\n" + _existingLRDCPRemittance);
        }
        final HashMap<String, TableInfo.Column> _columnsCollectionAccountRemittance = new HashMap<String, TableInfo.Column>(5);
        _columnsCollectionAccountRemittance.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCollectionAccountRemittance.put("sActNumbr", new TableInfo.Column("sActNumbr", "TEXT", true, 3, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCollectionAccountRemittance.put("sBnkActID", new TableInfo.Column("sBnkActID", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCollectionAccountRemittance.put("sBranchNm", new TableInfo.Column("sBranchNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCollectionAccountRemittance.put("sActNamex", new TableInfo.Column("sActNamex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCollectionAccountRemittance = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCollectionAccountRemittance = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCollectionAccountRemittance = new TableInfo("Collection_Account_Remittance", _columnsCollectionAccountRemittance, _foreignKeysCollectionAccountRemittance, _indicesCollectionAccountRemittance);
        final TableInfo _existingCollectionAccountRemittance = TableInfo.read(_db, "Collection_Account_Remittance");
        if (! _infoCollectionAccountRemittance.equals(_existingCollectionAccountRemittance)) {
          return new RoomOpenHelper.ValidationResult(false, "Collection_Account_Remittance(org.rmj.g3appdriver.GCircle.room.Entities.ERemittanceAccounts).\n"
                  + " Expected:\n" + _infoCollectionAccountRemittance + "\n"
                  + " Found:\n" + _existingCollectionAccountRemittance);
        }
        final HashMap<String, TableInfo.Column> _columnsXxxSysConfig = new HashMap<String, TableInfo.Column>(4);
        _columnsXxxSysConfig.put("sConfigCd", new TableInfo.Column("sConfigCd", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSysConfig.put("sConfigDs", new TableInfo.Column("sConfigDs", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSysConfig.put("sConfigVl", new TableInfo.Column("sConfigVl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxSysConfig.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysXxxSysConfig = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesXxxSysConfig = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoXxxSysConfig = new TableInfo("xxxSysConfig", _columnsXxxSysConfig, _foreignKeysXxxSysConfig, _indicesXxxSysConfig);
        final TableInfo _existingXxxSysConfig = TableInfo.read(_db, "xxxSysConfig");
        if (! _infoXxxSysConfig.equals(_existingXxxSysConfig)) {
          return new RoomOpenHelper.ValidationResult(false, "xxxSysConfig(org.rmj.g3appdriver.GCircle.room.Entities.ESysConfig).\n"
                  + " Expected:\n" + _infoXxxSysConfig + "\n"
                  + " Found:\n" + _existingXxxSysConfig);
        }
        final HashMap<String, TableInfo.Column> _columnsGLocatorSysLog = new HashMap<String, TableInfo.Column>(11);
        _columnsGLocatorSysLog.put("sLoctnIDx", new TableInfo.Column("sLoctnIDx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGLocatorSysLog.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGLocatorSysLog.put("sDeviceID", new TableInfo.Column("sDeviceID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGLocatorSysLog.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGLocatorSysLog.put("nLongitud", new TableInfo.Column("nLongitud", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGLocatorSysLog.put("nLatitude", new TableInfo.Column("nLatitude", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGLocatorSysLog.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGLocatorSysLog.put("cGpsEnbld", new TableInfo.Column("cGpsEnbld", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGLocatorSysLog.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGLocatorSysLog.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGLocatorSysLog.put("dLstUpdte", new TableInfo.Column("dLstUpdte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGLocatorSysLog = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGLocatorSysLog = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGLocatorSysLog = new TableInfo("GLocator_Sys_log", _columnsGLocatorSysLog, _foreignKeysGLocatorSysLog, _indicesGLocatorSysLog);
        final TableInfo _existingGLocatorSysLog = TableInfo.read(_db, "GLocator_Sys_log");
        if (! _infoGLocatorSysLog.equals(_existingGLocatorSysLog)) {
          return new RoomOpenHelper.ValidationResult(false, "GLocator_Sys_log(org.rmj.g3appdriver.GCircle.room.Entities.EGLocatorSysLog).\n"
                  + " Expected:\n" + _infoGLocatorSysLog + "\n"
                  + " Found:\n" + _existingGLocatorSysLog);
        }
        final HashMap<String, TableInfo.Column> _columnsRelation = new HashMap<String, TableInfo.Column>(4);
        _columnsRelation.put("sRelatnID", new TableInfo.Column("sRelatnID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelation.put("sRelatnDs", new TableInfo.Column("sRelatnDs", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelation.put("cRecdStats", new TableInfo.Column("cRecdStats", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRelation.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRelation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRelation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRelation = new TableInfo("Relation", _columnsRelation, _foreignKeysRelation, _indicesRelation);
        final TableInfo _existingRelation = TableInfo.read(_db, "Relation");
        if (! _infoRelation.equals(_existingRelation)) {
          return new RoomOpenHelper.ValidationResult(false, "Relation(org.rmj.g3appdriver.GCircle.room.Entities.ERelation).\n"
                  + " Expected:\n" + _infoRelation + "\n"
                  + " Found:\n" + _existingRelation);
        }
        final HashMap<String, TableInfo.Column> _columnsNNDMEventRequest = new HashMap<String, TableInfo.Column>(9);
        _columnsNNDMEventRequest.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNNDMEventRequest.put("sSourceNo", new TableInfo.Column("sSourceNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNNDMEventRequest.put("sSourceCD", new TableInfo.Column("sSourceCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNNDMEventRequest.put("sReqstTyp", new TableInfo.Column("sReqstTyp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNNDMEventRequest.put("sJsonData", new TableInfo.Column("sJsonData", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNNDMEventRequest.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNNDMEventRequest.put("dCreatedx", new TableInfo.Column("dCreatedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNNDMEventRequest.put("dReceived", new TableInfo.Column("dReceived", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsNNDMEventRequest.put("dPostedxx", new TableInfo.Column("dPostedxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysNNDMEventRequest = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesNNDMEventRequest = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoNNDMEventRequest = new TableInfo("NNDM_Event_Request", _columnsNNDMEventRequest, _foreignKeysNNDMEventRequest, _indicesNNDMEventRequest);
        final TableInfo _existingNNDMEventRequest = TableInfo.read(_db, "NNDM_Event_Request");
        if (! _infoNNDMEventRequest.equals(_existingNNDMEventRequest)) {
          return new RoomOpenHelper.ValidationResult(false, "NNDM_Event_Request(org.rmj.g3appdriver.GCircle.room.Entities.ENNDMRequest).\n"
                  + " Expected:\n" + _infoNNDMEventRequest + "\n"
                  + " Found:\n" + _existingNNDMEventRequest);
        }
        final HashMap<String, TableInfo.Column> _columnsXxxAppConfig = new HashMap<String, TableInfo.Column>(4);
        _columnsXxxAppConfig.put("sConfigCd", new TableInfo.Column("sConfigCd", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAppConfig.put("sConfigDs", new TableInfo.Column("sConfigDs", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAppConfig.put("sConfigVl", new TableInfo.Column("sConfigVl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAppConfig.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysXxxAppConfig = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesXxxAppConfig = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoXxxAppConfig = new TableInfo("xxxAppConfig", _columnsXxxAppConfig, _foreignKeysXxxAppConfig, _indicesXxxAppConfig);
        final TableInfo _existingXxxAppConfig = TableInfo.read(_db, "xxxAppConfig");
        if (! _infoXxxAppConfig.equals(_existingXxxAppConfig)) {
          return new RoomOpenHelper.ValidationResult(false, "xxxAppConfig(org.rmj.g3appdriver.GCircle.room.Entities.EAppConfig).\n"
                  + " Expected:\n" + _infoXxxAppConfig + "\n"
                  + " Found:\n" + _existingXxxAppConfig);
        }
        final HashMap<String, TableInfo.Column> _columnsCashCountMaster = new HashMap<String, TableInfo.Column>(30);
        _columnsCashCountMaster.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nCn0001cx", new TableInfo.Column("nCn0001cx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nCn0005cx", new TableInfo.Column("nCn0005cx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nCn0010cx", new TableInfo.Column("nCn0010cx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nCn0025cx", new TableInfo.Column("nCn0025cx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nCn0050cx", new TableInfo.Column("nCn0050cx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nCn0001px", new TableInfo.Column("nCn0001px", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nCn0005px", new TableInfo.Column("nCn0005px", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nCn0010px", new TableInfo.Column("nCn0010px", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nNte0020p", new TableInfo.Column("nNte0020p", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nNte0050p", new TableInfo.Column("nNte0050p", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nNte0100p", new TableInfo.Column("nNte0100p", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nNte0200p", new TableInfo.Column("nNte0200p", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nNte0500p", new TableInfo.Column("nNte0500p", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("nNte1000p", new TableInfo.Column("nNte1000p", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sPettyAmt", new TableInfo.Column("sPettyAmt", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sORNoxxxx", new TableInfo.Column("sORNoxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sSINoxxxx", new TableInfo.Column("sSINoxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sPRNoxxxx", new TableInfo.Column("sPRNoxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sCRNoxxxx", new TableInfo.Column("sCRNoxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sORNoxNPt", new TableInfo.Column("sORNoxNPt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sPRNoxNPt", new TableInfo.Column("sPRNoxNPt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sDRNoxxxx", new TableInfo.Column("sDRNoxxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("dEntryDte", new TableInfo.Column("dEntryDte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sReqstdBy", new TableInfo.Column("sReqstdBy", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCashCountMaster.put("sSendStat", new TableInfo.Column("sSendStat", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCashCountMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCashCountMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCashCountMaster = new TableInfo("Cash_Count_Master", _columnsCashCountMaster, _foreignKeysCashCountMaster, _indicesCashCountMaster);
        final TableInfo _existingCashCountMaster = TableInfo.read(_db, "Cash_Count_Master");
        if (! _infoCashCountMaster.equals(_existingCashCountMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "Cash_Count_Master(org.rmj.g3appdriver.GCircle.room.Entities.ECashCount).\n"
                  + " Expected:\n" + _infoCashCountMaster + "\n"
                  + " Found:\n" + _existingCashCountMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsBranchOpening = new HashMap<String, TableInfo.Column>(7);
        _columnsBranchOpening.put("sBranchCD", new TableInfo.Column("sBranchCD", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchOpening.put("dTransact", new TableInfo.Column("dTransact", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchOpening.put("sTimeOpen", new TableInfo.Column("sTimeOpen", "TEXT", true, 3, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchOpening.put("sOpenNowx", new TableInfo.Column("sOpenNowx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchOpening.put("dSendDate", new TableInfo.Column("dSendDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchOpening.put("dNotified", new TableInfo.Column("dNotified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchOpening.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBranchOpening = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBranchOpening = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBranchOpening = new TableInfo("Branch_Opening", _columnsBranchOpening, _foreignKeysBranchOpening, _indicesBranchOpening);
        final TableInfo _existingBranchOpening = TableInfo.read(_db, "Branch_Opening");
        if (! _infoBranchOpening.equals(_existingBranchOpening)) {
          return new RoomOpenHelper.ValidationResult(false, "Branch_Opening(org.rmj.g3appdriver.GCircle.room.Entities.EBranchOpenMonitor).\n"
                  + " Expected:\n" + _infoBranchOpening + "\n"
                  + " Found:\n" + _existingBranchOpening);
        }
        final HashMap<String, TableInfo.Column> _columnsEmployeeLeave = new HashMap<String, TableInfo.Column>(28);
        _columnsEmployeeLeave.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("sEmployNm", new TableInfo.Column("sEmployNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("sEmployID", new TableInfo.Column("sEmployID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("sBranchNm", new TableInfo.Column("sBranchNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("sDeptName", new TableInfo.Column("sDeptName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("sPositnNm", new TableInfo.Column("sPositnNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("dDateFrom", new TableInfo.Column("dDateFrom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("dDateThru", new TableInfo.Column("dDateThru", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("nNoDaysxx", new TableInfo.Column("nNoDaysxx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("sPurposex", new TableInfo.Column("sPurposex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("cLeaveTyp", new TableInfo.Column("cLeaveTyp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("dAppldFrx", new TableInfo.Column("dAppldFrx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("dAppldTox", new TableInfo.Column("dAppldTox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("sEntryByx", new TableInfo.Column("sEntryByx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("dEntryDte", new TableInfo.Column("dEntryDte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("nWithPayx", new TableInfo.Column("nWithPayx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("nWithOPay", new TableInfo.Column("nWithOPay", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("nEqualHrs", new TableInfo.Column("nEqualHrs", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("sApproved", new TableInfo.Column("sApproved", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("dApproved", new TableInfo.Column("dApproved", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("cSentStat", new TableInfo.Column("cSentStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("cAppvSent", new TableInfo.Column("cAppvSent", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("dSendDate", new TableInfo.Column("dSendDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("nLveCredt", new TableInfo.Column("nLveCredt", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeLeave.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmployeeLeave = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEmployeeLeave = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEmployeeLeave = new TableInfo("Employee_Leave", _columnsEmployeeLeave, _foreignKeysEmployeeLeave, _indicesEmployeeLeave);
        final TableInfo _existingEmployeeLeave = TableInfo.read(_db, "Employee_Leave");
        if (! _infoEmployeeLeave.equals(_existingEmployeeLeave)) {
          return new RoomOpenHelper.ValidationResult(false, "Employee_Leave(org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeLeave).\n"
                  + " Expected:\n" + _infoEmployeeLeave + "\n"
                  + " Found:\n" + _existingEmployeeLeave);
        }
        final HashMap<String, TableInfo.Column> _columnsEmployeeBusinessTrip = new HashMap<String, TableInfo.Column>(20);
        _columnsEmployeeBusinessTrip.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("xEmployee", new TableInfo.Column("xEmployee", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("sFullName", new TableInfo.Column("sFullName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("sBranchNm", new TableInfo.Column("sBranchNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("sDeptName", new TableInfo.Column("sDeptName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("sPositnNm", new TableInfo.Column("sPositnNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("dDateFrom", new TableInfo.Column("dDateFrom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("dDateThru", new TableInfo.Column("dDateThru", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("sDestinat", new TableInfo.Column("sDestinat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("sApproved", new TableInfo.Column("sApproved", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("dApproved", new TableInfo.Column("dApproved", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("dAppldFrx", new TableInfo.Column("dAppldFrx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("dAppldTox", new TableInfo.Column("dAppldTox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("sModified", new TableInfo.Column("sModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeBusinessTrip.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmployeeBusinessTrip = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEmployeeBusinessTrip = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEmployeeBusinessTrip = new TableInfo("Employee_Business_Trip", _columnsEmployeeBusinessTrip, _foreignKeysEmployeeBusinessTrip, _indicesEmployeeBusinessTrip);
        final TableInfo _existingEmployeeBusinessTrip = TableInfo.read(_db, "Employee_Business_Trip");
        if (! _infoEmployeeBusinessTrip.equals(_existingEmployeeBusinessTrip)) {
          return new RoomOpenHelper.ValidationResult(false, "Employee_Business_Trip(org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeBusinessTrip).\n"
                  + " Expected:\n" + _infoEmployeeBusinessTrip + "\n"
                  + " Found:\n" + _existingEmployeeBusinessTrip);
        }
        final HashMap<String, TableInfo.Column> _columnsXxxAOEmpRole = new HashMap<String, TableInfo.Column>(9);
        _columnsXxxAOEmpRole.put("sObjectNm", new TableInfo.Column("sObjectNm", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAOEmpRole.put("sObjectDs", new TableInfo.Column("sObjectDs", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAOEmpRole.put("cObjectTp", new TableInfo.Column("cObjectTp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAOEmpRole.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAOEmpRole.put("sParentxx", new TableInfo.Column("sParentxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAOEmpRole.put("sSeqnceCd", new TableInfo.Column("sSeqnceCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAOEmpRole.put("cHasChild", new TableInfo.Column("cHasChild", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAOEmpRole.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsXxxAOEmpRole.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysXxxAOEmpRole = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesXxxAOEmpRole = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoXxxAOEmpRole = new TableInfo("xxxAOEmpRole", _columnsXxxAOEmpRole, _foreignKeysXxxAOEmpRole, _indicesXxxAOEmpRole);
        final TableInfo _existingXxxAOEmpRole = TableInfo.read(_db, "xxxAOEmpRole");
        if (! _infoXxxAOEmpRole.equals(_existingXxxAOEmpRole)) {
          return new RoomOpenHelper.ValidationResult(false, "xxxAOEmpRole(org.rmj.g3appdriver.GCircle.room.Entities.EEmployeeRole).\n"
                  + " Expected:\n" + _infoXxxAOEmpRole + "\n"
                  + " Found:\n" + _existingXxxAOEmpRole);
        }
        RoomOpenHelper.ValidationResult _result;
        _result = onValidateSchema2(_db);
        if (!_result.isValid) {
          return _result;
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }

      private RoomOpenHelper.ValidationResult onValidateSchema2(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsInventoryCountMaster = new HashMap<String, TableInfo.Column>(13);
        _columnsInventoryCountMaster.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("nEntryNox", new TableInfo.Column("nEntryNox", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("sRqstdByx", new TableInfo.Column("sRqstdByx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("sVerified", new TableInfo.Column("sVerified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("dVerified", new TableInfo.Column("dVerified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("sApproved", new TableInfo.Column("sApproved", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("dApproved", new TableInfo.Column("dApproved", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("sModified", new TableInfo.Column("sModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountMaster.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInventoryCountMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInventoryCountMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInventoryCountMaster = new TableInfo("Inventory_Count_Master", _columnsInventoryCountMaster, _foreignKeysInventoryCountMaster, _indicesInventoryCountMaster);
        final TableInfo _existingInventoryCountMaster = TableInfo.read(_db, "Inventory_Count_Master");
        if (! _infoInventoryCountMaster.equals(_existingInventoryCountMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "Inventory_Count_Master(org.rmj.g3appdriver.GCircle.room.Entities.EInventoryMaster).\n"
                  + " Expected:\n" + _infoInventoryCountMaster + "\n"
                  + " Found:\n" + _existingInventoryCountMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsInventoryCountDetail = new HashMap<String, TableInfo.Column>(20);
        _columnsInventoryCountDetail.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("nEntryNox", new TableInfo.Column("nEntryNox", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("sBarrCode", new TableInfo.Column("sBarrCode", "TEXT", true, 3, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("sPartsIDx", new TableInfo.Column("sPartsIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("sDescript", new TableInfo.Column("sDescript", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("sWHouseID", new TableInfo.Column("sWHouseID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("sWHouseNm", new TableInfo.Column("sWHouseNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("sSectnIDx", new TableInfo.Column("sSectnIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("sSectnNme", new TableInfo.Column("sSectnNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("sBinIDxxx", new TableInfo.Column("sBinIDxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("sBinNamex", new TableInfo.Column("sBinNamex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("nQtyOnHnd", new TableInfo.Column("nQtyOnHnd", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("nActCtr01", new TableInfo.Column("nActCtr01", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("nActCtr02", new TableInfo.Column("nActCtr02", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("nActCtr03", new TableInfo.Column("nActCtr03", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("nLedgerNo", new TableInfo.Column("nLedgerNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("nBegQtyxx", new TableInfo.Column("nBegQtyxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInventoryCountDetail.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInventoryCountDetail = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInventoryCountDetail = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInventoryCountDetail = new TableInfo("Inventory_Count_Detail", _columnsInventoryCountDetail, _foreignKeysInventoryCountDetail, _indicesInventoryCountDetail);
        final TableInfo _existingInventoryCountDetail = TableInfo.read(_db, "Inventory_Count_Detail");
        if (! _infoInventoryCountDetail.equals(_existingInventoryCountDetail)) {
          return new RoomOpenHelper.ValidationResult(false, "Inventory_Count_Detail(org.rmj.g3appdriver.GCircle.room.Entities.EInventoryDetail).\n"
                  + " Expected:\n" + _infoInventoryCountDetail + "\n"
                  + " Found:\n" + _existingInventoryCountDetail);
        }
        final HashMap<String, TableInfo.Column> _columnsCreditOnlineApplicationCI = new HashMap<String, TableInfo.Column>(32);
        _columnsCreditOnlineApplicationCI.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sCredInvx", new TableInfo.Column("sCredInvx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sManagerx", new TableInfo.Column("sManagerx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sAddressx", new TableInfo.Column("sAddressx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sAddrFndg", new TableInfo.Column("sAddrFndg", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sAssetsxx", new TableInfo.Column("sAssetsxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sAsstFndg", new TableInfo.Column("sAsstFndg", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sIncomexx", new TableInfo.Column("sIncomexx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sIncmFndg", new TableInfo.Column("sIncmFndg", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("cHasRecrd", new TableInfo.Column("cHasRecrd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sRecrdRem", new TableInfo.Column("sRecrdRem", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sPrsnBrgy", new TableInfo.Column("sPrsnBrgy", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sPrsnPstn", new TableInfo.Column("sPrsnPstn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sPrsnNmbr", new TableInfo.Column("sPrsnNmbr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sNeighBr1", new TableInfo.Column("sNeighBr1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sNeighBr2", new TableInfo.Column("sNeighBr2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sNeighBr3", new TableInfo.Column("sNeighBr3", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("dRcmdRcd1", new TableInfo.Column("dRcmdRcd1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("dRcmdtnx1", new TableInfo.Column("dRcmdtnx1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("cRcmdtnx1", new TableInfo.Column("cRcmdtnx1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sRcmdtnx1", new TableInfo.Column("sRcmdtnx1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("dRcmdRcd2", new TableInfo.Column("dRcmdRcd2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("dRcmdtnx2", new TableInfo.Column("dRcmdtnx2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("cRcmdtnx2", new TableInfo.Column("cRcmdtnx2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sRcmdtnx2", new TableInfo.Column("sRcmdtnx2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("cUploaded", new TableInfo.Column("cUploaded", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("cTransfer", new TableInfo.Column("cTransfer", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("sApproved", new TableInfo.Column("sApproved", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("dApproved", new TableInfo.Column("dApproved", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCreditOnlineApplicationCI.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, "CURRENT_TIMESTAMP", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCreditOnlineApplicationCI = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCreditOnlineApplicationCI = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCreditOnlineApplicationCI = new TableInfo("Credit_Online_Application_CI", _columnsCreditOnlineApplicationCI, _foreignKeysCreditOnlineApplicationCI, _indicesCreditOnlineApplicationCI);
        final TableInfo _existingCreditOnlineApplicationCI = TableInfo.read(_db, "Credit_Online_Application_CI");
        if (! _infoCreditOnlineApplicationCI.equals(_existingCreditOnlineApplicationCI)) {
          return new RoomOpenHelper.ValidationResult(false, "Credit_Online_Application_CI(org.rmj.g3appdriver.GCircle.room.Entities.ECreditOnlineApplicationCI).\n"
                  + " Expected:\n" + _infoCreditOnlineApplicationCI + "\n"
                  + " Found:\n" + _existingCreditOnlineApplicationCI);
        }
        final HashMap<String, TableInfo.Column> _columnsEmployeeItinerary = new HashMap<String, TableInfo.Column>(9);
        _columnsEmployeeItinerary.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeItinerary.put("sEmployID", new TableInfo.Column("sEmployID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeItinerary.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeItinerary.put("dTimeFrom", new TableInfo.Column("dTimeFrom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeItinerary.put("dTimeThru", new TableInfo.Column("dTimeThru", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeItinerary.put("sLocation", new TableInfo.Column("sLocation", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeItinerary.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeItinerary.put("cSendStat", new TableInfo.Column("cSendStat", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEmployeeItinerary.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEmployeeItinerary = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEmployeeItinerary = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEmployeeItinerary = new TableInfo("Employee_Itinerary", _columnsEmployeeItinerary, _foreignKeysEmployeeItinerary, _indicesEmployeeItinerary);
        final TableInfo _existingEmployeeItinerary = TableInfo.read(_db, "Employee_Itinerary");
        if (! _infoEmployeeItinerary.equals(_existingEmployeeItinerary)) {
          return new RoomOpenHelper.ValidationResult(false, "Employee_Itinerary(org.rmj.g3appdriver.GCircle.room.Entities.EItinerary).\n"
                  + " Expected:\n" + _infoEmployeeItinerary + "\n"
                  + " Found:\n" + _existingEmployeeItinerary);
        }
        final HashMap<String, TableInfo.Column> _columnsPanaloReward = new HashMap<String, TableInfo.Column>(4);
        _columnsPanaloReward.put("sPanaloCD", new TableInfo.Column("sPanaloCD", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPanaloReward.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPanaloReward.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPanaloReward.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPanaloReward = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPanaloReward = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPanaloReward = new TableInfo("Panalo_Reward", _columnsPanaloReward, _foreignKeysPanaloReward, _indicesPanaloReward);
        final TableInfo _existingPanaloReward = TableInfo.read(_db, "Panalo_Reward");
        if (! _infoPanaloReward.equals(_existingPanaloReward)) {
          return new RoomOpenHelper.ValidationResult(false, "Panalo_Reward(org.rmj.g3appdriver.GCircle.room.Entities.EPanaloReward).\n"
                  + " Expected:\n" + _infoPanaloReward + "\n"
                  + " Found:\n" + _existingPanaloReward);
        }
        final HashMap<String, TableInfo.Column> _columnsRaffleStatus = new HashMap<String, TableInfo.Column>(2);
        _columnsRaffleStatus.put("sStatusID", new TableInfo.Column("sStatusID", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRaffleStatus.put("HasRffle", new TableInfo.Column("HasRffle", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRaffleStatus = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRaffleStatus = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRaffleStatus = new TableInfo("Raffle_Status", _columnsRaffleStatus, _foreignKeysRaffleStatus, _indicesRaffleStatus);
        final TableInfo _existingRaffleStatus = TableInfo.read(_db, "Raffle_Status");
        if (! _infoRaffleStatus.equals(_existingRaffleStatus)) {
          return new RoomOpenHelper.ValidationResult(false, "Raffle_Status(org.rmj.g3appdriver.GCircle.room.Entities.ERaffleStatus).\n"
                  + " Expected:\n" + _infoRaffleStatus + "\n"
                  + " Found:\n" + _existingRaffleStatus);
        }
        final HashMap<String, TableInfo.Column> _columnsPacitaRule = new HashMap<String, TableInfo.Column>(7);
        _columnsPacitaRule.put("nEntryNox", new TableInfo.Column("nEntryNox", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaRule.put("sFieldNmx", new TableInfo.Column("sFieldNmx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaRule.put("nMaxValue", new TableInfo.Column("nMaxValue", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaRule.put("cParentxx", new TableInfo.Column("cParentxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaRule.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaRule.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaRule.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPacitaRule = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPacitaRule = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPacitaRule = new TableInfo("Pacita_Rule", _columnsPacitaRule, _foreignKeysPacitaRule, _indicesPacitaRule);
        final TableInfo _existingPacitaRule = TableInfo.read(_db, "Pacita_Rule");
        if (! _infoPacitaRule.equals(_existingPacitaRule)) {
          return new RoomOpenHelper.ValidationResult(false, "Pacita_Rule(org.rmj.g3appdriver.GCircle.room.Entities.EPacitaRule).\n"
                  + " Expected:\n" + _infoPacitaRule + "\n"
                  + " Found:\n" + _existingPacitaRule);
        }
        final HashMap<String, TableInfo.Column> _columnsPacitaEvaluation = new HashMap<String, TableInfo.Column>(10);
        _columnsPacitaEvaluation.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaEvaluation.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaEvaluation.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaEvaluation.put("sBranchCD", new TableInfo.Column("sBranchCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaEvaluation.put("sPayloadx", new TableInfo.Column("sPayloadx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaEvaluation.put("nRatingxx", new TableInfo.Column("nRatingxx", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaEvaluation.put("sEvalType", new TableInfo.Column("sEvalType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaEvaluation.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaEvaluation.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPacitaEvaluation.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPacitaEvaluation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPacitaEvaluation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPacitaEvaluation = new TableInfo("Pacita_Evaluation", _columnsPacitaEvaluation, _foreignKeysPacitaEvaluation, _indicesPacitaEvaluation);
        final TableInfo _existingPacitaEvaluation = TableInfo.read(_db, "Pacita_Evaluation");
        if (! _infoPacitaEvaluation.equals(_existingPacitaEvaluation)) {
          return new RoomOpenHelper.ValidationResult(false, "Pacita_Evaluation(org.rmj.g3appdriver.GCircle.room.Entities.EPacitaEvaluation).\n"
                  + " Expected:\n" + _infoPacitaEvaluation + "\n"
                  + " Found:\n" + _existingPacitaEvaluation);
        }
        final HashMap<String, TableInfo.Column> _columnsInstallmentTerm = new HashMap<String, TableInfo.Column>(4);
        _columnsInstallmentTerm.put("nTermCode", new TableInfo.Column("nTermCode", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstallmentTerm.put("sTermDesc", new TableInfo.Column("sTermDesc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstallmentTerm.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsInstallmentTerm.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysInstallmentTerm = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesInstallmentTerm = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoInstallmentTerm = new TableInfo("Installment_Term", _columnsInstallmentTerm, _foreignKeysInstallmentTerm, _indicesInstallmentTerm);
        final TableInfo _existingInstallmentTerm = TableInfo.read(_db, "Installment_Term");
        if (! _infoInstallmentTerm.equals(_existingInstallmentTerm)) {
          return new RoomOpenHelper.ValidationResult(false, "Installment_Term(org.rmj.g3appdriver.GCircle.room.Entities.ELoanTerm).\n"
                  + " Expected:\n" + _infoInstallmentTerm + "\n"
                  + " Found:\n" + _existingInstallmentTerm);
        }
        final HashMap<String, TableInfo.Column> _columnsGanadoOnline = new HashMap<String, TableInfo.Column>(20);
        _columnsGanadoOnline.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("cGanadoTp", new TableInfo.Column("cGanadoTp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("cPaymForm", new TableInfo.Column("cPaymForm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("sClientNm", new TableInfo.Column("sClientNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("sClntInfo", new TableInfo.Column("sClntInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("sProdInfo", new TableInfo.Column("sProdInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("sPaymInfo", new TableInfo.Column("sPaymInfo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("dTargetxx", new TableInfo.Column("dTargetxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("dFollowUp", new TableInfo.Column("dFollowUp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("sReferdBy", new TableInfo.Column("sReferdBy", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("sRelatnID", new TableInfo.Column("sRelatnID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("dCreatedx", new TableInfo.Column("dCreatedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("dLastUpdt", new TableInfo.Column("dLastUpdt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("sBranchCD", new TableInfo.Column("sBranchCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGanadoOnline.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGanadoOnline = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGanadoOnline = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGanadoOnline = new TableInfo("Ganado_Online", _columnsGanadoOnline, _foreignKeysGanadoOnline, _indicesGanadoOnline);
        final TableInfo _existingGanadoOnline = TableInfo.read(_db, "Ganado_Online");
        if (! _infoGanadoOnline.equals(_existingGanadoOnline)) {
          return new RoomOpenHelper.ValidationResult(false, "Ganado_Online(org.rmj.g3appdriver.GCircle.room.Entities.EGanadoOnline).\n"
                  + " Expected:\n" + _infoGanadoOnline + "\n"
                  + " Found:\n" + _existingGanadoOnline);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "d04908b4fdf3de64e7963ca5748f39ac", "62d8f7610ef4909532dc9260b8a66a8b");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Branch_Info","MC_Brand","Mc_Model","MC_Category","Province_Info","Mc_Model_Price","MC_Model_Color","Town_Info","Barangay_Info","MC_Term_Category","Country_Info","Occupation_Info","Credit_Online_Application","Credit_Applicant_Info","MC_Area_Performance","MC_Branch_Performance","FB_Raffle_Transaction_Basis","PromoLocal_Detail","Notification_Info_Master","Notification_Info_Recepient","Notification_User","System_Code_Approval","xxxSCA_Request","LR_DCP_Collection_Master","LR_DCP_Collection_Detail","Address_Update_Request","Mobile_Update_Request","Image_Information","User_Info_Master","EDocSys_File","Client_Info_Master","App_Token_Info","Credit_Online_Application_Documents","Client_Update_Request","Bank_Info","Employee_Log_Selfie","Credit_Online_Application_List","Uncaptured_Client_Image","Credit_Online_Application_List_CI","LR_DCP_Remittance","Collection_Account_Remittance","xxxSysConfig","GLocator_Sys_log","Relation","NNDM_Event_Request","xxxAppConfig","Cash_Count_Master","Branch_Opening","Employee_Leave","Employee_Business_Trip","xxxAOEmpRole","Inventory_Count_Master","Inventory_Count_Detail","Credit_Online_Application_CI","Employee_Itinerary","Panalo_Reward","Raffle_Status","Pacita_Rule","Pacita_Evaluation","Installment_Term","Ganado_Online");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Branch_Info`");
      _db.execSQL("DELETE FROM `MC_Brand`");
      _db.execSQL("DELETE FROM `Mc_Model`");
      _db.execSQL("DELETE FROM `MC_Category`");
      _db.execSQL("DELETE FROM `Province_Info`");
      _db.execSQL("DELETE FROM `Mc_Model_Price`");
      _db.execSQL("DELETE FROM `MC_Model_Color`");
      _db.execSQL("DELETE FROM `Town_Info`");
      _db.execSQL("DELETE FROM `Barangay_Info`");
      _db.execSQL("DELETE FROM `MC_Term_Category`");
      _db.execSQL("DELETE FROM `Country_Info`");
      _db.execSQL("DELETE FROM `Occupation_Info`");
      _db.execSQL("DELETE FROM `Credit_Online_Application`");
      _db.execSQL("DELETE FROM `Credit_Applicant_Info`");
      _db.execSQL("DELETE FROM `MC_Area_Performance`");
      _db.execSQL("DELETE FROM `MC_Branch_Performance`");
      _db.execSQL("DELETE FROM `FB_Raffle_Transaction_Basis`");
      _db.execSQL("DELETE FROM `PromoLocal_Detail`");
      _db.execSQL("DELETE FROM `Notification_Info_Master`");
      _db.execSQL("DELETE FROM `Notification_Info_Recepient`");
      _db.execSQL("DELETE FROM `Notification_User`");
      _db.execSQL("DELETE FROM `System_Code_Approval`");
      _db.execSQL("DELETE FROM `xxxSCA_Request`");
      _db.execSQL("DELETE FROM `LR_DCP_Collection_Master`");
      _db.execSQL("DELETE FROM `LR_DCP_Collection_Detail`");
      _db.execSQL("DELETE FROM `Address_Update_Request`");
      _db.execSQL("DELETE FROM `Mobile_Update_Request`");
      _db.execSQL("DELETE FROM `Image_Information`");
      _db.execSQL("DELETE FROM `User_Info_Master`");
      _db.execSQL("DELETE FROM `EDocSys_File`");
      _db.execSQL("DELETE FROM `Client_Info_Master`");
      _db.execSQL("DELETE FROM `App_Token_Info`");
      _db.execSQL("DELETE FROM `Credit_Online_Application_Documents`");
      _db.execSQL("DELETE FROM `Client_Update_Request`");
      _db.execSQL("DELETE FROM `Bank_Info`");
      _db.execSQL("DELETE FROM `Employee_Log_Selfie`");
      _db.execSQL("DELETE FROM `Credit_Online_Application_List`");
      _db.execSQL("DELETE FROM `Uncaptured_Client_Image`");
      _db.execSQL("DELETE FROM `Credit_Online_Application_List_CI`");
      _db.execSQL("DELETE FROM `LR_DCP_Remittance`");
      _db.execSQL("DELETE FROM `Collection_Account_Remittance`");
      _db.execSQL("DELETE FROM `xxxSysConfig`");
      _db.execSQL("DELETE FROM `GLocator_Sys_log`");
      _db.execSQL("DELETE FROM `Relation`");
      _db.execSQL("DELETE FROM `NNDM_Event_Request`");
      _db.execSQL("DELETE FROM `xxxAppConfig`");
      _db.execSQL("DELETE FROM `Cash_Count_Master`");
      _db.execSQL("DELETE FROM `Branch_Opening`");
      _db.execSQL("DELETE FROM `Employee_Leave`");
      _db.execSQL("DELETE FROM `Employee_Business_Trip`");
      _db.execSQL("DELETE FROM `xxxAOEmpRole`");
      _db.execSQL("DELETE FROM `Inventory_Count_Master`");
      _db.execSQL("DELETE FROM `Inventory_Count_Detail`");
      _db.execSQL("DELETE FROM `Credit_Online_Application_CI`");
      _db.execSQL("DELETE FROM `Employee_Itinerary`");
      _db.execSQL("DELETE FROM `Panalo_Reward`");
      _db.execSQL("DELETE FROM `Raffle_Status`");
      _db.execSQL("DELETE FROM `Pacita_Rule`");
      _db.execSQL("DELETE FROM `Pacita_Evaluation`");
      _db.execSQL("DELETE FROM `Installment_Term`");
      _db.execSQL("DELETE FROM `Ganado_Online`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(DEmployeeInfo.class, DEmployeeInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DFileCode.class, DFileCode_Impl.getRequiredConverters());
    _typeConvertersMap.put(DClientInfo.class, DClientInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DBarangayInfo.class, DBarangayInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DTownInfo.class, DTownInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DProvinceInfo.class, DProvinceInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DCountryInfo.class, DCountryInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DMcCategory.class, DMcCategory_Impl.getRequiredConverters());
    _typeConvertersMap.put(DMcTermCategory.class, DMcTermCategory_Impl.getRequiredConverters());
    _typeConvertersMap.put(DMcBrand.class, DMcBrand_Impl.getRequiredConverters());
    _typeConvertersMap.put(DMcModel.class, DMcModel_Impl.getRequiredConverters());
    _typeConvertersMap.put(DMcModelPrice.class, DMcModelPrice_Impl.getRequiredConverters());
    _typeConvertersMap.put(DBranchInfo.class, DBranchInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DOccupationInfo.class, DOccupationInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DCreditApplication.class, DCreditApplication_Impl.getRequiredConverters());
    _typeConvertersMap.put(DCreditApplicantInfo.class, DCreditApplicantInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAreaPerformance.class, DAreaPerformance_Impl.getRequiredConverters());
    _typeConvertersMap.put(DBranchPerformance.class, DBranchPerformance_Impl.getRequiredConverters());
    _typeConvertersMap.put(DRawDao.class, DRawDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DRaffleInfo.class, DRaffleInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DNotificationReceiver.class, DNotificationReceiver_Impl.getRequiredConverters());
    _typeConvertersMap.put(DApprovalCode.class, DApprovalCode_Impl.getRequiredConverters());
    _typeConvertersMap.put(DLRDcp.class, DLRDcp_Impl.getRequiredConverters());
    _typeConvertersMap.put(DDCPCollectionMaster.class, DDCPCollectionMaster_Impl.getRequiredConverters());
    _typeConvertersMap.put(DDCPCollectionDetail.class, DDCPCollectionDetail_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAddressRequest.class, DAddressRequest_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAddressUpdate.class, DAddressUpdate_Impl.getRequiredConverters());
    _typeConvertersMap.put(DMobileUpdate.class, DMobileUpdate_Impl.getRequiredConverters());
    _typeConvertersMap.put(DMobileRequest.class, DMobileRequest_Impl.getRequiredConverters());
    _typeConvertersMap.put(DImageInfo.class, DImageInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DCreditApplicationDocuments.class, DCreditApplicationDocuments_Impl.getRequiredConverters());
    _typeConvertersMap.put(DClientUpdate.class, DClientUpdate_Impl.getRequiredConverters());
    _typeConvertersMap.put(DBankInfo.class, DBankInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DSelfieLog.class, DSelfieLog_Impl.getRequiredConverters());
    _typeConvertersMap.put(DInventoryDao.class, DInventoryDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DBranchLoanApplication.class, DBranchLoanApplication_Impl.getRequiredConverters());
    _typeConvertersMap.put(DUncapturedClient.class, DUncapturedClient_Impl.getRequiredConverters());
    _typeConvertersMap.put(DCIEvaluation.class, DCIEvaluation_Impl.getRequiredConverters());
    _typeConvertersMap.put(DRelation.class, DRelation_Impl.getRequiredConverters());
    _typeConvertersMap.put(DDCP_Remittance.class, DDCP_Remittance_Impl.getRequiredConverters());
    _typeConvertersMap.put(DRemittanceAccounts.class, DRemittanceAccounts_Impl.getRequiredConverters());
    _typeConvertersMap.put(DSysConfig.class, DSysConfig_Impl.getRequiredConverters());
    _typeConvertersMap.put(DLocatorSysLog.class, DLocatorSysLog_Impl.getRequiredConverters());
    _typeConvertersMap.put(DNNDMRequest.class, DNNDMRequest_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAppConfig.class, DAppConfig_Impl.getRequiredConverters());
    _typeConvertersMap.put(DCashCount.class, DCashCount_Impl.getRequiredConverters());
    _typeConvertersMap.put(DBranchOpeningMonitor.class, DBranchOpeningMonitor_Impl.getRequiredConverters());
    _typeConvertersMap.put(DEmployeeLeave.class, DEmployeeLeave_Impl.getRequiredConverters());
    _typeConvertersMap.put(DEmployeeBusinessTrip.class, DEmployeeBusinessTrip_Impl.getRequiredConverters());
    _typeConvertersMap.put(DEmployeeRole.class, DEmployeeRole_Impl.getRequiredConverters());
    _typeConvertersMap.put(DInventoryMaster.class, DInventoryMaster_Impl.getRequiredConverters());
    _typeConvertersMap.put(DInventoryDetail.class, DInventoryDetail_Impl.getRequiredConverters());
    _typeConvertersMap.put(DCreditOnlineApplicationCI.class, DCreditOnlineApplicationCI_Impl.getRequiredConverters());
    _typeConvertersMap.put(DItinerary.class, DItinerary_Impl.getRequiredConverters());
    _typeConvertersMap.put(DToken.class, DToken_Impl.getRequiredConverters());
    _typeConvertersMap.put(DevTool.class, DevTool_Impl.getRequiredConverters());
    _typeConvertersMap.put(DNotificationMaster.class, DNotificationMaster_Impl.getRequiredConverters());
    _typeConvertersMap.put(DNotificationDetail.class, DNotificationDetail_Impl.getRequiredConverters());
    _typeConvertersMap.put(DNotificationUser.class, DNotificationUser_Impl.getRequiredConverters());
    _typeConvertersMap.put(DPanalo.class, DPanalo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DPayslip.class, DPayslip_Impl.getRequiredConverters());
    _typeConvertersMap.put(DRaffleStatus.class, DRaffleStatus_Impl.getRequiredConverters());
    _typeConvertersMap.put(DMessages.class, DMessages_Impl.getRequiredConverters());
    _typeConvertersMap.put(DNotification.class, DNotification_Impl.getRequiredConverters());
    _typeConvertersMap.put(DPacita.class, DPacita_Impl.getRequiredConverters());
    _typeConvertersMap.put(DGanadoOnline.class, DGanadoOnline_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public DEmployeeInfo EmployeeDao() {
    if (_dEmployeeInfo != null) {
      return _dEmployeeInfo;
    } else {
      synchronized(this) {
        if(_dEmployeeInfo == null) {
          _dEmployeeInfo = new DEmployeeInfo_Impl(this);
        }
        return _dEmployeeInfo;
      }
    }
  }

  @Override
  public DFileCode FileCodeDao() {
    if (_dFileCode != null) {
      return _dFileCode;
    } else {
      synchronized(this) {
        if(_dFileCode == null) {
          _dFileCode = new DFileCode_Impl(this);
        }
        return _dFileCode;
      }
    }
  }

  @Override
  public DClientInfo ClientDao() {
    if (_dClientInfo != null) {
      return _dClientInfo;
    } else {
      synchronized(this) {
        if(_dClientInfo == null) {
          _dClientInfo = new DClientInfo_Impl(this);
        }
        return _dClientInfo;
      }
    }
  }

  @Override
  public DBarangayInfo BarangayDao() {
    if (_dBarangayInfo != null) {
      return _dBarangayInfo;
    } else {
      synchronized(this) {
        if(_dBarangayInfo == null) {
          _dBarangayInfo = new DBarangayInfo_Impl(this);
        }
        return _dBarangayInfo;
      }
    }
  }

  @Override
  public DTownInfo TownDao() {
    if (_dTownInfo != null) {
      return _dTownInfo;
    } else {
      synchronized(this) {
        if(_dTownInfo == null) {
          _dTownInfo = new DTownInfo_Impl(this);
        }
        return _dTownInfo;
      }
    }
  }

  @Override
  public DProvinceInfo ProvinceDao() {
    if (_dProvinceInfo != null) {
      return _dProvinceInfo;
    } else {
      synchronized(this) {
        if(_dProvinceInfo == null) {
          _dProvinceInfo = new DProvinceInfo_Impl(this);
        }
        return _dProvinceInfo;
      }
    }
  }

  @Override
  public DCountryInfo CountryDao() {
    if (_dCountryInfo != null) {
      return _dCountryInfo;
    } else {
      synchronized(this) {
        if(_dCountryInfo == null) {
          _dCountryInfo = new DCountryInfo_Impl(this);
        }
        return _dCountryInfo;
      }
    }
  }

  @Override
  public DMcCategory McCategoryDao() {
    if (_dMcCategory != null) {
      return _dMcCategory;
    } else {
      synchronized(this) {
        if(_dMcCategory == null) {
          _dMcCategory = new DMcCategory_Impl(this);
        }
        return _dMcCategory;
      }
    }
  }

  @Override
  public DMcTermCategory McTermCategoryDao() {
    if (_dMcTermCategory != null) {
      return _dMcTermCategory;
    } else {
      synchronized(this) {
        if(_dMcTermCategory == null) {
          _dMcTermCategory = new DMcTermCategory_Impl(this);
        }
        return _dMcTermCategory;
      }
    }
  }

  @Override
  public DMcBrand McBrandDao() {
    if (_dMcBrand != null) {
      return _dMcBrand;
    } else {
      synchronized(this) {
        if(_dMcBrand == null) {
          _dMcBrand = new DMcBrand_Impl(this);
        }
        return _dMcBrand;
      }
    }
  }

  @Override
  public DMcModel McModelDao() {
    if (_dMcModel != null) {
      return _dMcModel;
    } else {
      synchronized(this) {
        if(_dMcModel == null) {
          _dMcModel = new DMcModel_Impl(this);
        }
        return _dMcModel;
      }
    }
  }

  @Override
  public DMcModelPrice McModelPriceDao() {
    if (_dMcModelPrice != null) {
      return _dMcModelPrice;
    } else {
      synchronized(this) {
        if(_dMcModelPrice == null) {
          _dMcModelPrice = new DMcModelPrice_Impl(this);
        }
        return _dMcModelPrice;
      }
    }
  }

  @Override
  public DBranchInfo BranchDao() {
    if (_dBranchInfo != null) {
      return _dBranchInfo;
    } else {
      synchronized(this) {
        if(_dBranchInfo == null) {
          _dBranchInfo = new DBranchInfo_Impl(this);
        }
        return _dBranchInfo;
      }
    }
  }

  @Override
  public DOccupationInfo OccupationDao() {
    if (_dOccupationInfo != null) {
      return _dOccupationInfo;
    } else {
      synchronized(this) {
        if(_dOccupationInfo == null) {
          _dOccupationInfo = new DOccupationInfo_Impl(this);
        }
        return _dOccupationInfo;
      }
    }
  }

  @Override
  public DCreditApplication CreditApplicationDao() {
    if (_dCreditApplication != null) {
      return _dCreditApplication;
    } else {
      synchronized(this) {
        if(_dCreditApplication == null) {
          _dCreditApplication = new DCreditApplication_Impl(this);
        }
        return _dCreditApplication;
      }
    }
  }

  @Override
  public DCreditApplicantInfo CreditApplicantDao() {
    if (_dCreditApplicantInfo != null) {
      return _dCreditApplicantInfo;
    } else {
      synchronized(this) {
        if(_dCreditApplicantInfo == null) {
          _dCreditApplicantInfo = new DCreditApplicantInfo_Impl(this);
        }
        return _dCreditApplicantInfo;
      }
    }
  }

  @Override
  public DAreaPerformance AreaPerformanceDao() {
    if (_dAreaPerformance != null) {
      return _dAreaPerformance;
    } else {
      synchronized(this) {
        if(_dAreaPerformance == null) {
          _dAreaPerformance = new DAreaPerformance_Impl(this);
        }
        return _dAreaPerformance;
      }
    }
  }

  @Override
  public DBranchPerformance BranchPerformanceDao() {
    if (_dBranchPerformance != null) {
      return _dBranchPerformance;
    } else {
      synchronized(this) {
        if(_dBranchPerformance == null) {
          _dBranchPerformance = new DBranchPerformance_Impl(this);
        }
        return _dBranchPerformance;
      }
    }
  }

  @Override
  public DRawDao RawDao() {
    if (_dRawDao != null) {
      return _dRawDao;
    } else {
      synchronized(this) {
        if(_dRawDao == null) {
          _dRawDao = new DRawDao_Impl(this);
        }
        return _dRawDao;
      }
    }
  }

  @Override
  public DRaffleInfo RaffleDao() {
    if (_dRaffleInfo != null) {
      return _dRaffleInfo;
    } else {
      synchronized(this) {
        if(_dRaffleInfo == null) {
          _dRaffleInfo = new DRaffleInfo_Impl(this);
        }
        return _dRaffleInfo;
      }
    }
  }

  @Override
  public DNotificationReceiver ntfReceiverDao() {
    if (_dNotificationReceiver != null) {
      return _dNotificationReceiver;
    } else {
      synchronized(this) {
        if(_dNotificationReceiver == null) {
          _dNotificationReceiver = new DNotificationReceiver_Impl(this);
        }
        return _dNotificationReceiver;
      }
    }
  }

  @Override
  public DApprovalCode ApprovalDao() {
    if (_dApprovalCode != null) {
      return _dApprovalCode;
    } else {
      synchronized(this) {
        if(_dApprovalCode == null) {
          _dApprovalCode = new DApprovalCode_Impl(this);
        }
        return _dApprovalCode;
      }
    }
  }

  @Override
  public DLRDcp DcpDao() {
    if (_dLRDcp != null) {
      return _dLRDcp;
    } else {
      synchronized(this) {
        if(_dLRDcp == null) {
          _dLRDcp = new DLRDcp_Impl(this);
        }
        return _dLRDcp;
      }
    }
  }

  @Override
  public DDCPCollectionMaster DcpMasterDao() {
    if (_dDCPCollectionMaster != null) {
      return _dDCPCollectionMaster;
    } else {
      synchronized(this) {
        if(_dDCPCollectionMaster == null) {
          _dDCPCollectionMaster = new DDCPCollectionMaster_Impl(this);
        }
        return _dDCPCollectionMaster;
      }
    }
  }

  @Override
  public DDCPCollectionDetail DcpDetailDao() {
    if (_dDCPCollectionDetail != null) {
      return _dDCPCollectionDetail;
    } else {
      synchronized(this) {
        if(_dDCPCollectionDetail == null) {
          _dDCPCollectionDetail = new DDCPCollectionDetail_Impl(this);
        }
        return _dDCPCollectionDetail;
      }
    }
  }

  @Override
  public DAddressRequest AddressRequestDao() {
    if (_dAddressRequest != null) {
      return _dAddressRequest;
    } else {
      synchronized(this) {
        if(_dAddressRequest == null) {
          _dAddressRequest = new DAddressRequest_Impl(this);
        }
        return _dAddressRequest;
      }
    }
  }

  @Override
  public DAddressUpdate addressUpdateDao() {
    if (_dAddressUpdate != null) {
      return _dAddressUpdate;
    } else {
      synchronized(this) {
        if(_dAddressUpdate == null) {
          _dAddressUpdate = new DAddressUpdate_Impl(this);
        }
        return _dAddressUpdate;
      }
    }
  }

  @Override
  public DMobileUpdate mobileUpdateDao() {
    if (_dMobileUpdate != null) {
      return _dMobileUpdate;
    } else {
      synchronized(this) {
        if(_dMobileUpdate == null) {
          _dMobileUpdate = new DMobileUpdate_Impl(this);
        }
        return _dMobileUpdate;
      }
    }
  }

  @Override
  public DMobileRequest MobileRequestDao() {
    if (_dMobileRequest != null) {
      return _dMobileRequest;
    } else {
      synchronized(this) {
        if(_dMobileRequest == null) {
          _dMobileRequest = new DMobileRequest_Impl(this);
        }
        return _dMobileRequest;
      }
    }
  }

  @Override
  public DImageInfo ImageInfoDao() {
    if (_dImageInfo != null) {
      return _dImageInfo;
    } else {
      synchronized(this) {
        if(_dImageInfo == null) {
          _dImageInfo = new DImageInfo_Impl(this);
        }
        return _dImageInfo;
      }
    }
  }

  @Override
  public DCreditApplicationDocuments DocumentInfoDao() {
    if (_dCreditApplicationDocuments != null) {
      return _dCreditApplicationDocuments;
    } else {
      synchronized(this) {
        if(_dCreditApplicationDocuments == null) {
          _dCreditApplicationDocuments = new DCreditApplicationDocuments_Impl(this);
        }
        return _dCreditApplicationDocuments;
      }
    }
  }

  @Override
  public DClientUpdate ClientUpdateDao() {
    if (_dClientUpdate != null) {
      return _dClientUpdate;
    } else {
      synchronized(this) {
        if(_dClientUpdate == null) {
          _dClientUpdate = new DClientUpdate_Impl(this);
        }
        return _dClientUpdate;
      }
    }
  }

  @Override
  public DBankInfo BankInfoDao() {
    if (_dBankInfo != null) {
      return _dBankInfo;
    } else {
      synchronized(this) {
        if(_dBankInfo == null) {
          _dBankInfo = new DBankInfo_Impl(this);
        }
        return _dBankInfo;
      }
    }
  }

  @Override
  public DSelfieLog SelfieDao() {
    if (_dSelfieLog != null) {
      return _dSelfieLog;
    } else {
      synchronized(this) {
        if(_dSelfieLog == null) {
          _dSelfieLog = new DSelfieLog_Impl(this);
        }
        return _dSelfieLog;
      }
    }
  }

  @Override
  public DInventoryDao InventoryDao() {
    if (_dInventoryDao != null) {
      return _dInventoryDao;
    } else {
      synchronized(this) {
        if(_dInventoryDao == null) {
          _dInventoryDao = new DInventoryDao_Impl(this);
        }
        return _dInventoryDao;
      }
    }
  }

  @Override
  public DBranchLoanApplication CreditAppDocsDao() {
    if (_dBranchLoanApplication != null) {
      return _dBranchLoanApplication;
    } else {
      synchronized(this) {
        if(_dBranchLoanApplication == null) {
          _dBranchLoanApplication = new DBranchLoanApplication_Impl(this);
        }
        return _dBranchLoanApplication;
      }
    }
  }

  @Override
  public DUncapturedClient UncapturedDao() {
    if (_dUncapturedClient != null) {
      return _dUncapturedClient;
    } else {
      synchronized(this) {
        if(_dUncapturedClient == null) {
          _dUncapturedClient = new DUncapturedClient_Impl(this);
        }
        return _dUncapturedClient;
      }
    }
  }

  @Override
  public DCIEvaluation CIDao() {
    if (_dCIEvaluation != null) {
      return _dCIEvaluation;
    } else {
      synchronized(this) {
        if(_dCIEvaluation == null) {
          _dCIEvaluation = new DCIEvaluation_Impl(this);
        }
        return _dCIEvaluation;
      }
    }
  }

  @Override
  public DRelation RelDao() {
    if (_dRelation != null) {
      return _dRelation;
    } else {
      synchronized(this) {
        if(_dRelation == null) {
          _dRelation = new DRelation_Impl(this);
        }
        return _dRelation;
      }
    }
  }

  @Override
  public DDCP_Remittance DCPRemitanceDao() {
    if (_dDCPRemittance != null) {
      return _dDCPRemittance;
    } else {
      synchronized(this) {
        if(_dDCPRemittance == null) {
          _dDCPRemittance = new DDCP_Remittance_Impl(this);
        }
        return _dDCPRemittance;
      }
    }
  }

  @Override
  public DRemittanceAccounts RemitanceAccDao() {
    if (_dRemittanceAccounts != null) {
      return _dRemittanceAccounts;
    } else {
      synchronized(this) {
        if(_dRemittanceAccounts == null) {
          _dRemittanceAccounts = new DRemittanceAccounts_Impl(this);
        }
        return _dRemittanceAccounts;
      }
    }
  }

  @Override
  public DSysConfig sysConfigDao() {
    if (_dSysConfig != null) {
      return _dSysConfig;
    } else {
      synchronized(this) {
        if(_dSysConfig == null) {
          _dSysConfig = new DSysConfig_Impl(this);
        }
        return _dSysConfig;
      }
    }
  }

  @Override
  public DLocatorSysLog locatorSysLogDao() {
    if (_dLocatorSysLog != null) {
      return _dLocatorSysLog;
    } else {
      synchronized(this) {
        if(_dLocatorSysLog == null) {
          _dLocatorSysLog = new DLocatorSysLog_Impl(this);
        }
        return _dLocatorSysLog;
      }
    }
  }

  @Override
  public DNNDMRequest nndmRequestDao() {
    if (_dNNDMRequest != null) {
      return _dNNDMRequest;
    } else {
      synchronized(this) {
        if(_dNNDMRequest == null) {
          _dNNDMRequest = new DNNDMRequest_Impl(this);
        }
        return _dNNDMRequest;
      }
    }
  }

  @Override
  public DAppConfig appConfigDao() {
    if (_dAppConfig != null) {
      return _dAppConfig;
    } else {
      synchronized(this) {
        if(_dAppConfig == null) {
          _dAppConfig = new DAppConfig_Impl(this);
        }
        return _dAppConfig;
      }
    }
  }

  @Override
  public DCashCount CashCountDao() {
    if (_dCashCount != null) {
      return _dCashCount;
    } else {
      synchronized(this) {
        if(_dCashCount == null) {
          _dCashCount = new DCashCount_Impl(this);
        }
        return _dCashCount;
      }
    }
  }

  @Override
  public DBranchOpeningMonitor openingMonitoryDao() {
    if (_dBranchOpeningMonitor != null) {
      return _dBranchOpeningMonitor;
    } else {
      synchronized(this) {
        if(_dBranchOpeningMonitor == null) {
          _dBranchOpeningMonitor = new DBranchOpeningMonitor_Impl(this);
        }
        return _dBranchOpeningMonitor;
      }
    }
  }

  @Override
  public DEmployeeLeave employeeLeaveDao() {
    if (_dEmployeeLeave != null) {
      return _dEmployeeLeave;
    } else {
      synchronized(this) {
        if(_dEmployeeLeave == null) {
          _dEmployeeLeave = new DEmployeeLeave_Impl(this);
        }
        return _dEmployeeLeave;
      }
    }
  }

  @Override
  public DEmployeeBusinessTrip employeeOBDao() {
    if (_dEmployeeBusinessTrip != null) {
      return _dEmployeeBusinessTrip;
    } else {
      synchronized(this) {
        if(_dEmployeeBusinessTrip == null) {
          _dEmployeeBusinessTrip = new DEmployeeBusinessTrip_Impl(this);
        }
        return _dEmployeeBusinessTrip;
      }
    }
  }

  @Override
  public DEmployeeRole employeeRoleDao() {
    if (_dEmployeeRole != null) {
      return _dEmployeeRole;
    } else {
      synchronized(this) {
        if(_dEmployeeRole == null) {
          _dEmployeeRole = new DEmployeeRole_Impl(this);
        }
        return _dEmployeeRole;
      }
    }
  }

  @Override
  public DInventoryMaster inventoryMasterDao() {
    if (_dInventoryMaster != null) {
      return _dInventoryMaster;
    } else {
      synchronized(this) {
        if(_dInventoryMaster == null) {
          _dInventoryMaster = new DInventoryMaster_Impl(this);
        }
        return _dInventoryMaster;
      }
    }
  }

  @Override
  public DInventoryDetail inventoryDetailDao() {
    if (_dInventoryDetail != null) {
      return _dInventoryDetail;
    } else {
      synchronized(this) {
        if(_dInventoryDetail == null) {
          _dInventoryDetail = new DInventoryDetail_Impl(this);
        }
        return _dInventoryDetail;
      }
    }
  }

  @Override
  public DCreditOnlineApplicationCI creditEvaluationDao() {
    if (_dCreditOnlineApplicationCI != null) {
      return _dCreditOnlineApplicationCI;
    } else {
      synchronized(this) {
        if(_dCreditOnlineApplicationCI == null) {
          _dCreditOnlineApplicationCI = new DCreditOnlineApplicationCI_Impl(this);
        }
        return _dCreditOnlineApplicationCI;
      }
    }
  }

  @Override
  public DItinerary itineraryDao() {
    if (_dItinerary != null) {
      return _dItinerary;
    } else {
      synchronized(this) {
        if(_dItinerary == null) {
          _dItinerary = new DItinerary_Impl(this);
        }
        return _dItinerary;
      }
    }
  }

  @Override
  public DToken dToken() {
    if (_dToken != null) {
      return _dToken;
    } else {
      synchronized(this) {
        if(_dToken == null) {
          _dToken = new DToken_Impl(this);
        }
        return _dToken;
      }
    }
  }

  @Override
  public DevTool devTool() {
    if (_devTool != null) {
      return _devTool;
    } else {
      synchronized(this) {
        if(_devTool == null) {
          _devTool = new DevTool_Impl(this);
        }
        return _devTool;
      }
    }
  }

  @Override
  public DNotificationMaster nMasterDao() {
    if (_dNotificationMaster != null) {
      return _dNotificationMaster;
    } else {
      synchronized(this) {
        if(_dNotificationMaster == null) {
          _dNotificationMaster = new DNotificationMaster_Impl(this);
        }
        return _dNotificationMaster;
      }
    }
  }

  @Override
  public DNotificationDetail nDetailDao() {
    if (_dNotificationDetail != null) {
      return _dNotificationDetail;
    } else {
      synchronized(this) {
        if(_dNotificationDetail == null) {
          _dNotificationDetail = new DNotificationDetail_Impl(this);
        }
        return _dNotificationDetail;
      }
    }
  }

  @Override
  public DNotificationUser nUserDao() {
    if (_dNotificationUser != null) {
      return _dNotificationUser;
    } else {
      synchronized(this) {
        if(_dNotificationUser == null) {
          _dNotificationUser = new DNotificationUser_Impl(this);
        }
        return _dNotificationUser;
      }
    }
  }

  @Override
  public DPanalo panaloDao() {
    if (_dPanalo != null) {
      return _dPanalo;
    } else {
      synchronized(this) {
        if(_dPanalo == null) {
          _dPanalo = new DPanalo_Impl(this);
        }
        return _dPanalo;
      }
    }
  }

  @Override
  public DPayslip payslipDao() {
    if (_dPayslip != null) {
      return _dPayslip;
    } else {
      synchronized(this) {
        if(_dPayslip == null) {
          _dPayslip = new DPayslip_Impl(this);
        }
        return _dPayslip;
      }
    }
  }

  @Override
  public DRaffleStatus raffleStatusDao() {
    if (_dRaffleStatus != null) {
      return _dRaffleStatus;
    } else {
      synchronized(this) {
        if(_dRaffleStatus == null) {
          _dRaffleStatus = new DRaffleStatus_Impl(this);
        }
        return _dRaffleStatus;
      }
    }
  }

  @Override
  public DMessages messagesDao() {
    if (_dMessages != null) {
      return _dMessages;
    } else {
      synchronized(this) {
        if(_dMessages == null) {
          _dMessages = new DMessages_Impl(this);
        }
        return _dMessages;
      }
    }
  }

  @Override
  public DNotification notificationDao() {
    if (_dNotification != null) {
      return _dNotification;
    } else {
      synchronized(this) {
        if(_dNotification == null) {
          _dNotification = new DNotification_Impl(this);
        }
        return _dNotification;
      }
    }
  }

  @Override
  public DPacita pacitaDao() {
    if (_dPacita != null) {
      return _dPacita;
    } else {
      synchronized(this) {
        if(_dPacita == null) {
          _dPacita = new DPacita_Impl(this);
        }
        return _dPacita;
      }
    }
  }

  @Override
  public DGanadoOnline ganadoDao() {
    if (_dGanadoOnline != null) {
      return _dGanadoOnline;
    } else {
      synchronized(this) {
        if(_dGanadoOnline == null) {
          _dGanadoOnline = new DGanadoOnline_Impl(this);
        }
        return _dGanadoOnline;
      }
    }
  }
}
