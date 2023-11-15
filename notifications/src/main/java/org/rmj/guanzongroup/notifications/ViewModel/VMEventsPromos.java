package org.rmj.guanzongroup.notifications.ViewModel;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.rmj.g3appdriver.dev.Database.Entities.EEvents;
import org.rmj.g3appdriver.dev.Database.Entities.EPromo;

import org.rmj.g3appdriver.lib.GCardCore.GCardSystem;
import org.rmj.g3appdriver.lib.GCardCore.iGCardSystem;

import java.util.List;

public class VMEventsPromos extends AndroidViewModel {
    private final iGCardSystem poSystem;
    private final Application instance;

    public VMEventsPromos(@NonNull Application application) {
        super(application);
        this.instance = application;
        this.poSystem = new GCardSystem(application).getInstance(GCardSystem.CoreFunctions.EXTRAS);
    }

    public LiveData<List<EEvents>> getEvents() {
        return poSystem.GetNewsEvents();
    }
    public LiveData<List<EPromo>> getPromos() {
        return poSystem.GetPromotions();
    }


    public void DownloadPromos(){
        new DownloadPromos().execute();
    }
    public void DownloadEvents(){
        new DownloadEvents().execute();
    }

    private class DownloadPromos extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                iGCardSystem loGcard = new GCardSystem(instance).getInstance(GCardSystem.CoreFunctions.EXTRAS);
                loGcard.DownloadPromotions(new GCardSystem.GCardSystemCallback() {
                    @Override
                    public void OnSuccess(String args) {
//                        Log.e("promos OnSuccess", args);
                    }

                    @Override
                    public void OnFailed(String message) {
                        Log.e("promos OnFailed", message);

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    private class DownloadEvents extends AsyncTask<String, Void, String> {

        @Override

        protected String doInBackground(String... strings) {
            try {
                iGCardSystem loGcard = new GCardSystem(instance).getInstance(GCardSystem.CoreFunctions.EXTRAS);
                loGcard.DownloadNewsEvents(new GCardSystem.GCardSystemCallback() {
                    @Override
                    public void OnSuccess(String args) {
                        Log.e("events OnSuccess", args);
                    }

                    @Override
                    public void OnFailed(String message) {
                        Log.e("events OnFailed", message);

                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}