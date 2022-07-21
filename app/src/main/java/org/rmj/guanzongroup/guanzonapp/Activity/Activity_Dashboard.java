package org.rmj.guanzongroup.guanzonapp.Activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.navigation.NavigationView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Promo;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_UserInfo;
import org.rmj.guanzongroup.digitalgcard.Activity.Activity_QrCodeScanner;
import org.rmj.guanzongroup.digitalgcard.Dialogs.Dialog_TransactionPIN;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.Service.DashboardActionReceiver;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ItemCart;
import org.rmj.guanzongroup.marketplace.ViewModel.VMHome;
import org.rmj.guanzongroup.guanzonapp.databinding.ActivityDashboardBinding;
import org.rmj.guanzongroup.notifications.Activity.Activity_Browser;
import org.rmj.guanzongroup.notifications.Activity.Activity_NotificationList;
import org.rmj.guanzongroup.useraccount.Activity.Activity_DocumentScanner;
import org.rmj.guanzongroup.useraccount.Activity.Activity_Login;
import org.rmj.guanzongroup.useraccount.Activity.Activity_ProfileVerification;
import org.rmj.guanzongroup.useraccount.Activity.Activity_SignUp;
import org.rmj.guanzongroup.useraccount.Activity.Activity_IDVerification;

import java.util.Objects;

public class Activity_Dashboard extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityDashboardBinding binding;
    private NavigationView navigationView;
    private VMHome mViewModel;
    private LayoutInflater loInflate;

    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialog;

    private Toolbar toolbar;
    private BadgeDrawable loBadge;
    private TextView lblBadge;
    private static final int GCARD_APPLICATION = 1;

    private EGcardApp poGcardNo;

    private final DashboardActionReceiver poLogRcv = new DashboardActionReceiver();

    private final ActivityResultLauncher<Intent> poArl = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == GCARD_APPLICATION) {
                    Intent loIntent = result.getData();
                    if (loIntent != null) {
//                        Toast.makeText(Activity_Dashboard.this, loIntent.getStringExtra("result"), Toast.LENGTH_LONG).show();
                        String lsArgs = loIntent.getStringExtra("args");
                        ParseQrCode(lsArgs);
                    } else {
                        Toast.makeText(Activity_Dashboard.this, "No data result receive.", Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    @SuppressLint("UnsafeOptInUsageError")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        mViewModel = new ViewModelProvider(Activity_Dashboard.this).get(VMHome.class);
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarActivityDashboard.toolbar);
        poLoading = new Dialog_Loading(Activity_Dashboard.this);
        poDialog = new Dialog_SingleButton(Activity_Dashboard.this);
        DrawerLayout drawer = binding.drawerLayout;
        navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_promos,
                R.id.nav_events,
                R.id.nav_purchases,
                R.id.nav_wishlist,
                R.id.nav_item_cart,
                R.id.nav_my_gcard,
                R.id.nav_scan_qrcode,
                R.id.nav_redeemables,
                R.id.nav_gcard_orders,
                R.id.nav_gcard_transactions,
                R.id.nav_pre_termination,
                R.id.nav_account_settings,
                R.id.nav_find_us,
                R.id.nav_customer_service,
                R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();

        mViewModel.GetActiveGCard().observe(Activity_Dashboard.this, eGcardApp -> {
            try {
                navigationView = findViewById(R.id.nav_view);
                Menu nav_Menu = navigationView.getMenu();

                //Disable Pre-Termination page untill project is develop...
                nav_Menu.findItem(R.id.nav_wishlist).setVisible(false);
                nav_Menu.findItem(R.id.nav_pre_termination).setVisible(false);
                nav_Menu.findItem(R.id.nav_customer_service).setVisible(false);
                if (eGcardApp == null) {
                    nav_Menu.findItem(R.id.nav_redeemables).setVisible(false);
                    nav_Menu.findItem(R.id.nav_gcard_orders).setVisible(false);
                    nav_Menu.findItem(R.id.nav_gcard_transactions).setVisible(false);
                    nav_Menu.findItem(R.id.nav_pre_termination).setVisible(false);
                } else {
                    nav_Menu.findItem(R.id.nav_redeemables).setVisible(true);
                    nav_Menu.findItem(R.id.nav_gcard_orders).setVisible(true);
                    nav_Menu.findItem(R.id.nav_gcard_transactions).setVisible(true);
                    nav_Menu.findItem(R.id.nav_pre_termination).setVisible(true);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_dashboard);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        setupIntentArguments(navController);
        loInflate = LayoutInflater.from(Activity_Dashboard.this);

        mViewModel.GetUnreadMessagesCount().observe(Activity_Dashboard.this, count -> {
            try{
                toolbar = findViewById(R.id.toolbar);
                if(count > 0) {
                    loBadge = BadgeDrawable.create(Activity_Dashboard.this);
                    loBadge.setNumber(count);
                    BadgeUtils.attachBadgeDrawable(loBadge, toolbar, R.id.item_notifications);
                } else {
                    BadgeUtils.detachBadgeDrawable(loBadge, toolbar, R.id.item_notifications);
                    supportInvalidateOptionsMenu();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetCartItemCount().observe(Activity_Dashboard.this, count -> {
            try {
                toolbar = findViewById(R.id.toolbar);

                lblBadge = (TextView) loInflate.inflate(R.layout.nav_action_badge, null, false);
                navigationView.getMenu().findItem(R.id.nav_item_cart).setActionView(lblBadge);
                lblBadge.setText(GetBadgeValue(count));
                if(count > 0) {
                    loBadge = BadgeDrawable.create(Activity_Dashboard.this);
                    loBadge.setNumber(count);
                    BadgeUtils.attachBadgeDrawable(loBadge, toolbar, R.id.item_cart);
                } else {
                    BadgeUtils.detachBadgeDrawable(loBadge, toolbar, R.id.item_cart);
                    supportInvalidateOptionsMenu();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        mViewModel.GetToPayOrders().observe(Activity_Dashboard.this, count -> {
            try{
                lblBadge = (TextView) loInflate.inflate(R.layout.nav_action_badge, null, false);
                navigationView.getMenu().findItem(R.id.nav_purchases).setActionView(lblBadge);
                lblBadge.setText(GetBadgeValue(count));
            } catch (Exception e){
                e.printStackTrace();
            }
        });

        navigationView.getMenu().findItem(R.id.nav_logout).setOnMenuItemClickListener(menuItem -> {
            Dialog_DoubleButton loDialog = new Dialog_DoubleButton(Activity_Dashboard.this);
            loDialog.setButtonText("YES", "NO");
            loDialog.initDialog("Confirm Logout", "Do you want to log out?", new Dialog_DoubleButton.OnDialogConfirmation() {
                @Override
                public void onConfirm(AlertDialog dialog) {
                    mViewModel.LogoutUserSession(() -> {
                        Intent loIntent = new Intent(Activity_Dashboard.this, Activity_Dashboard.class);
                        startActivity(loIntent);
                    });
                    dialog.dismiss();
                }

                @Override
                public void onCancel(AlertDialog dialog) {
                    dialog.dismiss();
                }
            });
            loDialog.show();
            return false;
        });

        navigationView.getMenu().findItem(R.id.nav_scan_qrcode).setOnMenuItemClickListener(menuItem -> {
            Intent loIntent = new Intent(Activity_Dashboard.this, Activity_QrCodeScanner.class);
            poArl.launch(loIntent);
            return false;
        });

        navigationView.getMenu().findItem(R.id.nav_item_cart).setOnMenuItemClickListener(menuItem -> {
            Intent intent = new Intent(Activity_Dashboard.this, Activity_ItemCart.class);
            intent.putExtra("args", "1");
            startActivity(intent);
            return false;
        });

        setUpHeader(navigationView);

        mViewModel.CheckPromotions(new VMHome.OnCheckPromotions() {
            @Override
            public void OnCheckPromos(String args1, String args2) {
                Dialog_Promo loDialog = new Dialog_Promo(Activity_Dashboard.this);
                loDialog.initDialog(args2, (dialog) -> {
                    Intent intent = new Intent(Activity_Dashboard.this, Activity_Browser.class);
                    intent.putExtra("url_link", args1);
                    intent.putExtra("args", "1");
                    startActivity(intent);
                    dialog.dismiss();
                });
                loDialog.show();
            }

            @Override
            public void OnCheckEvents(String args1, String args2) {
                Dialog_Promo loDialog = new Dialog_Promo(Activity_Dashboard.this);
                loDialog.initDialog(args1, (dialog) -> {
                    Intent intent = new Intent(Activity_Dashboard.this, Activity_Browser.class);
                    intent.putExtra("url_link", args2);
                    intent.putExtra("args", "0");
                    startActivity(intent);
                    dialog.dismiss();
                });
                loDialog.show();
            }

            @Override
            public void NoPromos() {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mrktplc, menu);
        // Get the SearchView and set the searchable configuration
        mViewModel.getClientInfo().observe(Activity_Dashboard.this, eClientinfo -> {
            try {
                if(eClientinfo != null){
                    menu.findItem(R.id.item_notifications).setVisible(true);
                    menu.findItem(R.id.item_cart).setVisible(true);
                } else {
                    menu.findItem(R.id.item_notifications).setVisible(false);
                    menu.findItem(R.id.item_cart).setVisible(false);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
        return true;
    }

    @Override
    public void onBackPressed() {
        Dialog_DoubleButton loDialog = new Dialog_DoubleButton(Activity_Dashboard.this);
        loDialog.setButtonText("YES", "NO");
        loDialog.initDialog("Guanzon App", "Exit Guanzon App?", new Dialog_DoubleButton.OnDialogConfirmation() {
            @Override
            public void onConfirm(AlertDialog dialog) {
                dialog.dismiss();
                finish();
            }

            @Override
            public void onCancel(AlertDialog dialog) {
                dialog.dismiss();
            }
        });
        loDialog.show();
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SUCCESS_LOGIN");
        registerReceiver(poLogRcv, intentFilter);
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(poLogRcv);
        super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent loIntent;
        if(item.getItemId() == android.R.id.home){

        } else if (item.getItemId() == R.id.item_search) {
//            startActivity(new Intent(Activity_Dashboard.this, Activity_IDVerification.class));
//            startActivity(new Intent(Activity_Dashboard.this, Activity_DocumentScanner.class));
            startActivity(new Intent(Activity_Dashboard.this, Activity_ProfileVerification.class));
//            loIntent = new Intent(Activity_Dashboard.this, Activity_SearchItem.class);
//            startActivity(loIntent);
        } else if (item.getItemId() == R.id.item_cart) {
            Intent intent = new Intent(Activity_Dashboard.this, Activity_ItemCart.class);
            intent.putExtra("args", "1");
            startActivity(intent);
        } else {
            startActivity(new Intent(Activity_Dashboard.this, Activity_NotificationList.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_dashboard);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void setUpHeader(NavigationView foNavigxx) {
        View headerLayout = foNavigxx.getHeaderView(0);
        LinearLayout lnAuthxxx = headerLayout.findViewById(R.id.ln_authenticate);
        LinearLayout lnGcardxx = headerLayout.findViewById(R.id.ln_gcard_info);
        TextView txtGcardN = headerLayout.findViewById(R.id.lblGcardNo);
        TextView txtGcardP = headerLayout.findViewById(R.id.lblGcardPts);
        TextView txtSignUp = headerLayout.findViewById(R.id.lbl_Signup);
        TextView txtLoginx = headerLayout.findViewById(R.id.lbl_Login);
        TextView txtFullNm = headerLayout.findViewById(R.id.lbl_UserFullName);

        mViewModel.getClientInfo().observe(Activity_Dashboard.this, eClientinfo -> {
            try {
                Menu nav_Menu = navigationView.getMenu();
                if(eClientinfo != null) {
                    String lsFullNme;
                    if(eClientinfo.getClientID() != null) {
                        lsFullNme = eClientinfo.getFrstName() + " " + eClientinfo.getLastName();
                    } else {
                        lsFullNme = eClientinfo.getUserName();
                    }
                    lnAuthxxx.setVisibility(View.GONE);
                    txtFullNm.setVisibility(View.VISIBLE);
                    txtFullNm.setText(Objects.requireNonNull(lsFullNme));
                    nav_Menu.findItem(R.id.nav_purchases).setVisible(true);
                    nav_Menu.findItem(R.id.nav_wishlist).setVisible(true);
                    nav_Menu.findItem(R.id.nav_item_cart).setVisible(true);
                    nav_Menu.findItem(R.id.nav_account_settings).setVisible(true);
                    nav_Menu.findItem(R.id.nav_logout).setVisible(true);
                } else {
                    lnAuthxxx.setVisibility(View.VISIBLE);
                    txtFullNm.setVisibility(View.GONE);
                    txtSignUp.setOnClickListener(v -> {
                        Intent loIntent = new Intent(Activity_Dashboard.this, Activity_SignUp.class);
                        startActivity(loIntent);
                    });

                    txtLoginx.setOnClickListener(v -> {
                        Intent loIntent = new Intent(Activity_Dashboard.this, Activity_Login.class);
                        startActivity(loIntent);
                    });
                    nav_Menu.findItem(R.id.nav_purchases).setVisible(false);
                    nav_Menu.findItem(R.id.nav_wishlist).setVisible(false);
                    nav_Menu.findItem(R.id.nav_item_cart).setVisible(false);
                    nav_Menu.findItem(R.id.nav_account_settings).setVisible(false);
                    nav_Menu.findItem(R.id.nav_logout).setVisible(false);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        });

        mViewModel.GetActiveGCard().observe(Activity_Dashboard.this, gcard -> {
            try {
                poGcardNo = gcard;
                if(gcard != null) {
                    lnGcardxx.setVisibility(View.VISIBLE);
                    String lsGcardPt = "Points: " + gcard.getAvlPoint();
                    txtGcardN.setText(gcard.getCardNmbr());
                    txtGcardP.setText(lsGcardPt);
                } else {
                    lnGcardxx.setVisibility(View.GONE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                lnGcardxx.setVisibility(View.GONE);
            }
        });

        headerLayout.setOnClickListener(v -> {
            mViewModel.ViewGCardQrCode(bitmap -> {
                try{
                    if(poGcardNo != null) {
                        final Dialog_UserInfo loDialog = new Dialog_UserInfo(this);
                        loDialog.initDialog(poGcardNo, bitmap);
                        loDialog.show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
    }

    private String GetBadgeValue(int val){
        if(val > 0){
            lblBadge.setVisibility(View.VISIBLE);
            return String.valueOf(val);
        } else {
            lblBadge.setVisibility(View.GONE);
            return "0";
        }
    }

    public void ParseQrCode(String fsVal){
        mViewModel.ParseQrCode(fsVal, new GCardSystem.ParseQrCodeCallback() {
            @Override
            public void ApplicationResult(String args) {
                AddGcard(args);
            }

            @Override
            public void TransactionResult(String args) {
                Dialog_TransactionPIN loDialog = new Dialog_TransactionPIN(Activity_Dashboard.this);
                loDialog.initDialog(args);
            }

            @Override
            public void OnFailed(String message) {
                poDialog.setButtonText("Okay");
                poDialog.initDialog("Digital GCard", message, () -> poDialog.dismiss());
                poDialog.show();
            }
        });
    }

    private void AddGcard(String fsVal){
        mViewModel.AddNewGCard(fsVal, new VMHome.OnActionCallback() {
            @Override
            public void OnLoad() {
                poLoading.initDialog("Digital GCard", "Adding GCard. Please wait...");
                poLoading.show();
            }

            @Override
            public void OnSuccess(String args) {
                poLoading.dismiss();
                poDialog.setButtonText("Okay");
                poDialog.initDialog("Digital GCard", args, () -> {
                    poDialog.dismiss();
                });
                poDialog.show();
            }

            @Override
            public void OnFailed(String args) {
                poLoading.dismiss();
                poDialog.setButtonText("Okay");
                poDialog.initDialog("Digital GCard", args, () -> poDialog.dismiss());
                poDialog.show();
            }
        });
    }

    private void setupIntentArguments(NavController navController){
        if(getIntent().hasExtra("args")){
            String lsArgs = getIntent().getStringExtra("args");
            switch (lsArgs){
                case "gcard":
                    Bundle loBundle = new Bundle();
                    loBundle.putInt("gcardInstance", 1);
                    navController.navigate(R.id .action_nav_account_settings_to_nav_my_gcard, loBundle);
                    break;
            }
        }
    }
}