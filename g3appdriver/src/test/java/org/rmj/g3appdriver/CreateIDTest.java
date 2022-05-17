package org.rmj.g3appdriver;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateIDTest {

    @Test
    public void test01CreateUniqueIDTest() throws Exception{
        String lsUserID = "GAP0190554";
        String lsValxxx = "12345";

        String lsUserxx = lsUserID.substring(0, 3);
        StringBuilder loBuilder = new StringBuilder(lsUserxx);
        loBuilder.append("000");
        loBuilder.append(lsValxxx);
        assertEquals("GAP00012345", loBuilder.toString());
    }

    @Test
    public void test02CreateIDForList() throws Exception {
        String lsUserID = "GAP0190554";
        String lsPrefxx = "00000000";
        int lsLimitxx = 135;
        List<String> lsIDxxxx = new ArrayList<>();
        for(int x = 0; x < lsLimitxx; x++){
            String lsUserxx = lsUserID.substring(0, 3);
            StringBuilder loBuilder = new StringBuilder(lsUserxx);
            loBuilder.append(lsPrefxx);
//            loBuilder.replace();
        }
        assertEquals(135, lsIDxxxx.size());
    }
}
