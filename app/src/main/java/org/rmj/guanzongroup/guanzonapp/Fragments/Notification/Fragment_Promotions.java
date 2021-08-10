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

import org.rmj.g3appdriver.etc.FacebookShare;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_AppBrowser;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Promotions;
import org.rmj.guanzongroup.guanzonapp.Model.PromoEventsModel;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMPromotions;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Promotions extends Fragment {

    private View view;

    private VMPromotions mViewModel;
    private RecyclerView recyclerView;
    private Adapter_Promotions adapter;
    private ArrayList<PromoEventsModel> promoEventsModels;
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
        promoEventsModels = new ArrayList<>();
        mViewModel.getAllEvents().observe(getViewLifecycleOwner(), eEvents -> {
            for(int i = 0; i < eEvents.size(); i++){
                PromoEventsModel eventsModel = new PromoEventsModel();
                eventsModel.setTransNox(eEvents.get(i).getTransNox());
                eventsModel.setBranchNm(eEvents.get(i).getBranchNm());
                eventsModel.setDateFrom(eEvents.get(i).getEvntFrom());
                eventsModel.setDateThru(eEvents.get(i).getEvntThru());
                eventsModel.setTitle(eEvents.get(i).getEventTle());
                eventsModel.setAddress(eEvents.get(i).getAddressx());
                eventsModel.setUrl(eEvents.get(i).getEventURL());
                eventsModel.setImgUrl(eEvents.get(i).getImageURL());
                eventsModel.setNotified(eEvents.get(i).getNotified());
                eventsModel.setModified(eEvents.get(i).getModified());
                promoEventsModels.add(eventsModel);
            }

        });
        mViewModel.getAllPromo().observe(getViewLifecycleOwner(), ePromos -> {
            if (ePromos.size()> 0){
                for(int i = 0; i < ePromos.size(); i++){
                    PromoEventsModel eventsModel = new PromoEventsModel();
                    eventsModel.setTransNox(ePromos.get(i).getTransNox());
                    eventsModel.setBranchNm("");
                    eventsModel.setDateFrom(ePromos.get(i).getDateFrom());
                    eventsModel.setDateThru(ePromos.get(i).getDateThru());
                    eventsModel.setTitle(ePromos.get(i).getCaptionx());
                    eventsModel.setAddress("");
                    eventsModel.setUrl(ePromos.get(i).getPromoUrl());
                    eventsModel.setImgUrl(ePromos.get(i).getImageUrl());
                    eventsModel.setNotified(ePromos.get(i).getNotified());
                    eventsModel.setModified("");
                    eventsModel.setImgByte("");
                    eventsModel.setDivision(String.valueOf(ePromos.get(i).getDivision()));
                    promoEventsModels.add(eventsModel);
                }
            }else{
                PromoEventsModel eventsModel = new PromoEventsModel();
                eventsModel.setTransNox("");
                eventsModel.setBranchNm("");
                eventsModel.setDateFrom("");
                eventsModel.setDateThru("");
                eventsModel.setTitle("See more promos at Official Guanzon Group");
                eventsModel.setAddress("");
                eventsModel.setUrl("https://www.guanzongroup.com.ph/category/promos/");
                eventsModel.setImgUrl("");
                eventsModel.setNotified("");
                eventsModel.setModified("");
                eventsModel.setImgByte("");
                promoEventsModels.add(0,eventsModel);
            }
            Log.e("Fragment_Promotions", String.valueOf(promoEventsModels.size()));

            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(RecyclerView.VERTICAL);
//            EPromo info = new EPromo();
//            info.setTransNox("");
//            info.setTransact("");
//            info.setImageUrl(null);
//            info.setPromoUrl("https://www.guanzongroup.com.ph/category/promos/");
//            info.setCaptionx("See more promos at Official Guanzon Group");
//            info.setDateFrom("");
//            info.setDateThru("");
//            ePromos.add(info);

            adapter = new Adapter_Promotions(getActivity(), promoEventsModels);
            adapter.setOnPromotionClickListener(new Adapter_Promotions.onPromotionClickListener() {
                @Override
                public void onClick(int position, String promo_link) {
                    Intent intent = new Intent(getActivity(), Activity_AppBrowser.class);
                    intent.putExtra("url_link", promo_link);
                    startActivity(intent);
                    mViewModel.updatEvents(promoEventsModels.get(position).transNox);
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

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);
    });
    }

    private void setupWidgets(View v) {
        recyclerView = view.findViewById(R.id.recycler_view_fragment_promotions);
    }
}
