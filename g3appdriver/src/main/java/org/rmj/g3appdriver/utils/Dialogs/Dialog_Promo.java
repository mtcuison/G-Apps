package org.rmj.g3appdriver.utils.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.rmj.g3appdriver.R;

public class Dialog_Promo {

    private AlertDialog poDialogx;
    private final Context poContext;
    private static boolean isShown;

    public Dialog_Promo(Context foContext) {
        this.poContext = foContext;
    }

    public void initDialog(String fsImgUrlx, OnPromoClick mCallBack){
        View view = LayoutInflater.from(poContext).inflate(R.layout.dialog_promo ,
                null, false);
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(poContext);
        loBuilder.setView(view).setCancelable(false);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        TextView lnkClosex = view.findViewById(R.id.lnkClosex);
        ImageView imgPromox = view.findViewById(R.id.imgPromox);

        lnkClosex.setOnClickListener(v -> poDialogx.dismiss());
        imgPromox.setOnClickListener(v -> mCallBack.onClick(poDialogx));
        Picasso.get().load(fsImgUrlx).into(imgPromox);
    }

    public void show() {
        if(!isShown) {
            poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            poDialogx.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;
            poDialogx.show();
            isShown = true;
        }
    }

    public void dismiss(){
        if(poDialogx != null && poDialogx.isShowing()){
            poDialogx.dismiss();
            isShown = false;
        }
    }

    public interface OnPromoClick {
        void onClick(AlertDialog dialog);
    }

}
