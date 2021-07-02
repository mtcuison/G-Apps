package org.rmj.guanzongroup.guanzonapp.ViewModel;

import android.app.Application;
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

import org.rmj.g3appdriver.Database.Entities.EEmployeeInfo;
import org.rmj.g3appdriver.Database.Repositories.REmployee;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.guanzongroup.guanzonapp.Fragments.Branches.Fragment_Branches;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_NewsFeed;
import org.rmj.guanzongroup.guanzonapp.Fragments.Fragment_About;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Notifications;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Promotions;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.ArrayList;
import java.util.List;

public class VMMainActivity extends AndroidViewModel {

    private final REmployee poUser;
    private final SessionManager poSession;
    private final MutableLiveData<Boolean> pbIsLogIn = new MutableLiveData<>();
    private final MutableLiveData<List<Fragment>> psFragment = new MutableLiveData<>();
    private final MutableLiveData<Integer> psMenu = new MutableLiveData<>();
    private final MutableLiveData<String[]> psTitles = new MutableLiveData<>();
    public VMMainActivity(@NonNull Application application) {
        super(application);
        this.poUser = new REmployee(application);
        this.poSession = new SessionManager(application);
        this.pbIsLogIn.setValue(poSession.isLoggedIn());
    }
    public SessionManager getPoSession(){
        return poSession;
    }

    public LiveData<Boolean> isLoggedIn(){
        pbIsLogIn.setValue(poSession.isLoggedIn());
        return pbIsLogIn;
    }
    public void setLogin(boolean val){
        poSession.setLogin(val);
        pbIsLogIn.setValue(val);

    }
    public LiveData<EEmployeeInfo> getEmployeeInfo(){
        return poUser.getEmployeeInfo();
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

    public LiveData<Integer> getMenuAction(){
        if(poSession.isLoggedIn()){
            psMenu.setValue(R.menu.action_options_menu);

        } else {
            psMenu.setValue(R.menu.action_contact_us);
        }
        return psMenu;
    }
    public int getDasboard(){
        if(poSession.isLoggedIn()){
            return R.id.bottom_dashboard;
        } else {
            return R.id.nav_newsFeed;
        }
    }
    public void setMenuBadges(Menu menu){
        if(poSession.isLoggedIn()){
            MenuItem itemCart = menu.findItem(R.id.menu_action_item_cart);
            MenuItem Gcard = menu.findItem(R.id.menu_action_gcard_options);
            MenuItem Account = menu.findItem(R.id.menu_action_user_details);
            View cart = MenuItemCompat.getActionView(itemCart);
            View gcard = MenuItemCompat.getActionView(Gcard);
            View account = MenuItemCompat.getActionView(Account);
            //TextView orderItems = cart.findViewById(R.id.lbl_item_on_cart_count);
            //orderItems.setVisibility(getCartBadgeVisibility());
//            int itemsOnCart = new CartManager(mContext).getCartItemCount();
            //orderItems.setText(String.valueOf(itemsOnCart));
            ImageView gcardBadge = gcard.findViewById(R.id.img_gcard_badge_notice);
            gcardBadge.setVisibility(getGCardBadgeVisibility());

            ImageButton btnAccount = account.findViewById(R.id.btn_action_user_details);
//            btnAccount.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    new Dialog_UserDetail(mContext).showDialog();
//                }
//            });

            ImageButton btnGCard = gcard.findViewById(R.id.btn_action_gcard_selection);
//            btnGCard.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    new Dialog_GcardSelection(mContext).showDialog();
//                }
//            });

            /*ImageButton btnItemCart = cart.findViewById(R.id.btn_action_item_cart);
            btnItemCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mContext.startActivity(new Intent(mContext, Activity_ItemCart.class));
                }
            });*/
        } else {

        }
    }

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
