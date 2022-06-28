package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Database.Entities.EPromo;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.FilterType;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

public class VMSearchItem extends AndroidViewModel {
    private static final String TAG = VMSearchItem.class.getSimpleName();

    private final Context mContext;

    private final RProduct poProdct;
    private iGCardSystem poSystem;

    public VMSearchItem(@NonNull Application application) {
        super(application);
        this.mContext = application;
        this.poProdct = new RProduct(mContext);
        this.poSystem = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.EXTRAS);
    }

    public LiveData<List<DProduct.oProduct>> getProductList(int fnIndex) {
        return poProdct.GetProductsList(fnIndex, FilterType.DEFAULT, null, null);
    }

    public LiveData<List<DProduct.oProduct>> GetSearchProductList(String fsVal){
        return poProdct.SearchProducts(fsVal);
    }

    public void RequestProductSearch(String fsVal, OnSearchCallback callback){
        new ProductSearchTask(callback).execute(fsVal);
    }

    public interface OnSearchCallback{
        void OnSearchFinish();
    }

    private class ProductSearchTask extends AsyncTask<String, Void, String>{

        private final OnSearchCallback poCallback;

        public ProductSearchTask(OnSearchCallback poCallback) {
            this.poCallback = poCallback;
        }

        @Override
        protected String doInBackground(String... strings) {
            if(poProdct.SearchProduct(strings[0])){
                Log.d(TAG, "");
            } else {
                Log.e(TAG, poProdct.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            poCallback.OnSearchFinish();
            super.onPostExecute(s);
        }
    }

    public LiveData<List<EPromo>> GetPromoList(){
        return poSystem.GetPromotions();
    }
}
