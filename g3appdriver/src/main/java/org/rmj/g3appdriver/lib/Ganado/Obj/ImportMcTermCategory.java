/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.g3appdriver
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:18 PM
 */

package org.rmj.g3appdriver.lib.Ganado.Obj;

import android.app.Application;

import org.rmj.g3appdriver.dev.Repositories.RMcTermCategory;
import org.rmj.g3appdriver.lib.Ganado.model.ImportDataCallback;
import org.rmj.g3appdriver.lib.Ganado.model.ImportInstance;

public class ImportMcTermCategory implements ImportInstance {
    public static final String TAG = ImportMcTermCategory.class.getSimpleName();

    private final RMcTermCategory poSys;

    public ImportMcTermCategory(Application application){
        this.poSys = new RMcTermCategory(application);
    }

    @Override
    public void ImportData(ImportDataCallback callback) {
       if(!poSys.ImportMcTermCategory()){
           callback.OnFailedImportData(poSys.getMessage());
       } else {
           callback.OnSuccessImportData();
       }
    }
}
