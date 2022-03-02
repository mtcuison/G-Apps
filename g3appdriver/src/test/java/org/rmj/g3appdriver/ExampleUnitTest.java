package org.rmj.g3appdriver;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test01JSonObjectVal() throws Exception {
        JSONObject loJSon = new JSONObject();
        loJSon.put("json", "sample_data");
        JSONObject detail = new JSONObject();
        detail.put("alphabet", "abc");
        detail.put("numericx", "123");
        detail.put("rvsAlpha", "zyx");
        detail.put("rvsNumrc", "987");
        JSONArray laJson = new JSONArray();
        laJson.put(detail);
        loJSon.put("detail", laJson);

        JSONArray laResult = loJSon.getJSONArray("detail");
        assertNotNull(laResult);
    }
}