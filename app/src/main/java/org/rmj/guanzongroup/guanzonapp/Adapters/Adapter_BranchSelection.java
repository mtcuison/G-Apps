package org.rmj.guanzongroup.guanzonapp.Adapters;

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

import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.BranchSelection;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_BranchSelection extends RecyclerView.Adapter<Adapter_BranchSelection.BranchViewHolder> {

    private List<BranchSelection> branchSelectionList;
    private List<BranchSelection> filteredSearchBranch;
    private onBranchContentClickListener onBranchContentClickListener;
    private BranchFilter branchFilter;

    public Adapter_BranchSelection(List<BranchSelection> branchSelections, onBranchContentClickListener listener){
        this.branchSelectionList = branchSelections;
        this.onBranchContentClickListener = listener;
        this.filteredSearchBranch = branchSelections;
        this.branchFilter = new BranchFilter(Adapter_BranchSelection.this);
    }

    @NonNull
    @Override
    public BranchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_branch_selection, parent, false);
        return new BranchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BranchViewHolder holder, final int position) {
        BranchSelection branchSelection = filteredSearchBranch.get(position);

        holder.lblBranchName.setText(branchSelection.getBranchNme());
        holder.lblBranchAdd.setText(branchSelection.getBranchAdd());
        holder.branchContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBranchContentClickListener.onClick(
                        filteredSearchBranch.get(position).getBranchCde(),
                        filteredSearchBranch.get(position).getBranchNme(),
                        filteredSearchBranch.get(position).getBranchAdd());
            }
        });
    }

    @Override
    public int getItemCount() {
        return filteredSearchBranch.size();
    }

    public BranchFilter getBranchFilter() {
        return branchFilter;
    }

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

    public interface onBranchContentClickListener{
        void onClick(String BranchCode, String BranchName, String BranchAddress);
    }

    public class BranchFilter extends Filter{
        private Adapter_BranchSelection adapter;
        BranchFilter(Adapter_BranchSelection adapter){
            super();
            this.adapter = adapter;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            final FilterResults results = new FilterResults();
            if(constraint.length() == 0){
                filteredSearchBranch.addAll(branchSelectionList);
            } else {
                List<BranchSelection> filteredList = new ArrayList<>();
               for(BranchSelection filteredBranches : branchSelectionList){
                   if (filteredBranches.getBranchNme().toLowerCase().contains(constraint.toString().toLowerCase())) {
                       filteredList.add(filteredBranches);
                   }
               }
               filteredSearchBranch = filteredList;
            }
            results.values = filteredSearchBranch;
            results.count = filteredSearchBranch.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            adapter.filteredSearchBranch = (List<BranchSelection>) results.values;
            this.adapter.notifyDataSetChanged();
        }
    }
}
