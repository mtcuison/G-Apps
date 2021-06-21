package org.rmj.guanzongroup.guanzonapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.g3appdriver.Database.Entities.EBranchInfo;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Branches;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Branch extends RecyclerView.Adapter<Adapter_Branch.MobitekBranchViewHolder>{

    private List<EBranchInfo> branchesList;
    private List<EBranchInfo> filteredBranchList;
    private Context mContext;
    private BranchFilter branchFilter;
    private boolean isSearch;

    private onBranchClickListener onBranchClickListener;

    public Adapter_Branch(Context context, List<EBranchInfo> branchesList, boolean isSearch){
        this.mContext = context;
        this.branchesList = branchesList;
        this.filteredBranchList = branchesList;
        this.branchFilter = new BranchFilter(Adapter_Branch.this);
        this.isSearch = isSearch;
    }

    public void setOnBranchClickListener(onBranchClickListener listener){
        this.onBranchClickListener = listener;
    }

    @NonNull
    @Override
    public MobitekBranchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View branchView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_branches, parent, false);
        return new MobitekBranchViewHolder(branchView, onBranchClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MobitekBranchViewHolder holder, int position) {
        holder.obj_branches = filteredBranchList.get(position);
        EBranchInfo branches = filteredBranchList.get(position);

        if(!isSearch) {
            holder.imgBranchIcon.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.animation_list_icon_fade_scale));
            holder.listContent.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.animation_list_content_fade_translate));
        }

        holder.lblBranchName.setText(branches.getBranchNm());
        holder.lblBranchAddress.setText(branches.getAddressx());
    }

    @Override
    public int getItemCount() {
        return filteredBranchList.size();
    }

    public BranchFilter getBranchFilter() {
        return branchFilter;
    }

    static class MobitekBranchViewHolder extends RecyclerView.ViewHolder{

        EBranchInfo obj_branches;

        TextView lblBranchName;
        TextView lblBranchAddress;
        LinearLayout listContent;
        ImageView imgBranchIcon;


        MobitekBranchViewHolder(@NonNull View itemView, final onBranchClickListener listener) {
            super(itemView);

            lblBranchName = itemView.findViewById(R.id.lbl_list_item_branchName);
            lblBranchAddress = itemView.findViewById(R.id.lbl_list_item_branchAdds);
            listContent = itemView.findViewById(R.id.linear_list_item_branch_content);
            imgBranchIcon = itemView.findViewById(R.id.img_list_item_branches);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onClick(position,
                                    obj_branches.getBranchNm(),
                                    obj_branches.getAddressx(),
                                    obj_branches.getTelNumbr(),
                                    obj_branches.getContactx(),
                                    obj_branches.getEmailAdd());

                        }
                    }
                }
            });
        }
    }

    public interface onBranchClickListener{
        void onClick(int position, String BranchName, String Address, String Mobile, String PhoneNo, String Email);
    }

    public class BranchFilter extends Filter{

        private Adapter_Branch adapter;

        BranchFilter(Adapter_Branch adapter){
            super();
            this.adapter = adapter;
        }

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            final FilterResults results = new FilterResults();
            if(constraint.length() == 0){
                filteredBranchList.addAll(branchesList);
            } else {
                List<EBranchInfo> filtereSearch = new ArrayList<>();
                for(EBranchInfo branches : branchesList){
                    if(branches.getBranchNm().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filtereSearch.add(branches);
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
