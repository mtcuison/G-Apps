package org.rmj.g3appdriver.dev.Database.Entities;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DBranchInfo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DEmployeeInfo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DEvents;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DGCardTransactionLedger;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DGanadoOnline;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DItemCart;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMCSerialRegistration;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMcBrand;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMcCategory;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMcModel;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMcModelPrice;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DMobileAddressInfo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DNotifications;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderDetail;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DOrderMaster;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DPanalo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DPromo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRawDao;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRedeemablesInfo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRelation;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DSearchLog;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DServiceInfo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DUserInfo;

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
        ETokenInfo.class,
        EBarangayInfo.class,
        ETownInfo.class,
        EProvinceInfo.class,
        ECountryInfo.class,
        EMobileInfo.class,
        EAddressInfo.class,
        EProducts.class,
        EItemCart.class,
        EOrderDetail.class,
        EOrderMaster.class,
        ESearchLog.class,
        EEmailInfo.class,
        EPanaloReward.class,
        EGuanzonPanalo.class,
        ERelation.class,
        EGanadoOnline.class,
        EMCColor.class,
        EMcBrand.class,
        EMcModel.class,
        EMcModelPrice.class,
        EMCModelCashPrice.class,
        EMcCategory.class,
        EMcTermCategory.class}, version = 2, exportSchema = false)
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
    public abstract DAddress AddDao();
    public abstract DMobileAddressInfo mobAddDao();
    public abstract DProduct prodctDao();
    public abstract DItemCart itemCartDao();
    public abstract DOrderMaster orderMasterDao();
    public abstract DOrderDetail orderDetailDao();
    public abstract DSearchLog searchDao();
    public abstract DPanalo panaloDao();
    public abstract DGanadoOnline ganadoDao();
    public abstract DRelation relDao();
    public abstract DMcBrand McBrandDao();
    public abstract DMcModel McModelDao();
    public abstract DMcModelPrice McModelPriceDao();
    public abstract DMcCategory McCategoryDao();

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

    private static final Callback roomCallBack = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.e(TAG, "Local database has been created.");
        }
    };
}
