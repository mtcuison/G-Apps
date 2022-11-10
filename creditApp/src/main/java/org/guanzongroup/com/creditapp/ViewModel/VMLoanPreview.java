package org.guanzongroup.com.creditapp.ViewModel;

import android.app.Application;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class VMLoanPreview extends AndroidViewModel {
    private static final String TAG = VMLoanPreview.class.getSimpleName();

    public interface OnInitializeInfo{
        void OnLoad(String title, String message);
        void OnSuccess();
        void OnFailed(String message);
    }

    public VMLoanPreview(@NonNull Application application) {
        super(application);
    }

    public void InitIntentData(Intent foVal){
        String sListngID, nMinDownx, nMonAmort;
    }

    public void InitializeApplicantInfo()
}
