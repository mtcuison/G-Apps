package org.guanzongroup.com.creditapp.ViewModel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.guanzongroup.com.creditapp.Obj.MpCreditApp;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.FilterType;

import java.util.List;

public class VMLoanProductList extends AndroidViewModel {
    private static final String TAG = VMLoanProductList.class.getSimpleName();

    private final Context mContext;
    private final RProduct poProdct;

    private final MutableLiveData<MpCreditApp> poCredApp = new MutableLiveData<>();

    private String message;

    public VMLoanProductList(@NonNull Application application) {
        super(application);
        this.mContext = application;
        this.poCredApp.setValue(new MpCreditApp());
        this.poProdct = new RProduct(mContext);
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
            String lsDetail = poCredApp.getValue().getData();
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
}
