package org.rmj.guanzongroup.marketplace.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_Promo;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ProductOverview;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ImageSlider;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductList;
import org.rmj.guanzongroup.marketplace.Model.HomeImageSliderModel;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMHome;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Home extends Fragment {

    private VMHome mViewModel;
    private Adapter_ProductList poAdapter;
    private RecyclerView poRvProds ;
    private SliderView poSliderx;

    public Fragment_Home() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(requireActivity()).get(VMHome.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        displayData();
        return view;
    }

    private void initViews(View v) {
        // Image Slider Setup
        poSliderx = v.findViewById(R.id.imgSlider);
        poSliderx.setIndicatorAnimation(IndicatorAnimationType.WORM);
        poSliderx.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        poSliderx.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        poSliderx.setIndicatorSelectedColor(Color.WHITE);
        poSliderx.setIndicatorUnselectedColor(Color.GRAY);
        poSliderx.setScrollTimeInSec(5);
        poSliderx.startAutoCycle();

        poRvProds = v.findViewById(R.id.rv_products);
        poRvProds.setLayoutManager(new GridLayoutManager(requireActivity(),
                2, RecyclerView.VERTICAL, false));
        poRvProds.setHasFixedSize(true);
    }

    private void displayData() {
        showPromoDialog();
        setImageSlider();
        setProductAdapter();
    }

    private void showPromoDialog() {
        boolean isThereAnActivePromo = true;
        if(isThereAnActivePromo) {
            String sampleUrl = "http://unbox.ph/wp-content/uploads/2021/09/9.9-Lazada-Promo.jpg";
            Dialog_Promo loDialog = new Dialog_Promo(requireActivity());
            loDialog.initDialog(sampleUrl, (dialog) -> {
                // TODO: Intent to specific activity to show product/promo.
                Toast.makeText(requireActivity(), "Promo Image Clicked.", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });
            loDialog.show();
        }
    }

    private void setImageSlider() {
        Adapter_ImageSlider adapter = new Adapter_ImageSlider(requireActivity(),getSliderImages());
        poSliderx.setSliderAdapter(adapter);
    }

    private void setProductAdapter() {
        mViewModel.getProductList(0).observe(getViewLifecycleOwner(), products -> {
            try {
                if(products.size() > 0) {
                    poAdapter = new Adapter_ProductList(products, listingId -> {
                        Intent loIntent = new Intent(requireActivity(), Activity_ProductOverview.class);
                        loIntent.putExtra("sListingId", listingId);
                        startActivity(loIntent);
                    });
                    poRvProds.setAdapter(poAdapter);
                    poAdapter.notifyDataSetChanged();
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });
    }

    private List<HomeImageSliderModel> getSliderImages() {
        List<HomeImageSliderModel> loSliders = new ArrayList<>();
        loSliders.add(new HomeImageSliderModel("https://wallpaperaccess.com/full/2697937.jpg"));
        loSliders.add(new HomeImageSliderModel("https://wallpaperaccess.com/full/2697956.jpg"));
        loSliders.add(new HomeImageSliderModel("https://wallpaperaccess.com/full/2697963.jpg"));
        return loSliders;
    }

}