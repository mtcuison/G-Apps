package org.rmj.guanzongroup.useraccount.ViewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class VMIDVerification extends AndroidViewModel {
    private static final String TAG = AndroidViewModel.class.getSimpleName();

//    private final AccountVerification poSys;
//    private final ConnectionUtil poConn;

    public VMIDVerification(@NonNull Application application) {
        super(application);
//        this.poSys = new AccountVerification(application);
//        this.poConn = new ConnectionUtil(application);
    }

    public void ImportIDTypes(OnImportIDTypeListener listener){
//        new ImportIDTask(listener).execute();
    }

//    private class ImportIDTask extends AsyncTask<Void, Void, List<UserIdentification>>{
//
//        private final OnImportIDTypeListener listener;
//
//        private String message;
//
//        public ImportIDTask(OnImportIDTypeListener listener) {
//            this.listener = listener;
//        }
//
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            listener.OnImportIDType("Loan Application", "Initializing valid ids. Please wait...");
//        }
//
//        @Override
//        protected List<UserIdentification> doInBackground(Void... voids) {
//            if(!poConn.isDeviceConnected()){
//                message = "Unable to connect.";
//                return null;
//            }
//
//            List<UserIdentification> loList = poSys.ImportIDCode();
//
//            if(loList == null){
//                message = poSys.getMessage();
//                return null;
//            }
//
//            return loList;
//        }
//
//        @Override
//        protected void onPostExecute(List<UserIdentification> result) {
//            super.onPostExecute(result);
//            if(result == null){
//                listener.OnFailed(message);
//            } else {
//                listener.OnSuccess(result);
//            }
//        }
//    }
}
