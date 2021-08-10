package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RRedeemItemInfo;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.utils.CodeGenerator;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_Loading;
import org.rmj.guanzongroup.guanzonapp.etc.OnAsyncTaskCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class VMItemCart extends AndroidViewModel {
    private static final String TAG = VMItemCart.class.getSimpleName();
    private final Application instance;
    private final RGcardApp poGcardxx;
    private final RRedeemItemInfo poCartItm;
    private final MutableLiveData<String> psGcardNo = new MutableLiveData<>();
    private final MutableLiveData<String> psCardNox = new MutableLiveData<>();
    public VMItemCart(@NonNull Application application) {
        super(application);
        this.instance = application;
        Log.e(TAG, "Initialized.");
        this.poGcardxx = new RGcardApp(application);
        this.poCartItm = new RRedeemItemInfo(application);
        this.psGcardNo.setValue(poGcardxx.getCardNox());
        this.psCardNox.setValue(poGcardxx.getCardNo());
    }

    public LiveData<EGcardApp> getGCardInfo() {
        return poGcardxx.getGCardInfo();
    }

    public LiveData<List<DRedeemItemInfo.CartItemsDetail>> getCartItemsDetail() {
        return poCartItm.getCartItemsDetail(psGcardNo.getValue());
    }

    public LiveData<Double> getTotalCartPoints() {
        return poCartItm.getTotalCartPoints(psGcardNo.getValue());
    }

    public void removeItemFromCart(String fsPromoId) {
        poCartItm.removeItemFromCart(fsPromoId);
    }

    public void updateAvailablePoints(String fsGcardNo, String fsNewPts) {
        poGcardxx.updateAvailablePoints(fsGcardNo, fsNewPts);
    }

    private JSONObject placeOrderParameter(String fsBranch, List<DRedeemItemInfo.CartItemsDetail> foItems){
        JSONArray items = new JSONArray();
        JSONObject params = new JSONObject();
        JSONObject details;
        try{
            if(foItems.size() > 0) {
                for(int x = 0; x < foItems.size(); x++){
                    details = new JSONObject();
                    details.put("promoidx", foItems.get(x).sPromoIDx);
                    details.put("itemqtyx", foItems.get(x).nItemQtyx);
                    items.put(details);
                }

                params.put("secureno", new CodeGenerator().generateSecureNo(psCardNox.getValue()));
                params.put("branchcd", fsBranch);
                params.put("detail", items);
                return params;
            } else {
                return null;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void placeOrder(String fsBranch, List<DRedeemItemInfo.CartItemsDetail> foItems, OnAsyncTaskCallback callBack) {
        new PlaceOrderTask(instance, psGcardNo.getValue(), poCartItm, callBack)
                .execute(placeOrderParameter(fsBranch, foItems));
    }

    private static class PlaceOrderTask extends AsyncTask<JSONObject, Integer, String> {

        private final Application instance;
        private final RRedeemItemInfo poCartItm;
        private final HttpHeaders poHeaders;
        private final ConnectionUtil poConnect;
        private final WebApi poWebApix;
        private final OnAsyncTaskCallback callback;
//        private final Dialog_Loading poLoading;
        private String psGcardNo;
        private String message;

        private PlaceOrderTask(Application instance, String fsGcardNo, RRedeemItemInfo poItem, OnAsyncTaskCallback callBack) {
            this.instance = instance;
            this.poCartItm = poItem;
            this.psGcardNo = fsGcardNo;
            this.poHeaders = HttpHeaders.getInstance(instance);
            this.poConnect = new ConnectionUtil(instance);
            this.poWebApix = new WebApi(instance);
            this.callback = callBack;
//            this.poLoading = foLoading;
        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            poLoading.setMessage("Sending request. Please wait...");
//            poLoading.showDialog();
        }

        @Override
        protected String doInBackground(JSONObject... jsonObjects) {
            String response = "";
            try {
                if(poConnect.isDeviceConnected()) {
                    Log.e("jsonInBg", jsonObjects[0].toString());
                    response = WebClient.httpsPostJSon(poWebApix.URL_PLACE_ODER, jsonObjects[0].toString(),poHeaders.getHeaders());
                    Log.e("PlaceOrderResponse", response);
                    JSONObject loJson = new JSONObject(Objects.requireNonNull(response));
                    String lsResult = loJson.getString("result");
                    if(lsResult.equalsIgnoreCase("success")){
                        poCartItm.placeOrder(psGcardNo, jsonObjects[0].getString("branchcd"));

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
//            poLoading.dismissDialog();
            try {
                JSONObject loJson = new JSONObject(s);
                Log.e(TAG, loJson.getString("result"));
                String lsResult = loJson.getString("result");
                if(lsResult.equalsIgnoreCase("success")){
                    callback.onSuccessResult("Order placed.");
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

}
