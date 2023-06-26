package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import org.rmj.g3appdriver.GCircle.room.Entities.ENNDMRequest;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DNNDMRequest_Impl implements DNNDMRequest {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ENNDMRequest> __insertionAdapterOfENNDMRequest;

  public DNNDMRequest_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfENNDMRequest = new EntityInsertionAdapter<ENNDMRequest>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `NNDM_Event_Request` (`sTransNox`,`sSourceNo`,`sSourceCD`,`sReqstTyp`,`sJsonData`,`cTranStat`,`dCreatedx`,`dReceived`,`dPostedxx`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ENNDMRequest value) {
        if (value.getTransNox() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTransNox());
        }
        if (value.getSourceNo() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getSourceNo());
        }
        if (value.getSourceCD() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSourceCD());
        }
        if (value.getReqstTyp() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getReqstTyp());
        }
        if (value.getJsonData() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getJsonData());
        }
        if (value.getTranStat() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getTranStat());
        }
        if (value.getCreatedx() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getCreatedx());
        }
        if (value.getReceived() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getReceived());
        }
        if (value.getPostedxx() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getPostedxx());
        }
      }
    };
  }

  @Override
  public void insert(final ENNDMRequest enndmRequest) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfENNDMRequest.insert(enndmRequest);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
