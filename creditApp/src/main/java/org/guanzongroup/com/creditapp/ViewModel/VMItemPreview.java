package org.guanzongroup.com.creditapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class VMItemPreview extends AndroidViewModel {
    private static final String TAG = VMItemPreview.class.getSimpleName();

//    private final RProduct poApp;

    public VMItemPreview(@NonNull Application application) {
        super(application);
//        this.poApp = new RProduct(application);
    }

//    public LiveData<EProducts> getProductInfo(String fsListID){
//        return poApp.GetProductInfo(fsListID);
//    }
}
