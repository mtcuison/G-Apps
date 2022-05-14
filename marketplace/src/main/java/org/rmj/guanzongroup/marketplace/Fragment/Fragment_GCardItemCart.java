package org.rmj.guanzongroup.marketplace.Fragment;

import static org.rmj.guanzongroup.marketplace.Fragment.Fragment_MPItemCart.currencyFormat;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ItemCart;
import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMGCardItemCart;
import org.rmj.guanzongroup.marketplace.ViewModel.VMMPItemCart;

import java.text.DecimalFormat;
import java.util.List;

public class Fragment_GCardItemCart extends Fragment {

    private VMGCardItemCart mViewModel;


    private RecyclerView recyclerView;
    private LinearLayout noItem, lnGCardFooter;
    private MaterialButton btnCheckOut;
    private TextView lblGrandTotal;
    private Adapter_ItemCart adapter;
    private List<ItemCartModel> itemList;
    public static Fragment_GCardItemCart newInstance() {
        return new Fragment_GCardItemCart();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gcard_item_cart, container, false);
        initWidgets(v);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMGCardItemCart.class);
        mViewModel.getGCardItemCart().observe(requireActivity(), itemCart ->{
            if (itemCart != null){
                noItem.setVisibility(View.GONE);
                lnGCardFooter.setVisibility(View.VISIBLE);
                adapter = new Adapter_ItemCart(itemCart, new Adapter_ItemCart.OnCartAction() {
                    @Override
                    public void onClickAction(String val) {

                    }
                });
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                adapter.notifyDataSetChanged();
                double subtotal = 0;
                for (int x = 0; x < itemList.size(); x++){
                    subtotal += Double.parseDouble(itemList.get(x).getItemPrice().replaceAll(",",""));
                }
                lblGrandTotal.setText("₱ " + currencyFormat(subtotal));
            }else {
                noItem.setVisibility(View.VISIBLE);
                lnGCardFooter.setVisibility(View.GONE);
            }
        });
    }


    private void initWidgets(View view){
        recyclerView = view.findViewById(R.id.recyclerView_GCardCart);
        noItem = view.findViewById(R.id.layoutGCardNoItem);
        lnGCardFooter = view.findViewById(R.id.lnGCardFooter);
        lblGrandTotal = view.findViewById(R.id.lblGCardGrandTotal);
        btnCheckOut = view.findViewById(R.id.btnGCardCheckOut);
    }

    public static String currencyFormat(double amount) {
        DecimalFormat formatter = new DecimalFormat("###,###,##0.00");
        return formatter.format(amount);
    }
}