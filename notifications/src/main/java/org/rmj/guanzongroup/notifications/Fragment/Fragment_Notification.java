package org.rmj.guanzongroup.notifications.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.rmj.guanzongroup.notifications.R;


public class Fragment_Notification extends Fragment {
    public static Fragment_Notification newInstance() {
        return new Fragment_Notification();
    }

    public Fragment_Notification() {
    }

//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment__notification, container, false);
//
//
//        return view;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__notification, container, false);
        return view;
    }
}