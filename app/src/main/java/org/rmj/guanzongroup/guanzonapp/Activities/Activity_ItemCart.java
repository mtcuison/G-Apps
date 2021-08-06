package org.rmj.guanzongroup.guanzonapp.Activities;

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

import org.rmj.g3appdriver.Database.Entities.ERedeemItemInfo;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_ItemCart;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_Loading;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMItemCart;
import org.rmj.guanzongroup.guanzonapp.etc.CustomToast;

import java.util.List;

public class Activity_ItemCart extends AppCompatActivity{
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
        layout = findViewById(R.id.linear_emptyList);
        Toolbar toolbar = findViewById(R.id.toolbar_itemCart);
        toolbar.setTitle("Item Cart");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view_itemCart);
        MaterialButton btnPlaceOrder = findViewById(R.id.btn_cart_placeOrder);
        btnSelectBranch = findViewById(R.id.btn_cart_selectBranch);
        lblCartItemPoints = findViewById(R.id.lbl_cart_orderPoints);
        lblRmnPoints = findViewById(R.id.lbl_cart_rmnPoints);

        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
//                if(branchCde.isEmpty()){
//                    new Dialog_BranchSelection(Activity_ItemCart.this).showDialog();
//                }
//                new PlaceOrderTask().execute();
            }
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
//        cartItemList = new CartManager(Activity_ItemCart.this).getCartItems();
//        if(cartItemList.size() > 0) {
//            layout.setVisibility(View.GONE);
//            final Adapter_ItemCart adapter = new Adapter_ItemCart(Activity_ItemCart.this, cartItemList);
//            LinearLayoutManager layoutManager = new LinearLayoutManager(Activity_ItemCart.this);
//            layoutManager.setOrientation(RecyclerView.VERTICAL);
//            recyclerView.setAdapter(adapter);
//            recyclerView.setLayoutManager(layoutManager);
//
//            adapter.setOnDataSetChangeListener(new Adapter_ItemCart.onDataSetChangeListener() {
//                @Override
//                public void onItemDeleteClickListener(String PromoID) {
//                    new CartManager(Activity_ItemCart.this).removeFromCart(PromoID);
//                    setupCartItems();
//                    adapter.notifyDataSetChanged();
//                    if (new Activity_Redeemables().getInstance().isOpen) {
//                        Activity_Redeemables.getInstance().invalidateOptionsMenu();
//                    }
//                    Activity_DashBoard.getInstance().invalidateOptionsMenu();
//                    new Fragment_DashBoard().getInstance().refreshUI();
//                    refreshCartPoints();
//                }
//            });
//        } else {
//            layout.setVisibility(View.VISIBLE);
//        }
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

    private String[] getPromoIDxx(){
//        String[] promos = new String[cartItemList.size()];
//        for(int x = 0; x < cartItemList.size(); x++){
//            promos[x] = cartItemList.get(x).getItemIDxx();
//        }
//        return promos;
            return null;
    }

    private int[] getQuantity(){
//        int[] quantity = new int[cartItemList.size()];
//        for(int x = 0; x < cartItemList.size(); x++){
//            quantity[x] = Integer.parseInt(cartItemList.get(x).getQuantity());
//        }
//        return quantity;
        return null;
    }
//    TODO: Afternoon
//    class PlaceOrderTask extends AsyncTask<Integer, Integer, String>{
//
//        String message;
//
//        @RequiresApi(api = Build.VERSION_CODES.M)
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            loading.setMessage("Sending request. Please wait...");
//            loading.showDialog();
//        }
//
//        @Override
//        protected String doInBackground(Integer... integers) {
//            final String[] result = new String[1];
//            new PlaceOrder().placeItemsOnCart(Activity_ItemCart.this, branchCde, getPromoIDxx(), getQuantity(),
//                    new PlaceOrder.onPlaceOrderRequestListener() {
//                        @Override
//                        public void onPlaceOrderSuccessResult() {
//                            result[0] = "success";
//                        }
//
//                        @Override
//                        public void onPlaceOrderFailedResult(String errorMessage) {
//                            customToast.setType(CustomToast.CustomToastType.WARNING);
//                            customToast.setMessage(errorMessage);
//                            customToast.show();
//                            message = errorMessage;
//                            result[0] = "error";
//                        }
//                    });
//            return result[0];
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            loading.dismissDialog();
//            if(s.equalsIgnoreCase("success")){
//                startActivity(new Intent(Activity_ItemCart.this, Activity_Orders.class));
//                finish();
//                if(new Activity_Redeemables().isOpen) {
//                    new Activity_Redeemables();
//                }
//            } else {
//                customToast.setType(CustomToast.CustomToastType.WARNING);
//                customToast.setMessage(message);
//                customToast.show();
//            }
//            this.cancel(true);
//        }
//    }
}
