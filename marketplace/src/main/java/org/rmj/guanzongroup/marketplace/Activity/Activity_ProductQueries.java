package org.rmj.guanzongroup.marketplace.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;
import org.rmj.guanzongroup.marketplace.databinding.ActivityProductQueriesBinding;

public class Activity_ProductQueries extends AppCompatActivity {

    private ActivityProductQueriesBinding mBinding;
    private Dialog_SingleButton poDialogx;
    private String psItemIdx = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityProductQueriesBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        getExtras();

        poDialogx = new Dialog_SingleButton(Activity_ProductQueries.this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void getExtras() {
        if(getIntent().hasExtra("sListingId")) {
            psItemIdx = getIntent().getStringExtra("sListingId");
        } else {
            poDialogx.setButtonText("Okay");
            poDialogx.initDialog("Marketplace", "Product does not exist.", d -> {
                d.dismiss();
                finish();
            });
            poDialogx.show();
        }
    }

}