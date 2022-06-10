package org.rmj.guanzongroup.marketplace.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
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

import org.rmj.g3appdriver.utils.Dialogs.Dialog_QRCode;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ProductOverview;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_HomeImageSlider;
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(requireActivity()).get(VMHome.class);
        displayData();
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
        setImageSlider();
        initGcardPanel();
        setCategoryAdapter();
        setProductAdapter();
    }

    private void setImageSlider() {
        Adapter_HomeImageSlider adapter = new Adapter_HomeImageSlider(requireActivity(),getSliderImages());
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
        loSliders.add(new HomeImageSliderModel("https://q6h9q4e8.rocketcdn.me/wp-content/uploads/2021/09/EDX_Blog-Headers_v18-1080x150.png"));
        loSliders.add(new HomeImageSliderModel("data:image/jpeg;base64,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"));
        loSliders.add(new HomeImageSliderModel("https://www.vwbpe.org/wp-content/uploads/immersive-exp-hdr-1080x150.png"));
        loSliders.add(new HomeImageSliderModel("https://makingspiritsbright.com/wp-content/uploads/2015/09/Making-Spirits-Bright-Header-1080x150-no-MSB.jpg"));
        loSliders.add(new HomeImageSliderModel("https://horrortree.com/wp-content/uploads/2015/08/lillicat-publishers-1080x150.jpg.webp"));
        return loSliders;
    }

}