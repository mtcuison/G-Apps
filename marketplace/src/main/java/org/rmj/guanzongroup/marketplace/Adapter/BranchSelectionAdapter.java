/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.creditApp
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:17 PM
 */

package org.rmj.guanzongroup.marketplace.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.dev.Database.Entities.EBranchInfo;
import org.rmj.guanzongroup.marketplace.R;

import java.util.ArrayList;
import java.util.List;

public class BranchSelectionAdapter extends RecyclerView.Adapter<BranchSelectionAdapter.ClientInfoViewHolder> implements Filterable{

    private List<EBranchInfo> plBranch;
    private List<EBranchInfo> plBranch1;
    private List<EBranchInfo> plSchList;
    private List<EBranchInfo> filteredList;
    private BranchSelectionAdapter.OnVoidApplicationListener onVoidApplicationListener;
    private BranchSelectionAdapter.OnExportGOCASListener onExportGOCASListener;
    private BranchSelectionAdapter.OnApplicationClickListener onApplicationClickListener;

    public BranchSelectionAdapter(List<EBranchInfo> plBranch, BranchSelectionAdapter.OnApplicationClickListener onApplicationClickListener) {
        this.plBranch = plBranch;
        this.plBranch1 = plBranch;
        this.onApplicationClickListener = onApplicationClickListener;
//        this.poSearch = new SearchFilter();
    }
    public interface OnItemClickListener {
        void OnClick(int position);

        void OnActionButtonClick();
    }
    @NonNull
    @Override
    public BranchSelectionAdapter.ClientInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_branch_selection, parent, false);
        return new BranchSelectionAdapter.ClientInfoViewHolder(view,onApplicationClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientInfoViewHolder holder, int position) {
        EBranchInfo poBranch = plBranch.get(position);
        holder.lblBranchName.setText(poBranch.getBranchNm());
        holder.lblBranchAddress.setText(poBranch.getAddressx());
    }

    @Override
    public int getItemCount() {
        return plBranch.size();
    }

//    public SearchFilter getSearchFilter(){
//        return poSearch;
//    }
    public class ClientInfoViewHolder extends RecyclerView.ViewHolder{

        TextView lblBranchName;
        TextView lblBranchAddress;

        public ClientInfoViewHolder(@NonNull View itemView, BranchSelectionAdapter.OnApplicationClickListener onApplicationClickListener) {
            super(itemView);

            lblBranchName = itemView.findViewById(R.id.lbl_branch_selection_branchName);
            lblBranchAddress = itemView.findViewById(R.id.lbl_branch_selection_branchAddress);
            itemView.setOnClickListener(v12 -> {
                if(BranchSelectionAdapter.this.onApplicationClickListener !=null){
                    int lnPos = getAdapterPosition();
                    if(lnPos != RecyclerView.NO_POSITION){
                        BranchSelectionAdapter.this.onApplicationClickListener.OnClick(lnPos, plBranch);
                    }
                }
            });
        }
    }


    public interface OnVoidApplicationListener{
        void OnVoid(int position, String TransNox);
    }

    public interface OnApplicationClickListener{
        void OnClick(int position, List<EBranchInfo> loanList);
    }

    public interface OnExportGOCASListener{
        void onExport(String GOCAS, String ClientName,String DateApplied);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty() || charString.length()==0 || charString == null) {
                    plBranch = plBranch1;

                } else {
                    filteredList = new ArrayList<>();
                    for (EBranchInfo row : plBranch1) {
                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or category in match match
                        if (row.getBranchNm().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }

                    }

                    plBranch = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = plBranch;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                plBranch = (ArrayList<EBranchInfo>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
