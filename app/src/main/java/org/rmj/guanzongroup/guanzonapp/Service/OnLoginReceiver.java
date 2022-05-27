package org.rmj.guanzongroup.guanzonapp.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.RGcardApp;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

public class OnLoginReceiver extends BroadcastReceiver {
    private static final String TAG = OnLoginReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        new CheckDataImportTask(context).execute();
    }

    private static class CheckDataImportTask extends AsyncTask<String, Void, String>{

        private final Context mContext;

        GCardSystem.GCardSystemCallback callback = new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                Log.d(TAG, args);
            }

            @Override
            public void OnFailed(String message) {
                Log.e(TAG, message);
            }
        };

        public CheckDataImportTask(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                pause();
                iGCardSystem loGcard = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);

                loGcard.DownloadGcardNumbers(callback);
                pause();
                if(new RGcardApp(mContext).hasActiveGcard().size() > 0){
                    loGcard.DownloadMCServiceInfo(callback);
                    pause();
                    loGcard.DownloadTransactions(callback);
                }

                pause();
                RClientInfo loClient = new RClientInfo(mContext);
                if (loClient.ImportAccountInfo()) {
                    Log.d(TAG, "Client info downloaded successfully.");
                } else {
                    Log.e(TAG, "Failed to download client info. " + loClient.getMessage());
                }
                pause();
                if (loClient.getClientId() != null) {
                    ROrder loPurchase = new ROrder(mContext);
                    if (loPurchase.ImportMarketPlaceItemCart()) {
                        Log.d(TAG, "Cart items downloaded successfully.");
                    } else {
                        Log.e(TAG, "Failed to download cart items. " + loPurchase.getMessage());
                    }
                    pause();
                    if (loPurchase.ImportPurchases()) {
                        Log.d(TAG, "Purchases downloaded successfully.");
                    } else {
                        Log.e(TAG, "Failed to download purchases. " + loPurchase.getMessage());
                    }
                }
            } catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        private void pause() throws Exception{
            Thread.sleep(1000);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d(TAG, "Local imports for user account has finished.");
        }
    }
}
