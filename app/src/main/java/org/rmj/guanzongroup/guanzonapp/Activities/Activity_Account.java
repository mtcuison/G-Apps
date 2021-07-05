package org.rmj.guanzongroup.guanzonapp.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.tabs.TabLayout;

import org.rmj.g3appdriver.Database.Repositories.RClientInfo;
import org.rmj.g3appdriver.dev.AppData;
import org.rmj.g3appdriver.etc.AppConfigPreference;
import org.rmj.g3appdriver.etc.GAppMessageBox;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMAccount;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMMainActivity;

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
    private VMAccount mViewModel;
    private VMMainActivity viewModel;
    private GAppMessageBox loMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        mViewModel = new ViewModelProvider(Activity_Account.this).get(VMAccount.class);
        viewModel = new ViewModelProvider(Activity_Account.this).get(VMMainActivity.class);
        loMessage = new GAppMessageBox(Activity_Account.this);
        setupWidgets();
        mViewModel.getClientInfo().observe(Activity_Account.this, eClientInfo -> {
            lblUsername.setText(eClientInfo.getUserName());
            lblUserEmail.setText(eClientInfo.getEmailAdd());
            lblMobileNo.setText(eClientInfo.getMobileNo());
        });

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
        btnLogout.setOnClickListener(v->{
            userLogout();
        });
    }
    @Override
    public void onBackPressed() {
        finish();
    }
    public void userLogout(){
        loMessage.initDialog();
        loMessage.setPositiveButton("Yes", (view, dialog) -> {
            dialog.dismiss();
            setResult(Activity.RESULT_OK);
            finish();
        });
        loMessage.setNegativeButton("No", (view, dialog) -> dialog.dismiss());
        loMessage.setTitle("GhostRider");
        loMessage.setMessage("Exit Ghostrider app?");
        loMessage.show();
    }
}
