package com.lingjiancong.resource;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * @author lingjiancong
 */
public class TestProperties {

    @Test
    public void testProperties() throws IOException {
        // properties cannot load inputStream twice
        Properties properties = new Properties();
        InputStream fis = this.getClass().getClassLoader().getResourceAsStream("log4j.properties");

        // solution: open again
        InputStream another = this.getClass().getClassLoader().getResourceAsStream("log4j.properties");
        Properties p2 = new Properties();
        p2.load(another);
        properties.load(fis);

    }

    @Test
    public void testNull() {
        String s = null;
        Object o = s;
        String sN = (String) o;
        System.out.println(sN);
    }

    @Test
    public void testListNull() {
        List<Integer> lists = null;
        for (Integer i : lists) {
            System.out.println(i);
        }
    }

}
