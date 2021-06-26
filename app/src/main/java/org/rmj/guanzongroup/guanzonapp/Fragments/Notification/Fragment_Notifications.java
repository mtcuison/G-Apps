package org.rmj.guanzongroup.guanzonapp.Fragments.Notification;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.rmj.guanzongroup.guanzonapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Notifications extends Fragment {
    private static Fragment_Notifications instance;
    private View view;
    public Fragment_Notifications() {
        // Required empty public constructor
    }

    public static Fragment_Notifications getInstance(){
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dashboard_tab_notifications, container, false);

        return view;
    }

}
