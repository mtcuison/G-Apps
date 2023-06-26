package org.rmj.guanzongroup.guanzonapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.GConnect.room.Entities.EBranchInfo;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_BranchList extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<EBranchInfo> poBranchs;
    private List<EBranchInfo> filteredBranchList;
    private final OnBranchClickListener poListener;
    private final BranchFilter poFilter;

    public interface OnBranchClickListener{
        void OnClick(EBranchInfo args);
    }

    public Adapter_BranchList(List<EBranchInfo> foBranchs, OnBranchClickListener listener) {
        this.poBranchs = foBranchs;
        this.filteredBranchList = foBranchs;
        this.poFilter = new BranchFilter(Adapter_BranchList.this);
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
        EBranchInfo loBranch = filteredBranchList.get(position);
        ((ViewHolderItem) holder).loArgs = loBranch;
        ((ViewHolderItem) holder).txtBranch.setText(loBranch.getBranchNm());
        ((ViewHolderItem) holder).txtAddrss.setText(loBranch.getAddressx());
    }

    @Override
    public int getItemCount() {
        return filteredBranchList.size();
    }

    public BranchFilter Filter(){
        return poFilter;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class ViewHolderItem extends RecyclerView.ViewHolder{

        public EBranchInfo loArgs;
        public TextView txtBranch, txtAddrss;

        public ViewHolderItem(@NonNull View itemView, OnBranchClickListener listener) {
            super(itemView);
            this.txtBranch = itemView.findViewById(R.id.txt_branch_name);
            this.txtAddrss = itemView.findViewById(R.id.txt_bill_address);

            itemView.setOnClickListener(view -> listener.OnClick(loArgs));
        }
    }

    public class BranchFilter extends Filter {

        private final Adapter_BranchList adapter;

        BranchFilter(Adapter_BranchList adapter){
            super();
            this.adapter = adapter;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            final FilterResults results = new FilterResults();
            if(constraint.length() == 0){
                filteredBranchList = poBranchs;
            } else {
                List<EBranchInfo> filtereSearch = new ArrayList<>();
                for(EBranchInfo branch : poBranchs){
                    if(branch.getBranchNm().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filtereSearch.add(branch);
                    }
                }
                filteredBranchList = filtereSearch;
            }
            results.values = filteredBranchList;
            results.count = filteredBranchList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            adapter.filteredBranchList = (List<EBranchInfo>) results.values;
            this.adapter.notifyDataSetChanged();
        }
    }
}
