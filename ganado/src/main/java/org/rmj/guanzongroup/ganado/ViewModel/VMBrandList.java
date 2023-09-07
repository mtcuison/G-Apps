package org.rmj.guanzongroup.ganado.ViewModel;

//import static org.rmj.g3appdriver.dev.Api.ApiResult.NOT_CONNECTED;
//import static org.rmj.g3appdriver.dev.Api.ApiResult.UNABLE_TO_REACH_LOCAL;
//import static org.rmj.g3appdriver.dev.Api.ApiResult.UNABLE_TO_REACH_SERVER;
//import static org.rmj.g3appdriver.etc.AppConstants.getLocalMessage;
import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EMcBrand;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.Ganado.Obj.ImportBrand;
import org.rmj.g3appdriver.lib.Ganado.Obj.ImportBrandModel;
import org.rmj.g3appdriver.lib.Ganado.Obj.ImportCategory;
import org.rmj.g3appdriver.lib.Ganado.Obj.ImportMcModelPrice;
import org.rmj.g3appdriver.lib.Ganado.Obj.ImportMcTermCategory;
import org.rmj.g3appdriver.lib.Ganado.Obj.ImportTown;
import org.rmj.g3appdriver.lib.Ganado.Obj.Import_McColors;
import org.rmj.g3appdriver.lib.Ganado.Obj.Import_Relation;
import org.rmj.g3appdriver.lib.Ganado.Obj.ProductInquiry;
//import org.rmj.g3appdriver.lib.;
import org.rmj.g3appdriver.lib.Ganado.model.ImportDataCallback;
import org.rmj.g3appdriver.lib.Ganado.model.ImportInstance;
import org.rmj.g3appdriver.utils.Task.OnDoBackgroundTaskListener;
import org.rmj.g3appdriver.utils.Task.TaskExecutor;


import java.util.List;

public class VMBrandList extends AndroidViewModel {
    private static final String TAG = ConnectionUtil.class.getSimpleName();
    private final ProductInquiry poSys;
    private final ConnectionUtil poConn;

    public VMBrandList(@NonNull Application application) {
        super(application);

        poSys = new ProductInquiry(application);
        poConn = new ConnectionUtil(application);
    }

    public LiveData<List<EMcBrand>> getBrandList(){
        return poSys.GetMotorcycleBrands();
    }
    public void importCriteria(){
        new ImportCriteriaTask().execute();
    }


    private class ImportCriteriaTask{
        private String TAG = getClass().getSimpleName();
        public void execute(){
            TaskExecutor.Execute(null, new OnDoBackgroundTaskListener() {
                @Override
                public Object DoInBackground(Object args) {
                    if (!poConn.isDeviceConnected()){
                        return poConn.getMessage();
                    }
                    ImportInstance[]  importInstances = {
                            new ImportBrand(getApplication()),
                            new ImportBrandModel(getApplication()),
                            new Import_McColors(getApplication()),
                            new ImportMcModelPrice(getApplication()),
                            new ImportCategory(getApplication()),
                            new ImportMcTermCategory(getApplication()),
                            new ImportTown(getApplication()),
                            new Import_Relation(getApplication())};
                    new Thread(() -> {
                        for (ImportInstance importInstance : importInstances) {
                            importInstance.ImportData(new ImportDataCallback() {
                                @Override
                                public void OnSuccessImportData() {
                                    Log.e(TAG, importInstance.getClass().getSimpleName() + " import success.");
                                }

                                @Override
                                public void OnFailedImportData(String message) {
                                    Log.e(TAG, importInstance.getClass().getSimpleName() + " import failed. " + message);
                                }
                            });
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();



                        return "";
                }

                @Override
                public void OnPostExecute(Object object) {
                    Log.d(TAG, object.toString());
                }
            });
        }
    }
}
