package org.rmj.g3appdriver.lib.Ganado.Obj;

import android.app.Application;

import org.rmj.g3appdriver.dev.Repositories.RMcModel;
import org.rmj.g3appdriver.lib.Ganado.model.ImportDataCallback;
import org.rmj.g3appdriver.lib.Ganado.model.ImportInstance;


public class Import_McColors implements ImportInstance {
    public static final String TAG = ImportBrandModel.class.getSimpleName();

    private final RMcModel poSys;

    public Import_McColors(Application instance) {
        this.poSys = new RMcModel(instance);
    }

    @Override
    public void ImportData(ImportDataCallback callback) {
        if(!poSys.ImportModelColor()){
            callback.OnFailedImportData(poSys.getMessage());
        } else {
            callback.OnSuccessImportData();
        }
    }
}
