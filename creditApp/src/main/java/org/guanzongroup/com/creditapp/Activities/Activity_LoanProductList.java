package org.guanzongroup.com.creditapp.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;

import com.google.android.material.textfield.TextInputEditText;

import org.guanzongroup.com.creditapp.Adapter.Adapter_LoanProductList;
import org.guanzongroup.com.creditapp.R;
import org.guanzongroup.com.creditapp.ViewModel.VMLoanProductList;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_Loading;
import org.rmj.g3appdriver.utils.Dialogs.Dialog_SingleButton;

import java.util.Objects;

public class Activity_LoanProductList extends AppCompatActivity {

    private VMLoanProductList mViewModel;

    private Toolbar toolbar;
    private TextInputEditText txtSearch;
    private RecyclerView recyclerView;
    private Dialog_Loading poLoad;
    private Dialog_SingleButton poDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(Activity_LoanProductList.this).get(VMLoanProductList.class);
        setContentView(R.layout.activity_loan_product_list);

        poLoad = new Dialog_Loading(Activity_LoanProductList.this);
        poDialog = new Dialog_SingleButton(Activity_LoanProductList.this);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Apply For A Loan");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        txtSearch = findViewById(R.id.txt_search);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(Activity_LoanProductList.this, 2, RecyclerView.VERTICAL, false));
        recyclerView.setHasFixedSize(true);

        InitializeProductList();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void InitializeProductList(){
        mViewModel.getProductList().observe(Activity_LoanProductList.this, products -> {
            try{
                if(products.size() > 0){
                    Adapter_LoanProductList loAdapter = new Adapter_LoanProductList(products, new Adapter_LoanProductList.OnItemClick() {
                        @Override
                        public void onClick(String fsListIdx) {
                            Intent loIntent = new Intent(Activity_LoanProductList.this, Activity_ItemPreview.class);
                            loIntent.putExtra("sListngID", fsListIdx);
                            startActivity(loIntent);
                            finish();
                        }

                        @Override
                        public void onApplyLoanClick(String fsListIdx, String BrandNme, String ModelID) {
                            Intent loIntent = new Intent(Activity_LoanProductList.this, Activity_LoanTerm.class);
                            loIntent.putExtra("sListngID", fsListIdx);
                            loIntent.putExtra("sModelIDx", BrandNme);
                            loIntent.putExtra("sUnitAppl", BrandNme);
                            loIntent.putExtra("sModelIDx", ModelID);
                            startActivity(loIntent);
                            finish();
                        }
                    });
                    recyclerView.setAdapter(loAdapter);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        });


        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}