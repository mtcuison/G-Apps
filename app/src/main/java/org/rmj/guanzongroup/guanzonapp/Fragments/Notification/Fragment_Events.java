package org.rmj.guanzongroup.guanzonapp.Fragments.Notification;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.Activities.Activity_AppBrowser;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_NewsEvents;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMNewsFeed;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Events extends Fragment {
    private static final String TAG = Fragment_Events.class.getSimpleName();
    private static Fragment_Events instance;

    private View view;
    private VMNewsFeed mViewModel;

    public Fragment_Events() {
        // Required empty public constructor
    }

    private Fragment_Events getInstance(){
        if(instance == null){
            instance = this;
        }
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_events, container, false);
        mViewModel = ViewModelProviders.of(this).get(VMNewsFeed.class);
        setupWidgets();
        return view;
    }
    private void setupWidgets(){
        MaterialButton btnLogin = view.findViewById(R.id.btn_fragment_intro_login);
        MaterialButton btnRegister = view.findViewById(R.id.btn_fragment_intro_register);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_newsFeed);
        mViewModel.getAllEvents().observe(getViewLifecycleOwner(), list ->{
            Log.e(TAG, list.toString());
            Adapter_NewsEvents adapter = new Adapter_NewsEvents(list, new Adapter_NewsEvents.OnEventItemClickListener() {
                @Override
                public void OnClick(String TransNox, String Url) {
                    Intent loIntent = new Intent(getActivity(), Activity_AppBrowser.class);
                    loIntent.putExtra("url_link", Url);
                    getActivity().startActivity(loIntent);
                    mViewModel.updateReadEvent(TransNox);
//                    new SalePromotions(getActivity()).UpdateReadEvent(TransNox);
//                    new Fragment_Notifications().getInstance().refreshBadges();
//                    new Activity_DashBoard().getInstance().refreshTabBadge();
                }
            });
            LinearLayoutManager lm = new LinearLayoutManager(getActivity());
            lm.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(lm);
            recyclerView.setAdapter(adapter);
        });
    }


}
