package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class All_Transactions {
    private String ReferNox;
    private String TranType;
    private String Pointsxx;
    private String DateTime;

    public All_Transactions(String referNox,
                            String tranType,
                            String pointsxx,
                            String dateTime){
        this.ReferNox = referNox;
        this.TranType = tranType;
        this.Pointsxx = pointsxx;
        this.DateTime = dateTime;
    }

    public String getReferNox() {
        return ReferNox;
    }

    public String getTranType() {
        return TranType;
    }

    public String getPointsxx() {
        return parsePoints();
    }

    public String getDateTime() {
        return Date_Readable_Format(DateTime);
    }

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

    private String parsePoints(){
        switch (TranType){
            case "ONLINE":
            case "OFFLINE":
                return "+ " + Pointsxx;
            case "REDEMPTION":
            case "PREORDER":
                return "- " + Pointsxx;
        }
        return "";
    }
}
