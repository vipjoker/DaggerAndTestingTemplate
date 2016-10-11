package com.example.mydagger;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

interface a {
    void print();
}

interface B {
    int print();

    class User implements B {
        private String name;

        @Override
        public int print() {
            System.out.println("USER print");
            return 0;
        }


    }

    enum COLOR{

        INSTANCE;
            public void print() {
                System.out.println("Hello world");
            }

            public void goodBye() {
                System.out.println("good");
            }

        }

}

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public  class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testString() throws Exception {
        Map<Date,String > map = new HashMap<>();
        Date date = new Date();
        map.put(date, "Hello");
        System.out.println(map.get(date));
        date.setTime(0);
        System.out.println(map.get(date));


    }

}