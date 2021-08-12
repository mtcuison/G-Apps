package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.Entities.EGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.Database.Repositories.REmployee;
import org.rmj.g3appdriver.Database.Repositories.REvents;
import org.rmj.g3appdriver.Database.Repositories.RGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RMCSerialRegistration;
import org.rmj.g3appdriver.Database.Repositories.RPromo;
import org.rmj.g3appdriver.Database.Repositories.RRedeemablesInfo;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.dev.Telephony;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_GcardSelection;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_NewsFeed;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Notifications;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Promotions;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class VMMainActivity extends AndroidViewModel {

    private final static String TAG = VMMainActivity.class.getSimpleName();
    private final REmployee poUser;
    private final RClientInfo poClient;
    private final RGcardApp poGCard;
    private final RGCardTransactionLedger poLedger;
    private final RMCSerialRegistration poMC;
    private final SessionManager poSession;
    private final AppConfigPreference appConfig;
    public static final MutableLiveData<Boolean> pbIsLogIn = new MutableLiveData<>();
    private final MutableLiveData<List<Fragment>> psFragment = new MutableLiveData<>();
    private final MutableLiveData<Integer> psMenu = new MutableLiveData<>();
    private final MutableLiveData<String[]> psTitles = new MutableLiveData<>();
    private Application instance;
    private final REvents poEvents;
    private final RPromo poPromo;
    private final RRedeemablesInfo poRedeemables;
    private String message;
    private final MutableLiveData<String> resultMessage = new MutableLiveData<>();
    private final MutableLiveData<Integer> nUnReadCount = new MutableLiveData();
    public VMMainActivity(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poUser = new REmployee(application);
        this.poClient = new RClientInfo(application);
        this.poSession = new SessionManager(application);
        this.poGCard = new RGcardApp(application);
        this.poLedger = new RGCardTransactionLedger(application);
        this.poMC = new RMCSerialRegistration(application);
        this.appConfig = new AppConfigPreference(application);
        this.pbIsLogIn.setValue(poSession.isLoggedIn());
        this.poEvents = new REvents(application);
        this.poPromo = new RPromo(application);
        this.nUnReadCount.setValue(0);
        this.poRedeemables = new RRedeemablesInfo(application);
        this.pbIsLogIn.setValue(poSession.isLoggedIn());
    }
    public SessionManager getPoSession(){
        return poSession;
    }
    public LiveData<Integer> getOrdersCount(String GCardNo){
        return poRedeemables.getOrdersCount(GCardNo);
    }
    public interface onScannerResultListener{
        void onSuccessResult(String Pin);
        void onFailedResult(String errorMessage);
    }

    public void setupAction(CodeGenerator codeGenerator, String result, onScannerResultListener listener){
        Log.e(TAG, codeGenerator.getGCardNumber() + " mygcardnumber = " + poGCard.getCardNo());
        if(!isQrCodeValid(codeGenerator, listener)){
            listener.onFailedResult(resultMessage.getValue());
        } else {
            if(codeGenerator.isQrCodeTransaction()){
                if(!codeGenerator.isDeviceValid(
                        appConfig.getMobileNo(),
                        poSession.getUserID(),
                        poGCard.getCardNo())){
                    listener.onFailedResult("Mobile Number or Account is not valid to confirm this transaction");
                } else {
//                    getTransactionResult();createJSONParameters()
                    JSONObject params = new JSONObject();
                    try{
                        params.put("gcardno", poGCard.getCardNo());
                        params.put("entryno", "");
                        params.put("datetrn", codeGenerator.getDTransact());
                        params.put("srcedsc", codeGenerator.getTransSource());
                        params.put("referno", codeGenerator.getSourceNo());
                        params.put("trandsc", codeGenerator.getSourceCD());
                        params.put("srcenox", codeGenerator.getSourceNo());
                        params.put("pointsx", Double.parseDouble(codeGenerator.getPointsxx()));
                        params.put("qrcodex", "1");
                        params.put("receive", "0");
                        new LoadTransactionResult(codeGenerator, result, instance, listener).execute(params);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        listener.onFailedResult(e.getMessage());
                    }
                }
            } else if(codeGenerator.isQrCodeApplication()){
                JSONObject params = new JSONObject();
                try {
                    params.put("secureno", codeGenerator.generateSecureNo(poGCard.getCardNo()));
                    new LoadApplicationResult(codeGenerator, result, instance, listener).execute(params);
                } catch (JSONException e) {
                    e.printStackTrace();
                    listener.onFailedResult(e.getMessage());
                }
            }
        }
    }
    private boolean isQrCodeValid(CodeGenerator codeGenerator, onScannerResultListener listener){
        if(!codeGenerator.isCodeValid()){
            message = "Qr Code is not applicable to any GCard transaction.";
            resultMessage.setValue(message);
//            listener.onFailedResult(message);
            return false;
        } else if(codeGenerator.isTransactionVoid()){
            message = "This transaction is cancelled or void";
            resultMessage.setValue(message);
//            listener.onFailedResult(message);
            return false;
        } else {
            return true;
        }
    }
    public String getMessage(){
        return message;
    }
    private static class LoadApplicationResult extends AsyncTask<JSONObject, Integer, String> {
        private final onScannerResultListener callback;
        private final RGCardTransactionLedger poLedger;
        private final RGcardApp poGcard;

        private final HttpHeaders poHeaders;
        private final ConnectionUtil poConn;
        private final Telephony poDevID;
        private final SessionManager poUser;
        private final AppConfigPreference poConfig;
        private final WebApi poWebApi;
        private final Application instance;
        private final CodeGenerator codeGenerator;
        public LoadApplicationResult(CodeGenerator codeGenerator, String result, Application application, onScannerResultListener callback) {
            this.instance = application;
            this.callback = callback;
            this.codeGenerator = codeGenerator;
            this.poLedger = new RGCardTransactionLedger(instance);
            this.poGcard = new RGcardApp(instance);
            this.poHeaders = HttpHeaders.getInstance(instance);
            this.poConn = new ConnectionUtil(instance);
            this.poDevID = new Telephony(instance);
            this.poUser = new SessionManager(instance);
            this.poWebApi = new WebApi(instance);
            this.poConfig = AppConfigPreference.getInstance(instance);
            this.codeGenerator.setEncryptedQrCode(result);
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObject) {
            String response = "";
            try {
                if(poConn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_IMPORT_GCARD,jsonObject[0].toString(),poHeaders.getHeaders());
                    Log.e("Import_AccountGCard", response);
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        if (!poGcard.insertGCard(loJson)){
                            response = AppConstants.ERROR_SAVING_TO_LOCAL();
                        }
                        else {
                            Log.e("Import_AccountGCard", lsResult);
                            poGcard.saveGCardUpdate();
                        }

                    }
                } else {
                    response = AppConstants.NO_INTERNET();
                }
            } catch (Exception e) {
                Log.e(TAG, Arrays.toString(e.getStackTrace()));
                e.printStackTrace();
            }
            return response;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject loJson = new JSONObject(s);
                Log.e(TAG, loJson.getString("result"));
                String lsResult = loJson.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.onSuccessResult(codeGenerator.getGCardNumber());
                } else {
                    JSONObject loError = loJson.getJSONObject("error");
                    String message = loError.getString("message");
                    callback.onFailedResult(message);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onFailedResult(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                callback.onFailedResult(e.getMessage());
            }
        }
    }
    private static class LoadTransactionResult extends AsyncTask<JSONObject, Integer, String>{
        private final onScannerResultListener callback;
        private final RGCardTransactionLedger poLedger;
        private final RGcardApp poGcard;

        private final HttpHeaders poHeaders;
        private final ConnectionUtil poConn;
        private final Telephony poDevID;
        private final SessionManager poUser;
        private final AppConfigPreference poConfig;
        private final WebApi poWebApi;
        private final Application instance;
        private final CodeGenerator codeGenerator;
        public LoadTransactionResult(CodeGenerator codeGenerator, String result, Application application, onScannerResultListener callback) {
            this.instance = application;
            this.callback = callback;
            this.codeGenerator = codeGenerator;
            this.poLedger = new RGCardTransactionLedger(instance);
            this.poGcard = new RGcardApp(instance);
            this.poHeaders = HttpHeaders.getInstance(instance);
            this.poConn = new ConnectionUtil(instance);
            this.poDevID = new Telephony(instance);
            this.poUser = new SessionManager(instance);
            this.poWebApi = new WebApi(instance);
            this.poConfig = AppConfigPreference.getInstance(instance);
        }
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObject) {
            String response = "";
            try {
                if (poLedger.isTransactionValid(jsonObject[0].getString("gcardno"),
                        jsonObject[0].getString("srcedsc"),
                        jsonObject[0].getString("referno"),
                        jsonObject[0].getString("trandsc"),
                        jsonObject[0].getString("srcenox"),
                        jsonObject[0].getString("pointsx")).getValue() > 0){
                    EGCardTransactionLedger ledger = new EGCardTransactionLedger();
                    ledger.setReferNox(jsonObject[0].getString("referno"));
                    ledger.setSourceDs(jsonObject[0].getString("srcedsc"));
                    ledger.setGCardNox(jsonObject[0].getString("gcardno"));
                    ledger.setTranDesc(jsonObject[0].getString("trandsc"));
                    ledger.setSourceNo(jsonObject[0].getString("srcenox"));
                    ledger.setQRCodexx(jsonObject[0].getString("qrcodex"));
                    ledger.setReceived(jsonObject[0].getString("receive"));
                    ledger.setTransact(jsonObject[0].getString("datetrn"));
                    ledger.setEntryNox(Integer.parseInt(jsonObject[0].getString("entryno")));
                    ledger.setPointsxx(Double.parseDouble(jsonObject[0].getString("pointsx")));
                    poLedger.insert(ledger);
                    response ="success";

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return response;
        }



        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject loJson = new JSONObject(s);
                Log.e(TAG, loJson.getString("result"));
                String lsResult = loJson.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.onSuccessResult(codeGenerator.getTransactionPIN());
                } else {
                    JSONObject loError = loJson.getJSONObject("error");
                    String message = loError.getString("message");
                    callback.onFailedResult(message);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onFailedResult(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                callback.onFailedResult(e.getMessage());
            }
        }
    }
    public LiveData<EClientInfo> getClientInfo(){
        return poClient.getClientInfo();
    }
    public LiveData<Boolean> isLoggedIn(){
        return pbIsLogIn;
    }
    public LiveData<List<EGcardApp>> hasUnCheckGCard(){
        return poGCard.hasUnCheckGCard();
    }
    public void setLogin(boolean val){
        poSession.setLogin(val);
        pbIsLogIn.setValue(val);
    }
    public void userLogout(){
        poGCard.deleteGCard();
        poClient.LogoutUserSession();
        poLedger.deleteGCardTrans();
        poMC.deleteMC();
        poSession.initUserLogout();
    }
    public LiveData<EGcardApp> getGCard(){
        return poGCard.getGCardInfo();
    }

    public interface OnDataFetchListener{
        void OnCheckLocalData(List<EGcardApp> gcardApps);
    }
    public LiveData<List<EGcardApp>> getAllGCard(){
        return poGCard.getAllGCardInfo();
    }
    public void getAllGCard(OnDataFetchListener listener){
        new CheckDataTask(listener).execute();
    }

    @SuppressLint("StaticFieldLeak")
    private class CheckDataTask extends AsyncTask<String, Integer, Boolean>{

        OnDataFetchListener mListener;
        List<EGcardApp> loginDetails;
        public CheckDataTask(OnDataFetchListener mListener) {
            this.mListener = mListener;
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            boolean hasData = false;
            try{

                loginDetails = poGCard.getAllGCard();
                publishProgress(1);

            } catch (Exception e){
                e.printStackTrace();
            }
            return hasData;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            mListener.OnCheckLocalData(loginDetails);
        }
    }
    public Fragment getMainFragment(boolean val){
        if(val){
            return new Fragment_DashBoard();
        }else {

            return  new Fragment_NewsFeed();
        }
    }
    public LiveData<String[]> getTitles(){

        if(poSession.isLoggedIn()){
            psTitles.setValue(new String[]{
                    "Client Portal",
                    "Promos",
                    "Find Us",
                    "About Us"
            });
        }else{
            psTitles.setValue(new String[]{
                    "Dashboard",
                    "Promos",
                    "Find Us",
                    "About Us"
            });
        }
        return  psTitles;
    }

    public Fragment getPromoFragment(boolean val){
        if(val){
            return new Fragment_Notifications();
        }else {

            return new Fragment_Promotions();
        }
    }

    public int getMenuAction(boolean val){
        if(val){
            return R.menu.action_options_menu;

        } else {
            return R.menu.action_contact_us;
        }
    }
//    public void setMenuBadges(Menu menu, boolean val, EClientInfo eClientInfo){
//        if(val){
//            MenuItem itemCart = menu.findItem(R.id.menu_action_item_cart);
//            MenuItem Gcard = menu.findItem(R.id.menu_action_gcard_options);
//            MenuItem Account = menu.findItem(R.id.menu_action_user_details);
//            View cart = MenuItemCompat.getActionView(itemCart);
//            View gcard = MenuItemCompat.getActionView(Gcard);
//            View account = MenuItemCompat.getActionView(Account);
//            ImageView gcardBadge = gcard.findViewById(R.id.img_gcard_badge_notice);
//            gcardBadge.setVisibility(getGCardBadgeVisibility());
//
//            ImageButton btnAccount = account.findViewById(R.id.btn_action_user_details);
//            btnAccount.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    new Dialog_UserDetail(MainActivity.newInstance(), eClientInfo).showDialog();
//                }
//            });
//
//            ImageButton btnGCard = gcard.findViewById(R.id.btn_action_gcard_selection);
////
//        } else {
//
//        }
//    }

    private int getCartBadgeVisibility(){
//        if(new CartManager(mContext).getCartItemCount() == 0){
//            return View.GONE;
//        }
        return View.VISIBLE;
    }

    private int getGCardBadgeVisibility(){
//        if(new GcardAppMaster(mContext).hasUnCheckGCard()){
//            return View.VISIBLE;
//        }
        return View.GONE;
    }
    public interface onAddNewGCardListener{
        void onAddResult();
        void onSuccessResult();
        void onErrorResult(String ErrorMessage);
    }
    public void addNewGCard(String gcardNo, String bday, onAddNewGCardListener listener){
        try{
            JSONObject params = new JSONObject();
            params.put("secureno", new CodeGenerator().generateSecureNo(gcardNo));
            new AddNewGCardTaslk(poGCard,listener, instance).execute(params);
//            new VMQrCodeScanner.LoadTransactionResult(codeGenerator, result, instance, listener).execute(params);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    private static class AddNewGCardTaslk extends AsyncTask<JSONObject, Integer, String> {
        private final onAddNewGCardListener callback;
        private final RGCardTransactionLedger poLedger;
        private final RGcardApp poGcard;

        private final HttpHeaders poHeaders;
        private final ConnectionUtil poConn;
        private final Telephony poDevID;
        private final SessionManager poUser;
        private final AppConfigPreference poConfig;
        private final WebApi poWebApi;
        private final Application instance;
        public AddNewGCardTaslk(RGcardApp poGcard, onAddNewGCardListener callback, Application application) {
            this.instance = application;
            this.callback = callback;
            this.poLedger = new RGCardTransactionLedger(instance);
            this.poGcard = new RGcardApp(instance);
            this.poHeaders = HttpHeaders.getInstance(instance);
            this.poConn = new ConnectionUtil(instance);
            this.poDevID = new Telephony(instance);
            this.poUser = new SessionManager(instance);
            this.poWebApi = new WebApi(instance);
            this.poConfig = AppConfigPreference.getInstance(instance);
        }
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(JSONObject... jsonObject) {
            String response = "";
            try {
                if(poConn.isDeviceConnected()) {
                    response = WebClient.httpsPostJSon(poWebApi.URL_ADD_NEW_GCARD, jsonObject[0].toString(),poHeaders.getHeaders());
                    Log.e("add new gcard", response);
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        if (!poGcard.insertNewGCard(loJson)){
                            response = AppConstants.ERROR_SAVING_TO_LOCAL();
                        }
                        poGcard.checkUserGcardForActive();
                    }
                } else {
                    response = AppConstants.NO_INTERNET();
                }
            } catch (Exception e) {
                Log.e(TAG, Arrays.toString(e.getStackTrace()));
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            callback.onAddResult();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject loJson = new JSONObject(s);
                Log.e(TAG, loJson.getString("result"));
                String lsResult = loJson.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.onSuccessResult();
                } else {
                    JSONObject loError = loJson.getJSONObject("error");
                    String message = loError.getString("message");
                    callback.onErrorResult(message);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                callback.onErrorResult(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                callback.onErrorResult(e.getMessage());
            }
        }
    }
}
