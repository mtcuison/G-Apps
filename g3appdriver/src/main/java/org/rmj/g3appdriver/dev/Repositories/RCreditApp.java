package org.rmj.g3appdriver.dev.Repositories;

import android.content.Context;

public class RCreditApp {
    private static final String TAG = RCreditApp.class.getSimpleName();

    private final Context mContext;

    private String message;

    public RCreditApp(Context mContext) {
        this.mContext = mContext;
    }

    public boolean DownloadLoanProducts(){
        try{
            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean DownloadProductOverview(String fsArgs){
        try{
            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public boolean CalculateAmortization(String fsArgs){
        try{
            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }
}
