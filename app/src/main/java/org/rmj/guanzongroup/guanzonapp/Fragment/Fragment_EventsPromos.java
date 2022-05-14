package org.rmj.guanzongroup.guanzonapp.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.rmj.guanzongroup.guanzonapp.Activity.Activity_Browser;
import org.rmj.guanzongroup.guanzonapp.Adapter.Adapter_BranchList;
import org.rmj.guanzongroup.guanzonapp.Adapter.Adapter_EventsPromos;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMEventsPromos;

public class Fragment_EventsPromos extends Fragment {

    private VMEventsPromos mViewModel;
    private RecyclerView eventsPromoView;
    private Adapter_EventsPromos poAdapter;
    public static Fragment_EventsPromos newInstance() {
        return new Fragment_EventsPromos();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events_promos, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMEventsPromos.class);
        // TODO: Use the ViewModel
        if(getArguments().get("gcardInstance").toString().equalsIgnoreCase("1")){
            mViewModel.DownloadPromos();
            mViewModel.getPromos().observe(getViewLifecycleOwner(), promos -> {
                poAdapter = new Adapter_EventsPromos(requireActivity(), new Adapter_EventsPromos.OnEventPromoClickListener() {
                    @Override
                    public void OnClick(String url, String args) {
                        Intent intent = new Intent(getActivity(), Activity_Browser.class);
                        intent.putExtra("url_link", url);
                        intent.putExtra("args", args);
                        startActivity(intent);
                    }
                },promos, "1");
                eventsPromoView.setAdapter(poAdapter);
                poAdapter.notifyDataSetChanged();
            });
        } else {
            mViewModel.DownloadEvents();
            mViewModel.getEvents().observe(getViewLifecycleOwner(), events -> {
                poAdapter = new Adapter_EventsPromos(requireActivity(),events, new Adapter_EventsPromos.OnEventPromoClickListener() {
                    @Override
                    public void OnClick(String url, String args) {
//                        Toast.makeText(requireActivity(), args, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Activity_Browser.class);
                        intent.putExtra("url_link", url);
                        intent.putExtra("args", args);
                        startActivity(intent);
                    }
                },"2");
                eventsPromoView.setAdapter(poAdapter);
                poAdapter.notifyDataSetChanged();
            });
        }
    }
    void initViews(View v){
        eventsPromoView = v.findViewById(R.id.recycler_view_EventsPromo);
        LinearLayoutManager loManager = new LinearLayoutManager(requireActivity());
        loManager.setOrientation(RecyclerView.VERTICAL);
        eventsPromoView.setLayoutManager(loManager);
        eventsPromoView.setHasFixedSize(true);
    }
}