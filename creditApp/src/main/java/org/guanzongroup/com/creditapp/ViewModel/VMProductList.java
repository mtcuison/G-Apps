package org.guanzongroup.com.creditapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class VMProductList extends AndroidViewModel {
    private static final String TAG = VMProductList.class.getSimpleName();


    public VMProductList(@NonNull Application application) {
        super(application);
    }
}
