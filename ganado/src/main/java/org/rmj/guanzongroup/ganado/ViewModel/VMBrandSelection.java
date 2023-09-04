package org.rmj.guanzongroup.ganado.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.Ganado.Obj.Ganado;
import org.rmj.g3appdriver.lib.Ganado.Obj.ProductInquiry;
import org.rmj.g3appdriver.dev.Database.Entities.EMcModel;
import org.rmj.g3appdriver.dev.Database.Entities.EMcBrand;
import java.util.List;

public class VMBrandSelection extends AndroidViewModel {
    // TODO: Implement the ViewModel
    private final Ganado  poGanado;
    private final ProductInquiry poSys;
    private final ConnectionUtil poConn;


    public VMBrandSelection(@NonNull Application application) {
        super(application);
        poSys = new ProductInquiry(application);
        poConn = new ConnectionUtil(application);
        poGanado = new Ganado(application);
    }
    public LiveData<List<EMcBrand>> getBrandList(){
        return poSys.GetMotorcycleBrands();
    }

}