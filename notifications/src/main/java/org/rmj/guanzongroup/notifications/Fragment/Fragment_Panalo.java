package org.rmj.guanzongroup.notifications.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.notifications.Activity.Activity_Browser;
import org.rmj.guanzongroup.notifications.Activity.Activity_GuanzonPanalo;
import org.rmj.guanzongroup.notifications.Activity.Activity_NotificationList;
import org.rmj.guanzongroup.notifications.Activity.Activity_PreviewMessage;
import org.rmj.guanzongroup.notifications.Activity.Activity_ViewNotification;
import org.rmj.guanzongroup.notifications.Adapter.Adapter_EventsPromos;
import org.rmj.guanzongroup.notifications.Adapter.Adapter_Notifications;
import org.rmj.guanzongroup.notifications.Adapter.Adapter_RegularMessage;
import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMEventsPromos;
import org.rmj.guanzongroup.notifications.ViewModel.VMNotifications;

public class Fragment_Panalo extends Fragment {
    private VMNotifications mViewModel;
    private RecyclerView recyclerView;
    private ConstraintLayout ln_empty;

    private Adapter_RegularMessage adapter;
    private Adapter_Notifications adapters;
    public static Fragment_Panalo newInstance() {
        return new Fragment_Panalo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__panalo, container, false);
        mViewModel = new ViewModelProvider(getActivity()).get(VMNotifications.class);
        recyclerView = view.findViewById(R.id.recycler_view_notifications);
        ln_empty = view.findViewById(R.id.ln_empty);
        LinearLayoutManager loManager = new LinearLayoutManager(requireActivity());
        loManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(loManager);
        recyclerView.setHasFixedSize(true);
        mViewModel.GetPanaloRegularMessagesSystemNotif().observe(getActivity(), notif -> {
            if (notif.size() > 0) {
                ln_empty.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                adapters = new Adapter_Notifications(notif, (fsMesgIDxx, lsCreated, fsMesgType, lsDataSent) -> {
                    Log.e("sMsgIDxxx", fsMesgIDxx);
                    if (!fsMesgType.equalsIgnoreCase("00000")) {
                        Intent loIntent = new Intent(getActivity(), Activity_ViewNotification.class);
                        loIntent.putExtra("sMsgIDxxx", fsMesgIDxx);
                        loIntent.putExtra("sMsgTypex", fsMesgType);
                        loIntent.putExtra("sDataSent", lsDataSent);
                        startActivity(loIntent);
                    } else {
                        Intent loIntent = new Intent(getActivity(), Activity_PreviewMessage.class);
                        loIntent.putExtra("sCreatedx", lsCreated);
                        startActivity(loIntent);
                    }
                });

//                adapter = new Adapter_RegularMessage(notif);

                recyclerView.setAdapter(adapters);
                adapters.notifyDataSetChanged();
            } else {
                ln_empty.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.GONE);
            }
        });
        return view;
    }
}