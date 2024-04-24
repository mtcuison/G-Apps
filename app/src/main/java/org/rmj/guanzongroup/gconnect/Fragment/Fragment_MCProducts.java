package org.rmj.guanzongroup.gconnect.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.Entities.EMcBrand;
import org.rmj.guanzongroup.ganado.ViewModel.VMBrandList;
import org.rmj.guanzongroup.gconnect.Adapter.Adapter_MCProductImageSlider;
import org.rmj.guanzongroup.gconnect.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Fragment_MCProducts extends Fragment {
    private VMBrandList mViewModel;
    private RecyclerView img_slider;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homeproductslider, container, false);

        mViewModel = new ViewModelProvider(requireActivity()).get(VMBrandList.class);
        img_slider = view.findViewById(R.id.img_slider);

        mViewModel.getBrandList().observe(requireActivity(), new Observer<List<EMcBrand>>() {
            @Override
            public void onChanged(List<EMcBrand> eMcBrands) {
                if (eMcBrands.size() > 0) {
                    HashMap<Integer, String> logos = new HashMap<>();

                    for (int i = 0; i < eMcBrands.size(); i++) {
                        String sName = eMcBrands.get(i).getBrandNme();
                        switch (sName) {
                            case "HONDA":
                                logos.put(R.drawable.hondalogo, eMcBrands.get(i).getBrandIDx());
                                break;
                            case "SUZUKI":
                                logos.put(R.drawable.suzuki, eMcBrands.get(i).getBrandIDx());
                                break;
                            case "KAWASAKI":
                                logos.put(R.drawable.kawasakilogo, eMcBrands.get(i).getBrandIDx());
                                break;
                            case "YAMAHA":
                                logos.put(R.drawable.yamahalogo, eMcBrands.get(i).getBrandIDx());
                                break;
                        }
                    }

                    Adapter_MCProductImageSlider loAdapter = new Adapter_MCProductImageSlider(requireActivity(), logos);
                    img_slider.setLayoutManager(new LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false));
                    img_slider.setAdapter(loAdapter);
                }
            }
        });

        return view;
    }
}
