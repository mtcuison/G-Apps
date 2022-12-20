package org.rmj.guanzongroup.panalo.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import org.rmj.g3appdriver.dev.Database.Entities.EPanaloReward;
import org.rmj.g3appdriver.dev.Database.Entities.EPromo;
import org.rmj.g3appdriver.etc.ConnectionUtil;
import org.rmj.g3appdriver.lib.Panalo.GPanalo;
import org.rmj.g3appdriver.lib.Panalo.PanaloRewards;
import org.rmj.g3appdriver.lib.Promotions.GPromos;

import java.util.List;

public class VMPanalo extends AndroidViewModel {

    private final GPromos poPromos;
    private final GPanalo poSys;

    private final ConnectionUtil poConn;

    public interface OnImportPanaloRewards{
        void OnImport();
        void OnSuccess(List<PanaloRewards> rewards);
        void OnFailed(String message);
    }

    public VMPanalo(@NonNull Application application) {
        super(application);
        this.poPromos = new GPromos(application);
        this.poSys = new GPanalo(application);
        this.poConn = new ConnectionUtil(application);
    }
    // TODO: Implement the ViewModel

    public LiveData<List<EPromo>> getPromotions(){
        return poPromos.GetPromotions();
    }

    public LiveData<EPanaloReward> GetPanaloNotice(){
        return poSys.GetPanaloNotice();
    }

    public void ImportPanaloRewards(String args, OnImportPanaloRewards listener){
        new ImportRewardsTask(listener).execute(args);
    }

    private class ImportRewardsTask extends AsyncTask<String, Void, List<PanaloRewards>>{

        private final OnImportPanaloRewards mListener;

        private String message;

        public ImportRewardsTask(OnImportPanaloRewards mListener) {
            this.mListener = mListener;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mListener.OnImport();
        }

        @Override
        protected List<PanaloRewards> doInBackground(String... strings) {
            try{
                List<PanaloRewards> loRewards = poSys.GetRewards(strings[0]);
                if(loRewards == null){
                    message = poSys.getMessage();
                    return null;
                }

                return loRewards;
            } catch (Exception e){
                e.printStackTrace();
                message = e.getMessage();
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<PanaloRewards> result) {
            super.onPostExecute(result);
            if(result == null){
                mListener.OnFailed(message);
            } else {
                mListener.OnSuccess(result);
            }
        }
    }
}