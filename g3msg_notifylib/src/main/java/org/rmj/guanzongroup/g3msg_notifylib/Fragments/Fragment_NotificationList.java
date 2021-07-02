package org.rmj.guanzongroup.g3msg_notifylib.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.etc.GToast;
import org.rmj.guanzongroup.g3msg_notifylib.Activities.Activity_MessageView;
import org.rmj.guanzongroup.g3msg_notifylib.Adapter.g3NotificationAdapter;
import org.rmj.guanzongroup.g3msg_notifylib.Model.NotificationMessageModel;
import org.rmj.guanzongroup.g3msg_notifylib.R;
import org.rmj.guanzongroup.g3msg_notifylib.ViewModel.VMNotificationList;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_NotificationList extends Fragment {
    private static final String TAG = Fragment_NotificationList.class.getSimpleName();
    private static Fragment_NotificationList instance;
    private View view;
    private VMNotificationList mViewModel;
    private RecyclerView recyclerView;
    public static Fragment_NotificationList newInstance(){
        return new Fragment_NotificationList();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_notification_list, container, false);

        initWidgets();
        mViewModel = ViewModelProviders.of(this).get(VMNotificationList.class);
        mViewModel.getUserNotificationList().observe(getViewLifecycleOwner(), userNotificationInfos -> {
            List<NotificationMessageModel> notificationItemLists = new ArrayList<>();
            notificationItemLists.clear();
            for (int x = 0; x < userNotificationInfos.size(); x++) {
                notificationItemLists.add(new NotificationMessageModel(
                        userNotificationInfos.get(x).MesgIDxx,
                        userNotificationInfos.get(x).MsgTitle,
                        userNotificationInfos.get(x).CreatrNm,
                        userNotificationInfos.get(x).Messagex,
                        userNotificationInfos.get(x).Received,
                        userNotificationInfos.get(x).Received));
            }
            LinearLayoutManager manager = new LinearLayoutManager(getActivity());
            manager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(manager);
            g3NotificationAdapter loAdapter = new g3NotificationAdapter(notificationItemLists);
            recyclerView.setAdapter(loAdapter);
            loAdapter.setOnNotificationClickListener(new g3NotificationAdapter.OnNotificationClickListener() {
                @Override
                public void OnClick(int position, boolean isRead) {
                    try {
                        Intent intent = new Intent(getActivity(), Activity_MessageView.class);
                        intent.putExtra("notification", notificationItemLists.get(position));
                        startActivity(intent);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        });
        return view;
    }

    private void initWidgets(){
        recyclerView = view.findViewById(R.id.recyclerview_notificationList);

    }



}
