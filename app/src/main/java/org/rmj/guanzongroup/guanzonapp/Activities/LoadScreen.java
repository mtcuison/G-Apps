package org.rmj.guanzongroup.guanzonapp.Activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.GapImportInstance;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.ImportAccountGcard;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.ImportBranch;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.ImportOrders;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.ImportPromotions;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.Import_Transactions;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport.onImportResultListener;
import org.rmj.guanzongroup.guanzonapp.R;

class LoadScreen {
    private static final String TAG = LoadScreen.class.getSimpleName();

    private Context mContext;
    private Activity mActivity;
    private TextView lblProgress;

    private SessionManager session;

    LoadScreen(Context context,
               Activity activity,
               TextView lblProgress){
        this.mContext = context;
        this.mActivity = activity;
        this.lblProgress = lblProgress;
        this.session = new SessionManager(mContext);
    }

    void startProgress(){
        try {
            new DoBackgroundProgress().execute(getImportInstance1().length);
            Log.e(TAG, "Progress started.");
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("StaticFieldLeak")
    class DoBackgroundProgress extends AsyncTask<Integer, Integer, String>{

        @Override
        protected void onPreExecute() {
            Log.e(TAG, "AsyncTask started.");
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for(int x = 0; x < getImportInstance1().length; x++){
                final String lsClass = getImportInstance1()[x].getClass().getSimpleName();
                getImportInstance1()[x].sendRequest(mContext, new onImportResultListener() {
                    @Override
                    public void onSuccessImport() {
                        Log.e(TAG, lsClass + "successfully imported assets");
                    }

                    @Override
                    public void onErrorResult() {
                        Log.e(TAG, lsClass + "failed to import assets");
                    }
                });

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress((int) ((x / (float) integers[0]) * 100));
            }

            return "finish";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            lblProgress.setText(String.valueOf(values[0] + "%"));
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            if(s.equalsIgnoreCase("finish")) {
                Intent intent = new Intent(mContext, Activity_DashBoard.class);
                mContext.startActivity(intent);
                ((Activity_SplashScreen) mContext).overridePendingTransition(R.anim.animation_intent_activity_fade_in, R.anim.animation_intent_activity_fade_out);
                this.cancel(true);
                mActivity.finish();
            }
            super.onPostExecute(s);
        }
    }

    private GapImportInstance[] getImportInstance1(){
        if(session.isLoggedIn()){
            return new GapImportInstance[]{
                    new ImportAccountGcard(),
                    new ImportOrders(),
                    new Import_Transactions()};
        } else {
            return new GapImportInstance[]{
                    new ImportBranch(),
                    new ImportPromotions()};
        }
    }
}
