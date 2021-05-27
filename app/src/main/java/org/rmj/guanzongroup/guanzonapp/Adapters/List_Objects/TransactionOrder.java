package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionOrder {
    private String transno;
    private String totAmnt;
    private String Branchx;
    private String Address;
    private String dOrderx;


    public TransactionOrder(String transno,
                            String totAmnt,
                            String branchx,
                            String address,
                            String dOrderx){
        this.transno = transno;
        this.totAmnt = totAmnt;
        this.Branchx = branchx;
        this.Address = address;
        this.dOrderx = dOrderx;
    }

    public String getTransno() {
        return transno;
    }

    public String getTotAmnt() {
        return totAmnt;
    }

    public String getBranchx() {
        return Branchx;
    }

    public String getAddress() {
        return Address;
    }

    public String getdOrderx() {
        return Date_Readable_Format(dOrderx);
    }

    @SuppressLint("SimpleDateFormat")
    private String Date_Readable_Format(String dateReceive){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateReceive);
            return new SimpleDateFormat("MMMM dd, yyyy").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
