package org.rmj.guanzongroup.guanzonapp.Fragments.Branches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.rmj.guanzongroup.guanzonapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Branches extends Fragment {



    public Fragment_Branches() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =  inflater.inflate(R.layout.fragment_dashboard_tab_branches, container, false);

        return view;
    }


}
