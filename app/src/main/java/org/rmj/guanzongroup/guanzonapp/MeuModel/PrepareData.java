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
import android.view.View;

import org.rmj.g3appdriver.dev.DeptCode;
import org.rmj.g3appdriver.etc.SessionManager;
import org.rmj.guanzongroup.guanzonapp.R;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static org.rmj.guanzongroup.guanzonapp.Activities.MainActivity.listDataChild;
import static org.rmj.guanzongroup.guanzonapp.Activities.MainActivity.listDataHeader;

public class PrepareData {
    SessionManager sessionManager;
    public void prepareMenuData(Context mContext) {
        listDataHeader.clear();
        listDataChild.clear();
        sessionManager = new SessionManager(mContext);
        MenuModel menuModel = new MenuModel("Home", R.drawable.ic_menu_home, true, false , VISIBLE); //Menu of Android Tutorial. No sub menus
        listDataHeader.add(menuModel);

        if (!menuModel.hasChildren) {
            listDataChild.put(menuModel, null);
        }


    }
}
