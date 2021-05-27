package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transactions {
    private String DateTime;
    private String Pointsxx;
    private String ReferNox;
    private String Transact;

    public Transactions(String dateTime,
                     String pointsxx,
                     String referNox,
                     String transact){
        this.DateTime = dateTime;
        this.Pointsxx = pointsxx;
        this.ReferNox = referNox;
        this.Transact = transact;
    }

    public String getDateTime() { return Date_Readable_Format(DateTime); }

    public String getPointsxx() { return "+"+Pointsxx; }

    public String getReferNox() { return ReferNox; }

    public String getTransact() { return Transact; }

    @SuppressLint("SimpleDateFormat")
    private String Date_Readable_Format(String dateReceive){
        try {
            Date date = new SimpleDateFormat("yyyy-mm-dd").parse(dateReceive);
            return new SimpleDateFormat("MMMM dd, yyyy").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
