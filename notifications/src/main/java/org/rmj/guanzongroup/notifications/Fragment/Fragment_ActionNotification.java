package org.rmj.guanzongroup.notifications.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.guanzongroup.notifications.R;
import org.rmj.guanzongroup.notifications.ViewModel.VMViewNotification;

public class Fragment_ActionNotification extends Fragment {

    private VMViewNotification mViewModel;

    public static Fragment_ActionNotification newInstance() {
        return new Fragment_ActionNotification();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(VMViewNotification.class);
        View loView = inflater.inflate(R.layout.fragment_action_notification, container, false);


        return loView;
    }
}