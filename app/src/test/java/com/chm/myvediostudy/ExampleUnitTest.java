package com.chm.myvediostudy;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
        double init = 5;
        double increase = 0.02;
        for (int i = 0; i < 20; i++) {
            init += init * increase;
            System.out.println(init);
        }
    }
}