package org.rmj.guanzongroup.ganado.Activities;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

import org.rmj.g3appdriver.etc.LoadDialog;
import org.rmj.g3appdriver.etc.MessageBox;
import org.rmj.guanzongroup.ganado.Adapter.InquiryListAdapter;
import org.rmj.guanzongroup.ganado.R;
import org.rmj.guanzongroup.ganado.ViewModel.VMInquiry;

import java.util.Objects;

public class Activity_Inquiries extends AppCompatActivity {

    private VMInquiry mViewModel;
    private RecyclerView rvInquiries;
    private InquiryListAdapter inquiryList;
    private LoadDialog poLoad;
    private MessageBox poMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(VMInquiry.class);
        setContentView(R.layout.activity_inquiries);
        intWidgets();

        poLoad = new LoadDialog(Activity_Inquiries.this);
        poMessage = new MessageBox(Activity_Inquiries.this);

        mViewModel.ImportCriteria(new VMInquiry.OnTaskExecute() {
            @Override
            public void OnExecute() {
                poLoad.initDialog("Product Inquiry", "Checking data. Please wait...", false);
                poLoad.show();
            }

            @Override
            public void OnSuccess() {
                poLoad.dismiss();
            }

            @Override
            public void OnFailed(String message) {
                poLoad.dismiss();
                poMessage.initDialog();
                poMessage.setTitle("Product Inquiry");
                poMessage.setMessage(message);
                poMessage.setPositiveButton("Okay", new MessageBox.DialogButton() {
                    @Override
                    public void OnButtonClick(View view, AlertDialog dialog) {
                        dialog.dismiss();
                    }
                });
                poMessage.show();
            }
        });
        mViewModel.GetInquiries().observe(Activity_Inquiries.this, inquiries ->{
            if (inquiries.size() > 0){
                InquiryListAdapter adapter= new InquiryListAdapter(getApplication(), inquiries, new InquiryListAdapter.OnModelClickListener() {
                    @Override
                    public void OnClick(String TransNox) {
                        Intent intent = new Intent(Activity_Inquiries.this, Activity_ProductSelection.class);
                        intent.putExtra("TransNox",TransNox);
                        startActivity(intent);
                        overridePendingTransition(R.anim.anim_intent_slide_in_left, R.anim.anim_intent_slide_out_right);
                        finish();

                    }

                });

                rvInquiries.setAdapter(adapter);
                rvInquiries.setLayoutManager(new LinearLayoutManager(Activity_Inquiries.this,RecyclerView.VERTICAL,false));

            }
        });
    }
    private void intWidgets(){
        MaterialToolbar toolbar = findViewById(R.id.toolbar_Inquiries);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        rvInquiries = findViewById(R.id.rvInquiries);
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_intent_slide_in_left, R.anim.anim_intent_slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}