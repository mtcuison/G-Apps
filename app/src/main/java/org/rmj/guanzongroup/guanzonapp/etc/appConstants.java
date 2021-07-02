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

package org.rmj.guanzongroup.guanzonapp.etc;

import androidx.fragment.app.Fragment;

import org.rmj.guanzongroup.guanzonapp.Fragments.Branches.Fragment_Branches;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Notifications;
import org.rmj.guanzongroup.guanzonapp.Fragments.Notification.Fragment_Promotions;
import org.rmj.guanzongroup.guanzonapp.Fragments.Dashboard.Fragment_NewsFeed;
import org.rmj.guanzongroup.guanzonapp.Fragments.Fragment_About;

public class appConstants {
    public static Fragment[] getHomePages(boolean val){
        if (val){
            return APPLICATION_CLIENT_PAGES;
        } else {

            return APPLICATION_DASHBOARD_PAGES;
        }
    }

    public static String[] getHomeTitles(boolean val){
        if (val){
            return APPLICATION_CLIENT_TITLES;
        } else {

            return APPLICATION_DASHBOARD_TITLES;
        }
    }


    public static final Fragment[] APPLICATION_DASHBOARD_PAGES = {
            new Fragment_NewsFeed(),
            new Fragment_Promotions(),
            new Fragment_Branches(),
            new Fragment_About()
    };
    public static final Fragment[] APPLICATION_CLIENT_PAGES = {
            new Fragment_DashBoard(),
            new Fragment_Notifications(),
            new Fragment_Branches(),
            new Fragment_About()
    };
    public static final String[] APPLICATION_DASHBOARD_TITLES = {
            "Dashboard",
            "Promos",
            "Find Us",
            "About Us"
    };
    public static final String[] APPLICATION_CLIENT_TITLES = {"Client Portal",
            "Promos",
            "Find Us",
            "About Us"
    };

}
