/*
 * Created by Android Team MIS-SEG Year 2021
 * Copyright (c) 2021. Guanzon Central Office
 * Guanzon Bldg., Perez Blvd., Dagupan City, Pangasinan 2400
 * Project name : GhostRider_Android
 * Module : GhostRider_Android.app
 * Electronic Personnel Access Control Security System
 * project file created : 4/24/21 3:19 PM
 * project file last modified : 4/24/21 3:17 PM
 */

package org.rmj.guanzongroup.guanzonapp.MeuModel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

import org.rmj.guanzongroup.guanzonapp.Adapters.ExpandableListDrawerAdapter;

import static org.rmj.guanzongroup.guanzonapp.Activities.MainActivity.expListView;
import static org.rmj.guanzongroup.guanzonapp.Activities.MainActivity.listAdapter;
import static org.rmj.guanzongroup.guanzonapp.Activities.MainActivity.listDataChild;
import static org.rmj.guanzongroup.guanzonapp.Activities.MainActivity.listDataHeader;

public class PopulateExpandableList {
    private static final String TAG = PopulateExpandableList.class.getSimpleName();

    /*Edited by Mike*/
    public void populate(Context context, OnHomeButtonClickListener listener) {
        listAdapter = new ExpandableListDrawerAdapter(context, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        expListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                if (listDataHeader.get(groupPosition).isGroup) {
                    if (!listDataHeader.get(groupPosition).hasChildren) {
                        if(groupPosition == 0){
                            if(listener != null){
                                listener.OnHomeButtonClick();
                            }
                        }
//                        if(groupPosition == 2){
//                            context.startActivity(new Intent(context, Activity_CollectionList.class));
//                        }
                    } else {
//                        for (int i = 0; i < listAdapter.getGroupCount(); i++) {
//                            if (i != groupPosition) {
//                                expListView.collapseGroup(i);
//                            }
//                        }

                    }
                }

                return false;
            }
        });

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                int childCount = listDataChild.get(listDataHeader.get(groupPosition)).size();

                Intent intent;
                switch (groupPosition)
                {
                    case 0:

                        break;
                }
                return false;
            }
        });
    }

    /*Added by mike
    * listener for handling Home Button on navigation menu*/
    public interface OnHomeButtonClickListener{
        void OnHomeButtonClick();
    }
}
