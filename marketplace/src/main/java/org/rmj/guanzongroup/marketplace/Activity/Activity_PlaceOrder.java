package org.rmj.guanzongroup.marketplace.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_DoubleButton;
import org.rmj.guanzongroup.marketplace.Activity_PaymentMethod;
import org.rmj.guanzongroup.marketplace.Dialog.Dialog_BottomCart;
import org.rmj.guanzongroup.marketplace.Fragment.FragmentPaymentMethod;
import org.rmj.guanzongroup.marketplace.Fragment.FragmentShippingAddress;

import org.rmj.guanzongroup.marketplace.R;

public class Activity_PlaceOrder extends AppCompatActivity {
    private RadioGroup rgDelOption;
    private RadioButton rbRegular, rbExpress;
    private MaterialButton btnPlaceOrder;
    private TextView lblPaymentChange,lblAddressChange;
    private Fragment fragmentPaymentMethod;
    private Fragment fragmentShippingAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        initWidgets();
        rgDelOption.setOnCheckedChangeListener(new OnRadioButtonSelectListener());
        btnPlaceOrder.setOnClickListener(v->{
            Dialog_BottomCart dialog = new Dialog_BottomCart();
            dialog.setCancelable(false);
            dialog.setItemSubTotal("₱ 1,000.00");
            dialog.setItemShippingFee(0);
            dialog.setItemOtherFee("₱ 0.00");
            dialog.setItemGrandTotal(1000);
            dialog.show((this).getSupportFragmentManager(), "");
        });

        lblPaymentChange.setOnClickListener(v->{
            startActivity(new Intent(this, Activity_PaymentMethod.class));
        });
        lblAddressChange.setOnClickListener(v->{
            Fragment fragment = new FragmentShippingAddress();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.myContainer, fragment).commit();
        });
    }
    private void initWidgets(){
        rgDelOption = findViewById(R.id.rgDelOption);
        rbRegular = findViewById(R.id.rbRegular);
        rbExpress = findViewById(R.id.rbExpress);
        btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        lblPaymentChange = findViewById(R.id.lblPaymentChange);
        lblAddressChange = findViewById(R.id.lblAddressChange);

        fragmentPaymentMethod= new FragmentPaymentMethod();
        fragmentShippingAddress = new FragmentShippingAddress();
    }
    private class OnRadioButtonSelectListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if(radioGroup.getId() == R.id.rgDelOption){
                if (i == R.id.rbRegular) {
                    rbRegular.setChecked(true);
                    rbExpress.setChecked(false);
                } else if (i == R.id.rbExpress) {
                    rbExpress.setChecked(true);
                    rbRegular.setChecked(false);
                }
            }
        }
    }
}