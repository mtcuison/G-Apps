package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import org.rmj.g3appdriver.etc.FragmentAdapter;
import org.rmj.g3appdriver.etc.NonSwipeableViewPager;
import org.rmj.guanzongroup.useraccount.Adapter.Adapter_AccountDetails;
import org.rmj.guanzongroup.useraccount.Fragment.Fragment_AccountDetailsList;
import org.rmj.guanzongroup.useraccount.Fragment.Fragment_EditAccountInfo;
import org.rmj.guanzongroup.useraccount.Fragment.Fragment_EditAddress;
import org.rmj.guanzongroup.useraccount.Fragment.Fragment_EditPersonalInfo;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountDetails;

import java.util.Objects;
import org.rmj.guanzongroup.useraccount.R;


public class Activity_AccountDetails extends AppCompatActivity {
    private static final String TAG = Activity_AccountDetails.class.getSimpleName();
    private static Activity_AccountDetails instance;
    private VMAccountDetails mViewModel;
    private Toolbar toolbar;
    private NonSwipeableViewPager viewPager;

    private Fragment[] poPages = new Fragment[] {
            new Fragment_AccountDetailsList(),
            new Fragment_EditPersonalInfo(),
            new Fragment_EditAddress(),
            new Fragment_EditAccountInfo()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        instance = Activity_AccountDetails.this;
        mViewModel = new ViewModelProvider(Activity_AccountDetails.this)
                .get(VMAccountDetails.class);

        initViews();
        setUpToolbar();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public static Activity_AccountDetails getInstance() {
        return instance;
    }

    // Initialize this first before anything else.
    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        viewPager = findViewById(R.id.viewpager_signup);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), poPages));
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

}