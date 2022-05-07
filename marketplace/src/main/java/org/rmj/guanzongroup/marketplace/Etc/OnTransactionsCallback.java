package org.rmj.guanzongroup.marketplace.Etc;

public interface OnTransactionsCallback {
    void onLoading();
    void onSuccess(String fsMessage);
    void onFailed(String fsMessage);
}
