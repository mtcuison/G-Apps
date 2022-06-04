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

public class Fragment_ProductInquiry extends Fragment {

    private VMProductInquiry mViewModel;

    public static Fragment_ProductInquiry newInstance() {
        return new Fragment_ProductInquiry();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(VMProductInquiry.class);
        View loView = inflater.inflate(R.layout.fragment_product_inquiry, container, false);

        return loView;
    }
}