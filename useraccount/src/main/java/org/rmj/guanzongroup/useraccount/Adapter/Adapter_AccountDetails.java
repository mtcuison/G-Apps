package org.rmj.guanzongroup.useraccount.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import org.rmj.guanzongroup.useraccount.Model.AccountDetailsInfo;
import org.rmj.guanzongroup.useraccount.R;

import java.util.List;

public class Adapter_AccountDetails extends RecyclerView.Adapter<Adapter_AccountDetails.ViewHolderItem> {

    private final List<AccountDetailsInfo> poAcctInf;
    private final AdapterCallback poCallBck;

    public Adapter_AccountDetails(List<AccountDetailsInfo> foAcctInf, AdapterCallback foCallBck){
        this.poAcctInf = foAcctInf;
        this.poCallBck = foCallBck;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_menu_item, parent, false);
        return new ViewHolderItem(viewItem, poCallBck);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        Log.e("TAG", String.valueOf(position));
        AccountDetailsInfo loDetail = poAcctInf.get(position);
        holder.isHeader = loDetail.isHeader();
        holder.isContent = loDetail.isContent();
        if(loDetail.isHeader() == View.VISIBLE) {
            holder.menuHead.setVisibility(loDetail.isHeader());
            holder.menuItem.setVisibility(View.GONE);
            holder.lblHeadTitle.setText(loDetail.getHeader());
        } else if(loDetail.isContent() == View.VISIBLE) {
            holder.menuHead.setVisibility(View.GONE);
            holder.menuItem.setVisibility(loDetail.isContent());
            holder.lblMenuTitle.setText(loDetail.getLabel());
            holder.txtData.setText("".equalsIgnoreCase(loDetail.getContent()) ? "Set Now" : loDetail.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return poAcctInf.size();
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder {
        public int isHeader, isContent;
        public ConstraintLayout menuItem, menuHead;
        public TextView lblEdit, lblHeadTitle, lblMenuTitle, txtData;

        public ViewHolderItem(@NonNull View itemView, AdapterCallback loCallBck) {
            super(itemView);
            lblEdit = itemView.findViewById(R.id.lbl_edit);
            menuItem = itemView.findViewById(R.id.menu_item);
            menuHead = itemView.findViewById(R.id.menu_header);
            lblHeadTitle = itemView.findViewById(R.id.lblMenuHeader);
            lblMenuTitle = itemView.findViewById(R.id.lblMenuTitle);
            txtData = itemView.findViewById(R.id.txtData);

            lblEdit.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION && isHeader == View.VISIBLE) {
                    loCallBck.onEditClick(lblHeadTitle.getText().toString().trim());
                }
            });
        }

    }

    public interface AdapterCallback {
        void onEditClick(String fsLabel);
    }

}
