package org.guanzongroup.com.creditapp.ViewModel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.lib.CreditApp.model.MpCreditApp;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.etc.FilterType;

import java.util.List;
import java.util.Objects;

public class VMLoanProductList extends AndroidViewModel {
    private static final String TAG = VMLoanProductList.class.getSimpleName();

    private final Context mContext;
    private final RProduct poProdct;
    private final ConnectionUtil poConn;
    private final RClientInfo poClient;

    private final MutableLiveData<MpCreditApp> poCredApp = new MutableLiveData<>();

    public interface OnValidateVerifiedUser{
        void OnValidate(String title, String message);
        void OnAccountVerified();
        void OnAccountNotVerified();
        void OnFailed(String message);
    }

    public VMLoanProductList(@NonNull Application application) {
        super(application);
        this.mContext = application;
        this.poCredApp.setValue(new MpCreditApp());
        this.poProdct = new RProduct(mContext);
        this.poConn = new ConnectionUtil(mContext);
        this.poClient = new RClientInfo(mContext);
    }

    public void initData(Intent foVal){
        try {
            if(foVal.hasExtra("sDetlInfo")) {
                String lsDetail = foVal.getStringExtra("sDetlInfo");
                MpCreditApp loCredApp = new MpCreditApp();
                loCredApp.setData(lsDetail);
                this.poCredApp.setValue(loCredApp);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void StartActivity(Class<?> activity) {
        try {
            String lsDetail = Objects.requireNonNull(poCredApp.getValue()).getData();
            Intent loIntent = new Intent(mContext, activity);
            loIntent.putExtra("sDetlInfo", lsDetail);
            loIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Log.d(TAG, "Data passed: " + lsDetail);
            mContext.startActivity(loIntent);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public LiveData<MpCreditApp> getCreditAppData(){
        return poCredApp;
    }

    public void setData(MpCreditApp foVal){
        poCredApp.setValue(foVal);
    }

    public LiveData<List<DProduct.oProduct>> getProductList(int fnIndex) {
        return poProdct.GetProductsList(fnIndex, FilterType.DEFAULT, null, null);
    }

    public void ValidateUserVerification(OnValidateVerifiedUser listener){
        new ValidateVerifiedTask(listener).execute();
    }

    private class ValidateVerifiedTask extends AsyncTask<Void, String, Integer>{

        private final OnValidateVerifiedUser mListener;

        private String message;

        public ValidateVerifiedTask(OnValidateVerifiedUser mListener) {
            this.mListener = mListener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mListener.OnValidate("Guanzon App", "Checking account. Please wait...");
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            try{
                if(!poConn.isDeviceConnected()){
                    message = "Unable to connect.";
                    return 0;
                }

                if(!poClient.ImportAccountInfo()){
                    message = poClient.getMessage();
                    return 0;
                }

                EClientInfo loClient = poClient.GetClientInfo();
                if(loClient == null){
                    message = "Unable to find client record. Please try restarting the app and try again.";
                    return 0;
                }

                int lnVerified = loClient.getVerified();
                if(lnVerified == 0){
                    message = "Account not verified. Proceed to account verification.";
                    return 2;
                }

                message = "Account verified. Proceed to loan application.";
                return 1;
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return 0;
            }
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            switch (result){
                case 0:
                    mListener.OnFailed(message);
                    break;
                case 2:
                    mListener.OnAccountNotVerified();
                    break;
                default:
                    mListener.OnAccountVerified();
                    break;
            }
        }
    }
}
