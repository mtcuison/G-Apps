package org.rmj.guanzongroup.guanzonapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.GuanzonAppConfig;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMDashboard;
import org.rmj.guanzongroup.guanzonapp.databinding.ActivityDashboardBinding;
import org.rmj.guanzongroup.marketplace.Activity.Activity_SearchItem;
import org.rmj.guanzongroup.useraccount.Activity.Activity_Login;
import org.rmj.guanzongroup.useraccount.Activity.Activity_SignUp;

import java.util.Objects;

public class Activity_Dashboard extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityDashboardBinding binding;
    private VMDashboard mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new GuanzonAppConfig(Activity_Dashboard.this).setTestCase(true);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        mViewModel = new ViewModelProvider(Activity_Dashboard.this).get(VMDashboard.class);
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarActivityDashboard.toolbar);
//        binding.appBarActivityDashboard.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home,
                R.id.nav_notifications,
                R.id.nav_purchases,
                R.id.nav_wishlist,
                R.id.nav_item_cart,
                R.id.nav_my_gcard,
                R.id.nav_redeemables,
                R.id.nav_gcard_orders,
                R.id.nav_gcard_transactions,
                R.id.nav_account_settings,
                R.id.nav_find_us,
                R.id.nav_customer_service)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_activity_dashboard);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        setUpHeader(navigationView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.marketplace_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
//            finish();
        } else if (item.getItemId() == R.id.item_search) {
            Intent loIntent = new Intent(Activity_Dashboard.this, Activity_SearchItem.class);
            startActivity(loIntent);
        } else if (item.getItemId() == R.id.item_cart) {
//            Navigation.findNavController(findViewById(android.R.id.content).getRootView()).navigate(R.id.nav_item_cart);
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
        TextView txtSignUp = headerLayout.findViewById(R.id.lbl_Signup);
        TextView txtLoginx = headerLayout.findViewById(R.id.lbl_Login);
        TextView txtFullNm = headerLayout.findViewById(R.id.lbl_UserFullName);
        mViewModel.getClientInfo().observe(Activity_Dashboard.this, eClientinfo -> {
            try {
                if(eClientinfo != null) {
                    lnAuthxxx.setVisibility(View.GONE);
                    txtFullNm.setVisibility(View.VISIBLE);
                    txtFullNm.setText(Objects.requireNonNull(eClientinfo.getLastName()));
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
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
//        if(poActPref.getLoginStatus()) {
//            lnAuthxxx.setVisibility(View.GONE);
//            txtFullNm.setVisibility(View.VISIBLE);
//            txtFullNm.setText(Objects.requireNonNull(poActPref.getFullName()));
//        } else {
//            lnAuthxxx.setVisibility(View.VISIBLE);
//            txtFullNm.setVisibility(View.GONE);
//            txtSignUp.setOnClickListener(v -> {
//                Intent loIntent = new Intent(Activity_Dashboard.this, Activity_SignUp.class);
//                startActivity(loIntent);
//            });
//
//            txtLoginx.setOnClickListener(v -> {
//                Intent loIntent = new Intent(Activity_Dashboard.this, Activity_Login.class);
//                startActivity(loIntent);
//            });
//        }
    }
}