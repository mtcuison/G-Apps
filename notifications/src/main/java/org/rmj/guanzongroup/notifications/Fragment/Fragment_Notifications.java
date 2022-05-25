package org.rmj.guanzongroup.notifications.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.notifications.Activity.Activity_ViewNotification;
import org.rmj.guanzongroup.notifications.Adapter.Adapter_Notifications;
import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMNotifications;

public class Fragment_Notifications extends Fragment {
    private VMNotifications mViewModel;
    private TextView noNotif;
    private RecyclerView recyclerView;
    private Adapter_Notifications adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        initViews(view);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMNotifications.class);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));
        mViewModel.GetClientNotificationList().observe(requireActivity(), notif ->{
            if(notif.size() > 0){
                noNotif.setVisibility(View.GONE);
                adapter = new Adapter_Notifications(notif, (fsMesgIDxx, fsMesgType) -> {
                    Intent loIntent = new Intent(requireActivity(), Activity_ViewNotification.class);
                    loIntent.putExtra("sMsgIDxxx", fsMesgIDxx);
                    startActivity(loIntent);
                });
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }else{
                noNotif.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private void initViews(View v) {
        noNotif = v.findViewById(R.id.lbl_no_notifications);
        recyclerView = v.findViewById(R.id.recycler_view_notifications);
    }
}