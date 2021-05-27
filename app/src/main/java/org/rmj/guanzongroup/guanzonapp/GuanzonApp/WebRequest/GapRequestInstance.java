package org.rmj.guanzongroup.guanzonapp.GuanzonApp.WebRequest;

import android.content.Context;

public interface GapRequestInstance {
    void sendRequest(Context context, onSendRequestResultListener listener);

    interface onSendRequestResultListener{
        void onSuccessResult();
        void onErrorResult(String ErrorMessage);
    }
}
