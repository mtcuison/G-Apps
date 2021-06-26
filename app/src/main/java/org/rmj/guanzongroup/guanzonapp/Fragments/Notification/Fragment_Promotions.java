package org.rmj.guanzongroup.guanzonapp.Fragments.Notification;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Promotions extends Fragment {

    private View view;

    private RecyclerView recyclerView;


    public Fragment_Promotions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_promotions, container, false);


        return view;
    }
}
