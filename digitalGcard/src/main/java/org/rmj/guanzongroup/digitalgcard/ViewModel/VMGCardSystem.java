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
import org.rmj.g3appdriver.dev.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.dev.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.CartItem;
import org.rmj.g3appdriver.lib.GCardCore.Obj.GcardCartItems;
import org.rmj.g3appdriver.lib.GCardCore.Obj.GcardCredentials;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

public class VMGCardSystem extends AndroidViewModel {

    private static final String TAG = VMGCardSystem.class.getSimpleName();
    private final GCardSystem poGcrdSys;
    private final ConnectionUtil poConnect;
    private iGCardSystem mGcardSys;

    public VMGCardSystem(@NonNull Application application) {
        super(application);
        Log.e(TAG, "Initialized.");
        this.poGcrdSys = new GCardSystem(application);
        this.poConnect = new ConnectionUtil(application);
    }

    // TODO: Initialize this method whenever it is used to return a fragment instance.
    public void setInstance(GCardSystem.CoreFunctions foCore) {
        mGcardSys = poGcrdSys.getInstance(foCore);
    }

    // ------- METHODS ------- //
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

    public void addGcard(GcardCredentials foCardDta, GcardTransactionCallback foCallBck) {
        new AddGcardTask(mGcardSys, poConnect, foCardDta, foCallBck).execute();
    }

    public void addGCardQrCode(String foGcardQr, GcardTransactionCallback callback) {
        new AddGCardQrCodeTask(mGcardSys, poConnect,callback).execute();
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
        new AddToCartTask(mGcardSys, item, poConnect, callback).execute();
    }

    public void UpdateCartItem(CartItem item, GcardTransactionCallback callback) {
        new UpdateCartItemTask(mGcardSys, item, poConnect, callback);
    }

    public void PlaceOrder(GcardCartItems items, GcardTransactionCallback callback) {
        new PlaceOrderTask(mGcardSys, items, poConnect, callback).execute();
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

    // ------- ASYNCTASKS -------- //
    private static class AddGcardTask extends AsyncTask<Void, Void, String> {
        private static final String ADD_GCARD_TAG = AddGcardTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardCredentials loGcardxx;
        private final GcardTransactionCallback loCallbck;

        private AddGcardTask(iGCardSystem foGcrdSys, ConnectionUtil foConnect, GcardCredentials gcardInfo, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loConnect = foConnect;
            this.loGcardxx = gcardInfo;
            this.loCallbck = callBack;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loCallbck.onLoad();
        }

        @Override
        protected String doInBackground(Void... voids) {
            final String[] lsResult = {""};
            try {
                if(loConnect.isDeviceConnected()) {
                    mGcardSys.AddGCard(loGcardxx, new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            try {
                                JSONObject loDetail = new JSONObject(args);
                                mGcardSys.SaveGCardInfo(loDetail);
                                lsResult[0] = parse(SUCCESS, args);
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
            try {
                JSONObject loJson = new JSONObject(s);
                String lsStatus =String.valueOf(loJson.get("status"));
                String lsMessage = loJson.getString("message");
                if(lsStatus.equals(SUCCESS.toString())) {
                    loCallbck.onSuccess(lsMessage);
                } else if(lsStatus.equals(FAILED.toString())) {
                    loCallbck.onFailed(lsMessage);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

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

    private static class AddToCartTask extends AsyncTask<String, Void, Void> {
        private static final String ADD_TO_CART_TAG = AddToCartTask.class.getSimpleName();
        private final CartItem loCartItm;
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private AddToCartTask(iGCardSystem foGcrdSys, CartItem foCartItm, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loCartItm = foCartItm;
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
                    mGcardSys.AddToCart(loCartItm, new GCardSystem.GCardSystemCallback() {
                        @Override
                        public void OnSuccess(String args) {
                            // TODO: Call the saving of add to cart item to local database
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
                Log.e(ADD_TO_CART_TAG, e.getMessage());
                loCallbck.onFailed(ADD_TO_CART_TAG + e.getMessage());
            }
            return null;
        }

    }

    private static class UpdateCartItemTask extends AsyncTask<String, Void, Void> {
        private static final String UPDATE_CART_TAG = UpdateCartItemTask.class.getSimpleName();
        private final CartItem loCartItm;
        private final iGCardSystem mGcardSys;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private UpdateCartItemTask(iGCardSystem foGcrdSys, CartItem foCartItm, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loCartItm = foCartItm;
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

    private static class PlaceOrderTask extends AsyncTask<String, Void, Void> {
        private static final String PLACE_ORDER_TAG = PlaceOrderTask.class.getSimpleName();
        private final iGCardSystem mGcardSys;
        private final GcardCartItems loCartItm;
        private final ConnectionUtil loConnect;
        private final GcardTransactionCallback loCallbck;

        private PlaceOrderTask(iGCardSystem foGcrdSys, GcardCartItems foCartItm, ConnectionUtil foConnect, GcardTransactionCallback callBack) {
            this.mGcardSys = foGcrdSys;
            this.loCartItm = foCartItm;
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
//                    mGcardSys.PlaceOrder(loCartItm, new GCardSystem.GCardSystemCallback() {
//                        @Override
//                        public void OnSuccess(String args) {
//                            // TODO: Call the update of cart to local database
//                            loCallbck.onSuccess(args);
//                        }
//
//                        @Override
//                        public void OnFailed(String message) {
//                            loCallbck.onFailed(message);
//                        }
//                    });
                } else {
                    loCallbck.onFailed(AppConstants.SERVER_NO_RESPONSE());
                }
            } catch(Exception e) {
                e.printStackTrace();
                Log.e(PLACE_ORDER_TAG, e.getMessage());
                loCallbck.onFailed(PLACE_ORDER_TAG + e.getMessage());
            }
            return null;
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
                    return mGcardSys.GenerateGCardOrderQrCode();
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

    public interface GcardTransactionCallback {
        void onLoad();
        void onSuccess(String fsMessage);
        void onFailed(String fsMessage);
        void onQrGenerate(Bitmap foBitmap);
    }

}
