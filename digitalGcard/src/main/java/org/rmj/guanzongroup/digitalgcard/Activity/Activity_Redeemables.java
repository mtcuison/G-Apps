package org.rmj.guanzongroup.digitalgcard.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.rmj.g3appdriver.dev.Database.Entities.ERedeemablesInfo;
import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.guanzongroup.digitalgcard.Adapter.Adapter_Redeemables;
import org.rmj.guanzongroup.digitalgcard.R;
import org.rmj.guanzongroup.digitalgcard.ViewModel.VMGCardSystem;

import java.util.List;

public class Activity_Redeemables extends AppCompatActivity {
    private String TAG = Activity_Redeemables.class.getSimpleName();
    private VMGCardSystem mViewModel;
    private RecyclerView rvRedeemables;
    private TextView lbl_no_redeemables;
    private Adapter_Redeemables adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redeemables);
        try {
            mViewModel = new ViewModelProvider(this).get(VMGCardSystem.class);
            initViews();
            mViewModel.setInstance(GCardSystem.CoreFunctions.REDEMPTION);
            mViewModel.downloadRedeemables(new VMGCardSystem.GcardTransactionCallback() {
                @Override
                public void onLoad() {

                }

                @Override
                public void onSuccess(String fsMessage) {

                }

                @Override
                public void onFailed(String fsMessage) {

                }

                @Override
                public void onQrGenerate(Bitmap foBitmap) {

                }
            });

            mViewModel.GetRedeemablesList().observe(this, new Observer<List<ERedeemablesInfo>>() {
                @Override
                public void onChanged(List<ERedeemablesInfo> eRedeemablesInfos) {
                    Log.d("COUNT", String.valueOf(eRedeemablesInfos.size()));
                    if(eRedeemablesInfos.size()>0){
                        lbl_no_redeemables.setVisibility(View.GONE);
                    }else{
                        lbl_no_redeemables.setVisibility(View.VISIBLE);
                    }
                    adapter = new Adapter_Redeemables(Activity_Redeemables.this,eRedeemablesInfos, new Adapter_Redeemables.OnItemClick() {
                        @Override
                        public void onClick(String sPromoCode) {

                        }

                        @Override
                        public void addToCart() {

                        }
                    });
                    rvRedeemables.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            });
            initRedeemables();
        }catch (NullPointerException e){
            Log.e(TAG, e.getMessage());
        }
    }

    private void initViews() {
        rvRedeemables =findViewById(R.id.rvRedeemables);
        lbl_no_redeemables =findViewById(R.id.lbl_no_redeemables);
        rvRedeemables.setLayoutManager(new GridLayoutManager(Activity_Redeemables.this,
                2, RecyclerView.VERTICAL, false));
        rvRedeemables.setHasFixedSize(true);
    }

    private void initRedeemables() {

    }

}