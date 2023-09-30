package org.rmj.guanzongroup.panalo.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.rmj.guanzongroup.panalo.R;

public class DialogRaffelEntry {
    private static final String TAG = DialogRaffelEntry.class.getSimpleName();

    private final Context mContext;

    public interface OnDialogActionListener{
        void OnCreate(String Transact, String ReferNo);
    }

    private final AlertDialog.Builder poBuilders;
    private AlertDialog poDialog;

    public DialogRaffelEntry(Context mContext) {
        this.mContext = mContext;
        this.poBuilders = new AlertDialog.Builder(mContext);
    }

   public void initDialog(OnDialogActionListener listener){
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_raffle_entry, null, false);
        poBuilders.setView(view).setCancelable(false);
        poDialog = poBuilders.create();

       AutoCompleteTextView txtTransact = view.findViewById(R.id.tie_transaction);
       TextInputEditText txtReferNo = view.findViewById(R.id.tie_referenceNo);
       MaterialButton btnGenerate = view.findViewById(R.id.btnCreate);
       MaterialButton btnClose = view.findViewById(R.id.btnClose);

       String[] TRANSACTIONS = {"MOTORCYCLE PURCHASE", "JOB ORDER", "SPARE PARTS PURCHASE", "MONTHLY PAYMENT", "MOBILE PHONE PURCHASE"};
       txtTransact.setAdapter(new ArrayAdapter<>(mContext, R.layout.support_simple_spinner_dropdown_item, TRANSACTIONS));

       btnGenerate.setOnClickListener(v -> {
           if(txtTransact.getText().toString().isEmpty()){
               Toast.makeText(mContext, "Please select transaction.", Toast.LENGTH_SHORT).show();
               return;
           }

           if(txtReferNo.getText().toString().isEmpty()){
               Toast.makeText(mContext, "Please enter reference number.", Toast.LENGTH_SHORT).show();
               return;
           }

           String lsTransct = txtTransact.getText().toString();
           String lsReferNo = txtReferNo.getText().toString();
           listener.OnCreate(lsTransct, lsReferNo);
           poDialog.dismiss();
       });

       btnClose.setOnClickListener(v -> poDialog.dismiss());

       poDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
       poDialog.getWindow().getAttributes().windowAnimations = org.rmj.g3appdriver.R.style.PopupAnimation;
       poDialog.show();
   }
}
