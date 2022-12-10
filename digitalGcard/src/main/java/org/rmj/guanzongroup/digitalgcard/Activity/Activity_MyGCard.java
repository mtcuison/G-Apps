package org.rmj.guanzongroup.digitalgcard.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.dev.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.lib.Account.AccountInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_UserInfo;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;
import org.rmj.guanzongroup.useraccount.Activity.Activity_Login;

import java.util.Objects;

public class Activity_MyGCard extends AppCompatActivity {

    private VMGCardSystem mViewModel;

    private Toolbar toolbar;
    private ConstraintLayout vAddGcard, vMyGcardx;
    private TextView txtManage, txtUserNm, txtCardNo, txtPoints;
    private MaterialButton btnAddCrd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_MyGCard.this).get(VMGCardSystem.class);
        setContentView(R.layout.activity_my_gcard);
        mViewModel.setmContext(GCardSystem.CoreFunctions.GCARD);
        if(!new AccountInfo(Activity_MyGCard.this).getLoginStatus()) {
            Intent loIntent = new Intent(Activity_MyGCard.this, Activity_Login.class);
            startActivity(loIntent);
            finish();
        } else {
            initViews();
            initMyGcard();
        }
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("My GCard");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        vAddGcard = findViewById(R.id.layout_add_gcard);
        vMyGcardx = findViewById(R.id.layout_my_gcard);
        txtManage = findViewById(R.id.lblManageGcard);
        txtUserNm = findViewById(R.id.lbl_gcard_user);
        txtCardNo = findViewById(R.id.lbl_card_number);
        txtPoints = findViewById(R.id.lbl_gcard_points);
        btnAddCrd = findViewById(R.id.btnAddGcard);
    }

    private void initMyGcard() {
        mViewModel.getActiveGcard().observe(Activity_MyGCard.this, eGcardApp -> {
            try {
                if(eGcardApp == null) {
                    vAddGcard.setVisibility(View.VISIBLE);
                    vMyGcardx.setVisibility(View.GONE);
                    btnAddCrd.setOnClickListener(v -> {
                        Intent loIntent = new Intent(Activity_MyGCard.this, Activity_AddGcard.class);
                        startActivity(loIntent);
                    });
                } else {
                    vAddGcard.setVisibility(View.GONE);
                    vMyGcardx.setVisibility(View.VISIBLE);
                    displayGcardInfo(eGcardApp);
                    txtManage.setOnClickListener(v -> {
                        Intent loIntent = new Intent(Activity_MyGCard.this, Activity_ManageGcard.class);
                        startActivity(loIntent);
                    });

                    findViewById(R.id.cvGcard).setOnClickListener(v -> {
                        mViewModel.ViewGCardQrCode(bitmap -> {
                            try{
                                final Dialog_UserInfo loDialog = new Dialog_UserInfo(Activity_MyGCard.this);
                                loDialog.initDialog(eGcardApp, bitmap);
                                loDialog.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void displayGcardInfo(EGcardApp foGcardxx) {
        txtUserNm.setText(Objects.requireNonNull(foGcardxx.getNmOnCard()));
        txtCardNo.setText(Objects.requireNonNull(foGcardxx.getCardNmbr()));
        txtPoints.setText(String.valueOf(foGcardxx.getAvlPoint()));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}