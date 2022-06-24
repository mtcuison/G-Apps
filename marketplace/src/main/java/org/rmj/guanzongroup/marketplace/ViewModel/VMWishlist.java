package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.guanzongroup.marketplace.Etc.AddUpdateCartTask;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;

public class VMWishlist extends AndroidViewModel {

    private Application application;

    public VMWishlist(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public void addUpdateCart(String fsListId, int fnItemQty, OnTransactionsCallback foCallBck) {
        new AddUpdateCartTask(application, fnItemQty, foCallBck).execute(fsListId);
    }

}