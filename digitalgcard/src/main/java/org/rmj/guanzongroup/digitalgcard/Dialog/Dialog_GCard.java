package org.rmj.guanzongroup.digitalgcard.Dialog;

import android.app.AlertDialog;
import android.content.Context;

public class Dialog_GCard {
    private final AlertDialog.Builder mBuilder;

    public Dialog_GCard(Context context) {
        this.mBuilder = new AlertDialog.Builder(context);
    }

    public void

    public interface OnDialogInteraction {
        void onPositiveBtnClick(String fsMessage);
        void onNegativeBtnClick(String fsMessage);
    }

}
