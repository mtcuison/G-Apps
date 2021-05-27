package org.rmj.guanzongroup.guanzonapp.Activities;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.dev.Telephony;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.g3appdriver.etc.SharedPref;
import org.rmj.guanzongroup.guanzonapp.Adapters.ActivityFragmentAdapter;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_ChangePassword;
import org.rmj.guanzongroup.guanzonapp.Dialogs.MessageBox;
import org.rmj.guanzongroup.guanzonapp.Fragments.Transaction.Fragment_AllTransactions;
import org.rmj.guanzongroup.guanzonapp.Fragments.Transaction.Fragment_PointsEarn;
import org.rmj.guanzongroup.guanzonapp.Fragments.Transaction.Fragment_Redemption;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.GcardAppMaster;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.UserLogout;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction.PointsManager;
import org.rmj.guanzongroup.guanzonapp.R;

public class Activity_Account extends AppCompatActivity {
    private static final String TAG = Activity_Account.class.getSimpleName();
    private AppData db;

    private TextView lblUsername;
    private TextView lblUserEmail;
    private TextView lblMobileNo;
    private TextView lblUserDevice;
    private TextView lblGcardPoints;
    private TextView lblGcardNumber;
    private MaterialButton btnLogout;
    private MaterialButton btnChangePass;
    private MaterialButton btnDevices;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        db = AppData.getInstance(Activity_Account.this);
        setupWidgets();
        setupWidgetData();
    }

    private void setupWidgets(){
        lblUsername = findViewById(R.id.lbl_account_username);
        lblUserEmail = findViewById(R.id.lbl_account_userEmail);
        lblMobileNo = findViewById(R.id.lbl_account_dvcMobileNo);
        lblUserDevice = findViewById(R.id.lbl_account_userDevice);
        lblGcardPoints = findViewById(R.id.lbl_account_gcard_available_points);
        lblGcardNumber = findViewById(R.id.lbl_account_active_gcard_number);
        btnLogout = findViewById(R.id.btn_account_logout);
        btnChangePass = findViewById(R.id.btn_account_changePassword);
        btnDevices = findViewById(R.id.btn_account_otherDevice);
        viewPager = findViewById(R.id.viewpager_account_history);
        tabLayout = findViewById(R.id.tablayout_account_fragment_indicator);
    }

    @SuppressLint("SetTextI18n")
    private void setupWidgetData(){
        lblUsername.setText(db.getUserName());
        lblUserEmail.setText(db.getEmailAddress());
        lblUserDevice.setText(Build.BRAND + " - " + Build.MODEL);
        lblMobileNo.setText(new SharedPref(Activity_Account.this).getMobileNo());
        lblGcardNumber.setText(new GcardAppMaster(Activity_Account.this).getCardNumber());
        lblGcardPoints.setText(String.valueOf(new PointsManager(Activity_Account.this).getRemainingGCardPoints()));

        ActivityFragmentAdapter adapter = new ActivityFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_AllTransactions());
        adapter.addFragment(new Fragment_PointsEarn());
        adapter.addFragment(new Fragment_Redemption());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_transaction_tab_all);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_transaction_tab_card);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_transaction_tab_redeem);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewLogoutMessage();
            }
        });

        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Dialog_ChangePassword(Activity_Account.this).showDialog();
            }
        });

        btnDevices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void ViewLogoutMessage() {
        MessageBox messageBox = new MessageBox(Activity_Account.this);
        messageBox.setDialogMessage("Are you sure you want to logout?");
        messageBox.setMessageType(MessageBox.MessageType.WARNING);
        messageBox.setPositiveButton("Okay", new MessageBox.onMessageBoxButtonClick() {
            @Override
            public void onClick(View view, AlertDialog dialog) {
                new SessionManager(Activity_Account.this).setLogin(false);
                Intent intent = new Intent(Activity_Account.this, Activity_DashBoard.class);
                finish();
                startActivity(intent);
                new UserLogout(Activity_Account.this).logoutUser();
                dialog.dismiss();
            }
        });

        messageBox.setNegativeButton("Cancel", new MessageBox.onMessageBoxButtonClick() {
            @Override
            public void onClick(View view, AlertDialog dialog) {
                dialog.dismiss();
            }
        });
        messageBox.showDialog();
    }
}
