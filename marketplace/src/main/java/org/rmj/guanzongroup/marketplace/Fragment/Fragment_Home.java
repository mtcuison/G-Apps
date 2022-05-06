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
import androidx.recyclerview.widget.GridLayoutManager;
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
    private Adapter_ProductList poAdapter;
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
        poRvProds.setLayoutManager(new GridLayoutManager(requireActivity(),
                2, RecyclerView.VERTICAL, false));
        poRvCateg.setLayoutManager(new LinearLayoutManager(requireActivity()));
        poRvProds.setHasFixedSize(true);
        poRvCateg.setHasFixedSize(true);
    }

    private void displayData() {
        setProductAdapter();
        setCategoryAdapter();
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

    private void setCategoryAdapter() {

    }

}