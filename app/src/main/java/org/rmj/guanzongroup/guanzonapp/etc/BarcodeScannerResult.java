package org.rmj.guanzongroup.guanzonapp.etc;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;

import org.rmj.guanzongroup.guanzonapp.Dialogs.MessageBox;

public class BarcodeScannerResult {
    private Context mContext;

    public BarcodeScannerResult(Context context){
        this.mContext = context;
    }

    public void showResult(String result){
        MessageBox messageBox = new MessageBox(mContext);
        messageBox.setNegativeButton("Exit", new MessageBox.onMessageBoxButtonClick() {
            @Override
            public void onClick(View view, AlertDialog dialog) {

            }
        });
        messageBox.setPositiveButton("Okay", new MessageBox.onMessageBoxButtonClick() {
            @Override
            public void onClick(View view, AlertDialog dialog) {

            }
        });
        messageBox.setMessageType(MessageBox.MessageType.INFO);
        messageBox.setDialogMessage(result);
        messageBox.showDialog();
    }
}
