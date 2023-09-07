package org.rmj.guanzongroup.ganado.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EMcModel;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.Ganado.Obj.ProductInquiry;

import java.util.List;

public class VMProductSelection extends AndroidViewModel {

    private final ProductInquiry poSys;
    private final ConnectionUtil poConn;


    public VMProductSelection(@NonNull Application application) {
        super(application);
        poSys = new ProductInquiry(application);
        poConn = new ConnectionUtil(application);
    }

    public LiveData<List<EMcModel>> GetModelsList(String lsValue){
        return poSys.GetModelsList(lsValue);
    }
    
}
