package org.rmj.guanzongroup.guanzonapp.Fragments.Notification;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.Database.Entities.EPromo;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_AppBrowser;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Promotions;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_NewsFeed;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMNewsFeed;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMPromotions;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Promotions extends Fragment {

    private View view;

    private VMPromotions mViewModel;
    private RecyclerView recyclerView;
    private Adapter_Promotions adapter;

    public static Fragment_Promotions newInstance() {
        return new Fragment_Promotions();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_promotions, container, false);
        setupWidgets(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VMPromotions.class);
        mViewModel.getAllPromo().observe(getViewLifecycleOwner(), ePromos -> {
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            EPromo info = new EPromo();
            info.setTransNox("");
            info.setTransact("");
            info.setImageUrl(null);
            info.setPromoUrl("https://www.guanzongroup.com.ph/category/promos/");
            info.setCaptionx("See more promos at Official Guanzon Group");
            info.setDateFrom("");
            info.setDateThru("");
            ePromos.add(info);
            adapter = new Adapter_Promotions(getActivity(), ePromos);
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
//                        new FacebookShare(Fragment_Promotions.this).shareLink(PromoLink, Caption);
                }
            });

            adapter.setOnShareLinkClickListener(new Adapter_Promotions.onShareLinkClickListener() {
                @Override
                public void onClick(String PromoLink) {

                }
            });

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
    });
    }

    private void setupWidgets(View v) {
        recyclerView = view.findViewById(R.id.recycler_view_fragment_promotions);
    }
}
