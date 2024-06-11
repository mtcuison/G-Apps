package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.g3appdriver.etc.FragmentAdapter;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.guanzongroup.useraccount.Fragment.Fragment_EditAccountInfo;
import org.rmj.guanzongroup.useraccount.Fragment.Fragment_EditAddress;
import org.rmj.guanzongroup.useraccount.Fragment.Fragment_EditPersonalInfo;
import org.rmj.guanzongroup.useraccount.R;

import java.util.Objects;

public class Activity_EditAccountDetails extends AppCompatActivity {
    private static Activity_EditAccountDetails instance;
    private Toolbar toolbar;
    private ViewPager2 viewPager;
    private Dialog_DoubleButton poDialogx;
    private int index;
    private Fragment[] poPages = new Fragment[] {
            new Fragment_EditPersonalInfo(),
            new Fragment_EditAddress(),
            new Fragment_EditAccountInfo()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_acount_details);

        instance = Activity_EditAccountDetails.this;
        index = getIntent().getIntExtra("index", 0);

        initViews();
        setUpToolbar();
        moveToPageNumber(index);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            popUpCloseConfirmationDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        popUpCloseConfirmationDialog();
    }

    public static Activity_EditAccountDetails getInstance() {
        return instance;
    }

    // Initialize this first before anything else.
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewpager_signup);
        poDialogx = new Dialog_DoubleButton(Activity_EditAccountDetails.this);

        FragmentAdapter loAdapter = new FragmentAdapter(getSupportFragmentManager(), getLifecycle());
        loAdapter.initFragments(poPages);

        viewPager.setAdapter(loAdapter);
    }

    // Initialize initViews() before this method.
    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Account Details");
    }
    public void moveToPageNumber(int fnPageNum){
        viewPager.setCurrentItem(fnPageNum);
    }
    private void popUpCloseConfirmationDialog() {
        poDialogx.setButtonText("Yes", "No");
        poDialogx.initDialog("Edit Account Details", "Are you sure you want to cancel editing?", new Dialog_DoubleButton.OnDialogConfirmation() {
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
        poDialogx.show();
    }

}