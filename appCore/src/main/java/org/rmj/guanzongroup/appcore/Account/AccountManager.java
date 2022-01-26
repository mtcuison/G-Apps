package org.rmj.guanzongroup.appcore.Account;

import android.content.Context;

import org.json.JSONObject;
import org.rmj.guanzongroup.appcore.Account.Obj.AccountDetail;

public class AccountManager {
    private static final String TAG = AccountManager.class.getSimpleName();

    private Context mContext;

    public AccountManager(Context mContext) {
        this.mContext = mContext;
    }

    public void initAccount(JSONObject foAccount) throws Exception{
        AccountInfo loInfo = new AccountInfo(mContext);
        loInfo.setFullName("");
        loInfo.setGender("");
        loInfo.setBirthdate("");
        loInfo.setBirthplace("");
        loInfo.setCitizenship("");
        loInfo.setTaxId("");
        loInfo.setEmailAdd("");
        loInfo.setMobileNo("");
        loInfo.setPassword("");
        loInfo.setAddress("");
    }
}
