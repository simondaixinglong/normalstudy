package com.simon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void getHtmlStr(){

//        String str = "rate=30%!40%";

//        StringEscapeUtils.unescapeHtml4（str）
//        StringEscapeUtils.unescapeHtml4(str);

//        Log.d("tag", StringEscapeUtils.unescapeHtml4(str));

        byte a;
        int b = 298;
        a = (byte) b;

        System.out.println(a);
        System.out.println(b);

    }

}