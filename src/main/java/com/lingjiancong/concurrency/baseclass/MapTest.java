package com.lingjiancong.concurrency.baseclass;

import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lingjiancong
 * @since 2018-06-12
 */
public class MapTest {

    @Test
    public void concurrentMapTest() {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>(8);

        map.put("a", 1);
        map.get("a");
        for (int i = 0; i < 12; ++i) {
            if (i == 10) {
                System.out.println("resize");
            }
            map.put("a" + i, i);
        }

        int max = 1 << 30;
        System.out.println(max);

        max = -16 >> 2;
        System.out.println(max);

        max = -16 >>> 2;
        System.out.println(max);

        int n = 1;
        n |= 2;
        System.out.println(n);
    }

    @Test
    public void typeTest() {
        Collection<String> collection = new ArrayList<>();
        Type[] types = collection.getClass().getGenericInterfaces();
        Type t = types[0];
        Comparable<String> comparable;
    }
}
