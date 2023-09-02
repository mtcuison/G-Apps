package org.rmj.guanzongroup.guanzonconnect.Dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.guanzongroup.guanzonconnect.R;

public class DialogBranchInfo {
    private static final String TAG = DialogBranchInfo.class.getSimpleName();

    private final Context mContext;

    private AlertDialog poDialogx;

    public interface BranchDialogActionCallback{
        void OnInitLocation(Intent args);
    }

    public DialogBranchInfo(Context mContext) {
        this.mContext = mContext;
    }

    public void InitDialog(EBranchInfo foVal, BranchDialogActionCallback callback){
        try{
            View loView = LayoutInflater.from(mContext).inflate(R.layout.dialog_branch_info, null, false);
            AlertDialog.Builder loBuilder =  new AlertDialog.Builder(mContext);
            loBuilder.setCancelable(true).setView(loView);
            poDialogx = loBuilder.create();

            TextView lblBranchNm, lblAddressx;

            lblBranchNm = loView.findViewById(R.id.lbl_branchName);
            lblAddressx = loView.findViewById(R.id.lbl_branchAddress);

            lblBranchNm.setText(foVal.getBranchNm());
            lblAddressx.setText(foVal.getAddressx());

            lblAddressx.setOnClickListener(v -> {
                Uri gmmIntentUri;
                if(foVal.getLatitude() == 0.0 && foVal.getLongtude() == 0.0){
                    Uri.parse("geo:0,0?q=guanzon" + foVal.getAddressx());
                } else {
                    gmmIntentUri = Uri.parse("geo:" + foVal.getLatitude() + ", " + foVal.getLongtude() + "?q=guanzon");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    callback.OnInitLocation(mapIntent);
                }
            });

            poDialogx.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
