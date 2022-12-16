package org.rmj.guanzongroup.panalo.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.rmj.guanzongroup.panalo.R;

public class DialogPanaloPromo implements iDialog {
    private static final String TAG = DialogPanaloPromo.class.getSimpleName();

    private final Context mContext;

    private ImageButton btn_close;
    private TextView txt_GPanaloPromo;

    private final AlertDialog.Builder poBuilder;
    private AlertDialog poDialog;


    public DialogPanaloPromo(Context mContext) {
        this.mContext = mContext;
        this.poBuilder = new AlertDialog.Builder(mContext);
    }


    @Override
    public void initDialog(Object foVal, PanaloDialogClickListener listener) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_panalo_promo, null, false);
        poBuilder.setView(view).setCancelable(false);
        poDialog = poBuilder.create();

        txt_GPanaloPromo = view.findViewById(R.id.txt_PopupDIalog_GPanalo);

        btn_close = view.findViewById(R.id.btn_dialog_X);

        btn_close.setOnClickListener(v -> listener.OnClose(poDialog));
    }

    @Override
    public void show() {
        poDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        poDialog.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
        poDialog.show();
    }
}
