package org.guanzongroup.com.creditapp.ViewModel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import org.json.JSONObject;

public class VMProductList extends AndroidViewModel {
    private static final String TAG = VMProductList.class.getSimpleName();

    private final Context mContext;
    private JSONObject poData;

    private String message;

    public VMProductList(@NonNull Application application) {
        super(application);
        this.mContext = application;
    }

    public void setData(JSONObject foVal){
        this.poData = foVal;
    }

    public void StartActivity(Class<?> activity) {
        Intent loIntent = new Intent(mContext, activity);
        loIntent.putExtra("sDetlInfo", poData.toString());
        mContext.startActivity(loIntent);
    }

    public JSONObject getCreditAppData(Class<?> activity, Intent foVal){
        JSONObject loJson = null;
        try{
            if(!foVal.hasExtra("sDetlInfo")){
                message = "No data found.";
            } else {
                String lsDetail = foVal.getStringExtra("sDetlInfo");
                loJson = new JSONObject(lsDetail);
                switch (activity.getSimpleName().toLowerCase()){
                    case "activity_loanentry":
                        return loJson.getJSONObject("loan_unit");
                    case "activity_meansinfo":
                        return loJson.getJSONObject("means_info");
                    case "activity_otherinfo":
                        return loJson.getJSONObject("other_info");
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
        }
        return loJson;
    }
}
