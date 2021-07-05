package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.Repositories.AppTokenManager;
import org.rmj.g3appdriver.Database.Repositories.RBranchInfo;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.Database.Repositories.REmployee;
import org.rmj.g3appdriver.Database.Repositories.REvents;
import org.rmj.g3appdriver.Database.Repositories.RPromo;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.etc.SharedPref;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_SplashScreen;

public class VMSplashScreen extends AndroidViewModel {
    private final MutableLiveData<Boolean> pbGranted = new MutableLiveData<>();
    private final MutableLiveData<String[]> paPermisions = new MutableLiveData<>();
    private final MutableLiveData<Boolean> pbIsLogIn = new MutableLiveData<>();
    private final MutableLiveData<Boolean> pbSession = new MutableLiveData<>();
    private final MutableLiveData<Integer> pnSession = new MutableLiveData<>();
    private final MutableLiveData<Boolean> pbIsTesting= new MutableLiveData<>();
    private final MutableLiveData<Boolean> pbIsLocalHostChange = new MutableLiveData<>();
    private final MutableLiveData<String> psMobileNo = new MutableLiveData<>();
    private final REmployee poUserDbx;
    private final AppConfigPreference poConfigx;
    private final SessionManager poSession;
    private final REmployee poEmployee;
    private final RClientInfo poClient;
    private final ConnectionUtil poConn;
    private final AppTokenManager poToken;
    private final REvents appEvent;
    private final RBranchInfo poBranch;
    private final RPromo poPromo;
    private SharedPref sharedPref;

    public VMSplashScreen(@NonNull Application application) {
        super(application);
        poUserDbx = new REmployee(application);
        poConfigx = AppConfigPreference.getInstance(application);
        poSession = new SessionManager(application);
        poConfigx.setTemp_ProductID("GuanzonApp");
        poConfigx.setIsTesting(false);
        poConn = new ConnectionUtil(application);
        poToken = new AppTokenManager(application);
        poEmployee = new REmployee(application);
        poClient = new RClientInfo(application);
        appEvent = new REvents(application);
        poBranch = new RBranchInfo(application);
        poPromo = new RPromo(application);
//        pbIsTesting.setValue(poSession.isTesting_Phase());
//        pbIsLocalHostChange.setValue(poSession.getIsLocalHostChange());
        paPermisions.setValue(new String[]{
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.GET_ACCOUNTS,
                Manifest.permission.CAMERA});
        pbGranted.setValue(hasPermissions(application.getApplicationContext(), paPermisions.getValue()));
    }
    public void setMobileNo(String val){
        psMobileNo.setValue(val);
        poConfigx.setTemp_mobileno(val);
//        poSession.set(val);

    }
    public LiveData<Boolean> isPermissionsGranted(){
        return pbGranted;
    }

    public LiveData<String[]> getPermisions(){
        return paPermisions;
    }
    public LiveData<String> getMobileNo(){
        psMobileNo.setValue(poConfigx.getMobileNo());
        return psMobileNo;
    }

    public void setSessionTime(int time){
        try {
            this.pnSession.setValue(time);
            if(poConn.isDeviceConnected()) {
                boolean result = pnSession.getValue() <= 0;
                pbSession.setValue(result);
            } else {
                pbSession.setValue(true);
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }
    public LiveData<Boolean> isSessionValid(){
        return pbSession;
    }

    public void setPermissionsGranted(boolean isGranted){
        this.pbGranted.setValue(isGranted);
    }
//
//    public LiveData<Boolean> isLoggedIn(){
//        pbIsLogIn.setValue(poSession.isLoggedIn());
//        return pbIsLogIn;
//    }

    private static boolean hasPermissions(Context context, String... permissions){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M && permissions!=null ){
            for (String permission: permissions){
                if(ActivityCompat.checkSelfPermission(context, permission)!= PackageManager.PERMISSION_GRANTED){
                    return false;
                }
            }
        }
        return true;
    }
}
