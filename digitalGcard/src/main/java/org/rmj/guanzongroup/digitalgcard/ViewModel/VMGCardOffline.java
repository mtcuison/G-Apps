package org.rmj.guanzongroup.digitalgcard.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DGcardApp;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DPointsRequest;
import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.dev.Database.Entities.EPointsRequest;
import org.rmj.g3appdriver.dev.Database.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.Repositories.RBranchInfo;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.GCardCore.GCardManager;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;
import org.rmj.g3appdriver.utils.Task.OnTaskExecuteListener;
import org.rmj.g3appdriver.utils.Task.TaskExecutor;

import java.util.HashMap;
import java.util.List;

public class VMGCardOffline extends AndroidViewModel {
    private final DGcardApp poGCard;
    private final RBranchInfo poBranchx;
    private final DPointsRequest poRequest;
    private final ConnectionUtil poConnection;
    private final GCardSystem poSystem;
    private iGCardSystem poCardSystem;
    private String message;

    public VMGCardOffline(@NonNull Application application) {
        super(application);

        this.poGCard = GGC_GuanzonAppDB.getInstance(application).EGcardAppDao();
        this.poBranchx = new RBranchInfo(application);
        this.poRequest = GGC_GuanzonAppDB.getInstance(application).GPointsRqstDao();
        this.poConnection = new ConnectionUtil(application);
        this.poSystem = new GCardSystem(application);
        this.poCardSystem = poSystem.getInstance(GCardSystem.CoreFunctions.GCARD);
    }

    public LiveData<List<EGcardApp>> GetCardNumbers(){
        return poGCard.getAllGCardInfo();
    }
    public LiveData<List<EBranchInfo>> getMotorBranches() {
        return poBranchx.getMotorBranches();
    }

    public void SaveRequest(EPointsRequest foData, onRequest callback){
        TaskExecutor.Execute(foData, new OnTaskExecuteListener() {
            @Override
            public void OnPreExecute() {
                callback.onLoad("Points Request", "Sending Request");
            }
            @Override
            public Object DoInBackground(Object args) {
                EPointsRequest loData = (EPointsRequest) args;
                poRequest.SaveRequest(loData);
                message = "Request saved to device";

                //TODO: Upload transaction to server if connected
                if (poConnection.isDeviceConnected()){
                    HashMap<String, String> loparams = new HashMap<>();
                    loparams.put("sGCardNox", loData.getsGCardNox());
                    loparams.put("dTransact", loData.getdTransact());
                    loparams.put("sBranchCD", loData.getsBranchCd());
                    loparams.put("sReferNox", loData.getsReferNox());
                    loparams.put("sSourceCd", loData.getsSourceCd());
                    loparams.put("sOTPasswd", loData.getsOTPasswd());

                    if (!poCardSystem.DownloadGcardPoints(loparams)){
                        message = poCardSystem.GetMessage();
                    }else {
                        message = "Request Sent";
                    }
                }

                return message;
            }
            @Override
            public void OnPostExecute(Object object) {
                String result = object.toString();
                callback.onFinished(result);
            }
        });
    }
    public interface onRequest{
        void onLoad(String title, String message);
        void onFinished(String result);
    }
}