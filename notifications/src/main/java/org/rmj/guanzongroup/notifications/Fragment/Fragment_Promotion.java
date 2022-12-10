package org.rmj.guanzongroup.notifications.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.rmj.guanzongroup.notifications.R;

public class Fragment_Promotion extends Fragment {
    public static Fragment_Promotion newInstance() {
        return new Fragment_Promotion();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__promotion, container, false);
        return view;
    }
}