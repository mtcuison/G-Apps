package org.rmj.guanzongroup.guanzonapp.Activities;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.rmj.g3appdriver.Database.DataAccessObject.DRedeemItemInfo;
import org.rmj.g3appdriver.Database.Entities.EGcardApp;
import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.g3appdriver.Database.Repositories.RRedeemItemInfo;
import org.rmj.g3appdriver.Http.HttpHeaders;
import org.rmj.g3appdriver.Http.HttpRequestUtil;
import org.rmj.g3appdriver.etc.AppConstants;
import org.rmj.g3appdriver.etc.GAppMessageBox;
import org.rmj.g3appdriver.utils.ConnectionUtil;
import org.rmj.g3appdriver.utils.WebApi;
import org.rmj.g3appdriver.utils.WebClient;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_ItemCart;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_Loading;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMItemCart;
import org.rmj.guanzongroup.guanzonapp.etc.CustomToast;
import org.rmj.guanzongroup.guanzonapp.etc.OnAsyncTaskCallback;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Activity_ItemCart extends AppCompatActivity{
    private static final String TAG = Activity_ItemCart.class.getSimpleName();
    private static Activity_ItemCart instance;
    private VMItemCart mViewModel;
    private List<ERedeemItemInfo> poItemCrt;

    private RecyclerView recyclerView;
    private MaterialButton btnSelectBranch;
    private TextView lblCartItemPoints;
    private TextView lblRmnPoints;
    private LinearLayout layout;
    private CustomToast poToast;
    private Dialog_Loading poLoading;

    private GAppMessageBox loMessage;
    private String branchCde = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = Activity_ItemCart.this;
        mViewModel = ViewModelProviders.of(Activity_ItemCart.this).get(VMItemCart.class);
        setContentView(R.layout.activity_item_cart);
        setupWidgets();
        setupJavaClassess();
        setupCartItems();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupJavaClassess(){
        poToast = new CustomToast(Activity_ItemCart.this);
        poLoading = new Dialog_Loading(Activity_ItemCart.this);
    }

    private void setupWidgets(){
        loMessage = new GAppMessageBox(Activity_ItemCart.this);
        layout = findViewById(R.id.linear_emptyList);
        Toolbar toolbar = findViewById(R.id.toolbar_itemCart);
        toolbar.setTitle("Item Cart");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        poToast = new CustomToast(instance);
        recyclerView = findViewById(R.id.recycler_view_itemCart);
        MaterialButton btnPlaceOrder = findViewById(R.id.btn_cart_placeOrder);
        btnSelectBranch = findViewById(R.id.btn_cart_selectBranch);
        lblCartItemPoints = findViewById(R.id.lbl_cart_orderPoints);
        lblRmnPoints = findViewById(R.id.lbl_cart_rmnPoints);

        btnPlaceOrder.setOnClickListener(v -> {
            mViewModel.getCartItemsDetail().observe(instance, itemDetl -> {
                try {
                    if(itemDetl.size() > 0) {
//                        JSONObject loJson = composeDataParameter("0365", itemDetl);
//                        Log.e("PlaceOrderParam", loJson.toString());
                        mViewModel.placeOrder("0365", itemDetl, new OnAsyncTaskCallback() {
                            @Override
                            public void onSuccessResult(String message) {
                                loMessage.initDialog();
                                loMessage.setPositiveButton("Okay", (view, dialog) -> {
                                    dialog.dismiss();
                                });
                                loMessage.setTitle("GuanzonApp");
                                loMessage.setMessage(message);
                                loMessage.show();
                            }

                            @Override
                            public void onFailedResult(String message) {
                                loMessage.initDialog();
                                loMessage.setPositiveButton("Okay", (view, dialog) -> {
                                    dialog.dismiss();
                                });
                                loMessage.setTitle("GuanzonApp");
                                loMessage.setMessage(message);
                                loMessage.show();
                            }
                        });
                    }
                } catch(NullPointerException e) {
                    e.printStackTrace();
                }
            });
        });

        btnSelectBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Dialog_BranchSelection(Activity_ItemCart.this).showDialog();
            }
        });

        mViewModel.getTotalCartPoints().observe(instance, totalCartPoints -> {
            try {
                lblCartItemPoints.setText(String.valueOf(totalCartPoints));
            } catch(NullPointerException e) {
                e.printStackTrace();
            }
        });

        mViewModel.getGCardInfo().observe(instance,cardInfo -> {
            try {
                lblRmnPoints.setText(String.valueOf(cardInfo.getAvlPoint()));
            } catch(NullPointerException e) {
                e.printStackTrace();
            }
        });
    }

    private void setupCartItems(){
        mViewModel.getCartItemsDetail().observe(instance, cartItems -> {
            try {
                if(cartItems.size() > 0) {
                    layout.setVisibility(View.GONE);

                    Adapter_ItemCart adapter = new Adapter_ItemCart(Activity_ItemCart.this,
                            cartItems, (String fsGcardno, String fsGcardPt, String fsPromoId, double fnRefundx) ->  {
                            try {
                                mViewModel.removeItemFromCart(fsPromoId);
                                String lsNewPts = String.valueOf(Double.parseDouble(fsGcardPt) + fnRefundx);
                                mViewModel.updateAvailablePoints(fsGcardno, lsNewPts);

                                poToast.setType(CustomToast.CustomToastType.INFORMATION);
                                poToast.setMessage("Item removed from cart.");
                                poToast.show();
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                    });

                    LinearLayoutManager layoutManager = new LinearLayoutManager(Activity_ItemCart.this);
                    layoutManager.setOrientation(RecyclerView.VERTICAL);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter.notifyDataSetChanged();
                } else {
                    layout.setVisibility(View.VISIBLE);
                }
            } catch(NullPointerException e) {
                e.printStackTrace();
            }
        });
    }


    public void setBranchValue(String BranchCode, String BranchName){
        branchCde = BranchCode;
        btnSelectBranch.setText(BranchName);
    }

}
