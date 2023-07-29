package org.rmj.guanzongroup.guanzonconnect.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.rmj.g3appdriver.dev.Database.DataAccessObject.DProduct;
import org.rmj.guanzongroup.guanzonconnect.R;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ProductList;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ProductOverview;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_Categories;
import org.rmj.g3appdriver.lib.Promotions.Adapter_ImageSlider;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductList;
import org.rmj.g3appdriver.lib.Promotions.model.HomeImageSliderModel;
import org.rmj.guanzongroup.marketplace.ViewModel.VMHome;

import java.util.ArrayList;
import java.util.List;

public class Fragment_Home extends Fragment {
    private static final String TAG = Fragment_Home.class.getSimpleName();

    private VMHome mViewModel;
    private Adapter_ProductList poAdapter;
    private RecyclerView poRvProds, poRvCateg;
    private SliderView poSliderx;
    private final List<DProduct.oProduct> poList = new ArrayList<>();

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
        mViewModel.GetBrandNames().observe(getViewLifecycleOwner(), strings -> {
            try {
                final Adapter_Categories loAdapter = new Adapter_Categories(strings, args -> {
                    Intent loIntent = new Intent(requireActivity(), Activity_ProductList.class);
                    loIntent.putExtra("xBrandNme", args);
                    startActivity(loIntent);
                });
                loAdapter.notifyDataSetChanged();
                poRvCateg.setAdapter(loAdapter);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    private void setProductAdapter() {
        mViewModel.getProductList(0).observe(getViewLifecycleOwner(), products -> {
            try {
                if(products.size() > 0) {
                    poList.clear();
                    poList.addAll(products);
                    poAdapter = new Adapter_ProductList(poList, listingId -> {
                        Intent loIntent = new Intent(requireActivity(), Activity_ProductOverview.class);
                        loIntent.putExtra("sListngId", listingId);
                        Log.d(TAG, "Passed parameter: " + listingId);
                        startActivity(loIntent);
                    });
                    poRvProds.setAdapter(poAdapter);
                    poAdapter.notifyDataSetChanged();
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });

        poRvProds.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager layoutManager = LinearLayoutManager.class.cast(recyclerView.getLayoutManager());
                int totalItemCount = layoutManager.getItemCount();
                int lastVisible = layoutManager.findLastVisibleItemPosition();

                boolean endHasBeenReached = lastVisible + 5 >= totalItemCount;
                if (totalItemCount > 0 && endHasBeenReached) {
                    mViewModel.getProductList(totalItemCount).observe(getViewLifecycleOwner(), products -> {
                        try {
                            if(products.size() > 0) {
                                poList.addAll(products);
                                poAdapter.notifyDataSetChanged();
                                Log.d(TAG, "New items added");
                            }
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        });
    }

    private void setSliderImages() {
        List<HomeImageSliderModel> loSliders = new ArrayList<>();
        mViewModel.GetPromoLinkList().observe(getViewLifecycleOwner(), ePromos -> {
            try {
                for (int x = 0; x < ePromos.size(); x++) {
                    loSliders.add(new HomeImageSliderModel(ePromos.get(x).getImageSld()));
                }

                Adapter_ImageSlider adapter = new Adapter_ImageSlider(loSliders, args -> {
                    try{
                        Intent intent = new Intent("android.intent.action.SUCCESS_LOGIN");
                        intent.putExtra("url_link", ePromos.get(args).getPromoUrl());
                        intent.putExtra("browser_args", "1");
                        intent.putExtra("args", "promo");
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