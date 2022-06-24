package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import org.rmj.g3appdriver.dev.Database.Entities.EPromo;

import java.util.List;

@Dao
public interface DPromo {

    @Insert
    void insert(EPromo ePromo);

    @Query("SELECT * FROM Promo_Link_Info")
    LiveData<List<EPromo>> getAllPromo();

    @Query("SELECT * FROM Promo_Link_Info")
    List<EPromo> getAllPromoForDownloadImg();

    @Query("UPDATE App_Event_Info SET cNotified = '1', dModified =:date WHERE sTransNox =:transNox ")
    void updateReadPromo(String date, String transNox);

    @Query("SELECT COUNT(*) FROM Promo_Link_Info WHERE cNotified = '0'")
    LiveData<Integer> getPromoCount();

    @Query("SELECT EXISTS(SELECT * FROM Promo_Link_Info WHERE sTransNox =:TransNox AND cNotified = '1')")
    boolean getPromoExist(String TransNox);

    @Query("UPDATE Promo_Link_Info SET sImagePath =:imgPath WHERE sTransNox =:transNox ")
    void updatePromoImgPath(String imgPath, String transNox);

    @Query("SELECT * FROM PROMO_LINK_INFO WHERE sTransNox =:TransNox")
    EPromo getPromoInfoIfExist(String TransNox);

    @Query("SELECT * FROM Promo_Link_Info ORDER BY dDateFrom DESC LIMIT 1")
    EPromo CheckPromo();

    @Query("UPDATE PROMO_LINK_INFO SET dTransact=:Transact, " +
            "dDateFrom=:DateFrom, " +
            "dDateThru=:DateThru, " +
            "sCaptionx=:Captionx, " +
            "sImageUrl=:ImageUrl, " +
            "sImgeByte=:ImgeByte, " +
            "sPromoUrl=:PromoUrl, " +
            "cNotified=:Notified, " +
            "cDivision=:Division  " +
            "WHERE sTransNox=:TransNox")
    void UpdatePromoInfo(String Transact,
                         String DateFrom,
                         String DateThru,
                         String Captionx,
                         String ImageUrl,
                         String ImgeByte,
                         String PromoUrl,
                         String Notified,
                         String Division,
                         String TransNox);
}
