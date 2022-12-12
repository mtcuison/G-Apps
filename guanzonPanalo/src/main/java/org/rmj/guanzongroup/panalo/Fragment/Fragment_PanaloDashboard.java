package org.rmj.guanzongroup.panalo.Fragment;

import android.content.Intent;
import android.os.Bundle;
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

    private VMPanaloDashboard mViewModel;
    private View view;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private LinearLayout layout_GCard, layout_GPanalo, layout_GGanado;
    private TextView txt_GCardNo, txt_GCardNm, txt_GCardPnt;
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

        viewPager.setAdapter(new PanaloFragmentAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        fab_Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loIntent = new Intent(requireActivity(), Activity_QrCodeScanner.class);
                poArl.launch(loIntent);
            }
        });
        return view;
    }


    private void initViews() {
        txt_GCardNo = view.findViewById(R.id.txt_GcardNumber);
        txt_GCardNm = view.findViewById(R.id.txt_GcardName);
        txt_GCardPnt = view.findViewById(R.id.txt_GcardPoints);
        viewPager = view.findViewById(R.id.viewpager);
        tabLayout = view.findViewById(R.id.tab_layout);

        fab_Scan = view.findViewById(R.id.fab_Scan);
    }

    private static class PanaloFragmentAdapter extends FragmentStatePagerAdapter{

        private final Fragment[] loFragments = new Fragment[]{new Fragment_MyGcard(), new Fragment_Panalo(), new Fragment_PanaloRewards()};
        private final String[] lsTitles = new String[]{"My GCard", "Panalo", "Rewards"};

        public PanaloFragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return loFragments[position];
        }

        @Override
        public int getCount() {
            return loFragments.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return lsTitles[position];
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