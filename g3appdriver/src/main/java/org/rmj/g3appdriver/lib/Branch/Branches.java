package org.rmj.g3appdriver.lib.Branch;

import android.content.Context;

import org.rmj.g3appdriver.lib.Branch.Obj.MCBranch;
import org.rmj.g3appdriver.lib.Branch.Obj.MPBranch;

public class Branches {
    private static final String TAG = Branches.class.getSimpleName();

    private final Context mContext;

    private String message;

    public Branches(Context context) {
        this.mContext = context;
    }

    public String getMessage() {
        return message;
    }

    public boolean ImportBranchList(){
        try{

            return true;
        } catch (Exception e){
            e.printStackTrace();
            message = e.getMessage();
            return false;
        }
    }

    public iBranch InitBranch(GBRANCHES instance){
        switch (instance){
            case MOTORCYCLE:
                return new MCBranch(mContext);
            case MOBILE_PHONE:
                return new MPBranch(mContext);
            default:
                return null;
        }
    }
}
