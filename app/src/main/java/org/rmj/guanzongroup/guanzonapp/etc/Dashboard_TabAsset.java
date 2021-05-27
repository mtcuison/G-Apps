package org.rmj.guanzongroup.guanzonapp.etc;

import android.content.Context;

import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.guanzongroup.guanzonapp.R;

public class Dashboard_TabAsset {

    private Context mContext;
    private SessionManager session;

    private int[] tabIconOutlined;
    private int[] tabIconToggled;

    public Dashboard_TabAsset(Context context){
        this.mContext = context;
        this.session = new SessionManager(mContext);
    }

    public int[] tabIcon(){
        return tabIconOutlined = new int[]{
          getTabIconMain(),
          getTabNotification(),
          R.drawable.ic_tab_location,
          R.drawable.ic_tab_info
        };
    }

    public int[] tabIconToggled(){
        return tabIconToggled = new int[]{
                getTabIconMainToggled(),
                getTabNotificationToggled(),
                R.drawable.ic_tab_location_toggled,
                R.drawable.ic_tab_info_toggled
        };
    }

    private int getTabIconMain(){
        if(session.isLoggedIn()){
            return R.drawable.ic_tab_dashboard;
        }
        return R.drawable.ic_tab_login;
    }

    private int getTabIconMainToggled(){
        if(session.isLoggedIn()){
            return R.drawable.ic_tab_dashboard_toggled;
        }
        return R.drawable.ic_tab_login_toggled;
    }

    private int getTabNotification(){
        if(session.isLoggedIn()){
            return R.drawable.ic_tab_notification;
        }
        return R.drawable.ic_tab_promo;
    }

    private int getTabNotificationToggled(){
        if(session.isLoggedIn()){
            return R.drawable.ic_tab_notification_toggled;
        }
        return R.drawable.ic_tab_promo_toggled;
    }
}
