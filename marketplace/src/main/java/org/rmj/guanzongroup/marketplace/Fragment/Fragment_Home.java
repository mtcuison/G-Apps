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
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_Categories;
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
    private RecyclerView poRvProds, poRvCateg;
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

        poRvCateg = v.findViewById(R.id.rv_categories);
        poRvCateg.setLayoutManager(new GridLayoutManager(requireActivity(),
                2, RecyclerView.HORIZONTAL, false));
        poRvCateg.setHasFixedSize(true);
    }

    private void displayData() {
        setSliderImages();
        setCategoryAdapter();
        setProductAdapter();
    }

    private void setCategoryAdapter() {
        List<String> strings = new ArrayList<>();
        strings.add("https://static.zerochan.net/Venti.full.3365467.jpg");
        strings.add("https://static.zerochan.net/Enomoto.Yuiko.full.1590131.jpg");
        strings.add("https://datingroo.com/wp-content/uploads/2021/03/stop-abuse-resized.jpg");
        strings.add("https://images-stylist.s3-eu-west-1.amazonaws.com/app/uploads/2020/12/21183331/how-to-stay-calm-in-an-argument-crop-1640111653-1920x1920.jpg");
        strings.add("https://www.stylist.co.uk/images/app/uploads/2020/04/08154707/gettyimages-1171901303-1120x1120.jpg?w=1200&h=1&fit=max&auto=format%2Ccompress");
        strings.add("https://static.zerochan.net/Okumura.Rin.full.598240.jpg");
        strings.add("https://static.zerochan.net/Venti.full.3365467.jpg");
        strings.add("https://static.zerochan.net/Enomoto.Yuiko.full.1590131.jpg");
        strings.add("https://datingroo.com/wp-content/uploads/2021/03/stop-abuse-resized.jpg");
        strings.add("https://images-stylist.s3-eu-west-1.amazonaws.com/app/uploads/2020/12/21183331/how-to-stay-calm-in-an-argument-crop-1640111653-1920x1920.jpg");
        strings.add("https://www.stylist.co.uk/images/app/uploads/2020/04/08154707/gettyimages-1171901303-1120x1120.jpg?w=1200&h=1&fit=max&auto=format%2Ccompress");
        strings.add("https://static.zerochan.net/Okumura.Rin.full.598240.jpg");

        final Adapter_Categories loAdapter = new Adapter_Categories(strings, position -> {

        });
        loAdapter.notifyDataSetChanged();
        poRvCateg.setAdapter(loAdapter);
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

    private void setSliderImages() {
        List<HomeImageSliderModel> loSliders = new ArrayList<>();
        mViewModel.GetPromoLinkList().observe(getViewLifecycleOwner(), ePromos -> {
            try {
                for (int x = 0; x < ePromos.size(); x++) {
                    loSliders.add(new HomeImageSliderModel(ePromos.get(x).getImageUrl()));
                }

                Adapter_ImageSlider adapter = new Adapter_ImageSlider(loSliders, args -> {
                    try{
                        Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
                        intent.putExtra("url_link", ePromos.get(args).getPromoUrl());
                        intent.putExtra("args", "1");
                        requireActivity().sendBroadcast(intent);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                });
                poSliderx.setSliderAdapter(adapter);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}