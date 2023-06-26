package org.rmj.g3appdriver.GConnect.room;

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
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DAddress;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DAddress_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DBranchInfo;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DBranchInfo_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DClientInfo_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DEmployeeInfo;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DEmployeeInfo_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DEvents;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DEvents_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DGCardTransactionLedger;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DGCardTransactionLedger_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DGcardApp_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DItemCart;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DItemCart_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DMCSerialRegistration;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DMCSerialRegistration_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DMobileAddressInfo;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DMobileAddressInfo_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DNotifications_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DOrder;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DOrderDetail;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DOrderDetail_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DOrder_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DPanalo;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DPanalo_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DProduct;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DProduct_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DPromo;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DPromo_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DRawDao;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DRawDao_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DRedeemItemInfo_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DRedeemablesInfo;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DRedeemablesInfo_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DSearchLog;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DSearchLog_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DServiceInfo;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DServiceInfo_Impl;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DUserInfo;
import org.rmj.g3appdriver.GConnect.room.DataAccessObject.DUserInfo_Impl;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GGC_GConnectDB_Impl extends GGC_GConnectDB {
  private volatile DBranchInfo _dBranchInfo;

  private volatile DClientInfo _dClientInfo;

  private volatile DGcardApp _dGcardApp;

  private volatile DGCardTransactionLedger _dGCardTransactionLedger;

  private volatile DMCSerialRegistration _dMCSerialRegistration;

  private volatile DPromo _dPromo;

  private volatile DRedeemablesInfo _dRedeemablesInfo;

  private volatile DRedeemItemInfo _dRedeemItemInfo;

  private volatile DServiceInfo _dServiceInfo;

  private volatile DUserInfo _dUserInfo;

  private volatile DRawDao _dRawDao;

  private volatile DEmployeeInfo _dEmployeeInfo;

  private volatile DNotifications _dNotifications;

  private volatile DEvents _dEvents;

  private volatile DAddress _dAddress;

  private volatile DMobileAddressInfo _dMobileAddressInfo;

  private volatile DProduct _dProduct;

  private volatile DItemCart _dItemCart;

  private volatile DOrder _dOrder;

  private volatile DOrderDetail _dOrderDetail;

  private volatile DSearchLog _dSearchLog;

  private volatile DPanalo _dPanalo;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `App_Event_Info` (`sTransNox` TEXT NOT NULL, `sBranchNm` TEXT, `dEvntFrom` TEXT, `dEvntThru` TEXT, `sEventTle` TEXT, `sAddressx` TEXT, `sEventURL` TEXT, `sImageURL` TEXT, `cNotified` TEXT, `dModified` TEXT, `sDirectoryFolder` TEXT, `sImagePath` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `BranchInfo` (`sBranchCd` TEXT NOT NULL, `sBranchNm` TEXT, `sDescript` TEXT, `sAddressx` TEXT, `sTownIDxx` TEXT, `sTownName` TEXT, `sProvName` TEXT, `nLatitude` REAL NOT NULL, `nLongtude` REAL NOT NULL, `sContactx` TEXT, `sTelNumbr` TEXT, `sEmailAdd` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sBranchCd`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Client_Profile_Info` (`sUserIDxx` TEXT NOT NULL, `sClientID` TEXT, `sEmailAdd` TEXT, `sUserName` TEXT, `sLastName` TEXT, `sFrstName` TEXT, `sMiddName` TEXT, `sSuffixNm` TEXT, `sMaidenNm` TEXT, `cGenderCd` TEXT, `cCvilStat` TEXT, `sCitizenx` TEXT, `dBirthDte` TEXT, `sBirthPlc` TEXT, `sHouseNo1` TEXT, `sAddress1` TEXT, `sBrgyIDx1` TEXT, `sTownIDx1` TEXT, `sHouseNo2` TEXT, `sAddress2` TEXT, `sBrgyIDx2` TEXT, `sTownIDx2` TEXT, `sTaxIDNox` TEXT, `cRecdStat` INTEGER NOT NULL, `sMobileNo` TEXT, `cVerified` INTEGER NOT NULL, `dVerified` TEXT, `cAgreeTnC` INTEGER NOT NULL, `dDateMmbr` TEXT, `sImagePth` TEXT, `dImgeDate` TEXT, `cImgeStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sUserIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `GCard_App_Master` (`sGCardNox` TEXT NOT NULL, `sCardNmbr` TEXT, `sUserIDxx` TEXT, `sNmOnCard` TEXT, `dMemberxx` TEXT, `cCardType` TEXT, `sTotPoint` TEXT, `sAvlPoint` TEXT, `cTranStat` TEXT, `cActvStat` TEXT, `dModified` TEXT, `cNotified` TEXT, PRIMARY KEY(`sGCardNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `G_Card_Transaction_Ledger` (`sReferNox` TEXT NOT NULL, `sGCardNox` TEXT, `nEntryNox` INTEGER NOT NULL, `dTransact` TEXT, `sSourceDs` TEXT, `sTranType` TEXT, `sTranDesc` TEXT, `sSourceNo` TEXT, `nPointsxx` REAL NOT NULL, `cQRCodexx` TEXT, `cReceived` TEXT, PRIMARY KEY(`sReferNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MC_Serial_Registration` (`sSerialID` TEXT NOT NULL, `sGCardNox` TEXT, `sEngineNo` TEXT, `sFrameNox` TEXT, `sModelNme` TEXT, `sFSEPStat` TEXT, `cRegStatx` TEXT, PRIMARY KEY(`sSerialID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Promo_Link_Info` (`sTransNox` TEXT NOT NULL, `dTransact` TEXT, `dDateFrom` TEXT, `dDateThru` TEXT, `sCaptionx` TEXT, `sImageUrl` TEXT, `sImageSld` TEXT, `sImgeByte` TEXT, `sPromoUrl` TEXT, `cNotified` TEXT, `cDivision` INTEGER NOT NULL, `cRecdStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Notification_Info_Master` (`sTransNox` TEXT NOT NULL, `sMesgIDxx` TEXT, `sParentxx` TEXT, `dCreatedx` TEXT, `sAppSrcex` TEXT, `sCreatrID` TEXT, `sCreatrNm` TEXT, `sMsgTitle` TEXT, `sMessagex` TEXT, `sURLxxxxx` TEXT, `sDataSndx` TEXT, `sMsgTypex` TEXT, `cSentxxxx` TEXT, `dSentxxxx` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Notification_Info_Recepient` (`sTransNox` TEXT NOT NULL, `sAppRcptx` TEXT, `sRecpntID` TEXT, `sRecpntNm` TEXT, `sGroupIDx` TEXT, `sGroupNmx` TEXT, `cMonitorx` TEXT, `cMesgStat` TEXT, `cStatSent` TEXT, `dSentxxxx` TEXT, `dReceived` TEXT, `dReadxxxx` TEXT, `dLastUpdt` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Notification_User` (`sUserIDxx` TEXT NOT NULL, `sUserName` TEXT, PRIMARY KEY(`sUserIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Redeemables` (`sTransNox` TEXT NOT NULL, `sPromoCde` TEXT, `sPromoDsc` TEXT, `nPointsxx` REAL NOT NULL, `sImageUrl` TEXT, `cPreOrder` TEXT, `dDateFrom` TEXT, `dDateThru` TEXT, `cNotified` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Redeem_Item` (`sPromoIDx` TEXT NOT NULL, `sBatchNox` TEXT, `sTransNox` TEXT, `sGCardNox` TEXT, `nItemQtyx` INTEGER NOT NULL, `nPointsxx` REAL NOT NULL, `sBranchCd` TEXT, `sReferNox` TEXT, `dOrderedx` TEXT, `dPlacOrdr` TEXT, `dPickupxx` TEXT, `cTranStat` TEXT, `cPlcOrder` TEXT, `cNotified` TEXT, PRIMARY KEY(`sPromoIDx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MC_Service` (`sGCardNox` TEXT NOT NULL, `sSerialID` TEXT, `sEngineNo` TEXT, `sFrameNox` TEXT, `sBrandNme` TEXT, `sModelNme` TEXT, `cFSEPStat` TEXT, `dPurchase` TEXT, `nYellowxx` INTEGER NOT NULL, `nWhitexxx` INTEGER NOT NULL, `nYlwCtrxx` INTEGER NOT NULL, `nWhtCtrxx` INTEGER NOT NULL, `dLastSrvc` TEXT, `nMIlAgexx` INTEGER NOT NULL, `dNxtRmnds` TEXT, PRIMARY KEY(`sGCardNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `User_Info_Master` (`sClientID` TEXT NOT NULL, `sBranchCD` TEXT, `sBranchNm` TEXT, `sLogNoxxx` TEXT, `sUserIDxx` TEXT, `sEmailAdd` TEXT, `sUserName` TEXT, `nUserLevl` TEXT, `sDeptIDxx` TEXT, `sPositnID` TEXT, `sEmpLevID` TEXT, `cAllowUpd` TEXT, `dLoginxxx` TEXT, `sMobileNo` TEXT, `dSessionx` TEXT, `sEmployID` TEXT, PRIMARY KEY(`sClientID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tbl_user` (`name` TEXT NOT NULL, `gcard_number` TEXT, `avl_points` REAL NOT NULL, `d_modified` TEXT, PRIMARY KEY(`name`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `App_Token_Info` (`sAppToken` TEXT NOT NULL, PRIMARY KEY(`sAppToken`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Barangay_Info` (`sBrgyIDxx` TEXT NOT NULL, `sBrgyName` TEXT, `sTownIDxx` TEXT, `cHasRoute` TEXT, `cBlackLst` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sBrgyIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Town_Info` (`sTownIDxx` TEXT NOT NULL, `sTownName` TEXT, `sZippCode` TEXT, `sProvIDxx` TEXT, `sProvCode` TEXT, `sMuncplCd` TEXT, `cHasRoute` TEXT, `cBlackLst` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTownIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Province_Info` (`sProvIDxx` TEXT NOT NULL, `sProvName` TEXT, `cRecdStat` INTEGER NOT NULL, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sProvIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Country_Info` (`sCntryCde` TEXT NOT NULL, `sCntryNme` TEXT, `sNational` TEXT, `cRecdStat` TEXT, `dTimeStmp` TEXT, `dLstUpdte` TEXT, PRIMARY KEY(`sCntryCde`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `App_User_Mobile` (`sUserIDxx` TEXT NOT NULL, `dTransact` TEXT NOT NULL, `sMobileNo` TEXT, `cUserVrfd` INTEGER NOT NULL, `dUserVrfd` TEXT, `dVerified` TEXT, `cRecdStat` INTEGER NOT NULL, `dTimeStmp` TEXT, PRIMARY KEY(`sUserIDxx`, `dTransact`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Address_Update_Request` (`sTransNox` TEXT NOT NULL, `sClientID` TEXT, `cReqstCDe` TEXT, `cAddrssTp` TEXT, `sHouseNox` TEXT, `sAddressx` TEXT, `sTownIDxx` TEXT, `sBrgyIDxx` TEXT, `cPrimaryx` TEXT, `sSourceCD` TEXT, `sSourceNo` TEXT, `nLatitude` TEXT, `nLongitud` TEXT, `sRemarksx` TEXT, `cTranStat` TEXT, `cSendStat` TEXT, `dSendDate` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Product_Inventory` (`sListngID` TEXT NOT NULL, `sBriefDsc` TEXT, `sDescript` TEXT, `sStockIDx` TEXT, `xBarCodex` TEXT, `xDescript` TEXT, `nRatingxx` TEXT, `xBrandNme` TEXT, `sModelIDx` TEXT, `xModelNme` TEXT, `sImagesxx` TEXT, `xColorNme` TEXT, `xCategrNm` TEXT, `nTotalQty` TEXT, `nQtyOnHnd` TEXT, `nResvOrdr` TEXT, `nSoldQtyx` TEXT, `nUnitPrce` TEXT, `dListStrt` TEXT, `dListEndx` TEXT, `cAllwCrdt` TEXT, `cTranStat` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sListngID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MarketPlace_Cart` (`sUserIDxx` TEXT NOT NULL, `sListIDxx` TEXT NOT NULL, `cBuyNowxx` TEXT NOT NULL, `nQuantity` INTEGER, `nAvlQtyxx` INTEGER, `dCreatedx` TEXT, `cTranStat` TEXT, `cCheckOut` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sUserIDxx`, `sListIDxx`, `cBuyNowxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MarketPlace_Order_Detail` (`sTransNox` TEXT NOT NULL, `nEntryNox` TEXT NOT NULL, `sStockIDx` TEXT, `nQuantity` TEXT, `nUnitPrce` TEXT, `nDiscount` TEXT, `nAddDiscx` TEXT, `nApproved` TEXT, `nIssuedxx` TEXT, `nCancelld` TEXT, `sReferNox` TEXT, `sNotesxxx` TEXT, `cReviewed` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`, `nEntryNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `MarketPlace_Order_Master` (`sTransNox` TEXT NOT NULL, `sBranchCd` TEXT, `dTransact` TEXT, `dExpected` TEXT, `sClientID` TEXT, `sAppUsrID` TEXT, `sReferNox` TEXT, `sRemarksx` TEXT, `nTranTotl` REAL, `nVATRatex` REAL, `nDiscount` REAL, `nAddDiscx` REAL, `nFreightx` REAL, `nProcPaym` REAL, `nAmtPaidx` REAL, `dDueDatex` TEXT, `sTermCode` TEXT, `sSourceNo` TEXT, `sSourceCd` TEXT, `cTranStat` TEXT, `dWaybillx` TEXT, `sWaybilNo` TEXT, `sBatchNox` TEXT, `dPickedUp` TEXT, `cPaymPstd` TEXT, `cPaymType` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sTransNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Mkt_Search_log` (`nEntryNox` INTEGER NOT NULL, `sSearchxx` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`nEntryNox`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Client_Email_Info` (`sUserIDxx` TEXT NOT NULL, `dTransact` TEXT NOT NULL, `sEmailAdd` TEXT, `cVerified` INTEGER NOT NULL, `dVerified` TEXT, `cRecdStat` INTEGER NOT NULL, `dTimeStmp` TEXT, PRIMARY KEY(`sUserIDxx`, `dTransact`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Panalo_Reward` (`sPanaloCD` TEXT NOT NULL, `cTranStat` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sPanaloCD`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Guanzon_Panalo` (`sPanaloQC` TEXT NOT NULL, `dTransact` TEXT, `sUserIDxx` TEXT, `sPanaloCD` TEXT, `sPanaloDs` TEXT, `sAcctNmbr` TEXT, `nAmountxx` REAL, `sItemCode` TEXT, `sItemDesc` TEXT, `nItemQtyx` INTEGER, `nRedeemxx` REAL, `dExpiryDt` TEXT, `sBranchNm` TEXT, `dRedeemxx` TEXT, `cTranStat` TEXT, PRIMARY KEY(`sPanaloQC`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9bdf560978746035bed3e24a898cd8f5')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `App_Event_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `BranchInfo`");
        _db.execSQL("DROP TABLE IF EXISTS `Client_Profile_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `GCard_App_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `G_Card_Transaction_Ledger`");
        _db.execSQL("DROP TABLE IF EXISTS `MC_Serial_Registration`");
        _db.execSQL("DROP TABLE IF EXISTS `Promo_Link_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Notification_Info_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `Notification_Info_Recepient`");
        _db.execSQL("DROP TABLE IF EXISTS `Notification_User`");
        _db.execSQL("DROP TABLE IF EXISTS `Redeemables`");
        _db.execSQL("DROP TABLE IF EXISTS `Redeem_Item`");
        _db.execSQL("DROP TABLE IF EXISTS `MC_Service`");
        _db.execSQL("DROP TABLE IF EXISTS `User_Info_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `tbl_user`");
        _db.execSQL("DROP TABLE IF EXISTS `App_Token_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Barangay_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Town_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Province_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Country_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `App_User_Mobile`");
        _db.execSQL("DROP TABLE IF EXISTS `Address_Update_Request`");
        _db.execSQL("DROP TABLE IF EXISTS `Product_Inventory`");
        _db.execSQL("DROP TABLE IF EXISTS `MarketPlace_Cart`");
        _db.execSQL("DROP TABLE IF EXISTS `MarketPlace_Order_Detail`");
        _db.execSQL("DROP TABLE IF EXISTS `MarketPlace_Order_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `Mkt_Search_log`");
        _db.execSQL("DROP TABLE IF EXISTS `Client_Email_Info`");
        _db.execSQL("DROP TABLE IF EXISTS `Panalo_Reward`");
        _db.execSQL("DROP TABLE IF EXISTS `Guanzon_Panalo`");
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
        final HashMap<String, TableInfo.Column> _columnsAppEventInfo = new HashMap<String, TableInfo.Column>(12);
        _columnsAppEventInfo.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("sBranchNm", new TableInfo.Column("sBranchNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("dEvntFrom", new TableInfo.Column("dEvntFrom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("dEvntThru", new TableInfo.Column("dEvntThru", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("sEventTle", new TableInfo.Column("sEventTle", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("sAddressx", new TableInfo.Column("sAddressx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("sEventURL", new TableInfo.Column("sEventURL", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("sImageURL", new TableInfo.Column("sImageURL", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("cNotified", new TableInfo.Column("cNotified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("sDirectoryFolder", new TableInfo.Column("sDirectoryFolder", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppEventInfo.put("sImagePath", new TableInfo.Column("sImagePath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAppEventInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAppEventInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAppEventInfo = new TableInfo("App_Event_Info", _columnsAppEventInfo, _foreignKeysAppEventInfo, _indicesAppEventInfo);
        final TableInfo _existingAppEventInfo = TableInfo.read(_db, "App_Event_Info");
        if (! _infoAppEventInfo.equals(_existingAppEventInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "App_Event_Info(org.rmj.g3appdriver.GConnect.room.Entities.EEvents).\n"
                  + " Expected:\n" + _infoAppEventInfo + "\n"
                  + " Found:\n" + _existingAppEventInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsBranchInfo = new HashMap<String, TableInfo.Column>(14);
        _columnsBranchInfo.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sBranchNm", new TableInfo.Column("sBranchNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sDescript", new TableInfo.Column("sDescript", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sAddressx", new TableInfo.Column("sAddressx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sTownIDxx", new TableInfo.Column("sTownIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sTownName", new TableInfo.Column("sTownName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sProvName", new TableInfo.Column("sProvName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("nLatitude", new TableInfo.Column("nLatitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("nLongtude", new TableInfo.Column("nLongtude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sContactx", new TableInfo.Column("sContactx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sTelNumbr", new TableInfo.Column("sTelNumbr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("sEmailAdd", new TableInfo.Column("sEmailAdd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBranchInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBranchInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBranchInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBranchInfo = new TableInfo("BranchInfo", _columnsBranchInfo, _foreignKeysBranchInfo, _indicesBranchInfo);
        final TableInfo _existingBranchInfo = TableInfo.read(_db, "BranchInfo");
        if (! _infoBranchInfo.equals(_existingBranchInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "BranchInfo(org.rmj.g3appdriver.GConnect.room.Entities.EBranchInfo).\n"
                  + " Expected:\n" + _infoBranchInfo + "\n"
                  + " Found:\n" + _existingBranchInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsClientProfileInfo = new HashMap<String, TableInfo.Column>(33);
        _columnsClientProfileInfo.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sClientID", new TableInfo.Column("sClientID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sEmailAdd", new TableInfo.Column("sEmailAdd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sUserName", new TableInfo.Column("sUserName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sLastName", new TableInfo.Column("sLastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sFrstName", new TableInfo.Column("sFrstName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sMiddName", new TableInfo.Column("sMiddName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sSuffixNm", new TableInfo.Column("sSuffixNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sMaidenNm", new TableInfo.Column("sMaidenNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("cGenderCd", new TableInfo.Column("cGenderCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("cCvilStat", new TableInfo.Column("cCvilStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sCitizenx", new TableInfo.Column("sCitizenx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("dBirthDte", new TableInfo.Column("dBirthDte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sBirthPlc", new TableInfo.Column("sBirthPlc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sHouseNo1", new TableInfo.Column("sHouseNo1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sAddress1", new TableInfo.Column("sAddress1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sBrgyIDx1", new TableInfo.Column("sBrgyIDx1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sTownIDx1", new TableInfo.Column("sTownIDx1", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sHouseNo2", new TableInfo.Column("sHouseNo2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sAddress2", new TableInfo.Column("sAddress2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sBrgyIDx2", new TableInfo.Column("sBrgyIDx2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sTownIDx2", new TableInfo.Column("sTownIDx2", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sTaxIDNox", new TableInfo.Column("sTaxIDNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sMobileNo", new TableInfo.Column("sMobileNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("cVerified", new TableInfo.Column("cVerified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("dVerified", new TableInfo.Column("dVerified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("cAgreeTnC", new TableInfo.Column("cAgreeTnC", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("dDateMmbr", new TableInfo.Column("dDateMmbr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("sImagePth", new TableInfo.Column("sImagePth", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("dImgeDate", new TableInfo.Column("dImgeDate", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("cImgeStat", new TableInfo.Column("cImgeStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientProfileInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClientProfileInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClientProfileInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClientProfileInfo = new TableInfo("Client_Profile_Info", _columnsClientProfileInfo, _foreignKeysClientProfileInfo, _indicesClientProfileInfo);
        final TableInfo _existingClientProfileInfo = TableInfo.read(_db, "Client_Profile_Info");
        if (! _infoClientProfileInfo.equals(_existingClientProfileInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Client_Profile_Info(org.rmj.g3appdriver.GConnect.room.Entities.EClientInfo).\n"
                  + " Expected:\n" + _infoClientProfileInfo + "\n"
                  + " Found:\n" + _existingClientProfileInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsGCardAppMaster = new HashMap<String, TableInfo.Column>(12);
        _columnsGCardAppMaster.put("sGCardNox", new TableInfo.Column("sGCardNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("sCardNmbr", new TableInfo.Column("sCardNmbr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("sNmOnCard", new TableInfo.Column("sNmOnCard", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("dMemberxx", new TableInfo.Column("dMemberxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("cCardType", new TableInfo.Column("cCardType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("sTotPoint", new TableInfo.Column("sTotPoint", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("sAvlPoint", new TableInfo.Column("sAvlPoint", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("cActvStat", new TableInfo.Column("cActvStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardAppMaster.put("cNotified", new TableInfo.Column("cNotified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGCardAppMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGCardAppMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGCardAppMaster = new TableInfo("GCard_App_Master", _columnsGCardAppMaster, _foreignKeysGCardAppMaster, _indicesGCardAppMaster);
        final TableInfo _existingGCardAppMaster = TableInfo.read(_db, "GCard_App_Master");
        if (! _infoGCardAppMaster.equals(_existingGCardAppMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "GCard_App_Master(org.rmj.g3appdriver.GConnect.room.Entities.EGcardApp).\n"
                  + " Expected:\n" + _infoGCardAppMaster + "\n"
                  + " Found:\n" + _existingGCardAppMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsGCardTransactionLedger = new HashMap<String, TableInfo.Column>(11);
        _columnsGCardTransactionLedger.put("sReferNox", new TableInfo.Column("sReferNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardTransactionLedger.put("sGCardNox", new TableInfo.Column("sGCardNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardTransactionLedger.put("nEntryNox", new TableInfo.Column("nEntryNox", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardTransactionLedger.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardTransactionLedger.put("sSourceDs", new TableInfo.Column("sSourceDs", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardTransactionLedger.put("sTranType", new TableInfo.Column("sTranType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardTransactionLedger.put("sTranDesc", new TableInfo.Column("sTranDesc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardTransactionLedger.put("sSourceNo", new TableInfo.Column("sSourceNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardTransactionLedger.put("nPointsxx", new TableInfo.Column("nPointsxx", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardTransactionLedger.put("cQRCodexx", new TableInfo.Column("cQRCodexx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGCardTransactionLedger.put("cReceived", new TableInfo.Column("cReceived", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGCardTransactionLedger = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGCardTransactionLedger = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGCardTransactionLedger = new TableInfo("G_Card_Transaction_Ledger", _columnsGCardTransactionLedger, _foreignKeysGCardTransactionLedger, _indicesGCardTransactionLedger);
        final TableInfo _existingGCardTransactionLedger = TableInfo.read(_db, "G_Card_Transaction_Ledger");
        if (! _infoGCardTransactionLedger.equals(_existingGCardTransactionLedger)) {
          return new RoomOpenHelper.ValidationResult(false, "G_Card_Transaction_Ledger(org.rmj.g3appdriver.GConnect.room.Entities.EGCardLedger).\n"
                  + " Expected:\n" + _infoGCardTransactionLedger + "\n"
                  + " Found:\n" + _existingGCardTransactionLedger);
        }
        final HashMap<String, TableInfo.Column> _columnsMCSerialRegistration = new HashMap<String, TableInfo.Column>(7);
        _columnsMCSerialRegistration.put("sSerialID", new TableInfo.Column("sSerialID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCSerialRegistration.put("sGCardNox", new TableInfo.Column("sGCardNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCSerialRegistration.put("sEngineNo", new TableInfo.Column("sEngineNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCSerialRegistration.put("sFrameNox", new TableInfo.Column("sFrameNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCSerialRegistration.put("sModelNme", new TableInfo.Column("sModelNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCSerialRegistration.put("sFSEPStat", new TableInfo.Column("sFSEPStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCSerialRegistration.put("cRegStatx", new TableInfo.Column("cRegStatx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMCSerialRegistration = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMCSerialRegistration = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMCSerialRegistration = new TableInfo("MC_Serial_Registration", _columnsMCSerialRegistration, _foreignKeysMCSerialRegistration, _indicesMCSerialRegistration);
        final TableInfo _existingMCSerialRegistration = TableInfo.read(_db, "MC_Serial_Registration");
        if (! _infoMCSerialRegistration.equals(_existingMCSerialRegistration)) {
          return new RoomOpenHelper.ValidationResult(false, "MC_Serial_Registration(org.rmj.g3appdriver.GConnect.room.Entities.EMCSerialRegistration).\n"
                  + " Expected:\n" + _infoMCSerialRegistration + "\n"
                  + " Found:\n" + _existingMCSerialRegistration);
        }
        final HashMap<String, TableInfo.Column> _columnsPromoLinkInfo = new HashMap<String, TableInfo.Column>(13);
        _columnsPromoLinkInfo.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("dDateFrom", new TableInfo.Column("dDateFrom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("dDateThru", new TableInfo.Column("dDateThru", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("sCaptionx", new TableInfo.Column("sCaptionx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("sImageUrl", new TableInfo.Column("sImageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("sImageSld", new TableInfo.Column("sImageSld", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("sImgeByte", new TableInfo.Column("sImgeByte", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("sPromoUrl", new TableInfo.Column("sPromoUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("cNotified", new TableInfo.Column("cNotified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("cDivision", new TableInfo.Column("cDivision", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPromoLinkInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPromoLinkInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPromoLinkInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPromoLinkInfo = new TableInfo("Promo_Link_Info", _columnsPromoLinkInfo, _foreignKeysPromoLinkInfo, _indicesPromoLinkInfo);
        final TableInfo _existingPromoLinkInfo = TableInfo.read(_db, "Promo_Link_Info");
        if (! _infoPromoLinkInfo.equals(_existingPromoLinkInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Promo_Link_Info(org.rmj.g3appdriver.GConnect.room.Entities.EPromo).\n"
                  + " Expected:\n" + _infoPromoLinkInfo + "\n"
                  + " Found:\n" + _existingPromoLinkInfo);
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
          return new RoomOpenHelper.ValidationResult(false, "Notification_Info_Master(org.rmj.g3appdriver.GConnect.room.Entities.ENotificationMaster).\n"
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
          return new RoomOpenHelper.ValidationResult(false, "Notification_Info_Recepient(org.rmj.g3appdriver.GConnect.room.Entities.ENotificationRecipient).\n"
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
          return new RoomOpenHelper.ValidationResult(false, "Notification_User(org.rmj.g3appdriver.GConnect.room.Entities.ENotificationUser).\n"
                  + " Expected:\n" + _infoNotificationUser + "\n"
                  + " Found:\n" + _existingNotificationUser);
        }
        final HashMap<String, TableInfo.Column> _columnsRedeemables = new HashMap<String, TableInfo.Column>(9);
        _columnsRedeemables.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemables.put("sPromoCde", new TableInfo.Column("sPromoCde", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemables.put("sPromoDsc", new TableInfo.Column("sPromoDsc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemables.put("nPointsxx", new TableInfo.Column("nPointsxx", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemables.put("sImageUrl", new TableInfo.Column("sImageUrl", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemables.put("cPreOrder", new TableInfo.Column("cPreOrder", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemables.put("dDateFrom", new TableInfo.Column("dDateFrom", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemables.put("dDateThru", new TableInfo.Column("dDateThru", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemables.put("cNotified", new TableInfo.Column("cNotified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRedeemables = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRedeemables = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRedeemables = new TableInfo("Redeemables", _columnsRedeemables, _foreignKeysRedeemables, _indicesRedeemables);
        final TableInfo _existingRedeemables = TableInfo.read(_db, "Redeemables");
        if (! _infoRedeemables.equals(_existingRedeemables)) {
          return new RoomOpenHelper.ValidationResult(false, "Redeemables(org.rmj.g3appdriver.GConnect.room.Entities.ERedeemablesInfo).\n"
                  + " Expected:\n" + _infoRedeemables + "\n"
                  + " Found:\n" + _existingRedeemables);
        }
        final HashMap<String, TableInfo.Column> _columnsRedeemItem = new HashMap<String, TableInfo.Column>(14);
        _columnsRedeemItem.put("sPromoIDx", new TableInfo.Column("sPromoIDx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("sBatchNox", new TableInfo.Column("sBatchNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("sGCardNox", new TableInfo.Column("sGCardNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("nItemQtyx", new TableInfo.Column("nItemQtyx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("nPointsxx", new TableInfo.Column("nPointsxx", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("sReferNox", new TableInfo.Column("sReferNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("dOrderedx", new TableInfo.Column("dOrderedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("dPlacOrdr", new TableInfo.Column("dPlacOrdr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("dPickupxx", new TableInfo.Column("dPickupxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("cPlcOrder", new TableInfo.Column("cPlcOrder", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsRedeemItem.put("cNotified", new TableInfo.Column("cNotified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRedeemItem = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRedeemItem = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRedeemItem = new TableInfo("Redeem_Item", _columnsRedeemItem, _foreignKeysRedeemItem, _indicesRedeemItem);
        final TableInfo _existingRedeemItem = TableInfo.read(_db, "Redeem_Item");
        if (! _infoRedeemItem.equals(_existingRedeemItem)) {
          return new RoomOpenHelper.ValidationResult(false, "Redeem_Item(org.rmj.g3appdriver.GConnect.room.Entities.ERedeemItemInfo).\n"
                  + " Expected:\n" + _infoRedeemItem + "\n"
                  + " Found:\n" + _existingRedeemItem);
        }
        final HashMap<String, TableInfo.Column> _columnsMCService = new HashMap<String, TableInfo.Column>(15);
        _columnsMCService.put("sGCardNox", new TableInfo.Column("sGCardNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("sSerialID", new TableInfo.Column("sSerialID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("sEngineNo", new TableInfo.Column("sEngineNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("sFrameNox", new TableInfo.Column("sFrameNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("sBrandNme", new TableInfo.Column("sBrandNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("sModelNme", new TableInfo.Column("sModelNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("cFSEPStat", new TableInfo.Column("cFSEPStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("dPurchase", new TableInfo.Column("dPurchase", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("nYellowxx", new TableInfo.Column("nYellowxx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("nWhitexxx", new TableInfo.Column("nWhitexxx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("nYlwCtrxx", new TableInfo.Column("nYlwCtrxx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("nWhtCtrxx", new TableInfo.Column("nWhtCtrxx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("dLastSrvc", new TableInfo.Column("dLastSrvc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("nMIlAgexx", new TableInfo.Column("nMIlAgexx", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMCService.put("dNxtRmnds", new TableInfo.Column("dNxtRmnds", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMCService = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMCService = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMCService = new TableInfo("MC_Service", _columnsMCService, _foreignKeysMCService, _indicesMCService);
        final TableInfo _existingMCService = TableInfo.read(_db, "MC_Service");
        if (! _infoMCService.equals(_existingMCService)) {
          return new RoomOpenHelper.ValidationResult(false, "MC_Service(org.rmj.g3appdriver.GConnect.room.Entities.EServiceInfo).\n"
                  + " Expected:\n" + _infoMCService + "\n"
                  + " Found:\n" + _existingMCService);
        }
        final HashMap<String, TableInfo.Column> _columnsUserInfoMaster = new HashMap<String, TableInfo.Column>(16);
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
        _columnsUserInfoMaster.put("sEmpLevID", new TableInfo.Column("sEmpLevID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("cAllowUpd", new TableInfo.Column("cAllowUpd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("dLoginxxx", new TableInfo.Column("dLoginxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sMobileNo", new TableInfo.Column("sMobileNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("dSessionx", new TableInfo.Column("dSessionx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUserInfoMaster.put("sEmployID", new TableInfo.Column("sEmployID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUserInfoMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUserInfoMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUserInfoMaster = new TableInfo("User_Info_Master", _columnsUserInfoMaster, _foreignKeysUserInfoMaster, _indicesUserInfoMaster);
        final TableInfo _existingUserInfoMaster = TableInfo.read(_db, "User_Info_Master");
        if (! _infoUserInfoMaster.equals(_existingUserInfoMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "User_Info_Master(org.rmj.g3appdriver.GConnect.room.Entities.EEmployeeInfo).\n"
                  + " Expected:\n" + _infoUserInfoMaster + "\n"
                  + " Found:\n" + _existingUserInfoMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsTblUser = new HashMap<String, TableInfo.Column>(4);
        _columnsTblUser.put("name", new TableInfo.Column("name", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUser.put("gcard_number", new TableInfo.Column("gcard_number", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUser.put("avl_points", new TableInfo.Column("avl_points", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTblUser.put("d_modified", new TableInfo.Column("d_modified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTblUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTblUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTblUser = new TableInfo("tbl_user", _columnsTblUser, _foreignKeysTblUser, _indicesTblUser);
        final TableInfo _existingTblUser = TableInfo.read(_db, "tbl_user");
        if (! _infoTblUser.equals(_existingTblUser)) {
          return new RoomOpenHelper.ValidationResult(false, "tbl_user(org.rmj.g3appdriver.GConnect.room.Entities.EUserInfo).\n"
                  + " Expected:\n" + _infoTblUser + "\n"
                  + " Found:\n" + _existingTblUser);
        }
        final HashMap<String, TableInfo.Column> _columnsAppTokenInfo = new HashMap<String, TableInfo.Column>(1);
        _columnsAppTokenInfo.put("sAppToken", new TableInfo.Column("sAppToken", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAppTokenInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAppTokenInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAppTokenInfo = new TableInfo("App_Token_Info", _columnsAppTokenInfo, _foreignKeysAppTokenInfo, _indicesAppTokenInfo);
        final TableInfo _existingAppTokenInfo = TableInfo.read(_db, "App_Token_Info");
        if (! _infoAppTokenInfo.equals(_existingAppTokenInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "App_Token_Info(org.rmj.g3appdriver.GConnect.room.Entities.ETokenInfo).\n"
                  + " Expected:\n" + _infoAppTokenInfo + "\n"
                  + " Found:\n" + _existingAppTokenInfo);
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
          return new RoomOpenHelper.ValidationResult(false, "Barangay_Info(org.rmj.g3appdriver.GConnect.room.Entities.EBarangayInfo).\n"
                  + " Expected:\n" + _infoBarangayInfo + "\n"
                  + " Found:\n" + _existingBarangayInfo);
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
          return new RoomOpenHelper.ValidationResult(false, "Town_Info(org.rmj.g3appdriver.GConnect.room.Entities.ETownInfo).\n"
                  + " Expected:\n" + _infoTownInfo + "\n"
                  + " Found:\n" + _existingTownInfo);
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
          return new RoomOpenHelper.ValidationResult(false, "Province_Info(org.rmj.g3appdriver.GConnect.room.Entities.EProvinceInfo).\n"
                  + " Expected:\n" + _infoProvinceInfo + "\n"
                  + " Found:\n" + _existingProvinceInfo);
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
          return new RoomOpenHelper.ValidationResult(false, "Country_Info(org.rmj.g3appdriver.GConnect.room.Entities.ECountryInfo).\n"
                  + " Expected:\n" + _infoCountryInfo + "\n"
                  + " Found:\n" + _existingCountryInfo);
        }
        final HashMap<String, TableInfo.Column> _columnsAppUserMobile = new HashMap<String, TableInfo.Column>(8);
        _columnsAppUserMobile.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUserMobile.put("dTransact", new TableInfo.Column("dTransact", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUserMobile.put("sMobileNo", new TableInfo.Column("sMobileNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUserMobile.put("cUserVrfd", new TableInfo.Column("cUserVrfd", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUserMobile.put("dUserVrfd", new TableInfo.Column("dUserVrfd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUserMobile.put("dVerified", new TableInfo.Column("dVerified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUserMobile.put("cRecdStat", new TableInfo.Column("cRecdStat", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAppUserMobile.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAppUserMobile = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAppUserMobile = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAppUserMobile = new TableInfo("App_User_Mobile", _columnsAppUserMobile, _foreignKeysAppUserMobile, _indicesAppUserMobile);
        final TableInfo _existingAppUserMobile = TableInfo.read(_db, "App_User_Mobile");
        if (! _infoAppUserMobile.equals(_existingAppUserMobile)) {
          return new RoomOpenHelper.ValidationResult(false, "App_User_Mobile(org.rmj.g3appdriver.GConnect.room.Entities.EMobileInfo).\n"
                  + " Expected:\n" + _infoAppUserMobile + "\n"
                  + " Found:\n" + _existingAppUserMobile);
        }
        final HashMap<String, TableInfo.Column> _columnsAddressUpdateRequest = new HashMap<String, TableInfo.Column>(19);
        _columnsAddressUpdateRequest.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sClientID", new TableInfo.Column("sClientID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("cReqstCDe", new TableInfo.Column("cReqstCDe", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("cAddrssTp", new TableInfo.Column("cAddrssTp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sHouseNox", new TableInfo.Column("sHouseNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sAddressx", new TableInfo.Column("sAddressx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sTownIDxx", new TableInfo.Column("sTownIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sBrgyIDxx", new TableInfo.Column("sBrgyIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("cPrimaryx", new TableInfo.Column("cPrimaryx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sSourceCD", new TableInfo.Column("sSourceCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAddressUpdateRequest.put("sSourceNo", new TableInfo.Column("sSourceNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
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
          return new RoomOpenHelper.ValidationResult(false, "Address_Update_Request(org.rmj.g3appdriver.GConnect.room.Entities.EAddressInfo).\n"
                  + " Expected:\n" + _infoAddressUpdateRequest + "\n"
                  + " Found:\n" + _existingAddressUpdateRequest);
        }
        final HashMap<String, TableInfo.Column> _columnsProductInventory = new HashMap<String, TableInfo.Column>(23);
        _columnsProductInventory.put("sListngID", new TableInfo.Column("sListngID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("sBriefDsc", new TableInfo.Column("sBriefDsc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("sDescript", new TableInfo.Column("sDescript", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("sStockIDx", new TableInfo.Column("sStockIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("xBarCodex", new TableInfo.Column("xBarCodex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("xDescript", new TableInfo.Column("xDescript", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("nRatingxx", new TableInfo.Column("nRatingxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("xBrandNme", new TableInfo.Column("xBrandNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("sModelIDx", new TableInfo.Column("sModelIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("xModelNme", new TableInfo.Column("xModelNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("sImagesxx", new TableInfo.Column("sImagesxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("xColorNme", new TableInfo.Column("xColorNme", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("xCategrNm", new TableInfo.Column("xCategrNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("nTotalQty", new TableInfo.Column("nTotalQty", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("nQtyOnHnd", new TableInfo.Column("nQtyOnHnd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("nResvOrdr", new TableInfo.Column("nResvOrdr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("nSoldQtyx", new TableInfo.Column("nSoldQtyx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("nUnitPrce", new TableInfo.Column("nUnitPrce", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("dListStrt", new TableInfo.Column("dListStrt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("dListEndx", new TableInfo.Column("dListEndx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("cAllwCrdt", new TableInfo.Column("cAllwCrdt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsProductInventory.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysProductInventory = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesProductInventory = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoProductInventory = new TableInfo("Product_Inventory", _columnsProductInventory, _foreignKeysProductInventory, _indicesProductInventory);
        final TableInfo _existingProductInventory = TableInfo.read(_db, "Product_Inventory");
        if (! _infoProductInventory.equals(_existingProductInventory)) {
          return new RoomOpenHelper.ValidationResult(false, "Product_Inventory(org.rmj.g3appdriver.GConnect.room.Entities.EProducts).\n"
                  + " Expected:\n" + _infoProductInventory + "\n"
                  + " Found:\n" + _existingProductInventory);
        }
        final HashMap<String, TableInfo.Column> _columnsMarketPlaceCart = new HashMap<String, TableInfo.Column>(9);
        _columnsMarketPlaceCart.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceCart.put("sListIDxx", new TableInfo.Column("sListIDxx", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceCart.put("cBuyNowxx", new TableInfo.Column("cBuyNowxx", "TEXT", true, 3, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceCart.put("nQuantity", new TableInfo.Column("nQuantity", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceCart.put("nAvlQtyxx", new TableInfo.Column("nAvlQtyxx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceCart.put("dCreatedx", new TableInfo.Column("dCreatedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceCart.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceCart.put("cCheckOut", new TableInfo.Column("cCheckOut", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceCart.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMarketPlaceCart = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMarketPlaceCart = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMarketPlaceCart = new TableInfo("MarketPlace_Cart", _columnsMarketPlaceCart, _foreignKeysMarketPlaceCart, _indicesMarketPlaceCart);
        final TableInfo _existingMarketPlaceCart = TableInfo.read(_db, "MarketPlace_Cart");
        if (! _infoMarketPlaceCart.equals(_existingMarketPlaceCart)) {
          return new RoomOpenHelper.ValidationResult(false, "MarketPlace_Cart(org.rmj.g3appdriver.GConnect.room.Entities.EItemCart).\n"
                  + " Expected:\n" + _infoMarketPlaceCart + "\n"
                  + " Found:\n" + _existingMarketPlaceCart);
        }
        final HashMap<String, TableInfo.Column> _columnsMarketPlaceOrderDetail = new HashMap<String, TableInfo.Column>(14);
        _columnsMarketPlaceOrderDetail.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("nEntryNox", new TableInfo.Column("nEntryNox", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("sStockIDx", new TableInfo.Column("sStockIDx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("nQuantity", new TableInfo.Column("nQuantity", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("nUnitPrce", new TableInfo.Column("nUnitPrce", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("nDiscount", new TableInfo.Column("nDiscount", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("nAddDiscx", new TableInfo.Column("nAddDiscx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("nApproved", new TableInfo.Column("nApproved", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("nIssuedxx", new TableInfo.Column("nIssuedxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("nCancelld", new TableInfo.Column("nCancelld", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("sReferNox", new TableInfo.Column("sReferNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("sNotesxxx", new TableInfo.Column("sNotesxxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("cReviewed", new TableInfo.Column("cReviewed", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderDetail.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMarketPlaceOrderDetail = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMarketPlaceOrderDetail = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMarketPlaceOrderDetail = new TableInfo("MarketPlace_Order_Detail", _columnsMarketPlaceOrderDetail, _foreignKeysMarketPlaceOrderDetail, _indicesMarketPlaceOrderDetail);
        final TableInfo _existingMarketPlaceOrderDetail = TableInfo.read(_db, "MarketPlace_Order_Detail");
        if (! _infoMarketPlaceOrderDetail.equals(_existingMarketPlaceOrderDetail)) {
          return new RoomOpenHelper.ValidationResult(false, "MarketPlace_Order_Detail(org.rmj.g3appdriver.GConnect.room.Entities.EOrderDetail).\n"
                  + " Expected:\n" + _infoMarketPlaceOrderDetail + "\n"
                  + " Found:\n" + _existingMarketPlaceOrderDetail);
        }
        final HashMap<String, TableInfo.Column> _columnsMarketPlaceOrderMaster = new HashMap<String, TableInfo.Column>(28);
        _columnsMarketPlaceOrderMaster.put("sTransNox", new TableInfo.Column("sTransNox", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("dExpected", new TableInfo.Column("dExpected", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("sClientID", new TableInfo.Column("sClientID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("sAppUsrID", new TableInfo.Column("sAppUsrID", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("sReferNox", new TableInfo.Column("sReferNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("nTranTotl", new TableInfo.Column("nTranTotl", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("nVATRatex", new TableInfo.Column("nVATRatex", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("nDiscount", new TableInfo.Column("nDiscount", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("nAddDiscx", new TableInfo.Column("nAddDiscx", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("nFreightx", new TableInfo.Column("nFreightx", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("nProcPaym", new TableInfo.Column("nProcPaym", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("nAmtPaidx", new TableInfo.Column("nAmtPaidx", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("dDueDatex", new TableInfo.Column("dDueDatex", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("sTermCode", new TableInfo.Column("sTermCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("sSourceNo", new TableInfo.Column("sSourceNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("sSourceCd", new TableInfo.Column("sSourceCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("dWaybillx", new TableInfo.Column("dWaybillx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("sWaybilNo", new TableInfo.Column("sWaybilNo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("sBatchNox", new TableInfo.Column("sBatchNox", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("dPickedUp", new TableInfo.Column("dPickedUp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("cPaymPstd", new TableInfo.Column("cPaymPstd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("cPaymType", new TableInfo.Column("cPaymType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMarketPlaceOrderMaster.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMarketPlaceOrderMaster = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMarketPlaceOrderMaster = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMarketPlaceOrderMaster = new TableInfo("MarketPlace_Order_Master", _columnsMarketPlaceOrderMaster, _foreignKeysMarketPlaceOrderMaster, _indicesMarketPlaceOrderMaster);
        final TableInfo _existingMarketPlaceOrderMaster = TableInfo.read(_db, "MarketPlace_Order_Master");
        if (! _infoMarketPlaceOrderMaster.equals(_existingMarketPlaceOrderMaster)) {
          return new RoomOpenHelper.ValidationResult(false, "MarketPlace_Order_Master(org.rmj.g3appdriver.GConnect.room.Entities.EOrderMaster).\n"
                  + " Expected:\n" + _infoMarketPlaceOrderMaster + "\n"
                  + " Found:\n" + _existingMarketPlaceOrderMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsMktSearchLog = new HashMap<String, TableInfo.Column>(3);
        _columnsMktSearchLog.put("nEntryNox", new TableInfo.Column("nEntryNox", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMktSearchLog.put("sSearchxx", new TableInfo.Column("sSearchxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMktSearchLog.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMktSearchLog = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMktSearchLog = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMktSearchLog = new TableInfo("Mkt_Search_log", _columnsMktSearchLog, _foreignKeysMktSearchLog, _indicesMktSearchLog);
        final TableInfo _existingMktSearchLog = TableInfo.read(_db, "Mkt_Search_log");
        if (! _infoMktSearchLog.equals(_existingMktSearchLog)) {
          return new RoomOpenHelper.ValidationResult(false, "Mkt_Search_log(org.rmj.g3appdriver.GConnect.room.Entities.ESearchLog).\n"
                  + " Expected:\n" + _infoMktSearchLog + "\n"
                  + " Found:\n" + _existingMktSearchLog);
        }
        final HashMap<String, TableInfo.Column> _columnsClientEmailInfo = new HashMap<String, TableInfo.Column>(7);
        _columnsClientEmailInfo.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEmailInfo.put("dTransact", new TableInfo.Column("dTransact", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEmailInfo.put("sEmailAdd", new TableInfo.Column("sEmailAdd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEmailInfo.put("cVerified", new TableInfo.Column("cVerified", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEmailInfo.put("dVerified", new TableInfo.Column("dVerified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEmailInfo.put("cRecdStat", new TableInfo.Column("cRecdStat", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClientEmailInfo.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClientEmailInfo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClientEmailInfo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClientEmailInfo = new TableInfo("Client_Email_Info", _columnsClientEmailInfo, _foreignKeysClientEmailInfo, _indicesClientEmailInfo);
        final TableInfo _existingClientEmailInfo = TableInfo.read(_db, "Client_Email_Info");
        if (! _infoClientEmailInfo.equals(_existingClientEmailInfo)) {
          return new RoomOpenHelper.ValidationResult(false, "Client_Email_Info(org.rmj.g3appdriver.GConnect.room.Entities.EEmailInfo).\n"
                  + " Expected:\n" + _infoClientEmailInfo + "\n"
                  + " Found:\n" + _existingClientEmailInfo);
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
          return new RoomOpenHelper.ValidationResult(false, "Panalo_Reward(org.rmj.g3appdriver.GConnect.room.Entities.EPanaloReward).\n"
                  + " Expected:\n" + _infoPanaloReward + "\n"
                  + " Found:\n" + _existingPanaloReward);
        }
        final HashMap<String, TableInfo.Column> _columnsGuanzonPanalo = new HashMap<String, TableInfo.Column>(15);
        _columnsGuanzonPanalo.put("sPanaloQC", new TableInfo.Column("sPanaloQC", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("dTransact", new TableInfo.Column("dTransact", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("sPanaloCD", new TableInfo.Column("sPanaloCD", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("sPanaloDs", new TableInfo.Column("sPanaloDs", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("sAcctNmbr", new TableInfo.Column("sAcctNmbr", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("nAmountxx", new TableInfo.Column("nAmountxx", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("sItemCode", new TableInfo.Column("sItemCode", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("sItemDesc", new TableInfo.Column("sItemDesc", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("nItemQtyx", new TableInfo.Column("nItemQtyx", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("nRedeemxx", new TableInfo.Column("nRedeemxx", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("dExpiryDt", new TableInfo.Column("dExpiryDt", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("sBranchNm", new TableInfo.Column("sBranchNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("dRedeemxx", new TableInfo.Column("dRedeemxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsGuanzonPanalo.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysGuanzonPanalo = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesGuanzonPanalo = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoGuanzonPanalo = new TableInfo("Guanzon_Panalo", _columnsGuanzonPanalo, _foreignKeysGuanzonPanalo, _indicesGuanzonPanalo);
        final TableInfo _existingGuanzonPanalo = TableInfo.read(_db, "Guanzon_Panalo");
        if (! _infoGuanzonPanalo.equals(_existingGuanzonPanalo)) {
          return new RoomOpenHelper.ValidationResult(false, "Guanzon_Panalo(org.rmj.g3appdriver.GConnect.room.Entities.EGuanzonPanalo).\n"
                  + " Expected:\n" + _infoGuanzonPanalo + "\n"
                  + " Found:\n" + _existingGuanzonPanalo);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "9bdf560978746035bed3e24a898cd8f5", "ab20cd2f16f5354302955eed1d9219bb");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "App_Event_Info","BranchInfo","Client_Profile_Info","GCard_App_Master","G_Card_Transaction_Ledger","MC_Serial_Registration","Promo_Link_Info","Notification_Info_Master","Notification_Info_Recepient","Notification_User","Redeemables","Redeem_Item","MC_Service","User_Info_Master","tbl_user","App_Token_Info","Barangay_Info","Town_Info","Province_Info","Country_Info","App_User_Mobile","Address_Update_Request","Product_Inventory","MarketPlace_Cart","MarketPlace_Order_Detail","MarketPlace_Order_Master","Mkt_Search_log","Client_Email_Info","Panalo_Reward","Guanzon_Panalo");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `App_Event_Info`");
      _db.execSQL("DELETE FROM `BranchInfo`");
      _db.execSQL("DELETE FROM `Client_Profile_Info`");
      _db.execSQL("DELETE FROM `GCard_App_Master`");
      _db.execSQL("DELETE FROM `G_Card_Transaction_Ledger`");
      _db.execSQL("DELETE FROM `MC_Serial_Registration`");
      _db.execSQL("DELETE FROM `Promo_Link_Info`");
      _db.execSQL("DELETE FROM `Notification_Info_Master`");
      _db.execSQL("DELETE FROM `Notification_Info_Recepient`");
      _db.execSQL("DELETE FROM `Notification_User`");
      _db.execSQL("DELETE FROM `Redeemables`");
      _db.execSQL("DELETE FROM `Redeem_Item`");
      _db.execSQL("DELETE FROM `MC_Service`");
      _db.execSQL("DELETE FROM `User_Info_Master`");
      _db.execSQL("DELETE FROM `tbl_user`");
      _db.execSQL("DELETE FROM `App_Token_Info`");
      _db.execSQL("DELETE FROM `Barangay_Info`");
      _db.execSQL("DELETE FROM `Town_Info`");
      _db.execSQL("DELETE FROM `Province_Info`");
      _db.execSQL("DELETE FROM `Country_Info`");
      _db.execSQL("DELETE FROM `App_User_Mobile`");
      _db.execSQL("DELETE FROM `Address_Update_Request`");
      _db.execSQL("DELETE FROM `Product_Inventory`");
      _db.execSQL("DELETE FROM `MarketPlace_Cart`");
      _db.execSQL("DELETE FROM `MarketPlace_Order_Detail`");
      _db.execSQL("DELETE FROM `MarketPlace_Order_Master`");
      _db.execSQL("DELETE FROM `Mkt_Search_log`");
      _db.execSQL("DELETE FROM `Client_Email_Info`");
      _db.execSQL("DELETE FROM `Panalo_Reward`");
      _db.execSQL("DELETE FROM `Guanzon_Panalo`");
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
    _typeConvertersMap.put(DBranchInfo.class, DBranchInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DClientInfo.class, DClientInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DGcardApp.class, DGcardApp_Impl.getRequiredConverters());
    _typeConvertersMap.put(DGCardTransactionLedger.class, DGCardTransactionLedger_Impl.getRequiredConverters());
    _typeConvertersMap.put(DMCSerialRegistration.class, DMCSerialRegistration_Impl.getRequiredConverters());
    _typeConvertersMap.put(DPromo.class, DPromo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DRedeemablesInfo.class, DRedeemablesInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DRedeemItemInfo.class, DRedeemItemInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DServiceInfo.class, DServiceInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DUserInfo.class, DUserInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DRawDao.class, DRawDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(DEmployeeInfo.class, DEmployeeInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DNotifications.class, DNotifications_Impl.getRequiredConverters());
    _typeConvertersMap.put(DEvents.class, DEvents_Impl.getRequiredConverters());
    _typeConvertersMap.put(DAddress.class, DAddress_Impl.getRequiredConverters());
    _typeConvertersMap.put(DMobileAddressInfo.class, DMobileAddressInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DProduct.class, DProduct_Impl.getRequiredConverters());
    _typeConvertersMap.put(DItemCart.class, DItemCart_Impl.getRequiredConverters());
    _typeConvertersMap.put(DOrder.class, DOrder_Impl.getRequiredConverters());
    _typeConvertersMap.put(DOrderDetail.class, DOrderDetail_Impl.getRequiredConverters());
    _typeConvertersMap.put(DSearchLog.class, DSearchLog_Impl.getRequiredConverters());
    _typeConvertersMap.put(DPanalo.class, DPanalo_Impl.getRequiredConverters());
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
  public DBranchInfo EBranchDao() {
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
  public DClientInfo EClientDao() {
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
  public DGcardApp EGcardAppDao() {
    if (_dGcardApp != null) {
      return _dGcardApp;
    } else {
      synchronized(this) {
        if(_dGcardApp == null) {
          _dGcardApp = new DGcardApp_Impl(this);
        }
        return _dGcardApp;
      }
    }
  }

  @Override
  public DGCardTransactionLedger gcardLedgerDao() {
    if (_dGCardTransactionLedger != null) {
      return _dGCardTransactionLedger;
    } else {
      synchronized(this) {
        if(_dGCardTransactionLedger == null) {
          _dGCardTransactionLedger = new DGCardTransactionLedger_Impl(this);
        }
        return _dGCardTransactionLedger;
      }
    }
  }

  @Override
  public DMCSerialRegistration EMCSerialRegistrationDao() {
    if (_dMCSerialRegistration != null) {
      return _dMCSerialRegistration;
    } else {
      synchronized(this) {
        if(_dMCSerialRegistration == null) {
          _dMCSerialRegistration = new DMCSerialRegistration_Impl(this);
        }
        return _dMCSerialRegistration;
      }
    }
  }

  @Override
  public DPromo EPromoDao() {
    if (_dPromo != null) {
      return _dPromo;
    } else {
      synchronized(this) {
        if(_dPromo == null) {
          _dPromo = new DPromo_Impl(this);
        }
        return _dPromo;
      }
    }
  }

  @Override
  public DRedeemablesInfo redeemablesDao() {
    if (_dRedeemablesInfo != null) {
      return _dRedeemablesInfo;
    } else {
      synchronized(this) {
        if(_dRedeemablesInfo == null) {
          _dRedeemablesInfo = new DRedeemablesInfo_Impl(this);
        }
        return _dRedeemablesInfo;
      }
    }
  }

  @Override
  public DRedeemItemInfo redeemedDao() {
    if (_dRedeemItemInfo != null) {
      return _dRedeemItemInfo;
    } else {
      synchronized(this) {
        if(_dRedeemItemInfo == null) {
          _dRedeemItemInfo = new DRedeemItemInfo_Impl(this);
        }
        return _dRedeemItemInfo;
      }
    }
  }

  @Override
  public DServiceInfo EServiceDao() {
    if (_dServiceInfo != null) {
      return _dServiceInfo;
    } else {
      synchronized(this) {
        if(_dServiceInfo == null) {
          _dServiceInfo = new DServiceInfo_Impl(this);
        }
        return _dServiceInfo;
      }
    }
  }

  @Override
  public DUserInfo EUserInfoDao() {
    if (_dUserInfo != null) {
      return _dUserInfo;
    } else {
      synchronized(this) {
        if(_dUserInfo == null) {
          _dUserInfo = new DUserInfo_Impl(this);
        }
        return _dUserInfo;
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
  public DNotifications NotificationDao() {
    if (_dNotifications != null) {
      return _dNotifications;
    } else {
      synchronized(this) {
        if(_dNotifications == null) {
          _dNotifications = new DNotifications_Impl(this);
        }
        return _dNotifications;
      }
    }
  }

  @Override
  public DEvents EventDao() {
    if (_dEvents != null) {
      return _dEvents;
    } else {
      synchronized(this) {
        if(_dEvents == null) {
          _dEvents = new DEvents_Impl(this);
        }
        return _dEvents;
      }
    }
  }

  @Override
  public DAddress AddDao() {
    if (_dAddress != null) {
      return _dAddress;
    } else {
      synchronized(this) {
        if(_dAddress == null) {
          _dAddress = new DAddress_Impl(this);
        }
        return _dAddress;
      }
    }
  }

  @Override
  public DMobileAddressInfo mobAddDao() {
    if (_dMobileAddressInfo != null) {
      return _dMobileAddressInfo;
    } else {
      synchronized(this) {
        if(_dMobileAddressInfo == null) {
          _dMobileAddressInfo = new DMobileAddressInfo_Impl(this);
        }
        return _dMobileAddressInfo;
      }
    }
  }

  @Override
  public DProduct prodctDao() {
    if (_dProduct != null) {
      return _dProduct;
    } else {
      synchronized(this) {
        if(_dProduct == null) {
          _dProduct = new DProduct_Impl(this);
        }
        return _dProduct;
      }
    }
  }

  @Override
  public DItemCart itemCartDao() {
    if (_dItemCart != null) {
      return _dItemCart;
    } else {
      synchronized(this) {
        if(_dItemCart == null) {
          _dItemCart = new DItemCart_Impl(this);
        }
        return _dItemCart;
      }
    }
  }

  @Override
  public DOrder ordersDao() {
    if (_dOrder != null) {
      return _dOrder;
    } else {
      synchronized(this) {
        if(_dOrder == null) {
          _dOrder = new DOrder_Impl(this);
        }
        return _dOrder;
      }
    }
  }

  @Override
  public DOrderDetail orderDetailDao() {
    if (_dOrderDetail != null) {
      return _dOrderDetail;
    } else {
      synchronized(this) {
        if(_dOrderDetail == null) {
          _dOrderDetail = new DOrderDetail_Impl(this);
        }
        return _dOrderDetail;
      }
    }
  }

  @Override
  public DSearchLog searchDao() {
    if (_dSearchLog != null) {
      return _dSearchLog;
    } else {
      synchronized(this) {
        if(_dSearchLog == null) {
          _dSearchLog = new DSearchLog_Impl(this);
        }
        return _dSearchLog;
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
}
