package org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard;


import android.content.Intent;
import android.os.Bundle;
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
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_SplashScreen;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_NewsEvents;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMNewsFeed;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_NewsFeed extends Fragment {

    private View view;
    private VMNewsFeed mViewModel;
    private Adapter_NewsEvents adapter;
    private RecyclerView recyclerView;
    private  MaterialButton btnLogin,btnRegister;

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
        mViewModel = ViewModelProviders.of(this).get(VMNewsFeed.class);
        mViewModel.getAllEvents().observe(getViewLifecycleOwner(), eEvents -> {
             adapter = new Adapter_NewsEvents(eEvents, new Adapter_NewsEvents.OnEventItemClickListener() {
                @Override
                public void OnClick(String TransNox, String Url) {
                    Intent loIntent = new Intent(getActivity(), Activity_AppBrowser.class);
                    loIntent.putExtra("url_link", Url);
                    getActivity().startActivity(loIntent);
//                    new SalePromotions(getActivity()).UpdateReadPromo(TransNox);
                }
            });
            LinearLayoutManager lm = new LinearLayoutManager(getActivity());
            lm.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(lm);
            recyclerView.setAdapter(adapter);
        });
    }
    private void setupWidgets(View v) {
        btnLogin = view.findViewById(R.id.btn_fragment_intro_login);
        btnRegister = view.findViewById(R.id.btn_fragment_intro_register);
        recyclerView = view.findViewById(R.id.recycler_view_newsFeed);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), Activity_Login.class),AppConstants.LOGIN_ACTIVITY_REQUEST_CODE);
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
