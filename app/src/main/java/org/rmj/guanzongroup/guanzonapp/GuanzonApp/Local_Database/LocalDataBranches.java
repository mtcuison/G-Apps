package org.rmj.guanzongroup.guanzonapp.GuanzonApp.Local_Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.rmj.g3appdriver.dev.AppData;
import org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects.Branches;

import java.util.ArrayList;
import java.util.List;

public class LocalDataBranches {
    private static final String TAG = LocalDataBranches.class.getSimpleName();

    private AppData db;
    private Cursor cursor;

    private ArrayList<ArrayList<String>> branch_arrayList = new ArrayList<ArrayList<String>>();
    private ArrayList<String> branch_index0 = new ArrayList<String>();
    private ArrayList<String> branch_index1 = new ArrayList<String>();
    private ArrayList<String> branch_index2 = new ArrayList<String>();
    private ArrayList<String> branch_index3 = new ArrayList<String>();
    private ArrayList<String> branch_index4 = new ArrayList<String>();
    private ArrayList<String> branch_index5 = new ArrayList<String>();
    private ArrayList<String> branch_index6 = new ArrayList<String>();

    public LocalDataBranches(Context context) {
        this.db = AppData.getInstance(context);
    }

    public ArrayList<ArrayList<String>> getMobileBranches(){
        cursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_branch WHERE sBranchCd LIKE 'C%'", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++){
                branch_index0.add(cursor.getString(cursor.getColumnIndex("sBranchCd")));
                branch_index1.add(cursor.getString(cursor.getColumnIndex("sBranchNm")));
                branch_index2.add(cursor.getString(cursor.getColumnIndex("sDescript")));
                branch_index3.add(cursor.getString(cursor.getColumnIndex("sAddressx")));
                branch_index4.add(cursor.getString(cursor.getColumnIndex("sTelNumbr")));
                branch_index5.add(cursor.getString(cursor.getColumnIndex("sContactx")));
                branch_index6.add(cursor.getString(cursor.getColumnIndex("sEmailAdd")));
                cursor.moveToNext();
            }
        }
        branch_arrayList.clear();
        branch_arrayList.add(branch_index0);
        branch_arrayList.add(branch_index1);
        branch_arrayList.add(branch_index2);
        branch_arrayList.add(branch_index3);
        branch_arrayList.add(branch_index4);
        branch_arrayList.add(branch_index5);
        branch_arrayList.add(branch_index6);
        cursor.close();
        return branch_arrayList;
    }

    public ArrayList<ArrayList<String>> getMotorBranches(){

        Cursor loCursor=db.getReadableDb().rawQuery("SELECT * FROM tbl_branch WHERE sBranchCd LIKE 'M%'", null);
        int lnRow = loCursor.getCount();

        if (lnRow <= 0){

        }else{
            loCursor.moveToFirst();
            do {
                branch_index0.add(loCursor.getString(loCursor.getColumnIndex("sBranchCd")));
                branch_index1.add(loCursor.getString(loCursor.getColumnIndex("sBranchNm")));
                branch_index2.add(loCursor.getString(loCursor.getColumnIndex("sDescript")));
                branch_index3.add(loCursor.getString(loCursor.getColumnIndex("sAddressx")));
                branch_index4.add(loCursor.getString(loCursor.getColumnIndex("sContactx")));
                branch_index5.add(loCursor.getString(loCursor.getColumnIndex("sTelNumbr")));
                branch_index6.add(loCursor.getString(loCursor.getColumnIndex("sEmailAdd")));
            } while (loCursor.moveToNext());
        }

        loCursor.close();

        branch_arrayList.clear();
        branch_arrayList.add(branch_index0);
        branch_arrayList.add(branch_index1);
        branch_arrayList.add(branch_index2);
        branch_arrayList.add(branch_index3);
        branch_arrayList.add(branch_index4);
        branch_arrayList.add(branch_index5);
        branch_arrayList.add(branch_index6);
        return  branch_arrayList;
    }

    public List<Branches> getAllBranchs(){
        List<Branches> branchesList = new ArrayList<>();
        cursor = db.getReadableDb().rawQuery("SELECT * FROM tbl_branch", null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            for(int x = 0; x < cursor.getCount(); x++){
                Branches branches = new Branches(
                        cursor.getString(cursor.getColumnIndex("sBranchNm")),
                        cursor.getString(cursor.getColumnIndex("sAddressx")),
                        cursor.getString(cursor.getColumnIndex("sDescript")),
                        cursor.getString(cursor.getColumnIndex("sBranchCd")),
                        cursor.getString(cursor.getColumnIndex("sContactx")),
                        cursor.getString(cursor.getColumnIndex("sContactx")),
                        cursor.getString(cursor.getColumnIndex("sEmailAdd")));
                branchesList.add(branches);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return branchesList;
    }
}
