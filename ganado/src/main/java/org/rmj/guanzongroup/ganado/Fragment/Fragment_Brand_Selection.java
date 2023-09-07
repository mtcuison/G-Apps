package org.rmj.guanzongroup.ganado.Fragment;

import static android.content.Intent.getIntent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.g3appdriver.dev.Database.Entities.EMcBrand;
import org.rmj.guanzongroup.ganado.Activity.Activity_Brand_List;
import org.rmj.guanzongroup.ganado.Adapter.ModelGridAdapter;
import org.rmj.guanzongroup.ganado.Adapter.RecyclerViewAdapter_BrandSelection;
import org.rmj.guanzongroup.ganado.R;
import org.rmj.guanzongroup.ganado.ViewModel.VMBrandList;
import org.rmj.guanzongroup.ganado.ViewModel.VMBrandSelection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fragment_Brand_Selection extends Fragment {
    private VMBrandList mViewModel;
    private RecyclerView rvc_brandlist;
    private View view;
    private ShapeableImageView brandcatimg;
    private RecyclerViewAdapter_BrandSelection rec_brandList;
    public static Fragment_Brand_Selection newInstance() {
        return new Fragment_Brand_Selection();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_brand_selection, container, false);
        intWidgets(view);
        mViewModel = new ViewModelProvider(this).get(VMBrandList.class);
        mViewModel.importCriteria();


        brandcatimg = view.findViewById(R.id.imagebrandtop);

        mViewModel.getBrandList().observe(requireActivity(), brandList -> {
            if (brandList.size() > 0) {
                rec_brandList = new RecyclerViewAdapter_BrandSelection(brandList, new RecyclerViewAdapter_BrandSelection.OnBrandSelectListener() {
                    @Override
                    public void OnSelect(String BrandID, String BrandName) {
//                        Intent intent = new Intent(Activity_BrandSelection.this, Activity_ProductSelection.class);
//                        intent.putExtra("lsBrandID", BrandID);
//                        intent.putExtra("lsBrandNm", BrandName);
//                        startActivity(intent);
//                        overridePendingTransition(R.anim.anim_intent_slide_in_right, R.anim.anim_intent_slide_out_left);
                    }
                });

                rvc_brandlist.setAdapter(rec_brandList);
                rvc_brandlist.setLayoutManager(new GridLayoutManager(requireActivity(), 2, RecyclerView.VERTICAL, false));

                rec_brandList.notifyDataSetChanged();
            }
        });

        return view;
    }
    private void intWidgets(View v) {
        rvc_brandlist = v.findViewById(R.id.rv_brands);

    }

}