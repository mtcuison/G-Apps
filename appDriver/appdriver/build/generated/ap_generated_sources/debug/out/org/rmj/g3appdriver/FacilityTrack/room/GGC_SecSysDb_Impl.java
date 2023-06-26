package org.rmj.g3appdriver.FacilityTrack.room;

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
import org.rmj.g3appdriver.FacilityTrack.room.DataAccessObject.DAccountInfo;
import org.rmj.g3appdriver.FacilityTrack.room.DataAccessObject.DAccountInfo_Impl;
import org.rmj.g3appdriver.FacilityTrack.room.DataAccessObject.DItinerary;
import org.rmj.g3appdriver.FacilityTrack.room.DataAccessObject.DItinerary_Impl;

@SuppressWarnings({"unchecked", "deprecation"})
public final class GGC_SecSysDb_Impl extends GGC_SecSysDb {
  private volatile DAccountInfo _dAccountInfo;

  private volatile DItinerary _dItinerary;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `User_Info_Master` (`sClientID` TEXT NOT NULL, `sBranchCD` TEXT, `sBranchNm` TEXT, `sLogNoxxx` TEXT, `sUserIDxx` TEXT, `sEmailAdd` TEXT, `sUserName` TEXT, `nUserLevl` TEXT, `sDeptIDxx` TEXT, `sPositnID` TEXT, `sEmpLevID` INTEGER, `cSlfieLog` TEXT, `cAllowUpd` TEXT, `dLoginxxx` TEXT, `sMobileNo` TEXT, `dSessionx` TEXT, `sEmployID` TEXT, `cPrivatex` TEXT, `sDeviceID` TEXT, `sModelIDx` TEXT, PRIMARY KEY(`sClientID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Facility_Personnel` (`sUserIDxx` TEXT NOT NULL, `sUserName` TEXT, PRIMARY KEY(`sUserIDxx`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Warehouse` (`sWHouseID` TEXT NOT NULL, `sWHouseNm` TEXT, `sBranchCd` TEXT, `dLastChck` TEXT, `cRecdStat` TEXT, `sModified` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sWHouseID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Building_Visit` (`sWHouseID` TEXT NOT NULL, `dTransact` TEXT NOT NULL, `sUserIDxx` TEXT, `sRemarksx` TEXT, `cSendStat` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sWHouseID`, `dTransact`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Building_Visit_Request` (`sNFCIDxxx` TEXT NOT NULL, `sUserIDxx` TEXT NOT NULL, `dSchedule` TEXT NOT NULL, `dVisitedx` TEXT, `cTranStat` TEXT, `sModified` TEXT, `dModified` TEXT, `dTimeStmp` TEXT, PRIMARY KEY(`sNFCIDxxx`, `sUserIDxx`, `dSchedule`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '58007a9fd66e824bde847a2d732e6552')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `User_Info_Master`");
        _db.execSQL("DROP TABLE IF EXISTS `Facility_Personnel`");
        _db.execSQL("DROP TABLE IF EXISTS `Warehouse`");
        _db.execSQL("DROP TABLE IF EXISTS `Building_Visit`");
        _db.execSQL("DROP TABLE IF EXISTS `Building_Visit_Request`");
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
          return new RoomOpenHelper.ValidationResult(false, "User_Info_Master(org.rmj.g3appdriver.FacilityTrack.room.Entities.EPersonnelInfo).\n"
                  + " Expected:\n" + _infoUserInfoMaster + "\n"
                  + " Found:\n" + _existingUserInfoMaster);
        }
        final HashMap<String, TableInfo.Column> _columnsFacilityPersonnel = new HashMap<String, TableInfo.Column>(2);
        _columnsFacilityPersonnel.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFacilityPersonnel.put("sUserName", new TableInfo.Column("sUserName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFacilityPersonnel = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFacilityPersonnel = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFacilityPersonnel = new TableInfo("Facility_Personnel", _columnsFacilityPersonnel, _foreignKeysFacilityPersonnel, _indicesFacilityPersonnel);
        final TableInfo _existingFacilityPersonnel = TableInfo.read(_db, "Facility_Personnel");
        if (! _infoFacilityPersonnel.equals(_existingFacilityPersonnel)) {
          return new RoomOpenHelper.ValidationResult(false, "Facility_Personnel(org.rmj.g3appdriver.FacilityTrack.room.Entities.EPersonnelInfo.EPersonnels).\n"
                  + " Expected:\n" + _infoFacilityPersonnel + "\n"
                  + " Found:\n" + _existingFacilityPersonnel);
        }
        final HashMap<String, TableInfo.Column> _columnsWarehouse = new HashMap<String, TableInfo.Column>(8);
        _columnsWarehouse.put("sWHouseID", new TableInfo.Column("sWHouseID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWarehouse.put("sWHouseNm", new TableInfo.Column("sWHouseNm", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWarehouse.put("sBranchCd", new TableInfo.Column("sBranchCd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWarehouse.put("dLastChck", new TableInfo.Column("dLastChck", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWarehouse.put("cRecdStat", new TableInfo.Column("cRecdStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWarehouse.put("sModified", new TableInfo.Column("sModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWarehouse.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWarehouse.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWarehouse = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWarehouse = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWarehouse = new TableInfo("Warehouse", _columnsWarehouse, _foreignKeysWarehouse, _indicesWarehouse);
        final TableInfo _existingWarehouse = TableInfo.read(_db, "Warehouse");
        if (! _infoWarehouse.equals(_existingWarehouse)) {
          return new RoomOpenHelper.ValidationResult(false, "Warehouse(org.rmj.g3appdriver.FacilityTrack.room.Entities.EWarehouse).\n"
                  + " Expected:\n" + _infoWarehouse + "\n"
                  + " Found:\n" + _existingWarehouse);
        }
        final HashMap<String, TableInfo.Column> _columnsBuildingVisit = new HashMap<String, TableInfo.Column>(7);
        _columnsBuildingVisit.put("sWHouseID", new TableInfo.Column("sWHouseID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisit.put("dTransact", new TableInfo.Column("dTransact", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisit.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisit.put("sRemarksx", new TableInfo.Column("sRemarksx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisit.put("cSendStat", new TableInfo.Column("cSendStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisit.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisit.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBuildingVisit = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBuildingVisit = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBuildingVisit = new TableInfo("Building_Visit", _columnsBuildingVisit, _foreignKeysBuildingVisit, _indicesBuildingVisit);
        final TableInfo _existingBuildingVisit = TableInfo.read(_db, "Building_Visit");
        if (! _infoBuildingVisit.equals(_existingBuildingVisit)) {
          return new RoomOpenHelper.ValidationResult(false, "Building_Visit(org.rmj.g3appdriver.FacilityTrack.room.Entities.EBuildingVisit).\n"
                  + " Expected:\n" + _infoBuildingVisit + "\n"
                  + " Found:\n" + _existingBuildingVisit);
        }
        final HashMap<String, TableInfo.Column> _columnsBuildingVisitRequest = new HashMap<String, TableInfo.Column>(8);
        _columnsBuildingVisitRequest.put("sNFCIDxxx", new TableInfo.Column("sNFCIDxxx", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisitRequest.put("sUserIDxx", new TableInfo.Column("sUserIDxx", "TEXT", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisitRequest.put("dSchedule", new TableInfo.Column("dSchedule", "TEXT", true, 3, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisitRequest.put("dVisitedx", new TableInfo.Column("dVisitedx", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisitRequest.put("cTranStat", new TableInfo.Column("cTranStat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisitRequest.put("sModified", new TableInfo.Column("sModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisitRequest.put("dModified", new TableInfo.Column("dModified", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBuildingVisitRequest.put("dTimeStmp", new TableInfo.Column("dTimeStmp", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBuildingVisitRequest = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBuildingVisitRequest = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBuildingVisitRequest = new TableInfo("Building_Visit_Request", _columnsBuildingVisitRequest, _foreignKeysBuildingVisitRequest, _indicesBuildingVisitRequest);
        final TableInfo _existingBuildingVisitRequest = TableInfo.read(_db, "Building_Visit_Request");
        if (! _infoBuildingVisitRequest.equals(_existingBuildingVisitRequest)) {
          return new RoomOpenHelper.ValidationResult(false, "Building_Visit_Request(org.rmj.g3appdriver.FacilityTrack.room.Entities.EBuildingVisitRequest).\n"
                  + " Expected:\n" + _infoBuildingVisitRequest + "\n"
                  + " Found:\n" + _existingBuildingVisitRequest);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "58007a9fd66e824bde847a2d732e6552", "6aa86d6a9e1d68dc3c897d478d1d93d6");
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
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "User_Info_Master","Facility_Personnel","Warehouse","Building_Visit","Building_Visit_Request");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `User_Info_Master`");
      _db.execSQL("DELETE FROM `Facility_Personnel`");
      _db.execSQL("DELETE FROM `Warehouse`");
      _db.execSQL("DELETE FROM `Building_Visit`");
      _db.execSQL("DELETE FROM `Building_Visit_Request`");
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
    _typeConvertersMap.put(DAccountInfo.class, DAccountInfo_Impl.getRequiredConverters());
    _typeConvertersMap.put(DItinerary.class, DItinerary_Impl.getRequiredConverters());
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
  public DAccountInfo accountDao() {
    if (_dAccountInfo != null) {
      return _dAccountInfo;
    } else {
      synchronized(this) {
        if(_dAccountInfo == null) {
          _dAccountInfo = new DAccountInfo_Impl(this);
        }
        return _dAccountInfo;
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
}
