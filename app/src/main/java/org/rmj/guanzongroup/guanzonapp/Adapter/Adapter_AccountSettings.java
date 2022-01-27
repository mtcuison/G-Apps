package org.rmj.guanzongroup.guanzonapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.rmj.guanzongroup.guanzonapp.R;

import java.util.ArrayList;

public class Adapter_AccountSettings extends RecyclerView.Adapter<Adapter_AccountSettings.SettingsMenuHolder> {

    private final ArrayList<String[]> poMenuLst;

    public Adapter_AccountSettings(ArrayList<String[]> foMenuLst){
        this.poMenuLst = foMenuLst;
    }

    @NonNull
    @Override
    public SettingsMenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_menu_list, parent, false);
        return new SettingsMenuHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsMenuHolder holder, int position) {
        String[] loMenu = poMenuLst.get(position);
        holder.lblMenuTitle.setText(loMenu[0]);
        holder.lblDescription.setText(loMenu[1]);
    }

    @Override
    public int getItemCount() {
        return poMenuLst.size();
    }

    public static class SettingsMenuHolder extends RecyclerView.ViewHolder{

        public TextView lblMenuTitle;
        public TextView lblDescription;

        public SettingsMenuHolder(@NonNull View itemView) {
            super(itemView);
            lblMenuTitle = itemView.findViewById(R.id.lblMenuTitle);
            lblDescription = itemView.findViewById(R.id.lblDescription);
        }
    }

}
