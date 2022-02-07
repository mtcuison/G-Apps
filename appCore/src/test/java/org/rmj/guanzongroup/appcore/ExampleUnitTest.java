package org.rmj.guanzongroup.appcore;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private boolean hasDecimal;
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testDoubleDecimalValue(){
        double d = 13;
        if(d % 1 == 0){
            hasDecimal = true;
        } else {
            hasDecimal = false;
        }
        assertTrue(hasDecimal);
    }
}