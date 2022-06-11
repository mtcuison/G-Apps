package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RProduct;

import java.util.List;

public class VMSearchItem extends AndroidViewModel {
    private static final String TAG = VMSearchItem.class.getSimpleName();

    private final Context mContext;

    private final RProduct poProdct;

    public VMSearchItem(@NonNull Application application) {
        super(application);
        this.mContext = application;
        this.poProdct = new RProduct(mContext);
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
            poProdct.SearchProduct(strings[0]);
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            poCallback.OnSearchFinish();
            super.onPostExecute(s);
        }
    }
}
