package org.rmj.guanzongroup.guanzonapp.etc;

import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_UserDetail;
import org.rmj.guanzongroup.guanzonapp.Dialogs.GCard_Selection.Dialog_GcardSelection;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_NewsFeed;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Notifications;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Promotions;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction.CartManager;
import org.rmj.guanzongroup.guanzonapp.R;

public class DashBoardIconBadge {
    private Context mContext;
    private SessionManager session;

    public DashBoardIconBadge(Context context){
        this.mContext = context;
        this.session = new SessionManager(mContext);
    }

    public Fragment getMainFragment(){
        if(session.isLoggedIn()){
            return new Fragment_DashBoard();
        }
        return new Fragment_NewsFeed();
    }

    public Fragment getPromoFragment(){
        if(session.isLoggedIn()){
            return new Fragment_Notifications();
        }
        return new Fragment_Promotions();
    }

    public int getMenuAction(){
        if(session.isLoggedIn()){
            return R.menu.action_options_menu;
        } else {
            return R.menu.action_contact_us;
        }
    }

    public void setMenuBadges(Menu menu){
        if(session.isLoggedIn()){
            MenuItem itemCart = menu.findItem(R.id.menu_action_item_cart);
            MenuItem Gcard = menu.findItem(R.id.menu_action_gcard_options);
            MenuItem Account = menu.findItem(R.id.menu_action_user_details);
            View cart = MenuItemCompat.getActionView(itemCart);
            View gcard = MenuItemCompat.getActionView(Gcard);
            View account = MenuItemCompat.getActionView(Account);
            //TextView orderItems = cart.findViewById(R.id.lbl_item_on_cart_count);
            //orderItems.setVisibility(getCartBadgeVisibility());
            int itemsOnCart = new CartManager(mContext).getCartItemCount();
            //orderItems.setText(String.valueOf(itemsOnCart));
            ImageView gcardBadge = gcard.findViewById(R.id.img_gcard_badge_notice);
            gcardBadge.setVisibility(getGCardBadgeVisibility());

            ImageButton btnAccount = account.findViewById(R.id.btn_action_user_details);
            btnAccount.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Dialog_UserDetail(mContext).showDialog();
                }
            });

            ImageButton btnGCard = gcard.findViewById(R.id.btn_action_gcard_selection);
            btnGCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Dialog_GcardSelection(mContext).showDialog();
                }
            });

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
        if(new CartManager(mContext).getCartItemCount() == 0){
            return View.GONE;
        }
        return View.VISIBLE;
    }

    private int getGCardBadgeVisibility(){
        if(new GcardAppMaster(mContext).hasUnCheckGCard()){
            return View.VISIBLE;
        }
        return View.GONE;
    }
}
