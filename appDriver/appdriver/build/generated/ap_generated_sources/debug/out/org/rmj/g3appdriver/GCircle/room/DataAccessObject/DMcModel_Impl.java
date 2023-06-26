package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
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
import org.rmj.g3appdriver.GCircle.room.Entities.EMCColor;
import org.rmj.g3appdriver.GCircle.room.Entities.EMcModel;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DMcModel_Impl implements DMcModel {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EMcModel> __insertionAdapterOfEMcModel;

  private final EntityInsertionAdapter<EMCColor> __insertionAdapterOfEMCColor;

  private final EntityInsertionAdapter<EMcModel> __insertionAdapterOfEMcModel_1;

  private final EntityDeletionOrUpdateAdapter<EMcModel> __updateAdapterOfEMcModel;

  private final EntityDeletionOrUpdateAdapter<EMCColor> __updateAdapterOfEMCColor;

  public DMcModel_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEMcModel = new EntityInsertionAdapter<EMcModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Mc_Model` (`sModelIDx`,`sModelCde`,`sModelNme`,`sBrandIDx`,`cMotorTyp`,`cRegisTyp`,`cEndOfLfe`,`cEngineTp`,`cHotItemx`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcModel value) {
        if (value.getModelIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getModelIDx());
        }
        if (value.getModelCde() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getModelCde());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModelNme());
        }
        if (value.getBrandIDx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBrandIDx());
        }
        if (value.getMotorTyp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMotorTyp());
        }
        if (value.getRegisTyp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRegisTyp());
        }
        if (value.getEndOfLfe() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEndOfLfe());
        }
        if (value.getEngineTp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEngineTp());
        }
        if (value.getHotItemx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getHotItemx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLstUpdte());
        }
      }
    };
    this.__insertionAdapterOfEMCColor = new EntityInsertionAdapter<EMCColor>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `MC_Model_Color` (`sModelIDx`,`sColorIDx`,`sColorNme`,`dTimeStmp`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMCColor value) {
        if (value.getModelIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getModelIDx());
        }
        if (value.getColorIDx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getColorIDx());
        }
        if (value.getColorNme() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getColorNme());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
      }
    };
    this.__insertionAdapterOfEMcModel_1 = new EntityInsertionAdapter<EMcModel>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `Mc_Model` (`sModelIDx`,`sModelCde`,`sModelNme`,`sBrandIDx`,`cMotorTyp`,`cRegisTyp`,`cEndOfLfe`,`cEngineTp`,`cHotItemx`,`cRecdStat`,`dTimeStmp`,`dLstUpdte`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcModel value) {
        if (value.getModelIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getModelIDx());
        }
        if (value.getModelCde() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getModelCde());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModelNme());
        }
        if (value.getBrandIDx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBrandIDx());
        }
        if (value.getMotorTyp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMotorTyp());
        }
        if (value.getRegisTyp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRegisTyp());
        }
        if (value.getEndOfLfe() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEndOfLfe());
        }
        if (value.getEngineTp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEngineTp());
        }
        if (value.getHotItemx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getHotItemx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLstUpdte());
        }
      }
    };
    this.__updateAdapterOfEMcModel = new EntityDeletionOrUpdateAdapter<EMcModel>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Mc_Model` SET `sModelIDx` = ?,`sModelCde` = ?,`sModelNme` = ?,`sBrandIDx` = ?,`cMotorTyp` = ?,`cRegisTyp` = ?,`cEndOfLfe` = ?,`cEngineTp` = ?,`cHotItemx` = ?,`cRecdStat` = ?,`dTimeStmp` = ?,`dLstUpdte` = ? WHERE `sModelIDx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMcModel value) {
        if (value.getModelIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getModelIDx());
        }
        if (value.getModelCde() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getModelCde());
        }
        if (value.getModelNme() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getModelNme());
        }
        if (value.getBrandIDx() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getBrandIDx());
        }
        if (value.getMotorTyp() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getMotorTyp());
        }
        if (value.getRegisTyp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getRegisTyp());
        }
        if (value.getEndOfLfe() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getEndOfLfe());
        }
        if (value.getEngineTp() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getEngineTp());
        }
        if (value.getHotItemx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getHotItemx());
        }
        if (value.getRecdStat() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getRecdStat());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTimeStmp());
        }
        if (value.getLstUpdte() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getLstUpdte());
        }
        if (value.getModelIDx() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getModelIDx());
        }
      }
    };
    this.__updateAdapterOfEMCColor = new EntityDeletionOrUpdateAdapter<EMCColor>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `MC_Model_Color` SET `sModelIDx` = ?,`sColorIDx` = ?,`sColorNme` = ?,`dTimeStmp` = ? WHERE `sModelIDx` = ? AND `sColorIDx` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EMCColor value) {
        if (value.getModelIDx() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getModelIDx());
        }
        if (value.getColorIDx() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getColorIDx());
        }
        if (value.getColorNme() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getColorNme());
        }
        if (value.getTimeStmp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTimeStmp());
        }
        if (value.getModelIDx() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModelIDx());
        }
        if (value.getColorIDx() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getColorIDx());
        }
      }
    };
  }

  @Override
  public void insert(final EMcModel mcModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMcModel.insert(mcModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final EMCColor mcColor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMCColor.insert(mcColor);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertBulkData(final List<EMcModel> models) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEMcModel_1.insert(models);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EMcModel mcModel) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEMcModel.handle(mcModel);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final EMCColor mcColor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfEMCColor.handle(mcColor);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public EMcModel GetMCModel(final String fsVal) {
    final String _sql = "SELECT * FROM MC_Model WHERE sModelIDx =?";
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
      final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
      final int _cursorIndexOfModelCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelCde");
      final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelNme");
      final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
      final int _cursorIndexOfMotorTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cMotorTyp");
      final int _cursorIndexOfRegisTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cRegisTyp");
      final int _cursorIndexOfEndOfLfe = CursorUtil.getColumnIndexOrThrow(_cursor, "cEndOfLfe");
      final int _cursorIndexOfEngineTp = CursorUtil.getColumnIndexOrThrow(_cursor, "cEngineTp");
      final int _cursorIndexOfHotItemx = CursorUtil.getColumnIndexOrThrow(_cursor, "cHotItemx");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EMcModel _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcModel();
        final String _tmpModelIDx;
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _tmpModelIDx = null;
        } else {
          _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        _result.setModelIDx(_tmpModelIDx);
        final String _tmpModelCde;
        if (_cursor.isNull(_cursorIndexOfModelCde)) {
          _tmpModelCde = null;
        } else {
          _tmpModelCde = _cursor.getString(_cursorIndexOfModelCde);
        }
        _result.setModelCde(_tmpModelCde);
        final String _tmpModelNme;
        if (_cursor.isNull(_cursorIndexOfModelNme)) {
          _tmpModelNme = null;
        } else {
          _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
        }
        _result.setModelNme(_tmpModelNme);
        final String _tmpBrandIDx;
        if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
          _tmpBrandIDx = null;
        } else {
          _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
        }
        _result.setBrandIDx(_tmpBrandIDx);
        final String _tmpMotorTyp;
        if (_cursor.isNull(_cursorIndexOfMotorTyp)) {
          _tmpMotorTyp = null;
        } else {
          _tmpMotorTyp = _cursor.getString(_cursorIndexOfMotorTyp);
        }
        _result.setMotorTyp(_tmpMotorTyp);
        final String _tmpRegisTyp;
        if (_cursor.isNull(_cursorIndexOfRegisTyp)) {
          _tmpRegisTyp = null;
        } else {
          _tmpRegisTyp = _cursor.getString(_cursorIndexOfRegisTyp);
        }
        _result.setRegisTyp(_tmpRegisTyp);
        final String _tmpEndOfLfe;
        if (_cursor.isNull(_cursorIndexOfEndOfLfe)) {
          _tmpEndOfLfe = null;
        } else {
          _tmpEndOfLfe = _cursor.getString(_cursorIndexOfEndOfLfe);
        }
        _result.setEndOfLfe(_tmpEndOfLfe);
        final String _tmpEngineTp;
        if (_cursor.isNull(_cursorIndexOfEngineTp)) {
          _tmpEngineTp = null;
        } else {
          _tmpEngineTp = _cursor.getString(_cursorIndexOfEngineTp);
        }
        _result.setEngineTp(_tmpEngineTp);
        final String _tmpHotItemx;
        if (_cursor.isNull(_cursorIndexOfHotItemx)) {
          _tmpHotItemx = null;
        } else {
          _tmpHotItemx = _cursor.getString(_cursorIndexOfHotItemx);
        }
        _result.setHotItemx(_tmpHotItemx);
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
        final String _tmpLstUpdte;
        if (_cursor.isNull(_cursorIndexOfLstUpdte)) {
          _tmpLstUpdte = null;
        } else {
          _tmpLstUpdte = _cursor.getString(_cursorIndexOfLstUpdte);
        }
        _result.setLstUpdte(_tmpLstUpdte);
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
  public EMcModel GetLatestMCModel() {
    final String _sql = "SELECT * FROM MC_Model ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
      final int _cursorIndexOfModelCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelCde");
      final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelNme");
      final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
      final int _cursorIndexOfMotorTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cMotorTyp");
      final int _cursorIndexOfRegisTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cRegisTyp");
      final int _cursorIndexOfEndOfLfe = CursorUtil.getColumnIndexOrThrow(_cursor, "cEndOfLfe");
      final int _cursorIndexOfEngineTp = CursorUtil.getColumnIndexOrThrow(_cursor, "cEngineTp");
      final int _cursorIndexOfHotItemx = CursorUtil.getColumnIndexOrThrow(_cursor, "cHotItemx");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EMcModel _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcModel();
        final String _tmpModelIDx;
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _tmpModelIDx = null;
        } else {
          _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        _result.setModelIDx(_tmpModelIDx);
        final String _tmpModelCde;
        if (_cursor.isNull(_cursorIndexOfModelCde)) {
          _tmpModelCde = null;
        } else {
          _tmpModelCde = _cursor.getString(_cursorIndexOfModelCde);
        }
        _result.setModelCde(_tmpModelCde);
        final String _tmpModelNme;
        if (_cursor.isNull(_cursorIndexOfModelNme)) {
          _tmpModelNme = null;
        } else {
          _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
        }
        _result.setModelNme(_tmpModelNme);
        final String _tmpBrandIDx;
        if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
          _tmpBrandIDx = null;
        } else {
          _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
        }
        _result.setBrandIDx(_tmpBrandIDx);
        final String _tmpMotorTyp;
        if (_cursor.isNull(_cursorIndexOfMotorTyp)) {
          _tmpMotorTyp = null;
        } else {
          _tmpMotorTyp = _cursor.getString(_cursorIndexOfMotorTyp);
        }
        _result.setMotorTyp(_tmpMotorTyp);
        final String _tmpRegisTyp;
        if (_cursor.isNull(_cursorIndexOfRegisTyp)) {
          _tmpRegisTyp = null;
        } else {
          _tmpRegisTyp = _cursor.getString(_cursorIndexOfRegisTyp);
        }
        _result.setRegisTyp(_tmpRegisTyp);
        final String _tmpEndOfLfe;
        if (_cursor.isNull(_cursorIndexOfEndOfLfe)) {
          _tmpEndOfLfe = null;
        } else {
          _tmpEndOfLfe = _cursor.getString(_cursorIndexOfEndOfLfe);
        }
        _result.setEndOfLfe(_tmpEndOfLfe);
        final String _tmpEngineTp;
        if (_cursor.isNull(_cursorIndexOfEngineTp)) {
          _tmpEngineTp = null;
        } else {
          _tmpEngineTp = _cursor.getString(_cursorIndexOfEngineTp);
        }
        _result.setEngineTp(_tmpEngineTp);
        final String _tmpHotItemx;
        if (_cursor.isNull(_cursorIndexOfHotItemx)) {
          _tmpHotItemx = null;
        } else {
          _tmpHotItemx = _cursor.getString(_cursorIndexOfHotItemx);
        }
        _result.setHotItemx(_tmpHotItemx);
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
        final String _tmpLstUpdte;
        if (_cursor.isNull(_cursorIndexOfLstUpdte)) {
          _tmpLstUpdte = null;
        } else {
          _tmpLstUpdte = _cursor.getString(_cursorIndexOfLstUpdte);
        }
        _result.setLstUpdte(_tmpLstUpdte);
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
  public EMCColor GetLatestMcColorTimeStamp() {
    final String _sql = "SELECT * FROM MC_Model_Color ORDER BY dTimeStmp DESC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
      final int _cursorIndexOfColorIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sColorIDx");
      final int _cursorIndexOfColorNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sColorNme");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EMCColor _result;
      if(_cursor.moveToFirst()) {
        _result = new EMCColor();
        final String _tmpModelIDx;
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _tmpModelIDx = null;
        } else {
          _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        _result.setModelIDx(_tmpModelIDx);
        final String _tmpColorIDx;
        if (_cursor.isNull(_cursorIndexOfColorIDx)) {
          _tmpColorIDx = null;
        } else {
          _tmpColorIDx = _cursor.getString(_cursorIndexOfColorIDx);
        }
        _result.setColorIDx(_tmpColorIDx);
        final String _tmpColorNme;
        if (_cursor.isNull(_cursorIndexOfColorNme)) {
          _tmpColorNme = null;
        } else {
          _tmpColorNme = _cursor.getString(_cursorIndexOfColorNme);
        }
        _result.setColorNme(_tmpColorNme);
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
  public EMCColor GetModelColor(final String ModelID, final String ColorID) {
    final String _sql = "SELECT * FROM MC_Model_Color WHERE sModelIDx =? AND sColorIDx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    _argIndex = 2;
    if (ColorID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ColorID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
      final int _cursorIndexOfColorIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sColorIDx");
      final int _cursorIndexOfColorNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sColorNme");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final EMCColor _result;
      if(_cursor.moveToFirst()) {
        _result = new EMCColor();
        final String _tmpModelIDx;
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _tmpModelIDx = null;
        } else {
          _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        _result.setModelIDx(_tmpModelIDx);
        final String _tmpColorIDx;
        if (_cursor.isNull(_cursorIndexOfColorIDx)) {
          _tmpColorIDx = null;
        } else {
          _tmpColorIDx = _cursor.getString(_cursorIndexOfColorIDx);
        }
        _result.setColorIDx(_tmpColorIDx);
        final String _tmpColorNme;
        if (_cursor.isNull(_cursorIndexOfColorNme)) {
          _tmpColorNme = null;
        } else {
          _tmpColorNme = _cursor.getString(_cursorIndexOfColorNme);
        }
        _result.setColorNme(_tmpColorNme);
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
  public LiveData<List<EMcModel>> getAllModeFromBrand(final String BrandID) {
    final String _sql = "SELECT * FROM Mc_Model WHERE sBrandIDx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BrandID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BrandID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mc_Model"}, false, new Callable<List<EMcModel>>() {
      @Override
      public List<EMcModel> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
          final int _cursorIndexOfModelCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelCde");
          final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelNme");
          final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
          final int _cursorIndexOfMotorTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cMotorTyp");
          final int _cursorIndexOfRegisTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cRegisTyp");
          final int _cursorIndexOfEndOfLfe = CursorUtil.getColumnIndexOrThrow(_cursor, "cEndOfLfe");
          final int _cursorIndexOfEngineTp = CursorUtil.getColumnIndexOrThrow(_cursor, "cEngineTp");
          final int _cursorIndexOfHotItemx = CursorUtil.getColumnIndexOrThrow(_cursor, "cHotItemx");
          final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
          final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
          final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
          final List<EMcModel> _result = new ArrayList<EMcModel>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EMcModel _item;
            _item = new EMcModel();
            final String _tmpModelIDx;
            if (_cursor.isNull(_cursorIndexOfModelIDx)) {
              _tmpModelIDx = null;
            } else {
              _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
            }
            _item.setModelIDx(_tmpModelIDx);
            final String _tmpModelCde;
            if (_cursor.isNull(_cursorIndexOfModelCde)) {
              _tmpModelCde = null;
            } else {
              _tmpModelCde = _cursor.getString(_cursorIndexOfModelCde);
            }
            _item.setModelCde(_tmpModelCde);
            final String _tmpModelNme;
            if (_cursor.isNull(_cursorIndexOfModelNme)) {
              _tmpModelNme = null;
            } else {
              _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
            }
            _item.setModelNme(_tmpModelNme);
            final String _tmpBrandIDx;
            if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
              _tmpBrandIDx = null;
            } else {
              _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
            }
            _item.setBrandIDx(_tmpBrandIDx);
            final String _tmpMotorTyp;
            if (_cursor.isNull(_cursorIndexOfMotorTyp)) {
              _tmpMotorTyp = null;
            } else {
              _tmpMotorTyp = _cursor.getString(_cursorIndexOfMotorTyp);
            }
            _item.setMotorTyp(_tmpMotorTyp);
            final String _tmpRegisTyp;
            if (_cursor.isNull(_cursorIndexOfRegisTyp)) {
              _tmpRegisTyp = null;
            } else {
              _tmpRegisTyp = _cursor.getString(_cursorIndexOfRegisTyp);
            }
            _item.setRegisTyp(_tmpRegisTyp);
            final String _tmpEndOfLfe;
            if (_cursor.isNull(_cursorIndexOfEndOfLfe)) {
              _tmpEndOfLfe = null;
            } else {
              _tmpEndOfLfe = _cursor.getString(_cursorIndexOfEndOfLfe);
            }
            _item.setEndOfLfe(_tmpEndOfLfe);
            final String _tmpEngineTp;
            if (_cursor.isNull(_cursorIndexOfEngineTp)) {
              _tmpEngineTp = null;
            } else {
              _tmpEngineTp = _cursor.getString(_cursorIndexOfEngineTp);
            }
            _item.setEngineTp(_tmpEngineTp);
            final String _tmpHotItemx;
            if (_cursor.isNull(_cursorIndexOfHotItemx)) {
              _tmpHotItemx = null;
            } else {
              _tmpHotItemx = _cursor.getString(_cursorIndexOfHotItemx);
            }
            _item.setHotItemx(_tmpHotItemx);
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
            final String _tmpLstUpdte;
            if (_cursor.isNull(_cursorIndexOfLstUpdte)) {
              _tmpLstUpdte = null;
            } else {
              _tmpLstUpdte = _cursor.getString(_cursorIndexOfLstUpdte);
            }
            _item.setLstUpdte(_tmpLstUpdte);
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
  public LiveData<String[]> getAllModelName(final String BrandID) {
    final String _sql = "SELECT (sModelNme || \" \" || sModelCde) AS ModelInfo FROM Mc_Model WHERE sBrandIDx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (BrandID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, BrandID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mc_Model"}, false, new Callable<String[]>() {
      @Override
      public String[] call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final String[] _result = new String[_cursor.getCount()];
          int _index = 0;
          while(_cursor.moveToNext()) {
            final String _item;
            final String _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getString(0);
            }
            _item = _tmp;
            _result[_index] = _item;
            _index ++;
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
  public String getModelName(final String ModelIDx) {
    final String _sql = "SELECT sModelNme FROM Mc_Model WHERE sModelIDx = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ModelIDx == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelIDx);
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
  public String getLatestDataTime() {
    final String _sql = "SELECT MAX(dTimeStmp) FROM Mc_Model";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
  public EMcModel getModelInfo(final String ModelID) {
    final String _sql = "SELECT * FROM Mc_Model WHERE sModelIDx =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfModelIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelIDx");
      final int _cursorIndexOfModelCde = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelCde");
      final int _cursorIndexOfModelNme = CursorUtil.getColumnIndexOrThrow(_cursor, "sModelNme");
      final int _cursorIndexOfBrandIDx = CursorUtil.getColumnIndexOrThrow(_cursor, "sBrandIDx");
      final int _cursorIndexOfMotorTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cMotorTyp");
      final int _cursorIndexOfRegisTyp = CursorUtil.getColumnIndexOrThrow(_cursor, "cRegisTyp");
      final int _cursorIndexOfEndOfLfe = CursorUtil.getColumnIndexOrThrow(_cursor, "cEndOfLfe");
      final int _cursorIndexOfEngineTp = CursorUtil.getColumnIndexOrThrow(_cursor, "cEngineTp");
      final int _cursorIndexOfHotItemx = CursorUtil.getColumnIndexOrThrow(_cursor, "cHotItemx");
      final int _cursorIndexOfRecdStat = CursorUtil.getColumnIndexOrThrow(_cursor, "cRecdStat");
      final int _cursorIndexOfTimeStmp = CursorUtil.getColumnIndexOrThrow(_cursor, "dTimeStmp");
      final int _cursorIndexOfLstUpdte = CursorUtil.getColumnIndexOrThrow(_cursor, "dLstUpdte");
      final EMcModel _result;
      if(_cursor.moveToFirst()) {
        _result = new EMcModel();
        final String _tmpModelIDx;
        if (_cursor.isNull(_cursorIndexOfModelIDx)) {
          _tmpModelIDx = null;
        } else {
          _tmpModelIDx = _cursor.getString(_cursorIndexOfModelIDx);
        }
        _result.setModelIDx(_tmpModelIDx);
        final String _tmpModelCde;
        if (_cursor.isNull(_cursorIndexOfModelCde)) {
          _tmpModelCde = null;
        } else {
          _tmpModelCde = _cursor.getString(_cursorIndexOfModelCde);
        }
        _result.setModelCde(_tmpModelCde);
        final String _tmpModelNme;
        if (_cursor.isNull(_cursorIndexOfModelNme)) {
          _tmpModelNme = null;
        } else {
          _tmpModelNme = _cursor.getString(_cursorIndexOfModelNme);
        }
        _result.setModelNme(_tmpModelNme);
        final String _tmpBrandIDx;
        if (_cursor.isNull(_cursorIndexOfBrandIDx)) {
          _tmpBrandIDx = null;
        } else {
          _tmpBrandIDx = _cursor.getString(_cursorIndexOfBrandIDx);
        }
        _result.setBrandIDx(_tmpBrandIDx);
        final String _tmpMotorTyp;
        if (_cursor.isNull(_cursorIndexOfMotorTyp)) {
          _tmpMotorTyp = null;
        } else {
          _tmpMotorTyp = _cursor.getString(_cursorIndexOfMotorTyp);
        }
        _result.setMotorTyp(_tmpMotorTyp);
        final String _tmpRegisTyp;
        if (_cursor.isNull(_cursorIndexOfRegisTyp)) {
          _tmpRegisTyp = null;
        } else {
          _tmpRegisTyp = _cursor.getString(_cursorIndexOfRegisTyp);
        }
        _result.setRegisTyp(_tmpRegisTyp);
        final String _tmpEndOfLfe;
        if (_cursor.isNull(_cursorIndexOfEndOfLfe)) {
          _tmpEndOfLfe = null;
        } else {
          _tmpEndOfLfe = _cursor.getString(_cursorIndexOfEndOfLfe);
        }
        _result.setEndOfLfe(_tmpEndOfLfe);
        final String _tmpEngineTp;
        if (_cursor.isNull(_cursorIndexOfEngineTp)) {
          _tmpEngineTp = null;
        } else {
          _tmpEngineTp = _cursor.getString(_cursorIndexOfEngineTp);
        }
        _result.setEngineTp(_tmpEngineTp);
        final String _tmpHotItemx;
        if (_cursor.isNull(_cursorIndexOfHotItemx)) {
          _tmpHotItemx = null;
        } else {
          _tmpHotItemx = _cursor.getString(_cursorIndexOfHotItemx);
        }
        _result.setHotItemx(_tmpHotItemx);
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
        final String _tmpLstUpdte;
        if (_cursor.isNull(_cursorIndexOfLstUpdte)) {
          _tmpLstUpdte = null;
        } else {
          _tmpLstUpdte = _cursor.getString(_cursorIndexOfLstUpdte);
        }
        _result.setLstUpdte(_tmpLstUpdte);
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
  public LiveData<DMcModel.McAmortInfo> GetMonthlyPayment(final String ModelID, final int Term) {
    final String _sql = "SELECT  a.sModelIDx, d.sModelNme, a.nSelPrice, a.nMinDownx, b.nMiscChrg, b.nRebatesx, b.nEndMrtgg, c.nAcctThru, c.nFactorRt FROM Mc_Model_Price a, MC_Category b, MC_Term_Category c, Mc_Model d WHERE a.sMCCatIDx = b.sMCCatIDx AND a.sMCCatIDx = c.sMCCatIDx AND a.sModelIDx = d.sModelIDx AND a.sModelIDx = ? AND c.nAcctThru = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, Term);
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mc_Model_Price","MC_Category","MC_Term_Category","Mc_Model"}, false, new Callable<DMcModel.McAmortInfo>() {
      @Override
      public DMcModel.McAmortInfo call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfSModelIDx = 0;
          final int _cursorIndexOfSModelNme = 1;
          final int _cursorIndexOfNSelPrice = 2;
          final int _cursorIndexOfNMinDownx = 3;
          final int _cursorIndexOfNMiscChrg = 4;
          final int _cursorIndexOfNRebatesx = 5;
          final int _cursorIndexOfNEndMrtgg = 6;
          final int _cursorIndexOfNAcctThru = 7;
          final int _cursorIndexOfNFactorRt = 8;
          final DMcModel.McAmortInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new DMcModel.McAmortInfo();
            if (_cursor.isNull(_cursorIndexOfSModelIDx)) {
              _result.sModelIDx = null;
            } else {
              _result.sModelIDx = _cursor.getString(_cursorIndexOfSModelIDx);
            }
            if (_cursor.isNull(_cursorIndexOfSModelNme)) {
              _result.sModelNme = null;
            } else {
              _result.sModelNme = _cursor.getString(_cursorIndexOfSModelNme);
            }
            if (_cursor.isNull(_cursorIndexOfNSelPrice)) {
              _result.nSelPrice = null;
            } else {
              _result.nSelPrice = _cursor.getString(_cursorIndexOfNSelPrice);
            }
            if (_cursor.isNull(_cursorIndexOfNMinDownx)) {
              _result.nMinDownx = null;
            } else {
              _result.nMinDownx = _cursor.getString(_cursorIndexOfNMinDownx);
            }
            if (_cursor.isNull(_cursorIndexOfNMiscChrg)) {
              _result.nMiscChrg = null;
            } else {
              _result.nMiscChrg = _cursor.getString(_cursorIndexOfNMiscChrg);
            }
            if (_cursor.isNull(_cursorIndexOfNRebatesx)) {
              _result.nRebatesx = null;
            } else {
              _result.nRebatesx = _cursor.getString(_cursorIndexOfNRebatesx);
            }
            if (_cursor.isNull(_cursorIndexOfNEndMrtgg)) {
              _result.nEndMrtgg = null;
            } else {
              _result.nEndMrtgg = _cursor.getString(_cursorIndexOfNEndMrtgg);
            }
            if (_cursor.isNull(_cursorIndexOfNAcctThru)) {
              _result.nAcctThru = null;
            } else {
              _result.nAcctThru = _cursor.getString(_cursorIndexOfNAcctThru);
            }
            if (_cursor.isNull(_cursorIndexOfNFactorRt)) {
              _result.nFactorRt = null;
            } else {
              _result.nFactorRt = _cursor.getString(_cursorIndexOfNFactorRt);
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
  public LiveData<DMcModel.McDPInfo> getDownpayment(final String ModelID) {
    final String _sql = "SELECT  a.sModelIDx AS ModelIDx, a.sModelNme AS ModelNme, b.nMinDownx AS MinDownx, c.nRebatesx AS Rebatesx, c.nMiscChrg AS MiscChrg, c.nEndMrtgg AS EndMrtgg, b.nSelPrice AS SelPrice, b.nLastPrce AS LastPrce FROM Mc_Model a, Mc_Model_Price b, MC_Category c WHERE a.sModelIDx = b.sModelIDx AND b.cRecdStat = '1' AND b.sMCCatIDx = c.sMCCatIDx AND (a.sModelIDx = ?)";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ModelID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ModelID);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"Mc_Model","Mc_Model_Price","MC_Category"}, false, new Callable<DMcModel.McDPInfo>() {
      @Override
      public DMcModel.McDPInfo call() throws Exception {
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
          final DMcModel.McDPInfo _result;
          if(_cursor.moveToFirst()) {
            _result = new DMcModel.McDPInfo();
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

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
