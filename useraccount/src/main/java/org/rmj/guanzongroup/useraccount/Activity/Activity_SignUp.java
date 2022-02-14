package org.rmj.guanzongroup.useraccount.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.guanzongroup.appcore.Etc.FragmentAdapter;
import org.rmj.guanzongroup.appcore.Etc.NonSwipeableViewPager;
import org.rmj.guanzongroup.useraccount.Fragment.Fragment_SignUpInfo;
import org.rmj.guanzongroup.useraccount.Fragment.Fragment_SignUpPassword;
import org.rmj.guanzongroup.useraccount.R;
import org.rmj.guanzongroup.useraccount.ViewModel.VMAccountAuthentication;

import java.util.Objects;

public class Activity_SignUp extends AppCompatActivity {

    private VMAccountAuthentication mViewModel;
    private static Activity_SignUp instance;
    private Toolbar toolbar;
    private NonSwipeableViewPager viewPager;

    private Fragment[] poPages = new Fragment[] {
            new Fragment_SignUpInfo(),
            new Fragment_SignUpPassword()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        instance = Activity_SignUp.this;
        mViewModel = new ViewModelProvider(Activity_SignUp.this).get(VMAccountAuthentication.class);
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

    public static Activity_SignUp getInstance() {
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
        getSupportActionBar().setTitle("Sign Up");
    }

    public void moveToPageNumber(int fnPageNum){
        viewPager.setCurrentItem(fnPageNum);
    }

}