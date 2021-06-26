package org.rmj.g3appdriver.Database;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.rmj.g3appdriver.Database.DataAccessObject.DBranchInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DEmployeeInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DEvents;
import org.rmj.g3appdriver.Database.DataAccessObject.DGCardTransactionLedger;
import org.rmj.g3appdriver.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.Database.DataAccessObject.DMCSerialRegistration;
import org.rmj.g3appdriver.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.Database.DataAccessObject.DPromo;
import org.rmj.g3appdriver.Database.DataAccessObject.DRawDao;
import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemablesInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DServiceInfo;
import org.rmj.g3appdriver.Database.DataAccessObject.DUserInfo;
import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.Entities.EEmployeeInfo;
import org.rmj.g3appdriver.Database.Entities.EEvents;
import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.EMCSerialRegistration;
import org.rmj.g3appdriver.Database.Entities.ENotificationMaster;
import org.rmj.g3appdriver.Database.Entities.ENotificationRecipient;
import org.rmj.g3appdriver.Database.Entities.ENotificationUser;
import org.rmj.g3appdriver.Database.Entities.EPromo;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.Database.Entities.EServiceInfo;
import org.rmj.g3appdriver.Database.Entities.ETokenInfo;
import org.rmj.g3appdriver.Database.Entities.EUserInfo;

@Database(entities = {
        EEvents.class,
        EBranchInfo.class,
        EClientInfo.class,
        EGcardApp.class,
        EGCardTransactionLedger.class,
        EMCSerialRegistration.class,
        EPromo.class,
        ENotificationMaster.class,
        ENotificationRecipient.class,
        ENotificationUser.class,
        ERedeemablesInfo.class,
        ERedeemItemInfo.class,
        EServiceInfo.class,
        EEmployeeInfo.class,
        EUserInfo.class,
        ETokenInfo.class}, version = 1, exportSchema = false)
public abstract class GGC_GuanzonAppDB extends RoomDatabase {
    private static final String TAG = "GuanzonApp_DB_Manager";
    private static GGC_GuanzonAppDB instance;


//    public abstract DAppEventInfo EAppEventDao();
    public abstract DBranchInfo EBranchDao();
    public abstract DClientInfo EClientDao();
    public abstract DGcardApp EGcardAppDao();
    public abstract DGCardTransactionLedger EGCardTransactionLedgerDao();
    public abstract DMCSerialRegistration EMCSerialRegistrationDao();
    public abstract DPromo EPromoDao();
    public abstract DRedeemablesInfo ERedeemablesDao();
    public abstract DRedeemItemInfo ERedeemItemDao();
    public abstract DServiceInfo EServiceDao();
    public abstract DUserInfo EUserInfoDao();
    public abstract DRawDao RawDao();
    public abstract DEmployeeInfo EmployeeDao();
    public abstract DNotifications NotificationDao();
    public abstract DEvents EventDao();

    public static synchronized GGC_GuanzonAppDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    GGC_GuanzonAppDB.class, "GGC_ISysDBF.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.e(TAG, "Local database has been created.");
        }
    };

}
