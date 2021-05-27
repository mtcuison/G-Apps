package org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.rmj.androidprojects.guanzongroup.g3logindriver.Activity_CreateAccount;
import org.rmj.androidprojects.guanzongroup.g3logindriver.Activity_Login;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_AppBrowser;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_NewsEvents;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.SalePromotions;
import org.rmj.guanzongroup.guanzonapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_NewsFeed extends Fragment {
    private static final String TAG = Fragment_NewsFeed.class.getSimpleName();

    private View view;

    public Fragment_NewsFeed() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_news_feed, container, false);
        setupWidgets();
        return view;
    }

    private void setupWidgets(){
        MaterialButton btnLogin = view.findViewById(R.id.btn_fragment_intro_login);
        MaterialButton btnRegister = view.findViewById(R.id.btn_fragment_intro_register);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_newsFeed);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Activity_Login.class));
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Activity_CreateAccount.class));
            }
        });

        Adapter_NewsEvents adapter = new Adapter_NewsEvents(new SalePromotions(getActivity()).getEventList(), new Adapter_NewsEvents.OnEventItemClickListener() {
            @Override
            public void OnClick(String TransNox, String Url) {
                Intent loIntent = new Intent(getActivity(), Activity_AppBrowser.class);
                loIntent.putExtra("url_link", Url);
                getActivity().startActivity(loIntent);
                new SalePromotions(getActivity()).UpdateReadPromo(TransNox);
            }
        });
        LinearLayoutManager lm = new LinearLayoutManager(getActivity());
        lm.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(adapter);
    }
}
