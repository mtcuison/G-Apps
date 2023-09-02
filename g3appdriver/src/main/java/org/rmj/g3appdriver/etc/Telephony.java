package org.rmj.g3appdriver.etc;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;

import androidx.core.app.ActivityCompat;

import java.util.ArrayList;
import java.util.List;

public class Telephony {

    private final Context mContext;

    public interface OnSubscriptionCheckListener{
        void OnCheck(int simCount, ArrayList<String> mobileNo);
        void NoSubscription();
    }

    public Telephony(Context context){
        this.mContext = context;
    }

    @SuppressLint("HardwareIds")
    public String getDeviceID() {
        return Settings.Secure.getString(
                mContext.getContentResolver(),
                Settings.Secure.ANDROID_ID);
    }

    @SuppressLint("NewApi")
    public String getMobilNumbers() {
        try {
            List<SubscriptionInfo> subInfoList;
            ArrayList<String> Numbers = new ArrayList<>();
            SubscriptionManager mSubscriptionManager = SubscriptionManager.from(mContext);
            ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE);
            subInfoList = mSubscriptionManager.getActiveSubscriptionInfoList();
            if (subInfoList.size() > 0) {
                for (SubscriptionInfo subscriptionInfo : subInfoList) {
                    Numbers.add(subscriptionInfo.getNumber());
                }
                if(Numbers.get(0) != null){
                    String lsResult = "";
                    String MobileNo = Numbers.get(0);
                    if (!MobileNo.isEmpty()) {
                        if (MobileNo.substring(0, 3).equalsIgnoreCase("+63")) {
                            lsResult = MobileNo.replace("+63", "0");
                        } else if (MobileNo.substring(0, 1).equalsIgnoreCase("9")) {
                            lsResult = "0" + MobileNo;
                        } else if (MobileNo.substring(0, 2).equalsIgnoreCase("63")) {
                            lsResult = MobileNo.replace("63", "0");
                        } else if (MobileNo.substring(0, 2).equalsIgnoreCase("09")) {
                            lsResult = MobileNo;
                        } else {
                            MobileNo = MobileNo.replace("-", "");
                            MobileNo = MobileNo.replace("+", "");
                            String lsTarget = MobileNo.substring(0, 2);
                            lsResult = MobileNo.replace(lsTarget, "09");
                        }
                    }
                    return lsResult;
                } else if(Numbers.get(1) != null){
                    String lsResult = "";
                    String MobileNo = Numbers.get(1);
                    if (!MobileNo.isEmpty()) {
                        if (MobileNo.substring(0, 3).equalsIgnoreCase("+63")) {
                            lsResult = MobileNo.replace("+63", "0");
                        } else if (MobileNo.substring(0, 1).equalsIgnoreCase("9")) {
                            lsResult = "0" + MobileNo;
                        } else if (MobileNo.substring(0, 2).equalsIgnoreCase("63")) {
                            lsResult = MobileNo.replace("63", "0");
                        } else if (MobileNo.substring(0, 2).equalsIgnoreCase("09")) {
                            lsResult = MobileNo;
                        } else {
                            //this method is use for emulator testing...
                            MobileNo = MobileNo.replace("-", "");
                            MobileNo = MobileNo.replace("+", "");
                            String lsTarget = MobileNo.substring(0, 2);
                            lsResult = MobileNo.replace(lsTarget, "09");
                        }
                    }
                    return lsResult;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
            return "";
        }
        return "";
    }

    @SuppressLint("NewApi")
    public void getSubscriptions(OnSubscriptionCheckListener listener){
        try {
            List<SubscriptionInfo> subInfoList;
            SubscriptionManager mSubscriptionManager = SubscriptionManager.from(mContext);
            ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE);
            subInfoList = mSubscriptionManager.getActiveSubscriptionInfoList();
            if(subInfoList.size() > 0){
                ArrayList<String> mobileNo = new ArrayList<>();
                for(int x = 0; x < subInfoList.size(); x++){
                    SubscriptionInfo subscriptionInfo = subInfoList.get(x);
                    String lsMobile = subscriptionInfo.getNumber();
                    if(lsMobile!=null) {
                        if (!lsMobile.isEmpty()) {
                            String lsResult;
                            if (lsMobile.substring(0, 3).equalsIgnoreCase("+63")) {
                                lsResult = lsMobile.replace("+63", "0");
                            } else if (lsMobile.substring(0, 1).equalsIgnoreCase("9")) {
                                lsResult = "0" + lsMobile;
                            } else if (lsMobile.substring(0, 2).equalsIgnoreCase("63")) {
                                lsResult = lsMobile.replace("63", "0");
                            } else if (lsMobile.substring(0, 2).equalsIgnoreCase("09")) {
                                lsResult = lsMobile;
                            } else {
                                lsMobile = lsMobile.replace("-", "");
                                lsMobile = lsMobile.replace("+", "");
                                String lsTarget = lsMobile.substring(0, 2);
                                lsResult = lsMobile.replace(lsTarget, "09");
                            }
                            mobileNo.add(lsResult);
                        }
                    }
                }
                listener.OnCheck(mobileNo.size(), mobileNo);
            } else {
                listener.NoSubscription();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
