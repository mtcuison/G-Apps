package org.rmj.guanzongroup.marketplace.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.rmj.guanzongroup.marketplace.Activity.Activity_ProductOverview;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ProductList;
import org.rmj.guanzongroup.marketplace.Etc.SampleProductData;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMHome;


public class Fragment_Home extends Fragment {

    private VMHome mViewModel;
    private Adapter_ProductList poTopDeal, poProduct;
    private RecyclerView poRvProds, poRvCateg;

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
        poRvProds = v.findViewById(R.id.rv_top_products);
        poRvCateg = v.findViewById(R.id.rv_categories);
        poRvProds.setLayoutManager(new LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false));
        poRvCateg.setLayoutManager(new LinearLayoutManager(requireActivity()));
        poRvProds.setHasFixedSize(true);
        poRvCateg.setHasFixedSize(true);
    }

    private void displayData() {
        setProductAdapter();
        setCategoryAdapter();
    }

    private void setProductAdapter() {
        try {
            if("success".equals(SampleProductData.getJson().getString("result"))) {
                JSONArray loArray = SampleProductData.getJson().getJSONArray("detail");
                poTopDeal = new Adapter_ProductList(loArray, fsListIdx -> {
                    Intent loIntent = new Intent(requireActivity(), Activity_ProductOverview.class);
                    loIntent.putExtra("sListingId", fsListIdx);
                    startActivity(loIntent);
                });
                poRvProds.setAdapter(poTopDeal);
                poTopDeal.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setCategoryAdapter() {

    }

}