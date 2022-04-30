package org.rmj.guanzongroup.marketplace.Fragment;

import androidx.cardview.widget.CardView;
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

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.marketplace.Adapter.Adapter_ItemCart;
import org.rmj.guanzongroup.marketplace.Adapter.Adapter_PaymentMethod;
import org.rmj.guanzongroup.marketplace.Model.PaymentMethodModel;
import org.rmj.guanzongroup.marketplace.R;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class FragmentPaymentMethod extends Fragment {

    private VMPaymentMethod mViewModel;
    private RecyclerView recyclerViewCard, recyclerViewEWallet;
    private CardView cvCashOnDelivery;
    private MaterialButton btnAddPayment;
    private List<PaymentMethodModel> paymentCardList;
    private List<PaymentMethodModel> paymentEWalletList;
    private Adapter_PaymentMethod adapterCard;
    private Adapter_PaymentMethod adapterEWallet;
    public static FragmentPaymentMethod newInstance() {
        return new FragmentPaymentMethod();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_payment_method, container, false);
        initWidgets(v);
        setData();
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMPaymentMethod.class);
        // TODO: Use the ViewModel
    }
    private void initWidgets(View v){
        recyclerViewCard = v.findViewById(R.id.recyclerView_paymentCard);
        recyclerViewEWallet = v.findViewById(R.id.recyclerView_paymentEWallet);
        cvCashOnDelivery = v.findViewById(R.id.cvCash);
        btnAddPayment = v.findViewById(R.id.btn_bottom_sheet_add_payment);
    }
    private void setData(){
        paymentCardList = new ArrayList<>();
        paymentEWalletList = new ArrayList<>();
        PaymentMethodModel infoCardModel = new PaymentMethodModel();
        infoCardModel.setItemPaymentCateg("Debit");
        infoCardModel.setItemPaymentName("Juan Dela Cruz");
        infoCardModel.setItemPaymentNo("****-****-1234");
        paymentCardList.add(infoCardModel);
        PaymentMethodModel infoCardModel2 = new PaymentMethodModel();
        infoCardModel2.setItemPaymentCateg("Credit");
        infoCardModel2.setItemPaymentName("Juan Dela Cruz");
        infoCardModel2.setItemPaymentNo("****-****-5678");
        paymentCardList.add(infoCardModel2);
        PaymentMethodModel infoEWalletModel = new PaymentMethodModel();
        infoEWalletModel.setItemPaymentCateg("GCash");
        infoEWalletModel.setItemPaymentName("Juan Dela Cruz");
        infoEWalletModel.setItemPaymentNo("0927-123-4567");
        paymentEWalletList.add(infoCardModel);
        PaymentMethodModel infoEWalletMode1 = new PaymentMethodModel();
        infoEWalletMode1.setItemPaymentCateg("PayMaya");
        infoEWalletMode1.setItemPaymentName("Juan Jose Dela Cruz");
        infoEWalletMode1.setItemPaymentNo("juandc@guanzongroup.com.ph");
        paymentEWalletList.add(infoEWalletMode1);
        PaymentMethodModel infoEWalletMode2 = new PaymentMethodModel();
        infoEWalletMode2.setItemPaymentCateg("PayPal");
        infoEWalletMode2.setItemPaymentName("Juan Jose");
        infoEWalletMode2.setItemPaymentNo("juandc@guanzongroup.com.ph");
        paymentEWalletList.add(infoEWalletMode2);

        adapterCard = new Adapter_PaymentMethod(paymentCardList, new Adapter_PaymentMethod.OnCartAction() {
            @Override
            public void onClickAction(String val) {

            }
        });
        adapterEWallet = new Adapter_PaymentMethod(paymentEWalletList, new Adapter_PaymentMethod.OnCartAction() {
            @Override
            public void onClickAction(String val) {

            }
        });

        recyclerViewCard.setAdapter(adapterCard);
        recyclerViewEWallet.setAdapter(adapterEWallet);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewCard.setLayoutManager(layoutManager);
        recyclerViewCard.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());

        recyclerViewEWallet.setLayoutManager(layoutManager1);
        recyclerViewEWallet.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        adapterCard.notifyDataSetChanged();
        adapterEWallet.notifyDataSetChanged();
    }

}