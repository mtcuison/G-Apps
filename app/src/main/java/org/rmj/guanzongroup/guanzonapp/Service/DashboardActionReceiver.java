package org.rmj.guanzongroup.guanzonapp.Service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;
import org.rmj.g3appdriver.dev.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.Repositories.ROrder;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;
import org.rmj.guanzongroup.notifications.Activity.Activity_Browser;
import org.rmj.guanzongroup.useraccount.Activity.Activity_ProfileVerification;

public class DashboardActionReceiver extends BroadcastReceiver {
    private static final String TAG = DashboardActionReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.hasExtra("args")){
            String args = intent.getStringExtra("args");
            Intent loIntent;
            switch (args){
                case "auth":
                    new CheckDataImportTask(context).execute();
                    break;
                case "client":
                    new ImportClientCompleteInfoTask(context).execute();
                    break;
                case "promo":
                    loIntent = new Intent(context, Activity_Browser.class);
                    loIntent.putExtra("url_link", intent.getStringExtra("url_link"));
                    loIntent.putExtra("args", intent.getStringExtra("browser_args"));
                    loIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(loIntent);
                    break;
                case "purchase":
                    new ImportClientPurchasesTask(context).execute();
                    break;
                case "verify":
                    loIntent = new Intent(context, Activity_ProfileVerification.class);
                    loIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(loIntent);
                    break;
            }
        }
    }

    private static class CheckDataImportTask extends AsyncTask<String, Void, String>{

        private final Context mContext;
        private iGCardSystem loGcard;
        private char cImportxx;

        GCardSystem.GCardSystemCallback callback = new GCardSystem.GCardSystemCallback() {
            @Override
            public void OnSuccess(String args) {
                Log.d(TAG, args);
                try {
                    switch (cImportxx) {
                        case '0':
                            loGcard.SaveGCardInfo(new JSONObject(args));
                            break;
                        case '1':
                            loGcard.SaveMcServiceInfo(new JSONObject(args));
                            break;
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
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
                loGcard = new GCardSystem(mContext).getInstance(GCardSystem.CoreFunctions.GCARD);

                cImportxx = '0';
                loGcard.DownloadGcardNumbers(callback);
                pause();
                if(loGcard.hasActiveGcard().size() > 0){
                    cImportxx = '1';
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

    private static class ImportClientCompleteInfoTask extends AsyncTask<String, Void, String>{

        private final Context mContext;
        private iGCardSystem loGcard;
        private char cImportxx;

        public ImportClientCompleteInfoTask(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
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

    private static class ImportClientPurchasesTask extends AsyncTask<String, Void, String>{

        private final Context mContext;
        private iGCardSystem loGcard;
        private char cImportxx;

        public ImportClientPurchasesTask(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                ROrder loPurchase = new ROrder(mContext);
                if (loPurchase.ImportPurchases()) {
                    Log.d(TAG, "Purchases downloaded successfully.");
                } else {
                    Log.e(TAG, "Failed to download purchases. " + loPurchase.getMessage());
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
