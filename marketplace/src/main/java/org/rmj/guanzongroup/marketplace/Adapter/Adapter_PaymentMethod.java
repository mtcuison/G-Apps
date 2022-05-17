package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.rmj.guanzongroup.marketplace.Model.ItemCartModel;
import org.rmj.guanzongroup.marketplace.Model.PaymentMethodModel;
import org.rmj.guanzongroup.marketplace.R;

import java.util.List;

public class Adapter_PaymentMethod extends RecyclerView.Adapter<Adapter_PaymentMethod.OrderHolder> {

    private final List<PaymentMethodModel> poCart;
    private final OnCartAction poCallBck;
    public Adapter_PaymentMethod(List<PaymentMethodModel> foCart,OnCartAction foCallBck) {
        this.poCart = foCart;
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_payment_method, parent, false);
        return new OrderHolder(view, poCallBck);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        PaymentMethodModel loPayment = poCart.get(position);
        holder.lblPaymentName.setText(loPayment.getItemPaymentName());
        holder.lblPaymentNo.setText(loPayment.getItemPaymentNo());
        holder.lblPaymentCateg.setText(loPayment.getItemPaymentCateg());

    }

    @Override
    public int getItemCount() {
        return poCart.size();
    }

    public static class OrderHolder extends RecyclerView.ViewHolder{

        public TextView lblPaymentName;
        public TextView lblPaymentNo;
        public TextView lblPaymentCateg;
        public ImageView imgItem;

        public OrderHolder(@NonNull View itemView, OnCartAction foCallBck) {
            super(itemView);
            lblPaymentName = itemView.findViewById(R.id.lblPaymentName);
            lblPaymentNo = itemView.findViewById(R.id.lblPaymentNo);
            lblPaymentCateg = itemView.findViewById(R.id.lblPaymentCategory);
            imgItem = itemView.findViewById(R.id.imgProduct);


        }

    }

    public interface OnCartAction {
        void onClickAction(String val);
    }

}
