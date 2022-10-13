package org.rmj.guanzongroup.useraccount.ViewModel;

public interface OnSubmitIDPictureListener {
    void OnSubmit(String title, String message);
    void OnSuccess(String args);
    void OnFailed(String message);
}
