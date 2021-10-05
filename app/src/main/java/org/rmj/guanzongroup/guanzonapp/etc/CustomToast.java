package org.rmj.guanzongroup.guanzonapp.etc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.rmj.guanzongroup.guanzonapp.R;

public class CustomToast {
    private View view;
    private Context mContext;
    private Toast toast;

    private String Message;
    private int Type;

    public CustomToast(Context context){
        this.mContext = context;
        this.toast = new Toast(mContext);
    }

    public void show(){
        setView();
        toast.show();
    }

    public void setMessage(String message) {
        Message = message;
    }

    public void setType(int type) {
        Type = type;
    }

    @SuppressLint("InflateParams")
    private void setView(){
        view = LayoutInflater.from(mContext).inflate(R.layout.toast_custom_view, null, false);

        ImageView imgToastType = view.findViewById(R.id.lbl_toast_type);
        TextView lblMessage = view.findViewById(R.id.lbl_toast_message);

        imgToastType.setImageResource(Type);
        lblMessage.setText(Message);

        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
    }

    public interface CustomToastType{
        int ADDED_TO_CART = R.drawable.ic_toolbar_shopping_cart;
        int DELETE_ITEM_ON_CART = R.drawable.ic_item_delete;
        int WARNING = R.drawable.ic_toast_icon_warning;
        int INFORMATION = R.drawable.ic_toast_icon_info;
    }
}
