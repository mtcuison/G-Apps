package org.rmj.guanzongroup.gconnect.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DAddress;
import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.g3appdriver.dev.Repositories.RAddressMobile;
import org.rmj.g3appdriver.dev.Repositories.RBranchInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

public class VMBranchDetails extends AndroidViewModel {
    private final RBranchInfo poBranchx;
    private final RAddressMobile poAddress;
    private final Application instance;

    public VMBranchDetails(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poBranchx = new RBranchInfo(application);
        this.poAddress = new RAddressMobile(application);
    }

    public void DownloadBranches(){
        new DownloadBranchesTask().execute();
    }

    private class DownloadBranchesTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            try {
            iGCardSystem loGcard = new GCardSystem(instance).getInstance(GCardSystem.CoreFunctions.EXTRAS);
                loGcard.DownloadBranchesList(new GCardSystem.GCardSystemCallback() {
                    @Override
                    public void OnSuccess(String args) {

                    }

                    @Override
                    public void OnFailed(String message) {

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public LiveData<List<EBranchInfo>> getMotorBranches() {
        return poBranchx.getMotorBranches();
    }

    public LiveData<List<EBranchInfo>> getMobileBranches() {
        return poBranchx.getMobileBranches();
    }

    public LiveData<List<DAddress.oTownObj>> GetTownList(){
        return poAddress.GetTownList();
    }
}
