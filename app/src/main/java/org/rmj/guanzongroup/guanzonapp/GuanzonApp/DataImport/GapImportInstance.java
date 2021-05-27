package org.rmj.guanzongroup.guanzonapp.GuanzonApp.DataImport;

import android.content.Context;

public interface GapImportInstance {
    void sendRequest(Context context, onImportResultListener listener);
}

