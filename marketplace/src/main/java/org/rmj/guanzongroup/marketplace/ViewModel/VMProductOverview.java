package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.guanzongroup.marketplace.Etc.AddUpdateCartTask;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;
import org.rmj.guanzongroup.marketplace.R;

public class VMProductOverview extends AndroidViewModel {

    private final Application application;
    private final RProduct poProdcts;

    public VMProductOverview(@NonNull Application application) {
        super(application);
        this.application = application;
        this.poProdcts = new RProduct(application);
    }

    public LiveData<EProducts> getProductInfo(String fsListID){
        return poProdcts.GetProductInfo(fsListID);
    }

    public void addUpdateCart(String fsListId, int fnItemQty, OnTransactionsCallback foCallBck) {
        new AddUpdateCartTask(application, fnItemQty, foCallBck).execute(fsListId);
    }

}
