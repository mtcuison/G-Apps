package org.rmj.guanzongroup.promotions.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.guanzongroup.promotions.R;
import org.rmj.guanzongroup.promotions.ViewModel.VMPromotions;

public class Fragment_Promotions extends Fragment {

    private VMPromotions mViewModel;

    public static Fragment_Promotions newInstance() {
        return new Fragment_Promotions();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(VMPromotions.class);
        return inflater.inflate(R.layout.fragment_promotions, container, false);
    }

}