package org.rmj.g3appdriver.dev.Database.DataAccessObject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import org.rmj.g3appdriver.dev.Database.Entities.EEvents;

import java.util.List;

@Dao
public interface DEvents {

    @Insert
    void insert(EEvents events);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBulkData(List<EEvents> events);

    @Update
    void update(EEvents events);

    @Query("SELECT * FROM App_Event_Info ORDER BY sTransNox ASC")
    LiveData<List<EEvents>> getAllEvents();


    @Query("SELECT * FROM App_Event_Info")
    List<EEvents> getAllEventsForDownloadImg();


    @Query("SELECT EXISTS(SELECT * FROM App_Event_Info WHERE sTransNox =:TransNox AND cNotified = '1')")
    boolean getEventExist(String TransNox);

//    @Query("SELECT * FROM App_Event_Info")
//    LiveData<List<EEvents>> getAllEvents();

    @Query("UPDATE App_Event_Info SET cNotified = '1', dModified =:date WHERE sTransNox =:transNox ")
    void updateReadEvent(String date, String transNox);


    @Query("UPDATE App_Event_Info SET sImagePath =:imgPath WHERE sTransNox =:transNox ")
    void updateEventImgPath(String imgPath, String transNox);

    @Query("SELECT COUNT(*) FROM App_Event_Info WHERE cNotified = '0'")
    LiveData<Integer> getEventCount();


//    @Query("SELECT * FROM Promo_Link_Info UNION SELECT * FROM App_Event_Info")
//    List<PromoEventsModel> getAllEventsPromo();
     class  PromoEventsModel {
        public String transNox;
        public String branchNm;
        public String dateFrom;
        public String dateThru;
        public String title;
        public String Address;
        public String url;
        public String imgUrl;
        public String notified;
        public String modified;
        public String imgByte;
        public String division;
        public String directoryFolder;
        public String imgPath;
        }
}
