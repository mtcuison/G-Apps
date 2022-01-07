package org.rmj.guanzongroup.digitalgcard.Fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMMyGcardBaseContainer;

public class Fragment_MyGcardBaseContainer extends Fragment {

    private VMMyGcardBaseContainer mViewModel;

    public static Fragment_MyGcardBaseContainer newInstance() {
        return new Fragment_MyGcardBaseContainer();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_gcard_base_container, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMMyGcardBaseContainer.class);
        // TODO: Use the ViewModel
        if(getArguments() != null){
            int lnArgs = getArguments().getInt("gcardInstance");
            if(lnArgs == 1){

            } else if(lnArgs == 2){

            }
        }
    }

}