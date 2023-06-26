package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class VMProductList extends AndroidViewModel {
    private static final String TAG = VMProductList.class.getSimpleName();

//    private final RProduct poProdct;

    private String message;

    public interface OnSearchItemListener{
        void OnSearch(String title, String message);
        void OnSearch();
    }

    public VMProductList(@NonNull Application application) {
        super(application);
//        this.poProdct = new RProduct(application);
    }

//    public void SetProductFilter(RProduct.oFilterx foVal){
//        poProdct.setFilterType(foVal);
//    }
//
//    public LiveData<RProduct.oFilterx> GetFilterType(){
//        return poProdct.GetFilterType();
//    }
//
//    public LiveData<List<DProduct.oProduct>> GetBrandProductList(int fnIndex, FilterType foVal, String args){
//        return poProdct.GetProductsList(fnIndex, foVal, args, null);
//    }
//
//    public void SearchItem(String args, OnSearchItemListener listener){
//        new SearchItemTask(listener).execute(args);
//    }
//
//    public LiveData<List<DProduct.oProduct>> GetProductsOnBrand(String fsArgs, String fsArgs1){
//        return poProdct.GetProductsOnBrand(fsArgs, fsArgs1);
//    }
//
//    private class SearchItemTask extends AsyncTask<String, Void, Boolean>{
//
//        private final OnSearchItemListener listener;
//
//        public SearchItemTask(OnSearchItemListener listener) {
//            this.listener = listener;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            listener.OnSearch("Guanzon App", "Searching item. Please wait...");
//        }
//
//        @Override
//        protected Boolean doInBackground(String... strings) {
//            try {
//                if(!poProdct.SearchProduct(strings[0])){
//                    message = poProdct.getMessage();
//                    return false;
//                }
//
//                return true;
//            } catch (Exception e){
//                e.printStackTrace();
//                message = e.getMessage();
//                return false;
//            }
//        }
//
//        @Override
//        protected void onPostExecute(Boolean isSuccess) {
//            super.onPostExecute(isSuccess);
//            listener.OnSearch();
//        }
//    }
}
