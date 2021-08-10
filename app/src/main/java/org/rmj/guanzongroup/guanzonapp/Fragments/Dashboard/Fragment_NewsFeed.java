package org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.rmj.androidprojects.guanzongroup.g3logindriver.Activity_CreateAccount;
import org.rmj.androidprojects.guanzongroup.g3logindriver.Login.Activity_Login;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_AppBrowser;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_LoadScreen;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_SplashScreen;
import org.rmj.guanzongroup.guanzonapp.Activities.MainActivity;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_NewsEvents;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMDashboard;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMMainActivity;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMNewsFeed;

import static android.app.Activity.RESULT_OK;
import static org.rmj.g3appdriver.etc.AppConstants.ACCOUNT_REQUEST_CODE;
import static org.rmj.g3appdriver.etc.AppConstants.LOGIN_ACTIVITY_REQUEST_CODE;
import static org.rmj.guanzongroup.guanzonapp.Activities.MainActivity.tabBadge;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_NewsFeed extends Fragment {

    private View view;
    private VMDashboard mViewModel;
    private Adapter_NewsEvents adapter;
    private RecyclerView recyclerView;
    private  MaterialButton btnLogin,btnRegister;

    private int total;
    private int promo;
    private int event;
    public static Fragment_NewsFeed newInstance() {
        return new Fragment_NewsFeed();
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news_feed, container, false);
        setupWidgets(view);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VMDashboard.class);
        getActivity().setTitle("Dashboard");
        mViewModel.getPromoCount().observe(getViewLifecycleOwner(), promo_count->{
            promo = promo_count;
        });
        mViewModel.getEventsCount().observe(getViewLifecycleOwner(), event_count->{
            event = event_count;
            total = event + promo;
            tabBadge.setNumber(total);
            tabBadge.setVisible(total > 0);
            Log.e("Total", "Total = " + total);
        });
//        mViewModel.getAllEvents().observe(getViewLifecycleOwner(), eEvents -> {
//             adapter = new Adapter_NewsEvents(eEvents, new Adapter_NewsEvents.OnEventItemClickListener() {
//                @Override
//                public void OnClick(String TransNox, String Url) {
//                    Intent loIntent = new Intent(getActivity(), Activity_AppBrowser.class);
//                    loIntent.putExtra("url_link", Url);
//                    getActivity().startActivity(loIntent);
////                    new SalePromotions(getActivity()).UpdateReadPromo(TransNox);
//                }
//            });
//            LinearLayoutManager lm = new LinearLayoutManager(getActivity());
//            lm.setOrientation(RecyclerView.VERTICAL);
//            recyclerView.setLayoutManager(lm);
//            recyclerView.setAdapter(adapter);
//        });
    }
    private void setupWidgets(View v) {
        btnLogin = view.findViewById(R.id.btn_fragment_intro_login);
        btnRegister = view.findViewById(R.id.btn_fragment_intro_register);
        recyclerView = view.findViewById(R.id.recycler_view_newsFeed);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startActivityForResult(new Intent(getActivity(), Activity_Login.class),AppConstants.LOGIN_ACTIVITY_REQUEST_CODE);

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Activity_CreateAccount.class));
            }
        });
    }


}
