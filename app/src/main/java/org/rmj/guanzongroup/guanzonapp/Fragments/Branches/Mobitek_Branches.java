package org.rmj.guanzongroup.guanzonapp.Fragments.Branches;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import org.rmj.guanzongroup.guanzonapp.R;

public class Mobitek_Branches extends Fragment {

    private View view;

    public Mobitek_Branches(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_branch_mobitek, container, false);

        return view;
    }

}
