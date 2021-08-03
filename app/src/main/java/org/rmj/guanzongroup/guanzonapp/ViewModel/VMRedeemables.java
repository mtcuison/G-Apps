package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.Database.Entities.EPromo;
import org.rmj.g3appdriver.Database.Repositories.RPromo;

import java.util.ArrayList;
import java.util.List;

public class VMRedeemables extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final RPromo poPromo;
    private LiveData<List<EPromo>> ePromo;
    private List<EPromo> promoList = new ArrayList<>();
    public VMRedeemables(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poPromo = new RPromo(application);
        this.ePromo = poPromo.getAllPromo();

    }
    public LiveData<List<EPromo>> getAllPromo(){
        return ePromo;
    }
}
