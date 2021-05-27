package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.BranchSelection;

import java.util.ArrayList;
import java.util.List;

public class BranchSelectionData {
    private Context mContext;

    private AppData db;
    private List<BranchSelection> branchSelectionList;

    public BranchSelectionData(Context context){
        this.mContext = context;
        this.db = AppData.getInstance(mContext);
        this.branchSelectionList = new ArrayList<>();
    }

    public List<BranchSelection> getBranches(){
        Cursor cursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_branch WHERE sBranchCd LIKE '%M%'", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++){
                BranchSelection branchSelection = new BranchSelection(
                        cursor.getString(cursor.getColumnIndex("sBranchCd")),
                        cursor.getString(cursor.getColumnIndex("sBranchNm")),
                        cursor.getString(cursor.getColumnIndex("sAddressx")));
                branchSelectionList.add(branchSelection);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return branchSelectionList;
    }
}
