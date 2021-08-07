package org.rmj.guanzongroup.guanzonapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.lifecycle.ViewModelProviders;
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
import org.rmj.guanzongroup.guanzonapp.R;
import org.rmj.guanzongroup.guanzonapp.ViewModel.VMRedeemables;

import java.util.ArrayList;
import java.util.List;

public class Activity_Redeemables extends AppCompatActivity {
    private final static String TAG = Activity_Redeemables.class.getSimpleName();
    private VMRedeemables mViewModel;
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
//        orderItems.setVisibility(getBadgeVisibility());
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

    private void setupWidgets(){
        mViewModel = ViewModelProviders.of(Activity_Redeemables.this).get(VMRedeemables.class);
        Toolbar toolbar = findViewById(R.id.toolbar_redeemables);
        toolbar.setTitle("Redeemables");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        layout = findViewById(R.id.linear_emptyList);

        recyclerView = findViewById(R.id.recycler_view_redeemables);
    }

    private void setupRedeemables(){
        mViewModel.getRedeemablesList().observe(Activity_Redeemables.this, foRedeems -> {
            try {
                if (foRedeems.size() > 0) {
                    mViewModel.getGcardInfo().observe(Activity_Redeemables.this, eGcardApp -> {
                        try {
                            layout.setVisibility(View.GONE);
                            Adapter_Redeemables adapter = new Adapter_Redeemables(Activity_Redeemables.this,
                                    eGcardApp, foRedeems, (String TransNo, String Redeemable, String Points, byte[] image_data) -> {
                                // TODO: Adapter Onclick
                            });

                            recyclerView.setAdapter(adapter);
                            LinearLayoutManager layoutManager = new LinearLayoutManager(Activity_Redeemables.this);
                            layoutManager.setOrientation(RecyclerView.VERTICAL);
                            recyclerView.setLayoutManager(layoutManager);
                            adapter.notifyDataSetChanged();
                        } catch (NullPointerException e) {
                            e.printStackTrace();
                        }
                    });
                } else {
                    layout.setVisibility(View.VISIBLE);
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        });
    }

//    private int getBadgeVisibility(){
//        mViewModel.getRedeemablesList().observe(Activity_Redeemables.this, fnCount -> {
//            if (new CartManager(Activity_Redeemables.this).getCartItemCount() == 0) {
//                return View.GONE;
//            }
//            return View.VISIBLE;
//        }
//    }

    public static Activity_Redeemables getInstance(){
        return instance;
    }

    public void setBadgeView() {
        mViewModel.getRedeemablesList().observe(Activity_Redeemables.this, fnCount -> {
            orderItems.setVisibility(View.VISIBLE);
            orderItems.setText(String.valueOf(fnCount));
        });
    }
}