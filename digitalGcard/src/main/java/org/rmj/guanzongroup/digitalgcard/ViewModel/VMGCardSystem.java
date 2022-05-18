package org.rmj.guanzongroup.digitalgcard.ViewModel;

import static org.rmj.g3appdriver.utils.CallbackJson.CallbackStatus.FAILED;
import static org.rmj.g3appdriver.utils.CallbackJson.CallbackStatus.SUCCESS;
import static org.rmj.g3appdriver.utils.CallbackJson.parse;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.dev.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.dev.Repositories.RGcardApp;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.CartItem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.GcardCartItems;
import org.rmj.g3appdriver.lib.GCardCore.Obj.GcardCredentials;
import org.rmj.g3appdriver.lib.GCardCore.RedemptionManager;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

public class VMGCardSystem extends AndroidViewModel {

    private static final String TAG = VMGCardSystem.class.getSimpleName();
    private final Application instance;
    private final GCardSystem poGcrdSys;
    private final RGcardApp poGcardxx;
    private final ConnectionUtil poConnect;
    private iGCardSystem mGcardSys;

    public VMGCardSystem(@NonNull Application application) {
        super(application);
        Log.e(TAG, "Initialized.");
        this.instance = application;
        this.poGcrdSys = new GCardSystem(application);
        this.poGcardxx = new RGcardApp(application);
        this.poConnect = new ConnectionUtil(application);
    }

    /** Initialize this method whenever it is used to return a GCard function instance to be used. */
    public void setInstance(GCardSystem.CoreFunctions foCore) {
        mGcardSys = poGcrdSys.getInstance(foCore);
    }

    // ------- METHODS ------- //

    public LiveData<EGcardApp> getActiveGcard() {
        return poGcardxx.hasNoGcard();
    }

    public LiveData<List<EGcardApp>> getInactiveGCard() {
        return poGcardxx.hasUnCheckGCard();
    }

    public LiveData<List<EGcardApp>> GetGCardList() {
        return mGcardSys.GetGCardList();
    }

    public LiveData<List<ERedeemablesInfo>> GetRedeemablesList() {
        return mGcardSys.GetRedeemablesList();
    }

    public LiveData<List<EGCardTransactionLedger>> GetGcardTransactions() {
        return mGcardSys.GetGcardTransactions();
    }

    public LiveData<List<EGCardTransactionLedger>> GetPointsEntryTransactions() {
        return mGcardSys.GetPointsEntryTransactions();
    }

    public LiveData<List<EGCardTransactionLedger>> GetRedemptionTransactions() {
        return  mGcardSys.GetRedemptionTransactions();
    }

    public void setActiveGcard(String fsCardNox, GcardTransactionCallback foCallBck) {
        new SetActiveGcardTask(poGcardxx, foCallBck).execute(fsCardNox);
    }

    public void addGcard(GcardCredentials foCardDta, GcardTransactionCallback foCallBck) {
        new AddGcardTask(mGcardSys, poConnect, foCallBck).execute(foCardDta);
    }

    public void addGCardQrCode(String foGcardQr, GcardTransactionCallback callback) {
        new AddGCardQrCodeTask(mGcardSys, poConnect,callback).execute();
    }

    public void confirmAddGCard(GcardCredentials foCardDta, GcardTransactionCallback foCallBck) {
        new ConfirmAddGCardTask(mGcardSys, poConnect, foCallBck).execute(foCardDta);
    }

    public void downloadGcardNumbers(GcardTransactionCallback callback) {
        new DownloadGcardNumbersTask(mGcardSys, poConnect, callback).execute();
    }

    public void activateGcard(String foGcardNo,GcardTransactionCallback callBack) {
        new ActivateGcardTask(mGcardSys, poConnect, callBack).execute(foGcardNo);
    }

    public void generateGCardQrCode(GcardTransactionCallback callBack) {
        new GenerateGCardQrCodeTask(mGcardSys, poConnect, callBack).execute();
    }

    public void downloadRedeemables(GcardTransactionCallback callback) {
        new DownloadRedeemablesTask(mGcardSys, poConnect, callback).execute();
    }

    public void addToCart(CartItem item, GcardTransactionCallback callback) {
        new AddToCartTask(mGcardSys, poConnect, callback).execute(item);
    }

    public void UpdateCartItem(CartItem item, GcardTransactionCallback callback) {
        new UpdateCartItemTask(mGcardSys, poConnect, callback).execute(item);
    }

    public LiveData<List<DRedeemItemInfo.GCardCartItem>> GetCartItems(){
        mGcardSys = new GCardSystem(instance).getInstance(GCardSystem.CoreFunctions.REDEMPTION);
        return mGcardSys.GetCartItems();
    }
    public void GetMCBranchesForRedemption(GetBranchCallback callback){
        new GetMCBranchesForRedemptionTask(instance, callback).execute();
    }
    public void PlaceOrder(List<DRedeemItemInfo.GCardCartItem> redeemables, String BranchCD, GcardTransactionCallback callback) {
        new PlaceOrderTask(mGcardSys, redeemables, BranchCD, poConnect, callback).execute();
    }


    public void generateGCardOrderQrCode(GcardTransactionCallback callBack) {
        new GenerateGCardOrderQrCode(mGcardSys, poConnect, callBack).execute();
    }

    public void downloadTransactions(GcardTransactionCallback callback) {
        new DownloadTransactionsTask(mGcardSys, poConnect, callback);
    }

    public void saveTransactions(JSONObject detail, GcardTransactionCallback callBack) {
        new SaveTransactions(mGcardSys, poConnect, callBack).execute(detail);
    }

    public void downloadMCServiceInfo(GcardTransactionCallback callBack) {
        new DownloadMCServiceInfoTask(mGcardSys, poConnect, callBack).execute();
    }

    public void downloadRegistrationInfo(GcardTransactionCallback callback) {
        new DownloadRegistrationInfoTask(mGcardSys, poConnect, callback).execute();
    }

    public void scheduleNextServiceDate(String date, GcardTransactionCallback callback) {
        new ScheduleNextServiceDateTask(mGcardSys, poConnect, callback).execute(date);
    }

    private static void setCallBack(String fsResultx, GcardTransactionCallback foCallBck) {
        try {
            JSONObject loJson = new JSONObject(fsResultx);
            String lsStatus =String.valueOf(loJson.get("status"));
            String lsMessage = loJson.getString("message");
            if(lsStatus.equals(SUCCESS.toString())) {
                foCallBck.onSuccess(lsMessage);
            } else if(lsStatus.equals(FAILED.toString())) {
                foCallBck.onFailed(lsMessage);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // ------- ASYNCTASKS -------- //
    private static class AddGcardTask extends AsyncTask<GcardCredentials, Void, String> {
        private static final String ADD_GCARD_TAG = AddGcardTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private AddGcardTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected String doInBackground(GcardCredentials... foGcardxx) {
            GcardCredentials loGcardxx = foGcardxx[0];
            final String[] lsResult = {""};
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.AddGCard(loGcardxx, new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            try {
                                JSONObject loDetail = new JSONObject(args);
                                mGcardSys.SaveGCardInfo(loDetail);
                                mGcardSys.DownloadMCServiceInfo(new GCardSystem.GCardSystemCallback() {
                                    @Override
                                    public void OnSuccess(String args) {
                                        try {
                                            JSONObject loDetail = new JSONObject(args);
                                            mGcardSys.SaveMcServiceInfo(loDetail);
                                            lsResult[0] = parse(SUCCESS, "GCard Added Successfully.");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
                                        }
                                    }

                                    @Override
                                    public void OnFailed(String message) {
                                        lsResult[0] = parse(FAILED, message);
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e(ADD_GCARD_TAG, e.getMessage());
                                lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(ADD_GCARD_TAG, e.getMessage());
                                lsResult[0] = parse(FAILED,ADD_GCARD_TAG + e.getMessage());
                            }
                        }

                        @Override
                        public void OnFailed(String message) {
                            lsResult[0] = parse(FAILED, message);
                        }

                    });
                } else {
                    lsResult[0] = parse(FAILED, AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(ADD_GCARD_TAG, e.getMessage());
                lsResult[0] = parse(FAILED, ADD_GCARD_TAG + e.getMessage());
            }
            return lsResult[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setCallBack(s, loCallbck);
        }

    }

    private static class ConfirmAddGCardTask extends AsyncTask<GcardCredentials, Void, String> {
        private static final String CONFIRM_ADD_TAG = ConfirmAddGCardTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private ConfirmAddGCardTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected String doInBackground(GcardCredentials... foGcardxx) {
            GcardCredentials loGcardxx = foGcardxx[0];
            final String[] lsResult = {""};
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.ConfirmAddGCard(loGcardxx, new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            try {
                                JSONObject loDetail = new JSONObject(args);
                                mGcardSys.SaveGCardInfo(loDetail);
                                mGcardSys.DownloadMCServiceInfo(new GCardSystem.GCardSystemCallback() {
                                    @Override
                                    public void OnSuccess(String args) {
                                        try {
                                            JSONObject loDetail = new JSONObject(args);
                                            mGcardSys.SaveMcServiceInfo(loDetail);
                                            lsResult[0] = parse(SUCCESS, "GCard Added Successfully.");
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                            lsResult[0] = parse(FAILED, CONFIRM_ADD_TAG + e.getMessage());
                                        }
                                    }

                                    @Override
                                    public void OnFailed(String message) {
                                        lsResult[0] = parse(FAILED, message);
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e(CONFIRM_ADD_TAG, e.getMessage());
                                lsResult[0] = parse(FAILED, CONFIRM_ADD_TAG + e.getMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(CONFIRM_ADD_TAG, e.getMessage());
                                lsResult[0] = parse(FAILED,CONFIRM_ADD_TAG + e.getMessage());
                            }
                        }

                        @Override
                        public void OnFailed(String message) {
                            lsResult[0] = parse(FAILED, message);
                        }

                    });
                } else {
                    lsResult[0] = parse(FAILED, AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(CONFIRM_ADD_TAG, e.getMessage());
                lsResult[0] = parse(FAILED, CONFIRM_ADD_TAG + e.getMessage());
            }
            return lsResult[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setCallBack(s, loCallbck);
        }

    }

    private static class AddGCardQrCodeTask extends AsyncTask<Void, Void, Void> {
        private static final String ADD_GCARD_QR_TAG = AddGCardQrCodeTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private AddGCardQrCodeTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                if(loConnect.isDeviceConnected()) {
                    //TODO: Add QR Scanner Method here to provide
                    mGcardSys.AddGCardQrCode("", new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            try {
                                JSONObject loDetail = new JSONObject(args);
                                mGcardSys.SaveGCardInfo(loDetail);
                                loCallbck.onSuccess(args);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e(ADD_GCARD_QR_TAG, e.getMessage());
                                loCallbck.onFailed(ADD_GCARD_QR_TAG + e.getMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(ADD_GCARD_QR_TAG, e.getMessage());
                                loCallbck.onFailed(ADD_GCARD_QR_TAG + e.getMessage());
                            }
                        }

                        @Override
                        public void OnFailed(String message) {
                            loCallbck.onFailed(message);
                        }

                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(ADD_GCARD_QR_TAG, e.getMessage());
                loCallbck.onFailed(ADD_GCARD_QR_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class DownloadGcardNumbersTask extends AsyncTask<Void, Void, Void> {
        private static final String DOWNLOAD_GCARD_TAG = DownloadGcardNumbersTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private DownloadGcardNumbersTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                if(loConnect.isDeviceConnected()) {
                    //TODO: Add QR Scanner Method here to provide
                    mGcardSys.DownloadGcardNumbers(new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            try {
                                JSONObject loDetail = new JSONObject(args);
                                loCallbck.onSuccess(args);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Log.e(DOWNLOAD_GCARD_TAG, e.getMessage());
                                loCallbck.onFailed(DOWNLOAD_GCARD_TAG + e.getMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e(DOWNLOAD_GCARD_TAG, e.getMessage());
                                loCallbck.onFailed(DOWNLOAD_GCARD_TAG + e.getMessage());
                            }
                        }

                        @Override
                        public void OnFailed(String message) {
                            loCallbck.onFailed(message);
                        }

                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(DOWNLOAD_GCARD_TAG, e.getMessage());
                loCallbck.onFailed(DOWNLOAD_GCARD_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class ActivateGcardTask extends AsyncTask<String, Void, Void> {
        private static final String ACTIVATE_GCARD_TAG = ActivateGcardTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private ActivateGcardTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(String... strings) {
            String lsGcardNo = "";
            lsGcardNo = strings[0];
            try {
                if(loConnect.isDeviceConnected()) {
                    //TODO: Add QR Scanner Method here to provide
                    mGcardSys.ActivateGcard(lsGcardNo);
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(ACTIVATE_GCARD_TAG, e.getMessage());
                loCallbck.onFailed(ACTIVATE_GCARD_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class GenerateGCardQrCodeTask extends AsyncTask<String, Void, Bitmap> {
        private static final String GENERATE_QR_TAG = GenerateGCardQrCodeTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private GenerateGCardQrCodeTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                if(loConnect.isDeviceConnected()) {
                    //TODO: Add QR Scanner Method here to provide
                    return mGcardSys.GenerateGCardQrCode();
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(GENERATE_QR_TAG, e.getMessage());
                loCallbck.onFailed(GENERATE_QR_TAG + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            loCallbck.onQrGenerate(bitmap);
        }
    }

    private static class DownloadRedeemablesTask extends AsyncTask<String, Void, Void> {
        private static final String DL_REDEEMABLES_TAG = DownloadRedeemablesTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private DownloadRedeemablesTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(String... strings) {
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.DownloadRedeemables(new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            // TODO: Call the saving of redeemables to local database
                            loCallbck.onSuccess(args);
                        }

                        @Override
                        public void OnFailed(String message) {
                            loCallbck.onFailed(message);
                        }
                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(DL_REDEEMABLES_TAG, e.getMessage());
                loCallbck.onFailed(DL_REDEEMABLES_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class AddToCartTask extends AsyncTask<CartItem, Void, Void> {
        private static final String ADD_TO_CART_TAG = AddToCartTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;
        private String messages = "";
        private boolean isSuccess = false;

        private AddToCartTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(CartItem... foCartItm) {
            CartItem loCartItm = foCartItm[0];
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.AddToCart(loCartItm, new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            // TODO: Call the saving of add to cart item to local database
                            messages = args;
                            isSuccess = true;
//                            loCallbck.onSuccess(args);
                        }

                        @Override
                        public void OnFailed(String message) {
                            messages = message;
                            isSuccess = false;
//                            loCallbck.onFailed(message);
                        }
                    });
                } else {
                    messages = AppConstants.NO_INTERNET();
                    isSuccess = false;
//                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(ADD_TO_CART_TAG, e.getMessage());
                messages = ADD_TO_CART_TAG + " " + e.getMessage();
                isSuccess = false;
//                loCallbck.onFailed(ADD_TO_CART_TAG + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            if (isSuccess){
                loCallbck.onSuccess(messages);
            }else {
                loCallbck.onFailed(messages);
            }

        }
    }

    private static class UpdateCartItemTask extends AsyncTask<CartItem, Void, Void> {
        private static final String UPDATE_CART_TAG = UpdateCartItemTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private UpdateCartItemTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(CartItem... foCartItm) {
            CartItem loCartItm = foCartItm[0];
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.UpdateCartItem(loCartItm, new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            // TODO: Call the update of cart to local database
                            loCallbck.onSuccess(args);
                        }

                        @Override
                        public void OnFailed(String message) {
                            loCallbck.onFailed(message);
                        }
                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(UPDATE_CART_TAG, e.getMessage());
                loCallbck.onFailed(UPDATE_CART_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class PlaceOrderTask extends AsyncTask<GcardCartItems, Void, Void> {
        private static final String PLACE_ORDER_TAG = PlaceOrderTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;
        private final List<DRedeemItemInfo.GCardCartItem> poRedeem;
        private final String sBranchCD;
        private boolean isSuccess = false;
        private String messages = "";

        private PlaceOrderTask(iGCardSystem gcardSys,List<DRedeemItemInfo.GCardCartItem> redeemables, String BranchCD,ConnectionUtil foConnect, GcardTransactionCallback callback) {
            this.mGcardSys = gcardSys;
            this.loConnect = foConnect;
            this.loCallbck = callback;
            this.poRedeem = redeemables;
            this.sBranchCD = BranchCD;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(GcardCartItems... foCartItm) {
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.PlaceOrder(poRedeem, sBranchCD, new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            // TODO: Call the update of cart to local database

                            isSuccess = true;
                            messages = args;
                        }

                        @Override
                        public void OnFailed(String message) {

                            isSuccess = false;
                            messages = message;
                        }
                    });
                } else {
                    isSuccess = false;
                    messages = AppConstants.NO_INTERNET();
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(PLACE_ORDER_TAG, e.getMessage());
                isSuccess = false;
                messages = e.getMessage();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            if (isSuccess){
                loCallbck.onSuccess(messages);
            }else {
                loCallbck.onFailed(messages);
            }
        }
    }

    private static class GenerateGCardOrderQrCode extends AsyncTask<String, Void, Bitmap> {
        private static final String GENERATE_ORDER_QR_TAG = GenerateGCardOrderQrCode.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private GenerateGCardOrderQrCode(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                if(loConnect.isDeviceConnected()) {
                    //TODO: Add QR Scanner Method here to provide
                    return mGcardSys.GenerateGCardOrderQrCode("");
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(GENERATE_ORDER_QR_TAG, e.getMessage());
                loCallbck.onFailed(GENERATE_ORDER_QR_TAG + e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            loCallbck.onQrGenerate(bitmap);
        }
    }

    private static class DownloadTransactionsTask extends AsyncTask<String, Void, Void> {
        private static final String DL_TRANS_TAG = DownloadTransactionsTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private DownloadTransactionsTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(String... strings) {
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.DownloadTransactions(new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            // TODO: Save downloaded transactions to local database.
                            loCallbck.onSuccess(args);
                        }

                        @Override
                        public void OnFailed(String message) {
                            loCallbck.onFailed(message);
                        }
                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(DL_TRANS_TAG, e.getMessage());
                loCallbck.onFailed(DL_TRANS_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class SaveTransactions extends AsyncTask<JSONObject, Void, Void> {
        private static final String SAVE_TRANS_TAG = SaveTransactions.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private SaveTransactions(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(JSONObject... jsonObjects) {
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.SaveTransactions(jsonObjects[0]);
                    loCallbck.onSuccess("Success");
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(SAVE_TRANS_TAG, e.getMessage());
                loCallbck.onFailed(SAVE_TRANS_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class DownloadMCServiceInfoTask extends AsyncTask<Void, Void, Void> {
        private static final String DL_SERVICES_TAG = DownloadMCServiceInfoTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private DownloadMCServiceInfoTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.DownloadMCServiceInfo(new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            try {
                                JSONObject loJson = new JSONObject(args);
                                mGcardSys.SaveMcServiceInfo(loJson);
                                loCallbck.onSuccess("args");
                            } catch (JSONException e) {
                                e.printStackTrace();
                                loCallbck.onFailed(DL_SERVICES_TAG + e.getMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                                loCallbck.onFailed(DL_SERVICES_TAG + e.getMessage());
                            }
                        }

                        @Override
                        public void OnFailed(String message) {
                            loCallbck.onFailed(DL_SERVICES_TAG + message);
                        }
                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(DL_SERVICES_TAG, e.getMessage());
                loCallbck.onFailed(DL_SERVICES_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class DownloadRegistrationInfoTask extends AsyncTask<Void, Void, Void> {
        private static final String DL_REG_TAG = DownloadRegistrationInfoTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private DownloadRegistrationInfoTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.DownloadRegistrationInfo(new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            // TODO: Save registration info to local
                            try {
                                JSONObject loJson = new JSONObject(args);
                                mGcardSys.SaveRegistrationInfo(loJson);
                                loCallbck.onSuccess("args");
                            } catch (JSONException e) {
                                e.printStackTrace();
                                loCallbck.onFailed(DL_REG_TAG + e.getMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                                loCallbck.onFailed(DL_REG_TAG + e.getMessage());
                            }
                        }

                        @Override
                        public void OnFailed(String message) {
                            loCallbck.onFailed(DL_REG_TAG + message);
                        }
                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(DL_REG_TAG, e.getMessage());
                loCallbck.onFailed(DL_REG_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class ScheduleNextServiceDateTask extends AsyncTask<String, Void, Void> {
        private static final String SCHED_SERVICE_TAG = ScheduleNextServiceDateTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private ScheduleNextServiceDateTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected Void doInBackground(String... strings) {
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.ScheduleNextServiceDate(strings[0], new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            // TODO: Save service scched to local
                            loCallbck.onSuccess(args);
                        }

                        @Override
                        public void OnFailed(String message) {
                            loCallbck.onFailed(message);
                        }
                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(SCHED_SERVICE_TAG, e.getMessage());
                loCallbck.onFailed(SCHED_SERVICE_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class SetActiveGcardTask extends AsyncTask<String, Void, String> {

        private final RGcardApp loGcardxx;
        private final GcardTransactionCallback loCallBck;

        private SetActiveGcardTask(RGcardApp foGcardxx, GcardTransactionCallback foCallbck) {
            this.loGcardxx = foGcardxx;
            this.loCallBck = foCallbck;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallBck.onLoad();
        }

        @Override
        protected String doInBackground(String... strings) {
            String lsCardNox = strings[0];
            String lsResultx = "";

            try {
                loGcardxx.updateGCardDeactiveStatus();
                loGcardxx.updateGCardActiveStatus(lsCardNox);
                lsResultx = parse(SUCCESS, "Selected GCard has been activated.");
            } catch (Exception e) {
                e.printStackTrace();
                lsResultx = parse(FAILED, e.getMessage());
            }

            return lsResultx;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            setCallBack(s, loCallBck);
        }
    }


    private static class GetMCBranchesForRedemptionTask  extends AsyncTask<String, Void, Void> {

        private final RedemptionManager loredemp;
        private final GetBranchCallback loCallBck;
        private List<EBranchInfo> branchInfos;
        private GetMCBranchesForRedemptionTask (Application app, GetBranchCallback foCallbck) {
            this.loredemp = new RedemptionManager(app);
            this.loCallBck = foCallbck;
        }

        @Override
        protected Void doInBackground(String... strings) {
            branchInfos = loredemp.GetMCBranchesForRedemption();
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            loCallBck.onSuccess(branchInfos);
        }
    }

    public interface GetBranchCallback {
        void onSuccess(List<EBranchInfo> branchInfos);
    }
    public interface GcardTransactionCallback {
        void onLoad();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
        void onQrGenerate(Bitmap foBitmap);
    }
}
