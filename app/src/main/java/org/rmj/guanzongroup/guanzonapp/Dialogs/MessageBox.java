package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.R;

import javax.mail.Message;

public class MessageBox {

    private Context mContext;

    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    private boolean hasPositiveButton = false;
    private boolean hasNegativeButton = false;
    private char MessageType = '0';
    private String DialogMessage = "";

    private MaterialButton btnPositiveButton;
    private MaterialButton btnNegativeButton;
    private TextView lblMessageBody;
    private ImageView imgMessageType;

    private onMessageBoxButtonClick positiveButtonListener;
    private onMessageBoxButtonClick negativeButtonListener;
    private String PositiveButtonText = "";
    private String NegativeButtonText = "";

    public interface onMessageBoxButtonClick{
        void onClick(View view, AlertDialog dialog);
    }

    public interface MessageType{
        char WARNING = '1';
        char INFO = '2';
    }

    public MessageBox(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
    }

    public void showDialog(){
        createDialog();
        dialog.show();
    }

    private void createDialog(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_message_box, null, false);
        builder.setView(view)
                .setCancelable(false);
        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.PopupAnimation;

        btnPositiveButton = view.findViewById(R.id.btn_messagebox_positive_button);
        btnNegativeButton = view.findViewById(R.id.btn_messagebox_negative_button);
        lblMessageBody = view.findViewById(R.id.lbl_messagebox_message_body);
        imgMessageType = view.findViewById(R.id.img_messagebox_dialog_type);

        btnPositiveButton.setVisibility(getPositiveButton());
        btnPositiveButton.setText(PositiveButtonText);
        btnNegativeButton.setVisibility(getNegativeButton());
        btnNegativeButton.setText(NegativeButtonText);
        imgMessageType.setImageResource(getImageIcon());
        lblMessageBody.setText(DialogMessage);

        btnPositiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positiveButtonListener.onClick(v, dialog);
            }
        });

        btnNegativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                negativeButtonListener.onClick(v, dialog);
            }
        });
    }

    public void setPositiveButton(String Text, onMessageBoxButtonClick listener) {
        this.hasPositiveButton = true;
        this.positiveButtonListener = listener;
        this.PositiveButtonText = Text;
    }

    public void setNegativeButton(String Text, onMessageBoxButtonClick listener) {
        this.hasNegativeButton = true;
        this.negativeButtonListener = listener;
        this.NegativeButtonText = Text;
    }

    public void setMessageType(char messageType) {
        this.MessageType = messageType;
    }

    public void setDialogMessage(String Message){
        this.DialogMessage = Message;
    }

    private int getImageIcon(){
        switch (MessageType){
            case '0':
            case '2':
                return R.drawable.ic_dialog_message_box_info;
            case '1':
                return R.drawable.ic_dialog_message_box_warning;
        }
        return 0;
    }

    private int getPositiveButton(){
        if(hasPositiveButton){
            return View.VISIBLE;
        }
        return View.GONE;
    }

    private int getNegativeButton(){
        if(hasNegativeButton){
            return View.VISIBLE;
        }
        return View.GONE;
    }
}
