package org.rmj.guanzongroup.guanzonapp.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_ItemCart;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.CartItem;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_BranchSelection;
import org.rmj.guanzongroup.guanzonapp.Dialogs.Dialog_Loading;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction.CartManager;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction.PlaceOrder;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction.PointsManager;
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.etc.CustomToast;

import java.util.List;

public class Activity_ItemCart extends AppCompatActivity{
    private static Activity_ItemCart instance;

    private List<CartItem> cartItemList;

    private RecyclerView recyclerView;
    private MaterialButton btnSelectBranch;
    private TextView lblCartItemPoints;
    private TextView lblRmnPoints;
    private LinearLayout layout;
    private CustomToast customToast;
    private Dialog_Loading loading;

    private double CartItemPoints = 0;
    private double GCardRmPoints = 0;

    private String branchCde = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        setContentView(R.layout.activity_item_cart);
        CartItemPoints = new PointsManager(Activity_ItemCart.this).getCartItemPoints();
        GCardRmPoints = new PointsManager(Activity_ItemCart.this).getRemainingGCardPoints();
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
        customToast = new CustomToast(Activity_ItemCart.this);
        loading = new Dialog_Loading(Activity_ItemCart.this);
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
                if(branchCde.isEmpty()){
                    new Dialog_BranchSelection(Activity_ItemCart.this).showDialog();
                }
                new PlaceOrderTask().execute();
            }
        });

        btnSelectBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            new Dialog_BranchSelection(Activity_ItemCart.this).showDialog();
            }
        });

        lblCartItemPoints.setText(String.valueOf(CartItemPoints));
        lblRmnPoints.setText(String.valueOf(GCardRmPoints));
    }

    private void setupCartItems(){
        cartItemList = new CartManager(Activity_ItemCart.this).getCartItems();
        if(cartItemList.size() > 0) {
            layout.setVisibility(View.GONE);
            final Adapter_ItemCart adapter = new Adapter_ItemCart(Activity_ItemCart.this, cartItemList);
            LinearLayoutManager layoutManager = new LinearLayoutManager(Activity_ItemCart.this);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);

            adapter.setOnDataSetChangeListener(new Adapter_ItemCart.onDataSetChangeListener() {
                @Override
                public void onItemDeleteClickListener(String PromoID) {
                    new CartManager(Activity_ItemCart.this).removeFromCart(PromoID);
                    setupCartItems();
                    adapter.notifyDataSetChanged();
                    if (new Activity_Redeemables().getInstance().isOpen) {
                        Activity_Redeemables.getInstance().invalidateOptionsMenu();
                    }
                    Activity_DashBoard.getInstance().invalidateOptionsMenu();
                    new Fragment_DashBoard().getInstance().refreshUI();
                    refreshCartPoints();
                }
            });
        } else {
            layout.setVisibility(View.VISIBLE);
        }
    }

    public Activity_ItemCart getInstance(){
        return instance;
    }

    public void setBranchValue(String BranchCode, String BranchName){
        branchCde = BranchCode;
        btnSelectBranch.setText(BranchName);
    }

    public void refreshCartPoints(){
        CartItemPoints = new PointsManager(Activity_ItemCart.this).getCartItemPoints();
        lblCartItemPoints.setText(String.valueOf(CartItemPoints));
        lblRmnPoints.setText(String.valueOf(new PointsManager(Activity_ItemCart.this).getRemainingGCardPoints()));
    }

    private String[] getPromoIDxx(){
        String[] promos = new String[cartItemList.size()];
        for(int x = 0; x < cartItemList.size(); x++){
            promos[x] = cartItemList.get(x).getItemIDxx();
        }
        return promos;
    }

    private int[] getQuantity(){
        int[] quantity = new int[cartItemList.size()];
        for(int x = 0; x < cartItemList.size(); x++){
            quantity[x] = Integer.parseInt(cartItemList.get(x).getQuantity());
        }
        return quantity;
    }

    class PlaceOrderTask extends AsyncTask<Integer, Integer, String>{

        String message;

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading.setMessage("Sending request. Please wait...");
            loading.showDialog();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            final String[] result = new String[1];
            new PlaceOrder().placeItemsOnCart(Activity_ItemCart.this, branchCde, getPromoIDxx(), getQuantity(),
                    new PlaceOrder.onPlaceOrderRequestListener() {
                        @Override
                        public void onPlaceOrderSuccessResult() {
                            result[0] = "success";
                        }

                        @Override
                        public void onPlaceOrderFailedResult(String errorMessage) {
                            customToast.setType(CustomToast.CustomToastType.WARNING);
                            customToast.setMessage(errorMessage);
                            customToast.show();
                            message = errorMessage;
                            result[0] = "error";
                        }
                    });
            return result[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            loading.dismissDialog();
            if(s.equalsIgnoreCase("success")){
                startActivity(new Intent(Activity_ItemCart.this, Activity_Orders.class));
                finish();
                if(new Activity_Redeemables().isOpen) {
                    new Activity_Redeemables();
                }
            } else {
                customToast.setType(CustomToast.CustomToastType.WARNING);
                customToast.setMessage(message);
                customToast.show();
            }
            this.cancel(true);
        }
    }
}
