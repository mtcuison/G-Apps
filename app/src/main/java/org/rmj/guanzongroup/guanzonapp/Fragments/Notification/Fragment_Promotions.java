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
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Model.PromoEventsModel;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMPromotions;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Promotions extends Fragment {

    private static final String TAG = Fragment_Promotions.class.getSimpleName();
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
        mViewModel.getAllPromo().observe(getViewLifecycleOwner(), promoList -> {
            mViewModel.setPromos(promoList);
        });
        mViewModel.getAllEvents().observe(getViewLifecycleOwner(), events -> {
            mViewModel.setEvents(events);
        });
        mViewModel.getAllPromoEvents().observe(getViewLifecycleOwner(), promoEvents ->{
            Log.e(TAG, "array list size = " +promoEvents.size());
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            adapter = new Adapter_Promotions(getActivity(), promoEvents);
            adapter.setOnPromotionClickListener(new Adapter_Promotions.onPromotionClickListener() {
                @Override
                public void onClick(int position, String promo_link) {
                    Intent intent = new Intent(getActivity(), Activity_AppBrowser.class);
                    intent.putExtra("url_link", promo_link);
                    startActivity(intent);
                    mViewModel.updatEvents(promoEvents.get(position).transNox);
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
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Guanzon App");
                    String shareMessage= "\nLet me recommend you this application\n\n";
                    shareMessage = PromoLink + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
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
