package org.rmj.g3appdriver.lib.Panalo;

import android.content.Context;
import android.graphics.Bitmap;

import org.json.JSONObject;

import java.util.List;

public class GPanalo {
    private static final String TAG = GPanalo.class.getSimpleName();

    private final Context mContext;

    private String message;

    public GPanalo(Context mContext) {
        this.mContext = mContext;
    }

    public String getMessage() {
        return message;
    }

    public JSONObject GetRewardDetail(String params){
        try{

            return null;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    public boolean ClaimReward(String args){
        try{


            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public List<JSONObject> GetRewards(String args){
        try{

            return null;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }

    public Bitmap RedeemReward(String args){
        try{

            return null;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return null;
        }
    }
}
