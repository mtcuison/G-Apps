package org.rmj.guanzongroup.ganado.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.imageview.ShapeableImageView;

import org.rmj.g3appdriver.etc.LoadDialog;
import org.rmj.g3appdriver.etc.MessageBox;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.guanzongroup.ganado.Adapter.RecyclerViewAdapter_BrandSelection;
import org.rmj.guanzongroup.ganado.R;
import org.rmj.guanzongroup.ganado.ViewModel.VMBrandList;

import java.util.Objects;


public class Activity_BrandSelection extends AppCompatActivity {

    private VMBrandList mViewModel;
    private RecyclerView rvc_brandlist;
    private ShapeableImageView brandcatimg;
    private RecyclerViewAdapter_BrandSelection rec_brandList;
    private LoadDialog poLoad;
    private MessageBox poMessage;

    private Dialog_Loading poLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_selection);
        intWidgets();
        mViewModel = new ViewModelProvider(this).get(VMBrandList.class);

        brandcatimg = findViewById(R.id.imagebrandtop);

        mViewModel.importCriteria(new VMBrandList.OnDownloadModels() {
            @Override
            public void onLoad() {
                poLoading.initDialog("Product Inquiry", "Product Inquiry item downloading.. Please wait.");
                poLoading.show();
            }

            @Override
            public void onSuccess(String fsMessage) {
                poLoading.dismiss();
                Log.e(Activity_BrandSelection.class.getSimpleName(), fsMessage);

            }

            @Override
            public void onFailed(String fsMessage) {
                poLoading.dismiss();
                Log.e(Activity_BrandSelection.class.getSimpleName(), fsMessage);


            }
        });
        mViewModel.getBrandList().observe(Activity_BrandSelection.this, brandList -> {
            if (brandList.size() > 0) {
                rec_brandList = new RecyclerViewAdapter_BrandSelection(brandList, new RecyclerViewAdapter_BrandSelection.OnBrandSelectListener() {
                    @Override
                    public void OnSelect(String BrandID, String BrandName) {
                        Intent intent = new Intent(Activity_BrandSelection.this, Activity_ProductSelection.class);
                        intent.putExtra("lsBrandID", BrandID);
                        intent.putExtra("lsBrandNm", BrandName);
                        Log.d("TEEJEI SELECTED THIS", BrandName);
                        startActivity(intent);
                        overridePendingTransition(R.anim.anim_intent_slide_in_right, R.anim.anim_intent_slide_out_left);
                    }
                });

                rvc_brandlist.setAdapter(rec_brandList);
                rvc_brandlist.setLayoutManager(new GridLayoutManager(Activity_BrandSelection.this, 2, RecyclerView.VERTICAL, false));

                rec_brandList.notifyDataSetChanged();
            }
        });
    }

    private void intWidgets() {
        rvc_brandlist = findViewById(R.id.rv_brands);

        MaterialToolbar toolbar = findViewById(R.id.toolbar_brand);
        toolbar.setTitle("Brand Selection");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        poLoading = new Dialog_Loading(Activity_BrandSelection.this);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_intent_slide_in_left, R.anim.anim_intent_slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}