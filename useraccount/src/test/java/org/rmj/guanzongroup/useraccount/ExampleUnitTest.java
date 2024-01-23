package org.rmj.guanzongroup.useraccount;

import org.junit.Test;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.DClientInfo;
import org.rmj.g3appdriver.dev.Database.DataAccessObject.GGC_GuanzonAppDB;
import org.rmj.g3appdriver.dev.Database.Entities.EClientInfo;

import static org.junit.Assert.*;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private Context instance;
    private DClientInfo podao;
    private  GGC_GuanzonAppDB TestDB;

    public void setup(){
        instance= ApplicationProvider.getApplicationContext();
        TestDB = Room.inMemoryDatabaseBuilder(instance, GGC_GuanzonAppDB.class).build();

        this.podao = TestDB.EClientDao();


    }
    @Test
    public void TestGcashNo() {
        EClientInfo eClientInfo = new EClientInfo();
        eClientInfo.setUserIDxx("sUserIDxx");
        eClientInfo.setGCashNo("09993095066");

        podao.insert(eClientInfo);
        System.out.println(eClientInfo.getGCashNo());
    }
}