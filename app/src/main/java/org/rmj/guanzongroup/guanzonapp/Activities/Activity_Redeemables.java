package org.rmj.guanzongroup.guanzonapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_Redeemables;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.RedeemableItems;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.Redeemables;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Transaction.CartManager;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.ArrayList;
import java.util.List;

public class Activity_Redeemables extends AppCompatActivity {
    @SuppressLint("StaticFieldLeak")
    private static Activity_Redeemables instance;
    public boolean isOpen = false;

    private RecyclerView recyclerView;
    private TextView orderItems;
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        isOpen = true;
        setContentView(R.layout.activity_redeemables);
        setupWidgets();
        setupRedeemables();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_redeemables_menu_cart, menu);
        MenuItem itemCart = menu.findItem(R.id.menu_action_item_redeemable_cart);
        View ActionView = MenuItemCompat.getActionView(itemCart);
        orderItems = ActionView.findViewById(R.id.lbl_item_on_cart_count);
        int itemsOnCart = new CartManager(Activity_Redeemables.this).getCartItemCount();
        orderItems.setVisibility(getBadgeVisibility());
        orderItems.setText(String.valueOf(itemsOnCart));
        ImageButton btnCart = ActionView.findViewById(R.id.btn_action_redeemable_cart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Redeemables.this, Activity_ItemCart.class));
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    protected void onDestroy() {
        isOpen = false;
        super.onDestroy();
    }

    public static Activity_Redeemables getInstance(){
        return instance;
    }

    public void setBadgeView(){
        orderItems.setVisibility(View.VISIBLE);
        orderItems.setText(String.valueOf(new CartManager(Activity_Redeemables.this).getCartItemCount()));
    }

    private void setupWidgets(){
        Toolbar toolbar = findViewById(R.id.toolbar_redeemables);
        toolbar.setTitle("Redeemables");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        layout = findViewById(R.id.linear_emptyList);

        recyclerView = findViewById(R.id.recycler_view_redeemables);
    }

    private void setupRedeemables(){
        Redeemables redeemables = new Redeemables(Activity_Redeemables.this);
        ArrayList<ArrayList> arr_redeemables;
        List<RedeemableItems> redeemableItemsList = new ArrayList<>();
        arr_redeemables = redeemables.getRedeemables();

        if(arr_redeemables.get(0).size()>0){
            layout.setVisibility(View.GONE);
            for(int x = 0; x < arr_redeemables.get(0).size(); x++){
                RedeemableItems redeemableItems = new RedeemableItems((String) arr_redeemables.get(0).get(x),
                        (String) arr_redeemables.get(1).get(x),
                        (String) arr_redeemables.get(2).get(x),
                        (byte[]) arr_redeemables.get(6).get(x),
                        (String) arr_redeemables.get(7).get(x));
                redeemableItemsList.add(redeemableItems);
            }
            Adapter_Redeemables adapter = new Adapter_Redeemables(Activity_Redeemables.this, redeemableItemsList);
            adapter.setOnRedeemableItemClickListener(new Adapter_Redeemables.onRedeemableItemClickListener() {
                @Override
                public void onClick(String TransNo, String Redeemable, String Points, byte[] image_data) {

                }
            });

            recyclerView.setAdapter(adapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(Activity_Redeemables.this);
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager);
        } else {
            layout.setVisibility(View.VISIBLE);
        }
    }

    private int getBadgeVisibility(){
        if(new CartManager(Activity_Redeemables.this).getCartItemCount() == 0){
            return View.GONE;
        }
        return View.VISIBLE;
    }

}
