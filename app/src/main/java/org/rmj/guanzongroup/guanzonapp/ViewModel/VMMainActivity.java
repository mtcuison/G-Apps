package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import org.rmj.g3appdriver.Database.Entities.EClientInfo;
import org.rmj.g3appdriver.Database.Entities.EEmployeeInfo;
import org.rmj.g3appdriver.Database.Entities.EEvents;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.EPromo;
import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.Database.Repositories.REmployee;
import org.rmj.g3appdriver.Database.Repositories.REvents;
import org.rmj.g3appdriver.Database.Repositories.RGCardTransactionLedger;
import org.rmj.g3appdriver.Database.Repositories.RGcardApp;
import org.rmj.g3appdriver.Database.Repositories.RMCSerialRegistration;
import org.rmj.g3appdriver.Database.Repositories.RPromo;
import org.rmj.g3appdriver.Database.Repositories.RRedeemablesInfo;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.GToast;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_NewsFeed;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Notifications;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Promotions;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class VMMainActivity extends AndroidViewModel {

    private final REmployee poUser;
    private final RClientInfo poClient;
    private final RGcardApp poGCard;
    private final RGCardTransactionLedger poLedger;
    private final RMCSerialRegistration poMC;
    private final SessionManager poSession;
    private final AppConfigPreference appConfig;
    public static final MutableLiveData<Boolean> pbIsLogIn = new MutableLiveData<>();
    private final MutableLiveData<List<Fragment>> psFragment = new MutableLiveData<>();
    private final MutableLiveData<Integer> psMenu = new MutableLiveData<>();
    private final MutableLiveData<String[]> psTitles = new MutableLiveData<>();
    private Application instance;
    private final REvents poEvents;
    private final RPromo poPromo;
    private final RRedeemablesInfo poRedeemables;
    private final MutableLiveData<Integer> nUnReadCount = new MutableLiveData();
    public VMMainActivity(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poUser = new REmployee(application);
        this.poClient = new RClientInfo(application);
        this.poSession = new SessionManager(application);
        this.poGCard = new RGcardApp(application);
        this.poLedger = new RGCardTransactionLedger(application);
        this.poMC = new RMCSerialRegistration(application);
        this.appConfig = new AppConfigPreference(application);
        this.pbIsLogIn.setValue(poSession.isLoggedIn());
        this.poEvents = new REvents(application);
        this.poPromo = new RPromo(application);
        this.nUnReadCount.setValue(0);
        this.poRedeemables = new RRedeemablesInfo(application);
        this.pbIsLogIn.setValue(poSession.isLoggedIn());
    }
    public SessionManager getPoSession(){
        return poSession;
    }
    public LiveData<Integer> getOrdersCount(String GCardNo){
        return poRedeemables.getOrdersCount(GCardNo);
    }

    public LiveData<Integer> getUnreadNotificationCount(){
//        Log.e("VMMain", "events count = " + poEvents.getEventCount().getValue().size() + "  promo count = " + poPromo.getPromoCount().getValue().size());
        try {
            if(poSession.isLoggedIn()) {
                nUnReadCount.setValue(this.poEvents.getEventCount().getValue() + this.poPromo.getPromoCount().getValue());
//            return poEvents.getEventCount() + poPromo.getPromoCount() + getMessageCount();
                return nUnReadCount;
            }else {
                nUnReadCount.setValue(poPromo.getPromoCount().getValue());
            }

            return nUnReadCount;
        }catch (NullPointerException e){
            e.printStackTrace();
            nUnReadCount.setValue(0);

            return nUnReadCount;
        }catch (Exception e){
            e.printStackTrace();
            nUnReadCount.setValue(0);
            return nUnReadCount;
        }
    }
    public LiveData<EClientInfo> getClientInfo(){
        return poClient.getClientInfo();
    }
    public LiveData<Boolean> isLoggedIn(){
        return pbIsLogIn;
    }
    public void setLogin(boolean val){
        poSession.setLogin(val);
        pbIsLogIn.setValue(val);
    }
    public void userLogout(){
        poGCard.deleteGCard();
        poClient.LogoutUserSession();
        poLedger.deleteGCardTrans();
        poMC.deleteMC();
        poSession.initUserLogout();
    }
    public LiveData<EGcardApp> getGCard(){
        return poGCard.getGCardInfo();
    }
    public LiveData<List<EGcardApp>> getAllGCard(){
        return poGCard.getAllGCardInfo();
    }
    public Fragment getMainFragment(boolean val){
        if(val){
            return new Fragment_DashBoard();
        }else {

            return  new Fragment_NewsFeed();
        }
    }
    public LiveData<String[]> getTitles(){

        if(poSession.isLoggedIn()){
            psTitles.setValue(new String[]{
                    "Client Portal",
                    "Promos",
                    "Find Us",
                    "About Us"
            });
        }else{
            psTitles.setValue(new String[]{
                    "Dashboard",
                    "Promos",
                    "Find Us",
                    "About Us"
            });
        }
        return  psTitles;
    }

    public Fragment getPromoFragment(boolean val){
        if(val){
            return new Fragment_Notifications();
        }else {

            return new Fragment_Promotions();
        }
    }

    public int getMenuAction(boolean val){
        if(val){
            return R.menu.action_options_menu;

        } else {
            return R.menu.action_contact_us;
        }
    }
//    public void setMenuBadges(Menu menu, boolean val, EClientInfo eClientInfo){
//        if(val){
//            MenuItem itemCart = menu.findItem(R.id.menu_action_item_cart);
//            MenuItem Gcard = menu.findItem(R.id.menu_action_gcard_options);
//            MenuItem Account = menu.findItem(R.id.menu_action_user_details);
//            View cart = MenuItemCompat.getActionView(itemCart);
//            View gcard = MenuItemCompat.getActionView(Gcard);
//            View account = MenuItemCompat.getActionView(Account);
//            ImageView gcardBadge = gcard.findViewById(R.id.img_gcard_badge_notice);
//            gcardBadge.setVisibility(getGCardBadgeVisibility());
//
//            ImageButton btnAccount = account.findViewById(R.id.btn_action_user_details);
//            btnAccount.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    new Dialog_UserDetail(MainActivity.newInstance(), eClientInfo).showDialog();
//                }
//            });
//
//            ImageButton btnGCard = gcard.findViewById(R.id.btn_action_gcard_selection);
////
//        } else {
//
//        }
//    }

    private int getCartBadgeVisibility(){
//        if(new CartManager(mContext).getCartItemCount() == 0){
//            return View.GONE;
//        }
        return View.VISIBLE;
    }

    private int getGCardBadgeVisibility(){
//        if(new GcardAppMaster(mContext).hasUnCheckGCard()){
//            return View.VISIBLE;
//        }
        return View.GONE;
    }
}
