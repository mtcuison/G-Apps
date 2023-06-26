package org.rmj.g3appdriver.GCircle.room.DataAccessObject;

import androidx.room.RoomDatabase;
import java.lang.Class;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DNotificationUser_Impl implements DNotificationUser {
  private final RoomDatabase __db;

  public DNotificationUser_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
