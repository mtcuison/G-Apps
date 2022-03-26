package org.rmj.guanzongroup.guanzonapp.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.Model.AccountDetailsInfo;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_AccountDetails extends RecyclerView.Adapter<Adapter_AccountDetails.ViewHolderItem> {

    private final List<AccountDetailsInfo> poAcctInf;

    public Adapter_AccountDetails(List<AccountDetailsInfo> foAcctInf){
        this.poAcctInf = foAcctInf;
    }

    @NonNull
    @Override
    public ViewHolderItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_menu_item, parent, false);
        return new ViewHolderItem(viewItem);
    }

    @Override
    public void onBindViewHolder(ViewHolderItem holder, int position) {
        Log.e("TAG", String.valueOf(position));
        AccountDetailsInfo loDetail = poAcctInf.get(position);
        holder.isHeader = loDetail.isHeader();
        holder.isContent = loDetail.isContent();
        if(loDetail.isHeader() == View.VISIBLE) {
            holder.lblHeadTitle.setVisibility(loDetail.isHeader());
            holder.menuItem.setVisibility(View.GONE);
            holder.lblHeadTitle.setText(loDetail.getHeader());
        } else if(loDetail.isContent() == View.VISIBLE) {
            holder.lblHeadTitle.setVisibility(View.GONE);
            holder.menuItem.setVisibility(loDetail.isContent());
            holder.lblMenuTitle.setText(loDetail.getLabel());
            holder.txtData.setText("".equalsIgnoreCase(loDetail.getContent()) ? "Set Now" : loDetail.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return poAcctInf.size();
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{
        public int isHeader, isContent;
        public ConstraintLayout menuItem;
        public TextView lblHeadTitle, lblMenuTitle, txtData;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            menuItem = itemView.findViewById(R.id.menu_item);
            lblHeadTitle = itemView.findViewById(R.id.lblMenuHeader);
            lblMenuTitle = itemView.findViewById(R.id.lblMenuTitle);
            txtData = itemView.findViewById(R.id.txtData);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION && isContent == View.VISIBLE) {
//                    callBack.onClick(position);
                }
            });
        }

    }

}
