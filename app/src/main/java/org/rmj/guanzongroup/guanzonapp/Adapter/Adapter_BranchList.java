package org.rmj.guanzongroup.guanzonapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.List;

public class Adapter_BranchList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<EBranchInfo> poBranchs;
    private final OnBranchClickListener poListener;

    public interface OnBranchClickListener{
        void OnClick(String args);
    }

    public Adapter_BranchList(List<EBranchInfo> foBranchs, OnBranchClickListener listener) {
        this.poBranchs = foBranchs;
        this.poListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_branch_list_content, parent, false);
        return new ViewHolderItem(viewItem1, poListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        EBranchInfo loBranch = poBranchs.get(position);
        ((ViewHolderItem) holder).sBranchCd = loBranch.getBranchCd();
        ((ViewHolderItem) holder).txtBranch.setText(loBranch.getBranchNm());
        ((ViewHolderItem) holder).txtAddrss.setText(loBranch.getAddressx());
    }

    @Override
    public int getItemCount() {
        return poBranchs.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public String sBranchCd = "";
        public TextView txtBranch, txtAddrss;

        public ViewHolderItem(@NonNull View itemView, OnBranchClickListener listener) {
            super(itemView);
            this.txtBranch = itemView.findViewById(R.id.txt_branch_name);
            this.txtAddrss = itemView.findViewById(R.id.txt_address);

            itemView.setOnClickListener(view -> listener.OnClick(sBranchCd));
        }
    }
}
