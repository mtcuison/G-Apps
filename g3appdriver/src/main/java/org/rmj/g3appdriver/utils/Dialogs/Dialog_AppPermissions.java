package org.rmj.g3appdriver.utils.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import org.rmj.g3appdriver.R;

public class Dialog_AppPermissions {
    private static final String TAG = Dialog_DoubleButton.class.getSimpleName();

    private final AlertDialog poDialogx;

    public Dialog_AppPermissions(Context foContext, OnButtonClick foCallBck) {

        View view = LayoutInflater.from(foContext).inflate(R.layout.dialog_app_permisions,
                null, false);
        AlertDialog.Builder loBuilder = new AlertDialog.Builder(foContext);
        loBuilder.setView(view).setCancelable(false);
        poDialogx = loBuilder.create();
        poDialogx.setCancelable(false);

        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(v -> foCallBck.onClick(poDialogx));
    }

    public void show(){
        poDialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        poDialogx.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;
        poDialogx.show();
    }

    public interface OnButtonClick {
        void onClick(AlertDialog dialog);
    }
}
