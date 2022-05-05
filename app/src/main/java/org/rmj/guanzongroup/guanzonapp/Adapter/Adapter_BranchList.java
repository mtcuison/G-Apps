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
    private static final int VIEW_HEAD = 0;
    private final List<EBranchInfo> poBranchs;
    private final boolean isMotor;

    public Adapter_BranchList(List<EBranchInfo> foBranchs, boolean isMotor){
        this.poBranchs = foBranchs;
        this.isMotor = isMotor;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_HEAD) {
            View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_branch_list_head, parent, false);
            return new HeadImageHolder(viewItem);
        } else {
            View viewItem1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_branch_list_content, parent, false);
            return new ViewHolderItem(viewItem1);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        EBranchInfo loBranch = poBranchs.get(position);
        if(holder instanceof HeadImageHolder) {
            if(isMotor) {

            } else {

            }
//            ((HeadImageHolder) holder).imgHeader.setImageBitmap();
        } else if(holder instanceof ViewHolderItem) {
            ((ViewHolderItem) holder).txtBranch.setText(loBranch.getBranchNm());
            ((ViewHolderItem) holder).txtAddrss.setText(loBranch.getAddressx());
        }
    }

    @Override
    public int getItemCount() {
        return poBranchs.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class HeadImageHolder extends RecyclerView.ViewHolder{

        public ImageView imgHeader;

        public HeadImageHolder(@NonNull View itemView) {
            super(itemView);
            this.imgHeader = itemView.findViewById(R.id.img_header);
        }

    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public TextView txtBranch, txtAddrss;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            this.txtBranch = itemView.findViewById(R.id.txt_branch_name);
            this.txtAddrss = itemView.findViewById(R.id.txt_address);
        }

    }
}
