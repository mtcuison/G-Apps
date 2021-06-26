package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.Database.Entities.EPromo;
import org.rmj.g3appdriver.Database.Repositories.RPromo;

import java.util.List;

public class VMPromotions extends AndroidViewModel {

    private static final String TAG = VMBranches.class.getSimpleName();
    private final Application instance;
    private final RPromo poPromo;
    private MutableLiveData<List<EBranchInfo>> eBranchInfoList;
    public VMPromotions(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poPromo = new RPromo(application);
    }
    public LiveData<List<EPromo>> getAllPromo(){
        return poPromo.getAllPromo();
    }
}
