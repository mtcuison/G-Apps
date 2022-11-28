package org.rmj.guanzongroup.marketplace.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.rmj.guanzongroup.marketplace.Etc.AddUpdateCartTask;
import org.rmj.guanzongroup.marketplace.Etc.OnTransactionsCallback;

public class VMWishlist extends AndroidViewModel {

    private Context application;

    public VMWishlist(@NonNull Application application) {
        super(application);
        this.application = application;
    }

    public void addUpdateCart(String fsListId, int fnItemQty, boolean QtyUpdate,OnTransactionsCallback foCallBck) {
        new AddUpdateCartTask(application, fnItemQty, QtyUpdate,foCallBck).execute(fsListId);
    }

}