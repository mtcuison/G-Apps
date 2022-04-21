package org.rmj.g3appdriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DissectFullNameTest {

    String lsFrstNm;
    String lsMiddNm;

    @Test
    public void test01DissectSingleFirstName() throws Exception{
        String lsFullName = "Doe, John Mark Jayson De Vera";
        String[] ls1stSplit = lsFullName.split(",");
        String[] ls2ndSplit = ls1stSplit[1].split(" ");
        if(ls2ndSplit.length == 3){
            lsFrstNm = ls2ndSplit[1];
        }else if(ls2ndSplit.length == 5){
            lsFrstNm = ls2ndSplit[1] + " " +ls2ndSplit[2];
        }else if(ls2ndSplit.length == 6){
            lsFrstNm = ls2ndSplit[1] + " " +ls2ndSplit[2] + " " +ls2ndSplit[3];
        }
        assertEquals("John Mark Jayson", lsFrstNm);
    }

    @Test
    public void test02DissectFirstName() throws Exception{
        String fullName = "John Erich Daws Black";
        int idx = fullName.lastIndexOf(' ');
        if (idx == -1)
            throw new IllegalArgumentException("Only a single name: " + fullName);
        String firstName = fullName.substring(0, idx);
        String lastName  = fullName.substring(idx + 1);
        assertEquals("John Mark Jayson", firstName);
        assertEquals("John Mark Jayson", lastName);
    }
}
