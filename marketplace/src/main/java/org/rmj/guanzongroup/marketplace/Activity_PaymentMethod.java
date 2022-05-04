package org.rmj.guanzongroup.marketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.marketplace.Adapter.Adapter_PaymentMethod;
import org.rmj.guanzongroup.marketplace.Model.PaymentMethodModel;
import org.rmj.guanzongroup.marketplace.ViewModel.VMPaymentMethod;

import java.util.ArrayList;
import java.util.List;

public class Activity_PaymentMethod extends AppCompatActivity {


    private VMPaymentMethod mViewModel;
    private RecyclerView recyclerViewCard, recyclerViewEWallet;
    private CardView cvCashOnDelivery;
    private MaterialButton btnAddPayment;
    private List<PaymentMethodModel> paymentCardList;
    private List<PaymentMethodModel> paymentEWalletList;
    private Adapter_PaymentMethod adapterCard;
    private Adapter_PaymentMethod adapterEWallet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        initWidgets();
        setData();
    }

    private void initWidgets(){
        recyclerViewCard = findViewById(R.id.recyclerView_paymentCard);
        recyclerViewEWallet = findViewById(R.id.recyclerView_paymentEWallet);
        cvCashOnDelivery = findViewById(R.id.cvCash);
        btnAddPayment = findViewById(R.id.btn_bottom_sheet_add_payment);
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
        recyclerViewCard.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewCard.addItemDecoration(new DividerItemDecoration(this, 0));

        recyclerViewEWallet.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewEWallet.addItemDecoration(new DividerItemDecoration(this, 0));

        adapterCard.notifyDataSetChanged();
        adapterEWallet.notifyDataSetChanged();
    }
}