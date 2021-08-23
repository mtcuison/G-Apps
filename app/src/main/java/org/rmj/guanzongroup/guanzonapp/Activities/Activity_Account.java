package org.rmj.guanzongroup.guanzonapp.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
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
import org.rmj.g3appdriver.etc.GToast;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_ChangePassword;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_Loading;
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
    private GAppMessageBox loMessage;
    Dialog_Loading loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        mViewModel = new ViewModelProvider(Activity_Account.this).get(VMAccount.class);
        loMessage = new GAppMessageBox(Activity_Account.this);
        loading = new Dialog_Loading(Activity_Account.this);
        setupWidgets();
        mViewModel.getClientInfo().observe(Activity_Account.this, eClientInfo -> {
            try{
                lblUsername.setText(eClientInfo.getUserName());
                lblUserEmail.setText(eClientInfo.getEmailAdd());
                lblMobileNo.setText(eClientInfo.getMobileNo());

            }catch (NullPointerException e){
                e.printStackTrace();
            }
        });
        mViewModel.getGCardInfo().observe(Activity_Account.this, gcad ->{
            try {
                lblGcardPoints.setText(gcad.getAvlPoint());
                lblGcardNumber.setText(gcad.getCardNmbr());
            }catch (NullPointerException e){
                e.printStackTrace();
            }
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
        btnChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog_ChangePassword loDialog = new Dialog_ChangePassword(Activity_Account.this);
                loDialog.createDialog(new Dialog_ChangePassword.onChangePasswordListener() {
                    @Override
                    public void onChangePassword(AlertDialog dialog, String oldPass, String newPass) {
                        mViewModel.changePassword(oldPass, newPass, new VMAccount.onChangePasswordCallBackListener() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onStartChangePassword() {
                                loading.setMessage("Please wait...");
                                loading.showDialog();
                            }

                            @Override
                            public void onSuccessChangePassword() {
                                loading.dismissDialog();
                                GToast.CreateMessage(Activity_Account.this, "Password reset successfully.", GToast.INFORMATION).show();
                            }

                            @Override
                            public void onErrorChangePassword(String ErrorMessage) {
                                loading.dismissDialog();
                                loMessage.initDialog();
                                loMessage.setPositiveButton("Okay", (view, dialog) -> {
                                    dialog.dismiss();
                                });
                                loMessage.setTitle("Guanzon App");
                                loMessage.setMessage(ErrorMessage);
                                loMessage.show();
                            }
                        });
                    }
                });
                loDialog.showDialog();
            }
        });
    }
    @Override
    public void onBackPressed() {
//        startActivity(new Intent(Activity_Account.this, MainActivity.class));
        finish();
    }

    public void userLogout(){
        loMessage.initDialog();
        loMessage.setPositiveButton("Yes", (view, dialog) -> {
            dialog.dismiss();
            mViewModel.userLogout();
            startActivity(new Intent(Activity_Account.this, MainActivity.class));
            finish();
        });
        loMessage.setNegativeButton("No", (view, dialog) -> dialog.dismiss());
        loMessage.setTitle("Guanzon App");
        loMessage.setMessage("Are you sure you want to logout?");
        loMessage.show();
    }
}
