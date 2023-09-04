package org.rmj.guanzongroup.ganado.Fragment;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.rmj.guanzongroup.ganado.Activity.Activity_Brand_List;
import org.rmj.guanzongroup.ganado.Adapter.ModelGridAdapter;
import org.rmj.guanzongroup.ganado.R;
import org.rmj.guanzongroup.ganado.ViewModel.VMBrandSelection;

public class Fragment_Brand_Selection extends Fragment {

    private VMBrandSelection mViewModel;
    private RecyclerView poRVBrand, poRvCateg;
    public static Fragment_Brand_Selection newInstance() {
        return new Fragment_Brand_Selection();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMBrandSelection.class);
        View view = inflater.inflate(R.layout.fragment_brand_selection, container, false);
        initViews(view);
        displayData();
        return view;
    }
    private void initViews(View v) {
        poRVBrand = v.findViewById(R.id.rvBrand);
        poRVBrand.setLayoutManager(new GridLayoutManager(requireActivity(),
                2, RecyclerView.HORIZONTAL, false));
//        poRvCateg.setHasFixedSize(true);
    }
    private void displayData() {
//        setSliderImages();
//        setCategoryAdapter();
//        setProductAdapter();
    }

//    private void setCategoryAdapter() {
//        mViewModel.GetBrandNames().observe(getViewLifecycleOwner(), strings -> {
//            try {
//                final ModelGridAdapter loAdapter = new ModelGridAdapter(strings, args -> {
//                    Intent loIntent = new Intent(requireActivity(), Activity_Brand_List.class);
//                    loIntent.putExtra("xBrandNme", args);
//                    startActivity(loIntent);
//                });
//                loAdapter.notifyDataSetChanged();
//                poRvCateg.setAdapter(loAdapter);
//            } catch (Exception e){
//                e.printStackTrace();
//            }
//        });
//    }

}