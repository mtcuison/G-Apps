package org.rmj.guanzongroup.marketplace.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_Promo;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_QRCode;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ProductOverview;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_Categories;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ImageSlider;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductList;
import org.rmj.guanzongroup.marketplace.Model.HomeImageSliderModel;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMHome;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Fragment_Home extends Fragment {

    private VMHome mViewModel;
    private Adapter_ProductList poAdapter;
    private RecyclerView poRvProds, poRvCateg;
    private SliderView poSliderx;
    private CardView gcardPane;
    private TextView txtCardNo, txtGcrdPt;

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

        gcardPane = v.findViewById(R.id.gCard_panel);
        txtCardNo = v.findViewById(R.id.txt_card_number);
        txtGcrdPt = v.findViewById(R.id.txt_gcard_points);
        poRvProds = v.findViewById(R.id.rv_products);
        poRvCateg = v.findViewById(R.id.rv_categories);
        poRvProds.setLayoutManager(new GridLayoutManager(requireActivity(),
                2, RecyclerView.VERTICAL, false));
        poRvCateg.setLayoutManager(new LinearLayoutManager(requireActivity()));
        poRvProds.setHasFixedSize(true);
        poRvCateg.setHasFixedSize(true);
    }

    private void displayData() {
        showPromoDialog();
        setImageSlider();
        initGcardPanel();
        setCategoryAdapter();
        setProductAdapter();
    }

    private void showPromoDialog() {
        boolean isThereAnActivePromo = true;
        if(isThereAnActivePromo) {
            String sampleUrl = "https://scontent.fmnl9-3.fna.fbcdn.net/v/t39.30808-6/282387720_5403740322981545_1108881974112682037_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=730e14&_nc_eui2=AeEvu2TqVptylKnLQCLZJsRtSxQVxHxfyshLFBXEfF_KyEAKctHKcbuaNcazD-nb2MAP_y_8m_GYvWx_bhlvEfaj&_nc_ohc=Qq0Ju_q0W9AAX-lGGig&_nc_ht=scontent.fmnl9-3.fna&oh=00_AT8ef2TtqoNkTcSEWKKEQqwEwtelUX0xorokm2XyAP7snA&oe=62A98FB0";
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

    private void initGcardPanel() {
        mViewModel.getActiveGcard().observe(getViewLifecycleOwner(), eGcardApp -> {
            try {
                if(eGcardApp == null) {
                    gcardPane.setVisibility(View.GONE);
                } else {
                    gcardPane.setVisibility(View.VISIBLE);
                    txtCardNo.setText(Objects.requireNonNull(eGcardApp.getCardNmbr()));
                    txtGcrdPt.setText(Objects.requireNonNull(eGcardApp.getAvlPoint()));

                    gcardPane.setOnClickListener(view -> mViewModel.ViewGCardQrCode(foVal -> {
                        //TODO : Create Dialog that will iew QrCode
                        if(foVal == null){
                            Toast.makeText(requireActivity(), "Failed generating Qr-Code", Toast.LENGTH_SHORT).show();
                        } else {

                            Dialog_QRCode dialog_qrCode = new Dialog_QRCode(requireActivity());
                            dialog_qrCode.initDialog("GCard QR Code", foVal, new Dialog_QRCode.QrCodeCallback() {
                                @Override
                                public void onRefresh(AlertDialog foDialogx) {

                                }
                            });
                            dialog_qrCode.show();
                        }
                    }));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void setCategoryAdapter() {
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.ic_img_am);
        list.add(R.drawable.ic_img_ap);
        list.add(R.drawable.ic_img_mc);
        list.add(R.drawable.ic_img_mp);
        final Adapter_Categories loAdapter = new Adapter_Categories(requireActivity(), list, new Adapter_Categories.OnItemClick() {
            @Override
            public void onClick(int position) {

            }
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

    private List<HomeImageSliderModel> getSliderImages() {
        List<HomeImageSliderModel> loSliders = new ArrayList<>();
        loSliders.add(new HomeImageSliderModel("https://wallpaperaccess.com/full/943013.jpg"));
        loSliders.add(new HomeImageSliderModel("https://wallpaperaccess.com/full/2752949.jpg"));
        loSliders.add(new HomeImageSliderModel("https://wallpaperboat.com/wp-content/uploads/2021/04/26/76958/2560x1080-05.jpg"));
        loSliders.add(new HomeImageSliderModel("https://wallpaperaccess.com/full/2752980.jpg"));
        loSliders.add(new HomeImageSliderModel("https://cdn.wallpapersafari.com/91/95/40FEij.jpg"));
        return loSliders;
    }

}