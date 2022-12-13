package org.rmj.guanzongroup.panalo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

import org.rmj.g3appdriver.etc.FragmentAdapter;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.digitalgcard.Activity.Activity_QrCodeScanner;
import org.rmj.guanzongroup.digitalgcard.Dialogs.Dialog_TransactionPIN;
import org.rmj.guanzongroup.digitalgcard.Fragment.Fragment_MyGcard;
import org.rmj.guanzongroup.panalo.R;
import org.rmj.guanzongroup.panalo.ViewModel.VMPanaloDashboard;

public class Fragment_PanaloDashboard extends Fragment {
    private static final String TAG = Fragment_PanaloDashboard.class.getSimpleName();

    private VMPanaloDashboard mViewModel;
    private View view;
    private BottomNavigationView botNav;
    private ViewPager viewPager;
    private FloatingActionButton fab_Scan;

    private static final int GCARD_APPLICATION = 1;

    private Dialog_Loading poLoading;
    private Dialog_SingleButton poDialog;

    private final ActivityResultLauncher<Intent> poArl = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == GCARD_APPLICATION) {
                    Intent loIntent = result.getData();
                    if (loIntent != null) {
                        String lsArgs = loIntent.getStringExtra("args");
                        ParseQrCode(lsArgs);
                    } else {
                        Toast.makeText(requireActivity(), "No data result receive.", Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    public static Fragment_PanaloDashboard newInstance() {
        return new Fragment_PanaloDashboard();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMPanaloDashboard.class);
        poLoading = new Dialog_Loading(requireActivity());
        poDialog = new Dialog_SingleButton(requireActivity());
        view = inflater.inflate(R.layout.fragment_panalo_dashboard, container, false);
        initViews();

        setupPages();
        botNav.setBackground(null);
        botNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.nav_home) {
                    viewPager.setCurrentItem(0);
                    Log.d(TAG, "Home Selected.");
                } else if(item.getItemId() == R.id.nav_MyGcard){
                    viewPager.setCurrentItem(1);
                    Log.d(TAG, "My G-Card Selected.");
                } else if(item.getItemId() == R.id.nav_Panalo) {
                    viewPager.setCurrentItem(2);
                    Log.d(TAG, "Guanzon Panalo Selected.");
                } else if(item.getItemId() == R.id.nav_rewards) {
                    viewPager.setCurrentItem(3);
                    Log.d(TAG, "Panalo Rewards Selected.");
                }
                return true;
            }
        });

        fab_Scan.setOnClickListener(v -> {
            Intent loIntent = new Intent(requireActivity(), Activity_QrCodeScanner.class);
            poArl.launch(loIntent);
        });
        return view;
    }


    private void initViews() {
        viewPager = view.findViewById(R.id.viewpager);
        botNav = view.findViewById(R.id.bottom_navigation);
        fab_Scan = view.findViewById(R.id.fab_Scan);
    }

    private void setupPages(){
        Fragment[] loFragments = new Fragment[]{new Fragment_Panalo(), new Fragment_MyGcard(), new Fragment_PanaloRewards()};
        FragmentAdapter loAdapter = new FragmentAdapter(getChildFragmentManager(), loFragments);
        viewPager.setAdapter(loAdapter);
    }

    public void ParseQrCode(String fsVal){
        mViewModel.ParseQrCode(fsVal, new GCardSystem.ParseQrCodeCallback() {
            @Override
            public void ApplicationResult(String args) {
                AddGcard(args);
            }

            @Override
            public void TransactionResult(String args) {
                Dialog_TransactionPIN loDialog = new Dialog_TransactionPIN(requireActivity());
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
        mViewModel.AddNewGCard(fsVal, new VMPanaloDashboard.OnActionCallback() {
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
}