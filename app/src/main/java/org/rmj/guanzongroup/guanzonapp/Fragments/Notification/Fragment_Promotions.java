package org.rmj.guanzongroup.guanzonapp.Fragments.Notification;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.Activities.Activity_AppBrowser;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Promotions;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Promotions;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.SalePromotions;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.etc.FacebookShare;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Promotions extends Fragment {

    private View view;

    private RecyclerView recyclerView;

    private List<Promotions> promotionsList = new ArrayList<>();
    private SalePromotions salePromotions;
    private Adapter_Promotions adapter;

    public Fragment_Promotions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_promotions, container, false);

        setupWidgets();
        setupRecyclerView();
        return view;
    }

    private void setupWidgets(){
        salePromotions = new SalePromotions(getActivity());

        //MaterialButton btnMcLoan = view.findViewById(R.id.btn_fragment_promos_mc_credit);
        //MaterialButton btnMpLoan = view.findViewById(R.id.btn_fragment_promos_mp_credit);
        recyclerView = view.findViewById(R.id.recycler_view_fragment_promotions);

        /*btnMcLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadIntent = new Intent(getActivity(), Activity_AppBrowser.class);
                loadIntent.putExtra("url_link", "https://www.guanzongroup.com.ph/product-category/motorcycle-2/");
                getActivity().startActivity(loadIntent);
            }
        });

        btnMpLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadIntent = new Intent(getActivity(), Activity_AppBrowser.class);
                loadIntent.putExtra("url_link", "https://www.guanzongroup.com.ph/product-category/mobile/apply-for-a-loan-cp/");
                getActivity().startActivity(loadIntent);
            }
        });*/
    }

    private void setupRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        promotionsList.clear();
        promotionsList = salePromotions.getPromoList();
        if(promotionsList.size()>0) {
            adapter = new Adapter_Promotions(getActivity(), promotionsList);
            adapter.setOnPromotionClickListener(new Adapter_Promotions.onPromotionClickListener() {
                @Override
                public void onClick(int position, String promo_link) {
                    Intent intent = new Intent(getActivity(), Activity_AppBrowser.class);
                    intent.putExtra("url_link", promo_link);
                    startActivity(intent);
                }
            });

            adapter.setOnFacebookShareClickListener(new Adapter_Promotions.onFacebookShareClickListener() {
                @Override
                public void onClick(String PromoLink, String Caption) {
                    new FacebookShare(Fragment_Promotions.this).shareLink(PromoLink, Caption);
                }
            });

            adapter.setOnShareLinkClickListener(new Adapter_Promotions.onShareLinkClickListener() {
                @Override
                public void onClick(String PromoLink) {

                }
            });
        }

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
