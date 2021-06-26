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
public class Fragment_Events extends Fragment {
    private static final String TAG = Fragment_Events.class.getSimpleName();
    private static Fragment_Events instance;

    private View view;

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

        return view;
    }


}
