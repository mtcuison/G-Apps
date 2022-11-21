package org.rmj.guanzongroup.useraccount.ViewModel;

import org.rmj.g3appdriver.lib.Account.Obj.UserIdentification;

import java.util.List;

public interface OnImportIDTypeListener {
    void OnImportIDType(String title, String message);
    void OnSuccess(List<UserIdentification> args);
    void OnFailed(String message);
}
