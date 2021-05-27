package org.rmj.guanzongroup.guanzonapp.Services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.rmj.guanzongroup.guanzonapp.Activities.Activity_DashBoard;
import org.rmj.guanzongroup.guanzonapp.Activities.Activity_LoadScreen;

public class ActionBroadCaster extends BroadcastReceiver {
    private static final String TAG = ActionBroadCaster.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        try {
            new Activity_DashBoard().getInstance().finish();
            intent = new Intent(context, Activity_LoadScreen.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            Log.e(TAG, "Broadcast has been receive.");
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(context, e.getMessage()+ " " + "From Broadcast manager", Toast.LENGTH_SHORT).show();
        }
    }
}
