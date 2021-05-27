package org.rmj.guanzongroup.guanzonapp.Dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.Activities.Activity_ItemCart;
import org.rmj.guanzongroup.guanzonapp.Adapters.Adapter_BranchSelection;
import org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database.BranchSelectionData;
import org.rmj.guanzongroup.guanzonapp.R;

public class Dialog_BranchSelection {
    private Context mContext;

    private View view;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;

    private RecyclerView recyclerView;
    private EditText txtSearch;
    private Adapter_BranchSelection adapter;

    public Dialog_BranchSelection(Context context){
        this.mContext = context;
        this.builder = new AlertDialog.Builder(mContext);
    }

    public void showDialog(){
        createDialog();
        dialog.show();
    }

    @SuppressLint("InflateParams")
    private void createDialog(){
        view = LayoutInflater.from(mContext).inflate(R.layout.dialog_branch_selection, null, false);
        builder.setView(view)
                .setCancelable(true);

        recyclerView = view.findViewById(R.id.recycler_view_dialog_branch_selection);
        txtSearch = view.findViewById(R.id.txt_dialog_branch_selection_search);
        txtSearch.addTextChangedListener(new searchFilterer());

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        adapter = new Adapter_BranchSelection(new BranchSelectionData(mContext).getBranches(), new Adapter_BranchSelection.onBranchContentClickListener() {
            @Override
            public void onClick(String BranchCode, String BranchName, String BranchAddress) {
                new Activity_ItemCart().getInstance().setBranchValue(BranchCode, BranchName);
                dialog.dismiss();
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }


    class searchFilterer implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            adapter.getBranchFilter().filter(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
