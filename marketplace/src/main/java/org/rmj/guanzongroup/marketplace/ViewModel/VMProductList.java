package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.FilterType;

import java.util.List;

public class VMProductList extends AndroidViewModel {
    private static final String TAG = VMProductList.class.getSimpleName();

    private final RProduct poProdct;

    public VMProductList(@NonNull Application application) {
        super(application);
        this.poProdct = new RProduct(application);
    }

    public void SetProductFilter(RProduct.oFilterx foVal){
        poProdct.setFilterType(foVal);
    }

    public LiveData<RProduct.oFilterx> GetFilterType(){
        return poProdct.GetFilterType();
    }

    public LiveData<List<DProduct.oProduct>> GetBrandProductList(int fnIndex, FilterType foVal, String args){
        return poProdct.GetProductsList(fnIndex, foVal, args, null);
    }
}
