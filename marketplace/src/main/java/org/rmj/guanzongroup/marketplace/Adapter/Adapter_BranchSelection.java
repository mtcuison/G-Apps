package org.rmj.guanzongroup.marketplace.Adapter;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.marketplace.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_BranchSelection extends RecyclerView.Adapter<Adapter_BranchSelection.BranchViewHolder> {

//    private List<EBranchInfo> EBranchInfoList;
//    private List<EBranchInfo> filteredSearchBranch;
//    private onBranchContentClickListener onBranchContentClickListener;
//    private BranchFilter branchFilter;

//    public Adapter_BranchSelection(List<EBranchInfo> EBranchInfos, onBranchContentClickListener listener){
//        this.EBranchInfoList = EBranchInfos;
//        this.onBranchContentClickListener = listener;
//        this.filteredSearchBranch = EBranchInfos;
//        this.branchFilter = new BranchFilter(Adapter_BranchSelection.this);
//    }

    @NonNull
    @Override
    public BranchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_branch_selection, parent, false);
        return new BranchViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull BranchViewHolder holder,int position) {
//        EBranchInfo EBranchInfo = filteredSearchBranch.get(position);
//
//        holder.lblBranchName.setText(EBranchInfo.getBranchNm());
//        holder.lblBranchAdd.setText(EBranchInfo.getAddressx());
//        holder.branchContent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBranchContentClickListener.onClick(
//                        EBranchInfo
////                        filteredSearchBranch.get(position).getBranchCd(),
////                        filteredSearchBranch.get(position).getBranchNm(),
////                        filteredSearchBranch.get(position).getAddressx());
//                );
//            }
//        });
    }

    @Override
    public int getItemCount() {
//        return filteredSearchBranch.size();
        return 0;
    }

//    public BranchFilter getBranchFilter() {
//        return branchFilter;
//    }

    static class BranchViewHolder extends RecyclerView.ViewHolder{

        LinearLayout branchContent;
        TextView lblBranchName;
        TextView lblBranchAdd;

        BranchViewHolder(@NonNull View itemView) {
            super(itemView);

            branchContent = itemView.findViewById(R.id.linear_branch_content);
            lblBranchName = itemView.findViewById(R.id.lbl_branch_selection_branchName);
            lblBranchAdd = itemView.findViewById(R.id.lbl_branch_selection_branchAddress);
        }
    }

//    public interface onBranchContentClickListener{
//        void onClick(String BranchCode, String BranchName, String BranchAddress);
//    }

//    public interface onBranchContentClickListener{
//        void onClick(EBranchInfo eBranchInfo);
//    }
//
//    public class BranchFilter extends Filter{
//        private Adapter_BranchSelection adapter;
//        BranchFilter(Adapter_BranchSelection adapter){
//            super();
//            this.adapter = adapter;
//        }
//
//        @RequiresApi(api = Build.VERSION_CODES.N)
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            final FilterResults results = new FilterResults();
//            if(constraint.length() == 0){
//                filteredSearchBranch.addAll(EBranchInfoList);
//            } else {
//                List<EBranchInfo> filteredList = new ArrayList<>();
//               for(EBranchInfo filteredBranches : EBranchInfoList){
//                   if (filteredBranches.getBranchNm().toLowerCase().contains(constraint.toString().toLowerCase())) {
//                       filteredList.add(filteredBranches);
//                   }
//               }
//               filteredSearchBranch = filteredList;
//            }
//            results.values = filteredSearchBranch;
//            results.count = filteredSearchBranch.size();
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            adapter.filteredSearchBranch = (List<EBranchInfo>) results.values;
//            this.adapter.notifyDataSetChanged();
//        }
//    }
}
