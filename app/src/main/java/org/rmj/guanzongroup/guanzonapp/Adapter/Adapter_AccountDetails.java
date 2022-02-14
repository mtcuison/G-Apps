package org.rmj.guanzongroup.guanzonapp.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.Model.AccountDetailsInfo;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_AccountDetails extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_ITEM = 1;

    private final List<AccountDetailsInfo> poAcctInf;

    public Adapter_AccountDetails(List<AccountDetailsInfo> foAcctInf){
        this.poAcctInf = foAcctInf;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch(viewType) {
            case TYPE_HEADER:
                View viewHead = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_header_layout, parent, false);
                return new ViewHolderHeader(viewHead);

            case TYPE_ITEM:
                View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_menu_item, parent, false);
                return new ViewHolderItem(viewItem);

            default:
                throw new RuntimeException("There is no type that matches the type "
                        + viewType + " + make sure your using types correctly." +
                        " (See static attributes in the class.");
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e("TAG", String.valueOf(position));
        AccountDetailsInfo loDetail = poAcctInf.get(position);
        switch(holder.getItemViewType()) {
            case TYPE_HEADER:
                ((ViewHolderHeader) holder).lblMenuHeader.setText(loDetail.getHeader());
                break;
            case TYPE_ITEM:
                Log.e("Tuamtalon ka ba dito", "00");
                ((ViewHolderItem) holder).lblMenuTitle.setText(loDetail.getLabel());
                ((ViewHolderItem) holder).txtData.setText(loDetail.getContent());
                break;
        }
//        if(holder instanceof ViewHolderHeader) {
//            ((ViewHolderHeader) holder).lblMenuHeader.setText(loDetail.getHeader());
//        } else if(holder instanceof ViewHolderItem) {
//            ((ViewHolderItem) holder).lblMenuTitle.setText(loDetail.getLabel());
//            ((ViewHolderItem) holder).txtData.setText(loDetail.getContent());
//        }

    }

    @Override
    public int getItemCount() {
        return poAcctInf.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(!"".equalsIgnoreCase(poAcctInf.get(position).getHeader()))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    public static class ViewHolderHeader extends RecyclerView.ViewHolder{

        public TextView lblMenuHeader;

        public ViewHolderHeader(@NonNull View itemView) {
            super(itemView);
            lblMenuHeader = itemView.findViewById(R.id.lblMenuHeader);
        }
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public TextView lblMenuTitle, txtData;

        public ViewHolderItem(@NonNull View itemView) {
            super(itemView);
            lblMenuTitle = itemView.findViewById(R.id.lblMenuTitle);
            txtData = itemView.findViewById(R.id.txtData);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
//                    callBack.onClick(position);
                }
            });
        }

    }

}
