package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EProducts;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RProduct;
import org.rmj.g3appdriver.etc.ConnectionUtil;

import java.util.List;

public class VMHome extends AndroidViewModel {
    private final RClientInfo poClientx;
    private final RProduct poProduct;

    public VMHome(@NonNull Application application) {
        super(application);
        this.poClientx = new RClientInfo(application);
        this.poProduct = new RProduct(application);
    }

    public LiveData<EClientInfo> getClientInfo() {
        return poClientx.getClientInfo();
    }

    public LiveData<List<EProducts>> getProductList(int fnIndex) {
        return poProduct.GetProductList(fnIndex);
    }
}