package org.rmj.guanzongroup.guanzonapp.Adapters.List_Objects;

import android.annotation.SuppressLint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Promotions {
    private String PromoLink;
    private String PromoURL;
    private String PromoCaption;
    private String PromoDateFrm;
    private String PromoDateThr;
    private String PromoImage;

    public Promotions(String promoLink,
                      String promoCaption,
                      String promoURL,
                      String promoDateThr,
                      String promoDateFrm,
                      String promoImage){
        this.PromoLink = promoLink;
        this.PromoURL = promoURL;
        this.PromoCaption = promoCaption;
        this.PromoDateThr = promoDateThr;
        this.PromoDateFrm = promoDateFrm;
        this.PromoImage = promoImage;
    }

    public String getPromoLink() {
        return PromoLink;
    }

    public String getPromoURL() {
        return PromoURL;
    }

    public String getPromoDateFrm() {
        return PromoDateFrm;
    }

    public String getPromoCaption() {
        return PromoCaption;
    }

    public String getPromoDateThr() {
        return Date_Readable_Format(PromoDateThr);
    }

    public String getPromoImage() {
        return PromoImage;
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
}
